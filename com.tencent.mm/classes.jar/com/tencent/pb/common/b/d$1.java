package com.tencent.pb.common.b;

import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.f;

final class d$1
  implements Runnable
{
  d$1(d paramd) {}
  
  public final void run()
  {
    this.Bdb.jRa = true;
    c.d("MicroMsg.Voip", new Object[] { "NETTASK_RECV TimeOut cmd= ", this.Bdb.dTD() });
    f.F(20006, 3, "-1104");
    if (this.Bdb.BcW != null) {
      this.Bdb.BcW.a(2, -1, "time exceed, force to callback", this.Bdb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.d.1
 * JD-Core Version:    0.7.0.1
 */