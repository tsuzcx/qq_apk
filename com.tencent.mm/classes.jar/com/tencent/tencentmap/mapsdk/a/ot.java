package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.GeoPoint;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class ot
  extends kk
{
  private static int c = 0;
  private CopyOnWriteArrayList<ot.a> a;
  private Context b;
  
  private GeoPoint a(qc paramqc)
  {
    if (paramqc == null) {
      return null;
    }
    return new GeoPoint((int)(paramqc.a * 1000000.0D), (int)(paramqc.b * 1000000.0D));
  }
  
  private boolean a(iu paramiu, kl paramkl1, kl paramkl2)
  {
    paramkl1 = paramkl1.a(paramiu);
    paramiu = paramkl2.a(paramiu);
    if ((paramkl1 == null) || (paramiu == null)) {
      return false;
    }
    return Rect.intersects(paramkl1, paramiu);
  }
  
  private ot.b b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return ot.b.d;
    case 0: 
      return ot.b.a;
    case 1: 
      return ot.b.b;
    }
    return ot.b.c;
  }
  
  private void b(iu paramiu)
  {
    if ((this.a == null) || (this.a.isEmpty())) {}
    for (;;)
    {
      return;
      int m = this.a.size();
      int n = ot.b.d.ordinal();
      ot.b[] arrayOfb = new ot.b[m];
      int i = 0;
      while (i < m)
      {
        arrayOfb[i] = ot.b.a;
        i += 1;
      }
      i = 0;
      while (i < m)
      {
        ot.a locala1 = (ot.a)this.a.get(i);
        kl localkl1 = locala1.c();
        locala1.a(paramiu, arrayOfb[i]);
        int j = i + 1;
        while (j < m)
        {
          ot.a locala2 = (ot.a)this.a.get(j);
          kl localkl2 = locala2.c();
          locala2.a(paramiu, arrayOfb[j]);
          ot.b localb;
          if (locala1.b() <= locala2.b())
          {
            k = arrayOfb[j].ordinal();
            while (k <= n)
            {
              localb = b(k);
              locala2.a(paramiu, localb);
              arrayOfb[j] = localb;
              if (!a(paramiu, localkl1, localkl2)) {
                break;
              }
              k += 1;
            }
          }
          int k = arrayOfb[i].ordinal() - 1;
          while (k < n)
          {
            localb = b(k);
            locala2.a(paramiu, localb);
            arrayOfb[i] = localb;
            if (!a(paramiu, localkl1, localkl2)) {
              break;
            }
            k += 1;
          }
          j += 1;
        }
        i += 1;
      }
    }
  }
  
  /* Error */
  public boolean a(iu paramiu, float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 100	com/tencent/tencentmap/mapsdk/a/ot:c	()I
    //   6: istore 5
    //   8: iconst_0
    //   9: istore 4
    //   11: iload 4
    //   13: iload 5
    //   15: if_icmpge +66 -> 81
    //   18: aload_0
    //   19: iload 4
    //   21: invokevirtual 103	com/tencent/tencentmap/mapsdk/a/ot:a	(I)Lcom/tencent/tencentmap/mapsdk/a/kj;
    //   24: checkcast 45	com/tencent/tencentmap/mapsdk/a/kl
    //   27: astore 7
    //   29: aload 7
    //   31: aload_1
    //   32: fload_2
    //   33: fload_3
    //   34: invokevirtual 105	com/tencent/tencentmap/mapsdk/a/kl:a	(Lcom/tencent/tencentmap/mapsdk/a/iu;FF)Z
    //   37: ifeq +35 -> 72
    //   40: iload 4
    //   42: iload 5
    //   44: iconst_1
    //   45: isub
    //   46: if_icmpge +18 -> 64
    //   49: aload_0
    //   50: aload 7
    //   52: invokevirtual 108	com/tencent/tencentmap/mapsdk/a/ot:b	(Lcom/tencent/tencentmap/mapsdk/a/kj;)Z
    //   55: ifeq +9 -> 64
    //   58: aload_0
    //   59: aload 7
    //   61: invokevirtual 111	com/tencent/tencentmap/mapsdk/a/ot:a	(Lcom/tencent/tencentmap/mapsdk/a/kj;)V
    //   64: iconst_1
    //   65: istore 6
    //   67: aload_0
    //   68: monitorexit
    //   69: iload 6
    //   71: ireturn
    //   72: iload 4
    //   74: iconst_1
    //   75: iadd
    //   76: istore 4
    //   78: goto -67 -> 11
    //   81: iconst_0
    //   82: istore 6
    //   84: goto -17 -> 67
    //   87: astore_1
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	ot
    //   0	92	1	paramiu	iu
    //   0	92	2	paramFloat1	float
    //   0	92	3	paramFloat2	float
    //   9	68	4	i	int
    //   6	40	5	j	int
    //   65	18	6	bool	boolean
    //   27	33	7	localkl	kl
    // Exception table:
    //   from	to	target	type
    //   2	8	87	finally
    //   18	40	87	finally
    //   49	64	87	finally
  }
  
  public void b(je paramje, iu paramiu)
  {
    try
    {
      b(paramiu);
      super.b(paramje, paramiu);
      return;
    }
    finally
    {
      paramje = finally;
      throw paramje;
    }
  }
  
  public void e()
  {
    try
    {
      this.a.clear();
      d();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void f()
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        ot.a locala = (ot.a)localIterator.next();
        if ((locala != null) && (locala.a()))
        {
          this.a.remove(locala);
          b(locala.c());
        }
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ot
 * JD-Core Version:    0.7.0.1
 */