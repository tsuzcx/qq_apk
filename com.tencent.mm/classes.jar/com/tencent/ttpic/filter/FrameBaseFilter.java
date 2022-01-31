package com.tencent.ttpic.filter;

import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.gles.AttributeParam;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FrameBaseFilter
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FrameBaseFragmentShader.dat");
  public static final String VERTEX_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FrameBaseVertexShader.dat");
  private Map<String, AttributeParam> mAttrParams;
  private int mRenderMode;
  private int mSTextureHandle;
  
  public FrameBaseFilter()
  {
    super(VERTEX_SHADER, FRAGMENT_SHADER);
    init();
  }
  
  public FrameBaseFilter(String paramString)
  {
    super(VERTEX_SHADER, paramString);
    init();
  }
  
  public FrameBaseFilter(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    init();
  }
  
  private void addAttribParam(String paramString, float[] paramArrayOfFloat)
  {
    addAttribParam(paramString, paramArrayOfFloat, false);
  }
  
  private void addAttribParam(String paramString, float[] paramArrayOfFloat, boolean paramBoolean)
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
  
  private void init()
  {
    this.mAttrParams = new HashMap();
    this.mSTextureHandle = -1;
  }
  
  public void ApplyGLSLFilter()
  {
    initAttribParams();
    super.ApplyGLSLFilter();
    Iterator localIterator = this.mAttrParams.values().iterator();
    while (localIterator.hasNext()) {
      ((AttributeParam)localIterator.next()).initialParams(getmProgramIds());
    }
    this.mSTextureHandle = GLES20.glGetUniformLocation(getmProgramIds(), "inputImageTexture");
  }
  
  public void OnDrawFrameGLSL()
  {
    super.OnDrawFrameGLSL();
    Iterator localIterator = this.mAttrParams.values().iterator();
    while (localIterator.hasNext()) {
      ((AttributeParam)localIterator.next()).setParams(getmProgramIds());
    }
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    Iterator localIterator = this.mAttrParams.values().iterator();
    while (localIterator.hasNext()) {
      ((AttributeParam)localIterator.next()).clear();
    }
  }
  
  public void initAttribParams()
  {
    setPositions(VideoFilterUtil.ORIGIN_POSITION_COORDS);
    setTexCords(VideoFilterUtil.ORIGIN_TEX_COORDS);
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt1);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glUniform1i(this.mSTextureHandle, 0);
    GLES20.glDrawArrays(6, 0, 4);
    if (this.mRenderMode == 0) {
      GLES20.glFinish();
    }
    while (this.mRenderMode != 1) {
      return true;
    }
    GLES20.glFlush();
    return true;
  }
  
  public boolean setPositions(float[] paramArrayOfFloat)
  {
    addAttribParam("position", paramArrayOfFloat);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.filter.FrameBaseFilter
 * JD-Core Version:    0.7.0.1
 */