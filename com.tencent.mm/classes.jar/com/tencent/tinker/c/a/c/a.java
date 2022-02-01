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
  public abstract int aiG(int paramInt);
  
  public abstract int aiH(int paramInt);
  
  public abstract int aiI(int paramInt);
  
  public abstract int aiJ(int paramInt);
  
  public abstract int aiK(int paramInt);
  
  public abstract int aiL(int paramInt);
  
  public abstract int aiM(int paramInt);
  
  public abstract int aiN(int paramInt);
  
  public abstract int aiO(int paramInt);
  
  public abstract int aiP(int paramInt);
  
  public abstract int aiQ(int paramInt);
  
  public abstract int aiR(int paramInt);
  
  public abstract int aiS(int paramInt);
  
  public abstract int aiT(int paramInt);
  
  public final e.a[] b(e.a[] paramArrayOfa)
  {
    e.a[] arrayOfa = new e.a[paramArrayOfa.length];
    int i = 0;
    while (i < paramArrayOfa.length)
    {
      e.a locala = paramArrayOfa[i];
      arrayOfa[i] = new e.a(aiJ(locala.MzE), locala.MzF);
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
      int j = aiK(localb.MzG);
      int k = aiT(localb.MzH);
      arrayOfb[i] = new e.b(j, localb.MzF, k);
      i += 1;
    }
    return arrayOfb;
  }
  
  public final class a
  {
    private final b MCS;
    
    public a(b paramb)
    {
      this.MCS = paramb;
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
        l.a(this.MCS, 0, paramm.readByte());
        return;
      case 2: 
        l.a(this.MCS, 2, paramm.readShort());
        return;
      case 4: 
        l.a(this.MCS, 4, paramm.readInt());
        return;
      case 6: 
        l.a(this.MCS, 6, paramm.readLong());
        return;
      case 3: 
        l.b(this.MCS, 3, paramm.readChar());
        return;
      case 16: 
        long l = Float.floatToIntBits(paramm.readFloat());
        l.c(this.MCS, 16, l << 32);
        return;
      case 17: 
        l.c(this.MCS, 17, Double.doubleToLongBits(paramm.readDouble()));
        return;
      case 23: 
        l.b(this.MCS, 23, a.this.aiG(paramm.gcD()));
        return;
      case 24: 
        l.b(this.MCS, 24, a.this.aiH(paramm.gcE()));
        return;
      case 25: 
        l.b(this.MCS, 25, a.this.aiJ(paramm.gcF()));
        return;
      case 27: 
        l.b(this.MCS, 27, a.this.aiJ(paramm.gcG()));
        return;
      case 26: 
        l.b(this.MCS, 26, a.this.aiK(paramm.gcH()));
        return;
      case 28: 
        ll(28, 0);
        c(paramm);
        return;
      case 29: 
        ll(29, 0);
        b(paramm);
        return;
      case 30: 
        paramm.gcI();
        ll(30, 0);
        return;
      }
      if (paramm.readBoolean()) {
        i = 1;
      }
      ll(31, i);
    }
    
    private void ll(int paramInt1, int paramInt2)
    {
      this.MCS.writeByte(paramInt2 << 5 | paramInt1);
    }
    
    public final void b(m paramm)
    {
      int j = paramm.gcB();
      o.a(this.MCS, a.this.aiH(paramm.MAs));
      o.a(this.MCS, j);
      int i = 0;
      while (i < j)
      {
        o.a(this.MCS, a.this.aiG(paramm.gcC()));
        a(paramm);
        i += 1;
      }
    }
    
    public final void c(m paramm)
    {
      int j = paramm.gcA();
      o.a(this.MCS, j);
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