package com.tencent.mm.plugin.nfc.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static final char[] pgv = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static byte[] b(short paramShort)
  {
    return new byte[] { (byte)(paramShort >>> 8 & 0xFF), (byte)(paramShort & 0xFF) };
  }
  
  public static String byteArrayToHexString(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23050);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(23050);
      return null;
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      arrayOfChar[(i * 2)] = pgv[(j >>> 4)];
      arrayOfChar[(i * 2 + 1)] = pgv[(j & 0xF)];
      i += 1;
    }
    paramArrayOfByte = new String(arrayOfChar);
    AppMethodBeat.o(23050);
    return paramArrayOfByte;
  }
  
  public static byte[] hexStringToByteArray(String paramString)
  {
    AppMethodBeat.i(23051);
    int j = paramString.length();
    byte[] arrayOfByte = new byte[j / 2];
    int i = 0;
    while (i < j)
    {
      arrayOfByte[(i / 2)] = ((byte)((Character.digit(paramString.charAt(i), 16) << 4) + Character.digit(paramString.charAt(i + 1), 16)));
      i += 2;
    }
    AppMethodBeat.o(23051);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc.c.a
 * JD-Core Version:    0.7.0.1
 */