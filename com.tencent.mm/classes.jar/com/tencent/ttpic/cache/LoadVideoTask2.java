package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.common.VideoPngDecoder;
import com.tencent.ttpic.util.ByteUtil;
import com.tencent.ttpic.util.VideoBitmapUtil;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Map;

public class LoadVideoTask2
  extends AsyncTask<Void, Integer, Boolean>
{
  private static final String TAG = LoadVideoTask2.class.getSimpleName();
  private Map<String, Bitmap> cache;
  private final String dataPath;
  private final String itemId;
  private final String materialId;
  private final int sampleSize;
  
  public LoadVideoTask2(Map<String, Bitmap> paramMap, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.cache = paramMap;
    this.dataPath = paramString1;
    this.itemId = paramString2;
    this.materialId = paramString3;
    this.sampleSize = paramInt;
  }
  
  protected Boolean doInBackground(Void... paramVarArgs)
  {
    for (;;)
    {
      int i;
      int j;
      try
      {
        paramVarArgs = this.dataPath + File.separator + this.itemId + File.separator + this.itemId + ".mp4";
        RandomAccessFile localRandomAccessFile = new RandomAccessFile(paramVarArgs, "r");
        long l = localRandomAccessFile.length();
        localRandomAccessFile.seek(l - 4L);
        Object localObject = new byte[4];
        localRandomAccessFile.read((byte[])localObject);
        i = ByteUtil.readInt((byte[])localObject);
        if ((i <= 12) || (i >= 400))
        {
          localRandomAccessFile.close();
          return Boolean.valueOf(false);
        }
        localRandomAccessFile.seek(l - i + 8L);
        int k = (i - 12) / 4;
        int[] arrayOfInt = new int[k];
        i = 0;
        if (i < k)
        {
          localRandomAccessFile.read((byte[])localObject);
          arrayOfInt[i] = ByteUtil.readInt((byte[])localObject);
          i += 1;
          continue;
        }
        localObject = new VideoPngDecoder(paramVarArgs);
        i = 0;
        if (!((VideoPngDecoder)localObject).pG())
        {
          if (isCancelled()) {
            return Boolean.valueOf(false);
          }
          Bitmap localBitmap = ((VideoPngDecoder)localObject).dZ(this.sampleSize);
          j = 0;
          if (j >= k) {
            break label401;
          }
          if (arrayOfInt[j] != i) {
            break label394;
          }
          if (TextUtils.isEmpty(this.materialId))
          {
            paramVarArgs = this.itemId + "_" + j + ".png";
            if ((!VideoBitmapUtil.isLegal(localBitmap)) || (this.cache.containsKey(paramVarArgs))) {
              break label394;
            }
            this.cache.put(paramVarArgs, localBitmap);
            break label394;
          }
          paramVarArgs = this.materialId + File.separator + this.itemId + "_" + j + ".png";
          continue;
        }
        ((VideoPngDecoder)localObject).release();
        localRandomAccessFile.close();
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs = paramVarArgs;
        paramVarArgs.toString();
        continue;
      }
      finally {}
      return Boolean.valueOf(true);
      label394:
      j += 1;
      continue;
      label401:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.cache.LoadVideoTask2
 * JD-Core Version:    0.7.0.1
 */