package d.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"numberFormatError", "", "input", "", "toByteOrNull", "", "(Ljava/lang/String;)Ljava/lang/Byte;", "radix", "", "(Ljava/lang/String;I)Ljava/lang/Byte;", "toIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "(Ljava/lang/String;I)Ljava/lang/Integer;", "toLongOrNull", "", "(Ljava/lang/String;)Ljava/lang/Long;", "(Ljava/lang/String;I)Ljava/lang/Long;", "toShortOrNull", "", "(Ljava/lang/String;)Ljava/lang/Short;", "(Ljava/lang/String;I)Ljava/lang/Short;", "kotlin-stdlib"}, fvw=1)
public class v
  extends u
{
  public static final Integer aRf(String paramString)
  {
    AppMethodBeat.i(129444);
    k.h(paramString, "$this$toIntOrNull");
    paramString = n.gJ(paramString, 10);
    AppMethodBeat.o(129444);
    return paramString;
  }
  
  public static final Long aRg(String paramString)
  {
    AppMethodBeat.i(129446);
    k.h(paramString, "$this$toLongOrNull");
    paramString = n.gK(paramString, 10);
    AppMethodBeat.o(129446);
    return paramString;
  }
  
  public static final Integer gJ(String paramString, int paramInt)
  {
    int k = -2147483647;
    int n = 0;
    AppMethodBeat.i(129445);
    k.h(paramString, "$this$toIntOrNull");
    a.agb(paramInt);
    int i2 = paramString.length();
    if (i2 == 0)
    {
      AppMethodBeat.o(129445);
      return null;
    }
    int i = paramString.charAt(0);
    int j;
    int i1;
    int m;
    if (i < 48)
    {
      if (i2 == 1)
      {
        AppMethodBeat.o(129445);
        return null;
      }
      if (i == 45)
      {
        k = -2147483648;
        i = 1;
        j = 1;
        i1 = -59652323;
        m = i;
        i = i1;
      }
    }
    for (;;)
    {
      if (m >= i2) {
        break label229;
      }
      int i3 = Character.digit(paramString.charAt(m), paramInt);
      if (i3 < 0)
      {
        AppMethodBeat.o(129445);
        return null;
        if (i == 43)
        {
          i = 1;
          j = 0;
          break;
        }
        AppMethodBeat.o(129445);
        return null;
        i = 0;
        j = 0;
        break;
      }
      if (n < i) {
        if (i == -59652323)
        {
          i1 = k / paramInt;
          i = i1;
          if (n < i1)
          {
            AppMethodBeat.o(129445);
            return null;
          }
        }
        else
        {
          AppMethodBeat.o(129445);
          return null;
        }
      }
      n *= paramInt;
      if (n < k + i3)
      {
        AppMethodBeat.o(129445);
        return null;
      }
      n -= i3;
      m += 1;
    }
    label229:
    if (j != 0)
    {
      AppMethodBeat.o(129445);
      return Integer.valueOf(n);
    }
    paramInt = -n;
    AppMethodBeat.o(129445);
    return Integer.valueOf(paramInt);
  }
  
  public static final Long gK(String paramString, int paramInt)
  {
    long l2 = -9223372036854775807L;
    AppMethodBeat.i(129447);
    k.h(paramString, "$this$toLongOrNull");
    a.agb(paramInt);
    int k = paramString.length();
    if (k == 0)
    {
      AppMethodBeat.o(129447);
      return null;
    }
    int i = paramString.charAt(0);
    int j;
    long l3;
    if (i < 48)
    {
      if (k == 1)
      {
        AppMethodBeat.o(129447);
        return null;
      }
      if (i == 45)
      {
        l2 = -9223372036854775808L;
        i = 1;
        j = 1;
        l1 = -256204778801521550L;
        l3 = 0L;
      }
    }
    for (;;)
    {
      if (i >= k) {
        break label234;
      }
      int m = Character.digit(paramString.charAt(i), paramInt);
      if (m < 0)
      {
        AppMethodBeat.o(129447);
        return null;
        if (i == 43)
        {
          i = 1;
          j = 0;
          break;
        }
        AppMethodBeat.o(129447);
        return null;
        i = 0;
        j = 0;
        break;
      }
      if (l3 < l1) {
        if (l1 == -256204778801521550L)
        {
          long l4 = l2 / paramInt;
          l1 = l4;
          if (l3 < l4)
          {
            AppMethodBeat.o(129447);
            return null;
          }
        }
        else
        {
          AppMethodBeat.o(129447);
          return null;
        }
      }
      l3 = paramInt * l3;
      if (l3 < m + l2)
      {
        AppMethodBeat.o(129447);
        return null;
      }
      l3 -= m;
      i += 1;
    }
    label234:
    if (j != 0)
    {
      AppMethodBeat.o(129447);
      return Long.valueOf(l3);
    }
    long l1 = -l3;
    AppMethodBeat.o(129447);
    return Long.valueOf(l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.n.v
 * JD-Core Version:    0.7.0.1
 */