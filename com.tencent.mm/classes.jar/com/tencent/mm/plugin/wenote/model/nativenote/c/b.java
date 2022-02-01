package com.tencent.mm.plugin.wenote.model.nativenote.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public float cNQ = -1.0F;
  public float cNR = -1.0F;
  public int oOD = 0;
  public float pCL = -1.0F;
  public float pCM = -1.0F;
  public int pCN = -1;
  public float pCO = -1.0F;
  public float pCP = -1.0F;
  public float pCQ = -1.0F;
  public float pCR = -1.0F;
  public int pCS = -1;
  
  private boolean cgb()
  {
    return (this.pCL >= 0.0F) && (this.pCM >= 0.0F) && (this.cNQ >= 0.0F) && (this.cNR >= 0.0F) && (this.pCN >= 0);
  }
  
  private boolean cgc()
  {
    return (this.pCO >= 0.0F) && (this.pCP >= 0.0F) && (this.pCQ >= 0.0F) && (this.pCR >= 0.0F) && (this.pCS >= 0);
  }
  
  public final void a(int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt2)
  {
    this.oOD = paramInt1;
    this.pCL = paramFloat1;
    this.pCM = paramFloat2;
    this.cNQ = paramFloat3;
    this.cNR = paramFloat4;
    if (this.oOD == 1)
    {
      this.pCN = paramInt2;
      return;
    }
    this.pCN = 0;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(30548);
    if (!cgb())
    {
      AppMethodBeat.o(30548);
      return 0;
    }
    if (!cgc())
    {
      AppMethodBeat.o(30548);
      return 1;
    }
    int i = Math.abs((int)(this.cNQ - this.pCQ));
    int j = Math.abs((int)(this.cNR - this.pCR));
    if ((i > 30) || (j > 30) || (this.pCN != this.pCS))
    {
      AppMethodBeat.o(30548);
      return 3;
    }
    AppMethodBeat.o(30548);
    return 2;
  }
  
  public final void reset()
  {
    this.oOD = 0;
    this.pCL = -1.0F;
    this.pCM = -1.0F;
    this.cNQ = -1.0F;
    this.cNR = -1.0F;
    this.pCN = -1;
    this.pCO = -1.0F;
    this.pCP = -1.0F;
    this.pCQ = -1.0F;
    this.pCR = -1.0F;
    this.pCS = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.b
 * JD-Core Version:    0.7.0.1
 */