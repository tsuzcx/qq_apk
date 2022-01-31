package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.logic.watermark.LogicDataManager;
import com.tencent.ttpic.model.RenderParam;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.TRIGGERED_STATUS;
import com.tencent.ttpic.model.TextRenderItem;
import com.tencent.ttpic.model.Transition;
import com.tencent.ttpic.model.TriggerCtrlItem;
import com.tencent.ttpic.model.WMGroup;
import com.tencent.ttpic.particlesystem2d.Particle;
import com.tencent.ttpic.particlesystem2d.ParticleItem;
import com.tencent.ttpic.particlesystem2d.ParticleSystem2D;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.PARTICLE_CLEAR_MODE;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class VoiceTextFilter
  extends VideoFilterBase
{
  private static final String TAG;
  private float faceDetScale;
  private FastRenderFilter fastRenderFilter;
  private int frameInterval;
  private boolean isBackground;
  private long lastFrameTimestamp;
  private int lastHeight;
  private int lastWidth;
  private ParticleItem[] particleItems;
  private ParticleSystem2D particleSystem2D;
  private List<RenderParam> renderParams;
  private List<StickerItem> stickerItems;
  private List<TextRenderItem> textRenderItems;
  private int zIndex;
  
  static
  {
    AppMethodBeat.i(83178);
    TAG = VoiceTextFilter.class.getSimpleName();
    AppMethodBeat.o(83178);
  }
  
  public VoiceTextFilter(int paramInt, List<StickerItem> paramList)
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.FAST_STICKER);
    AppMethodBeat.i(83160);
    this.particleSystem2D = new ParticleSystem2D(VideoGlobalContext.getContext());
    this.textRenderItems = new ArrayList();
    this.fastRenderFilter = new FastRenderFilter();
    this.renderParams = new ArrayList();
    this.lastFrameTimestamp = -1L;
    this.lastWidth = -1;
    this.lastHeight = -1;
    this.zIndex = paramInt;
    if (paramInt < 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.isBackground = bool;
      this.stickerItems = paramList;
      initParticleItems(paramList);
      AppMethodBeat.o(83160);
      return;
    }
  }
  
  private void buildRenderParams(ParticleItem paramParticleItem)
  {
    AppMethodBeat.i(83170);
    int i;
    Particle localParticle;
    RenderParam localRenderParam;
    float f2;
    float f1;
    label110:
    int k;
    if (paramParticleItem.particles != null)
    {
      Particle[] arrayOfParticle = paramParticleItem.particles;
      int m = arrayOfParticle.length;
      i = 0;
      if (i < m)
      {
        localParticle = arrayOfParticle[i];
        if ((localParticle.texture > 0) && (localParticle.alive))
        {
          localRenderParam = new RenderParam();
          localRenderParam.texture = localParticle.texture;
          f2 = 0.0F;
          switch (paramParticleItem.emissionMode)
          {
          default: 
            f1 = 0.0F;
            k = 0;
            if (paramParticleItem.stickerItem.anchorPoint != null) {
              k = paramParticleItem.stickerItem.anchorPoint[0];
            }
            break;
          }
        }
      }
    }
    for (int j = paramParticleItem.stickerItem.anchorPoint[1];; j = 0)
    {
      f2 -= k;
      f1 -= j;
      float f3 = f2 + paramParticleItem.stickerItem.width * paramParticleItem.screenRatioScale;
      float f4 = paramParticleItem.stickerItem.height * paramParticleItem.screenRatioScale + f1;
      localRenderParam.texCords = GlUtil.ORIGIN_TEX_COORDS_TRIANGLES;
      localRenderParam.texScale = localParticle.scale;
      localRenderParam.texAnchor[0] = ((f2 + f3) / 2.0F - this.width / 2);
      localRenderParam.texAnchor[1] = ((f4 + f1) / 2.0F - this.height / 2);
      localRenderParam.texRotate[2] = localParticle.rotate;
      localRenderParam.position = AlgoUtils.calPositionsTriangles(f2, f4, f3, f1, this.width, this.height);
      this.renderParams.add(localRenderParam);
      i += 1;
      break;
      f2 = localParticle.startX + localParticle.positionX * paramParticleItem.screenRatioScale;
      f1 = localParticle.startY + localParticle.positionY * paramParticleItem.screenRatioScale;
      break label110;
      f2 = paramParticleItem.emitterX + localParticle.positionX * paramParticleItem.screenRatioScale;
      f1 = paramParticleItem.emitterY + localParticle.positionY * paramParticleItem.screenRatioScale;
      break label110;
      f2 = localParticle.positionX * paramParticleItem.screenRatioScale;
      f1 = localParticle.positionY * paramParticleItem.screenRatioScale;
      break label110;
      AppMethodBeat.o(83170);
      return;
    }
  }
  
  private void initParticleItems(List<StickerItem> paramList)
  {
    AppMethodBeat.i(83161);
    if (paramList != null)
    {
      this.particleItems = new ParticleItem[paramList.size()];
      int i = 0;
      while (i < paramList.size())
      {
        StickerItem localStickerItem = (StickerItem)paramList.get(i);
        if (localStickerItem.wmGroupCopies != null)
        {
          localObject = localStickerItem.wmGroupCopies.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((WMGroup)((Iterator)localObject).next()).init();
          }
        }
        Object localObject = new ParticleItem(localStickerItem);
        ((ParticleItem)localObject).triggerCtrlItem = new TriggerCtrlItem(localStickerItem);
        ((ParticleItem)localObject).particles = new Particle[localStickerItem.transition.particleCountMax];
        ((ParticleItem)localObject).maxRepeatCount = localStickerItem.transition.repeatCount;
        ((ParticleItem)localObject).emissionMode = localStickerItem.transition.emissionMode;
        ((ParticleItem)localObject).particleAlwaysUpdate = localStickerItem.transition.particleAlwaysUpdate;
        ((ParticleItem)localObject).clearMode = localStickerItem.transition.clearMode;
        int j = 0;
        while (j < ((ParticleItem)localObject).particles.length)
        {
          ((ParticleItem)localObject).particles[j] = new Particle();
          j += 1;
        }
        this.particleItems[i] = localObject;
        i += 1;
      }
      this.particleSystem2D.createParticles(paramList);
    }
    AppMethodBeat.o(83161);
  }
  
  private void recycleUnusedWMGroups()
  {
    AppMethodBeat.i(83167);
    ParticleItem[] arrayOfParticleItem = this.particleItems;
    int k = arrayOfParticleItem.length;
    int i = 0;
    while (i < k)
    {
      ParticleItem localParticleItem = arrayOfParticleItem[i];
      if (localParticleItem.particles != null)
      {
        HashSet localHashSet = new HashSet();
        Particle[] arrayOfParticle = localParticleItem.particles;
        int m = arrayOfParticle.length;
        int j = 0;
        while (j < m)
        {
          Particle localParticle = arrayOfParticle[j];
          if (localParticle.alive) {
            localHashSet.add(Integer.valueOf(localParticle.wmGroupId));
          }
          j += 1;
        }
        j = 0;
        while (j < localParticleItem.stickerItem.wmGroupCopies.size())
        {
          if ((!localHashSet.contains(Integer.valueOf(j))) && (!((WMGroup)localParticleItem.stickerItem.wmGroupCopies.get(j)).isLock()) && ((j != localParticleItem.curWMGroupId) || ((j == localParticleItem.curWMGroupId) && (localParticleItem.takenByParticle)))) {
            localParticleItem.recycleWMGroup(j);
          }
          j += 1;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(83167);
  }
  
  private void reset(int paramInt)
  {
    AppMethodBeat.i(83165);
    this.particleSystem2D.clearParticles(paramInt);
    if ((this.particleItems != null) && (paramInt < this.particleItems.length)) {
      this.particleItems[paramInt].reset();
    }
    AppMethodBeat.o(83165);
  }
  
  private void resetAll()
  {
    AppMethodBeat.i(83164);
    this.particleSystem2D.reset();
    int i = 0;
    while (i < this.particleItems.length)
    {
      this.particleItems[i].reset();
      i += 1;
    }
    AppMethodBeat.o(83164);
  }
  
  private void updateCurEmitterPos(List<PointF> paramList1, List<PointF> paramList2)
  {
    AppMethodBeat.i(83168);
    ParticleItem[] arrayOfParticleItem = this.particleItems;
    int k = arrayOfParticleItem.length;
    int i = 0;
    if (i < k)
    {
      ParticleItem localParticleItem = arrayOfParticleItem[i];
      StickerItem localStickerItem = localParticleItem.stickerItem;
      if (localStickerItem != null) {}
      switch (localStickerItem.type)
      {
      case 3: 
      default: 
      case 1: 
        for (;;)
        {
          i += 1;
          break;
          int m;
          if (this.width / this.height >= 0.75D)
          {
            int n = (int)(this.width / 0.75D);
            j = (int)(n * localStickerItem.position[1]);
            m = (int)(this.width * localStickerItem.position[0]);
            n = (n - this.height) / 2;
            localParticleItem.emitterX = m;
            localParticleItem.emitterY = (j - n);
            localParticleItem.screenRatioScale = (this.width * 1.0F / 720.0F);
          }
          else
          {
            j = (int)(this.height * 0.75D);
            m = (int)(this.height * localStickerItem.position[1]);
            localParticleItem.emitterX = ((int)(j * localStickerItem.position[0]) - (j - this.width) / 2);
            localParticleItem.emitterY = m;
            localParticleItem.screenRatioScale = (this.height * 1.0F / 960.0F);
          }
        }
      }
      Object localObject;
      label290:
      PointF localPointF;
      if (VideoMaterialUtil.isGestureItem(localStickerItem))
      {
        localObject = paramList2;
        if ((localObject == null) || (((List)localObject).isEmpty())) {
          break label449;
        }
        localPointF = (PointF)((List)localObject).get(localStickerItem.alignFacePoints[0]);
        if (localStickerItem.alignFacePoints.length != 1) {
          break label451;
        }
      }
      label449:
      label451:
      for (int j = localStickerItem.alignFacePoints[0];; j = localStickerItem.alignFacePoints[1])
      {
        localObject = (PointF)((List)localObject).get(j);
        localObject = new PointF((localPointF.x + ((PointF)localObject).x) / 2.0F, (localPointF.y + ((PointF)localObject).y) / 2.0F);
        ((PointF)localObject).x /= this.faceDetScale;
        ((PointF)localObject).y /= this.faceDetScale;
        localParticleItem.emitterX = ((PointF)localObject).x;
        localParticleItem.emitterY = ((PointF)localObject).y;
        break;
        localObject = paramList1;
        break label290;
        break;
      }
    }
    AppMethodBeat.o(83168);
  }
  
  private void updateParticleItemTrigger(PTDetectInfo paramPTDetectInfo)
  {
    AppMethodBeat.i(83175);
    if (this.particleItems != null)
    {
      ParticleItem[] arrayOfParticleItem = this.particleItems;
      int j = arrayOfParticleItem.length;
      int i = 0;
      if (i < j)
      {
        ParticleItem localParticleItem = arrayOfParticleItem[i];
        TRIGGERED_STATUS localTRIGGERED_STATUS = localParticleItem.triggerCtrlItem.getTriggeredStatus(paramPTDetectInfo);
        if ((localTRIGGERED_STATUS == TRIGGERED_STATUS.FIRST_TRIGGERED) || (localTRIGGERED_STATUS == TRIGGERED_STATUS.TRIGGERED)) {}
        for (boolean bool = true;; bool = false)
        {
          localParticleItem.triggered = bool;
          i += 1;
          break;
        }
      }
    }
    AppMethodBeat.o(83175);
  }
  
  private void updateParticleState(ParticleItem paramParticleItem, int paramInt, long paramLong)
  {
    AppMethodBeat.i(83169);
    if ((paramParticleItem.particleReachMax) && (paramParticleItem.clearMode == VideoMaterialUtil.PARTICLE_CLEAR_MODE.CLEAR_ALL.value) && (paramParticleItem.lastFrameParticleReachMax)) {
      paramParticleItem.canUpdateTexture = true;
    }
    Object localObject1;
    Object localObject2;
    int i;
    if ((paramParticleItem.canUpdateTexture) || ((paramParticleItem.clearMode == VideoMaterialUtil.PARTICLE_CLEAR_MODE.CLEAR_ALL.value) && (paramParticleItem.lastFrameParticleReachMax)))
    {
      if (paramParticleItem.lockedWMGroups.isEmpty()) {
        break label371;
      }
      localObject1 = new ArrayList();
      localObject2 = paramParticleItem.lockedWMGroups.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (WMGroup)((Iterator)localObject2).next();
        if (((WMGroup)localObject3).isAsyncDrawFinished())
        {
          ((WMGroup)localObject3).updateTexture(paramLong, true, false, true);
          ((WMGroup)localObject3).unlock();
          ((List)localObject1).add(localObject3);
          paramParticleItem.useWMGroup(((WMGroup)localObject3).id);
          paramParticleItem.curTexture = ((WMGroup)localObject3).getCurTexture();
          paramParticleItem.curWMGroupId = ((WMGroup)localObject3).id;
          paramParticleItem.curRepeatCount = 0;
          paramParticleItem.canUpdateTexture = false;
          paramParticleItem.takenByParticle = false;
          if ((paramParticleItem.clearMode == VideoMaterialUtil.PARTICLE_CLEAR_MODE.CLEAR_ALL.value) && (paramParticleItem.lastFrameParticleReachMax))
          {
            this.particleSystem2D.clearParticles(paramInt);
            paramParticleItem.resetWMGroup();
            paramParticleItem.useWMGroup(((WMGroup)localObject3).id);
            localObject3 = paramParticleItem.particles;
            int j = localObject3.length;
            i = 0;
            while (i < j)
            {
              localObject3[i].alive = false;
              i += 1;
            }
            this.particleSystem2D.advance(this.particleItems, this.frameInterval);
            paramParticleItem.lastFrameParticleReachMax = false;
          }
        }
      }
      paramParticleItem.lockedWMGroups.removeAll((Collection)localObject1);
    }
    while (paramParticleItem.particleAlwaysUpdate)
    {
      localObject1 = paramParticleItem.getActiveWMGroups().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WMGroup)((Iterator)localObject1).next();
        if (((WMGroup)localObject2).updateTexture(paramLong, true, false, true)) {
          ((WMGroup)localObject2).unlock();
        }
      }
      label371:
      localObject1 = paramParticleItem.getAvailableWMGroup();
      if (localObject1 != null)
      {
        if (!((WMGroup)localObject1).updateTexture(paramLong, true, false, true)) {
          break label523;
        }
        ((WMGroup)localObject1).unlock();
        paramParticleItem.useWMGroup(((WMGroup)localObject1).id);
        paramParticleItem.curTexture = ((WMGroup)localObject1).getCurTexture();
        paramParticleItem.curWMGroupId = ((WMGroup)localObject1).id;
        paramParticleItem.curRepeatCount = 0;
        paramParticleItem.canUpdateTexture = false;
        paramParticleItem.takenByParticle = false;
      }
      while ((paramParticleItem.clearMode == VideoMaterialUtil.PARTICLE_CLEAR_MODE.CLEAR_ALL.value) && (paramParticleItem.lastFrameParticleReachMax) && (!paramParticleItem.takenByParticle))
      {
        this.particleSystem2D.clearParticles(paramInt);
        paramParticleItem.resetWMGroup();
        paramParticleItem.useWMGroup(paramParticleItem.curWMGroupId);
        localObject1 = paramParticleItem.particles;
        i = localObject1.length;
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1[paramInt].alive = false;
          paramInt += 1;
        }
        label523:
        if (!((WMGroup)localObject1).isLock())
        {
          paramParticleItem.recycleWMGroup(((WMGroup)localObject1).id);
        }
        else
        {
          paramParticleItem.useWMGroup(((WMGroup)localObject1).id);
          paramParticleItem.lockedWMGroups.add(localObject1);
        }
      }
      continue;
      this.particleSystem2D.advance(this.particleItems, this.frameInterval);
      paramParticleItem.lastFrameParticleReachMax = false;
    }
    paramParticleItem = paramParticleItem.getActiveWMGroups().iterator();
    while (paramParticleItem.hasNext()) {
      ((WMGroup)paramParticleItem.next()).updateTexture(paramLong, false, true, true);
    }
    AppMethodBeat.o(83169);
  }
  
  private void updateParticleStateAndBuildRenderParams(long paramLong)
  {
    AppMethodBeat.i(83171);
    this.renderParams.clear();
    int i = 0;
    if (i < this.particleItems.length)
    {
      ParticleItem localParticleItem = this.particleItems[i];
      if (((!this.isBackground) || (localParticleItem.stickerItem.zIndex < 0)) && ((this.isBackground) || (localParticleItem.stickerItem.zIndex >= 0)))
      {
        if ((!localParticleItem.triggered) || (localParticleItem.stickerItem.wmGroupCopies == null)) {
          break label142;
        }
        updateParticleState(localParticleItem, i, paramLong);
        buildRenderParams(localParticleItem);
      }
      for (;;)
      {
        if ((localParticleItem.clearMode == VideoMaterialUtil.PARTICLE_CLEAR_MODE.CLEAR_ALL.value) && (!localParticleItem.lastFrameParticleReachMax)) {
          localParticleItem.lastFrameParticleReachMax = localParticleItem.particleReachMax;
        }
        i += 1;
        break;
        label142:
        reset(i);
      }
    }
    AppMethodBeat.o(83171);
  }
  
  private void updateParticles(List<PointF> paramList1, List<PointF> paramList2, long paramLong)
  {
    AppMethodBeat.i(83172);
    if (this.particleItems != null)
    {
      updateCurEmitterPos(paramList1, paramList2);
      updateParticleStateAndBuildRenderParams(paramLong);
    }
    AppMethodBeat.o(83172);
  }
  
  public void ApplyGLSLFilter()
  {
    AppMethodBeat.i(83162);
    super.ApplyGLSLFilter();
    this.fastRenderFilter.applyGLSLFilter();
    AppMethodBeat.o(83162);
  }
  
  public void clearGLSLSelf()
  {
    AppMethodBeat.i(83177);
    super.clearGLSLSelf();
    Object localObject = this.textRenderItems.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((TextRenderItem)((Iterator)localObject).next()).clear();
    }
    int i = 0;
    while (i < this.stickerItems.size())
    {
      localObject = (StickerItem)this.stickerItems.get(i);
      if (((StickerItem)localObject).wmGroupCopies != null)
      {
        localObject = ((StickerItem)localObject).wmGroupCopies.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((WMGroup)((Iterator)localObject).next()).clear();
        }
      }
      i += 1;
    }
    this.fastRenderFilter.clearGLSLSelf();
    this.particleSystem2D.release();
    LogicDataManager.getInstance().clearVoiceTexts();
    AppMethodBeat.o(83177);
  }
  
  public int getZIndex()
  {
    return this.zIndex;
  }
  
  public void initParams() {}
  
  public boolean isBackground()
  {
    return this.isBackground;
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(83173);
    updateAndRender(null, System.currentTimeMillis(), this.isBackground);
    AppMethodBeat.o(83173);
    return true;
  }
  
  public void setTriggerWords(String paramString)
  {
    AppMethodBeat.i(83176);
    if (this.particleItems != null)
    {
      ParticleItem[] arrayOfParticleItem = this.particleItems;
      int j = arrayOfParticleItem.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = arrayOfParticleItem[i];
        TriggerCtrlItem localTriggerCtrlItem = ((ParticleItem)localObject).triggerCtrlItem;
        if (TextUtils.isEmpty(((ParticleItem)localObject).stickerItem.triggerWords)) {}
        for (localObject = paramString;; localObject = ((ParticleItem)localObject).stickerItem.triggerWords)
        {
          localTriggerCtrlItem.setTriggerWords((String)localObject);
          i += 1;
          break;
        }
      }
    }
    AppMethodBeat.o(83176);
  }
  
  public void updateAndRender(h paramh, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(83174);
    if (!this.renderParams.isEmpty())
    {
      BenchUtil.benchStart(TAG + " fastRenderFilter.render");
      this.fastRenderFilter.render(this.renderParams, paramh, true);
      BenchUtil.benchEnd(TAG + " fastRenderFilter.render");
    }
    AppMethodBeat.o(83174);
  }
  
  public void updatePreview(PTDetectInfo paramPTDetectInfo)
  {
    AppMethodBeat.i(83166);
    BenchUtil.benchStart(TAG + " updatePreview");
    if (this.lastFrameTimestamp != -1L) {
      this.frameInterval = ((int)(paramPTDetectInfo.timestamp - this.lastFrameTimestamp));
    }
    this.lastFrameTimestamp = paramPTDetectInfo.timestamp;
    BenchUtil.benchStart(TAG + " updateParticleItemTrigger");
    updateParticleItemTrigger(paramPTDetectInfo);
    BenchUtil.benchEnd(TAG + " updateParticleItemTrigger");
    BenchUtil.benchStart(TAG + " updateParticles");
    updateParticles(paramPTDetectInfo.facePoints, paramPTDetectInfo.handPoints, paramPTDetectInfo.timestamp);
    BenchUtil.benchEnd(TAG + " updateParticles");
    BenchUtil.benchStart(TAG + " particleSystem2D.advance");
    this.particleSystem2D.advance(this.particleItems, this.frameInterval);
    BenchUtil.benchEnd(TAG + " particleSystem2D.advance");
    BenchUtil.benchStart(TAG + " recycleUnusedWMGroups");
    recycleUnusedWMGroups();
    BenchUtil.benchEnd(TAG + " recycleUnusedWMGroups");
    BenchUtil.benchEnd(TAG + " updatePreview");
    AppMethodBeat.o(83166);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    AppMethodBeat.i(83163);
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.fastRenderFilter.updateVideoSize(paramInt1, paramInt2);
    this.faceDetScale = ((float)paramDouble);
    Iterator localIterator = this.textRenderItems.iterator();
    while (localIterator.hasNext()) {
      ((TextRenderItem)localIterator.next()).updateVideoSize(paramInt1, paramInt2);
    }
    if ((this.lastWidth > 0) && (this.lastHeight > 0) && ((paramInt1 != this.lastWidth) || (paramInt2 != this.lastHeight))) {
      resetAll();
    }
    this.lastWidth = paramInt1;
    this.lastHeight = paramInt2;
    AppMethodBeat.o(83163);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.filter.VoiceTextFilter
 * JD-Core Version:    0.7.0.1
 */