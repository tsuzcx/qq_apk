package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import d.n.n;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"ESCAPE_CHARS", "", "", "ESCAPE_CHARS$annotations", "()V", "[Ljava/lang/String;", "shouldBeQuoted", "", "str", "toHexChar", "", "i", "", "printQuoted", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "value", "toBooleanStrict", "toBooleanStrictOrNull", "(Ljava/lang/String;)Ljava/lang/Boolean;", "kotlinx-serialization-runtime"})
public final class p
{
  private static final String[] OlB;
  
  static
  {
    AppMethodBeat.i(199930);
    String[] arrayOfString = new String[''];
    int i = 0;
    while (i <= 31)
    {
      char c1 = amx(i >> 12);
      char c2 = amx(i >> 8);
      char c3 = amx(i >> 4);
      char c4 = amx(i);
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
    OlB = arrayOfString;
    AppMethodBeat.o(199930);
  }
  
  private static final char amx(int paramInt)
  {
    paramInt &= 0xF;
    if (paramInt < 10) {
      return (char)(paramInt + 48);
    }
    return (char)(paramInt - 10 + 97);
  }
  
  public static final void b(StringBuilder paramStringBuilder, String paramString)
  {
    AppMethodBeat.i(199926);
    d.g.b.p.h(paramStringBuilder, "$this$printQuoted");
    d.g.b.p.h(paramString, "value");
    paramStringBuilder.append('"');
    int k = paramString.length();
    int j = 0;
    int i = 0;
    String str;
    if (j < k)
    {
      int m = paramString.charAt(j);
      if (m >= OlB.length) {
        break label126;
      }
      str = OlB[m];
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
      AppMethodBeat.o(199926);
      return;
    }
  }
  
  public static final boolean bfc(String paramString)
  {
    AppMethodBeat.i(199927);
    d.g.b.p.h(paramString, "$this$toBooleanStrict");
    Boolean localBoolean = bfd(paramString);
    if (localBoolean != null)
    {
      boolean bool = localBoolean.booleanValue();
      AppMethodBeat.o(199927);
      return bool;
    }
    paramString = (Throwable)new IllegalStateException(paramString + " does not represent a Boolean");
    AppMethodBeat.o(199927);
    throw paramString;
  }
  
  public static final Boolean bfd(String paramString)
  {
    AppMethodBeat.i(199928);
    d.g.b.p.h(paramString, "$this$toBooleanStrictOrNull");
    if (n.H(paramString, "true", true))
    {
      paramString = Boolean.TRUE;
      AppMethodBeat.o(199928);
      return paramString;
    }
    if (n.H(paramString, "false", true))
    {
      paramString = Boolean.FALSE;
      AppMethodBeat.o(199928);
      return paramString;
    }
    AppMethodBeat.o(199928);
    return null;
  }
  
  public static final boolean bfe(String paramString)
  {
    AppMethodBeat.i(199929);
    d.g.b.p.h(paramString, "str");
    if (d.g.b.p.i(paramString, "null"))
    {
      AppMethodBeat.o(199929);
      return true;
    }
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      if (g.I(paramString.charAt(i)) != 0)
      {
        AppMethodBeat.o(199929);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(199929);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.a.p
 * JD-Core Version:    0.7.0.1
 */