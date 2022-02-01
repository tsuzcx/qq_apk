package com.tencent.tav.extractor.wrapper;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.extractor.AssetExtractor;

public class ExtractorLoader
{
  private static Handler loadHandler;
  private static HandlerThread loadThread;
  
  static
  {
    AppMethodBeat.i(218515);
    HandlerThread localHandlerThread = new HandlerThread("ExtractorLoader");
    loadThread = localHandlerThread;
    localHandlerThread.start();
    AppMethodBeat.o(218515);
  }
  
  public static void cacheExtractor(AssetExtractor paramAssetExtractor)
  {
    AppMethodBeat.i(218514);
    checkAndStart();
    loadHandler.post(new ExtractorLoaderRunnable(paramAssetExtractor));
    AppMethodBeat.o(218514);
  }
  
  public static void cacheExtractor(String paramString)
  {
    AppMethodBeat.i(218513);
    checkAndStart();
    loadHandler.post(new VideoPathLoaderRunnable(paramString));
    AppMethodBeat.o(218513);
  }
  
  private static void checkAndStart()
  {
    AppMethodBeat.i(218512);
    if ((loadHandler == null) && (loadThread.getLooper() != null)) {
      loadHandler = new Handler(loadThread.getLooper());
    }
    AppMethodBeat.o(218512);
  }
  
  static class ExtractorLoaderRunnable
    implements Runnable
  {
    private AssetExtractor extractor;
    
    ExtractorLoaderRunnable(AssetExtractor paramAssetExtractor)
    {
      this.extractor = paramAssetExtractor;
    }
    
    public void run()
    {
      AppMethodBeat.i(218510);
      if (!ExtractorWrapperPool.contains(this.extractor.getSourcePath()))
      {
        ExtractorWrapper localExtractorWrapper = new ExtractorWrapper(this.extractor.getSourcePath());
        localExtractorWrapper.checkAndLoad(this.extractor);
        ExtractorWrapperPool.put(localExtractorWrapper);
        this.extractor = null;
      }
      AppMethodBeat.o(218510);
    }
  }
  
  static class VideoPathLoaderRunnable
    implements Runnable
  {
    private String videoPath;
    
    VideoPathLoaderRunnable(String paramString)
    {
      this.videoPath = paramString;
    }
    
    public void run()
    {
      AppMethodBeat.i(218511);
      if (!ExtractorWrapperPool.contains(this.videoPath))
      {
        AssetExtractor localAssetExtractor = new AssetExtractor();
        localAssetExtractor.setDataSource(this.videoPath);
        ExtractorWrapper localExtractorWrapper = new ExtractorWrapper(this.videoPath);
        localExtractorWrapper.checkAndLoad(localAssetExtractor);
        ExtractorWrapperPool.put(localExtractorWrapper);
      }
      AppMethodBeat.o(218511);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.extractor.wrapper.ExtractorLoader
 * JD-Core Version:    0.7.0.1
 */