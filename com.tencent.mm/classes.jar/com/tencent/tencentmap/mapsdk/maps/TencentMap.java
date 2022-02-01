package com.tencent.tencentmap.mapsdk.maps;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.view.View;
import com.tencent.map.lib.MapLanguage;
import com.tencent.map.sdk.comps.indoor.IIndoor;
import com.tencent.map.sdk.comps.mylocation.IMyLocation;
import com.tencent.tencentmap.mapsdk.maps.model.AoiLayer;
import com.tencent.tencentmap.mapsdk.maps.model.AoiLayer.OnAoiLayerLoadListener;
import com.tencent.tencentmap.mapsdk.maps.model.AoiLayerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Arc;
import com.tencent.tencentmap.mapsdk.maps.model.ArcOptions;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.Circle;
import com.tencent.tencentmap.mapsdk.maps.model.CircleOptions;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayer;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.IOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider;
import com.tencent.tencentmap.mapsdk.maps.model.Polygon;
import com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import com.tencent.tencentmap.mapsdk.maps.model.RestrictBoundsFitMode;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlayOptions;
import java.util.List;

public abstract interface TencentMap
  extends IIndoor, IMyLocation
{
  public static final int MAP_MODE_NAV = 12;
  public static final int MAP_MODE_NAV_NIGHT = 1013;
  public static final int MAP_MODE_NAV_TRAFFIC = 1009;
  public static final int MAP_MODE_NORMAL = 0;
  public static final int MAP_MODE_NORMAL_TRAFFIC = 5;
  public static final int MAP_TYPE_DARK = 1008;
  public static final int MAP_TYPE_NAVI = 1012;
  public static final int MAP_TYPE_NIGHT = 1013;
  public static final int MAP_TYPE_NONE = -1;
  public static final int MAP_TYPE_NORMAL = 1000;
  public static final int MAP_TYPE_SATELLITE = 1011;
  public static final int MAP_TYPE_TRAFFIC_NAVI = 1009;
  public static final int MAP_TYPE_TRAFFIC_NIGHT = 1010;
  
  public abstract AoiLayer addAoiLayer(String paramString, AoiLayerOptions paramAoiLayerOptions, AoiLayer.OnAoiLayerLoadListener paramOnAoiLayerLoadListener);
  
  public abstract Arc addArc(ArcOptions paramArcOptions);
  
  public abstract Circle addCircle(CircleOptions paramCircleOptions);
  
  public abstract CustomLayer addCustomLayer(CustomLayerOptions paramCustomLayerOptions);
  
  public abstract GroundOverlay addGroundOverlay(GroundOverlayOptions paramGroundOverlayOptions);
  
  public abstract Marker addMarker(MarkerOptions paramMarkerOptions);
  
  public abstract void addOnMapLoadedCallback(OnMapLoadedCallback paramOnMapLoadedCallback);
  
  public abstract Polygon addPolygon(PolygonOptions paramPolygonOptions);
  
  public abstract Polyline addPolyline(PolylineOptions paramPolylineOptions);
  
  public abstract void addTencentMapGestureListener(TencentMapGestureListener paramTencentMapGestureListener);
  
  public abstract TileOverlay addTileOverlay(TileOverlayOptions paramTileOverlayOptions);
  
  public abstract VectorHeatOverlay addVectorHeatOverlay(VectorHeatOverlayOptions paramVectorHeatOverlayOptions);
  
  public abstract void animateCamera(CameraUpdate paramCameraUpdate);
  
  public abstract void animateCamera(CameraUpdate paramCameraUpdate, long paramLong, CancelableCallback paramCancelableCallback);
  
  public abstract void animateCamera(CameraUpdate paramCameraUpdate, CancelableCallback paramCancelableCallback);
  
  public abstract CameraPosition calculateZoomToSpanLevel(List<IOverlay> paramList, List<LatLng> paramList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void clear();
  
  public abstract void clearAllOverlays();
  
  public abstract void clearCache();
  
  public abstract void enableMultipleInfowindow(boolean paramBoolean);
  
  public abstract List<LatLng> getBounderPoints(Marker paramMarker);
  
  public abstract CameraPosition getCameraPosition();
  
  public abstract String getCityName(LatLng paramLatLng);
  
  public abstract String getDebugError();
  
  public abstract MapLanguage getLanguage();
  
  public abstract <T extends TencentMapComponent.Component> T getMapComponent(Class<T> paramClass);
  
  public abstract TencentMapContext getMapContext();
  
  public abstract int getMapHeight();
  
  public abstract Rect getMapPadding();
  
  public abstract int getMapStyle();
  
  public abstract int getMapType();
  
  public abstract int getMapWidth();
  
  public abstract float getMaxZoomLevel();
  
  public abstract float getMinZoomLevel();
  
  public abstract Projection getProjection();
  
  public abstract UiSettings getUiSettings();
  
  public abstract String getVersion();
  
  public abstract float getZoomToSpanLevel(LatLng paramLatLng1, LatLng paramLatLng2);
  
  public abstract boolean isBlockRouteEnabled();
  
  public abstract boolean isDestroyed();
  
  public abstract boolean isHandDrawMapEnable();
  
  public abstract boolean isSateLiteEnable();
  
  public abstract boolean isTrafficEnabled();
  
  public abstract void loadKMLFile(String paramString);
  
  public abstract void moveCamera(CameraUpdate paramCameraUpdate);
  
  public abstract void removeOnMapLoadedCallback(OnMapLoadedCallback paramOnMapLoadedCallback);
  
  public abstract void removeTencentMapGestureListener(TencentMapGestureListener paramTencentMapGestureListener);
  
  public abstract void setBaseMapEnabled(boolean paramBoolean);
  
  public abstract void setBlockRouteEnabled(boolean paramBoolean);
  
  public abstract void setBuilding3dEffectEnable(boolean paramBoolean);
  
  public abstract void setBuildingEnable(boolean paramBoolean);
  
  public abstract void setCameraCenterProportion(float paramFloat1, float paramFloat2);
  
  public abstract void setCameraCenterProportion(float paramFloat1, float paramFloat2, boolean paramBoolean);
  
  public abstract void setCustomRender(CustomRender paramCustomRender);
  
  public abstract void setDrawPillarWith2DStyle(boolean paramBoolean);
  
  public abstract void setForeignLanguage(Language paramLanguage);
  
  public abstract void setHandDrawMapEnable(boolean paramBoolean);
  
  public abstract void setInfoWindowAdapter(InfoWindowAdapter paramInfoWindowAdapter);
  
  public abstract void setMapCenterAndScale(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void setMapFrameRate(float paramFloat);
  
  public abstract void setMapStyle(int paramInt);
  
  public abstract void setMapType(int paramInt);
  
  public abstract void setMaxZoomLevel(int paramInt);
  
  public abstract void setMinZoomLevel(int paramInt);
  
  public abstract void setMyLocationStyle(MyLocationStyle paramMyLocationStyle);
  
  public abstract void setOnCameraChangeListener(OnCameraChangeListener paramOnCameraChangeListener);
  
  public abstract void setOnCompassClickedListener(TencentMap.OnCompassClickedListener paramOnCompassClickedListener);
  
  public abstract void setOnInfoWindowClickListener(OnInfoWindowClickListener paramOnInfoWindowClickListener);
  
  public abstract void setOnMapClickListener(OnMapClickListener paramOnMapClickListener);
  
  public abstract void setOnMapLoadedCallback(OnMapLoadedCallback paramOnMapLoadedCallback);
  
  public abstract void setOnMapLongClickListener(OnMapLongClickListener paramOnMapLongClickListener);
  
  public abstract void setOnMapPoiClickListener(OnMapPoiClickListener paramOnMapPoiClickListener);
  
  public abstract void setOnMarkerClickListener(OnMarkerClickListener paramOnMarkerClickListener);
  
  public abstract void setOnMarkerDragListener(OnMarkerDragListener paramOnMarkerDragListener);
  
  public abstract void setOnPolylineClickListener(OnPolylineClickListener paramOnPolylineClickListener);
  
  public abstract void setOnTapMapViewInfoWindowHidden(boolean paramBoolean);
  
  public abstract void setOnTrafficEventClickListener(TencentMap.OnTrafficEventClickListener paramOnTrafficEventClickListener);
  
  public abstract void setOverSeaTileProvider(OverSeaTileProvider paramOverSeaTileProvider);
  
  public abstract void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean);
  
  public abstract void setPointToCenter(int paramInt1, int paramInt2);
  
  public abstract void setPoisEnabled(boolean paramBoolean);
  
  public abstract void setRestrictBounds(LatLngBounds paramLatLngBounds, RestrictBoundsFitMode paramRestrictBoundsFitMode);
  
  public abstract void setSatelliteEnabled(boolean paramBoolean);
  
  public abstract void setTencentMapGestureListener(TencentMapGestureListener paramTencentMapGestureListener);
  
  public abstract void setTrafficEnabled(boolean paramBoolean);
  
  public abstract void showBuilding(boolean paramBoolean);
  
  public abstract void snapshot(SnapshotReadyCallback paramSnapshotReadyCallback);
  
  public abstract void snapshot(SnapshotReadyCallback paramSnapshotReadyCallback, Bitmap.Config paramConfig);
  
  public abstract void snapshot(SnapshotReadyCallback paramSnapshotReadyCallback, Bitmap.Config paramConfig, int paramInt);
  
  public abstract void stopAnimation();
  
  public static abstract interface CancelableCallback
  {
    public abstract void onCancel();
    
    public abstract void onFinish();
  }
  
  public static abstract interface InfoWindowAdapter
  {
    public abstract View getInfoContents(Marker paramMarker);
    
    public abstract View getInfoWindow(Marker paramMarker);
  }
  
  public static abstract interface OnCameraChangeListener
  {
    public abstract void onCameraChange(CameraPosition paramCameraPosition);
    
    public abstract void onCameraChangeFinished(CameraPosition paramCameraPosition);
  }
  
  public static abstract interface OnIndoorStateChangeListener
  {
    public abstract boolean onIndoorBuildingDeactivated();
    
    public abstract boolean onIndoorBuildingFocused();
    
    public abstract boolean onIndoorLevelActivated(IndoorBuilding paramIndoorBuilding);
  }
  
  public static abstract interface OnInfoWindowClickListener
  {
    public abstract void onInfoWindowClick(Marker paramMarker);
    
    public abstract void onInfoWindowClickLocation(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
  
  public static abstract interface OnMapClickListener
  {
    public abstract void onMapClick(LatLng paramLatLng);
  }
  
  public static abstract interface OnMapLoadedCallback
  {
    public abstract void onMapLoaded();
  }
  
  public static abstract interface OnMapLongClickListener
  {
    public abstract void onMapLongClick(LatLng paramLatLng);
  }
  
  public static abstract interface OnMapPoiClickListener
  {
    public abstract void onClicked(MapPoi paramMapPoi);
  }
  
  public static abstract interface OnMarkerClickListener
  {
    public abstract boolean onMarkerClick(Marker paramMarker);
  }
  
  public static abstract interface OnMarkerDragListener
  {
    public abstract void onMarkerDrag(Marker paramMarker);
    
    public abstract void onMarkerDragEnd(Marker paramMarker);
    
    public abstract void onMarkerDragStart(Marker paramMarker);
  }
  
  public static abstract interface OnPolylineClickListener
  {
    public abstract void onPolylineClick(Polyline paramPolyline, LatLng paramLatLng);
  }
  
  public static abstract interface SnapshotReadyCallback
  {
    public abstract void onSnapshotReady(Bitmap paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.TencentMap
 * JD-Core Version:    0.7.0.1
 */