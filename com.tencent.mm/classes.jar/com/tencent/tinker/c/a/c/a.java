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
  public abstract int asg(int paramInt);
  
  public abstract int ash(int paramInt);
  
  public abstract int asi(int paramInt);
  
  public abstract int asj(int paramInt);
  
  public abstract int ask(int paramInt);
  
  public abstract int asl(int paramInt);
  
  public abstract int asm(int paramInt);
  
  public abstract int asn(int paramInt);
  
  public abstract int aso(int paramInt);
  
  public abstract int asp(int paramInt);
  
  public abstract int asq(int paramInt);
  
  public abstract int asr(int paramInt);
  
  public abstract int ass(int paramInt);
  
  public abstract int ast(int paramInt);
  
  public final e.a[] b(e.a[] paramArrayOfa)
  {
    e.a[] arrayOfa = new e.a[paramArrayOfa.length];
    int i = 0;
    while (i < paramArrayOfa.length)
    {
      e.a locala = paramArrayOfa[i];
      arrayOfa[i] = new e.a(asj(locala.SfI), locala.SfJ);
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
      int j = ask(localb.SfK);
      int k = ast(localb.SfL);
      arrayOfb[i] = new e.b(j, localb.SfJ, k);
      i += 1;
    }
    return arrayOfb;
  }
  
  public final class a
  {
    private final b SiU;
    
    public a(b paramb)
    {
      this.SiU = paramb;
    }
    
    private void a(m paramm)
    {
      int i = 0;
      switch (paramm.hoI())
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
        throw new j("Unexpected type: " + Integer.toHexString(paramm.hoI()));
      case 0: 
        l.a(this.SiU, 0, paramm.readByte());
        return;
      case 2: 
        l.a(this.SiU, 2, paramm.readShort());
        return;
      case 4: 
        l.a(this.SiU, 4, paramm.readInt());
        return;
      case 6: 
        l.a(this.SiU, 6, paramm.readLong());
        return;
      case 3: 
        l.b(this.SiU, 3, paramm.readChar());
        return;
      case 16: 
        long l = Float.floatToIntBits(paramm.readFloat());
        l.c(this.SiU, 16, l << 32);
        return;
      case 17: 
        l.c(this.SiU, 17, Double.doubleToLongBits(paramm.readDouble()));
        return;
      case 23: 
        l.b(this.SiU, 23, a.this.asg(paramm.hoM()));
        return;
      case 24: 
        l.b(this.SiU, 24, a.this.ash(paramm.hoN()));
        return;
      case 25: 
        l.b(this.SiU, 25, a.this.asj(paramm.hoO()));
        return;
      case 27: 
        l.b(this.SiU, 27, a.this.asj(paramm.zd()));
        return;
      case 26: 
        l.b(this.SiU, 26, a.this.ask(paramm.hoP()));
        return;
      case 28: 
        mJ(28, 0);
        c(paramm);
        return;
      case 29: 
        mJ(29, 0);
        b(paramm);
        return;
      case 30: 
        paramm.hoQ();
        mJ(30, 0);
        return;
      }
      if (paramm.readBoolean()) {
        i = 1;
      }
      mJ(31, i);
    }
    
    private void mJ(int paramInt1, int paramInt2)
    {
      this.SiU.writeByte(paramInt2 << 5 | paramInt1);
    }
    
    public final void b(m paramm)
    {
      int j = paramm.hoK();
      o.a(this.SiU, a.this.ash(paramm.Sgw));
      o.a(this.SiU, j);
      int i = 0;
      while (i < j)
      {
        o.a(this.SiU, a.this.asg(paramm.hoL()));
        a(paramm);
        i += 1;
      }
    }
    
    public final void c(m paramm)
    {
      int j = paramm.hoJ();
      o.a(this.SiU, j);
      int i = 0;
      while (i < j)
      {
        a(paramm);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tinker.c.a.c.a
 * JD-Core Version:    0.7.0.1
 */