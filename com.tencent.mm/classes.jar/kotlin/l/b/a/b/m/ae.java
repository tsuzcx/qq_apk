package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.ab;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.c.t;
import kotlin.l.b.a.b.b.c.t.a;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.j.b.n;
import kotlin.l.b.a.b.j.d.a;

public final class ae
{
  public static final ae ajpU;
  private static final b<kotlin.l.b.a.b.m.a.g, al> ajpV;
  
  static
  {
    AppMethodBeat.i(60771);
    ajpU = new ae();
    ajpV = (b)ae.a.ajpW;
    AppMethodBeat.o(60771);
  }
  
  public static final al a(kotlin.l.b.a.b.b.a.g paramg, e parame, List<? extends az> paramList)
  {
    AppMethodBeat.i(60768);
    s.u(paramg, "annotations");
    s.u(parame, "descriptor");
    s.u(paramList, "arguments");
    parame = parame.kmZ();
    s.s(parame, "descriptor.typeConstructor");
    paramg = c(paramg, parame, paramList, false);
    AppMethodBeat.o(60768);
    return paramg;
  }
  
  public static final al a(kotlin.l.b.a.b.b.a.g paramg, n paramn)
  {
    AppMethodBeat.i(60770);
    s.u(paramg, "annotations");
    s.u(paramn, "constructor");
    paramn = (ax)paramn;
    List localList = (List)ab.aivy;
    kotlin.l.b.a.b.j.g.h localh = v.eW("Scope for integer literal type", true);
    s.s(localh, "createErrorScope(\"Scope …eger literal type\", true)");
    paramg = a(paramg, paramn, localList, false, localh);
    AppMethodBeat.o(60770);
    return paramg;
  }
  
  public static final al a(final kotlin.l.b.a.b.b.a.g paramg, ax paramax, final List<? extends az> paramList, final boolean paramBoolean, final kotlin.l.b.a.b.j.g.h paramh)
  {
    AppMethodBeat.i(191638);
    s.u(paramg, "annotations");
    s.u(paramax, "constructor");
    s.u(paramList, "arguments");
    s.u(paramh, "memberScope");
    paramax = new am(paramax, paramList, paramBoolean, paramh, (b)new d(paramax, paramList, paramg, paramBoolean, paramh));
    if (paramg.isEmpty())
    {
      paramg = (al)paramax;
      AppMethodBeat.o(191638);
      return paramg;
    }
    paramg = (al)new i((al)paramax, paramg);
    AppMethodBeat.o(191638);
    return paramg;
  }
  
  public static final al a(kotlin.l.b.a.b.b.a.g paramg, ax paramax, List<? extends az> paramList, boolean paramBoolean, kotlin.l.b.a.b.j.g.h paramh, b<? super kotlin.l.b.a.b.m.a.g, ? extends al> paramb)
  {
    AppMethodBeat.i(60767);
    s.u(paramg, "annotations");
    s.u(paramax, "constructor");
    s.u(paramList, "arguments");
    s.u(paramh, "memberScope");
    s.u(paramb, "refinedTypeFactory");
    paramax = new am(paramax, paramList, paramBoolean, paramh, paramb);
    if (paramg.isEmpty())
    {
      paramg = (al)paramax;
      AppMethodBeat.o(60767);
      return paramg;
    }
    paramg = (al)new i((al)paramax, paramg);
    AppMethodBeat.o(60767);
    return paramg;
  }
  
