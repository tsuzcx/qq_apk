package com.tencent.mm.plugin.wepkg.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.InputStream;

public final class b
  extends InputStream
{
  private a JOd;
  private long size;
  
  public b(o paramo, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(177092);
    this.size = paramLong2;
    this.JOd = new a(s.ao(paramo));
    Mk(paramLong1);
    this.JOd.gkW();
    AppMethodBeat.o(177092);
  }
  
  private long Mj(long paramLong)
  {
    AppMethodBeat.i(110779);
    paramLong = Math.min(gkX(), paramLong);
    AppMethodBeat.o(110779);
    return paramLong;
  }
  
  private void Mk(long paramLong)
  {
    AppMethodBeat.i(110780);
    long l2;
    for (long l1 = 0L; l1 < paramLong; l1 += l2)
    {
      l2 = this.JOd.skip(paramLong - l1);
      if (l2 <= 0L) {
        break;
      }
    }
    if (l1 < paramLong)
    {
      IOException localIOException = new IOException("could not seek pos ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(110780);
      throw localIOException;
    }
    AppMethodBeat.o(110780);
  }
  
  private long gkX()
  {
    return this.size - this.JOd.count;
  }
  
  public final int available()
  {
    AppMethodBeat.i(110777);
    int i = (int)Mj(this.JOd.available());
    AppMethodBeat.o(110777);
    return i;
  }
  
  public final void close()
  {
    AppMethodBeat.i(110778);
    this.JOd.close();
    super.close();
    AppMethodBeat.o(110778);
  }
  
  public final int read()
  {
    AppMethodBeat.i(110773);
    if (gkX() <= 0L) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(110773);
      return -1;
    }
    i = this.JOd.read();
    AppMethodBeat.o(110773);
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(110774);
    int i = read(paramArrayOfByte, 0, paramArrayOfByte.length);
    AppMethodBeat.o(110774);
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110775);
    long l = Mj(paramInt2);
    if ((l == 0L) && (paramInt2 > 0))
    {
      AppMethodBeat.o(110775);
      return -1;
    }
    paramInt1 = this.JOd.read(paramArrayOfByte, paramInt1, (int)l);
    AppMethodBeat.o(110775);
    return paramInt1;
  }
  
  public final long skip(long paramLong)
  {
    AppMethodBeat.i(110776);
    paramLong = this.JOd.skip(Mj(paramLong));
    AppMethodBeat.o(110776);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.d.b
 * JD-Core Version:    0.7.0.1
 */