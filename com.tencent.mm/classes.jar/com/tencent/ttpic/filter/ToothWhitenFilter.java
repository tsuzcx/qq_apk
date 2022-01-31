package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.faceBeauty.FaceParam;
import com.tencent.filter.m.f;
import com.tencent.filter.m.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import com.tencent.ttpic.util.FaceDetectUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ToothWhitenFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER;
  private static String LUT_FILE;
  private static final String MASK_COORDS = "assets://mask/coords/toothwhite.tsv";
  private static String MASK_FILE;
  private static final String TAG;
  private static final String VERTEX_SHADER;
  private FaceParam faceParam;
  private float[] faceVertices;
  private Bitmap inputWhiteBitmap;
  private Bitmap maskBitmap;
  private int maskHeight;
  private float[] maskTexCoords;
  private int maskWidth;
  private float whiteTeeth;
  
  static
  {
    AppMethodBeat.i(83019);
    TAG = ToothWhitenFilter.class.getSimpleName();
    VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ToothWhitenVertexShader.dat");
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ToothWhitenFragmentShader.dat");
    MASK_FILE = "assets://mask/images/toothmask.png";
    LUT_FILE = "assets://luts/teethLUT.png";
    AppMethodBeat.o(83019);
  }
  
  public ToothWhitenFilter(FaceParam paramFaceParam)
  {
    super(VERTEX_SHADER, FRAGMENT_SHADER);
    AppMethodBeat.i(83011);
    this.whiteTeeth = 0.0F;
    this.faceVertices = new float[1380];
    this.maskTexCoords = new float[1380];
    this.faceParam = paramFaceParam;
    initBitmaps();
    initParams();
    AppMethodBeat.o(83011);
  }
  
  private void initBitmaps()
  {
    AppMethodBeat.i(83016);
    this.maskBitmap = BitmapUtils.decodeSampledBitmapFromAssets(VideoGlobalContext.getContext(), FileUtils.getRealPath(MASK_FILE), 2147483647, 2147483647);
    if (this.maskBitmap != null)
    {
      this.maskWidth = this.maskBitmap.getWidth();
      this.maskHeight = this.maskBitmap.getHeight();
    }
    this.inputWhiteBitmap = BitmapUtils.decodeSampledBitmapFromAssets(VideoGlobalContext.getContext(), FileUtils.getRealPath(LUT_FILE), 2147483647, 2147483647);
    AppMethodBeat.o(83016);
  }
  
  private void initMaskCoords()
  {
    AppMethodBeat.i(83017);
    this.maskTexCoords = FaceOffUtil.initMaterialFaceTexCoords(FaceOffUtil.getFullCoords(FaceOffUtil.loadTexCoords("assets://mask/coords/toothwhite.tsv"), 2.0F), this.maskWidth, this.maskHeight, this.maskTexCoords);
    addAttribParam("inputTextureCoordinate", this.maskTexCoords, true);
    AppMethodBeat.o(83017);
  }
  
  private void initPositions(FaceParam paramFaceParam)
  {
    AppMethodBeat.i(83018);
    if (paramFaceParam == null)
    {
      AppMethodBeat.o(83018);
      return;
    }
    int[][] arrayOfInt = paramFaceParam.bsW;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < arrayOfInt.length)
    {
      localArrayList.add(new PointF(arrayOfInt[i][0], arrayOfInt[i][1]));
      i += 1;
    }
    FaceDetectUtil.facePointf83to90(localArrayList);
    setPositions(FaceOffUtil.initFacePositions(FaceOffUtil.getFullCoords(localArrayList, 2.0F), paramFaceParam.width, paramFaceParam.height, this.faceVertices));
    AppMethodBeat.o(83018);
  }
  
  public void clearGLSLSelf()
  {
    AppMethodBeat.i(83014);
    super.clearGLSLSelf();
    BitmapUtils.recycle(this.maskBitmap);
    BitmapUtils.recycle(this.inputWhiteBitmap);
    LogUtils.d(TAG, "[clearGLSLSelf] delete texture, recycle bmp");
    AppMethodBeat.o(83014);
  }
  
  public void initAttribParams()
  {
    AppMethodBeat.i(83013);
    setDrawMode(GlUtil.DRAW_MODE.TRIANGLES);
    setCoordNum(690);
    setRenderMode(2);
    initMaskCoords();
    initPositions(this.faceParam);
    AppMethodBeat.o(83013);
  }
  
  public void initParams()
  {
    AppMethodBeat.i(83012);
    addParam(new m.f("whiteTeeth", this.whiteTeeth));
    addParam(new m.k("inputMaskTexture", this.maskBitmap, 33986, true));
    addParam(new m.k("inputWhiteTeethLutTexture", this.inputWhiteBitmap, 33987, true));
    AppMethodBeat.o(83012);
  }
  
  public void setParam(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(83015);
    if (paramMap.containsKey("whiteTeeth")) {
      this.whiteTeeth = ((Float)paramMap.get("whiteTeeth")).floatValue();
    }
    this.whiteTeeth /= 200.0F;
    addParam(new m.f("whiteTeeth", this.whiteTeeth));
    AppMethodBeat.o(83015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.filter.ToothWhitenFilter
 * JD-Core Version:    0.7.0.1
 */