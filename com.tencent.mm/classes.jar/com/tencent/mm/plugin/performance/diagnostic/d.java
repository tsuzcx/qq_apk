package com.tencent.mm.plugin.performance.diagnostic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.plugin.performance.a.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class d
{
  private static final String GLV;
  private static final IListener<fw> GLW;
  private static final MultiProcessMMKV cQO;
  
  static
  {
    AppMethodBeat.i(200603);
    cQO = MultiProcessMMKV.getMMKV("diagnostic_storage");
    StringBuilder localStringBuilder = new StringBuilder();
    a locala = a.GLp;
    GLV = a.fnm() + ".$token";
    GLW = new IListener() {};
    AppMethodBeat.o(200603);
  }
  
  public static void alive()
  {
    AppMethodBeat.i(200601);
    if (!MMApplicationContext.isMainProcess())
    {
      AppMethodBeat.o(200601);
      return;
    }
    GLW.alive();
    AppMethodBeat.o(200601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.d
 * JD-Core Version:    0.7.0.1
 */