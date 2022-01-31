package com.tencent.mm.plugin.nfc.c;

public final class a
{
  private static final char[] mGp = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static byte[] b(short paramShort)
  {
    return new byte[] { (byte)(paramShort >>> 8 & 0xFF), (byte)(paramShort & 0xFF) };
  }
  
  public static String byteArrayToHexString(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      arrayOfChar[(i * 2)] = mGp[(j >>> 4)];
      arrayOfChar[(i * 2 + 1)] = mGp[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static byte[] hexStringToByteArray(String paramString)
  {
    int j = paramString.length();
    byte[] arrayOfByte = new byte[j / 2];
    int i = 0;
    while (i < j)
    {
      arrayOfByte[(i / 2)] = ((byte)((Character.digit(paramString.charAt(i), 16) << 4) + Character.digit(paramString.charAt(i + 1), 16)));
      i += 2;
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc.c.a
 * JD-Core Version:    0.7.0.1
 */