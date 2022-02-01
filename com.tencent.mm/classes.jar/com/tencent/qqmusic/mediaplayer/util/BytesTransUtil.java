package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.nio.ByteOrder;

public class BytesTransUtil
{
  private static BytesTransUtil instance = null;
  private String TAG = "BytesTransUtil";
  
  public static BytesTransUtil getInstance()
  {
    AppMethodBeat.i(87728);
    if (instance == null) {
      instance = new BytesTransUtil();
    }
    BytesTransUtil localBytesTransUtil = instance;
    AppMethodBeat.o(87728);
    return localBytesTransUtil;
  }
  
  public int[] Bytes2Ints(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(87743);
    int[] arrayOfInt = new int[paramArrayOfByte.length / 4];
    int i = 0;
    while (i < arrayOfInt.length)
    {
      byte[] arrayOfByte = new byte[4];
      int j = 0;
      while (j < 4)
      {
        arrayOfByte[j] = paramArrayOfByte[(i * 4 + j)];
        j += 1;
      }
      arrayOfInt[i] = getInt(arrayOfByte);
      System.out.println("2out->" + arrayOfInt[i]);
      i += 1;
    }
    AppMethodBeat.o(87743);
    return arrayOfInt;
  }
  
  public long[] Bytes2Longs(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(87745);
    long[] arrayOfLong = new long[paramArrayOfByte.length / 8];
    int i = 0;
    while (i < arrayOfLong.length)
    {
      byte[] arrayOfByte = new byte[8];
      int j = 0;
      while (j < 8)
      {
        arrayOfByte[j] = paramArrayOfByte[(i * 8 + j)];
        j += 1;
      }
      arrayOfLong[i] = getLong(arrayOfByte);
      i += 1;
    }
    AppMethodBeat.o(87745);
    return arrayOfLong;
  }
  
