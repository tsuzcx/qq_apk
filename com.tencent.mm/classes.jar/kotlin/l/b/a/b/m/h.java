package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import kotlin.a.v;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.aq;
import kotlin.l.b.a.b.l.f;
import kotlin.x;

public abstract class h
  implements at
{
  private final f<a> abqa;
  
  public h(kotlin.l.b.a.b.l.j paramj)
  {
    this.abqa = paramj.a((a)new b(this), (b)c.abqe, (b)new d(this));
  }
  
  protected void H(ab paramab)
  {
    p.k(paramab, "type");
  }
  
  protected Collection<ab> JB(boolean paramBoolean)
  {
    return (Collection)v.aaAd;
  }
  
  protected abstract Collection<ab> iEe();
  
  protected abstract aq iEi();
  
  protected ab iGm()
  {
    return null;
  }
  
  public final List<ab> iPQ()
  {
    return ((a)this.abqa.invoke()).abqb;
  }
  
  static final class a
  {
    List<? extends ab> abqb;
    final Collection<ab> abqc;
    
    public a(Collection<? extends ab> paramCollection)
    {
      AppMethodBeat.i(60602);
      this.abqc = paramCollection;
      this.abqb = kotlin.a.j.listOf(u.abqp);
      AppMethodBeat.o(60602);
    }
  }
  
  static final class b
    extends q
    implements a<h.a>
  {
    b(h paramh)
    {
      super();
    }
  }
  
  static final class c
    extends q
    implements b<Boolean, h.a>
  {
    public static final c abqe;
    
    static
    {
      AppMethodBeat.i(60605);
      abqe = new c();
      AppMethodBeat.o(60605);
    }
    
    c()
    {
      super();
    }
  }
  
  static final class d
    extends q
    implements b<h.a, x>
  {
    d(h paramh)
    {
      super();
    }
    
    static final class a
      extends q
      implements b<at, Collection<? extends ab>>
    {
      a(h.d paramd)
      {
        super();
      }
    }
    
    static final class b
      extends q
      implements b<ab, x>
    {
      b(h.d paramd)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.h
 * JD-Core Version:    0.7.0.1
 */