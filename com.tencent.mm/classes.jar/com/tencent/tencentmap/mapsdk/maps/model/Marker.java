package com.tencent.tencentmap.mapsdk.maps.model;

import android.content.Context;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerDragListener;

public abstract interface Marker
  extends IOverlay
{
  public abstract float getAlpha();
  
  public abstract float getAnchorU();
  
  public abstract float getAnchorV();
  
  public abstract String getContentDescription();
  
  public abstract int getDisplayLevel();
  
  public abstract int getHeight(Context paramContext);
  
  public abstract String getId();
  
  public abstract int getLevel();
  
  public abstract TencentMap.OnMarkerDragListener getOnDragListener();
  
  public abstract MarkerOptions getOptions();
  
  public abstract LatLng getPosition();
  
  public abstract float getRotation();
  
  public abstract String getSnippet();
  
  public abstract Object getTag();
  
  public abstract String getTitle();
  
  public abstract int getWidth(Context paramContext);
  
  public abstract float getZIndex();
  
  public abstract void hideInfoWindow();
  
  public abstract boolean isClickable();
  
  public abstract boolean isDraggable();
  
  public abstract boolean isFastLoad();
  
  public abstract boolean isInMapCenterState();
  
  public abstract boolean isInfoWindowAutoOverturn();
  
  public abstract boolean isInfoWindowEnable();
  
  public abstract boolean isInfoWindowShown();
  
  public abstract boolean isVisible();
  
  public abstract boolean onTapMapViewBubbleHidden();
  
  public abstract void refreshInfoWindow();
  
  public abstract void remove();
  
  public abstract void setAlpha(float paramFloat);
  
  public abstract void setAnchor(float paramFloat1, float paramFloat2);
  
  public abstract void setAnimation(Animation paramAnimation);
  
  public abstract void setClickable(boolean paramBoolean);
  
  public abstract void setContentDescription(String paramString);
  
  public abstract void setDraggable(boolean paramBoolean);
  
  public abstract void setFastLoad(boolean paramBoolean);
  
  public abstract void setFixingPoint(int paramInt1, int paramInt2);
  
  public abstract void setFixingPointEnable(boolean paramBoolean);
  
  public abstract void setIcon(BitmapDescriptor paramBitmapDescriptor);
  
  public abstract void setInMapCenterState(boolean paramBoolean);
  
  public abstract void setInfoWindowAnchor(float paramFloat1, float paramFloat2);
  
  public abstract void setInfoWindowEnable(boolean paramBoolean);
  
  public abstract void setInfoWindowOffset(int paramInt1, int paramInt2);
  
  public abstract void setLevel(int paramInt);
  
  public abstract void setMarkerOptions(MarkerOptions paramMarkerOptions);
  
  public abstract void setOnTapMapViewBubbleHidden(boolean paramBoolean);
  
  public abstract void setPosition(LatLng paramLatLng);
  
  public abstract void setRotation(float paramFloat);
  
  public abstract void setSnippet(String paramString);
  
  public abstract void setTag(Object paramObject);
  
  public abstract void setTitle(String paramString);
  
  public abstract void setVisible(boolean paramBoolean);
  
  public abstract void setZIndex(float paramFloat);
  
  public abstract void showInfoWindow();
  
  public abstract boolean startAnimation();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.Marker
 * JD-Core Version:    0.7.0.1
 */