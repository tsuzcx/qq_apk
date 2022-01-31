package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.tencentmap.mapsdk.map.IMapView;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.tencentmap.mapsdk.map.MapView.LayoutParams;
import com.tencent.tencentmap.mapsdk.map.Projection;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.map.UiSettings;

public class rk
  implements IMapView
{
  private static float c = 1.0F;
  private af a;
  private TencentMap b;
  
  public rk(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    rh.a("vector MapView construct function start");
    float f = paramContext.getResources().getDisplayMetrics().density;
    c = f;
    rq.a(f);
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
    this.b = new rp(this.a.getMap());
    this.a.getMap().l().a(false);
  }
  
  public static float a()
  {
    return c;
  }
  
  public void addView(View paramView, MapView.LayoutParams paramLayoutParams)
  {
    if (this.a.getMap() != null) {
      this.a.getMap().a(new qg().a(ps.a(paramView)).a(rq.a(paramLayoutParams.point)));
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a == null) {}
    while ((!this.a.dispatchTouchEvent(paramMotionEvent)) && (!this.a.onTouchEvent(paramMotionEvent))) {
      return false;
    }
    return true;
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
    if (this.a.getMap() != null) {
      return new ro(this.a.getMap());
    }
    return null;
  }
  
  public UiSettings getUiSettings()
  {
    if (this.a.getMap() != null) {
      return new rr(this.a.getMap().l());
    }
    return null;
  }
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onDestroy()
  {
    this.a.c();
  }
  
  public void onDestroyView() {}
  
  public void onLowMemory() {}
  
  public void onPause()
  {
    this.a.e();
  }
  
  public void onRestart()
  {
    this.a.f();
  }
  
  public void onResume()
  {
    this.a.d();
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStart()
  {
    this.a.a();
  }
  
  public void onStop()
  {
    this.a.b();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getAction() == 0;
  }
  
  public void updateViewLayout(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.a != null) {
      this.a.updateViewLayout(paramView, paramLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.rk
 * JD-Core Version:    0.7.0.1
 */