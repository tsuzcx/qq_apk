package com.tencent.pb.common.b;

import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.f;

final class d$1
  implements Runnable
{
  d$1(d paramd) {}
  
  public final void run()
  {
    this.wFB.hXh = true;
    c.d("MicroMsg.Voip", new Object[] { "NETTASK_RECV TimeOut cmd= ", this.wFB.cNR() });
    f.y(20006, 3, "-1104");
    if (this.wFB.wFv != null) {
      this.wFB.wFv.a(2, -1, "time exceed, force to callback", this.wFB);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.d.1
 * JD-Core Version:    0.7.0.1
 */