package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.ttpic.face.Face;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.HandActionCounter;
import com.tencent.ttpic.model.VideoFilterEffect;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VideoEffectFilterBase
  extends VideoFilterBase
{
  private static final String TAG = VideoEffectFilterBase.class.getSimpleName();
  protected VideoFilterEffect mVideoFilterEffect;
  
  public VideoEffectFilterBase(String paramString1, String paramString2, VideoFilterEffect paramVideoFilterEffect)
  {
    super(paramString1, paramString2);
    this.mVideoFilterEffect = paramVideoFilterEffect;
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    setTexCords(new float[] { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F });
  }
  
  public void initParams() {}
  
  public boolean shouldRender(int paramInt1, int paramInt2, List<Face> paramList)
  {
    if ((paramInt1 == -1) || (paramInt2 == 0) || (paramList == null) || (paramList.isEmpty())) {
      return true;
    }
    if (this.mVideoFilterEffect == null) {
      return false;
    }
    switch (this.mVideoFilterEffect.order)
    {
    default: 
      return false;
    case 1: 
      return paramInt1 == ((Face)paramList.get(0)).faceIndex;
    }
    return paramInt1 == ((Face)paramList.get(paramList.size() - 1)).faceIndex;
  }
  
  public void updatePreview(List<PointF> paramList1, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList2, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, float paramFloat, long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.filter.VideoEffectFilterBase
 * JD-Core Version:    0.7.0.1
 */