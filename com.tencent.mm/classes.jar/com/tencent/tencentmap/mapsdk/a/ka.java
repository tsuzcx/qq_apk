package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Rect;
import java.util.ArrayList;

public abstract class ka<T extends ko<E>, E extends kj>
  implements kj
{
  private T a;
  private ArrayList<E> b;
  private ka.a<E> c;
  private int d = -1;
  private int e = -1;
  
  public int a()
  {
    return this.e;
  }
  
  public Rect a(iu paramiu)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    for (;;)
    {
      int i;
      try
      {
        if (this.b != null)
        {
          i = this.b.size();
          if (i == 0) {
            localObject2 = localObject1;
          }
        }
        else
        {
          return localObject2;
        }
        int j = this.b.size();
        i = 0;
        localObject1 = localObject3;
        localObject2 = localObject1;
        if (i >= j) {
          continue;
        }
        localObject2 = ((kj)this.b.get(i)).a(paramiu);
        if (localObject2 != null) {
          if (localObject1 == null)
          {
            localObject1 = localObject2;
          }
          else
          {
            localObject1.left = Math.min(localObject1.left, ((Rect)localObject2).left);
            localObject1.top = Math.max(localObject1.top, ((Rect)localObject2).top);
            localObject1.right = Math.max(localObject1.right, ((Rect)localObject2).right);
            localObject1.bottom = Math.min(localObject1.bottom, ((Rect)localObject2).bottom);
          }
        }
      }
      finally {}
      i += 1;
    }
  }
  
  /* Error */
  public E a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 34	com/tencent/tencentmap/mapsdk/a/ka:b	Ljava/util/ArrayList;
    //   6: ifnull +20 -> 26
    //   9: iload_1
    //   10: iflt +16 -> 26
    //   13: aload_0
    //   14: getfield 34	com/tencent/tencentmap/mapsdk/a/ka:b	Ljava/util/ArrayList;
    //   17: invokevirtual 39	java/util/ArrayList:size	()I
    //   20: istore_2
    //   21: iload_2
    //   22: iload_1
    //   23: if_icmpgt +9 -> 32
    //   26: aconst_null
    //   27: astore_3
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_3
    //   31: areturn
    //   32: aload_0
    //   33: getfield 34	com/tencent/tencentmap/mapsdk/a/ka:b	Ljava/util/ArrayList;
    //   36: iload_1
    //   37: invokevirtual 43	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   40: checkcast 7	com/tencent/tencentmap/mapsdk/a/kj
    //   43: astore_3
    //   44: goto -16 -> 28
    //   47: astore_3
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_3
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	ka
    //   0	52	1	paramInt	int
    //   20	4	2	i	int
    //   27	17	3	localObject1	Object
    //   47	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	47	finally
    //   13	21	47	finally
    //   32	44	47	finally
  }
  
  public void a(je paramje, iu paramiu)
  {
    for (;;)
    {
      int i;
      try
      {
        int j = a();
        i = 0;
        int k = c();
        kj localkj;
        if (i < k)
        {
          if (j != i)
          {
            localkj = a(i);
            if ((localkj != null) && ((localkj instanceof kd))) {
              localkj.b(paramje, paramiu);
            }
          }
        }
        else
        {
          localkj = b();
          if ((localkj != null) && ((localkj instanceof kd))) {
            localkj.b(paramje, paramiu);
          }
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public void a(E paramE)
  {
    try
    {
      if (this.b == null) {
        this.b = new ArrayList();
      }
      this.b.add(paramE);
      return;
    }
    finally {}
  }
  
  public boolean a(iu paramiu, float paramFloat1, float paramFloat2)
  {
    if (this.b == null) {
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        ArrayList localArrayList = new ArrayList(this.b.size());
        localArrayList.addAll(this.b);
        int j = localArrayList.size();
        i = 0;
        if (i >= j) {
          break;
        }
        int k = (this.d + i + 1) % j;
        kj localkj = (kj)localArrayList.get(k);
        if (localkj.a(paramiu, paramFloat1, paramFloat2))
        {
          this.d = k;
          if (this.c != null) {
            this.c.a(this.a, localkj, k);
          }
          return true;
        }
      }
      finally {}
      i += 1;
    }
    return false;
  }
  
  /* Error */
  public E b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 34	com/tencent/tencentmap/mapsdk/a/ka:b	Ljava/util/ArrayList;
    //   6: ifnull +43 -> 49
    //   9: aload_0
    //   10: getfield 29	com/tencent/tencentmap/mapsdk/a/ka:e	I
    //   13: iflt +36 -> 49
    //   16: aload_0
    //   17: getfield 34	com/tencent/tencentmap/mapsdk/a/ka:b	Ljava/util/ArrayList;
    //   20: invokevirtual 39	java/util/ArrayList:size	()I
    //   23: aload_0
    //   24: getfield 29	com/tencent/tencentmap/mapsdk/a/ka:e	I
    //   27: if_icmple +22 -> 49
    //   30: aload_0
    //   31: getfield 34	com/tencent/tencentmap/mapsdk/a/ka:b	Ljava/util/ArrayList;
    //   34: aload_0
    //   35: getfield 29	com/tencent/tencentmap/mapsdk/a/ka:e	I
    //   38: invokevirtual 43	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   41: checkcast 7	com/tencent/tencentmap/mapsdk/a/kj
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: areturn
    //   49: aconst_null
    //   50: astore_1
    //   51: goto -6 -> 45
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	ka
    //   44	7	1	localkj	kj
    //   54	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	45	54	finally
  }
  
  public void b(je paramje, iu paramiu)
  {
    for (;;)
    {
      int i;
      try
      {
        int j = a();
        i = 0;
        int k = c();
        kj localkj;
        if (i < k)
        {
          if (j != i)
          {
            localkj = a(i);
            if ((localkj != null) && (!(localkj instanceof kd))) {
              localkj.b(paramje, paramiu);
            }
          }
        }
        else
        {
          localkj = b();
          if ((localkj != null) && (!(localkj instanceof kd))) {
            localkj.b(paramje, paramiu);
          }
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  /* Error */
  public boolean b(E paramE)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 34	com/tencent/tencentmap/mapsdk/a/ka:b	Ljava/util/ArrayList;
    //   6: ifnull +16 -> 22
    //   9: aload_0
    //   10: getfield 34	com/tencent/tencentmap/mapsdk/a/ka:b	Ljava/util/ArrayList;
    //   13: aload_1
    //   14: invokevirtual 114	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   17: istore_2
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_2
    //   21: ireturn
    //   22: iconst_0
    //   23: istore_2
    //   24: goto -6 -> 18
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	ka
    //   0	32	1	paramE	E
    //   17	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	18	27	finally
  }
  
  /* Error */
  public int c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 34	com/tencent/tencentmap/mapsdk/a/ka:b	Ljava/util/ArrayList;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +9 -> 17
    //   11: iconst_0
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 34	com/tencent/tencentmap/mapsdk/a/ka:b	Ljava/util/ArrayList;
    //   21: invokevirtual 39	java/util/ArrayList:size	()I
    //   24: istore_1
    //   25: goto -12 -> 13
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	ka
    //   12	13	1	i	int
    //   6	2	2	localArrayList	ArrayList
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   17	25	28	finally
  }
  
  public void d()
  {
    try
    {
      if (this.b != null) {
        this.b.clear();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ka
 * JD-Core Version:    0.7.0.1
 */