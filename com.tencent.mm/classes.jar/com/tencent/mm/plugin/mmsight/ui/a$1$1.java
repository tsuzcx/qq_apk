package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Bitmap;
import com.tencent.mm.api.m;
import com.tencent.mm.c.g;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class a$1$1
  implements m
{
  a$1$1(a.1 param1) {}
  
  public final void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    y.i("MicroMsg.MMSightVideoEditor", "photoEditor onSuccess: %s isNever：%s", new Object[] { paramBitmap, Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        paramBitmap.recycle();
      }
      if ((this.mpx.mpw.mpn != null) && (!this.mpx.mpw.mpp)) {
        if ((this.mpx.mpw.mph > 0) && (this.mpx.mpw.mpf > 0) && (this.mpx.mpw.mph <= this.mpx.mpw.mpf)) {
          ai.d(new a.1.1.1(this));
        }
      }
    }
    while (paramBitmap == null)
    {
      do
      {
        return;
        this.mpx.mpw.bIW = g.bQ(this.mpx.mpw.videoPath);
        ai.d(new a.1.1.2(this));
        return;
      } while (!this.mpx.mpw.mpp);
      ai.d(new a.1.1.3(this));
      return;
    }
    ai.d(new a.1.1.4(this, paramBitmap));
  }
  
  public final void b(Exception paramException)
  {
    y.e("MicroMsg.MMSightVideoEditor", "photoEditor onError: %s", new Object[] { paramException });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.a.1.1
 * JD-Core Version:    0.7.0.1
 */