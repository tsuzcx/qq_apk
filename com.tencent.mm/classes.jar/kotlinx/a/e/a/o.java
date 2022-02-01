package kotlinx.a.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"ESCAPE_CHARS", "", "", "getESCAPE_CHARS$annotations", "()V", "[Ljava/lang/String;", "shouldBeQuoted", "", "str", "toHexChar", "", "i", "", "printQuoted", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "value", "toBooleanStrict", "toBooleanStrictOrNull", "(Ljava/lang/String;)Ljava/lang/Boolean;", "kotlinx-serialization-runtime"}, k=2, mv={1, 4, 0})
public final class o
{
  private static final String[] ajEQ;
  
  static
  {
    AppMethodBeat.i(188540);
    String[] arrayOfString = new String[''];
    int i = 0;
    while (i <= 31)
    {
      char c1 = aMO(i >> 12);
      char c2 = aMO(i >> 8);
      char c3 = aMO(i >> 4);
      char c4 = aMO(i);
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
    ajEQ = arrayOfString;
    AppMethodBeat.o(188540);
  }
  
  private static final char aMO(int paramInt)
  {
    paramInt &= 0xF;
    if (paramInt < 10) {
      return (char)(paramInt + 48);
    }
    return (char)(paramInt - 10 + 97);
  }
  
  public static final void b(StringBuilder paramStringBuilder, String paramString)
  {
    AppMethodBeat.i(188513);
    s.u(paramStringBuilder, "$this$printQuoted");
    s.u(paramString, "value");
    paramStringBuilder.append('"');
    int k = paramString.length();
    int j = 0;
    int i = 0;
    String str;
    if (j < k)
    {
      int m = paramString.charAt(j);
      if (m >= ajEQ.length) {
        break label126;
      }
      str = ajEQ[m];
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
      AppMethodBeat.o(188513);
      return;
    }
  }
  
  public static final boolean bKa(String paramString)
  {
    AppMethodBeat.i(188529);
    s.u(paramString, "$this$toBooleanStrict");
    s.u(paramString, "$this$toBooleanStrictOrNull");
    Boolean localBoolean;
    if (n.T(paramString, "true", true)) {
      localBoolean = Boolean.TRUE;
    }
    while (localBoolean != null)
    {
      boolean bool = localBoolean.booleanValue();
      AppMethodBeat.o(188529);
      return bool;
      if (n.T(paramString, "false", true)) {
        localBoolean = Boolean.FALSE;
      } else {
        localBoolean = null;
      }
    }
    paramString = (Throwable)new IllegalStateException(paramString + " does not represent a Boolean");
    AppMethodBeat.o(188529);
    throw paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlinx.a.e.a.o
 * JD-Core Version:    0.7.0.1
 */