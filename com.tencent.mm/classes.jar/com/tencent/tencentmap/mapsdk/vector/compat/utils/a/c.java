package com.tencent.tencentmap.mapsdk.vector.compat.utils.a;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c
{
  public static double a = 6378137.0D;
  final double b;
  
  public c()
  {
    AppMethodBeat.i(193063);
    this.b = (6.283185307179586D * a);
    AppMethodBeat.o(193063);
  }
  
  public c(double paramDouble)
  {
    this.b = paramDouble;
  }
  
  public double a(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    AppMethodBeat.i(193066);
    double d4 = paramLatLng1.getLongitude();
    double d3 = paramLatLng1.getLatitude();
    double d2 = paramLatLng2.getLongitude();
    double d1 = paramLatLng2.getLatitude();
    double d5 = d4 * 0.01745329251994329D;
    double d6 = d3 * 0.01745329251994329D;
    d3 = d2 * 0.01745329251994329D;
    d4 = d1 * 0.01745329251994329D;
    d1 = Math.sin(d5);
    d2 = Math.sin(d6);
    d5 = Math.cos(d5);
    d6 = Math.cos(d6);
    double d7 = Math.sin(d3);
    double d8 = Math.sin(d4);
    d3 = Math.cos(d3);
    d4 = Math.cos(d4);
    paramLatLng1 = new double[3];
    paramLatLng2 = new double[3];
    paramLatLng1[0] = (d5 * d6);
    paramLatLng1[1] = (d6 * d1);
    paramLatLng1[2] = d2;
    paramLatLng2[0] = (d4 * d3);
    paramLatLng2[1] = (d4 * d7);
    paramLatLng2[2] = d8;
    d1 = Math.asin(Math.sqrt((paramLatLng1[0] - paramLatLng2[0]) * (paramLatLng1[0] - paramLatLng2[0]) + (paramLatLng1[1] - paramLatLng2[1]) * (paramLatLng1[1] - paramLatLng2[1]) + (paramLatLng1[2] - paramLatLng2[2]) * (paramLatLng1[2] - paramLatLng2[2])) / 2.0D);
    d2 = this.b;
    AppMethodBeat.o(193066);
    return d1 * d2 * 3.141592653589793D;
  }
  
  public LatLng a(b paramb)
  {
    AppMethodBeat.i(193065);
    double d = paramb.a / this.b;
    paramb = new LatLng(90.0D - Math.toDegrees(Math.atan(Math.exp(-(0.5D - paramb.b / this.b) * 2.0D * 3.141592653589793D)) * 2.0D), (d - 0.5D) * 360.0D);
    AppMethodBeat.o(193065);
    return paramb;
  }
  
  public b a(LatLng paramLatLng)
  {
    AppMethodBeat.i(193064);
    double d1 = paramLatLng.getLongitude() / 360.0D;
    double d2 = Math.sin(Math.toRadians(paramLatLng.getLatitude()));
    d2 = Math.log((1.0D + d2) / (1.0D - d2)) * 0.5D / -6.283185307179586D;
    paramLatLng = new b((d1 + 0.5D) * this.b, (d2 + 0.5D) * this.b);
    AppMethodBeat.o(193064);
    return paramLatLng;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.a.c
 * JD-Core Version:    0.7.0.1
 */