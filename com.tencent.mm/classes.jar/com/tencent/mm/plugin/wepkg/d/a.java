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
  
  public final int heP()
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
    AppMethodBeat.i(110770);
    int j = super.read();
    int k = this.count;
    if (j >= 0) {}
    for (int i = 1;; i = 0)
    {
      this.count = (i + k);
      AppMethodBeat.o(110770);
      return j;
    }
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(110768);
    int j = super.read(paramArrayOfByte);
    int k = this.count;
    if (j >= 0) {}
    for (int i = j;; i = 0)
    {
      this.count = (i + k);
      AppMethodBeat.o(110768);
      return j;
    }
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110769);
    paramInt2 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    int i = this.count;
    if (paramInt2 >= 0) {}
    for (paramInt1 = paramInt2;; paramInt1 = 0)
    {
      this.count = (paramInt1 + i);
      AppMethodBeat.o(110769);
      return paramInt2;
    }
  }
  
  public final long skip(long paramLong)
  {
    AppMethodBeat.i(110771);
    paramLong = super.skip(paramLong);
    this.count = ((int)(this.count + paramLong));
    AppMethodBeat.o(110771);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.d.a
 * JD-Core Version:    0.7.0.1
 */