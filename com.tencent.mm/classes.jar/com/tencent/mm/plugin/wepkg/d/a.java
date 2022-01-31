package com.tencent.mm.plugin.wepkg.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class a
  extends c
{
  int count;
  
  public a(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public final int dkG()
  {
    try
    {
      int i = this.count;
      this.count = 0;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int read()
  {
    AppMethodBeat.i(63612);
    int j = super.read();
    int k = this.count;
    if (j >= 0) {}
    for (int i = 1;; i = 0)
    {
      this.count = (i + k);
      AppMethodBeat.o(63612);
      return j;
    }
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63610);
    int j = super.read(paramArrayOfByte);
    int k = this.count;
    if (j >= 0) {}
    for (int i = j;; i = 0)
    {
      this.count = (i + k);
      AppMethodBeat.o(63610);
      return j;
    }
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(63611);
    paramInt2 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    int i = this.count;
    if (paramInt2 >= 0) {}
    for (paramInt1 = paramInt2;; paramInt1 = 0)
    {
      this.count = (paramInt1 + i);
      AppMethodBeat.o(63611);
      return paramInt2;
    }
  }
  
  public final long skip(long paramLong)
  {
    AppMethodBeat.i(63613);
    paramLong = super.skip(paramLong);
    this.count = ((int)(this.count + paramLong));
    AppMethodBeat.o(63613);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.d.a
 * JD-Core Version:    0.7.0.1
 */