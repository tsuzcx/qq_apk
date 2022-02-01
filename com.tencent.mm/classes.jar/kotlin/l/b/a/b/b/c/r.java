package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.y;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.ad;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.j.f.g;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.l.f;
import kotlin.l.b.a.b.l.i;
import kotlin.l.k;

public final class r
  extends j
  implements ad
{
  final b TiI;
  private final f Tlx;
  private final h Tly;
  final w Tlz;
  
  static
  {
    AppMethodBeat.i(57124);
    cLI = new k[] { (k)aa.a(new y(aa.bp(r.class), "fragments", "getFragments()Ljava/util/List;")) };
    AppMethodBeat.o(57124);
  }
  
  public r(w paramw, b paramb, kotlin.l.b.a.b.l.j paramj)
  {
    super(g.a.hBP(), paramb.hJh());
    AppMethodBeat.i(57130);
    this.Tlz = paramw;
    this.TiI = paramb;
    this.Tlx = paramj.al((a)new a(this));
    this.Tly = ((h)new g(paramj.al((a)new b(this))));
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
      if ((p.j(this.TiI, paramObject.hBk())) && (p.j(this.Tlz, paramObject.hBl())))
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
    List localList = (List)i.a(this.Tlx, cLI[0]);
    AppMethodBeat.o(57125);
    return localList;
  }
  
  public final h hAp()
  {
    return this.Tly;
  }
  
  public final b hBk()
  {
    return this.TiI;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(57128);
    int i = this.Tlz.hashCode();
    int j = this.TiI.hashCode();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.r
 * JD-Core Version:    0.7.0.1
 */