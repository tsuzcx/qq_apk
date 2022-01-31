package com.tencent.recovery.wx.util;

public class MyDES
{
  public static char a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, int paramInt, byte[] paramArrayOfByte3)
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
    localMyByteArray4.bud = 0;
    localMyByteArray4.buc = localMyByteArray3.buc;
    localMyByteArray5.bud = 28;
    localMyByteArray5.buc = localMyByteArray3.buc;
    localMyByteArray6.bud = 0;
    localMyByteArray6.buc = localMyByteArray8.buc;
    localMyByteArray7.bud = 32;
    localMyByteArray7.buc = localMyByteArray8.buc;
    a(localMyByteArray2, 24);
    paramArrayOfByte3 = new MyByteArray(paramArrayOfByte3);
    i = paramInt;
    if (paramInt > 24) {
      i = 24;
    }
    d(localMyByteArray2, paramArrayOfByte3, i);
    paramArrayOfByte3 = new byte[16];
    byte[] tmp348_346 = paramArrayOfByte3;
    tmp348_346[0] = 1;
    byte[] tmp353_348 = tmp348_346;
    tmp353_348[1] = 1;
    byte[] tmp358_353 = tmp353_348;
    tmp358_353[2] = 2;
    byte[] tmp363_358 = tmp358_353;
    tmp363_358[3] = 2;
    byte[] tmp368_363 = tmp363_358;
    tmp368_363[4] = 2;
    byte[] tmp373_368 = tmp368_363;
    tmp373_368[5] = 2;
    byte[] tmp378_373 = tmp373_368;
    tmp378_373[6] = 2;
    byte[] tmp384_378 = tmp378_373;
    tmp384_378[7] = 2;
    byte[] tmp390_384 = tmp384_378;
    tmp390_384[8] = 1;
    byte[] tmp396_390 = tmp390_384;
    tmp396_390[9] = 2;
    byte[] tmp402_396 = tmp396_390;
    tmp402_396[10] = 2;
    byte[] tmp408_402 = tmp402_396;
    tmp408_402[11] = 2;
    byte[] tmp414_408 = tmp408_402;
    tmp414_408[12] = 2;
    byte[] tmp420_414 = tmp414_408;
    tmp420_414[13] = 2;
    byte[] tmp426_420 = tmp420_414;
    tmp426_420[14] = 2;
    byte[] tmp432_426 = tmp426_420;
    tmp432_426[15] = 1;
    tmp432_426;
    b(localMyByteArray3, localMyByteArray2, 64);
    a(localMyByteArray3, localMyByteArray3, new byte[] { 57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2, 59, 51, 43, 35, 27, 19, 11, 3, 60, 52, 44, 36, 63, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, 45, 37, 29, 21, 13, 5, 28, 20, 12, 4 }, 56, localMyByteArray1);
    paramInt = 0;
    while (paramInt < 16)
    {
      c(localMyByteArray4, localMyByteArray1, paramArrayOfByte3[paramInt]);
      c(localMyByteArray5, localMyByteArray1, paramArrayOfByte3[paramInt]);
      a(arrayOfMyByteArray[paramInt], localMyByteArray3, new byte[] { 14, 17, 11, 24, 1, 5, 3, 28, 15, 6, 21, 10, 23, 19, 12, 4, 26, 8, 16, 7, 27, 20, 13, 2, 41, 52, 31, 37, 47, 55, 30, 40, 51, 45, 33, 48, 44, 49, 39, 56, 34, 53, 46, 42, 50, 36, 29, 32 }, 48, localMyByteArray1);
      paramInt += 1;
    }
    i = paramArrayOfByte2.bud;
    int j = paramArrayOfByte1.bud;
    a(paramArrayOfByte1, tmp348_346, arrayOfMyByteArray, localMyByteArray8, localMyByteArray9, localMyByteArray10, localMyByteArray6, localMyByteArray7, localMyByteArray1);
    d(tmp353_348, paramArrayOfByte1, 8);
    paramArrayOfByte1.bud += 8;
    paramLong = 0L;
    while (paramLong < l >> 3)
    {
      paramInt = 0;
      while (paramInt < 8)
      {
        tmp353_348.buc[(tmp353_348.bud + paramInt)] = ((byte)(tmp353_348.buc[(tmp353_348.bud + paramInt)] ^ paramArrayOfByte2.buc[(paramArrayOfByte2.bud + paramInt)]));
        paramInt += 1;
      }
      a(paramArrayOfByte1, tmp353_348, arrayOfMyByteArray, localMyByteArray8, localMyByteArray9, localMyByteArray10, localMyByteArray6, localMyByteArray7, localMyByteArray1);
      d(tmp353_348, paramArrayOfByte1, 8);
      paramLong += 1L;
      paramArrayOfByte1.bud += 8;
      paramArrayOfByte2.bud += 8;
    }
    paramArrayOfByte2.bud = i;
    paramArrayOfByte1.bud = j;
    return '\001';
  }
  
  private static void a(MyByteArray paramMyByteArray, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      paramMyByteArray.buc[(paramMyByteArray.bud + i)] = 0;
      i += 1;
    }
  }
  
  private static void a(MyByteArray paramMyByteArray1, MyByteArray paramMyByteArray2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      byte[] arrayOfByte = paramMyByteArray1.buc;
      int j = paramMyByteArray1.bud + i;
      arrayOfByte[j] = ((byte)(arrayOfByte[j] ^ paramMyByteArray2.buc[(paramMyByteArray2.bud + i)]));
      i += 1;
    }
  }
  
  private static void a(MyByteArray paramMyByteArray1, MyByteArray paramMyByteArray2, byte[] paramArrayOfByte, int paramInt, MyByteArray paramMyByteArray3)
  {
    int i = 0;
    while (i < paramInt)
    {
      paramMyByteArray3.buc[(paramMyByteArray3.bud + i)] = paramMyByteArray2.buc[(paramMyByteArray2.bud + paramArrayOfByte[i] - 1)];
      i += 1;
    }
    d(paramMyByteArray1, paramMyByteArray3, paramInt);
  }
  
  private static void a(MyByteArray paramMyByteArray1, MyByteArray paramMyByteArray2, MyByteArray[] paramArrayOfMyByteArray, MyByteArray paramMyByteArray3, MyByteArray paramMyByteArray4, MyByteArray paramMyByteArray5, MyByteArray paramMyByteArray6, MyByteArray paramMyByteArray7, MyByteArray paramMyByteArray8)
  {
    b(paramMyByteArray3, paramMyByteArray2, 64);
    a(paramMyByteArray3, paramMyByteArray3, new byte[] { 58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, 12, 4, 62, 54, 46, 38, 30, 22, 14, 6, 64, 56, 48, 40, 32, 24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19, 11, 3, 61, 53, 45, 37, 29, 21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7 }, 64, paramMyByteArray8);
    int i = 0;
    int j;
    while (i < 16)
    {
      d(paramMyByteArray5, paramMyByteArray7, 32);
      paramMyByteArray2 = paramArrayOfMyByteArray[i];
      a(paramMyByteArray4, paramMyByteArray7, new byte[] { 32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9, 10, 11, 12, 13, 12, 13, 14, 15, 16, 17, 16, 17, 18, 19, 20, 21, 20, 21, 22, 23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1 }, 48, paramMyByteArray8);
      a(paramMyByteArray4, paramMyByteArray2, 48);
      paramMyByteArray2 = new byte[][] { { 14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7 }, { 0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8 }, { 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0 }, { 15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13 } };
      byte[] arrayOfByte7 = { 15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10 };
      byte[] arrayOfByte8 = { 3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5 };
      byte[] arrayOfByte9 = { 0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15 };
      byte[] arrayOfByte10 = { 13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9 };
      byte[][] arrayOfByte1 = { { 10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8 }, { 13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1 }, { 13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7 }, { 1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12 } };
      byte[] arrayOfByte3 = { 3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14 };
      byte[][] arrayOfByte2 = { { 2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9 }, { 14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6 }, { 4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14 }, { 11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3 } };
      byte[] arrayOfByte4 = { 10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8 };
      byte[] arrayOfByte5 = { 9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6 };
      byte[] arrayOfByte6 = { 4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13 };
      Object localObject = { 1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2 };
      localObject = new byte[][] { { 4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1 }, { 13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6 }, localObject, { 6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12 } };
      byte[] arrayOfByte11 = { 1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2 };
      byte[] arrayOfByte12 = { 2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11 };
      int k = paramMyByteArray4.bud;
      int m = paramMyByteArray7.bud;
      j = 0;
      while (j < 8)
      {
        int n = (byte)((paramMyByteArray4.buc[(paramMyByteArray4.bud + 0)] << 1) + paramMyByteArray4.buc[(paramMyByteArray4.bud + 5)]);
        int i1 = (byte)((paramMyByteArray4.buc[(paramMyByteArray4.bud + 1)] << 3) + (paramMyByteArray4.buc[(paramMyByteArray4.bud + 2)] << 2) + (paramMyByteArray4.buc[(paramMyByteArray4.bud + 3)] << 1) + paramMyByteArray4.buc[(paramMyByteArray4.bud + 4)]);
        b(paramMyByteArray7, new MyByteArray(new byte[][][] { paramMyByteArray2, { arrayOfByte7, arrayOfByte8, arrayOfByte9, arrayOfByte10 }, arrayOfByte1, { { 7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15 }, { 13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9 }, { 10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4 }, arrayOfByte3 }, arrayOfByte2, { { 12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11 }, arrayOfByte4, arrayOfByte5, arrayOfByte6 }, localObject, { { 13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7 }, arrayOfByte11, { 7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8 }, arrayOfByte12 } }[j][n][i1]), 4);
        j = (byte)(j + 1);
        paramMyByteArray4.bud += 6;
        paramMyByteArray7.bud += 4;
      }
      paramMyByteArray4.bud = k;
      paramMyByteArray7.bud = m;
      a(paramMyByteArray7, paramMyByteArray7, new byte[] { 16, 7, 20, 21, 29, 12, 28, 17, 1, 15, 23, 26, 5, 18, 31, 10, 2, 8, 24, 14, 32, 27, 3, 9, 19, 13, 30, 6, 22, 11, 4, 25 }, 32, paramMyByteArray8);
      a(paramMyByteArray7, paramMyByteArray6, 32);
      d(paramMyByteArray6, paramMyByteArray5, 32);
      i += 1;
    }
    a(paramMyByteArray3, paramMyByteArray3, new byte[] { 40, 8, 48, 16, 56, 24, 64, 32, 39, 7, 47, 15, 55, 23, 63, 31, 38, 6, 46, 14, 54, 22, 62, 30, 37, 5, 45, 13, 53, 21, 61, 29, 36, 4, 44, 12, 52, 20, 60, 28, 35, 3, 43, 11, 51, 19, 59, 27, 34, 2, 42, 10, 50, 18, 58, 26, 33, 1, 41, 9, 49, 17, 57, 25 }, 64, paramMyByteArray8);
    a(paramMyByteArray1, 8);
    i = 0;
    while (i < 64)
    {
      paramMyByteArray2 = paramMyByteArray1.buc;
      j = paramMyByteArray1.bud + (i >> 3);
      paramMyByteArray2[j] = ((byte)(paramMyByteArray2[j] | paramMyByteArray3.buc[(paramMyByteArray3.bud + i)] << (i & 0x7)));
      i += 1;
    }
  }
  
  private static void b(MyByteArray paramMyByteArray1, MyByteArray paramMyByteArray2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      paramMyByteArray1.buc[(paramMyByteArray1.bud + i)] = ((byte)(paramMyByteArray2.buc[((i >> 3) + paramMyByteArray2.bud)] >> (i & 0x7) & 0x1));
      i += 1;
    }
  }
  
  private static void c(MyByteArray paramMyByteArray1, MyByteArray paramMyByteArray2, int paramInt)
  {
    int k = 0;
    d(paramMyByteArray2, paramMyByteArray1, paramInt);
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= 28 - paramInt) {
        break;
      }
      paramMyByteArray1.buc[(paramMyByteArray1.bud + i)] = paramMyByteArray1.buc[(paramMyByteArray1.bud + i + paramInt)];
      i += 1;
    }
    while (j < paramInt)
    {
      paramMyByteArray1.buc[(paramMyByteArray1.bud + j + 28 - paramInt)] = paramMyByteArray2.buc[(paramMyByteArray2.bud + j)];
      j += 1;
    }
  }
  
  private static void d(MyByteArray paramMyByteArray1, MyByteArray paramMyByteArray2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      paramMyByteArray1.buc[(paramMyByteArray1.bud + i)] = paramMyByteArray2.buc[(paramMyByteArray2.bud + i)];
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.wx.util.MyDES
 * JD-Core Version:    0.7.0.1
 */