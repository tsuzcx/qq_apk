package com.tencent.tencentmap.mapsdk.maps;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.CamerParameter;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.IOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds.Builder;
import java.util.ArrayList;
import java.util.List;

public final class CameraUpdateFactory
{
  private static LatLng getSymmetricPoint(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    AppMethodBeat.i(180985);
    paramLatLng1 = new LatLng(paramLatLng1.latitude * 2.0D - paramLatLng2.latitude, paramLatLng1.longitude * 2.0D - paramLatLng2.longitude);
    AppMethodBeat.o(180985);
    return paramLatLng1;
  }
  
  public static CameraUpdate newCameraPosition(CameraPosition paramCameraPosition)
  {
    AppMethodBeat.i(180977);
    CamerParameter localCamerParameter = new CamerParameter();
    localCamerParameter.iCamerType = CamerParameter.NEWCAMER_POSITION;
    localCamerParameter.newCameraPosition_cameraPosition = paramCameraPosition;
    paramCameraPosition = new CameraUpdate(localCamerParameter);
    AppMethodBeat.o(180977);
    return paramCameraPosition;
  }
  
  static CameraUpdate newElementBoundsRect(List<IOverlay> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(180982);
    CamerParameter localCamerParameter = new CamerParameter();
    localCamerParameter.iCamerType = CamerParameter.NEW_ELEMENTS_BOUNDS_RECT;
    localCamerParameter.elements = paramList;
    localCamerParameter.newLatLngBoundsRects_padLeft = paramInt1;
    localCamerParameter.newLatLngBoundsRects_padRight = paramInt2;
    localCamerParameter.newLatLngBoundsRects_padTop = paramInt3;
    localCamerParameter.newLatLngBoundsRects_padBom = paramInt4;
    paramList = new CameraUpdate(localCamerParameter);
    AppMethodBeat.o(180982);
    return paramList;
  }
  
  public static CameraUpdate newLatLng(LatLng paramLatLng)
  {
    AppMethodBeat.i(180978);
    CamerParameter localCamerParameter = new CamerParameter();
    localCamerParameter.iCamerType = CamerParameter.NEWLATLNG;
    localCamerParameter.newLatLng_latLng = paramLatLng;
    paramLatLng = new CameraUpdate(localCamerParameter);
    AppMethodBeat.o(180978);
    return paramLatLng;
  }
  
  public static CameraUpdate newLatLngBounds(LatLngBounds paramLatLngBounds, int paramInt)
  {
    AppMethodBeat.i(180980);
    CamerParameter localCamerParameter = new CamerParameter();
    localCamerParameter.iCamerType = CamerParameter.NEWLATLNG_BOUNDS;
    localCamerParameter.newLatLngBounds_bounds = paramLatLngBounds;
    localCamerParameter.newLatLngBounds_padding = paramInt;
    paramLatLngBounds = new CameraUpdate(localCamerParameter);
    AppMethodBeat.o(180980);
    return paramLatLngBounds;
  }
  
  public static CameraUpdate newLatLngBoundsRect(LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(180981);
    CamerParameter localCamerParameter = new CamerParameter();
    localCamerParameter.iCamerType = CamerParameter.NEWLATLNG_BOUNDS_RECT;
    localCamerParameter.newLatLngBounds_dimension_bounds = paramLatLngBounds;
    localCamerParameter.newLatLngBoundsRects_padLeft = paramInt1;
    localCamerParameter.newLatLngBoundsRects_padRight = paramInt2;
    localCamerParameter.newLatLngBoundsRects_padTop = paramInt3;
    localCamerParameter.newLatLngBoundsRects_padBom = paramInt4;
    paramLatLngBounds = new CameraUpdate(localCamerParameter);
    AppMethodBeat.o(180981);
    return paramLatLngBounds;
  }
  
