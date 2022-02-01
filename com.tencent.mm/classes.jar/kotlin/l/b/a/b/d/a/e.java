package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.x;
import kotlin.l.b.a.b.d.b.t;
import kotlin.l.b.a.b.f.f;

public final class e
  extends ad
{
  public static final e aiOw;
  
  static
  {
    AppMethodBeat.i(57565);
    aiOw = new e();
    AppMethodBeat.o(57565);
  }
  
  public static final x e(x paramx)
  {
    AppMethodBeat.i(57562);
    s.u(paramx, "functionDescriptor");
    f localf = paramx.kok();
    s.s(localf, "functionDescriptor.name");
    if (!e(localf))
    {
      AppMethodBeat.o(57562);
      return null;
    }
    paramx = (x)kotlin.l.b.a.b.j.d.a.b((kotlin.l.b.a.b.b.b)paramx, (kotlin.g.a.b)a.aiOx);
    AppMethodBeat.o(57562);
    return paramx;
  }
  
  public static boolean e(f paramf)
  {
    AppMethodBeat.i(57563);
    s.u(paramf, "<this>");
    boolean bool = ad.krX().contains(paramf);
    AppMethodBeat.o(57563);
    return bool;
  }
  
  public static final ad.b i(kotlin.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(192045);
    s.u(paramb, "<this>");
    if (!ad.krX().contains(paramb.kok()))
    {
      AppMethodBeat.o(192045);
      return null;
    }
    paramb = kotlin.l.b.a.b.j.d.a.b(paramb, (kotlin.g.a.b)b.aiOy);
    if (paramb == null) {}
    for (paramb = null; paramb == null; paramb = t.c((kotlin.l.b.a.b.b.a)paramb))
    {
      AppMethodBeat.o(192045);
      return null;
    }
    s.u(paramb, "builtinSignature");
    if (ad.krV().contains(paramb))
    {
      paramb = ad.b.aiQD;
      AppMethodBeat.o(192045);
      return paramb;
    }
    if ((ad.c)ak.e(ad.krW(), paramb) == ad.c.aiQH)
    {
      paramb = ad.b.aiQF;
      AppMethodBeat.o(192045);
      return paramb;
    }
    paramb = ad.b.aiQE;
    AppMethodBeat.o(192045);
    return paramb;
  }
  
  static final class a
    extends u
    implements kotlin.g.a.b<kotlin.l.b.a.b.b.b, Boolean>
  {
    public static final a aiOx;
    
    static
    {
      AppMethodBeat.i(57559);
      aiOx = new a();
      AppMethodBeat.o(57559);
    }
    
    a()
    {
      super();
    }
  }
  
  static final class b
    extends u
    implements kotlin.g.a.b<kotlin.l.b.a.b.b.b, Boolean>
  {
    public static final b aiOy;
    
    static
    {
      AppMethodBeat.i(57561);
      aiOy = new b();
      AppMethodBeat.o(57561);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.e
 * JD-Core Version:    0.7.0.1
 */