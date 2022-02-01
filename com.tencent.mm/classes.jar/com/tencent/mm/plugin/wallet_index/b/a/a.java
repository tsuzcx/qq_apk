package com.tencent.mm.plugin.wallet_index.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  private static final byte[] VZX;
  private static final byte[] VZY;
  private static final byte[] VZZ;
  private static final byte[] Waa;
  
  static
  {
    AppMethodBeat.i(263723);
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      VZX = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
      VZY = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
      VZZ = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9 };
      Waa = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9 };
      AppMethodBeat.o(263723);
      return;
    }
  }
  
  private static int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, byte[] paramArrayOfByte3)
  {
    if (paramArrayOfByte1[2] == 61)
    {
      paramArrayOfByte2[paramInt] = ((byte)((paramArrayOfByte3[paramArrayOfByte1[0]] << 24 >>> 6 | paramArrayOfByte3[paramArrayOfByte1[1]] << 24 >>> 12) >>> 16));
      return 1;
    }
    if (paramArrayOfByte1[3] == 61)
    {
      i = paramArrayOfByte3[paramArrayOfByte1[0]];
      i = paramArrayOfByte3[paramArrayOfByte1[1]] << 24 >>> 12 | i << 24 >>> 6 | paramArrayOfByte3[paramArrayOfByte1[2]] << 24 >>> 18;
      paramArrayOfByte2[paramInt] = ((byte)(i >>> 16));
      paramArrayOfByte2[(paramInt + 1)] = ((byte)(i >>> 8));
      return 2;
    }
    int i = paramArrayOfByte3[paramArrayOfByte1[0]];
    i = paramArrayOfByte3[paramArrayOfByte1[1]] << 24 >>> 12 | i << 24 >>> 6 | paramArrayOfByte3[paramArrayOfByte1[2]] << 24 >>> 18 | paramArrayOfByte3[paramArrayOfByte1[3]] << 24 >>> 24;
    paramArrayOfByte2[paramInt] = ((byte)(i >> 16));
    paramArrayOfByte2[(paramInt + 1)] = ((byte)(i >> 8));
    paramArrayOfByte2[(paramInt + 2)] = ((byte)i);
    return 3;
  }
  
  public static byte[] decode(String paramString)
  {
    AppMethodBeat.i(263710);
    byte[] arrayOfByte1 = paramString.getBytes();
    int i2 = arrayOfByte1.length;
    byte[] arrayOfByte2 = VZZ;
    paramString = new byte[i2 * 3 / 4 + 2];
    int k = 0;
    byte[] arrayOfByte3 = new byte[4];
    int j = 0;
    int m = 0;
    if (m < i2)
    {
      int i = (byte)(arrayOfByte1[(m + 0)] & 0x7F);
      n = arrayOfByte2[i];
      if (n >= -5)
      {
        if (n < -1) {
          break label416;
        }
        if (i == 61)
        {
          n = i2 - m;
          i1 = (byte)(arrayOfByte1[(i2 - 1 + 0)] & 0x7F);
          if ((j == 0) || (j == 1))
          {
            paramString = new b("invalid padding byte '=' at byte offset ".concat(String.valueOf(m)));
            AppMethodBeat.o(263710);
            throw paramString;
          }
          if (((j == 3) && (n > 2)) || ((j == 4) && (n > 1)))
          {
            paramString = new b("padding byte '=' falsely signals end of encoded value at offset ".concat(String.valueOf(m)));
            AppMethodBeat.o(263710);
            throw paramString;
          }
          if ((i1 == 61) || (i1 == 10)) {
            break label327;
          }
          paramString = new b("encoded value has invalid trailing byte");
          AppMethodBeat.o(263710);
          throw paramString;
        }
        int i1 = j + 1;
        arrayOfByte3[j] = i;
        j = i1;
        n = k;
        if (i1 == 4)
        {
          n = a(arrayOfByte3, paramString, k, arrayOfByte2);
          j = 0;
        }
      }
    }
    label416:
    for (int n = k + n;; n = k)
    {
      m += 1;
      k = n;
      break;
      paramString = new b("Bad Base64 input character at " + m + ": " + arrayOfByte1[(m + 0)] + "(decimal)");
      AppMethodBeat.o(263710);
      throw paramString;
      label327:
      m = k;
      if (j != 0)
      {
        if (j == 1)
        {
          paramString = new b("single trailing character at offset " + (i2 - 1));
          AppMethodBeat.o(263710);
          throw paramString;
        }
        arrayOfByte3[j] = 61;
        m = k + a(arrayOfByte3, paramString, k, arrayOfByte2);
      }
      arrayOfByte1 = new byte[m];
      System.arraycopy(paramString, 0, arrayOfByte1, 0, m);
      AppMethodBeat.o(263710);
      return arrayOfByte1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.b.a.a
 * JD-Core Version:    0.7.0.1
 */