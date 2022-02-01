package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.l.b.a.b.b.ay;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.l.m;
import kotlin.l.b.a.b.m.a.g;
import kotlin.o;

public abstract class h
  extends k
{
  private final kotlin.l.b.a.b.l.h<b> ajpf;
  final boolean ajpg;
  
  public h(m paramm)
  {
    this.ajpf = paramm.a((a)new c(this), (b)d.ajpn, (b)new e(this));
  }
  
  protected void A(ad paramad)
  {
    s.u(paramad, "type");
  }
  
  protected Collection<ad> PE(boolean paramBoolean)
  {
    return (Collection)ab.aivy;
  }
  
  public final ax c(g paramg)
  {
    s.u(paramg, "kotlinTypeRefiner");
    return (ax)new a(paramg);
  }
  
  public final List<ad> kAC()
  {
    return ((b)this.ajpf.invoke()).ajpm;
  }
  
  protected abstract Collection<ad> knw();
  
  protected abstract ay kny();
  
  protected ad kpI()
  {
    return null;
  }
  
  protected List<ad> oV(List<ad> paramList)
  {
    s.u(paramList, "supertypes");
    return paramList;
  }
  
  final class a
    implements ax
  {
    final g ajjc;
    private final j ajph;
    
    public a()
    {
      AppMethodBeat.i(191625);
      this.ajjc = localObject;
      this.ajph = kotlin.k.a(o.aiuG, (a)new a(this, h.this));
      AppMethodBeat.o(191625);
    }
    
    public final ax c(g paramg)
    {
      AppMethodBeat.i(191637);
      s.u(paramg, "kotlinTypeRefiner");
      paramg = h.this.c(paramg);
      AppMethodBeat.o(191637);
      return paramg;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(191639);
      boolean bool = h.this.equals(paramObject);
      AppMethodBeat.o(191639);
      return bool;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(191641);
      int i = h.this.hashCode();
      AppMethodBeat.o(191641);
      return i;
    }
    
    public final List<ba> klq()
    {
      AppMethodBeat.i(191626);
      List localList = h.this.klq();
      s.s(localList, "this@AbstractTypeConstructor.parameters");
      AppMethodBeat.o(191626);
      return localList;
    }
    
    public final kotlin.l.b.a.b.b.h knA()
    {
      AppMethodBeat.i(191632);
      kotlin.l.b.a.b.b.h localh = h.this.knA();
      AppMethodBeat.o(191632);
      return localh;
    }
    
    public final boolean knx()
    {
      AppMethodBeat.i(191628);
      boolean bool = h.this.knx();
      AppMethodBeat.o(191628);
      return bool;
    }
    
    public final kotlin.l.b.a.b.a.h koV()
    {
      AppMethodBeat.i(191633);
      kotlin.l.b.a.b.a.h localh = h.this.koV();
      s.s(localh, "this@AbstractTypeConstructor.builtIns");
      AppMethodBeat.o(191633);
      return localh;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(191644);
      String str = h.this.toString();
      AppMethodBeat.o(191644);
      return str;
    }
    
    static final class a
      extends u
      implements a<List<? extends ad>>
    {
      a(h.a parama, h paramh)
      {
        super();
      }
    }
  }
  
  static final class b
  {
    final Collection<ad> ajpl;
    List<? extends ad> ajpm;
    
    public b(Collection<? extends ad> paramCollection)
    {
      AppMethodBeat.i(60602);
      this.ajpl = paramCollection;
      this.ajpm = p.listOf(v.ajpy);
      AppMethodBeat.o(60602);
    }
  }
  
  static final class c
    extends u
    implements a<h.b>
  {
    c(h paramh)
    {
      super();
    }
  }
  
  static final class d
    extends u
    implements b<Boolean, h.b>
  {
    public static final d ajpn;
    
    static
    {
      AppMethodBeat.i(60605);
      ajpn = new d();
      AppMethodBeat.o(60605);
    }
    
    d()
    {
      super();
    }
  }
  
  static final class e
    extends u
    implements b<h.b, ah>
  {
    e(h paramh)
    {
      super();
    }
    
    static final class a
      extends u
      implements b<ax, Iterable<? extends ad>>
    {
      a(h paramh)
      {
        super();
      }
    }
    
    static final class b
      extends u
      implements b<ad, ah>
    {
      b(h paramh)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.l.b.a.b.m.h
 * JD-Core Version:    0.7.0.1
 */