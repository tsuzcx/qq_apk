package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.BufferInfo;
import com.tencent.qqmusic.mediaplayer.FloatBufferInfo;

public class PcmConvertionUtil
{
  private static void checkArrayLength(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(103514);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
    {
      paramArrayOfInt = new IllegalArgumentException("int Array must not be null or zero length");
      AppMethodBeat.o(103514);
      throw paramArrayOfInt;
    }
    if (paramInt > paramArrayOfInt.length)
    {
      paramArrayOfInt = new IllegalArgumentException("the length param can not larger than int Array length. param:" + paramInt + ", int array length:" + paramArrayOfInt.length);
      AppMethodBeat.o(103514);
      throw paramArrayOfInt;
    }
    AppMethodBeat.o(103514);
  }
  
  private static void checkArrayLength(short[] paramArrayOfShort, int paramInt)
  {
    AppMethodBeat.i(103515);
    if ((paramArrayOfShort == null) || (paramArrayOfShort.length == 0))
    {
      paramArrayOfShort = new IllegalArgumentException("short Array must not be null or zero length");
      AppMethodBeat.o(103515);
      throw paramArrayOfShort;
    }
    if (paramInt > paramArrayOfShort.length)
    {
      paramArrayOfShort = new IllegalArgumentException("the length param can not larger than short Array length. param:" + paramInt + ", short array length:" + paramArrayOfShort.length);
      AppMethodBeat.o(103515);
      throw paramArrayOfShort;
    }
    AppMethodBeat.o(103515);
  }
  
  private static void checkBufferLength(BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(103513);
    if ((paramBufferInfo == null) || (paramBufferInfo.byteBuffer == null) || (paramBufferInfo.bufferSize <= 0))
    {
      paramBufferInfo = new IllegalArgumentException("bufferInfo must not be null or zero length");
      AppMethodBeat.o(103513);
      throw paramBufferInfo;
    }
    AppMethodBeat.o(103513);
  }
  
  private static void convertBitDepth24To16(BufferInfo paramBufferInfo1, BufferInfo paramBufferInfo2, int paramInt)
  {
    AppMethodBeat.i(103504);
    checkBufferLength(paramBufferInfo1);
    if (paramBufferInfo2 == null)
    {
      paramBufferInfo1 = new IllegalArgumentException("BufferInfo dest must not be null");
      AppMethodBeat.o(103504);
      throw paramBufferInfo1;
    }
    if (paramInt != 3)
    {
      paramBufferInfo1 = new IllegalArgumentException("origin bit depth must be 3");
      AppMethodBeat.o(103504);
      throw paramBufferInfo1;
    }
    int k = paramBufferInfo1.bufferSize;
    paramBufferInfo2.setTempByteBufferCapacity(paramBufferInfo1.bufferSize);
    int i = 0;
    paramInt = 0;
    if (i < k)
    {
      if (i % 3 == 0) {
        break label133;
      }
      byte[] arrayOfByte = paramBufferInfo2.tempByteBuffer;
      int j = paramInt + 1;
      arrayOfByte[paramInt] = paramBufferInfo1.byteBuffer[i];
      paramInt = j;
    }
    label133:
    for (;;)
    {
      i += 1;
      break;
      paramBufferInfo2.fillByte(paramBufferInfo2.tempByteBuffer, paramInt);
      paramBufferInfo2.bufferSize = paramInt;
      AppMethodBeat.o(103504);
      return;
    }
  }
  
  private static void convertBitDepth32To16(BufferInfo paramBufferInfo1, BufferInfo paramBufferInfo2, int paramInt)
  {
    AppMethodBeat.i(103505);
    checkBufferLength(paramBufferInfo1);
    if (paramBufferInfo2 == null)
    {
      paramBufferInfo1 = new IllegalArgumentException("BufferInfo dest must not be null");
      AppMethodBeat.o(103505);
      throw paramBufferInfo1;
    }
    if (paramInt != 4)
    {
      paramBufferInfo1 = new IllegalArgumentException("origin bit depth must be 4");
      AppMethodBeat.o(103505);
      throw paramBufferInfo1;
    }
    int j = paramBufferInfo1.bufferSize;
    paramBufferInfo2.setTempByteBufferCapacity(paramBufferInfo1.bufferSize);
    int i = 0;
    paramInt = 0;
    while (i < j)
    {
      DataConversionUtil.floatTo2Bytes(DataConversionUtil.bytesToFloat32bitInLittleEndian(paramBufferInfo1.byteBuffer, i), paramBufferInfo2.tempByteBuffer, paramInt);
      i += 4;
      paramInt += 2;
    }
    paramBufferInfo2.fillByte(paramBufferInfo2.tempByteBuffer, paramInt);
    paramBufferInfo2.bufferSize = paramInt;
    AppMethodBeat.o(103505);
  }
  
