package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.v;
import d.g.a.a;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l.b.a.b.b.aq;
import d.l.b.a.b.l.f;
import d.z;
import java.util.Collection;
import java.util.List;

public abstract class h
  implements at
{
  private final f<a> NBy;
  
  public h(d.l.b.a.b.l.j paramj)
  {
    this.NBy = paramj.a((a)new b(this), (b)c.NBC, (b)new d(this));
  }
  
  protected Collection<ab> Ar(boolean paramBoolean)
  {
    return (Collection)v.MKE;
  }
  
  protected void I(ab paramab)
  {
    p.h(paramab, "type");
  }
  
  protected abstract Collection<ab> ghN();
  
  protected abstract aq ghR();
  
  protected ab gjT()
  {
    return null;
  }
  
  public final List<ab> gtS()
  {
    return ((a)this.NBy.invoke()).NBz;
  }
  
  static final class a
  {
    final Collection<ab> NBA;
    List<? extends ab> NBz;
    
    public a(Collection<? extends ab> paramCollection)
    {
      AppMethodBeat.i(60602);
      this.NBA = paramCollection;
      this.NBz = d.a.j.listOf(u.NBN);
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
    public static final c NBC;
    
    static
    {
      AppMethodBeat.i(60605);
      NBC = new c();
      AppMethodBeat.o(60605);
    }
    
    c()
    {
      super();
    }
  }
  
  static final class d
    extends q
    implements b<h.a, z>
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
      implements b<ab, z>
    {
      b(h.d paramd)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.h
 * JD-Core Version:    0.7.0.1
 */