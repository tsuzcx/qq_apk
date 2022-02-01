package d.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.u;
import d.g.b.w;
import d.l.b.a.b.l.f;

public final class al<T extends d.l.b.a.b.j.f.h>
{
  public static final a JqH;
  private final f JqD;
  private final e JqE;
  private final b<d.l.b.a.b.m.a.i, T> JqF;
  private final d.l.b.a.b.m.a.i JqG;
  
  static
  {
    AppMethodBeat.i(56881);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(al.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")) };
    JqH = new a((byte)0);
    AppMethodBeat.o(56881);
  }
  
  private al(e parame, d.l.b.a.b.l.i parami, b<? super d.l.b.a.b.m.a.i, ? extends T> paramb, d.l.b.a.b.m.a.i parami1)
  {
    AppMethodBeat.i(56883);
    this.JqE = parame;
    this.JqF = paramb;
    this.JqG = parami1;
    this.JqD = parami.H((d.g.a.a)new b(this));
    AppMethodBeat.o(56883);
  }
  
  public final T b(d.l.b.a.b.m.a.i parami)
  {
    AppMethodBeat.i(56882);
    d.g.b.k.h(parami, "kotlinTypeRefiner");
    parami.f(d.l.b.a.b.j.d.a.F((l)this.JqE));
    parami = (d.l.b.a.b.j.f.h)d.l.b.a.b.l.h.a(this.JqD, $$delegatedProperties[0]);
    AppMethodBeat.o(56882);
    return parami;
  }
  
  public static final class a
  {
    public static <T extends d.l.b.a.b.j.f.h> al<T> a(e parame, d.l.b.a.b.l.i parami, d.l.b.a.b.m.a.i parami1, b<? super d.l.b.a.b.m.a.i, ? extends T> paramb)
    {
      AppMethodBeat.i(56879);
      d.g.b.k.h(parame, "classDescriptor");
      d.g.b.k.h(parami, "storageManager");
      d.g.b.k.h(parami1, "kotlinTypeRefinerForOwnerModule");
      d.g.b.k.h(paramb, "scopeFactory");
      parame = new al(parame, parami, paramb, parami1, (byte)0);
      AppMethodBeat.o(56879);
      return parame;
    }
  }
  
  static final class b
    extends d.g.b.l
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