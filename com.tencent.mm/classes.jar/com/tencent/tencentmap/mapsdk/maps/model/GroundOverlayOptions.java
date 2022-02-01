package com.tencent.tencentmap.mapsdk.maps.model;

public final class GroundOverlayOptions
{
  private float mAlpha = 1.0F;
  private float mAnchorU = 0.5F;
  private float mAnchorV = 0.5F;
  private BitmapDescriptor mBitmapDescriptor;
  private LatLngBounds mLatLngBounds;
  private int mLevel = OverlayLevel.OverlayLevelAboveBuildings;
  private LatLng mPosition;
  private boolean mVisibility = true;
  private int mZIndex;
  private float mZoom = 18.0F;
  
  public final GroundOverlayOptions alpha(float paramFloat)
  {
    this.mAlpha = paramFloat;
    return this;
  }
  
  public final GroundOverlayOptions anchor(float paramFloat1, float paramFloat2)
  {
    this.mAnchorU = paramFloat1;
    this.mAnchorV = paramFloat2;
    return this;
  }
  
  public final GroundOverlayOptions bitmap(BitmapDescriptor paramBitmapDescriptor)
  {
    this.mBitmapDescriptor = paramBitmapDescriptor;
    return this;
  }
  
  public final float getAlpha()
  {
    return this.mAlpha;
  }
  
  public final float getAnchorU()
  {
    return this.mAnchorU;
  }
  
  public final float getAnchorV()
  {
    return this.mAnchorV;
  }
  
  public final BitmapDescriptor getBitmap()
  {
    return this.mBitmapDescriptor;
  }
  
  public final LatLngBounds getLatLngBounds()
  {
    return this.mLatLngBounds;
  }
  
  public final int getLevel()
  {
    return this.mLevel;
  }
  
  public final LatLng getPosition()
  {
    return this.mPosition;
  }
  
  public final int getZIndex()
  {
    return this.mZIndex;
  }
  
  public final float getZoom()
  {
    return this.mZoom;
  }
  
  public final boolean isVisible()
  {
    return this.mVisibility;
  }
  
  public final GroundOverlayOptions latLngBounds(LatLngBounds paramLatLngBounds)
  {
    this.mLatLngBounds = paramLatLngBounds;
    return this;
  }
  
  public final GroundOverlayOptions level(int paramInt)
  {
    if ((paramInt < OverlayLevel.OverlayLevelAboveRoads) || (paramInt > OverlayLevel.OverlayLevelAboveLabels)) {
      return this;
    }
    this.mLevel = paramInt;
    return this;
  }
  
  public final GroundOverlayOptions position(LatLng paramLatLng)
  {
    this.mPosition = paramLatLng;
    return this;
  }
  
  public final GroundOverlayOptions visible(boolean paramBoolean)
  {
    this.mVisibility = paramBoolean;
    return this;
  }
  
  public final GroundOverlayOptions zIndex(int paramInt)
  {
    this.mZIndex = paramInt;
    return this;
  }
  
  public final GroundOverlayOptions zoom(float paramFloat)
  {
    this.mZoom = paramFloat;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.GroundOverlayOptions
 * JD-Core Version:    0.7.0.1
 */