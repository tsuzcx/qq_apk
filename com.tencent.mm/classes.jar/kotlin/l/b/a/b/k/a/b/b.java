package kotlin.l.b.a.b.k.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.b.ab;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l.b.a.b.b.a.c;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.a.g.b;
import kotlin.l.b.a.b.l.f;
import kotlin.l.b.a.b.l.i;
import kotlin.l.b.a.b.l.j;
import kotlin.l.n;

public class b
  implements g
{
  private final f abov;
  
  static
  {
    AppMethodBeat.i(60390);
    cMt = new n[] { (n)ab.a(new z(ab.bO(b.class), "annotations", "getAnnotations()Ljava/util/List;")) };
    AppMethodBeat.o(60390);
  }
  
  public b(j paramj, a<? extends List<? extends c>> parama)
  {
    AppMethodBeat.i(60394);
    this.abov = paramj.av(parama);
    AppMethodBeat.o(60394);
  }
  
  private final List<c> iPz()
  {
    AppMethodBeat.i(60391);
    List localList = (List)i.a(this.abov, cMt[0]);
    AppMethodBeat.o(60391);
    return localList;
  }
  
  public final c g(kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(60395);
    p.k(paramb, "fqName");
    paramb = g.b.a(this, paramb);
    AppMethodBeat.o(60395);
    return paramb;
  }
  
  public final boolean h(kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(60396);
    p.k(paramb, "fqName");
    boolean bool = g.b.b(this, paramb);
    AppMethodBeat.o(60396);
    return bool;
  }
  
  public boolean isEmpty()
  {
    AppMethodBeat.i(60392);
    boolean bool = iPz().isEmpty();
    AppMethodBeat.o(60392);
    return bool;
  }
  
  public Iterator<c> iterator()
  {
    AppMethodBeat.i(60393);
    Iterator localIterator = iPz().iterator();
    AppMethodBeat.o(60393);
    return localIterator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.b.b
 * JD-Core Version:    0.7.0.1
 */