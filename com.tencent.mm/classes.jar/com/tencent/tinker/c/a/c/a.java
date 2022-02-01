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
  public abstract int ahX(int paramInt);
  
  public abstract int ahY(int paramInt);
  
  public abstract int ahZ(int paramInt);
  
  public abstract int aia(int paramInt);
  
  public abstract int aib(int paramInt);
  
  public abstract int aic(int paramInt);
  
  public abstract int aid(int paramInt);
  
  public abstract int aie(int paramInt);
  
  public abstract int aif(int paramInt);
  
  public abstract int aig(int paramInt);
  
  public abstract int aih(int paramInt);
  
  public abstract int aii(int paramInt);
  
  public abstract int aij(int paramInt);
  
  public abstract int aik(int paramInt);
  
  public final e.a[] b(e.a[] paramArrayOfa)
  {
    e.a[] arrayOfa = new e.a[paramArrayOfa.length];
    int i = 0;
    while (i < paramArrayOfa.length)
    {
      e.a locala = paramArrayOfa[i];
      arrayOfa[i] = new e.a(aia(locala.McJ), locala.McK);
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
      int j = aib(localb.McL);
      int k = aik(localb.McM);
      arrayOfb[i] = new e.b(j, localb.McK, k);
      i += 1;
    }
    return arrayOfb;
  }
  
  public final class a
  {
    private final b MfV;
    
    public a(b paramb)
    {
      this.MfV = paramb;
    }
    
    private void a(m paramm)
    {
      int i = 0;
      switch (paramm.yW())
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
        throw new j("Unexpected type: " + Integer.toHexString(paramm.yW()));
      case 0: 
        l.a(this.MfV, 0, paramm.readByte());
        return;
      case 2: 
        l.a(this.MfV, 2, paramm.readShort());
        return;
      case 4: 
        l.a(this.MfV, 4, paramm.readInt());
        return;
      case 6: 
        l.a(this.MfV, 6, paramm.readLong());
        return;
      case 3: 
        l.b(this.MfV, 3, paramm.readChar());
        return;
      case 16: 
        long l = Float.floatToIntBits(paramm.readFloat());
        l.c(this.MfV, 16, l << 32);
        return;
      case 17: 
        l.c(this.MfV, 17, Double.doubleToLongBits(paramm.readDouble()));
        return;
      case 23: 
        l.b(this.MfV, 23, a.this.ahX(paramm.fYe()));
        return;
      case 24: 
        l.b(this.MfV, 24, a.this.ahY(paramm.fYf()));
        return;
      case 25: 
        l.b(this.MfV, 25, a.this.aia(paramm.fYg()));
        return;
      case 27: 
        l.b(this.MfV, 27, a.this.aia(paramm.fYh()));
        return;
      case 26: 
        l.b(this.MfV, 26, a.this.aib(paramm.fYi()));
        return;
      case 28: 
        le(28, 0);
        c(paramm);
        return;
      case 29: 
        le(29, 0);
        b(paramm);
        return;
      case 30: 
        paramm.fYj();
        le(30, 0);
        return;
      }
      if (paramm.readBoolean()) {
        i = 1;
      }
      le(31, i);
    }
    
    private void le(int paramInt1, int paramInt2)
    {
      this.MfV.writeByte(paramInt2 << 5 | paramInt1);
    }
    
    public final void b(m paramm)
    {
      int j = paramm.fYc();
      o.a(this.MfV, a.this.ahY(paramm.Mdx));
      o.a(this.MfV, j);
      int i = 0;
      while (i < j)
      {
        o.a(this.MfV, a.this.ahX(paramm.fYd()));
        a(paramm);
        i += 1;
      }
    }
    
    public final void c(m paramm)
    {
      int j = paramm.fYb();
      o.a(this.MfV, j);
      int i = 0;
      while (i < j)
      {
        a(paramm);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.c.a.c.a
 * JD-Core Version:    0.7.0.1
 */