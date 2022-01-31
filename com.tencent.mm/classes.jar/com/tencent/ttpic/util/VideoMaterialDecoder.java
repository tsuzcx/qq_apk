package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.thread.VideoThreadPool;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class VideoMaterialDecoder
{
  public static final String MATERIAL_PREFIX = "video_";
  private static final String TAG;
  private static VideoMaterialDecoder ins;
  private List<VideoMaterialDecoder.DecodeVideoTask> mTaskList;
  
  static
  {
    AppMethodBeat.i(84049);
    TAG = VideoMaterialDecoder.class.getSimpleName();
    ins = new VideoMaterialDecoder();
    AppMethodBeat.o(84049);
  }
  
  private VideoMaterialDecoder()
  {
    AppMethodBeat.i(84047);
    this.mTaskList = new ArrayList();
    AppMethodBeat.o(84047);
  }
  
  public static VideoMaterialDecoder getInstance()
  {
    return ins;
  }
  
  public void saveVideoMaterialToImages(String paramString)
  {
    AppMethodBeat.i(84048);
    Object localObject1 = VideoMaterialUtil.getMaterialId(paramString);
    if ((localObject1 == null) || (!((String)localObject1).startsWith("video_")))
    {
      AppMethodBeat.o(84048);
      return;
    }
    paramString = new File(paramString).listFiles();
    if (paramString == null)
    {
      AppMethodBeat.o(84048);
      return;
    }
    this.mTaskList.clear();
    int j = paramString.length;
    int i = 0;
    Object localObject2;
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
    if (this.mTaskList.size() == 0)
    {
      AppMethodBeat.o(84048);
      return;
    }
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
      AppMethodBeat.o(84048);
      return;
    }
    catch (InterruptedException paramString)
    {
      AppMethodBeat.o(84048);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoMaterialDecoder
 * JD-Core Version:    0.7.0.1
 */