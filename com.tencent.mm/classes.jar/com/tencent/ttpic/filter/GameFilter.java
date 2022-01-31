package com.tencent.ttpic.filter;

import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.ttpic.facedetect.FaceDetector;
import com.tencent.ttpic.facedetect.FaceDetectorManager;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.gameplaysdk.model.GameParams;
import com.tencent.ttpic.gameplaysdk.model.NodeParameter;
import com.tencent.ttpic.gameplaysdk.model.StickerItem3D;
import com.tencent.ttpic.gameplaysdk.util.LogUtil;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.HandActionCounter;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GameFilter
{
  private static final String TAG = GameFilter.class.getSimpleName();
  private String dataPath;
  private String gameName;
  private GameParams gameParams;
  private int height;
  private List<StickerItem3D> itemList3D;
  private int[] m2DTexture = new int[1];
  private int mDepthBuffer;
  private BaseFilter mFlipFilter = new BaseFilter(GLSLRender.bcE);
  private h mFlipFrame = new h();
  private int mFramebuffer;
  private h mInputFrame = new h();
  private int maxFaceCount;
  private int orderMode;
  private int width;
  
  public GameFilter(List<StickerItem3D> paramList, int paramInt1, int paramInt2)
  {
    this.itemList3D = paramList;
    this.orderMode = paramInt1;
    this.maxFaceCount = paramInt2;
  }
  
  private void initFrameBuffer(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[1];
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
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    GlUtil.checkGlError("glGenFramebuffers");
    this.mFramebuffer = arrayOfInt[0];
    GLES20.glBindFramebuffer(36160, this.mFramebuffer);
    GlUtil.checkGlError("glBindTexture " + this.m2DTexture);
    GLES20.glGenRenderbuffers(1, arrayOfInt, 0);
    GlUtil.checkGlError("glGenRenderbuffers");
    this.mDepthBuffer = arrayOfInt[0];
    GLES20.glBindRenderbuffer(36161, this.mDepthBuffer);
    GlUtil.checkGlError("glBindRenderbuffer ");
    GLES20.glRenderbufferStorage(36161, 33189, paramInt1, paramInt2);
    GlUtil.checkGlError("glRenderbufferStorage");
    GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.mDepthBuffer);
    GlUtil.checkGlError("glFramebufferRenderbuffer");
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.m2DTexture[0], 0);
    GlUtil.checkGlError("glFramebufferTexture2D");
    paramInt1 = GLES20.glCheckFramebufferStatus(36160);
    if (paramInt1 != 36053) {
      throw new RuntimeException("Framebuffer not complete, status=" + paramInt1);
    }
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glActiveTexture(33984);
  }
  
  public void applyGLSLFilter()
  {
    this.mFlipFilter.ApplyGLSLFilter();
  }
  
  public void clear()
  {
    this.mFlipFilter.ClearGLSL();
    this.mInputFrame.clear();
    this.mFlipFrame.clear();
  }
  
  public NodeParameter[] getNodeParameters()
  {
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
      if (localArrayList.isEmpty()) {
        return null;
      }
      localObject = new NodeParameter[localArrayList.size()];
      int i = 0;
      while (i < localArrayList.size())
      {
        localObject[i] = ((NodeParameter)localArrayList.get(i));
        i += 1;
      }
      return localObject;
    }
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
    this.gameParams = paramGameParams;
    this.dataPath = (paramString + File.separator);
  }
  
  protected void updateActionTriggered(Map<Integer, FaceActionCounter> paramMap, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet)
  {
    long l;
    StickerItem3D localStickerItem3D;
    boolean bool3;
    Object localObject;
    label113:
    int i;
    label145:
    boolean bool1;
    label185:
    boolean bool2;
    if (this.itemList3D != null)
    {
      l = System.currentTimeMillis();
      Iterator localIterator = this.itemList3D.iterator();
      if (localIterator.hasNext())
      {
        localStickerItem3D = (StickerItem3D)localIterator.next();
        if (localStickerItem3D.activateTriggerTotalCount != 0)
        {
          if ((localStickerItem3D.preTriggerType != VideoMaterialUtil.TRIGGER_TYPE.ALWAYS.value) && ((!VideoMaterialUtil.isFaceTriggerType(localStickerItem3D.preTriggerType)) || (!paramSet.contains(Integer.valueOf(localStickerItem3D.preTriggerType))))) {
            break label617;
          }
          bool3 = VideoMaterialUtil.isFaceTriggerType(localStickerItem3D.countTriggerType);
          if (bool3)
          {
            localObject = paramMap;
            if (localObject == null) {
              break label617;
            }
            if (!bool3) {
              break label262;
            }
            i = ((FaceActionCounter)paramMap.get(Integer.valueOf(localStickerItem3D.countTriggerType))).count;
            if (i % localStickerItem3D.activateTriggerTotalCount != localStickerItem3D.activateTriggerCount) {
              break label617;
            }
            if ((localStickerItem3D.playCount != 0) && (localStickerItem3D.curPlayCount >= localStickerItem3D.playCount)) {
              break label287;
            }
            bool1 = true;
            if (localStickerItem3D.curPlayCount >= localStickerItem3D.playCount) {
              break label293;
            }
            bool2 = bool1;
            if (bool3)
            {
              FaceDetectorManager.getInstance().getCurrentFaceDetector().lockActionCounter();
              bool2 = bool1;
            }
          }
        }
      }
    }
    for (;;)
    {
      label220:
      if (bool2) {
        if (!localStickerItem3D.triggered) {
          localStickerItem3D.frameStartTime = l;
        }
      }
      for (localStickerItem3D.triggered = true;; localStickerItem3D.triggered = false) {
        label262:
        label287:
        label293:
        do
        {
          localStickerItem3D.calFrameIndex(l);
          break;
          localObject = paramMap1;
          break label113;
          i = ((HandActionCounter)paramMap1.get(Integer.valueOf(localStickerItem3D.countTriggerType))).count;
          break label145;
          bool1 = false;
          break label185;
          bool2 = bool1;
          if (localStickerItem3D.playCount <= 0) {
            break label220;
          }
          bool2 = bool1;
          if (!bool3) {
            break label220;
          }
          FaceDetectorManager.getInstance().getCurrentFaceDetector().clearActionCounter();
          bool2 = bool1;
          break label220;
          if (!VideoMaterialUtil.isFaceTriggerType(localStickerItem3D.triggerType)) {
            break label617;
          }
          bool2 = paramSet.contains(Integer.valueOf(localStickerItem3D.triggerType));
          break label220;
        } while ((!localStickerItem3D.alwaysTriggered) && (localStickerItem3D.curPlayCount < localStickerItem3D.playCount));
      }
      if (this.itemList3D != null)
      {
        paramMap1 = new ArrayList();
        paramMap = this.itemList3D.iterator();
        while (paramMap.hasNext())
        {
          paramSet = (StickerItem3D)paramMap.next();
          if (paramSet.triggered) {
            paramMap1.add(paramSet);
          }
          LogUtil.e(TAG, String.format("item.id  = %s, item.triggered = " + paramSet.triggered, new Object[] { paramSet.id }));
        }
        paramSet = new StickerItem3D[paramMap1.size()];
        i = 0;
        if (i < paramMap1.size())
        {
          paramSet[i] = new StickerItem3D();
          paramSet[i].id = ((StickerItem3D)paramMap1.get(i)).id.split(":")[0];
          localObject = paramSet[i];
          if (((StickerItem3D)paramMap1.get(i)).curFrameImagePath == null) {}
          for (paramMap = "";; paramMap = ((StickerItem3D)paramMap1.get(i)).curFrameImagePath)
          {
            ((StickerItem3D)localObject).curFrameImagePath = paramMap;
            i += 1;
            break;
          }
        }
      }
      return;
      label617:
      bool2 = false;
    }
  }
  
  public h updateAndRender(h paramh, List<FaceStatus> paramList, Map<Integer, FaceActionCounter> paramMap, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, int paramInt)
  {
    if ((paramList != null) && (paramList.size() > 0) && (((FaceStatus)paramList.get(0)).denseFaceModel != null) && (((FaceStatus)paramList.get(0)).denseFaceModel[0] != 0.0F) && (((FaceStatus)paramList.get(0)).transform[15] < 1.0F)) {}
    return paramh;
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.filter.GameFilter
 * JD-Core Version:    0.7.0.1
 */