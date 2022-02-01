package com.tencent.mm.plugin.multitalk.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.b;
import kotlin.g.b.u;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/utils/MultitalkFeatureReportHelper$StatusHolder;", "", "()V", "list", "", "Lkotlin/Pair;", "", "appendEnd", "", "appendStart", "close", "reset", "statusStr", "", "totalTimeSec", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d$a
{
  private final List<r<Long, Long>> list;
  
  public d$a()
  {
    AppMethodBeat.i(284592);
    this.list = ((List)new ArrayList());
    AppMethodBeat.o(284592);
  }
  
  public final void close()
  {
    AppMethodBeat.i(284608);
    r localr = (r)p.oN(this.list);
    if ((localr != null) && (((Number)localr.bsD).longValue() == 0L)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        giP();
      }
      AppMethodBeat.o(284608);
      return;
    }
  }
  
  public final void giO()
  {
    AppMethodBeat.i(284594);
    this.list.add(new r(Long.valueOf(System.currentTimeMillis()), Long.valueOf(0L)));
    AppMethodBeat.o(284594);
  }
  
  public final void giP()
  {
    AppMethodBeat.i(284597);
    r localr = (r)p.oN(this.list);
    if (localr != null) {
      this.list.set(p.oE(this.list), new r(localr.bsC, Long.valueOf(System.currentTimeMillis())));
    }
    AppMethodBeat.o(284597);
  }
  
  public final long giQ()
  {
    AppMethodBeat.i(284604);
    Iterator localIterator = ((Iterable)this.list).iterator();
    long l1 = 0L;
    if (localIterator.hasNext())
    {
      r localr = (r)localIterator.next();
      if (((Number)localr.bsD).longValue() > ((Number)localr.bsC).longValue()) {}
      for (long l2 = ((Number)localr.bsD).longValue() - ((Number)localr.bsC).longValue();; l2 = 0L)
      {
        l1 = l2 + l1;
        break;
      }
    }
    l1 /= 1000L;
    AppMethodBeat.o(284604);
    return l1;
  }
  
  public final String giR()
  {
    AppMethodBeat.i(284611);
    String str = p.a((Iterable)this.list, (CharSequence)";", null, null, 0, null, (b)a.LAG, 30);
    AppMethodBeat.o(284611);
    return str;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(284601);
    this.list.clear();
    AppMethodBeat.o(284601);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lkotlin/Pair;", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<r<? extends Long, ? extends Long>, CharSequence>
  {
    public static final a LAG;
    
    static
    {
      AppMethodBeat.i(284596);
      LAG = new a();
      AppMethodBeat.o(284596);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.e.d.a
 * JD-Core Version:    0.7.0.1
 */