package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.s;

public final class h
{
  private static final kotlin.l.b.a.b.b.ad<p<g>> ajrb;
  
  static
  {
    AppMethodBeat.i(61058);
    ajrb = new kotlin.l.b.a.b.b.ad("KotlinTypeRefiner");
    AppMethodBeat.o(61058);
  }
  
  public static final List<kotlin.l.b.a.b.m.ad> a(g paramg, Iterable<? extends kotlin.l.b.a.b.m.ad> paramIterable)
  {
    AppMethodBeat.i(191685);
    s.u(paramg, "<this>");
    s.u(paramIterable, "types");
    Collection localCollection = (Collection)new ArrayList(kotlin.a.p.a(paramIterable, 10));
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localCollection.add(paramg.aD((kotlin.l.b.a.b.m.ad)paramIterable.next()));
    }
    paramg = (List)localCollection;
    AppMethodBeat.o(191685);
    return paramg;
  }
  
  public static final kotlin.l.b.a.b.b.ad<p<g>> kAS()
  {
    return ajrb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.l.b.a.b.m.a.h
 * JD-Core Version:    0.7.0.1
 */