  public static final al a(final kotlin.l.b.a.b.b.a.g paramg, ax paramax, final List<? extends az> paramList, final boolean paramBoolean, kotlin.l.b.a.b.m.a.g paramg1)
  {
    AppMethodBeat.i(191630);
    s.u(paramg, "annotations");
    s.u(paramax, "constructor");
    s.u(paramList, "arguments");
    if ((paramg.isEmpty()) && (paramList.isEmpty()) && (!paramBoolean) && (paramax.knA() != null))
    {
      paramg = paramax.knA();
      s.checkNotNull(paramg);
      paramg = paramg.koj();
      s.s(paramg, "constructor.declarationDescriptor!!.defaultType");
      AppMethodBeat.o(191630);
      return paramg;
    }
    Object localObject = paramax.knA();
    if ((localObject instanceof ba)) {
      paramg1 = ((ba)localObject).koj().knP();
    }
    for (;;)
    {
      paramg = a(paramg, paramax, paramList, paramBoolean, paramg1, (b)new c(paramax, paramList, paramg, paramBoolean));
      AppMethodBeat.o(191630);
      return paramg;
      if ((localObject instanceof e))
      {
        kotlin.l.b.a.b.m.a.g localg = paramg1;
        if (paramg1 == null) {
          localg = a.e(a.F((l)localObject));
        }
        if (paramList.isEmpty())
        {
          paramg1 = (e)localObject;
          s.u(paramg1, "<this>");
          s.u(localg, "kotlinTypeRefiner");
          localObject = t.aiLm;
          paramg1 = t.a.a(paramg1, localg);
        }
        else
        {
          paramg1 = (e)localObject;
          localObject = ay.ajqs;
          localObject = ay.a.a(paramax, paramList);
          s.u(paramg1, "<this>");
          s.u(localObject, "typeSubstitution");
          s.u(localg, "kotlinTypeRefiner");
          t.a locala = t.aiLm;
          paramg1 = t.a.a(paramg1, (bc)localObject, localg);
        }
      }
      else if ((localObject instanceof kotlin.l.b.a.b.b.az))
      {
        paramg1 = v.eW(s.X("Scope for abbreviation: ", ((kotlin.l.b.a.b.b.az)localObject).kok()), true);
        s.s(paramg1, "createErrorScope(\"Scope …{descriptor.name}\", true)");
      }
      else
      {
        if (!(paramax instanceof ac)) {
          break;
        }
        paramg1 = ((ac)paramax).kAI();
      }
    }
    paramg = new IllegalStateException("Unsupported classifier: " + localObject + " for constructor: " + paramax);
    AppMethodBeat.o(191630);
    throw paramg;
  }
  
  public static final al a(kotlin.l.b.a.b.b.az paramaz, List<? extends az> paramList)
  {
    AppMethodBeat.i(191636);
    s.u(paramaz, "<this>");
    s.u(paramList, "arguments");
    at localat = new at((av)av.a.ajqr);
    au.a locala = au.ajqn;
    paramaz = au.a.a(null, paramaz, paramList);
    paramList = kotlin.l.b.a.b.b.a.g.aiIh;
    paramList = g.a.kpB();
    s.u(paramaz, "typeAliasExpansion");
    s.u(paramList, "annotations");
    paramaz = localat.a(paramaz, paramList, false, 0, true);
    AppMethodBeat.o(191636);
    return paramaz;
  }
  
  public static final bk a(al paramal1, al paramal2)
  {
    AppMethodBeat.i(60769);
    s.u(paramal1, "lowerBound");
    s.u(paramal2, "upperBound");
    if (s.p(paramal1, paramal2))
    {
      paramal1 = (bk)paramal1;
      AppMethodBeat.o(60769);
      return paramal1;
    }
    paramal1 = (bk)new y(paramal1, paramal2);
    AppMethodBeat.o(60769);
    return paramal1;
  }
  
  static final class b
  {
    final al ajom;
    final ax ajpX;
    
    public b(al paramal, ax paramax)
    {
      this.ajom = paramal;
      this.ajpX = paramax;
    }
  }
  
  static final class c
    extends u
    implements b<kotlin.l.b.a.b.m.a.g, al>
  {
    c(ax paramax, List<? extends az> paramList, kotlin.l.b.a.b.b.a.g paramg, boolean paramBoolean)
    {
      super();
    }
  }
  
  static final class d
    extends u
    implements b<kotlin.l.b.a.b.m.a.g, al>
  {
    d(ax paramax, List<? extends az> paramList, kotlin.l.b.a.b.b.a.g paramg, boolean paramBoolean, kotlin.l.b.a.b.j.g.h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.ae
 * JD-Core Version:    0.7.0.1
 */