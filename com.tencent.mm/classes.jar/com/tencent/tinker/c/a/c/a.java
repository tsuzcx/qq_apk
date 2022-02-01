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
  public abstract int aBT(int paramInt);
  
  public abstract int aBU(int paramInt);
  
  public abstract int aBV(int paramInt);
  
  public abstract int aBW(int paramInt);
  
  public abstract int aBX(int paramInt);
  
  public abstract int aBY(int paramInt);
  
  public abstract int aBZ(int paramInt);
  
  public abstract int aCa(int paramInt);
  
  public abstract int aCb(int paramInt);
  
  public abstract int aCc(int paramInt);
  
  public abstract int aCd(int paramInt);
  
  public abstract int aCe(int paramInt);
  
  public abstract int aCf(int paramInt);
  
  public abstract int aCg(int paramInt);
  
  public final e.a[] b(e.a[] paramArrayOfa)
  {
    e.a[] arrayOfa = new e.a[paramArrayOfa.length];
    int i = 0;
    while (i < paramArrayOfa.length)
    {
      e.a locala = paramArrayOfa[i];
      arrayOfa[i] = new e.a(aBW(locala.ZIt), locala.ZIu);
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
      int j = aBX(localb.ZIv);
      int k = aCg(localb.ZIw);
      arrayOfb[i] = new e.b(j, localb.ZIu, k);
      i += 1;
    }
    return arrayOfb;
  }
  
  public final class a
  {
    private final b ZLF;
    
    public a(b paramb)
    {
      this.ZLF = paramb;
    }
    
    private void a(m paramm)
    {
      int i = 0;
      switch (paramm.zY())
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
        throw new j("Unexpected type: " + Integer.toHexString(paramm.zY()));
      case 0: 
        l.a(this.ZLF, 0, paramm.readByte());
        return;
      case 2: 
        l.a(this.ZLF, 2, paramm.readShort());
        return;
      case 4: 
        l.a(this.ZLF, 4, paramm.readInt());
        return;
      case 6: 
        l.a(this.ZLF, 6, paramm.readLong());
        return;
      case 3: 
        l.b(this.ZLF, 3, paramm.readChar());
        return;
      case 16: 
        long l = Float.floatToIntBits(paramm.readFloat());
        l.c(this.ZLF, 16, l << 32);
        return;
      case 17: 
        l.c(this.ZLF, 17, Double.doubleToLongBits(paramm.readDouble()));
        return;
      case 23: 
        l.b(this.ZLF, 23, a.this.aBT(paramm.isn()));
        return;
      case 24: 
        l.b(this.ZLF, 24, a.this.aBU(paramm.iso()));
        return;
      case 25: 
        l.b(this.ZLF, 25, a.this.aBW(paramm.isp()));
        return;
      case 27: 
        l.b(this.ZLF, 27, a.this.aBW(paramm.AF()));
        return;
      case 26: 
        l.b(this.ZLF, 26, a.this.aBX(paramm.isq()));
        return;
      case 28: 
        ob(28, 0);
        c(paramm);
        return;
      case 29: 
        ob(29, 0);
        b(paramm);
        return;
      case 30: 
        paramm.isr();
        ob(30, 0);
        return;
      }
      if (paramm.readBoolean()) {
        i = 1;
      }
      ob(31, i);
    }
    
    private void ob(int paramInt1, int paramInt2)
    {
      this.ZLF.bU(paramInt2 << 5 | paramInt1);
    }
    
    public final void b(m paramm)
    {
      int j = paramm.isl();
      o.a(this.ZLF, a.this.aBU(paramm.ZJh));
      o.a(this.ZLF, j);
      int i = 0;
      while (i < j)
      {
        o.a(this.ZLF, a.this.aBT(paramm.ism()));
        a(paramm);
        i += 1;
      }
    }
    
    public final void c(m paramm)
    {
      int j = paramm.isk();
      o.a(this.ZLF, j);
      int i = 0;
      while (i < j)
      {
        a(paramm);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.tinker.c.a.c.a
 * JD-Core Version:    0.7.0.1
 */