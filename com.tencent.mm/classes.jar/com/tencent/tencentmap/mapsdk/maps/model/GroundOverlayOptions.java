package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class GroundOverlayOptions
{
  public static Bitmap TRANSPARENT_PIXEL;
  private float mAlpha;
  private float mAnchorU;
  private float mAnchorV;
  private BitmapDescriptor mBitmapDescriptor;
  private LatLngBounds mLatLngBounds;
  private int mLevel;
  private LatLng mPosition;
  private boolean mVisibility;
  private int mZIndex;
  private float mZoom;
  
  static
  {
    AppMethodBeat.i(193608);
    Bitmap.Config localConfig = Bitmap.Config.ARGB_8888;
    TRANSPARENT_PIXEL = Bitmap.createBitmap(new int[] { 0 }, 1, 1, localConfig);
    AppMethodBeat.o(193608);
  }
  
  public GroundOverlayOptions()
  {
    AppMethodBeat.i(193607);
    this.mBitmapDescriptor = BitmapDescriptorFactory.fromBitmap(TRANSPARENT_PIXEL);
    this.mZoom = 18.0F;
    this.mAnchorU = 0.5F;
    this.mAnchorV = 0.5F;
    this.mAlpha = 1.0F;
    this.mVisibility = true;
    this.mLevel = OverlayLevel.OverlayLevelAboveBuildings;
    AppMethodBeat.o(193607);
  }
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.GroundOverlayOptions
 * JD-Core Version:    0.7.0.1
 */