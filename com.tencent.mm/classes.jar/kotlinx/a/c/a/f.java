package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/json/internal/JsonReader;", "", "source", "", "(Ljava/lang/String;)V", "buf", "", "canBeginValue", "", "getCanBeginValue", "()Z", "currentPosition", "", "isDone", "length", "offset", "tokenClass", "", "tokenPosition", "append", "", "ch", "", "appendEsc", "startPosition", "appendHex", "startPos", "appendRange", "fromIndex", "toIndex", "fail", "", "message", "position", "fromHexChar", "nextLiteral", "nextString", "nextToken", "require", "condition", "Lkotlin/Function0;", "require$kotlinx_serialization_runtime", "requireTokenClass", "expected", "errorMessage", "Lkotlin/Function1;", "requireTokenClass$kotlinx_serialization_runtime", "skipElement", "takeBooleanStringUnquoted", "takeString", "takeStringInternal", "takeStringQuoted", "toString", "kotlinx-serialization-runtime"})
public final class f
{
  public byte Ual;
  int Uam;
  private char[] buf;
  private int length;
  private int offset;
  private final String source;
  public int zaD;
  
  public f(String paramString)
  {
    AppMethodBeat.i(225674);
    this.source = paramString;
    this.Ual = 12;
    this.offset = -1;
    this.buf = new char[16];
    hPc();
    AppMethodBeat.o(225674);
  }
  
  private final void append(char paramChar)
  {
    AppMethodBeat.i(225662);
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
    AppMethodBeat.o(225662);
  }
  
