package com.tencent.ttpic.filter;

import android.content.Context;
import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.PTDetectInfo.Builder;
import com.tencent.ttpic.PTFaceAttr;
import com.tencent.ttpic.PTFaceAttr.PTExpression;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.gameplaysdk.GamePlaySDK;
import com.tencent.ttpic.gameplaysdk.model.GameParams;
import com.tencent.ttpic.gameplaysdk.model.NodeParameter;
import com.tencent.ttpic.gameplaysdk.model.StickerItem3D;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.HandActionCounter;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.youtu.GestureDetector;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GameFilter
{
  private static final String TAG;
  private String dataPath;
  private String gameName;
  private GameParams gameParams;
  private int height;
  private boolean isFirstFrame;
  private List<StickerItem3D> itemList3D;
  private int[] m2DTexture;
  private int mDepthBuffer;
  private BaseFilter mFlipFilter;
  private h mFlipFrame;
  private int mFramebuffer;
  private int maxFaceCount;
  private int orderMode;
  private int width;
  
  static
  {
    AppMethodBeat.i(82569);
    TAG = GameFilter.class.getSimpleName();
    AppMethodBeat.o(82569);
  }
  
  public GameFilter(List<StickerItem3D> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82557);
    this.mFlipFilter = new BaseFilter(GLSLRender.btg);
    this.mFlipFrame = new h();
    this.isFirstFrame = true;
    this.m2DTexture = new int[1];
    this.itemList3D = paramList;
    this.orderMode = paramInt1;
    this.maxFaceCount = paramInt2;
    AppMethodBeat.o(82557);
  }
  
  private void initFrameBuffer(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82568);
    Object localObject = new int[1];
    GLES20.glGenTextures(this.m2DTexture.length, this.m2DTexture, 0);
    GlUtil.checkGlError("glGenTextures");
    GLES20.glActiveTexture(33987);
    GLES20.glBindTexture(3553, this.m2DTexture[0]);
    GlUtil.checkGlError("glBindTexture");
    GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
    GLES20.glTexParameterf(3553, 10241, 9728.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GlUtil.checkGlError("glTexParameter");
    GLES20.glGenFramebuffers(1, (int[])localObject, 0);
    GlUtil.checkGlError("glGenFramebuffers");
    this.mFramebuffer = localObject[0];
    GLES20.glBindFramebuffer(36160, this.mFramebuffer);
    GlUtil.checkGlError("glBindTexture " + this.m2DTexture);
    GLES20.glGenRenderbuffers(1, (int[])localObject, 0);
    GlUtil.checkGlError("glGenRenderbuffers");
    this.mDepthBuffer = localObject[0];
    GLES20.glBindRenderbuffer(36161, this.mDepthBuffer);
    GlUtil.checkGlError("glBindRenderbuffer ");
    GLES20.glRenderbufferStorage(36161, 33189, paramInt1, paramInt2);
    GlUtil.checkGlError("glRenderbufferStorage");
    GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.mDepthBuffer);
    GlUtil.checkGlError("glFramebufferRenderbuffer");
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.m2DTexture[0], 0);
    GlUtil.checkGlError("glFramebufferTexture2D");
    paramInt1 = GLES20.glCheckFramebufferStatus(36160);
    if (paramInt1 != 36053)
    {
      localObject = new RuntimeException("Framebuffer not complete, status=".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(82568);
      throw ((Throwable)localObject);
    }
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glActiveTexture(33984);
    AppMethodBeat.o(82568);
  }
  
  public void applyGLSLFilter()
  {
    AppMethodBeat.i(82559);
    this.mFlipFilter.ApplyGLSLFilter();
    GamePlaySDK.getInstance().init(VideoGlobalContext.getContext(), VideoGlobalContext.getContext().getAssets(), null, null, this.width, this.height);
    GamePlaySDK.getInstance().startGame(this.dataPath, this.gameParams, getNodeParameters());
    AppMethodBeat.o(82559);
  }
  
  public void clear()
  {
    AppMethodBeat.i(82567);
    this.mFlipFilter.ClearGLSL();
    this.mFlipFrame.clear();
    GamePlaySDK.getInstance().stopGame();
    AppMethodBeat.o(82567);
  }
  
  public int getGameRefTextureHeight()
  {
    AppMethodBeat.i(82566);
    int i = GamePlaySDK.getInstance().getGameRefTextureHeight();
    AppMethodBeat.o(82566);
    return i;
  }
  
  public int getGameRefTextureID()
  {
    AppMethodBeat.i(82564);
    int i = GamePlaySDK.getInstance().getGameRefTextureID();
    AppMethodBeat.o(82564);
    return i;
  }
  
  public int getGameRefTextureWidth()
  {
    AppMethodBeat.i(82565);
    int i = GamePlaySDK.getInstance().getGameRefTextureWidth();
    AppMethodBeat.o(82565);
    return i;
  }
  
  public NodeParameter[] getNodeParameters()
  {
    AppMethodBeat.i(82560);
    if (this.itemList3D != null)
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject = this.itemList3D.iterator();
      while (((Iterator)localObject).hasNext())
      {
        StickerItem3D localStickerItem3D = (StickerItem3D)((Iterator)localObject).next();
        if (localStickerItem3D.nodeParameter != null) {
          localArrayList.add(localStickerItem3D.nodeParameter);
        }
      }
      if (localArrayList.isEmpty())
      {
        AppMethodBeat.o(82560);
        return null;
      }
      localObject = new NodeParameter[localArrayList.size()];
      int i = 0;
      while (i < localArrayList.size())
      {
        localObject[i] = ((NodeParameter)localArrayList.get(i));
        i += 1;
      }
      AppMethodBeat.o(82560);
      return localObject;
    }
    AppMethodBeat.o(82560);
    return null;
  }
  
  public int getOrderMode()
  {
    return this.orderMode;
  }
  
  public void init() {}
  
  public void setGameName(String paramString)
  {
    this.gameName = paramString;
  }
  
  public void setGameParams(GameParams paramGameParams, String paramString)
  {
    AppMethodBeat.i(82558);
    this.gameParams = paramGameParams;
    this.dataPath = (paramString + File.separator);
    AppMethodBeat.o(82558);
  }
  
  protected void updateActionTriggered(PTDetectInfo paramPTDetectInfo)
  {
    AppMethodBeat.i(82562);
    Object localObject2 = paramPTDetectInfo.faceActionCounter;
    Map localMap = paramPTDetectInfo.handActionCounter;
    Set localSet = paramPTDetectInfo.triggeredExpression;
    label119:
    Object localObject1;
    label138:
    int i;
    if (this.itemList3D != null)
    {
      long l = System.currentTimeMillis();
      Iterator localIterator = this.itemList3D.iterator();
      if (localIterator.hasNext())
      {
        StickerItem3D localStickerItem3D = (StickerItem3D)localIterator.next();
        boolean bool3;
        label170:
        boolean bool2;
        label209:
        boolean bool1;
        if (localStickerItem3D.activateTriggerTotalCount != 0) {
          if (localStickerItem3D.preTriggerType != PTFaceAttr.PTExpression.ALWAYS.value)
          {
            if (VideoMaterialUtil.isFaceTriggerType(localStickerItem3D.preTriggerType)) {
              if (!localSet.contains(Integer.valueOf(localStickerItem3D.preTriggerType))) {
                break label286;
              }
            }
          }
          else
          {
            bool3 = VideoMaterialUtil.isFaceTriggerType(localStickerItem3D.countTriggerType);
            if (!bool3) {
              break label292;
            }
            localObject1 = localObject2;
            if (localObject1 == null) {
              break label286;
            }
            if (!bool3) {
              break label299;
            }
            i = ((FaceActionCounter)((Map)localObject2).get(Integer.valueOf(localStickerItem3D.countTriggerType))).count;
            if (i % localStickerItem3D.activateTriggerTotalCount != localStickerItem3D.activateTriggerCount) {
              break label286;
            }
            if ((localStickerItem3D.playCount != 0) && (localStickerItem3D.curPlayCount >= localStickerItem3D.playCount)) {
              break label324;
            }
            bool2 = true;
            if (localStickerItem3D.curPlayCount >= localStickerItem3D.playCount) {
              break label343;
            }
            if (!bool3) {
              break label330;
            }
            paramPTDetectInfo.faceDetector.lockActionCounter();
            bool1 = bool2;
            label238:
            if (!bool1) {
              break label434;
            }
            if (!localStickerItem3D.triggered) {
              localStickerItem3D.frameStartTime = l;
            }
          }
        }
        label286:
        label292:
        label299:
        label434:
        for (localStickerItem3D.triggered = true;; localStickerItem3D.triggered = false) {
          label324:
          label330:
          label343:
          do
          {
            localStickerItem3D.calFrameIndex(l);
            break;
            if (GestureDetector.getInstance().isGestureTriggered(localStickerItem3D.preTriggerType)) {
              break label119;
            }
            bool1 = false;
            break label238;
            localObject1 = localMap;
            break label138;
            i = ((HandActionCounter)localMap.get(Integer.valueOf(localStickerItem3D.countTriggerType))).count;
            break label170;
            bool2 = false;
            break label209;
            GestureDetector.getInstance().lockActionCounter();
            bool1 = bool2;
            break label238;
            bool1 = bool2;
            if (localStickerItem3D.playCount <= 0) {
              break label238;
            }
            if (bool3)
            {
              paramPTDetectInfo.faceDetector.clearActionCounter();
              bool1 = bool2;
              break label238;
            }
            GestureDetector.getInstance().clearActionCounter();
            bool1 = bool2;
            break label238;
            if (VideoMaterialUtil.isFaceTriggerType(localStickerItem3D.triggerType))
            {
              bool1 = localSet.contains(Integer.valueOf(localStickerItem3D.triggerType));
              break label238;
            }
            bool1 = GestureDetector.getInstance().isGestureTriggered(localStickerItem3D.triggerType);
            break label238;
          } while ((!localStickerItem3D.alwaysTriggered) && (localStickerItem3D.curPlayCount < localStickerItem3D.playCount));
        }
      }
    }
    if (this.itemList3D != null)
    {
      localObject1 = new ArrayList();
      paramPTDetectInfo = this.itemList3D.iterator();
      while (paramPTDetectInfo.hasNext())
      {
        localObject2 = (StickerItem3D)paramPTDetectInfo.next();
        if (((StickerItem3D)localObject2).triggered) {
          ((List)localObject1).add(localObject2);
        }
        LogUtils.e(TAG, String.format("item.id  = %s, item.triggered = " + ((StickerItem3D)localObject2).triggered, new Object[] { ((StickerItem3D)localObject2).id }));
      }
      localObject2 = new StickerItem3D[((List)localObject1).size()];
      i = 0;
      if (i < ((List)localObject1).size())
      {
        localObject2[i] = new StickerItem3D();
        localObject2[i].id = ((StickerItem3D)localObject1.get(i)).id.split(":")[0];
        localMap = localObject2[i];
        if (((StickerItem3D)((List)localObject1).get(i)).curFrameImagePath == null) {}
        for (paramPTDetectInfo = "";; paramPTDetectInfo = ((StickerItem3D)((List)localObject1).get(i)).curFrameImagePath)
        {
          localMap.curFrameImagePath = paramPTDetectInfo;
          i += 1;
          break;
        }
      }
      GamePlaySDK.getInstance().updateTriggerInfo((StickerItem3D[])localObject2);
    }
    AppMethodBeat.o(82562);
  }
  
  public h updateAndRender(h paramh, PTFaceAttr paramPTFaceAttr)
  {
    AppMethodBeat.i(82561);
    List localList = paramPTFaceAttr.getFaceStatusList();
    Object localObject = paramPTFaceAttr.getFaceActionCounter();
    Map localMap = GestureDetector.getInstance().getHandActionCounter();
    Set localSet = paramPTFaceAttr.getTriggeredExpression();
    int j = paramPTFaceAttr.getRotation();
    if ((localList == null) || (localList.size() <= 0) || (((FaceStatus)localList.get(0)).denseFaceModel == null) || (((FaceStatus)localList.get(0)).denseFaceModel[0] == 0.0F) || (((FaceStatus)localList.get(0)).transform[15] < 1.0F))
    {
      AppMethodBeat.o(82561);
      return paramh;
    }
    if (GamePlaySDK.getInstance().isInited())
    {
      updateActionTriggered(new PTDetectInfo.Builder().faceActionCounter((Map)localObject).handActionCounter(localMap).triggeredExpression(localSet).faceDetector(paramPTFaceAttr.getFaceDetector()).faceDetector(paramPTFaceAttr.getFaceDetector()).build());
      if (this.itemList3D != null)
      {
        paramPTFaceAttr = this.itemList3D.iterator();
        while (paramPTFaceAttr.hasNext())
        {
          localObject = (StickerItem3D)paramPTFaceAttr.next();
          if ((((StickerItem3D)localObject).alignFacePoints != null) && (((StickerItem3D)localObject).alignFacePoints.length > 0)) {
            GamePlaySDK.getInstance().setNodeAlignedHeadPointIndex(((StickerItem3D)localObject).id, localObject.alignFacePoints[0]);
          }
        }
      }
      this.mFlipFilter.nativeSetRotationAndFlip(j, 0, 1);
      int k = Math.min(this.maxFaceCount, localList.size());
      int i = 0;
      if (i < k)
      {
        paramPTFaceAttr = (FaceStatus)localList.get(i);
        if (paramPTFaceAttr.denseFaceModel != null)
        {
          GamePlaySDK.getInstance().updateHeadData(paramPTFaceAttr.denseFaceModel, paramPTFaceAttr.transform);
          GamePlaySDK.getInstance().onDrawFrame();
          this.mFlipFilter.nativeSetRotationAndFlip(-j, 0, 1);
          if (!this.isFirstFrame)
          {
            GlUtil.setBlendMode(true);
            if ((j != 90) && (j != 270)) {
              break label412;
            }
            if (paramPTFaceAttr.transform[11] > 2.5D) {
              this.mFlipFilter.RenderProcess(GamePlaySDK.getInstance().getGameTexture(), this.height, this.width, -1, 0.0D, paramh);
            }
          }
        }
        for (;;)
        {
          GlUtil.setBlendMode(false);
          i += 1;
          break;
          label412:
          if (paramPTFaceAttr.transform[11] > 2.5D) {
            this.mFlipFilter.RenderProcess(GamePlaySDK.getInstance().getGameTexture(), this.width, this.height, -1, 0.0D, paramh);
          }
        }
      }
    }
    this.isFirstFrame = false;
    AppMethodBeat.o(82561);
    return paramh;
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(82563);
    if ((paramInt3 == 90) || (paramInt3 == 270)) {
      this.width = paramInt2;
    }
    for (this.height = paramInt1;; this.height = paramInt2)
    {
      GamePlaySDK.getInstance().onSurfaceChanged(this.width * 2, this.height * 2);
      AppMethodBeat.o(82563);
      return;
      this.width = paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.filter.GameFilter
 * JD-Core Version:    0.7.0.1
 */