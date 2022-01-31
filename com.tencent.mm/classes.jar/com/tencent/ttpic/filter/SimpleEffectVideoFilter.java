package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.filter.m.k;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.HandActionCounter;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoUtil;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SimpleEffectVideoFilter
  extends VideoFilterBase
{
  public static final String LOOKUP_TABLE_FILE_NAME = "filterEffect.lut";
  private String mDataPath;
  
  public SimpleEffectVideoFilter(String paramString)
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.LOOKUP);
    this.mDataPath = paramString;
    initParams();
  }
  
  public static Bitmap getBitmap(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("assets://"))) {}
    for (paramString = VideoBitmapUtil.decodeSampleBitmapFromAssets(VideoGlobalContext.getContext(), VideoUtil.getRealPath(paramString), 2147483647, 2147483647);; paramString = VideoBitmapUtil.decodeSampledBitmapFromFile(paramString, 2147483647, 2147483647))
    {
      String str = paramString;
      if (!VideoBitmapUtil.isLegal(paramString)) {
        str = null;
      }
      return str;
    }
  }
  
  public void initParams()
  {
    addParam(new m.k("inputImageTexture2", getBitmap(this.mDataPath + "/filterEffect.lut"), 33986, true));
  }
  
  public void updatePreview(List<PointF> paramList1, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList2, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, float paramFloat, long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.filter.SimpleEffectVideoFilter
 * JD-Core Version:    0.7.0.1
 */