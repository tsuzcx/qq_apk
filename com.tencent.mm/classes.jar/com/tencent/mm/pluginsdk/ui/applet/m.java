package com.tencent.mm.pluginsdk.ui.applet;

import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;

public final class m
  implements com.tencent.mm.av.a.c.h
{
  int DqG;
  private float[] DqH;
  a DqI;
  Runnable DqJ;
  int Dqm;
  int nzH;
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
    this.Dqm = 0;
    this.requestStart = 0L;
    this.requestEnd = 0L;
    this.scene = 0;
    this.DqG = 0;
    this.nzH = 0;
    this.DqI = null;
    this.DqH = null;
  }
  
  public m(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, float paramFloat, a parama)
  {
    AppMethodBeat.i(124378);
    this.scene = 0;
    this.Dqm = 0;
    this.requestStart = 0L;
    this.requestEnd = 0L;
    this.scene = paramInt1;
    this.DqG = paramInt2;
    this.nzH = paramInt3;
    this.DqI = parama;
    if ((paramBoolean1) || (paramBoolean2))
    {
      if (this.DqH == null) {
        this.DqH = new float[] { 0.0F, 0.0F, 0.0F, 0.0F };
      }
      if (paramBoolean1)
      {
        parama = this.DqH;
        this.DqH[1] = paramFloat;
        parama[0] = paramFloat;
      }
      if (paramBoolean2)
      {
        parama = this.DqH;
        this.DqH[3] = paramFloat;
        parama[2] = paramFloat;
        AppMethodBeat.o(124378);
      }
    }
    else
    {
      this.DqH = null;
    }
    AppMethodBeat.o(124378);
  }
  
  public m(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat, a parama)
  {
    this.scene = 0;
    this.Dqm = 0;
    this.requestStart = 0L;
    this.requestEnd = 0L;
    this.scene = paramInt1;
    this.DqG = paramInt2;
    this.nzH = paramInt3;
    this.DqI = parama;
    this.DqH = paramArrayOfFloat;
  }
  
  public final Bitmap a(final String paramString, View paramView, b paramb)
  {
    AppMethodBeat.i(124380);
    if (this.DqH == null)
    {
      AppMethodBeat.o(124380);
      return null;
    }
    if ((paramb == null) || (paramb.bitmap == null) || (paramb.bitmap.isRecycled()))
    {
      ac.w("MicroMsg.ChattingBizImageDownloadListener", "onProcessBitmap bitmap is null");
      AppMethodBeat.o(124380);
      return null;
    }
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.ChattingBizImageDownloadListener", "onProcessBitmap url is null");
      AppMethodBeat.o(124380);
      return null;
    }
    try
    {
      if (((paramView instanceof ImageView)) && (this.DqJ != null) && (this.DqG == -1) && (this.nzH == -1))
      {
        paramString = (ImageView)paramView;
        this.DqG = paramString.getMeasuredWidth();
        this.nzH = paramString.getMeasuredHeight();
        if ((this.DqG <= 0) || (this.nzH <= 0))
        {
          paramString.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
          {
            public final void onGlobalLayout()
            {
              AppMethodBeat.i(124376);
              paramString.getViewTreeObserver().removeOnGlobalLayoutListener(this);
              m.this.DqG = paramString.getMeasuredWidth();
              m.this.nzH = paramString.getMeasuredHeight();
              ac.d("MicroMsg.ChattingBizImageDownloadListener", "onProcessBitmap image delay layout:%d,%d", new Object[] { Integer.valueOf(m.this.DqG), Integer.valueOf(m.this.nzH) });
              m.this.DqJ.run();
              AppMethodBeat.o(124376);
            }
          });
          paramb.hLa = true;
          paramb.hLb = true;
          AppMethodBeat.o(124380);
          return null;
        }
      }
      paramView = com.tencent.mm.sdk.platformtools.f.b(paramb.bitmap, this.DqG, this.nzH, true);
      paramString = Bitmap.createScaledBitmap(paramView, this.DqG, this.nzH, true);
      if ((paramString != paramView) && (paramView != null) && (!paramView.isRecycled()))
      {
        ac.i("MicroMsg.ChattingBizImageDownloadListener", "bitmap recycle %s", new Object[] { paramView.toString() });
        paramView.recycle();
      }
      paramView = com.tencent.mm.sdk.platformtools.f.a(paramString, this.DqH);
      if ((paramString != null) && (!paramString.isRecycled()))
      {
        ac.i("MicroMsg.ChattingBizImageDownloadListener", "bitmap recycle %s", new Object[] { paramString.toString() });
        paramString.recycle();
      }
      AppMethodBeat.o(124380);
      return paramView;
    }
    catch (OutOfMemoryError paramString)
    {
      ac.w("MicroMsg.ChattingBizImageDownloadListener", "onProcessBitmap OutOfMemoryError %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(124380);
    }
    return null;
  }
  
  public final void ay(Runnable paramRunnable)
  {
    this.DqJ = paramRunnable;
  }
  
  public final void b(String paramString, View paramView)
  {
    AppMethodBeat.i(124379);
    if (this.DqI != null) {
      this.DqI.onStart();
    }
    paramView = g.Dqh;
    if (g.aHh(paramString)) {
      this.Dqm = 1;
    }
    for (;;)
    {
      this.requestStart = System.currentTimeMillis();
      ac.d("MicroMsg.ChattingBizImageDownloadListener", "alvinluo onImageLoadStart requestImageType: %d, url: %s", new Object[] { Integer.valueOf(this.Dqm), paramString });
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(86L, 0L, 1L, false);
      AppMethodBeat.o(124379);
      return;
      paramView = g.Dqh;
      if (g.aHi(paramString)) {
        this.Dqm = 2;
      } else {
        this.Dqm = 0;
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
      ac.d("MicroMsg.ChattingBizImageDownloadListener", "onImageLoadFinish, url:%s, contentType: %s, scene: %d, bitmap == null: %b", new Object[] { paramString, paramView, Integer.valueOf(i), Boolean.valueOf(bool) });
      if ((this.DqI == null) || (paramb.bitmap == null) || (paramb.bitmap.isRecycled())) {
        break label140;
      }
      paramView = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(124377);
          m.this.requestEnd = System.currentTimeMillis();
          if (m.this.DqI != null) {
            m.this.DqI.onFinish();
          }
          Object localObject = g.Dqh;
          if ((g.WS(m.this.scene)) && (paramb.from == 2))
          {
            localObject = f.Dqf;
            f.b(m.this.Dqm, true, m.this.requestEnd - m.this.requestStart);
            localObject = f.Dqf;
            f.aR(m.this.Dqm, true);
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
      ap.f(paramView);
      continue;
      label140:
      if ((paramb.bitmap == null) || (paramb.bitmap.isRecycled()))
      {
        this.requestEnd = System.currentTimeMillis();
        paramView = g.Dqh;
        if ((g.WS(this.scene)) && (paramb.from == 2))
        {
          paramView = f.Dqf;
          f.b(this.Dqm, false, this.requestEnd - this.requestStart);
          paramView = f.Dqf;
          f.aR(this.Dqm, false);
        }
      }
    }
    label222:
    paramView = g.Dqh;
    if (g.kY(paramString, paramb.contentType)) {}
    for (boolean bool = true;; bool = false)
    {
      i = paramb.status;
      ac.d("MicroMsg.ChattingBizImageDownloadListener", "onImageLoadFinish, isDownloadWebp: %b, status: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      switch (i)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(124381);
        return;
        if (bool)
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(86L, 13L, 1L, false);
          AppMethodBeat.o(124381);
          return;
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(86L, 2L, 1L, false);
          if (bool)
          {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(86L, 15L, 1L, false);
            AppMethodBeat.o(124381);
            return;
            if (bool) {
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(86L, 14L, 1L, false);
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