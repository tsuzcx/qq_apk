package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/json/internal/JsonReader;", "", "source", "", "(Ljava/lang/String;)V", "buf", "", "canBeginValue", "", "getCanBeginValue", "()Z", "currentPosition", "", "isDone", "length", "offset", "tokenClass", "", "tokenPosition", "append", "", "ch", "", "appendEsc", "startPosition", "appendHex", "startPos", "appendRange", "fromIndex", "toIndex", "fail", "", "message", "position", "fromHexChar", "nextLiteral", "nextString", "nextToken", "require", "condition", "Lkotlin/Function0;", "require$kotlinx_serialization_runtime", "requireTokenClass", "expected", "errorMessage", "Lkotlin/Function1;", "requireTokenClass$kotlinx_serialization_runtime", "skipElement", "takeBooleanStringUnquoted", "takeString", "takeStringInternal", "takeStringQuoted", "toString", "kotlinx-serialization-runtime"})
public final class f
{
  int abDA;
  private char[] abDB;
  public byte abDz;
  private int length;
  private int offset;
  private final String source;
  public int zrB;
  
  public f(String paramString)
  {
    AppMethodBeat.i(255880);
    this.source = paramString;
    this.abDz = 12;
    this.offset = -1;
    this.abDB = new char[16];
    iUj();
    AppMethodBeat.o(255880);
  }
  
