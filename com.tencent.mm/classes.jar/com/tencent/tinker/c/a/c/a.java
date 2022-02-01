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
  public abstract int aII(int paramInt);
  
  public abstract int aIJ(int paramInt);
  
  public abstract int aIK(int paramInt);
  
  public abstract int aIL(int paramInt);
  
  public abstract int aIM(int paramInt);
  
  public abstract int aIN(int paramInt);
  
  public abstract int aIO(int paramInt);
  
  public abstract int aIP(int paramInt);
  
  public abstract int aIQ(int paramInt);
  
  public abstract int aIR(int paramInt);
  
  public abstract int aIS(int paramInt);
  
  public abstract int aIT(int paramInt);
  
  public abstract int aIU(int paramInt);
  
  public abstract int aIV(int paramInt);
  
  public final e.a[] b(e.a[] paramArrayOfa)
  {
    e.a[] arrayOfa = new e.a[paramArrayOfa.length];
    int i = 0;
    while (i < paramArrayOfa.length)
    {
      e.a locala = paramArrayOfa[i];
      arrayOfa[i] = new e.a(aIL(locala.ahNw), locala.ahNx);
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
      int j = aIM(localb.ahNy);
      int k = aIV(localb.ahNz);
      arrayOfb[i] = new e.b(j, localb.ahNx, k);
      i += 1;
    }
    return arrayOfb;
  }
  
  public final class a
  {
    private final b ahQH;
    
    public a(b paramb)
    {
      this.ahQH = paramb;
    }
    
    private void a(m paramm)
    {
      int i = 0;
      switch (paramm.px())
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
        throw new j("Unexpected type: " + Integer.toHexString(paramm.px()));
      case 0: 
        l.a(this.ahQH, 0, paramm.readByte());
        return;
      case 2: 
        l.a(this.ahQH, 2, paramm.readShort());
        return;
      case 4: 
        l.a(this.ahQH, 4, paramm.readInt());
        return;
      case 6: 
        l.a(this.ahQH, 6, paramm.readLong());
        return;
      case 3: 
        l.b(this.ahQH, 3, paramm.readChar());
        return;
      case 16: 
        long l = Float.floatToIntBits(paramm.readFloat());
        l.c(this.ahQH, 16, l << 32);
        return;
      case 17: 
        l.c(this.ahQH, 17, Double.doubleToLongBits(paramm.readDouble()));
        return;
      case 23: 
        l.b(this.ahQH, 23, a.this.aII(paramm.kbN()));
        return;
      case 24: 
        l.b(this.ahQH, 24, a.this.aIJ(paramm.kbO()));
        return;
      case 25: 
        l.b(this.ahQH, 25, a.this.aIL(paramm.kbP()));
        return;
      case 27: 
        l.b(this.ahQH, 27, a.this.aIL(paramm.aam()));
        return;
      case 26: 
        l.b(this.ahQH, 26, a.this.aIM(paramm.kbQ()));
        return;
      case 28: 
        pY(28, 0);
        c(paramm);
        return;
      case 29: 
        pY(29, 0);
        b(paramm);
        return;
      case 30: 
        paramm.kbR();
        pY(30, 0);
        return;
      }
      if (paramm.readBoolean()) {
        i = 1;
      }
      pY(31, i);
    }
    
    private void pY(int paramInt1, int paramInt2)
    {
      this.ahQH.eQ(paramInt2 << 5 | paramInt1);
    }
    
    public final void b(m paramm)
    {
      int j = paramm.kbL();
      o.a(this.ahQH, a.this.aIJ(paramm.ahOj));
      o.a(this.ahQH, j);
      int i = 0;
      while (i < j)
      {
        o.a(this.ahQH, a.this.aII(paramm.kbM()));
        a(paramm);
        i += 1;
      }
    }
    
    public final void c(m paramm)
    {
      int j = paramm.kbK();
      o.a(this.ahQH, j);
      int i = 0;
      while (i < j)
      {
        a(paramm);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.tinker.c.a.c.a
 * JD-Core Version:    0.7.0.1
 */