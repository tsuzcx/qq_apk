package kotlin.l.b.a.b.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.a.j;
import kotlin.l.b.a.b.a.k.a;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.b.x;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.ae;
import kotlin.l.b.a.b.m.aq;
import kotlin.l.b.a.b.m.ax;

final class e
  implements b
{
  public static final e ajsd;
  private static final String description;
  
  static
  {
    AppMethodBeat.i(61295);
    ajsd = new e();
    description = "second parameter must be of type KProperty<*> or its supertype";
    AppMethodBeat.o(61295);
  }
  
  public final String getDescription()
  {
    return description;
  }
  
  public final boolean h(x paramx)
  {
    AppMethodBeat.i(61294);
    s.u(paramx, "functionDescriptor");
    Object localObject1 = (bd)paramx.kod().get(1);
    paramx = j.aiBR;
    s.s(localObject1, "secondParameter");
    paramx = kotlin.l.b.a.b.j.d.a.F((l)localObject1);
    s.u(paramx, "module");
    paramx = w.b(paramx, k.a.aiDK);
    if (paramx == null) {}
    Object localObject2;
    Object localObject3;
    for (paramx = null; paramx == null; paramx = (ad)ae.a((g)localObject2, paramx, p.listOf(new aq((ba)localObject3))))
    {
      AppMethodBeat.o(61294);
      return false;
      localObject2 = g.aiIh;
      localObject2 = g.a.kpB();
      localObject3 = paramx.kmZ().klq();
      s.s(localObject3, "kPropertyClass.typeConstructor.parameters");
      localObject3 = p.oO((List)localObject3);
      s.s(localObject3, "kPropertyClass.typeConstructor.parameters.single()");
    }
    localObject1 = ((bd)localObject1).koG();
    s.s(localObject1, "secondParameter.type");
    boolean bool = kotlin.l.b.a.b.m.d.a.d(paramx, kotlin.l.b.a.b.m.d.a.au((ad)localObject1));
    AppMethodBeat.o(61294);
    return bool;
  }
  
  public final String i(x paramx)
  {
    AppMethodBeat.i(61296);
    paramx = b.a.a(this, paramx);
    AppMethodBeat.o(61296);
    return paramx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.n.e
 * JD-Core Version:    0.7.0.1
 */