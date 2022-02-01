package com.tencent.tbs.one.impl.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;

public final class h
  extends OutputStream
{
  private OutputStream[] a;
  
  public h(OutputStream[] paramArrayOfOutputStream)
  {
    this.a = paramArrayOfOutputStream;
  }
  
  public final void close()
  {
    AppMethodBeat.i(173930);
    OutputStream[] arrayOfOutputStream = this.a;
    int j = arrayOfOutputStream.length;
    int i = 0;
    while (i < j)
    {
      arrayOfOutputStream[i].close();
      i += 1;
    }
    AppMethodBeat.o(173930);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(173929);
    OutputStream[] arrayOfOutputStream = this.a;
    int j = arrayOfOutputStream.length;
    int i = 0;
    while (i < j)
    {
      arrayOfOutputStream[i].flush();
      i += 1;
    }
    AppMethodBeat.o(173929);
  }
  
  public final void write(int paramInt)
  {
    AppMethodBeat.i(173926);
    OutputStream[] arrayOfOutputStream = this.a;
    int j = arrayOfOutputStream.length;
    int i = 0;
    while (i < j)
    {
      arrayOfOutputStream[i].write(paramInt);
      i += 1;
    }
    AppMethodBeat.o(173926);
  }
  
  public final void write(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(173927);
    OutputStream[] arrayOfOutputStream = this.a;
    int j = arrayOfOutputStream.length;
    int i = 0;
    while (i < j)
    {
      arrayOfOutputStream[i].write(paramArrayOfByte);
      i += 1;
    }
    AppMethodBeat.o(173927);
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(173928);
    OutputStream[] arrayOfOutputStream = this.a;
    int j = arrayOfOutputStream.length;
    int i = 0;
    while (i < j)
    {
      arrayOfOutputStream[i].write(paramArrayOfByte, paramInt1, paramInt2);
      i += 1;
    }
    AppMethodBeat.o(173928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a.h
 * JD-Core Version:    0.7.0.1
 */