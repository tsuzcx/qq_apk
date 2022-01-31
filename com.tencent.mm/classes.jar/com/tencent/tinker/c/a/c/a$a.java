package com.tencent.tinker.c.a.c;

import com.tencent.tinker.a.a.b.b;
import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.a.l;
import com.tencent.tinker.a.a.m;
import com.tencent.tinker.a.a.o;

public final class a$a
{
  private final b BrT;
  
  public a$a(a parama, b paramb)
  {
    this.BrT = paramb;
  }
  
  private void a(m paramm)
  {
    int i = 0;
    switch (paramm.dWb())
    {
    case 1: 
    case 5: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    default: 
      throw new j("Unexpected type: " + Integer.toHexString(paramm.dWb()));
    case 0: 
      l.a(this.BrT, 0, paramm.readByte());
      return;
    case 2: 
      l.a(this.BrT, 2, paramm.readShort());
      return;
    case 4: 
      l.a(this.BrT, 4, paramm.readInt());
      return;
    case 6: 
      l.a(this.BrT, 6, paramm.readLong());
      return;
    case 3: 
      l.b(this.BrT, 3, paramm.readChar());
      return;
    case 16: 
      long l = Float.floatToIntBits(paramm.readFloat());
      l.c(this.BrT, 16, l << 32);
      return;
    case 17: 
      l.c(this.BrT, 17, Double.doubleToLongBits(paramm.readDouble()));
      return;
    case 23: 
      l.b(this.BrT, 23, this.BrR.SP(paramm.dWf()));
      return;
    case 24: 
      l.b(this.BrT, 24, this.BrR.SQ(paramm.dWg()));
      return;
    case 25: 
      l.b(this.BrT, 25, this.BrR.SS(paramm.dWh()));
      return;
    case 27: 
      l.b(this.BrT, 27, this.BrR.SS(paramm.dWi()));
      return;
    case 26: 
      l.b(this.BrT, 26, this.BrR.ST(paramm.dWj()));
      return;
    case 28: 
      iv(28, 0);
      c(paramm);
      return;
    case 29: 
      iv(29, 0);
      b(paramm);
      return;
    case 30: 
      paramm.dWk();
      iv(30, 0);
      return;
    }
    if (paramm.readBoolean()) {
      i = 1;
    }
    iv(31, i);
  }
  
  private void iv(int paramInt1, int paramInt2)
  {
    this.BrT.writeByte(paramInt2 << 5 | paramInt1);
  }
  
  public final void b(m paramm)
  {
    int j = paramm.dWd();
    o.a(this.BrT, this.BrR.SQ(paramm.Bpv));
    o.a(this.BrT, j);
    int i = 0;
    while (i < j)
    {
      o.a(this.BrT, this.BrR.SP(paramm.dWe()));
      a(paramm);
      i += 1;
    }
  }
  
  public final void c(m paramm)
  {
    int j = paramm.dWc();
    o.a(this.BrT, j);
    int i = 0;
    while (i < j)
    {
      a(paramm);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tinker.c.a.c.a.a
 * JD-Core Version:    0.7.0.1
 */