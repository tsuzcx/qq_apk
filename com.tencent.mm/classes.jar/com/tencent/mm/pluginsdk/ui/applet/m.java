package com.tencent.mm.pluginsdk.ui.applet;

import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.c.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public final class m
  implements com.tencent.mm.modelimage.loader.b.h
{
  int YbO;
  int YbP;
  private float[] YbQ;
  a YbR;
  Runnable YbS;
  int Ybw;
  long requestEnd;
  long requestStart;
  int scene;
  
  public m()
  {
    this((byte)0);
  }
  
  public m(byte paramByte)
  {
    this.scene = 0;
    this.Ybw = 0;
    this.requestStart = 0L;
    this.requestEnd = 0L;
    this.scene = 0;
    this.YbO = 0;
    this.YbP = 0;
    this.YbR = null;
    this.YbQ = null;
  }
  
  public m(int paramInt1, int paramInt2, int paramInt3, a parama)
  {
    this.scene = 0;
    this.Ybw = 0;
    this.requestStart = 0L;
    this.requestEnd = 0L;
    this.scene = paramInt1;
    this.YbO = paramInt2;
    this.YbP = paramInt3;
    this.YbR = parama;
    this.YbQ = null;
  }
  
  public m(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, float paramFloat, a parama)
  {
    AppMethodBeat.i(124378);
    this.scene = 0;
    this.Ybw = 0;
    this.requestStart = 0L;
    this.requestEnd = 0L;
    this.scene = paramInt1;
    this.YbO = paramInt2;
    this.YbP = paramInt3;
    this.YbR = parama;
    if ((paramBoolean1) || (paramBoolean2))
    {
      if (this.YbQ == null) {
        this.YbQ = new float[] { 0.0F, 0.0F, 0.0F, 0.0F };
      }
      if (paramBoolean1)
      {
        parama = this.YbQ;
        this.YbQ[1] = paramFloat;
        parama[0] = paramFloat;
      }
      if (paramBoolean2)
      {
        parama = this.YbQ;
        this.YbQ[3] = paramFloat;
        parama[2] = paramFloat;
        AppMethodBeat.o(124378);
      }
    }
    else
    {
      this.YbQ = null;
    }
    AppMethodBeat.o(124378);
  }
  
  public final Bitmap a(final String paramString, View paramView, b paramb)
  {
    AppMethodBeat.i(124380);
    if (this.YbQ == null)
    {
      AppMethodBeat.o(124380);
      return null;
    }
    if ((paramb == null) || (paramb.bitmap == null) || (paramb.bitmap.isRecycled()))
    {
      Log.w("MicroMsg.ChattingBizImageDownloadListener", "onProcessBitmap bitmap is null");
      AppMethodBeat.o(124380);
      return null;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.ChattingBizImageDownloadListener", "onProcessBitmap url is null");
      AppMethodBeat.o(124380);
      return null;
    }
    try
    {
      if (((paramView instanceof ImageView)) && (this.YbS != null) && (this.YbO == -1) && (this.YbP == -1))
      {
        paramString = (ImageView)paramView;
        this.YbO = paramString.getMeasuredWidth();
        this.YbP = paramString.getMeasuredHeight();
        if ((this.YbO <= 0) || (this.YbP <= 0))
        {
          paramString.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
          {
            public final void onGlobalLayout()
            {
              AppMethodBeat.i(124376);
              paramString.getViewTreeObserver().removeOnGlobalLayoutListener(this);
              m.this.YbO = paramString.getMeasuredWidth();
              m.this.YbP = paramString.getMeasuredHeight();
              Log.d("MicroMsg.ChattingBizImageDownloadListener", "onProcessBitmap image delay layout:%d,%d", new Object[] { Integer.valueOf(m.this.YbO), Integer.valueOf(m.this.YbP) });
              m.this.YbS.run();
              AppMethodBeat.o(124376);
            }
          });
          paramb.oKU = true;
          paramb.oKV = true;
          AppMethodBeat.o(124380);
          return null;
        }
      }
      paramView = BitmapUtil.getCenterCropBitmap(paramb.bitmap, this.YbO, this.YbP, true);
      paramString = Bitmap.createScaledBitmap(paramView, this.YbO, this.YbP, true);
      if ((paramString != paramView) && (paramView != null) && (!paramView.isRecycled()))
      {
        Log.i("MicroMsg.ChattingBizImageDownloadListener", "bitmap recycle %s", new Object[] { paramView.toString() });
        paramView.recycle();
      }
      paramView = BitmapUtil.getRoundedCornerBitmap(paramString, true, this.YbQ, true);
      if ((paramString != null) && (!paramString.isRecycled()))
      {
        Log.i("MicroMsg.ChattingBizImageDownloadListener", "bitmap recycle %s", new Object[] { paramString.toString() });
        paramString.recycle();
      }
      if ((this.YbR instanceof b)) {
        ((b)this.YbR).af(paramView);
      }
      AppMethodBeat.o(124380);
      return paramView;
    }
    catch (OutOfMemoryError paramString)
    {
      Log.w("MicroMsg.ChattingBizImageDownloadListener", "onProcessBitmap OutOfMemoryError %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(124380);
    }
    return null;
  }
  
  public final void b(String paramString, View paramView, final b paramb)
  {
    AppMethodBeat.i(124381);
    paramView = paramb.contentType;
    int i = this.scene;
    if (paramb.bitmap == null)
    {
      bool = true;
      Log.d("MicroMsg.ChattingBizImageDownloadListener", "onImageLoadFinish, url:%s, contentType: %s, scene: %d, bitmap == null: %b", new Object[] { paramString, paramView, Integer.valueOf(i), Boolean.valueOf(bool) });
      if ((paramb.bitmap == null) || (paramb.bitmap.isRecycled())) {
        break label133;
      }
      paramView = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(124377);
          m.this.requestEnd = System.currentTimeMillis();
          if (m.this.YbR != null)
          {
            m.this.YbR.onFinish();
            m.this.YbR = null;
          }
          Object localObject = g.Ybp;
          if ((g.awl(m.this.scene)) && (paramb.from == 2))
          {
            localObject = f.Ybo;
            f.b(m.this.Ybw, true, m.this.requestEnd - m.this.requestStart);
            localObject = f.Ybo;
            f.cs(m.this.Ybw, true);
          }
          AppMethodBeat.o(124377);
        }
      };
      if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
        break label126;
      }
      paramView.run();
    }
    for (;;)
    {
      if (paramb.from == 2) {
        break label220;
      }
      AppMethodBeat.o(124381);
      return;
      bool = false;
      break;
      label126:
      MMHandlerThread.postToMainThread(paramView);
      continue;
      label133:
      this.YbR = null;
      if ((paramb.bitmap == null) || (paramb.bitmap.isRecycled()))
      {
        this.requestEnd = System.currentTimeMillis();
        paramView = g.Ybp;
        if ((g.awl(this.scene)) && (paramb.from == 2))
        {
          paramView = f.Ybo;
          f.b(this.Ybw, false, this.requestEnd - this.requestStart);
          paramView = f.Ybo;
          f.cs(this.Ybw, false);
        }
      }
    }
    label220:
    paramView = g.Ybp;
    if (g.pl(paramString, paramb.contentType)) {}
    for (boolean bool = true;; bool = false)
    {
      i = paramb.status;
      Log.d("MicroMsg.ChattingBizImageDownloadListener", "onImageLoadFinish, isDownloadWebp: %b, status: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      switch (i)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(124381);
        return;
        if (bool)
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(86L, 13L, 1L, false);
          AppMethodBeat.o(124381);
          return;
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(86L, 2L, 1L, false);
          if (bool)
          {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(86L, 15L, 1L, false);
            AppMethodBeat.o(124381);
            return;
            if (bool) {
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(86L, 14L, 1L, false);
            }
          }
        }
      }
    }
  }
  
  public final void c(String paramString, View paramView)
  {
    AppMethodBeat.i(124379);
    if (this.YbR != null) {
      this.YbR.onStart();
    }
    paramView = g.Ybp;
    if (g.bqS(paramString)) {
      this.Ybw = 1;
    }
    for (;;)
    {
      this.requestStart = System.currentTimeMillis();
      Log.d("MicroMsg.ChattingBizImageDownloadListener", "alvinluo onImageLoadStart requestImageType: %d, url: %s", new Object[] { Integer.valueOf(this.Ybw), paramString });
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(86L, 0L, 1L, false);
      AppMethodBeat.o(124379);
      return;
      paramView = g.Ybp;
      if (g.bqT(paramString)) {
        this.Ybw = 2;
      } else {
        this.Ybw = 0;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void onFinish();
    
    public abstract void onStart();
  }
  
  public static abstract interface b
    extends m.a
  {
    public abstract boolean af(Bitmap paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.m
 * JD-Core Version:    0.7.0.1
 */