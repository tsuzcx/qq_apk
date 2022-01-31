package com.tencent.mm.pluginsdk.location;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public int cyX;
  public float fBB;
  public float fBC;
  public long itemId;
  public int scene;
  
  public b(long paramLong, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.fBB = paramFloat1;
    this.fBC = paramFloat2;
    this.cyX = paramInt1;
    this.scene = paramInt2;
    this.itemId = paramLong;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(79210);
    String str = String.format("%d-%d-%d", new Object[] { Integer.valueOf((int)(this.fBB * 1000000.0F)), Integer.valueOf((int)(this.fBC * 1000000.0F)), Integer.valueOf(this.cyX) });
    AppMethodBeat.o(79210);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.location.b
 * JD-Core Version:    0.7.0.1
 */