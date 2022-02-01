package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.v;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.j.b.n;
import kotlin.l.b.a.b.j.f.h;

public final class ac
{
  private static final b<kotlin.l.b.a.b.m.a.i, aj> abqH;
  public static final ac abqI;
  
  static
  {
    AppMethodBeat.i(60771);
    abqI = new ac();
    abqH = (b)ac.a.abqJ;
    AppMethodBeat.o(60771);
  }
  
  public static final aj a(g paramg, e parame, List<? extends av> paramList)
  {
    AppMethodBeat.i(60768);
    p.k(paramg, "annotations");
    p.k(parame, "descriptor");
    p.k(paramList, "arguments");
    parame = parame.iDL();
    p.j(parame, "descriptor.typeConstructor");
    paramg = c(paramg, parame, paramList, false);
    AppMethodBeat.o(60768);
    return paramg;
  }
  
  public static final aj a(g paramg, n paramn)
  {
    AppMethodBeat.i(60770);
    p.k(paramg, "annotations");
    p.k(paramn, "constructor");
    paramn = (at)paramn;
    List localList = (List)v.aaAd;
    h localh = u.eh("Scope for integer literal type", true);
    p.j(localh, "ErrorUtils.createErrorSc…eger literal type\", true)");
    paramg = a(paramg, paramn, localList, false, localh);
    AppMethodBeat.o(60770);
    return paramg;
  }
  
  public static final aj a(final g paramg, at paramat, final List<? extends av> paramList, final boolean paramBoolean, final h paramh)
  {
    AppMethodBeat.i(269971);
    p.k(paramg, "annotations");
    p.k(paramat, "constructor");
    p.k(paramList, "arguments");
    p.k(paramh, "memberScope");
    paramat = new ak(paramat, paramList, paramBoolean, paramh, (b)new d(paramat, paramList, paramg, paramBoolean, paramh));
    if (paramg.isEmpty())
    {
      paramg = (aj)paramat;
      AppMethodBeat.o(269971);
      return paramg;
    }
    paramg = (aj)new i((aj)paramat, paramg);
    AppMethodBeat.o(269971);
    return paramg;
  }
  
  public static final aj a(g paramg, at paramat, List<? extends av> paramList, boolean paramBoolean, h paramh, b<? super kotlin.l.b.a.b.m.a.i, ? extends aj> paramb)
  {
    AppMethodBeat.i(60767);
    p.k(paramg, "annotations");
    p.k(paramat, "constructor");
    p.k(paramList, "arguments");
    p.k(paramh, "memberScope");
    p.k(paramb, "refinedTypeFactory");
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
    p.k(paramaj1, "lowerBound");
    p.k(paramaj2, "upperBound");
    if (p.h(paramaj1, paramaj2))
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
    implements b<kotlin.l.b.a.b.m.a.i, aj>
  {
    c(at paramat, List paramList, g paramg, boolean paramBoolean)
    {
      super();
    }
  }
  
  static final class d
    extends q
    implements b<kotlin.l.b.a.b.m.a.i, aj>
  {
    d(at paramat, List paramList, g paramg, boolean paramBoolean, h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.ac
 * JD-Core Version:    0.7.0.1
 */