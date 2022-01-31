package com.tencent.qqmusic.mediaplayer.seektable;

import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.io.Closeable;
import java.nio.charset.Charset;

public class ParsableInputStreamWrapper
  implements Parsable, Closeable
{
  private final IDataSource dataSource;
  private final byte[] intBuffer;
  private final byte[] longBuffer;
  private long position;
  
  public ParsableInputStreamWrapper(IDataSource paramIDataSource)
  {
    this.dataSource = paramIDataSource;
    this.intBuffer = new byte[4];
    this.longBuffer = new byte[8];
    this.position = 0L;
  }
  
  public long available()
  {
    return this.dataSource.getSize() - this.position;
  }
  
  public void close()
  {
    this.dataSource.close();
  }
  
  public void readBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l = this.position;
    this.position = (this.dataSource.readAt(this.position, paramArrayOfByte, paramInt1, paramInt2) + l);
  }
  
  public int readInt()
  {
    int i = this.dataSource.readAt(this.position, this.intBuffer, 0, this.intBuffer.length);
    this.position += i;
    if (i != this.intBuffer.length) {
      return -1;
    }
    return (this.intBuffer[0] & 0xFF) << 24 | (this.intBuffer[1] & 0xFF) << 16 | (this.intBuffer[2] & 0xFF) << 8 | this.intBuffer[3] & 0xFF;
  }
  
  public int[] readIntArray(int paramInt)
  {
    int[] arrayOfInt = new int[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfInt[i] = readInt();
      i += 1;
    }
    return arrayOfInt;
  }
  
  public void readIntArrayInterleaved(int paramInt, int[]... paramVarArgs)
  {
    int i = 0;
    while (i < paramInt)
    {
      int k = paramVarArgs.length;
      int j = 0;
      while (j < k)
      {
        paramVarArgs[j][i] = readInt();
        j += 1;
      }
      i += 1;
    }
  }
  
  public long readLong()
  {
    int i = this.dataSource.readAt(this.position, this.longBuffer, 0, this.longBuffer.length);
    this.position += i;
    if (i != this.longBuffer.length) {
      return -1L;
    }
    return (this.longBuffer[0] & 0xFF) << 56 | (this.longBuffer[1] & 0xFF) << 48 | (this.longBuffer[2] & 0xFF) << 40 | (this.longBuffer[3] & 0xFF) << 32 | (this.longBuffer[4] & 0xFF) << 24 | (this.longBuffer[5] & 0xFF) << 16 | (this.longBuffer[6] & 0xFF) << 8 | this.longBuffer[7] & 0xFF;
  }
  
  public long[] readLongArray(int paramInt)
  {
    long[] arrayOfLong = new long[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfLong[i] = readLong();
      i += 1;
    }
    return arrayOfLong;
  }
  
  public void readLongArrayInterleaved(int paramInt, long[]... paramVarArgs)
  {
    int i = 0;
    while (i < paramInt)
    {
      int k = paramVarArgs.length;
      int j = 0;
      while (j < k)
      {
        paramVarArgs[j][i] = readLong();
        j += 1;
      }
      i += 1;
    }
  }
  
  public String readString(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    readBytes(arrayOfByte, 0, paramInt);
    return new String(arrayOfByte, Charset.defaultCharset());
  }
  
  public long skip(long paramLong)
  {
    long l = available();
    if (l > paramLong)
    {
      this.position += paramLong;
      return paramLong;
    }
    this.position += l;
    return l;
  }
  
  public long tell()
  {
    return this.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.ParsableInputStreamWrapper
 * JD-Core Version:    0.7.0.1
 */