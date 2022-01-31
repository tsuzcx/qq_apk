package com.tencent.ttpic.filter;

import com.tencent.filter.m.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.WMElement;
import java.util.List;

public class WMDitheringAnimationFilter
  extends WMAnimationFilterBase
{
  private static final int ANIMATION_DURATION = 1000;
  private static final int ANIMATION_FRAMES = 16;
  private static final int FRAME_DURATION = 62;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(83181);
    TAG = WMDitheringAnimationFilter.class.getSimpleName();
    AppMethodBeat.o(83181);
  }
  
  public WMDitheringAnimationFilter(WMElement paramWMElement, int paramInt1, int paramInt2)
  {
    super(paramWMElement, paramInt1, paramInt2, 1000);
  }
  
  protected void initAnimationTimePoints()
  {
    AppMethodBeat.i(83179);
    this.mAnimationTimePoints.add(new WMAnimationFilterBase.AnimationTimePoint(this, 0L, 0.0F));
    this.mAnimationTimePoints.add(new WMAnimationFilterBase.AnimationTimePoint(this, 124L, (float)Math.toRadians(6.0D)));
    this.mAnimationTimePoints.add(new WMAnimationFilterBase.AnimationTimePoint(this, 248L, (float)Math.toRadians(-6.0D)));
    this.mAnimationTimePoints.add(new WMAnimationFilterBase.AnimationTimePoint(this, 372L, (float)Math.toRadians(6.0D)));
    this.mAnimationTimePoints.add(new WMAnimationFilterBase.AnimationTimePoint(this, 496L, (float)Math.toRadians(-6.0D)));
    this.mAnimationTimePoints.add(new WMAnimationFilterBase.AnimationTimePoint(this, 620L, (float)Math.toRadians(0.0D)));
    this.mAnimationTimePoints.add(new WMAnimationFilterBase.AnimationTimePoint(this, 992L, (float)Math.toRadians(0.0D)));
    AppMethodBeat.o(83179);
  }
  
  protected void setAnimationParams()
  {
    AppMethodBeat.i(83180);
    addParam(new m.d("texRotate", 0.0F, 0.0F, getAnimationValue()));
    AppMethodBeat.o(83180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.filter.WMDitheringAnimationFilter
 * JD-Core Version:    0.7.0.1
 */