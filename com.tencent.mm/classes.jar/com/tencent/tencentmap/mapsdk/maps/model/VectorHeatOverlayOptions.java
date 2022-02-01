package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class VectorHeatOverlayOptions
  extends BaseOverlayProvider
{
  private boolean mAnimate = false;
  private int mAnimateDuration = 5000;
  private int[] mColors;
  private boolean mDraw3D = false;
  private float mGap;
  private double mMaxHeight = 2000.0D;
  private double mMaxIntensity = 2000.0D;
  private int mMaxZoom = 22;
  private double mMinHeight = 0.0D;
  private double mMinIntensity = 0.0D;
  private int mMinZoom = 3;
  private WeightedLatLng[] mNodes;
  private float mOpacity = 1.0F;
  private boolean mRangeFlag = false;
  private float mSize = 2000.0F;
  private double[] mStartPoints;
  private int mType = 0;
  private boolean mVisibility = true;
  
  public final VectorHeatOverlayOptions animate(boolean paramBoolean)
  {
    this.mAnimate = paramBoolean;
    return this;
  }
  
  public final VectorHeatOverlayOptions colors(int[] paramArrayOfInt)
  {
    this.mColors = paramArrayOfInt;
    return this;
  }
  
  public final VectorHeatOverlayOptions draw3D(boolean paramBoolean)
  {
    this.mDraw3D = paramBoolean;
    return this;
  }
  
  public final VectorHeatOverlayOptions gap(float paramFloat)
  {
    this.mGap = paramFloat;
    return this;
  }
  
  public final int getAnimateTime()
  {
    return this.mAnimateDuration;
  }
  
  public final int[] getColors()
  {
    return this.mColors;
  }
  
  public final float getGap()
  {
    return this.mGap;
  }
  
  public final double getMaxHeight()
  {
    return this.mMaxHeight;
  }
  
  public final double getMaxIntensity()
  {
    return this.mMaxIntensity;
  }
  
  public final int getMaxZoom()
  {
    return this.mMaxZoom;
  }
  
  public final double getMinHeight()
  {
    return this.mMinHeight;
  }
  
  public final double getMinIntensity()
  {
    return this.mMinIntensity;
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
  
  public final boolean getRangeFlag()
  {
    return this.mRangeFlag;
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
    AppMethodBeat.i(217997);
    VectorHeatOverlayOptions.VectorHeatOverlayType localVectorHeatOverlayType = VectorHeatOverlayOptions.VectorHeatOverlayType.values()[this.mType];
    AppMethodBeat.o(217997);
    return localVectorHeatOverlayType;
  }
  
  public final VectorHeatOverlayOptions heightRange(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 <= paramDouble2) && (paramDouble1 >= 0.0D))
    {
      this.mMaxHeight = paramDouble2;
      this.mMinHeight = paramDouble1;
      return this;
    }
    this.mMinHeight = 0.0D;
    this.mMaxHeight = 2000.0D;
    return this;
  }
  
  public final boolean isAnimate()
  {
    return this.mAnimate;
  }
  
  public final boolean isDraw3D()
  {
    return this.mDraw3D;
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
  
  public final VectorHeatOverlayOptions setAnimateTime(int paramInt)
  {
    this.mAnimateDuration = paramInt;
    return this;
  }
  
  public final VectorHeatOverlayOptions showRange(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 <= paramDouble2) && (paramDouble1 >= 0.0D))
    {
      this.mMaxIntensity = paramDouble2;
      this.mMinIntensity = paramDouble1;
      this.mRangeFlag = true;
      return this;
    }
    this.mMinIntensity = 0.0D;
    this.mMaxIntensity = 2000.0D;
    this.mRangeFlag = false;
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
    AppMethodBeat.i(217999);
    this.mType = paramVectorHeatOverlayType.ordinal();
    AppMethodBeat.o(217999);
    return this;
  }
  
  public final VectorHeatOverlayOptions visibility(boolean paramBoolean)
  {
    this.mVisibility = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlayOptions
 * JD-Core Version:    0.7.0.1
 */