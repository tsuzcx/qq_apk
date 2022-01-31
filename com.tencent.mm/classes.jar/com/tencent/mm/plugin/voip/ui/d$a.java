package com.tencent.mm.plugin.voip.ui;

import android.graphics.Bitmap;
import android.widget.RelativeLayout;
import com.tencent.mm.ag.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;

public final class d$a
  implements Runnable
{
  public d$a(d paramd) {}
  
  public final void run()
  {
    y.i("MicroMsg.VoipBaseFragment", "try load blur bitmap,timestamp: " + System.currentTimeMillis());
    Bitmap localBitmap2 = b.a(this.pWZ.djD, false, -1);
    if ((localBitmap2 == null) || (this.pWZ.pWQ == null)) {
      return;
    }
    int i = 0;
    while (((this.pWZ.pWQ.getHeight() == 0) || (this.pWZ.pWQ.getWidth() == 0)) && (i < 10)) {
      try
      {
        Thread.sleep(300L);
        i += 1;
      }
      catch (InterruptedException localInterruptedException)
      {
        y.e("MicroMsg.VoipBaseFragment", "wait voip initialize interrupted");
        return;
      }
    }
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2.getHeight() <= localBitmap2.getWidth())
    {
      localBitmap1 = localBitmap2;
      if (localBitmap2.getHeight() / 5 > 0)
      {
        localBitmap1 = localBitmap2;
        if ((int)(localBitmap2.getHeight() * 0.6D) > 0) {
          localBitmap1 = Bitmap.createBitmap(localBitmap2, localBitmap2.getWidth() / 5, localBitmap2.getHeight() / 5, (int)(localBitmap2.getHeight() * 0.6D), (int)(localBitmap2.getHeight() * 0.6D), null, false);
        }
      }
    }
    float f = 1.0F * this.pWZ.pWQ.getHeight() / this.pWZ.pWQ.getWidth();
    i = (int)(localBitmap1.getHeight() / f);
    localBitmap1 = c.a(localBitmap1, localBitmap1.getHeight(), i, true, false);
    if (localBitmap1 == null)
    {
      y.e("MicroMsg.VoipBaseFragment", "extract Thumb Nail for blur background failed");
      return;
    }
    try
    {
      localBitmap1 = c.f(localBitmap1, 20);
      y.i("MicroMsg.VoipBaseFragment", "blur ok, timestamp: " + System.currentTimeMillis());
      this.pWZ.hcZ.post(new d.a.1(this, localBitmap1));
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.VoipBaseFragment", "fastblur failed: " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.d.a
 * JD-Core Version:    0.7.0.1
 */