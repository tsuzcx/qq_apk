package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.q;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.f.a;

public class CdnImageView
  extends MMImageView
  implements a
{
  private String EVD;
  private String EVE;
  private boolean EVF;
  private boolean EVG;
  private com.tencent.e.i.d EVH;
  private ap handler;
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
    this.EVG = false;
    this.handler = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(152164);
        Object localObject = bt.bI(paramAnonymousMessage.getData().getString("k_url"), "");
        CdnImageView.a(CdnImageView.this, bt.bI(CdnImageView.a(CdnImageView.this), ""));
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
        localObject = com.tencent.mm.sdk.platformtools.g.cr(paramAnonymousMessage);
        q.aIE();
        com.tencent.mm.aw.d.g(CdnImageView.a(CdnImageView.this), (Bitmap)localObject);
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
              paramAnonymousMessage = com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject, CdnImageView.d(CdnImageView.this), CdnImageView.c(CdnImageView.this), true, false);
            }
          }
        }
        localObject = paramAnonymousMessage;
        if (CdnImageView.e(CdnImageView.this))
        {
          localObject = paramAnonymousMessage;
          if (paramAnonymousMessage != null) {
            localObject = com.tencent.mm.sdk.platformtools.g.a(paramAnonymousMessage, false, paramAnonymousMessage.getWidth() * 0.5F);
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
    this.EVD = paramString2;
    if (!bt.isNullOrNil(this.EVD))
    {
      paramString2 = com.tencent.mm.sdk.platformtools.g.aQf(this.EVD);
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
      gc(paramString1, paramInt3);
      AppMethodBeat.o(152172);
      return;
    }
    aMO(paramString1);
    AppMethodBeat.o(152172);
  }
  
  private void aMO(String paramString)
  {
    AppMethodBeat.i(152174);
    if (!com.tencent.mm.vfs.i.fv(paramString))
    {
      setVisibility(8);
      AppMethodBeat.o(152174);
      return;
    }
    if ((this.targetWidth <= 0) || (this.targetHeight <= 0)) {}
    for (paramString = com.tencent.mm.sdk.platformtools.g.aQf(paramString); paramString == null; paramString = com.tencent.mm.sdk.platformtools.g.d(paramString, this.targetWidth, this.targetHeight, true))
    {
      setVisibility(8);
      AppMethodBeat.o(152174);
      return;
    }
    Object localObject = paramString;
    if (this.EVF)
    {
      localObject = paramString;
      if (paramString != null) {
        localObject = com.tencent.mm.sdk.platformtools.g.a(paramString, false, paramString.getWidth() * 0.5F);
      }
    }
    setImageBitmap((Bitmap)localObject);
    setImageBitmapCompleted((Bitmap)localObject);
    AppMethodBeat.o(152174);
  }
  
  private boolean fcx()
  {
    AppMethodBeat.i(152175);
    try
    {
      Object localObject1 = getCacheFilePath();
      ad.d("MicroMsg.CdnImageView", "useSdcardCache, path: %s", new Object[] { localObject1 });
      if (com.tencent.mm.vfs.i.fv((String)localObject1))
      {
        Object localObject2 = com.tencent.mm.sdk.platformtools.g.aQf((String)localObject1);
        ad.d("MicroMsg.CdnImageView", "get bitmap from cache path: %s", new Object[] { localObject2 });
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (this.targetWidth > 0)
          {
            localObject1 = localObject2;
            if (this.targetHeight > 0) {
              localObject1 = com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject2, this.targetHeight, this.targetWidth, true, false);
            }
          }
          localObject2 = localObject1;
          if (this.EVF)
          {
            localObject2 = localObject1;
            if (localObject1 != null) {
              localObject2 = com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject1, false, ((Bitmap)localObject1).getWidth() * 0.5F);
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
  
  private void gc(String paramString, int paramInt)
  {
    AppMethodBeat.i(152176);
    q.aIE();
    Object localObject = com.tencent.mm.aw.d.vT(paramString);
    if (localObject != null)
    {
      paramString = (String)localObject;
      if (this.targetWidth > 0)
      {
        paramString = (String)localObject;
        if (this.targetHeight > 0) {
          paramString = com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject, this.targetWidth, this.targetHeight, true, false);
        }
      }
      localObject = paramString;
      if (this.EVF)
      {
        localObject = paramString;
        if (paramString != null) {
          localObject = com.tencent.mm.sdk.platformtools.g.a(paramString, false, paramString.getWidth() * 0.5F);
        }
      }
      setImageBitmap((Bitmap)localObject);
      setImageBitmapCompleted((Bitmap)localObject);
      AppMethodBeat.o(152176);
      return;
    }
    if ((this.EVG) && (fcx()))
    {
      AppMethodBeat.o(152176);
      return;
    }
    if (paramInt > 0) {
      setImageResource(paramInt);
    }
    for (;;)
    {
      this.EVH = h.LTJ.aS(new CdnImageView.a(paramString, this.handler));
      AppMethodBeat.o(152176);
      return;
      setImageBitmap(null);
    }
  }
  
  private String getAccImagesPath()
  {
    AppMethodBeat.i(152177);
    String str = b.arU() + "wallet_images/";
    AppMethodBeat.o(152177);
    return str;
  }
  
  private String getCacheFilePath()
  {
    AppMethodBeat.i(152173);
    String str;
    if (!bt.isNullOrNil(this.EVD)) {
      str = this.EVD;
    }
    for (;;)
    {
      AppMethodBeat.o(152173);
      return str;
      if (!bt.isNullOrNil(this.EVE))
      {
        str = this.EVE + com.tencent.mm.b.g.getMessageDigest(this.url.getBytes());
      }
      else
      {
        com.tencent.mm.vfs.i.aYg(getAccImagesPath());
        str = getAccImagesPath() + com.tencent.mm.b.g.getMessageDigest(this.url.getBytes());
      }
    }
  }
  
  public final void aI(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152169);
    r(paramString, paramInt1, paramInt2, -1);
    AppMethodBeat.o(152169);
  }
  
  public final void gb(String paramString, int paramInt)
  {
    AppMethodBeat.i(152168);
    r(paramString, 0, 0, paramInt);
    AppMethodBeat.o(152168);
  }
  
  public final void lw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(152170);
    a(paramString1, -1, 0, 0, paramString2);
    AppMethodBeat.o(152170);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(195449);
    super.onDetachedFromWindow();
    if (this.EVH != null) {
      this.EVH.cancel(false);
    }
    AppMethodBeat.o(195449);
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
    this.EVE = paramString;
  }
  
  public void setImgSavedPath(String paramString)
  {
    this.EVD = paramString;
  }
  
  public void setRoundCorner(boolean paramBoolean)
  {
    this.EVF = paramBoolean;
  }
  
  public void setUrl(String paramString)
  {
    AppMethodBeat.i(152167);
    r(paramString, 0, 0, -1);
    AppMethodBeat.o(152167);
  }
  
  public void setUseSdcardCache(boolean paramBoolean)
  {
    this.EVG = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.CdnImageView
 * JD-Core Version:    0.7.0.1
 */