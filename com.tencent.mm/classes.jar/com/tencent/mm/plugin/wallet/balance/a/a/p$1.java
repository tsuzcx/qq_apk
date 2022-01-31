package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Vector;

final class p$1
  implements Runnable
{
  p$1(p paramp) {}
  
  public final void run()
  {
    AppMethodBeat.i(45246);
    Iterator localIterator = p.a(this.tMC).iterator();
    while (localIterator.hasNext()) {
      ((p.a)localIterator.next()).cQP();
    }
    AppMethodBeat.o(45246);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.p.1
 * JD-Core Version:    0.7.0.1
 */