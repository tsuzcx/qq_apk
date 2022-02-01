package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.n.a.a;
import kotlin.n.n;
import kotlin.z;

public final class s
{
  private static final f a(f paramf, String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(57623);
    if (paramf.abfN)
    {
      AppMethodBeat.o(57623);
      return null;
    }
    String str = paramf.getIdentifier();
    p.j(str, "methodName.identifier");
    if (!n.M(str, paramString1, false))
    {
      AppMethodBeat.o(57623);
      return null;
    }
    if (str.length() == paramString1.length())
    {
      AppMethodBeat.o(57623);
      return null;
    }
    int i = str.charAt(paramString1.length());
    if (97 > i) {}
    while (paramString2 != null) {
      if ((z.aazO) && (!paramBoolean))
      {
        paramf = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(57623);
        throw paramf;
        if (122 >= i)
        {
          AppMethodBeat.o(57623);
          return null;
        }
      }
      else
      {
        paramf = f.bHb(paramString2 + n.b(str, (CharSequence)paramString1));
        AppMethodBeat.o(57623);
        return paramf;
      }
    }
    if (!paramBoolean)
    {
      AppMethodBeat.o(57623);
      return paramf;
    }
    paramf = a.bHt(n.b(str, (CharSequence)paramString1));
    if (!f.bHc(paramf))
    {
      AppMethodBeat.o(57623);
      return null;
    }
    paramf = f.bHb(paramf);
    AppMethodBeat.o(57623);
    return paramf;
  }
  
  private static f a(f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(57622);
    p.k(paramf, "methodName");
    if (paramBoolean) {}
    for (String str = "is";; str = null)
    {
      paramf = a(paramf, "set", false, str, 4);
      AppMethodBeat.o(57622);
      return paramf;
    }
  }
  
  public static final List<f> i(f paramf)
  {
    AppMethodBeat.i(57625);
    p.k(paramf, "name");
    Object localObject = paramf.qu();
    p.j(localObject, "name.asString()");
    if (o.bGK((String)localObject))
    {
      p.k(paramf, "methodName");
      f localf = a(paramf, "get", false, null, 12);
      localObject = localf;
      if (localf == null) {
        localObject = a(paramf, "is", false, null, 8);
      }
      paramf = j.eY(localObject);
      AppMethodBeat.o(57625);
      return paramf;
    }
    if (o.bGL((String)localObject))
    {
      p.k(paramf, "methodName");
      paramf = j.ah(new f[] { a(paramf, false), a(paramf, true) });
      AppMethodBeat.o(57625);
      return paramf;
    }
    localObject = e.aaRP;
    paramf = e.h(paramf);
    AppMethodBeat.o(57625);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.s
 * JD-Core Version:    0.7.0.1
 */