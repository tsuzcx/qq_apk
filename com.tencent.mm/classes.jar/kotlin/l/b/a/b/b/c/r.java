package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.ad;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.j.f.g;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.l.f;
import kotlin.l.b.a.b.l.i;

public final class r
  extends j
  implements ad
{
  final b aaLC;
  private final f aaOr;
  private final h aaOs;
  final w aaOt;
  
  static
  {
    AppMethodBeat.i(57124);
    cMt = new kotlin.l.n[] { (kotlin.l.n)kotlin.g.b.ab.a(new z(kotlin.g.b.ab.bO(r.class), "fragments", "getFragments()Ljava/util/List;")) };
    AppMethodBeat.o(57124);
  }
  
  public r(w paramw, b paramb, kotlin.l.b.a.b.l.j paramj)
  {
    super(g.a.iGe(), paramb.iNB());
    AppMethodBeat.i(57130);
    this.aaOt = paramw;
    this.aaLC = paramb;
    this.aaOr = paramj.av((a)new a(this));
    this.aaOs = ((h)new g(paramj.av((a)new b(this))));
    AppMethodBeat.o(57130);
  }
  
  public final <R, D> R a(kotlin.l.b.a.b.b.n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(57129);
    p.k(paramn, "visitor");
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
      if ((p.h(this.aaLC, paramObject.iFy())) && (p.h(this.aaOt, paramObject.iFz())))
      {
        AppMethodBeat.o(57127);
        return true;
      }
      AppMethodBeat.o(57127);
      return false;
    }
  }
  
  public final List<kotlin.l.b.a.b.b.ab> getFragments()
  {
    AppMethodBeat.i(57125);
    List localList = (List)i.a(this.aaOr, cMt[0]);
    AppMethodBeat.o(57125);
    return localList;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(57128);
    int i = this.aaOt.hashCode();
    int j = this.aaLC.hashCode();
    AppMethodBeat.o(57128);
    return i * 31 + j;
  }
  
  public final h iEC()
  {
    return this.aaOs;
  }
  
  public final b iFy()
  {
    return this.aaLC;
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
    implements a<List<? extends kotlin.l.b.a.b.b.ab>>
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.r
 * JD-Core Version:    0.7.0.1
 */