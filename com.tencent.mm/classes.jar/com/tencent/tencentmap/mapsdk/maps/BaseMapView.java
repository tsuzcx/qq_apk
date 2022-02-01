package com.tencent.tencentmap.mapsdk.maps;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.tencentmap.mapsdk.maps.model.MapKernel;
import com.tencent.tencentmap.mapsdk.maps.model.MapViewType;

public abstract class BaseMapView
  extends FrameLayout
{
  public BaseMapView(Context paramContext)
  {
    super(paramContext);
  }
  
  public BaseMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BaseMapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public abstract TencentMap getMap();
  
  public abstract TencentMap getMap(TencentMapOptions paramTencentMapOptions);
  
  protected TencentMapOptions.IMapKernel getMapKernel()
  {
    return MapKernel.Vector;
  }
  
  protected MapViewType getViewType()
  {
    return MapViewType.SurfaceView;
  }
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onRestart();
  
  public abstract void onResume();
  
  public abstract void onStart();
  
  public abstract void onStop();
  
  public static abstract interface MapViewProxy
  {
    public abstract TencentMap getMap();
    
    public abstract boolean isTouchable();
    
    public abstract void onCreated();
    
    public abstract void onDestroy();
    
    public abstract boolean onInterceptTouchEvent(MotionEvent paramMotionEvent);
    
    public abstract void onPause();
    
    public abstract void onRestart();
    
    public abstract void onResume();
    
    public abstract void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void onStart();
    
    public abstract void onStop();
    
    public abstract void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2);
    
    public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
    
    public abstract void onUpdateOptions(TencentMapOptions paramTencentMapOptions);
    
    public abstract void setOnTop(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.BaseMapView
 * JD-Core Version:    0.7.0.1
 */