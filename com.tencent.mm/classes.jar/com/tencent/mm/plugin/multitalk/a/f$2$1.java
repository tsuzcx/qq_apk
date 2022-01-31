package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.sdk.platformtools.y;

final class f$2$1
  implements Runnable
{
  f$2$1(f.2 param2) {}
  
  public final void run()
  {
    j.a locala1 = j.blx();
    if (locala1 != this.mua.mtZ.mtR)
    {
      j.a locala2 = this.mua.mtZ.mtR;
      this.mua.mtZ.mtR = locala1;
      y.i("MicroMsg.MT.MultiTalkManager", "steve: network change: %s -> %s", new Object[] { locala2.name(), this.mua.mtZ.mtR.name() });
      this.mua.mtZ.up(this.mua.mtZ.mtD);
      if (this.mua.mtZ.mtQ != null) {
        this.mua.mtZ.mtQ.a(this.mua.mtZ.mtR);
      }
      return;
    }
    y.i("MicroMsg.MT.MultiTalkManager", "network not change: %s", new Object[] { this.mua.mtZ.mtR.name() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.f.2.1
 * JD-Core Version:    0.7.0.1
 */