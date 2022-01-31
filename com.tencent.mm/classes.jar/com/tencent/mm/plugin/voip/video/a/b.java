package com.tencent.mm.plugin.voip.video.a;

import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.config.BeautyRealConfig;
import com.tencent.ttpic.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.filter.BeautyFaceList;
import com.tencent.ttpic.filter.BeautyParam;
import com.tencent.ttpic.filter.BeautyTransformList;
import com.tencent.ttpic.filter.BrightnessAdjustmentFilter;
import com.tencent.ttpic.filter.RemodelFilter;
import com.tencent.ttpic.filter.SmoothBFilters;
import com.tencent.ttpic.util.BeautyRealUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import java.util.Map;

public final class b
{
  public static boolean ENABLE_GESTURE;
  public static float FACE_DETECT_IMG_WIDTH;
  public static boolean lte;
  private boolean bRB;
  int eYd;
  int eYj;
  int eYk;
  int frameIndex;
  BrightnessAdjustmentFilter ltf;
  boolean ltg;
  BaseFilter lth;
  com.tencent.filter.h lti;
  com.tencent.filter.h ltj;
  a ltk;
  int ltl;
  byte[] ltm;
  int ltn;
  BeautyFaceList mBeautyFaceList;
  com.tencent.filter.h mBeautyFrame2;
  private BeautyParam mBeautyParam;
  com.tencent.filter.h mBeautyTransformCopyFrame;
  BeautyTransformList mBeautyTransformList;
  BaseFilter mCopyFilter;
  RemodelFilter mRemodelFilter;
  SmoothBFilters mSmoothBFilters;
  BaseFilter mSwapCopyFilter;
  com.tencent.filter.h[] mSwapFrames;
  com.tencent.filter.h mTempFrame;
  
  static
  {
    AppMethodBeat.i(5124);
    lte = true;
    ENABLE_GESTURE = true;
    FACE_DETECT_IMG_WIDTH = 180.0F;
    AppMethodBeat.o(5124);
  }
  
