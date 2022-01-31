package com.tencent.mm.plugin.voip.video.a;

import android.opengl.GLES20;
import com.tencent.ttpic.PTBeauty;
import com.tencent.ttpic.PTFilter;
import com.tencent.ttpic.PTFilter.PTCopyFilter;
import com.tencent.ttpic.PTSmoothSkin;
import com.tencent.ttpic.baseutils.SourcePathUtil;
import com.tencent.ttpic.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.facedetect.FaceDetector;
import com.tencent.ttpic.facedetect.FaceDetectorManager;

public class a
{
  static final String TAG = a.class.getSimpleName();
  public static float jjQ = 180.0F;
  private boolean dBn = false;
  PTSmoothSkin jjR = null;
  private PTFilter.PTCopyFilter jjS = null;
  private PTBeauty jjT;
  PTFilter.PTCopyFilter jjU = null;
  int jjV;
  int jjW;
  int jjX;
  int jjY;
  private int jjZ;
  private int jka;
  private boolean[] jkb = new boolean[7];
  byte[] jkc;
  int jkd;
  int jke;
  PTFilter qcb = null;
  int qcc;
  
  private void a(BeautyRealConfig.TYPE paramTYPE, int paramInt)
  {
    int k = 1;
    int m = 1;
    int n = 1;
    int i1 = 1;
    int i2 = 1;
    int i = 1;
    int j = 0;
    if (this.jjT != null) {
      this.jjT.setBeautyParam(paramTYPE, paramInt);
    }
    switch (a.1.jkf[paramTYPE.ordinal()])
    {
    default: 
      return;
    case 1: 
      paramTYPE = this.jkb;
      if (paramInt != 0) {}
      for (;;)
      {
        paramTYPE[0] = i;
        return;
        i = 0;
      }
    case 2: 
      paramTYPE = this.jkb;
      i = j;
      if (paramInt != 0) {
        i = 1;
      }
      paramTYPE[1] = i;
      return;
    case 3: 
      paramTYPE = this.jkb;
      if (paramInt != 0) {}
      for (i = k;; i = 0)
      {
        paramTYPE[2] = i;
        return;
      }
    case 4: 
      paramTYPE = this.jkb;
      if (paramInt != 0) {}
      for (i = m;; i = 0)
      {
        paramTYPE[3] = i;
        return;
      }
    case 5: 
      paramTYPE = this.jkb;
      if (paramInt != 0) {}
      for (i = n;; i = 0)
      {
        paramTYPE[4] = i;
        return;
      }
    case 6: 
      paramTYPE = this.jkb;
      if (paramInt != 0) {}
      for (i = i1;; i = 0)
      {
        paramTYPE[5] = i;
        return;
      }
    }
    paramTYPE = this.jkb;
    if (paramInt != 0) {}
    for (i = i2;; i = 0)
    {
      paramTYPE[6] = i;
      return;
    }
  }
  
  public final void clear()
  {
    if (this.jjR != null)
    {
      this.jjR.destroy();
      this.jjR = null;
    }
    if (this.qcb != null)
    {
      this.qcb.destroy();
      this.qcb = null;
    }
    if (this.jjT != null)
    {
      this.jjT.destroy();
      this.jjT = null;
    }
    if (this.jjS != null) {
      this.jjS.destroy();
    }
    this.jjS = null;
    if (this.jjU != null) {
      this.jjU.destroy();
    }
    this.jjU = null;
    GLES20.glDeleteTextures(4, new int[] { this.jjX, this.jjY, this.jjZ, this.jka }, 0);
    GLES20.glDeleteFramebuffers(1, new int[] { this.qcc }, 0);
  }
  
  public final void er(int paramInt1, int paramInt2)
  {
    clear();
    this.jjR = new PTSmoothSkin();
    this.jjR.init();
    if (this.jjR != null) {
      this.jjR.setBeautyLevel(20);
    }
    a(BeautyRealConfig.TYPE.BASIC3, 10);
    a(BeautyRealConfig.TYPE.FACE_V, 0);
    a(BeautyRealConfig.TYPE.EYE, 0);
    a(BeautyRealConfig.TYPE.NOSE, 0);
    a(BeautyRealConfig.TYPE.CHIN, 0);
    this.qcb = PTFilter.createByLut(SourcePathUtil.getFilterSourcePath());
    this.qcb.init();
    this.jjS = new PTFilter.PTCopyFilter();
    this.jjS.init();
    this.jjU = new PTFilter.PTCopyFilter();
    this.jjU.init();
    int[] arrayOfInt = new int[4];
    GLES20.glGenTextures(4, arrayOfInt, 0);
    this.jjX = arrayOfInt[0];
    this.jjY = arrayOfInt[1];
    this.jjZ = arrayOfInt[2];
    this.jka = arrayOfInt[3];
    this.jjV = paramInt1;
    this.jjW = paramInt2;
    arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    this.qcc = arrayOfInt[0];
    FaceDetectorManager.getInstance().getCurrentFaceDetector().clearActionCounter();
    SourcePathUtil.loadBeautySo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.a.a
 * JD-Core Version:    0.7.0.1
 */