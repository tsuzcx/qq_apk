package com.tencent.mm.protocal.c;

public final class bml
  extends com.tencent.mm.bv.a
{
  public String tFO;
  public boolean tFP;
  
  public final bml YI(String paramString)
  {
    this.tFO = paramString;
    this.tFP = true;
    return this;
  }
  
  public final void a(d.a.a.c.a parama)
  {
    if (this.tFP) {
      parama.d(1, this.tFO);
    }
  }
  
  public final boolean a(d.a.a.a.a parama, com.tencent.mm.bv.a parama1, int paramInt)
  {
    parama1 = (bml)parama1;
    switch (paramInt)
    {
    default: 
      return false;
    }
    parama1.YI(parama.xpH.readString());
    return true;
  }
  
  public final int btq()
  {
    int i = 0;
    if (this.tFP) {
      i = d.a.a.b.b.a.e(1, this.tFO) + 0;
    }
    return i + 0;
  }
  
  public final byte[] toByteArray()
  {
    return super.toByteArray();
  }
  
  public final String toString()
  {
    return this.tFO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bml
 * JD-Core Version:    0.7.0.1
 */