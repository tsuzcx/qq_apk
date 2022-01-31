package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.cq;
import com.tencent.tencentmap.mapsdk.a.cz;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class mz
  implements my
{
  static int b = 4;
  mk<Double, mu> a;
  double c;
  double d;
  private lu e;
  
  public mz(lu paramlu)
  {
    this.e = paramlu;
  }
  
  public List<ly> a(DoublePoint paramDoublePoint1, DoublePoint paramDoublePoint2, double paramDouble)
  {
    AppMethodBeat.i(149361);
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    int i = (int)(10.0D / paramDouble);
    paramDouble = -Math.log(paramDouble) / Math.log(2.0D);
    double d1 = (this.d - this.c) / 20.0D;
    paramDouble = (Math.pow(paramDouble, b) / Math.pow(21.0D, b - 1) - 0.2D) * d1 + this.c;
    if (paramDouble < this.c) {
      paramDouble = this.c;
    }
    for (;;)
    {
      if (this.a != null) {
        this.a.b(mv.a(paramDoublePoint1.x, paramDoublePoint2.y, paramDoublePoint2.x, paramDoublePoint1.y)).a(new mz.1(this, paramDouble, i, localHashMap, localArrayList));
      }
      AppMethodBeat.o(149361);
      return localArrayList;
    }
  }
  
  public void a(List<cq> paramList)
  {
    AppMethodBeat.i(149362);
    this.a = mk.a(22).b(32).a();
    this.c = 0.0D;
    this.d = 4.9E-324D;
    float[][] arrayOfFloat = (float[][])Array.newInstance(Float.TYPE, new int[] { 256, 256 });
    paramList = paramList.iterator();
    int j;
    while (paramList.hasNext())
    {
      Object localObject1 = (cq)paramList.next();
      Object localObject2 = ((cq)localObject1).b();
      localObject2 = new GeoPoint((int)(((cz)localObject2).a * 1000000.0D), (int)(((cz)localObject2).b * 1000000.0D));
      localObject2 = this.e.e().a((GeoPoint)localObject2);
      double d1 = ((cq)localObject1).a();
      this.a = this.a.a(Double.valueOf(d1), mu.a(((DoublePoint)localObject2).x, ((DoublePoint)localObject2).y));
      if (d1 > this.c) {
        this.c = d1;
      }
      i = (int)(((DoublePoint)localObject2).x / 1048576.0D);
      j = (int)(((DoublePoint)localObject2).y / 1048576.0D);
      localObject1 = arrayOfFloat[i];
      localObject1[j] = ((float)(d1 + localObject1[j]));
    }
    int i = 0;
    while (i < 256)
    {
      j = 0;
      while (j < 256)
      {
        if (arrayOfFloat[i][j] > this.d) {
          this.d = arrayOfFloat[i][j];
        }
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(149362);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.mz
 * JD-Core Version:    0.7.0.1
 */