  private final void bd(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(225663);
    int i = paramInt2 - paramInt1;
    int j = this.length;
    paramInt2 = j + i;
    if (paramInt2 > this.buf.length)
    {
      char[] arrayOfChar = Arrays.copyOf(this.buf, kotlin.k.j.mZ(paramInt2, this.buf.length * 2));
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
    AppMethodBeat.o(225663);
  }
  
  private final void hX(String paramString, int paramInt)
  {
    AppMethodBeat.i(225665);
    this.Uam = paramInt;
    this.offset = paramInt;
    while ((paramInt < paramString.length()) && (g.G(paramString.charAt(paramInt)) == 0)) {
      paramInt += 1;
    }
    this.zaD = paramInt;
    this.length = (paramInt - this.offset);
    if (g.o(paramString, this.offset, this.length, "null")) {}
    for (byte b = 10;; b = 0)
    {
      this.Ual = b;
      AppMethodBeat.o(225665);
      return;
    }
  }
  
  private final void hY(String paramString, int paramInt)
  {
    AppMethodBeat.i(225666);
    this.Uam = paramInt;
    this.length = 0;
    int i = paramInt + 1;
    int j = i;
    while (paramString.charAt(i) != '"') {
      if (paramString.charAt(i) == '\\')
      {
        bd(paramString, j, i);
        i = hZ(paramString, i + 1);
        j = i;
      }
      else
      {
        i += 1;
        if (i >= paramString.length())
        {
          ib("EOF", i);
          AppMethodBeat.o(225666);
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
      this.zaD = (i + 1);
      this.Ual = 1;
      AppMethodBeat.o(225666);
      return;
      bd(paramString, j, i);
      this.offset = -1;
    }
  }
  
  private final int hZ(String paramString, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(225667);
    if (paramInt < paramString.length()) {}
    for (int i = 1; i == 0; i = 0)
    {
      ib("Unexpected EOF after escape character", paramInt);
      AppMethodBeat.o(225667);
      throw null;
    }
    i = paramInt + 1;
    char c1 = paramString.charAt(paramInt);
    if (c1 == 'u')
    {
      paramInt = ia(paramString, i);
      AppMethodBeat.o(225667);
      return paramInt;
    }
    char c2 = g.awf(c1);
    if (c2 != 0) {}
    for (paramInt = j; paramInt == 0; paramInt = 0)
    {
      ib("Invalid escaped char '" + c1 + '\'', i);
      AppMethodBeat.o(225667);
      throw null;
    }
    append(c2);
    AppMethodBeat.o(225667);
    return i;
  }
  
  private final int ia(String paramString, int paramInt)
  {
    AppMethodBeat.i(225668);
    int j = paramInt + 1;
    paramInt = ic(paramString, paramInt);
    int i = j + 1;
    j = ic(paramString, j);
    int k = i + 1;
    append((char)((j << 8) + (paramInt << 12) + (ic(paramString, i) << 4) + ic(paramString, k)));
    AppMethodBeat.o(225668);
    return k + 1;
  }
  
  private final int ic(String paramString, int paramInt)
  {
    AppMethodBeat.i(225673);
    if (paramInt < paramString.length()) {}
    for (int i = 1; i == 0; i = 0)
    {
      ib("Unexpected EOF during unicode escape", paramInt);
      AppMethodBeat.o(225673);
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
      AppMethodBeat.o(225673);
      throw null;
      if ('9' < c) {
        break;
      }
      AppMethodBeat.o(225673);
      return c - '0';
      if ('f' < c) {
        break label60;
      }
      AppMethodBeat.o(225673);
      return c - 'a' + 10;
    }
    label134:
    AppMethodBeat.o(225673);
    return c - 'A' + 10;
  }
  
  public final boolean hOY()
  {
    switch (this.Ual)
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
  
  public final String hOZ()
  {
    AppMethodBeat.i(225659);
    if ((this.Ual != 0) && (this.Ual != 1))
    {
      ib("Expected string or non-null literal", this.Uam);
      AppMethodBeat.o(225659);
      throw null;
    }
    String str = hPb();
    AppMethodBeat.o(225659);
    return str;
  }
  
  public final String hPa()
  {
    AppMethodBeat.i(225660);
    if (this.Ual != 1)
    {
      ib("Expected string literal with quotes. Use 'JsonConfiguration.isLenient = true' to accept non-compliant JSON", this.Uam);
      AppMethodBeat.o(225660);
      throw null;
    }
    String str = hPb();
    AppMethodBeat.o(225660);
    return str;
  }
  
  final String hPb()
  {
    AppMethodBeat.i(225661);
    Object localObject;
    if (this.offset < 0) {
      localObject = new String(this.buf, 0, this.length);
    }
    for (;;)
    {
      hPc();
      AppMethodBeat.o(225661);
      return localObject;
      localObject = this.source;
      int i = this.offset;
      int j = this.offset;
      int k = this.length;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(225661);
        throw ((Throwable)localObject);
      }
      localObject = ((String)localObject).substring(i, j + k);
      p.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
  }
  
  public final void hPc()
  {
    AppMethodBeat.i(225664);
    String str = this.source;
    int i = this.zaD;
    while (i < str.length())
    {
      byte b = g.G(str.charAt(i));
      if (b == 3)
      {
        i += 1;
      }
      else
      {
        if (b == 0)
        {
          hX(str, i);
          AppMethodBeat.o(225664);
          return;
        }
        if (b == 1)
        {
          hY(str, i);
          AppMethodBeat.o(225664);
          return;
        }
        this.Uam = i;
        this.Ual = b;
        this.zaD = (i + 1);
        AppMethodBeat.o(225664);
        return;
      }
    }
    this.Uam = i;
    this.Ual = 12;
    AppMethodBeat.o(225664);
  }
  
  public final void hPd()
  {
    AppMethodBeat.i(225669);
    if ((this.Ual != 6) && (this.Ual != 8))
    {
      hPc();
      AppMethodBeat.o(225669);
      return;
    }
    Object localObject = (List)new ArrayList();
    switch (this.Ual)
    {
    default: 
      label80:
      hPc();
      if (((Collection)localObject).isEmpty()) {
        break;
      }
    }
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(225669);
      return;
      ((List)localObject).add(Byte.valueOf(this.Ual));
      break label80;
      if (((Number)kotlin.a.j.ku((List)localObject)).byteValue() != 8)
      {
        localObject = (Throwable)kotlinx.a.c.l.af(this.zaD, "found ] instead of }", this.source);
        AppMethodBeat.o(225669);
        throw ((Throwable)localObject);
      }
      ((List)localObject).remove(((List)localObject).size() - 1);
      break label80;
      if (((Number)kotlin.a.j.ku((List)localObject)).byteValue() != 6)
      {
        localObject = (Throwable)kotlinx.a.c.l.af(this.zaD, "found } instead of ]", this.source);
        AppMethodBeat.o(225669);
        throw ((Throwable)localObject);
      }
      ((List)localObject).remove(((List)localObject).size() - 1);
      break label80;
    }
  }
  
  public final Void ib(String paramString, int paramInt)
  {
    AppMethodBeat.i(225671);
    p.h(paramString, "message");
    paramString = (Throwable)kotlinx.a.c.l.af(paramInt, paramString, this.source);
    AppMethodBeat.o(225671);
    throw paramString;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(225670);
    String str = "JsonReader(source='" + this.source + "', currentPosition=" + this.zaD + ", tokenClass=" + this.Ual + ", tokenPosition=" + this.Uam + ", offset=" + this.offset + ')';
    AppMethodBeat.o(225670);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.c.a.f
 * JD-Core Version:    0.7.0.1
 */