  public static CameraUpdate newLatLngBoundsWithMapCenter(LatLngBounds paramLatLngBounds, LatLng paramLatLng, int paramInt)
  {
    AppMethodBeat.i(180984);
    if (paramLatLngBounds == null)
    {
      AppMethodBeat.o(180984);
      return null;
    }
    LatLng localLatLng1 = paramLatLngBounds.northeast;
    LatLng localLatLng2 = getSymmetricPoint(paramLatLng, localLatLng1);
    paramLatLngBounds = paramLatLngBounds.southwest;
    paramLatLng = getSymmetricPoint(paramLatLng, paramLatLngBounds);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localLatLng1);
    localArrayList.add(localLatLng2);
    localArrayList.add(paramLatLngBounds);
    localArrayList.add(paramLatLng);
    paramLatLngBounds = newLatLngBounds(new LatLngBounds.Builder().include(localArrayList).build(), paramInt);
    AppMethodBeat.o(180984);
    return paramLatLngBounds;
  }
  
  public static CameraUpdate newLatLngZoom(LatLng paramLatLng, float paramFloat)
  {
    AppMethodBeat.i(180979);
    CamerParameter localCamerParameter = new CamerParameter();
    localCamerParameter.iCamerType = CamerParameter.NEWLATLNG_ZOOM;
    localCamerParameter.newLatLngZoom_latLng = paramLatLng;
    localCamerParameter.newLatLngZoom_zoom = paramFloat;
    paramLatLng = new CameraUpdate(localCamerParameter);
    AppMethodBeat.o(180979);
    return paramLatLng;
  }
  
  public static CameraUpdate rotateTo(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(180983);
    Object localObject = new CamerParameter();
    ((CamerParameter)localObject).iCamerType = CamerParameter.ROTATETO;
    ((CamerParameter)localObject).rotateto_rotate = paramFloat1;
    ((CamerParameter)localObject).rotateto_skew = paramFloat2;
    localObject = new CameraUpdate((CamerParameter)localObject);
    AppMethodBeat.o(180983);
    return localObject;
  }
  
  public static CameraUpdate scrollBy(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(180973);
    Object localObject = new CamerParameter();
    ((CamerParameter)localObject).iCamerType = CamerParameter.SCROLLBY;
    ((CamerParameter)localObject).scrollBy_xPixel = paramFloat1;
    ((CamerParameter)localObject).scrollBy_yPixel = paramFloat2;
    localObject = new CameraUpdate((CamerParameter)localObject);
    AppMethodBeat.o(180973);
    return localObject;
  }
  
  public static CameraUpdate zoomBy(float paramFloat)
  {
    AppMethodBeat.i(180975);
    Object localObject = new CamerParameter();
    ((CamerParameter)localObject).iCamerType = CamerParameter.ZOOMBY;
    ((CamerParameter)localObject).zoomBy_amount = paramFloat;
    localObject = new CameraUpdate((CamerParameter)localObject);
    AppMethodBeat.o(180975);
    return localObject;
  }
  
  public static CameraUpdate zoomBy(float paramFloat, Point paramPoint)
  {
    AppMethodBeat.i(180976);
    CamerParameter localCamerParameter = new CamerParameter();
    localCamerParameter.iCamerType = CamerParameter.ZOOMBY_POINT;
    localCamerParameter.zoomBy_Point_amount = paramFloat;
    localCamerParameter.zoomBy_Point_focus = paramPoint;
    paramPoint = new CameraUpdate(localCamerParameter);
    AppMethodBeat.o(180976);
    return paramPoint;
  }
  
  public static CameraUpdate zoomIn()
  {
    AppMethodBeat.i(180971);
    Object localObject = new CamerParameter();
    ((CamerParameter)localObject).iCamerType = CamerParameter.ZOOMIN;
    localObject = new CameraUpdate((CamerParameter)localObject);
    AppMethodBeat.o(180971);
    return localObject;
  }
  
  public static CameraUpdate zoomOut()
  {
    AppMethodBeat.i(180972);
    Object localObject = new CamerParameter();
    ((CamerParameter)localObject).iCamerType = CamerParameter.ZOOMOUT;
    localObject = new CameraUpdate((CamerParameter)localObject);
    AppMethodBeat.o(180972);
    return localObject;
  }
  
  public static CameraUpdate zoomTo(float paramFloat)
  {
    AppMethodBeat.i(180974);
    Object localObject = new CamerParameter();
    ((CamerParameter)localObject).iCamerType = CamerParameter.ZOOMTO;
    ((CamerParameter)localObject).zoomTo_zoom = paramFloat;
    localObject = new CameraUpdate((CamerParameter)localObject);
    AppMethodBeat.o(180974);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory
 * JD-Core Version:    0.7.0.1
 */