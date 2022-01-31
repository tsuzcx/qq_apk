package com.tencent.mm.plugin.wepkg.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class b
  extends InputStream
{
  private long size;
  private a vGY;
  
  public b(File paramFile, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(63614);
    this.size = paramLong2;
    this.vGY = new a(new FileInputStream(paramFile));
    nu(paramLong1);
    this.vGY.dkG();
    AppMethodBeat.o(63614);
  }
  
  private long dkH()
  {
    return this.size - this.vGY.count;
  }
  
  private long nt(long paramLong)
  {
    AppMethodBeat.i(63620);
    paramLong = Math.min(dkH(), paramLong);
    AppMethodBeat.o(63620);
    return paramLong;
  }
  
  private void nu(long paramLong)
  {
    AppMethodBeat.i(63621);
    long l2;
    for (long l1 = 0L; l1 < paramLong; l1 += l2)
    {
      l2 = this.vGY.skip(paramLong - l1);
      if (l2 <= 0L) {
        break;
      }
    }
    if (l1 < paramLong)
    {
      IOException localIOException = new IOException("could not seek pos ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(63621);
      throw localIOException;
    }
    AppMethodBeat.o(63621);
  }
  
  public final int available()
  {
    AppMethodBeat.i(63619);
    int i = (int)nt(this.vGY.available());
    AppMethodBeat.o(63619);
    return i;
  }
  
  public final void close()
  {
    AppMethodBeat.i(141553);
    this.vGY.close();
    super.close();
    AppMethodBeat.o(141553);
  }
  
  public final int read()
  {
    AppMethodBeat.i(63615);
    if (dkH() <= 0L) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(63615);
      return -1;
    }
    i = this.vGY.read();
    AppMethodBeat.o(63615);
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63616);
    int i = read(paramArrayOfByte, 0, paramArrayOfByte.length);
    AppMethodBeat.o(63616);
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(63617);
    long l = nt(paramInt2);
    if ((l == 0L) && (paramInt2 > 0))
    {
      AppMethodBeat.o(63617);
      return -1;
    }
    paramInt1 = this.vGY.read(paramArrayOfByte, paramInt1, (int)l);
    AppMethodBeat.o(63617);
    return paramInt1;
  }
  
  public final long skip(long paramLong)
  {
    AppMethodBeat.i(63618);
    paramLong = this.vGY.skip(nt(paramLong));
    AppMethodBeat.o(63618);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.d.b
 * JD-Core Version:    0.7.0.1
 */