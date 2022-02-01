package d.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.f.c;
import d.l.b.a.b.f.f;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class q
{
  public static final String g(c paramc)
  {
    AppMethodBeat.i(59871);
    p.h(paramc, "$this$render");
    paramc = paramc.grm();
    p.g(paramc, "pathSegments()");
    paramc = js(paramc);
    AppMethodBeat.o(59871);
    return paramc;
  }
  
  public static final String js(List<f> paramList)
  {
    AppMethodBeat.i(59872);
    p.h(paramList, "pathSegments");
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      f localf = (f)paramList.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(".");
      }
      localStringBuilder.append(x(localf));
    }
    paramList = localStringBuilder.toString();
    p.g(paramList, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(59872);
    return paramList;
  }
  
  public static final String x(f paramf)
  {
    AppMethodBeat.i(59869);
    p.h(paramf, "$this$render");
    if (y(paramf))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramf = paramf.sD();
      p.g(paramf, "asString()");
      paramf = "`".concat(String.valueOf(paramf)) + '`';
      AppMethodBeat.o(59869);
      return paramf;
    }
    paramf = paramf.sD();
    p.g(paramf, "asString()");
    AppMethodBeat.o(59869);
    return paramf;
  }
  
  private static final boolean y(f paramf)
  {
    AppMethodBeat.i(59870);
    if (paramf.Nqp)
    {
      AppMethodBeat.o(59870);
      return false;
    }
    paramf = paramf.sD();
    p.g(paramf, "asString()");
    int j;
    if (!l.NuU.contains(paramf))
    {
      paramf = (CharSequence)paramf;
      i = 0;
      if (i >= paramf.length()) {
        break label111;
      }
      char c = paramf.charAt(i);
      if ((Character.isLetterOrDigit(c)) || (c == '_')) {
        break label99;
      }
      j = 1;
      label82:
      if (j == 0) {
        break label104;
      }
    }
    label99:
    label104:
    label111:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label116;
      }
      AppMethodBeat.o(59870);
      return true;
      j = 0;
      break label82;
      i += 1;
      break;
    }
    label116:
    AppMethodBeat.o(59870);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.i.q
 * JD-Core Version:    0.7.0.1
 */