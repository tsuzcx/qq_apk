package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.filter.m.b;
import com.tencent.filter.m.f;
import com.tencent.filter.m.i;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.HandActionCounter;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VideoFlipFilter
  extends VideoFilterBase
{
  public static String FRAGMENT_SHADER = null;
  public static String VERTEX_SHADER = null;
  
  public VideoFlipFilter(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public static VideoFlipFilter createVideoFlipFilter()
  {
    if (TextUtils.isEmpty(VERTEX_SHADER)) {
      VERTEX_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FlipAndRotateVertexShader.dat").replace("\n", "");
    }
    if (TextUtils.isEmpty(FRAGMENT_SHADER)) {
      FRAGMENT_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FlipAndRotateFragmentShader.dat").replace("\n", "");
    }
    return new VideoFlipFilter(VERTEX_SHADER, FRAGMENT_SHADER);
  }
  
  public void ApplyGLSLFilter()
  {
    initParams();
    super.ApplyGLSLFilter();
    setTexCords(VideoFilterUtil.ORIGIN_TEX_COORDS);
    setPositions(VideoFilterUtil.ORIGIN_POSITION_COORDS);
  }
  
  public void initParams()
  {
    addParam(new m.i("texNeedTransform", -1));
    addParam(new m.b("canvasSize", 0.0F, 0.0F));
    addParam(new m.f("texRotate", 0.0F));
  }
  
  public void updatePreview(List<PointF> paramList1, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList2, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, float paramFloat, long paramLong) {}
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    addParam(new m.b("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.VideoFlipFilter
 * JD-Core Version:    0.7.0.1
 */