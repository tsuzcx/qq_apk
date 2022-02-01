package d.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.g.a.b;
import d.g.b.p;
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
  private final d.l.b.a.b.e.b.a NVF;
  final Map<d.l.b.a.b.f.a, a.b> NWC;
  private final b<d.l.b.a.b.f.a, an> NWD;
  private final c NjZ;
  
  public y(a.l paraml, c paramc, d.l.b.a.b.e.b.a parama, b<? super d.l.b.a.b.f.a, ? extends an> paramb)
  {
    AppMethodBeat.i(60345);
    this.NjZ = paramc;
    this.NVF = parama;
    this.NWD = paramb;
    paraml = paraml.NJq;
    p.g(paraml, "proto.class_List");
    paramc = (Iterable)paraml;
    paraml = (Map)new LinkedHashMap(d.k.j.lw(ae.ajS(d.a.j.a(paramc, 10)), 16));
    paramc = paramc.iterator();
    while (paramc.hasNext())
    {
      parama = paramc.next();
      paramb = (a.b)parama;
      c localc = this.NjZ;
      p.g(paramb, "klass");
      paraml.put(x.a(localc, paramb.NHQ), parama);
    }
    this.NWC = paraml;
    AppMethodBeat.o(60345);
  }
  
  public final h d(d.l.b.a.b.f.a parama)
  {
    AppMethodBeat.i(60344);
    p.h(parama, "classId");
    a.b localb = (a.b)this.NWC.get(parama);
    if (localb == null)
    {
      AppMethodBeat.o(60344);
      return null;
    }
    parama = new h(this.NjZ, localb, this.NVF, (an)this.NWD.invoke(parama));
    AppMethodBeat.o(60344);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.k.a.y
 * JD-Core Version:    0.7.0.1
 */