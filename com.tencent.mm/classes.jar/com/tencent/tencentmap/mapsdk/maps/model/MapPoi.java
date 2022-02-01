package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MapPoi
{
  private double latitude;
  private double longitude;
  public String name;
  public LatLng position;
  
  public MapPoi() {}
  
  public MapPoi(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(193609);
    this.latitude = paramDouble1;
    this.longitude = paramDouble2;
    this.position = new LatLng(paramDouble1, paramDouble2);
    AppMethodBeat.o(193609);
  }
  
  public MapPoi(double paramDouble1, double paramDouble2, String paramString)
  {
    this(paramDouble1, paramDouble2);
    this.name = paramString;
  }
  
  public double getLatitude()
  {
    return this.latitude;
  }
  
  public double getLongitude()
  {
    return this.longitude;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public LatLng getPosition()
  {
    return this.position;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setPosition(LatLng paramLatLng)
  {
    AppMethodBeat.i(193610);
    this.position = paramLatLng;
    this.latitude = paramLatLng.getLatitude();
    this.longitude = paramLatLng.getLongitude();
    AppMethodBeat.o(193610);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.MapPoi
 * JD-Core Version:    0.7.0.1
 */