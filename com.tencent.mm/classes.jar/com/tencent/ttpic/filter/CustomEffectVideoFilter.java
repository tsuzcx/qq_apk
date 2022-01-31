package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.filter.m.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.model.VideoFilterEffect;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.io.File;
import java.util.List;

public class CustomEffectVideoFilter
  extends VideoEffectFilterBase
{
  private static final String TAG;
  private List<String> mResourceList;
  
  static
  {
    AppMethodBeat.i(82137);
    TAG = CustomVideoFilter.class.getSimpleName();
    AppMethodBeat.o(82137);
  }
  
  public CustomEffectVideoFilter(String paramString1, String paramString2, List<String> paramList, String paramString3, VideoFilterEffect paramVideoFilterEffect)
  {
    super(paramString1, paramString2, paramVideoFilterEffect);
    AppMethodBeat.i(82135);
    this.dataPath = paramString3;
    this.mResourceList = paramList;
    initInputImageTexture();
    AppMethodBeat.o(82135);
  }
  
  public void initInputImageTexture()
  {
    AppMethodBeat.i(82136);
    if (BaseUtils.isEmpty(this.mResourceList))
    {
      AppMethodBeat.o(82136);
      return;
    }
    int i = 0;
    if (i < this.mResourceList.size())
    {
      Object localObject = (String)this.mResourceList.get(i);
      localObject = this.dataPath + File.separator + (String)localObject;
      if (((String)localObject).startsWith("assets://")) {}
      for (localObject = BitmapUtils.decodeSampledBitmapFromAssets(VideoGlobalContext.getContext(), FileUtils.getRealPath((String)localObject), MediaConfig.VIDEO_IMAGE_WIDTH, MediaConfig.VIDEO_IMAGE_HEIGHT);; localObject = BitmapUtils.decodeSampledBitmapFromFile((String)localObject, MediaConfig.VIDEO_IMAGE_WIDTH, MediaConfig.VIDEO_IMAGE_HEIGHT))
      {
        if (BitmapUtils.isLegal((Bitmap)localObject)) {
          addParam(new m.k("inputImageTexture" + (i + 2), (Bitmap)localObject, 33986 + i, true));
        }
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(82136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.filter.CustomEffectVideoFilter
 * JD-Core Version:    0.7.0.1
 */