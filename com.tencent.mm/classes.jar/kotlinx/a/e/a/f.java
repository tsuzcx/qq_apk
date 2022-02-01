package kotlinx.a.e.a;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"BEGIN_LIST", "", "BEGIN_OBJ", "C2TC", "", "getC2TC$annotations", "()V", "getC2TC", "()[B", "COLON", "COMMA", "CTC_MAX", "", "END_LIST", "END_OBJ", "ESC2C_MAX", "INVALID", "NULL", "", "STRING", "STRING_ESC", "TC_BEGIN_LIST", "", "TC_BEGIN_OBJ", "TC_COLON", "TC_COMMA", "TC_END_LIST", "TC_END_OBJ", "TC_EOF", "TC_INVALID", "TC_NULL", "TC_OTHER", "TC_STRING", "TC_STRING_ESC", "TC_WS", "UNICODE_ESC", "lenientHint", "charToTokenClass", "c", "escapeToChar", "rangeEquals", "", "source", "start", "length", "str", "initC2TC", "", "cl", "kotlinx-serialization-runtime"}, k=2, mv={1, 4, 0})
public final class f
{
  private static final byte[] ajEF;
  
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
    ajEF = arrayOfByte;
  }
  
  public static final byte L(char paramChar)
  {
    if (paramChar < '~') {
      return ajEF[paramChar];
    }
    return 0;
  }
  
  public static final char aMN(int paramInt)
  {
    if (paramInt < 117) {
      return b.ajEo[paramInt];
    }
    return '\000';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlinx.a.e.a.f
 * JD-Core Version:    0.7.0.1
 */