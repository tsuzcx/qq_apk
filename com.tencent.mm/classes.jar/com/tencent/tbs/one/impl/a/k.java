package com.tencent.tbs.one.impl.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;

public final class k
  extends InputStream
{
  public long a = 0L;
  public a b;
  private InputStream c;
  private long d;
  private int e = 0;
  
  public k(InputStream paramInputStream, long paramLong)
  {
    this.c = paramInputStream;
    this.d = paramLong;
  }
  
  private void a()
  {
    AppMethodBeat.i(173945);
    if ((this.b != null) && (!this.b.a()))
    {
      IOException localIOException = new IOException("Aborted");
      AppMethodBeat.o(173945);
      throw localIOException;
    }
    AppMethodBeat.o(173945);
  }
  
  private void b()
  {
    AppMethodBeat.i(173955);
    if ((this.d > 0L) && (this.b != null))
    {
      int i = (int)(this.a / this.d * 100.0D);
      if (i - this.e >= 2)
      {
        this.e = i;
        this.b.a(i);
      }
    }
    AppMethodBeat.o(173955);
  }
  
  public final int available()
  {
    AppMethodBeat.i(173950);
    int i = this.c.available();
    AppMethodBeat.o(173950);
    return i;
  }
  
  public final void close()
  {
    AppMethodBeat.i(173951);
    this.c.close();
    AppMethodBeat.o(173951);
  }
  
  public final void mark(int paramInt)
  {
    try
    {
      AppMethodBeat.i(173952);
      this.c.mark(paramInt);
      AppMethodBeat.o(173952);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean markSupported()
  {
    AppMethodBeat.i(173954);
    boolean bool = this.c.markSupported();
    AppMethodBeat.o(173954);
    return bool;
  }
  
  public final int read()
  {
    AppMethodBeat.i(173946);
    a();
    int i = this.c.read();
    if (i != -1)
    {
      this.a += 1L;
      b();
    }
    AppMethodBeat.o(173946);
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(173947);
    a();
    int i = this.c.read(paramArrayOfByte);
    if (i != -1)
    {
      this.a += i;
      b();
    }
    AppMethodBeat.o(173947);
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(173948);
    a();
    paramInt1 = this.c.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 != -1)
    {
      this.a += paramInt1;
      b();
    }
    AppMethodBeat.o(173948);
    return paramInt1;
  }
  
  public final void reset()
  {
    try
    {
      AppMethodBeat.i(173953);
      this.c.reset();
      AppMethodBeat.o(173953);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long skip(long paramLong)
  {
    AppMethodBeat.i(173949);
    paramLong = this.c.skip(paramLong);
    AppMethodBeat.o(173949);
    return paramLong;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
    
    public abstract boolean a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a.k
 * JD-Core Version:    0.7.0.1
 */