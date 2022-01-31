package com.tencent.mm.plugin.soter.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.b.a;
import com.tencent.soter.a.b.e;
import com.tencent.soter.core.c.j;

final class b$3$1
  implements Runnable
{
  b$3$1(b.3 param3, a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(73866);
    j localj = (j)this.sod.BmW;
    this.soe.soc.soh.errCode = 0;
    this.soe.soc.soh.errMsg = "OK";
    this.soe.soc.soh.sop = 1;
    this.soe.soc.soh.cGu = localj.BmG;
    this.soe.soc.soh.soq = localj.signature;
    this.soe.soc.cxW();
    AppMethodBeat.o(73866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.c.b.3.1
 * JD-Core Version:    0.7.0.1
 */