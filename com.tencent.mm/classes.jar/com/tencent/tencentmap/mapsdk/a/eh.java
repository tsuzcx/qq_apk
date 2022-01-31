package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.IndoorBuilding;
import com.tencent.mapsdk.raster.model.IndoorInfo;
import com.tencent.mapsdk.raster.model.IndoorLevel;
import com.tencent.mapsdk.raster.model.IndoorMapPoi;
import com.tencent.mapsdk.raster.model.Language;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.MapPoi;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.raster.model.PolygonOptions;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.mapsdk.raster.model.VisibleRegion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.CameraParameter;
import com.tencent.tencentmap.mapsdk.map.CameraUpdate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class eh
{
  public static float a(float paramFloat)
  {
    return paramFloat;
  }
  
  public static CameraPosition a(cn paramcn)
  {
    AppMethodBeat.i(150300);
    if (paramcn == null)
    {
      AppMethodBeat.o(150300);
      return null;
    }
    paramcn = new CameraPosition(a(paramcn.a), b(paramcn.b), paramcn.c, paramcn.d);
    AppMethodBeat.o(150300);
    return paramcn;
  }
  
  static IndoorBuilding a(cu paramcu)
  {
    AppMethodBeat.i(150309);
    if (paramcu == null)
    {
      AppMethodBeat.o(150309);
      return null;
    }
    List localList = c(paramcu.c());
    if (localList == null)
    {
      AppMethodBeat.o(150309);
      return null;
    }
    paramcu = new IndoorBuilding(paramcu.a(), paramcu.b(), localList, paramcu.d());
    AppMethodBeat.o(150309);
    return paramcu;
  }
  
  public static LatLng a(cz paramcz)
  {
    AppMethodBeat.i(150295);
    if (paramcz == null)
    {
      AppMethodBeat.o(150295);
      return null;
    }
    paramcz = new LatLng(paramcz.a, paramcz.b);
    AppMethodBeat.o(150295);
    return paramcz;
  }
  
  static LatLngBounds a(da paramda)
  {
    AppMethodBeat.i(150303);
    if ((paramda == null) || (paramda.b == null) || (paramda.a == null))
    {
      AppMethodBeat.o(150303);
      return null;
    }
    paramda = new LatLngBounds(new LatLng(paramda.a.a, paramda.a.b), new LatLng(paramda.b.a, paramda.b.b));
    AppMethodBeat.o(150303);
    return paramda;
  }
  
  public static MapPoi a(db paramdb)
  {
    AppMethodBeat.i(150296);
    if (paramdb == null)
    {
      AppMethodBeat.o(150296);
      return null;
    }
    if ((paramdb instanceof cx))
    {
      paramdb = (cx)paramdb;
      paramdb = new IndoorMapPoi(paramdb.d(), a(paramdb.e()), paramdb.a(), paramdb.b(), paramdb.c());
      AppMethodBeat.o(150296);
      return paramdb;
    }
    paramdb = new MapPoi(paramdb.d(), a(paramdb.e()));
    AppMethodBeat.o(150296);
    return paramdb;
  }
  
  public static VisibleRegion a(dm paramdm)
  {
    AppMethodBeat.i(150301);
    if (paramdm == null)
    {
      AppMethodBeat.o(150301);
      return null;
    }
    paramdm = new VisibleRegion(a(paramdm.a), a(paramdm.b), a(paramdm.c), a(paramdm.d), a(paramdm.e));
    AppMethodBeat.o(150301);
    return paramdm;
  }
  
  static ab a(CameraUpdate paramCameraUpdate, ah paramah)
  {
    AppMethodBeat.i(150308);
    if ((paramCameraUpdate == null) || (paramCameraUpdate.getParams() == null))
    {
      AppMethodBeat.o(150308);
      return null;
    }
    CameraParameter localCameraParameter = paramCameraUpdate.getParams();
    int j;
    int i;
    int m;
    int k;
    switch (paramCameraUpdate.getParams().cameraUpdate_type)
    {
    default: 
      AppMethodBeat.o(150308);
      return null;
    case 6: 
      paramCameraUpdate = ac.a(a(localCameraParameter.newCameraPosition));
      AppMethodBeat.o(150308);
      return paramCameraUpdate;
    case 7: 
      paramCameraUpdate = ac.a(a(localCameraParameter.newLatLng));
      AppMethodBeat.o(150308);
      return paramCameraUpdate;
    case 9: 
      paramCameraUpdate = ac.a(a(localCameraParameter.newLatLngBounds_bounds), localCameraParameter.newLatLngBounds_padding, localCameraParameter.newLatLngBounds_padding, localCameraParameter.newLatLngBounds_padding, localCameraParameter.newLatLngBounds_padding);
      AppMethodBeat.o(150308);
      return paramCameraUpdate;
    case 10: 
      if ((paramah != null) && (paramah.x() != 0) && (paramah.x() != 0)) {
        if (localCameraParameter.newLatLngBounds_dimension_width < paramah.x())
        {
          j = paramah.x() / 2 - (localCameraParameter.newLatLngBounds_dimension_width / 2 - localCameraParameter.newLatLngBounds_dimension_padding);
          i = j;
          if (localCameraParameter.newLatLngBounds_dimension_height < paramah.y())
          {
            m = paramah.y() / 2 - (localCameraParameter.newLatLngBounds_dimension_height / 2 - localCameraParameter.newLatLngBounds_dimension_padding);
            k = m;
          }
        }
      }
      break;
    }
    for (;;)
    {
      paramCameraUpdate = ac.a(a(localCameraParameter.newLatLngBounds_dimension_bounds), i, j, m, k);
      AppMethodBeat.o(150308);
      return paramCameraUpdate;
      paramCameraUpdate = ac.a(a(localCameraParameter.newLatLngZoom_latlng), a(localCameraParameter.newLatLngZoom_zoom));
      AppMethodBeat.o(150308);
      return paramCameraUpdate;
      paramCameraUpdate = ac.a(localCameraParameter.scrollBy_xPixel, localCameraParameter.scrollBy_yPixel);
      AppMethodBeat.o(150308);
      return paramCameraUpdate;
      paramCameraUpdate = ac.a(localCameraParameter.zoomBy_Point_amount, localCameraParameter.zoomBy_Point_focus);
      AppMethodBeat.o(150308);
      return paramCameraUpdate;
      paramCameraUpdate = ac.b(localCameraParameter.zoomBy_amount);
      AppMethodBeat.o(150308);
      return paramCameraUpdate;
      paramCameraUpdate = ac.a();
      AppMethodBeat.o(150308);
      return paramCameraUpdate;
      paramCameraUpdate = ac.b();
      AppMethodBeat.o(150308);
      return paramCameraUpdate;
      float f;
      if (localCameraParameter.zoomTo_zoom < paramah.f()) {
        f = paramah.f();
      }
      for (;;)
      {
        paramCameraUpdate = ac.a(a(f));
        AppMethodBeat.o(150308);
        return paramCameraUpdate;
        if (localCameraParameter.zoomTo_zoom > paramah.e()) {
          f = paramah.e();
        } else {
          f = localCameraParameter.zoomTo_zoom;
        }
      }
      paramCameraUpdate = ac.a(a(localCameraParameter.newLatLngBounds_bounds), a(localCameraParameter.newLatLng), localCameraParameter.newLatLngBounds_padding);
      AppMethodBeat.o(150308);
      return paramCameraUpdate;
      k = 0;
      m = 0;
      continue;
      i = 0;
      j = 0;
      break;
      k = 0;
      i = 0;
      m = 0;
      j = 0;
    }
  }
  
  public static cn a(CameraPosition paramCameraPosition)
  {
    AppMethodBeat.i(150299);
    if (paramCameraPosition == null)
    {
      AppMethodBeat.o(150299);
      return null;
    }
    paramCameraPosition = new cn(a(paramCameraPosition.getTarget()), a(paramCameraPosition.getZoom()), paramCameraPosition.getSkew(), paramCameraPosition.getBearing());
    AppMethodBeat.o(150299);
    return paramCameraPosition;
  }
  
  public static cp a(CircleOptions paramCircleOptions)
  {
    AppMethodBeat.i(150304);
    if (paramCircleOptions == null)
    {
      AppMethodBeat.o(150304);
      return null;
    }
    cp localcp = new cp();
    cz localcz = a(paramCircleOptions.getCenter());
    if (localcz != null) {
      localcp.a(localcz);
    }
    localcp.a(a(paramCircleOptions.getCenter())).b(paramCircleOptions.getFillColor()).a(paramCircleOptions.getRadius()).a(paramCircleOptions.getStrokeColor()).a(paramCircleOptions.getStrokeWidth() / w.g()).a(paramCircleOptions.isVisible()).c((int)paramCircleOptions.getZIndex()).d(paramCircleOptions.getLevel());
    AppMethodBeat.o(150304);
    return localcp;
  }
  
  static cv a(IndoorInfo paramIndoorInfo)
  {
    AppMethodBeat.i(150310);
    if (paramIndoorInfo == null)
    {
      AppMethodBeat.o(150310);
      return null;
    }
    paramIndoorInfo = new cv(paramIndoorInfo.getBuildingId(), paramIndoorInfo.getFloorName());
    AppMethodBeat.o(150310);
    return paramIndoorInfo;
  }
  
  public static cy a(Language paramLanguage)
  {
    AppMethodBeat.i(150312);
    if (paramLanguage == null)
    {
      paramLanguage = cy.a;
      AppMethodBeat.o(150312);
      return paramLanguage;
    }
    switch (eh.1.a[paramLanguage.ordinal()])
    {
    default: 
      paramLanguage = cy.a;
      AppMethodBeat.o(150312);
      return paramLanguage;
    case 1: 
      paramLanguage = cy.a;
      AppMethodBeat.o(150312);
      return paramLanguage;
    }
    paramLanguage = cy.b;
    AppMethodBeat.o(150312);
    return paramLanguage;
  }
  
  public static cz a(LatLng paramLatLng)
  {
    AppMethodBeat.i(150294);
    if (paramLatLng == null)
    {
      AppMethodBeat.o(150294);
      return null;
    }
    paramLatLng = new cz(paramLatLng.getLatitude(), paramLatLng.getLongitude());
    AppMethodBeat.o(150294);
    return paramLatLng;
  }
  
  static da a(LatLngBounds paramLatLngBounds)
  {
    AppMethodBeat.i(150302);
    if ((paramLatLngBounds == null) || (paramLatLngBounds.getNortheast() == null) || (paramLatLngBounds.getSouthwest() == null))
    {
      AppMethodBeat.o(150302);
      return null;
    }
    paramLatLngBounds = new da(new cz(paramLatLngBounds.getSouthwest().getLatitude(), paramLatLngBounds.getSouthwest().getLongitude()), new cz(paramLatLngBounds.getNortheast().getLatitude(), paramLatLngBounds.getNortheast().getLongitude()));
    AppMethodBeat.o(150302);
    return paramLatLngBounds;
  }
  
  public static dd a(MarkerOptions paramMarkerOptions)
  {
    AppMethodBeat.i(150305);
    if (paramMarkerOptions == null)
    {
      AppMethodBeat.o(150305);
      return null;
    }
    Object localObject = a(paramMarkerOptions.getPosition());
    if (localObject == null)
    {
      AppMethodBeat.o(150305);
      return null;
    }
    localObject = new dd((cz)localObject);
    dd localdd = ((dd)localObject).b(paramMarkerOptions.getAlpha()).b(paramMarkerOptions.isVisible()).a(paramMarkerOptions.isDraggable()).a(paramMarkerOptions.getAnchorU(), paramMarkerOptions.getAnchorV()).a(paramMarkerOptions.getRotation()).a(a(paramMarkerOptions.getIndoorInfo())).c(paramMarkerOptions.getZIndex()).a(paramMarkerOptions.getLevel()).c(paramMarkerOptions.isFlat());
    if (paramMarkerOptions.isFlat() != paramMarkerOptions.isClockwise()) {}
    for (boolean bool = true;; bool = false)
    {
      localdd.d(bool).a(paramMarkerOptions.getInfoWindowOffsetX(), paramMarkerOptions.getInfowindowOffsetY()).c(paramMarkerOptions.getContentDescription());
      if (paramMarkerOptions.getIcon() != null) {
        ((dd)localObject).a(cl.a(paramMarkerOptions.getIcon().getBitmap()));
      }
      if (paramMarkerOptions.getMarkerView() != null) {
        ((dd)localObject).a(cl.a(paramMarkerOptions.getMarkerView()));
      }
      if (paramMarkerOptions.getSnippet() != null) {
        ((dd)localObject).b(paramMarkerOptions.getSnippet());
      }
      if (paramMarkerOptions.getTitle() != null) {
        ((dd)localObject).a(paramMarkerOptions.getTitle());
      }
      if (paramMarkerOptions.getTag() != null) {
        ((dd)localObject).a(paramMarkerOptions.getTag());
      }
      AppMethodBeat.o(150305);
      return localObject;
    }
  }
  
  public static di a(PolygonOptions paramPolygonOptions)
  {
    AppMethodBeat.i(150307);
    if (paramPolygonOptions == null)
    {
      AppMethodBeat.o(150307);
      return null;
    }
    di localdi = new di();
    List localList = b(paramPolygonOptions.getPoints());
    if ((localList != null) && (localList.size() > 2))
    {
      localdi.b(localList);
      localdi.a(paramPolygonOptions.isVisible()).c((int)paramPolygonOptions.getZIndex()).d(paramPolygonOptions.getLevel()).a(paramPolygonOptions.getStrokeWidth() / w.g()).a(paramPolygonOptions.getStrokeColor()).b(paramPolygonOptions.getFillColor());
      AppMethodBeat.o(150307);
      return localdi;
    }
    AppMethodBeat.o(150307);
    return null;
  }
  
  public static dk a(PolylineOptions paramPolylineOptions)
  {
    AppMethodBeat.i(150306);
    if (paramPolylineOptions == null)
    {
      AppMethodBeat.o(150306);
      return null;
    }
    dk localdk = new dk();
    Object localObject = b(paramPolylineOptions.getPoints());
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      AppMethodBeat.o(150306);
      return null;
    }
    localdk.a((Iterable)localObject);
    float f = paramPolylineOptions.getWidth();
    localdk.d((int)paramPolylineOptions.getZIndex()).f(paramPolylineOptions.getLevel()).a(f).a(paramPolylineOptions.isVisible()).a(paramPolylineOptions.getColor()).b(paramPolylineOptions.getEdgeColor()).b(paramPolylineOptions.getEdgeWidth()).e(paramPolylineOptions.getLineType()).c(paramPolylineOptions.getEraseColor()).a(a(paramPolylineOptions.getIndoorInfo()));
    if (paramPolylineOptions.getColorTexture() != null) {
      localdk.a(cl.a(paramPolylineOptions.getColorTexture().getBitmap()));
    }
    if (paramPolylineOptions.getArrowTexture() != null)
    {
      localdk.b(true);
      localdk.g((int)paramPolylineOptions.getArrowGap());
      localObject = new Matrix();
      ((Matrix)localObject).postRotate(-90.0F);
    }
    try
    {
      Bitmap localBitmap = paramPolylineOptions.getArrowTexture().getBitmap();
      localBitmap = Bitmap.createScaledBitmap(localBitmap, localBitmap.getWidth(), localBitmap.getHeight(), true);
      localdk.b(cl.a(Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), (Matrix)localObject, true)));
      label254:
      if (paramPolylineOptions.isDottedLine())
      {
        localObject = new ArrayList();
        ((List)localObject).add(Integer.valueOf((int)(3.0F * paramPolylineOptions.getWidth())));
        ((List)localObject).add(Integer.valueOf((int)paramPolylineOptions.getWidth()));
        localdk.c((List)localObject);
      }
      AppMethodBeat.o(150306);
      return localdk;
    }
    catch (Exception localException)
    {
      break label254;
    }
  }
  
  public static List<LatLng> a(List<cz> paramList)
  {
    AppMethodBeat.i(150297);
    if (paramList == null)
    {
      AppMethodBeat.o(150297);
      return null;
    }
    paramList = (cz[])paramList.toArray(new cz[paramList.size()]);
    ArrayList localArrayList = new ArrayList();
    int j = paramList.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(a(paramList[i]));
      i += 1;
    }
    AppMethodBeat.o(150297);
    return localArrayList;
  }
  
  public static float b(float paramFloat)
  {
    return paramFloat;
  }
  
  public static List<cz> b(List<LatLng> paramList)
  {
    AppMethodBeat.i(150298);
    if (paramList == null)
    {
      AppMethodBeat.o(150298);
      return null;
    }
    paramList = (LatLng[])paramList.toArray(new LatLng[paramList.size()]);
    ArrayList localArrayList = new ArrayList();
    int j = paramList.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(a(paramList[i]));
      i += 1;
    }
    AppMethodBeat.o(150298);
    return localArrayList;
  }
  
  static List<IndoorLevel> c(List<cw> paramList)
  {
    AppMethodBeat.i(150311);
    if (paramList == null)
    {
      AppMethodBeat.o(150311);
      return null;
    }
    Object localObject = new CopyOnWriteArrayList(paramList);
    paramList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      cw localcw = (cw)((Iterator)localObject).next();
      if (localcw == null)
      {
        AppMethodBeat.o(150311);
        return null;
      }
      paramList.add(new IndoorLevel(localcw.a()));
    }
    AppMethodBeat.o(150311);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.eh
 * JD-Core Version:    0.7.0.1
 */