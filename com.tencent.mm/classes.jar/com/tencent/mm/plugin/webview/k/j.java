package com.tencent.mm.plugin.webview.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptReporter;", "", "()V", "bizReportIds", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "", "getBizReportIds", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "report", "", "key", "Lcom/tencent/mm/plugin/webview/webcompt/Key;", "Companion", "webview-sdk_release"})
public final class j
{
  public static final a EwE;
  final ConcurrentLinkedDeque<Long> EwD;
  
  static
  {
    AppMethodBeat.i(82961);
    EwE = new a((byte)0);
    AppMethodBeat.o(82961);
  }
  
  public j()
  {
    AppMethodBeat.i(82960);
    this.EwD = new ConcurrentLinkedDeque();
    AppMethodBeat.o(82960);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(82959);
    p.h(paramb, "key");
    g.yhR.idkeyStat(1147L, paramb.value, 1L, false);
    Iterator localIterator = ((Iterable)this.EwD).iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      g localg = g.yhR;
      p.g(localLong, "it");
      localg.idkeyStat(localLong.longValue(), paramb.value, 1L, false);
    }
    AppMethodBeat.o(82959);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptReporter$Companion;", "", "()V", "ID", "", "webview-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.j
 * JD-Core Version:    0.7.0.1
 */