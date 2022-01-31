package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.common.VideoPngDecoder;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.util.Map;

public class LoadVideoTask
  extends AsyncTask<Void, Integer, Boolean>
{
  private static final String TAG = LoadVideoTask.class.getSimpleName();
  private Map<String, Bitmap> cache;
  private final String dataPath;
  private final String itemId;
  private final String materialId;
  private final int sampleSize;
  private final String subFolder;
  
  public LoadVideoTask(Map<String, Bitmap> paramMap, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    this.cache = paramMap;
    this.dataPath = paramString1;
    this.subFolder = paramString2;
    this.itemId = paramString3;
    this.materialId = paramString4;
    this.sampleSize = paramInt;
  }
  
  protected Boolean doInBackground(Void... paramVarArgs)
  {
    try
    {
      paramVarArgs = this.dataPath + File.separator + this.subFolder + File.separator + this.itemId + ".mp4";
      arrayOfInt = VideoMaterialUtil.getVideoIndexMap(paramVarArgs);
      localVideoPngDecoder = new VideoPngDecoder(paramVarArgs);
      i = 0;
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        int[] arrayOfInt;
        VideoPngDecoder localVideoPngDecoder;
        int i;
        Bitmap localBitmap;
        int j;
        paramVarArgs.toString();
        continue;
        j += 1;
        continue;
        label263:
        i += 1;
      }
    }
    if ((!localVideoPngDecoder.pG()) && (!isCancelled()))
    {
      localBitmap = localVideoPngDecoder.dZ(this.sampleSize);
      j = 0;
      if (j >= arrayOfInt.length) {
        break label263;
      }
      if (arrayOfInt[j] == i)
      {
        if (TextUtils.isEmpty(this.materialId)) {}
        for (paramVarArgs = this.itemId + "_" + i + ".png"; (VideoBitmapUtil.isLegal(localBitmap)) && (!this.cache.containsKey(paramVarArgs)); paramVarArgs = this.materialId + File.separator + this.itemId + "_" + i + ".png")
        {
          this.cache.put(paramVarArgs, localBitmap);
          break;
        }
      }
    }
    else
    {
      localVideoPngDecoder.release();
      return Boolean.valueOf(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.cache.LoadVideoTask
 * JD-Core Version:    0.7.0.1
 */