package d.l.b.a.b.k.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.u;
import d.g.b.w;
import d.l.b.a.b.b.a.c;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.b.a.g.b;
import d.l.b.a.b.l.f;
import d.l.b.a.b.l.h;
import d.l.b.a.b.l.i;
import java.util.Iterator;
import java.util.List;

public class b
  implements g
{
  private final f JVC;
  
  static
  {
    AppMethodBeat.i(60390);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(b.class), "annotations", "getAnnotations()Ljava/util/List;")) };
    AppMethodBeat.o(60390);
  }
  
  public b(i parami, a<? extends List<? extends c>> parama)
  {
    AppMethodBeat.i(60394);
    this.JVC = parami.H(parama);
    AppMethodBeat.o(60394);
  }
  
  private final List<c> fJA()
  {
    AppMethodBeat.i(60391);
    List localList = (List)h.a(this.JVC, $$delegatedProperties[0]);
    AppMethodBeat.o(60391);
    return localList;
  }
  
  public final c g(d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(60395);
    d.g.b.k.h(paramb, "fqName");
    paramb = g.b.a(this, paramb);
    AppMethodBeat.o(60395);
    return paramb;
  }
  
  public final boolean h(d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(60396);
    d.g.b.k.h(paramb, "fqName");
    boolean bool = g.b.b(this, paramb);
    AppMethodBeat.o(60396);
    return bool;
  }
  
  public boolean isEmpty()
  {
    AppMethodBeat.i(60392);
    boolean bool = fJA().isEmpty();
    AppMethodBeat.o(60392);
    return bool;
  }
  
  public Iterator<c> iterator()
  {
    AppMethodBeat.i(60393);
    Iterator localIterator = fJA().iterator();
    AppMethodBeat.o(60393);
    return localIterator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     d.l.b.a.b.k.a.b.b
 * JD-Core Version:    0.7.0.1
 */