  public short[] Bytes2Shorts(short[] paramArrayOfShort, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(87740);
    byte[] arrayOfByte = new byte[2];
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      System.arraycopy(paramArrayOfByte, i * 2, arrayOfByte, 0, 2);
      paramArrayOfShort[i] = getShort(arrayOfByte);
      i += 1;
    }
    AppMethodBeat.o(87740);
    return paramArrayOfShort;
  }
  
  public byte[] Ints2Bytes(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(87744);
    byte[] arrayOfByte1 = new byte[paramArrayOfInt.length * 4];
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      byte[] arrayOfByte2 = getBytes(paramArrayOfInt[i]);
      System.out.println("1out->" + paramArrayOfInt[i]);
      int j = 0;
      while (j < 4)
      {
        arrayOfByte1[(i * 4 + j)] = arrayOfByte2[j];
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(87744);
    return arrayOfByte1;
  }
  
  public byte[] Longs2Bytes(long[] paramArrayOfLong)
  {
    AppMethodBeat.i(87746);
    byte[] arrayOfByte1 = new byte[paramArrayOfLong.length * 8];
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      byte[] arrayOfByte2 = getBytes(paramArrayOfLong[i]);
      int j = 0;
      while (j < 8)
      {
        arrayOfByte1[(i * 8 + j)] = arrayOfByte2[j];
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(87746);
    return arrayOfByte1;
  }
  
  public void Shorts2Bytes(short[] paramArrayOfShort, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(87742);
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      System.arraycopy(getBytes(paramArrayOfShort[i]), 0, paramArrayOfByte, i * 2, 2);
      i += 1;
    }
    AppMethodBeat.o(87742);
  }
  
  public byte[] Shorts2Bytes(short[] paramArrayOfShort)
  {
    AppMethodBeat.i(87741);
    byte[] arrayOfByte = new byte[paramArrayOfShort.length * 2];
    Shorts2Bytes(paramArrayOfShort, arrayOfByte);
    AppMethodBeat.o(87741);
    return arrayOfByte;
  }
  
  public byte[] getBytes(int paramInt)
  {
    AppMethodBeat.i(87734);
    byte[] arrayOfByte = getBytes(paramInt, testCPU());
    AppMethodBeat.o(87734);
    return arrayOfByte;
  }
  
  public byte[] getBytes(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(87730);
    byte[] arrayOfByte = new byte[4];
    if (paramBoolean)
    {
      j = 3;
      i = paramInt;
      paramInt = j;
      while (paramInt >= 0)
      {
        arrayOfByte[paramInt] = ((byte)(i & 0xFF));
        i >>= 8;
        paramInt -= 1;
      }
    }
    System.out.println("1");
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < 4)
    {
      arrayOfByte[paramInt] = ((byte)(i & 0xFF));
      i >>= 8;
      paramInt += 1;
    }
    AppMethodBeat.o(87730);
    return arrayOfByte;
  }
  
  public byte[] getBytes(long paramLong)
  {
    AppMethodBeat.i(87736);
    byte[] arrayOfByte = getBytes(paramLong, testCPU());
    AppMethodBeat.o(87736);
    return arrayOfByte;
  }
  
  public byte[] getBytes(long paramLong, boolean paramBoolean)
  {
    byte[] arrayOfByte = new byte[8];
    if (paramBoolean)
    {
      i = 7;
      while (i >= 0)
      {
        arrayOfByte[i] = ((byte)(int)(paramLong & 0xFF));
        paramLong >>= 8;
        i -= 1;
      }
    }
    int i = 0;
    while (i < 8)
    {
      arrayOfByte[i] = ((byte)(int)(paramLong & 0xFF));
      paramLong >>= 8;
      i += 1;
    }
    return arrayOfByte;
  }
  
  public byte[] getBytes(short paramShort)
  {
    AppMethodBeat.i(87735);
    byte[] arrayOfByte = getBytes(paramShort, testCPU());
    AppMethodBeat.o(87735);
    return arrayOfByte;
  }
  
  public byte[] getBytes(short paramShort, boolean paramBoolean)
  {
    byte[] arrayOfByte = new byte[2];
    if (paramBoolean)
    {
      s = 1;
      i = paramShort;
      paramShort = s;
      while (paramShort >= 0)
      {
        arrayOfByte[paramShort] = ((byte)(i & 0xFF));
        i = (short)(i >> 8);
        paramShort -= 1;
      }
    }
    short s = 0;
    int i = paramShort;
    paramShort = s;
    while (paramShort < 2)
    {
      arrayOfByte[paramShort] = ((byte)(i & 0xFF));
      i = (short)(i >> 8);
      paramShort += 1;
    }
    return arrayOfByte;
  }
  
  public int getInt(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(87737);
    int i = getInt(paramArrayOfByte, testCPU());
    AppMethodBeat.o(87737);
    return i;
  }
  
  public int getInt(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(87732);
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new IllegalArgumentException("byte array is null!");
      AppMethodBeat.o(87732);
      throw paramArrayOfByte;
    }
    if (paramArrayOfByte.length > 4)
    {
      paramArrayOfByte = new IllegalArgumentException("byte array size > 4 !");
      AppMethodBeat.o(87732);
      throw paramArrayOfByte;
    }
    int k;
    if (paramBoolean)
    {
      i = 0;
      j = 0;
      for (;;)
      {
        k = i;
        if (j >= paramArrayOfByte.length) {
          break;
        }
        i = i << 8 | paramArrayOfByte[j] & 0xFF;
        j += 1;
      }
    }
    int j = paramArrayOfByte.length - 1;
    int i = 0;
    for (;;)
    {
      k = i;
      if (j < 0) {
        break;
      }
      i = i << 8 | paramArrayOfByte[j] & 0xFF;
      j -= 1;
    }
    AppMethodBeat.o(87732);
    return k;
  }
  
  public long getLong(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(87739);
    long l = getLong(paramArrayOfByte, testCPU());
    AppMethodBeat.o(87739);
    return l;
  }
  
  public long getLong(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(87733);
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new IllegalArgumentException("byte array is null!");
      AppMethodBeat.o(87733);
      throw paramArrayOfByte;
    }
    if (paramArrayOfByte.length > 8)
    {
      paramArrayOfByte = new IllegalArgumentException("byte array size > 8 !");
      AppMethodBeat.o(87733);
      throw paramArrayOfByte;
    }
    long l1 = 0L;
    long l2;
    if (paramBoolean)
    {
      i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= paramArrayOfByte.length) {
          break;
        }
        l1 = l1 << 8 | paramArrayOfByte[i] & 0xFF;
        i += 1;
      }
    }
    int i = paramArrayOfByte.length - 1;
    for (;;)
    {
      l2 = l1;
      if (i < 0) {
        break;
      }
      l1 = l1 << 8 | paramArrayOfByte[i] & 0xFF;
      i -= 1;
    }
    AppMethodBeat.o(87733);
    return l2;
  }
  
  public short getShort(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(87738);
    short s = getShort(paramArrayOfByte, testCPU());
    AppMethodBeat.o(87738);
    return s;
  }
  
  public short getShort(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(87731);
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new IllegalArgumentException("byte array is null!");
      AppMethodBeat.o(87731);
      throw paramArrayOfByte;
    }
    if (paramArrayOfByte.length > 2)
    {
      paramArrayOfByte = new IllegalArgumentException("byte array size > 2 !");
      AppMethodBeat.o(87731);
      throw paramArrayOfByte;
    }
    short s2;
    if (paramBoolean)
    {
      s1 = 0;
      i = 0;
      for (;;)
      {
        s2 = s1;
        if (i >= paramArrayOfByte.length) {
          break;
        }
        s1 = (short)((short)(s1 << 8) | paramArrayOfByte[i] & 0xFF);
        i += 1;
      }
    }
    int i = paramArrayOfByte.length - 1;
    short s1 = 0;
    for (;;)
    {
      s2 = s1;
      if (i < 0) {
        break;
      }
      s1 = (short)((short)(s1 << 8) | paramArrayOfByte[i] & 0xFF);
      i -= 1;
    }
    AppMethodBeat.o(87731);
    return s2;
  }
  
  public boolean testCPU()
  {
    AppMethodBeat.i(87729);
    if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN)
    {
      AppMethodBeat.o(87729);
      return true;
    }
    AppMethodBeat.o(87729);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.BytesTransUtil
 * JD-Core Version:    0.7.0.1
 */