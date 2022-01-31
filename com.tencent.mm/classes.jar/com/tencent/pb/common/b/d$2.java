package com.tencent.pb.common.b;

import com.tencent.pb.common.c.c;

final class d$2
  implements Runnable
{
  d$2(d paramd, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    if (this.wFB.hXh) {
      c.d("MicroMsg.Voip", new Object[] { this.wFB.TAG2, "onResp netscene already canceled, cmd:" + this.wFB.wFy });
    }
    while (this.wFB.wFv == null) {
      return;
    }
    this.wFB.wFv.a(this.wFC, this.wFD, "", this.wFB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.d.2
 * JD-Core Version:    0.7.0.1
 */