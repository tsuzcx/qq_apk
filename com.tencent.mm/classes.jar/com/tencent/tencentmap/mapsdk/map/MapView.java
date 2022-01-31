package com.tencent.tencentmap.mapsdk.map;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.tencentmap.mapsdk.dynamic.c;

public class MapView
  extends FrameLayout
  implements IMapView
{
  private c mMapProvider;
  private int mMapType = 1;
  private Projection mProjection;
  private UiSettings mUiSettings;
  private IMapView mapView;
  
  public MapView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(null);
  }
  
  public MapView(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    super(paramContext);
    init(paramTencentMapOptions);
  }
  
  private void init(TencentMapOptions paramTencentMapOptions)
  {
    Context localContext = getContext();
    this.mMapProvider = new c();
    if (paramTencentMapOptions != null) {
      this.mMapProvider.a(paramTencentMapOptions.getMapType());
    }
    this.mapView = this.mMapProvider.a(localContext.getApplicationContext(), paramTencentMapOptions);
    if (this.mapView != null)
    {
      paramTencentMapOptions = new ViewGroup.LayoutParams(-1, -1);
      addView(this.mapView.getMapView(), paramTencentMapOptions);
    }
    if ((localContext instanceof MapActivity)) {
      ((MapActivity)localContext).setMapView(this);
    }
  }
  
  public void addView(View paramView, MapView.LayoutParams paramLayoutParams)
  {
    if ((this.mapView == null) || (paramLayoutParams == null)) {
      return;
    }
    this.mapView.addView(paramView, paramLayoutParams);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    this.mapView.dispatchTouchEvent(paramMotionEvent);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public TencentMap getMap()
  {
    if (this.mapView == null) {
      return null;
    }
    return this.mapView.getMap();
  }
  
  @Deprecated
  public LatLng getMapCenter()
  {
    if ((this.mapView == null) || (this.mapView.getMap() == null)) {
      return null;
    }
    return this.mapView.getMap().getMapCenter();
  }
  
  public MapController getMapController()
  {
    if (this.mapView == null) {
      return null;
    }
    return this.mapView.getMapController();
  }
  
  public View getMapView()
  {
    return this;
  }
  
  public Projection getProjection()
  {
    if (this.mapView == null) {
      return null;
    }
    return this.mapView.getProjection();
  }
  
  public UiSettings getUiSettings()
  {
    if (this.mapView == null) {
      return null;
    }
    return this.mapView.getUiSettings();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (this.mapView == null) {
      return;
    }
    this.mapView.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    if (this.mapView == null) {
      return;
    }
    this.mapView.onDestroy();
  }
  
  public void onDestroyView()
  {
    if (this.mapView == null) {
      return;
    }
    this.mapView.onDestroyView();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onLowMemory()
  {
    if (this.mapView == null) {
      return;
    }
    this.mapView.onLowMemory();
  }
  
  public void onPause()
  {
    if (this.mapView == null) {
      return;
    }
    this.mapView.onPause();
  }
  
  public void onRestart()
  {
    if (this.mapView == null) {
      return;
    }
    this.mapView.onRestart();
  }
  
  public void onResume()
  {
    if (this.mapView == null) {
      return;
    }
    this.mapView.onResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.mapView == null) {
      return;
    }
    this.mapView.onSaveInstanceState(paramBundle);
  }
  
  public void onStart()
  {
    if (this.mapView == null) {
      return;
    }
    this.mapView.onStart();
  }
  
  public void onStop()
  {
    if (this.mapView == null) {
      return;
    }
    this.mapView.onStop();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mapView != null) {
      return this.mapView.onTouchEvent(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void updateViewLayout(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.mapView == null) {
      return;
    }
    this.mapView.updateViewLayout(paramView, paramLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.MapView
 * JD-Core Version:    0.7.0.1
 */