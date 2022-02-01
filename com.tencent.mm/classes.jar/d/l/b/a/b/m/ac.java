package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.v;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.b.e;
import d.l.b.a.b.j.b.n;
import d.l.b.a.b.j.f.h;
import java.util.List;

public final class ac
{
  private static final b<d.l.b.a.b.m.a.i, aj> NCh;
  public static final ac NCi;
  
  static
  {
    AppMethodBeat.i(60771);
    NCi = new ac();
    NCh = (b)ac.a.NCj;
    AppMethodBeat.o(60771);
  }
  
  public static final aj a(g paramg, e parame, List<? extends av> paramList)
  {
    AppMethodBeat.i(60768);
    p.h(paramg, "annotations");
    p.h(parame, "descriptor");
    p.h(paramList, "arguments");
    parame = parame.ghu();
    p.g(parame, "descriptor.typeConstructor");
    paramg = c(paramg, parame, paramList, false);
    AppMethodBeat.o(60768);
    return paramg;
  }
  
  public static final aj a(g paramg, n paramn)
  {
    AppMethodBeat.i(60770);
    p.h(paramg, "annotations");
    p.h(paramn, "constructor");
    paramn = (at)paramn;
    List localList = (List)v.MKE;
    h localh = u.dv("Scope for integer literal type", true);
    p.g(localh, "ErrorUtils.createErrorSc…eger literal type\", true)");
    paramg = a(paramg, paramn, localList, localh);
    AppMethodBeat.o(60770);
    return paramg;
  }
  
  public static final aj a(final g paramg, at paramat, final List<? extends av> paramList, final h paramh)
  {
    AppMethodBeat.i(60766);
    p.h(paramg, "annotations");
    p.h(paramat, "constructor");
    p.h(paramList, "arguments");
    p.h(paramh, "memberScope");
    paramat = new ak(paramat, paramList, false, paramh, (b)new d(paramat, paramList, paramg, false, paramh));
    if (paramg.isEmpty())
    {
      paramg = (aj)paramat;
      AppMethodBeat.o(60766);
      return paramg;
    }
    paramg = (aj)new i((aj)paramat, paramg);
    AppMethodBeat.o(60766);
    return paramg;
  }
  
  public static final aj a(g paramg, at paramat, List<? extends av> paramList, boolean paramBoolean, h paramh, b<? super d.l.b.a.b.m.a.i, ? extends aj> paramb)
  {
    AppMethodBeat.i(60767);
    p.h(paramg, "annotations");
    p.h(paramat, "constructor");
    p.h(paramList, "arguments");
    p.h(paramh, "memberScope");
    p.h(paramb, "refinedTypeFactory");
    paramat = new ak(paramat, paramList, paramBoolean, paramh, paramb);
    if (paramg.isEmpty())
    {
      paramg = (aj)paramat;
      AppMethodBeat.o(60767);
      return paramg;
    }
    paramg = (aj)new i((aj)paramat, paramg);
    AppMethodBeat.o(60767);
    return paramg;
  }
  
  public static final bg a(aj paramaj1, aj paramaj2)
  {
    AppMethodBeat.i(60769);
    p.h(paramaj1, "lowerBound");
    p.h(paramaj2, "upperBound");
    if (p.i(paramaj1, paramaj2))
    {
      paramaj1 = (bg)paramaj1;
      AppMethodBeat.o(60769);
      return paramaj1;
    }
    paramaj1 = (bg)new w(paramaj1, paramaj2);
    AppMethodBeat.o(60769);
    return paramaj1;
  }
  
  static final class b {}
  
  static final class c
    extends q
    implements b<d.l.b.a.b.m.a.i, aj>
  {
    c(at paramat, List paramList, g paramg, boolean paramBoolean)
    {
      super();
    }
  }
  
  static final class d
    extends q
    implements b<d.l.b.a.b.m.a.i, aj>
  {
    d(at paramat, List paramList, g paramg, boolean paramBoolean, h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.ac
 * JD-Core Version:    0.7.0.1
 */