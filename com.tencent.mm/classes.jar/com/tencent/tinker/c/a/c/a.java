package com.tencent.tinker.c.a.c;

import com.tencent.tinker.a.a.b.b;
import com.tencent.tinker.a.a.e.a;
import com.tencent.tinker.a.a.e.b;
import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.a.l;
import com.tencent.tinker.a.a.m;
import com.tencent.tinker.a.a.o;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public abstract class a
{
  public abstract int afA(int paramInt);
  
  public abstract int afB(int paramInt);
  
  public abstract int afC(int paramInt);
  
  public abstract int afD(int paramInt);
  
  public abstract int afE(int paramInt);
  
  public abstract int afF(int paramInt);
  
  public abstract int afG(int paramInt);
  
  public abstract int afH(int paramInt);
  
  public abstract int afI(int paramInt);
  
  public abstract int afJ(int paramInt);
  
  public abstract int afK(int paramInt);
  
  public abstract int afx(int paramInt);
  
  public abstract int afy(int paramInt);
  
  public abstract int afz(int paramInt);
  
  public final e.a[] b(e.a[] paramArrayOfa)
  {
    e.a[] arrayOfa = new e.a[paramArrayOfa.length];
    int i = 0;
    while (i < paramArrayOfa.length)
    {
      e.a locala = paramArrayOfa[i];
      arrayOfa[i] = new e.a(afA(locala.KmL), locala.KmM);
      i += 1;
    }
    return arrayOfa;
  }
  
  public final e.b[] b(e.b[] paramArrayOfb)
  {
    e.b[] arrayOfb = new e.b[paramArrayOfb.length];
    int i = 0;
    while (i < paramArrayOfb.length)
    {
      e.b localb = paramArrayOfb[i];
      int j = afB(localb.KmN);
      int k = afK(localb.KmO);
      arrayOfb[i] = new e.b(j, localb.KmM, k);
      i += 1;
    }
    return arrayOfb;
  }
  
  public final class a
  {
    private final b KpX;
    
    public a(b paramb)
    {
      this.KpX = paramb;
    }
    
    private void a(m paramm)
    {
      int i = 0;
      switch (paramm.xz())
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
        throw new j("Unexpected type: " + Integer.toHexString(paramm.xz()));
      case 0: 
        l.a(this.KpX, 0, paramm.readByte());
        return;
      case 2: 
        l.a(this.KpX, 2, paramm.readShort());
        return;
      case 4: 
        l.a(this.KpX, 4, paramm.readInt());
        return;
      case 6: 
        l.a(this.KpX, 6, paramm.readLong());
        return;
      case 3: 
        l.b(this.KpX, 3, paramm.readChar());
        return;
      case 16: 
        long l = Float.floatToIntBits(paramm.readFloat());
        l.c(this.KpX, 16, l << 32);
        return;
      case 17: 
        l.c(this.KpX, 17, Double.doubleToLongBits(paramm.readDouble()));
        return;
      case 23: 
        l.b(this.KpX, 23, a.this.afx(paramm.fGS()));
        return;
      case 24: 
        l.b(this.KpX, 24, a.this.afy(paramm.fGT()));
        return;
      case 25: 
        l.b(this.KpX, 25, a.this.afA(paramm.fGU()));
        return;
      case 27: 
        l.b(this.KpX, 27, a.this.afA(paramm.fGV()));
        return;
      case 26: 
        l.b(this.KpX, 26, a.this.afB(paramm.fGW()));
        return;
      case 28: 
        kP(28, 0);
        c(paramm);
        return;
      case 29: 
        kP(29, 0);
        b(paramm);
        return;
      case 30: 
        paramm.fGX();
        kP(30, 0);
        return;
      }
      if (paramm.readBoolean()) {
        i = 1;
      }
      kP(31, i);
    }
    
    private void kP(int paramInt1, int paramInt2)
    {
      this.KpX.writeByte(paramInt2 << 5 | paramInt1);
    }
    
    public final void b(m paramm)
    {
      int j = paramm.fGQ();
      o.a(this.KpX, a.this.afy(paramm.Knz));
      o.a(this.KpX, j);
      int i = 0;
      while (i < j)
      {
        o.a(this.KpX, a.this.afx(paramm.fGR()));
        a(paramm);
        i += 1;
      }
    }
    
    public final void c(m paramm)
    {
      int j = paramm.fGP();
      o.a(this.KpX, j);
      int i = 0;
      while (i < j)
      {
        a(paramm);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.c.a.c.a
 * JD-Core Version:    0.7.0.1
 */