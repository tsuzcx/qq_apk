package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.i.c;
import kotlin.l.b.a.b.m.ax;

public final class x
{
  private static final StringBuilder b(String paramString, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(191696);
    s.u(paramString, "<this>");
    paramString = paramStringBuilder.append(paramString);
    s.s(paramString, "append(value)");
    paramString = paramString.append('\n');
    s.s(paramString, "append('\\n')");
    AppMethodBeat.o(191696);
    return paramString;
  }
  
  static final String f(ax paramax)
  {
    AppMethodBeat.i(61193);
    StringBuilder localStringBuilder = new StringBuilder();
    b(s.X("type: ", paramax), localStringBuilder);
    b(s.X("hashCode: ", Integer.valueOf(paramax.hashCode())), localStringBuilder);
    b(s.X("javaClass: ", paramax.getClass().getCanonicalName()), localStringBuilder);
    for (paramax = (l)paramax.knA(); paramax != null; paramax = paramax.knp())
    {
      b(s.X("fqName: ", c.ajgy.k(paramax)), localStringBuilder);
      b(s.X("javaClass: ", paramax.getClass().getCanonicalName()), localStringBuilder);
    }
    paramax = localStringBuilder.toString();
    s.s(paramax, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(61193);
    return paramax;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.a.x
 * JD-Core Version:    0.7.0.1
 */