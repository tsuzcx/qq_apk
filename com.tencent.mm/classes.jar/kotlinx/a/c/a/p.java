package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"ESCAPE_CHARS", "", "", "ESCAPE_CHARS$annotations", "()V", "[Ljava/lang/String;", "shouldBeQuoted", "", "str", "toHexChar", "", "i", "", "printQuoted", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "value", "toBooleanStrict", "toBooleanStrictOrNull", "(Ljava/lang/String;)Ljava/lang/Boolean;", "kotlinx-serialization-runtime"})
public final class p
{
  private static final String[] abDM;
  
  static
  {
    AppMethodBeat.i(256029);
    String[] arrayOfString = new String[''];
    int i = 0;
    while (i <= 31)
    {
      char c1 = aGb(i >> 12);
      char c2 = aGb(i >> 8);
      char c3 = aGb(i >> 4);
      char c4 = aGb(i);
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
    abDM = arrayOfString;
    AppMethodBeat.o(256029);
  }
  
  private static final char aGb(int paramInt)
  {
    paramInt &= 0xF;
    if (paramInt < 10) {
      return (char)(paramInt + 48);
    }
    return (char)(paramInt - 10 + 97);
  }
  
  public static final void b(StringBuilder paramStringBuilder, String paramString)
  {
    AppMethodBeat.i(256021);
    kotlin.g.b.p.k(paramStringBuilder, "$this$printQuoted");
    kotlin.g.b.p.k(paramString, "value");
    paramStringBuilder.append('"');
    int k = paramString.length();
    int j = 0;
    int i = 0;
    String str;
    if (j < k)
    {
      int m = paramString.charAt(j);
      if (m >= abDM.length) {
        break label126;
      }
      str = abDM[m];
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
      AppMethodBeat.o(256021);
      return;
    }
  }
  
  public static final boolean bHU(String paramString)
  {
    AppMethodBeat.i(256023);
    kotlin.g.b.p.k(paramString, "$this$toBooleanStrict");
    Boolean localBoolean = bHV(paramString);
    if (localBoolean != null)
    {
      boolean bool = localBoolean.booleanValue();
      AppMethodBeat.o(256023);
      return bool;
    }
    paramString = (Throwable)new IllegalStateException(paramString + " does not represent a Boolean");
    AppMethodBeat.o(256023);
    throw paramString;
  }
  
  public static final Boolean bHV(String paramString)
  {
    AppMethodBeat.i(256026);
    kotlin.g.b.p.k(paramString, "$this$toBooleanStrictOrNull");
    if (n.L(paramString, "true", true))
    {
      paramString = Boolean.TRUE;
      AppMethodBeat.o(256026);
      return paramString;
    }
    if (n.L(paramString, "false", true))
    {
      paramString = Boolean.FALSE;
      AppMethodBeat.o(256026);
      return paramString;
    }
    AppMethodBeat.o(256026);
    return null;
  }
  
  public static final boolean bHW(String paramString)
  {
    AppMethodBeat.i(256027);
    kotlin.g.b.p.k(paramString, "str");
    if (kotlin.g.b.p.h(paramString, "null"))
    {
      AppMethodBeat.o(256027);
      return true;
    }
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      if (g.R(paramString.charAt(i)) != 0)
      {
        AppMethodBeat.o(256027);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(256027);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlinx.a.c.a.p
 * JD-Core Version:    0.7.0.1
 */