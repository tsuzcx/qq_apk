package kotlin.l.b.a.b.k.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.y;
import kotlin.l.b.a.b.b.a.c;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.a.g.b;
import kotlin.l.b.a.b.l.f;
import kotlin.l.b.a.b.l.i;
import kotlin.l.b.a.b.l.j;
import kotlin.l.k;

public class b
  implements g
{
  private final f TLT;
  
  static
  {
    AppMethodBeat.i(60390);
    cLI = new k[] { (k)aa.a(new y(aa.bp(b.class), "annotations", "getAnnotations()Ljava/util/List;")) };
    AppMethodBeat.o(60390);
  }
  
  public b(j paramj, a<? extends List<? extends c>> parama)
  {
    AppMethodBeat.i(60394);
    this.TLT = paramj.al(parama);
    AppMethodBeat.o(60394);
  }
  
  private final List<c> hLh()
  {
    AppMethodBeat.i(60391);
    List localList = (List)i.a(this.TLT, cLI[0]);
    AppMethodBeat.o(60391);
    return localList;
  }
  
  public final c g(kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(60395);
    p.h(paramb, "fqName");
    paramb = g.b.a(this, paramb);
    AppMethodBeat.o(60395);
    return paramb;
  }
  
  public final boolean h(kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(60396);
    p.h(paramb, "fqName");
    boolean bool = g.b.b(this, paramb);
    AppMethodBeat.o(60396);
    return bool;
  }
  
  public boolean isEmpty()
  {
    AppMethodBeat.i(60392);
    boolean bool = hLh().isEmpty();
    AppMethodBeat.o(60392);
    return bool;
  }
  
  public Iterator<c> iterator()
  {
    AppMethodBeat.i(60393);
    Iterator localIterator = hLh().iterator();
    AppMethodBeat.o(60393);
    return localIterator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.b.b
 * JD-Core Version:    0.7.0.1
 */