package com.tencent.mm.plugin.subapp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class a$a$1
  implements ap.a
{
  a$a$1(a.a parama, int paramInt) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(25158);
    if (this.sWj.sVZ)
    {
      AppMethodBeat.o(25158);
      return false;
    }
    ab.d("MicroMsg.SubCoreSubapp", "timmer get, delay:%d", new Object[] { Integer.valueOf(this.sWi) });
    this.sWj.a(a.a.a.sWn);
    AppMethodBeat.o(25158);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.a.a.1
 * JD-Core Version:    0.7.0.1
 */