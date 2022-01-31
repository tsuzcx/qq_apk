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

public class dy
  implements IMapView
{
  private ae a;
  private TencentMap b;
  
  public dy(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(150316);
    dw.a("VecotrMapRenderLayer construct function start");
    ai localai = null;
    if (paramTencentMapOptions != null)
    {
      localai = new ai();
      if (paramTencentMapOptions.getExtSurface() != null)
      {
        localai.a(paramTencentMapOptions.getExtSurface());
        localai.a(paramTencentMapOptions.getExtSurfaceWidth(), paramTencentMapOptions.getExtSurfaceHeight());
      }
      localai.a(paramTencentMapOptions.isHandDrawMapEnable());
      localai.a(paramTencentMapOptions.getSubKey(), paramTencentMapOptions.getSubId());
      localai.b(paramTencentMapOptions.isMutipleInfowindowEnabled());
    }
    this.a = new ae(paramContext, localai);
    this.b = new ef(this.a.getMap());
    this.a.getMap().l().a(false);
    AppMethodBeat.o(150316);
  }
  
  public void addView(View paramView, MapView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(150319);
    if (this.a.getMap() != null) {
      this.a.getMap().a(new dd().a(cl.a(paramView)).a(eh.a(paramLayoutParams.point)));
    }
    AppMethodBeat.o(150319);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
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
    AppMethodBeat.i(150318);
    if (this.a.getMap() != null)
    {
      ee localee = new ee(this.a.getMap());
      AppMethodBeat.o(150318);
      return localee;
    }
    AppMethodBeat.o(150318);
    return null;
  }
  
  public UiSettings getUiSettings()
  {
    AppMethodBeat.i(150317);
    if (this.a.getMap() != null)
    {
      ei localei = new ei(this.a.getMap().l());
      AppMethodBeat.o(150317);
      return localei;
    }
    AppMethodBeat.o(150317);
    return null;
  }
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onDestroy()
  {
    AppMethodBeat.i(150326);
    this.a.c();
    AppMethodBeat.o(150326);
  }
  
  public void onDestroyView() {}
  
  public void onLowMemory() {}
  
  public void onPause()
  {
    AppMethodBeat.i(150323);
    this.a.e();
    AppMethodBeat.o(150323);
  }
  
  public void onRestart()
  {
    AppMethodBeat.i(150325);
    this.a.f();
    AppMethodBeat.o(150325);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(150322);
    this.a.d();
    AppMethodBeat.o(150322);
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(150328);
    if (this.a != null) {
      this.a.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(150328);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(150321);
    this.a.a();
    AppMethodBeat.o(150321);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(150324);
    this.a.b();
    AppMethodBeat.o(150324);
  }
  
  public void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150329);
    if (this.a != null) {
      this.a.a(paramObject, paramInt1, paramInt2);
    }
    AppMethodBeat.o(150329);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(150327);
    boolean bool = this.a.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(150327);
    return bool;
  }
  
  public void updateViewLayout(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(150320);
    if (this.a != null) {
      this.a.updateViewLayout(paramView, paramLayoutParams);
    }
    AppMethodBeat.o(150320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.dy
 * JD-Core Version:    0.7.0.1
 */