package com.tencent.mm.pluginsdk.ui.applet;

import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.d.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;

public final class m
  implements com.tencent.mm.aw.a.c.h
{
  int BXV;
  int BYp;
  private float[] BYq;
  a BYr;
  Runnable BYs;
  int mXi;
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
    this.BXV = 0;
    this.requestStart = 0L;
    this.requestEnd = 0L;
    this.scene = 0;
    this.BYp = 0;
    this.mXi = 0;
    this.BYr = null;
    this.BYq = null;
  }
  
  public m(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, float paramFloat, a parama)
  {
    AppMethodBeat.i(124378);
    this.scene = 0;
    this.BXV = 0;
    this.requestStart = 0L;
    this.requestEnd = 0L;
    this.scene = paramInt1;
    this.BYp = paramInt2;
    this.mXi = paramInt3;
    this.BYr = parama;
    if ((paramBoolean1) || (paramBoolean2))
    {
      if (this.BYq == null) {
        this.BYq = new float[] { 0.0F, 0.0F, 0.0F, 0.0F };
      }
      if (paramBoolean1)
      {
        parama = this.BYq;
        this.BYq[1] = paramFloat;
        parama[0] = paramFloat;
      }
      if (paramBoolean2)
      {
        parama = this.BYq;
        this.BYq[3] = paramFloat;
        parama[2] = paramFloat;
        AppMethodBeat.o(124378);
      }
    }
    else
    {
      this.BYq = null;
    }
    AppMethodBeat.o(124378);
  }
  
  public m(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat, a parama)
  {
    this.scene = 0;
    this.BXV = 0;
    this.requestStart = 0L;
    this.requestEnd = 0L;
    this.scene = paramInt1;
    this.BYp = paramInt2;
    this.mXi = paramInt3;
    this.BYr = parama;
    this.BYq = paramArrayOfFloat;
  }
  
  public final Bitmap a(final String paramString, View paramView, b paramb)
  {
    AppMethodBeat.i(124380);
    if (this.BYq == null)
    {
      AppMethodBeat.o(124380);
      return null;
    }
    if ((paramb == null) || (paramb.bitmap == null) || (paramb.bitmap.isRecycled()))
    {
      ad.w("MicroMsg.ChattingBizImageDownloadListener", "onProcessBitmap bitmap is null");
      AppMethodBeat.o(124380);
      return null;
    }
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.ChattingBizImageDownloadListener", "onProcessBitmap url is null");
      AppMethodBeat.o(124380);
      return null;
    }
    try
    {
      if (((paramView instanceof ImageView)) && (this.BYs != null) && (this.BYp == -1) && (this.mXi == -1))
      {
        paramString = (ImageView)paramView;
        this.BYp = paramString.getMeasuredWidth();
        this.mXi = paramString.getMeasuredHeight();
        if ((this.BYp <= 0) || (this.mXi <= 0))
        {
          paramString.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
          {
            public final void onGlobalLayout()
            {
              AppMethodBeat.i(124376);
              paramString.getViewTreeObserver().removeOnGlobalLayoutListener(this);
              m.this.BYp = paramString.getMeasuredWidth();
              m.this.mXi = paramString.getMeasuredHeight();
              ad.d("MicroMsg.ChattingBizImageDownloadListener", "onProcessBitmap image delay layout:%d,%d", new Object[] { Integer.valueOf(m.this.BYp), Integer.valueOf(m.this.mXi) });
              m.this.BYs.run();
              AppMethodBeat.o(124376);
            }
          });
          paramb.hkx = true;
          paramb.hky = true;
          AppMethodBeat.o(124380);
          return null;
        }
      }
      paramView = com.tencent.mm.sdk.platformtools.f.b(paramb.bitmap, this.BYp, this.mXi, true);
      paramString = Bitmap.createScaledBitmap(paramView, this.BYp, this.mXi, true);
      if ((paramString != paramView) && (paramView != null) && (!paramView.isRecycled()))
      {
        ad.i("MicroMsg.ChattingBizImageDownloadListener", "bitmap recycle %s", new Object[] { paramView.toString() });
        paramView.recycle();
      }
      paramView = com.tencent.mm.sdk.platformtools.f.a(paramString, this.BYq);
      if ((paramString != null) && (!paramString.isRecycled()))
      {
        ad.i("MicroMsg.ChattingBizImageDownloadListener", "bitmap recycle %s", new Object[] { paramString.toString() });
        paramString.recycle();
      }
      AppMethodBeat.o(124380);
      return paramView;
    }
    catch (OutOfMemoryError paramString)
    {
      ad.w("MicroMsg.ChattingBizImageDownloadListener", "onProcessBitmap OutOfMemoryError %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(124380);
    }
    return null;
  }
  
  public final void aw(Runnable paramRunnable)
  {
    this.BYs = paramRunnable;
  }
  
  public final void b(String paramString, View paramView)
  {
    AppMethodBeat.i(124379);
    if (this.BYr != null) {
      this.BYr.onStart();
    }
    paramView = g.BXQ;
    if (g.aBP(paramString)) {
      this.BXV = 1;
    }
    for (;;)
    {
      this.requestStart = System.currentTimeMillis();
      ad.d("MicroMsg.ChattingBizImageDownloadListener", "alvinluo onImageLoadStart requestImageType: %d, url: %s", new Object[] { Integer.valueOf(this.BXV), paramString });
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(86L, 0L, 1L, false);
      AppMethodBeat.o(124379);
      return;
      paramView = g.BXQ;
      if (g.aBQ(paramString)) {
        this.BXV = 2;
      } else {
        this.BXV = 0;
      }
    }
  }
  
  public final void b(String paramString, View paramView, final b paramb)
  {
    AppMethodBeat.i(124381);
    paramView = paramb.bxn;
    int i = this.scene;
    if (paramb.bitmap == null)
    {
      bool = true;
      ad.d("MicroMsg.ChattingBizImageDownloadListener", "onImageLoadFinish, url:%s, contentType: %s, scene: %d, bitmap == null: %b", new Object[] { paramString, paramView, Integer.valueOf(i), Boolean.valueOf(bool) });
      if ((this.BYr == null) || (paramb.bitmap == null) || (paramb.bitmap.isRecycled())) {
        break label140;
      }
      paramView = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(124377);
          m.this.requestEnd = System.currentTimeMillis();
          if (m.this.BYr != null) {
            m.this.BYr.onFinish();
          }
          Object localObject = g.BXQ;
          if ((g.UI(m.this.scene)) && (paramb.from == 2))
          {
            localObject = f.BXO;
            f.b(m.this.BXV, true, m.this.requestEnd - m.this.requestStart);
            localObject = f.BXO;
            f.aN(m.this.BXV, true);
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
      aq.f(paramView);
      continue;
      label140:
      if ((paramb.bitmap == null) || (paramb.bitmap.isRecycled()))
      {
        this.requestEnd = System.currentTimeMillis();
        paramView = g.BXQ;
        if ((g.UI(this.scene)) && (paramb.from == 2))
        {
          paramView = f.BXO;
          f.b(this.BXV, false, this.requestEnd - this.requestStart);
          paramView = f.BXO;
          f.aN(this.BXV, false);
        }
      }
    }
    label222:
    paramView = g.BXQ;
    if (g.kB(paramString, paramb.bxn)) {}
    for (boolean bool = true;; bool = false)
    {
      i = paramb.status;
      ad.d("MicroMsg.ChattingBizImageDownloadListener", "onImageLoadFinish, isDownloadWebp: %b, status: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      switch (i)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(124381);
        return;
        if (bool)
        {
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(86L, 13L, 1L, false);
          AppMethodBeat.o(124381);
          return;
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(86L, 2L, 1L, false);
          if (bool)
          {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(86L, 15L, 1L, false);
            AppMethodBeat.o(124381);
            return;
            if (bool) {
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(86L, 14L, 1L, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.m
 * JD-Core Version:    0.7.0.1
 */