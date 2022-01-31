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
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.map.UiSettings;

public class eg
  implements IMapView
{
  private aj a;
  private TencentMap b;
  
  public eg(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(150382);
    dw.a("vector MapView construct function start");
    ai localai = null;
    if (paramTencentMapOptions != null)
    {
      localai = new ai();
      if (paramTencentMapOptions.getExtSurface() != null) {
        localai.a(paramTencentMapOptions.getExtSurface());
      }
      localai.a(paramTencentMapOptions.isHandDrawMapEnable());
      localai.a(paramTencentMapOptions.getSubKey(), paramTencentMapOptions.getSubId());
      localai.b(paramTencentMapOptions.isMutipleInfowindowEnabled());
    }
    this.a = new aj(paramContext, localai);
    this.b = new ef(this.a.getMap());
    this.a.getMap().l().a(false);
    AppMethodBeat.o(150382);
  }
  
  public void addView(View paramView, MapView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(150385);
    if (this.a.getMap() != null) {
      this.a.getMap().a(new dd().a(cl.a(paramView)).a(eh.a(paramLayoutParams.point)));
    }
    AppMethodBeat.o(150385);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(150394);
    if (this.a == null)
    {
      AppMethodBeat.o(150394);
      return false;
    }
    if ((this.a.dispatchTouchEvent(paramMotionEvent)) || (this.a.onTouchEvent(paramMotionEvent)))
    {
      AppMethodBeat.o(150394);
      return true;
    }
    AppMethodBeat.o(150394);
    return false;
  }
  
  public TencentMap getMap()
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
    AppMethodBeat.i(150384);
    if (this.a.getMap() != null)
    {
      ee localee = new ee(this.a.getMap());
      AppMethodBeat.o(150384);
      return localee;
    }
    AppMethodBeat.o(150384);
    return null;
  }
  
  public UiSettings getUiSettings()
  {
    AppMethodBeat.i(150383);
    if (this.a.getMap() != null)
    {
      ei localei = new ei(this.a.getMap().l());
      AppMethodBeat.o(150383);
      return localei;
    }
    AppMethodBeat.o(150383);
    return null;
  }
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onDestroy()
  {
    AppMethodBeat.i(150392);
    this.a.c();
    AppMethodBeat.o(150392);
  }
  
  public void onDestroyView() {}
  
  public void onLowMemory() {}
  
  public void onPause()
  {
    AppMethodBeat.i(150389);
    this.a.e();
    AppMethodBeat.o(150389);
  }
  
  public void onRestart()
  {
    AppMethodBeat.i(150391);
    this.a.f();
    AppMethodBeat.o(150391);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(150388);
    this.a.d();
    AppMethodBeat.o(150388);
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(150395);
    if (this.a != null) {
      this.a.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(150395);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(150387);
    this.a.a();
    AppMethodBeat.o(150387);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(150390);
    this.a.b();
    AppMethodBeat.o(150390);
  }
  
  public void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150396);
    if (this.a != null) {
      this.a.a(paramObject, paramInt1, paramInt2);
    }
    AppMethodBeat.o(150396);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(150393);
    if (paramMotionEvent.getAction() == 0)
    {
      AppMethodBeat.o(150393);
      return true;
    }
    AppMethodBeat.o(150393);
    return false;
  }
  
  public void updateViewLayout(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(150386);
    if (this.a != null) {
      this.a.updateViewLayout(paramView, paramLayoutParams);
    }
    AppMethodBeat.o(150386);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.eg
 * JD-Core Version:    0.7.0.1
 */