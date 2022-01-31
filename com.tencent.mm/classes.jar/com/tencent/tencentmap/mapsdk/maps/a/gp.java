package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;

public class gp
  extends ByteArrayOutputStream
{
  private final gl a;
  
  public gp(gl paramgl, int paramInt)
  {
    AppMethodBeat.i(148015);
    this.a = paramgl;
    this.buf = this.a.a(Math.max(paramInt, 256));
    AppMethodBeat.o(148015);
  }
  
  private void a(int paramInt)
  {
    AppMethodBeat.i(148018);
    if (this.count + paramInt <= this.buf.length)
    {
      AppMethodBeat.o(148018);
      return;
    }
    byte[] arrayOfByte = this.a.a((this.count + paramInt) * 2);
    System.arraycopy(this.buf, 0, arrayOfByte, 0, this.count);
    this.a.a(this.buf);
    this.buf = arrayOfByte;
    AppMethodBeat.o(148018);
  }
  
  public void close()
  {
    AppMethodBeat.i(148016);
    this.a.a(this.buf);
    this.buf = null;
    super.close();
    AppMethodBeat.o(148016);
  }
  
  public void finalize()
  {
    AppMethodBeat.i(148017);
    this.a.a(this.buf);
    AppMethodBeat.o(148017);
  }
  
  public void write(int paramInt)
  {
    try
    {
      AppMethodBeat.i(148020);
      a(1);
      super.write(paramInt);
      AppMethodBeat.o(148020);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(148019);
      a(paramInt2);
      super.write(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(148019);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.gp
 * JD-Core Version:    0.7.0.1
 */