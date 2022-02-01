package com.tencent.mm.pluginsdk.location;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public long JTu;
  public int dRt;
  public float iUY;
  public float iUZ;
  public int scene;
  
  public d(long paramLong, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.iUY = paramFloat1;
    this.iUZ = paramFloat2;
    this.dRt = paramInt1;
    this.scene = paramInt2;
    this.JTu = paramLong;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(151631);
    String str = String.format("%d-%d-%d", new Object[] { Integer.valueOf((int)(this.iUY * 1000000.0F)), Integer.valueOf((int)(this.iUZ * 1000000.0F)), Integer.valueOf(this.dRt) });
    AppMethodBeat.o(151631);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.location.d
 * JD-Core Version:    0.7.0.1
 */