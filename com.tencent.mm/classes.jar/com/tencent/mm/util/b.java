package com.tencent.mm.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.n.n;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/util/ExptReportLogic;", "", "()V", "TAG", "", "structLog", "", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "plugin-comm_release"})
public final class b
{
  public static final b LDa;
  private static final String TAG = "MicroMsg.ExptReportLogic";
  
  static
  {
    AppMethodBeat.i(218957);
    LDa = new b();
    TAG = "MicroMsg.ExptReportLogic";
    AppMethodBeat.o(218957);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(218956);
    p.h(parama, "struct");
    String str = TAG;
    int i = parama.getId();
    parama = parama.RD();
    p.g(parama, "struct.toShowString()");
    ae.i(str, "report%s %s", new Object[] { Integer.valueOf(i), n.h(parama, "\r\n", " ", false) });
    AppMethodBeat.o(218956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.util.b
 * JD-Core Version:    0.7.0.1
 */