package d.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.n.n;
import d.v;

public final class d
{
  private static boolean a(b paramb1, b paramb2)
  {
    AppMethodBeat.i(59318);
    p.h(paramb1, "$this$isSubpackageOf");
    p.h(paramb2, "packageName");
    if (p.i(paramb1, paramb2))
    {
      AppMethodBeat.o(59318);
      return true;
    }
    if (paramb2.isRoot())
    {
      AppMethodBeat.o(59318);
      return true;
    }
    paramb1 = paramb1.sD();
    p.g(paramb1, "this.asString()");
    paramb2 = paramb2.sD();
    p.g(paramb2, "packageName.asString()");
    if ((n.nF(paramb1, paramb2)) && (paramb1.charAt(paramb2.length()) == '.'))
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
    if (p.i(paramb1, paramb2))
    {
      paramb1 = b.NNl;
      p.g(paramb1, "FqName.ROOT");
      AppMethodBeat.o(59319);
      return paramb1;
    }
    paramb1 = paramb1.sD();
    p.g(paramb1, "asString()");
    int i = paramb2.sD().length();
    if (paramb1 == null)
    {
      paramb1 = new v("null cannot be cast to non-null type java.lang.String");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.f.d
 * JD-Core Version:    0.7.0.1
 */