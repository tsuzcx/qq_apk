package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.g.b.ab;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.l.f;
import kotlin.l.b.a.b.l.j;
import kotlin.l.n;

public final class al<T extends h>
{
  public static final a aaKC;
  private final b<kotlin.l.b.a.b.m.a.i, T> aaKA;
  private final kotlin.l.b.a.b.m.a.i aaKB;
  private final f aaKy;
  private final e aaKz;
  
  static
  {
    AppMethodBeat.i(56881);
    cMt = new n[] { (n)ab.a(new z(ab.bO(al.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")) };
    aaKC = new a((byte)0);
    AppMethodBeat.o(56881);
  }
  
  private al(e parame, j paramj, b<? super kotlin.l.b.a.b.m.a.i, ? extends T> paramb, kotlin.l.b.a.b.m.a.i parami)
  {
    AppMethodBeat.i(56883);
    this.aaKz = parame;
    this.aaKA = paramb;
    this.aaKB = parami;
    this.aaKy = paramj.av((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(56883);
  }
  
  public final T b(kotlin.l.b.a.b.m.a.i parami)
  {
    AppMethodBeat.i(56882);
    p.k(parami, "kotlinTypeRefiner");
    parami.f(kotlin.l.b.a.b.j.d.a.F((l)this.aaKz));
    parami = (h)kotlin.l.b.a.b.l.i.a(this.aaKy, cMt[0]);
    AppMethodBeat.o(56882);
    return parami;
  }
  
  public static final class a
  {
    public static <T extends h> al<T> a(e parame, j paramj, kotlin.l.b.a.b.m.a.i parami, b<? super kotlin.l.b.a.b.m.a.i, ? extends T> paramb)
    {
      AppMethodBeat.i(56879);
      p.k(parame, "classDescriptor");
      p.k(paramj, "storageManager");
      p.k(parami, "kotlinTypeRefinerForOwnerModule");
      p.k(paramb, "scopeFactory");
      parame = new al(parame, paramj, paramb, parami, (byte)0);
      AppMethodBeat.o(56879);
      return parame;
    }
  }
  
  static final class b
    extends q
    implements kotlin.g.a.a<T>
  {
    b(al paramal)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.al
 * JD-Core Version:    0.7.0.1
 */