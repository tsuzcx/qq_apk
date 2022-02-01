package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.map.sdk.utilities.heatmap.WeightedLatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class VectorHeatOverlayOptions
{
  private int[] mColors;
  private float mGap;
  private int mMaxZoom = 22;
  private int mMinZoom = 3;
  private WeightedLatLng[] mNodes;
  private float mOpacity = 1.0F;
  private float mSize = 2000.0F;
  private double[] mStartPoints;
  private int mType = 0;
  private boolean mVisibility = true;
  
  public final VectorHeatOverlayOptions colors(int[] paramArrayOfInt)
  {
    this.mColors = paramArrayOfInt;
    return this;
  }
  
  public final VectorHeatOverlayOptions gap(float paramFloat)
  {
    this.mGap = paramFloat;
    return this;
  }
  
  public final int[] getColors()
  {
    return this.mColors;
  }
  
  public final float getGap()
  {
    return this.mGap;
  }
  
  public final int getMaxZoom()
  {
    return this.mMaxZoom;
  }
  
  public final int getMinZoom()
  {
    return this.mMinZoom;
  }
  
  public final WeightedLatLng[] getNodes()
  {
    return this.mNodes;
  }
  
  public final float getOpacity()
  {
    return this.mOpacity;
  }
  
  public final float getSize()
  {
    return this.mSize;
  }
  
  public final double[] getStartPoints()
  {
    return this.mStartPoints;
  }
  
  public final VectorHeatOverlayOptions.VectorHeatOverlayType getType()
  {
    AppMethodBeat.i(191301);
    VectorHeatOverlayOptions.VectorHeatOverlayType localVectorHeatOverlayType = VectorHeatOverlayOptions.VectorHeatOverlayType.values()[this.mType];
    AppMethodBeat.o(191301);
    return localVectorHeatOverlayType;
  }
  
  public final boolean isVisibility()
  {
    return this.mVisibility;
  }
  
  public final VectorHeatOverlayOptions maxZoom(int paramInt)
  {
    this.mMaxZoom = paramInt;
    return this;
  }
  
  public final VectorHeatOverlayOptions minZoom(int paramInt)
  {
    this.mMinZoom = paramInt;
    return this;
  }
  
  public final VectorHeatOverlayOptions nodes(WeightedLatLng[] paramArrayOfWeightedLatLng)
  {
    this.mNodes = paramArrayOfWeightedLatLng;
    return this;
  }
  
  public final VectorHeatOverlayOptions opacity(float paramFloat)
  {
    this.mOpacity = paramFloat;
    return this;
  }
  
  public final VectorHeatOverlayOptions size(float paramFloat)
  {
    this.mSize = paramFloat;
    return this;
  }
  
  public final VectorHeatOverlayOptions startPoints(double[] paramArrayOfDouble)
  {
    this.mStartPoints = paramArrayOfDouble;
    return this;
  }
  
  public final VectorHeatOverlayOptions type(VectorHeatOverlayOptions.VectorHeatOverlayType paramVectorHeatOverlayType)
  {
    AppMethodBeat.i(191302);
    this.mType = paramVectorHeatOverlayType.ordinal();
    AppMethodBeat.o(191302);
    return this;
  }
  
  public final VectorHeatOverlayOptions visibility(boolean paramBoolean)
  {
    this.mVisibility = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlayOptions
 * JD-Core Version:    0.7.0.1
 */