package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.filter.h;
import com.tencent.filter.m;
import com.tencent.ttpic.gles.AttributeParam;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.HandActionCounter;
import com.tencent.ttpic.shader.Shader;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.shader.ShaderManager;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoFilterUtil.DRAW_MODE;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class VideoFilterBase
{
  public String dataPath;
  public int height;
  private Map<String, AttributeParam> mAttrParams;
  private int mCoordNum;
  private VideoFilterUtil.DRAW_MODE mDrawMode;
  protected double mFaceDetScale;
  protected boolean mIsRenderForBitmap = false;
  private Map<String, m> mParamList;
  private int mRenderMode = 1;
  protected int mSTextureHandle;
  private boolean needDelProgram;
  private Shader shader;
  public int width;
  
  private VideoFilterBase(Shader paramShader)
  {
    this.shader = paramShader;
    this.mAttrParams = new HashMap();
    this.mParamList = new HashMap();
    this.mSTextureHandle = -1;
    this.mCoordNum = 4;
    this.mDrawMode = VideoFilterUtil.DRAW_MODE.TRIANGLE_FAN;
  }
  
  public VideoFilterBase(ShaderCreateFactory.PROGRAM_TYPE paramPROGRAM_TYPE)
  {
    this(ShaderManager.getInstance().getShader(paramPROGRAM_TYPE));
  }
  
  public VideoFilterBase(String paramString1, String paramString2)
  {
    this(new Shader(paramString1, paramString2));
    this.needDelProgram = true;
  }
  
  public void ApplyGLSLFilter()
  {
    initAttribParams();
    GlUtil.debugCheckGlError(this);
    this.shader.compile();
    GlUtil.debugCheckGlError(this);
    Iterator localIterator = this.mParamList.values().iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).initialParams(this.shader.getShaderProgram());
    }
    localIterator = this.mAttrParams.values().iterator();
    while (localIterator.hasNext()) {
      ((AttributeParam)localIterator.next()).initialParams(this.shader.getShaderProgram());
    }
    GlUtil.debugCheckGlError(this);
    this.mSTextureHandle = GLES20.glGetUniformLocation(this.shader.getShaderProgram(), "inputImageTexture");
    GlUtil.debugCheckGlError(this);
  }
  
  public void OnDrawFrameGLSL()
  {
    this.shader.bind();
    Iterator localIterator = this.mParamList.values().iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).setParams(this.shader.getShaderProgram());
    }
    localIterator = this.mAttrParams.values().iterator();
    while (localIterator.hasNext())
    {
      AttributeParam localAttributeParam = (AttributeParam)localIterator.next();
      if (localAttributeParam.handle >= 0) {
        localAttributeParam.setParams(this.shader.getShaderProgram());
      }
    }
  }
  
  public void OnDrawFrameGLSLSuper()
  {
    this.shader.bind();
    Iterator localIterator = this.mParamList.values().iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).setParams(this.shader.getShaderProgram());
    }
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, h paramh)
  {
    paramh.a(paramInt4, paramInt2, paramInt3, paramDouble);
    OnDrawFrameGLSL();
    renderTexture(paramInt1, paramInt2, paramInt3);
  }
  
  public void addAttribParam(AttributeParam paramAttributeParam)
  {
    if (paramAttributeParam == null) {
      return;
    }
    AttributeParam localAttributeParam2 = (AttributeParam)this.mAttrParams.get(paramAttributeParam.name);
    AttributeParam localAttributeParam1 = localAttributeParam2;
    if (localAttributeParam2 == null)
    {
      localAttributeParam1 = new AttributeParam(paramAttributeParam.name, paramAttributeParam.vertices, paramAttributeParam.perVertexFloat, false);
      this.mAttrParams.put(paramAttributeParam.name, localAttributeParam1);
    }
    localAttributeParam1.setVertices(paramAttributeParam.vertices);
    localAttributeParam1.perVertexFloat = paramAttributeParam.perVertexFloat;
  }
  
  public void addAttribParam(String paramString, float[] paramArrayOfFloat)
  {
    addAttribParam(paramString, paramArrayOfFloat, false);
  }
  
  public void addAttribParam(String paramString, float[] paramArrayOfFloat, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    AttributeParam localAttributeParam2 = (AttributeParam)this.mAttrParams.get(paramString);
    AttributeParam localAttributeParam1 = localAttributeParam2;
    if (localAttributeParam2 == null)
    {
      localAttributeParam1 = new AttributeParam(paramString, paramArrayOfFloat, paramBoolean);
      this.mAttrParams.put(paramString, localAttributeParam1);
    }
    localAttributeParam1.setVertices(paramArrayOfFloat);
  }
  
  public void addParam(m paramm)
  {
    if (paramm == null) {
      return;
    }
    m localm = (m)this.mParamList.get(paramm.name);
    if (localm == null)
    {
      this.mParamList.put(paramm.name, paramm);
      return;
    }
    paramm.handle = localm.handle;
    this.mParamList.put(paramm.name, paramm);
  }
  
  public void clearGLSLSelf()
  {
    if (this.needDelProgram) {
      this.shader.clear();
    }
    Iterator localIterator = this.mParamList.values().iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).clear();
    }
    localIterator = this.mAttrParams.values().iterator();
    while (localIterator.hasNext()) {
      ((AttributeParam)localIterator.next()).clear();
    }
  }
  
  public AttributeParam getAttribParam(String paramString)
  {
    return (AttributeParam)this.mAttrParams.get(paramString);
  }
  
  public int getProgramIds()
  {
    return this.shader.getShaderProgram();
  }
  
  public void initAttribParams()
  {
    setPositions(VideoFilterUtil.ORIGIN_POSITION_COORDS);
    setTexCords(VideoFilterUtil.ORIGIN_TEX_COORDS);
  }
  
  public abstract void initParams();
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt1);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glUniform1i(this.mSTextureHandle, 0);
    if (this.mDrawMode == VideoFilterUtil.DRAW_MODE.TRIANGLE_STRIP)
    {
      GLES20.glDrawArrays(5, 0, this.mCoordNum);
      if (this.mRenderMode != 0) {
        break label162;
      }
      GLES20.glFinish();
    }
    label162:
    while (this.mRenderMode != 1)
    {
      return true;
      if (this.mDrawMode == VideoFilterUtil.DRAW_MODE.TRIANGLES)
      {
        GLES20.glDrawArrays(4, 0, this.mCoordNum);
        break;
      }
      if (this.mDrawMode == VideoFilterUtil.DRAW_MODE.TRIANGLE_FAN)
      {
        GLES20.glDrawArrays(6, 0, this.mCoordNum);
        break;
      }
      if (this.mDrawMode != VideoFilterUtil.DRAW_MODE.LINES) {
        break;
      }
      GLES20.glDrawArrays(1, 0, this.mCoordNum);
      break;
    }
    GLES20.glFlush();
    return true;
  }
  
  public boolean setCoordNum(int paramInt)
  {
    this.mCoordNum = paramInt;
    return true;
  }
  
  public void setDrawMode(VideoFilterUtil.DRAW_MODE paramDRAW_MODE)
  {
    this.mDrawMode = paramDRAW_MODE;
  }
  
  public boolean setGrayCords(float[] paramArrayOfFloat)
  {
    addAttribParam("inputGrayTextureCoordinate", paramArrayOfFloat);
    return true;
  }
  
  public void setIsRenderForBitmap(boolean paramBoolean)
  {
    this.mIsRenderForBitmap = paramBoolean;
  }
  
  public boolean setPositions(float[] paramArrayOfFloat)
  {
    addAttribParam("position", paramArrayOfFloat);
    return true;
  }
  
  public boolean setPositions(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    addAttribParam("position", paramArrayOfFloat, paramBoolean);
    return true;
  }
  
  public boolean setRenderMode(int paramInt)
  {
    this.mRenderMode = paramInt;
    return true;
  }
  
  public boolean setTexCords(float[] paramArrayOfFloat)
  {
    addAttribParam("inputTextureCoordinate", paramArrayOfFloat);
    return true;
  }
  
  public boolean setTexCords(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    addAttribParam("inputTextureCoordinate", paramArrayOfFloat, paramBoolean);
    return true;
  }
  
  public void updateFilterShader(ShaderCreateFactory.PROGRAM_TYPE paramPROGRAM_TYPE)
  {
    this.shader = ShaderManager.getInstance().getShader(paramPROGRAM_TYPE);
    this.needDelProgram = false;
  }
  
  public void updateFilterShader(String paramString1, String paramString2)
  {
    this.shader = new Shader(paramString1, paramString2);
    this.needDelProgram = true;
  }
  
  public abstract void updatePreview(List<PointF> paramList1, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList2, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, float paramFloat, long paramLong);
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.mFaceDetScale = paramDouble;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ttpic.filter.VideoFilterBase
 * JD-Core Version:    0.7.0.1
 */