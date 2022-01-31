package com.tencent.ttpic.filter;

import android.graphics.RectF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.b;
import com.tencent.filter.m.d;
import com.tencent.filter.m.f;
import com.tencent.filter.m.i;
import com.tencent.filter.m.j;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.model.WMElement;
import com.tencent.ttpic.util.MatrixUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.util.ArrayList;
import java.util.List;

public abstract class WMAnimationFilterBase
  extends BaseFilter
{
  private static final String TAG = WMAnimationFilterBase.class.getSimpleName();
  protected List<WMAnimationFilterBase.AnimationTimePoint> mAnimationTimePoints = new ArrayList();
  private int mDuration;
  private long mStartTime;
  
  public WMAnimationFilterBase(WMElement paramWMElement, int paramInt1, int paramInt2, int paramInt3)
  {
    super(FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/WMAnimationVertexShader.dat"), FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/WMAnimationFragmentShader.dat"));
    initParams(paramWMElement, paramInt1, paramInt2, paramInt3);
  }
  
  private void initParams(WMElement paramWMElement, int paramInt1, int paramInt2, int paramInt3)
  {
    addParam(new m.i("texNeedTransform", 1));
    addParam(new m.b("canvasSize", paramInt1, paramInt2));
    addParam(new m.b("texAnchor", (paramWMElement.finalContentRect.left + paramWMElement.finalContentRect.right) / 2.0F - paramInt1 / 2, (paramWMElement.finalContentRect.top + paramWMElement.finalContentRect.bottom) / 2.0F - paramInt2 / 2));
    addParam(new m.f("texScale", 1.0F));
    addParam(new m.d("texRotate", 0.0F, 0.0F, 0.0F));
    addParam(new m.j("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0F, 4.0F, 10.0F)));
    this.mStartTime = System.currentTimeMillis();
    this.mDuration = paramInt3;
    initAnimationTimePoints();
  }
  
  protected float getAnimationValue()
  {
    long l = (System.currentTimeMillis() - this.mStartTime) % this.mDuration;
    int i = 1;
    while (i < this.mAnimationTimePoints.size())
    {
      WMAnimationFilterBase.AnimationTimePoint localAnimationTimePoint1 = (WMAnimationFilterBase.AnimationTimePoint)this.mAnimationTimePoints.get(i - 1);
      WMAnimationFilterBase.AnimationTimePoint localAnimationTimePoint2 = (WMAnimationFilterBase.AnimationTimePoint)this.mAnimationTimePoints.get(i);
      if (l <= localAnimationTimePoint2.timePoint)
      {
        float f1 = (float)(l - localAnimationTimePoint1.timePoint) * 1.0F / (float)(localAnimationTimePoint2.timePoint - localAnimationTimePoint1.timePoint);
        float f2 = localAnimationTimePoint1.value;
        return (localAnimationTimePoint2.value - localAnimationTimePoint1.value) * f1 + f2;
      }
      i += 1;
    }
    return 0.0F;
  }
  
  protected abstract void initAnimationTimePoints();
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    setAnimationParams();
    return super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
  
  protected abstract void setAnimationParams();
  
  public void updateParams(WMElement paramWMElement, int paramInt1, int paramInt2)
  {
    addParam(new m.b("canvasSize", paramInt1, paramInt2));
    addParam(new m.b("texAnchor", (paramWMElement.finalContentRect.left + paramWMElement.finalContentRect.right) / 2.0F - paramInt1 / 2, (paramWMElement.finalContentRect.top + paramWMElement.finalContentRect.bottom) / 2.0F - paramInt2 / 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.filter.WMAnimationFilterBase
 * JD-Core Version:    0.7.0.1
 */