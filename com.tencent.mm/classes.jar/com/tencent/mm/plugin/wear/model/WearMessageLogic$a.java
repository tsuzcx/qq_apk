package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.e.q;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.sdk.platformtools.ab;

final class WearMessageLogic$a
  extends d
{
  public int cnU;
  public int fOC;
  public int uHh;
  public byte[] uHi;
  
  private WearMessageLogic$a(WearMessageLogic paramWearMessageLogic) {}
  
  public final void execute()
  {
    AppMethodBeat.i(26321);
    ab.i("MicroMsg.Wear.WearMessageLogic", "handle message %s", new Object[] { toString() });
    com.tencent.mm.plugin.wear.model.e.a locala = a.cYy().uGA.IV(this.fOC);
    if (locala != null) {
      locala.d(this.uHh, this.cnU, this.fOC, this.uHi);
    }
    AppMethodBeat.o(26321);
  }
  
  public final String getName()
  {
    return "HttpMessageTask";
  }
  
  public final String toString()
  {
    AppMethodBeat.i(26322);
    String str = String.format("connectType=%d funId=%d sessionId=%d", new Object[] { Integer.valueOf(this.uHh), Integer.valueOf(this.fOC), Integer.valueOf(this.cnU) });
    AppMethodBeat.o(26322);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.WearMessageLogic.a
 * JD-Core Version:    0.7.0.1
 */