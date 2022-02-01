package com.tencent.mm.plugin.wepkg.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.io.InputStream;

public final class b
  extends InputStream
{
  private a QNw;
  private long size;
  
  public b(q paramq, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(177092);
    this.size = paramLong2;
    this.QNw = new a(u.al(paramq));
    TK(paramLong1);
    this.QNw.heP();
    AppMethodBeat.o(177092);
  }
  
  private long TJ(long paramLong)
  {
    AppMethodBeat.i(110779);
    paramLong = Math.min(heQ(), paramLong);
    AppMethodBeat.o(110779);
    return paramLong;
  }
  
  private void TK(long paramLong)
  {
    AppMethodBeat.i(110780);
    long l2;
    for (long l1 = 0L; l1 < paramLong; l1 += l2)
    {
      l2 = this.QNw.skip(paramLong - l1);
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
  
  private long heQ()
  {
    return this.size - this.QNw.count;
  }
  
  public final int available()
  {
    AppMethodBeat.i(110777);
    int i = (int)TJ(this.QNw.available());
    AppMethodBeat.o(110777);
    return i;
  }
  
  public final void close()
  {
    AppMethodBeat.i(110778);
    this.QNw.close();
    super.close();
    AppMethodBeat.o(110778);
  }
  
  public final int read()
  {
    AppMethodBeat.i(110773);
    if (heQ() <= 0L) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(110773);
      return -1;
    }
    i = this.QNw.read();
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
    long l = TJ(paramInt2);
    if ((l == 0L) && (paramInt2 > 0))
    {
      AppMethodBeat.o(110775);
      return -1;
    }
    paramInt1 = this.QNw.read(paramArrayOfByte, paramInt1, (int)l);
    AppMethodBeat.o(110775);
    return paramInt1;
  }
  
  public final long skip(long paramLong)
  {
    AppMethodBeat.i(110776);
    paramLong = this.QNw.skip(TJ(paramLong));
    AppMethodBeat.o(110776);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.d.b
 * JD-Core Version:    0.7.0.1
 */