package kotlin.l.b.a.b.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.ak;
import kotlin.g.b.s;
import kotlin.l.b.a.b.a.h;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.m.a.j;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.az;
import kotlin.l.b.a.b.m.bl;

public final class c
  implements b
{
  public final az ajjx;
  public j ajjy;
  
  public c(az paramaz)
  {
    AppMethodBeat.i(60031);
    this.ajjx = paramaz;
    if (this.ajjx.kAN() != bl.ajqM) {}
    for (int i = 1; (ak.aiuY) && (i == 0); i = 0)
    {
      paramaz = (Throwable)new AssertionError(s.X("Only nontrivial projections can be captured, not: ", this.ajjx));
      AppMethodBeat.o(60031);
      throw paramaz;
    }
    AppMethodBeat.o(60031);
  }
  
  public final List<ba> klq()
  {
    return (List)ab.aivy;
  }
  
  public final boolean knx()
  {
    return false;
  }
  
  public final h koV()
  {
    AppMethodBeat.i(60030);
    h localh = this.ajjx.koG().kzm().koV();
    s.s(localh, "projection.type.constructor.builtIns");
    AppMethodBeat.o(60030);
    return localh;
  }
  
  public final Collection<ad> kpG()
  {
    AppMethodBeat.i(60028);
    if (this.ajjx.kAN() == bl.ajqO) {}
    for (Object localObject = this.ajjx.koG();; localObject = (ad)koV().kmP())
    {
      s.s(localObject, "if (projection.projectio… builtIns.nullableAnyType");
      localObject = (Collection)p.listOf(localObject);
      AppMethodBeat.o(60028);
      return localObject;
    }
  }
  
  public final az kzn()
  {
    return this.ajjx;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60029);
    String str = "CapturedTypeConstructor(" + this.ajjx + ')';
    AppMethodBeat.o(60029);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.a.a.c
 * JD-Core Version:    0.7.0.1
 */