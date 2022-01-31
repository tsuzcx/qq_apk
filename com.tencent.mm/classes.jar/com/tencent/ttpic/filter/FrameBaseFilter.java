package com.tencent.ttpic.filter;

import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.filter.BaseFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.gles.AttributeParam;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FrameBaseFilter
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER;
  public static final String VERTEX_SHADER;
  private Map<String, AttributeParam> mAttrParams;
  private int mRenderMode;
  private int mSTextureHandle;
  
  static
  {
    AppMethodBeat.i(82548);
    VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FrameBaseVertexShader.dat");
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FrameBaseFragmentShader.dat");
    AppMethodBeat.o(82548);
  }
  
  public FrameBaseFilter()
  {
    super(VERTEX_SHADER, FRAGMENT_SHADER);
    AppMethodBeat.i(82535);
    init();
    AppMethodBeat.o(82535);
  }
  
  public FrameBaseFilter(String paramString)
  {
    super(VERTEX_SHADER, paramString);
    AppMethodBeat.i(82536);
    init();
    AppMethodBeat.o(82536);
  }
  
  public FrameBaseFilter(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    AppMethodBeat.i(82537);
    init();
    AppMethodBeat.o(82537);
  }
  
  private void addAttribParam(String paramString, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(82545);
    addAttribParam(paramString, paramArrayOfFloat, false);
    AppMethodBeat.o(82545);
  }
  
  private void addAttribParam(String paramString, float[] paramArrayOfFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(82546);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(82546);
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
    AppMethodBeat.o(82546);
  }
  
  private void init()
  {
    AppMethodBeat.i(82538);
    this.mAttrParams = new HashMap();
    this.mSTextureHandle = -1;
    AppMethodBeat.o(82538);
  }
  
  public void ApplyGLSLFilter()
  {
    AppMethodBeat.i(82544);
    initAttribParams();
    super.ApplyGLSLFilter();
    Iterator localIterator = this.mAttrParams.values().iterator();
    while (localIterator.hasNext()) {
      ((AttributeParam)localIterator.next()).initialParams(getmProgramIds());
    }
    this.mSTextureHandle = GLES20.glGetUniformLocation(getmProgramIds(), "inputImageTexture");
    AppMethodBeat.o(82544);
  }
  
  public void OnDrawFrameGLSL()
  {
    AppMethodBeat.i(82542);
    super.OnDrawFrameGLSL();
    Iterator localIterator = this.mAttrParams.values().iterator();
    while (localIterator.hasNext()) {
      ((AttributeParam)localIterator.next()).setParams(getmProgramIds());
    }
    AppMethodBeat.o(82542);
  }
  
  public void clearGLSLSelf()
  {
    AppMethodBeat.i(82547);
    super.clearGLSLSelf();
    Iterator localIterator = this.mAttrParams.values().iterator();
    while (localIterator.hasNext()) {
      ((AttributeParam)localIterator.next()).clear();
    }
    AppMethodBeat.o(82547);
  }
  
  public void initAttribParams()
  {
    AppMethodBeat.i(82539);
    setPositions(GlUtil.ORIGIN_POSITION_COORDS);
    setTexCords(GlUtil.ORIGIN_TEX_COORDS);
    AppMethodBeat.o(82539);
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(82543);
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
    for (;;)
    {
      AppMethodBeat.o(82543);
      return true;
      if (this.mRenderMode == 1) {
        GLES20.glFlush();
      }
    }
  }
  
  public boolean setPositions(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(82540);
    addAttribParam("position", paramArrayOfFloat);
    AppMethodBeat.o(82540);
    return true;
  }
  
  public boolean setRenderMode(int paramInt)
  {
    this.mRenderMode = paramInt;
    return true;
  }
  
  public boolean setTexCords(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(82541);
    addAttribParam("inputTextureCoordinate", paramArrayOfFloat);
    AppMethodBeat.o(82541);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.ttpic.filter.FrameBaseFilter
 * JD-Core Version:    0.7.0.1
 */