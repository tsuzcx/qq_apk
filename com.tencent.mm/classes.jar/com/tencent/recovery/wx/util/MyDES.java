package com.tencent.recovery.wx.util;

public class MyDES
{
  public static final int DECRYPTION = 1;
  public static final int ENCRYPTION = 0;
  
  private static void BitToByte(MyByteArray paramMyByteArray1, MyByteArray paramMyByteArray2, int paramInt)
  {
    int i = 0;
    memset(paramMyByteArray1, 0, paramInt >> 3);
    while (i < paramInt)
    {
      byte[] arrayOfByte = paramMyByteArray1.array;
      int j = paramMyByteArray1.begin + (i >> 3);
      arrayOfByte[j] = ((byte)(arrayOfByte[j] | paramMyByteArray2.array[(paramMyByteArray2.begin + i)] << (i & 0x7)));
      i += 1;
    }
  }
  
  private static void ByteToBit(MyByteArray paramMyByteArray1, MyByteArray paramMyByteArray2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      paramMyByteArray1.array[(paramMyByteArray1.begin + i)] = ((byte)(paramMyByteArray2.array[((i >> 3) + paramMyByteArray2.begin)] >> (i & 0x7) & 0x1));
      i += 1;
    }
  }
  
  private static void CYCLELEFT(MyByteArray paramMyByteArray1, MyByteArray paramMyByteArray2, int paramInt1, int paramInt2)
  {
    int k = 0;
    memcpy(paramMyByteArray2, paramMyByteArray1, paramInt2);
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= paramInt1 - paramInt2) {
        break;
      }
      paramMyByteArray1.array[(paramMyByteArray1.begin + i)] = paramMyByteArray1.array[(paramMyByteArray1.begin + i + paramInt2)];
      i += 1;
    }
    while (j < paramInt2)
    {
      paramMyByteArray1.array[(paramMyByteArray1.begin + j + paramInt1 - paramInt2)] = paramMyByteArray2.array[(paramMyByteArray2.begin + j)];
      j += 1;
    }
  }
  
  private static void DES(MyByteArray paramMyByteArray1, MyByteArray paramMyByteArray2, MyByteArray[] paramArrayOfMyByteArray, int paramInt, MyByteArray paramMyByteArray3, MyByteArray paramMyByteArray4, MyByteArray paramMyByteArray5, MyByteArray paramMyByteArray6, MyByteArray paramMyByteArray7, MyByteArray paramMyByteArray8)
  {
    ByteToBit(paramMyByteArray3, paramMyByteArray2, 64);
    TRANSFORM(paramMyByteArray3, paramMyByteArray3, new byte[] { 58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, 12, 4, 62, 54, 46, 38, 30, 22, 14, 6, 64, 56, 48, 40, 32, 24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19, 11, 3, 61, 53, 45, 37, 29, 21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7 }, 64, paramMyByteArray8);
    if (paramInt == 0)
    {
      paramInt = 0;
      while (paramInt < 16)
      {
        memcpy(paramMyByteArray5, paramMyByteArray7, 32);
        F_FUNCTION(paramMyByteArray7, paramArrayOfMyByteArray[paramInt], paramMyByteArray4, paramMyByteArray8);
        XOR(paramMyByteArray7, paramMyByteArray6, 32);
        memcpy(paramMyByteArray6, paramMyByteArray5, 32);
        paramInt += 1;
      }
    }
    paramInt = 15;
    while (paramInt >= 0)
    {
      memcpy(paramMyByteArray5, paramMyByteArray6, 32);
      F_FUNCTION(paramMyByteArray6, paramArrayOfMyByteArray[paramInt], paramMyByteArray4, paramMyByteArray8);
      XOR(paramMyByteArray6, paramMyByteArray7, 32);
      memcpy(paramMyByteArray7, paramMyByteArray5, 32);
      paramInt -= 1;
    }
    TRANSFORM(paramMyByteArray3, paramMyByteArray3, new byte[] { 40, 8, 48, 16, 56, 24, 64, 32, 39, 7, 47, 15, 55, 23, 63, 31, 38, 6, 46, 14, 54, 22, 62, 30, 37, 5, 45, 13, 53, 21, 61, 29, 36, 4, 44, 12, 52, 20, 60, 28, 35, 3, 43, 11, 51, 19, 59, 27, 34, 2, 42, 10, 50, 18, 58, 26, 33, 1, 41, 9, 49, 17, 57, 25 }, 64, paramMyByteArray8);
    BitToByte(paramMyByteArray1, paramMyByteArray3, 64);
  }
  
  private static void F_FUNCTION(MyByteArray paramMyByteArray1, MyByteArray paramMyByteArray2, MyByteArray paramMyByteArray3, MyByteArray paramMyByteArray4)
  {
    TRANSFORM(paramMyByteArray3, paramMyByteArray1, new byte[] { 32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9, 10, 11, 12, 13, 12, 13, 14, 15, 16, 17, 16, 17, 18, 19, 20, 21, 20, 21, 22, 23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1 }, 48, paramMyByteArray4);
    XOR(paramMyByteArray3, paramMyByteArray2, 48);
    S_BOXF(paramMyByteArray1, paramMyByteArray3);
    TRANSFORM(paramMyByteArray1, paramMyByteArray1, new byte[] { 16, 7, 20, 21, 29, 12, 28, 17, 1, 15, 23, 26, 5, 18, 31, 10, 2, 8, 24, 14, 32, 27, 3, 9, 19, 13, 30, 6, 22, 11, 4, 25 }, 32, paramMyByteArray4);
  }
  
  private static void InitVars(MyByteArray paramMyByteArray1, MyByteArray paramMyByteArray2, MyByteArray paramMyByteArray3, MyByteArray paramMyByteArray4, MyByteArray paramMyByteArray5, MyByteArray paramMyByteArray6)
  {
    paramMyByteArray3.begin = 0;
    paramMyByteArray3.array = paramMyByteArray2.array;
    paramMyByteArray4.begin = 28;
    paramMyByteArray4.array = paramMyByteArray2.array;
    paramMyByteArray5.begin = 0;
    paramMyByteArray5.array = paramMyByteArray1.array;
    paramMyByteArray6.begin = 32;
    paramMyByteArray6.array = paramMyByteArray1.array;
  }
  
  private static void SETKEY(MyByteArray[] paramArrayOfMyByteArray, MyByteArray paramMyByteArray1, byte[] paramArrayOfByte, int paramInt, MyByteArray paramMyByteArray2, MyByteArray paramMyByteArray3, MyByteArray paramMyByteArray4, MyByteArray paramMyByteArray5)
  {
    memset(paramMyByteArray1, 0, 24);
    paramArrayOfByte = new MyByteArray(paramArrayOfByte);
    int i = paramInt;
    if (paramInt > 24) {
      i = 24;
    }
    memcpy(paramMyByteArray1, paramArrayOfByte, i);
    Set_SubKey(paramArrayOfMyByteArray, paramMyByteArray1, paramMyByteArray2, paramMyByteArray3, paramMyByteArray4, paramMyByteArray5);
  }
  
  private static void S_BOXF(MyByteArray paramMyByteArray1, MyByteArray paramMyByteArray2)
  {
    int i = 0;
    byte[] arrayOfByte1 = { 14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7 };
    byte[] arrayOfByte2 = { 0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8 };
    byte[] arrayOfByte3 = { 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0 };
    byte[] arrayOfByte4 = { 15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13 };
    Object localObject1 = { 3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5 };
    Object localObject2 = { 13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9 };
    localObject1 = new byte[][] { { 15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10 }, localObject1, { 0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15 }, localObject2 };
    localObject2 = new byte[] { 13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1 };
    localObject2 = new byte[][] { { 10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8 }, localObject2, { 13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7 }, { 1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12 } };
    Object localObject3 = { 13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9 };
    localObject3 = new byte[][] { { 7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15 }, localObject3, { 10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4 }, { 3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14 } };
    byte[] arrayOfByte5 = { 2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9 };
    byte[] arrayOfByte6 = { 14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6 };
    byte[] arrayOfByte7 = { 4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14 };
    Object localObject4 = { 10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8 };
    Object localObject5 = { 9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6 };
    localObject4 = new byte[][] { { 12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11 }, localObject4, localObject5, { 4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13 } };
    localObject5 = new byte[][] { { 4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1 }, { 13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6 }, { 1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2 }, { 6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12 } };
    byte[][] arrayOfByte = { { 13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7 }, { 1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2 }, { 7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8 }, { 2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11 } };
    int j = paramMyByteArray2.begin;
    int k = paramMyByteArray1.begin;
    while (i < 8)
    {
      int m = (byte)((paramMyByteArray2.array[(paramMyByteArray2.begin + 0)] << 1) + paramMyByteArray2.array[(paramMyByteArray2.begin + 5)]);
      int n = (byte)((paramMyByteArray2.array[(paramMyByteArray2.begin + 1)] << 3) + (paramMyByteArray2.array[(paramMyByteArray2.begin + 2)] << 2) + (paramMyByteArray2.array[(paramMyByteArray2.begin + 3)] << 1) + paramMyByteArray2.array[(paramMyByteArray2.begin + 4)]);
      ByteToBit(paramMyByteArray1, new MyByteArray(new byte[][][] { { arrayOfByte1, arrayOfByte2, arrayOfByte3, arrayOfByte4 }, localObject1, localObject2, localObject3, { arrayOfByte5, arrayOfByte6, arrayOfByte7, { 11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3 } }, localObject4, localObject5, arrayOfByte }[i][m][n]), 4);
      i = (byte)(i + 1);
      paramMyByteArray2.begin += 6;
      paramMyByteArray1.begin += 4;
    }
    paramMyByteArray2.begin = j;
    paramMyByteArray1.begin = k;
  }
  
  private static void Set_SubKey(MyByteArray[] paramArrayOfMyByteArray, MyByteArray paramMyByteArray1, MyByteArray paramMyByteArray2, MyByteArray paramMyByteArray3, MyByteArray paramMyByteArray4, MyByteArray paramMyByteArray5)
  {
    byte[] arrayOfByte = new byte[16];
    byte[] tmp8_6 = arrayOfByte;
    tmp8_6[0] = 1;
    byte[] tmp13_8 = tmp8_6;
    tmp13_8[1] = 1;
    byte[] tmp18_13 = tmp13_8;
    tmp18_13[2] = 2;
    byte[] tmp23_18 = tmp18_13;
    tmp23_18[3] = 2;
    byte[] tmp28_23 = tmp23_18;
    tmp28_23[4] = 2;
    byte[] tmp33_28 = tmp28_23;
    tmp33_28[5] = 2;
    byte[] tmp38_33 = tmp33_28;
    tmp38_33[6] = 2;
    byte[] tmp44_38 = tmp38_33;
    tmp44_38[7] = 2;
    byte[] tmp50_44 = tmp44_38;
    tmp50_44[8] = 1;
    byte[] tmp56_50 = tmp50_44;
    tmp56_50[9] = 2;
    byte[] tmp62_56 = tmp56_50;
    tmp62_56[10] = 2;
    byte[] tmp68_62 = tmp62_56;
    tmp68_62[11] = 2;
    byte[] tmp74_68 = tmp68_62;
    tmp74_68[12] = 2;
    byte[] tmp80_74 = tmp74_68;
    tmp80_74[13] = 2;
    byte[] tmp86_80 = tmp80_74;
    tmp86_80[14] = 2;
    byte[] tmp92_86 = tmp86_80;
    tmp92_86[15] = 1;
    tmp92_86;
    ByteToBit(paramMyByteArray2, paramMyByteArray1, 64);
    TRANSFORM(paramMyByteArray2, paramMyByteArray2, new byte[] { 57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2, 59, 51, 43, 35, 27, 19, 11, 3, 60, 52, 44, 36, 63, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, 45, 37, 29, 21, 13, 5, 28, 20, 12, 4 }, 56, paramMyByteArray5);
    int i = 0;
    while (i < 16)
    {
      CYCLELEFT(paramMyByteArray3, paramMyByteArray5, 28, arrayOfByte[i]);
      CYCLELEFT(paramMyByteArray4, paramMyByteArray5, 28, arrayOfByte[i]);
      TRANSFORM(paramArrayOfMyByteArray[i], paramMyByteArray2, new byte[] { 14, 17, 11, 24, 1, 5, 3, 28, 15, 6, 21, 10, 23, 19, 12, 4, 26, 8, 16, 7, 27, 20, 13, 2, 41, 52, 31, 37, 47, 55, 30, 40, 51, 45, 33, 48, 44, 49, 39, 56, 34, 53, 46, 42, 50, 36, 29, 32 }, 48, paramMyByteArray5);
      i += 1;
    }
  }
  
  private static void TRANSFORM(MyByteArray paramMyByteArray1, MyByteArray paramMyByteArray2, byte[] paramArrayOfByte, int paramInt, MyByteArray paramMyByteArray3)
  {
    int i = 0;
    while (i < paramInt)
    {
      paramMyByteArray3.array[(paramMyByteArray3.begin + i)] = paramMyByteArray2.array[(paramMyByteArray2.begin + paramArrayOfByte[i] - 1)];
      i += 1;
    }
    memcpy(paramMyByteArray1, paramMyByteArray3, paramInt);
  }
  
  public static char Using_DES(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, int paramInt1, byte[] paramArrayOfByte3, int paramInt2)
  {
    paramArrayOfByte1 = new MyByteArray(paramArrayOfByte1);
    paramArrayOfByte2 = new MyByteArray(paramArrayOfByte2);
    MyByteArray[] arrayOfMyByteArray = new MyByteArray[16];
    int i = 0;
    while (i < 16)
    {
      arrayOfMyByteArray[i] = new MyByteArray(new byte[48]);
      i += 1;
    }
    MyByteArray localMyByteArray1 = new MyByteArray(new byte[256]);
    MyByteArray localMyByteArray2 = new MyByteArray(new byte[24]);
    MyByteArray localMyByteArray3 = new MyByteArray(new byte[64]);
    MyByteArray localMyByteArray4 = new MyByteArray();
    MyByteArray localMyByteArray5 = new MyByteArray();
    MyByteArray localMyByteArray6 = new MyByteArray();
    MyByteArray localMyByteArray7 = new MyByteArray();
    MyByteArray localMyByteArray8 = new MyByteArray(new byte[64]);
    MyByteArray localMyByteArray9 = new MyByteArray(new byte[48]);
    MyByteArray localMyByteArray10 = new MyByteArray(new byte[32]);
    MyByteArray localMyByteArray11 = new MyByteArray(new byte[9]);
    MyByteArray localMyByteArray12 = new MyByteArray(new byte[8]);
    long l;
    if ((paramArrayOfByte3 != null) && (paramArrayOfByte3.length > 0))
    {
      l = 7L + paramLong & 0xFFFFFFF8;
      if (l != 0L) {}
    }
    else
    {
      return '\000';
    }
    InitVars(localMyByteArray8, localMyByteArray3, localMyByteArray4, localMyByteArray5, localMyByteArray6, localMyByteArray7);
    SETKEY(arrayOfMyByteArray, localMyByteArray2, paramArrayOfByte3, paramInt1, localMyByteArray3, localMyByteArray4, localMyByteArray5, localMyByteArray1);
    paramInt1 = paramArrayOfByte2.begin;
    i = paramArrayOfByte1.begin;
    if (paramInt2 == 0)
    {
      DES(paramArrayOfByte1, localMyByteArray11, arrayOfMyByteArray, paramInt2, localMyByteArray8, localMyByteArray9, localMyByteArray10, localMyByteArray6, localMyByteArray7, localMyByteArray1);
      memcpy(localMyByteArray12, paramArrayOfByte1, 8);
      paramArrayOfByte1.begin += 8;
      paramLong = 0L;
      while (paramLong < l >> 3)
      {
        XOR2(localMyByteArray12, localMyByteArray12, paramArrayOfByte2);
        DES(paramArrayOfByte1, localMyByteArray12, arrayOfMyByteArray, paramInt2, localMyByteArray8, localMyByteArray9, localMyByteArray10, localMyByteArray6, localMyByteArray7, localMyByteArray1);
        memcpy(localMyByteArray12, paramArrayOfByte1, 8);
        paramLong += 1L;
        paramArrayOfByte1.begin += 8;
        paramArrayOfByte2.begin += 8;
      }
    }
    memcpy(localMyByteArray11, paramArrayOfByte2, 8);
    paramArrayOfByte2.begin += 8;
    paramLong = 1L;
    while (paramLong < l >> 3)
    {
      DES(localMyByteArray12, paramArrayOfByte2, arrayOfMyByteArray, paramInt2, localMyByteArray8, localMyByteArray9, localMyByteArray10, localMyByteArray6, localMyByteArray7, localMyByteArray1);
      XOR2(paramArrayOfByte1, localMyByteArray12, localMyByteArray11);
      memcpy(localMyByteArray11, paramArrayOfByte2, 8);
      paramLong += 1L;
      paramArrayOfByte1.begin += 8;
      paramArrayOfByte2.begin += 8;
    }
    paramArrayOfByte2.begin = paramInt1;
    paramArrayOfByte1.begin = i;
    return '\001';
  }
  
  private static void XOR(MyByteArray paramMyByteArray1, MyByteArray paramMyByteArray2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      byte[] arrayOfByte = paramMyByteArray1.array;
      int j = paramMyByteArray1.begin + i;
      arrayOfByte[j] = ((byte)(arrayOfByte[j] ^ paramMyByteArray2.array[(paramMyByteArray2.begin + i)]));
      i += 1;
    }
  }
  
  private static void XOR2(MyByteArray paramMyByteArray1, MyByteArray paramMyByteArray2, MyByteArray paramMyByteArray3)
  {
    int i = 0;
    while (i < 8)
    {
      paramMyByteArray1.array[(paramMyByteArray1.begin + i)] = ((byte)(paramMyByteArray2.array[(paramMyByteArray2.begin + i)] ^ paramMyByteArray3.array[(paramMyByteArray3.begin + i)]));
      i += 1;
    }
  }
  
  private static void memcpy(MyByteArray paramMyByteArray1, MyByteArray paramMyByteArray2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      paramMyByteArray1.array[(paramMyByteArray1.begin + i)] = paramMyByteArray2.array[(paramMyByteArray2.begin + i)];
      i += 1;
    }
  }
  
  private static void memset(MyByteArray paramMyByteArray, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < paramInt2)
    {
      paramMyByteArray.array[(paramMyByteArray.begin + i)] = ((byte)paramInt1);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.wx.util.MyDES
 * JD-Core Version:    0.7.0.1
 */