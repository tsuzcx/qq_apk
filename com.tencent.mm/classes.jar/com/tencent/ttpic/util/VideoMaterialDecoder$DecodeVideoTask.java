package com.tencent.ttpic.util;

import android.os.AsyncTask;
import com.tencent.common.VideoPngDecoder;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

class VideoMaterialDecoder$DecodeVideoTask
  extends AsyncTask<Void, Integer, Boolean>
{
  private CountDownLatch countDownLatch;
  private final File dir;
  private final File[] files;
  
  public VideoMaterialDecoder$DecodeVideoTask(File paramFile, File[] paramArrayOfFile)
  {
    this.dir = paramFile;
    this.files = paramArrayOfFile;
  }
  
  protected Boolean doInBackground(Void... paramVarArgs)
  {
    for (;;)
    {
      int i;
      int k;
      try
      {
        paramVarArgs = this.files;
        int m = paramVarArgs.length;
        i = 0;
        if (i < m)
        {
          Object localObject1 = paramVarArgs[i];
          VideoFileUtil.deleteFiles(this.dir.getAbsolutePath(), ".png");
          RandomAccessFile localRandomAccessFile = new RandomAccessFile(((File)localObject1).getAbsoluteFile(), "r");
          long l = localRandomAccessFile.length();
          localRandomAccessFile.seek(l - 4L);
          Object localObject2 = new byte[4];
          localRandomAccessFile.read((byte[])localObject2);
          int j = ByteUtil.readInt((byte[])localObject2);
          if ((j <= 12) || (j >= 400))
          {
            localRandomAccessFile.close();
          }
          else
          {
            localRandomAccessFile.seek(l - j + 8L);
            int n = (j - 12) / 4;
            int[] arrayOfInt = new int[n];
            j = 0;
            if (j < n)
            {
              localRandomAccessFile.read((byte[])localObject2);
              arrayOfInt[j] = ByteUtil.readInt((byte[])localObject2);
              j += 1;
              continue;
            }
            localObject1 = new VideoPngDecoder(((File)localObject1).getAbsolutePath());
            localObject2 = new ArrayList();
            k = 0;
            j = 0;
            if (k == 0)
            {
              ((List)localObject2).clear();
              k = 0;
              if (k < n)
              {
                if (arrayOfInt[k] != j) {
                  break label391;
                }
                ((List)localObject2).add(this.dir.getAbsolutePath() + File.separator + VideoMaterialUtil.getMaterialId(this.dir.getAbsolutePath()) + "_" + k + ".png");
                break label391;
              }
              k = ((VideoPngDecoder)localObject1).w((List)localObject2);
              j += 1;
              continue;
            }
            ((VideoPngDecoder)localObject1).release();
            localRandomAccessFile.close();
          }
        }
      }
      catch (Exception paramVarArgs)
      {
        VideoMaterialDecoder.access$000();
        paramVarArgs.toString();
        return Boolean.valueOf(true);
        if (this.countDownLatch == null) {
          continue;
        }
        this.countDownLatch.countDown();
        continue;
      }
      finally
      {
        if (this.countDownLatch != null) {
          this.countDownLatch.countDown();
        }
      }
      i += 1;
      continue;
      label391:
      k += 1;
    }
  }
  
  public void setCountDownLatch(CountDownLatch paramCountDownLatch)
  {
    this.countDownLatch = paramCountDownLatch;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoMaterialDecoder.DecodeVideoTask
 * JD-Core Version:    0.7.0.1
 */