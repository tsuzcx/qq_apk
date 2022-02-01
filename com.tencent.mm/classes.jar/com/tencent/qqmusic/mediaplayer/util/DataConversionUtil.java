package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteOrder;

public class DataConversionUtil
{
  private static final float BASE_16BIT = 32768.0F;
  private static final float BASE_32BIT = 2.147484E+009F;
  private static final boolean IS_LITTLE_ENDIAN;
  
  static
  {
    AppMethodBeat.i(87727);
    if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {}
    for (boolean bool = true;; bool = false)
    {
      IS_LITTLE_ENDIAN = bool;
      AppMethodBeat.o(87727);
      return;
    }
  }
  
  public static int byteArray16BitToShortArray(byte[] paramArrayOfByte, int paramInt, short[] paramArrayOfShort)
  {
    AppMethodBeat.i(87716);
    checkByteArrayLength(paramArrayOfByte, paramInt);
    checkShortArrayLength(paramArrayOfShort, paramInt / 2);
    if (paramInt % 2 != 0)
    {
      paramArrayOfByte = new IllegalArgumentException("length of byteArray must be multiple of 2");
      AppMethodBeat.o(87716);
      throw paramArrayOfByte;
    }
    int j = 0;
    int k = 0;
    if ((j < paramInt) && (k < paramArrayOfShort.length))
    {
      if (IS_LITTLE_ENDIAN) {}
      for (int i = bytesToShort16bitInLittleEndian(paramArrayOfByte, j);; i = bytesToShort16bitInBigEndian(paramArrayOfByte, j))
      {
        paramArrayOfShort[k] = i;
        k += 1;
        j += 2;
        break;
      }
    }
    AppMethodBeat.o(87716);
    return k;
  }
  
  public static int byteArray24BitToIntArray(byte[] paramArrayOfByte, int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(87717);
    checkByteArrayLength(paramArrayOfByte, paramInt);
    checkIntArrayLength(paramArrayOfInt, paramInt / 3);
    if (paramInt % 3 != 0)
    {
      paramArrayOfByte = new IllegalArgumentException("length of byteArray must be multiple of 3");
      AppMethodBeat.o(87717);
      throw paramArrayOfByte;
    }
    int i = 0;
    int j = 0;
    if ((i < paramInt) && (j < paramArrayOfInt.length))
    {
      if (IS_LITTLE_ENDIAN) {}
      for (int k = bytesToInt24bitInLittleEndian(paramArrayOfByte, i);; k = bytesToInt24bitInBigEndian(paramArrayOfByte, i))
      {
        paramArrayOfInt[j] = k;
        j += 1;
        i += 3;
        break;
      }
    }
    AppMethodBeat.o(87717);
    return j;
  }
  
  public static int byteArray32BitToIntArray(byte[] paramArrayOfByte, int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(87718);
    checkByteArrayLength(paramArrayOfByte, paramInt);
    checkIntArrayLength(paramArrayOfInt, paramInt / 4);
    if (paramInt % 4 != 0)
    {
      paramArrayOfByte = new IllegalArgumentException("length of byteArray must be multiple of 4");
      AppMethodBeat.o(87718);
      throw paramArrayOfByte;
    }
    int i = 0;
    int j = 0;
    if ((i < paramInt) && (j < paramArrayOfInt.length))
    {
      if (IS_LITTLE_ENDIAN) {}
      for (int k = bytesToInt32bitInLittleEndian(paramArrayOfByte, i);; k = bytesToInt32bitInBigEndian(paramArrayOfByte, i))
      {
        paramArrayOfInt[j] = k;
        j += 1;
        i += 4;
        break;
      }
    }
    AppMethodBeat.o(87718);
    return j;
  }
  
