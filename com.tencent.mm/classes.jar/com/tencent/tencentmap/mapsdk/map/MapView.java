package com.tencent.tencentmap.mapsdk.map;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.rastercore.MapProvider;
import com.tencent.mapsdk.rastercore.core.MapContext;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MapView
  extends FrameLayout
  implements IMapView
{
  private MapProvider mMapProvider;
  private int mMapType;
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
    AppMethodBeat.i(87461);
    this.mMapType = 1;
    init(null);
    AppMethodBeat.o(87461);
  }
  
  public MapView(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    super(paramContext);
    AppMethodBeat.i(87462);
    this.mMapType = 1;
    init(paramTencentMapOptions);
    AppMethodBeat.o(87462);
  }
  
  private void init(TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(87463);
    Context localContext = getContext();
    this.mMapProvider = new MapProvider();
    MapContext.setContext(localContext.getApplicationContext());
    this.mapView = this.mMapProvider.getMapView(localContext.getApplicationContext(), paramTencentMapOptions);
    if (this.mapView != null)
    {
      paramTencentMapOptions = new ViewGroup.LayoutParams(-1, -1);
      addView(this.mapView.getMapView(), paramTencentMapOptions);
    }
    if ((localContext instanceof MapActivity)) {
      ((MapActivity)localContext).setMapView(this);
    }
    AppMethodBeat.o(87463);
  }
  
  public void addView(View paramView, MapView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(87464);
    if ((this.mapView == null) || (paramLayoutParams == null))
    {
      AppMethodBeat.o(87464);
      return;
    }
    this.mapView.addView(paramView, paramLayoutParams);
    AppMethodBeat.o(87464);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(87468);
    this.mapView.dispatchTouchEvent(paramMotionEvent);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(87468);
    return bool;
  }
  
  public TencentMap getMap()
  {
    AppMethodBeat.i(87465);
    if (this.mapView == null)
    {
      AppMethodBeat.o(87465);
      return null;
    }
    TencentMap localTencentMap = this.mapView.getMap();
    AppMethodBeat.o(87465);
    return localTencentMap;
  }
  
  @Deprecated
  public LatLng getMapCenter()
  {
    AppMethodBeat.i(87480);
    if ((this.mapView == null) || (this.mapView.getMap() == null))
    {
      AppMethodBeat.o(87480);
      return null;
    }
    LatLng localLatLng = this.mapView.getMap().getMapCenter();
    AppMethodBeat.o(87480);
    return localLatLng;
  }
  
  public MapController getMapController()
  {
    AppMethodBeat.i(87479);
    if (this.mapView == null)
    {
      AppMethodBeat.o(87479);
      return null;
    }
    MapController localMapController = this.mapView.getMapController();
    AppMethodBeat.o(87479);
    return localMapController;
  }
  
  public View getMapView()
  {
    return this;
  }
  
  public Projection getProjection()
  {
    AppMethodBeat.i(87478);
    if (this.mapView == null)
    {
      AppMethodBeat.o(87478);
      return null;
    }
    Projection localProjection = this.mapView.getMap().getProjection();
    AppMethodBeat.o(87478);
    return localProjection;
  }
  
  public UiSettings getUiSettings()
  {
    AppMethodBeat.i(87481);
    if (this.mapView == null)
    {
      AppMethodBeat.o(87481);
      return null;
    }
    UiSettings localUiSettings = this.mapView.getUiSettings();
    AppMethodBeat.o(87481);
    return localUiSettings;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(87466);
    if (this.mapView == null)
    {
      AppMethodBeat.o(87466);
      return;
    }
    this.mapView.onCreate(paramBundle);
    AppMethodBeat.o(87466);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(87475);
    if (this.mapView == null)
    {
      AppMethodBeat.o(87475);
      return;
    }
    this.mapView.onDestroy();
    AppMethodBeat.o(87475);
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(87474);
    if (this.mapView == null)
    {
      AppMethodBeat.o(87474);
      return;
    }
    this.mapView.onDestroyView();
    AppMethodBeat.o(87474);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(87477);
    if (this.mapView == null)
    {
      AppMethodBeat.o(87477);
      return;
    }
    this.mapView.onLowMemory();
    AppMethodBeat.o(87477);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(87471);
    if (this.mapView == null)
    {
      AppMethodBeat.o(87471);
      return;
    }
    this.mapView.onPause();
    AppMethodBeat.o(87471);
  }
  
  public void onRestart()
  {
    AppMethodBeat.i(87473);
    if (this.mapView == null)
    {
      AppMethodBeat.o(87473);
      return;
    }
    this.mapView.onRestart();
    AppMethodBeat.o(87473);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(87470);
    if (this.mapView == null)
    {
      AppMethodBeat.o(87470);
      return;
    }
    this.mapView.onResume();
    AppMethodBeat.o(87470);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(87476);
    if (this.mapView == null)
    {
      AppMethodBeat.o(87476);
      return;
    }
    this.mapView.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(87476);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(87483);
    if (this.mapView != null) {
      this.mapView.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(87483);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(87469);
    if (this.mapView == null)
    {
      AppMethodBeat.o(87469);
      return;
    }
    this.mapView.onStart();
    AppMethodBeat.o(87469);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(87472);
    if (this.mapView == null)
    {
      AppMethodBeat.o(87472);
      return;
    }
    this.mapView.onStop();
    AppMethodBeat.o(87472);
  }
  
  public void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(87484);
    if (this.mapView != null) {
      this.mapView.onSurfaceChanged(paramObject, paramInt1, paramInt2);
    }
    AppMethodBeat.o(87484);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(87467);
    if (this.mapView != null)
    {
      bool = this.mapView.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(87467);
      return bool;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(87467);
    return bool;
  }
  
  public void updateViewLayout(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(87482);
    if (this.mapView == null)
    {
      AppMethodBeat.o(87482);
      return;
    }
    this.mapView.updateViewLayout(paramView, paramLayoutParams);
    AppMethodBeat.o(87482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.MapView
 * JD-Core Version:    0.7.0.1
 */