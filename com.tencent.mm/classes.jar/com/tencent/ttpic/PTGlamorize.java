package com.tencent.ttpic;

import android.graphics.PointF;
import android.opengl.GLES20;
import android.util.Pair;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.config.BeautyRealConfig;
import com.tencent.ttpic.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.facedetect.FaceDetector;
import com.tencent.ttpic.filter.BeautyFaceList;
import com.tencent.ttpic.filter.BeautyParam;
import com.tencent.ttpic.filter.BeautyTransformList;
import com.tencent.ttpic.filter.ColorToneFilter;
import com.tencent.ttpic.filter.RemodelFilter;
import com.tencent.ttpic.filter.SmoothBFilters;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.util.BeautyRealUtil;
import com.tencent.ttpic.util.BenchUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PTGlamorize
{
  public static boolean ENABLE_GESTURE;
  public static final String TAG;
  private static boolean isFaceDetectInited;
  private float FACE_DETECT_IMG_WIDTH;
  private boolean isUnInitSwapCopyFilter;
  private double mAspectRatio;
  private BeautyFaceList mBeautyFaceList;
  private h mBeautyFrame2;
  private BeautyParam mBeautyParam;
  private h mBeautyTransformCopyFrame;
  private BeautyTransformList mBeautyTransformList;
  private ColorToneFilter mColorToneFilter;
  private h mColorToneFrame;
  private BaseFilter mCopyFilter;
  private boolean mEnableLongLeg;
  private boolean mEnableSlimWaist;
  private PTFaceAttr mFaceAttr;
  private double mFaceDetectScale;
  private int mFrameIndex;
  private int mHeightFrame;
  private PTFilter mPTAlphaFilter;
  private PTFilter mPTFilter;
  private PTFilter.PTLongLegFilter mPTLongLegFilter;
  PTSegmentor mPTSegmentor;
  private PTFilter.PTSlimWaistFilter mPTSlimWaistFilter;
  private PTSticker mPTSticker;
  private PTFaceDetector mPTfaceDectector;
  private RemodelFilter mRemodelFilter;
  private int mRotationDegree;
  private PTSegAttr mSegAttr;
  private SmoothBFilters mSmoothBFilters;
  private BaseFilter mSwapCopyFilter;
  private h[] mSwapFrames;
  private h mTempFrame;
  private int mWidthFrame;
  
  static
  {
    AppMethodBeat.i(80730);
    TAG = PTGlamorize.class.getSimpleName();
    ENABLE_GESTURE = true;
    isFaceDetectInited = false;
    AppMethodBeat.o(80730);
  }
  
  public PTGlamorize()
  {
    AppMethodBeat.i(80710);
    this.mSmoothBFilters = new SmoothBFilters();
    this.mBeautyTransformList = new BeautyTransformList();
    this.mColorToneFilter = new ColorToneFilter();
    this.mBeautyFaceList = new BeautyFaceList();
    this.mRemodelFilter = new RemodelFilter();
    this.mPTAlphaFilter = new PTFilter.PTAlphaFilter();
    this.mPTLongLegFilter = new PTFilter.PTLongLegFilter();
    this.mEnableLongLeg = true;
    this.mPTSlimWaistFilter = new PTFilter.PTSlimWaistFilter();
    this.mEnableSlimWaist = true;
    this.mSwapCopyFilter = new BaseFilter(GLSLRender.btg);
    this.isUnInitSwapCopyFilter = true;
    this.mCopyFilter = new BaseFilter(GLSLRender.btg);
    this.FACE_DETECT_IMG_WIDTH = 180.0F;
    this.mFaceDetectScale = 0.16666667163372D;
    this.mRotationDegree = 0;
    this.mWidthFrame = 0;
    this.mHeightFrame = 0;
    this.mAspectRatio = 0.5625D;
    this.mBeautyTransformCopyFrame = new h();
    this.mSwapFrames = new h[2];
    this.mFrameIndex = -1;
    this.mColorToneFrame = new h();
    this.mBeautyFrame2 = new h();
    this.mTempFrame = new h();
    this.mPTfaceDectector = new PTFaceDetector();
    this.mPTSegmentor = PTSegmentor.getInstance();
    AppMethodBeat.o(80710);
  }
  
  private void clearFrames()
  {
    AppMethodBeat.i(80719);
    this.mBeautyTransformCopyFrame.clear();
    h[] arrayOfh = this.mSwapFrames;
    int j = arrayOfh.length;
    int i = 0;
    while (i < j)
    {
      h localh = arrayOfh[i];
      if (localh != null) {
        localh.clear();
      }
      i += 1;
    }
    this.mColorToneFrame.clear();
    this.mBeautyFrame2.clear();
    this.mTempFrame.clear();
    AppMethodBeat.o(80719);
  }
  
  private PTFaceAttr detectFace(h paramh, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(80714);
    float f = this.FACE_DETECT_IMG_WIDTH / paramInt2;
    boolean bool1;
    PTFaceDetector localPTFaceDetector;
    if ((ENABLE_GESTURE) && (this.mPTSticker != null) && (this.mPTSticker.needDetectGesture()))
    {
      bool1 = true;
      BenchUtil.benchStart("PTFaceDetector");
      localPTFaceDetector = this.mPTfaceDectector;
      if ((!this.mEnableLongLeg) && (!this.mEnableSlimWaist)) {
        break label104;
      }
    }
    label104:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramh = localPTFaceDetector.detectFrame(paramh, null, paramInt1, true, bool1, bool2, f);
      BenchUtil.benchEnd("PTFaceDetector");
      AppMethodBeat.o(80714);
      return paramh;
      bool1 = false;
      break;
    }
  }
  
  private h renderBeautyFaceList(h paramh, PTFaceAttr paramPTFaceAttr)
  {
    AppMethodBeat.i(80715);
    h localh = paramh;
    if (this.mBeautyFaceList != null)
    {
      localh = paramh;
      if (paramPTFaceAttr != null)
      {
        localh = paramh;
        if (this.mSmoothBFilters != null)
        {
          this.mBeautyFaceList.setLightRemovePouchSkinTexture(this.mSmoothBFilters.getVarianceFrame().texture[0]);
          localh = this.mBeautyFaceList.render(paramh, paramPTFaceAttr.getAllFacePoints());
        }
      }
    }
    AppMethodBeat.o(80715);
    return localh;
  }
  
  private h renderBeautyFilter(h paramh, double paramDouble)
  {
    AppMethodBeat.i(80717);
    Object localObject = paramh;
    if (paramh.width > 0)
    {
      localObject = paramh;
      if (paramh.height > 0)
      {
        localObject = new ArrayList();
        if (this.mFaceAttr != null) {
          localObject = this.mFaceAttr.getAllFacePoints();
        }
        this.mSmoothBFilters.updateAndRender(paramh, this.mBeautyFrame2, (List)localObject, (int)(paramh.width * paramDouble), (int)(paramh.height * paramDouble), this.mRotationDegree);
        localObject = this.mBeautyFrame2;
      }
    }
    AppMethodBeat.o(80717);
    return localObject;
  }
  
  private h renderBeautyTransformList(h paramh, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr, double paramDouble, float paramFloat)
  {
    AppMethodBeat.i(80716);
    if ((this.mBeautyTransformList != null) && (paramPTFaceAttr != null))
    {
      paramh = this.mBeautyTransformList.process(paramh, paramPTFaceAttr.getAllFacePoints(), paramDouble, paramPTFaceAttr.getAllFaceAngles(), paramFloat);
      if ((paramPTSegAttr != null) && (paramPTSegAttr.getMaskFrame() != null))
      {
        h localh = paramPTSegAttr.getMaskFrame();
        this.mCopyFilter.RenderProcess(localh.texture[0], localh.width, localh.height, -1, 0.0D, this.mBeautyTransformCopyFrame);
        paramPTSegAttr.setMaskFrame(this.mBeautyTransformList.process(this.mBeautyTransformCopyFrame, paramPTFaceAttr.getAllFacePoints(), this.mFaceDetectScale, paramPTFaceAttr.getAllFaceAngles(), this.mRotationDegree));
      }
      paramh = this.mRemodelFilter.process(paramh, paramPTFaceAttr.getAllFacePoints(), paramPTFaceAttr.getAllFaceAngles(), paramDouble);
      AppMethodBeat.o(80716);
      return paramh;
    }
    AppMethodBeat.o(80716);
    return paramh;
  }
  
  private void setAtomBeautyLevel(BeautyRealConfig.TYPE paramTYPE, int paramInt)
  {
    AppMethodBeat.i(80721);
    switch (PTGlamorize.1.$SwitchMap$com$tencent$ttpic$config$BeautyRealConfig$TYPE[paramTYPE.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(80721);
      return;
      this.mSmoothBFilters.updateBlurAlpha(paramInt * 0.8F / 100.0F);
      AppMethodBeat.o(80721);
      return;
      this.mColorToneFilter.updateAlpha(paramInt / 100.0F);
      AppMethodBeat.o(80721);
      return;
      this.mBeautyFaceList.setRemovePounchAlpha(paramInt / 100.0F);
      AppMethodBeat.o(80721);
      return;
      this.mBeautyFaceList.setEyeLightenAlpha(paramInt / 100.0F);
      AppMethodBeat.o(80721);
      return;
      this.mBeautyFaceList.setToothWhitenAlpha(paramInt / 80.0F);
      AppMethodBeat.o(80721);
      return;
      this.mRemodelFilter.setParam(paramTYPE.value, paramInt);
      AppMethodBeat.o(80721);
      return;
      this.mBeautyTransformList.setBeautyParam(paramTYPE.value, BeautyRealUtil.getDistortParam(this.mBeautyParam.getDistortList(paramTYPE.value), paramInt, paramTYPE.value));
    }
  }
  
  private void updateBeautyNormalFactor(int paramInt)
  {
    AppMethodBeat.i(80713);
    float f;
    if (this.mBeautyFaceList != null)
    {
      if (paramInt > 40) {
        break label36;
      }
      f = 0.0F;
    }
    for (;;)
    {
      this.mBeautyFaceList.setNormalAlphaFactor(f);
      AppMethodBeat.o(80713);
      return;
      label36:
      if (paramInt >= 80) {
        f = 1.0F;
      } else {
        f = (paramInt - 40.0F) / 40.0F;
      }
    }
  }
  
  public void adjustFilterParam(float paramFloat)
  {
    AppMethodBeat.i(80725);
    if (this.mPTAlphaFilter != null) {
      this.mPTAlphaFilter.getFilter().setAdjustParam(1.0F - paramFloat);
    }
    AppMethodBeat.o(80725);
  }
  
  public void changeFilter(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(80724);
    if (this.mPTFilter != null)
    {
      this.mPTFilter.destroy();
      this.mPTFilter = null;
    }
    if (FilterEnum4Shaka.contains(paramInt1))
    {
      this.mPTFilter = new PTFilter();
      this.mPTFilter.setFilter(FilterPlus.createFilter(paramInt1));
      this.mPTFilter.getFilter().needFlipBlend = true;
      this.mPTFilter.getFilter().setEffectIndex(paramInt2);
    }
    while (this.mPTFilter == null)
    {
      AppMethodBeat.o(80724);
      return;
      this.mPTFilter = PTFilter.createById(paramInt1, paramInt2);
    }
    this.mPTFilter.init();
    AppMethodBeat.o(80724);
  }
  
  public void clear()
  {
    AppMethodBeat.i(80718);
    this.mPTfaceDectector.destroy();
    this.mPTSegmentor.destroy();
    this.mSmoothBFilters.clear();
    this.mBeautyTransformList.clear();
    this.mColorToneFilter.clearGLSLSelf();
    this.mBeautyFaceList.clear();
    this.mRemodelFilter.clear();
    if (this.mPTFilter != null) {
      this.mPTFilter.destroy();
    }
    this.mPTAlphaFilter.destroy();
    this.mPTLongLegFilter.destroy();
    this.mPTSlimWaistFilter.destroy();
    if (this.mPTSticker != null) {
      this.mPTSticker.destroy();
    }
    this.mSwapCopyFilter.ClearGLSL();
    this.mCopyFilter.ClearGLSL();
    clearFrames();
    AppMethodBeat.o(80718);
  }
  
  public void init()
  {
    int i = 0;
    AppMethodBeat.i(80711);
    this.mSmoothBFilters.initial();
    this.mSmoothBFilters.setOnlyDetFaceRectSkin(false);
    this.mBeautyTransformList.initial();
    this.mColorToneFilter.ApplyGLSLFilter();
    this.mBeautyFaceList.initial();
    this.mRemodelFilter.init();
    if (this.mPTFilter != null) {
      this.mPTFilter.init();
    }
    this.mPTAlphaFilter.init();
    this.mPTLongLegFilter.init();
    this.mPTSlimWaistFilter.init();
    this.mBeautyParam = new BeautyParam(true);
    this.mBeautyParam.changeFaceMeshSet(1);
    while (i < this.mSwapFrames.length)
    {
      this.mSwapFrames[i] = new h();
      i += 1;
    }
    try
    {
      this.mPTfaceDectector.init();
      this.mPTfaceDectector.getFaceDetector().clearActionCounter();
      this.mPTSegmentor.init();
      isFaceDetectInited = true;
      AppMethodBeat.o(80711);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(80711);
    }
  }
  
  public void init(BeautyParam paramBeautyParam) {}
  
  public h process(h paramh)
  {
    AppMethodBeat.i(80712);
    if ((this.mWidthFrame != paramh.width) || (this.mHeightFrame != paramh.height))
    {
      this.mWidthFrame = paramh.width;
      this.mHeightFrame = paramh.height;
      this.mFaceDetectScale = (180.0F / this.mWidthFrame);
      if (this.mHeightFrame != 0) {
        this.mAspectRatio = (this.mWidthFrame / this.mHeightFrame);
      }
    }
    this.mFrameIndex = ((this.mFrameIndex + 1) % 2);
    if (this.isUnInitSwapCopyFilter)
    {
      this.mSwapCopyFilter.ApplyGLSLFilter(true, this.mWidthFrame, this.mHeightFrame);
      this.isUnInitSwapCopyFilter = false;
    }
    this.mSwapCopyFilter.nativeSetRotationAndFlip(0, 0, 1);
    this.mSwapCopyFilter.RenderProcess(paramh.texture[0], this.mWidthFrame, this.mHeightFrame, -1, 0.0D, this.mSwapFrames[this.mFrameIndex]);
    Object localObject1 = this.mSwapFrames[this.mFrameIndex];
    this.mRotationDegree = 0;
    if (this.mPTSticker != null) {
      GLES20.glFinish();
    }
    this.mFaceAttr = detectFace((h)localObject1, this.mRotationDegree, this.mWidthFrame);
    Object localObject2 = this.mPTSegmentor;
    int i = this.mRotationDegree;
    boolean bool;
    if ((this.mPTSticker != null) && (this.mPTSticker.isSegmentRequired()))
    {
      bool = true;
      this.mSegAttr = ((PTSegmentor)localObject2).detectFrame((h)localObject1, i, bool);
      updateBeautyNormalFactor(((Integer)this.mFaceAttr.getHistogram().first).intValue());
      localObject2 = this.mFaceAttr.getOrigFrame();
      localObject1 = localObject2;
      if (this.mPTFilter != null)
      {
        localObject1 = this.mPTFilter.process((h)localObject2, this.mWidthFrame, this.mHeightFrame);
        this.mPTAlphaFilter.getFilter().addParam(new m.n("inputImageTexture2", localObject2.texture[0], 33986));
        localObject1 = this.mPTAlphaFilter.process((h)localObject1, this.mWidthFrame, this.mHeightFrame);
      }
      localObject1 = renderBeautyFilter((h)localObject1, this.mFaceDetectScale);
      if (this.mBeautyFaceList != null) {
        this.mBeautyFaceList.updateVideoSize(this.mWidthFrame, this.mHeightFrame, this.mFaceDetectScale);
      }
      localObject1 = renderBeautyFaceList((h)localObject1, this.mFaceAttr);
      if (!this.mColorToneFilter.needRender()) {
        break label870;
      }
      this.mColorToneFilter.RenderProcess(paramh.texture[0], paramh.width, paramh.height, -1, 0.0D, this.mColorToneFrame);
    }
    h localh;
    label870:
    for (paramh = this.mColorToneFrame;; paramh = localh)
    {
      localObject2 = paramh;
      if (this.mFaceAttr != null) {
        if (!this.mEnableLongLeg)
        {
          localObject2 = paramh;
          if (!this.mEnableSlimWaist) {}
        }
        else
        {
          localObject1 = this.mFaceAttr.getBodyPoints();
          ArrayList localArrayList = new ArrayList();
          if (!((List)localObject1).isEmpty())
          {
            localObject1 = (List)((List)localObject1).get(0);
            i = 0;
            for (;;)
            {
              if (i < ((List)localObject1).size())
              {
                localArrayList.add(new PointF((float)(((PointF)((List)localObject1).get(i)).x / this.mFaceAttr.getFaceDetectScale()), (float)(((PointF)((List)localObject1).get(i)).y / this.mFaceAttr.getFaceDetectScale())));
                i += 1;
                continue;
                bool = false;
                break;
              }
            }
          }
          localObject1 = paramh;
          if (this.mEnableLongLeg)
          {
            this.mPTLongLegFilter.setWaistLine(localArrayList, this.mHeightFrame);
            localObject1 = this.mPTLongLegFilter.process(paramh, this.mWidthFrame, this.mHeightFrame);
          }
          localObject2 = localObject1;
          if (this.mEnableSlimWaist)
          {
            localObject2 = localObject1;
            if (!this.mPTSlimWaistFilter.setWaistRectangle(localArrayList, this.mWidthFrame, this.mHeightFrame)) {}
          }
        }
      }
      for (paramh = this.mPTSlimWaistFilter.process((h)localObject1, this.mWidthFrame, this.mHeightFrame);; paramh = (h)localObject2)
      {
        localObject1 = paramh;
        try
        {
          if (this.mPTSticker != null)
          {
            this.mPTSticker.updateVideoSize(this.mWidthFrame, this.mHeightFrame, this.mFaceAttr.getFaceDetectScale(), this.mRotationDegree);
            localObject1 = this.mPTSticker.processTransformRelatedFilters(paramh, this.mFaceAttr, this.mSegAttr);
          }
          localObject1 = renderBeautyTransformList((h)localObject1, this.mFaceAttr, this.mSegAttr, this.mFaceDetectScale, this.mRotationDegree);
          paramh = (h)localObject1;
        }
        catch (Exception localException)
        {
          try
          {
            if (this.mPTSticker != null) {
              paramh = this.mPTSticker.processStickerFilters((h)localObject1, this.mFaceAttr, this.mSegAttr);
            }
            this.mSwapCopyFilter.RenderProcess(paramh.texture[0], this.mWidthFrame, this.mHeightFrame, -1, 0.0D, this.mTempFrame);
            paramh = this.mTempFrame;
            AppMethodBeat.o(80712);
            return paramh;
            localException = localException;
            localh = paramh;
          }
          catch (Exception paramh)
          {
            for (;;)
            {
              paramh = localh;
            }
          }
        }
      }
    }
  }
  
  public void setBeautyLevel(BeautyRealConfig.TYPE paramTYPE, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(80720);
    if (BeautyRealUtil.isCombinedType(paramTYPE.value))
    {
      paramTYPE = BeautyRealUtil.getBeautyLevels(paramTYPE.value, false);
      if (paramTYPE.containsKey(BeautyRealConfig.TYPE.BEAUTY)) {
        setAtomBeautyLevel(BeautyRealConfig.TYPE.BEAUTY, ((Integer)paramTYPE.get(BeautyRealConfig.TYPE.BEAUTY)).intValue());
      }
      if (paramTYPE.containsKey(BeautyRealConfig.TYPE.BASIC3)) {
        setAtomBeautyLevel(BeautyRealConfig.TYPE.BASIC3, ((Integer)paramTYPE.get(BeautyRealConfig.TYPE.BASIC3)).intValue());
      }
      BeautyRealConfig.TYPE[] arrayOfTYPE = BeautyRealConfig.SINGLE_TRANS_TYPE_574;
      int j = arrayOfTYPE.length;
      paramInt = i;
      while (paramInt < j)
      {
        BeautyRealConfig.TYPE localTYPE = arrayOfTYPE[paramInt];
        setAtomBeautyLevel(localTYPE, ((Integer)paramTYPE.get(localTYPE)).intValue());
        paramInt += 1;
      }
      AppMethodBeat.o(80720);
      return;
    }
    if (paramTYPE == BeautyRealConfig.TYPE.LIPS_THICKNESS)
    {
      setAtomBeautyLevel(paramTYPE, 0 - paramInt);
      AppMethodBeat.o(80720);
      return;
    }
    setAtomBeautyLevel(paramTYPE, paramInt);
    AppMethodBeat.o(80720);
  }
  
  public void setCosmeticAlpha(int paramInt)
  {
    AppMethodBeat.i(80723);
    if (this.mPTSticker != null) {
      this.mPTSticker.updateCosAlpha(paramInt);
    }
    AppMethodBeat.o(80723);
  }
  
  public void setCosmeticMaterial(VideoMaterial paramVideoMaterial, int paramInt)
  {
    AppMethodBeat.i(80722);
    if (this.mPTSticker != null)
    {
      this.mPTSticker.destroy();
      this.mPTSticker = null;
    }
    if ((paramVideoMaterial != null) && (paramVideoMaterial.getDataPath() != null) && (paramVideoMaterial.getId() != null))
    {
      this.mPTSticker = new PTSticker(paramVideoMaterial, this.mPTfaceDectector.getFaceDetector());
      this.mPTSticker.init();
      setCosmeticAlpha(paramInt);
    }
    AppMethodBeat.o(80722);
  }
  
  public void setEnableLongLeg(boolean paramBoolean)
  {
    AppMethodBeat.i(80726);
    this.mEnableLongLeg = paramBoolean;
    if ((this.mEnableLongLeg) && (this.mPTLongLegFilter.getStrength() < 1.E-005D)) {
      this.mEnableLongLeg = false;
    }
    AppMethodBeat.o(80726);
  }
  
  public void setLongLegStrength(float paramFloat)
  {
    AppMethodBeat.i(80727);
    if (this.mPTLongLegFilter != null)
    {
      this.mPTLongLegFilter.setStrength(paramFloat);
      if (this.mPTLongLegFilter.getStrength() < 1.E-005D)
      {
        this.mEnableLongLeg = false;
        AppMethodBeat.o(80727);
        return;
      }
      this.mEnableLongLeg = true;
    }
    AppMethodBeat.o(80727);
  }
  
  public void setSlimWaistStrength(float paramFloat)
  {
    AppMethodBeat.i(80729);
    if (this.mPTSlimWaistFilter != null)
    {
      this.mPTSlimWaistFilter.setStrength(paramFloat);
      if (this.mPTSlimWaistFilter.getStrength() < 1.E-005D)
      {
        this.mEnableSlimWaist = false;
        AppMethodBeat.o(80729);
        return;
      }
      this.mEnableSlimWaist = true;
    }
    AppMethodBeat.o(80729);
  }
  
  public void setmEnableSlimWaist(boolean paramBoolean)
  {
    AppMethodBeat.i(80728);
    this.mEnableSlimWaist = paramBoolean;
    if ((this.mEnableSlimWaist) && (this.mPTSlimWaistFilter.getStrength() < 1.E-005D)) {
      this.mEnableSlimWaist = false;
    }
    AppMethodBeat.o(80728);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.PTGlamorize
 * JD-Core Version:    0.7.0.1
 */