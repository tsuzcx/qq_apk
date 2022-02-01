package com.tencent.mm.pluginsdk.location;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public int hQp;
  public long itemId;
  public float oDT;
  public float oDU;
  public int scene;
  
  public d(long paramLong, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.oDT = paramFloat1;
    this.oDU = paramFloat2;
    this.hQp = paramInt1;
    this.scene = paramInt2;
    this.itemId = paramLong;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(151631);
    String str = String.format("%d-%d-%d", new Object[] { Integer.valueOf((int)(this.oDT * 1000000.0F)), Integer.valueOf((int)(this.oDU * 1000000.0F)), Integer.valueOf(this.hQp) });
    AppMethodBeat.o(151631);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.location.d
 * JD-Core Version:    0.7.0.1
 */