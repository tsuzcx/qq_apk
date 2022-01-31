package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.filter.m.a;
import com.tencent.filter.m.b;
import com.tencent.filter.m.f;
import com.tencent.filter.m.i;
import com.tencent.filter.m.k;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.HandActionCounter;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import com.tencent.ttpic.util.VideoUtil;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CustomVideoFilter
  extends VideoFilterBase
{
  private static final String TAG = CustomVideoFilter.class.getSimpleName();
  private float frameStartTime;
  private List<NormalVideoFilter> normalFilters;
  private VideoMaterialUtil.TRIGGER_TYPE triggerType;
  
  public CustomVideoFilter(String paramString1, String paramString2, List<String> paramList, VideoMaterialUtil.TRIGGER_TYPE paramTRIGGER_TYPE, String paramString3)
  {
    super(paramString1, paramString2);
    this.dataPath = paramString3;
    this.triggerType = paramTRIGGER_TYPE;
    if (this.triggerType == null) {
      this.triggerType = VideoMaterialUtil.TRIGGER_TYPE.UNKNOW;
    }
    initParams();
    initTextureParams(paramList);
  }
  
  private void initTextureParams(List<String> paramList)
  {
    if (VideoUtil.isEmpty(paramList)) {
      return;
    }
    int i = 0;
    label10:
    if (i < paramList.size())
    {
      localObject = (String)paramList.get(i);
      localObject = this.dataPath + File.separator + (String)localObject;
      if (!((String)localObject).startsWith("assets://")) {
        break label134;
      }
    }
    label134:
    for (Object localObject = VideoBitmapUtil.decodeSampleBitmapFromAssets(VideoGlobalContext.getContext(), VideoUtil.getRealPath((String)localObject), MediaConfig.VIDEO_IMAGE_WIDTH, MediaConfig.VIDEO_IMAGE_HEIGHT);; localObject = VideoBitmapUtil.decodeSampledBitmapFromFile((String)localObject, MediaConfig.VIDEO_IMAGE_WIDTH, MediaConfig.VIDEO_IMAGE_HEIGHT))
    {
      if (VideoBitmapUtil.isLegal((Bitmap)localObject)) {
        addParam(new m.k("inputImageTexture" + (i + 1), (Bitmap)localObject, 33985 + i, true));
      }
      i += 1;
      break label10;
      break;
    }
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    setTexCords(VideoFilterUtil.ORIGIN_TEX_COORDS);
    this.frameStartTime = ((float)System.currentTimeMillis());
  }
  
  public float[] getElementDurations(long paramLong)
  {
    if (VideoUtil.isEmpty(this.normalFilters)) {
      return new float[0];
    }
    float[] arrayOfFloat = new float[this.normalFilters.size()];
    int i = 0;
    while (i < this.normalFilters.size())
    {
      arrayOfFloat[i] = ((NormalVideoFilter)this.normalFilters.get(i)).getFrameDuration(paramLong);
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public void initParams()
  {
    addParam(new m.b(VideoFilterBase.SHADER_FIELD.CANVAS_SIZE.name, 0.0F, 0.0F));
    addParam(new m.b(VideoFilterBase.SHADER_FIELD.FACE_DETECT_IMAGE_SIZE.name, 0.0F, 0.0F));
    addParam(new m.a(VideoFilterBase.SHADER_FIELD.FACE_POINT.name, new float[0]));
    addParam(new m.i(VideoFilterBase.SHADER_FIELD.FACE_ACTION_TYPE.name, 0));
    addParam(new m.f(VideoFilterBase.SHADER_FIELD.FRAME_DURATION.name, 0.0F));
    addParam(new m.a(VideoFilterBase.SHADER_FIELD.ELEMENT_DURATIONS.name, new float[0]));
  }
  
  public void setNormalFilters(List<NormalVideoFilter> paramList)
  {
    this.normalFilters = paramList;
  }
  
  public void updatePreview(List<PointF> paramList1, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList2, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, float paramFloat, long paramLong)
  {
    int i = 0;
    if (paramSet.contains(Integer.valueOf(this.triggerType.value)))
    {
      i = this.triggerType.value;
      addParam(new m.i(VideoFilterBase.SHADER_FIELD.FACE_ACTION_TYPE.name, i));
      addParam(new m.f(VideoFilterBase.SHADER_FIELD.FRAME_DURATION.name, ((float)System.currentTimeMillis() - this.frameStartTime) / 1000.0F));
      if (paramList1 == null) {
        break label179;
      }
      paramList1 = VideoMaterialUtil.toFlatArray(paramList1);
      if (paramList1 != null) {
        addParam(new m.a(VideoFilterBase.SHADER_FIELD.FACE_POINT.name, VideoMaterialUtil.flipYPoints(paramList1, (int)(this.height * this.mFaceDetScale))));
      }
    }
    for (;;)
    {
      addParam(new m.a(VideoFilterBase.SHADER_FIELD.ELEMENT_DURATIONS.name, getElementDurations(paramLong)));
      return;
      if (!paramSet.contains(Integer.valueOf(VideoMaterialUtil.TRIGGER_TYPE.FACE_DETECT.value))) {
        break;
      }
      i = VideoMaterialUtil.TRIGGER_TYPE.FACE_DETECT.value;
      break;
      label179:
      paramList1 = new float['´'];
      i = 0;
      while (i < 180)
      {
        paramList1[i] = 0.0F;
        i += 1;
      }
      addParam(new m.a(VideoFilterBase.SHADER_FIELD.FACE_POINT.name, paramList1));
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    addParam(new m.b(VideoFilterBase.SHADER_FIELD.CANVAS_SIZE.name, paramInt1, paramInt2));
    addParam(new m.b(VideoFilterBase.SHADER_FIELD.FACE_DETECT_IMAGE_SIZE.name, (float)(this.width * this.mFaceDetScale), (float)(this.height * this.mFaceDetScale)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.filter.CustomVideoFilter
 * JD-Core Version:    0.7.0.1
 */