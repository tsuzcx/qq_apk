package com.tencent.mm.plugin.wenote.model.nativenote.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public float cEZ = -1.0F;
  public float cFa = -1.0F;
  public int nBH = 0;
  public float ooX = -1.0F;
  public float ooY = -1.0F;
  public int ooZ = -1;
  public float opa = -1.0F;
  public float opb = -1.0F;
  public float opc = -1.0F;
  public float opd = -1.0F;
  public int ope = -1;
  
  private boolean bST()
  {
    return (this.ooX >= 0.0F) && (this.ooY >= 0.0F) && (this.cEZ >= 0.0F) && (this.cFa >= 0.0F) && (this.ooZ >= 0);
  }
  
  private boolean bSU()
  {
    return (this.opa >= 0.0F) && (this.opb >= 0.0F) && (this.opc >= 0.0F) && (this.opd >= 0.0F) && (this.ope >= 0);
  }
  
  public final void a(int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt2)
  {
    this.nBH = paramInt1;
    this.ooX = paramFloat1;
    this.ooY = paramFloat2;
    this.cEZ = paramFloat3;
    this.cFa = paramFloat4;
    if (this.nBH == 1)
    {
      this.ooZ = paramInt2;
      return;
    }
    this.ooZ = 0;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(30548);
    if (!bST())
    {
      AppMethodBeat.o(30548);
      return 0;
    }
    if (!bSU())
    {
      AppMethodBeat.o(30548);
      return 1;
    }
    int i = Math.abs((int)(this.cEZ - this.opc));
    int j = Math.abs((int)(this.cFa - this.opd));
    if ((i > 30) || (j > 30) || (this.ooZ != this.ope))
    {
      AppMethodBeat.o(30548);
      return 3;
    }
    AppMethodBeat.o(30548);
    return 2;
  }
  
  public final void reset()
  {
    this.nBH = 0;
    this.ooX = -1.0F;
    this.ooY = -1.0F;
    this.cEZ = -1.0F;
    this.cFa = -1.0F;
    this.ooZ = -1;
    this.opa = -1.0F;
    this.opb = -1.0F;
    this.opc = -1.0F;
    this.opd = -1.0F;
    this.ope = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.b
 * JD-Core Version:    0.7.0.1
 */