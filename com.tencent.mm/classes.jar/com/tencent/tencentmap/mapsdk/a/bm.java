package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.k;
import com.tencent.map.lib.element.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.hu;
import com.tencent.tencentmap.mapsdk.maps.a.ih;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class bm
  extends k
{
  private static int c = 0;
  private CopyOnWriteArrayList<bm.a> a;
  private Context b;
  
  private GeoPoint a(cz paramcz)
  {
    AppMethodBeat.i(149890);
    if (paramcz == null)
    {
      AppMethodBeat.o(149890);
      return null;
    }
    paramcz = new GeoPoint((int)(paramcz.a * 1000000.0D), (int)(paramcz.b * 1000000.0D));
    AppMethodBeat.o(149890);
    return paramcz;
  }
  
  private boolean a(hu paramhu, l paraml1, l paraml2)
  {
    AppMethodBeat.i(149889);
    paraml1 = paraml1.a(paramhu);
    paramhu = paraml2.a(paramhu);
    if ((paraml1 == null) || (paramhu == null))
    {
      AppMethodBeat.o(149889);
      return false;
    }
    boolean bool = Rect.intersects(paraml1, paramhu);
    AppMethodBeat.o(149889);
    return bool;
  }
  
  private bm.b b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return bm.b.d;
    case 0: 
      return bm.b.a;
    case 1: 
      return bm.b.b;
    }
    return bm.b.c;
  }
  
  private void b(hu paramhu)
  {
    AppMethodBeat.i(149888);
    if ((this.a == null) || (this.a.isEmpty()))
    {
      AppMethodBeat.o(149888);
      return;
    }
    int m = this.a.size();
    int n = bm.b.d.ordinal();
    bm.b[] arrayOfb = new bm.b[m];
    int i = 0;
    while (i < m)
    {
      arrayOfb[i] = bm.b.a;
      i += 1;
    }
    i = 0;
    while (i < m)
    {
      bm.a locala1 = (bm.a)this.a.get(i);
      l locall1 = locala1.c();
      locala1.a(paramhu, arrayOfb[i]);
      int j = i + 1;
      while (j < m)
      {
        bm.a locala2 = (bm.a)this.a.get(j);
        l locall2 = locala2.c();
        locala2.a(paramhu, arrayOfb[j]);
        bm.b localb;
        if (locala1.b() <= locala2.b())
        {
          k = arrayOfb[j].ordinal();
          while (k <= n)
          {
            localb = b(k);
            locala2.a(paramhu, localb);
            arrayOfb[j] = localb;
            if (!a(paramhu, locall1, locall2)) {
              break;
            }
            k += 1;
          }
        }
        int k = arrayOfb[i].ordinal() - 1;
        while (k < n)
        {
          localb = b(k);
          locala2.a(paramhu, localb);
          arrayOfb[i] = localb;
          if (!a(paramhu, locall1, locall2)) {
            break;
          }
          k += 1;
        }
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(149888);
  }
  
  /* Error */
  public boolean a(hu paramhu, float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 112
    //   4: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokevirtual 114	com/tencent/tencentmap/mapsdk/a/bm:c	()I
    //   11: istore 5
    //   13: iconst_0
    //   14: istore 4
    //   16: iload 4
    //   18: iload 5
    //   20: if_icmpge +71 -> 91
    //   23: aload_0
    //   24: iload 4
    //   26: invokevirtual 117	com/tencent/tencentmap/mapsdk/a/bm:a	(I)Lcom/tencent/map/lib/element/j;
    //   29: checkcast 57	com/tencent/map/lib/element/l
    //   32: astore 7
    //   34: aload 7
    //   36: aload_1
    //   37: fload_2
    //   38: fload_3
    //   39: invokevirtual 119	com/tencent/map/lib/element/l:a	(Lcom/tencent/tencentmap/mapsdk/maps/a/hu;FF)Z
    //   42: ifeq +40 -> 82
    //   45: iload 4
    //   47: iload 5
    //   49: iconst_1
    //   50: isub
    //   51: if_icmpge +18 -> 69
    //   54: aload_0
    //   55: aload 7
    //   57: invokevirtual 122	com/tencent/tencentmap/mapsdk/a/bm:b	(Lcom/tencent/map/lib/element/j;)Z
    //   60: ifeq +9 -> 69
    //   63: aload_0
    //   64: aload 7
    //   66: invokevirtual 125	com/tencent/tencentmap/mapsdk/a/bm:a	(Lcom/tencent/map/lib/element/j;)V
    //   69: iconst_1
    //   70: istore 6
    //   72: ldc 112
    //   74: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aload_0
    //   78: monitorexit
    //   79: iload 6
    //   81: ireturn
    //   82: iload 4
    //   84: iconst_1
    //   85: iadd
    //   86: istore 4
    //   88: goto -72 -> 16
    //   91: ldc 112
    //   93: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: iconst_0
    //   97: istore 6
    //   99: goto -22 -> 77
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	bm
    //   0	107	1	paramhu	hu
    //   0	107	2	paramFloat1	float
    //   0	107	3	paramFloat2	float
    //   14	73	4	i	int
    //   11	40	5	j	int
    //   70	28	6	bool	boolean
    //   32	33	7	locall	l
    // Exception table:
    //   from	to	target	type
    //   2	13	102	finally
    //   23	45	102	finally
    //   54	69	102	finally
    //   72	77	102	finally
    //   91	96	102	finally
  }
  
  public void b(ih paramih, hu paramhu)
  {
    try
    {
      AppMethodBeat.i(149886);
      b(paramhu);
      super.b(paramih, paramhu);
      AppMethodBeat.o(149886);
      return;
    }
    finally
    {
      paramih = finally;
      throw paramih;
    }
  }
  
  public void e()
  {
    try
    {
      AppMethodBeat.i(149884);
      this.a.clear();
      d();
      AppMethodBeat.o(149884);
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
      AppMethodBeat.i(149885);
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        bm.a locala = (bm.a)localIterator.next();
        if ((locala != null) && (locala.a()))
        {
          this.a.remove(locala);
          b(locala.c());
        }
      }
      AppMethodBeat.o(149885);
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.bm
 * JD-Core Version:    0.7.0.1
 */