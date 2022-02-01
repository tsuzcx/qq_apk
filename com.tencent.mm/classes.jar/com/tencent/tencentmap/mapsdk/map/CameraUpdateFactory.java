package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Point;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class CameraUpdateFactory
{
  public static CameraUpdate newCameraPosition(CameraPosition paramCameraPosition)
  {
    AppMethodBeat.i(87504);
    CameraParameter localCameraParameter = new CameraParameter();
    localCameraParameter.cameraUpdate_type = 6;
    localCameraParameter.newCameraPosition = paramCameraPosition;
    paramCameraPosition = new CameraUpdate(localCameraParameter);
    AppMethodBeat.o(87504);
    return paramCameraPosition;
  }
  
  public static CameraUpdate newLatLng(LatLng paramLatLng)
  {
    AppMethodBeat.i(87505);
    CameraParameter localCameraParameter = new CameraParameter();
    localCameraParameter.cameraUpdate_type = 7;
    localCameraParameter.newLatLng = paramLatLng;
    paramLatLng = new CameraUpdate(localCameraParameter);
    AppMethodBeat.o(87505);
    return paramLatLng;
  }
  
  public static CameraUpdate newLatLngBounds(LatLngBounds paramLatLngBounds, int paramInt)
  {
    AppMethodBeat.i(87507);
    CameraParameter localCameraParameter = new CameraParameter();
    localCameraParameter.cameraUpdate_type = 9;
    localCameraParameter.newLatLngBounds_bounds = paramLatLngBounds;
    localCameraParameter.newLatLngBounds_padding = paramInt;
    paramLatLngBounds = new CameraUpdate(localCameraParameter);
    AppMethodBeat.o(87507);
    return paramLatLngBounds;
  }
  
  public static CameraUpdate newLatLngBounds(LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(87508);
    CameraParameter localCameraParameter = new CameraParameter();
    localCameraParameter.cameraUpdate_type = 10;
    localCameraParameter.newLatLngBounds_dimension_bounds = paramLatLngBounds;
    localCameraParameter.newLatLngBounds_dimension_width = paramInt1;
    localCameraParameter.newLatLngBounds_dimension_height = paramInt2;
    localCameraParameter.newLatLngBounds_dimension_padding = paramInt3;
    paramLatLngBounds = new CameraUpdate(localCameraParameter);
    AppMethodBeat.o(87508);
    return paramLatLngBounds;
  }
  
  public static CameraUpdate newLatLngBounds(LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(173712);
    CameraParameter localCameraParameter = new CameraParameter();
    localCameraParameter.cameraUpdate_type = 12;
    localCameraParameter.newLatLngBounds_dimension_bounds = paramLatLngBounds;
    localCameraParameter.newLatLngBoundsRects_padLeft = paramInt1;
    localCameraParameter.newLatLngBoundsRects_padRight = paramInt2;
    localCameraParameter.newLatLngBoundsRects_padTop = paramInt3;
    localCameraParameter.newLatLngBoundsRects_padBom = paramInt4;
    paramLatLngBounds = new CameraUpdate(localCameraParameter);
    AppMethodBeat.o(173712);
    return paramLatLngBounds;
  }
  
  public static CameraUpdate newLatLngBoundsWithMapCenter(LatLngBounds paramLatLngBounds, LatLng paramLatLng, int paramInt)
  {
    AppMethodBeat.i(87509);
    CameraParameter localCameraParameter = new CameraParameter();
    localCameraParameter.cameraUpdate_type = 11;
    localCameraParameter.newLatLngBounds_bounds = paramLatLngBounds;
    localCameraParameter.newLatLng = paramLatLng;
    localCameraParameter.newLatLngBounds_padding = paramInt;
    paramLatLngBounds = new CameraUpdate(localCameraParameter);
    AppMethodBeat.o(87509);
    return paramLatLngBounds;
  }
  
  public static CameraUpdate newLatLngZoom(LatLng paramLatLng, float paramFloat)
  {
    AppMethodBeat.i(87506);
    CameraParameter localCameraParameter = new CameraParameter();
    localCameraParameter.cameraUpdate_type = 8;
    localCameraParameter.newLatLngZoom_latlng = paramLatLng;
    localCameraParameter.newLatLngZoom_zoom = paramFloat;
    paramLatLng = new CameraUpdate(localCameraParameter);
    AppMethodBeat.o(87506);
    return paramLatLng;
  }
  
  public static CameraUpdate scrollBy(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(87500);
    Object localObject = new CameraParameter();
    ((CameraParameter)localObject).cameraUpdate_type = 2;
    ((CameraParameter)localObject).scrollBy_xPixel = paramFloat1;
    ((CameraParameter)localObject).scrollBy_yPixel = paramFloat2;
    localObject = new CameraUpdate((CameraParameter)localObject);
    AppMethodBeat.o(87500);
    return localObject;
  }
  
  public static CameraUpdate zoomBy(float paramFloat)
  {
    AppMethodBeat.i(87502);
    Object localObject = new CameraParameter();
    ((CameraParameter)localObject).cameraUpdate_type = 4;
    ((CameraParameter)localObject).zoomBy_amount = paramFloat;
    localObject = new CameraUpdate((CameraParameter)localObject);
    AppMethodBeat.o(87502);
    return localObject;
  }
  
  public static CameraUpdate zoomBy(float paramFloat, Point paramPoint)
  {
    AppMethodBeat.i(87503);
    CameraParameter localCameraParameter = new CameraParameter();
    localCameraParameter.cameraUpdate_type = 5;
    localCameraParameter.zoomBy_Point_amount = paramFloat;
    localCameraParameter.zoomBy_Point_focus = paramPoint;
    paramPoint = new CameraUpdate(localCameraParameter);
    AppMethodBeat.o(87503);
    return paramPoint;
  }
  
  public static CameraUpdate zoomIn()
  {
    AppMethodBeat.i(87498);
    Object localObject = new CameraParameter();
    ((CameraParameter)localObject).cameraUpdate_type = 0;
    localObject = new CameraUpdate((CameraParameter)localObject);
    AppMethodBeat.o(87498);
    return localObject;
  }
  
  public static CameraUpdate zoomOut()
  {
    AppMethodBeat.i(87499);
    Object localObject = new CameraParameter();
    ((CameraParameter)localObject).cameraUpdate_type = 1;
    localObject = new CameraUpdate((CameraParameter)localObject);
    AppMethodBeat.o(87499);
    return localObject;
  }
  
  public static CameraUpdate zoomTo(float paramFloat)
  {
    AppMethodBeat.i(87501);
    Object localObject = new CameraParameter();
    ((CameraParameter)localObject).cameraUpdate_type = 3;
    ((CameraParameter)localObject).zoomTo_zoom = paramFloat;
    localObject = new CameraUpdate((CameraParameter)localObject);
    AppMethodBeat.o(87501);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.CameraUpdateFactory
 * JD-Core Version:    0.7.0.1
 */