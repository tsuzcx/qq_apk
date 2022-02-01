package kotlin.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.t;

public final class d
{
  private static boolean a(b paramb1, b paramb2)
  {
    AppMethodBeat.i(59318);
    p.h(paramb1, "$this$isSubpackageOf");
    p.h(paramb2, "packageName");
    if (p.j(paramb1, paramb2))
    {
      AppMethodBeat.o(59318);
      return true;
    }
    if (paramb2.isRoot())
    {
      AppMethodBeat.o(59318);
      return true;
    }
    paramb1 = paramb1.sG();
    p.g(paramb1, "this.asString()");
    paramb2 = paramb2.sG();
    p.g(paramb2, "packageName.asString()");
    if ((n.J(paramb1, paramb2, false)) && (paramb1.charAt(paramb2.length()) == '.'))
    {
      AppMethodBeat.o(59318);
      return true;
    }
    AppMethodBeat.o(59318);
    return false;
  }
  
  public static final b b(b paramb1, b paramb2)
  {
    AppMethodBeat.i(59319);
    p.h(paramb1, "$this$tail");
    p.h(paramb2, "prefix");
    if ((!a(paramb1, paramb2)) || (paramb2.isRoot()))
    {
      AppMethodBeat.o(59319);
      return paramb1;
    }
    if (p.j(paramb1, paramb2))
    {
      paramb1 = b.TCQ;
      p.g(paramb1, "FqName.ROOT");
      AppMethodBeat.o(59319);
      return paramb1;
    }
    paramb1 = paramb1.sG();
    p.g(paramb1, "asString()");
    int i = paramb2.sG().length();
    if (paramb1 == null)
    {
      paramb1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(59319);
      throw paramb1;
    }
    paramb1 = paramb1.substring(i + 1);
    p.g(paramb1, "(this as java.lang.String).substring(startIndex)");
    paramb1 = new b(paramb1);
    AppMethodBeat.o(59319);
    return paramb1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.f.d
 * JD-Core Version:    0.7.0.1
 */