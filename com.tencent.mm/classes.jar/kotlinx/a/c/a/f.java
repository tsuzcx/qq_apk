package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/json/internal/JsonReader;", "", "source", "", "(Ljava/lang/String;)V", "buf", "", "canBeginValue", "", "getCanBeginValue", "()Z", "currentPosition", "", "isDone", "length", "offset", "tokenClass", "", "tokenPosition", "append", "", "ch", "", "appendEsc", "startPosition", "appendHex", "startPos", "appendRange", "fromIndex", "toIndex", "fail", "", "message", "position", "fromHexChar", "nextLiteral", "nextString", "nextToken", "require", "condition", "Lkotlin/Function0;", "require$kotlinx_serialization_runtime", "requireTokenClass", "expected", "errorMessage", "Lkotlin/Function1;", "requireTokenClass$kotlinx_serialization_runtime", "skipElement", "takeBooleanStringUnquoted", "takeString", "takeStringInternal", "takeStringQuoted", "toString", "kotlinx-serialization-runtime"})
public final class f
{
  public byte Olo;
  int Olp;
  private char[] buf;
  private int length;
  private int offset;
  private final String source;
  public int vFD;
  
  public f(String paramString)
  {
    AppMethodBeat.i(199902);
    this.source = paramString;
    this.Olo = 12;
    this.offset = -1;
    this.buf = new char[16];
    gBV();
    AppMethodBeat.o(199902);
  }
  
  private final void append(char paramChar)
  {
    AppMethodBeat.i(199890);
    if (this.length >= this.buf.length)
    {
      arrayOfChar = Arrays.copyOf(this.buf, this.buf.length * 2);
      p.g(arrayOfChar, "java.util.Arrays.copyOf(this, newSize)");
      this.buf = arrayOfChar;
    }
    char[] arrayOfChar = this.buf;
    int i = this.length;
    this.length = (i + 1);
    arrayOfChar[i] = paramChar;
    AppMethodBeat.o(199890);
  }
  
