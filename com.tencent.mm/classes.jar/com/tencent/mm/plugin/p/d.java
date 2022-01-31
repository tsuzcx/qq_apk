package com.tencent.mm.plugin.p;

import android.graphics.Point;
import android.view.View;
import android.view.View.OnTouchListener;
import java.util.Collection;
import java.util.Set;

public abstract interface d
{
  public abstract void addPinView(View paramView, double paramDouble1, double paramDouble2);
  
  public abstract void addView(Object paramObject, double paramDouble1, double paramDouble2, String paramString);
  
  public abstract void clean();
  
  public abstract void destroy();
  
  public abstract Collection<Object> getChilds();
  
  public abstract b getIController();
  
  public abstract int getMapCenterX();
  
  public abstract int getMapCenterY();
  
  public abstract Point getPointByGeoPoint(double paramDouble1, double paramDouble2);
  
  public abstract Set<String> getTags();
  
  public abstract Object getViewByItag(String paramString);
  
  public abstract e getViewManager();
  
  public abstract int getZoom();
  
  public abstract int getZoomLevel();
  
  public abstract void invalidate();
  
  public abstract void removeView(View paramView);
  
  public abstract Object removeViewByTag(String paramString);
  
  public abstract void setBuiltInZoomControls(boolean paramBoolean);
  
  public abstract void setMapAnchor(float paramFloat1, float paramFloat2);
  
  public abstract void setMapViewOnTouchListener(View.OnTouchListener paramOnTouchListener);
  
  public abstract void updateLocaitonPinLayout(View paramView, double paramDouble1, double paramDouble2);
  
  public abstract void zoomToSpan(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.p.d
 * JD-Core Version:    0.7.0.1
 */