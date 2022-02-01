package d.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.a.j;
import d.g.a.b;
import d.g.b.k;
import d.l.b.a.b.b.an;
import d.l.b.a.b.e.a.b;
import d.l.b.a.b.e.a.l;
import d.l.b.a.b.e.b.c;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class y
  implements i
{
  private final c KVO;
  private final d.l.b.a.b.e.b.a LHA;
  final Map<d.l.b.a.b.f.a, a.b> LIx;
  private final b<d.l.b.a.b.f.a, an> LIy;
  
  public y(a.l paraml, c paramc, d.l.b.a.b.e.b.a parama, b<? super d.l.b.a.b.f.a, ? extends an> paramb)
  {
    AppMethodBeat.i(60345);
    this.KVO = paramc;
    this.LHA = parama;
    this.LIy = paramb;
    paraml = paraml.Lvn;
    k.g(paraml, "proto.class_List");
    paramc = (Iterable)paraml;
    paraml = (Map)new LinkedHashMap(d.k.h.la(ae.agH(j.a(paramc, 10)), 16));
    paramc = paramc.iterator();
    while (paramc.hasNext())
    {
      parama = paramc.next();
      paramb = (a.b)parama;
      c localc = this.KVO;
      k.g(paramb, "klass");
      paraml.put(x.a(localc, paramb.LtN), parama);
    }
    this.LIx = paraml;
    AppMethodBeat.o(60345);
  }
  
  public final h d(d.l.b.a.b.f.a parama)
  {
    AppMethodBeat.i(60344);
    k.h(parama, "classId");
    a.b localb = (a.b)this.LIx.get(parama);
    if (localb == null)
    {
      AppMethodBeat.o(60344);
      return null;
    }
    parama = new h(this.KVO, localb, this.LHA, (an)this.LIy.ay(parama));
    AppMethodBeat.o(60344);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.k.a.y
 * JD-Core Version:    0.7.0.1
 */