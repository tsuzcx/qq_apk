package kotlinx.a.c.a;

import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"BEGIN_LIST", "", "BEGIN_OBJ", "C2TC", "", "C2TC$annotations", "()V", "getC2TC", "()[B", "COLON", "COMMA", "CTC_MAX", "", "END_LIST", "END_OBJ", "ESC2C_MAX", "INVALID", "NULL", "", "STRING", "STRING_ESC", "TC_BEGIN_LIST", "", "TC_BEGIN_OBJ", "TC_COLON", "TC_COMMA", "TC_END_LIST", "TC_END_OBJ", "TC_EOF", "TC_INVALID", "TC_NULL", "TC_OTHER", "TC_STRING", "TC_STRING_ESC", "TC_WS", "UNICODE_ESC", "charToTokenClass", "c", "escapeToChar", "rangeEquals", "", "source", "start", "length", "str", "initC2TC", "", "cl", "kotlinx-serialization-runtime"})
public final class g
{
  private static final byte[] abDC;
  
  static
  {
    byte[] arrayOfByte = new byte[126];
    int i = 0;
    while (i <= 32)
    {
      arrayOfByte[i] = 11;
      i += 1;
    }
    arrayOfByte[9] = 3;
    arrayOfByte[10] = 3;
    arrayOfByte[13] = 3;
    arrayOfByte[32] = 3;
    arrayOfByte[44] = 4;
    arrayOfByte[58] = 5;
    arrayOfByte[123] = 6;
    arrayOfByte[125] = 7;
    arrayOfByte[91] = 8;
    arrayOfByte[93] = 9;
    arrayOfByte[34] = 1;
    arrayOfByte[92] = 2;
    abDC = arrayOfByte;
  }
  
  public static final byte R(char paramChar)
  {
    if (paramChar < '~') {
      return abDC[paramChar];
    }
    return 0;
  }
  
  public static final char aGa(int paramInt)
  {
    if (paramInt < 117) {
      return c.abDv[paramInt];
    }
    return '\000';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.a.c.a.g
 * JD-Core Version:    0.7.0.1
 */