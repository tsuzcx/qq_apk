package com.tencent.mm.plugin.wenote.model.nativenote.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public float fif = -1.0F;
  public float fig = -1.0F;
  public int viewType = 0;
  public float xAG = -1.0F;
  public float xAH = -1.0F;
  public int xAI = -1;
  public float xAJ = -1.0F;
  public float xAK = -1.0F;
  public float xAL = -1.0F;
  public float xAM = -1.0F;
  public int xAN = -1;
  
  private boolean dwO()
  {
    return (this.xAG >= 0.0F) && (this.xAH >= 0.0F) && (this.fif >= 0.0F) && (this.fig >= 0.0F) && (this.xAI >= 0);
  }
  
  private boolean dwP()
  {
    return (this.xAJ >= 0.0F) && (this.xAK >= 0.0F) && (this.xAL >= 0.0F) && (this.xAM >= 0.0F) && (this.xAN >= 0);
  }
  
  public final void a(int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt2)
  {
    this.viewType = paramInt1;
    this.xAG = paramFloat1;
    this.xAH = paramFloat2;
    this.fif = paramFloat3;
    this.fig = paramFloat4;
    if (this.viewType == 1)
    {
      this.xAI = paramInt2;
      return;
    }
    this.xAI = 0;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(30548);
    if (!dwO())
    {
      AppMethodBeat.o(30548);
      return 0;
    }
    if (!dwP())
    {
      AppMethodBeat.o(30548);
      return 1;
    }
    int i = Math.abs((int)(this.fif - this.xAL));
    int j = Math.abs((int)(this.fig - this.xAM));
    if ((i > 30) || (j > 30) || (this.xAI != this.xAN))
    {
      AppMethodBeat.o(30548);
      return 3;
    }
    AppMethodBeat.o(30548);
    return 2;
  }
  
  public final void reset()
  {
    this.viewType = 0;
    this.xAG = -1.0F;
    this.xAH = -1.0F;
    this.fif = -1.0F;
    this.fig = -1.0F;
    this.xAI = -1;
    this.xAJ = -1.0F;
    this.xAK = -1.0F;
    this.xAL = -1.0F;
    this.xAM = -1.0F;
    this.xAN = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.b
 * JD-Core Version:    0.7.0.1
 */