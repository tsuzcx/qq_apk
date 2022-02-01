package com.tencent.tbs.one.impl.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.impl.a.c;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;

public final class a
  implements Closeable
{
  boolean a;
  private final RandomAccessFile b;
  private final File c;
  private final byte[] d;
  
  public a(File paramFile)
  {
    AppMethodBeat.i(173819);
    this.d = new byte[8];
    this.c = paramFile;
    this.b = new RandomAccessFile(this.c, "r");
    AppMethodBeat.o(173819);
  }
  
  public final int a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(173821);
    int i = this.b.read(paramArrayOfByte);
    AppMethodBeat.o(173821);
    return i;
  }
  
  public final int a(char[] paramArrayOfChar)
  {
    AppMethodBeat.i(173822);
    byte[] arrayOfByte = new byte[paramArrayOfChar.length];
    int j = this.b.read(arrayOfByte);
    int i = 0;
    while (i < paramArrayOfChar.length)
    {
      paramArrayOfChar[i] = ((char)arrayOfByte[i]);
      i += 1;
    }
    AppMethodBeat.o(173822);
    return j;
  }
  
  public final short a()
  {
    AppMethodBeat.i(173823);
    int i = this.b.readShort();
    if (this.a)
    {
      i = (short)((i & 0xFF00) >>> 8 | (i & 0xFF) << 8);
      AppMethodBeat.o(173823);
      return i;
    }
    AppMethodBeat.o(173823);
    return i;
  }
  
  public final void a(long paramLong)
  {
    AppMethodBeat.i(173820);
    this.b.seek(paramLong);
    AppMethodBeat.o(173820);
  }
  
  public final int b()
  {
    AppMethodBeat.i(173824);
    int i = this.b.readInt();
    if (this.a)
    {
      AppMethodBeat.o(173824);
      return (i & 0xFF000000) >>> 24 | (i & 0xFF) << 24 | (0xFF00 & i) << 8 | (0xFF0000 & i) >>> 8;
    }
    AppMethodBeat.o(173824);
    return i;
  }
  
  public final long c()
  {
    AppMethodBeat.i(173825);
    if (this.a)
    {
      this.b.readFully(this.d, 0, 8);
      l1 = this.d[7];
      long l2 = this.d[6] & 0xFF;
      long l3 = this.d[5] & 0xFF;
      long l4 = this.d[4] & 0xFF;
      long l5 = this.d[3] & 0xFF;
      long l6 = this.d[2] & 0xFF;
      long l7 = this.d[1] & 0xFF;
      long l8 = this.d[0] & 0xFF;
      AppMethodBeat.o(173825);
      return l1 << 56 | l2 << 48 | l3 << 40 | l4 << 32 | l5 << 24 | l6 << 16 | l7 << 8 | l8;
    }
    long l1 = this.b.readLong();
    AppMethodBeat.o(173825);
    return l1;
  }
  
  public final void close()
  {
    AppMethodBeat.i(173826);
    c.a(this.b);
    AppMethodBeat.o(173826);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.one.impl.c.a.a
 * JD-Core Version:    0.7.0.1
 */