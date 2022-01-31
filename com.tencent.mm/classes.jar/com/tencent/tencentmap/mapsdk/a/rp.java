package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.Language;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.raster.model.Polygon;
import com.tencent.mapsdk.raster.model.PolygonOptions;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.tencentmap.mapsdk.map.CameraUpdate;
import com.tencent.tencentmap.mapsdk.map.CancelableCallback;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnErrorListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnIndoorStateChangeListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapCameraChangeListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLoadedListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapPoiClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerDraggedListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnScreenShotListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.TencentMapGestureListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class rp
  implements TencentMap
{
  private ah a;
  private HashMap<Integer, rl> b = new HashMap();
  private List<qf> c = new ArrayList();
  private boolean d = false;
  private qn e;
  
  public rp(ah paramah)
  {
    this.a = paramah;
  }
  
  private rl a(qf paramqf)
  {
    if (paramqf == null) {
      return null;
    }
    return (rl)this.b.get(Integer.valueOf(paramqf.c().hashCode()));
  }
  
  protected List<qf> a()
  {
    return this.c;
  }
  
  public Circle addCircle(CircleOptions paramCircleOptions)
  {
    if (this.a == null) {}
    while (paramCircleOptions == null) {
      return null;
    }
    return new rj(this.a.a(rq.a(paramCircleOptions)));
  }
  
  public Marker addMarker(MarkerOptions paramMarkerOptions)
  {
    if (this.a == null) {}
    while (paramMarkerOptions == null) {
      return null;
    }
    paramMarkerOptions = new rl(this, this.a.a(rq.a(paramMarkerOptions)));
    this.b.put(Integer.valueOf(paramMarkerOptions.getId().hashCode()), paramMarkerOptions);
    return paramMarkerOptions;
  }
  
  public Polygon addPolygon(PolygonOptions paramPolygonOptions)
  {
    if (this.a == null) {}
    while (paramPolygonOptions == null) {
      return null;
    }
    return new rn(this.a.a(rq.a(paramPolygonOptions)));
  }
  
  public Polyline addPolyline(PolylineOptions paramPolylineOptions)
  {
    if (this.a == null) {}
    while (paramPolylineOptions == null) {
      return null;
    }
    return new rm(this.a.a(rq.a(paramPolylineOptions)));
  }
  
  public void animateCamera(CameraUpdate paramCameraUpdate)
  {
    if (this.a == null) {}
    while (paramCameraUpdate == null) {
      return;
    }
    this.a.b(rq.a(paramCameraUpdate, this.a.t()));
  }
  
  public void animateCamera(CameraUpdate paramCameraUpdate, long paramLong, CancelableCallback paramCancelableCallback)
  {
    if (this.a == null) {}
    while (paramCameraUpdate == null) {
      return;
    }
    this.a.a(rq.a(paramCameraUpdate, this.a.t()), paramLong, new rp.11(this, paramCancelableCallback));
  }
  
  public void animateTo(LatLng paramLatLng)
  {
    if (this.a == null) {}
    while (paramLatLng == null) {
      return;
    }
    this.a.b(ad.a(rq.a(paramLatLng)));
  }
  
  public void animateTo(LatLng paramLatLng, long paramLong, CancelableCallback paramCancelableCallback)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(ad.a(rq.a(paramLatLng)), paramLong, new rp.10(this, paramCancelableCallback));
  }
  
  @Deprecated
  public void animateTo(LatLng paramLatLng, Runnable paramRunnable)
  {
    if (this.a == null) {}
    while (paramLatLng == null) {
      return;
    }
    this.a.a(ad.a(rq.a(paramLatLng)), new rp.1(this, paramRunnable));
  }
  
  public void clearAllOverlays()
  {
    if (this.a != null) {
      this.a.h();
    }
  }
  
  public boolean clearCache()
  {
    return false;
  }
  
  public void enableMultipleInfowindow(boolean paramBoolean)
  {
    if (this.a == null) {
      return;
    }
    this.a.h(paramBoolean);
  }
  
  public String getActivedIndoorBuilding(LatLng paramLatLng)
  {
    if (this.a == null) {
      return null;
    }
    return this.a.a(rq.a(paramLatLng));
  }
  
  public String[] getActivedIndoorFloorNames()
  {
    if (this.a == null) {
      return null;
    }
    return this.a.w();
  }
  
  public int getIndoorFloorId()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.v();
  }
  
  public LatLng getMapCenter()
  {
    if (this.a == null) {
      return null;
    }
    this.a.d();
    return rq.a(this.a.d().a);
  }
  
  public int getMaxZoomLevel()
  {
    if (this.a == null) {
      return 19;
    }
    return (int)this.a.e();
  }
  
  public int getMinZoomLevel()
  {
    if (this.a == null) {
      return 4;
    }
    return (int)this.a.f();
  }
  
  public void getScreenShot(TencentMap.OnScreenShotListener paramOnScreenShotListener)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(new rp.8(this, paramOnScreenShotListener));
  }
  
  @Deprecated
  public void getScreenShot(TencentMap.OnScreenShotListener paramOnScreenShotListener, Rect paramRect)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(new rp.9(this, paramOnScreenShotListener));
  }
  
  public String getVersion()
  {
    if (this.a == null) {
      return null;
    }
    return this.a.u();
  }
  
  public int getZoomLevel()
  {
    if (this.a == null) {
      return -1;
    }
    return (int)this.a.d().b + rq.a;
  }
  
  public boolean isAppKeyAvailable()
  {
    return true;
  }
  
  public boolean isHandDrawMapEnable()
  {
    if (this.a == null) {
      return false;
    }
    return this.a.x();
  }
  
  public boolean isSatelliteEnabled()
  {
    return this.d;
  }
  
  public boolean isTrafficEnabled()
  {
    if (this.a == null) {
      return false;
    }
    return this.a.i();
  }
  
  public void moveCamera(CameraUpdate paramCameraUpdate)
  {
    if (this.a == null) {}
    while (paramCameraUpdate == null) {
      return;
    }
    this.a.a(rq.a(paramCameraUpdate, this.a.t()));
  }
  
  public void removeTencentMapGestureListener(TencentMap.TencentMapGestureListener paramTencentMapGestureListener)
  {
    this.a.c(this.e);
  }
  
  public void scrollBy(float paramFloat1, float paramFloat2)
  {
    if (this.a == null) {
      return;
    }
    this.a.b(ad.a(paramFloat1, paramFloat2));
  }
  
  public void scrollBy(float paramFloat1, float paramFloat2, long paramLong, CancelableCallback paramCancelableCallback)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(ad.a(paramFloat1, paramFloat2), new rp.12(this, paramCancelableCallback));
  }
  
  public void set3DEnable(boolean paramBoolean)
  {
    if (this.a == null) {
      return;
    }
    this.a.e(paramBoolean);
  }
  
  public void setCenter(LatLng paramLatLng)
  {
    if (this.a == null) {}
    while (paramLatLng == null) {
      return;
    }
    this.a.a(ad.a(new qc(paramLatLng.getLatitude(), paramLatLng.getLongitude())));
  }
  
  @Deprecated
  public void setErrorListener(TencentMap.OnErrorListener paramOnErrorListener)
  {
    if (this.a == null) {}
  }
  
  public void setForeignLanguage(Language paramLanguage)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(rq.a(paramLanguage));
  }
  
  public void setHandDrawMapEnable(boolean paramBoolean)
  {
    if (this.a == null) {
      return;
    }
    this.a.g(paramBoolean);
  }
  
  public void setIndoorEnabled(boolean paramBoolean)
  {
    if (this.a == null) {
      return;
    }
    this.a.f(paramBoolean);
  }
  
  public void setIndoorFloor(int paramInt)
  {
    if (this.a == null) {
      return;
    }
    this.a.c(paramInt);
  }
  
  public void setIndoorFloor(String paramString1, String paramString2)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(paramString1, paramString2);
  }
  
  public void setInfoWindowAdapter(TencentMap.InfoWindowAdapter paramInfoWindowAdapter)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(new rp.13(this, paramInfoWindowAdapter));
  }
  
  public void setMapAnchor(float paramFloat1, float paramFloat2)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(paramFloat1, paramFloat2, false);
    this.a.l().i(true);
  }
  
  public void setMapStyle(int paramInt)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(paramInt);
  }
  
  public void setOnIndoorStateChangeListener(TencentMap.OnIndoorStateChangeListener paramOnIndoorStateChangeListener)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(new rp.6(this, paramOnIndoorStateChangeListener));
  }
  
  public void setOnInfoWindowClickListener(TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(new rp.16(this, paramOnInfoWindowClickListener));
  }
  
  public void setOnMapCameraChangeListener(TencentMap.OnMapCameraChangeListener paramOnMapCameraChangeListener)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(new rp.2(this, paramOnMapCameraChangeListener));
  }
  
  public void setOnMapClickListener(TencentMap.OnMapClickListener paramOnMapClickListener)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(new rp.3(this, paramOnMapClickListener));
  }
  
  public void setOnMapLoadedListener(TencentMap.OnMapLoadedListener paramOnMapLoadedListener)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(new rp.15(this, paramOnMapLoadedListener));
  }
  
  public void setOnMapLongClickListener(TencentMap.OnMapLongClickListener paramOnMapLongClickListener)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(new rp.4(this, paramOnMapLongClickListener));
  }
  
  public void setOnMapPoiClickListener(TencentMap.OnMapPoiClickListener paramOnMapPoiClickListener)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(new rp.5(this, paramOnMapPoiClickListener));
  }
  
  public void setOnMarkerClickListener(TencentMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(new rp.17(this, paramOnMarkerClickListener));
  }
  
  public void setOnMarkerDraggedListener(TencentMap.OnMarkerDraggedListener paramOnMarkerDraggedListener)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(new rp.14(this, paramOnMarkerDraggedListener));
  }
  
  public void setSatelliteEnabled(boolean paramBoolean)
  {
    if (this.a == null) {
      return;
    }
    this.d = paramBoolean;
    this.a.b(paramBoolean);
  }
  
  public void setTencentMapGestureListener(TencentMap.TencentMapGestureListener paramTencentMapGestureListener)
  {
    if ((this.a == null) || (paramTencentMapGestureListener == null)) {
      return;
    }
    if (this.e != null) {
      this.a.c(this.e);
    }
    this.e = new rp.7(this, paramTencentMapGestureListener);
    this.a.a(this.e);
  }
  
  public void setTrafficEnabled(boolean paramBoolean)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(paramBoolean);
  }
  
  public void setZoom(int paramInt)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(ad.a(paramInt - rq.a));
  }
  
  public void stopAnimation()
  {
    if (this.a == null) {
      return;
    }
    this.a.g();
  }
  
  public void zoomIn()
  {
    if (this.a == null) {
      return;
    }
    this.a.b(ad.a());
  }
  
  public void zoomInFixing(int paramInt1, int paramInt2)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(ad.a(1.0F, new Point(paramInt1, paramInt2)));
  }
  
  public void zoomOut()
  {
    if (this.a == null) {
      return;
    }
    this.a.b(ad.b());
  }
  
  public void zoomOutFixing(int paramInt1, int paramInt2)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(ad.a(-1.0F, new Point(paramInt1, paramInt2)));
  }
  
  public void zoomToSpan(double paramDouble1, double paramDouble2)
  {
    zoomToSpan(new LatLng(getMapCenter().getLatitude() - paramDouble1 / 2.0D, getMapCenter().getLongitude() + paramDouble2 / 2.0D), new LatLng(getMapCenter().getLatitude() + paramDouble1 / 2.0D, getMapCenter().getLongitude() - paramDouble2 / 2.0D));
  }
  
  public void zoomToSpan(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(ad.a(new qd(rq.a(paramLatLng1), rq.a(paramLatLng2)), 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.rp
 * JD-Core Version:    0.7.0.1
 */