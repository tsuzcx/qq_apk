package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"numberFormatError", "", "input", "", "toByteOrNull", "", "(Ljava/lang/String;)Ljava/lang/Byte;", "radix", "", "(Ljava/lang/String;I)Ljava/lang/Byte;", "toIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "(Ljava/lang/String;I)Ljava/lang/Integer;", "toLongOrNull", "", "(Ljava/lang/String;)Ljava/lang/Long;", "(Ljava/lang/String;I)Ljava/lang/Long;", "toShortOrNull", "", "(Ljava/lang/String;)Ljava/lang/Short;", "(Ljava/lang/String;I)Ljava/lang/Short;", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/text/StringsKt")
public class v
  extends u
{
  public static final Integer bJF(String paramString)
  {
    AppMethodBeat.i(129444);
    s.u(paramString, "$this$toIntOrNull");
    paramString = n.bJG(paramString);
    AppMethodBeat.o(129444);
    return paramString;
  }
  
  public static final Integer bJG(String paramString)
  {
    int k = -2147483647;
    int n = 0;
    AppMethodBeat.i(190921);
    s.u(paramString, "$this$toIntOrNull");
    a.aMy(10);
    int i2 = paramString.length();
    if (i2 == 0)
    {
      AppMethodBeat.o(190921);
      return null;
    }
    int i = paramString.charAt(0);
    int j;
    int i1;
    int m;
    if (s.compare(i, 48) < 0)
    {
      if (i2 == 1)
      {
        AppMethodBeat.o(190921);
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
        break label232;
      }
      int i3 = Character.digit(paramString.charAt(m), 10);
      if (i3 < 0)
      {
        AppMethodBeat.o(190921);
        return null;
        if (i == 43)
        {
          i = 1;
          j = 0;
          break;
        }
        AppMethodBeat.o(190921);
        return null;
        i = 0;
        j = 0;
        break;
      }
      if (n < i) {
        if (i == -59652323)
        {
          i1 = k / 10;
          i = i1;
          if (n < i1)
          {
            AppMethodBeat.o(190921);
            return null;
          }
        }
        else
        {
          AppMethodBeat.o(190921);
          return null;
        }
      }
      n *= 10;
      if (n < k + i3)
      {
        AppMethodBeat.o(190921);
        return null;
      }
      n -= i3;
      m += 1;
    }
    label232:
    if (j != 0)
    {
      AppMethodBeat.o(190921);
      return Integer.valueOf(n);
    }
    i = -n;
    AppMethodBeat.o(190921);
    return Integer.valueOf(i);
  }
  
  public static final Long bJH(String paramString)
  {
    AppMethodBeat.i(129446);
    s.u(paramString, "$this$toLongOrNull");
    paramString = n.bJI(paramString);
    AppMethodBeat.o(129446);
    return paramString;
  }
  
  public static final Long bJI(String paramString)
  {
    AppMethodBeat.i(190927);
    s.u(paramString, "$this$toLongOrNull");
    a.aMy(10);
    int k = paramString.length();
    if (k == 0)
    {
      AppMethodBeat.o(190927);
      return null;
    }
    int i = paramString.charAt(0);
    int j;
    long l2;
    long l3;
    if (s.compare(i, 48) < 0)
    {
      if (k == 1)
      {
        AppMethodBeat.o(190927);
        return null;
      }
      if (i == 45)
      {
        l1 = -9223372036854775808L;
        i = 1;
        j = 1;
        l2 = -256204778801521550L;
        l3 = 0L;
      }
    }
    for (;;)
    {
      if (i >= k) {
        break label242;
      }
      int m = Character.digit(paramString.charAt(i), 10);
      if (m < 0)
      {
        AppMethodBeat.o(190927);
        return null;
        if (i == 43)
        {
          l1 = -9223372036854775807L;
          i = 1;
          j = 0;
          break;
        }
        AppMethodBeat.o(190927);
        return null;
        l1 = -9223372036854775807L;
        i = 0;
        j = 0;
        break;
      }
      if (l3 < l2) {
        if (l2 == -256204778801521550L)
        {
          long l4 = l1 / 10L;
          l2 = l4;
          if (l3 < l4)
          {
            AppMethodBeat.o(190927);
            return null;
          }
        }
        else
        {
          AppMethodBeat.o(190927);
          return null;
        }
      }
      l3 = 10L * l3;
      if (l3 < m + l1)
      {
        AppMethodBeat.o(190927);
        return null;
      }
      l3 -= m;
      i += 1;
    }
    label242:
    if (j != 0)
    {
      AppMethodBeat.o(190927);
      return Long.valueOf(l3);
    }
    long l1 = -l3;
    AppMethodBeat.o(190927);
    return Long.valueOf(l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.n.v
 * JD-Core Version:    0.7.0.1
 */