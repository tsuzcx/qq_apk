package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.f.a;
import com.tencent.mm.vfs.o;

public class CdnImageView
  extends MMImageView
  implements a
{
  private String FnY;
  private String FnZ;
  private boolean Foa;
  private boolean Fob;
  private com.tencent.e.i.d Foc;
  private aq handler;
  private int targetHeight;
  private int targetWidth;
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
    this.Fob = false;
    this.handler = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(152164);
        Object localObject = bu.bI(paramAnonymousMessage.getData().getString("k_url"), "");
        CdnImageView.a(CdnImageView.this, bu.bI(CdnImageView.a(CdnImageView.this), ""));
        if ((bu.isNullOrNil(CdnImageView.a(CdnImageView.this))) && (bu.isNullOrNil((String)localObject)))
        {
          CdnImageView.this.setImageBitmap(null);
          CdnImageView.this.setImageBitmapCompleted(null);
          AppMethodBeat.o(152164);
          return;
        }
        if (!CdnImageView.a(CdnImageView.this).equals(localObject))
        {
          ae.d("MicroMsg.CdnImageView", "hy: url not equal. abort this msg");
          AppMethodBeat.o(152164);
          return;
        }
        paramAnonymousMessage = paramAnonymousMessage.getData().getByteArray("k_data");
        if ((paramAnonymousMessage == null) || (paramAnonymousMessage.length == 0))
        {
          ae.e("MicroMsg.CdnImageView", "handleMsg fail, data is null");
          AppMethodBeat.o(152164);
          return;
        }
        localObject = com.tencent.mm.sdk.platformtools.h.cu(paramAnonymousMessage);
        q.aIW();
        com.tencent.mm.av.d.g(CdnImageView.a(CdnImageView.this), (Bitmap)localObject);
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
              paramAnonymousMessage = com.tencent.mm.sdk.platformtools.h.a((Bitmap)localObject, CdnImageView.d(CdnImageView.this), CdnImageView.c(CdnImageView.this), true, false);
            }
          }
        }
        localObject = paramAnonymousMessage;
        if (CdnImageView.e(CdnImageView.this))
        {
          localObject = paramAnonymousMessage;
          if (paramAnonymousMessage != null) {
            localObject = com.tencent.mm.sdk.platformtools.h.a(paramAnonymousMessage, false, paramAnonymousMessage.getWidth() * 0.5F);
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
    this.targetWidth = paramInt1;
    this.targetHeight = paramInt2;
    this.FnY = paramString2;
    if (!bu.isNullOrNil(this.FnY))
    {
      paramString2 = com.tencent.mm.sdk.platformtools.h.aRC(this.FnY);
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
      gl(paramString1, paramInt3);
      AppMethodBeat.o(152172);
      return;
    }
    aOk(paramString1);
    AppMethodBeat.o(152172);
  }
  
  private void aOk(String paramString)
  {
    AppMethodBeat.i(152174);
    if (!o.fB(paramString))
    {
      setVisibility(8);
      AppMethodBeat.o(152174);
      return;
    }
    if ((this.targetWidth <= 0) || (this.targetHeight <= 0)) {}
    for (paramString = com.tencent.mm.sdk.platformtools.h.aRC(paramString); paramString == null; paramString = com.tencent.mm.sdk.platformtools.h.d(paramString, this.targetWidth, this.targetHeight, true))
    {
      setVisibility(8);
      AppMethodBeat.o(152174);
      return;
    }
    Object localObject = paramString;
    if (this.Foa)
    {
      localObject = paramString;
      if (paramString != null) {
        localObject = com.tencent.mm.sdk.platformtools.h.a(paramString, false, paramString.getWidth() * 0.5F);
      }
    }
    setImageBitmap((Bitmap)localObject);
    setImageBitmapCompleted((Bitmap)localObject);
    AppMethodBeat.o(152174);
  }
  
  private boolean fgl()
  {
    AppMethodBeat.i(152175);
    try
    {
      Object localObject1 = getCacheFilePath();
      ae.d("MicroMsg.CdnImageView", "useSdcardCache, path: %s", new Object[] { localObject1 });
      if (o.fB((String)localObject1))
      {
        Object localObject2 = com.tencent.mm.sdk.platformtools.h.aRC((String)localObject1);
        ae.d("MicroMsg.CdnImageView", "get bitmap from cache path: %s", new Object[] { localObject2 });
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (this.targetWidth > 0)
          {
            localObject1 = localObject2;
            if (this.targetHeight > 0) {
              localObject1 = com.tencent.mm.sdk.platformtools.h.a((Bitmap)localObject2, this.targetHeight, this.targetWidth, true, false);
            }
          }
          localObject2 = localObject1;
          if (this.Foa)
          {
            localObject2 = localObject1;
            if (localObject1 != null) {
              localObject2 = com.tencent.mm.sdk.platformtools.h.a((Bitmap)localObject1, false, ((Bitmap)localObject1).getWidth() * 0.5F);
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
      ae.printErrStackTrace("MicroMsg.CdnImageView", localException, "setBitmapFromLocalCache error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(152175);
    }
    return false;
  }
  
  private String getAccImagesPath()
  {
    AppMethodBeat.i(152177);
    String str = b.asj() + "wallet_images/";
    AppMethodBeat.o(152177);
    return str;
  }
  
  private String getCacheFilePath()
  {
    AppMethodBeat.i(152173);
    String str;
    if (!bu.isNullOrNil(this.FnY)) {
      str = this.FnY;
    }
    for (;;)
    {
      AppMethodBeat.o(152173);
      return str;
      if (!bu.isNullOrNil(this.FnZ))
      {
        str = this.FnZ + g.getMessageDigest(this.url.getBytes());
      }
      else
      {
        o.aZI(getAccImagesPath());
        str = getAccImagesPath() + g.getMessageDigest(this.url.getBytes());
      }
    }
  }
  
  private void gl(String paramString, int paramInt)
  {
    AppMethodBeat.i(152176);
    q.aIW();
    Object localObject = com.tencent.mm.av.d.wA(paramString);
    if (localObject != null)
    {
      paramString = (String)localObject;
      if (this.targetWidth > 0)
      {
        paramString = (String)localObject;
        if (this.targetHeight > 0) {
          paramString = com.tencent.mm.sdk.platformtools.h.a((Bitmap)localObject, this.targetWidth, this.targetHeight, true, false);
        }
      }
      localObject = paramString;
      if (this.Foa)
      {
        localObject = paramString;
        if (paramString != null) {
          localObject = com.tencent.mm.sdk.platformtools.h.a(paramString, false, paramString.getWidth() * 0.5F);
        }
      }
      setImageBitmap((Bitmap)localObject);
      setImageBitmapCompleted((Bitmap)localObject);
      AppMethodBeat.o(152176);
      return;
    }
    if ((this.Fob) && (fgl()))
    {
      AppMethodBeat.o(152176);
      return;
    }
    if (paramInt > 0) {
      setImageResource(paramInt);
    }
    for (;;)
    {
      this.Foc = com.tencent.e.h.MqF.aP(new CdnImageView.a(paramString, this.handler));
      AppMethodBeat.o(152176);
      return;
      setImageBitmap(null);
    }
  }
  
  public final void aK(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152169);
    r(paramString, paramInt1, paramInt2, -1);
    AppMethodBeat.o(152169);
  }
  
  public final void gk(String paramString, int paramInt)
  {
    AppMethodBeat.i(152168);
    r(paramString, 0, 0, paramInt);
    AppMethodBeat.o(152168);
  }
  
  public final void lD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(152170);
    a(paramString1, -1, 0, 0, paramString2);
    AppMethodBeat.o(152170);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(218902);
    super.onDetachedFromWindow();
    if (this.Foc != null) {
      this.Foc.cancel(false);
    }
    AppMethodBeat.o(218902);
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
    this.FnZ = paramString;
  }
  
  public void setImgSavedPath(String paramString)
  {
    this.FnY = paramString;
  }
  
  public void setRoundCorner(boolean paramBoolean)
  {
    this.Foa = paramBoolean;
  }
  
  public void setUrl(String paramString)
  {
    AppMethodBeat.i(152167);
    r(paramString, 0, 0, -1);
    AppMethodBeat.o(152167);
  }
  
  public void setUseSdcardCache(boolean paramBoolean)
  {
    this.Fob = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.CdnImageView
 * JD-Core Version:    0.7.0.1
 */