package com.tencent.mm.plugin.webview.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptReporter;", "", "()V", "bizReportIds", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "", "getBizReportIds", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "report", "", "key", "Lcom/tencent/mm/plugin/webview/webcompt/Key;", "Companion", "webview-sdk_release"})
public final class j
{
  public static final a EPa;
  final ConcurrentLinkedDeque<Long> EOZ;
  
  static
  {
    AppMethodBeat.i(82961);
    EPa = new a((byte)0);
    AppMethodBeat.o(82961);
  }
  
  public j()
  {
    AppMethodBeat.i(82960);
    this.EOZ = new ConcurrentLinkedDeque();
    AppMethodBeat.o(82960);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(82959);
    p.h(paramb, "key");
    g.yxI.idkeyStat(1147L, paramb.value, 1L, false);
    Iterator localIterator = ((Iterable)this.EOZ).iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      g localg = g.yxI;
      p.g(localLong, "it");
      localg.idkeyStat(localLong.longValue(), paramb.value, 1L, false);
    }
    AppMethodBeat.o(82959);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptReporter$Companion;", "", "()V", "ID", "", "webview-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.j
 * JD-Core Version:    0.7.0.1
 */