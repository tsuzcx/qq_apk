package d.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.g.b.x;
import d.g.b.z;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.b.ab;
import d.l.b.a.b.b.ad;
import d.l.b.a.b.b.n;
import d.l.b.a.b.f.b;
import d.l.b.a.b.j.f.g;
import d.l.b.a.b.j.f.h;
import d.l.b.a.b.l.f;
import d.l.b.a.b.l.i;
import d.l.k;
import java.util.List;

public final class r
  extends j
  implements ad
{
  final b Nta;
  private final f NvP;
  private final h NvQ;
  final w NvR;
  
  static
  {
    AppMethodBeat.i(57124);
    cxA = new k[] { (k)z.a(new x(z.bp(r.class), "fragments", "getFragments()Ljava/util/List;")) };
    AppMethodBeat.o(57124);
  }
  
  public r(w paramw, b paramb, d.l.b.a.b.l.j paramj)
  {
    super(g.a.gon(), paramb.gvK());
    AppMethodBeat.i(57130);
    this.NvR = paramw;
    this.Nta = paramb;
    this.NvP = paramj.S((a)new a(this));
    this.NvQ = ((h)new g(paramj.S((a)new b(this))));
    AppMethodBeat.o(57130);
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(57129);
    p.h(paramn, "visitor");
    paramn = paramn.a((ad)this, paramD);
    AppMethodBeat.o(57129);
    return paramn;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(57127);
    if (!(paramObject instanceof ad)) {
      paramObject = null;
    }
    for (;;)
    {
      paramObject = (ad)paramObject;
      if (paramObject == null)
      {
        AppMethodBeat.o(57127);
        return false;
      }
      if ((p.i(this.Nta, paramObject.gnI())) && (p.i(this.NvR, paramObject.gnJ())))
      {
        AppMethodBeat.o(57127);
        return true;
      }
      AppMethodBeat.o(57127);
      return false;
    }
  }
  
  public final List<ab> getFragments()
  {
    AppMethodBeat.i(57125);
    List localList = (List)i.a(this.NvP, cxA[0]);
    AppMethodBeat.o(57125);
    return localList;
  }
  
  public final h gmN()
  {
    return this.NvQ;
  }
  
  public final b gnI()
  {
    return this.Nta;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(57128);
    int i = this.NvR.hashCode();
    int j = this.Nta.hashCode();
    AppMethodBeat.o(57128);
    return i * 31 + j;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(57131);
    boolean bool = getFragments().isEmpty();
    AppMethodBeat.o(57131);
    return bool;
  }
  
  static final class a
    extends q
    implements a<List<? extends ab>>
  {
    a(r paramr)
    {
      super();
    }
  }
  
  static final class b
    extends q
    implements a<h>
  {
    b(r paramr)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.c.r
 * JD-Core Version:    0.7.0.1
 */