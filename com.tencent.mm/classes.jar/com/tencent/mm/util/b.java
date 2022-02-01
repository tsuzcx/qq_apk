package com.tencent.mm.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.n.n;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/util/ExptReportLogic;", "", "()V", "TAG", "", "structLog", "", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "plugin-comm_release"})
public final class b
{
  public static final b Lgy;
  private static final String TAG = "MicroMsg.ExptReportLogic";
  
  static
  {
    AppMethodBeat.i(195178);
    Lgy = new b();
    TAG = "MicroMsg.ExptReportLogic";
    AppMethodBeat.o(195178);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(195177);
    p.h(parama, "struct");
    String str = TAG;
    int i = parama.getId();
    parama = parama.RE();
    p.g(parama, "struct.toShowString()");
    ad.i(str, "report%s %s", new Object[] { Integer.valueOf(i), n.h(parama, "\r\n", " ", false) });
    AppMethodBeat.o(195177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.util.b
 * JD-Core Version:    0.7.0.1
 */