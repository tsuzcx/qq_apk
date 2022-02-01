package d.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.g.b.x;
import d.g.b.z;
import d.l.b.a.b.j.f.h;
import d.l.b.a.b.l.f;
import d.l.b.a.b.l.j;
import d.l.k;

public final class al<T extends h>
{
  public static final a MUV;
  private final f MUR;
  private final e MUS;
  private final b<d.l.b.a.b.m.a.i, T> MUT;
  private final d.l.b.a.b.m.a.i MUU;
  
  static
  {
    AppMethodBeat.i(56881);
    cwV = new k[] { (k)z.a(new x(z.bp(al.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")) };
    MUV = new a((byte)0);
    AppMethodBeat.o(56881);
  }
  
  private al(e parame, j paramj, b<? super d.l.b.a.b.m.a.i, ? extends T> paramb, d.l.b.a.b.m.a.i parami)
  {
    AppMethodBeat.i(56883);
    this.MUS = parame;
    this.MUT = paramb;
    this.MUU = parami;
    this.MUR = paramj.S((d.g.a.a)new b(this));
    AppMethodBeat.o(56883);
  }
  
  public final T b(d.l.b.a.b.m.a.i parami)
  {
    AppMethodBeat.i(56882);
    p.h(parami, "kotlinTypeRefiner");
    parami.f(d.l.b.a.b.j.d.a.F((l)this.MUS));
    parami = (h)d.l.b.a.b.l.i.a(this.MUR, cwV[0]);
    AppMethodBeat.o(56882);
    return parami;
  }
  
  public static final class a
  {
    public static <T extends h> al<T> a(e parame, j paramj, d.l.b.a.b.m.a.i parami, b<? super d.l.b.a.b.m.a.i, ? extends T> paramb)
    {
      AppMethodBeat.i(56879);
      p.h(parame, "classDescriptor");
      p.h(paramj, "storageManager");
      p.h(parami, "kotlinTypeRefinerForOwnerModule");
      p.h(paramb, "scopeFactory");
      parame = new al(parame, paramj, paramb, parami, (byte)0);
      AppMethodBeat.o(56879);
      return parame;
    }
  }
  
  static final class b
    extends q
    implements d.g.a.a<T>
  {
    b(al paramal)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.al
 * JD-Core Version:    0.7.0.1
 */