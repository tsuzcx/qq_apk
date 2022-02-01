package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.p;
import kotlin.ak;
import kotlin.g.b.s;
import kotlin.l.b.a.b.n.a.a;
import kotlin.n.n;

public final class aa
{
  private static final kotlin.l.b.a.b.f.f a(kotlin.l.b.a.b.f.f paramf, String paramString1, boolean paramBoolean, String paramString2)
  {
    int j = 0;
    AppMethodBeat.i(57623);
    if (paramf.ajeG)
    {
      AppMethodBeat.o(57623);
      return null;
    }
    String str = paramf.getIdentifier();
    s.s(str, "methodName.identifier");
    if (!n.U(str, paramString1, false))
    {
      AppMethodBeat.o(57623);
      return null;
    }
    if (str.length() == paramString1.length())
    {
      AppMethodBeat.o(57623);
      return null;
    }
    int k = str.charAt(paramString1.length());
    int i = j;
    if (97 <= k)
    {
      i = j;
      if (k <= 122) {
        i = 1;
      }
    }
    if (i != 0)
    {
      AppMethodBeat.o(57623);
      return null;
    }
    if (paramString2 != null)
    {
      if ((ak.aiuY) && (!paramBoolean))
      {
        paramf = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(57623);
        throw paramf;
      }
      paramf = kotlin.l.b.a.b.f.f.bJe(s.X(paramString2, n.c(str, (CharSequence)paramString1)));
      AppMethodBeat.o(57623);
      return paramf;
    }
    if (!paramBoolean)
    {
      AppMethodBeat.o(57623);
      return paramf;
    }
    paramf = a.bJw(n.c(str, (CharSequence)paramString1));
    if (!kotlin.l.b.a.b.f.f.bJf(paramf))
    {
      AppMethodBeat.o(57623);
      return null;
    }
    paramf = kotlin.l.b.a.b.f.f.bJe(paramf);
    AppMethodBeat.o(57623);
    return paramf;
  }
  
  private static kotlin.l.b.a.b.f.f a(kotlin.l.b.a.b.f.f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(57622);
    s.u(paramf, "methodName");
    if (paramBoolean) {}
    for (String str = "is";; str = null)
    {
      paramf = a(paramf, "set", false, str, 4);
      AppMethodBeat.o(57622);
      return paramf;
    }
  }
  
  public static final List<kotlin.l.b.a.b.f.f> g(kotlin.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(57625);
    s.u(paramf, "name");
    Object localObject = paramf.PF();
    s.s(localObject, "name.asString()");
    if (v.bIM((String)localObject))
    {
      s.u(paramf, "methodName");
      kotlin.l.b.a.b.f.f localf = a(paramf, "get", false, null, 12);
      localObject = localf;
      if (localf == null) {
        localObject = a(paramf, "is", false, null, 8);
      }
      paramf = p.hs(localObject);
      AppMethodBeat.o(57625);
      return paramf;
    }
    if (v.bIN((String)localObject))
    {
      s.u(paramf, "methodName");
      paramf = p.am(new kotlin.l.b.a.b.f.f[] { a(paramf, false), a(paramf, true) });
      AppMethodBeat.o(57625);
      return paramf;
    }
    localObject = f.aiOz;
    paramf = f.f(paramf);
    AppMethodBeat.o(57625);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.aa
 * JD-Core Version:    0.7.0.1
 */