package d.l.b.a.b.n.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.n.n;
import java.util.Iterator;

public final class a
{
  public static final String aWV(String paramString)
  {
    AppMethodBeat.i(61336);
    k.h(paramString, "$this$decapitalizeSmartForCompiler");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; (i != 0) || (!gO(paramString, 0)); i = 0)
    {
      AppMethodBeat.o(61336);
      return paramString;
    }
    if ((paramString.length() == 1) || (!gO(paramString, 1)))
    {
      k.h(paramString, "$this$decapitalizeAsciiOnly");
      if (((CharSequence)paramString).length() == 0)
      {
        i = 1;
        if (i == 0)
        {
          c = paramString.charAt(0);
          if ('A' <= c) {
            break label113;
          }
        }
      }
      label113:
      while ('Z' < c)
      {
        AppMethodBeat.o(61336);
        return paramString;
        i = 0;
        break;
      }
      char c = Character.toLowerCase(c);
      paramString = paramString.substring(1);
      k.g(paramString, "(this as java.lang.String).substring(startIndex)");
      paramString = String.valueOf(c) + paramString;
      AppMethodBeat.o(61336);
      return paramString;
    }
    Object localObject2 = ((Iterable)n.aF((CharSequence)paramString)).iterator();
    Object localObject1;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (!gO(paramString, ((Number)localObject1).intValue()))
      {
        i = 1;
        label216:
        if (i == 0) {
          break label300;
        }
      }
    }
    for (;;)
    {
      localObject1 = (Integer)localObject1;
      if (localObject1 == null) {
        break label307;
      }
      i = ((Integer)localObject1).intValue() - 1;
      localObject1 = new StringBuilder();
      localObject2 = paramString.substring(0, i);
      k.g(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      localObject1 = ((StringBuilder)localObject1).append(aWW((String)localObject2));
      paramString = paramString.substring(i);
      k.g(paramString, "(this as java.lang.String).substring(startIndex)");
      paramString = paramString;
      AppMethodBeat.o(61336);
      return paramString;
      i = 0;
      break label216;
      label300:
      break;
      localObject1 = null;
    }
    label307:
    paramString = aWW(paramString);
    AppMethodBeat.o(61336);
    return paramString;
  }
  
  private static final String aWW(String paramString)
  {
    AppMethodBeat.i(61338);
    paramString = aWY(paramString);
    AppMethodBeat.o(61338);
    return paramString;
  }
  
  public static final String aWX(String paramString)
  {
    AppMethodBeat.i(61339);
    k.h(paramString, "$this$capitalizeAsciiOnly");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(61339);
      return paramString;
    }
    char c = paramString.charAt(0);
    if ('a' > c) {}
    while ('z' < c)
    {
      AppMethodBeat.o(61339);
      return paramString;
    }
    c = Character.toUpperCase(c);
    paramString = paramString.substring(1);
    k.g(paramString, "(this as java.lang.String).substring(startIndex)");
    paramString = String.valueOf(c) + paramString;
    AppMethodBeat.o(61339);
    return paramString;
  }
  
  private static String aWY(String paramString)
  {
    AppMethodBeat.i(61340);
    k.h(paramString, "$this$toLowerCaseAsciiOnly");
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    int j = paramString.length();
    int i = 0;
    if (i < j)
    {
      char c = paramString.charAt(i);
      if ('A' > c) {}
      for (;;)
      {
        localStringBuilder.append(c);
        i += 1;
        break;
        if ('Z' >= c) {
          c = Character.toLowerCase(c);
        }
      }
    }
    paramString = localStringBuilder.toString();
    k.g(paramString, "builder.toString()");
    AppMethodBeat.o(61340);
    return paramString;
  }
  
  private static final boolean gO(String paramString, int paramInt)
  {
    AppMethodBeat.i(61337);
    paramInt = paramString.charAt(paramInt);
    if (65 > paramInt) {}
    while (90 < paramInt)
    {
      AppMethodBeat.o(61337);
      return false;
    }
    AppMethodBeat.o(61337);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.n.a.a
 * JD-Core Version:    0.7.0.1
 */