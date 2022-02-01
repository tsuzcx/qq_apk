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
  public abstract int acB(int paramInt);
  
  public abstract int acC(int paramInt);
  
  public abstract int acD(int paramInt);
  
  public abstract int acE(int paramInt);
  
  public abstract int acF(int paramInt);
  
  public abstract int acG(int paramInt);
  
  public abstract int acH(int paramInt);
  
  public abstract int acI(int paramInt);
  
  public abstract int acJ(int paramInt);
  
  public abstract int acK(int paramInt);
  
  public abstract int acL(int paramInt);
  
  public abstract int acM(int paramInt);
  
  public abstract int acN(int paramInt);
  
  public abstract int acO(int paramInt);
  
  public final e.a[] b(e.a[] paramArrayOfa)
  {
    e.a[] arrayOfa = new e.a[paramArrayOfa.length];
    int i = 0;
    while (i < paramArrayOfa.length)
    {
      e.a locala = paramArrayOfa[i];
      arrayOfa[i] = new e.a(acE(locala.IAC), locala.IAD);
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
      int j = acF(localb.IAE);
      int k = acO(localb.IAF);
      arrayOfb[i] = new e.b(j, localb.IAD, k);
      i += 1;
    }
    return arrayOfb;
  }
  
  public final class a
  {
    private final b IDO;
    
    public a(b paramb)
    {
      this.IDO = paramb;
    }
    
    private void a(m paramm)
    {
      int i = 0;
      switch (paramm.xM())
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
        throw new j("Unexpected type: " + Integer.toHexString(paramm.xM()));
      case 0: 
        l.a(this.IDO, 0, paramm.readByte());
        return;
      case 2: 
        l.a(this.IDO, 2, paramm.readShort());
        return;
      case 4: 
        l.a(this.IDO, 4, paramm.readInt());
        return;
      case 6: 
        l.a(this.IDO, 6, paramm.readLong());
        return;
      case 3: 
        l.b(this.IDO, 3, paramm.readChar());
        return;
      case 16: 
        long l = Float.floatToIntBits(paramm.readFloat());
        l.c(this.IDO, 16, l << 32);
        return;
      case 17: 
        l.c(this.IDO, 17, Double.doubleToLongBits(paramm.readDouble()));
        return;
      case 23: 
        l.b(this.IDO, 23, a.this.acB(paramm.foK()));
        return;
      case 24: 
        l.b(this.IDO, 24, a.this.acC(paramm.foL()));
        return;
      case 25: 
        l.b(this.IDO, 25, a.this.acE(paramm.foM()));
        return;
      case 27: 
        l.b(this.IDO, 27, a.this.acE(paramm.foN()));
        return;
      case 26: 
        l.b(this.IDO, 26, a.this.acF(paramm.foO()));
        return;
      case 28: 
        ky(28, 0);
        c(paramm);
        return;
      case 29: 
        ky(29, 0);
        b(paramm);
        return;
      case 30: 
        paramm.foP();
        ky(30, 0);
        return;
      }
      if (paramm.readBoolean()) {
        i = 1;
      }
      ky(31, i);
    }
    
    private void ky(int paramInt1, int paramInt2)
    {
      this.IDO.writeByte(paramInt2 << 5 | paramInt1);
    }
    
    public final void b(m paramm)
    {
      int j = paramm.foI();
      o.a(this.IDO, a.this.acC(paramm.IBq));
      o.a(this.IDO, j);
      int i = 0;
      while (i < j)
      {
        o.a(this.IDO, a.this.acB(paramm.foJ()));
        a(paramm);
        i += 1;
      }
    }
    
    public final void c(m paramm)
    {
      int j = paramm.foH();
      o.a(this.IDO, j);
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