  public static int byteArrayToFloatArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(87715);
    checkByteArrayLength(paramArrayOfByte, paramInt1);
    checkFloatArrayLength(paramArrayOfFloat, paramInt1 / paramInt2);
    checkByteArrayProperty(paramInt1, paramInt2);
    int i = 0;
    int j = 0;
    if (i < paramInt1)
    {
      int k = i / paramInt2;
      if (paramInt2 == 3) {}
      for (float f = bytesToFloat24bit(paramArrayOfByte, i);; f = bytesToFloat32bit(paramArrayOfByte, i))
      {
        paramArrayOfFloat[k] = f;
        j += 1;
        i += paramInt2;
        break;
      }
    }
    AppMethodBeat.o(87715);
    return j;
  }
  
  public static float bytesToFloat24bit(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(87708);
    if (IS_LITTLE_ENDIAN)
    {
      f = bytesToFloat24bitInLittleEndian(paramArrayOfByte, paramInt);
      AppMethodBeat.o(87708);
      return f;
    }
    float f = bytesToFloat24bitInBigEndian(paramArrayOfByte, paramInt);
    AppMethodBeat.o(87708);
    return f;
  }
  
  public static float bytesToFloat24bitInBigEndian(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(87711);
    float f = bytesToInt24bitInBigEndian(paramArrayOfByte, paramInt) / 2.147484E+009F;
    AppMethodBeat.o(87711);
    return f;
  }
  
  public static float bytesToFloat24bitInLittleEndian(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(87710);
    float f = bytesToInt24bitInLittleEndian(paramArrayOfByte, paramInt) / 2.147484E+009F;
    AppMethodBeat.o(87710);
    return f;
  }
  
  public static float bytesToFloat32bit(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(87709);
    if (IS_LITTLE_ENDIAN)
    {
      f = bytesToFloat32bitInLittleEndian(paramArrayOfByte, paramInt);
      AppMethodBeat.o(87709);
      return f;
    }
    float f = bytesToFloat32bitInBigEndian(paramArrayOfByte, paramInt);
    AppMethodBeat.o(87709);
    return f;
  }
  
  public static float bytesToFloat32bitInBigEndian(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(87713);
    float f = bytesToInt32bitInBigEndian(paramArrayOfByte, paramInt) / 2.147484E+009F;
    AppMethodBeat.o(87713);
    return f;
  }
  
  public static float bytesToFloat32bitInLittleEndian(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(87712);
    float f = bytesToInt32bitInLittleEndian(paramArrayOfByte, paramInt) / 2.147484E+009F;
    AppMethodBeat.o(87712);
    return f;
  }
  
  public static int bytesToInt24bitInBigEndian(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[(paramInt + 2)] << 8 & 0xFF | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16 | (paramArrayOfByte[paramInt] & 0xFF) << 24;
  }
  
  public static int bytesToInt24bitInLittleEndian(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[paramInt] << 8 & 0xFF | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 24;
  }
  
  public static int bytesToInt32bitInBigEndian(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[(paramInt + 3)] & 0xFF | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16 | (paramArrayOfByte[paramInt] & 0xFF) << 24;
  }
  
  public static int bytesToInt32bitInLittleEndian(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[paramInt] & 0xFF | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24;
  }
  
  public static short bytesToShort16bitInBigEndian(byte[] paramArrayOfByte, int paramInt)
  {
    return (short)(paramArrayOfByte[(paramInt + 1)] & 0xFF | (paramArrayOfByte[paramInt] & 0xFF) << 8);
  }
  
  public static short bytesToShort16bitInLittleEndian(byte[] paramArrayOfByte, int paramInt)
  {
    return (short)(paramArrayOfByte[paramInt] & 0xFF | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8);
  }
  
  private static void checkByteArrayLength(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(87723);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      paramArrayOfByte = new IllegalArgumentException("byte Array must not be null or zero length");
      AppMethodBeat.o(87723);
      throw paramArrayOfByte;
    }
    if (paramInt > paramArrayOfByte.length)
    {
      paramArrayOfByte = new IllegalArgumentException("the length param can not larger than byte Array length. param:" + paramInt + ", byte array length:" + paramArrayOfByte.length);
      AppMethodBeat.o(87723);
      throw paramArrayOfByte;
    }
    AppMethodBeat.o(87723);
  }
  
  private static void checkByteArrayProperty(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(87722);
    IllegalArgumentException localIllegalArgumentException;
    if ((paramInt2 > 4) || (paramInt2 < 3))
    {
      localIllegalArgumentException = new IllegalArgumentException("bytesPerSample of " + paramInt2 + " is not supported");
      AppMethodBeat.o(87722);
      throw localIllegalArgumentException;
    }
    if (paramInt1 % paramInt2 != 0)
    {
      localIllegalArgumentException = new IllegalArgumentException("length of byteArray must be multiple of bytesPerSample");
      AppMethodBeat.o(87722);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(87722);
  }
  
  private static void checkFloatArrayLength(float[] paramArrayOfFloat, int paramInt)
  {
    AppMethodBeat.i(87726);
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length == 0))
    {
      paramArrayOfFloat = new IllegalArgumentException("float Array must not be null or zero length");
      AppMethodBeat.o(87726);
      throw paramArrayOfFloat;
    }
    if (paramInt > paramArrayOfFloat.length)
    {
      paramArrayOfFloat = new IllegalArgumentException("the length param can not larger than float Array length. param:" + paramInt + ", float array length:" + paramArrayOfFloat.length);
      AppMethodBeat.o(87726);
      throw paramArrayOfFloat;
    }
    AppMethodBeat.o(87726);
  }
  
  private static void checkIntArrayLength(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(87725);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
    {
      paramArrayOfInt = new IllegalArgumentException("int Array must not be null or zero length");
      AppMethodBeat.o(87725);
      throw paramArrayOfInt;
    }
    if (paramInt > paramArrayOfInt.length)
    {
      paramArrayOfInt = new IllegalArgumentException("the length param can not larger than int Array length. param:" + paramInt + ", int array length:" + paramArrayOfInt.length);
      AppMethodBeat.o(87725);
      throw paramArrayOfInt;
    }
    AppMethodBeat.o(87725);
  }
  
  private static void checkShortArrayLength(short[] paramArrayOfShort, int paramInt)
  {
    AppMethodBeat.i(87724);
    if ((paramArrayOfShort == null) || (paramArrayOfShort.length == 0))
    {
      paramArrayOfShort = new IllegalArgumentException("short Array must not be null or zero length");
      AppMethodBeat.o(87724);
      throw paramArrayOfShort;
    }
    if (paramInt > paramArrayOfShort.length)
    {
      paramArrayOfShort = new IllegalArgumentException("the length param can not larger than short Array length. param:" + paramInt + ", short array length:" + paramArrayOfShort.length);
      AppMethodBeat.o(87724);
      throw paramArrayOfShort;
    }
    AppMethodBeat.o(87724);
  }
  
  public static void floatTo2Bytes(float paramFloat, byte[] paramArrayOfByte, int paramInt)
  {
    float f2 = 1.0F;
    float f1 = -1.0F;
    AppMethodBeat.i(87714);
    if (paramFloat > 1.0F) {
      paramFloat = f2;
    }
    for (;;)
    {
      if (paramFloat < -1.0F) {
        paramFloat = f1;
      }
      for (;;)
      {
        shortTo2Bytes((short)(int)(paramFloat * 32768.0F), paramArrayOfByte, paramInt);
        AppMethodBeat.o(87714);
        return;
      }
    }
  }
  
  public static int intArrayToByteArray24Bit(int[] paramArrayOfInt, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(87720);
    checkIntArrayLength(paramArrayOfInt, paramInt);
    checkByteArrayLength(paramArrayOfByte, paramInt * 3);
    int j = 0;
    int i = 0;
    while (j < paramInt)
    {
      intTo3Bytes(paramArrayOfInt[j], paramArrayOfByte, i);
      j += 1;
      i += 3;
    }
    AppMethodBeat.o(87720);
    return i;
  }
  
  public static int intArrayToByteArray32Bit(int[] paramArrayOfInt, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(87721);
    checkIntArrayLength(paramArrayOfInt, paramInt);
    checkByteArrayLength(paramArrayOfByte, paramInt * 4);
    int j = 0;
    int i = 0;
    while (j < paramInt)
    {
      intTo4Bytes(paramArrayOfInt[j], paramArrayOfByte, i);
      j += 1;
      i += 4;
    }
    AppMethodBeat.o(87721);
    return i;
  }
  
  public static void intTo3Bytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    if (IS_LITTLE_ENDIAN)
    {
      paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >> 8 & 0xFF));
      paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 16 & 0xFF));
      paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 >> 24 & 0xFF));
      return;
    }
    paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 >> 8 & 0xFF));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 16 & 0xFF));
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >> 24 & 0xFF));
  }
  
  public static void intTo4Bytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    if (IS_LITTLE_ENDIAN)
    {
      paramArrayOfByte[paramInt2] = ((byte)(paramInt1 & 0xFF));
      paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 8 & 0xFF));
      paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 >> 16 & 0xFF));
      paramArrayOfByte[(paramInt2 + 3)] = ((byte)(paramInt1 >> 24 & 0xFF));
      return;
    }
    paramArrayOfByte[(paramInt2 + 3)] = ((byte)(paramInt1 & 0xFF));
    paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 >> 8 & 0xFF));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 16 & 0xFF));
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >> 24 & 0xFF));
  }
  
  public static int shortArrayToByteArray16Bit(short[] paramArrayOfShort, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(87719);
    checkShortArrayLength(paramArrayOfShort, paramInt);
    checkByteArrayLength(paramArrayOfByte, paramInt * 2);
    int j = 0;
    int i = 0;
    while (j < paramInt)
    {
      shortTo2Bytes(paramArrayOfShort[j], paramArrayOfByte, i);
      j += 1;
      i += 2;
    }
    AppMethodBeat.o(87719);
    return i;
  }
  
  public static void shortTo2Bytes(short paramShort, byte[] paramArrayOfByte, int paramInt)
  {
    if (IS_LITTLE_ENDIAN)
    {
      paramArrayOfByte[paramInt] = ((byte)(paramShort & 0xFF));
      paramArrayOfByte[(paramInt + 1)] = ((byte)(paramShort >> 8 & 0xFF));
      return;
    }
    paramArrayOfByte[(paramInt + 1)] = ((byte)(paramShort & 0xFF));
    paramArrayOfByte[paramInt] = ((byte)(paramShort >> 8 & 0xFF));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.DataConversionUtil
 * JD-Core Version:    0.7.0.1
 */