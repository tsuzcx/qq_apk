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
    p.k(paramb1, "$this$isSubpackageOf");
    p.k(paramb2, "packageName");
    if (p.h(paramb1, paramb2))
    {
      AppMethodBeat.o(59318);
      return true;
    }
    if (paramb2.isRoot())
    {
      AppMethodBeat.o(59318);
      return true;
    }
    paramb1 = paramb1.qu();
    p.j(paramb1, "this.asString()");
    paramb2 = paramb2.qu();
    p.j(paramb2, "packageName.asString()");
    if ((n.M(paramb1, paramb2, false)) && (paramb1.charAt(paramb2.length()) == '.'))
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
    p.k(paramb1, "$this$tail");
    p.k(paramb2, "prefix");
    if ((!a(paramb1, paramb2)) || (paramb2.isRoot()))
    {
      AppMethodBeat.o(59319);
      return paramb1;
    }
    if (p.h(paramb1, paramb2))
    {
      paramb1 = b.abfD;
      p.j(paramb1, "FqName.ROOT");
      AppMethodBeat.o(59319);
      return paramb1;
    }
    paramb1 = paramb1.qu();
    p.j(paramb1, "asString()");
    int i = paramb2.qu().length();
    if (paramb1 == null)
    {
      paramb1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(59319);
      throw paramb1;
    }
    paramb1 = paramb1.substring(i + 1);
    p.j(paramb1, "(this as java.lang.String).substring(startIndex)");
    paramb1 = new b(paramb1);
    AppMethodBeat.o(59319);
    return paramb1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.f.d
 * JD-Core Version:    0.7.0.1
 */