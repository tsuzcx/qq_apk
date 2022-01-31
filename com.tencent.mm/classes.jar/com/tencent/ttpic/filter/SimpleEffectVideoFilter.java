package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.filter.m.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.util.VideoGlobalContext;

public class SimpleEffectVideoFilter
  extends VideoFilterBase
{
  public static final String LOOKUP_TABLE_FILE_NAME = "filterEffect.lut";
  private String mDataPath;
  
  public SimpleEffectVideoFilter(String paramString)
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.LOOKUP);
    AppMethodBeat.i(82855);
    this.mDataPath = paramString;
    initParams();
    AppMethodBeat.o(82855);
  }
  
  public static Bitmap getBitmap(String paramString)
  {
    AppMethodBeat.i(82857);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("assets://"))) {}
    for (paramString = BitmapUtils.decodeSampledBitmapFromAssets(VideoGlobalContext.getContext(), FileUtils.getRealPath(paramString), 2147483647, 2147483647); !BitmapUtils.isLegal(paramString); paramString = BitmapUtils.decodeSampledBitmapFromFile(paramString, 2147483647, 2147483647))
    {
      AppMethodBeat.o(82857);
      return null;
    }
    AppMethodBeat.o(82857);
    return paramString;
  }
  
  public void initParams()
  {
    AppMethodBeat.i(82856);
    addParam(new m.k("inputImageTexture2", getBitmap(this.mDataPath + "/filterEffect.lut"), 33986, true));
    AppMethodBeat.o(82856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.filter.SimpleEffectVideoFilter
 * JD-Core Version:    0.7.0.1
 */