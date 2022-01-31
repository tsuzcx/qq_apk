package com.tencent.pb.common.b;

import com.tencent.pb.common.c.c;

final class d$2
  implements Runnable
{
  d$2(d paramd, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    if (this.Bdb.jRa) {
      c.d("MicroMsg.Voip", new Object[] { this.Bdb.TAG2, "onResp netscene already canceled, cmd:" + this.Bdb.BcZ });
    }
    while (this.Bdb.BcW == null) {
      return;
    }
    this.Bdb.BcW.a(this.Bdc, this.Bdd, "", this.Bdb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.pb.common.b.d.2
 * JD-Core Version:    0.7.0.1
 */