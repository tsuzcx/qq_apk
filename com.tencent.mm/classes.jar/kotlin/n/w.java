package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.ah;
import kotlin.a.b;
import kotlin.a.b.a;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"CASE_INSENSITIVE_ORDER", "Ljava/util/Comparator;", "", "Lkotlin/Comparator;", "Lkotlin/String$Companion;", "getCASE_INSENSITIVE_ORDER", "(Lkotlin/jvm/internal/StringCompanionObject;)Ljava/util/Comparator;", "String", "stringBuffer", "Ljava/lang/StringBuffer;", "stringBuilder", "Ljava/lang/StringBuilder;", "bytes", "", "charset", "Ljava/nio/charset/Charset;", "offset", "", "length", "chars", "", "codePoints", "", "capitalize", "locale", "Ljava/util/Locale;", "codePointAt", "index", "codePointBefore", "codePointCount", "beginIndex", "endIndex", "compareTo", "other", "ignoreCase", "", "concatToString", "startIndex", "contentEquals", "", "charSequence", "decapitalize", "decodeToString", "throwOnInvalidSequence", "encodeToByteArray", "endsWith", "suffix", "equals", "format", "args", "", "", "(Ljava/lang/String;Ljava/util/Locale;[Ljava/lang/Object;)Ljava/lang/String;", "formatNullable", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "intern", "isBlank", "lowercase", "nativeIndexOf", "ch", "", "fromIndex", "str", "nativeLastIndexOf", "offsetByCodePoints", "codePointOffset", "regionMatches", "thisOffset", "otherOffset", "repeat", "n", "replace", "oldChar", "newChar", "oldValue", "newValue", "replaceFirst", "split", "", "regex", "Ljava/util/regex/Pattern;", "limit", "startsWith", "prefix", "substring", "toByteArray", "toCharArray", "destination", "destinationOffset", "toLowerCase", "toPattern", "flags", "toUpperCase", "uppercase", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/text/StringsKt")
public class w
  extends v
{
  public static final boolean T(String paramString1, String paramString2, boolean paramBoolean)
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
  
  public static final boolean U(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(190945);
    s.u(paramString1, "$this$startsWith");
    s.u(paramString2, "prefix");
    if (!paramBoolean)
    {
      paramBoolean = paramString1.startsWith(paramString2);
      AppMethodBeat.o(190945);
      return paramBoolean;
    }
    paramBoolean = n.a(paramString1, 0, paramString2, 0, paramString2.length(), paramBoolean);
    AppMethodBeat.o(190945);
    return paramBoolean;
  }
  
  public static final String a(String paramString, char paramChar1, char paramChar2)
  {
    AppMethodBeat.i(129366);
    s.u(paramString, "$this$replace");
    paramString = paramString.replace(paramChar1, paramChar2);
    s.s(paramString, "(this as java.lang.Strin…replace(oldChar, newChar)");
    AppMethodBeat.o(129366);
    return paramString;
  }
  
  public static final String a(char[] paramArrayOfChar, int paramInt)
  {
    AppMethodBeat.i(190943);
    s.u(paramArrayOfChar, "$this$concatToString");
    b.a locala = b.aivb;
    int i = paramArrayOfChar.length;
    if (paramInt > i)
    {
      paramArrayOfChar = (Throwable)new IndexOutOfBoundsException("startIndex: 0, endIndex: " + paramInt + ", size: " + i);
      AppMethodBeat.o(190943);
      throw paramArrayOfChar;
    }
    if (paramInt < 0)
    {
      paramArrayOfChar = (Throwable)new IllegalArgumentException("startIndex: 0 > endIndex: " + paramInt);
      AppMethodBeat.o(190943);
      throw paramArrayOfChar;
    }
    paramArrayOfChar = new String(paramArrayOfChar, 0, paramInt + 0);
    AppMethodBeat.o(190943);
    return paramArrayOfChar;
  }
  
  public static final boolean a(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(190953);
    s.u(paramString1, "$this$regionMatches");
    s.u(paramString2, "other");
    if (!paramBoolean)
    {
      paramBoolean = paramString1.regionMatches(0, paramString2, paramInt2, paramInt3);
      AppMethodBeat.o(190953);
      return paramBoolean;
    }
    paramBoolean = paramString1.regionMatches(paramBoolean, 0, paramString2, paramInt2, paramInt3);
    AppMethodBeat.o(190953);
    return paramBoolean;
  }
  
  public static final String bW(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(129368);
    s.u(paramString1, "$this$replaceFirst");
    s.u(paramString2, "oldValue");
    s.u(paramString3, "newValue");
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
  
  public static final boolean bp(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(129371);
    s.u(paramCharSequence, "$this$isBlank");
    if (paramCharSequence.length() != 0)
    {
      Object localObject = (Iterable)n.bs(paramCharSequence);
      if (((localObject instanceof Collection)) && (((Collection)localObject).isEmpty())) {
        break label95;
      }
      localObject = ((Iterable)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (a.I(paramCharSequence.charAt(((ah)localObject).Zo())));
    }
    label95:
    for (int i = 0; i != 0; i = 1)
    {
      AppMethodBeat.o(129371);
      return true;
    }
    AppMethodBeat.o(129371);
    return false;
  }
  
  public static final String m(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(129367);
    s.u(paramString1, "$this$replace");
    s.u(paramString2, "oldValue");
    s.u(paramString3, "newValue");
    int i = n.a((CharSequence)paramString1, paramString2, 0, paramBoolean);
    if (i < 0)
    {
      AppMethodBeat.o(129367);
      return paramString1;
    }
    int k = paramString2.length();
    int m = k.qu(k, 1);
    int n = paramString1.length() - k + paramString3.length();
    if (n < 0)
    {
      paramString1 = (Throwable)new OutOfMemoryError();
      AppMethodBeat.o(129367);
      throw paramString1;
    }
    StringBuilder localStringBuilder = new StringBuilder(n);
    for (;;)
    {
      localStringBuilder.append((CharSequence)paramString1, j, i).append(paramString3);
      j = i + k;
      if (i < paramString1.length())
      {
        i = n.a((CharSequence)paramString1, paramString2, i + m, paramBoolean);
        if (i > 0) {}
      }
      else
      {
        paramString1 = localStringBuilder.append((CharSequence)paramString1, j, paramString1.length()).toString();
        s.s(paramString1, "stringBuilder.append(this, i, length).toString()");
        AppMethodBeat.o(129367);
        return paramString1;
      }
    }
  }
  
  public static final String p(CharSequence paramCharSequence, int paramInt)
  {
    int k = 1;
    AppMethodBeat.i(129374);
    s.u(paramCharSequence, "$this$repeat");
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
    s.s(paramCharSequence, "sb.toString()");
    AppMethodBeat.o(129374);
    return paramCharSequence;
  }
  
  public static final boolean rs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(129370);
    s.u(paramString1, "$this$endsWith");
    s.u(paramString2, "suffix");
    boolean bool = paramString1.endsWith(paramString2);
    AppMethodBeat.o(129370);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.n.w
 * JD-Core Version:    0.7.0.1
 */