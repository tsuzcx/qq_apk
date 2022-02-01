package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.l.b.a.b.j.e.d;
import kotlin.n.n;

final class m
  implements l<k>
{
  public static final m TvN;
  
  static
  {
    AppMethodBeat.i(58216);
    TvN = new m();
    AppMethodBeat.o(58216);
  }
  
  private k btO(String paramString)
  {
    int k = 0;
    AppMethodBeat.i(58209);
    p.h(paramString, "representation");
    if (((CharSequence)paramString).length() > 0) {}
    for (int i = 1; (aa.SXc) && (i == 0); i = 0)
    {
      paramString = (Throwable)new AssertionError("empty string as JvmType");
      AppMethodBeat.o(58209);
      throw paramString;
    }
    int m = paramString.charAt(0);
    d[] arrayOfd = d.values();
    int n = arrayOfd.length;
    i = 0;
    d locald;
    int j;
    if (i < n)
    {
      locald = arrayOfd[i];
      if (locald.getDesc().charAt(0) == m)
      {
        j = 1;
        label110:
        if (j == 0) {
          break label144;
        }
      }
    }
    for (;;)
    {
      if (locald == null) {
        break label157;
      }
      paramString = (k)new k.c(locald);
      AppMethodBeat.o(58209);
      return paramString;
      j = 0;
      break label110;
      label144:
      i += 1;
      break;
      locald = null;
    }
    switch (m)
    {
    default: 
      i = k;
      if (m == 76)
      {
        i = k;
        if (n.a((CharSequence)paramString, ';')) {
          i = 1;
        }
      }
      if ((aa.SXc) && (i == 0))
      {
        paramString = (Throwable)new AssertionError("Type that is not primitive nor array should be Object, but '" + paramString + "' was found");
        AppMethodBeat.o(58209);
        throw paramString;
      }
      break;
    case 86: 
      paramString = (k)new k.c(null);
      AppMethodBeat.o(58209);
      return paramString;
    case 91: 
      label157:
      paramString = paramString.substring(1);
      p.g(paramString, "(this as java.lang.String).substring(startIndex)");
      paramString = (k)new k.a(btO(paramString));
      AppMethodBeat.o(58209);
      return paramString;
    }
    paramString = paramString.substring(1, paramString.length() - 1);
    p.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    paramString = (k)new k.b(paramString);
    AppMethodBeat.o(58209);
    return paramString;
  }
  
  private static k.b btP(String paramString)
  {
    AppMethodBeat.i(58211);
    p.h(paramString, "internalName");
    paramString = new k.b(paramString);
    AppMethodBeat.o(58211);
    return paramString;
  }
  
  public final String a(k paramk)
  {
    AppMethodBeat.i(58213);
    p.h(paramk, "type");
    if ((paramk instanceof k.a))
    {
      paramk = "[" + a(((k.a)paramk).TvK);
      AppMethodBeat.o(58213);
      return paramk;
    }
    if ((paramk instanceof k.c))
    {
      paramk = ((k.c)paramk).TvM;
      if (paramk != null)
      {
        paramk = paramk.getDesc();
        if (paramk != null) {}
      }
      else
      {
        AppMethodBeat.o(58213);
        return "V";
      }
    }
    else
    {
      if ((paramk instanceof k.b))
      {
        paramk = "L" + ((k.b)paramk).TvL + ";";
        AppMethodBeat.o(58213);
        return paramk;
      }
      paramk = new kotlin.m();
      AppMethodBeat.o(58213);
      throw paramk;
    }
    AppMethodBeat.o(58213);
    return paramk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.m
 * JD-Core Version:    0.7.0.1
 */