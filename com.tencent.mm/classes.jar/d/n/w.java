package d.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ab;
import d.g.b.p;
import d.l;
import d.m.i;
import java.util.Iterator;

@l(gfA=1, gfx={1, 1, 16}, gfy={""}, gfz={"CASE_INSENSITIVE_ORDER", "Ljava/util/Comparator;", "", "Lkotlin/Comparator;", "Lkotlin/String$Companion;", "getCASE_INSENSITIVE_ORDER", "(Lkotlin/jvm/internal/StringCompanionObject;)Ljava/util/Comparator;", "String", "stringBuffer", "Ljava/lang/StringBuffer;", "stringBuilder", "Ljava/lang/StringBuilder;", "bytes", "", "charset", "Ljava/nio/charset/Charset;", "offset", "", "length", "chars", "", "codePoints", "", "capitalize", "locale", "Ljava/util/Locale;", "codePointAt", "index", "codePointBefore", "codePointCount", "beginIndex", "endIndex", "compareTo", "other", "ignoreCase", "", "concatToString", "startIndex", "contentEquals", "charSequence", "", "decapitalize", "decodeToString", "throwOnInvalidSequence", "encodeToByteArray", "endsWith", "suffix", "equals", "format", "args", "", "", "(Ljava/lang/String;Ljava/util/Locale;[Ljava/lang/Object;)Ljava/lang/String;", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "intern", "isBlank", "nativeIndexOf", "ch", "", "fromIndex", "str", "nativeLastIndexOf", "offsetByCodePoints", "codePointOffset", "regionMatches", "thisOffset", "otherOffset", "repeat", "n", "replace", "oldChar", "newChar", "oldValue", "newValue", "replaceFirst", "split", "", "regex", "Ljava/util/regex/Pattern;", "limit", "startsWith", "prefix", "substring", "toByteArray", "toCharArray", "destination", "destinationOffset", "toLowerCase", "toPattern", "flags", "toUpperCase", "kotlin-stdlib"})
public class w
  extends v
{
  public static final boolean H(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(129365);
    if (paramString1 == null)
    {
      if (paramString2 == null)
      {
        AppMethodBeat.o(129365);
        return true;
      }
      AppMethodBeat.o(129365);
      return false;
    }
    if (!paramBoolean)
    {
      paramBoolean = paramString1.equals(paramString2);
      AppMethodBeat.o(129365);
      return paramBoolean;
    }
    paramBoolean = paramString1.equalsIgnoreCase(paramString2);
    AppMethodBeat.o(129365);
    return paramBoolean;
  }
  
  public static final String a(String paramString, char paramChar1, char paramChar2)
  {
    AppMethodBeat.i(129366);
    p.h(paramString, "$this$replace");
    paramString = paramString.replace(paramChar1, paramChar2);
    p.g(paramString, "(this as java.lang.Strin…replace(oldChar, newChar)");
    AppMethodBeat.o(129366);
    return paramString;
  }
  
  public static final boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(129372);
    p.h(paramString1, "$this$regionMatches");
    p.h(paramString2, "other");
    if (!paramBoolean)
    {
      paramBoolean = paramString1.regionMatches(0, paramString2, paramInt1, paramInt2);
      AppMethodBeat.o(129372);
      return paramBoolean;
    }
    paramBoolean = paramString1.regionMatches(paramBoolean, 0, paramString2, paramInt1, paramInt2);
    AppMethodBeat.o(129372);
    return paramBoolean;
  }
  
  public static final boolean aE(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(129371);
    p.h(paramCharSequence, "$this$isBlank");
    if (paramCharSequence.length() != 0)
    {
      Iterator localIterator = ((Iterable)n.aG(paramCharSequence)).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (a.isWhitespace(paramCharSequence.charAt(((ab)localIterator).nextInt())));
    }
    for (int i = 0; i != 0; i = 1)
    {
      AppMethodBeat.o(129371);
      return true;
    }
    AppMethodBeat.o(129371);
    return false;
  }
  
  public static final String bp(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(129368);
    p.h(paramString1, "$this$replaceFirst");
    p.h(paramString2, "oldValue");
    p.h(paramString3, "newValue");
    int i = n.a((CharSequence)paramString1, paramString2, 0, false, 2);
    if (i < 0)
    {
      AppMethodBeat.o(129368);
      return paramString1;
    }
    int j = paramString2.length();
    paramString1 = n.a((CharSequence)paramString1, i, j + i, (CharSequence)paramString3).toString();
    AppMethodBeat.o(129368);
    return paramString1;
  }
  
  public static final String capitalize(String paramString)
  {
    AppMethodBeat.i(129373);
    p.h(paramString, "$this$capitalize");
    int i;
    if (((CharSequence)paramString).length() > 0) {
      i = 1;
    }
    while ((i != 0) && (Character.isLowerCase(paramString.charAt(0))))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String str = paramString.substring(0, 1);
      p.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      if (str == null)
      {
        paramString = new d.v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(129373);
        throw paramString;
        i = 0;
      }
      else
      {
        str = str.toUpperCase();
        p.g(str, "(this as java.lang.String).toUpperCase()");
        localStringBuilder = localStringBuilder.append(str);
        paramString = paramString.substring(1);
        p.g(paramString, "(this as java.lang.String).substring(startIndex)");
        paramString = paramString;
        AppMethodBeat.o(129373);
        return paramString;
      }
    }
    AppMethodBeat.o(129373);
    return paramString;
  }
  
  public static final String h(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(129367);
    p.h(paramString1, "$this$replace");
    p.h(paramString2, "oldValue");
    p.h(paramString3, "newValue");
    paramString1 = i.a(n.a((CharSequence)paramString1, new String[] { paramString2 }, paramBoolean, 4), (CharSequence)paramString3);
    AppMethodBeat.o(129367);
    return paramString1;
  }
  
  public static final boolean nA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(129370);
    p.h(paramString1, "$this$endsWith");
    p.h(paramString2, "suffix");
    boolean bool = paramString1.endsWith(paramString2);
    AppMethodBeat.o(129370);
    return bool;
  }
  
  public static final boolean nz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(129369);
    p.h(paramString1, "$this$startsWith");
    p.h(paramString2, "prefix");
    boolean bool = paramString1.startsWith(paramString2);
    AppMethodBeat.o(129369);
    return bool;
  }
  
  public static final String r(CharSequence paramCharSequence, int paramInt)
  {
    int k = 1;
    AppMethodBeat.i(129374);
    p.h(paramCharSequence, "$this$repeat");
    if (paramInt >= 0) {}
    for (int j = 1; j == 0; j = 0)
    {
      paramCharSequence = (Throwable)new IllegalArgumentException(("Count 'n' must be non-negative, but was " + paramInt + '.').toString());
      AppMethodBeat.o(129374);
      throw paramCharSequence;
    }
    StringBuilder localStringBuilder;
    switch (paramInt)
    {
    default: 
      switch (paramCharSequence.length())
      {
      default: 
        localStringBuilder = new StringBuilder(paramCharSequence.length() * paramInt);
        if (paramInt > 0)
        {
          j = k;
          for (;;)
          {
            localStringBuilder.append(paramCharSequence);
            if (j == paramInt) {
              break;
            }
            j += 1;
          }
        }
        break;
      }
    case 0: 
      AppMethodBeat.o(129374);
      return "";
    case 1: 
      paramCharSequence = paramCharSequence.toString();
      AppMethodBeat.o(129374);
      return paramCharSequence;
      AppMethodBeat.o(129374);
      return "";
      int i = paramCharSequence.charAt(0);
      paramCharSequence = new char[paramInt];
      j = 0;
      while (j < paramInt)
      {
        paramCharSequence[j] = i;
        j += 1;
      }
      paramCharSequence = new String(paramCharSequence);
      AppMethodBeat.o(129374);
      return paramCharSequence;
    }
    paramCharSequence = localStringBuilder.toString();
    p.g(paramCharSequence, "sb.toString()");
    AppMethodBeat.o(129374);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.n.w
 * JD-Core Version:    0.7.0.1
 */