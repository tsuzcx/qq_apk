package com.tencent.ttpic.util;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
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
    AppMethodBeat.i(84045);
    try
    {
      paramVarArgs = this.files;
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramVarArgs[i];
        FileUtils.deleteFiles(this.dir.getAbsolutePath(), ".png");
        localObject = new RandomAccessFile(((File)localObject).getAbsoluteFile(), "r");
        long l = ((RandomAccessFile)localObject).length();
        ((RandomAccessFile)localObject).seek(l - 4L);
        byte[] arrayOfByte = new byte[4];
        ((RandomAccessFile)localObject).read(arrayOfByte);
        int k = ByteUtil.readInt(arrayOfByte);
        if ((k <= 12) || (k >= 400))
        {
          ((RandomAccessFile)localObject).close();
          i += 1;
        }
        else
        {
          ((RandomAccessFile)localObject).seek(l - k + 8L);
          k = (k - 12) / 4;
          paramVarArgs = new int[k];
          i = 0;
          while (i < k)
          {
            ((RandomAccessFile)localObject).read(arrayOfByte);
            paramVarArgs[i] = ByteUtil.readInt(arrayOfByte);
            i += 1;
          }
          localObject = new ArrayList();
          i = 0;
          for (;;)
          {
            ((List)localObject).clear();
            j = 0;
            while (j < k)
            {
              if (paramVarArgs[j] == i) {
                ((List)localObject).add(this.dir.getAbsolutePath() + File.separator + VideoMaterialUtil.getMaterialId(this.dir.getAbsolutePath()) + "_" + j + ".png");
              }
              j += 1;
            }
            i += 1;
          }
        }
      }
      if (this.countDownLatch != null) {
        this.countDownLatch.countDown();
      }
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        VideoMaterialDecoder.access$000();
        if (this.countDownLatch != null) {
          this.countDownLatch.countDown();
        }
      }
    }
    finally
    {
      if (this.countDownLatch == null) {
        break label348;
      }
      this.countDownLatch.countDown();
      AppMethodBeat.o(84045);
    }
    paramVarArgs = Boolean.TRUE;
    AppMethodBeat.o(84045);
    return paramVarArgs;
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