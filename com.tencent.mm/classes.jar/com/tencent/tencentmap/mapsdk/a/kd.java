package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.util.StringUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class kd
  implements kj
{
  private ik a;
  private ke b;
  private int[] c;
  private int[] d;
  private int e;
  private GeoPoint f;
  private boolean g = true;
  private int h = -1;
  private kd.a i;
  private float j = -1.0F;
  private int k = -1;
  
  public kd(ke paramke)
  {
    a(paramke);
  }
  
  private void a(je paramje, iu paramiu)
  {
    if (this.b == null) {}
    label7:
    List localList;
    ArrayList localArrayList1;
    int i1;
    int[] arrayOfInt;
    int m;
    do
    {
      do
      {
        do
        {
          break label7;
          do
          {
            return;
          } while ((this.b.r != 2) && (this.b.r != 3));
          localList = this.b.q;
        } while ((localList == null) || (localList.isEmpty()));
        localArrayList1 = this.b.a;
      } while ((localArrayList1 == null) || (localArrayList1.size() < 2));
      i1 = localArrayList1.size();
      arrayOfInt = new int[i1 - 1];
      m = 0;
      while (m < i1 - 1)
      {
        arrayOfInt[m] = 0;
        m += 1;
      }
      m = kq.a(localArrayList1, arrayOfInt, paramiu);
    } while (m <= 0);
    paramiu = new ArrayList(m + i1);
    ArrayList localArrayList2;
    int n;
    Object localObject;
    GeoPoint localGeoPoint1;
    GeoPoint localGeoPoint2;
    if (this.b.r == 2)
    {
      localArrayList2 = new ArrayList(3);
      n = localList.size();
      m = 0;
      while ((m < i1 - 1) && (m < n))
      {
        localObject = new GeoPoint((GeoPoint)localArrayList1.get(m));
        localGeoPoint1 = new GeoPoint((GeoPoint)localList.get(m));
        localGeoPoint2 = new GeoPoint((GeoPoint)localArrayList1.get(m + 1));
        paramiu.add(localArrayList1.get(m));
        localArrayList2.clear();
        localArrayList2.add(localObject);
        localArrayList2.add(localGeoPoint1);
        localArrayList2.add(localGeoPoint2);
        if (arrayOfInt[m] > 0)
        {
          localObject = kq.a(localArrayList2, arrayOfInt[m]);
          if ((localObject != null) && (!((List)localObject).isEmpty())) {
            paramiu.addAll((Collection)localObject);
          }
        }
        m += 1;
      }
      paramiu.add(localArrayList1.get(i1 - 1));
    }
    for (;;)
    {
      if (this.h != -1) {
        paramje.a(this.h);
      }
      this.b.b = paramiu;
      return;
      localArrayList2 = new ArrayList(4);
      n = 0;
      int i2 = localList.size();
      m = 0;
      while ((n < i1 - 1) && (m < i2))
      {
        localObject = new GeoPoint((GeoPoint)localArrayList1.get(n));
        localGeoPoint1 = new GeoPoint((GeoPoint)localList.get(m));
        localGeoPoint2 = new GeoPoint((GeoPoint)localList.get(m + 1));
        GeoPoint localGeoPoint3 = new GeoPoint((GeoPoint)localArrayList1.get(n + 1));
        paramiu.add(localArrayList1.get(n));
        localArrayList2.clear();
        localArrayList2.add(localObject);
        localArrayList2.add(localGeoPoint1);
        localArrayList2.add(localGeoPoint2);
        localArrayList2.add(localGeoPoint3);
        if (arrayOfInt[n] > 0)
        {
          localObject = kq.a(localArrayList2, arrayOfInt[n]);
          if ((localObject != null) && (!((List)localObject).isEmpty())) {
            paramiu.addAll((Collection)localObject);
          }
        }
        n += 1;
        m += 2;
      }
      paramiu.add(localArrayList1.get(i1 - 1));
    }
  }
  
  public Rect a(iu paramiu)
  {
    if ((this.b == null) || (this.b.b == null)) {
      return null;
    }
    paramiu = this.b.b.iterator();
    int m = 2147483647;
    int i2 = 2147483647;
    int i1 = -2147483648;
    int n = -2147483648;
    int i5;
    int i3;
    if (paramiu.hasNext())
    {
      GeoPoint localGeoPoint = (GeoPoint)paramiu.next();
      i5 = localGeoPoint.getLatitudeE6();
      i3 = localGeoPoint.getLongitudeE6();
      if (i5 <= n) {
        break label154;
      }
      n = i5;
    }
    label154:
    for (;;)
    {
      int i4 = i2;
      if (i5 < i2) {
        i4 = i5;
      }
      i5 = i1;
      if (i3 > i1) {
        i5 = i3;
      }
      if (i3 < m) {
        m = i3;
      }
      for (;;)
      {
        i2 = i4;
        i1 = i5;
        break;
        return new Rect(m, n, i1, i2);
      }
    }
  }
  
  public ArrayList<GeoPoint> a()
  {
    return this.b.b;
  }
  
  public void a(float paramFloat)
  {
    this.b.j = paramFloat;
  }
  
  public final void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(ke paramke)
  {
    if (paramke == null) {
      try
      {
        throw new IllegalArgumentException("LineOptions不能为空！");
      }
      finally {}
    }
    if ((paramke.b == null) || (paramke.b.size() < 2)) {
      throw new IllegalArgumentException("LineOptions中点的个数不能小于2");
    }
    if ((paramke.c == null) || (paramke.c.length <= 0)) {
      throw new IllegalArgumentException("参数startIndexes不能为空!");
    }
    if ((paramke.d == null) || (paramke.d.length <= 0)) {
      throw new IllegalArgumentException("参数colors不能为空!");
    }
    this.b = paramke;
    this.c = paramke.c;
    this.d = paramke.d;
    this.h = -1;
  }
  
  /* Error */
  public boolean a(iu paramiu, float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 164	com/tencent/tencentmap/mapsdk/a/kd:a	Lcom/tencent/tencentmap/mapsdk/a/ik;
    //   9: astore_1
    //   10: aload_1
    //   11: ifnonnull +12 -> 23
    //   14: iload 6
    //   16: istore 5
    //   18: aload_0
    //   19: monitorexit
    //   20: iload 5
    //   22: ireturn
    //   23: aload_0
    //   24: getfield 164	com/tencent/tencentmap/mapsdk/a/kd:a	Lcom/tencent/tencentmap/mapsdk/a/ik;
    //   27: invokeinterface 169 1 0
    //   32: fload_2
    //   33: fload_3
    //   34: invokevirtual 174	com/tencent/tencentmap/mapsdk/a/jc:a	(FF)Lcom/tencent/map/lib/mapstructure/TappedElement;
    //   37: astore_1
    //   38: iload 6
    //   40: istore 5
    //   42: aload_1
    //   43: ifnull -25 -> 18
    //   46: aload_1
    //   47: getfield 180	com/tencent/map/lib/mapstructure/TappedElement:itemId	J
    //   50: lstore 7
    //   52: aload_0
    //   53: invokevirtual 183	com/tencent/tencentmap/mapsdk/a/kd:x	()I
    //   56: istore 4
    //   58: iload 6
    //   60: istore 5
    //   62: lload 7
    //   64: iload 4
    //   66: i2l
    //   67: lcmp
    //   68: ifne -50 -> 18
    //   71: iconst_1
    //   72: istore 5
    //   74: goto -56 -> 18
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	kd
    //   0	82	1	paramiu	iu
    //   0	82	2	paramFloat1	float
    //   0	82	3	paramFloat2	float
    //   56	9	4	m	int
    //   16	57	5	bool1	boolean
    //   1	58	6	bool2	boolean
    //   50	13	7	l	long
    // Exception table:
    //   from	to	target	type
    //   5	10	77	finally
    //   23	38	77	finally
    //   46	58	77	finally
  }
  
  public void b(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void b(je paramje, iu paramiu)
  {
    if (paramje == null) {}
    for (;;)
    {
      return;
      try
      {
        this.a = paramje.b();
        float f1 = paramje.d();
        if ((this.j == -1.0F) || (this.j != f1))
        {
          this.j = f1;
          a(paramje, paramiu);
        }
        paramje.a(this);
      }
      finally {}
    }
  }
  
  public int[] b()
  {
    return this.c;
  }
  
  public int[] c()
  {
    return this.d;
  }
  
  public boolean d()
  {
    return this.b.h;
  }
  
  public int[] e()
  {
    return this.b.e;
  }
  
  public int[] f()
  {
    return this.b.f;
  }
  
  public float g()
  {
    return this.b.g;
  }
  
  public GeoPoint h()
  {
    return this.f;
  }
  
  public int i()
  {
    return this.e;
  }
  
  public boolean j()
  {
    return this.b.i;
  }
  
  public boolean k()
  {
    return this.b.l;
  }
  
  public boolean l()
  {
    return this.b.n;
  }
  
  public int m()
  {
    return this.b.a();
  }
  
  public float n()
  {
    return this.b.j;
  }
  
  public float o()
  {
    if (this.b == null) {
      return 1.0F;
    }
    return this.b.m;
  }
  
  public kd.a p()
  {
    try
    {
      kd.a locala = this.i;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String q()
  {
    if ((this.b.d != null) && (this.b.d.length > 0))
    {
      if (this.b.d[0] == 33) {
        return "color_point_texture.png";
      }
      if (this.b.d[0] == 20) {
        return "color_texture_line_v2.png";
      }
    }
    if (StringUtil.isEmpty(this.b.k)) {
      return "color_texture_flat_style.png";
    }
    return this.b.k;
  }
  
  public final int r()
  {
    return this.h;
  }
  
  public boolean s()
  {
    return this.b.s;
  }
  
  public int t()
  {
    return this.b.u;
  }
  
  public String u()
  {
    return this.b.v;
  }
  
  public float v()
  {
    return this.b.b();
  }
  
  public int[] w()
  {
    return new int[] { this.b.x, this.b.y };
  }
  
  public int x()
  {
    return this.k;
  }
  
  public List<Integer> y()
  {
    return this.b.z;
  }
  
  public void z()
  {
    this.k = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.kd
 * JD-Core Version:    0.7.0.1
 */