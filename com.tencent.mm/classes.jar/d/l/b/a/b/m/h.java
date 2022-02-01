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
  private final f<a> NYF;
  
  public h(d.l.b.a.b.l.j paramj)
  {
    this.NYF = paramj.a((a)new b(this), (b)c.NYJ, (b)new d(this));
  }
  
  protected Collection<ab> AE(boolean paramBoolean)
  {
    return (Collection)v.NhH;
  }
  
  protected void I(ab paramab)
  {
    p.h(paramab, "type");
  }
  
  protected abstract Collection<ab> gmp();
  
  protected abstract aq gmt();
  
  protected ab gov()
  {
    return null;
  }
  
  public final List<ab> gyu()
  {
    return ((a)this.NYF.invoke()).NYG;
  }
  
  static final class a
  {
    List<? extends ab> NYG;
    final Collection<ab> NYH;
    
    public a(Collection<? extends ab> paramCollection)
    {
      AppMethodBeat.i(60602);
      this.NYH = paramCollection;
      this.NYG = d.a.j.listOf(u.NYU);
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
    public static final c NYJ;
    
    static
    {
      AppMethodBeat.i(60605);
      NYJ = new c();
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