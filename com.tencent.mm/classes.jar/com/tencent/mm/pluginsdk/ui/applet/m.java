package com.tencent.mm.pluginsdk.ui.applet;

import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;

public final class m
  implements com.tencent.mm.av.a.c.h
{
  int FnK;
  int Foe;
  private float[] Fof;
  a Fog;
  Runnable Foh;
  int ogD;
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
    this.FnK = 0;
    this.requestStart = 0L;
    this.requestEnd = 0L;
    this.scene = 0;
    this.Foe = 0;
    this.ogD = 0;
    this.Fog = null;
    this.Fof = null;
  }
  
  public m(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, float paramFloat, a parama)
  {
    AppMethodBeat.i(124378);
    this.scene = 0;
    this.FnK = 0;
    this.requestStart = 0L;
    this.requestEnd = 0L;
    this.scene = paramInt1;
    this.Foe = paramInt2;
    this.ogD = paramInt3;
    this.Fog = parama;
    if ((paramBoolean1) || (paramBoolean2))
    {
      if (this.Fof == null) {
        this.Fof = new float[] { 0.0F, 0.0F, 0.0F, 0.0F };
      }
      if (paramBoolean1)
      {
        parama = this.Fof;
        this.Fof[1] = paramFloat;
        parama[0] = paramFloat;
      }
      if (paramBoolean2)
      {
        parama = this.Fof;
        this.Fof[3] = paramFloat;
        parama[2] = paramFloat;
        AppMethodBeat.o(124378);
      }
    }
    else
    {
      this.Fof = null;
    }
    AppMethodBeat.o(124378);
  }
  
  public m(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat, a parama)
  {
    this.scene = 0;
    this.FnK = 0;
    this.requestStart = 0L;
    this.requestEnd = 0L;
    this.scene = paramInt1;
    this.Foe = paramInt2;
    this.ogD = paramInt3;
    this.Fog = parama;
    this.Fof = paramArrayOfFloat;
  }
  
  public final Bitmap a(final String paramString, View paramView, b paramb)
  {
    AppMethodBeat.i(124380);
    if (this.Fof == null)
    {
      AppMethodBeat.o(124380);
      return null;
    }
    if ((paramb == null) || (paramb.bitmap == null) || (paramb.bitmap.isRecycled()))
    {
      ae.w("MicroMsg.ChattingBizImageDownloadListener", "onProcessBitmap bitmap is null");
      AppMethodBeat.o(124380);
      return null;
    }
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.ChattingBizImageDownloadListener", "onProcessBitmap url is null");
      AppMethodBeat.o(124380);
      return null;
    }
    try
    {
      if (((paramView instanceof ImageView)) && (this.Foh != null) && (this.Foe == -1) && (this.ogD == -1))
      {
        paramString = (ImageView)paramView;
        this.Foe = paramString.getMeasuredWidth();
        this.ogD = paramString.getMeasuredHeight();
        if ((this.Foe <= 0) || (this.ogD <= 0))
        {
          paramString.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
          {
            public final void onGlobalLayout()
            {
              AppMethodBeat.i(124376);
              paramString.getViewTreeObserver().removeOnGlobalLayoutListener(this);
              m.this.Foe = paramString.getMeasuredWidth();
              m.this.ogD = paramString.getMeasuredHeight();
              ae.d("MicroMsg.ChattingBizImageDownloadListener", "onProcessBitmap image delay layout:%d,%d", new Object[] { Integer.valueOf(m.this.Foe), Integer.valueOf(m.this.ogD) });
              m.this.Foh.run();
              AppMethodBeat.o(124376);
            }
          });
          paramb.igN = true;
          paramb.igO = true;
          AppMethodBeat.o(124380);
          return null;
        }
      }
      paramView = com.tencent.mm.sdk.platformtools.h.b(paramb.bitmap, this.Foe, this.ogD, true);
      paramString = Bitmap.createScaledBitmap(paramView, this.Foe, this.ogD, true);
      if ((paramString != paramView) && (paramView != null) && (!paramView.isRecycled()))
      {
        ae.i("MicroMsg.ChattingBizImageDownloadListener", "bitmap recycle %s", new Object[] { paramView.toString() });
        paramView.recycle();
      }
      paramView = com.tencent.mm.sdk.platformtools.h.a(paramString, this.Fof);
      if ((paramString != null) && (!paramString.isRecycled()))
      {
        ae.i("MicroMsg.ChattingBizImageDownloadListener", "bitmap recycle %s", new Object[] { paramString.toString() });
        paramString.recycle();
      }
      AppMethodBeat.o(124380);
      return paramView;
    }
    catch (OutOfMemoryError paramString)
    {
      ae.w("MicroMsg.ChattingBizImageDownloadListener", "onProcessBitmap OutOfMemoryError %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(124380);
    }
    return null;
  }
  
  public final void av(Runnable paramRunnable)
  {
    this.Foh = paramRunnable;
  }
  
  public final void b(String paramString, View paramView)
  {
    AppMethodBeat.i(124379);
    if (this.Fog != null) {
      this.Fog.onStart();
    }
    paramView = g.FnF;
    if (g.aOg(paramString)) {
      this.FnK = 1;
    }
    for (;;)
    {
      this.requestStart = System.currentTimeMillis();
      ae.d("MicroMsg.ChattingBizImageDownloadListener", "alvinluo onImageLoadStart requestImageType: %d, url: %s", new Object[] { Integer.valueOf(this.FnK), paramString });
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(86L, 0L, 1L, false);
      AppMethodBeat.o(124379);
      return;
      paramView = g.FnF;
      if (g.aOh(paramString)) {
        this.FnK = 2;
      } else {
        this.FnK = 0;
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
      ae.d("MicroMsg.ChattingBizImageDownloadListener", "onImageLoadFinish, url:%s, contentType: %s, scene: %d, bitmap == null: %b", new Object[] { paramString, paramView, Integer.valueOf(i), Boolean.valueOf(bool) });
      if ((this.Fog == null) || (paramb.bitmap == null) || (paramb.bitmap.isRecycled())) {
        break label140;
      }
      paramView = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(124377);
          m.this.requestEnd = System.currentTimeMillis();
          if (m.this.Fog != null) {
            m.this.Fog.onFinish();
          }
          Object localObject = g.FnF;
          if ((g.Zu(m.this.scene)) && (paramb.from == 2))
          {
            localObject = f.FnD;
            f.b(m.this.FnK, true, m.this.requestEnd - m.this.requestStart);
            localObject = f.FnD;
            f.be(m.this.FnK, true);
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
      ar.f(paramView);
      continue;
      label140:
      if ((paramb.bitmap == null) || (paramb.bitmap.isRecycled()))
      {
        this.requestEnd = System.currentTimeMillis();
        paramView = g.FnF;
        if ((g.Zu(this.scene)) && (paramb.from == 2))
        {
          paramView = f.FnD;
          f.b(this.FnK, false, this.requestEnd - this.requestStart);
          paramView = f.FnD;
          f.be(this.FnK, false);
        }
      }
    }
    label222:
    paramView = g.FnF;
    if (g.lC(paramString, paramb.contentType)) {}
    for (boolean bool = true;; bool = false)
    {
      i = paramb.status;
      ae.d("MicroMsg.ChattingBizImageDownloadListener", "onImageLoadFinish, isDownloadWebp: %b, status: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      switch (i)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(124381);
        return;
        if (bool)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(86L, 13L, 1L, false);
          AppMethodBeat.o(124381);
          return;
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(86L, 2L, 1L, false);
          if (bool)
          {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(86L, 15L, 1L, false);
            AppMethodBeat.o(124381);
            return;
            if (bool) {
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(86L, 14L, 1L, false);
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