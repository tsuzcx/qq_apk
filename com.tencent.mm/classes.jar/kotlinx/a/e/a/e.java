package kotlinx.a.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.k.k;
import kotlin.n.n;
import kotlinx.a.e.j;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/json/internal/JsonReader;", "", "source", "", "(Ljava/lang/String;)V", "buf", "", "canBeginValue", "", "getCanBeginValue", "()Z", "currentPosition", "", "isDone", "length", "offset", "tokenClass", "", "tokenPosition", "append", "", "ch", "", "appendEsc", "startPosition", "appendHex", "startPos", "appendRange", "fromIndex", "toIndex", "fail", "", "message", "position", "fromHexChar", "nextLiteral", "nextString", "nextToken", "peekString", "isLenient", "require", "condition", "Lkotlin/Function0;", "require$kotlinx_serialization_runtime", "requireTokenClass", "expected", "errorMessage", "Lkotlin/Function1;", "requireTokenClass$kotlinx_serialization_runtime", "skipElement", "takeBooleanStringUnquoted", "takeString", "takeStringInternal", "advance", "takeStringQuoted", "toString", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public final class e
{
  public int EuH;
  public byte ajEC;
  int ajED;
  private char[] ajEE;
  private int length;
  private int offset;
  private final String source;
  
  public e(String paramString)
  {
    AppMethodBeat.i(188590);
    this.source = paramString;
    this.ajEC = 12;
    this.offset = -1;
    this.ajEE = new char[16];
    kFK();
    AppMethodBeat.o(188590);
  }
  
  private final void bp(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188508);
    int i = paramInt2 - paramInt1;
    int j = this.length;
    paramInt2 = j + i;
    if (paramInt2 > this.ajEE.length)
    {
      char[] arrayOfChar = Arrays.copyOf(this.ajEE, k.qu(paramInt2, this.ajEE.length * 2));
      s.s(arrayOfChar, "java.util.Arrays.copyOf(this, newSize)");
      this.ajEE = arrayOfChar;
    }
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      this.ajEE[(j + paramInt2)] = paramString.charAt(paramInt1 + paramInt2);
      paramInt2 += 1;
    }
    this.length += i;
    AppMethodBeat.o(188508);
  }
  
  private final void h(char paramChar)
  {
    AppMethodBeat.i(188500);
    if (this.length >= this.ajEE.length)
    {
      arrayOfChar = Arrays.copyOf(this.ajEE, this.ajEE.length * 2);
      s.s(arrayOfChar, "java.util.Arrays.copyOf(this, newSize)");
      this.ajEE = arrayOfChar;
    }
    char[] arrayOfChar = this.ajEE;
    int i = this.length;
    this.length = (i + 1);
    arrayOfChar[i] = paramChar;
    AppMethodBeat.o(188500);
  }
  
  private final void jR(String paramString, int paramInt)
  {
    AppMethodBeat.i(188518);
    this.ajED = paramInt;
    this.offset = paramInt;
    while ((paramInt < paramString.length()) && (f.L(paramString.charAt(paramInt)) == 0)) {
      paramInt += 1;
    }
    this.EuH = paramInt;
    this.length = (paramInt - this.offset);
    if (f.t(paramString, this.offset, this.length, "null")) {}
    for (byte b = 10;; b = 0)
    {
      this.ajEC = b;
      AppMethodBeat.o(188518);
      return;
    }
  }
  
  private final void jS(String paramString, int paramInt)
  {
    AppMethodBeat.i(188534);
    this.ajED = paramInt;
    this.length = 0;
    int i = paramInt + 1;
    int j = i;
    while (paramString.charAt(i) != '"') {
      if (paramString.charAt(i) == '\\')
      {
        bp(paramString, j, i);
        i = jT(paramString, i + 1);
        j = i;
      }
      else
      {
        i += 1;
        if (i >= paramString.length())
        {
          jV("EOF", i);
          paramString = new kotlin.f();
          AppMethodBeat.o(188534);
          throw paramString;
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
      this.EuH = (i + 1);
      this.ajEC = 1;
      AppMethodBeat.o(188534);
      return;
      bp(paramString, j, i);
      this.offset = -1;
    }
  }
  
  private final int jT(String paramString, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(188545);
    if (paramInt < paramString.length()) {}
    for (int i = 1; i == 0; i = 0)
    {
      jV("Unexpected EOF after escape character", paramInt);
      paramString = new kotlin.f();
      AppMethodBeat.o(188545);
      throw paramString;
    }
    i = paramInt + 1;
    char c1 = paramString.charAt(paramInt);
    if (c1 == 'u')
    {
      paramInt = jU(paramString, i);
      AppMethodBeat.o(188545);
      return paramInt;
    }
    char c2 = f.aMN(c1);
    if (c2 != 0) {}
    for (paramInt = j; paramInt == 0; paramInt = 0)
    {
      jV("Invalid escaped char '" + c1 + '\'', i);
      paramString = new kotlin.f();
      AppMethodBeat.o(188545);
      throw paramString;
    }
    h(c2);
    AppMethodBeat.o(188545);
    return i;
  }
  
  private final int jU(String paramString, int paramInt)
  {
    AppMethodBeat.i(188558);
    int j = paramInt + 1;
    paramInt = jW(paramString, paramInt);
    int i = j + 1;
    j = jW(paramString, j);
    int k = i + 1;
    h((char)((j << 8) + (paramInt << 12) + (jW(paramString, i) << 4) + jW(paramString, k)));
    AppMethodBeat.o(188558);
    return k + 1;
  }
  
  private final int jW(String paramString, int paramInt)
  {
    AppMethodBeat.i(188579);
    if (paramInt < paramString.length()) {}
    for (int i = 1; i == 0; i = 0)
    {
      jV("Unexpected EOF during unicode escape", paramInt);
      paramString = new kotlin.f();
      AppMethodBeat.o(188579);
      throw paramString;
    }
    char c = paramString.charAt(paramInt);
    if ('0' > c)
    {
      if ('a' <= c) {
        break label131;
      }
      label68:
      if ('A' <= c) {
        break label150;
      }
    }
    label131:
    label150:
    while ('F' < c)
    {
      a(this, "Invalid toHexChar char '" + c + "' in unicode escape");
      paramString = new kotlin.f();
      AppMethodBeat.o(188579);
      throw paramString;
      if ('9' < c) {
        break;
      }
      AppMethodBeat.o(188579);
      return c - '0';
      if ('f' < c) {
        break label68;
      }
      AppMethodBeat.o(188579);
      return c - 'a' + 10;
    }
    AppMethodBeat.o(188579);
    return c - 'A' + 10;
  }
  
  final String PQ(boolean paramBoolean)
  {
    AppMethodBeat.i(188652);
    Object localObject;
    if (this.offset < 0) {
      localObject = n.a(this.ajEE, this.length + 0);
    }
    for (;;)
    {
      if (paramBoolean) {
        kFK();
      }
      AppMethodBeat.o(188652);
      return localObject;
      localObject = this.source;
      int i = this.offset;
      int j = this.offset;
      int k = this.length;
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(188652);
        throw ((Throwable)localObject);
      }
      localObject = ((String)localObject).substring(i, j + k);
      s.s(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
  }
  
  public final boolean isDone()
  {
    return this.ajEC == 12;
  }
  
  public final Void jV(String paramString, int paramInt)
  {
    AppMethodBeat.i(188702);
    s.u(paramString, "message");
    paramString = (Throwable)j.am(paramInt, paramString, this.source);
    AppMethodBeat.o(188702);
    throw paramString;
  }
  
  public final boolean kFH()
  {
    switch (this.ajEC)
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
  
  public final String kFI()
  {
    AppMethodBeat.i(188625);
    if ((this.ajEC != 0) && (this.ajEC != 1))
    {
      jV("Expected string or non-null literal", this.ajED);
      localObject = new kotlin.f();
      AppMethodBeat.o(188625);
      throw ((Throwable)localObject);
    }
    Object localObject = PQ(true);
    AppMethodBeat.o(188625);
    return localObject;
  }
  
  public final String kFJ()
  {
    AppMethodBeat.i(188641);
    if (this.ajEC != 1)
    {
      jV("Expected string literal with quotes. Use 'JsonBuilder.isLenient = true' to accept non-compliant JSON", this.ajED);
      localObject = new kotlin.f();
      AppMethodBeat.o(188641);
      throw ((Throwable)localObject);
    }
    Object localObject = PQ(true);
    AppMethodBeat.o(188641);
    return localObject;
  }
  
  public final void kFK()
  {
    AppMethodBeat.i(188664);
    String str = this.source;
    int i = this.EuH;
    while (i < str.length())
    {
      byte b = f.L(str.charAt(i));
      switch (b)
      {
      case 2: 
      default: 
        this.ajED = i;
        this.ajEC = b;
        this.EuH = (i + 1);
        AppMethodBeat.o(188664);
        return;
      case 3: 
        i += 1;
        break;
      case 0: 
        jR(str, i);
        AppMethodBeat.o(188664);
        return;
      case 1: 
        jS(str, i);
        AppMethodBeat.o(188664);
        return;
      }
    }
    this.ajED = i;
    this.ajEC = 12;
    AppMethodBeat.o(188664);
  }
  
  public final void kFL()
  {
    AppMethodBeat.i(188680);
    if ((this.ajEC != 6) && (this.ajEC != 8))
    {
      kFK();
      AppMethodBeat.o(188680);
      return;
    }
    Object localObject = (List)new ArrayList();
    switch (this.ajEC)
    {
    default: 
      label80:
      kFK();
      if (((Collection)localObject).isEmpty()) {
        break;
      }
    }
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(188680);
      return;
      ((List)localObject).add(Byte.valueOf(this.ajEC));
      break label80;
      if (((Number)p.oM((List)localObject)).byteValue() != 8)
      {
        localObject = (Throwable)j.am(this.EuH, "found ] instead of }", this.source);
        AppMethodBeat.o(188680);
        throw ((Throwable)localObject);
      }
      ((List)localObject).remove(((List)localObject).size() - 1);
      break label80;
      if (((Number)p.oM((List)localObject)).byteValue() != 6)
      {
        localObject = (Throwable)j.am(this.EuH, "found } instead of ]", this.source);
        AppMethodBeat.o(188680);
        throw ((Throwable)localObject);
      }
      ((List)localObject).remove(((List)localObject).size() - 1);
      break label80;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188689);
    String str = "JsonReader(source='" + this.source + "', currentPosition=" + this.EuH + ", tokenClass=" + this.ajEC + ", tokenPosition=" + this.ajED + ", offset=" + this.offset + ')';
    AppMethodBeat.o(188689);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.e.a.e
 * JD-Core Version:    0.7.0.1
 */