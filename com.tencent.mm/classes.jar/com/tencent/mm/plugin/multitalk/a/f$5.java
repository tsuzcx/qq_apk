package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.compatible.util.b;
import com.tencent.mm.plugin.voip.video.i;

final class f$5
  implements Runnable
{
  f$5(f paramf) {}
  
  public final void run()
  {
    this.mtZ.lpn.stop();
    this.mtZ.mtA = false;
    this.mtZ.eLi.zE();
    com.tencent.mm.compatible.b.f.yi().setSpeakerphoneOn(this.mtZ.mtB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.f.5
 * JD-Core Version:    0.7.0.1
 */