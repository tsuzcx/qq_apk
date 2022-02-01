package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import com.tencent.e.h;
import com.tencent.e.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.c;
import com.tencent.mm.aw.o;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.f.a;

public class CdnImageView
  extends MMImageView
  implements a
{
  private String BYj;
  private String BYk;
  private boolean BYl;
  private boolean BYm;
  private d BYn;
  private int gnh;
  private int gni;
  private ap handler;
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
    this.BYm = false;
    this.handler = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(152164);
        Object localObject = bt.by(paramAnonymousMessage.getData().getString("k_url"), "");
        CdnImageView.a(CdnImageView.this, bt.by(CdnImageView.a(CdnImageView.this), ""));
        if ((bt.isNullOrNil(CdnImageView.a(CdnImageView.this))) && (bt.isNullOrNil((String)localObject)))
        {
          CdnImageView.this.setImageBitmap(null);
          CdnImageView.this.setImageBitmapCompleted(null);
          AppMethodBeat.o(152164);
          return;
        }
        if (!CdnImageView.a(CdnImageView.this).equals(localObject))
        {
          ad.d("MicroMsg.CdnImageView", "hy: url not equal. abort this msg");
          AppMethodBeat.o(152164);
          return;
        }
        paramAnonymousMessage = paramAnonymousMessage.getData().getByteArray("k_data");
        if ((paramAnonymousMessage == null) || (paramAnonymousMessage.length == 0))
        {
          ad.e("MicroMsg.CdnImageView", "handleMsg fail, data is null");
          AppMethodBeat.o(152164);
          return;
        }
        localObject = f.cl(paramAnonymousMessage);
        o.ayE();
        c.h(CdnImageView.a(CdnImageView.this), (Bitmap)localObject);
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
    this.gnh = paramInt1;
    this.gni = paramInt2;
    this.BYj = paramString2;
    if (!bt.isNullOrNil(this.BYj))
    {
      paramString2 = f.aFi(this.BYj);
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
      fA(paramString1, paramInt3);
      AppMethodBeat.o(152172);
      return;
    }
    aBT(paramString1);
    AppMethodBeat.o(152172);
  }
  
  private void aBT(String paramString)
  {
    AppMethodBeat.i(152174);
    if (!com.tencent.mm.vfs.i.eK(paramString))
    {
      setVisibility(8);
      AppMethodBeat.o(152174);
      return;
    }
    if ((this.gnh <= 0) || (this.gni <= 0)) {}
    for (paramString = f.aFi(paramString); paramString == null; paramString = f.e(paramString, this.gnh, this.gni, true))
    {
      setVisibility(8);
      AppMethodBeat.o(152174);
      return;
    }
    Object localObject = paramString;
    if (this.BYl)
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
  
  private boolean eye()
  {
    AppMethodBeat.i(152175);
    try
    {
      Object localObject1 = getCacheFilePath();
      ad.d("MicroMsg.CdnImageView", "useSdcardCache, path: %s", new Object[] { localObject1 });
      if (com.tencent.mm.vfs.i.eK((String)localObject1))
      {
        Object localObject2 = f.aFi((String)localObject1);
        ad.d("MicroMsg.CdnImageView", "get bitmap from cache path: %s", new Object[] { localObject2 });
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (this.gnh > 0)
          {
            localObject1 = localObject2;
            if (this.gni > 0) {
              localObject1 = f.a((Bitmap)localObject2, this.gni, this.gnh, true, false);
            }
          }
          localObject2 = localObject1;
          if (this.BYl)
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
      ad.printErrStackTrace("MicroMsg.CdnImageView", localException, "setBitmapFromLocalCache error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(152175);
    }
    return false;
  }
  
  private void fA(String paramString, int paramInt)
  {
    AppMethodBeat.i(152176);
    o.ayE();
    Object localObject = c.pT(paramString);
    if (localObject != null)
    {
      paramString = (String)localObject;
      if (this.gnh > 0)
      {
        paramString = (String)localObject;
        if (this.gni > 0) {
          paramString = f.a((Bitmap)localObject, this.gnh, this.gni, true, false);
        }
      }
      localObject = paramString;
      if (this.BYl)
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
    if ((this.BYm) && (eye()))
    {
      AppMethodBeat.o(152176);
      return;
    }
    if (paramInt > 0) {
      setImageResource(paramInt);
    }
    for (;;)
    {
      this.BYn = h.Iye.aQ(new CdnImageView.a(paramString, this.handler));
      AppMethodBeat.o(152176);
      return;
      setImageBitmap(null);
    }
  }
  
  private String getAccImagesPath()
  {
    AppMethodBeat.i(152177);
    String str = b.aih() + "wallet_images/";
    AppMethodBeat.o(152177);
    return str;
  }
  
  private String getCacheFilePath()
  {
    AppMethodBeat.i(152173);
    String str;
    if (!bt.isNullOrNil(this.BYj)) {
      str = this.BYj;
    }
    for (;;)
    {
      AppMethodBeat.o(152173);
      return str;
      if (!bt.isNullOrNil(this.BYk))
      {
        str = this.BYk + g.getMessageDigest(this.url.getBytes());
      }
      else
      {
        com.tencent.mm.vfs.i.aMF(getAccImagesPath());
        str = getAccImagesPath() + g.getMessageDigest(this.url.getBytes());
      }
    }
  }
  
  public final void aB(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152169);
    r(paramString, paramInt1, paramInt2, -1);
    AppMethodBeat.o(152169);
  }
  
  public final void fz(String paramString, int paramInt)
  {
    AppMethodBeat.i(152168);
    r(paramString, 0, 0, paramInt);
    AppMethodBeat.o(152168);
  }
  
  public final void kC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(152170);
    a(paramString1, -1, 0, 0, paramString2);
    AppMethodBeat.o(152170);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(190790);
    super.onDetachedFromWindow();
    if (this.BYn != null) {
      this.BYn.cancel(false);
    }
    AppMethodBeat.o(190790);
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
    this.BYk = paramString;
  }
  
  public void setImgSavedPath(String paramString)
  {
    this.BYj = paramString;
  }
  
  public void setRoundCorner(boolean paramBoolean)
  {
    this.BYl = paramBoolean;
  }
  
  public void setUrl(String paramString)
  {
    AppMethodBeat.i(152167);
    r(paramString, 0, 0, -1);
    AppMethodBeat.o(152167);
  }
  
  public void setUseSdcardCache(boolean paramBoolean)
  {
    this.BYm = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.CdnImageView
 * JD-Core Version:    0.7.0.1
 */