package com.tencent.ttpic.util;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.ttpic.gles.GlUtil;

public class RGBATexSaveProcess
  implements TexSaveProcess
{
  private byte[] mData;
  private BaseFilter mFilter = new BaseFilter(GLSLRender.bcE);
  private h mRenderFrame = new h();
  
  private void initData(int paramInt1, int paramInt2)
  {
    paramInt1 = paramInt1 * paramInt2 * 4;
    if ((this.mData == null) || (this.mData.length != paramInt1)) {
      this.mData = new byte[paramInt1];
    }
  }
  
  public void clear()
  {
    this.mFilter.clearGLSLSelf();
    this.mRenderFrame.clear();
    this.mData = null;
  }
  
  public void init()
  {
    this.mFilter.ApplyGLSLFilter(true, 0.0F, 0.0F);
  }
  
  public boolean retrieveData(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    init();
    this.mFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, this.mRenderFrame);
    GlUtil.saveTextureToRgbaBuffer(this.mRenderFrame.texture[0], paramInt2, paramInt3, paramArrayOfByte, this.mRenderFrame.bcC[0]);
    return true;
  }
  
  public byte[] retrieveData(int paramInt1, int paramInt2, int paramInt3)
  {
    init();
    initData(paramInt2, paramInt3);
    BenchUtil.benchStart("scale");
    FrameUtil.clearFrame(this.mRenderFrame, 0.0F, 0.0F, 0.0F, 0.0F, paramInt2, paramInt3);
    this.mFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, this.mRenderFrame);
    BenchUtil.benchEnd("scale");
    BenchUtil.benchStart("saveTextureToRgbaBuffer");
    GlUtil.saveTextureToRgbaBuffer(this.mRenderFrame.texture[0], paramInt2, paramInt3, this.mData, this.mRenderFrame.bcC[0]);
    BenchUtil.benchEnd("saveTextureToRgbaBuffer");
    return this.mData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ttpic.util.RGBATexSaveProcess
 * JD-Core Version:    0.7.0.1
 */