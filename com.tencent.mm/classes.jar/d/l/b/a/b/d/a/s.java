package d.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.aa;
import d.g.b.k;
import d.l.b.a.b.f.f;
import d.l.b.a.b.n.a.a;
import d.n.n;
import java.util.List;

public final class s
{
  private static final f a(f paramf, String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(57623);
    if (paramf.Lzs)
    {
      AppMethodBeat.o(57623);
      return null;
    }
    String str = paramf.getIdentifier();
    k.g(str, "methodName.identifier");
    if (!n.nb(str, paramString1))
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
      if ((aa.KTq) && (!paramBoolean))
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
        paramf = f.aWB(paramString2 + n.b(str, (CharSequence)paramString1));
        AppMethodBeat.o(57623);
        return paramf;
      }
    }
    if (!paramBoolean)
    {
      AppMethodBeat.o(57623);
      return paramf;
    }
    paramf = a.aWV(n.b(str, (CharSequence)paramString1));
    if (!f.aWC(paramf))
    {
      AppMethodBeat.o(57623);
      return null;
    }
    paramf = f.aWB(paramf);
    AppMethodBeat.o(57623);
    return paramf;
  }
  
  private static f a(f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(57622);
    k.h(paramf, "methodName");
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
    k.h(paramf, "name");
    Object localObject = paramf.rf();
    k.g(localObject, "name.asString()");
    if (o.aWk((String)localObject))
    {
      k.h(paramf, "methodName");
      f localf = a(paramf, "get", false, null, 12);
      localObject = localf;
      if (localf == null) {
        localObject = a(paramf, "is", false, null, 8);
      }
      paramf = j.eJ(localObject);
      AppMethodBeat.o(57625);
      return paramf;
    }
    if (o.aWl((String)localObject))
    {
      k.h(paramf, "methodName");
      paramf = j.ac(new f[] { a(paramf, false), a(paramf, true) });
      AppMethodBeat.o(57625);
      return paramf;
    }
    localObject = e.Lll;
    paramf = e.h(paramf);
    AppMethodBeat.o(57625);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.s
 * JD-Core Version:    0.7.0.1
 */