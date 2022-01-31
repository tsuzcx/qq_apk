package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class ja
{
  private static double a(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    return (1.0D - paramFloat) * (1.0D - paramFloat) * paramInt1 + 2.0F * paramFloat * (1.0D - paramFloat) * paramInt2 + paramFloat * paramFloat * paramInt3;
  }
  
  private static double a(DoublePoint paramDoublePoint1, DoublePoint paramDoublePoint2)
  {
    AppMethodBeat.i(148674);
    double d1 = paramDoublePoint2.x - paramDoublePoint1.x;
    double d2 = paramDoublePoint2.y - paramDoublePoint1.y;
    d1 = Math.sqrt(d1 * d1 + d2 * d2);
    AppMethodBeat.o(148674);
    return d1;
  }
  
  private static float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    float f1 = (paramInt2 - paramInt1) * 3.0F;
    float f2 = (paramInt3 - paramInt2) * 3.0F - f1;
    float f3 = paramInt4 - paramInt1;
    float f4 = paramFloat * paramFloat;
    return f1 * paramFloat + (f2 * f4 + (f3 - f1 - f2) * (f4 * paramFloat)) + paramInt1;
  }
  
  public static int a(List<GeoPoint> paramList, int[] paramArrayOfInt, hu paramhu)
  {
    AppMethodBeat.i(148671);
    if (paramList == null)
    {
      AppMethodBeat.o(148671);
      return 0;
    }
    int k = paramList.size();
    if (k < 2)
    {
      AppMethodBeat.o(148671);
      return 0;
    }
    int i = 0;
    int j = 0;
    while (i < k - 1)
    {
      GeoPoint localGeoPoint1 = (GeoPoint)paramList.get(i);
      GeoPoint localGeoPoint2 = (GeoPoint)paramList.get(i + 1);
      double d = a(paramhu.b(localGeoPoint1), paramhu.b(localGeoPoint2));
      int m = (int)d / 500;
      m = (int)d / Math.max(4, m * 4);
      paramArrayOfInt[i] = m;
      j += m;
      i += 1;
    }
    AppMethodBeat.o(148671);
    return j;
  }
  
  private static GeoPoint a(List<GeoPoint> paramList, float paramFloat)
  {
    AppMethodBeat.i(148673);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(148673);
      return null;
    }
    int i = paramList.size();
    if ((i != 3) && (i != 4))
    {
      AppMethodBeat.o(148673);
      return null;
    }
    if (i == 3)
    {
      localGeoPoint1 = (GeoPoint)paramList.get(0);
      localGeoPoint2 = (GeoPoint)paramList.get(1);
      paramList = (GeoPoint)paramList.get(2);
      if ((localGeoPoint1 == null) || (localGeoPoint2 == null) || (paramList == null))
      {
        AppMethodBeat.o(148673);
        return null;
      }
      i = (int)a(localGeoPoint1.getLongitudeE6(), localGeoPoint2.getLongitudeE6(), paramList.getLongitudeE6(), paramFloat);
      paramList = new GeoPoint((int)a(localGeoPoint1.getLatitudeE6(), localGeoPoint2.getLatitudeE6(), paramList.getLatitudeE6(), paramFloat), i);
      AppMethodBeat.o(148673);
      return paramList;
    }
    GeoPoint localGeoPoint1 = (GeoPoint)paramList.get(0);
    GeoPoint localGeoPoint2 = (GeoPoint)paramList.get(1);
    GeoPoint localGeoPoint3 = (GeoPoint)paramList.get(2);
    paramList = (GeoPoint)paramList.get(3);
    if ((localGeoPoint1 == null) || (localGeoPoint2 == null) || (localGeoPoint3 == null) || (paramList == null))
    {
      AppMethodBeat.o(148673);
      return null;
    }
    i = (int)a(localGeoPoint1.getLongitudeE6(), localGeoPoint2.getLongitudeE6(), localGeoPoint3.getLongitudeE6(), paramList.getLongitudeE6(), paramFloat);
    paramList = new GeoPoint((int)a(localGeoPoint1.getLatitudeE6(), localGeoPoint2.getLatitudeE6(), localGeoPoint3.getLatitudeE6(), paramList.getLatitudeE6(), paramFloat), i);
    AppMethodBeat.o(148673);
    return paramList;
  }
  
  public static List<GeoPoint> a(List<GeoPoint> paramList, int paramInt)
  {
    AppMethodBeat.i(148672);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(148672);
      return null;
    }
    int m = paramList.size();
    ArrayList localArrayList = new ArrayList(paramInt);
    GeoPoint localGeoPoint1 = (GeoPoint)paramList.get(0);
    GeoPoint localGeoPoint2 = (GeoPoint)paramList.get(m - 1);
    int j = (localGeoPoint1.getLongitudeE6() + localGeoPoint2.getLongitudeE6()) / 2;
    int k = (localGeoPoint1.getLatitudeE6() + localGeoPoint2.getLatitudeE6()) / 2;
    int i = 0;
    while (i < m)
    {
      localGeoPoint1 = (GeoPoint)paramList.get(i);
      localGeoPoint1.setLongitudeE6(localGeoPoint1.getLongitudeE6() - j);
      localGeoPoint1.setLatitudeE6(localGeoPoint1.getLatitudeE6() - k);
      i += 1;
    }
    float f2 = 1.0F / (paramInt + 1);
    i = 0;
    float f1 = f2;
    while (i < paramInt)
    {
      localGeoPoint1 = a(paramList, f1);
      localGeoPoint1.setLongitudeE6(localGeoPoint1.getLongitudeE6() + j);
      localGeoPoint1.setLatitudeE6(localGeoPoint1.getLatitudeE6() + k);
      localArrayList.add(localGeoPoint1);
      f1 += f2;
      i += 1;
    }
    AppMethodBeat.o(148672);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ja
 * JD-Core Version:    0.7.0.1
 */