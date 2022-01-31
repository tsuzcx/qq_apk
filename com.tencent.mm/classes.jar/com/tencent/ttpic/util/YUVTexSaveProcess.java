package com.tencent.ttpic.util;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.b;

public class YUVTexSaveProcess
  implements TexSaveProcess
{
  private byte[] mData;
  private BaseFilter mFilter;
  private h mRenderFrame;
  private byte[] mYUVAData;
  
  public YUVTexSaveProcess()
  {
    AppMethodBeat.i(84304);
    this.mFilter = new BaseFilter(GLSLRender.btY);
    this.mRenderFrame = new h();
    AppMethodBeat.o(84304);
  }
  
  private void initData(int paramInt1, int paramInt2)
  {
    int i = paramInt1 * paramInt2 * 3 / 2;
    if ((this.mData == null) || (this.mData.length < i))
    {
      this.mData = new byte[i];
      this.mYUVAData = new byte[paramInt1 * paramInt2 * 4];
    }
  }
  
  public void clear()
  {
    AppMethodBeat.i(84307);
    this.mFilter.clearGLSLSelf();
    this.mRenderFrame.clear();
    this.mData = null;
    this.mYUVAData = null;
    AppMethodBeat.o(84307);
  }
  
  public void init()
  {
    AppMethodBeat.i(84305);
    this.mFilter.ApplyGLSLFilter(true, 0.0F, 0.0F);
    AppMethodBeat.o(84305);
  }
  
  public byte[] retrieveData(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(84306);
    init();
    initData(paramInt2, paramInt3);
    this.mRenderFrame.a(-1, paramInt2, paramInt3, 0.0D);
    this.mFilter.OnDrawFrameGLSL();
    this.mFilter.renderTexture(paramInt1, paramInt2, paramInt3);
    if (b.BzL < 0) {
      GLSLRender.nativeToRGBData(this.mYUVAData, paramInt2, paramInt3);
    }
    for (;;)
    {
      AlgoUtils.YUVX2YUV(this.mYUVAData, this.mData, paramInt2, paramInt3);
      byte[] arrayOfByte = this.mData;
      AppMethodBeat.o(84306);
      return arrayOfByte;
      GLSLRender.nativePushDataFromTexture(this.mYUVAData, paramInt2, paramInt3, b.BzL);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.YUVTexSaveProcess
 * JD-Core Version:    0.7.0.1
 */