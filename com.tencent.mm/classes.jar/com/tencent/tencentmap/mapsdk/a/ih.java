package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.basemap.data.GeoPoint;

public class ih
{
  private static ih a;
  private StringBuffer b = new StringBuffer();
  private String c = "";
  private String d = "";
  
  public static ih a()
  {
    if (a == null) {
      a = new ih();
    }
    return a;
  }
  
  public void a(int paramInt)
  {
    this.c = ("####ClearCacheStatus: " + paramInt);
  }
  
  public void a(jo paramjo)
  {
    if (paramjo == null) {
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    GeoPoint localGeoPoint = paramjo.o();
    if (localGeoPoint != null) {
      localStringBuffer.append("####mapCenter x: " + localGeoPoint.getLatitudeE6() + "  y: " + localGeoPoint.getLongitudeE6());
    }
    localStringBuffer.append("  mapScale: " + paramjo.i());
    localStringBuffer.append("  mapSkew: " + paramjo.d());
    localStringBuffer.append("  mapRotate: " + paramjo.c());
    this.d = localStringBuffer.toString();
  }
  
  public void a(String paramString)
  {
    if (this.b == null) {
      this.b = new StringBuffer();
    }
    this.b.append("####");
    this.b.append(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ih
 * JD-Core Version:    0.7.0.1
 */