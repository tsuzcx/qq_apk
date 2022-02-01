package com.tencent.mm.plugin.webview.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptReporter;", "", "()V", "bizReportIds", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "", "getBizReportIds", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "report", "", "key", "Lcom/tencent/mm/plugin/webview/webcompt/Key;", "Companion", "webview-sdk_release"})
public final class j
{
  public static final a CSD;
  final ConcurrentLinkedDeque<Long> CSC;
  
  static
  {
    AppMethodBeat.i(82961);
    CSD = new a((byte)0);
    AppMethodBeat.o(82961);
  }
  
  public j()
  {
    AppMethodBeat.i(82960);
    this.CSC = new ConcurrentLinkedDeque();
    AppMethodBeat.o(82960);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(82959);
    k.h(paramb, "key");
    h.wUl.idkeyStat(1147L, paramb.value, 1L, false);
    Iterator localIterator = ((Iterable)this.CSC).iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      h localh = h.wUl;
      k.g(localLong, "it");
      localh.idkeyStat(localLong.longValue(), paramb.value, 1L, false);
    }
    AppMethodBeat.o(82959);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptReporter$Companion;", "", "()V", "ID", "", "webview-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.j
 * JD-Core Version:    0.7.0.1
 */