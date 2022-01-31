package com.tencent.tencentmap.mapsdk.a;

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
import java.util.HashMap;

public class rd
  implements TencentMap
{
  private vb a;
  private HashMap<Integer, qz> b = new HashMap();
  
  public rd(vb paramvb)
  {
    this.a = paramvb;
  }
  
  private qz a(sa paramsa)
  {
    if (paramsa == null) {
      return null;
    }
    return (qz)this.b.get(Integer.valueOf(paramsa.b().hashCode()));
  }
  
  public Circle addCircle(CircleOptions paramCircleOptions)
  {
    if (paramCircleOptions == null) {
      return null;
    }
    return new qx(this.a.a(re.a(paramCircleOptions)));
  }
  
  public Marker addMarker(MarkerOptions paramMarkerOptions)
  {
    if (paramMarkerOptions == null) {}
    do
    {
      return null;
      paramMarkerOptions = re.a(paramMarkerOptions);
    } while (paramMarkerOptions == null);
    paramMarkerOptions = new qz(this.a.a(paramMarkerOptions));
    this.b.put(Integer.valueOf(paramMarkerOptions.getId().hashCode()), paramMarkerOptions);
    return paramMarkerOptions;
  }
  
  public Polygon addPolygon(PolygonOptions paramPolygonOptions)
  {
    if (paramPolygonOptions == null) {}
    do
    {
      return null;
      paramPolygonOptions = re.a(paramPolygonOptions);
    } while (paramPolygonOptions == null);
    return new rb(this.a.a(paramPolygonOptions));
  }
  
  public Polyline addPolyline(PolylineOptions paramPolylineOptions)
  {
    if (paramPolylineOptions == null) {}
    do
    {
      return null;
      paramPolylineOptions = re.a(paramPolylineOptions);
    } while (paramPolylineOptions == null);
    return new ra(this.a.a(paramPolylineOptions));
  }
  
  public void animateCamera(CameraUpdate paramCameraUpdate)
  {
    paramCameraUpdate = re.a(paramCameraUpdate);
    if (paramCameraUpdate == null) {
      return;
    }
    this.a.b(paramCameraUpdate);
  }
  
  public void animateCamera(CameraUpdate paramCameraUpdate, long paramLong, final CancelableCallback paramCancelableCallback)
  {
    paramCameraUpdate = re.a(paramCameraUpdate);
    if (paramCameraUpdate == null) {
      return;
    }
    this.a.a(paramCameraUpdate, paramLong, new uv()
    {
      public void a()
      {
        if (paramCancelableCallback != null) {
          paramCancelableCallback.onFinish();
        }
      }
      
      public void b()
      {
        if (paramCancelableCallback != null) {
          paramCancelableCallback.onCancel();
        }
      }
    });
  }
  
  public void animateTo(LatLng paramLatLng)
  {
    this.a.a(re.a(paramLatLng));
  }
  
  public void animateTo(LatLng paramLatLng, long paramLong, CancelableCallback paramCancelableCallback)
  {
    this.a.a(re.a(paramLatLng), paramLong, new rd.1(this, paramCancelableCallback));
  }
  
  public void animateTo(LatLng paramLatLng, Runnable paramRunnable)
  {
    this.a.a(re.a(paramLatLng), paramRunnable);
  }
  
  public void clearAllOverlays()
  {
    this.a.a();
  }
  
  public boolean clearCache()
  {
    return this.a.b();
  }
  
  public void enableMultipleInfowindow(boolean paramBoolean) {}
  
  public String getActivedIndoorBuilding(LatLng paramLatLng)
  {
    return null;
  }
  
  public String[] getActivedIndoorFloorNames()
  {
    return null;
  }
  
  public int getIndoorFloorId()
  {
    return 0;
  }
  
  public LatLng getMapCenter()
  {
    return re.a(this.a.c());
  }
  
  public int getMaxZoomLevel()
  {
    return this.a.e();
  }
  
  public int getMinZoomLevel()
  {
    return this.a.f();
  }
  
  public void getScreenShot(TencentMap.OnScreenShotListener paramOnScreenShotListener)
  {
    this.a.a(new rd.4(this, paramOnScreenShotListener));
  }
  
  public void getScreenShot(TencentMap.OnScreenShotListener paramOnScreenShotListener, Rect paramRect)
  {
    this.a.a(new rd.5(this, paramOnScreenShotListener), paramRect);
  }
  
  public String getVersion()
  {
    return this.a.g();
  }
  
  public int getZoomLevel()
  {
    return this.a.d();
  }
  
  public boolean isAppKeyAvailable()
  {
    return this.a.h();
  }
  
  public boolean isHandDrawMapEnable()
  {
    if (this.a == null) {
      return false;
    }
    return this.a.o();
  }
  
  public boolean isSatelliteEnabled()
  {
    return this.a.i();
  }
  
  public boolean isTrafficEnabled()
  {
    return this.a.m();
  }
  
  public void moveCamera(CameraUpdate paramCameraUpdate)
  {
    paramCameraUpdate = re.a(paramCameraUpdate);
    if (paramCameraUpdate == null) {
      return;
    }
    this.a.a(paramCameraUpdate);
  }
  
  public void removeTencentMapGestureListener(TencentMap.TencentMapGestureListener paramTencentMapGestureListener) {}
  
  public void scrollBy(float paramFloat1, float paramFloat2)
  {
    this.a.a(paramFloat1, paramFloat2);
  }
  
  public void scrollBy(float paramFloat1, float paramFloat2, long paramLong, CancelableCallback paramCancelableCallback)
  {
    this.a.a(paramFloat1, paramFloat2, paramLong, new rd.8(this, paramCancelableCallback));
  }
  
  public void set3DEnable(boolean paramBoolean) {}
  
  public void setCenter(LatLng paramLatLng)
  {
    if (paramLatLng == null) {
      return;
    }
    this.a.b(new ry(paramLatLng.getLatitude(), paramLatLng.getLongitude()));
  }
  
  public void setErrorListener(TencentMap.OnErrorListener paramOnErrorListener)
  {
    vb.a(new rd.6(this, paramOnErrorListener));
  }
  
  public void setForeignLanguage(Language paramLanguage)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(re.a(paramLanguage));
  }
  
  public void setHandDrawMapEnable(boolean paramBoolean)
  {
    if (this.a == null) {
      return;
    }
    this.a.c(paramBoolean);
  }
  
  public void setIndoorEnabled(boolean paramBoolean) {}
  
  public void setIndoorFloor(int paramInt) {}
  
  public void setIndoorFloor(String paramString1, String paramString2) {}
  
  public void setInfoWindowAdapter(TencentMap.InfoWindowAdapter paramInfoWindowAdapter)
  {
    this.a.a(new rd.9(this, paramInfoWindowAdapter));
  }
  
  public void setMapAnchor(float paramFloat1, float paramFloat2) {}
  
  public void setMapStyle(int paramInt) {}
  
  public void setOnIndoorStateChangeListener(TencentMap.OnIndoorStateChangeListener paramOnIndoorStateChangeListener) {}
  
  public void setOnInfoWindowClickListener(TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    this.a.a(new rd.12(this, paramOnInfoWindowClickListener));
  }
  
  public void setOnMapCameraChangeListener(TencentMap.OnMapCameraChangeListener paramOnMapCameraChangeListener)
  {
    this.a.a(new rd.14(this, paramOnMapCameraChangeListener));
  }
  
  public void setOnMapClickListener(TencentMap.OnMapClickListener paramOnMapClickListener)
  {
    this.a.a(new rd.2(this, paramOnMapClickListener));
  }
  
  public void setOnMapLoadedListener(TencentMap.OnMapLoadedListener paramOnMapLoadedListener)
  {
    this.a.a(new rd.11(this, paramOnMapLoadedListener));
  }
  
  public void setOnMapLongClickListener(TencentMap.OnMapLongClickListener paramOnMapLongClickListener)
  {
    this.a.a(new rd.3(this, paramOnMapLongClickListener));
  }
  
  public void setOnMapPoiClickListener(TencentMap.OnMapPoiClickListener paramOnMapPoiClickListener) {}
  
  public void setOnMarkerClickListener(final TencentMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    this.a.a(new vb.h()
    {
      public boolean a(sa paramAnonymoussa)
      {
        if (paramOnMarkerClickListener != null) {
          return paramOnMarkerClickListener.onMarkerClick(rd.a(rd.this, paramAnonymoussa));
        }
        return false;
      }
    });
  }
  
  public void setOnMarkerDraggedListener(TencentMap.OnMarkerDraggedListener paramOnMarkerDraggedListener)
  {
    this.a.a(new rd.10(this, paramOnMarkerDraggedListener));
  }
  
  public void setSatelliteEnabled(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }
  
  public void setTencentMapGestureListener(TencentMap.TencentMapGestureListener paramTencentMapGestureListener) {}
  
  public void setTrafficEnabled(boolean paramBoolean)
  {
    this.a.b(paramBoolean);
  }
  
  public void setZoom(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void stopAnimation()
  {
    this.a.l();
  }
  
  public void zoomIn()
  {
    this.a.j();
  }
  
  public void zoomInFixing(int paramInt1, int paramInt2)
  {
    this.a.a(paramInt1, paramInt2);
  }
  
  public void zoomOut()
  {
    this.a.k();
  }
  
  public void zoomOutFixing(int paramInt1, int paramInt2)
  {
    this.a.b(paramInt1, paramInt2);
  }
  
  public void zoomToSpan(double paramDouble1, double paramDouble2)
  {
    this.a.a(paramDouble1, paramDouble2);
  }
  
  public void zoomToSpan(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    this.a.a(re.a(paramLatLng1), re.a(paramLatLng2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.rd
 * JD-Core Version:    0.7.0.1
 */