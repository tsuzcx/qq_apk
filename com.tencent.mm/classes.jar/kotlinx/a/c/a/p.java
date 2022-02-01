package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"ESCAPE_CHARS", "", "", "ESCAPE_CHARS$annotations", "()V", "[Ljava/lang/String;", "shouldBeQuoted", "", "str", "toHexChar", "", "i", "", "printQuoted", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "value", "toBooleanStrict", "toBooleanStrictOrNull", "(Ljava/lang/String;)Ljava/lang/Boolean;", "kotlinx-serialization-runtime"})
public final class p
{
  private static final String[] Uay;
  
  static
  {
    AppMethodBeat.i(225702);
    String[] arrayOfString = new String[''];
    int i = 0;
    while (i <= 31)
    {
      char c1 = awg(i >> 12);
      char c2 = awg(i >> 8);
      char c3 = awg(i >> 4);
      char c4 = awg(i);
      arrayOfString[i] = ("\\u" + c1 + c2 + c3 + c4);
      i += 1;
    }
    arrayOfString[34] = "\\\"";
    arrayOfString[92] = "\\\\";
    arrayOfString[9] = "\\t";
    arrayOfString[8] = "\\b";
    arrayOfString[10] = "\\n";
    arrayOfString[13] = "\\r";
    arrayOfString[12] = "\\f";
    Uay = arrayOfString;
    AppMethodBeat.o(225702);
  }
  
  private static final char awg(int paramInt)
  {
    paramInt &= 0xF;
    if (paramInt < 10) {
      return (char)(paramInt + 48);
    }
    return (char)(paramInt - 10 + 97);
  }
  
  public static final void b(StringBuilder paramStringBuilder, String paramString)
  {
    AppMethodBeat.i(225698);
    kotlin.g.b.p.h(paramStringBuilder, "$this$printQuoted");
    kotlin.g.b.p.h(paramString, "value");
    paramStringBuilder.append('"');
    int k = paramString.length();
    int j = 0;
    int i = 0;
    String str;
    if (j < k)
    {
      int m = paramString.charAt(j);
      if (m >= Uay.length) {
        break label126;
      }
      str = Uay[m];
      if (str != null) {}
    }
    label126:
    for (;;)
    {
      j += 1;
      break;
      paramStringBuilder.append((CharSequence)paramString, i, j);
      paramStringBuilder.append(str);
      i = j + 1;
      continue;
      paramStringBuilder.append((CharSequence)paramString, i, k);
      paramStringBuilder.append('"');
      AppMethodBeat.o(225698);
      return;
    }
  }
  
  public static final boolean buR(String paramString)
  {
    AppMethodBeat.i(225699);
    kotlin.g.b.p.h(paramString, "$this$toBooleanStrict");
    Boolean localBoolean = buS(paramString);
    if (localBoolean != null)
    {
      boolean bool = localBoolean.booleanValue();
      AppMethodBeat.o(225699);
      return bool;
    }
    paramString = (Throwable)new IllegalStateException(paramString + " does not represent a Boolean");
    AppMethodBeat.o(225699);
    throw paramString;
  }
  
  public static final Boolean buS(String paramString)
  {
    AppMethodBeat.i(225700);
    kotlin.g.b.p.h(paramString, "$this$toBooleanStrictOrNull");
    if (n.I(paramString, "true", true))
    {
      paramString = Boolean.TRUE;
      AppMethodBeat.o(225700);
      return paramString;
    }
    if (n.I(paramString, "false", true))
    {
      paramString = Boolean.FALSE;
      AppMethodBeat.o(225700);
      return paramString;
    }
    AppMethodBeat.o(225700);
    return null;
  }
  
  public static final boolean buT(String paramString)
  {
    AppMethodBeat.i(225701);
    kotlin.g.b.p.h(paramString, "str");
    if (kotlin.g.b.p.j(paramString, "null"))
    {
      AppMethodBeat.o(225701);
      return true;
    }
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      if (g.G(paramString.charAt(i)) != 0)
      {
        AppMethodBeat.o(225701);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(225701);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.a.c.a.p
 * JD-Core Version:    0.7.0.1
 */