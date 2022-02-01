package com.tencent.smtt.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class c
  implements Closeable
{
  private final RandomAccessFile a;
  private final File b;
  private final byte[] c;
  private boolean d;
  
  public c(File paramFile)
  {
    AppMethodBeat.i(53950);
    this.c = new byte[8];
    this.b = paramFile;
    this.a = new RandomAccessFile(this.b, "r");
    AppMethodBeat.o(53950);
  }
  
  public c(String paramString)
  {
    this(new File(paramString));
    AppMethodBeat.i(53949);
    AppMethodBeat.o(53949);
  }
  
  public final int a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(53952);
    int i = this.a.read(paramArrayOfByte);
    AppMethodBeat.o(53952);
    return i;
  }
  
  public final int a(char[] paramArrayOfChar)
  {
    AppMethodBeat.i(53953);
    byte[] arrayOfByte = new byte[paramArrayOfChar.length];
    int j = this.a.read(arrayOfByte);
    int i = 0;
    while (i < paramArrayOfChar.length)
    {
      paramArrayOfChar[i] = ((char)arrayOfByte[i]);
      i += 1;
    }
    AppMethodBeat.o(53953);
    return j;
  }
  
  public final short a()
  {
    AppMethodBeat.i(53954);
    int i = this.a.readShort();
    if (this.d)
    {
      i = (short)((i & 0xFF00) >>> 8 | (i & 0xFF) << 8);
      AppMethodBeat.o(53954);
      return i;
    }
    AppMethodBeat.o(53954);
    return i;
  }
  
  public void a(long paramLong)
  {
    AppMethodBeat.i(53951);
    this.a.seek(paramLong);
    AppMethodBeat.o(53951);
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public final int b()
  {
    AppMethodBeat.i(53955);
    int i = this.a.readInt();
    if (this.d)
    {
      AppMethodBeat.o(53955);
      return (i & 0xFF000000) >>> 24 | (i & 0xFF) << 24 | (0xFF00 & i) << 8 | (0xFF0000 & i) >>> 8;
    }
    AppMethodBeat.o(53955);
    return i;
  }
  
  public final long c()
  {
    AppMethodBeat.i(53956);
    if (this.d)
    {
      this.a.readFully(this.c, 0, 8);
      l1 = this.c[7];
      long l2 = this.c[6] & 0xFF;
      long l3 = this.c[5] & 0xFF;
      long l4 = this.c[4] & 0xFF;
      long l5 = this.c[3] & 0xFF;
      long l6 = this.c[2] & 0xFF;
      long l7 = this.c[1] & 0xFF;
      long l8 = this.c[0] & 0xFF;
      AppMethodBeat.o(53956);
      return l1 << 56 | l2 << 48 | l3 << 40 | l4 << 32 | l5 << 24 | l6 << 16 | l7 << 8 | l8;
    }
    long l1 = this.a.readLong();
    AppMethodBeat.o(53956);
    return l1;
  }
  
  public void close()
  {
    AppMethodBeat.i(53957);
    try
    {
      this.a.close();
      AppMethodBeat.o(53957);
      return;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(53957);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.utils.c
 * JD-Core Version:    0.7.0.1
 */