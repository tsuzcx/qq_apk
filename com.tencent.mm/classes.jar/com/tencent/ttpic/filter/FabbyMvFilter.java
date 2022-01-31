package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.ttpic.factory.ShakaFilterFactory;
import com.tencent.ttpic.model.GridModel;
import com.tencent.ttpic.model.GridSettingModel;
import com.tencent.ttpic.model.Rect;
import com.tencent.ttpic.model.ShakaEffectItem;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoFilterFactory;
import com.tencent.ttpic.util.VideoFilterUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FabbyMvFilter
{
  public StaticStickerFilter bgFilter;
  public StaticStickerFilter coverFilter;
  private FastRenderFilter fastRenderFilter = new FastRenderFilter();
  public StaticStickerFilter fgFilter;
  private GridEffectFilter gridEffectFilter = new GridEffectFilter();
  private CanvasFilters mCanvasFilters = new CanvasFilters();
  private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.bcE);
  private h[] mCopyFrame = new h[2];
  public BaseFilter mEffectFilter;
  private h mFilterFrame = new h();
  private h mGridFrame = new h();
  private h mLastRenderFrame;
  private BaseFilter mMaskFilter = new BaseFilter(VideoFilterFactory.FRAGMENT_SHADER_MASK);
  private h mMotionBlurFrame = new h();
  private h mRotateScaleFrame = new h();
  public ShakaFilterBase mShakaFilter;
  private h mShakaFrame = new h();
  private ShakaMotionBlurFilter motionBlurFilter = new ShakaMotionBlurFilter();
  public FabbyMvPart mvPart;
  private float progress;
  private RotateScaleFilter rotateScaleFilter = new RotateScaleFilter();
  private long startTimeStamp = -1L;
  
  private boolean isRenderReady()
  {
    boolean bool1;
    if (this.bgFilter != null) {
      if (this.bgFilter.isRenderReady()) {
        bool1 = true;
      }
    }
    for (;;)
    {
      boolean bool2 = bool1;
      if (this.coverFilter != null)
      {
        if ((!bool1) || (!this.coverFilter.isRenderReady())) {
          break label72;
        }
        bool2 = true;
      }
      for (;;)
      {
        if (this.fgFilter != null)
        {
          if ((bool2) && (this.fgFilter.isRenderReady()))
          {
            return true;
            bool1 = false;
            break;
            label72:
            bool2 = false;
            continue;
          }
          return false;
        }
      }
      return bool2;
      bool1 = true;
    }
  }
  
  private void mergeFrame(h paramh1, h paramh2)
  {
    paramh1.a(-1, paramh1.width, paramh1.height, 0.0D);
    VideoFilterUtil.setBlendMode(true);
    this.mMaskFilter.OnDrawFrameGLSL();
    this.mMaskFilter.renderTexture(paramh2.texture[0], paramh2.width, paramh2.height);
    VideoFilterUtil.setBlendMode(false);
  }
  
  private boolean needMotionBlur(float paramFloat)
  {
    return Float.compare(paramFloat, 0.0F) != 0;
  }
  
  private boolean needTransform(double paramDouble1, double paramDouble2, double paramDouble3, PointF paramPointF1, PointF paramPointF2)
  {
    return (Double.compare(paramDouble1, 1.0D) != 0) || (paramDouble2 % 360.0D != 0.0D) || (Double.compare(paramDouble3, 1.0D) != 0) || (Float.compare(paramPointF1.x, 0.0F) != 0) || (Float.compare(paramPointF1.y, 0.0F) != 0) || (Float.compare(paramPointF2.x, 0.0F) != 0) || (Float.compare(paramPointF2.y, 0.0F) != 0);
  }
  
  private h renderForStaticFilters(h paramh, StaticStickerFilter paramStaticStickerFilter)
  {
    paramh.a(-1, paramh.width, paramh.height, 0.0D);
    if ((paramStaticStickerFilter == null) || (!paramStaticStickerFilter.isRenderReady())) {
      return paramh;
    }
    paramStaticStickerFilter.updateVideoSize(paramh.width, paramh.height, 0.0D);
    h localh1;
    if (paramh.texture[0] == this.mCopyFrame[0].texture[0])
    {
      localh1 = this.mCopyFrame[1];
      paramh.a(-1, paramh.width, paramh.height, 0.0D);
      VideoFilterUtil.setBlendMode(true);
      if (VideoFilterUtil.canUseBlendMode(paramStaticStickerFilter)) {
        break label215;
      }
      if (!VideoFileUtil.needCopy(paramStaticStickerFilter)) {
        break label252;
      }
    }
    label215:
    label252:
    for (h localh2 = FrameUtil.renderProcessBySwitchFbo(paramh.texture[0], paramh.width, paramh.height, this.mCopyFilter, paramh, localh1);; localh2 = paramh)
    {
      BenchUtil.benchStart("[showPreview]renderProcessBySwitchFbo " + paramStaticStickerFilter.getClass().getName());
      paramh = FrameUtil.renderProcessBySwitchFbo(localh2.texture[0], localh2.width, localh2.height, paramStaticStickerFilter, paramh, localh1);
      BenchUtil.benchEnd("[showPreview]renderProcessBySwitchFbo " + paramStaticStickerFilter.getClass().getName());
      for (;;)
      {
        VideoFilterUtil.setBlendMode(false);
        return paramh;
        localh1 = this.mCopyFrame[0];
        break;
        BenchUtil.benchStart("[showPreview]OnDrawFrameGLSL");
        paramStaticStickerFilter.OnDrawFrameGLSL();
        paramStaticStickerFilter.renderTexture(paramh.texture[0], paramh.width, paramh.height);
        BenchUtil.benchEnd("[showPreview]OnDrawFrameGLSL");
      }
    }
  }
  
  private h updateAndRenderCameraFrame(h paramh, float paramFloat)
  {
    h localh = updateAndRenderShakaEffect(paramh, paramFloat);
    double d1 = this.mvPart.getScale(paramFloat);
    double d2 = this.mvPart.getDegree(paramFloat);
    double d3 = this.mvPart.getAlpha(paramFloat);
    Object localObject = this.mvPart.getAnchor(paramFloat);
    PointF localPointF = this.mvPart.getTranslate(paramFloat);
    double d4 = this.mvPart.getBlurSize(paramFloat);
    double d5 = this.mvPart.getBlurAngle(paramFloat);
    this.rotateScaleFilter.updateParams((float)d1, (float)(3.141592653589793D * d2 / 180.0D), (float)d3, (PointF)localObject, localPointF, new PointF(localh.width, localh.height));
    this.motionBlurFilter.updateParams((float)d4, (float)d5, localh.width, localh.height);
    if (needTransform(d1, d2, d3, (PointF)localObject, localPointF))
    {
      FrameUtil.clearFrame(this.mRotateScaleFrame, 0.0F, 0.0F, 0.0F, 0.0F, localh.width, localh.height);
      this.rotateScaleFilter.RenderProcess(localh.texture[0], localh.width, localh.height, -1, 0.0D, this.mRotateScaleFrame);
      localh = this.mRotateScaleFrame;
    }
    for (;;)
    {
      localObject = localh;
      if (needMotionBlur((float)d4))
      {
        FrameUtil.clearFrame(this.mMotionBlurFrame, 0.0F, 0.0F, 0.0F, 0.0F, localh.width, localh.height);
        this.motionBlurFilter.RenderProcess(localh.texture[0], localh.width, localh.height, -1, 0.0D, this.mMotionBlurFrame);
        localObject = FrameUtil.getLastRenderFrame(this.mMotionBlurFrame);
      }
      if (paramh != localObject) {
        this.mCopyFilter.RenderProcess(localObject.texture[0], ((h)localObject).width, ((h)localObject).height, -1, 0.0D, paramh);
      }
      return paramh;
    }
  }
  
  private h updateAndRenderFilterEffect(h paramh, float paramFloat)
  {
    if (this.mvPart.getFilterParam(paramFloat) != 0) {}
    for (int i = 1; (this.mEffectFilter == null) || (i == 0); i = 0) {
      return paramh;
    }
    this.mEffectFilter.RenderProcess(paramh.texture[0], paramh.width, paramh.height, -1, 0.0D, this.mFilterFrame);
    return FrameUtil.getLastRenderFrame(this.mFilterFrame);
  }
  
  private h updateAndRenderGrid(h paramh1, h paramh2, float paramFloat)
  {
    this.gridEffectFilter.setGridType(this.mvPart.getGridType(paramFloat));
    paramh1.a(-1, paramh1.width, paramh1.height, 0.0D);
    VideoFilterUtil.setBlendMode(true);
    this.gridEffectFilter.OnDrawFrameGLSL();
    this.gridEffectFilter.renderTexture(paramh2.texture[0], paramh2.width, paramh2.height);
    VideoFilterUtil.setBlendMode(false);
    return paramh1;
  }
  
  private h updateAndRenderShakaEffect(h paramh, float paramFloat)
  {
    if (this.mShakaFilter == null) {
      return paramh;
    }
    Map localMap = this.mvPart.getShakaValueMap(paramFloat);
    this.mShakaFilter.setParameters(localMap);
    FrameUtil.clearFrame(this.mShakaFrame, 0.0F, 0.0F, 0.0F, 0.0F, paramh.width, paramh.height);
    this.mShakaFilter.RenderProcess(paramh.texture[0], paramh.width, paramh.height, -1, 0.0D, this.mShakaFrame);
    return this.mShakaFrame;
  }
  
  public void ApplyGLSLFilter()
  {
    if (this.bgFilter != null) {
      this.bgFilter.ApplyGLSLFilter();
    }
    if (this.fgFilter != null) {
      this.fgFilter.ApplyGLSLFilter();
    }
    if (this.coverFilter != null) {
      this.coverFilter.ApplyGLSLFilter();
    }
    this.mCopyFilter.ApplyGLSLFilter();
    this.mCanvasFilters.ApplyGLSLFilter();
    this.gridEffectFilter.ApplyGLSLFilter();
    this.rotateScaleFilter.ApplyGLSLFilter();
    this.mMaskFilter.ApplyGLSLFilter();
    if (this.mvPart.getShakaEffectItem() != null)
    {
      this.mShakaFilter = ShakaFilterFactory.create(this.mvPart.getShakaEffectItem().getFilterType());
      if (this.mShakaFilter != null) {
        this.mShakaFilter.ApplyGLSLFilter();
      }
    }
    if (this.mEffectFilter != null) {
      this.mEffectFilter.ApplyGLSLFilter(false, 0.0F, 0.0F);
    }
    int i = 0;
    while (i < this.mCopyFrame.length)
    {
      this.mCopyFrame[i] = new h();
      i += 1;
    }
    this.motionBlurFilter.ApplyGLSLFilter(false, 0.0F, 0.0F);
    this.fastRenderFilter.applyGLSLFilter();
  }
  
  public void clear()
  {
    if (this.bgFilter != null) {
      this.bgFilter.clearGLSLSelf();
    }
    if (this.fgFilter != null) {
      this.fgFilter.clearGLSLSelf();
    }
    if (this.coverFilter != null) {
      this.coverFilter.clearGLSLSelf();
    }
    if (this.mEffectFilter != null) {
      this.mEffectFilter.clearGLSLSelf();
    }
    this.gridEffectFilter.clearGLSLSelf();
    this.rotateScaleFilter.clearGLSLSelf();
    this.mMaskFilter.clearGLSLSelf();
    this.mCopyFilter.clearGLSLSelf();
    this.mCanvasFilters.clearGLSLSelf();
    this.motionBlurFilter.ClearGLSL();
    h[] arrayOfh = this.mCopyFrame;
    int j = arrayOfh.length;
    int i = 0;
    while (i < j)
    {
      arrayOfh[i].clear();
      i += 1;
    }
    this.mShakaFrame.clear();
    this.mMotionBlurFrame.clear();
    this.mRotateScaleFrame.clear();
    this.mFilterFrame.clear();
    if (this.mLastRenderFrame != null) {
      this.mLastRenderFrame.clear();
    }
    this.fastRenderFilter.clearGLSLSelf();
    if (this.mGridFrame != null) {
      this.mGridFrame.clear();
    }
  }
  
  public Map<Integer, PointF> getGridScaleMap()
  {
    HashMap localHashMap = new HashMap();
    if (this.mvPart.getGridType(this.progress) == 6)
    {
      GridSettingModel localGridSettingModel = this.mvPart.getGridSetting(this.progress);
      if (localGridSettingModel != null)
      {
        Iterator localIterator = localGridSettingModel.canvasRectList.iterator();
        while (localIterator.hasNext())
        {
          GridModel localGridModel = (GridModel)localIterator.next();
          float f = Math.min(Math.max(localGridModel.canvasRect.width / localGridSettingModel.canvasRect.width, localGridModel.canvasRect.height / localGridSettingModel.canvasRect.height), 1.0F);
          PointF localPointF;
          if (localHashMap.get(Integer.valueOf(localGridModel.renderId)) != null)
          {
            localPointF = (PointF)localHashMap.get(Integer.valueOf(localGridModel.renderId));
            if ((localPointF.x < f) || (localPointF.y < f))
            {
              localPointF.x = f;
              localPointF.y = f;
              localHashMap.put(Integer.valueOf(localGridModel.renderId), localPointF);
            }
          }
          else
          {
            localPointF = new PointF(f, f);
            localHashMap.put(Integer.valueOf(localGridModel.renderId), localPointF);
          }
        }
      }
    }
    else
    {
      localHashMap.put(Integer.valueOf(0), new PointF(1.0F, 1.0F));
    }
    return localHashMap;
  }
  
  public h getLastRenderFrame()
  {
    return this.mLastRenderFrame;
  }
  
  public long getTimestamp()
  {
    return this.startTimeStamp;
  }
  
  public h renderBgFilter(h paramh)
  {
    return renderForStaticFilters(paramh, this.bgFilter);
  }
  
  public h renderCoverFilter(h paramh)
  {
    return renderForStaticFilters(paramh, this.coverFilter);
  }
  
  public h renderFgFilter(h paramh)
  {
    return renderForStaticFilters(paramh, this.fgFilter);
  }
  
  public void reset()
  {
    this.startTimeStamp = -1L;
    if (this.bgFilter != null) {
      this.bgFilter.resetFabbyProgress();
    }
    if (this.fgFilter != null) {
      this.fgFilter.resetFabbyProgress();
    }
    if (this.coverFilter != null) {
      this.coverFilter.resetFabbyProgress();
    }
  }
  
  public void setRenderMode(int paramInt)
  {
    if (this.bgFilter != null) {
      VideoFilterUtil.setRenderMode(this.bgFilter, paramInt);
    }
    if (this.fgFilter != null) {
      VideoFilterUtil.setRenderMode(this.fgFilter, paramInt);
    }
    if (this.coverFilter != null) {
      VideoFilterUtil.setRenderMode(this.coverFilter, paramInt);
    }
    if (this.mEffectFilter != null) {
      VideoFilterUtil.setRenderMode(this.mEffectFilter, paramInt);
    }
    VideoFilterUtil.setRenderMode(this.gridEffectFilter, paramInt);
    VideoFilterUtil.setRenderMode(this.rotateScaleFilter, paramInt);
    this.mCanvasFilters.setRenderMode(paramInt);
  }
  
  public h updateAndRender(h paramh, Map<Integer, h> paramMap, long paramLong)
  {
    if (!isRenderReady()) {
      return paramh;
    }
    if (this.mvPart.getGridType(this.progress) == 6)
    {
      i = this.mvPart.getGridOrder(this.progress);
      BenchUtil.benchStart("[showPreview][FABBY] bg");
      Object localObject1 = renderBgFilter(paramh);
      BenchUtil.benchEnd("[showPreview][FABBY] bg");
      this.mCopyFilter.RenderProcess(localObject1.texture[0], ((h)localObject1).width, ((h)localObject1).height, -1, 0.0D, this.mGridFrame);
      Iterator localIterator;
      Object localObject2;
      h localh;
      if (i == 0)
      {
        BenchUtil.benchStart("[showPreview][FABBY] grid");
        paramh = new ArrayList();
        localObject1 = this.mvPart.getGridSetting(this.progress);
        if (localObject1 != null)
        {
          localIterator = ((GridSettingModel)localObject1).canvasRectList.iterator();
          while (localIterator.hasNext())
          {
            localObject2 = (GridModel)localIterator.next();
            if (paramMap.containsKey(Integer.valueOf(((GridModel)localObject2).renderId)))
            {
              localh = updateAndRenderCameraFrame((h)paramMap.get(Integer.valueOf(((GridModel)localObject2).renderId)), this.progress);
              localObject2 = this.mCanvasFilters.drawOnFrame((GridModel)localObject2, localh, ((GridSettingModel)localObject1).canvasRect.width, ((GridSettingModel)localObject1).canvasRect.height);
              if (localObject2 != null) {
                paramh.add(localObject2);
              }
            }
          }
        }
        VideoFilterUtil.setBlendMode(true);
        this.fastRenderFilter.render(paramh, this.mGridFrame);
        VideoFilterUtil.setBlendMode(false);
        paramh = this.mGridFrame;
        BenchUtil.benchEnd("[showPreview][FABBY] grid");
      }
      for (;;)
      {
        BenchUtil.benchStart("[showPreview][FABBY] cover");
        paramh = renderCoverFilter(paramh);
        BenchUtil.benchEnd("[showPreview][FABBY] cover");
        BenchUtil.benchStart("[showPreview][FABBY] fg");
        paramh = renderFgFilter(paramh);
        BenchUtil.benchEnd("[showPreview][FABBY] fg");
        BenchUtil.benchStart("[showPreview][FABBY] effect");
        paramh = updateAndRenderFilterEffect(paramh, this.progress);
        BenchUtil.benchEnd("[showPreview][FABBY] effect");
        this.mLastRenderFrame = paramh;
        return paramh;
        if (i == 1)
        {
          BenchUtil.benchStart("[showPreview][FABBY] grid");
          paramh = new ArrayList();
          localObject1 = this.mvPart.getGridSetting(this.progress);
          if (localObject1 != null)
          {
            localIterator = ((GridSettingModel)localObject1).canvasRectList.iterator();
            while (localIterator.hasNext())
            {
              localObject2 = (GridModel)localIterator.next();
              if (paramMap.containsKey(Integer.valueOf(((GridModel)localObject2).renderId)))
              {
                localh = (h)paramMap.get(Integer.valueOf(((GridModel)localObject2).renderId));
                localObject2 = this.mCanvasFilters.drawOnFrame((GridModel)localObject2, localh, ((GridSettingModel)localObject1).canvasRect.width, ((GridSettingModel)localObject1).canvasRect.height);
                if (localObject2 != null) {
                  paramh.add(localObject2);
                }
              }
            }
          }
          VideoFilterUtil.setBlendMode(true);
          this.fastRenderFilter.render(paramh, this.mGridFrame);
          VideoFilterUtil.setBlendMode(false);
          paramh = updateAndRenderCameraFrame(this.mGridFrame, this.progress);
          BenchUtil.benchEnd("[showPreview][FABBY] grid");
        }
      }
    }
    paramMap = (h)paramMap.values().iterator().next();
    BenchUtil.benchStart("[showPreview][FABBY] bg");
    paramh = renderBgFilter(paramh);
    BenchUtil.benchEnd("[showPreview][FABBY] bg");
    int i = this.mvPart.getGridMode(this.progress);
    int j = this.mvPart.getGridOrder(this.progress);
    if (i == 0)
    {
      BenchUtil.benchStart("[showPreview][FABBY] merge");
      if (j == 0)
      {
        mergeFrame(paramh, updateAndRenderCameraFrame(paramMap, this.progress));
        label641:
        BenchUtil.benchEnd("[showPreview][FABBY] merge");
      }
    }
    label648:
    label876:
    for (;;)
    {
      BenchUtil.benchStart("[showPreview][FABBY] cover");
      paramh = renderCoverFilter(paramh);
      BenchUtil.benchEnd("[showPreview][FABBY] cover");
      BenchUtil.benchStart("[showPreview][FABBY] fg");
      paramh = renderFgFilter(paramh);
      BenchUtil.benchEnd("[showPreview][FABBY] fg");
      if (i == 0)
      {
        BenchUtil.benchStart("[showPreview][FABBY] grid");
        FrameUtil.clearFrame(this.mGridFrame, 0.0F, 0.0F, 0.0F, 0.0F, paramh.width, paramh.height);
        paramMap = updateAndRenderGrid(this.mGridFrame, paramh, this.progress);
        BenchUtil.benchEnd("[showPreview][FABBY] grid");
        paramh = paramMap;
        if (j == 1) {
          paramh = updateAndRenderCameraFrame(paramMap, this.progress);
        }
      }
      for (;;)
      {
        paramh = updateAndRenderFilterEffect(paramh, this.progress);
        break;
        if (j != 1) {
          break label641;
        }
        mergeFrame(paramh, paramMap);
        break label641;
        this.mCopyFilter.RenderProcess(paramh.texture[0], paramh.width, paramh.height, -1, 0.0D, this.mGridFrame);
        if (j == 0)
        {
          paramh = updateAndRenderCameraFrame(paramMap, this.progress);
          paramh = updateAndRenderGrid(this.mGridFrame, paramh, this.progress);
          break label648;
        }
        if (j != 1) {
          break label876;
        }
        paramh = updateAndRenderCameraFrame(updateAndRenderGrid(this.mGridFrame, paramMap, this.progress), this.progress);
        break label648;
      }
    }
  }
  
  public void updateTextureParam(long paramLong)
  {
    if (this.startTimeStamp < 0L) {
      this.startTimeStamp = paramLong;
    }
    this.progress = ((float)(paramLong - this.startTimeStamp) / (float)this.mvPart.duration);
    if (this.bgFilter != null) {
      this.bgFilter.updateFabbyProgress(paramLong);
    }
    if (this.coverFilter != null) {
      this.coverFilter.updateFabbyProgress(paramLong);
    }
    if (this.fgFilter != null) {
      this.fgFilter.updateFabbyProgress(paramLong);
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    if (this.bgFilter != null) {
      this.bgFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.fgFilter != null) {
      this.fgFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.coverFilter != null) {
      this.coverFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.filter.FabbyMvFilter
 * JD-Core Version:    0.7.0.1
 */