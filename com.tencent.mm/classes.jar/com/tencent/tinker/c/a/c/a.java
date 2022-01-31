package com.tencent.tinker.c.a.c;

import com.tencent.tinker.a.a.e.a;
import com.tencent.tinker.a.a.e.b;
import java.io.ByteArrayInputStream;

public abstract class a
{
  public abstract int SP(int paramInt);
  
  public abstract int SQ(int paramInt);
  
  public abstract int SR(int paramInt);
  
  public abstract int SS(int paramInt);
  
  public abstract int ST(int paramInt);
  
  public abstract int SU(int paramInt);
  
  public abstract int SV(int paramInt);
  
  public abstract int SW(int paramInt);
  
  public abstract int SX(int paramInt);
  
  public abstract int SY(int paramInt);
  
  public abstract int SZ(int paramInt);
  
  public abstract int Ta(int paramInt);
  
  public abstract int Tb(int paramInt);
  
  public abstract int Tc(int paramInt);
  
  public final e.a[] b(e.a[] paramArrayOfa)
  {
    e.a[] arrayOfa = new e.a[paramArrayOfa.length];
    int i = 0;
    while (i < paramArrayOfa.length)
    {
      e.a locala = paramArrayOfa[i];
      arrayOfa[i] = new e.a(SS(locala.BoH), locala.BoI);
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
      int j = ST(localb.BoJ);
      int k = Tc(localb.BoK);
      arrayOfb[i] = new e.b(j, localb.BoI, k);
      i += 1;
    }
    return arrayOfb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.c.a.c.a
 * JD-Core Version:    0.7.0.1
 */