  private final void bh(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199891);
    int i = paramInt2 - paramInt1;
    int j = this.length;
    paramInt2 = j + i;
    if (paramInt2 > this.buf.length)
    {
      char[] arrayOfChar = Arrays.copyOf(this.buf, d.k.j.lw(paramInt2, this.buf.length * 2));
      p.g(arrayOfChar, "java.util.Arrays.copyOf(this, newSize)");
      this.buf = arrayOfChar;
    }
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      this.buf[(j + paramInt2)] = paramString.charAt(paramInt1 + paramInt2);
      paramInt2 += 1;
    }
    this.length += i;
    AppMethodBeat.o(199891);
  }
  
  private final void hB(String paramString, int paramInt)
  {
    AppMethodBeat.i(199893);
    this.Olp = paramInt;
    this.offset = paramInt;
    while ((paramInt < paramString.length()) && (g.I(paramString.charAt(paramInt)) == 0)) {
      paramInt += 1;
    }
    this.vFD = paramInt;
    this.length = (paramInt - this.offset);
    if (g.n(paramString, this.offset, this.length, "null")) {}
    for (byte b = 10;; b = 0)
    {
      this.Olo = b;
      AppMethodBeat.o(199893);
      return;
    }
  }
  
  private final void hC(String paramString, int paramInt)
  {
    AppMethodBeat.i(199894);
    this.Olp = paramInt;
    this.length = 0;
    int i = paramInt + 1;
    int j = i;
    while (paramString.charAt(i) != '"') {
      if (paramString.charAt(i) == '\\')
      {
        bh(paramString, j, i);
        i = hD(paramString, i + 1);
        j = i;
      }
      else
      {
        i += 1;
        if (i >= paramString.length())
        {
          hF("EOF", i);
          AppMethodBeat.o(199894);
          throw null;
        }
      }
    }
    if (j == paramInt + 1)
    {
      this.offset = j;
      this.length = (i - j);
    }
    for (;;)
    {
      this.vFD = (i + 1);
      this.Olo = 1;
      AppMethodBeat.o(199894);
      return;
      bh(paramString, j, i);
      this.offset = -1;
    }
  }
  
  private final int hD(String paramString, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(199895);
    if (paramInt < paramString.length()) {}
    for (int i = 1; i == 0; i = 0)
    {
      hF("Unexpected EOF after escape character", paramInt);
      AppMethodBeat.o(199895);
      throw null;
    }
    i = paramInt + 1;
    char c1 = paramString.charAt(paramInt);
    if (c1 == 'u')
    {
      paramInt = hE(paramString, i);
      AppMethodBeat.o(199895);
      return paramInt;
    }
    char c2 = g.amw(c1);
    if (c2 != 0) {}
    for (paramInt = j; paramInt == 0; paramInt = 0)
    {
      hF("Invalid escaped char '" + c1 + '\'', i);
      AppMethodBeat.o(199895);
      throw null;
    }
    append(c2);
    AppMethodBeat.o(199895);
    return i;
  }
  
  private final int hE(String paramString, int paramInt)
  {
    AppMethodBeat.i(199896);
    int j = paramInt + 1;
    paramInt = hG(paramString, paramInt);
    int i = j + 1;
    j = hG(paramString, j);
    int k = i + 1;
    append((char)((j << 8) + (paramInt << 12) + (hG(paramString, i) << 4) + hG(paramString, k)));
    AppMethodBeat.o(199896);
    return k + 1;
  }
  
  private final int hG(String paramString, int paramInt)
  {
    AppMethodBeat.i(199901);
    if (paramInt < paramString.length()) {}
    for (int i = 1; i == 0; i = 0)
    {
      hF("Unexpected EOF during unicode escape", paramInt);
      AppMethodBeat.o(199901);
      throw null;
    }
    char c = paramString.charAt(paramInt);
    if ('0' > c)
    {
      if ('a' <= c) {
        break label115;
      }
      label60:
      if ('A' <= c) {
        break label134;
      }
    }
    label115:
    while ('F' < c)
    {
      a(this, "Invalid toHexChar char '" + c + "' in unicode escape");
      AppMethodBeat.o(199901);
      throw null;
      if ('9' < c) {
        break;
      }
      AppMethodBeat.o(199901);
      return c - '0';
      if ('f' < c) {
        break label60;
      }
      AppMethodBeat.o(199901);
      return c - 'a' + 10;
    }
    label134:
    AppMethodBeat.o(199901);
    return c - 'A' + 10;
  }
  
  public final boolean gBR()
  {
    switch (this.Olo)
    {
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      return false;
    }
    return true;
  }
  
  public final String gBS()
  {
    AppMethodBeat.i(199887);
    if ((this.Olo != 0) && (this.Olo != 1))
    {
      hF("Expected string or non-null literal", this.Olp);
      AppMethodBeat.o(199887);
      throw null;
    }
    String str = gBU();
    AppMethodBeat.o(199887);
    return str;
  }
  
  public final String gBT()
  {
    AppMethodBeat.i(199888);
    if (this.Olo != 1)
    {
      hF("Expected string literal with quotes. Use 'JsonConfiguration.isLenient = true' to accept non-compliant JSON", this.Olp);
      AppMethodBeat.o(199888);
      throw null;
    }
    String str = gBU();
    AppMethodBeat.o(199888);
    return str;
  }
  
  final String gBU()
  {
    AppMethodBeat.i(199889);
    Object localObject;
    if (this.offset < 0) {
      localObject = new String(this.buf, 0, this.length);
    }
    for (;;)
    {
      gBV();
      AppMethodBeat.o(199889);
      return localObject;
      localObject = this.source;
      int i = this.offset;
      int j = this.offset;
      int k = this.length;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(199889);
        throw ((Throwable)localObject);
      }
      localObject = ((String)localObject).substring(i, j + k);
      p.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
  }
  
  public final void gBV()
  {
    AppMethodBeat.i(199892);
    String str = this.source;
    int i = this.vFD;
    while (i < str.length())
    {
      byte b = g.I(str.charAt(i));
      if (b == 3)
      {
        i += 1;
      }
      else
      {
        if (b == 0)
        {
          hB(str, i);
          AppMethodBeat.o(199892);
          return;
        }
        if (b == 1)
        {
          hC(str, i);
          AppMethodBeat.o(199892);
          return;
        }
        this.Olp = i;
        this.Olo = b;
        this.vFD = (i + 1);
        AppMethodBeat.o(199892);
        return;
      }
    }
    this.Olp = i;
    this.Olo = 12;
    AppMethodBeat.o(199892);
  }
  
  public final void gBW()
  {
    AppMethodBeat.i(199897);
    if ((this.Olo != 6) && (this.Olo != 8))
    {
      gBV();
      AppMethodBeat.o(199897);
      return;
    }
    Object localObject = (List)new ArrayList();
    switch (this.Olo)
    {
    default: 
      label80:
      gBV();
      if (((Collection)localObject).isEmpty()) {
        break;
      }
    }
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(199897);
      return;
      ((List)localObject).add(Byte.valueOf(this.Olo));
      break label80;
      if (((Number)d.a.j.jn((List)localObject)).byteValue() != 8)
      {
        localObject = (Throwable)kotlinx.a.c.l.ac(this.vFD, "found ] instead of }", this.source);
        AppMethodBeat.o(199897);
        throw ((Throwable)localObject);
      }
      ((List)localObject).remove(((List)localObject).size() - 1);
      break label80;
      if (((Number)d.a.j.jn((List)localObject)).byteValue() != 6)
      {
        localObject = (Throwable)kotlinx.a.c.l.ac(this.vFD, "found } instead of ]", this.source);
        AppMethodBeat.o(199897);
        throw ((Throwable)localObject);
      }
      ((List)localObject).remove(((List)localObject).size() - 1);
      break label80;
    }
  }
  
  public final Void hF(String paramString, int paramInt)
  {
    AppMethodBeat.i(199899);
    p.h(paramString, "message");
    paramString = (Throwable)kotlinx.a.c.l.ac(paramInt, paramString, this.source);
    AppMethodBeat.o(199899);
    throw paramString;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(199898);
    String str = "JsonReader(source='" + this.source + "', currentPosition=" + this.vFD + ", tokenClass=" + this.Olo + ", tokenPosition=" + this.Olp + ", offset=" + this.offset + ')';
    AppMethodBeat.o(199898);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.a.f
 * JD-Core Version:    0.7.0.1
 */