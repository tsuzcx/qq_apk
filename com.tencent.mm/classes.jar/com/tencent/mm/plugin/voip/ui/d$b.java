package com.tencent.mm.plugin.voip.ui;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;

public final class d$b
  implements Runnable
{
  public d$b(d paramd) {}
  
  public final void run()
  {
    y.i("MicroMsg.VoipBaseFragment", "try create blur bitmap,timestamp: " + System.currentTimeMillis());
    Bitmap localBitmap = c.EX(a.a.voip_video_called_blur_background);
    y.i("MicroMsg.VoipBaseFragment", "blur transparent ok, timestamp: " + System.currentTimeMillis());
    this.pWZ.hcZ.post(new d.b.1(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.d.b
 * JD-Core Version:    0.7.0.1
 */