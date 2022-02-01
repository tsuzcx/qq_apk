package com.tencent.mm.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/util/ExptReportLogic;", "", "()V", "TAG", "", "structLog", "", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "plugin-comm_release"})
public final class b
{
  public static final b QYu;
  private static final String TAG = "MicroMsg.ExptReportLogic";
  
  static
  {
    AppMethodBeat.i(223482);
    QYu = new b();
    TAG = "MicroMsg.ExptReportLogic";
    AppMethodBeat.o(223482);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(223481);
    p.h(parama, "struct");
    String str = TAG;
    int i = parama.getId();
    parama = parama.abW();
    p.g(parama, "struct.toShowString()");
    Log.i(str, "report%s %s", new Object[] { Integer.valueOf(i), n.j(parama, "\r\n", " ", false) });
    AppMethodBeat.o(223481);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.util.b
 * JD-Core Version:    0.7.0.1
 */