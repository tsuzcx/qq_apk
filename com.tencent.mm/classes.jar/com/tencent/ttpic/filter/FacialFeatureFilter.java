package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.filter.h;
import com.tencent.filter.m.j;
import com.tencent.filter.m.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.PTDetectInfo.Builder;
import com.tencent.ttpic.VideoModule;
import com.tencent.ttpic.VideoModule.DeviceType;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import com.tencent.ttpic.model.DistortionItem;
import com.tencent.ttpic.model.FaceFeatureItem;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class FacialFeatureFilter
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER;
  private static int FRAME_EDGE;
  public static final String VERTEX_SHADER;
  private float[] faceVertices;
  List<PointF> fullPositions;
  private float[] grayVertices;
  private FaceFeatureItem mFaceFeatureItem;
  private FaceItem mFaceItem;
  h mFrame;
  private boolean mIsFirstRender;
  h mResultFrame;
  private List<NormalVideoFilter> mStickerFilters;
  h mTFrame;
  TransformFilter mTransformFilter;
  private float[] mt4;
  private float[] texVertices;
  
  static
  {
    AppMethodBeat.i(82460);
    VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FacialFeatureVertexShader.dat");
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FacialFeatureFragmentShader.dat");
    FRAME_EDGE = 640;
    AppMethodBeat.o(82460);
  }
  
  public FacialFeatureFilter(FaceItem paramFaceItem, List<DistortionItem> paramList, FaceFeatureItem paramFaceFeatureItem)
  {
    super(VERTEX_SHADER, FRAGMENT_SHADER);
    AppMethodBeat.i(82447);
    this.mFrame = new h();
    this.mTFrame = new h();
    this.faceVertices = new float[1380];
    this.texVertices = new float[1380];
    this.grayVertices = new float[1380];
    this.mt4 = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
    this.mIsFirstRender = true;
    if (paramList != null) {
      this.mTransformFilter = new TransformFilter(paramList, null);
    }
    this.mFaceFeatureItem = paramFaceFeatureItem;
    this.mFaceItem = paramFaceItem;
    initParams();
    if (VideoModule.getDeviceType() == VideoModule.DeviceType.HIGH)
    {
      FRAME_EDGE = 1024;
      AppMethodBeat.o(82447);
      return;
    }
    if (VideoModule.getDeviceType() == VideoModule.DeviceType.MIDDLE)
    {
      FRAME_EDGE = 640;
      AppMethodBeat.o(82447);
      return;
    }
    FRAME_EDGE = 512;
    AppMethodBeat.o(82447);
  }
  
  private void updateFacePoints(List<PointF> paramList, float paramFloat)
  {
    AppMethodBeat.i(82450);
    float f1 = ((PointF)paramList.get(64)).x;
    float f2 = ((PointF)paramList.get(64)).y;
    Object localObject = paramList.iterator();
    PointF localPointF;
    while (((Iterator)localObject).hasNext())
    {
      localPointF = (PointF)((Iterator)localObject).next();
      localPointF.x -= f1;
      localPointF.y -= f2;
    }
    f1 = ((PointF)paramList.get(9)).x;
    f2 = ((PointF)paramList.get(84)).x;
    float f3 = ((PointF)paramList.get(9)).y;
    float f4 = ((PointF)paramList.get(84)).y;
    f2 = (float)Math.atan2(f1 - f2, f3 - f4);
    f1 = (float)Math.cos(f2);
    f2 = (float)Math.sin(f2);
    localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localPointF = (PointF)((Iterator)localObject).next();
      f3 = localPointF.x;
      f4 = localPointF.y;
      localPointF.x = (f3 * f1 - f4 * f2);
      localPointF.y = (f3 * f2 + f4 * f1);
    }
    f1 = AlgoUtils.getDistance((PointF)paramList.get(99), (PointF)paramList.get(101));
    localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localPointF = (PointF)((Iterator)localObject).next();
      localPointF.x = (localPointF.x * paramFloat / f1);
      localPointF.y = (localPointF.y * paramFloat / f1);
    }
    paramFloat /= 2.0F;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (PointF)paramList.next();
      ((PointF)localObject).x += paramFloat;
      ((PointF)localObject).y += paramFloat;
    }
    AppMethodBeat.o(82450);
  }
  
  public void ApplyGLSLFilter()
  {
    AppMethodBeat.i(82452);
    super.ApplyGLSLFilter();
    if (this.mTransformFilter != null) {
      this.mTransformFilter.ApplyGLSLFilter();
    }
    Iterator localIterator = this.mStickerFilters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).ApplyGLSLFilter();
    }
    AppMethodBeat.o(82452);
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, h paramh)
  {
    AppMethodBeat.i(82454);
    paramh = this.mFrame;
    paramInt2 = FRAME_EDGE;
    paramh.a(-1, paramInt2, paramInt2, paramDouble);
    if (this.mIsFirstRender)
    {
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(16384);
    }
    this.mIsFirstRender = false;
    OnDrawFrameGLSL();
    paramInt2 = FRAME_EDGE;
    renderTexture(paramInt1, paramInt2, paramInt2);
    this.mResultFrame = this.mFrame;
    if (this.mTransformFilter != null)
    {
      paramh = this.mTransformFilter;
      paramInt1 = this.mFrame.texture[0];
      paramInt2 = FRAME_EDGE;
      paramh.RenderProcess(paramInt1, paramInt2, paramInt2, -1, paramDouble, this.mTFrame);
      this.mResultFrame = this.mTFrame;
    }
    AppMethodBeat.o(82454);
  }
  
  public void clearGLSLSelf()
  {
    AppMethodBeat.i(82455);
    if (this.mTransformFilter != null) {
      this.mTransformFilter.clearGLSLSelf();
    }
    Iterator localIterator = this.mStickerFilters.iterator();
    while (localIterator.hasNext()) {
      ((NormalVideoFilter)localIterator.next()).clearGLSLSelf();
    }
    this.mFrame.clear();
    this.mTFrame.clear();
    super.clearGLSLSelf();
    AppMethodBeat.o(82455);
  }
  
  public h getFrame()
  {
    return this.mFrame;
  }
  
  public List<NormalVideoFilter> getStickerFilters()
  {
    return this.mStickerFilters;
  }
  
  public void initAttribParams()
  {
    AppMethodBeat.i(82451);
    super.initAttribParams();
    addAttribParam("inputTextureCoordinate2", FaceOffUtil.initMaterialFaceTexCoords(FaceOffUtil.getFullCoords(FaceOffUtil.genPoints(this.mFaceItem.facePoints), 2.0F), this.mFaceItem.width, this.mFaceItem.height, this.grayVertices));
    if (this.mTransformFilter != null) {
      this.mTransformFilter.initAttribParams();
    }
    setDrawMode(GlUtil.DRAW_MODE.TRIANGLES);
    setCoordNum(690);
    AppMethodBeat.o(82451);
  }
  
  public void initParams()
  {
    AppMethodBeat.i(82448);
    addParam(new m.k("inputImageTexture2", FaceOffUtil.getFaceBitmap(this.mFaceFeatureItem.getDataPath() + File.separator + this.mFaceItem.faceExchangeImage), 33987, true));
    addParam(new m.j("posMatRotate", this.mt4));
    if (this.mTransformFilter != null) {
      this.mTransformFilter.initParams();
    }
    AppMethodBeat.o(82448);
  }
  
  public void reset()
  {
    AppMethodBeat.i(82459);
    Iterator localIterator = this.mStickerFilters.iterator();
    while (localIterator.hasNext()) {
      ((NormalVideoFilter)localIterator.next()).reset();
    }
    if (this.mTransformFilter != null) {
      this.mTransformFilter.reset();
    }
    AppMethodBeat.o(82459);
  }
  
  public boolean setRenderMode(int paramInt)
  {
    AppMethodBeat.i(82456);
    super.setRenderMode(paramInt);
    if (this.mTransformFilter != null) {
      this.mTransformFilter.setRenderMode(paramInt);
    }
    Iterator localIterator = this.mStickerFilters.iterator();
    while (localIterator.hasNext()) {
      ((NormalVideoFilter)localIterator.next()).setRenderMode(paramInt);
    }
    AppMethodBeat.o(82456);
    return true;
  }
  
  public void setStickerFilters(List<NormalVideoFilter> paramList)
  {
    AppMethodBeat.i(82457);
    this.mStickerFilters = paramList;
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((NormalVideoFilter)paramList.next()).item.support3D = 0;
    }
    AppMethodBeat.o(82457);
  }
  
  public void updatePreview(PTDetectInfo paramPTDetectInfo)
  {
    AppMethodBeat.i(82449);
    this.fullPositions = FaceOffUtil.getFullCoords(VideoMaterialUtil.copyList(paramPTDetectInfo.facePoints), 2.0F);
    addAttribParam("inputTextureCoordinate", FaceOffUtil.initMaterialFaceTexCoords(this.fullPositions, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.texVertices));
    updateFacePoints(this.fullPositions, FRAME_EDGE);
    List localList = this.fullPositions;
    int i = FRAME_EDGE;
    setPositions(FaceOffUtil.initFacePositions(localList, i, i, this.faceVertices));
    setCoordNum(690);
    if (this.mTransformFilter != null)
    {
      paramPTDetectInfo = new PTDetectInfo.Builder().facePoints(this.fullPositions).faceAngles(paramPTDetectInfo.faceAngles).faceActionCounter(paramPTDetectInfo.faceActionCounter).handPoints(paramPTDetectInfo.handPoints).handActionCounter(paramPTDetectInfo.handActionCounter).triggeredExpression(paramPTDetectInfo.triggeredExpression).phoneAngle(paramPTDetectInfo.phoneAngle).timestamp(paramPTDetectInfo.timestamp).build();
      this.mTransformFilter.updatePreview(paramPTDetectInfo);
    }
    AppMethodBeat.o(82449);
  }
  
  public void updateStickerFilterList(List<PointF> paramList, float[] paramArrayOfFloat, h paramh)
  {
    AppMethodBeat.i(82458);
    updatePreview(new PTDetectInfo.Builder().facePoints(paramList).faceAngles(paramArrayOfFloat).build());
    RenderProcess(paramh.texture[0], paramh.width, paramh.height, paramh.texture[0], 0.0D, paramh);
    paramList = this.mStickerFilters.iterator();
    while (paramList.hasNext())
    {
      paramArrayOfFloat = (NormalVideoFilter)paramList.next();
      if (!paramArrayOfFloat.needLoadImage())
      {
        float f2 = AlgoUtils.getDistance((PointF)this.fullPositions.get(paramArrayOfFloat.item.scalePivots[0]), (PointF)this.fullPositions.get(paramArrayOfFloat.item.scalePivots[1]));
        float f1 = paramArrayOfFloat.item.dx * f2 / paramArrayOfFloat.item.originalScaleFactor;
        float f3 = paramArrayOfFloat.item.dy * f2 / paramArrayOfFloat.item.originalScaleFactor;
        if ((paramArrayOfFloat.item.anchorPoint != null) && (paramArrayOfFloat.item.anchorPoint.length >= 2))
        {
          paramArrayOfFloat.item.anchorPoint[0] = ((int)(((PointF)this.fullPositions.get(this.mFaceFeatureItem.getMaskAnchorPoint())).x + f1));
          paramArrayOfFloat.item.anchorPoint[1] = ((int)(((PointF)this.fullPositions.get(this.mFaceFeatureItem.getMaskAnchorPoint())).y + f3));
        }
        paramArrayOfFloat.item.width = FRAME_EDGE;
        paramArrayOfFloat.item.height = FRAME_EDGE;
        paramh = paramArrayOfFloat.item;
        if (paramArrayOfFloat.item.scale <= 0.0F) {}
        for (f1 = 1.0F;; f1 = paramArrayOfFloat.item.scale)
        {
          paramh.scaleFactor = ((int)(f2 / f1));
          paramArrayOfFloat.updateTextureParam(this.mResultFrame.texture[0]);
          break;
        }
      }
    }
    AppMethodBeat.o(82458);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    AppMethodBeat.i(82453);
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    if (this.mTransformFilter != null)
    {
      localObject = this.mTransformFilter;
      int i = FRAME_EDGE;
      ((TransformFilter)localObject).updateVideoSize(i, i, 1.0D);
    }
    Object localObject = this.mStickerFilters.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((NormalVideoFilter)((Iterator)localObject).next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    AppMethodBeat.o(82453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.FacialFeatureFilter
 * JD-Core Version:    0.7.0.1
 */