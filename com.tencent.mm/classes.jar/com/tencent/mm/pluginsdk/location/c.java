package com.tencent.mm.pluginsdk.location;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public long BNU;
  public int dpd;
  public float heb;
  public float hec;
  public int scene;
  
  public c(long paramLong, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.heb = paramFloat1;
    this.hec = paramFloat2;
    this.dpd = paramInt1;
    this.scene = paramInt2;
    this.BNU = paramLong;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(151631);
    String str = String.format("%d-%d-%d", new Object[] { Integer.valueOf((int)(this.heb * 1000000.0F)), Integer.valueOf((int)(this.hec * 1000000.0F)), Integer.valueOf(this.dpd) });
    AppMethodBeat.o(151631);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.location.c
 * JD-Core Version:    0.7.0.1
 */