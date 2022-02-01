package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.ak;
import kotlin.g.b.s;
import kotlin.l.b.a.b.j.e.e;
import kotlin.n.n;
import kotlin.p;

final class l
  implements k<j>
{
  public static final l aiWY;
  
  static
  {
    AppMethodBeat.i(58216);
    aiWY = new l();
    AppMethodBeat.o(58216);
  }
  
  private j bIU(String paramString)
  {
    int k = 0;
    AppMethodBeat.i(58209);
    s.u(paramString, "representation");
    if (((CharSequence)paramString).length() > 0) {}
    for (int i = 1; (ak.aiuY) && (i == 0); i = 0)
    {
      paramString = (Throwable)new AssertionError("empty string as JvmType");
      AppMethodBeat.o(58209);
      throw paramString;
    }
    int m = paramString.charAt(0);
    e[] arrayOfe = e.values();
    int n = arrayOfe.length;
    i = 0;
    e locale;
    int j;
    if (i < n)
    {
      locale = arrayOfe[i];
      if (locale.getDesc().charAt(0) == m)
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
      if (locale == null) {
        break label157;
      }
      paramString = (j)new j.d(locale);
      AppMethodBeat.o(58209);
      return paramString;
      j = 0;
      break label110;
      label144:
      i += 1;
      break;
      locale = null;
    }
    label157:
    if (m == 86)
    {
      paramString = (j)new j.d(null);
      AppMethodBeat.o(58209);
      return paramString;
    }
    if (m == 91)
    {
      paramString = paramString.substring(1);
      s.s(paramString, "(this as java.lang.String).substring(startIndex)");
      paramString = (j)new j.a(bIU(paramString));
      AppMethodBeat.o(58209);
      return paramString;
    }
    i = k;
    if (m == 76)
    {
      i = k;
      if (n.a((CharSequence)paramString, ';')) {
        i = 1;
      }
    }
    if ((ak.aiuY) && (i == 0))
    {
      paramString = (Throwable)new AssertionError("Type that is not primitive nor array should be Object, but '" + paramString + "' was found");
      AppMethodBeat.o(58209);
      throw paramString;
    }
    paramString = paramString.substring(1, paramString.length() - 1);
    s.s(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    paramString = (j)new j.c(paramString);
    AppMethodBeat.o(58209);
    return paramString;
  }
  
  private static j.c bIV(String paramString)
  {
    AppMethodBeat.i(58211);
    s.u(paramString, "internalName");
    paramString = new j.c(paramString);
    AppMethodBeat.o(58211);
    return paramString;
  }
  
  public final String a(j paramj)
  {
    AppMethodBeat.i(58213);
    s.u(paramj, "type");
    if ((paramj instanceof j.a))
    {
      paramj = s.X("[", a(((j.a)paramj).aiWV));
      AppMethodBeat.o(58213);
      return paramj;
    }
    if ((paramj instanceof j.d))
    {
      paramj = ((j.d)paramj).aiWX;
      if (paramj == null)
      {
        AppMethodBeat.o(58213);
        return "V";
      }
      paramj = paramj.getDesc();
      if (paramj == null)
      {
        AppMethodBeat.o(58213);
        return "V";
      }
      AppMethodBeat.o(58213);
      return paramj;
    }
    if ((paramj instanceof j.c))
    {
      paramj = "L" + ((j.c)paramj).aiWW + ';';
      AppMethodBeat.o(58213);
      return paramj;
    }
    paramj = new p();
    AppMethodBeat.o(58213);
    throw paramj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.l
 * JD-Core Version:    0.7.0.1
 */