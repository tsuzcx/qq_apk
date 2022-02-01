package com.tencent.tinker.c.a.c;

import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.b.a.c;
import com.tencent.tinker.a.b.a.d;
import com.tencent.tinker.a.b.a.e;
import com.tencent.tinker.a.b.a.f;
import com.tencent.tinker.a.b.a.g;
import com.tencent.tinker.a.b.a.h;
import java.io.EOFException;

public final class b
{
  final a KpY;
  
  public b(a parama)
  {
    this.KpY = parama;
  }
  
  public final short[] a(short[] paramArrayOfShort)
  {
    h localh = new h(paramArrayOfShort.length);
    c localc = new c();
    f localf = new f(localh, localc);
    paramArrayOfShort = new d(new g(paramArrayOfShort));
    int i;
    try
    {
      paramArrayOfShort.a(new a(localc));
      paramArrayOfShort.a(new a(localf));
      i = localh.anh;
      if (i == localh.Kov.length) {
        return localh.Kov;
      }
    }
    catch (EOFException paramArrayOfShort)
    {
      throw new j(paramArrayOfShort);
    }
    paramArrayOfShort = new short[i];
    System.arraycopy(localh.Kov, 0, paramArrayOfShort, 0, i);
    return paramArrayOfShort;
  }
  
  final class a
    extends e
  {
    a(e parame)
    {
      super();
    }
    
    private int kQ(int paramInt1, int paramInt2)
    {
      switch (paramInt2)
      {
      default: 
        return paramInt1;
      case 3: 
        return b.this.KpY.afx(paramInt1);
      case 2: 
        return b.this.KpY.afy(paramInt1);
      case 5: 
        return b.this.KpY.afA(paramInt1);
      }
      return b.this.KpY.afB(paramInt1);
    }
    
    public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong)
    {
      super.a(paramInt1, paramInt2, kQ(paramInt3, paramInt4), paramInt4, paramInt5, paramLong);
    }
    
    public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, int paramInt6)
    {
      super.a(paramInt1, paramInt2, kQ(paramInt3, paramInt4), paramInt4, paramInt5, paramLong, paramInt6);
    }
    
    public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, int paramInt6, int paramInt7)
    {
      super.a(paramInt1, paramInt2, kQ(paramInt3, paramInt4), paramInt4, paramInt5, paramLong, paramInt6, paramInt7);
    }
    
    public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, int paramInt6, int paramInt7, int paramInt8)
    {
      super.a(paramInt1, paramInt2, kQ(paramInt3, paramInt4), paramInt4, paramInt5, paramLong, paramInt6, paramInt7, paramInt8);
    }
    
    public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
    {
      super.a(paramInt1, paramInt2, kQ(paramInt3, paramInt4), paramInt4, paramInt5, paramLong, paramInt6, paramInt7, paramInt8, paramInt9);
    }
    
    public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
    {
      super.a(paramInt1, paramInt2, kQ(paramInt3, paramInt4), paramInt4, paramInt5, paramLong, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
    }
    
    public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, int paramInt6, int paramInt7)
    {
      super.b(paramInt1, paramInt2, kQ(paramInt3, paramInt4), paramInt4, paramInt5, paramLong, paramInt6, paramInt7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.c.a.c.b
 * JD-Core Version:    0.7.0.1
 */