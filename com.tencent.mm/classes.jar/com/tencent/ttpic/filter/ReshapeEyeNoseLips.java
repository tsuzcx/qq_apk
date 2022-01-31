package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;
import java.util.Map;

public class ReshapeEyeNoseLips
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER_V;
  public static final String VERTEX_SHADER_V;
  private static final int XCOORD_NUM = 128;
  private static final int YCOORD_NUM = 128;
  private float[] angles;
  private float eyebrowDistance;
  private float eyebrowHeight;
  private float eyebrowTiltAngle;
  private float eyesDistance;
  private float eyesHeight;
  private float eyesSize;
  private float eyesTiltAngle;
  private float eyesWidth;
  private float[] leftEyeCenter;
  private float[] leftEyePlainSize;
  private float[] leftEyebrowCenter;
  private float[] leftEyebrowPlainSize;
  private float[] lipsCenter;
  private float lipsHeight;
  private float[] lipsPlainSize;
  private float lipsProtectAngleLeft;
  private float lipsProtectAngleRight;
  private float[] lipsProtectCenterLeft;
  private float[] lipsProtectCenterRight;
  private float[] lipsProtectSizeLeft;
  private float[] lipsProtectSizeRight;
  private float lipsSize;
  private float lipsWidth;
  private float lipsYPosition;
  private List<PointF> mFullscreenVerticesPortrait;
  private List<PointF> mInitTextureCoordinatesPortrait;
  private float meshType;
  private float[] nose3DCenter;
  private float[] noseBottomCenter;
  private float noseBridgeWidth;
  private float noseOutlineWidth;
  private float[] nosePlainSize;
  private float nosePosition;
  private float noseSize;
  private float[] noseTipCenter;
  private float[] noseTipPlaneSize;
  private float noseTipSize;
  private float[] rightEyeCenter;
  private float[] rightEyePlainSize;
  private float[] rightEyebrowCenter;
  private float[] rightEyebrowPlainSize;
  private float[] size;
  
  static
  {
    AppMethodBeat.i(82765);
    VERTEX_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeNoseLipsVertexShader_v.glsl");
    FRAGMENT_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader_v.dat");
    AppMethodBeat.o(82765);
  }
  
  public ReshapeEyeNoseLips(int paramInt)
  {
    super(VERTEX_SHADER_V, FRAGMENT_SHADER_V);
    AppMethodBeat.i(82760);
    this.mFullscreenVerticesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0F, 1.0F, 0.0F, 1.0F);
    this.mInitTextureCoordinatesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0F, 1.0F, 0.0F, 1.0F);
    this.leftEyebrowPlainSize = new float[] { 0.0F, 0.0F };
    this.leftEyebrowCenter = new float[] { 0.0F, 0.0F };
    this.rightEyebrowPlainSize = new float[] { 0.0F, 0.0F };
    this.rightEyebrowCenter = new float[] { 0.0F, 0.0F };
    this.leftEyePlainSize = new float[] { 0.0F, 0.0F };
    this.leftEyeCenter = new float[] { 0.0F, 0.0F };
    this.rightEyePlainSize = new float[] { 0.0F, 0.0F };
    this.rightEyeCenter = new float[] { 0.0F, 0.0F };
    this.nose3DCenter = new float[] { 0.0F, 0.0F };
    this.nosePlainSize = new float[] { 0.0F, 0.0F };
    this.noseTipCenter = new float[] { 0.0F, 0.0F };
    this.noseBottomCenter = new float[] { 0.0F, 0.0F };
    this.noseTipPlaneSize = new float[] { 0.0F, 0.0F };
    this.lipsCenter = new float[] { 0.0F, 0.0F };
    this.lipsPlainSize = new float[] { 0.0F, 0.0F };
    this.lipsProtectSizeLeft = new float[] { 0.0F, 0.0F };
    this.lipsProtectCenterLeft = new float[] { 0.0F, 0.0F };
    this.lipsProtectAngleLeft = 0.0F;
    this.lipsProtectSizeRight = new float[] { 0.0F, 0.0F };
    this.lipsProtectCenterRight = new float[] { 0.0F, 0.0F };
    this.lipsProtectAngleRight = 0.0F;
    this.eyebrowHeight = 0.0F;
    this.eyebrowDistance = 1.0F;
    this.eyebrowTiltAngle = 0.0F;
    this.eyesWidth = 0.0F;
    this.eyesHeight = 0.0F;
    this.eyesSize = 0.1F;
    this.eyesTiltAngle = 0.0F;
    this.eyesDistance = 1.0F;
    this.noseSize = 0.0F;
    this.noseOutlineWidth = 0.0F;
    this.noseBridgeWidth = 0.1F;
    this.nosePosition = 0.0F;
    this.noseTipSize = 1.0F;
    this.lipsSize = 0.0F;
    this.lipsWidth = 0.0F;
    this.lipsHeight = 0.0F;
    this.lipsYPosition = 0.0F;
    this.angles = new float[] { 0.0F, 0.0F, 0.0F };
    this.size = new float[] { 1.0F, 1.0F };
    this.meshType = 0.0F;
    if (paramInt == 0) {}
    for (this.meshType = 0.5F;; this.meshType = 0.0F)
    {
      initParams();
      AppMethodBeat.o(82760);
      return;
    }
  }
  
  public void ApplyGLSLFilter()
  {
    AppMethodBeat.i(82763);
    initParams();
    super.ApplyGLSLFilter();
    setDrawMode(GlUtil.DRAW_MODE.TRIANGLE_STRIP);
    AppMethodBeat.o(82763);
  }
  
  public void initAttribParams()
  {
    AppMethodBeat.i(82762);
    setPositions(VideoMaterialUtil.toFlatArray((PointF[])this.mFullscreenVerticesPortrait.toArray(new PointF[0])), false);
    setTexCords(VideoMaterialUtil.toFlatArray((PointF[])this.mInitTextureCoordinatesPortrait.toArray(new PointF[0])), false);
    setCoordNum(32897);
    AppMethodBeat.o(82762);
  }
  
  public void initParams()
  {
    AppMethodBeat.i(82761);
    addParam(new m.g("leftEyePlainSize", this.leftEyePlainSize));
    addParam(new m.g("leftEyeCenter", this.leftEyeCenter));
    addParam(new m.g("rightEyePlainSize", this.rightEyePlainSize));
    addParam(new m.g("rightEyeCenter", this.rightEyeCenter));
    addParam(new m.g("leftEyebrowPlainSize", this.leftEyebrowPlainSize));
    addParam(new m.g("leftEyebrowCenter", this.leftEyebrowCenter));
    addParam(new m.g("rightEyebrowPlainSize", this.rightEyebrowPlainSize));
    addParam(new m.g("rightEyebrowCenter", this.rightEyebrowCenter));
    addParam(new m.g("nose3DCenter", this.nose3DCenter));
    addParam(new m.g("nosePlainSize", this.nosePlainSize));
    addParam(new m.g("noseTipCenter", this.noseTipCenter));
    addParam(new m.g("noseTipPlaneSize", this.noseTipPlaneSize));
    addParam(new m.g("noseBottomCenter", this.noseBottomCenter));
    addParam(new m.g("lipsCenter", this.lipsCenter));
    addParam(new m.g("lipsPlainSize", this.lipsPlainSize));
    addParam(new m.g("lipsProtectSizeLeft", this.lipsProtectSizeLeft));
    addParam(new m.g("lipsProtectCenterLeft", this.lipsProtectCenterLeft));
    addParam(new m.f("lipsProtectAngleLeft", this.lipsProtectAngleLeft));
    addParam(new m.g("lipsProtectSizeRight", this.lipsProtectSizeRight));
    addParam(new m.g("lipsProtectCenterRight", this.lipsProtectCenterRight));
    addParam(new m.f("lipsProtectAngleRight", this.lipsProtectAngleRight));
    addParam(new m.f("eyebrowHeight", this.eyebrowHeight));
    addParam(new m.f("eyebrowDistance", this.eyebrowDistance));
    addParam(new m.f("eyebrowTiltAngle", this.eyebrowTiltAngle));
    addParam(new m.f("eyesSize", this.eyesSize));
    addParam(new m.f("eyesWidth", this.eyesWidth));
    addParam(new m.f("eyesHeight", this.eyesHeight));
    addParam(new m.f("eyesTiltAngle", this.eyesTiltAngle));
    addParam(new m.f("eyesDistance", this.eyesDistance));
    addParam(new m.f("noseSize", this.noseSize));
    addParam(new m.f("noseOutlineWidth", this.noseOutlineWidth));
    addParam(new m.f("noseBridgeWidth", this.noseBridgeWidth));
    addParam(new m.f("nosePosition", this.nosePosition));
    addParam(new m.f("noseTipSize", this.noseTipSize));
    addParam(new m.f("lipsSize", this.lipsSize));
    addParam(new m.f("lipsWidth", this.lipsWidth));
    addParam(new m.f("lipsHeight", this.lipsHeight));
    addParam(new m.f("lipsYPosition", this.lipsYPosition));
    addParam(new m.g("angles", this.angles));
    addParam(new m.g("size", this.size));
    addParam(new m.f("meshType", this.meshType));
    float f = (float)Math.cos(this.angles[2]);
    addParam(new m.f("sin_t", (float)Math.sin(this.angles[2])));
    addParam(new m.f("cos_t", f));
    AppMethodBeat.o(82761);
  }
  
  public void setParam(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(82764);
    if (paramMap.containsKey("leftEyebrowPlainSize")) {
      this.leftEyebrowPlainSize = ((float[])paramMap.get("leftEyebrowPlainSize"));
    }
    if (paramMap.containsKey("leftEyebrowCenter")) {
      this.leftEyebrowCenter = ((float[])paramMap.get("leftEyebrowCenter"));
    }
    if (paramMap.containsKey("rightEyebrowPlainSize")) {
      this.rightEyebrowPlainSize = ((float[])paramMap.get("rightEyebrowPlainSize"));
    }
    if (paramMap.containsKey("rightEyebrowCenter")) {
      this.rightEyebrowCenter = ((float[])paramMap.get("rightEyebrowCenter"));
    }
    if (paramMap.containsKey("leftEyePlainSize")) {
      this.leftEyePlainSize = ((float[])paramMap.get("leftEyePlainSize"));
    }
    if (paramMap.containsKey("leftEyeCenter")) {
      this.leftEyeCenter = ((float[])paramMap.get("leftEyeCenter"));
    }
    if (paramMap.containsKey("rightEyePlainSize")) {
      this.rightEyePlainSize = ((float[])paramMap.get("rightEyePlainSize"));
    }
    if (paramMap.containsKey("rightEyeCenter")) {
      this.rightEyeCenter = ((float[])paramMap.get("rightEyeCenter"));
    }
    if (paramMap.containsKey("nose3DCenter")) {
      this.nose3DCenter = ((float[])paramMap.get("nose3DCenter"));
    }
    if (paramMap.containsKey("nosePlainSize")) {
      this.nosePlainSize = ((float[])paramMap.get("nosePlainSize"));
    }
    if (paramMap.containsKey("noseTipCenter")) {
      this.noseTipCenter = ((float[])paramMap.get("noseTipCenter"));
    }
    if (paramMap.containsKey("noseTipPlaneSize")) {
      this.noseTipPlaneSize = ((float[])paramMap.get("noseTipPlaneSize"));
    }
    if (paramMap.containsKey("noseBottomCenter")) {
      this.noseBottomCenter = ((float[])paramMap.get("noseBottomCenter"));
    }
    if (paramMap.containsKey("lipsCenter")) {
      this.lipsCenter = ((float[])paramMap.get("lipsCenter"));
    }
    if (paramMap.containsKey("lipsPlainSize")) {
      this.lipsPlainSize = ((float[])paramMap.get("lipsPlainSize"));
    }
    if (paramMap.containsKey("lipsProtectSizeLeft")) {
      this.lipsProtectSizeLeft = ((float[])paramMap.get("lipsProtectSizeLeft"));
    }
    if (paramMap.containsKey("lipsProtectCenterLeft")) {
      this.lipsProtectCenterLeft = ((float[])paramMap.get("lipsProtectCenterLeft"));
    }
    if (paramMap.containsKey("lipsProtectAngleLeft")) {
      this.lipsProtectAngleLeft = ((Float)paramMap.get("lipsProtectAngleLeft")).floatValue();
    }
    if (paramMap.containsKey("lipsProtectSizeRight")) {
      this.lipsProtectSizeRight = ((float[])paramMap.get("lipsProtectSizeRight"));
    }
    if (paramMap.containsKey("lipsProtectCenterRight")) {
      this.lipsProtectCenterRight = ((float[])paramMap.get("lipsProtectCenterRight"));
    }
    if (paramMap.containsKey("lipsProtectAngleRight")) {
      this.lipsProtectAngleRight = ((Float)paramMap.get("lipsProtectAngleRight")).floatValue();
    }
    if (paramMap.containsKey("eyebrowHeight")) {
      this.eyebrowHeight = (((Float)paramMap.get("eyebrowHeight")).floatValue() * 0.006F);
    }
    if (paramMap.containsKey("eyebrowDistance")) {
      this.eyebrowDistance = (((Float)paramMap.get("eyebrowDistance")).floatValue() * 0.009F);
    }
    if (paramMap.containsKey("eyebrowAngle")) {
      this.eyebrowTiltAngle = (((Float)paramMap.get("eyebrowAngle")).floatValue() * 0.0017F);
    }
    if (paramMap.containsKey("eyesWidth")) {
      this.eyesWidth = (((Float)paramMap.get("eyesWidth")).floatValue() * -0.003F);
    }
    if (paramMap.containsKey("eyesHeight")) {
      this.eyesHeight = (((Float)paramMap.get("eyesHeight")).floatValue() * -0.004F);
    }
    if (paramMap.containsKey("eyesSize")) {
      this.eyesSize = (((Float)paramMap.get("eyesSize")).floatValue() * -0.0032F);
    }
    if (paramMap.containsKey("eyesTiltAngle")) {
      this.eyesTiltAngle = (((Float)paramMap.get("eyesTiltAngle")).floatValue() * 0.001F);
    }
    if (paramMap.containsKey("eyesDistance")) {
      this.eyesDistance = (((Float)paramMap.get("eyesDistance")).floatValue() * 0.016F);
    }
    if (paramMap.containsKey("noseSize")) {
      this.noseSize = (((Float)paramMap.get("noseSize")).floatValue() * 0.006F);
    }
    if (paramMap.containsKey("noseOutlineWidth")) {
      this.noseOutlineWidth = (((Float)paramMap.get("noseOutlineWidth")).floatValue() * 0.01F);
    }
    if (paramMap.containsKey("noseBridgeWidth")) {
      this.noseBridgeWidth = (((Float)paramMap.get("noseBridgeWidth")).floatValue() * 0.008F);
    }
    if (paramMap.containsKey("nosePosition")) {
      this.nosePosition = (((Float)paramMap.get("nosePosition")).floatValue() * 0.008F);
    }
    if (paramMap.containsKey("noseTipSize")) {
      this.noseTipSize = (((Float)paramMap.get("noseTipSize")).floatValue() * -0.02F);
    }
    if (paramMap.containsKey("lipsSize")) {
      this.lipsSize = (((Float)paramMap.get("lipsSize")).floatValue() * -0.003F);
    }
    if (paramMap.containsKey("lipsHeight")) {
      this.lipsHeight = (((Float)paramMap.get("lipsHeight")).floatValue() * -0.008F);
    }
    if (paramMap.containsKey("lipsWidth"))
    {
      this.lipsWidth = (((Float)paramMap.get("lipsWidth")).floatValue() * -0.0038F);
      if (this.lipsWidth < 0.0F) {
        this.lipsWidth *= 0.8F;
      }
    }
    if (paramMap.containsKey("lipsYPosition"))
    {
      this.lipsYPosition = (((Float)paramMap.get("lipsYPosition")).floatValue() * -0.01F);
      if (this.lipsYPosition < 0.0F) {
        this.lipsYPosition *= 1.4F;
      }
    }
    if (paramMap.containsKey("angles")) {
      this.angles = ((float[])paramMap.get("angles"));
    }
    if (paramMap.containsKey("size")) {
      this.size = ((float[])paramMap.get("size"));
    }
    initParams();
    AppMethodBeat.o(82764);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.filter.ReshapeEyeNoseLips
 * JD-Core Version:    0.7.0.1
 */