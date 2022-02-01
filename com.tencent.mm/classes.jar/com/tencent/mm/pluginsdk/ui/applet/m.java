package com.tencent.mm.pluginsdk.ui.applet;

import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.c.h;
import com.tencent.mm.aw.a.d.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;

public final class m
  implements h
{
  int EVJ;
  private float[] EVK;
  a EVL;
  Runnable EVM;
  int EVp;
  int oaM;
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
    this.EVp = 0;
    this.requestStart = 0L;
    this.requestEnd = 0L;
    this.scene = 0;
    this.EVJ = 0;
    this.oaM = 0;
    this.EVL = null;
    this.EVK = null;
  }
  
  public m(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, float paramFloat, a parama)
  {
    AppMethodBeat.i(124378);
    this.scene = 0;
    this.EVp = 0;
    this.requestStart = 0L;
    this.requestEnd = 0L;
    this.scene = paramInt1;
    this.EVJ = paramInt2;
    this.oaM = paramInt3;
    this.EVL = parama;
    if ((paramBoolean1) || (paramBoolean2))
    {
      if (this.EVK == null) {
        this.EVK = new float[] { 0.0F, 0.0F, 0.0F, 0.0F };
      }
      if (paramBoolean1)
      {
        parama = this.EVK;
        this.EVK[1] = paramFloat;
        parama[0] = paramFloat;
      }
      if (paramBoolean2)
      {
        parama = this.EVK;
        this.EVK[3] = paramFloat;
        parama[2] = paramFloat;
        AppMethodBeat.o(124378);
      }
    }
    else
    {
      this.EVK = null;
    }
    AppMethodBeat.o(124378);
  }
  
  public m(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat, a parama)
  {
    this.scene = 0;
    this.EVp = 0;
    this.requestStart = 0L;
    this.requestEnd = 0L;
    this.scene = paramInt1;
    this.EVJ = paramInt2;
    this.oaM = paramInt3;
    this.EVL = parama;
    this.EVK = paramArrayOfFloat;
  }
  
  public final Bitmap a(final String paramString, View paramView, b paramb)
  {
    AppMethodBeat.i(124380);
    if (this.EVK == null)
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
      if (((paramView instanceof ImageView)) && (this.EVM != null) && (this.EVJ == -1) && (this.oaM == -1))
      {
        paramString = (ImageView)paramView;
        this.EVJ = paramString.getMeasuredWidth();
        this.oaM = paramString.getMeasuredHeight();
        if ((this.EVJ <= 0) || (this.oaM <= 0))
        {
          paramString.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
          {
            public final void onGlobalLayout()
            {
              AppMethodBeat.i(124376);
              paramString.getViewTreeObserver().removeOnGlobalLayoutListener(this);
              m.this.EVJ = paramString.getMeasuredWidth();
              m.this.oaM = paramString.getMeasuredHeight();
              ad.d("MicroMsg.ChattingBizImageDownloadListener", "onProcessBitmap image delay layout:%d,%d", new Object[] { Integer.valueOf(m.this.EVJ), Integer.valueOf(m.this.oaM) });
              m.this.EVM.run();
              AppMethodBeat.o(124376);
            }
          });
          paramb.idV = true;
          paramb.idW = true;
          AppMethodBeat.o(124380);
          return null;
        }
      }
      paramView = com.tencent.mm.sdk.platformtools.g.b(paramb.bitmap, this.EVJ, this.oaM, true);
      paramString = Bitmap.createScaledBitmap(paramView, this.EVJ, this.oaM, true);
      if ((paramString != paramView) && (paramView != null) && (!paramView.isRecycled()))
      {
        ad.i("MicroMsg.ChattingBizImageDownloadListener", "bitmap recycle %s", new Object[] { paramView.toString() });
        paramView.recycle();
      }
      paramView = com.tencent.mm.sdk.platformtools.g.a(paramString, this.EVK);
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
  
  public final void ax(Runnable paramRunnable)
  {
    this.EVM = paramRunnable;
  }
  
  public final void b(String paramString, View paramView)
  {
    AppMethodBeat.i(124379);
    if (this.EVL != null) {
      this.EVL.onStart();
    }
    paramView = g.EVk;
    if (g.aMK(paramString)) {
      this.EVp = 1;
    }
    for (;;)
    {
      this.requestStart = System.currentTimeMillis();
      ad.d("MicroMsg.ChattingBizImageDownloadListener", "alvinluo onImageLoadStart requestImageType: %d, url: %s", new Object[] { Integer.valueOf(this.EVp), paramString });
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(86L, 0L, 1L, false);
      AppMethodBeat.o(124379);
      return;
      paramView = g.EVk;
      if (g.aML(paramString)) {
        this.EVp = 2;
      } else {
        this.EVp = 0;
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
      ad.d("MicroMsg.ChattingBizImageDownloadListener", "onImageLoadFinish, url:%s, contentType: %s, scene: %d, bitmap == null: %b", new Object[] { paramString, paramView, Integer.valueOf(i), Boolean.valueOf(bool) });
      if ((this.EVL == null) || (paramb.bitmap == null) || (paramb.bitmap.isRecycled())) {
        break label140;
      }
      paramView = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(124377);
          m.this.requestEnd = System.currentTimeMillis();
          if (m.this.EVL != null) {
            m.this.EVL.onFinish();
          }
          Object localObject = g.EVk;
          if ((g.YO(m.this.scene)) && (paramb.from == 2))
          {
            localObject = f.EVi;
            f.b(m.this.EVp, true, m.this.requestEnd - m.this.requestStart);
            localObject = f.EVi;
            f.aY(m.this.EVp, true);
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
        paramView = g.EVk;
        if ((g.YO(this.scene)) && (paramb.from == 2))
        {
          paramView = f.EVi;
          f.b(this.EVp, false, this.requestEnd - this.requestStart);
          paramView = f.EVi;
          f.aY(this.EVp, false);
        }
      }
    }
    label222:
    paramView = g.EVk;
    if (g.lv(paramString, paramb.contentType)) {}
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
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(86L, 13L, 1L, false);
          AppMethodBeat.o(124381);
          return;
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(86L, 2L, 1L, false);
          if (bool)
          {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(86L, 15L, 1L, false);
            AppMethodBeat.o(124381);
            return;
            if (bool) {
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(86L, 14L, 1L, false);
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