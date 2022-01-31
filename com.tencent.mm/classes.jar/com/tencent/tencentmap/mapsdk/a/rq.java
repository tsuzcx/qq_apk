package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.IndoorBuilding;
import com.tencent.mapsdk.raster.model.IndoorInfo;
import com.tencent.mapsdk.raster.model.IndoorLevel;
import com.tencent.mapsdk.raster.model.Language;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.MapPoi;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.raster.model.PolygonOptions;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.mapsdk.raster.model.VisibleRegion;
import com.tencent.tencentmap.mapsdk.map.CameraParameter;
import com.tencent.tencentmap.mapsdk.map.CameraUpdate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class rq
{
  public static int a = 1;
  
  public static CameraPosition a(pu parampu)
  {
    if (parampu == null) {
      return null;
    }
    return new CameraPosition(a(parampu.a), c(parampu.b), parampu.c, parampu.d);
  }
  
  static IndoorBuilding a(py parampy)
  {
    if (parampy == null) {}
    List localList;
    do
    {
      return null;
      localList = c(parampy.c());
    } while (localList == null);
    return new IndoorBuilding(parampy.a(), parampy.b(), localList, parampy.d());
  }
  
  public static LatLng a(qc paramqc)
  {
    if (paramqc == null) {
      return null;
    }
    return new LatLng(paramqc.a, paramqc.b);
  }
  
  static LatLngBounds a(qd paramqd)
  {
    if ((paramqd == null) || (paramqd.b == null) || (paramqd.a == null)) {
      return null;
    }
    return new LatLngBounds(new LatLng(paramqd.a.a, paramqd.a.b), new LatLng(paramqd.b.a, paramqd.b.b));
  }
  
  public static MapPoi a(qe paramqe)
  {
    if (paramqe == null) {
      return null;
    }
    return new MapPoi(paramqe.a(), a(paramqe.b()));
  }
  
  public static VisibleRegion a(qo paramqo)
  {
    if (paramqo == null) {
      return null;
    }
    return new VisibleRegion(a(paramqo.a), a(paramqo.b), a(paramqo.c), a(paramqo.d), a(paramqo.e));
  }
  
  static ac a(CameraUpdate paramCameraUpdate, af paramaf)
  {
    if ((paramCameraUpdate == null) || (paramCameraUpdate.getParams() == null)) {
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
      return null;
    case 0: 
      return ad.a();
    case 6: 
      return ad.a(a(localCameraParameter.newCameraPosition));
    case 7: 
      return ad.a(a(localCameraParameter.newLatLng));
    case 9: 
      return ad.a(a(localCameraParameter.newLatLngBounds_bounds), localCameraParameter.newLatLngBounds_padding, localCameraParameter.newLatLngBounds_padding, localCameraParameter.newLatLngBounds_padding, localCameraParameter.newLatLngBounds_padding);
    case 10: 
      if ((paramaf != null) && (paramaf.getWidth() != 0) && (paramaf.getWidth() != 0)) {
        if (localCameraParameter.newLatLngBounds_dimension_width < paramaf.getWidth())
        {
          j = paramaf.getWidth() / 2 - (localCameraParameter.newLatLngBounds_dimension_width / 2 - localCameraParameter.newLatLngBounds_dimension_padding);
          i = j;
          if (localCameraParameter.newLatLngBounds_dimension_height < paramaf.getHeight())
          {
            m = paramaf.getHeight() / 2 - (localCameraParameter.newLatLngBounds_dimension_height / 2 - localCameraParameter.newLatLngBounds_dimension_padding);
            k = m;
          }
        }
      }
      break;
    }
    for (;;)
    {
      return ad.a(a(localCameraParameter.newLatLngBounds_dimension_bounds), i, j, m, k);
      return ad.a(a(localCameraParameter.newLatLngZoom_latlng), b(localCameraParameter.newLatLngZoom_zoom));
      return ad.a(localCameraParameter.scrollBy_xPixel, localCameraParameter.scrollBy_yPixel);
      return ad.a(localCameraParameter.zoomBy_Point_amount, localCameraParameter.zoomBy_Point_focus);
      return ad.b(localCameraParameter.zoomBy_amount);
      return ad.b();
      float f;
      if (localCameraParameter.zoomTo_zoom < paramaf.getMap().f()) {
        f = paramaf.getMap().f();
      }
      for (;;)
      {
        return ad.a(b(f));
        if (localCameraParameter.zoomTo_zoom > paramaf.getMap().e()) {
          f = paramaf.getMap().e();
        } else {
          f = localCameraParameter.zoomTo_zoom;
        }
      }
      return ad.a(a(localCameraParameter.newLatLngBounds_bounds), a(localCameraParameter.newLatLng), localCameraParameter.newLatLngBounds_padding);
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
  
  public static pu a(CameraPosition paramCameraPosition)
  {
    if (paramCameraPosition == null) {
      return null;
    }
    return new pu(a(paramCameraPosition.getTarget()), b(paramCameraPosition.getZoom()), paramCameraPosition.getSkew(), paramCameraPosition.getBearing());
  }
  
  public static pw a(CircleOptions paramCircleOptions)
  {
    if (paramCircleOptions == null) {
      return null;
    }
    pw localpw = new pw();
    qc localqc = a(paramCircleOptions.getCenter());
    if (localqc != null) {
      localpw.a(localqc);
    }
    localpw.a(a(paramCircleOptions.getCenter())).b(paramCircleOptions.getFillColor()).a(paramCircleOptions.getRadius()).a(paramCircleOptions.getStrokeColor()).a(paramCircleOptions.getStrokeWidth() / rk.a()).a(paramCircleOptions.isVisible()).c((int)paramCircleOptions.getZIndex());
    return localpw;
  }
  
  static pz a(IndoorInfo paramIndoorInfo)
  {
    if (paramIndoorInfo == null) {
      return null;
    }
    return new pz(paramIndoorInfo.getBuildingId(), paramIndoorInfo.getFloorName());
  }
  
  public static qb a(Language paramLanguage)
  {
    if (paramLanguage == null) {
      return qb.a;
    }
    switch (rq.1.a[paramLanguage.ordinal()])
    {
    default: 
      return qb.a;
    case 1: 
      return qb.a;
    }
    return qb.b;
  }
  
  public static qc a(LatLng paramLatLng)
  {
    if (paramLatLng == null) {
      return null;
    }
    return new qc(paramLatLng.getLatitude(), paramLatLng.getLongitude());
  }
  
  static qd a(LatLngBounds paramLatLngBounds)
  {
    if ((paramLatLngBounds == null) || (paramLatLngBounds.getNortheast() == null) || (paramLatLngBounds.getSouthwest() == null)) {
      return null;
    }
    return new qd(new qc(paramLatLngBounds.getSouthwest().getLatitude(), paramLatLngBounds.getSouthwest().getLongitude()), new qc(paramLatLngBounds.getNortheast().getLatitude(), paramLatLngBounds.getNortheast().getLongitude()));
  }
  
  public static qg a(MarkerOptions paramMarkerOptions)
  {
    if (paramMarkerOptions == null) {}
    do
    {
      return null;
      localObject = a(paramMarkerOptions.getPosition());
    } while (localObject == null);
    Object localObject = new qg((qc)localObject);
    qg localqg = ((qg)localObject).b(paramMarkerOptions.getAlpha()).b(paramMarkerOptions.isVisible()).a(paramMarkerOptions.isDraggable()).a(paramMarkerOptions.getAnchorU(), paramMarkerOptions.getAnchorV()).a(paramMarkerOptions.getRotation()).a(a(paramMarkerOptions.getIndoorInfo())).c(paramMarkerOptions.getZIndex()).c(paramMarkerOptions.isFlat());
    if (paramMarkerOptions.isFlat() != paramMarkerOptions.isClockwise()) {}
    for (boolean bool = true;; bool = false)
    {
      localqg.d(bool).a(paramMarkerOptions.getInfoWindowOffsetX(), paramMarkerOptions.getInfowindowOffsetY());
      if (paramMarkerOptions.getIcon() != null) {
        ((qg)localObject).a(ps.a(paramMarkerOptions.getIcon().getBitmap()));
      }
      if (paramMarkerOptions.getMarkerView() != null) {
        ((qg)localObject).a(ps.a(paramMarkerOptions.getMarkerView()));
      }
      if (paramMarkerOptions.getSnippet() != null) {
        ((qg)localObject).b(paramMarkerOptions.getSnippet());
      }
      if (paramMarkerOptions.getTitle() != null) {
        ((qg)localObject).a(paramMarkerOptions.getTitle());
      }
      if (paramMarkerOptions.getTag() != null) {
        ((qg)localObject).a(paramMarkerOptions.getTag());
      }
      return localObject;
    }
  }
  
  public static qj a(PolygonOptions paramPolygonOptions)
  {
    if (paramPolygonOptions == null) {}
    qj localqj;
    List localList;
    do
    {
      return null;
      localqj = new qj();
      localList = b(paramPolygonOptions.getPoints());
    } while ((localList == null) || (localList.size() <= 2));
    localqj.b(localList);
    localqj.a(paramPolygonOptions.isVisible()).c((int)paramPolygonOptions.getZIndex()).a(paramPolygonOptions.getStrokeWidth() / rk.a()).a(paramPolygonOptions.getStrokeColor()).b(paramPolygonOptions.getFillColor());
    return localqj;
  }
  
  public static ql a(PolylineOptions paramPolylineOptions)
  {
    if (paramPolylineOptions == null) {}
    ql localql;
    Object localObject;
    do
    {
      return null;
      localql = new ql();
      localObject = b(paramPolylineOptions.getPoints());
    } while ((localObject == null) || (((List)localObject).size() == 0));
    localql.a((Iterable)localObject);
    float f = paramPolylineOptions.getWidth();
    localql.c((int)paramPolylineOptions.getZIndex()).a(f).a(paramPolylineOptions.isVisible()).a(paramPolylineOptions.getColor()).b(paramPolylineOptions.getEdgeColor()).b(paramPolylineOptions.getEdgeWidth()).d(paramPolylineOptions.getLineType()).a(a(paramPolylineOptions.getIndoorInfo()));
    if (paramPolylineOptions.getColorTexture() != null) {
      localql.a(ps.a(paramPolylineOptions.getColorTexture().getBitmap()));
    }
    if (paramPolylineOptions.getArrowTexture() != null)
    {
      localql.b(true);
      localql.e((int)paramPolylineOptions.getArrowGap());
      localObject = new Matrix();
      ((Matrix)localObject).postRotate(-90.0F);
    }
    try
    {
      Bitmap localBitmap = paramPolylineOptions.getArrowTexture().getBitmap();
      localBitmap = Bitmap.createScaledBitmap(localBitmap, localBitmap.getWidth(), localBitmap.getHeight(), true);
      localql.b(ps.a(Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), (Matrix)localObject, true)));
      label220:
      if (paramPolylineOptions.isDottedLine())
      {
        localObject = new ArrayList();
        ((List)localObject).add(Integer.valueOf((int)(3.0F * paramPolylineOptions.getWidth())));
        ((List)localObject).add(Integer.valueOf((int)paramPolylineOptions.getWidth()));
        localql.c((List)localObject);
      }
      return localql;
    }
    catch (Exception localException)
    {
      break label220;
    }
  }
  
  public static List<LatLng> a(List<qc> paramList)
  {
    if (paramList == null) {
      return null;
    }
    paramList = (qc[])paramList.toArray(new qc[paramList.size()]);
    ArrayList localArrayList = new ArrayList();
    int j = paramList.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(a(paramList[i]));
      i += 1;
    }
    return localArrayList;
  }
  
  public static void a(float paramFloat)
  {
    a = (int)(paramFloat / 2.0F + 0.5D);
  }
  
  public static float b(float paramFloat)
  {
    return paramFloat - a;
  }
  
  public static List<qc> b(List<LatLng> paramList)
  {
    if (paramList == null) {
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
    return localArrayList;
  }
  
  public static float c(float paramFloat)
  {
    return a + paramFloat;
  }
  
  static List<IndoorLevel> c(List<qa> paramList)
  {
    if (paramList == null) {
      return null;
    }
    Object localObject = new CopyOnWriteArrayList(paramList);
    paramList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      qa localqa = (qa)((Iterator)localObject).next();
      if (localqa == null) {
        return null;
      }
      paramList.add(new IndoorLevel(localqa.a()));
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.rq
 * JD-Core Version:    0.7.0.1
 */