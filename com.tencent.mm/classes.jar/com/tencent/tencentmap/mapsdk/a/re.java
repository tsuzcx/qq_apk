package com.tencent.tencentmap.mapsdk.a;

import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.Language;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.raster.model.PolygonOptions;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.mapsdk.raster.model.VisibleRegion;
import com.tencent.tencentmap.mapsdk.map.CameraParameter;
import com.tencent.tencentmap.mapsdk.map.CameraUpdate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class re
{
  public static float a(float paramFloat)
  {
    return paramFloat;
  }
  
  public static CameraPosition a(ru paramru)
  {
    if (paramru == null) {
      return null;
    }
    return new CameraPosition(a(paramru.b()), b(paramru.c()));
  }
  
  public static LatLng a(ry paramry)
  {
    if (paramry == null) {
      return null;
    }
    return new LatLng(paramry.b(), paramry.c());
  }
  
  static LatLngBounds a(rz paramrz)
  {
    if ((paramrz == null) || (paramrz.c() == null) || (paramrz.b() == null)) {
      return null;
    }
    return new LatLngBounds(new LatLng(paramrz.b().b(), paramrz.b().c()), new LatLng(paramrz.c().b(), paramrz.c().c()));
  }
  
  public static VisibleRegion a(sl paramsl)
  {
    if (paramsl == null) {
      return null;
    }
    return new VisibleRegion(a(paramsl.a()), a(paramsl.b()), a(paramsl.c()), a(paramsl.d()), a(paramsl.e()));
  }
  
  public static ru a(CameraPosition paramCameraPosition)
  {
    if (paramCameraPosition == null) {
      return null;
    }
    return new ru(a(paramCameraPosition.getTarget()), a(paramCameraPosition.getZoom()));
  }
  
  public static rw a(CircleOptions paramCircleOptions)
  {
    Object localObject;
    if (paramCircleOptions == null) {
      localObject = null;
    }
    rw localrw;
    do
    {
      return localObject;
      localrw = new rw();
      localObject = a(paramCircleOptions.getCenter());
      if (localObject != null) {
        localrw.a((ry)localObject);
      }
      localrw.a(a(paramCircleOptions.getCenter())).b(paramCircleOptions.getFillColor()).a(paramCircleOptions.getRadius()).a(paramCircleOptions.getStrokeColor()).a(paramCircleOptions.getStrokeWidth()).a(paramCircleOptions.isVisible()).b((int)paramCircleOptions.getZIndex()).b(paramCircleOptions.getStrokeDash());
      localObject = localrw;
    } while (paramCircleOptions.getStrokeDashPathEffect() == null);
    localrw.a(paramCircleOptions.getStrokeDashPathEffect());
    return localrw;
  }
  
  public static ry a(LatLng paramLatLng)
  {
    if (paramLatLng == null) {
      return null;
    }
    return new ry(paramLatLng.getLatitude(), paramLatLng.getLongitude());
  }
  
  static rz a(LatLngBounds paramLatLngBounds)
  {
    if ((paramLatLngBounds == null) || (paramLatLngBounds.getNortheast() == null) || (paramLatLngBounds.getSouthwest() == null)) {
      return null;
    }
    return new rz(new ry(paramLatLngBounds.getSouthwest().getLatitude(), paramLatLngBounds.getSouthwest().getLongitude()), new ry(paramLatLngBounds.getNortheast().getLatitude(), paramLatLngBounds.getNortheast().getLongitude()));
  }
  
  public static sb a(MarkerOptions paramMarkerOptions)
  {
    Object localObject1 = null;
    if (paramMarkerOptions == null) {}
    Object localObject2;
    do
    {
      do
      {
        return localObject1;
        localObject2 = a(paramMarkerOptions.getPosition());
      } while (localObject2 == null);
      localObject2 = new sb().a((ry)localObject2);
      ((sb)localObject2).a(paramMarkerOptions.getAlpha()).b(paramMarkerOptions.isVisible()).a(paramMarkerOptions.isDraggable()).a(paramMarkerOptions.getAnchorU(), paramMarkerOptions.getAnchorV()).b(paramMarkerOptions.getRotation());
      if (paramMarkerOptions.getIcon() != null) {
        ((sb)localObject2).a(rt.a(paramMarkerOptions.getIcon().getBitmap()));
      }
      if (paramMarkerOptions.getMarkerView() != null) {
        ((sb)localObject2).a(paramMarkerOptions.getMarkerView());
      }
      if (paramMarkerOptions.getSnippet() != null) {
        ((sb)localObject2).b(paramMarkerOptions.getSnippet());
      }
      if (paramMarkerOptions.getTitle() != null) {
        ((sb)localObject2).a(paramMarkerOptions.getTitle());
      }
      if (paramMarkerOptions.getInfoWindowHideAnimation() != null) {
        ((sb)localObject2).d(paramMarkerOptions.getInfoWindowHideAnimation());
      }
      if (paramMarkerOptions.getInfoWindowShowAnimation() != null) {
        ((sb)localObject2).a(paramMarkerOptions.getInfoWindowShowAnimation());
      }
      if (paramMarkerOptions.getShowingAnination() != null) {
        ((sb)localObject2).b(paramMarkerOptions.getShowingAnination());
      }
      if (paramMarkerOptions.getHidingAnination() != null) {
        ((sb)localObject2).c(paramMarkerOptions.getHidingAnination());
      }
      localObject1 = localObject2;
    } while (paramMarkerOptions.getTag() == null);
    ((sb)localObject2).a(paramMarkerOptions.getTag());
    return localObject2;
  }
  
  public static sd a(PolygonOptions paramPolygonOptions)
  {
    if (paramPolygonOptions == null) {}
    sd localsd;
    List localList;
    do
    {
      return null;
      localsd = new sd();
      localList = b(paramPolygonOptions.getPoints());
    } while ((localList == null) || (localList.size() <= 2));
    localsd.a(localList);
    localsd.a(paramPolygonOptions.isVisible()).b((int)paramPolygonOptions.getZIndex()).a(paramPolygonOptions.getStrokeWidth()).a(paramPolygonOptions.getStrokeColor()).b(paramPolygonOptions.getFillColor());
    return localsd;
  }
  
  public static sf a(PolylineOptions paramPolylineOptions)
  {
    float f1 = 2.0F;
    if (paramPolylineOptions == null) {}
    sf localsf;
    List localList;
    do
    {
      return null;
      localsf = new sf();
      localList = b(paramPolylineOptions.getPoints());
    } while ((localList == null) || (localList.size() == 0));
    localsf.a(localList);
    float f3 = paramPolylineOptions.getWidth();
    float f2 = paramPolylineOptions.getEdgeWidth();
    if (f2 > 0.0F) {
      if (f3 > 2.0F * f2) {
        f1 = f3 - 2.0F * f2;
      }
    }
    for (;;)
    {
      localsf.d((int)paramPolylineOptions.getZIndex()).c(f1).a(paramPolylineOptions.isVisible()).b(paramPolylineOptions.getColor()).b(f2).a(paramPolylineOptions.getEdgeColor()).b(paramPolylineOptions.isGeodesic()).c(paramPolylineOptions.isDottedLine());
      if (paramPolylineOptions.getArrowTexture() != null)
      {
        localsf.a(new rs(paramPolylineOptions.getArrowTexture().getBitmap()));
        localsf.a(paramPolylineOptions.getArrowGap());
      }
      return localsf;
      f2 = f3 / 2.0F - 1.0F;
      continue;
      f1 = f3;
    }
  }
  
  public static sg a(Language paramLanguage)
  {
    if (paramLanguage == null) {
      return sg.a;
    }
    switch (re.1.a[paramLanguage.ordinal()])
    {
    default: 
      return sg.a;
    case 1: 
      return sg.a;
    }
    return sg.b;
  }
  
  static ut a(CameraUpdate paramCameraUpdate)
  {
    if ((paramCameraUpdate == null) || (paramCameraUpdate.getParams() == null)) {
      return null;
    }
    CameraParameter localCameraParameter = paramCameraUpdate.getParams();
    switch (paramCameraUpdate.getParams().cameraUpdate_type)
    {
    default: 
      return null;
    case 0: 
      return uu.a();
    case 6: 
      return uu.a(a(localCameraParameter.newCameraPosition));
    case 7: 
      return uu.a(a(localCameraParameter.newLatLng));
    case 9: 
      return uu.a(a(localCameraParameter.newLatLngBounds_bounds), localCameraParameter.newLatLngBounds_padding);
    case 10: 
      return uu.a(a(localCameraParameter.newLatLngBounds_dimension_bounds), localCameraParameter.newLatLngBounds_dimension_width, localCameraParameter.newLatLngBounds_dimension_height, localCameraParameter.newLatLngBounds_dimension_padding);
    case 8: 
      return uu.a(a(localCameraParameter.newLatLngZoom_latlng), a(localCameraParameter.newLatLngZoom_zoom));
    case 2: 
      return uu.a(localCameraParameter.scrollBy_xPixel, localCameraParameter.scrollBy_yPixel);
    case 5: 
      return uu.a(localCameraParameter.zoomBy_Point_amount, localCameraParameter.zoomBy_Point_focus);
    case 4: 
      return uu.b(localCameraParameter.zoomBy_amount);
    case 1: 
      return uu.b();
    }
    return uu.a(a(localCameraParameter.zoomTo_zoom));
  }
  
  public static List<LatLng> a(List<ry> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((ry)paramList.next()));
    }
    return localArrayList;
  }
  
  public static float b(float paramFloat)
  {
    return paramFloat;
  }
  
  public static List<ry> b(List<LatLng> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((LatLng)paramList.next()));
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.re
 * JD-Core Version:    0.7.0.1
 */