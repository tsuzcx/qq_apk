package com.tencent.mm.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/util/ExptReportLogic;", "", "()V", "TAG", "", "structLog", "", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private static final String TAG;
  public static final c agsX;
  
  static
  {
    AppMethodBeat.i(233986);
    agsX = new c();
    TAG = "MicroMsg.ExptReportLogic";
    AppMethodBeat.o(233986);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(233978);
    s.u(parama, "struct");
    String str = TAG;
    int i = parama.getId();
    parama = parama.aIF();
    s.s(parama, "struct.toShowString()");
    Log.i(str, "report%s %s", new Object[] { Integer.valueOf(i), n.m(parama, "\r\n", " ", false) });
    AppMethodBeat.o(233978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.util.c
 * JD-Core Version:    0.7.0.1
 */