package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.IMapView;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.tencentmap.mapsdk.map.MapView.LayoutParams;
import com.tencent.tencentmap.mapsdk.map.Projection;
import com.tencent.tencentmap.mapsdk.maps.MapView;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

public class i
  implements IMapView
{
  private MapView a;
  private com.tencent.tencentmap.mapsdk.map.TencentMap b;
  
  public i(Context paramContext, com.tencent.tencentmap.mapsdk.map.TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(181324);
    a.a("vector MapView construct function start");
    com.tencent.tencentmap.mapsdk.maps.TencentMapOptions localTencentMapOptions = null;
    if (paramTencentMapOptions != null)
    {
      localTencentMapOptions = new com.tencent.tencentmap.mapsdk.maps.TencentMapOptions();
      if (paramTencentMapOptions.getExtSurface() != null) {
        localTencentMapOptions.setExtSurface(paramTencentMapOptions.getExtSurface());
      }
      localTencentMapOptions.setHandDrawMapEnable(paramTencentMapOptions.isHandDrawMapEnable());
      localTencentMapOptions.setSubInfo(paramTencentMapOptions.getSubKey(), paramTencentMapOptions.getSubId());
      localTencentMapOptions.setMultipleInfoWindowEnable(paramTencentMapOptions.isMutipleInfowindowEnabled());
    }
    this.a = new MapView(paramContext, localTencentMapOptions);
    this.b = new n(this.a.getMap());
    this.a.getMap().getUiSettings().setZoomControlsEnabled(false);
    AppMethodBeat.o(181324);
  }
  
  public void addView(View paramView, MapView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(181327);
    if (this.a.getMap() != null) {
      this.a.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(paramView)).position(q.a(paramLayoutParams.point)));
    }
    AppMethodBeat.o(181327);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(186135);
    if (this.a == null)
    {
      AppMethodBeat.o(186135);
      return false;
    }
    if ((this.a.dispatchTouchEvent(paramMotionEvent)) || (this.a.onTouchEvent(paramMotionEvent)))
    {
      AppMethodBeat.o(186135);
      return true;
    }
    AppMethodBeat.o(186135);
    return false;
  }
  
  public com.tencent.tencentmap.mapsdk.map.TencentMap getMap()
  {
    return this.b;
  }
  
  public MapController getMapController()
  {
    return this.b;
  }
  
  public View getMapView()
  {
    return this.a;
  }
  
  public Projection getProjection()
  {
    AppMethodBeat.i(181326);
    if (getMap() != null)
    {
      Projection localProjection = getMap().getProjection();
      AppMethodBeat.o(181326);
      return localProjection;
    }
    AppMethodBeat.o(181326);
    return null;
  }
  
  public com.tencent.tencentmap.mapsdk.map.UiSettings getUiSettings()
  {
    AppMethodBeat.i(181325);
    if (this.a.getMap() != null)
    {
      r localr = new r(this.a.getMap().getUiSettings());
      AppMethodBeat.o(181325);
      return localr;
    }
    AppMethodBeat.o(181325);
    return null;
  }
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onDestroy()
  {
    AppMethodBeat.i(181334);
    this.a.onDestroy();
    AppMethodBeat.o(181334);
  }
  
  public void onDestroyView() {}
  
  public void onLowMemory() {}
  
  public void onPause()
  {
    AppMethodBeat.i(181331);
    this.a.onPause();
    AppMethodBeat.o(181331);
  }
  
  public void onRestart()
  {
    AppMethodBeat.i(181333);
    this.a.onRestart();
    AppMethodBeat.o(181333);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(181330);
    this.a.onResume();
    AppMethodBeat.o(181330);
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(181336);
    if (this.a != null) {
      this.a.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(181336);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(181329);
    this.a.onStart();
    AppMethodBeat.o(181329);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(181332);
    this.a.onStop();
    AppMethodBeat.o(181332);
  }
  
  public void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181337);
    if (this.a != null) {
      this.a.onSurfaceChanged(paramObject, paramInt1, paramInt2);
    }
    AppMethodBeat.o(181337);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(181335);
    if (paramMotionEvent.getAction() == 0)
    {
      AppMethodBeat.o(181335);
      return true;
    }
    AppMethodBeat.o(181335);
    return false;
  }
  
  public void updateViewLayout(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(181328);
    if (this.a != null) {
      this.a.updateViewLayout(paramView, paramLayoutParams);
    }
    AppMethodBeat.o(181328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.i
 * JD-Core Version:    0.7.0.1
 */