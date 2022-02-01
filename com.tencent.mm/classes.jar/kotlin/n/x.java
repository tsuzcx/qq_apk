package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k.g;
import kotlin.m.h;
import kotlin.r;

@Metadata(d1={""}, d2={"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "(Ljava/lang/CharSequence;)I", "requireNonNegativeLimit", "", "limit", "commonPrefixWith", "", "other", "ignoreCase", "", "commonSuffixWith", "contains", "char", "", "regex", "Lkotlin/text/Regex;", "contentEqualsIgnoreCaseImpl", "contentEqualsImpl", "endsWith", "suffix", "findAnyOf", "Lkotlin/Pair;", "strings", "", "startIndex", "last", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "hasSurrogatePairAt", "index", "ifBlank", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifEmpty", "indexOf", "endIndex", "indexOf$StringsKt__StringsKt", "string", "indexOfAny", "chars", "", "isEmpty", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "iterator", "Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "lineSequence", "Lkotlin/sequences/Sequence;", "lines", "", "matches", "orEmpty", "padEnd", "length", "padChar", "padStart", "rangesDelimitedBy", "delimiters", "", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "regionMatchesImpl", "thisOffset", "otherOffset", "removePrefix", "prefix", "removeRange", "range", "removeSuffix", "removeSurrounding", "delimiter", "replace", "transform", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "replacement", "replaceAfter", "missingDelimiterValue", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceFirstChar", "replaceFirstCharWithChar", "replaceFirstCharWithCharSequence", "replaceRange", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "startsWith", "subSequence", "start", "end", "substring", "substringAfter", "substringAfterLast", "substringBefore", "substringBeforeLast", "toBooleanStrict", "toBooleanStrictOrNull", "(Ljava/lang/String;)Ljava/lang/Boolean;", "trim", "predicate", "trimEnd", "trimStart", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/text/StringsKt")
public class x
  extends w
{
  public static final int a(CharSequence paramCharSequence, char paramChar, int paramInt)
  {
    AppMethodBeat.i(129404);
    s.u(paramCharSequence, "$this$lastIndexOf");
    if (!(paramCharSequence instanceof String))
    {
      char[] arrayOfChar = new char[1];
      arrayOfChar[0] = paramChar;
      s.u(paramCharSequence, "$this$lastIndexOfAny");
      s.u(arrayOfChar, "chars");
      int i;
      if ((paramCharSequence instanceof String))
      {
        i = kotlin.a.k.d(arrayOfChar);
        paramInt = ((String)paramCharSequence).lastIndexOf(i, paramInt);
        AppMethodBeat.o(129404);
        return paramInt;
      }
      paramInt = kotlin.k.k.qv(paramInt, n.bt(paramCharSequence));
      while (paramInt >= 0)
      {
        paramChar = paramCharSequence.charAt(paramInt);
        i = 0;
        if (i <= 0) {
          if (!a.a(arrayOfChar[i], paramChar, false)) {}
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label135;
          }
          AppMethodBeat.o(129404);
          return paramInt;
          i += 1;
          break;
        }
        label135:
        paramInt -= 1;
      }
      AppMethodBeat.o(129404);
      return -1;
    }
    paramInt = ((String)paramCharSequence).lastIndexOf(paramChar, paramInt);
    AppMethodBeat.o(129404);
    return paramInt;
  }
  
  public static final int a(CharSequence paramCharSequence, char paramChar, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(191017);
    s.u(paramCharSequence, "$this$indexOf");
    if ((paramBoolean) || (!(paramCharSequence instanceof String)))
    {
      paramInt = n.a(paramCharSequence, new char[] { paramChar }, paramInt, paramBoolean);
      AppMethodBeat.o(191017);
      return paramInt;
    }
    paramInt = ((String)paramCharSequence).indexOf(paramChar, paramInt);
    AppMethodBeat.o(191017);
    return paramInt;
  }
  
  private static final int a(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(129398);
    kotlin.k.e locale;
    int i;
    int j;
    if (!paramBoolean2)
    {
      locale = (kotlin.k.e)new g(kotlin.k.k.qu(paramInt1, 0), kotlin.k.k.qv(paramInt2, paramCharSequence1.length()));
      if ((!(paramCharSequence1 instanceof String)) || (!(paramCharSequence2 instanceof String))) {
        break label165;
      }
      paramInt2 = locale.fIj;
      i = locale.aixs;
      j = locale.rBp;
      if (j < 0) {
        break label136;
      }
      if (paramInt2 > i) {
        break label144;
      }
      paramInt1 = paramInt2;
    }
    label136:
    do
    {
      if (!n.a((String)paramCharSequence2, 0, (String)paramCharSequence1, paramInt1, paramCharSequence2.length(), paramBoolean1)) {
        break label151;
      }
      AppMethodBeat.o(129398);
      return paramInt1;
      locale = kotlin.k.k.qs(kotlin.k.k.qv(paramInt1, n.bt(paramCharSequence1)), kotlin.k.k.qu(paramInt2, 0));
      break;
      paramInt1 = paramInt2;
    } while (paramInt2 >= i);
    label144:
    label151:
    label165:
    do
    {
      do
      {
        AppMethodBeat.o(129398);
        return -1;
      } while (paramInt1 == i);
      paramInt1 += j;
      break;
      paramInt1 = locale.fIj;
      paramInt2 = locale.aixs;
      i = locale.rBp;
      if (i < 0) {
        break label219;
      }
    } while (paramInt1 > paramInt2);
    for (;;)
    {
      if (n.a(paramCharSequence2, 0, paramCharSequence1, paramInt1, paramCharSequence2.length(), paramBoolean1))
      {
        AppMethodBeat.o(129398);
        return paramInt1;
        label219:
        if (paramInt1 < paramInt2) {
          break;
        }
        continue;
      }
      if (paramInt1 == paramInt2) {
        break;
      }
      paramInt1 += i;
    }
  }
  
  public static final int a(CharSequence paramCharSequence, String paramString, int paramInt)
  {
    AppMethodBeat.i(129406);
    s.u(paramCharSequence, "$this$lastIndexOf");
    s.u(paramString, "string");
    if (!(paramCharSequence instanceof String))
    {
      paramInt = a(paramCharSequence, (CharSequence)paramString, paramInt, 0, false, true);
      AppMethodBeat.o(129406);
      return paramInt;
    }
    paramInt = ((String)paramCharSequence).lastIndexOf(paramString, paramInt);
    AppMethodBeat.o(129406);
    return paramInt;
  }
  
  public static final int a(CharSequence paramCharSequence, String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(129402);
    s.u(paramCharSequence, "$this$indexOf");
    s.u(paramString, "string");
    if ((paramBoolean) || (!(paramCharSequence instanceof String)))
    {
      paramInt = a(paramCharSequence, (CharSequence)paramString, paramInt, paramCharSequence.length(), paramBoolean);
      AppMethodBeat.o(129402);
      return paramInt;
    }
    paramInt = ((String)paramCharSequence).indexOf(paramString, paramInt);
    AppMethodBeat.o(129402);
    return paramInt;
  }
  
  public static final int a(CharSequence paramCharSequence, char[] paramArrayOfChar, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(168698);
    s.u(paramCharSequence, "$this$indexOfAny");
    s.u(paramArrayOfChar, "chars");
    int i;
    if ((!paramBoolean) && (paramArrayOfChar.length == 1) && ((paramCharSequence instanceof String)))
    {
      i = kotlin.a.k.d(paramArrayOfChar);
      paramInt = ((String)paramCharSequence).indexOf(i, paramInt);
      AppMethodBeat.o(168698);
      return paramInt;
    }
    paramInt = kotlin.k.k.qu(paramInt, 0);
    int j = n.bt(paramCharSequence);
    if (paramInt <= j) {
      for (;;)
      {
        char c = paramCharSequence.charAt(paramInt);
        int k = paramArrayOfChar.length;
        i = 0;
        if (i < k) {
          if (!a.a(paramArrayOfChar[i], c, paramBoolean)) {}
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label146;
          }
          AppMethodBeat.o(168698);
          return paramInt;
          i += 1;
          break;
        }
        label146:
        if (paramInt == j) {
          break;
        }
        paramInt += 1;
      }
    }
    AppMethodBeat.o(168698);
    return -1;
  }
  
  public static final CharSequence a(CharSequence paramCharSequence1, int paramInt1, int paramInt2, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(129391);
    s.u(paramCharSequence1, "$this$replaceRange");
    s.u(paramCharSequence2, "replacement");
    if (paramInt2 < paramInt1)
    {
      paramCharSequence1 = (Throwable)new IndexOutOfBoundsException("End index (" + paramInt2 + ") is less than start index (" + paramInt1 + ").");
      AppMethodBeat.o(129391);
      throw paramCharSequence1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    s.s(localStringBuilder.append(paramCharSequence1, 0, paramInt1), "this.append(value, startIndex, endIndex)");
    localStringBuilder.append(paramCharSequence2);
    s.s(localStringBuilder.append(paramCharSequence1, paramInt2, paramCharSequence1.length()), "this.append(value, startIndex, endIndex)");
    paramCharSequence1 = (CharSequence)localStringBuilder;
    AppMethodBeat.o(129391);
    return paramCharSequence1;
  }
  
  public static final String a(CharSequence paramCharSequence, g paramg)
  {
    AppMethodBeat.i(129380);
    s.u(paramCharSequence, "$this$substring");
    s.u(paramg, "range");
    paramCharSequence = paramCharSequence.subSequence(paramg.fIj, paramg.aixs + 1).toString();
    AppMethodBeat.o(129380);
    return paramCharSequence;
  }
  
  public static final String a(String paramString1, char paramChar, String paramString2)
  {
    AppMethodBeat.i(190947);
    s.u(paramString1, "$this$substringBefore");
    s.u(paramString2, "missingDelimiterValue");
    int i = n.a((CharSequence)paramString1, paramChar, 0, false, 6);
    if (i == -1)
    {
      AppMethodBeat.o(190947);
      return paramString2;
    }
    paramString1 = paramString1.substring(0, i);
    s.s(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(190947);
    return paramString1;
  }
  
  public static final String a(String paramString, g paramg)
  {
    AppMethodBeat.i(190938);
    s.u(paramString, "$this$substring");
    s.u(paramg, "range");
    paramString = paramString.substring(paramg.fIj, paramg.aixs + 1);
    s.s(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(190938);
    return paramString;
  }
  
  public static final String a(String paramString, char... paramVarArgs)
  {
    AppMethodBeat.i(129376);
    s.u(paramString, "$this$trimEnd");
    s.u(paramVarArgs, "chars");
    paramString = (CharSequence)paramString;
    int i = paramString.length() - 1;
    if (i >= 0) {
      if (kotlin.a.k.contains(paramVarArgs, paramString.charAt(i))) {}
    }
    for (paramString = paramString.subSequence(0, i + 1);; paramString = (CharSequence)"")
    {
      paramString = paramString.toString();
      AppMethodBeat.o(129376);
      return paramString;
      i -= 1;
      break;
    }
  }
  
  private static final List<String> a(CharSequence paramCharSequence, String paramString, boolean paramBoolean, int paramInt)
  {
    int j = 10;
    AppMethodBeat.i(191153);
    n.aMA(paramInt);
    int k = n.a(paramCharSequence, paramString, 0, false);
    if ((k == -1) || (paramInt == 1))
    {
      paramCharSequence = p.listOf(paramCharSequence.toString());
      AppMethodBeat.o(191153);
      return paramCharSequence;
    }
    int i;
    ArrayList localArrayList;
    if (paramInt > 0)
    {
      i = 1;
      if (i != 0) {
        j = kotlin.k.k.qv(paramInt, 10);
      }
      localArrayList = new ArrayList(j);
      j = k;
      k = 0;
    }
    for (;;)
    {
      localArrayList.add(paramCharSequence.subSequence(k, j).toString());
      k = paramString.length() + j;
      if ((i == 0) || (localArrayList.size() != paramInt - 1))
      {
        j = n.a(paramCharSequence, paramString, k, false);
        if (j != -1) {}
      }
      else
      {
        localArrayList.add(paramCharSequence.subSequence(k, paramCharSequence.length()).toString());
        paramCharSequence = (List)localArrayList;
        AppMethodBeat.o(191153);
        return paramCharSequence;
        i = 0;
        break;
      }
    }
  }
  
  public static final List<String> a(CharSequence paramCharSequence, char[] paramArrayOfChar, int paramInt)
  {
    AppMethodBeat.i(191144);
    s.u(paramCharSequence, "$this$split");
    s.u(paramArrayOfChar, "delimiters");
    if (paramArrayOfChar.length == 1)
    {
      paramCharSequence = a(paramCharSequence, String.valueOf(paramArrayOfChar[0]), false, paramInt);
      AppMethodBeat.o(191144);
      return paramCharSequence;
    }
    n.aMA(paramInt);
    Object localObject = kotlin.m.k.g((h)new e(paramCharSequence, paramInt, (m)new a(paramArrayOfChar, false)));
    paramArrayOfChar = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramArrayOfChar.add(n.a(paramCharSequence, (g)((Iterator)localObject).next()));
    }
    paramCharSequence = (List)paramArrayOfChar;
    AppMethodBeat.o(191144);
    return paramCharSequence;
  }
  
  public static final List<String> a(CharSequence paramCharSequence, String[] paramArrayOfString)
  {
    AppMethodBeat.i(129415);
    s.u(paramCharSequence, "$this$split");
    s.u(paramArrayOfString, "delimiters");
    if (paramArrayOfString.length == 1)
    {
      localObject = paramArrayOfString[0];
      if (((CharSequence)localObject).length() == 0) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramCharSequence = a(paramCharSequence, (String)localObject, false, 0);
        AppMethodBeat.o(129415);
        return paramCharSequence;
      }
    }
    Object localObject = kotlin.m.k.g(a(paramCharSequence, paramArrayOfString, false, 0));
    paramArrayOfString = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramArrayOfString.add(n.a(paramCharSequence, (g)((Iterator)localObject).next()));
    }
    paramCharSequence = (List)paramArrayOfString;
    AppMethodBeat.o(129415);
    return paramCharSequence;
  }
  
  public static final boolean a(CharSequence paramCharSequence, char paramChar)
  {
    AppMethodBeat.i(129395);
    s.u(paramCharSequence, "$this$endsWith");
    if ((paramCharSequence.length() > 0) && (a.a(paramCharSequence.charAt(n.bt(paramCharSequence)), paramChar, false)))
    {
      AppMethodBeat.o(129395);
      return true;
    }
    AppMethodBeat.o(129395);
    return false;
  }
  
  public static final boolean a(CharSequence paramCharSequence1, int paramInt1, CharSequence paramCharSequence2, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(190994);
    s.u(paramCharSequence1, "$this$regionMatchesImpl");
    s.u(paramCharSequence2, "other");
    if ((paramInt2 < 0) || (paramInt1 < 0) || (paramInt1 > paramCharSequence1.length() - paramInt3) || (paramInt2 > paramCharSequence2.length() - paramInt3))
    {
      AppMethodBeat.o(190994);
      return false;
    }
    int i = 0;
    while (i < paramInt3)
    {
      if (!a.a(paramCharSequence1.charAt(paramInt1 + i), paramCharSequence2.charAt(paramInt2 + i), paramBoolean))
      {
        AppMethodBeat.o(190994);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(190994);
    return true;
  }
  
  public static final boolean a(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean)
  {
    AppMethodBeat.i(129408);
    s.u(paramCharSequence1, "$this$contains");
    s.u(paramCharSequence2, "other");
    if ((paramCharSequence2 instanceof String))
    {
      if (n.a(paramCharSequence1, (String)paramCharSequence2, 0, paramBoolean, 2) >= 0)
      {
        AppMethodBeat.o(129408);
        return true;
      }
      AppMethodBeat.o(129408);
      return false;
    }
    if (a(paramCharSequence1, paramCharSequence2, 0, paramCharSequence1.length(), paramBoolean) >= 0)
    {
      AppMethodBeat.o(129408);
      return true;
    }
    AppMethodBeat.o(129408);
    return false;
  }
  
  public static final void aMA(int paramInt)
  {
    AppMethodBeat.i(191130);
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      Throwable localThrowable = (Throwable)new IllegalArgumentException("Limit must be non-negative, but was ".concat(String.valueOf(paramInt)).toString());
      AppMethodBeat.o(191130);
      throw localThrowable;
    }
    AppMethodBeat.o(191130);
  }
  
  public static final String b(String paramString1, char paramChar, String paramString2)
  {
    AppMethodBeat.i(190962);
    s.u(paramString1, "$this$substringBeforeLast");
    s.u(paramString2, "missingDelimiterValue");
    int i = n.b((CharSequence)paramString1, paramChar);
    if (i == -1)
    {
      AppMethodBeat.o(190962);
      return paramString2;
    }
    paramString1 = paramString1.substring(0, i);
    s.s(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(190962);
    return paramString1;
  }
  
  public static final String bX(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(129382);
    s.u(paramString1, "$this$substringBefore");
    s.u(paramString2, "delimiter");
    s.u(paramString3, "missingDelimiterValue");
    int i = n.a((CharSequence)paramString1, paramString2, 0, false, 6);
    if (i == -1)
    {
      AppMethodBeat.o(129382);
      return paramString3;
    }
    paramString1 = paramString1.substring(0, i);
    s.s(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(129382);
    return paramString1;
  }
  
  public static final String bY(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(129384);
    s.u(paramString1, "$this$substringAfter");
    s.u(paramString2, "delimiter");
    s.u(paramString3, "missingDelimiterValue");
    int i = n.a((CharSequence)paramString1, paramString2, 0, false, 6);
    if (i == -1)
    {
      AppMethodBeat.o(129384);
      return paramString3;
    }
    paramString1 = paramString1.substring(i + paramString2.length(), paramString1.length());
    s.s(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(129384);
    return paramString1;
  }
  
  public static final String bZ(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(129389);
    s.u(paramString1, "$this$substringAfterLast");
    s.u(paramString2, "delimiter");
    s.u(paramString3, "missingDelimiterValue");
    int i = n.g((CharSequence)paramString1, paramString2);
    if (i == -1)
    {
      AppMethodBeat.o(129389);
      return paramString3;
    }
    paramString1 = paramString1.substring(i + paramString2.length(), paramString1.length());
    s.s(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(129389);
    return paramString1;
  }
  
  public static final CharSequence bq(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(129377);
    s.u(paramCharSequence, "$this$trim");
    int i = paramCharSequence.length() - 1;
    int k = 0;
    int j = 0;
    while (j <= i)
    {
      if (k == 0) {}
      boolean bool;
      for (int m = j;; m = i)
      {
        bool = a.I(paramCharSequence.charAt(m));
        if (k != 0) {
          break label78;
        }
        if (bool) {
          break label71;
        }
        k = 1;
        break;
      }
      label71:
      j += 1;
      continue;
      label78:
      if (!bool) {
        break;
      }
      i -= 1;
    }
    paramCharSequence = paramCharSequence.subSequence(j, i + 1);
    AppMethodBeat.o(129377);
    return paramCharSequence;
  }
  
  public static final CharSequence br(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(168697);
    s.u(paramCharSequence, "$this$trimStart");
    int i = 0;
    int j = paramCharSequence.length();
    while (i < j)
    {
      if (!a.I(paramCharSequence.charAt(i)))
      {
        paramCharSequence = paramCharSequence.subSequence(i, paramCharSequence.length());
        AppMethodBeat.o(168697);
        return paramCharSequence;
      }
      i += 1;
    }
    paramCharSequence = (CharSequence)"";
    AppMethodBeat.o(168697);
    return paramCharSequence;
  }
  
  public static final g bs(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(129378);
    s.u(paramCharSequence, "$this$indices");
    paramCharSequence = new g(0, paramCharSequence.length() - 1);
    AppMethodBeat.o(129378);
    return paramCharSequence;
  }
  
  public static final int bt(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(129379);
    s.u(paramCharSequence, "$this$lastIndex");
    int i = paramCharSequence.length();
    AppMethodBeat.o(129379);
    return i - 1;
  }
  
  public static final boolean bu(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(129394);
    s.u(paramCharSequence, "$this$startsWith");
    if ((paramCharSequence.length() > 0) && (a.a(paramCharSequence.charAt(0), '0', false)))
    {
      AppMethodBeat.o(129394);
      return true;
    }
    AppMethodBeat.o(129394);
    return false;
  }
  
  public static final h<String> bv(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(129417);
    s.u(paramCharSequence, "$this$lineSequence");
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "\r\n";
    arrayOfString[1] = "\n";
    arrayOfString[2] = "\r";
    s.u(paramCharSequence, "$this$splitToSequence");
    s.u(arrayOfString, "delimiters");
    paramCharSequence = kotlin.m.k.d(a(paramCharSequence, arrayOfString, false, 0), (b)new c(paramCharSequence));
    AppMethodBeat.o(129417);
    return paramCharSequence;
  }
  
  public static final List<String> bw(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(129418);
    s.u(paramCharSequence, "$this$lines");
    paramCharSequence = kotlin.m.k.d(n.bv(paramCharSequence));
    AppMethodBeat.o(129418);
    return paramCharSequence;
  }
  
  public static final String c(String paramString1, char paramChar, String paramString2)
  {
    AppMethodBeat.i(129387);
    s.u(paramString1, "$this$substringAfterLast");
    s.u(paramString2, "missingDelimiterValue");
    int i = n.b((CharSequence)paramString1, paramChar);
    if (i == -1)
    {
      AppMethodBeat.o(129387);
      return paramString2;
    }
    paramString1 = paramString1.substring(i + 1, paramString1.length());
    s.s(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(129387);
    return paramString1;
  }
  
  public static final String c(String paramString, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(129392);
    s.u(paramString, "$this$removePrefix");
    s.u(paramCharSequence, "prefix");
    if (n.e((CharSequence)paramString, paramCharSequence))
    {
      paramString = paramString.substring(paramCharSequence.length());
      s.s(paramString, "(this as java.lang.String).substring(startIndex)");
      AppMethodBeat.o(129392);
      return paramString;
    }
    AppMethodBeat.o(129392);
    return paramString;
  }
  
  public static final boolean c(CharSequence paramCharSequence, char paramChar)
  {
    AppMethodBeat.i(129410);
    s.u(paramCharSequence, "$this$contains");
    if (n.a(paramCharSequence, paramChar, 0, false, 2) >= 0)
    {
      AppMethodBeat.o(129410);
      return true;
    }
    AppMethodBeat.o(129410);
    return false;
  }
  
  public static final String d(String paramString, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(190992);
    s.u(paramString, "$this$removeSuffix");
    s.u(paramCharSequence, "suffix");
    if (n.g((CharSequence)paramString, paramCharSequence))
    {
      paramString = paramString.substring(0, paramString.length() - paramCharSequence.length());
      s.s(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      AppMethodBeat.o(190992);
      return paramString;
    }
    AppMethodBeat.o(190992);
    return paramString;
  }
  
  public static final boolean e(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(129396);
    s.u(paramCharSequence1, "$this$startsWith");
    s.u(paramCharSequence2, "prefix");
    if (((paramCharSequence1 instanceof String)) && ((paramCharSequence2 instanceof String)))
    {
      bool = n.U((String)paramCharSequence1, (String)paramCharSequence2, false);
      AppMethodBeat.o(129396);
      return bool;
    }
    boolean bool = n.a(paramCharSequence1, 0, paramCharSequence2, 0, paramCharSequence2.length(), false);
    AppMethodBeat.o(129396);
    return bool;
  }
  
  public static final boolean g(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(191001);
    s.u(paramCharSequence1, "$this$endsWith");
    s.u(paramCharSequence2, "suffix");
    if (((paramCharSequence1 instanceof String)) && ((paramCharSequence2 instanceof String)))
    {
      bool = n.rs((String)paramCharSequence1, (String)paramCharSequence2);
      AppMethodBeat.o(191001);
      return bool;
    }
    boolean bool = n.a(paramCharSequence1, paramCharSequence1.length() - paramCharSequence2.length(), paramCharSequence2, 0, paramCharSequence2.length(), false);
    AppMethodBeat.o(191001);
    return bool;
  }
  
  public static final CharSequence j(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190987);
    s.u(paramCharSequence, "$this$removeRange");
    if (paramInt2 < paramInt1)
    {
      paramCharSequence = (Throwable)new IndexOutOfBoundsException("End index (" + paramInt2 + ") is less than start index (" + paramInt1 + ").");
      AppMethodBeat.o(190987);
      throw paramCharSequence;
    }
    if (paramInt2 == paramInt1)
    {
      paramCharSequence = paramCharSequence.subSequence(0, paramCharSequence.length());
      AppMethodBeat.o(190987);
      return paramCharSequence;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramCharSequence.length() - (paramInt2 - paramInt1));
    s.s(localStringBuilder.append(paramCharSequence, 0, paramInt1), "this.append(value, startIndex, endIndex)");
    s.s(localStringBuilder.append(paramCharSequence, paramInt2, paramCharSequence.length()), "this.append(value, startIndex, endIndex)");
    paramCharSequence = (CharSequence)localStringBuilder;
    AppMethodBeat.o(190987);
    return paramCharSequence;
  }
  
  public static final String ru(String paramString1, String paramString2)
  {
    AppMethodBeat.i(190956);
    s.u(paramString1, "$this$substringAfter");
    s.u(paramString2, "missingDelimiterValue");
    int i = n.a((CharSequence)paramString1, '$', 0, false, 6);
    if (i == -1)
    {
      AppMethodBeat.o(190956);
      return paramString2;
    }
    paramString1 = paramString1.substring(i + 1, paramString1.length());
    s.s(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(190956);
    return paramString1;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/Pair;", "", "", "currentIndex", "invoke"}, k=3, mv={1, 5, 1})
  static final class a
    extends u
    implements m<CharSequence, Integer, r<? extends Integer, ? extends Integer>>
  {
    a(char[] paramArrayOfChar, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/Pair;", "", "", "currentIndex", "invoke"}, k=3, mv={1, 5, 1})
  static final class b
    extends u
    implements m<CharSequence, Integer, r<? extends Integer, ? extends Integer>>
  {
    b(List paramList, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lkotlin/ranges/IntRange;", "invoke"}, k=3, mv={1, 5, 1})
  static final class c
    extends u
    implements b<g, String>
  {
    c(CharSequence paramCharSequence)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.n.x
 * JD-Core Version:    0.7.0.1
 */