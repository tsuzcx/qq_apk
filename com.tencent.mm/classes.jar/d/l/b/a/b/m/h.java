package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.a.v;
import d.g.a.a;
import d.g.a.b;
import d.g.b.k;
import d.g.b.l;
import d.l.b.a.b.b.aq;
import d.l.b.a.b.l.f;
import d.l.b.a.b.l.i;
import d.y;
import java.util.Collection;
import java.util.List;

public abstract class h
  implements at
{
  private final f<a> LKE;
  
  public h(i parami)
  {
    this.LKE = parami.a((a)new b(this), (b)c.LKI, (b)new d(this));
  }
  
  protected void I(ab paramab)
  {
    k.h(paramab, "type");
  }
  
  protected abstract Collection<ab> fQp();
  
  protected abstract aq fQt();
  
  protected ab fSv()
  {
    return null;
  }
  
  public final List<ab> gcs()
  {
    return ((a)this.LKE.invoke()).LKF;
  }
  
  protected Collection<ab> zD(boolean paramBoolean)
  {
    return (Collection)v.KTF;
  }
  
  static final class a
  {
    List<? extends ab> LKF;
    final Collection<ab> LKG;
    
    public a(Collection<? extends ab> paramCollection)
    {
      AppMethodBeat.i(60602);
      this.LKG = paramCollection;
      this.LKF = j.listOf(u.LKS);
      AppMethodBeat.o(60602);
    }
  }
  
  static final class b
    extends l
    implements a<h.a>
  {
    b(h paramh)
    {
      super();
    }
  }
  
  static final class c
    extends l
    implements b<Boolean, h.a>
  {
    public static final c LKI;
    
    static
    {
      AppMethodBeat.i(60605);
      LKI = new c();
      AppMethodBeat.o(60605);
    }
    
    c()
    {
      super();
    }
  }
  
  static final class d
    extends l
    implements b<h.a, y>
  {
    d(h paramh)
    {
      super();
    }
    
    static final class a
      extends l
      implements b<at, Collection<? extends ab>>
    {
      a(h.d paramd)
      {
        super();
      }
    }
    
    static final class b
      extends l
      implements b<ab, y>
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