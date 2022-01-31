package com.tencent.mm.roomsdk.a.c;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.roomsdk.a.b.a;
import com.tencent.mm.sdk.platformtools.y;

public final class d
{
  private f eeo = new d.1(this);
  private int ubD = 700;
  protected a ubs;
  protected a ubt;
  protected a ubu;
  
  public final d cpA()
  {
    y.i("MicroMsg.RoomWatchCallbackFactory", "alive");
    g.DQ();
    g.DO().dJT.a(this.ubD, this.eeo);
    return this;
  }
  
  public final void dead()
  {
    y.i("MicroMsg.RoomWatchCallbackFactory", "dead");
    g.DQ();
    g.DO().dJT.b(this.ubD, this.eeo);
  }
  
  public final d e(a parama)
  {
    this.ubs = parama;
    return this;
  }
  
  public final d f(a parama)
  {
    this.ubt = parama;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.d
 * JD-Core Version:    0.7.0.1
 */