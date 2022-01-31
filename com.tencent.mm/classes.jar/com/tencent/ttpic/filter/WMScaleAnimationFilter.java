package com.tencent.ttpic.filter;

import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.WMElement;
import java.util.List;

public class WMScaleAnimationFilter
  extends WMAnimationFilterBase
{
  private static final int ANIMATION_DURATION = 1000;
  private static final int ANIMATION_FRAMES = 16;
  private static final int FRAME_DURATION = 62;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(83184);
    TAG = WMScaleAnimationFilter.class.getSimpleName();
    AppMethodBeat.o(83184);
  }
  
  public WMScaleAnimationFilter(WMElement paramWMElement, int paramInt1, int paramInt2)
  {
    super(paramWMElement, paramInt1, paramInt2, 1000);
  }
  
  protected void initAnimationTimePoints()
  {
    AppMethodBeat.i(83182);
    this.mAnimationTimePoints.add(new WMAnimationFilterBase.AnimationTimePoint(this, 0L, 1.0F));
    this.mAnimationTimePoints.add(new WMAnimationFilterBase.AnimationTimePoint(this, 124L, 1.03F));
    this.mAnimationTimePoints.add(new WMAnimationFilterBase.AnimationTimePoint(this, 248L, 0.97F));
    this.mAnimationTimePoints.add(new WMAnimationFilterBase.AnimationTimePoint(this, 372L, 1.03F));
    this.mAnimationTimePoints.add(new WMAnimationFilterBase.AnimationTimePoint(this, 496L, 0.97F));
    this.mAnimationTimePoints.add(new WMAnimationFilterBase.AnimationTimePoint(this, 620L, 1.0F));
    this.mAnimationTimePoints.add(new WMAnimationFilterBase.AnimationTimePoint(this, 992L, 1.0F));
    AppMethodBeat.o(83182);
  }
  
  protected void setAnimationParams()
  {
    AppMethodBeat.i(83183);
    addParam(new m.f("texScale", getAnimationValue()));
    AppMethodBeat.o(83183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.filter.WMScaleAnimationFilter
 * JD-Core Version:    0.7.0.1
 */