package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class bmm
  extends com.tencent.mm.bv.a
{
  public int tFQ;
  private boolean tFR;
  
  private bmm cpn()
  {
    if (!this.tFR) {
      throw new b("Not all required fields were included (false = not included in message),  uiVal:" + this.tFR);
    }
    return this;
  }
  
  public final bmm EU(int paramInt)
  {
    this.tFQ = paramInt;
    this.tFR = true;
    return this;
  }
  
  public final void a(d.a.a.c.a parama)
  {
    parama.gB(1, this.tFQ);
  }
  
  public final boolean a(d.a.a.a.a parama, com.tencent.mm.bv.a parama1, int paramInt)
  {
    parama1 = (bmm)parama1;
    switch (paramInt)
    {
    default: 
      return false;
    }
    parama1.EU(parama.xpH.oD());
    return true;
  }
  
  public final int btq()
  {
    return d.a.a.a.gy(1, this.tFQ) + 0 + 0;
  }
  
  public final byte[] toByteArray()
  {
    cpn();
    return super.toByteArray();
  }
  
  public final String toString()
  {
    return new StringBuilder(String.valueOf(new StringBuilder(String.valueOf("")).append(getClass().getName()).append("(").toString())).append("uiVal = ").append(this.tFQ).append("   ").toString() + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bmm
 * JD-Core Version:    0.7.0.1
 */