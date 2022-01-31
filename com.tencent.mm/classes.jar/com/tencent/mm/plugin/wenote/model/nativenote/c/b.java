package com.tencent.mm.plugin.wenote.model.nativenote.c;

public final class b
{
  public float fSy = -1.0F;
  public float fSz = -1.0F;
  public int ivk = 0;
  public int rJA = -1;
  public float rJt = -1.0F;
  public float rJu = -1.0F;
  public int rJv = -1;
  public float rJw = -1.0F;
  public float rJx = -1.0F;
  public float rJy = -1.0F;
  public float rJz = -1.0F;
  
  public final void a(int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt2)
  {
    this.ivk = paramInt1;
    this.rJt = paramFloat1;
    this.rJu = paramFloat2;
    this.fSy = paramFloat3;
    this.fSz = paramFloat4;
    if (this.ivk == 1)
    {
      this.rJv = paramInt2;
      return;
    }
    this.rJv = 0;
  }
  
  public final int getType()
  {
    int j = 0;
    if ((this.rJt >= 0.0F) && (this.rJu >= 0.0F) && (this.fSy >= 0.0F) && (this.fSz >= 0.0F) && (this.rJv >= 0)) {}
    for (int i = 1; i == 0; i = 0) {
      return 0;
    }
    i = j;
    if (this.rJw >= 0.0F)
    {
      i = j;
      if (this.rJx >= 0.0F)
      {
        i = j;
        if (this.rJy >= 0.0F)
        {
          i = j;
          if (this.rJz >= 0.0F)
          {
            i = j;
            if (this.rJA >= 0) {
              i = 1;
            }
          }
        }
      }
    }
    if (i == 0) {
      return 1;
    }
    i = Math.abs((int)(this.fSy - this.rJy));
    j = Math.abs((int)(this.fSz - this.rJz));
    if ((i > 30) || (j > 30) || (this.rJv != this.rJA)) {
      return 3;
    }
    return 2;
  }
  
  public final void reset()
  {
    this.ivk = 0;
    this.rJt = -1.0F;
    this.rJu = -1.0F;
    this.fSy = -1.0F;
    this.fSz = -1.0F;
    this.rJv = -1;
    this.rJw = -1.0F;
    this.rJx = -1.0F;
    this.rJy = -1.0F;
    this.rJz = -1.0F;
    this.rJA = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.b
 * JD-Core Version:    0.7.0.1
 */