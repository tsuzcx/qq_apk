package com.tencent.mm.pluginsdk.location;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public long QSA;
  public int fKJ;
  public float lLr;
  public float lLs;
  public int scene;
  
  public d(long paramLong, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.lLr = paramFloat1;
    this.lLs = paramFloat2;
    this.fKJ = paramInt1;
    this.scene = paramInt2;
    this.QSA = paramLong;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(151631);
    String str = String.format("%d-%d-%d", new Object[] { Integer.valueOf((int)(this.lLr * 1000000.0F)), Integer.valueOf((int)(this.lLs * 1000000.0F)), Integer.valueOf(this.fKJ) });
    AppMethodBeat.o(151631);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.location.d
 * JD-Core Version:    0.7.0.1
 */