package com.tencent.mm.plugin.performance.diagnostic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.plugin.performance.a.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class b
{
  private static final String ASB;
  private static final IListener<fp> ASC;
  private static final MultiProcessMMKV cQe;
  
  static
  {
    AppMethodBeat.i(201030);
    cQe = MultiProcessMMKV.getMMKV("diagnostic_storage");
    StringBuilder localStringBuilder = new StringBuilder();
    a locala = a.ASb;
    ASB = a.eBC() + ".$token";
    ASC = new IListener() {};
    AppMethodBeat.o(201030);
  }
  
  public static void alive()
  {
    AppMethodBeat.i(201029);
    if (!MMApplicationContext.isMainProcess())
    {
      AppMethodBeat.o(201029);
      return;
    }
    ASC.alive();
    AppMethodBeat.o(201029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.b
 * JD-Core Version:    0.7.0.1
 */