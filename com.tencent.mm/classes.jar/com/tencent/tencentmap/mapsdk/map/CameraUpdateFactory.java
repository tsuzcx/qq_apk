package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Point;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;

public final class CameraUpdateFactory
{
  public static CameraUpdate newCameraPosition(CameraPosition paramCameraPosition)
  {
    CameraParameter localCameraParameter = new CameraParameter();
    localCameraParameter.cameraUpdate_type = 6;
    localCameraParameter.newCameraPosition = paramCameraPosition;
    return new CameraUpdate(localCameraParameter);
  }
  
  public static CameraUpdate newLatLng(LatLng paramLatLng)
  {
    CameraParameter localCameraParameter = new CameraParameter();
    localCameraParameter.cameraUpdate_type = 7;
    localCameraParameter.newLatLng = paramLatLng;
    return new CameraUpdate(localCameraParameter);
  }
  
  public static CameraUpdate newLatLngBounds(LatLngBounds paramLatLngBounds, int paramInt)
  {
    CameraParameter localCameraParameter = new CameraParameter();
    localCameraParameter.cameraUpdate_type = 9;
    localCameraParameter.newLatLngBounds_bounds = paramLatLngBounds;
    localCameraParameter.newLatLngBounds_padding = paramInt;
    return new CameraUpdate(localCameraParameter);
  }
  
  public static CameraUpdate newLatLngBounds(LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2, int paramInt3)
  {
    CameraParameter localCameraParameter = new CameraParameter();
    localCameraParameter.cameraUpdate_type = 10;
    localCameraParameter.newLatLngBounds_dimension_bounds = paramLatLngBounds;
    localCameraParameter.newLatLngBounds_dimension_width = paramInt1;
    localCameraParameter.newLatLngBounds_dimension_height = paramInt2;
    localCameraParameter.newLatLngBounds_dimension_padding = paramInt3;
    return new CameraUpdate(localCameraParameter);
  }
  
  public static CameraUpdate newLatLngBoundsWithMapCenter(LatLngBounds paramLatLngBounds, LatLng paramLatLng, int paramInt)
  {
    CameraParameter localCameraParameter = new CameraParameter();
    localCameraParameter.cameraUpdate_type = 11;
    localCameraParameter.newLatLngBounds_bounds = paramLatLngBounds;
    localCameraParameter.newLatLng = paramLatLng;
    localCameraParameter.newLatLngBounds_padding = paramInt;
    return new CameraUpdate(localCameraParameter);
  }
  
  public static CameraUpdate newLatLngZoom(LatLng paramLatLng, float paramFloat)
  {
    CameraParameter localCameraParameter = new CameraParameter();
    localCameraParameter.cameraUpdate_type = 8;
    localCameraParameter.newLatLngZoom_latlng = paramLatLng;
    localCameraParameter.newLatLngZoom_zoom = paramFloat;
    return new CameraUpdate(localCameraParameter);
  }
  
  public static CameraUpdate scrollBy(float paramFloat1, float paramFloat2)
  {
    CameraParameter localCameraParameter = new CameraParameter();
    localCameraParameter.cameraUpdate_type = 2;
    localCameraParameter.scrollBy_xPixel = paramFloat1;
    localCameraParameter.scrollBy_yPixel = paramFloat2;
    return new CameraUpdate(localCameraParameter);
  }
  
  public static CameraUpdate zoomBy(float paramFloat)
  {
    CameraParameter localCameraParameter = new CameraParameter();
    localCameraParameter.cameraUpdate_type = 4;
    localCameraParameter.zoomBy_amount = paramFloat;
    return new CameraUpdate(localCameraParameter);
  }
  
  public static CameraUpdate zoomBy(float paramFloat, Point paramPoint)
  {
    CameraParameter localCameraParameter = new CameraParameter();
    localCameraParameter.cameraUpdate_type = 5;
    localCameraParameter.zoomBy_Point_amount = paramFloat;
    localCameraParameter.zoomBy_Point_focus = paramPoint;
    return new CameraUpdate(localCameraParameter);
  }
  
  public static CameraUpdate zoomIn()
  {
    CameraParameter localCameraParameter = new CameraParameter();
    localCameraParameter.cameraUpdate_type = 0;
    return new CameraUpdate(localCameraParameter);
  }
  
  public static CameraUpdate zoomOut()
  {
    CameraParameter localCameraParameter = new CameraParameter();
    localCameraParameter.cameraUpdate_type = 1;
    return new CameraUpdate(localCameraParameter);
  }
  
  public static CameraUpdate zoomTo(float paramFloat)
  {
    CameraParameter localCameraParameter = new CameraParameter();
    localCameraParameter.cameraUpdate_type = 3;
    localCameraParameter.zoomTo_zoom = paramFloat;
    return new CameraUpdate(localCameraParameter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.CameraUpdateFactory
 * JD-Core Version:    0.7.0.1
 */