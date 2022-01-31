package com.tencent.mm.protocal.c;

public final class bmk
  extends com.tencent.mm.bv.a
{
  public int tFK;
  private boolean tFL;
  public com.tencent.mm.bv.b tFM;
  public boolean tFN;
  
  private bmk ET(int paramInt)
  {
    this.tFK = paramInt;
    this.tFL = true;
    return this;
  }
  
  private bmk cpm()
  {
    if (!this.tFL) {
      throw new d.a.a.b("Not all required fields were included (false = not included in message),  iLen:" + this.tFL);
    }
    return this;
  }
  
  public final bmk T(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte = com.tencent.mm.bv.b.v(paramArrayOfByte, 0, paramInt);
    b(paramArrayOfByte);
    ET(paramArrayOfByte.oY.length);
    return this;
  }
  
  public final void a(d.a.a.c.a parama)
  {
    parama.gB(1, this.tFK);
    if (this.tFN) {
      parama.b(2, this.tFM);
    }
  }
  
  public final boolean a(d.a.a.a.a parama, com.tencent.mm.bv.a parama1, int paramInt)
  {
    parama1 = (bmk)parama1;
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      parama1.ET(parama.xpH.oD());
      return true;
    }
    parama1.b(parama.cUs());
    return true;
  }
  
  public final bmk b(com.tencent.mm.bv.b paramb)
  {
    if (paramb == null) {
      bs(null);
    }
    this.tFM = paramb;
    this.tFN = true;
    ET(this.tFM.oY.length);
    return this;
  }
  
  public final bmk bs(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = com.tencent.mm.bv.b.bk(paramArrayOfByte);
    b(paramArrayOfByte);
    ET(paramArrayOfByte.oY.length);
    return this;
  }
  
  public final bmk bt(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new d.a.a.a.a(paramArrayOfByte, unknownTagHandler);
    for (int i = a(paramArrayOfByte);; i = a(paramArrayOfByte))
    {
      if (i <= 0) {
        return cpm();
      }
      if (!a(paramArrayOfByte, this, i)) {
        paramArrayOfByte.cUt();
      }
    }
  }
  
  public final int btq()
  {
    int j = d.a.a.a.gy(1, this.tFK) + 0;
    int i = j;
    if (this.tFN) {
      i = j + d.a.a.a.a(2, this.tFM);
    }
    return i + 0;
  }
  
  public final byte[] toByteArray()
  {
    cpm();
    return super.toByteArray();
  }
  
  public final String toString()
  {
    String str2 = new StringBuilder(String.valueOf("")).append(getClass().getName()).append("(").toString() + "iLen = " + this.tFK + "   ";
    String str1 = str2;
    if (this.tFN) {
      str1 = str2 + "Buffer = " + this.tFM + "   ";
    }
    return str1 + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bmk
 * JD-Core Version:    0.7.0.1
 */