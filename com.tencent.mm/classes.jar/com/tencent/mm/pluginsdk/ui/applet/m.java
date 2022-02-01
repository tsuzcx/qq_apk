package com.tencent.mm.pluginsdk.ui.applet;

import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.d.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public final class m
  implements com.tencent.mm.ay.a.c.h
{
  int RfI;
  int RfJ;
  private float[] RfK;
  a RfL;
  Runnable RfM;
  int Rfo;
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
    this.Rfo = 0;
    this.requestStart = 0L;
    this.requestEnd = 0L;
    this.scene = 0;
    this.RfI = 0;
    this.RfJ = 0;
    this.RfL = null;
    this.RfK = null;
  }
  
  public m(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, float paramFloat, a parama)
  {
    AppMethodBeat.i(124378);
    this.scene = 0;
    this.Rfo = 0;
    this.requestStart = 0L;
    this.requestEnd = 0L;
    this.scene = paramInt1;
    this.RfI = paramInt2;
    this.RfJ = paramInt3;
    this.RfL = parama;
    if ((paramBoolean1) || (paramBoolean2))
    {
      if (this.RfK == null) {
        this.RfK = new float[] { 0.0F, 0.0F, 0.0F, 0.0F };
      }
      if (paramBoolean1)
      {
        parama = this.RfK;
        this.RfK[1] = paramFloat;
        parama[0] = paramFloat;
      }
      if (paramBoolean2)
      {
        parama = this.RfK;
        this.RfK[3] = paramFloat;
        parama[2] = paramFloat;
        AppMethodBeat.o(124378);
      }
    }
    else
    {
      this.RfK = null;
    }
    AppMethodBeat.o(124378);
  }
  
  public m(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat, a parama)
  {
    this.scene = 0;
    this.Rfo = 0;
    this.requestStart = 0L;
    this.requestEnd = 0L;
    this.scene = paramInt1;
    this.RfI = paramInt2;
    this.RfJ = paramInt3;
    this.RfL = parama;
    this.RfK = paramArrayOfFloat;
  }
  
  public final Bitmap a(final String paramString, View paramView, b paramb)
  {
    AppMethodBeat.i(124380);
    if (this.RfK == null)
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
      if (((paramView instanceof ImageView)) && (this.RfM != null) && (this.RfI == -1) && (this.RfJ == -1))
      {
        paramString = (ImageView)paramView;
        this.RfI = paramString.getMeasuredWidth();
        this.RfJ = paramString.getMeasuredHeight();
        if ((this.RfI <= 0) || (this.RfJ <= 0))
        {
          paramString.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
          {
            public final void onGlobalLayout()
            {
              AppMethodBeat.i(124376);
              paramString.getViewTreeObserver().removeOnGlobalLayoutListener(this);
              m.this.RfI = paramString.getMeasuredWidth();
              m.this.RfJ = paramString.getMeasuredHeight();
              Log.d("MicroMsg.ChattingBizImageDownloadListener", "onProcessBitmap image delay layout:%d,%d", new Object[] { Integer.valueOf(m.this.RfI), Integer.valueOf(m.this.RfJ) });
              m.this.RfM.run();
              AppMethodBeat.o(124376);
            }
          });
          paramb.lSi = true;
          paramb.lSj = true;
          AppMethodBeat.o(124380);
          return null;
        }
      }
      paramView = BitmapUtil.getCenterCropBitmap(paramb.bitmap, this.RfI, this.RfJ, true);
      paramString = Bitmap.createScaledBitmap(paramView, this.RfI, this.RfJ, true);
      if ((paramString != paramView) && (paramView != null) && (!paramView.isRecycled()))
      {
        Log.i("MicroMsg.ChattingBizImageDownloadListener", "bitmap recycle %s", new Object[] { paramView.toString() });
        paramView.recycle();
      }
      paramView = BitmapUtil.getRoundedCornerBitmap(paramString, true, this.RfK, true);
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
  
  public final void aM(Runnable paramRunnable)
  {
    this.RfM = paramRunnable;
  }
  
  public final void b(String paramString, View paramView)
  {
    AppMethodBeat.i(124379);
    if (this.RfL != null) {
      this.RfL.onStart();
    }
    paramView = g.Rfj;
    if (g.bre(paramString)) {
      this.Rfo = 1;
    }
    for (;;)
    {
      this.requestStart = System.currentTimeMillis();
      Log.d("MicroMsg.ChattingBizImageDownloadListener", "alvinluo onImageLoadStart requestImageType: %d, url: %s", new Object[] { Integer.valueOf(this.Rfo), paramString });
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(86L, 0L, 1L, false);
      AppMethodBeat.o(124379);
      return;
      paramView = g.Rfj;
      if (g.brf(paramString)) {
        this.Rfo = 2;
      } else {
        this.Rfo = 0;
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
      if ((paramb.bitmap == null) || (paramb.bitmap.isRecycled())) {
        break label133;
      }
      paramView = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(124377);
          m.this.requestEnd = System.currentTimeMillis();
          if (m.this.RfL != null)
          {
            m.this.RfL.onFinish();
            m.this.RfL = null;
          }
          Object localObject = g.Rfj;
          if ((g.aqh(m.this.scene)) && (paramb.from == 2))
          {
            localObject = f.Rfh;
            f.b(m.this.Rfo, true, m.this.requestEnd - m.this.requestStart);
            localObject = f.Rfh;
            f.bK(m.this.Rfo, true);
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
      this.RfL = null;
      if ((paramb.bitmap == null) || (paramb.bitmap.isRecycled()))
      {
        this.requestEnd = System.currentTimeMillis();
        paramView = g.Rfj;
        if ((g.aqh(this.scene)) && (paramb.from == 2))
        {
          paramView = f.Rfh;
          f.b(this.Rfo, false, this.requestEnd - this.requestStart);
          paramView = f.Rfh;
          f.bK(this.Rfo, false);
        }
      }
    }
    label220:
    paramView = g.Rfj;
    if (g.nq(paramString, paramb.contentType)) {}
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
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(86L, 13L, 1L, false);
          AppMethodBeat.o(124381);
          return;
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(86L, 2L, 1L, false);
          if (bool)
          {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(86L, 15L, 1L, false);
            AppMethodBeat.o(124381);
            return;
            if (bool) {
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(86L, 14L, 1L, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.m
 * JD-Core Version:    0.7.0.1
 */