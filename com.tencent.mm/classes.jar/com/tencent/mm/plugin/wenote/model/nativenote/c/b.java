package com.tencent.mm.plugin.wenote.model.nativenote.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public float deo = -1.0F;
  public float dep = -1.0F;
  public float qSd = -1.0F;
  public float qSe = -1.0F;
  public int qSf = -1;
  public float qSg = -1.0F;
  public float qSh = -1.0F;
  public float qSi = -1.0F;
  public float qSj = -1.0F;
  public int qSk = -1;
  public int qcr = 0;
  
  private boolean cDR()
  {
    return (this.qSd >= 0.0F) && (this.qSe >= 0.0F) && (this.deo >= 0.0F) && (this.dep >= 0.0F) && (this.qSf >= 0);
  }
  
  private boolean cDS()
  {
    return (this.qSg >= 0.0F) && (this.qSh >= 0.0F) && (this.qSi >= 0.0F) && (this.qSj >= 0.0F) && (this.qSk >= 0);
  }
  
  public final void a(int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt2)
  {
    this.qcr = paramInt1;
    this.qSd = paramFloat1;
    this.qSe = paramFloat2;
    this.deo = paramFloat3;
    this.dep = paramFloat4;
    if (this.qcr == 1)
    {
      this.qSf = paramInt2;
      return;
    }
    this.qSf = 0;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(30548);
    if (!cDR())
    {
      AppMethodBeat.o(30548);
      return 0;
    }
    if (!cDS())
    {
      AppMethodBeat.o(30548);
      return 1;
    }
    int i = Math.abs((int)(this.deo - this.qSi));
    int j = Math.abs((int)(this.dep - this.qSj));
    if ((i > 30) || (j > 30) || (this.qSf != this.qSk))
    {
      AppMethodBeat.o(30548);
      return 3;
    }
    AppMethodBeat.o(30548);
    return 2;
  }
  
  public final void reset()
  {
    this.qcr = 0;
    this.qSd = -1.0F;
    this.qSe = -1.0F;
    this.deo = -1.0F;
    this.dep = -1.0F;
    this.qSf = -1;
    this.qSg = -1.0F;
    this.qSh = -1.0F;
    this.qSi = -1.0F;
    this.qSj = -1.0F;
    this.qSk = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.b
 * JD-Core Version:    0.7.0.1
 */