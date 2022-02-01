package com.tencent.mm.pluginsdk.location;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public long EKe;
  public int dyB;
  public float hXj;
  public float hXk;
  public int scene;
  
  public c(long paramLong, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.hXj = paramFloat1;
    this.hXk = paramFloat2;
    this.dyB = paramInt1;
    this.scene = paramInt2;
    this.EKe = paramLong;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(151631);
    String str = String.format("%d-%d-%d", new Object[] { Integer.valueOf((int)(this.hXj * 1000000.0F)), Integer.valueOf((int)(this.hXk * 1000000.0F)), Integer.valueOf(this.dyB) });
    AppMethodBeat.o(151631);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.location.c
 * JD-Core Version:    0.7.0.1
 */