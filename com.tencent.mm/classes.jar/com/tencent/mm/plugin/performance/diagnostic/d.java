package com.tencent.mm.plugin.performance.diagnostic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.gh;
import com.tencent.mm.plugin.performance.a.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class d
{
  private static final String MIR;
  private static final IListener<gh> MIS;
  private static final MultiProcessMMKV eMf;
  
  static
  {
    AppMethodBeat.i(300901);
    eMf = MultiProcessMMKV.getMMKV("diagnostic_storage");
    StringBuilder localStringBuilder = new StringBuilder();
    a locala = a.MIk;
    MIR = a.gxZ() + ".$token";
    MIS = new DiagnosticPush.1(f.hfK);
    AppMethodBeat.o(300901);
  }
  
  public static void alive()
  {
    AppMethodBeat.i(300885);
    if (!MMApplicationContext.isMainProcess())
    {
      AppMethodBeat.o(300885);
      return;
    }
    MIS.alive();
    AppMethodBeat.o(300885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.d
 * JD-Core Version:    0.7.0.1
 */