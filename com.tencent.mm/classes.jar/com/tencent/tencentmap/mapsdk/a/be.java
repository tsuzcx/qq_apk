package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.jj;
import java.util.Arrays;

public class be
{
  private int a;
  private int b;
  private int c;
  private byte[] d;
  
  public be()
  {
    AppMethodBeat.i(149820);
    this.d = new byte[4];
    AppMethodBeat.o(149820);
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149821);
    Arrays.fill(this.d, (byte)0);
    System.arraycopy(paramArrayOfByte, 0, this.d, 0, 4);
    this.a = jj.a(this.d);
    System.arraycopy(paramArrayOfByte, 4, this.d, 0, 4);
    this.b = jj.a(this.d);
    System.arraycopy(paramArrayOfByte, 8, this.d, 0, 4);
    this.c = jj.a(this.d);
    AppMethodBeat.o(149821);
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.be
 * JD-Core Version:    0.7.0.1
 */