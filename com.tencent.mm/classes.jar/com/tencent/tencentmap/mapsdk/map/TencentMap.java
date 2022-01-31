package com.tencent.tencentmap.mapsdk.map;

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

public abstract interface TencentMap
  extends MapController
{
  @Deprecated
  public static final int MAP_STYLE_ID_NIGHT = 8;
  public static final int MAP_STYLE_ID_NORMAL = 0;
  public static final String VERSION = "1.0.6";
  
  public abstract Circle addCircle(CircleOptions paramCircleOptions);
  
  public abstract Marker addMarker(MarkerOptions paramMarkerOptions);
  
  public abstract Polygon addPolygon(PolygonOptions paramPolygonOptions);
  
  public abstract Polyline addPolyline(PolylineOptions paramPolylineOptions);
  
  public abstract void animateCamera(CameraUpdate paramCameraUpdate);
  
  public abstract void animateCamera(CameraUpdate paramCameraUpdate, long paramLong, CancelableCallback paramCancelableCallback);
  
  public abstract void clearAllOverlays();
  
  public abstract boolean clearCache();
  
  public abstract void enableMultipleInfowindow(boolean paramBoolean);
  
  public abstract String getActivedIndoorBuilding(LatLng paramLatLng);
  
  public abstract String[] getActivedIndoorFloorNames();
  
  public abstract int getIndoorFloorId();
  
  public abstract LatLng getMapCenter();
  
  public abstract int getMaxZoomLevel();
  
  public abstract int getMinZoomLevel();
  
  public abstract void getScreenShot(TencentMap.OnScreenShotListener paramOnScreenShotListener);
  
  public abstract void getScreenShot(TencentMap.OnScreenShotListener paramOnScreenShotListener, Rect paramRect);
  
  public abstract String getVersion();
  
  public abstract int getZoomLevel();
  
  public abstract boolean isAppKeyAvailable();
  
  public abstract boolean isHandDrawMapEnable();
  
  public abstract boolean isSatelliteEnabled();
  
  public abstract boolean isTrafficEnabled();
  
  public abstract void moveCamera(CameraUpdate paramCameraUpdate);
  
  public abstract void removeTencentMapGestureListener(TencentMap.TencentMapGestureListener paramTencentMapGestureListener);
  
  public abstract void scrollBy(float paramFloat1, float paramFloat2);
  
  public abstract void scrollBy(float paramFloat1, float paramFloat2, long paramLong, CancelableCallback paramCancelableCallback);
  
  public abstract void set3DEnable(boolean paramBoolean);
  
  public abstract void setErrorListener(TencentMap.OnErrorListener paramOnErrorListener);
  
  public abstract void setForeignLanguage(Language paramLanguage);
  
  public abstract void setHandDrawMapEnable(boolean paramBoolean);
  
  public abstract void setIndoorEnabled(boolean paramBoolean);
  
  public abstract void setIndoorFloor(int paramInt);
  
  public abstract void setIndoorFloor(String paramString1, String paramString2);
  
  public abstract void setInfoWindowAdapter(TencentMap.InfoWindowAdapter paramInfoWindowAdapter);
  
  public abstract void setMapAnchor(float paramFloat1, float paramFloat2);
  
  public abstract void setMapStyle(int paramInt);
  
  public abstract void setOnIndoorStateChangeListener(TencentMap.OnIndoorStateChangeListener paramOnIndoorStateChangeListener);
  
  public abstract void setOnInfoWindowClickListener(TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener);
  
  public abstract void setOnMapCameraChangeListener(OnMapCameraChangeListener paramOnMapCameraChangeListener);
  
  public abstract void setOnMapClickListener(TencentMap.OnMapClickListener paramOnMapClickListener);
  
  public abstract void setOnMapLoadedListener(TencentMap.OnMapLoadedListener paramOnMapLoadedListener);
  
  public abstract void setOnMapLongClickListener(OnMapLongClickListener paramOnMapLongClickListener);
  
  public abstract void setOnMapPoiClickListener(TencentMap.OnMapPoiClickListener paramOnMapPoiClickListener);
  
  public abstract void setOnMarkerClickListener(TencentMap.OnMarkerClickListener paramOnMarkerClickListener);
  
  public abstract void setOnMarkerDraggedListener(TencentMap.OnMarkerDraggedListener paramOnMarkerDraggedListener);
  
  public abstract void setSatelliteEnabled(boolean paramBoolean);
  
  public abstract void setTencentMapGestureListener(TencentMap.TencentMapGestureListener paramTencentMapGestureListener);
  
  public abstract void setTrafficEnabled(boolean paramBoolean);
  
  public abstract void stopAnimation();
  
  public abstract void zoomIn();
  
  public abstract void zoomInFixing(int paramInt1, int paramInt2);
  
  public abstract void zoomOut();
  
  public abstract void zoomOutFixing(int paramInt1, int paramInt2);
  
  public abstract void zoomToSpan(double paramDouble1, double paramDouble2);
  
  public abstract void zoomToSpan(LatLng paramLatLng1, LatLng paramLatLng2);
  
  public static abstract interface OnMapCameraChangeListener
  {
    public abstract void onCameraChange(CameraPosition paramCameraPosition);
    
    public abstract void onCameraChangeFinish(CameraPosition paramCameraPosition);
  }
  
  public static abstract interface OnMapLongClickListener
  {
    public abstract void onMapLongClick(LatLng paramLatLng);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.TencentMap
 * JD-Core Version:    0.7.0.1
 */