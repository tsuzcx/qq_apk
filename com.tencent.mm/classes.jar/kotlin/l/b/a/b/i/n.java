package kotlin.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.g.b.s;
import kotlin.l.b.a.b.f.d;
import kotlin.l.b.a.b.f.f;

public final class n
{
  public static final String k(d paramd)
  {
    AppMethodBeat.i(59871);
    s.u(paramd, "<this>");
    paramd = paramd.kxV();
    s.s(paramd, "pathSegments()");
    paramd = pc(paramd);
    AppMethodBeat.o(59871);
    return paramd;
  }
  
  public static final String pc(List<f> paramList)
  {
    AppMethodBeat.i(59872);
    s.u(paramList, "pathSegments");
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      f localf = (f)paramList.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(".");
      }
      localStringBuilder.append(y(localf));
    }
    paramList = localStringBuilder.toString();
    s.s(paramList, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(59872);
    return paramList;
  }
  
  public static final String y(f paramf)
  {
    AppMethodBeat.i(59869);
    s.u(paramf, "<this>");
    if (z(paramf))
    {
      paramf = paramf.PF();
      s.s(paramf, "asString()");
      paramf = s.X("`".concat(String.valueOf(paramf)), "`");
      AppMethodBeat.o(59869);
      return paramf;
    }
    paramf = paramf.PF();
    s.s(paramf, "asString()");
    AppMethodBeat.o(59869);
    return paramf;
  }
  
  private static final boolean z(f paramf)
  {
    AppMethodBeat.i(59870);
    if (paramf.ajeG)
    {
      AppMethodBeat.o(59870);
      return false;
    }
    paramf = paramf.PF();
    s.s(paramf, "asString()");
    int j;
    if (!i.ajio.contains(paramf))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.i.n
 * JD-Core Version:    0.7.0.1
 */