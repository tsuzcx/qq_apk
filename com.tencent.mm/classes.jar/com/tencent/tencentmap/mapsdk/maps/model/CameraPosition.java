package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class CameraPosition
{
  public final float bearing;
  public LatLng target;
  public final float tilt;
  public final float zoom;
  
  CameraPosition(int paramInt, LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.target = paramLatLng;
    this.zoom = paramFloat1;
    this.tilt = paramFloat2;
    this.bearing = paramFloat3;
  }
  
  public CameraPosition(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this(1, paramLatLng, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public static Builder builder()
  {
    AppMethodBeat.i(173101);
    Builder localBuilder = new Builder();
    AppMethodBeat.o(173101);
    return localBuilder;
  }
  
  public static Builder builder(CameraPosition paramCameraPosition)
  {
    AppMethodBeat.i(173102);
    paramCameraPosition = new Builder(paramCameraPosition);
    AppMethodBeat.o(173102);
    return paramCameraPosition;
  }
  
  public static final CameraPosition fromLatLngZoom(LatLng paramLatLng, float paramFloat)
  {
    AppMethodBeat.i(173100);
    paramLatLng = new CameraPosition(paramLatLng, paramFloat, 0.0F, 0.0F);
    AppMethodBeat.o(173100);
    return paramLatLng;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(173103);
    if (this == paramObject)
    {
      AppMethodBeat.o(173103);
      return true;
    }
    if (!(paramObject instanceof CameraPosition))
    {
      AppMethodBeat.o(173103);
      return false;
    }
    paramObject = (CameraPosition)paramObject;
    if ((this.target.equals(paramObject.target)) && (Float.floatToIntBits(this.zoom) == Float.floatToIntBits(paramObject.zoom)) && (Float.floatToIntBits(this.tilt) == Float.floatToIntBits(paramObject.tilt)) && (Float.floatToIntBits(this.bearing) == Float.floatToIntBits(paramObject.bearing)))
    {
      AppMethodBeat.o(173103);
      return true;
    }
    AppMethodBeat.o(173103);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(173104);
    String str = "latlng:" + this.target.latitude + "," + this.target.longitude + ",zoom:" + this.zoom + ",tilt=" + this.tilt + ",bearing:" + this.bearing;
    AppMethodBeat.o(173104);
    return str;
  }
  
  public static final class Builder
  {
    private LatLng p;
    private float q;
    private float r = 1.4E-45F;
    private float s = 1.4E-45F;
    
    public Builder() {}
    
    public Builder(CameraPosition paramCameraPosition)
    {
      this.p = paramCameraPosition.target;
      this.q = paramCameraPosition.zoom;
      this.r = paramCameraPosition.tilt;
      this.s = paramCameraPosition.bearing;
    }
    
    public final Builder bearing(float paramFloat)
    {
      this.s = paramFloat;
      return this;
    }
    
    public final CameraPosition build()
    {
      AppMethodBeat.i(173099);
      CameraPosition localCameraPosition = new CameraPosition(this.p, this.q, this.r, this.s);
      AppMethodBeat.o(173099);
      return localCameraPosition;
    }
    
    public final Builder target(LatLng paramLatLng)
    {
      this.p = paramLatLng;
      return this;
    }
    
    public final Builder tilt(float paramFloat)
    {
      this.r = paramFloat;
      return this;
    }
    
    public final Builder zoom(float paramFloat)
    {
      this.q = paramFloat;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.CameraPosition
 * JD-Core Version:    0.7.0.1
 */