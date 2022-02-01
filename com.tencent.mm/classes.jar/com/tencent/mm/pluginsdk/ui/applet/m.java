package com.tencent.mm.pluginsdk.ui.applet;

import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public final class m
  implements com.tencent.mm.av.a.c.h
{
  int KeA;
  int KeU;
  int KeV;
  private float[] KeW;
  a KeX;
  Runnable KeY;
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
    this.KeA = 0;
    this.requestStart = 0L;
    this.requestEnd = 0L;
    this.scene = 0;
    this.KeU = 0;
    this.KeV = 0;
    this.KeX = null;
    this.KeW = null;
  }
  
  public m(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, float paramFloat, a parama)
  {
    AppMethodBeat.i(124378);
    this.scene = 0;
    this.KeA = 0;
    this.requestStart = 0L;
    this.requestEnd = 0L;
    this.scene = paramInt1;
    this.KeU = paramInt2;
    this.KeV = paramInt3;
    this.KeX = parama;
    if ((paramBoolean1) || (paramBoolean2))
    {
      if (this.KeW == null) {
        this.KeW = new float[] { 0.0F, 0.0F, 0.0F, 0.0F };
      }
      if (paramBoolean1)
      {
        parama = this.KeW;
        this.KeW[1] = paramFloat;
        parama[0] = paramFloat;
      }
      if (paramBoolean2)
      {
        parama = this.KeW;
        this.KeW[3] = paramFloat;
        parama[2] = paramFloat;
        AppMethodBeat.o(124378);
      }
    }
    else
    {
      this.KeW = null;
    }
    AppMethodBeat.o(124378);
  }
  
  public m(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat, a parama)
  {
    this.scene = 0;
    this.KeA = 0;
    this.requestStart = 0L;
    this.requestEnd = 0L;
    this.scene = paramInt1;
    this.KeU = paramInt2;
    this.KeV = paramInt3;
    this.KeX = parama;
    this.KeW = paramArrayOfFloat;
  }
  
  public final Bitmap a(final String paramString, View paramView, b paramb)
  {
    AppMethodBeat.i(124380);
    if (this.KeW == null)
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
      if (((paramView instanceof ImageView)) && (this.KeY != null) && (this.KeU == -1) && (this.KeV == -1))
      {
        paramString = (ImageView)paramView;
        this.KeU = paramString.getMeasuredWidth();
        this.KeV = paramString.getMeasuredHeight();
        if ((this.KeU <= 0) || (this.KeV <= 0))
        {
          paramString.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
          {
            public final void onGlobalLayout()
            {
              AppMethodBeat.i(124376);
              paramString.getViewTreeObserver().removeOnGlobalLayoutListener(this);
              m.this.KeU = paramString.getMeasuredWidth();
              m.this.KeV = paramString.getMeasuredHeight();
              Log.d("MicroMsg.ChattingBizImageDownloadListener", "onProcessBitmap image delay layout:%d,%d", new Object[] { Integer.valueOf(m.this.KeU), Integer.valueOf(m.this.KeV) });
              m.this.KeY.run();
              AppMethodBeat.o(124376);
            }
          });
          paramb.jbI = true;
          paramb.jbJ = true;
          AppMethodBeat.o(124380);
          return null;
        }
      }
      paramView = BitmapUtil.getCenterCropBitmap(paramb.bitmap, this.KeU, this.KeV, true);
      paramString = Bitmap.createScaledBitmap(paramView, this.KeU, this.KeV, true);
      if ((paramString != paramView) && (paramView != null) && (!paramView.isRecycled()))
      {
        Log.i("MicroMsg.ChattingBizImageDownloadListener", "bitmap recycle %s", new Object[] { paramView.toString() });
        paramView.recycle();
      }
      paramView = BitmapUtil.getRoundedCornerBitmap(paramString, true, this.KeW, true);
      if ((paramString != null) && (!paramString.isRecycled()))
      {
        Log.i("MicroMsg.ChattingBizImageDownloadListener", "bitmap recycle %s", new Object[] { paramString.toString() });
        paramString.recycle();
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
  
  public final void aG(Runnable paramRunnable)
  {
    this.KeY = paramRunnable;
  }
  
  public final void b(String paramString, View paramView)
  {
    AppMethodBeat.i(124379);
    if (this.KeX != null) {
      this.KeX.onStart();
    }
    paramView = g.Kev;
    if (g.beI(paramString)) {
      this.KeA = 1;
    }
    for (;;)
    {
      this.requestStart = System.currentTimeMillis();
      Log.d("MicroMsg.ChattingBizImageDownloadListener", "alvinluo onImageLoadStart requestImageType: %d, url: %s", new Object[] { Integer.valueOf(this.KeA), paramString });
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(86L, 0L, 1L, false);
      AppMethodBeat.o(124379);
      return;
      paramView = g.Kev;
      if (g.beJ(paramString)) {
        this.KeA = 2;
      } else {
        this.KeA = 0;
      }
    }
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
      if ((this.KeX == null) || (paramb.bitmap == null) || (paramb.bitmap.isRecycled())) {
        break label140;
      }
      paramView = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(124377);
          m.this.requestEnd = System.currentTimeMillis();
          if (m.this.KeX != null) {
            m.this.KeX.onFinish();
          }
          Object localObject = g.Kev;
          if ((g.aif(m.this.scene)) && (paramb.from == 2))
          {
            localObject = f.Ket;
            f.b(m.this.KeA, true, m.this.requestEnd - m.this.requestStart);
            localObject = f.Ket;
            f.by(m.this.KeA, true);
          }
          AppMethodBeat.o(124377);
        }
      };
      if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
        break label133;
      }
      paramView.run();
    }
    for (;;)
    {
      if (paramb.from == 2) {
        break label222;
      }
      AppMethodBeat.o(124381);
      return;
      bool = false;
      break;
      label133:
      MMHandlerThread.postToMainThread(paramView);
      continue;
      label140:
      if ((paramb.bitmap == null) || (paramb.bitmap.isRecycled()))
      {
        this.requestEnd = System.currentTimeMillis();
        paramView = g.Kev;
        if ((g.aif(this.scene)) && (paramb.from == 2))
        {
          paramView = f.Ket;
          f.b(this.KeA, false, this.requestEnd - this.requestStart);
          paramView = f.Ket;
          f.by(this.KeA, false);
        }
      }
    }
    label222:
    paramView = g.Kev;
    if (g.mA(paramString, paramb.contentType)) {}
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
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(86L, 13L, 1L, false);
          AppMethodBeat.o(124381);
          return;
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(86L, 2L, 1L, false);
          if (bool)
          {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(86L, 15L, 1L, false);
            AppMethodBeat.o(124381);
            return;
            if (bool) {
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(86L, 14L, 1L, false);
            }
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void onFinish();
    
    public abstract void onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.m
 * JD-Core Version:    0.7.0.1
 */