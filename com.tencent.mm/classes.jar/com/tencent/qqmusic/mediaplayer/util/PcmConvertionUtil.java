package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.qqmusic.mediaplayer.BufferInfo;
import com.tencent.qqmusic.mediaplayer.FloatBufferInfo;

public class PcmConvertionUtil
{
  private static void checkArrayLength(int[] paramArrayOfInt, int paramInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      throw new IllegalArgumentException("int Array must not be null or zero length");
    }
    if (paramInt > paramArrayOfInt.length) {
      throw new IllegalArgumentException("the length param can not larger than int Array length. param:" + paramInt + ", int array length:" + paramArrayOfInt.length);
    }
  }
  
  private static void checkArrayLength(short[] paramArrayOfShort, int paramInt)
  {
    if ((paramArrayOfShort == null) || (paramArrayOfShort.length == 0)) {
      throw new IllegalArgumentException("short Array must not be null or zero length");
    }
    if (paramInt > paramArrayOfShort.length) {
      throw new IllegalArgumentException("the length param can not larger than short Array length. param:" + paramInt + ", short array length:" + paramArrayOfShort.length);
    }
  }
  
  private static void checkBufferLength(BufferInfo paramBufferInfo)
  {
    if ((paramBufferInfo == null) || (paramBufferInfo.byteBuffer == null) || (paramBufferInfo.bufferSize <= 0)) {
      throw new IllegalArgumentException("bufferInfo must not be null or zero length");
    }
  }
  
  private static void convertBitDepth24To16(BufferInfo paramBufferInfo1, BufferInfo paramBufferInfo2, int paramInt)
  {
    checkBufferLength(paramBufferInfo1);
    if (paramBufferInfo2 == null) {
      throw new IllegalArgumentException("BufferInfo dest must not be null");
    }
    if (paramInt != 3) {
      throw new IllegalArgumentException("origin bit depth must be 3");
    }
    int k = paramBufferInfo1.bufferSize;
    paramBufferInfo2.setTempByteBufferCapacity(paramBufferInfo1.bufferSize);
    int i = 0;
    paramInt = 0;
    if (i < k)
    {
      if (i % 3 == 0) {
        break label109;
      }
      byte[] arrayOfByte = paramBufferInfo2.tempByteBuffer;
      int j = paramInt + 1;
      arrayOfByte[paramInt] = paramBufferInfo1.byteBuffer[i];
      paramInt = j;
    }
    label109:
    for (;;)
    {
      i += 1;
      break;
      paramBufferInfo2.fillByte(paramBufferInfo2.tempByteBuffer, paramInt);
      paramBufferInfo2.bufferSize = paramInt;
      return;
    }
  }
  
  private static void convertBitDepth32To16(BufferInfo paramBufferInfo1, BufferInfo paramBufferInfo2, int paramInt)
  {
    checkBufferLength(paramBufferInfo1);
    if (paramBufferInfo2 == null) {
      throw new IllegalArgumentException("BufferInfo dest must not be null");
    }
    if (paramInt != 4) {
      throw new IllegalArgumentException("origin bit depth must be 4");
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
  }
  
  public static void convertBitDepthTo16(BufferInfo paramBufferInfo1, BufferInfo paramBufferInfo2, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("not support originBitDepth, originBitDepth=" + paramInt);
    case 2: 
      checkBufferLength(paramBufferInfo1);
      paramBufferInfo1.copy(paramBufferInfo2);
      return;
    case 3: 
      convertBitDepth24To16(paramBufferInfo1, paramBufferInfo2, paramInt);
      return;
    }
    convertBitDepth32To16(paramBufferInfo1, paramBufferInfo2, paramInt);
  }
  
  public static void convertByteBufferToFloatBuffer(BufferInfo paramBufferInfo, FloatBufferInfo paramFloatBufferInfo, int paramInt)
  {
    checkBufferLength(paramBufferInfo);
    if (paramFloatBufferInfo == null) {
      throw new IllegalArgumentException("BufferInfo dest must not be null");
    }
    if (paramInt <= 0) {
      throw new IllegalArgumentException("bit depth must not be zero");
    }
    paramFloatBufferInfo.setTempFloatBufferCapacity(paramBufferInfo.bufferSize / paramInt);
    paramFloatBufferInfo.bufferSize = (paramBufferInfo.bufferSize / paramInt);
    DataConversionUtil.byteArrayToFloatArray(paramBufferInfo.byteBuffer, paramBufferInfo.bufferSize, paramInt, paramFloatBufferInfo.tempFloatBuffer);
    paramFloatBufferInfo.fillFloat(paramFloatBufferInfo.tempFloatBuffer, paramFloatBufferInfo.bufferSize);
  }
  
  private static void interpolateIn16Bit(BufferInfo paramBufferInfo1, BufferInfo paramBufferInfo2, long paramLong1, long paramLong2)
  {
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
  }
  
  private static void interpolateIn24Bit(BufferInfo paramBufferInfo1, BufferInfo paramBufferInfo2, long paramLong1, long paramLong2)
  {
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
  }
  
  private static void interpolateIn32Bit(BufferInfo paramBufferInfo1, BufferInfo paramBufferInfo2, long paramLong1, long paramLong2)
  {
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
  }
  
  private static void linearInterpolate(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2, float paramFloat)
  {
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
  }
  
  private static void linearInterpolate(short[] paramArrayOfShort1, int paramInt1, short[] paramArrayOfShort2, int paramInt2, float paramFloat)
  {
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
  }
  
  public static void reSample(BufferInfo paramBufferInfo1, BufferInfo paramBufferInfo2, long paramLong1, long paramLong2, int paramInt)
  {
    checkBufferLength(paramBufferInfo1);
    if (paramBufferInfo2 == null) {
      throw new IllegalArgumentException("BufferInfo dest must not be null");
    }
    if ((paramLong1 == paramLong2) || (paramLong2 <= 0L) || (paramLong1 <= 0L))
    {
      paramBufferInfo1.copy(paramBufferInfo2);
      return;
    }
    switch (paramInt)
    {
    default: 
      paramBufferInfo1.copy(paramBufferInfo2);
      return;
    case 2: 
      interpolateIn16Bit(paramBufferInfo1, paramBufferInfo2, paramLong1, paramLong2);
      return;
    case 3: 
      interpolateIn24Bit(paramBufferInfo1, paramBufferInfo2, paramLong1, paramLong2);
      return;
    }
    interpolateIn32Bit(paramBufferInfo1, paramBufferInfo2, paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.PcmConvertionUtil
 * JD-Core Version:    0.7.0.1
 */