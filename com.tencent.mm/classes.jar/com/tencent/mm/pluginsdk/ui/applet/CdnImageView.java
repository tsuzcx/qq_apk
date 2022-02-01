package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.q;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.h.a;
import com.tencent.mm.vfs.u;

public class CdnImageView
  extends MMImageView
  implements a
{
  private String RfC;
  private String RfD;
  private boolean RfE;
  private boolean RfF;
  private com.tencent.e.i.d RfG;
  private MMHandler handler;
  private float kPA;
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
    this.RfF = false;
    this.handler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(152164);
        Object localObject = Util.nullAs(paramAnonymousMessage.getData().getString("k_url"), "");
        CdnImageView.a(CdnImageView.this, Util.nullAs(CdnImageView.a(CdnImageView.this), ""));
        if ((Util.isNullOrNil(CdnImageView.a(CdnImageView.this))) && (Util.isNullOrNil((String)localObject)))
        {
          CdnImageView.this.setImageBitmap(null);
          CdnImageView.this.setImageBitmapCompleted(null);
          AppMethodBeat.o(152164);
          return;
        }
        if (!CdnImageView.a(CdnImageView.this).equals(localObject))
        {
          Log.d("MicroMsg.CdnImageView", "hy: url not equal. abort this msg");
          AppMethodBeat.o(152164);
          return;
        }
        paramAnonymousMessage = paramAnonymousMessage.getData().getByteArray("k_data");
        if ((paramAnonymousMessage == null) || (paramAnonymousMessage.length == 0))
        {
          Log.e("MicroMsg.CdnImageView", "handleMsg fail, data is null");
          AppMethodBeat.o(152164);
          return;
        }
        localObject = BitmapUtil.decodeByteArray(paramAnonymousMessage);
        q.bmg();
        com.tencent.mm.ay.d.g(CdnImageView.a(CdnImageView.this), (Bitmap)localObject);
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
              paramAnonymousMessage = BitmapUtil.extractThumbNail((Bitmap)localObject, CdnImageView.d(CdnImageView.this), CdnImageView.c(CdnImageView.this), true, false);
            }
          }
        }
        localObject = paramAnonymousMessage;
        if (CdnImageView.e(CdnImageView.this))
        {
          localObject = paramAnonymousMessage;
          if (paramAnonymousMessage != null) {
            if (CdnImageView.f(CdnImageView.this) <= 0.0F) {
              break label305;
            }
          }
        }
        label305:
        for (localObject = BitmapUtil.getRoundedCornerBitmap(paramAnonymousMessage, false, paramAnonymousMessage.getWidth() * CdnImageView.f(CdnImageView.this));; localObject = BitmapUtil.getRoundedCornerBitmap(paramAnonymousMessage, false, paramAnonymousMessage.getWidth() * 0.5F))
        {
          if (localObject != null) {
            CdnImageView.this.setImageBitmap((Bitmap)localObject);
          }
          CdnImageView.this.setImageBitmapCompleted((Bitmap)localObject);
          AppMethodBeat.o(152164);
          return;
        }
      }
    };
    AppMethodBeat.o(152166);
  }
  
  private void b(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(152172);
    this.url = paramString1;
    this.targetWidth = paramInt1;
    this.targetHeight = paramInt2;
    if (!Util.isNullOrNil(paramString2)) {
      this.RfC = paramString2;
    }
    if (!Util.isNullOrNil(this.RfC))
    {
      paramString2 = BitmapUtil.getBitmapNative(this.RfC);
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
      hs(paramString1, paramInt3);
      AppMethodBeat.o(152172);
      return;
    }
    bri(paramString1);
    AppMethodBeat.o(152172);
  }
  
  private void bri(String paramString)
  {
    AppMethodBeat.i(152174);
    if (!u.agG(paramString))
    {
      setVisibility(8);
      AppMethodBeat.o(152174);
      return;
    }
    if ((this.targetWidth <= 0) || (this.targetHeight <= 0)) {}
    for (paramString = BitmapUtil.getBitmapNative(paramString); paramString == null; paramString = BitmapUtil.extractThumbNail(paramString, this.targetHeight, this.targetWidth, true))
    {
      setVisibility(8);
      AppMethodBeat.o(152174);
      return;
    }
    Object localObject = paramString;
    if (this.RfE)
    {
      localObject = paramString;
      if (paramString != null) {
        if (this.kPA <= 0.0F) {
          break label132;
        }
      }
    }
    label132:
    for (localObject = BitmapUtil.getRoundedCornerBitmap(paramString, false, paramString.getWidth() * this.kPA);; localObject = BitmapUtil.getRoundedCornerBitmap(paramString, false, paramString.getWidth() * 0.5F))
    {
      setImageBitmap((Bitmap)localObject);
      setImageBitmapCompleted((Bitmap)localObject);
      AppMethodBeat.o(152174);
      return;
    }
  }
  
  private String getAccImagesPath()
  {
    AppMethodBeat.i(152177);
    String str = b.aSL() + "wallet_images/";
    AppMethodBeat.o(152177);
    return str;
  }
  
  private String getCacheFilePath()
  {
    AppMethodBeat.i(152173);
    String str;
    if (!Util.isNullOrNil(this.RfC)) {
      str = this.RfC;
    }
    for (;;)
    {
      AppMethodBeat.o(152173);
      return str;
      if (!Util.isNullOrNil(this.RfD))
      {
        str = this.RfD + g.getMessageDigest(this.url.getBytes());
      }
      else
      {
        u.bBD(getAccImagesPath());
        str = getAccImagesPath() + g.getMessageDigest(this.url.getBytes());
      }
    }
  }
  
  private boolean hks()
  {
    AppMethodBeat.i(152175);
    try
    {
      Object localObject1 = getCacheFilePath();
      Log.d("MicroMsg.CdnImageView", "useSdcardCache, path: %s", new Object[] { localObject1 });
      if (u.agG((String)localObject1))
      {
        Object localObject2 = BitmapUtil.getBitmapNative((String)localObject1);
        Log.d("MicroMsg.CdnImageView", "get bitmap from cache path: %s", new Object[] { localObject2 });
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (this.targetWidth > 0)
          {
            localObject1 = localObject2;
            if (this.targetHeight > 0) {
              localObject1 = BitmapUtil.extractThumbNail((Bitmap)localObject2, this.targetHeight, this.targetWidth, true, false);
            }
          }
          localObject2 = localObject1;
          if (this.RfE)
          {
            localObject2 = localObject1;
            if (localObject1 != null) {
              if (this.kPA <= 0.0F) {
                break label146;
              }
            }
          }
          label146:
          for (localObject2 = BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject1, false, ((Bitmap)localObject1).getWidth() * this.kPA);; localObject2 = BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject1, false, ((Bitmap)localObject1).getWidth() * 0.5F))
          {
            setImageBitmap((Bitmap)localObject2);
            setImageBitmapCompleted((Bitmap)localObject2);
            AppMethodBeat.o(152175);
            return true;
          }
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.CdnImageView", localException, "setBitmapFromLocalCache error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(152175);
    }
  }
  
  private void hs(String paramString, int paramInt)
  {
    AppMethodBeat.i(152176);
    q.bmg();
    Object localObject = com.tencent.mm.ay.d.LI(paramString);
    if (localObject != null)
    {
      paramString = (String)localObject;
      if (this.targetWidth > 0)
      {
        paramString = (String)localObject;
        if (this.targetHeight > 0) {
          paramString = BitmapUtil.extractThumbNail((Bitmap)localObject, this.targetHeight, this.targetWidth, true, false);
        }
      }
      localObject = paramString;
      if (this.RfE)
      {
        localObject = paramString;
        if (paramString != null) {
          if (this.kPA <= 0.0F) {
            break label107;
          }
        }
      }
      label107:
      for (localObject = BitmapUtil.getRoundedCornerBitmap(paramString, false, paramString.getWidth() * this.kPA);; localObject = BitmapUtil.getRoundedCornerBitmap(paramString, false, paramString.getWidth() * 0.5F))
      {
        setImageBitmap((Bitmap)localObject);
        setImageBitmapCompleted((Bitmap)localObject);
        AppMethodBeat.o(152176);
        return;
      }
    }
    if ((this.RfF) && (hks()))
    {
      AppMethodBeat.o(152176);
      return;
    }
    if (paramInt > 0) {
      setImageResource(paramInt);
    }
    for (;;)
    {
      this.RfG = h.ZvG.bf(new CdnImageView.a(paramString, this.handler));
      AppMethodBeat.o(152176);
      return;
      setImageBitmap(null);
    }
  }
  
  public final void aO(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152169);
    w(paramString, paramInt1, paramInt2, -1);
    AppMethodBeat.o(152169);
  }
  
  public final void hr(String paramString, int paramInt)
  {
    AppMethodBeat.i(152168);
    w(paramString, 0, 0, paramInt);
    AppMethodBeat.o(152168);
  }
  
  public final void nr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(152170);
    b(paramString1, -1, 0, 0, paramString2);
    AppMethodBeat.o(152170);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(225009);
    super.onDetachedFromWindow();
    if (this.RfG != null) {
      this.RfG.cancel(false);
    }
    AppMethodBeat.o(225009);
  }
  
  public void setImageBitmapCompleted(Bitmap paramBitmap) {}
  
  public void setImgSavedDir(String paramString)
  {
    this.RfD = paramString;
  }
  
  public void setImgSavedPath(String paramString)
  {
    this.RfC = paramString;
  }
  
  public void setRoundCorner(boolean paramBoolean)
  {
    this.RfE = paramBoolean;
  }
  
  public void setRoundCornerRate(float paramFloat)
  {
    this.kPA = paramFloat;
  }
  
  public void setUrl(String paramString)
  {
    AppMethodBeat.i(152167);
    w(paramString, 0, 0, -1);
    AppMethodBeat.o(152167);
  }
  
  public void setUseSdcardCache(boolean paramBoolean)
  {
    this.RfF = paramBoolean;
  }
  
  public final void w(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(152171);
    b(paramString, paramInt1, paramInt2, paramInt3, null);
    AppMethodBeat.o(152171);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.CdnImageView
 * JD-Core Version:    0.7.0.1
 */