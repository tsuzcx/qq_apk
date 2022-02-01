package com.tencent.qqmusic.mediaplayer.seektable;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(114219);
    this.dataSource = paramIDataSource;
    this.intBuffer = new byte[4];
    this.longBuffer = new byte[8];
    this.position = 0L;
    AppMethodBeat.o(114219);
  }
  
  public long available()
  {
    AppMethodBeat.i(114228);
    long l1 = this.dataSource.getSize();
    long l2 = this.position;
    AppMethodBeat.o(114228);
    return l1 - l2;
  }
  
  public void close()
  {
    AppMethodBeat.i(114230);
    this.dataSource.close();
    AppMethodBeat.o(114230);
  }
  
  public void readBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114226);
    long l = this.position;
    this.position = (this.dataSource.readAt(this.position, paramArrayOfByte, paramInt1, paramInt2) + l);
    AppMethodBeat.o(114226);
  }
  
  public int readInt()
  {
    AppMethodBeat.i(114220);
    int i = this.dataSource.readAt(this.position, this.intBuffer, 0, this.intBuffer.length);
    this.position += i;
    if (i != this.intBuffer.length)
    {
      AppMethodBeat.o(114220);
      return -1;
    }
    i = this.intBuffer[0];
    int j = this.intBuffer[1];
    int k = this.intBuffer[2];
    int m = this.intBuffer[3];
    AppMethodBeat.o(114220);
    return (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8 | m & 0xFF;
  }
  
  public int[] readIntArray(int paramInt)
  {
    AppMethodBeat.i(114222);
    int[] arrayOfInt = new int[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfInt[i] = readInt();
      i += 1;
    }
    AppMethodBeat.o(114222);
    return arrayOfInt;
  }
  
  public void readIntArrayInterleaved(int paramInt, int[]... paramVarArgs)
  {
    AppMethodBeat.i(114224);
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
    AppMethodBeat.o(114224);
  }
  
  public long readLong()
  {
    AppMethodBeat.i(114221);
    int i = this.dataSource.readAt(this.position, this.longBuffer, 0, this.longBuffer.length);
    this.position += i;
    if (i != this.longBuffer.length)
    {
      AppMethodBeat.o(114221);
      return -1L;
    }
    long l1 = this.longBuffer[0];
    long l2 = this.longBuffer[1];
    long l3 = this.longBuffer[2];
    long l4 = this.longBuffer[3];
    long l5 = this.longBuffer[4];
    long l6 = this.longBuffer[5];
    long l7 = this.longBuffer[6];
    long l8 = this.longBuffer[7];
    AppMethodBeat.o(114221);
    return (l1 & 0xFF) << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l4 & 0xFF) << 32 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8 | l8 & 0xFF;
  }
  
  public long[] readLongArray(int paramInt)
  {
    AppMethodBeat.i(114223);
    long[] arrayOfLong = new long[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfLong[i] = readLong();
      i += 1;
    }
    AppMethodBeat.o(114223);
    return arrayOfLong;
  }
  
  public void readLongArrayInterleaved(int paramInt, long[]... paramVarArgs)
  {
    AppMethodBeat.i(114225);
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
    AppMethodBeat.o(114225);
  }
  
  public String readString(int paramInt)
  {
    AppMethodBeat.i(114227);
    Object localObject = new byte[paramInt];
    readBytes((byte[])localObject, 0, paramInt);
    localObject = new String((byte[])localObject, Charset.defaultCharset());
    AppMethodBeat.o(114227);
    return localObject;
  }
  
  public long skip(long paramLong)
  {
    AppMethodBeat.i(114229);
    long l = available();
    if (l > paramLong) {
      this.position += paramLong;
    }
    for (;;)
    {
      AppMethodBeat.o(114229);
      return paramLong;
      this.position += l;
      paramLong = l;
    }
  }
  
  public long tell()
  {
    return this.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.ParsableInputStreamWrapper
 * JD-Core Version:    0.7.0.1
 */