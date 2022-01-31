package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

final class ag$2
  implements Runnable
{
  ag$2(int paramInt, Map paramMap) {}
  
  public final void run()
  {
    AppMethodBeat.i(46918);
    if (ag.ais() != null)
    {
      Iterator localIterator = ag.ais().iterator();
      while (localIterator.hasNext())
      {
        n localn = (n)localIterator.next();
        if (localn != null) {
          localn.yO(this.uls);
        }
      }
    }
    AppMethodBeat.o(46918);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ag.2
 * JD-Core Version:    0.7.0.1
 */