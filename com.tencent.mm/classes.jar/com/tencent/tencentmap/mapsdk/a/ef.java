package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mapsdk.raster.model.CameraPosition;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
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

public class ef
  implements TencentMap
{
  private ah a;
  private HashMap<Integer, eb> b;
  private List<dc> c;
  private boolean d;
  private dl e;
  
  public ef(ah paramah)
  {
    AppMethodBeat.i(150232);
    this.b = new HashMap();
    this.c = new ArrayList();
    this.d = false;
    this.a = paramah;
    AppMethodBeat.o(150232);
  }
  
  private eb a(dc paramdc)
  {
    AppMethodBeat.i(150261);
    if (paramdc == null)
    {
      AppMethodBeat.o(150261);
      return null;
    }
    paramdc = (eb)this.b.get(Integer.valueOf(paramdc.c().hashCode()));
    AppMethodBeat.o(150261);
    return paramdc;
  }
  
  protected List<dc> a()
  {
    return this.c;
  }
  
  public Circle addCircle(CircleOptions paramCircleOptions)
  {
    AppMethodBeat.i(150235);
    if (this.a == null)
    {
      AppMethodBeat.o(150235);
      return null;
    }
    if (paramCircleOptions == null)
    {
      AppMethodBeat.o(150235);
      return null;
    }
    paramCircleOptions = new dz(this.a.a(eh.a(paramCircleOptions)));
    AppMethodBeat.o(150235);
    return paramCircleOptions;
  }
  
  public Marker addMarker(MarkerOptions paramMarkerOptions)
  {
    AppMethodBeat.i(150236);
    if (this.a == null)
    {
      AppMethodBeat.o(150236);
      return null;
    }
    if (paramMarkerOptions == null)
    {
      AppMethodBeat.o(150236);
      return null;
    }
    paramMarkerOptions = new eb(this, this.a.a(eh.a(paramMarkerOptions)));
    this.b.put(Integer.valueOf(paramMarkerOptions.getId().hashCode()), paramMarkerOptions);
    AppMethodBeat.o(150236);
    return paramMarkerOptions;
  }
  
  public Polygon addPolygon(PolygonOptions paramPolygonOptions)
  {
    AppMethodBeat.i(150238);
    if (this.a == null)
    {
      AppMethodBeat.o(150238);
      return null;
    }
    if (paramPolygonOptions == null)
    {
      AppMethodBeat.o(150238);
      return null;
    }
    paramPolygonOptions = new ed(this.a.a(eh.a(paramPolygonOptions)));
    AppMethodBeat.o(150238);
    return paramPolygonOptions;
  }
  
  public Polyline addPolyline(PolylineOptions paramPolylineOptions)
  {
    AppMethodBeat.i(150237);
    if (this.a == null)
    {
      AppMethodBeat.o(150237);
      return null;
    }
    if (paramPolylineOptions == null)
    {
      AppMethodBeat.o(150237);
      return null;
    }
    paramPolylineOptions = new ec(this.a.a(eh.a(paramPolylineOptions)));
    AppMethodBeat.o(150237);
    return paramPolylineOptions;
  }
  
  public void animateCamera(CameraUpdate paramCameraUpdate)
  {
    AppMethodBeat.i(150250);
    if (this.a == null)
    {
      AppMethodBeat.o(150250);
      return;
    }
    if (paramCameraUpdate != null) {
      this.a.b(eh.a(paramCameraUpdate, this.a));
    }
    AppMethodBeat.o(150250);
  }
  
  public void animateCamera(CameraUpdate paramCameraUpdate, long paramLong, CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(150251);
    if (this.a == null)
    {
      AppMethodBeat.o(150251);
      return;
    }
    if (paramCameraUpdate != null) {
      this.a.a(eh.a(paramCameraUpdate, this.a), paramLong, new ef.11(this, paramCancelableCallback));
    }
    AppMethodBeat.o(150251);
  }
  
  public void animateTo(LatLng paramLatLng)
  {
    AppMethodBeat.i(150239);
    if (this.a == null)
    {
      AppMethodBeat.o(150239);
      return;
    }
    if (paramLatLng != null) {
      this.a.b(ac.a(eh.a(paramLatLng)));
    }
    AppMethodBeat.o(150239);
  }
  
  public void animateTo(LatLng paramLatLng, long paramLong, final CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(150241);
    if (this.a == null)
    {
      AppMethodBeat.o(150241);
      return;
    }
    this.a.a(ac.a(eh.a(paramLatLng)), paramLong, new ah.a()
    {
      public void a()
      {
        AppMethodBeat.i(150378);
        if (paramCancelableCallback != null) {
          paramCancelableCallback.onFinish();
        }
        AppMethodBeat.o(150378);
      }
      
      public void b()
      {
        AppMethodBeat.i(150379);
        paramCancelableCallback.onCancel();
        AppMethodBeat.o(150379);
      }
    });
    AppMethodBeat.o(150241);
  }
  
  @Deprecated
  public void animateTo(LatLng paramLatLng, Runnable paramRunnable)
  {
    AppMethodBeat.i(150240);
    if (this.a == null)
    {
      AppMethodBeat.o(150240);
      return;
    }
    if (paramLatLng != null) {
      this.a.a(ac.a(eh.a(paramLatLng)), new ef.1(this, paramRunnable));
    }
    AppMethodBeat.o(150240);
  }
  
  public void clearAllOverlays()
  {
    AppMethodBeat.i(150242);
    if (this.a != null) {
      this.a.h();
    }
    AppMethodBeat.o(150242);
  }
  
  public boolean clearCache()
  {
    return false;
  }
  
  public void enableMultipleInfowindow(boolean paramBoolean)
  {
    AppMethodBeat.i(150278);
    if (this.a == null)
    {
      AppMethodBeat.o(150278);
      return;
    }
    this.a.h(paramBoolean);
    AppMethodBeat.o(150278);
  }
  
  public String getActivedIndoorBuilding(LatLng paramLatLng)
  {
    AppMethodBeat.i(150275);
    if (this.a == null)
    {
      AppMethodBeat.o(150275);
      return null;
    }
    paramLatLng = this.a.a(eh.a(paramLatLng));
    AppMethodBeat.o(150275);
    return paramLatLng;
  }
  
  public String[] getActivedIndoorFloorNames()
  {
    AppMethodBeat.i(150276);
    if (this.a == null)
    {
      AppMethodBeat.o(150276);
      return null;
    }
    String[] arrayOfString = this.a.v();
    AppMethodBeat.o(150276);
    return arrayOfString;
  }
  
  public CameraPosition getCameraPosition()
  {
    AppMethodBeat.i(150282);
    if (this.a == null)
    {
      AppMethodBeat.o(150282);
      return null;
    }
    CameraPosition localCameraPosition = eh.a(this.a.d());
    AppMethodBeat.o(150282);
    return localCameraPosition;
  }
  
  public String getDebugError()
  {
    AppMethodBeat.i(150283);
    if (this.a == null)
    {
      AppMethodBeat.o(150283);
      return null;
    }
    String str = this.a.z();
    AppMethodBeat.o(150283);
    return str;
  }
  
  public int getIndoorFloorId()
  {
    AppMethodBeat.i(150277);
    if (this.a == null)
    {
      AppMethodBeat.o(150277);
      return 0;
    }
    int i = this.a.u();
    AppMethodBeat.o(150277);
    return i;
  }
  
  public LatLng getMapCenter()
  {
    AppMethodBeat.i(150243);
    if (this.a == null)
    {
      AppMethodBeat.o(150243);
      return null;
    }
    this.a.d();
    LatLng localLatLng = eh.a(this.a.d().a);
    AppMethodBeat.o(150243);
    return localLatLng;
  }
  
  public int getMaxZoomLevel()
  {
    AppMethodBeat.i(150245);
    if (this.a == null)
    {
      AppMethodBeat.o(150245);
      return 19;
    }
    int i = (int)this.a.e();
    AppMethodBeat.o(150245);
    return i;
  }
  
  public int getMinZoomLevel()
  {
    AppMethodBeat.i(150246);
    if (this.a == null)
    {
      AppMethodBeat.o(150246);
      return 4;
    }
    int i = (int)this.a.f();
    AppMethodBeat.o(150246);
    return i;
  }
  
  public void getScreenShot(TencentMap.OnScreenShotListener paramOnScreenShotListener)
  {
    AppMethodBeat.i(150285);
    if (this.a == null)
    {
      AppMethodBeat.o(150285);
      return;
    }
    this.a.a(new ef.8(this, paramOnScreenShotListener));
    AppMethodBeat.o(150285);
  }
  
  @Deprecated
  public void getScreenShot(TencentMap.OnScreenShotListener paramOnScreenShotListener, Rect paramRect)
  {
    AppMethodBeat.i(150286);
    if (this.a == null)
    {
      AppMethodBeat.o(150286);
      return;
    }
    this.a.a(new ef.9(this, paramOnScreenShotListener));
    AppMethodBeat.o(150286);
  }
  
  public String getVersion()
  {
    AppMethodBeat.i(150247);
    if (this.a == null)
    {
      AppMethodBeat.o(150247);
      return null;
    }
    String str = this.a.t();
    AppMethodBeat.o(150247);
    return str;
  }
  
  public int getZoomLevel()
  {
    AppMethodBeat.i(150244);
    if ((this.a == null) || (this.a.d() == null))
    {
      AppMethodBeat.o(150244);
      return -1;
    }
    int i = (int)this.a.d().b;
    AppMethodBeat.o(150244);
    return i;
  }
  
  public boolean isAppKeyAvailable()
  {
    return true;
  }
  
  public boolean isHandDrawMapEnable()
  {
    AppMethodBeat.i(150292);
    if (this.a == null)
    {
      AppMethodBeat.o(150292);
      return false;
    }
    boolean bool = this.a.w();
    AppMethodBeat.o(150292);
    return bool;
  }
  
  public boolean isSatelliteEnabled()
  {
    return this.d;
  }
  
  public boolean isTrafficEnabled()
  {
    AppMethodBeat.i(150288);
    if (this.a == null)
    {
      AppMethodBeat.o(150288);
      return false;
    }
    boolean bool = this.a.i();
    AppMethodBeat.o(150288);
    return bool;
  }
  
  public void moveCamera(CameraUpdate paramCameraUpdate)
  {
    AppMethodBeat.i(150249);
    if (this.a == null)
    {
      AppMethodBeat.o(150249);
      return;
    }
    if (paramCameraUpdate != null) {
      this.a.a(eh.a(paramCameraUpdate, this.a));
    }
    AppMethodBeat.o(150249);
  }
  
  public void removeTencentMapGestureListener(TencentMap.TencentMapGestureListener paramTencentMapGestureListener)
  {
    AppMethodBeat.i(150280);
    this.a.c(this.e);
    AppMethodBeat.o(150280);
  }
  
  public void scrollBy(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(150252);
    if (this.a == null)
    {
      AppMethodBeat.o(150252);
      return;
    }
    this.a.b(ac.a(paramFloat1, paramFloat2));
    AppMethodBeat.o(150252);
  }
  
  public void scrollBy(float paramFloat1, float paramFloat2, long paramLong, final CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(150253);
    if (this.a == null)
    {
      AppMethodBeat.o(150253);
      return;
    }
    this.a.a(ac.a(paramFloat1, paramFloat2), new ah.a()
    {
      public void a()
      {
        AppMethodBeat.i(150330);
        if (paramCancelableCallback != null) {
          paramCancelableCallback.onFinish();
        }
        AppMethodBeat.o(150330);
      }
      
      public void b()
      {
        AppMethodBeat.i(150331);
        if (paramCancelableCallback != null) {
          paramCancelableCallback.onCancel();
        }
        AppMethodBeat.o(150331);
      }
    });
    AppMethodBeat.o(150253);
  }
  
  public void set3DEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(150289);
    if (this.a == null)
    {
      AppMethodBeat.o(150289);
      return;
    }
    this.a.e(paramBoolean);
    AppMethodBeat.o(150289);
  }
  
  public void setCenter(LatLng paramLatLng)
  {
    AppMethodBeat.i(150233);
    if (this.a == null)
    {
      AppMethodBeat.o(150233);
      return;
    }
    if (paramLatLng != null) {
      this.a.a(ac.a(new cz(paramLatLng.getLatitude(), paramLatLng.getLongitude())));
    }
    AppMethodBeat.o(150233);
  }
  
  @Deprecated
  public void setErrorListener(TencentMap.OnErrorListener paramOnErrorListener)
  {
    if (this.a == null) {}
  }
  
  public void setForeignLanguage(Language paramLanguage)
  {
    AppMethodBeat.i(150281);
    if (this.a == null)
    {
      AppMethodBeat.o(150281);
      return;
    }
    this.a.a(eh.a(paramLanguage));
    AppMethodBeat.o(150281);
  }
  
  public void setHandDrawMapEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(150291);
    if (this.a == null)
    {
      AppMethodBeat.o(150291);
      return;
    }
    this.a.g(paramBoolean);
    AppMethodBeat.o(150291);
  }
  
  public void setIndoorEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(150272);
    if (this.a == null)
    {
      AppMethodBeat.o(150272);
      return;
    }
    this.a.f(paramBoolean);
    AppMethodBeat.o(150272);
  }
  
  public void setIndoorFloor(int paramInt)
  {
    AppMethodBeat.i(150273);
    if (this.a == null)
    {
      AppMethodBeat.o(150273);
      return;
    }
    this.a.c(paramInt);
    AppMethodBeat.o(150273);
  }
  
  public void setIndoorFloor(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150274);
    if (this.a == null)
    {
      AppMethodBeat.o(150274);
      return;
    }
    this.a.a(paramString1, paramString2);
    AppMethodBeat.o(150274);
  }
  
  public void setInfoWindowAdapter(TencentMap.InfoWindowAdapter paramInfoWindowAdapter)
  {
    AppMethodBeat.i(150260);
    if (this.a == null)
    {
      AppMethodBeat.o(150260);
      return;
    }
    this.a.a(new ef.13(this, paramInfoWindowAdapter));
    AppMethodBeat.o(150260);
  }
  
  public void setMapAnchor(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(150290);
    if (this.a == null)
    {
      AppMethodBeat.o(150290);
      return;
    }
    this.a.a(paramFloat1, paramFloat2, false);
    this.a.l().i(true);
    AppMethodBeat.o(150290);
  }
  
  public void setMapStyle(int paramInt)
  {
    AppMethodBeat.i(150270);
    if (this.a == null)
    {
      AppMethodBeat.o(150270);
      return;
    }
    this.a.a(paramInt);
    AppMethodBeat.o(150270);
  }
  
  public void setOnIndoorStateChangeListener(TencentMap.OnIndoorStateChangeListener paramOnIndoorStateChangeListener)
  {
    AppMethodBeat.i(150271);
    if (this.a == null)
    {
      AppMethodBeat.o(150271);
      return;
    }
    this.a.a(new ef.6(this, paramOnIndoorStateChangeListener));
    AppMethodBeat.o(150271);
  }
  
  public void setOnInfoWindowClickListener(TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    AppMethodBeat.i(150264);
    if (this.a == null)
    {
      AppMethodBeat.o(150264);
      return;
    }
    this.a.a(new ef.16(this, paramOnInfoWindowClickListener));
    AppMethodBeat.o(150264);
  }
  
  public void setOnMapCameraChangeListener(TencentMap.OnMapCameraChangeListener paramOnMapCameraChangeListener)
  {
    AppMethodBeat.i(150266);
    if (this.a == null)
    {
      AppMethodBeat.o(150266);
      return;
    }
    this.a.a(new ef.2(this, paramOnMapCameraChangeListener));
    AppMethodBeat.o(150266);
  }
  
  public void setOnMapClickListener(TencentMap.OnMapClickListener paramOnMapClickListener)
  {
    AppMethodBeat.i(150267);
    if (this.a == null)
    {
      AppMethodBeat.o(150267);
      return;
    }
    this.a.a(new ef.3(this, paramOnMapClickListener));
    AppMethodBeat.o(150267);
  }
  
  public void setOnMapLoadedListener(TencentMap.OnMapLoadedListener paramOnMapLoadedListener)
  {
    AppMethodBeat.i(150263);
    if (this.a == null)
    {
      AppMethodBeat.o(150263);
      return;
    }
    this.a.a(new ef.15(this, paramOnMapLoadedListener));
    AppMethodBeat.o(150263);
  }
  
  public void setOnMapLongClickListener(TencentMap.OnMapLongClickListener paramOnMapLongClickListener)
  {
    AppMethodBeat.i(150268);
    if (this.a == null)
    {
      AppMethodBeat.o(150268);
      return;
    }
    this.a.a(new ef.4(this, paramOnMapLongClickListener));
    AppMethodBeat.o(150268);
  }
  
  public void setOnMapPoiClickListener(TencentMap.OnMapPoiClickListener paramOnMapPoiClickListener)
  {
    AppMethodBeat.i(150269);
    if (this.a == null)
    {
      AppMethodBeat.o(150269);
      return;
    }
    this.a.a(new ef.5(this, paramOnMapPoiClickListener));
    AppMethodBeat.o(150269);
  }
  
  public void setOnMarkerClickListener(TencentMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    AppMethodBeat.i(150265);
    if (this.a == null)
    {
      AppMethodBeat.o(150265);
      return;
    }
    this.a.a(new ef.17(this, paramOnMarkerClickListener));
    AppMethodBeat.o(150265);
  }
  
  public void setOnMarkerDraggedListener(TencentMap.OnMarkerDraggedListener paramOnMarkerDraggedListener)
  {
    AppMethodBeat.i(150262);
    if (this.a == null)
    {
      AppMethodBeat.o(150262);
      return;
    }
    this.a.a(new ef.14(this, paramOnMarkerDraggedListener));
    AppMethodBeat.o(150262);
  }
  
  public void setSatelliteEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(150248);
    if (this.a == null)
    {
      AppMethodBeat.o(150248);
      return;
    }
    this.d = paramBoolean;
    this.a.b(paramBoolean);
    AppMethodBeat.o(150248);
  }
  
  public void setTencentMapGestureListener(TencentMap.TencentMapGestureListener paramTencentMapGestureListener)
  {
    AppMethodBeat.i(150279);
    if ((this.a == null) || (paramTencentMapGestureListener == null))
    {
      AppMethodBeat.o(150279);
      return;
    }
    if (this.e != null) {
      this.a.c(this.e);
    }
    this.e = new ef.7(this, paramTencentMapGestureListener);
    this.a.a(this.e);
    AppMethodBeat.o(150279);
  }
  
  public void setTrafficEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(150287);
    if (this.a == null)
    {
      AppMethodBeat.o(150287);
      return;
    }
    this.a.a(paramBoolean);
    AppMethodBeat.o(150287);
  }
  
  public void setZoom(int paramInt)
  {
    AppMethodBeat.i(150234);
    if (this.a == null)
    {
      AppMethodBeat.o(150234);
      return;
    }
    this.a.a(ac.a(paramInt));
    AppMethodBeat.o(150234);
  }
  
  public void stopAnimation()
  {
    AppMethodBeat.i(150284);
    if (this.a == null)
    {
      AppMethodBeat.o(150284);
      return;
    }
    this.a.g();
    AppMethodBeat.o(150284);
  }
  
  public void zoomIn()
  {
    AppMethodBeat.i(150254);
    if (this.a == null)
    {
      AppMethodBeat.o(150254);
      return;
    }
    this.a.b(ac.a());
    AppMethodBeat.o(150254);
  }
  
  public void zoomInFixing(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150255);
    if (this.a == null)
    {
      AppMethodBeat.o(150255);
      return;
    }
    this.a.a(ac.a(1.0F, new Point(paramInt1, paramInt2)));
    AppMethodBeat.o(150255);
  }
  
  public void zoomOut()
  {
    AppMethodBeat.i(150256);
    if (this.a == null)
    {
      AppMethodBeat.o(150256);
      return;
    }
    this.a.b(ac.b());
    AppMethodBeat.o(150256);
  }
  
  public void zoomOutFixing(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150257);
    if (this.a == null)
    {
      AppMethodBeat.o(150257);
      return;
    }
    this.a.a(ac.a(-1.0F, new Point(paramInt1, paramInt2)));
    AppMethodBeat.o(150257);
  }
  
  public void zoomToSpan(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(150259);
    zoomToSpan(new LatLng(getMapCenter().getLatitude() - paramDouble1 / 2.0D, getMapCenter().getLongitude() + paramDouble2 / 2.0D), new LatLng(getMapCenter().getLatitude() + paramDouble1 / 2.0D, getMapCenter().getLongitude() - paramDouble2 / 2.0D));
    AppMethodBeat.o(150259);
  }
  
  public void zoomToSpan(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    AppMethodBeat.i(150258);
    if (this.a == null)
    {
      AppMethodBeat.o(150258);
      return;
    }
    this.a.a(ac.a(new da(eh.a(paramLatLng1), eh.a(paramLatLng2)), 0));
    AppMethodBeat.o(150258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ef
 * JD-Core Version:    0.7.0.1
 */