package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.HandActionCounter;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.VideoFilterUtil.RATIO_MODE;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MultiViewerFilter
{
  private static final String TAG = MultiViewerFilter.class.getSimpleName();
  private Set<Integer> activeParts;
  private BaseFilter copyFilter;
  private BaseFilter effectFilter;
  private float outScale = 1.0F;
  private int renderId;
  private VideoFilterList videoFilterList;
  
  private void copyFrame(h paramh1, h paramh2)
  {
    if (this.copyFilter == null)
    {
      this.copyFilter = new BaseFilter(GLSLRender.bcE);
      this.copyFilter.ApplyGLSLFilter();
    }
    this.copyFilter.RenderProcess(paramh1.texture[0], paramh2.width, paramh2.height, -1, 0.0D, paramh2);
  }
  
  private h renderStickers(h paramh, List<List<PointF>> paramList, List<float[]> paramList1, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList2, float[] paramArrayOfFloat, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, double paramDouble, byte[] paramArrayOfByte, int paramInt, long paramLong, boolean paramBoolean)
  {
    BenchUtil.benchStart(TAG + " videoFilterList.process");
    paramh = this.videoFilterList.process(paramh, null, paramList, paramList1, paramMap, paramList2, paramArrayOfFloat, paramMap1, paramSet, paramDouble, paramArrayOfByte, paramLong, paramBoolean);
    BenchUtil.benchEnd(TAG + " videoFilterList.process");
    BenchUtil.benchStart(TAG + " videoFilterList.updateAndRenderStaticStickers");
    paramh = this.videoFilterList.updateAndRenderStaticStickers(paramh, paramList, paramList1, paramMap, paramList2, paramMap1, paramSet, paramDouble, paramInt, paramLong);
    BenchUtil.benchEnd(TAG + " videoFilterList.updateAndRenderStaticStickers");
    return paramh;
  }
  
  public void ApplyGLSLFilter()
  {
    if (this.videoFilterList != null) {
      this.videoFilterList.ApplyGLSLFilter();
    }
    if (this.effectFilter != null) {
      this.effectFilter.ApplyGLSLFilter(false, 0.0F, 0.0F);
    }
  }
  
  public void clear()
  {
    if (this.videoFilterList != null) {
      this.videoFilterList.destroy();
    }
    if (this.effectFilter != null) {
      this.effectFilter.ClearGLSL();
    }
    if (this.copyFilter != null) {
      this.copyFilter.ClearGLSL();
    }
  }
  
  public int getRenderId()
  {
    return this.renderId;
  }
  
  public boolean needRenderThisPart(int paramInt)
  {
    return this.activeParts.contains(Integer.valueOf(paramInt));
  }
  
  public h render(h paramh1, h paramh2, List<List<PointF>> paramList, List<float[]> paramList1, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList2, float[] paramArrayOfFloat, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, double paramDouble, byte[] paramArrayOfByte, int paramInt, long paramLong, boolean paramBoolean)
  {
    int i = 0;
    h localh1;
    if (this.effectFilter != null)
    {
      BenchUtil.benchStart(TAG + " effectFilter.RenderProcess");
      this.effectFilter.RenderProcess(paramh1.texture[0], paramh2.width, paramh2.height, -1, 0.0D, paramh2);
      BenchUtil.benchEnd(TAG + " effectFilter.RenderProcess");
      localh1 = FrameUtil.getLastRenderFrame(paramh2);
      i = 1;
    }
    for (;;)
    {
      h localh2 = localh1;
      if (this.videoFilterList != null)
      {
        if (this.videoFilterList.getFastStickerFilter() == null) {
          break label205;
        }
        if (i != 0) {
          break label174;
        }
        this.videoFilterList.setMultiViewerSrcTexture(localh1.texture[0]);
        this.videoFilterList.setMultiViewerOutFrame(paramh2);
      }
      for (;;)
      {
        localh2 = renderStickers(localh1, paramList, paramList1, paramMap, paramList2, paramArrayOfFloat, paramMap1, paramSet, paramDouble, paramArrayOfByte, paramInt, paramLong, paramBoolean);
        return localh2;
        label174:
        this.videoFilterList.setOutScale(this.outScale);
        this.videoFilterList.setMultiViewerSrcTexture(0);
        this.videoFilterList.setMultiViewerOutFrame(localh1);
      }
      label205:
      this.videoFilterList.setOutScale(this.outScale);
      if (i == 0)
      {
        copyFrame(paramh1, paramh2);
        localh1 = paramh2;
      }
      return renderStickers(localh1, paramList, paramList1, paramMap, paramList2, paramArrayOfFloat, paramMap1, paramSet, paramDouble, paramArrayOfByte, paramInt, paramLong, paramBoolean);
      localh1 = paramh1;
    }
  }
  
  public void setActiveParts(Set<Integer> paramSet)
  {
    this.activeParts = paramSet;
  }
  
  public void setEffectFilter(BaseFilter paramBaseFilter)
  {
    this.effectFilter = paramBaseFilter;
  }
  
  public void setOutScale(float paramFloat)
  {
    this.outScale = paramFloat;
  }
  
  public void setRatioMode(VideoFilterUtil.RATIO_MODE paramRATIO_MODE)
  {
    if (this.videoFilterList != null) {
      this.videoFilterList.setRatioMode(paramRATIO_MODE);
    }
  }
  
  public void setRenderId(int paramInt)
  {
    this.renderId = paramInt;
  }
  
  public void setVideoFilterList(VideoFilterList paramVideoFilterList)
  {
    this.videoFilterList = paramVideoFilterList;
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    if (this.videoFilterList != null) {
      this.videoFilterList.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.filter.MultiViewerFilter
 * JD-Core Version:    0.7.0.1
 */