package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.e.a.b;
import kotlin.l.b.a.b.e.a.l;
import kotlin.l.b.a.b.e.b.c;

public final class y
  implements i
{
  private final c SZH;
  private final kotlin.l.b.a.b.e.b.a TKB;
  final Map<kotlin.l.b.a.b.f.a, a.b> TLy;
  private final b<kotlin.l.b.a.b.f.a, an> TLz;
  
  public y(a.l paraml, c paramc, kotlin.l.b.a.b.e.b.a parama, b<? super kotlin.l.b.a.b.f.a, ? extends an> paramb)
  {
    AppMethodBeat.i(60345);
    this.SZH = paramc;
    this.TKB = parama;
    this.TLz = paramb;
    paraml = paraml.TyS;
    p.g(paraml, "proto.class_List");
    paramc = (Iterable)paraml;
    paraml = (Map)new LinkedHashMap(kotlin.k.j.mZ(ae.atJ(kotlin.a.j.a(paramc, 10)), 16));
    paramc = paramc.iterator();
    while (paramc.hasNext())
    {
      parama = paramc.next();
      paramb = (a.b)parama;
      c localc = this.SZH;
      p.g(paramb, "klass");
      paraml.put(x.a(localc, paramb.Txs), parama);
    }
    this.TLy = paraml;
    AppMethodBeat.o(60345);
  }
  
  public final h d(kotlin.l.b.a.b.f.a parama)
  {
    AppMethodBeat.i(60344);
    p.h(parama, "classId");
    a.b localb = (a.b)this.TLy.get(parama);
    if (localb == null)
    {
      AppMethodBeat.o(60344);
      return null;
    }
    parama = new h(this.SZH, localb, this.TKB, (an)this.TLz.invoke(parama));
    AppMethodBeat.o(60344);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.y
 * JD-Core Version:    0.7.0.1
 */