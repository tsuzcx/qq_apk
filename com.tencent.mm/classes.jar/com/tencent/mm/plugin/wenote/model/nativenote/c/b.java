package com.tencent.mm.plugin.wenote.model.nativenote.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public float bTE = -1.0F;
  public float bTF = -1.0F;
  public int kwo = 0;
  public float vAa = -1.0F;
  public float vAb = -1.0F;
  public float vAc = -1.0F;
  public float vAd = -1.0F;
  public int vAe = -1;
  public float vzX = -1.0F;
  public float vzY = -1.0F;
  public int vzZ = -1;
  
  private boolean diZ()
  {
    return (this.vzX >= 0.0F) && (this.vzY >= 0.0F) && (this.bTE >= 0.0F) && (this.bTF >= 0.0F) && (this.vzZ >= 0);
  }
  
  private boolean dja()
  {
    return (this.vAa >= 0.0F) && (this.vAb >= 0.0F) && (this.vAc >= 0.0F) && (this.vAd >= 0.0F) && (this.vAe >= 0);
  }
  
  public final void a(int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt2)
  {
    this.kwo = paramInt1;
    this.vzX = paramFloat1;
    this.vzY = paramFloat2;
    this.bTE = paramFloat3;
    this.bTF = paramFloat4;
    if (this.kwo == 1)
    {
      this.vzZ = paramInt2;
      return;
    }
    this.vzZ = 0;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(26854);
    if (!diZ())
    {
      AppMethodBeat.o(26854);
      return 0;
    }
    if (!dja())
    {
      AppMethodBeat.o(26854);
      return 1;
    }
    int i = Math.abs((int)(this.bTE - this.vAc));
    int j = Math.abs((int)(this.bTF - this.vAd));
    if ((i > 30) || (j > 30) || (this.vzZ != this.vAe))
    {
      AppMethodBeat.o(26854);
      return 3;
    }
    AppMethodBeat.o(26854);
    return 2;
  }
  
  public final void reset()
  {
    this.kwo = 0;
    this.vzX = -1.0F;
    this.vzY = -1.0F;
    this.bTE = -1.0F;
    this.bTF = -1.0F;
    this.vzZ = -1;
    this.vAa = -1.0F;
    this.vAb = -1.0F;
    this.vAc = -1.0F;
    this.vAd = -1.0F;
    this.vAe = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.b
 * JD-Core Version:    0.7.0.1
 */