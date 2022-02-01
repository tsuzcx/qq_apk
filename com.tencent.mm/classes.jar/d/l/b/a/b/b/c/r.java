package d.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.l;
import d.g.b.u;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.b.ab;
import d.l.b.a.b.b.ad;
import d.l.b.a.b.b.n;
import d.l.b.a.b.f.b;
import d.l.b.a.b.j.f.g;
import d.l.b.a.b.l.f;
import d.l.b.a.b.l.i;
import java.util.List;

public final class r
  extends j
  implements ad
{
  final b LeZ;
  private final f LhN;
  private final d.l.b.a.b.j.f.h LhO;
  final w LhP;
  
  static
  {
    AppMethodBeat.i(57124);
    $$delegatedProperties = new d.l.k[] { (d.l.k)d.g.b.w.a(new u(d.g.b.w.bn(r.class), "fragments", "getFragments()Ljava/util/List;")) };
    AppMethodBeat.o(57124);
  }
  
  public r(w paramw, b paramb, i parami)
  {
    super(g.a.fSm(), paramb.fZJ());
    AppMethodBeat.i(57130);
    this.LhP = paramw;
    this.LeZ = paramb;
    this.LhN = parami.O((a)new a(this));
    this.LhO = ((d.l.b.a.b.j.f.h)new g(parami.O((a)new b(this))));
    AppMethodBeat.o(57130);
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(57129);
    d.g.b.k.h(paramn, "visitor");
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
      if ((d.g.b.k.g(this.LeZ, paramObject.fRH())) && (d.g.b.k.g(this.LhP, paramObject.fRI())))
      {
        AppMethodBeat.o(57127);
        return true;
      }
      AppMethodBeat.o(57127);
      return false;
    }
  }
  
  public final d.l.b.a.b.j.f.h fQN()
  {
    return this.LhO;
  }
  
  public final b fRH()
  {
    return this.LeZ;
  }
  
  public final List<ab> getFragments()
  {
    AppMethodBeat.i(57125);
    List localList = (List)d.l.b.a.b.l.h.a(this.LhN, $$delegatedProperties[0]);
    AppMethodBeat.o(57125);
    return localList;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(57128);
    int i = this.LhP.hashCode();
    int j = this.LeZ.hashCode();
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
    extends l
    implements a<List<? extends ab>>
  {
    a(r paramr)
    {
      super();
    }
  }
  
  static final class b
    extends l
    implements a<d.l.b.a.b.j.f.h>
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