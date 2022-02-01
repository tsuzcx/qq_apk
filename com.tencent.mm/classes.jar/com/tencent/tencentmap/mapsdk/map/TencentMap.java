package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import com.tencent.map.sdk.comps.vis.VisualLayer;
import com.tencent.map.sdk.comps.vis.VisualLayerOptions;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.CustomLayer;
import com.tencent.mapsdk.raster.model.CustomLayerOptions;
import com.tencent.mapsdk.raster.model.IndoorBuilding;
import com.tencent.mapsdk.raster.model.Language;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.raster.model.Polygon;
import com.tencent.mapsdk.raster.model.PolygonOptions;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.mapsdk.raster.model.TileOverlay;
import com.tencent.mapsdk.raster.model.TileOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Arc;
import com.tencent.tencentmap.mapsdk.maps.model.ArcOptions;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;

public abstract interface TencentMap
  extends MapController
{
  @Deprecated
  public static final int MAP_STYLE_ID_NIGHT = 8;
  public static final int MAP_STYLE_ID_NORMAL = 0;
  public static final int MAP_TYPE_DARK = 1008;
  public static final int MAP_TYPE_NORMAL = 1000;
  public static final int MAP_TYPE_SATELLITE = 1011;
  
  public abstract Arc addArc(ArcOptions paramArcOptions);
  
  public abstract Circle addCircle(CircleOptions paramCircleOptions);
  
  public abstract CustomLayer addCustomLayer(CustomLayerOptions paramCustomLayerOptions);
  
  public abstract GroundOverlay addGroundOverlay(GroundOverlayOptions paramGroundOverlayOptions);
  
  public abstract void addInfoWindowAdapter(InfoWindowAdapter paramInfoWindowAdapter);
  
  public abstract Marker addMarker(MarkerOptions paramMarkerOptions);
  
  public abstract void addOnInfoWindowClickListener(TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener);
  
  public abstract void addOnMapCameraChangeListener(OnMapCameraChangeListener paramOnMapCameraChangeListener);
  
  public abstract void addOnMapClickListener(TencentMap.OnMapClickListener paramOnMapClickListener);
  
  public abstract void addOnMapLoadedListener(OnMapLoadedListener paramOnMapLoadedListener);
  
  public abstract void addOnMapLongClickListener(OnMapLongClickListener paramOnMapLongClickListener);
  
  public abstract void addOnMarkerClickListener(TencentMap.OnMarkerClickListener paramOnMarkerClickListener);
  
  public abstract void addOnMarkerDraggedListener(OnMarkerDraggedListener paramOnMarkerDraggedListener);
  
  public abstract Polygon addPolygon(PolygonOptions paramPolygonOptions);
  
  public abstract Polyline addPolyline(PolylineOptions paramPolylineOptions);
  
  public abstract TileOverlay addTileOverlay(TileOverlayOptions paramTileOverlayOptions);
  
  public abstract VisualLayer addVisualLayer(VisualLayerOptions paramVisualLayerOptions);
  
  public abstract void animateCamera(CameraUpdate paramCameraUpdate);
  
  public abstract void animateCamera(CameraUpdate paramCameraUpdate, long paramLong, CancelableCallback paramCancelableCallback);
  
  public abstract void clearAllOverlays();
  
  public abstract boolean clearCache();
  
  public abstract void enableMultipleInfowindow(boolean paramBoolean);
  
  public abstract String getActivedIndoorBuilding(LatLng paramLatLng);
  
  public abstract String[] getActivedIndoorFloorNames();
  
  public abstract CameraPosition getCameraPosition();
  
  public abstract String getDebugError();
  
  public abstract int getIndoorFloorId();
  
  public abstract LatLng getMapCenter();
  
  public abstract int getMapType();
  
  public abstract int getMaxZoomLevel();
  
  public abstract int getMinZoomLevel();
  
  public abstract Projection getProjection();
  
  public abstract void getScreenShot(OnScreenShotListener paramOnScreenShotListener);
  
  public abstract void getScreenShot(OnScreenShotListener paramOnScreenShotListener, Rect paramRect);
  
  public abstract String getVersion();
  
  public abstract int getZoomLevel();
  
  public abstract boolean isAppKeyAvailable();
  
  public abstract boolean isHandDrawMapEnable();
  
  public abstract boolean isSatelliteEnabled();
  
  public abstract boolean isTrafficEnabled();
  
  public abstract void moveCamera(CameraUpdate paramCameraUpdate);
  
  public abstract void remmoveOnInfoWindowClickListener(TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener);
  
  public abstract void removeInfoWindowAdapter(InfoWindowAdapter paramInfoWindowAdapter);
  
  public abstract void removeOnMapCameraChangeListener(OnMapCameraChangeListener paramOnMapCameraChangeListener);
  
  public abstract void removeOnMapClickListener(TencentMap.OnMapClickListener paramOnMapClickListener);
  
  public abstract void removeOnMapLoadedListener(OnMapLoadedListener paramOnMapLoadedListener);
  
  public abstract void removeOnMapLongClickListener(OnMapLongClickListener paramOnMapLongClickListener);
  
  public abstract void removeOnMarkerClickListener(TencentMap.OnMarkerClickListener paramOnMarkerClickListener);
  
  public abstract void removeOnMarkerDraggedListener(OnMarkerDraggedListener paramOnMarkerDraggedListener);
  
  public abstract void removeTencentMapGestureListener(TencentMapGestureListener paramTencentMapGestureListener);
  
  public abstract void scrollBy(float paramFloat1, float paramFloat2);
  
  public abstract void scrollBy(float paramFloat1, float paramFloat2, long paramLong, CancelableCallback paramCancelableCallback);
  
  public abstract void set3DEnable(boolean paramBoolean);
  
  public abstract void setBuilding3dEffectEnable(boolean paramBoolean);
  
  public abstract void setErrorListener(TencentMap.OnErrorListener paramOnErrorListener);
  
  public abstract void setForeignLanguage(Language paramLanguage);
  
  public abstract void setHandDrawMapEnable(boolean paramBoolean);
  
  public abstract void setIndoorEnabled(boolean paramBoolean);
  
  public abstract void setIndoorFloor(int paramInt);
  
  public abstract void setIndoorFloor(String paramString1, String paramString2);
  
  public abstract void setIndoorMaskColor(int paramInt);
  
  public abstract void setInfoWindowAdapter(InfoWindowAdapter paramInfoWindowAdapter);
  
  public abstract void setMapAnchor(float paramFloat1, float paramFloat2);
  
  public abstract void setMapBoundary(LatLngBounds paramLatLngBounds);
  
  public abstract void setMapStyle(int paramInt);
  
  public abstract void setMapType(int paramInt);
  
  public abstract void setMaxZoomLevel(int paramInt);
  
  public abstract void setMinZoomLevel(int paramInt);
  
  public abstract void setOnIndoorStateChangeListener(OnIndoorStateChangeListener paramOnIndoorStateChangeListener);
  
  public abstract void setOnInfoWindowClickListener(TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener);
  
  public abstract void setOnMapCameraChangeListener(OnMapCameraChangeListener paramOnMapCameraChangeListener);
  
  public abstract void setOnMapClickListener(TencentMap.OnMapClickListener paramOnMapClickListener);
  
  public abstract void setOnMapLoadedListener(OnMapLoadedListener paramOnMapLoadedListener);
  
  public abstract void setOnMapLongClickListener(OnMapLongClickListener paramOnMapLongClickListener);
  
  public abstract void setOnMapPoiClickListener(TencentMap.OnMapPoiClickListener paramOnMapPoiClickListener);
  
  public abstract void setOnMarkerClickListener(TencentMap.OnMarkerClickListener paramOnMarkerClickListener);
  
  public abstract void setOnMarkerDraggedListener(OnMarkerDraggedListener paramOnMarkerDraggedListener);
  
  public abstract void setPoisEnabled(boolean paramBoolean);
  
  public abstract void setSatelliteEnabled(boolean paramBoolean);
  
  public abstract void setTencentMapGestureListener(TencentMapGestureListener paramTencentMapGestureListener);
  
  public abstract void setTrafficEnabled(boolean paramBoolean);
  
  public abstract void showBuilding(boolean paramBoolean);
  
  public abstract void stopAnimation();
  
  public abstract void zoomIn();
  
  public abstract void zoomInFixing(int paramInt1, int paramInt2);
  
  public abstract void zoomOut();
  
  public abstract void zoomOutFixing(int paramInt1, int paramInt2);
  
  public abstract void zoomToSpan(double paramDouble1, double paramDouble2);
  
  public abstract void zoomToSpan(LatLng paramLatLng1, LatLng paramLatLng2);
  
  public static abstract interface InfoWindowAdapter
  {
    public abstract View getInfoWindow(Marker paramMarker);
    
    public abstract void onInfoWindowDettached(Marker paramMarker, View paramView);
  }
  
  public static abstract interface OnIndoorStateChangeListener
  {
    public abstract boolean onIndoorBuildingDeactivated();
    
    public abstract boolean onIndoorBuildingFocused();
    
    public abstract boolean onIndoorLevelActivated(IndoorBuilding paramIndoorBuilding);
  }
  
  public static abstract interface OnMapCameraChangeListener
  {
    public abstract void onCameraChange(CameraPosition paramCameraPosition);
    
    public abstract void onCameraChangeFinish(CameraPosition paramCameraPosition);
  }
  
  public static abstract interface OnMapLoadedListener
  {
    public abstract void onMapLoaded();
  }
  
  public static abstract interface OnMapLongClickListener
  {
    public abstract void onMapLongClick(LatLng paramLatLng);
  }
  
  public static abstract interface OnMarkerDraggedListener
  {
    public abstract void onMarkerDrag(Marker paramMarker);
    
    public abstract void onMarkerDragEnd(Marker paramMarker);
    
    public abstract void onMarkerDragStart(Marker paramMarker);
  }
  
  public static abstract interface OnScreenShotListener
  {
    public abstract void onMapScreenShot(Bitmap paramBitmap);
  }
  
  public static abstract interface TencentMapGestureListener
  {
    public abstract boolean onDoubleTap(float paramFloat1, float paramFloat2);
    
    public abstract boolean onDown(float paramFloat1, float paramFloat2);
    
    public abstract boolean onFling(float paramFloat1, float paramFloat2);
    
    public abstract boolean onLongPress(float paramFloat1, float paramFloat2);
    
    public abstract void onMapStable();
    
    public abstract boolean onScroll(float paramFloat1, float paramFloat2);
    
    public abstract boolean onSingleTap(float paramFloat1, float paramFloat2);
    
    public abstract boolean onUp(float paramFloat1, float paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.TencentMap
 * JD-Core Version:    0.7.0.1
 */