package kotlin.l.b.a.b.k.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.b.af;
import kotlin.g.b.ag;
import kotlin.g.b.ai;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.a.g.b;
import kotlin.l.b.a.b.l.h;
import kotlin.l.b.a.b.l.l;
import kotlin.l.b.a.b.l.m;
import kotlin.l.e;
import kotlin.l.o;

public class b
  implements g
{
  private final h ajne;
  
  static
  {
    AppMethodBeat.i(60390);
    aYe = new o[] { (o)ai.a((af)new ag((e)ai.cz(b.class), "annotations", "getAnnotations()Ljava/util/List;")) };
    AppMethodBeat.o(60390);
  }
  
  public b(m paramm, a<? extends List<? extends kotlin.l.b.a.b.b.a.c>> parama)
  {
    AppMethodBeat.i(60394);
    this.ajne = paramm.cq(parama);
    AppMethodBeat.o(60394);
  }
  
  private final List<kotlin.l.b.a.b.b.a.c> kAb()
  {
    AppMethodBeat.i(60391);
    List localList = (List)l.a(this.ajne, aYe[0]);
    AppMethodBeat.o(60391);
    return localList;
  }
  
  public final kotlin.l.b.a.b.b.a.c h(kotlin.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(60395);
    paramc = g.b.a(this, paramc);
    AppMethodBeat.o(60395);
    return paramc;
  }
  
  public final boolean i(kotlin.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(60396);
    boolean bool = g.b.b(this, paramc);
    AppMethodBeat.o(60396);
    return bool;
  }
  
  public boolean isEmpty()
  {
    AppMethodBeat.i(60392);
    boolean bool = kAb().isEmpty();
    AppMethodBeat.o(60392);
    return bool;
  }
  
  public Iterator<kotlin.l.b.a.b.b.a.c> iterator()
  {
    AppMethodBeat.i(60393);
    Iterator localIterator = kAb().iterator();
    AppMethodBeat.o(60393);
    return localIterator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.b.b
 * JD-Core Version:    0.7.0.1
 */