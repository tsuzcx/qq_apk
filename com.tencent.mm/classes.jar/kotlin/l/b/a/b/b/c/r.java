package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.b.af;
import kotlin.g.b.ag;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.al;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.j.g.g;
import kotlin.l.b.a.b.l.l;
import kotlin.l.b.a.b.l.m;
import kotlin.l.e;
import kotlin.l.o;

public class r
  extends j
  implements al
{
  final c aiIl;
  final w aiLc;
  private final kotlin.l.b.a.b.l.h aiLd;
  private final kotlin.l.b.a.b.l.h aiLe;
  private final kotlin.l.b.a.b.j.g.h aiLf;
  
  static
  {
    AppMethodBeat.i(57124);
    aYe = new o[] { (o)ai.a((af)new ag((e)ai.cz(r.class), "fragments", "getFragments()Ljava/util/List;")), (o)ai.a((af)new ag((e)ai.cz(r.class), "empty", "getEmpty()Z")) };
    AppMethodBeat.o(57124);
  }
  
  public r(w paramw, c paramc, m paramm)
  {
    super(g.a.kpB(), paramc.kxU());
    AppMethodBeat.i(57130);
    this.aiLc = paramw;
    this.aiIl = paramc;
    this.aiLd = paramm.cq((a)new b(this));
    this.aiLe = paramm.cq((a)new a(this));
    this.aiLf = ((kotlin.l.b.a.b.j.g.h)new g(paramm, (a)new c(this)));
    AppMethodBeat.o(57130);
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(57129);
    s.u(paramn, "visitor");
    paramn = paramn.a((al)this, paramD);
    AppMethodBeat.o(57129);
    return paramn;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(57127);
    if ((paramObject instanceof al)) {}
    for (paramObject = (al)paramObject; paramObject == null; paramObject = null)
    {
      AppMethodBeat.o(57127);
      return false;
    }
    if ((s.p(this.aiIl, paramObject.koY())) && (s.p(this.aiLc, paramObject.koZ())))
    {
      AppMethodBeat.o(57127);
      return true;
    }
    AppMethodBeat.o(57127);
    return false;
  }
  
  public final List<ah> getFragments()
  {
    AppMethodBeat.i(57125);
    List localList = (List)l.a(this.aiLd, aYe[0]);
    AppMethodBeat.o(57125);
    return localList;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(57128);
    int i = this.aiLc.hashCode();
    int j = this.aiIl.hashCode();
    AppMethodBeat.o(57128);
    return i * 31 + j;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(57131);
    boolean bool = ((Boolean)l.a(this.aiLe, aYe[1])).booleanValue();
    AppMethodBeat.o(57131);
    return bool;
  }
  
  public final kotlin.l.b.a.b.j.g.h knP()
  {
    return this.aiLf;
  }
  
  public final c koY()
  {
    return this.aiIl;
  }
  
  static final class a
    extends u
    implements a<Boolean>
  {
    a(r paramr)
    {
      super();
    }
  }
  
  static final class b
    extends u
    implements a<List<? extends ah>>
  {
    b(r paramr)
    {
      super();
    }
  }
  
  static final class c
    extends u
    implements a<kotlin.l.b.a.b.j.g.h>
  {
    c(r paramr)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.r
 * JD-Core Version:    0.7.0.1
 */