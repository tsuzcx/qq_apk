package com.tencent.mm.plugin.webview.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptReporter;", "", "()V", "bizReportIds", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "", "getBizReportIds", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "report", "", "key", "Lcom/tencent/mm/plugin/webview/webcompt/Key;", "Companion", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final a Xwv;
  final ConcurrentLinkedDeque<Long> Xww;
  
  static
  {
    AppMethodBeat.i(82961);
    Xwv = new a((byte)0);
    AppMethodBeat.o(82961);
  }
  
  public i()
  {
    AppMethodBeat.i(82960);
    this.Xww = new ConcurrentLinkedDeque();
    AppMethodBeat.o(82960);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(82959);
    s.u(paramb, "key");
    h.OAn.idkeyStat(1147L, paramb.value, 1L, false);
    Object localObject2 = (Iterable)this.Xww;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    label120:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      Long localLong = (Long)localObject3;
      s.s(localLong, "it");
      if (localLong.longValue() > 0L) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label120;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Long)((Iterator)localObject1).next();
      localObject3 = h.OAn;
      s.s(localObject2, "it");
      ((h)localObject3).idkeyStat(((Long)localObject2).longValue(), paramb.value, 1L, false);
    }
    AppMethodBeat.o(82959);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/webcompt/WebComptReporter$Companion;", "", "()V", "ID", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.l.i
 * JD-Core Version:    0.7.0.1
 */