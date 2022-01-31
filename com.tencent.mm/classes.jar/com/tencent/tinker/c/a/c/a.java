package com.tencent.tinker.c.a.c;

import com.tencent.tinker.a.a.e.a;
import com.tencent.tinker.a.a.e.b;

public abstract class a
{
  public abstract int JV(int paramInt);
  
  public abstract int JW(int paramInt);
  
  public abstract int JX(int paramInt);
  
  public abstract int JY(int paramInt);
  
  public abstract int JZ(int paramInt);
  
  public abstract int Ka(int paramInt);
  
  public abstract int Kb(int paramInt);
  
  public abstract int Kc(int paramInt);
  
  public abstract int Kd(int paramInt);
  
  public abstract int Ke(int paramInt);
  
  public abstract int Kf(int paramInt);
  
  public abstract int Kg(int paramInt);
  
  public abstract int Kh(int paramInt);
  
  public abstract int Ki(int paramInt);
  
  public final e.a[] b(e.a[] paramArrayOfa)
  {
    e.a[] arrayOfa = new e.a[paramArrayOfa.length];
    int i = 0;
    while (i < paramArrayOfa.length)
    {
      e.a locala = paramArrayOfa[i];
      arrayOfa[i] = new e.a(JY(locala.wSa), locala.wSb);
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
      int j = JZ(localb.wSc);
      int k = Ki(localb.wSd);
      arrayOfb[i] = new e.b(j, localb.wSb, k);
      i += 1;
    }
    return arrayOfb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tinker.c.a.c.a
 * JD-Core Version:    0.7.0.1
 */