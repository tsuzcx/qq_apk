package com.tencent.ttpic.util;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;

public class RGBATexSaveProcess
  implements TexSaveProcess
{
  private byte[] mData;
  private BaseFilter mFilter;
  private h mRenderFrame;
  
  public RGBATexSaveProcess()
  {
    AppMethodBeat.i(83942);
    this.mFilter = new BaseFilter(GLSLRender.btg);
    this.mRenderFrame = new h();
    AppMethodBeat.o(83942);
  }
  
  private void initData(int paramInt1, int paramInt2)
  {
    paramInt1 = paramInt1 * paramInt2 * 4;
    if ((this.mData == null) || (this.mData.length != paramInt1)) {
      this.mData = new byte[paramInt1];
    }
  }
  
  public void clear()
  {
    AppMethodBeat.i(83945);
    this.mFilter.clearGLSLSelf();
    this.mRenderFrame.clear();
    this.mData = null;
    AppMethodBeat.o(83945);
  }
  
  public void init()
  {
    AppMethodBeat.i(83943);
    this.mFilter.ApplyGLSLFilter(true, 0.0F, 0.0F);
    AppMethodBeat.o(83943);
  }
  
  public byte[] retrieveData(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(83944);
    init();
    initData(paramInt2, paramInt3);
    BenchUtil.benchStart("scale");
    FrameUtil.clearFrame(this.mRenderFrame, 0.0F, 0.0F, 0.0F, 0.0F, paramInt2, paramInt3);
    this.mFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, this.mRenderFrame);
    BenchUtil.benchEnd("scale");
    BenchUtil.benchStart("saveTextureToRgbaBuffer");
    GlUtil.saveTextureToRgbaBuffer(this.mRenderFrame.texture[0], paramInt2, paramInt3, this.mData, this.mRenderFrame.bte[0]);
    BenchUtil.benchEnd("saveTextureToRgbaBuffer");
    byte[] arrayOfByte = this.mData;
    AppMethodBeat.o(83944);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ttpic.util.RGBATexSaveProcess
 * JD-Core Version:    0.7.0.1
 */