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
import com.tencent.tencentmap.mapsdk.maps.TextureMapView;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

public class o
  implements IMapView
{
  private TextureMapView a;
  private com.tencent.tencentmap.mapsdk.map.TencentMap b;
  
  public o(Context paramContext, com.tencent.tencentmap.mapsdk.map.TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(186386);
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
    this.a = new TextureMapView(paramContext, localTencentMapOptions);
    this.b = new n(this.a.getMap());
    this.a.getMap().getUiSettings().setZoomControlsEnabled(false);
    AppMethodBeat.o(186386);
  }
  
  public void addView(View paramView, MapView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(186389);
    if (this.a.getMap() != null) {
      this.a.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(paramView)).position(q.a(paramLayoutParams.point)));
    }
    AppMethodBeat.o(186389);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(186398);
    if (this.a == null)
    {
      AppMethodBeat.o(186398);
      return false;
    }
    if ((this.a.dispatchTouchEvent(paramMotionEvent)) || (this.a.onTouchEvent(paramMotionEvent)))
    {
      AppMethodBeat.o(186398);
      return true;
    }
    AppMethodBeat.o(186398);
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
    AppMethodBeat.i(186388);
    if (getMap() != null)
    {
      Projection localProjection = getMap().getProjection();
      AppMethodBeat.o(186388);
      return localProjection;
    }
    AppMethodBeat.o(186388);
    return null;
  }
  
  public com.tencent.tencentmap.mapsdk.map.UiSettings getUiSettings()
  {
    AppMethodBeat.i(186387);
    if (this.a.getMap() != null)
    {
      r localr = new r(this.a.getMap().getUiSettings());
      AppMethodBeat.o(186387);
      return localr;
    }
    AppMethodBeat.o(186387);
    return null;
  }
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onDestroy()
  {
    AppMethodBeat.i(186396);
    this.a.onDestroy();
    AppMethodBeat.o(186396);
  }
  
  public void onDestroyView() {}
  
  public void onLowMemory() {}
  
  public void onPause()
  {
    AppMethodBeat.i(186393);
    this.a.onPause();
    AppMethodBeat.o(186393);
  }
  
  public void onRestart()
  {
    AppMethodBeat.i(186395);
    this.a.onRestart();
    AppMethodBeat.o(186395);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(186392);
    this.a.onResume();
    AppMethodBeat.o(186392);
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(186399);
    if (this.a != null) {
      this.a.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(186399);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(186391);
    this.a.onStart();
    AppMethodBeat.o(186391);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(186394);
    this.a.onStop();
    AppMethodBeat.o(186394);
  }
  
  public void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186400);
    if (this.a != null) {
      this.a.onSurfaceChanged(paramObject, paramInt1, paramInt2);
    }
    AppMethodBeat.o(186400);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(186397);
    if (paramMotionEvent.getAction() == 0)
    {
      AppMethodBeat.o(186397);
      return true;
    }
    AppMethodBeat.o(186397);
    return false;
  }
  
  public void updateViewLayout(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(186390);
    if (this.a != null) {
      this.a.updateViewLayout(paramView, paramLayoutParams);
    }
    AppMethodBeat.o(186390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.o
 * JD-Core Version:    0.7.0.1
 */