  public b()
  {
    AppMethodBeat.i(5119);
    this.mSwapCopyFilter = new BaseFilter(GLSLRender.btg);
    this.ltg = true;
    this.mSwapFrames = new com.tencent.filter.h[2];
    this.frameIndex = -1;
    this.bRB = false;
    try
    {
      this.lth = new BaseFilter(GLSLRender.btg);
      this.lti = new com.tencent.filter.h();
      this.mCopyFilter = new BaseFilter(GLSLRender.btg);
      this.mTempFrame = new com.tencent.filter.h();
      this.ltf = new BrightnessAdjustmentFilter();
      this.mSmoothBFilters = new SmoothBFilters();
      this.mBeautyFaceList = new BeautyFaceList();
      this.mBeautyTransformList = new BeautyTransformList();
      this.ltj = new com.tencent.filter.h();
      this.mBeautyTransformCopyFrame = new com.tencent.filter.h();
      this.mBeautyFrame2 = new com.tencent.filter.h();
      this.mBeautyParam = new BeautyParam(true);
      this.ltk = new a('\000');
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          this.mRemodelFilter = new RemodelFilter();
          AppMethodBeat.o(5119);
          return;
        }
        catch (Throwable localThrowable)
        {
          ab.printErrStackTrace("MicroMsg.FilterProcessTex", localThrowable, "create RemodelFilter error", new Object[0]);
          com.tencent.mm.plugin.report.service.h.qsU.j(914L, 12L, 1L);
          AppMethodBeat.o(5119);
        }
        localException = localException;
        ab.printErrStackTrace("MicroMsg.FilterProcessTex", localException, "create FilterProcess error", new Object[0]);
        com.tencent.mm.plugin.report.service.h.qsU.j(914L, 12L, 1L);
      }
    }
  }
  
  private void a(BeautyRealConfig.TYPE paramTYPE, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(5122);
    if (BeautyRealUtil.isCombinedType(paramTYPE.value))
    {
      paramTYPE = BeautyRealUtil.getBeautyLevels(paramTYPE.value, false);
      if (paramTYPE.containsKey(BeautyRealConfig.TYPE.BEAUTY)) {
        b(BeautyRealConfig.TYPE.BEAUTY, ((Integer)paramTYPE.get(BeautyRealConfig.TYPE.BEAUTY)).intValue());
      }
      if (paramTYPE.containsKey(BeautyRealConfig.TYPE.BASIC3)) {
        b(BeautyRealConfig.TYPE.BASIC3, ((Integer)paramTYPE.get(BeautyRealConfig.TYPE.BASIC3)).intValue());
      }
      BeautyRealConfig.TYPE[] arrayOfTYPE = BeautyRealConfig.SINGLE_TRANS_TYPE;
      int j = arrayOfTYPE.length;
      paramInt = i;
      while (paramInt < j)
      {
        BeautyRealConfig.TYPE localTYPE = arrayOfTYPE[paramInt];
        b(localTYPE, ((Integer)paramTYPE.get(localTYPE)).intValue());
        paramInt += 1;
      }
      AppMethodBeat.o(5122);
      return;
    }
    if (paramTYPE == BeautyRealConfig.TYPE.LIPS_THICKNESS)
    {
      b(paramTYPE, 0 - paramInt);
      AppMethodBeat.o(5122);
      return;
    }
    b(paramTYPE, paramInt);
    AppMethodBeat.o(5122);
  }
  
  private void b(BeautyRealConfig.TYPE paramTYPE, int paramInt)
  {
    AppMethodBeat.i(140211);
    ab.i("MicroMsg.FilterProcessTex", "setupCosmeticsLevelInner: %s, %s", new Object[] { paramTYPE, Integer.valueOf(paramInt) });
    switch (b.1.$SwitchMap$com$tencent$ttpic$config$BeautyRealConfig$TYPE[paramTYPE.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(140211);
      return;
      this.mSmoothBFilters.updateBlurAlpha(paramInt * 0.6F / 100.0F);
      if (this.mBeautyFaceList != null)
      {
        this.mBeautyFaceList.setLightRemovePouchAlpha(paramInt * 0.6F / 100.0F);
        AppMethodBeat.o(140211);
        return;
        AppMethodBeat.o(140211);
        return;
        if (this.mBeautyFaceList != null)
        {
          this.mBeautyFaceList.setRemovePounchAlpha(paramInt / 100.0F);
          AppMethodBeat.o(140211);
          return;
          if (this.mBeautyFaceList != null)
          {
            this.mBeautyFaceList.setEyeLightenAlpha(paramInt / 100.0F);
            AppMethodBeat.o(140211);
            return;
            if (this.mBeautyFaceList != null)
            {
              this.mBeautyFaceList.setToothWhitenAlpha(paramInt / 80.0F);
              AppMethodBeat.o(140211);
              return;
              if (this.mRemodelFilter != null)
              {
                this.mRemodelFilter.setParam(paramTYPE.value, paramInt);
                AppMethodBeat.o(140211);
                return;
                if ((this.mBeautyParam != null) && (this.mBeautyTransformList != null)) {
                  this.mBeautyTransformList.setBeautyParam(paramTYPE.value, BeautyRealUtil.getDistortParam(this.mBeautyParam.getDistortList(paramTYPE.value), paramInt, paramTYPE.value));
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void initial(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(5120);
    try
    {
      ab.i("MicroMsg.FilterProcessTex", "initial %s, %d", new Object[] { this, Long.valueOf(Thread.currentThread().getId()) });
      this.ltk.init();
      this.lth.ApplyGLSLFilter(true, this.eYj, this.eYk);
      this.mSwapCopyFilter.ApplyGLSLFilter(true, this.eYj, this.eYk);
      this.ltf.ApplyGLSLFilter(true, this.eYj, this.eYk);
      this.mSmoothBFilters.initial();
      this.mSmoothBFilters.updateBlurAlpha(0.4F);
      this.mBeautyFaceList.initial();
      this.mBeautyParam.changeFaceMeshSet(1);
      this.mBeautyTransformList.initial();
      this.mCopyFilter.ApplyGLSLFilter(true, this.eYj, this.eYk);
      VideoFilterUtil.setRenderMode(this.lth, 1);
      VideoFilterUtil.setRenderMode(this.ltf, 1);
      VideoFilterUtil.setRenderMode(this.mCopyFilter, 1);
      if (this.mBeautyTransformList != null) {
        this.mBeautyTransformList.setRenderMode(1);
      }
      if (this.mBeautyFaceList != null) {
        this.mBeautyFaceList.setRenderMode(1);
      }
      if (this.mSmoothBFilters != null) {
        this.mSmoothBFilters.setRenderMode(1);
      }
      if (this.mRemodelFilter != null) {
        this.mRemodelFilter.setRenderMode(1);
      }
      a(BeautyRealConfig.TYPE.BEAUTY, 50);
      a(BeautyRealConfig.TYPE.BASIC3, 20);
      a(BeautyRealConfig.TYPE.FACE_V, 0);
      a(BeautyRealConfig.TYPE.EYE, 0);
      a(BeautyRealConfig.TYPE.NOSE, 0);
      a(BeautyRealConfig.TYPE.CHIN, 0);
      this.eYd = paramInt1;
      this.ltl = paramInt2;
      int[] arrayOfInt = new int[1];
      GLES20.glGenFramebuffers(1, arrayOfInt, 0);
      this.ltn = arrayOfInt[0];
      paramInt1 = 0;
      while (paramInt1 < this.mSwapFrames.length)
      {
        this.mSwapFrames[paramInt1] = new com.tencent.filter.h();
        paramInt1 += 1;
      }
      ab.d("MicroMsg.FilterProcessTex", "initial end %s", new Object[] { this });
      AppMethodBeat.o(5120);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.FilterProcessTex", localException, "initial error", new Object[0]);
      AppMethodBeat.o(5120);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.a.b
 * JD-Core Version:    0.7.0.1
 */