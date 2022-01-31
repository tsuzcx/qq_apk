package com.tencent.mm.vending.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.f.a;

final class Vending$7
  implements Vending.c.a<_Index>
{
  Vending$7(Vending paramVending) {}
  
  public final void cJ(_Index param_Index)
  {
    AppMethodBeat.i(126168);
    Vending.i locali = this.ANV.getLock(param_Index);
    boolean bool = Vending.a(this.ANV, locali, param_Index);
    if (locali.g)
    {
      a.d("Vending", "This lock is defer to return %s %s", new Object[] { locali, param_Index });
      AppMethodBeat.o(126168);
      return;
    }
    if (bool)
    {
      AppMethodBeat.o(126168);
      return;
    }
    Vending.a(this.ANV, locali);
    AppMethodBeat.o(126168);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(126169);
    this.ANV.loaderClear();
    Vending.a(this.ANV);
    AppMethodBeat.o(126169);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vending.base.Vending.7
 * JD-Core Version:    0.7.0.1
 */