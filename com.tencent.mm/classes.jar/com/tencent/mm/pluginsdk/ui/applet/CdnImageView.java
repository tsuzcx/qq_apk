package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import com.tencent.e.h;
import com.tencent.e.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.c;
import com.tencent.mm.av.o;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.f.a;

public class CdnImageView
  extends MMImageView
  implements a
{
  private String DqA;
  private String DqB;
  private boolean DqC;
  private boolean DqD;
  private d DqE;
  private int gNU;
  private int gNV;
  private ao handler;
  private String url;
  
  public CdnImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CdnImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CdnImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(152166);
    this.url = null;
    this.DqD = false;
    this.handler = new ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(152164);
        Object localObject = bs.bG(paramAnonymousMessage.getData().getString("k_url"), "");
        CdnImageView.a(CdnImageView.this, bs.bG(CdnImageView.a(CdnImageView.this), ""));
        if ((bs.isNullOrNil(CdnImageView.a(CdnImageView.this))) && (bs.isNullOrNil((String)localObject)))
        {
          CdnImageView.this.setImageBitmap(null);
          CdnImageView.this.setImageBitmapCompleted(null);
          AppMethodBeat.o(152164);
          return;
        }
        if (!CdnImageView.a(CdnImageView.this).equals(localObject))
        {
          ac.d("MicroMsg.CdnImageView", "hy: url not equal. abort this msg");
          AppMethodBeat.o(152164);
          return;
        }
        paramAnonymousMessage = paramAnonymousMessage.getData().getByteArray("k_data");
        if ((paramAnonymousMessage == null) || (paramAnonymousMessage.length == 0))
        {
          ac.e("MicroMsg.CdnImageView", "handleMsg fail, data is null");
          AppMethodBeat.o(152164);
          return;
        }
        localObject = f.ck(paramAnonymousMessage);
        o.aFw();
        c.g(CdnImageView.a(CdnImageView.this), (Bitmap)localObject);
        if (CdnImageView.b(CdnImageView.this)) {
          CdnImageView.a(CdnImageView.this, (Bitmap)localObject);
        }
        paramAnonymousMessage = (Message)localObject;
        if (localObject != null)
        {
          paramAnonymousMessage = (Message)localObject;
          if (CdnImageView.c(CdnImageView.this) > 0)
          {
            paramAnonymousMessage = (Message)localObject;
            if (CdnImageView.d(CdnImageView.this) > 0) {
              paramAnonymousMessage = f.a((Bitmap)localObject, CdnImageView.d(CdnImageView.this), CdnImageView.c(CdnImageView.this), true, false);
            }
          }
        }
        localObject = paramAnonymousMessage;
        if (CdnImageView.e(CdnImageView.this))
        {
          localObject = paramAnonymousMessage;
          if (paramAnonymousMessage != null) {
            localObject = f.a(paramAnonymousMessage, false, paramAnonymousMessage.getWidth() * 0.5F);
          }
        }
        if (localObject != null) {
          CdnImageView.this.setImageBitmap((Bitmap)localObject);
        }
        CdnImageView.this.setImageBitmapCompleted((Bitmap)localObject);
        AppMethodBeat.o(152164);
      }
    };
    AppMethodBeat.o(152166);
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(152172);
    this.url = paramString1;
    this.gNU = paramInt1;
    this.gNV = paramInt2;
    this.DqA = paramString2;
    if (!bs.isNullOrNil(this.DqA))
    {
      paramString2 = f.aKz(this.DqA);
      if ((paramString2 != null) && (paramString2.getWidth() > 0) && (paramString2.getHeight() > 0))
      {
        setImageBitmap(paramString2);
        setImageBitmapCompleted(paramString2);
        AppMethodBeat.o(152172);
        return;
      }
    }
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      setVisibility(8);
      AppMethodBeat.o(152172);
      return;
    }
    if (paramString1.startsWith("http"))
    {
      fF(paramString1, paramInt3);
      AppMethodBeat.o(152172);
      return;
    }
    aHl(paramString1);
    AppMethodBeat.o(152172);
  }
  
  private void aHl(String paramString)
  {
    AppMethodBeat.i(152174);
    if (!com.tencent.mm.vfs.i.eA(paramString))
    {
      setVisibility(8);
      AppMethodBeat.o(152174);
      return;
    }
    if ((this.gNU <= 0) || (this.gNV <= 0)) {}
    for (paramString = f.aKz(paramString); paramString == null; paramString = f.e(paramString, this.gNU, this.gNV, true))
    {
      setVisibility(8);
      AppMethodBeat.o(152174);
      return;
    }
    Object localObject = paramString;
    if (this.DqC)
    {
      localObject = paramString;
      if (paramString != null) {
        localObject = f.a(paramString, false, paramString.getWidth() * 0.5F);
      }
    }
    setImageBitmap((Bitmap)localObject);
    setImageBitmapCompleted((Bitmap)localObject);
    AppMethodBeat.o(152174);
  }
  
  private boolean eNy()
  {
    AppMethodBeat.i(152175);
    try
    {
      Object localObject1 = getCacheFilePath();
      ac.d("MicroMsg.CdnImageView", "useSdcardCache, path: %s", new Object[] { localObject1 });
      if (com.tencent.mm.vfs.i.eA((String)localObject1))
      {
        Object localObject2 = f.aKz((String)localObject1);
        ac.d("MicroMsg.CdnImageView", "get bitmap from cache path: %s", new Object[] { localObject2 });
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (this.gNU > 0)
          {
            localObject1 = localObject2;
            if (this.gNV > 0) {
              localObject1 = f.a((Bitmap)localObject2, this.gNV, this.gNU, true, false);
            }
          }
          localObject2 = localObject1;
          if (this.DqC)
          {
            localObject2 = localObject1;
            if (localObject1 != null) {
              localObject2 = f.a((Bitmap)localObject1, false, ((Bitmap)localObject1).getWidth() * 0.5F);
            }
          }
          setImageBitmap((Bitmap)localObject2);
          setImageBitmapCompleted((Bitmap)localObject2);
          AppMethodBeat.o(152175);
          return true;
        }
      }
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.CdnImageView", localException, "setBitmapFromLocalCache error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(152175);
    }
    return false;
  }
  
  private void fF(String paramString, int paramInt)
  {
    AppMethodBeat.i(152176);
    o.aFw();
    Object localObject = c.te(paramString);
    if (localObject != null)
    {
      paramString = (String)localObject;
      if (this.gNU > 0)
      {
        paramString = (String)localObject;
        if (this.gNV > 0) {
          paramString = f.a((Bitmap)localObject, this.gNU, this.gNV, true, false);
        }
      }
      localObject = paramString;
      if (this.DqC)
      {
        localObject = paramString;
        if (paramString != null) {
          localObject = f.a(paramString, false, paramString.getWidth() * 0.5F);
        }
      }
      setImageBitmap((Bitmap)localObject);
      setImageBitmapCompleted((Bitmap)localObject);
      AppMethodBeat.o(152176);
      return;
    }
    if ((this.DqD) && (eNy()))
    {
      AppMethodBeat.o(152176);
      return;
    }
    if (paramInt > 0) {
      setImageResource(paramInt);
    }
    for (;;)
    {
      this.DqE = h.JZN.aT(new CdnImageView.a(paramString, this.handler));
      AppMethodBeat.o(152176);
      return;
      setImageBitmap(null);
    }
  }
  
  private String getAccImagesPath()
  {
    AppMethodBeat.i(152177);
    String str = b.aph() + "wallet_images/";
    AppMethodBeat.o(152177);
    return str;
  }
  
  private String getCacheFilePath()
  {
    AppMethodBeat.i(152173);
    String str;
    if (!bs.isNullOrNil(this.DqA)) {
      str = this.DqA;
    }
    for (;;)
    {
      AppMethodBeat.o(152173);
      return str;
      if (!bs.isNullOrNil(this.DqB))
      {
        str = this.DqB + g.getMessageDigest(this.url.getBytes());
      }
      else
      {
        com.tencent.mm.vfs.i.aSh(getAccImagesPath());
        str = getAccImagesPath() + g.getMessageDigest(this.url.getBytes());
      }
    }
  }
  
  public final void aE(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152169);
    r(paramString, paramInt1, paramInt2, -1);
    AppMethodBeat.o(152169);
  }
  
  public final void fE(String paramString, int paramInt)
  {
    AppMethodBeat.i(152168);
    r(paramString, 0, 0, paramInt);
    AppMethodBeat.o(152168);
  }
  
  public final void kZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(152170);
    a(paramString1, -1, 0, 0, paramString2);
    AppMethodBeat.o(152170);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(192694);
    super.onDetachedFromWindow();
    if (this.DqE != null) {
      this.DqE.cancel(false);
    }
    AppMethodBeat.o(192694);
  }
  
  public final void r(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(152171);
    a(paramString, paramInt1, paramInt2, paramInt3, null);
    AppMethodBeat.o(152171);
  }
  
  public void setImageBitmapCompleted(Bitmap paramBitmap) {}
  
  public void setImgSavedDir(String paramString)
  {
    this.DqB = paramString;
  }
  
  public void setImgSavedPath(String paramString)
  {
    this.DqA = paramString;
  }
  
  public void setRoundCorner(boolean paramBoolean)
  {
    this.DqC = paramBoolean;
  }
  
  public void setUrl(String paramString)
  {
    AppMethodBeat.i(152167);
    r(paramString, 0, 0, -1);
    AppMethodBeat.o(152167);
  }
  
  public void setUseSdcardCache(boolean paramBoolean)
  {
    this.DqD = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.CdnImageView
 * JD-Core Version:    0.7.0.1
 */