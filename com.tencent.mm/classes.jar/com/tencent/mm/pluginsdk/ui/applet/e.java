package com.tencent.mm.pluginsdk.ui.applet;

import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.g;
import com.tencent.mm.at.a.d.b;
import com.tencent.mm.at.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;

public final class e
  implements g
{
  int jWe;
  int vTi;
  private float[] vTj;
  e.a vTk;
  Runnable vTl;
  
  public e()
  {
    this(0, 0, null, null);
  }
  
  public e(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, float paramFloat, e.a parama)
  {
    AppMethodBeat.i(151359);
    this.vTi = paramInt1;
    this.jWe = paramInt2;
    this.vTk = parama;
    if ((paramBoolean1) || (paramBoolean2))
    {
      if (this.vTj == null) {
        this.vTj = new float[] { 0.0F, 0.0F, 0.0F, 0.0F };
      }
      if (paramBoolean1)
      {
        parama = this.vTj;
        this.vTj[1] = paramFloat;
        parama[0] = paramFloat;
      }
      if (paramBoolean2)
      {
        parama = this.vTj;
        this.vTj[3] = paramFloat;
        parama[2] = paramFloat;
        AppMethodBeat.o(151359);
      }
    }
    else
    {
      this.vTj = null;
    }
    AppMethodBeat.o(151359);
  }
  
  public e(int paramInt1, int paramInt2, float[] paramArrayOfFloat, e.a parama)
  {
    this.vTi = paramInt1;
    this.jWe = paramInt2;
    this.vTk = parama;
    this.vTj = paramArrayOfFloat;
  }
  
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    AppMethodBeat.i(11687);
    if (this.vTj == null)
    {
      AppMethodBeat.o(11687);
      return null;
    }
    if ((paramb == null) || (paramb.bitmap == null) || (paramb.bitmap.isRecycled()))
    {
      ab.w("MicroMsg.ChattingBizImageDownloadListener", "onProcessBitmap bitmap is null");
      AppMethodBeat.o(11687);
      return null;
    }
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.ChattingBizImageDownloadListener", "onProcessBitmap url is null");
      AppMethodBeat.o(11687);
      return null;
    }
    try
    {
      if (((paramView instanceof ImageView)) && (this.vTl != null) && (this.vTi == -1) && (this.jWe == -1))
      {
        paramString = (ImageView)paramView;
        this.vTi = paramString.getMeasuredWidth();
        this.jWe = paramString.getMeasuredHeight();
        if ((this.vTi <= 0) || (this.jWe <= 0))
        {
          paramString.getViewTreeObserver().addOnGlobalLayoutListener(new e.1(this, paramString));
          paramb.fHC = true;
          paramb.fHD = true;
          AppMethodBeat.o(11687);
          return null;
        }
      }
      paramView = d.b(paramb.bitmap, this.vTi, this.jWe, true);
      paramString = Bitmap.createScaledBitmap(paramView, this.vTi, this.jWe, true);
      if ((paramString != paramView) && (paramView != null) && (!paramView.isRecycled()))
      {
        ab.i("MicroMsg.ChattingBizImageDownloadListener", "bitmap recycle %s", new Object[] { paramView.toString() });
        paramView.recycle();
      }
      paramView = d.a(paramString, this.vTj);
      if ((paramString != null) && (!paramString.isRecycled()))
      {
        ab.i("MicroMsg.ChattingBizImageDownloadListener", "bitmap recycle %s", new Object[] { paramString.toString() });
        paramString.recycle();
      }
      AppMethodBeat.o(11687);
      return paramView;
    }
    catch (OutOfMemoryError paramString)
    {
      ab.w("MicroMsg.ChattingBizImageDownloadListener", "onProcessBitmap OutOfMemoryError %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(11687);
    }
    return null;
  }
  
  public final void aa(Runnable paramRunnable)
  {
    this.vTl = paramRunnable;
  }
  
  public final void b(String paramString, View paramView, b paramb)
  {
    AppMethodBeat.i(11688);
    if ((this.vTk != null) && (paramb.bitmap != null) && (!paramb.bitmap.isRecycled()))
    {
      paramView = new e.2(this);
      if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
        break label72;
      }
      paramView.run();
    }
    while (paramb.from != 2)
    {
      AppMethodBeat.o(11688);
      return;
      label72:
      al.d(paramView);
    }
    ab.d("MicroMsg.ChattingBizImageDownloadListener", "onImageLoadFinish, url:%s, contentType: %s", new Object[] { paramString, paramb.aZn });
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (q.ahJ())
    {
      bool1 = bool2;
      if (!bo.isNullOrNil(paramb.aZn))
      {
        bool1 = bool2;
        if (q.tv(paramString))
        {
          bool1 = bool2;
          if (paramb.aZn.equals("image/webp")) {
            bool1 = true;
          }
        }
      }
    }
    int i = paramb.status;
    ab.d("MicroMsg.ChattingBizImageDownloadListener", "onImageLoadFinish, isDownloadWebp: %b, status: %d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i) });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(11688);
      return;
      if (bool1)
      {
        h.qsU.idkeyStat(86L, 13L, 1L, false);
        AppMethodBeat.o(11688);
        return;
        h.qsU.idkeyStat(86L, 2L, 1L, false);
        if (bool1)
        {
          h.qsU.idkeyStat(86L, 15L, 1L, false);
          AppMethodBeat.o(11688);
          return;
          if (bool1) {
            h.qsU.idkeyStat(86L, 14L, 1L, false);
          }
        }
      }
    }
  }
  
  public final void tF(String paramString)
  {
    AppMethodBeat.i(11686);
    if (this.vTk != null) {
      this.vTk.onStart();
    }
    ab.d("MicroMsg.ChattingBizImageDownloadListener", "onImageLoadStart, url: %s", new Object[] { paramString });
    h.qsU.idkeyStat(86L, 0L, 1L, false);
    AppMethodBeat.o(11686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.e
 * JD-Core Version:    0.7.0.1
 */