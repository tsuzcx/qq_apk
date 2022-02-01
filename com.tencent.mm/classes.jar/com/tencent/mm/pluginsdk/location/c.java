package com.tencent.mm.pluginsdk.location;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public long FcC;
  public int dzG;
  public float iab;
  public float iac;
  public int scene;
  
  public c(long paramLong, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.iab = paramFloat1;
    this.iac = paramFloat2;
    this.dzG = paramInt1;
    this.scene = paramInt2;
    this.FcC = paramLong;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(151631);
    String str = String.format("%d-%d-%d", new Object[] { Integer.valueOf((int)(this.iab * 1000000.0F)), Integer.valueOf((int)(this.iac * 1000000.0F)), Integer.valueOf(this.dzG) });
    AppMethodBeat.o(151631);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.location.c
 * JD-Core Version:    0.7.0.1
 */