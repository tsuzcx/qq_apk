package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTFaceAttr;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.VideoFilterUtil.RATIO_MODE;
import java.util.List;
import java.util.Set;

public class MultiViewerFilter
{
  private static final String TAG;
  private Set<Integer> activeParts;
  private BaseFilter copyFilter;
  private BaseFilter effectFilter;
  private h emptyFrame;
  private boolean needOriginFrame;
  private int renderId;
  private VideoFilterList videoFilterList;
  
  static
  {
    AppMethodBeat.i(82672);
    TAG = MultiViewerFilter.class.getSimpleName();
    AppMethodBeat.o(82672);
  }
  
  public MultiViewerFilter()
  {
    AppMethodBeat.i(82661);
    this.emptyFrame = new h();
    AppMethodBeat.o(82661);
  }
  
  private void copyFrame(h paramh1, h paramh2)
  {
    AppMethodBeat.i(82666);
    if (this.copyFilter == null)
    {
      this.copyFilter = new BaseFilter(GLSLRender.btg);
      this.copyFilter.ApplyGLSLFilter();
    }
    this.copyFilter.RenderProcess(paramh1.texture[0], paramh2.width, paramh2.height, -1, 0.0D, paramh2);
    AppMethodBeat.o(82666);
  }
  
  private h renderStickers(h paramh, PTFaceAttr paramPTFaceAttr)
  {
    AppMethodBeat.i(82665);
    List localList1 = paramPTFaceAttr.getAllFacePoints();
    List localList2 = paramPTFaceAttr.getAllFaceAngles();
    List localList3 = paramPTFaceAttr.getHandPoints();
    BenchUtil.benchStart(TAG + " videoFilterList.process");
    this.videoFilterList.updateFaceParams(localList1, localList2, localList3, paramh.width);
    paramh = this.videoFilterList.processTransformRelatedFilters(paramh, paramPTFaceAttr);
    paramh = this.videoFilterList.updateAndRenderDynamicStickers(paramh, paramPTFaceAttr);
    BenchUtil.benchEnd(TAG + " videoFilterList.process");
    BenchUtil.benchStart(TAG + " videoFilterList.updateAndRenderStaticStickers");
    paramh = this.videoFilterList.updateAndRenderStaticStickers(paramh, paramPTFaceAttr);
    BenchUtil.benchEnd(TAG + " videoFilterList.updateAndRenderStaticStickers");
    AppMethodBeat.o(82665);
    return paramh;
  }
  
  public void ApplyGLSLFilter()
  {
    AppMethodBeat.i(82662);
    if (this.videoFilterList != null) {
      this.videoFilterList.ApplyGLSLFilter();
    }
    if (this.effectFilter != null) {
      this.effectFilter.ApplyGLSLFilter(false, 0.0F, 0.0F);
    }
    AppMethodBeat.o(82662);
  }
  
  public void clear()
  {
    AppMethodBeat.i(82668);
    if (this.videoFilterList != null) {
      this.videoFilterList.destroy();
    }
    if (this.effectFilter != null) {
      this.effectFilter.ClearGLSL();
    }
    if (this.copyFilter != null) {
      this.copyFilter.ClearGLSL();
    }
    if (this.emptyFrame != null) {
      this.emptyFrame.clear();
    }
    AppMethodBeat.o(82668);
  }
  
  public int getRenderId()
  {
    return this.renderId;
  }
  
  public boolean needRenderThisPart(int paramInt)
  {
    AppMethodBeat.i(82667);
    boolean bool = this.activeParts.contains(Integer.valueOf(paramInt));
    AppMethodBeat.o(82667);
    return bool;
  }
  
  public h render(h paramh1, h paramh2, PTFaceAttr paramPTFaceAttr)
  {
    AppMethodBeat.i(82664);
    int i = 0;
    Object localObject2;
    Object localObject1;
    if (this.needOriginFrame)
    {
      localObject2 = paramh1;
      localObject1 = localObject2;
      if (this.effectFilter != null)
      {
        BenchUtil.benchStart(TAG + " effectFilter.RenderProcess");
        this.effectFilter.RenderProcess(localObject2.texture[0], paramh2.width, paramh2.height, -1, 0.0D, paramh2);
        BenchUtil.benchEnd(TAG + " effectFilter.RenderProcess");
        localObject1 = FrameUtil.getLastRenderFrame(paramh2);
        i = 1;
      }
      localObject2 = localObject1;
      if (this.videoFilterList != null)
      {
        if (this.videoFilterList.getFastFaceStickerFilter() == null) {
          break label245;
        }
        if (i != 0) {
          break label225;
        }
        this.videoFilterList.setMultiViewerSrcTexture(localObject1.texture[0]);
        this.videoFilterList.setMultiViewerOutFrame(paramh2);
      }
    }
    for (;;)
    {
      localObject2 = renderStickers((h)localObject1, paramPTFaceAttr);
      AppMethodBeat.o(82664);
      return localObject2;
      this.emptyFrame.a(-1, paramh2.width, paramh2.height, 0.0D);
      FrameUtil.clearFrame(this.emptyFrame, 0.0F, 0.0F, 0.0F, 0.0F, paramh2.width, paramh2.height);
      localObject2 = this.emptyFrame;
      i = 1;
      break;
      label225:
      this.videoFilterList.setMultiViewerSrcTexture(0);
      this.videoFilterList.setMultiViewerOutFrame((h)localObject1);
    }
    label245:
    if (i == 0) {
      copyFrame(paramh1, paramh2);
    }
    for (;;)
    {
      localObject2 = renderStickers(paramh2, paramPTFaceAttr);
      break;
      paramh2 = (h)localObject1;
    }
  }
  
  public void reset()
  {
    AppMethodBeat.i(82670);
    if (this.videoFilterList != null) {
      this.videoFilterList.reset();
    }
    AppMethodBeat.o(82670);
  }
  
  public void setActiveParts(Set<Integer> paramSet)
  {
    this.activeParts = paramSet;
  }
  
  public void setAudioPause(boolean paramBoolean)
  {
    AppMethodBeat.i(82671);
    if (this.videoFilterList != null) {
      this.videoFilterList.setAudioPause(paramBoolean);
    }
    AppMethodBeat.o(82671);
  }
  
  public void setEffectFilter(BaseFilter paramBaseFilter)
  {
    this.effectFilter = paramBaseFilter;
  }
  
  public void setNeedOriginFrame(boolean paramBoolean)
  {
    this.needOriginFrame = paramBoolean;
  }
  
  public void setRatioMode(VideoFilterUtil.RATIO_MODE paramRATIO_MODE)
  {
    AppMethodBeat.i(82669);
    if (this.videoFilterList != null) {
      this.videoFilterList.setRatioMode(paramRATIO_MODE);
    }
    AppMethodBeat.o(82669);
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
    AppMethodBeat.i(82663);
    if (this.videoFilterList != null) {
      this.videoFilterList.updateVideoSize(paramInt1, paramInt2, paramDouble, 0);
    }
    AppMethodBeat.o(82663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.filter.MultiViewerFilter
 * JD-Core Version:    0.7.0.1
 */