package com.tencent.tinker.a.a;

public final class q
{
  public static void b(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    int k = paramString.length();
    int i = 0;
    if (i < k)
    {
      int m = paramString.charAt(i);
      int j;
      if ((m != 0) && (m <= 127))
      {
        j = paramInt + 1;
        paramArrayOfByte[paramInt] = ((byte)m);
        paramInt = j;
      }
      for (;;)
      {
        i += 1;
        break;
        if (m <= 2047)
        {
          j = paramInt + 1;
          paramArrayOfByte[paramInt] = ((byte)(m >> 6 & 0x1F | 0xC0));
          paramInt = j + 1;
          paramArrayOfByte[j] = ((byte)(m & 0x3F | 0x80));
        }
        else
        {
          j = paramInt + 1;
          paramArrayOfByte[paramInt] = ((byte)(m >> 12 & 0xF | 0xE0));
          int n = j + 1;
          paramArrayOfByte[j] = ((byte)(m >> 6 & 0x3F | 0x80));
          paramInt = n + 1;
          paramArrayOfByte[n] = ((byte)(m & 0x3F | 0x80));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tinker.a.a.q
 * JD-Core Version:    0.7.0.1
 */