  private final void bg(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255863);
    int i = paramInt2 - paramInt1;
    int j = this.length;
    paramInt2 = j + i;
    if (paramInt2 > this.abDB.length)
    {
      char[] arrayOfChar = Arrays.copyOf(this.abDB, i.ov(paramInt2, this.abDB.length * 2));
      p.j(arrayOfChar, "java.util.Arrays.copyOf(this, newSize)");
      this.abDB = arrayOfChar;
    }
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      this.abDB[(j + paramInt2)] = paramString.charAt(paramInt1 + paramInt2);
      paramInt2 += 1;
    }
    this.length += i;
    AppMethodBeat.o(255863);
  }
  
  private final void g(char paramChar)
  {
    AppMethodBeat.i(255861);
    if (this.length >= this.abDB.length)
    {
      arrayOfChar = Arrays.copyOf(this.abDB, this.abDB.length * 2);
      p.j(arrayOfChar, "java.util.Arrays.copyOf(this, newSize)");
      this.abDB = arrayOfChar;
    }
    char[] arrayOfChar = this.abDB;
    int i = this.length;
    this.length = (i + 1);
    arrayOfChar[i] = paramChar;
    AppMethodBeat.o(255861);
  }
  
  private final void iG(String paramString, int paramInt)
  {
    AppMethodBeat.i(255866);
    this.abDA = paramInt;
    this.offset = paramInt;
    while ((paramInt < paramString.length()) && (g.R(paramString.charAt(paramInt)) == 0)) {
      paramInt += 1;
    }
    this.zrB = paramInt;
    this.length = (paramInt - this.offset);
    if (g.r(paramString, this.offset, this.length, "null")) {}
    for (byte b = 10;; b = 0)
    {
      this.abDz = b;
      AppMethodBeat.o(255866);
      return;
    }
  }
  
  private final void iH(String paramString, int paramInt)
  {
    AppMethodBeat.i(255868);
    this.abDA = paramInt;
    this.length = 0;
    int i = paramInt + 1;
    int j = i;
    while (paramString.charAt(i) != '"') {
      if (paramString.charAt(i) == '\\')
      {
        bg(paramString, j, i);
        i = iI(paramString, i + 1);
        j = i;
      }
      else
      {
        i += 1;
        if (i >= paramString.length())
        {
          iK("EOF", i);
          AppMethodBeat.o(255868);
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
      this.zrB = (i + 1);
      this.abDz = 1;
      AppMethodBeat.o(255868);
      return;
      bg(paramString, j, i);
      this.offset = -1;
    }
  }
  
  private final int iI(String paramString, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(255869);
    if (paramInt < paramString.length()) {}
    for (int i = 1; i == 0; i = 0)
    {
      iK("Unexpected EOF after escape character", paramInt);
      AppMethodBeat.o(255869);
      throw null;
    }
    i = paramInt + 1;
    char c1 = paramString.charAt(paramInt);
    if (c1 == 'u')
    {
      paramInt = iJ(paramString, i);
      AppMethodBeat.o(255869);
      return paramInt;
    }
    char c2 = g.aGa(c1);
    if (c2 != 0) {}
    for (paramInt = j; paramInt == 0; paramInt = 0)
    {
      iK("Invalid escaped char '" + c1 + '\'', i);
      AppMethodBeat.o(255869);
      throw null;
    }
    g(c2);
    AppMethodBeat.o(255869);
    return i;
  }
  
  private final int iJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(255870);
    int j = paramInt + 1;
    paramInt = iL(paramString, paramInt);
    int i = j + 1;
    j = iL(paramString, j);
    int k = i + 1;
    g((char)((j << 8) + (paramInt << 12) + (iL(paramString, i) << 4) + iL(paramString, k)));
    AppMethodBeat.o(255870);
    return k + 1;
  }
  
  private final int iL(String paramString, int paramInt)
  {
    AppMethodBeat.i(255879);
    if (paramInt < paramString.length()) {}
    for (int i = 1; i == 0; i = 0)
    {
      iK("Unexpected EOF during unicode escape", paramInt);
      AppMethodBeat.o(255879);
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
      AppMethodBeat.o(255879);
      throw null;
      if ('9' < c) {
        break;
      }
      AppMethodBeat.o(255879);
      return c - '0';
      if ('f' < c) {
        break label60;
      }
      AppMethodBeat.o(255879);
      return c - 'a' + 10;
    }
    label134:
    AppMethodBeat.o(255879);
    return c - 'A' + 10;
  }
  
  public final Void iK(String paramString, int paramInt)
  {
    AppMethodBeat.i(255876);
    p.k(paramString, "message");
    paramString = (Throwable)kotlinx.a.c.l.ak(paramInt, paramString, this.source);
    AppMethodBeat.o(255876);
    throw paramString;
  }
  
  public final boolean iUf()
  {
    switch (this.abDz)
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
  
  public final String iUg()
  {
    AppMethodBeat.i(255854);
    if ((this.abDz != 0) && (this.abDz != 1))
    {
      iK("Expected string or non-null literal", this.abDA);
      AppMethodBeat.o(255854);
      throw null;
    }
    String str = iUi();
    AppMethodBeat.o(255854);
    return str;
  }
  
  public final String iUh()
  {
    AppMethodBeat.i(255857);
    if (this.abDz != 1)
    {
      iK("Expected string literal with quotes. Use 'JsonConfiguration.isLenient = true' to accept non-compliant JSON", this.abDA);
      AppMethodBeat.o(255857);
      throw null;
    }
    String str = iUi();
    AppMethodBeat.o(255857);
    return str;
  }
  
  final String iUi()
  {
    AppMethodBeat.i(255860);
    Object localObject;
    if (this.offset < 0) {
      localObject = new String(this.abDB, 0, this.length);
    }
    for (;;)
    {
      iUj();
      AppMethodBeat.o(255860);
      return localObject;
      localObject = this.source;
      int i = this.offset;
      int j = this.offset;
      int k = this.length;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(255860);
        throw ((Throwable)localObject);
      }
      localObject = ((String)localObject).substring(i, j + k);
      p.j(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
  }
  
  public final void iUj()
  {
    AppMethodBeat.i(255865);
    String str = this.source;
    int i = this.zrB;
    while (i < str.length())
    {
      byte b = g.R(str.charAt(i));
      if (b == 3)
      {
        i += 1;
      }
      else
      {
        if (b == 0)
        {
          iG(str, i);
          AppMethodBeat.o(255865);
          return;
        }
        if (b == 1)
        {
          iH(str, i);
          AppMethodBeat.o(255865);
          return;
        }
        this.abDA = i;
        this.abDz = b;
        this.zrB = (i + 1);
        AppMethodBeat.o(255865);
        return;
      }
    }
    this.abDA = i;
    this.abDz = 12;
    AppMethodBeat.o(255865);
  }
  
  public final void iUk()
  {
    AppMethodBeat.i(255871);
    if ((this.abDz != 6) && (this.abDz != 8))
    {
      iUj();
      AppMethodBeat.o(255871);
      return;
    }
    Object localObject = (List)new ArrayList();
    switch (this.abDz)
    {
    default: 
      label80:
      iUj();
      if (((Collection)localObject).isEmpty()) {
        break;
      }
    }
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(255871);
      return;
      ((List)localObject).add(Byte.valueOf(this.abDz));
      break label80;
      if (((Number)j.lq((List)localObject)).byteValue() != 8)
      {
        localObject = (Throwable)kotlinx.a.c.l.ak(this.zrB, "found ] instead of }", this.source);
        AppMethodBeat.o(255871);
        throw ((Throwable)localObject);
      }
      ((List)localObject).remove(((List)localObject).size() - 1);
      break label80;
      if (((Number)j.lq((List)localObject)).byteValue() != 6)
      {
        localObject = (Throwable)kotlinx.a.c.l.ak(this.zrB, "found } instead of ]", this.source);
        AppMethodBeat.o(255871);
        throw ((Throwable)localObject);
      }
      ((List)localObject).remove(((List)localObject).size() - 1);
      break label80;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(255873);
    String str = "JsonReader(source='" + this.source + "', currentPosition=" + this.zrB + ", tokenClass=" + this.abDz + ", tokenPosition=" + this.abDA + ", offset=" + this.offset + ')';
    AppMethodBeat.o(255873);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.c.a.f
 * JD-Core Version:    0.7.0.1
 */