package com.tencent.ttpic.util;

import com.tencent.ttpic.thread.VideoThreadPool;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class VideoMaterialDecoder
{
  public static final String MATERIAL_PREFIX = "video_";
  private static final String TAG = VideoMaterialDecoder.class.getSimpleName();
  private static VideoMaterialDecoder ins = new VideoMaterialDecoder();
  private List<VideoMaterialDecoder.DecodeVideoTask> mTaskList = new ArrayList();
  
  public static VideoMaterialDecoder getInstance()
  {
    return ins;
  }
  
  public void saveVideoMaterialToImages(String paramString)
  {
    Object localObject1 = VideoMaterialUtil.getMaterialId(paramString);
    if ((localObject1 == null) || (!((String)localObject1).startsWith("video_"))) {}
    Object localObject2;
    do
    {
      do
      {
        return;
        paramString = new File(paramString).listFiles();
      } while (paramString == null);
      this.mTaskList.clear();
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        localObject1 = paramString[i];
        if (((File)localObject1).isDirectory())
        {
          localObject2 = ((File)localObject1).listFiles(new VideoMaterialDecoder.1(this));
          if (localObject2 != null) {
            this.mTaskList.add(new VideoMaterialDecoder.DecodeVideoTask((File)localObject1, (File[])localObject2));
          }
        }
        i += 1;
      }
    } while (this.mTaskList.size() == 0);
    paramString = new CountDownLatch(this.mTaskList.size());
    localObject1 = this.mTaskList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (VideoMaterialDecoder.DecodeVideoTask)((Iterator)localObject1).next();
      ((VideoMaterialDecoder.DecodeVideoTask)localObject2).setCountDownLatch(paramString);
      ((VideoMaterialDecoder.DecodeVideoTask)localObject2).executeOnExecutor(VideoThreadPool.getInstance().getDualThreadExecutor(), new Void[0]);
    }
    try
    {
      paramString.await();
      return;
    }
    catch (InterruptedException paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoMaterialDecoder
 * JD-Core Version:    0.7.0.1
 */