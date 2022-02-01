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
  private final f<a> TNy;
  
  public h(kotlin.l.b.a.b.l.j paramj)
  {
    this.TNy = paramj.a((a)new b(this), (b)c.TNC, (b)new d(this));
  }
  
  protected Collection<ab> EU(boolean paramBoolean)
  {
    return (Collection)v.SXr;
  }
  
  protected void H(ab paramab)
  {
    p.h(paramab, "type");
  }
  
  protected ab hBX()
  {
    return null;
  }
  
  public final List<ab> hLx()
  {
    return ((a)this.TNy.invoke()).TNz;
  }
  
  protected abstract Collection<ab> hzR();
  
  protected abstract aq hzV();
  
  static final class a
  {
    final Collection<ab> TNA;
    List<? extends ab> TNz;
    
    public a(Collection<? extends ab> paramCollection)
    {
      AppMethodBeat.i(60602);
      this.TNA = paramCollection;
      this.TNz = kotlin.a.j.listOf(u.TNN);
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
    public static final c TNC;
    
    static
    {
      AppMethodBeat.i(60605);
      TNC = new c();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.h
 * JD-Core Version:    0.7.0.1
 */