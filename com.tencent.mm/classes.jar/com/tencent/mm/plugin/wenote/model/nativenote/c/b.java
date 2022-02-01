package com.tencent.mm.plugin.wenote.model.nativenote.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public float cCh = -1.0F;
  public float cCi = -1.0F;
  public float oSA = -1.0F;
  public float oSB = -1.0F;
  public float oSC = -1.0F;
  public float oSD = -1.0F;
  public int oSE = -1;
  public float oSx = -1.0F;
  public float oSy = -1.0F;
  public int oSz = -1;
  public int oeH = 0;
  
  private boolean cai()
  {
    return (this.oSx >= 0.0F) && (this.oSy >= 0.0F) && (this.cCh >= 0.0F) && (this.cCi >= 0.0F) && (this.oSz >= 0);
  }
  
  private boolean caj()
  {
    return (this.oSA >= 0.0F) && (this.oSB >= 0.0F) && (this.oSC >= 0.0F) && (this.oSD >= 0.0F) && (this.oSE >= 0);
  }
  
  public final void a(int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt2)
  {
    this.oeH = paramInt1;
    this.oSx = paramFloat1;
    this.oSy = paramFloat2;
    this.cCh = paramFloat3;
    this.cCi = paramFloat4;
    if (this.oeH == 1)
    {
      this.oSz = paramInt2;
      return;
    }
    this.oSz = 0;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(30548);
    if (!cai())
    {
      AppMethodBeat.o(30548);
      return 0;
    }
    if (!caj())
    {
      AppMethodBeat.o(30548);
      return 1;
    }
    int i = Math.abs((int)(this.cCh - this.oSC));
    int j = Math.abs((int)(this.cCi - this.oSD));
    if ((i > 30) || (j > 30) || (this.oSz != this.oSE))
    {
      AppMethodBeat.o(30548);
      return 3;
    }
    AppMethodBeat.o(30548);
    return 2;
  }
  
  public final void reset()
  {
    this.oeH = 0;
    this.oSx = -1.0F;
    this.oSy = -1.0F;
    this.cCh = -1.0F;
    this.cCi = -1.0F;
    this.oSz = -1;
    this.oSA = -1.0F;
    this.oSB = -1.0F;
    this.oSC = -1.0F;
    this.oSD = -1.0F;
    this.oSE = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.b
 * JD-Core Version:    0.7.0.1
 */