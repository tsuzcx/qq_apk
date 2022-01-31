package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.os.Bundle;
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

public class qy
  implements IMapView
{
  private uy a;
  private Context b;
  private TencentMap c;
  private Projection d;
  private UiSettings e;
  
  public qy(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    this.b = paramContext;
    vc localvc = null;
    if (paramTencentMapOptions != null)
    {
      localvc = new vc();
      if (paramTencentMapOptions.getExtSurface() != null) {
        localvc.a(paramTencentMapOptions.getExtSurface());
      }
      localvc.a(paramTencentMapOptions.isHandDrawMapEnable());
    }
    this.a = new uy(paramContext, localvc);
    this.c = new rd(this.a.getMap());
    this.d = new rc(this.a.getProjection());
    this.e = new rf(this.a.getUiSettings());
  }
  
  public void addView(View paramView, MapView.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams == null) {
      return;
    }
    this.a.addView(paramView, new uy.a(paramLayoutParams.width, paramLayoutParams.height, re.a(paramLayoutParams.point), paramLayoutParams.alignment));
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.a.dispatchTouchEvent(paramMotionEvent);
  }
  
  public TencentMap getMap()
  {
    return this.c;
  }
  
  public MapController getMapController()
  {
    return this.c;
  }
  
  public View getMapView()
  {
    return this.a;
  }
  
  public Projection getProjection()
  {
    return this.d;
  }
  
  public UiSettings getUiSettings()
  {
    return this.e;
  }
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onDestroy()
  {
    this.a.e();
  }
  
  public void onDestroyView() {}
  
  public void onLowMemory() {}
  
  public void onPause()
  {
    this.a.b();
  }
  
  public void onRestart()
  {
    this.a.d();
  }
  
  public void onResume()
  {
    this.a.a();
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStart() {}
  
  public void onStop()
  {
    this.a.c();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.qy
 * JD-Core Version:    0.7.0.1
 */