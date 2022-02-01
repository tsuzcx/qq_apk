package com.tencent.mm.pluginsdk.location;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public long Dgi;
  public int dmN;
  public float hEE;
  public float hEF;
  public int scene;
  
  public c(long paramLong, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.hEE = paramFloat1;
    this.hEF = paramFloat2;
    this.dmN = paramInt1;
    this.scene = paramInt2;
    this.Dgi = paramLong;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(151631);
    String str = String.format("%d-%d-%d", new Object[] { Integer.valueOf((int)(this.hEE * 1000000.0F)), Integer.valueOf((int)(this.hEF * 1000000.0F)), Integer.valueOf(this.dmN) });
    AppMethodBeat.o(151631);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.location.c
 * JD-Core Version:    0.7.0.1
 */