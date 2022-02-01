package kotlin.l.b.a.b.n.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.g.b.s;
import kotlin.n.n;

public final class a
{
  public static final String bJw(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(61336);
    s.u(paramString, "<this>");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; (i != 0) || (!jN(paramString, 0)); i = 0)
    {
      AppMethodBeat.o(61336);
      return paramString;
    }
    if ((paramString.length() == 1) || (!jN(paramString, 1)))
    {
      s.u(paramString, "<this>");
      if (((CharSequence)paramString).length() == 0) {}
      for (i = 1; i == 0; i = 0)
      {
        char c = paramString.charAt(0);
        i = j;
        if ('A' <= c)
        {
          i = j;
          if (c <= 'Z') {
            i = 1;
          }
        }
        if (i == 0) {
          break;
        }
        c = Character.toLowerCase(c);
        paramString = paramString.substring(1);
        s.s(paramString, "(this as java.lang.String).substring(startIndex)");
        paramString = String.valueOf(c) + paramString;
        AppMethodBeat.o(61336);
        return paramString;
      }
      AppMethodBeat.o(61336);
      return paramString;
    }
    Iterator localIterator = ((Iterable)n.bs((CharSequence)paramString)).iterator();
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (!jN(paramString, ((Number)localObject).intValue()))
      {
        i = 1;
        label230:
        if (i == 0) {
          break label261;
        }
      }
    }
    for (;;)
    {
      localObject = (Integer)localObject;
      if (localObject != null) {
        break label269;
      }
      paramString = bJx(paramString);
      AppMethodBeat.o(61336);
      return paramString;
      i = 0;
      break label230;
      label261:
      break;
      localObject = null;
    }
    label269:
    i = ((Integer)localObject).intValue() - 1;
    Object localObject = paramString.substring(0, i);
    s.s(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    localObject = bJx((String)localObject);
    paramString = paramString.substring(i);
    s.s(paramString, "(this as java.lang.String).substring(startIndex)");
    paramString = s.X((String)localObject, paramString);
    AppMethodBeat.o(61336);
    return paramString;
  }
  
  private static final String bJx(String paramString)
  {
    AppMethodBeat.i(61338);
    paramString = bJz(paramString);
    AppMethodBeat.o(61338);
    return paramString;
  }
  
  public static final String bJy(String paramString)
  {
    AppMethodBeat.i(61339);
    s.u(paramString, "<this>");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(61339);
      return paramString;
    }
    char c = paramString.charAt(0);
    if ('a' <= c) {
      if (c <= 'z') {
        i = 1;
      }
    }
    while (i != 0)
    {
      c = Character.toUpperCase(c);
      paramString = paramString.substring(1);
      s.s(paramString, "(this as java.lang.String).substring(startIndex)");
      paramString = String.valueOf(c) + paramString;
      AppMethodBeat.o(61339);
      return paramString;
      i = 0;
      continue;
      i = 0;
    }
    AppMethodBeat.o(61339);
    return paramString;
  }
  
  public static final String bJz(String paramString)
  {
    AppMethodBeat.i(61340);
    s.u(paramString, "<this>");
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    int k = paramString.length();
    int j = 0;
    if (j < k)
    {
      char c2 = paramString.charAt(j);
      int i;
      if ('A' <= c2) {
        if (c2 <= 'Z') {
          i = 1;
        }
      }
      for (;;)
      {
        char c1 = c2;
        if (i != 0) {
          c1 = Character.toLowerCase(c2);
        }
        localStringBuilder.append(c1);
        j += 1;
        break;
        i = 0;
        continue;
        i = 0;
      }
    }
    paramString = localStringBuilder.toString();
    s.s(paramString, "builder.toString()");
    AppMethodBeat.o(61340);
    return paramString;
  }
  
  private static final boolean jN(String paramString, int paramInt)
  {
    AppMethodBeat.i(61337);
    paramInt = paramString.charAt(paramInt);
    if (65 <= paramInt)
    {
      if (paramInt <= 90)
      {
        AppMethodBeat.o(61337);
        return true;
      }
      AppMethodBeat.o(61337);
      return false;
    }
    AppMethodBeat.o(61337);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlin.l.b.a.b.n.a.a
 * JD-Core Version:    0.7.0.1
 */