package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.PTDetectInfo.Builder;
import com.tencent.ttpic.model.VideoMaterial;
import java.util.List;

public class CrazyFaceFilters
{
  private FaceAverageBackgroundFilter faceAverageBackgroundFilter;
  private FaceAverageFilter faceAverageFilter;
  private BaseFilter mCopyFilter;
  private h mCopyFrame;
  private FaceSkinBalanceFilter mFaceSkinBalanceFilter;
  private h mSkinBalanceFrame;
  
  public CrazyFaceFilters(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(82124);
    this.mCopyFilter = new BaseFilter(GLSLRender.btg);
    this.mCopyFrame = new h();
    this.mSkinBalanceFrame = new h();
    VideoMaterial localVideoMaterial = paramVideoMaterial;
    if (paramVideoMaterial == null) {
      localVideoMaterial = new VideoMaterial();
    }
    this.faceAverageBackgroundFilter = new FaceAverageBackgroundFilter(localVideoMaterial.getDataPath(), localVideoMaterial.getFaceImageLayer());
    this.faceAverageFilter = new FaceAverageFilter(localVideoMaterial.getDataPath(), localVideoMaterial.getFaceImageLayer());
    this.mFaceSkinBalanceFilter = new FaceSkinBalanceFilter(localVideoMaterial.getFaceImageLayer());
    AppMethodBeat.o(82124);
  }
  
  public void ApplyGLSLFilter()
  {
    AppMethodBeat.i(82126);
    this.faceAverageBackgroundFilter.ApplyGLSLFilter();
    this.faceAverageFilter.ApplyGLSLFilter();
    this.mFaceSkinBalanceFilter.ApplyGLSLFilter();
    this.mCopyFilter.ApplyGLSLFilter();
    AppMethodBeat.o(82126);
  }
  
  public void clear()
  {
    AppMethodBeat.i(82128);
    this.faceAverageBackgroundFilter.clearGLSLSelf();
    this.faceAverageFilter.clearGLSLSelf();
    this.mFaceSkinBalanceFilter.clearGLSLSelf();
    this.mCopyFilter.clearGLSLSelf();
    this.mCopyFrame.clear();
    this.mSkinBalanceFrame.clear();
    AppMethodBeat.o(82128);
  }
  
  public void setImageData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(82129);
    this.mFaceSkinBalanceFilter.setImageData(paramArrayOfByte);
    AppMethodBeat.o(82129);
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(82130);
    this.faceAverageBackgroundFilter.setRenderMode(paramInt);
    this.faceAverageFilter.setRenderMode(paramInt);
    this.mFaceSkinBalanceFilter.setRenderMode(paramInt);
    this.mCopyFilter.setRenderMode(paramInt);
    AppMethodBeat.o(82130);
  }
  
  public h updateAndRender(h paramh, int paramInt1, int paramInt2, List<PointF> paramList, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(82125);
    this.mCopyFilter.RenderProcess(paramh.texture[0], paramInt1, paramInt2, -1, 0.0D, this.mCopyFrame);
    PTDetectInfo localPTDetectInfo = new PTDetectInfo.Builder().build();
    this.faceAverageBackgroundFilter.updatePreview(localPTDetectInfo);
    this.faceAverageBackgroundFilter.OnDrawFrameGLSL();
    this.faceAverageBackgroundFilter.renderTexture(this.mCopyFrame.texture[0], paramInt1, paramInt2);
    this.mFaceSkinBalanceFilter.RenderProcess(paramh.texture[0], paramInt1, paramInt2, -1, 0.0D, this.mSkinBalanceFrame);
    this.faceAverageFilter.setUserTexture(this.mSkinBalanceFrame.texture[0]);
    paramh = new PTDetectInfo.Builder().facePoints(paramList).faceAngles(paramArrayOfFloat).timestamp(0L).build();
    this.faceAverageFilter.updatePreview(paramh);
    this.mCopyFrame.a(this.mCopyFrame.texture[0], paramInt1, paramInt2, 0.0D);
    this.faceAverageFilter.OnDrawFrameGLSL();
    this.faceAverageFilter.renderTexture(this.mCopyFrame.texture[0], paramInt1, paramInt2);
    paramh = this.mCopyFrame;
    AppMethodBeat.o(82125);
    return paramh;
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    AppMethodBeat.i(82127);
    this.faceAverageBackgroundFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.faceAverageFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    AppMethodBeat.o(82127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.filter.CrazyFaceFilters
 * JD-Core Version:    0.7.0.1
 */