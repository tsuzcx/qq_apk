package com.tencent.mm.pluginsdk.ui.applet;

import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import com.tencent.mm.as.a.c.g;
import com.tencent.mm.as.a.d.b;
import com.tencent.mm.as.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;

public final class e
  implements g
{
  private int ift;
  private int sbZ;
  private int sca;
  e.a scb;
  
  public e()
  {
    this(0, 0, 0, null);
  }
  
  public e(int paramInt1, int paramInt2, int paramInt3, e.a parama)
  {
    this.sbZ = paramInt1;
    this.sca = paramInt2;
    this.ift = paramInt3;
    this.scb = parama;
  }
  
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    if (this.sbZ == 0) {
      return null;
    }
    if ((paramb == null) || (paramb.bitmap == null) || (paramb.bitmap.isRecycled()))
    {
      y.w("MicroMsg.ReaderAppUI", "onProcessBitmap bitmap is null");
      return null;
    }
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.ReaderAppUI", "onProcessBitmap url is null");
      return null;
    }
    try
    {
      paramView = c.a(paramb.bitmap, this.sca, this.ift, true);
      paramString = Bitmap.createScaledBitmap(paramView, this.sca, this.ift, true);
      if ((paramString != paramView) && (paramView != null) && (!paramView.isRecycled())) {
        paramView.recycle();
      }
      paramView = c.e(paramString, this.sbZ);
      if ((paramString != null) && (!paramString.isRecycled())) {
        paramString.recycle();
      }
      return paramView;
    }
    catch (OutOfMemoryError paramString)
    {
      y.w("MicroMsg.ReaderAppUI", "onProcessBitmap OutOfMemoryError %s", new Object[] { paramString.getMessage() });
    }
    return null;
  }
  
  public final void b(String paramString, View paramView, b paramb)
  {
    if ((this.scb != null) && (paramb.bitmap != null) && (!paramb.bitmap.isRecycled()))
    {
      paramView = new e.1(this);
      if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
        break label60;
      }
      paramView.run();
    }
    while (paramb.from != 2)
    {
      return;
      label60:
      ai.d(paramView);
    }
    y.d("MicroMsg.ReaderAppUI", "onImageLoadFinish, url:%s, contentType: %s", new Object[] { paramString, paramb.aRN });
    if ((q.OQ()) && (!bk.bl(paramb.aRN)) && (q.mp(paramString)) && (paramb.aRN.equals("image/webp"))) {}
    for (boolean bool = true;; bool = false)
    {
      int i = paramb.status;
      y.d("MicroMsg.ReaderAppUI", "onImageLoadFinish, isDownloadWebp: %b, status: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      switch (i)
      {
      case 2: 
      default: 
        return;
      case 0: 
        if (!bool) {
          break;
        }
        h.nFQ.a(86L, 13L, 1L, false);
        return;
      case 1: 
        h.nFQ.a(86L, 2L, 1L, false);
        if (!bool) {
          break;
        }
        h.nFQ.a(86L, 15L, 1L, false);
        return;
      case 3: 
        if (!bool) {
          break;
        }
        h.nFQ.a(86L, 14L, 1L, false);
        return;
      }
    }
  }
  
  public final void mv(String paramString)
  {
    y.d("MicroMsg.ReaderAppUI", "onImageLoadStart, url: %s", new Object[] { paramString });
    h.nFQ.a(86L, 0L, 1L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.e
 * JD-Core Version:    0.7.0.1
 */