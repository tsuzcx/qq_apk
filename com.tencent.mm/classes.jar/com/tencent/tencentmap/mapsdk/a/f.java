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
import com.tencent.tencentmap.mapsdk.maps.MapRenderLayer;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

public class f
  implements IMapView
{
  private MapRenderLayer a;
  private com.tencent.tencentmap.mapsdk.map.TencentMap b;
  
  public f(Context paramContext, com.tencent.tencentmap.mapsdk.map.TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(186321);
    a.a("VecotrMapRenderLayer construct function start");
    com.tencent.tencentmap.mapsdk.maps.TencentMapOptions localTencentMapOptions = null;
    if (paramTencentMapOptions != null)
    {
      localTencentMapOptions = new com.tencent.tencentmap.mapsdk.maps.TencentMapOptions();
      if (paramTencentMapOptions.getExtSurface() != null)
      {
        localTencentMapOptions.setExtSurface(paramTencentMapOptions.getExtSurface());
        localTencentMapOptions.setExtSurfaceDimension(paramTencentMapOptions.getExtSurfaceWidth(), paramTencentMapOptions.getExtSurfaceHeight());
      }
      localTencentMapOptions.setHandDrawMapEnable(paramTencentMapOptions.isHandDrawMapEnable());
      localTencentMapOptions.setSubInfo(paramTencentMapOptions.getSubKey(), paramTencentMapOptions.getSubId());
      localTencentMapOptions.setMultipleInfoWindowEnable(paramTencentMapOptions.isMutipleInfowindowEnabled());
    }
    this.a = new MapRenderLayer(paramContext, localTencentMapOptions);
    this.b = new n(this.a.getMap());
    this.a.getMap().getUiSettings().setZoomControlsEnabled(false);
    AppMethodBeat.o(186321);
  }
  
  public void addView(View paramView, MapView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(186324);
    if (this.a.getMap() != null) {
      this.a.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(paramView)).position(q.a(paramLayoutParams.point)));
    }
    AppMethodBeat.o(186324);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
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
    AppMethodBeat.i(186323);
    if (getMap() != null)
    {
      Projection localProjection = getMap().getProjection();
      AppMethodBeat.o(186323);
      return localProjection;
    }
    AppMethodBeat.o(186323);
    return null;
  }
  
  public com.tencent.tencentmap.mapsdk.map.UiSettings getUiSettings()
  {
    AppMethodBeat.i(186322);
    if (this.a.getMap() != null)
    {
      r localr = new r(this.a.getMap().getUiSettings());
      AppMethodBeat.o(186322);
      return localr;
    }
    AppMethodBeat.o(186322);
    return null;
  }
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onDestroy()
  {
    AppMethodBeat.i(186331);
    this.a.onDestroy();
    AppMethodBeat.o(186331);
  }
  
  public void onDestroyView() {}
  
  public void onLowMemory() {}
  
  public void onPause()
  {
    AppMethodBeat.i(186328);
    this.a.onPause();
    AppMethodBeat.o(186328);
  }
  
  public void onRestart()
  {
    AppMethodBeat.i(186330);
    this.a.onRestart();
    AppMethodBeat.o(186330);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(186327);
    this.a.onResume();
    AppMethodBeat.o(186327);
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(186333);
    if (this.a != null) {
      this.a.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(186333);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(186326);
    this.a.onStart();
    AppMethodBeat.o(186326);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(186329);
    this.a.onStop();
    AppMethodBeat.o(186329);
  }
  
  public void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186334);
    if (this.a != null) {
      this.a.onSurfaceChanged(paramObject, paramInt1, paramInt2);
    }
    AppMethodBeat.o(186334);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(186332);
    boolean bool = this.a.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(186332);
    return bool;
  }
  
  public void updateViewLayout(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(186325);
    if (this.a != null) {
      this.a.updateViewLayout(paramView, paramLayoutParams);
    }
    AppMethodBeat.o(186325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.f
 * JD-Core Version:    0.7.0.1
 */