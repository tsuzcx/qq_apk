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

public class ea
  implements IMapView
{
  private af a;
  private TencentMap b;
  
  public ea(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(101332);
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
    this.a = new af(paramContext, localai);
    this.b = new ef(this.a.getMap());
    this.a.getMap().l().a(false);
    AppMethodBeat.o(101332);
  }
  
  public void addView(View paramView, MapView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(101335);
    if (this.a.getMap() != null) {
      this.a.getMap().a(new dd().a(cl.a(paramView)).a(eh.a(paramLayoutParams.point)));
    }
    AppMethodBeat.o(101335);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(150158);
    if (this.a == null)
    {
      AppMethodBeat.o(150158);
      return false;
    }
    if ((this.a.dispatchTouchEvent(paramMotionEvent)) || (this.a.onTouchEvent(paramMotionEvent)))
    {
      AppMethodBeat.o(150158);
      return true;
    }
    AppMethodBeat.o(150158);
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
    AppMethodBeat.i(101334);
    if (this.a.getMap() != null)
    {
      ee localee = new ee(this.a.getMap());
      AppMethodBeat.o(101334);
      return localee;
    }
    AppMethodBeat.o(101334);
    return null;
  }
  
  public UiSettings getUiSettings()
  {
    AppMethodBeat.i(101333);
    if (this.a.getMap() != null)
    {
      ei localei = new ei(this.a.getMap().l());
      AppMethodBeat.o(101333);
      return localei;
    }
    AppMethodBeat.o(101333);
    return null;
  }
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onDestroy()
  {
    AppMethodBeat.i(101342);
    this.a.c();
    AppMethodBeat.o(101342);
  }
  
  public void onDestroyView() {}
  
  public void onLowMemory() {}
  
  public void onPause()
  {
    AppMethodBeat.i(101339);
    this.a.e();
    AppMethodBeat.o(101339);
  }
  
  public void onRestart()
  {
    AppMethodBeat.i(101341);
    this.a.f();
    AppMethodBeat.o(101341);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(101338);
    this.a.d();
    AppMethodBeat.o(101338);
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(101344);
    if (this.a != null) {
      this.a.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(101344);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(101337);
    this.a.a();
    AppMethodBeat.o(101337);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(101340);
    this.a.b();
    AppMethodBeat.o(101340);
  }
  
  public void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150159);
    if (this.a != null) {
      this.a.a(paramObject, paramInt1, paramInt2);
    }
    AppMethodBeat.o(150159);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(101343);
    if (paramMotionEvent.getAction() == 0)
    {
      AppMethodBeat.o(101343);
      return true;
    }
    AppMethodBeat.o(101343);
    return false;
  }
  
  public void updateViewLayout(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(101336);
    if (this.a != null) {
      this.a.updateViewLayout(paramView, paramLayoutParams);
    }
    AppMethodBeat.o(101336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ea
 * JD-Core Version:    0.7.0.1
 */