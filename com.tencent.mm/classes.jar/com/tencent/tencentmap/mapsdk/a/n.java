package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.CustomLayer;
import com.tencent.mapsdk.raster.model.CustomLayerOptions;
import com.tencent.mapsdk.raster.model.Language;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.raster.model.Polygon;
import com.tencent.mapsdk.raster.model.PolygonOptions;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.mapsdk.raster.model.TileOverlay;
import com.tencent.mapsdk.raster.model.TileOverlayOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.CameraUpdate;
import com.tencent.tencentmap.mapsdk.map.CancelableCallback;
import com.tencent.tencentmap.mapsdk.map.Projection;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnErrorListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapCameraChangeListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLoadedListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerDraggedListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnScreenShotListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.TencentMapGestureListener;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.CancelableCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerDragListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.SnapshotReadyCallback;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class n
  implements com.tencent.tencentmap.mapsdk.map.TencentMap
{
  private com.tencent.tencentmap.mapsdk.maps.TencentMap a;
  private HashMap<Integer, j> b;
  private List<com.tencent.tencentmap.mapsdk.maps.model.Marker> c;
  private boolean d;
  private TencentMapGestureListener e;
  
  public n(com.tencent.tencentmap.mapsdk.maps.TencentMap paramTencentMap)
  {
    AppMethodBeat.i(186223);
    this.b = new HashMap();
    this.c = new ArrayList();
    this.d = false;
    this.a = paramTencentMap;
    AppMethodBeat.o(186223);
  }
  
  private j a(com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(186252);
    if (paramMarker == null)
    {
      AppMethodBeat.o(186252);
      return null;
    }
    paramMarker = (j)this.b.get(Integer.valueOf(paramMarker.getId().hashCode()));
    AppMethodBeat.o(186252);
    return paramMarker;
  }
  
  protected List<com.tencent.tencentmap.mapsdk.maps.model.Marker> a()
  {
    return this.c;
  }
  
  public Circle addCircle(CircleOptions paramCircleOptions)
  {
    AppMethodBeat.i(186226);
    if (this.a == null)
    {
      AppMethodBeat.o(186226);
      return null;
    }
    if (paramCircleOptions == null)
    {
      AppMethodBeat.o(186226);
      return null;
    }
    paramCircleOptions = new g(this.a.addCircle(q.a(paramCircleOptions)));
    AppMethodBeat.o(186226);
    return paramCircleOptions;
  }
  
  public CustomLayer addCustomLayer(CustomLayerOptions paramCustomLayerOptions)
  {
    AppMethodBeat.i(186280);
    if (this.a == null)
    {
      AppMethodBeat.o(186280);
      return null;
    }
    paramCustomLayerOptions = new h(this.a.addCustomLayer(q.a(paramCustomLayerOptions)));
    AppMethodBeat.o(186280);
    return paramCustomLayerOptions;
  }
  
  public com.tencent.mapsdk.raster.model.Marker addMarker(MarkerOptions paramMarkerOptions)
  {
    AppMethodBeat.i(186227);
    if (this.a == null)
    {
      AppMethodBeat.o(186227);
      return null;
    }
    if (paramMarkerOptions == null)
    {
      AppMethodBeat.o(186227);
      return null;
    }
    paramMarkerOptions = new j(this, this.a.addMarker(q.a(paramMarkerOptions)));
    this.b.put(Integer.valueOf(paramMarkerOptions.getId().hashCode()), paramMarkerOptions);
    AppMethodBeat.o(186227);
    return paramMarkerOptions;
  }
  
  public Polygon addPolygon(PolygonOptions paramPolygonOptions)
  {
    AppMethodBeat.i(186229);
    if (this.a == null)
    {
      AppMethodBeat.o(186229);
      return null;
    }
    if (paramPolygonOptions == null)
    {
      AppMethodBeat.o(186229);
      return null;
    }
    paramPolygonOptions = new l(this.a.addPolygon(q.a(paramPolygonOptions)));
    AppMethodBeat.o(186229);
    return paramPolygonOptions;
  }
  
  public Polyline addPolyline(PolylineOptions paramPolylineOptions)
  {
    AppMethodBeat.i(186228);
    if (this.a == null)
    {
      AppMethodBeat.o(186228);
      return null;
    }
    if (paramPolylineOptions == null)
    {
      AppMethodBeat.o(186228);
      return null;
    }
    paramPolylineOptions = new k(this.a.addPolyline(q.a(paramPolylineOptions)));
    AppMethodBeat.o(186228);
    return paramPolylineOptions;
  }
  
  public TileOverlay addTileOverlay(TileOverlayOptions paramTileOverlayOptions)
  {
    AppMethodBeat.i(186275);
    if (this.a == null)
    {
      AppMethodBeat.o(186275);
      return null;
    }
    if (paramTileOverlayOptions == null)
    {
      AppMethodBeat.o(186275);
      return null;
    }
    paramTileOverlayOptions = new p(this.a.addTileOverlay(q.a(paramTileOverlayOptions)));
    AppMethodBeat.o(186275);
    return paramTileOverlayOptions;
  }
  
  public void animateCamera(CameraUpdate paramCameraUpdate)
  {
    AppMethodBeat.i(186241);
    if (this.a == null)
    {
      AppMethodBeat.o(186241);
      return;
    }
    if (paramCameraUpdate != null) {
      this.a.animateCamera(q.a(paramCameraUpdate, this.a));
    }
    AppMethodBeat.o(186241);
  }
  
  public void animateCamera(CameraUpdate paramCameraUpdate, long paramLong, final CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(186242);
    if (this.a == null)
    {
      AppMethodBeat.o(186242);
      return;
    }
    if (paramCameraUpdate != null) {
      this.a.animateCamera(q.a(paramCameraUpdate, this.a), paramLong, new TencentMap.CancelableCallback()
      {
        public void onCancel()
        {
          AppMethodBeat.i(186403);
          if (paramCancelableCallback != null) {
            paramCancelableCallback.onCancel();
          }
          AppMethodBeat.o(186403);
        }
        
        public void onFinish()
        {
          AppMethodBeat.i(186402);
          if (paramCancelableCallback != null) {
            paramCancelableCallback.onFinish();
          }
          AppMethodBeat.o(186402);
        }
      });
    }
    AppMethodBeat.o(186242);
  }
  
  public void animateTo(com.tencent.mapsdk.raster.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(186230);
    if (this.a == null)
    {
      AppMethodBeat.o(186230);
      return;
    }
    if (paramLatLng != null) {
      this.a.animateCamera(CameraUpdateFactory.newLatLng(q.a(paramLatLng)));
    }
    AppMethodBeat.o(186230);
  }
  
  public void animateTo(com.tencent.mapsdk.raster.model.LatLng paramLatLng, long paramLong, final CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(186232);
    if (this.a == null)
    {
      AppMethodBeat.o(186232);
      return;
    }
    this.a.animateCamera(CameraUpdateFactory.newLatLng(q.a(paramLatLng)), paramLong, new TencentMap.CancelableCallback()
    {
      public void onCancel()
      {
        AppMethodBeat.i(186382);
        paramCancelableCallback.onCancel();
        AppMethodBeat.o(186382);
      }
      
      public void onFinish()
      {
        AppMethodBeat.i(186381);
        if (paramCancelableCallback != null) {
          paramCancelableCallback.onFinish();
        }
        AppMethodBeat.o(186381);
      }
    });
    AppMethodBeat.o(186232);
  }
  
  @Deprecated
  public void animateTo(com.tencent.mapsdk.raster.model.LatLng paramLatLng, final Runnable paramRunnable)
  {
    AppMethodBeat.i(186231);
    if (this.a == null)
    {
      AppMethodBeat.o(186231);
      return;
    }
    if (paramLatLng != null) {
      this.a.animateCamera(CameraUpdateFactory.newLatLng(q.a(paramLatLng)), new TencentMap.CancelableCallback()
      {
        public void onCancel()
        {
          AppMethodBeat.i(186407);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(186407);
        }
        
        public void onFinish()
        {
          AppMethodBeat.i(186406);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(186406);
        }
      });
    }
    AppMethodBeat.o(186231);
  }
  
  public void clearAllOverlays()
  {
    AppMethodBeat.i(186233);
    if (this.a != null) {
      this.a.clear();
    }
    AppMethodBeat.o(186233);
  }
  
  public boolean clearCache()
  {
    return false;
  }
  
  public void enableMultipleInfowindow(boolean paramBoolean)
  {
    AppMethodBeat.i(186269);
    if (this.a == null)
    {
      AppMethodBeat.o(186269);
      return;
    }
    this.a.enableMultipleInfowindow(paramBoolean);
    AppMethodBeat.o(186269);
  }
  
  public String getActivedIndoorBuilding(com.tencent.mapsdk.raster.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(186266);
    if (this.a == null)
    {
      AppMethodBeat.o(186266);
      return null;
    }
    paramLatLng = this.a.getActivedIndoorBuilding(q.a(paramLatLng));
    AppMethodBeat.o(186266);
    return paramLatLng;
  }
  
  public String[] getActivedIndoorFloorNames()
  {
    AppMethodBeat.i(186267);
    if (this.a == null)
    {
      AppMethodBeat.o(186267);
      return null;
    }
    String[] arrayOfString = this.a.getActivedIndoorFloorNames();
    AppMethodBeat.o(186267);
    return arrayOfString;
  }
  
  public com.tencent.mapsdk.raster.model.CameraPosition getCameraPosition()
  {
    AppMethodBeat.i(186273);
    if (this.a == null)
    {
      AppMethodBeat.o(186273);
      return null;
    }
    com.tencent.mapsdk.raster.model.CameraPosition localCameraPosition = q.a(this.a.getCameraPosition());
    AppMethodBeat.o(186273);
    return localCameraPosition;
  }
  
  public String getDebugError()
  {
    AppMethodBeat.i(186274);
    if (this.a == null)
    {
      AppMethodBeat.o(186274);
      return null;
    }
    String str = this.a.getDebugError();
    AppMethodBeat.o(186274);
    return str;
  }
  
  public int getIndoorFloorId()
  {
    AppMethodBeat.i(186268);
    if (this.a == null)
    {
      AppMethodBeat.o(186268);
      return 0;
    }
    int i = this.a.getIndoorFloorId();
    AppMethodBeat.o(186268);
    return i;
  }
  
  public com.tencent.mapsdk.raster.model.LatLng getMapCenter()
  {
    AppMethodBeat.i(186234);
    if (this.a == null)
    {
      AppMethodBeat.o(186234);
      return null;
    }
    this.a.getCameraPosition();
    com.tencent.mapsdk.raster.model.LatLng localLatLng = q.a(this.a.getCameraPosition().target);
    AppMethodBeat.o(186234);
    return localLatLng;
  }
  
  public int getMapType()
  {
    AppMethodBeat.i(186278);
    if (this.a == null)
    {
      AppMethodBeat.o(186278);
      return 1000;
    }
    int i = this.a.getMapType();
    AppMethodBeat.o(186278);
    return i;
  }
  
  public int getMaxZoomLevel()
  {
    AppMethodBeat.i(186236);
    if (this.a == null)
    {
      AppMethodBeat.o(186236);
      return 19;
    }
    int i = (int)this.a.getMaxZoomLevel();
    AppMethodBeat.o(186236);
    return i;
  }
  
  public int getMinZoomLevel()
  {
    AppMethodBeat.i(186237);
    if (this.a == null)
    {
      AppMethodBeat.o(186237);
      return 4;
    }
    int i = (int)this.a.getMinZoomLevel();
    AppMethodBeat.o(186237);
    return i;
  }
  
  public Projection getProjection()
  {
    AppMethodBeat.i(186279);
    m localm = new m(this.a);
    AppMethodBeat.o(186279);
    return localm;
  }
  
  public void getScreenShot(final TencentMap.OnScreenShotListener paramOnScreenShotListener)
  {
    AppMethodBeat.i(186282);
    if (this.a == null)
    {
      AppMethodBeat.o(186282);
      return;
    }
    this.a.snapshot(new TencentMap.SnapshotReadyCallback()
    {
      public void onSnapshotReady(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(186139);
        if (paramOnScreenShotListener != null) {
          paramOnScreenShotListener.onMapScreenShot(paramAnonymousBitmap);
        }
        AppMethodBeat.o(186139);
      }
    });
    AppMethodBeat.o(186282);
  }
  
  @Deprecated
  public void getScreenShot(final TencentMap.OnScreenShotListener paramOnScreenShotListener, Rect paramRect)
  {
    AppMethodBeat.i(186283);
    if (this.a == null)
    {
      AppMethodBeat.o(186283);
      return;
    }
    this.a.snapshot(new TencentMap.SnapshotReadyCallback()
    {
      public void onSnapshotReady(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(186169);
        if (paramOnScreenShotListener != null) {
          paramOnScreenShotListener.onMapScreenShot(paramAnonymousBitmap);
        }
        AppMethodBeat.o(186169);
      }
    });
    AppMethodBeat.o(186283);
  }
  
  public String getVersion()
  {
    AppMethodBeat.i(186238);
    if (this.a == null)
    {
      AppMethodBeat.o(186238);
      return null;
    }
    String str = this.a.getVersion();
    AppMethodBeat.o(186238);
    return str;
  }
  
  public int getZoomLevel()
  {
    AppMethodBeat.i(186235);
    if ((this.a == null) || (this.a.getCameraPosition() == null))
    {
      AppMethodBeat.o(186235);
      return -1;
    }
    int i = (int)this.a.getCameraPosition().zoom;
    AppMethodBeat.o(186235);
    return i;
  }
  
  public boolean isAppKeyAvailable()
  {
    return true;
  }
  
  public boolean isHandDrawMapEnable()
  {
    AppMethodBeat.i(186289);
    if (this.a == null)
    {
      AppMethodBeat.o(186289);
      return false;
    }
    boolean bool = this.a.isHandDrawMapEnable();
    AppMethodBeat.o(186289);
    return bool;
  }
  
  public boolean isSatelliteEnabled()
  {
    return this.d;
  }
  
  public boolean isTrafficEnabled()
  {
    AppMethodBeat.i(186285);
    if (this.a == null)
    {
      AppMethodBeat.o(186285);
      return false;
    }
    boolean bool = this.a.isTrafficEnabled();
    AppMethodBeat.o(186285);
    return bool;
  }
  
  public void moveCamera(CameraUpdate paramCameraUpdate)
  {
    AppMethodBeat.i(186240);
    if (this.a == null)
    {
      AppMethodBeat.o(186240);
      return;
    }
    if (paramCameraUpdate != null) {
      this.a.moveCamera(q.a(paramCameraUpdate, this.a));
    }
    AppMethodBeat.o(186240);
  }
  
  public void removeTencentMapGestureListener(TencentMap.TencentMapGestureListener paramTencentMapGestureListener)
  {
    AppMethodBeat.i(186271);
    this.a.removeTencentMapGestureListener(this.e);
    AppMethodBeat.o(186271);
  }
  
  public void scrollBy(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(186243);
    if (this.a == null)
    {
      AppMethodBeat.o(186243);
      return;
    }
    this.a.animateCamera(CameraUpdateFactory.scrollBy(paramFloat1, paramFloat2));
    AppMethodBeat.o(186243);
  }
  
  public void scrollBy(float paramFloat1, float paramFloat2, long paramLong, final CancelableCallback paramCancelableCallback)
  {
    AppMethodBeat.i(186244);
    if (this.a == null)
    {
      AppMethodBeat.o(186244);
      return;
    }
    this.a.animateCamera(CameraUpdateFactory.scrollBy(paramFloat1, paramFloat2), new TencentMap.CancelableCallback()
    {
      public void onCancel()
      {
        AppMethodBeat.i(186336);
        if (paramCancelableCallback != null) {
          paramCancelableCallback.onCancel();
        }
        AppMethodBeat.o(186336);
      }
      
      public void onFinish()
      {
        AppMethodBeat.i(186335);
        if (paramCancelableCallback != null) {
          paramCancelableCallback.onFinish();
        }
        AppMethodBeat.o(186335);
      }
    });
    AppMethodBeat.o(186244);
  }
  
  public void set3DEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(186286);
    if (this.a == null)
    {
      AppMethodBeat.o(186286);
      return;
    }
    this.a.setBuildingEnable(paramBoolean);
    AppMethodBeat.o(186286);
  }
  
  public void setCenter(com.tencent.mapsdk.raster.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(186224);
    if (this.a == null)
    {
      AppMethodBeat.o(186224);
      return;
    }
    if (paramLatLng != null) {
      this.a.moveCamera(CameraUpdateFactory.newLatLng(new com.tencent.tencentmap.mapsdk.maps.model.LatLng(paramLatLng.getLatitude(), paramLatLng.getLongitude())));
    }
    AppMethodBeat.o(186224);
  }
  
  @Deprecated
  public void setErrorListener(TencentMap.OnErrorListener paramOnErrorListener)
  {
    if (this.a == null) {}
  }
  
  public void setForeignLanguage(Language paramLanguage)
  {
    AppMethodBeat.i(186272);
    if (this.a == null)
    {
      AppMethodBeat.o(186272);
      return;
    }
    this.a.setForeignLanguage(q.a(paramLanguage));
    AppMethodBeat.o(186272);
  }
  
  public void setHandDrawMapEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(186288);
    if (this.a == null)
    {
      AppMethodBeat.o(186288);
      return;
    }
    this.a.setHandDrawMapEnable(paramBoolean);
    AppMethodBeat.o(186288);
  }
  
  public void setIndoorEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(186263);
    if (this.a == null)
    {
      AppMethodBeat.o(186263);
      return;
    }
    this.a.setIndoorEnabled(paramBoolean);
    AppMethodBeat.o(186263);
  }
  
  public void setIndoorFloor(int paramInt)
  {
    AppMethodBeat.i(186264);
    if (this.a == null)
    {
      AppMethodBeat.o(186264);
      return;
    }
    this.a.setIndoorFloor(paramInt);
    AppMethodBeat.o(186264);
  }
  
  public void setIndoorFloor(String paramString1, String paramString2)
  {
    AppMethodBeat.i(186265);
    if (this.a == null)
    {
      AppMethodBeat.o(186265);
      return;
    }
    this.a.setIndoorFloor(paramString1, paramString2);
    AppMethodBeat.o(186265);
  }
  
  public void setInfoWindowAdapter(final com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter paramInfoWindowAdapter)
  {
    AppMethodBeat.i(186251);
    if (this.a == null)
    {
      AppMethodBeat.o(186251);
      return;
    }
    this.a.setInfoWindowAdapter(new com.tencent.tencentmap.mapsdk.maps.TencentMap.InfoWindowAdapter()
    {
      public View getInfoContents(com.tencent.tencentmap.mapsdk.maps.model.Marker paramAnonymousMarker)
      {
        return null;
      }
      
      public View getInfoWindow(com.tencent.tencentmap.mapsdk.maps.model.Marker paramAnonymousMarker)
      {
        AppMethodBeat.i(186385);
        if (paramInfoWindowAdapter != null)
        {
          paramAnonymousMarker = paramInfoWindowAdapter.getInfoWindow(n.a(n.this, paramAnonymousMarker));
          AppMethodBeat.o(186385);
          return paramAnonymousMarker;
        }
        AppMethodBeat.o(186385);
        return null;
      }
    });
    AppMethodBeat.o(186251);
  }
  
  public void setMapAnchor(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(186287);
    if (this.a == null)
    {
      AppMethodBeat.o(186287);
      return;
    }
    this.a.setCameraCenterProportion(paramFloat1, paramFloat2, false);
    this.a.getUiSettings().setGestureScaleByMapCenter(true);
    AppMethodBeat.o(186287);
  }
  
  public void setMapStyle(int paramInt)
  {
    AppMethodBeat.i(186261);
    if (this.a == null)
    {
      AppMethodBeat.o(186261);
      return;
    }
    this.a.setMapStyle(paramInt);
    AppMethodBeat.o(186261);
  }
  
  public void setMapType(int paramInt)
  {
    AppMethodBeat.i(186277);
    if (this.a == null)
    {
      AppMethodBeat.o(186277);
      return;
    }
    this.a.setMapType(paramInt);
    AppMethodBeat.o(186277);
  }
  
  public void setOnIndoorStateChangeListener(final com.tencent.tencentmap.mapsdk.map.TencentMap.OnIndoorStateChangeListener paramOnIndoorStateChangeListener)
  {
    AppMethodBeat.i(186262);
    if (this.a == null)
    {
      AppMethodBeat.o(186262);
      return;
    }
    this.a.setOnIndoorStateChangeListener(new com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener()
    {
      public boolean onIndoorBuildingDeactivated()
      {
        AppMethodBeat.i(186138);
        if (paramOnIndoorStateChangeListener == null)
        {
          AppMethodBeat.o(186138);
          return false;
        }
        boolean bool = paramOnIndoorStateChangeListener.onIndoorBuildingDeactivated();
        AppMethodBeat.o(186138);
        return bool;
      }
      
      public boolean onIndoorBuildingFocused()
      {
        AppMethodBeat.i(186136);
        if (paramOnIndoorStateChangeListener == null)
        {
          AppMethodBeat.o(186136);
          return false;
        }
        boolean bool = paramOnIndoorStateChangeListener.onIndoorBuildingFocused();
        AppMethodBeat.o(186136);
        return bool;
      }
      
      public boolean onIndoorLevelActivated(IndoorBuilding paramAnonymousIndoorBuilding)
      {
        AppMethodBeat.i(186137);
        if (paramOnIndoorStateChangeListener == null)
        {
          AppMethodBeat.o(186137);
          return false;
        }
        boolean bool = paramOnIndoorStateChangeListener.onIndoorLevelActivated(q.a(paramAnonymousIndoorBuilding));
        AppMethodBeat.o(186137);
        return bool;
      }
    });
    AppMethodBeat.o(186262);
  }
  
  public void setOnInfoWindowClickListener(final com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    AppMethodBeat.i(186255);
    if (this.a == null)
    {
      AppMethodBeat.o(186255);
      return;
    }
    this.a.setOnInfoWindowClickListener(new com.tencent.tencentmap.mapsdk.maps.TencentMap.OnInfoWindowClickListener()
    {
      public void onInfoWindowClick(com.tencent.tencentmap.mapsdk.maps.model.Marker paramAnonymousMarker)
      {
        AppMethodBeat.i(186184);
        paramOnInfoWindowClickListener.onInfoWindowClick(n.a(n.this, paramAnonymousMarker));
        AppMethodBeat.o(186184);
      }
      
      public void onInfoWindowClickLocation(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4) {}
    });
    AppMethodBeat.o(186255);
  }
  
  public void setOnMapCameraChangeListener(final TencentMap.OnMapCameraChangeListener paramOnMapCameraChangeListener)
  {
    AppMethodBeat.i(186257);
    if (this.a == null)
    {
      AppMethodBeat.o(186257);
      return;
    }
    this.a.setOnCameraChangeListener(new TencentMap.OnCameraChangeListener()
    {
      public void onCameraChange(com.tencent.tencentmap.mapsdk.maps.model.CameraPosition paramAnonymousCameraPosition)
      {
        AppMethodBeat.i(186142);
        if (paramOnMapCameraChangeListener != null) {
          paramOnMapCameraChangeListener.onCameraChange(q.a(paramAnonymousCameraPosition));
        }
        AppMethodBeat.o(186142);
      }
      
      public void onCameraChangeFinished(com.tencent.tencentmap.mapsdk.maps.model.CameraPosition paramAnonymousCameraPosition)
      {
        AppMethodBeat.i(186143);
        if (paramOnMapCameraChangeListener != null) {
          paramOnMapCameraChangeListener.onCameraChangeFinish(q.a(paramAnonymousCameraPosition));
        }
        AppMethodBeat.o(186143);
      }
    });
    AppMethodBeat.o(186257);
  }
  
  public void setOnMapClickListener(final com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener paramOnMapClickListener)
  {
    AppMethodBeat.i(186258);
    if (this.a == null)
    {
      AppMethodBeat.o(186258);
      return;
    }
    this.a.setOnMapClickListener(new com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapClickListener()
    {
      public void onMapClick(com.tencent.tencentmap.mapsdk.maps.model.LatLng paramAnonymousLatLng)
      {
        AppMethodBeat.i(186185);
        if (paramOnMapClickListener != null) {
          paramOnMapClickListener.onMapClick(q.a(paramAnonymousLatLng));
        }
        AppMethodBeat.o(186185);
      }
    });
    AppMethodBeat.o(186258);
  }
  
  public void setOnMapLoadedListener(final TencentMap.OnMapLoadedListener paramOnMapLoadedListener)
  {
    AppMethodBeat.i(186254);
    if (this.a == null)
    {
      AppMethodBeat.o(186254);
      return;
    }
    this.a.setOnMapLoadedCallback(new TencentMap.OnMapLoadedCallback()
    {
      public void onMapLoaded()
      {
        AppMethodBeat.i(186401);
        if (paramOnMapLoadedListener != null) {
          paramOnMapLoadedListener.onMapLoaded();
        }
        AppMethodBeat.o(186401);
      }
    });
    AppMethodBeat.o(186254);
  }
  
  public void setOnMapLongClickListener(final com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener paramOnMapLongClickListener)
  {
    AppMethodBeat.i(186259);
    if (this.a == null)
    {
      AppMethodBeat.o(186259);
      return;
    }
    this.a.setOnMapLongClickListener(new com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLongClickListener()
    {
      public void onMapLongClick(com.tencent.tencentmap.mapsdk.maps.model.LatLng paramAnonymousLatLng)
      {
        AppMethodBeat.i(186140);
        if (paramOnMapLongClickListener != null) {
          paramOnMapLongClickListener.onMapLongClick(q.a(paramAnonymousLatLng));
        }
        AppMethodBeat.o(186140);
      }
    });
    AppMethodBeat.o(186259);
  }
  
  public void setOnMapPoiClickListener(final com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapPoiClickListener paramOnMapPoiClickListener)
  {
    AppMethodBeat.i(186260);
    if (this.a == null)
    {
      AppMethodBeat.o(186260);
      return;
    }
    this.a.setOnMapPoiClickListener(new com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapPoiClickListener()
    {
      public void onClicked(MapPoi paramAnonymousMapPoi)
      {
        AppMethodBeat.i(186205);
        if (paramOnMapPoiClickListener != null) {
          paramOnMapPoiClickListener.onClicked(q.a(paramAnonymousMapPoi));
        }
        AppMethodBeat.o(186205);
      }
    });
    AppMethodBeat.o(186260);
  }
  
  public void setOnMarkerClickListener(final com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    AppMethodBeat.i(186256);
    if (this.a == null)
    {
      AppMethodBeat.o(186256);
      return;
    }
    this.a.setOnMarkerClickListener(new com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerClickListener()
    {
      public boolean onMarkerClick(com.tencent.tencentmap.mapsdk.maps.model.Marker paramAnonymousMarker)
      {
        AppMethodBeat.i(186141);
        if (paramOnMarkerClickListener != null)
        {
          boolean bool = paramOnMarkerClickListener.onMarkerClick(n.a(n.this, paramAnonymousMarker));
          AppMethodBeat.o(186141);
          return bool;
        }
        AppMethodBeat.o(186141);
        return false;
      }
    });
    AppMethodBeat.o(186256);
  }
  
  public void setOnMarkerDraggedListener(final TencentMap.OnMarkerDraggedListener paramOnMarkerDraggedListener)
  {
    AppMethodBeat.i(186253);
    if (this.a == null)
    {
      AppMethodBeat.o(186253);
      return;
    }
    this.a.setOnMarkerDragListener(new TencentMap.OnMarkerDragListener()
    {
      public void onMarkerDrag(com.tencent.tencentmap.mapsdk.maps.model.Marker paramAnonymousMarker)
      {
        AppMethodBeat.i(186319);
        if (paramOnMarkerDraggedListener != null) {
          paramOnMarkerDraggedListener.onMarkerDrag(n.a(n.this, paramAnonymousMarker));
        }
        AppMethodBeat.o(186319);
      }
      
      public void onMarkerDragEnd(com.tencent.tencentmap.mapsdk.maps.model.Marker paramAnonymousMarker)
      {
        AppMethodBeat.i(186320);
        if (paramOnMarkerDraggedListener != null) {
          paramOnMarkerDraggedListener.onMarkerDragEnd(n.a(n.this, paramAnonymousMarker));
        }
        AppMethodBeat.o(186320);
      }
      
      public void onMarkerDragStart(com.tencent.tencentmap.mapsdk.maps.model.Marker paramAnonymousMarker)
      {
        AppMethodBeat.i(186318);
        if (paramOnMarkerDraggedListener != null) {
          paramOnMarkerDraggedListener.onMarkerDragStart(n.a(n.this, paramAnonymousMarker));
        }
        AppMethodBeat.o(186318);
      }
    });
    AppMethodBeat.o(186253);
  }
  
  public void setPoisEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(186276);
    if (this.a == null)
    {
      AppMethodBeat.o(186276);
      return;
    }
    this.a.setPoisEnabled(paramBoolean);
    AppMethodBeat.o(186276);
  }
  
  public void setSatelliteEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(186239);
    if (this.a == null)
    {
      AppMethodBeat.o(186239);
      return;
    }
    this.d = paramBoolean;
    this.a.setSatelliteEnabled(paramBoolean);
    AppMethodBeat.o(186239);
  }
  
  public void setTencentMapGestureListener(final TencentMap.TencentMapGestureListener paramTencentMapGestureListener)
  {
    AppMethodBeat.i(186270);
    if ((this.a == null) || (paramTencentMapGestureListener == null))
    {
      AppMethodBeat.o(186270);
      return;
    }
    if (this.e != null) {
      this.a.removeTencentMapGestureListener(this.e);
    }
    this.e = new TencentMapGestureListener()
    {
      public boolean onDoubleTap(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(186170);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(186170);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onDoubleTap(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(186170);
        return bool;
      }
      
      public boolean onDown(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(186175);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(186175);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onDown(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(186175);
        return bool;
      }
      
      public boolean onFling(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(186172);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(186172);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onFling(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(186172);
        return bool;
      }
      
      public boolean onLongPress(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(186174);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(186174);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onLongPress(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(186174);
        return bool;
      }
      
      public void onMapStable()
      {
        AppMethodBeat.i(186177);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(186177);
          return;
        }
        paramTencentMapGestureListener.onMapStable();
        AppMethodBeat.o(186177);
      }
      
      public boolean onScroll(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(186173);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(186173);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onScroll(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(186173);
        return bool;
      }
      
      public boolean onSingleTap(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(186171);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(186171);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onSingleTap(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(186171);
        return bool;
      }
      
      public boolean onUp(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(186176);
        if (paramTencentMapGestureListener == null)
        {
          AppMethodBeat.o(186176);
          return false;
        }
        boolean bool = paramTencentMapGestureListener.onUp(paramAnonymousFloat1, paramAnonymousFloat2);
        AppMethodBeat.o(186176);
        return bool;
      }
    };
    this.a.setTencentMapGestureListener(this.e);
    AppMethodBeat.o(186270);
  }
  
  public void setTrafficEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(186284);
    if (this.a == null)
    {
      AppMethodBeat.o(186284);
      return;
    }
    this.a.setTrafficEnabled(paramBoolean);
    AppMethodBeat.o(186284);
  }
  
  public void setZoom(int paramInt)
  {
    AppMethodBeat.i(186225);
    if (this.a == null)
    {
      AppMethodBeat.o(186225);
      return;
    }
    this.a.moveCamera(CameraUpdateFactory.zoomTo(paramInt));
    AppMethodBeat.o(186225);
  }
  
  public void stopAnimation()
  {
    AppMethodBeat.i(186281);
    if (this.a == null)
    {
      AppMethodBeat.o(186281);
      return;
    }
    this.a.stopAnimation();
    AppMethodBeat.o(186281);
  }
  
  public void zoomIn()
  {
    AppMethodBeat.i(186245);
    if (this.a == null)
    {
      AppMethodBeat.o(186245);
      return;
    }
    this.a.animateCamera(CameraUpdateFactory.zoomIn());
    AppMethodBeat.o(186245);
  }
  
  public void zoomInFixing(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186246);
    if (this.a == null)
    {
      AppMethodBeat.o(186246);
      return;
    }
    this.a.moveCamera(CameraUpdateFactory.zoomBy(1.0F, new Point(paramInt1, paramInt2)));
    AppMethodBeat.o(186246);
  }
  
  public void zoomOut()
  {
    AppMethodBeat.i(186247);
    if (this.a == null)
    {
      AppMethodBeat.o(186247);
      return;
    }
    this.a.animateCamera(CameraUpdateFactory.zoomOut());
    AppMethodBeat.o(186247);
  }
  
  public void zoomOutFixing(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186248);
    if (this.a == null)
    {
      AppMethodBeat.o(186248);
      return;
    }
    this.a.moveCamera(CameraUpdateFactory.zoomBy(-1.0F, new Point(paramInt1, paramInt2)));
    AppMethodBeat.o(186248);
  }
  
  public void zoomToSpan(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(186250);
    zoomToSpan(new com.tencent.mapsdk.raster.model.LatLng(getMapCenter().getLatitude() - paramDouble1 / 2.0D, getMapCenter().getLongitude() + paramDouble2 / 2.0D), new com.tencent.mapsdk.raster.model.LatLng(getMapCenter().getLatitude() + paramDouble1 / 2.0D, getMapCenter().getLongitude() - paramDouble2 / 2.0D));
    AppMethodBeat.o(186250);
  }
  
  public void zoomToSpan(com.tencent.mapsdk.raster.model.LatLng paramLatLng1, com.tencent.mapsdk.raster.model.LatLng paramLatLng2)
  {
    AppMethodBeat.i(186249);
    if (this.a == null)
    {
      AppMethodBeat.o(186249);
      return;
    }
    this.a.moveCamera(CameraUpdateFactory.newLatLngBounds(new LatLngBounds(q.a(paramLatLng1), q.a(paramLatLng2)), 0));
    AppMethodBeat.o(186249);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.n
 * JD-Core Version:    0.7.0.1
 */