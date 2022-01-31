package com.tencent.mm.roomsdk.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.roomsdk.a.b.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
{
  private f fur;
  protected a yjI;
  protected a yjJ;
  protected a yjK;
  private int yjS;
  
  public d()
  {
    AppMethodBeat.i(80271);
    this.fur = new d.1(this);
    this.yjS = 700;
    AppMethodBeat.o(80271);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(80273);
    ab.i("MicroMsg.RoomWatchCallbackFactory", "dead");
    g.RM();
    g.RK().eHt.b(this.yjS, this.fur);
    AppMethodBeat.o(80273);
  }
  
  public final d dro()
  {
    AppMethodBeat.i(80272);
    ab.i("MicroMsg.RoomWatchCallbackFactory", "alive");
    g.RM();
    g.RK().eHt.a(this.yjS, this.fur);
    AppMethodBeat.o(80272);
    return this;
  }
  
  public final d e(a parama)
  {
    this.yjI = parama;
    return this;
  }
  
  public final d f(a parama)
  {
    this.yjJ = parama;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.d
 * JD-Core Version:    0.7.0.1
 */