  public static void convertBitDepthTo16(BufferInfo paramBufferInfo1, BufferInfo paramBufferInfo2, int paramInt)
  {
    AppMethodBeat.i(103503);
    switch (paramInt)
    {
    default: 
      paramBufferInfo1 = new IllegalArgumentException("not support originBitDepth, originBitDepth=".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(103503);
      throw paramBufferInfo1;
    case 2: 
      checkBufferLength(paramBufferInfo1);
      paramBufferInfo1.fillInto(paramBufferInfo2);
      AppMethodBeat.o(103503);
      return;
    case 3: 
      convertBitDepth24To16(paramBufferInfo1, paramBufferInfo2, paramInt);
      AppMethodBeat.o(103503);
      return;
    }
    convertBitDepth32To16(paramBufferInfo1, paramBufferInfo2, paramInt);
    AppMethodBeat.o(103503);
  }
  
  public static void convertByteBufferToFloatBuffer(BufferInfo paramBufferInfo, FloatBufferInfo paramFloatBufferInfo, int paramInt)
  {
    AppMethodBeat.i(103506);
    checkBufferLength(paramBufferInfo);
    if (paramFloatBufferInfo == null)
    {
      paramBufferInfo = new IllegalArgumentException("BufferInfo dest must not be null");
      AppMethodBeat.o(103506);
      throw paramBufferInfo;
    }
    if (paramInt <= 0)
    {
      paramBufferInfo = new IllegalArgumentException("bit depth must not be zero");
      AppMethodBeat.o(103506);
      throw paramBufferInfo;
    }
    paramFloatBufferInfo.setTempFloatBufferCapacity(paramBufferInfo.bufferSize / paramInt);
    paramFloatBufferInfo.bufferSize = (paramBufferInfo.bufferSize / paramInt);
    DataConversionUtil.byteArrayToFloatArray(paramBufferInfo.byteBuffer, paramBufferInfo.bufferSize, paramInt, paramFloatBufferInfo.tempFloatBuffer);
    paramFloatBufferInfo.fillFloat(paramFloatBufferInfo.tempFloatBuffer, paramFloatBufferInfo.bufferSize);
    AppMethodBeat.o(103506);
  }
  
  private static void interpolateIn16Bit(BufferInfo paramBufferInfo1, BufferInfo paramBufferInfo2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(103508);
    int i = paramBufferInfo1.bufferSize / 2;
    int j = Math.round(1.0F * i / (float)paramLong1 * (float)paramLong2);
    float f = j / i;
    short[] arrayOfShort2 = new short[i];
    short[] arrayOfShort1 = new short[j];
    DataConversionUtil.byteArray16BitToShortArray(paramBufferInfo1.byteBuffer, paramBufferInfo1.bufferSize, arrayOfShort2);
    linearInterpolate(arrayOfShort2, i, arrayOfShort1, j, f);
    paramBufferInfo1 = new byte[j * 2];
    DataConversionUtil.shortArrayToByteArray16Bit(arrayOfShort1, j, paramBufferInfo1);
    paramBufferInfo2.fillByte(paramBufferInfo1, paramBufferInfo1.length);
    AppMethodBeat.o(103508);
  }
  
  private static void interpolateIn24Bit(BufferInfo paramBufferInfo1, BufferInfo paramBufferInfo2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(103509);
    int i = paramBufferInfo1.bufferSize / 3;
    int j = Math.round(1.0F * i / (float)paramLong1 * (float)paramLong2);
    float f = j / i;
    int[] arrayOfInt2 = new int[i];
    int[] arrayOfInt1 = new int[j];
    DataConversionUtil.byteArray24BitToIntArray(paramBufferInfo1.byteBuffer, paramBufferInfo1.bufferSize, arrayOfInt2);
    linearInterpolate(arrayOfInt2, i, arrayOfInt1, j, f);
    paramBufferInfo1 = new byte[j * 3];
    DataConversionUtil.intArrayToByteArray24Bit(arrayOfInt1, j, paramBufferInfo1);
    paramBufferInfo2.fillByte(paramBufferInfo1, paramBufferInfo1.length);
    AppMethodBeat.o(103509);
  }
  
  private static void interpolateIn32Bit(BufferInfo paramBufferInfo1, BufferInfo paramBufferInfo2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(103510);
    int i = paramBufferInfo1.bufferSize / 4;
    int j = Math.round(1.0F * i / (float)paramLong1 * (float)paramLong2);
    float f = j / i;
    int[] arrayOfInt2 = new int[i];
    int[] arrayOfInt1 = new int[j];
    DataConversionUtil.byteArray32BitToIntArray(paramBufferInfo1.byteBuffer, paramBufferInfo1.bufferSize, arrayOfInt2);
    linearInterpolate(arrayOfInt2, i, arrayOfInt1, j, f);
    paramBufferInfo1 = new byte[j * 4];
    DataConversionUtil.intArrayToByteArray32Bit(arrayOfInt1, j, paramBufferInfo1);
    paramBufferInfo2.fillByte(paramBufferInfo1, paramBufferInfo1.length);
    AppMethodBeat.o(103510);
  }
  
  private static void linearInterpolate(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2, float paramFloat)
  {
    AppMethodBeat.i(103511);
    checkArrayLength(paramArrayOfInt1, paramInt1);
    checkArrayLength(paramArrayOfInt2, paramInt2);
    int i = 0;
    while (i < paramInt2)
    {
      float f = i / paramFloat;
      int m = (int)f;
      int k = m + 1;
      int j = k;
      if (k >= paramInt1) {
        j = paramInt1 - 1;
      }
      paramArrayOfInt2[i] = ((int)((paramArrayOfInt1[j] - paramArrayOfInt1[m]) * (f - m) + paramArrayOfInt1[m]));
      i += 1;
    }
    AppMethodBeat.o(103511);
  }
  
  private static void linearInterpolate(short[] paramArrayOfShort1, int paramInt1, short[] paramArrayOfShort2, int paramInt2, float paramFloat)
  {
    AppMethodBeat.i(103512);
    checkArrayLength(paramArrayOfShort1, paramInt1);
    checkArrayLength(paramArrayOfShort2, paramInt2);
    int i = 0;
    while (i < paramInt2)
    {
      float f = i / paramFloat;
      int m = (int)f;
      int k = m + 1;
      int j = k;
      if (k >= paramInt1) {
        j = paramInt1 - 1;
      }
      paramArrayOfShort2[i] = ((short)(int)((paramArrayOfShort1[j] - paramArrayOfShort1[m]) * (f - m) + paramArrayOfShort1[m]));
      i += 1;
    }
    AppMethodBeat.o(103512);
  }
  
  public static void reSample(BufferInfo paramBufferInfo1, BufferInfo paramBufferInfo2, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(103507);
    checkBufferLength(paramBufferInfo1);
    if (paramBufferInfo2 == null)
    {
      paramBufferInfo1 = new IllegalArgumentException("BufferInfo dest must not be null");
      AppMethodBeat.o(103507);
      throw paramBufferInfo1;
    }
    if ((paramLong1 == paramLong2) || (paramLong2 <= 0L) || (paramLong1 <= 0L))
    {
      paramBufferInfo1.fillInto(paramBufferInfo2);
      AppMethodBeat.o(103507);
      return;
    }
    switch (paramInt)
    {
    default: 
      paramBufferInfo1.fillInto(paramBufferInfo2);
      AppMethodBeat.o(103507);
      return;
    case 2: 
      interpolateIn16Bit(paramBufferInfo1, paramBufferInfo2, paramLong1, paramLong2);
      AppMethodBeat.o(103507);
      return;
    case 3: 
      interpolateIn24Bit(paramBufferInfo1, paramBufferInfo2, paramLong1, paramLong2);
      AppMethodBeat.o(103507);
      return;
    }
    interpolateIn32Bit(paramBufferInfo1, paramBufferInfo2, paramLong1, paramLong2);
    AppMethodBeat.o(103507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.PcmConvertionUtil
 * JD-Core Version:    0.7.0.1
 */