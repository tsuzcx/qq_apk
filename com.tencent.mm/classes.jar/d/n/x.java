package d.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.e;
import d.g.a.b;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.k.d;
import d.k.d.a;
import d.k.f;
import d.l;
import d.m.h;
import d.m.i;
import d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "(Ljava/lang/CharSequence;)I", "commonPrefixWith", "", "other", "ignoreCase", "", "commonSuffixWith", "contains", "char", "", "regex", "Lkotlin/text/Regex;", "endsWith", "suffix", "findAnyOf", "Lkotlin/Pair;", "strings", "", "startIndex", "last", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "hasSurrogatePairAt", "index", "ifBlank", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifEmpty", "indexOf", "endIndex", "indexOf$StringsKt__StringsKt", "string", "indexOfAny", "chars", "", "isEmpty", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "iterator", "Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "lineSequence", "Lkotlin/sequences/Sequence;", "lines", "", "matches", "orEmpty", "padEnd", "length", "padChar", "padStart", "rangesDelimitedBy", "delimiters", "", "limit", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "regionMatchesImpl", "thisOffset", "otherOffset", "removePrefix", "prefix", "removeRange", "range", "removeSuffix", "removeSurrounding", "delimiter", "replace", "transform", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "replacement", "replaceAfter", "missingDelimiterValue", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceRange", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "startsWith", "subSequence", "start", "end", "substring", "substringAfter", "substringAfterLast", "substringBefore", "substringBeforeLast", "trim", "predicate", "trimEnd", "trimStart", "kotlin-stdlib"}, gkc=1)
public class x
  extends w
{
  public static final int a(CharSequence paramCharSequence, char paramChar, int paramInt)
  {
    AppMethodBeat.i(129400);
    p.h(paramCharSequence, "$this$indexOf");
    if (!(paramCharSequence instanceof String))
    {
      paramInt = n.a(paramCharSequence, new char[] { paramChar }, paramInt, false);
      AppMethodBeat.o(129400);
      return paramInt;
    }
    paramInt = ((String)paramCharSequence).indexOf(paramChar, paramInt);
    AppMethodBeat.o(129400);
    return paramInt;
  }
  
  private static final int a(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(129398);
    Object localObject;
    if (!paramBoolean2)
    {
      localObject = (d)new f(d.k.j.lw(paramInt1, 0), d.k.j.lx(paramInt2, paramCharSequence1.length()));
      if ((!(paramCharSequence1 instanceof String)) || (!(paramCharSequence2 instanceof String))) {
        break label162;
      }
      paramInt1 = ((d)localObject).Njm;
      paramInt2 = ((d)localObject).Njn;
      i = ((d)localObject).kyd;
      if (i < 0) {
        break label141;
      }
      if (paramInt1 > paramInt2) {
        break label228;
      }
    }
    for (;;)
    {
      if (n.a((String)paramCharSequence2, (String)paramCharSequence1, paramInt1, paramCharSequence2.length(), paramBoolean1))
      {
        AppMethodBeat.o(129398);
        return paramInt1;
        paramInt1 = d.k.j.lx(paramInt1, n.aG(paramCharSequence1));
        paramInt2 = d.k.j.lw(paramInt2, 0);
        localObject = d.Njo;
        localObject = d.a.ba(paramInt1, paramInt2, -1);
        break;
        label141:
        if (paramInt1 < paramInt2) {
          break label228;
        }
        continue;
      }
      if (paramInt1 == paramInt2) {
        break label228;
      }
      paramInt1 += i;
    }
    label162:
    paramInt2 = ((d)localObject).Njm;
    int i = ((d)localObject).Njn;
    int j = ((d)localObject).kyd;
    if (j >= 0)
    {
      if (paramInt2 > i) {
        break label228;
      }
      paramInt1 = paramInt2;
    }
    for (;;)
    {
      if (n.a(paramCharSequence2, 0, paramCharSequence1, paramInt1, paramCharSequence2.length(), paramBoolean1))
      {
        AppMethodBeat.o(129398);
        return paramInt1;
        paramInt1 = paramInt2;
        if (paramInt2 >= i) {}
      }
      else
      {
        label228:
        while (paramInt1 == i)
        {
          AppMethodBeat.o(129398);
          return -1;
        }
        paramInt1 += j;
      }
    }
  }
  
  public static final int a(CharSequence paramCharSequence, String paramString, int paramInt)
  {
    AppMethodBeat.i(129406);
    p.h(paramCharSequence, "$this$lastIndexOf");
    p.h(paramString, "string");
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
    p.h(paramCharSequence, "$this$indexOf");
    p.h(paramString, "string");
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
    p.h(paramCharSequence, "$this$indexOfAny");
    p.h(paramArrayOfChar, "chars");
    int i;
    if ((!paramBoolean) && (paramArrayOfChar.length == 1) && ((paramCharSequence instanceof String)))
    {
      i = e.c(paramArrayOfChar);
      paramInt = ((String)paramCharSequence).indexOf(i, paramInt);
      AppMethodBeat.o(168698);
      return paramInt;
    }
    paramInt = d.k.j.lw(paramInt, 0);
    int j = n.aG(paramCharSequence);
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
            break label142;
          }
          AppMethodBeat.o(168698);
          return paramInt;
          i += 1;
          break;
        }
        label142:
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
    p.h(paramCharSequence1, "$this$replaceRange");
    p.h(paramCharSequence2, "replacement");
    if (paramInt2 < paramInt1)
    {
      paramCharSequence1 = (Throwable)new IndexOutOfBoundsException("End index (" + paramInt2 + ") is less than start index (" + paramInt1 + ").");
      AppMethodBeat.o(129391);
      throw paramCharSequence1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    p.g(localStringBuilder.append(paramCharSequence1, 0, paramInt1), "this.append(value, startIndex, endIndex)");
    localStringBuilder.append(paramCharSequence2);
    p.g(localStringBuilder.append(paramCharSequence1, paramInt2, paramCharSequence1.length()), "this.append(value, startIndex, endIndex)");
    paramCharSequence1 = (CharSequence)localStringBuilder;
    AppMethodBeat.o(129391);
    return paramCharSequence1;
  }
  
  public static final String a(CharSequence paramCharSequence, f paramf)
  {
    AppMethodBeat.i(129380);
    p.h(paramCharSequence, "$this$substring");
    p.h(paramf, "range");
    paramCharSequence = paramCharSequence.subSequence(paramf.Njm, paramf.Njn + 1).toString();
    AppMethodBeat.o(129380);
    return paramCharSequence;
  }
  
  public static final String a(String paramString1, char paramChar, String paramString2)
  {
    AppMethodBeat.i(188724);
    p.h(paramString1, "$this$substringBefore");
    p.h(paramString2, "missingDelimiterValue");
    int i = n.a((CharSequence)paramString1, paramChar, 0, 6);
    if (i == -1)
    {
      AppMethodBeat.o(188724);
      return paramString2;
    }
    paramString1 = paramString1.substring(0, i);
    p.g(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(188724);
    return paramString1;
  }
  
  public static final String a(String paramString, char... paramVarArgs)
  {
    AppMethodBeat.i(129376);
    p.h(paramString, "$this$trimEnd");
    p.h(paramVarArgs, "chars");
    paramString = (CharSequence)paramString;
    int i = paramString.length() - 1;
    if (i >= 0) {
      if (e.contains(paramVarArgs, paramString.charAt(i))) {}
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
  
  public static final List<String> a(CharSequence paramCharSequence, String[] paramArrayOfString)
  {
    AppMethodBeat.i(129415);
    p.h(paramCharSequence, "$this$split");
    p.h(paramArrayOfString, "delimiters");
    if (paramArrayOfString.length == 1)
    {
      localObject = paramArrayOfString[0];
      if (((CharSequence)localObject).length() == 0) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramCharSequence = h(paramCharSequence, (String)localObject);
        AppMethodBeat.o(129415);
        return paramCharSequence;
      }
    }
    Object localObject = i.f(a(paramCharSequence, paramArrayOfString, false));
    paramArrayOfString = (Collection)new ArrayList(d.a.j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramArrayOfString.add(n.a(paramCharSequence, (f)((Iterator)localObject).next()));
    }
    paramCharSequence = (List)paramArrayOfString;
    AppMethodBeat.o(129415);
    return paramCharSequence;
  }
  
  public static final boolean a(CharSequence paramCharSequence, char paramChar)
  {
    AppMethodBeat.i(129395);
    p.h(paramCharSequence, "$this$endsWith");
    if ((paramCharSequence.length() > 0) && (a.a(paramCharSequence.charAt(n.aG(paramCharSequence)), paramChar, false)))
    {
      AppMethodBeat.o(129395);
      return true;
    }
    AppMethodBeat.o(129395);
    return false;
  }
  
  public static final boolean a(CharSequence paramCharSequence1, int paramInt1, CharSequence paramCharSequence2, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(188728);
    p.h(paramCharSequence1, "$this$regionMatchesImpl");
    p.h(paramCharSequence2, "other");
    if ((paramInt2 < 0) || (paramInt1 < 0) || (paramInt1 > paramCharSequence1.length() - paramInt3) || (paramInt2 > paramCharSequence2.length() - paramInt3))
    {
      AppMethodBeat.o(188728);
      return false;
    }
    int i = 0;
    while (i < paramInt3)
    {
      if (!a.a(paramCharSequence1.charAt(paramInt1 + i), paramCharSequence2.charAt(paramInt2 + i), paramBoolean))
      {
        AppMethodBeat.o(188728);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(188728);
    return true;
  }
  
  public static final boolean a(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean)
  {
    AppMethodBeat.i(129408);
    p.h(paramCharSequence1, "$this$contains");
    p.h(paramCharSequence2, "other");
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
  
  public static final CharSequence aE(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(168697);
    p.h(paramCharSequence, "$this$trimStart");
    int i = 0;
    int j = paramCharSequence.length();
    while (i < j)
    {
      if (!a.isWhitespace(paramCharSequence.charAt(i)))
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
  
  public static final f aF(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(129378);
    p.h(paramCharSequence, "$this$indices");
    paramCharSequence = new f(0, paramCharSequence.length() - 1);
    AppMethodBeat.o(129378);
    return paramCharSequence;
  }
  
  public static final int aG(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(129379);
    p.h(paramCharSequence, "$this$lastIndex");
    int i = paramCharSequence.length();
    AppMethodBeat.o(129379);
    return i - 1;
  }
  
  public static final boolean aH(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(129394);
    p.h(paramCharSequence, "$this$startsWith");
    if ((paramCharSequence.length() > 0) && (a.a(paramCharSequence.charAt(0), '0', false)))
    {
      AppMethodBeat.o(129394);
      return true;
    }
    AppMethodBeat.o(129394);
    return false;
  }
  
  public static final h<String> aI(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(129417);
    p.h(paramCharSequence, "$this$lineSequence");
    paramCharSequence = n.a(paramCharSequence, new String[] { "\r\n", "\n", "\r" }, false, 6);
    AppMethodBeat.o(129417);
    return paramCharSequence;
  }
  
  public static final List<String> aJ(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(129418);
    p.h(paramCharSequence, "$this$lines");
    paramCharSequence = i.c(n.aI(paramCharSequence));
    AppMethodBeat.o(129418);
    return paramCharSequence;
  }
  
  public static final int b(CharSequence paramCharSequence, char paramChar, int paramInt)
  {
    AppMethodBeat.i(129404);
    p.h(paramCharSequence, "$this$lastIndexOf");
    if (!(paramCharSequence instanceof String))
    {
      char[] arrayOfChar = new char[1];
      arrayOfChar[0] = paramChar;
      p.h(paramCharSequence, "$this$lastIndexOfAny");
      p.h(arrayOfChar, "chars");
      int i;
      if ((paramCharSequence instanceof String))
      {
        i = e.c(arrayOfChar);
        paramInt = ((String)paramCharSequence).lastIndexOf(i, paramInt);
        AppMethodBeat.o(129404);
        return paramInt;
      }
      paramInt = d.k.j.lx(paramInt, n.aG(paramCharSequence));
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
            break label139;
          }
          AppMethodBeat.o(129404);
          return paramInt;
          i += 1;
          break;
        }
        label139:
        paramInt -= 1;
      }
      AppMethodBeat.o(129404);
      return -1;
    }
    paramInt = ((String)paramCharSequence).lastIndexOf(paramChar, paramInt);
    AppMethodBeat.o(129404);
    return paramInt;
  }
  
  public static final h<String> b(CharSequence paramCharSequence, String[] paramArrayOfString, boolean paramBoolean)
  {
    AppMethodBeat.i(129413);
    p.h(paramCharSequence, "$this$splitToSequence");
    p.h(paramArrayOfString, "delimiters");
    paramCharSequence = i.d(a(paramCharSequence, paramArrayOfString, paramBoolean), (b)new c(paramCharSequence));
    AppMethodBeat.o(129413);
    return paramCharSequence;
  }
  
  public static final String b(String paramString1, char paramChar, String paramString2)
  {
    AppMethodBeat.i(129387);
    p.h(paramString1, "$this$substringAfterLast");
    p.h(paramString2, "missingDelimiterValue");
    int i = n.b((CharSequence)paramString1, paramChar);
    if (i == -1)
    {
      AppMethodBeat.o(129387);
      return paramString2;
    }
    paramString1 = paramString1.substring(i + 1, paramString1.length());
    p.g(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(129387);
    return paramString1;
  }
  
  public static final String b(String paramString, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(129392);
    p.h(paramString, "$this$removePrefix");
    p.h(paramCharSequence, "prefix");
    if (n.d((CharSequence)paramString, paramCharSequence))
    {
      paramString = paramString.substring(paramCharSequence.length());
      p.g(paramString, "(this as java.lang.String).substring(startIndex)");
      AppMethodBeat.o(129392);
      return paramString;
    }
    AppMethodBeat.o(129392);
    return paramString;
  }
  
  public static final List<String> b(CharSequence paramCharSequence, char[] paramArrayOfChar)
  {
    AppMethodBeat.i(168701);
    p.h(paramCharSequence, "$this$split");
    p.h(paramArrayOfChar, "delimiters");
    if (paramArrayOfChar.length == 1)
    {
      paramCharSequence = h(paramCharSequence, String.valueOf(paramArrayOfChar[0]));
      AppMethodBeat.o(168701);
      return paramCharSequence;
    }
    Object localObject = i.f(a(paramCharSequence, paramArrayOfChar));
    paramArrayOfChar = (Collection)new ArrayList(d.a.j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramArrayOfChar.add(n.a(paramCharSequence, (f)((Iterator)localObject).next()));
    }
    paramCharSequence = (List)paramArrayOfChar;
    AppMethodBeat.o(168701);
    return paramCharSequence;
  }
  
  public static final String br(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(129382);
    p.h(paramString1, "$this$substringBefore");
    p.h(paramString2, "delimiter");
    p.h(paramString3, "missingDelimiterValue");
    int i = n.a((CharSequence)paramString1, paramString2, 0, false, 6);
    if (i == -1)
    {
      AppMethodBeat.o(129382);
      return paramString3;
    }
    paramString1 = paramString1.substring(0, i);
    p.g(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(129382);
    return paramString1;
  }
  
  public static final String bs(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(129384);
    p.h(paramString1, "$this$substringAfter");
    p.h(paramString2, "delimiter");
    p.h(paramString3, "missingDelimiterValue");
    int i = n.a((CharSequence)paramString1, paramString2, 0, false, 6);
    if (i == -1)
    {
      AppMethodBeat.o(129384);
      return paramString3;
    }
    paramString1 = paramString1.substring(i + paramString2.length(), paramString1.length());
    p.g(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(129384);
    return paramString1;
  }
  
  public static final String bt(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(129389);
    p.h(paramString1, "$this$substringAfterLast");
    p.h(paramString2, "delimiter");
    p.h(paramString3, "missingDelimiterValue");
    int i = n.g((CharSequence)paramString1, paramString2);
    if (i == -1)
    {
      AppMethodBeat.o(129389);
      return paramString3;
    }
    paramString1 = paramString1.substring(i + paramString2.length(), paramString1.length());
    p.g(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(129389);
    return paramString1;
  }
  
  public static final String c(String paramString, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(188727);
    p.h(paramString, "$this$removeSuffix");
    p.h(paramCharSequence, "suffix");
    if (n.e((CharSequence)paramString, paramCharSequence))
    {
      paramString = paramString.substring(0, paramString.length() - paramCharSequence.length());
      p.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      AppMethodBeat.o(188727);
      return paramString;
    }
    AppMethodBeat.o(188727);
    return paramString;
  }
  
  public static final boolean c(CharSequence paramCharSequence, char paramChar)
  {
    AppMethodBeat.i(129410);
    p.h(paramCharSequence, "$this$contains");
    if (n.a(paramCharSequence, paramChar, 0, 2) >= 0)
    {
      AppMethodBeat.o(129410);
      return true;
    }
    AppMethodBeat.o(129410);
    return false;
  }
  
  public static final boolean d(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(129396);
    p.h(paramCharSequence1, "$this$startsWith");
    p.h(paramCharSequence2, "prefix");
    if (((paramCharSequence1 instanceof String)) && ((paramCharSequence2 instanceof String)))
    {
      bool = n.nF((String)paramCharSequence1, (String)paramCharSequence2);
      AppMethodBeat.o(129396);
      return bool;
    }
    boolean bool = n.a(paramCharSequence1, 0, paramCharSequence2, 0, paramCharSequence2.length(), false);
    AppMethodBeat.o(129396);
    return bool;
  }
  
  public static final boolean e(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(188729);
    p.h(paramCharSequence1, "$this$endsWith");
    p.h(paramCharSequence2, "suffix");
    if (((paramCharSequence1 instanceof String)) && ((paramCharSequence2 instanceof String)))
    {
      bool = n.nG((String)paramCharSequence1, (String)paramCharSequence2);
      AppMethodBeat.o(188729);
      return bool;
    }
    boolean bool = n.a(paramCharSequence1, paramCharSequence1.length() - paramCharSequence2.length(), paramCharSequence2, 0, paramCharSequence2.length(), false);
    AppMethodBeat.o(188729);
    return bool;
  }
  
  private static final List<String> h(CharSequence paramCharSequence, String paramString)
  {
    AppMethodBeat.i(160969);
    int j = n.a(paramCharSequence, paramString, 0, false);
    if (j == -1)
    {
      paramCharSequence = d.a.j.listOf(paramCharSequence.toString());
      AppMethodBeat.o(160969);
      return paramCharSequence;
    }
    ArrayList localArrayList = new ArrayList(10);
    int i = 0;
    int k;
    int m;
    do
    {
      localArrayList.add(paramCharSequence.subSequence(i, j).toString());
      k = paramString.length() + j;
      m = n.a(paramCharSequence, paramString, k, false);
      j = m;
      i = k;
    } while (m != -1);
    localArrayList.add(paramCharSequence.subSequence(k, paramCharSequence.length()).toString());
    paramCharSequence = (List)localArrayList;
    AppMethodBeat.o(160969);
    return paramCharSequence;
  }
  
  public static final String nI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(188726);
    p.h(paramString1, "$this$substringAfter");
    p.h(paramString2, "missingDelimiterValue");
    int i = n.a((CharSequence)paramString1, '$', 0, 6);
    if (i == -1)
    {
      AppMethodBeat.o(188726);
      return paramString2;
    }
    paramString1 = paramString1.substring(i + 1, paramString1.length());
    p.g(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(188726);
    return paramString1;
  }
  
  public static final String nK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(129386);
    p.h(paramString1, "$this$substringBeforeLast");
    p.h(paramString2, "missingDelimiterValue");
    int i = n.b((CharSequence)paramString1, '/');
    if (i == -1)
    {
      AppMethodBeat.o(129386);
      return paramString2;
    }
    paramString1 = paramString1.substring(0, i);
    p.g(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(129386);
    return paramString1;
  }
  
  public static final CharSequence trim(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(129377);
    p.h(paramCharSequence, "$this$trim");
    int i = paramCharSequence.length() - 1;
    int k = 0;
    int j = 0;
    while (j <= i)
    {
      if (k == 0) {}
      boolean bool;
      for (int m = j;; m = i)
      {
        bool = a.isWhitespace(paramCharSequence.charAt(m));
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lkotlin/Pair;", "", "", "currentIndex", "invoke"})
  static final class a
    extends q
    implements m<CharSequence, Integer, o<? extends Integer, ? extends Integer>>
  {
    a(char[] paramArrayOfChar)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lkotlin/Pair;", "", "", "currentIndex", "invoke"})
  static final class b
    extends q
    implements m<CharSequence, Integer, o<? extends Integer, ? extends Integer>>
  {
    b(List paramList, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lkotlin/ranges/IntRange;", "invoke"})
  static final class c
    extends q
    implements b<f, String>
  {
    c(CharSequence paramCharSequence)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.n.x
 * JD-Core Version:    0.7.0.1
 */