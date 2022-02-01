package com.tencent.mm.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/util/ExptReportLogic;", "", "()V", "TAG", "", "structLog", "", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "plugin-comm_release"})
public final class c
{
  private static final String TAG = "MicroMsg.ExptReportLogic";
  public static final c Yyz;
  
  static
  {
    AppMethodBeat.i(193318);
    Yyz = new c();
    TAG = "MicroMsg.ExptReportLogic";
    AppMethodBeat.o(193318);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(193315);
    p.k(parama, "struct");
    String str = TAG;
    int i = parama.getId();
    parama = parama.agI();
    p.j(parama, "struct.toShowString()");
    Log.i(str, "report%s %s", new Object[] { Integer.valueOf(i), n.l(parama, "\r\n", " ", false) });
    AppMethodBeat.o(193315);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.util.c
 * JD-Core Version:    0.7.0.1
 */