package com.tencent.tencentmap.mapsdk.maps.model;

import android.content.Context;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerDragListener;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Accessible;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Alphable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Anchorable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Animationable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Clickable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Collisionable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Draggable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Removable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Rotatable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Tagable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Visible;

public abstract interface Marker
  extends Accessible, Alphable, Anchorable, Animationable, Clickable, Collisionable, Draggable, Levelable, Removable, Rotatable, Tagable<Object>, Visible, IOverlay
{
  public abstract int getDisplayLevel();
  
  public abstract int getHeight(Context paramContext);
  
  public abstract TencentMap.OnMarkerDragListener getOnDragListener();
  
  public abstract MarkerOptions getOptions();
  
  public abstract LatLng getPosition();
  
  public abstract String getSnippet();
  
  public abstract String getTitle();
  
  public abstract int getWidth(Context paramContext);
  
  public abstract void hideInfoWindow();
  
  public abstract boolean isFastLoad();
  
  public abstract boolean isInMapCenterState();
  
  public abstract boolean isInfoWindowAutoOverturn();
  
  public abstract boolean isInfoWindowEnable();
  
  public abstract boolean isInfoWindowShown();
  
  public abstract boolean onTapMapViewBubbleHidden();
  
  public abstract void refreshInfoWindow();
  
  public abstract void setFastLoad(boolean paramBoolean);
  
  public abstract void setFixingPoint(int paramInt1, int paramInt2);
  
  public abstract void setFixingPointEnable(boolean paramBoolean);
  
  public abstract void setIcon(BitmapDescriptor paramBitmapDescriptor);
  
  public abstract void setInMapCenterState(boolean paramBoolean);
  
  public abstract void setInfoWindowAnchor(float paramFloat1, float paramFloat2);
  
  public abstract void setInfoWindowEnable(boolean paramBoolean);
  
  public abstract void setInfoWindowOffset(int paramInt1, int paramInt2);
  
  public abstract void setMarkerOptions(MarkerOptions paramMarkerOptions);
  
  public abstract void setOnTapMapViewBubbleHidden(boolean paramBoolean);
  
  public abstract void setPosition(LatLng paramLatLng);
  
  public abstract void setSnippet(String paramString);
  
  public abstract void setTitle(String paramString);
  
  public abstract void showInfoWindow();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.Marker
 * JD-Core Version:    0.7.0.1
 */