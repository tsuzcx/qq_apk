package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.NativeLibs;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.Arrays;

public class NativeDataSourceFactory
{
  private static final String TAG = "NativeDataSourceFactory";
  private static final boolean soLoaded;
  
  static
  {
    boolean bool = NativeLibs.loadAll(Arrays.asList(new NativeLibs[] { NativeLibs.audioCommon, NativeLibs.formatDetector, NativeLibs.codecFactory, NativeLibs.decoderJni }));
    soLoaded = bool;
    if (!bool) {
      Logger.e("NativeDataSourceFactory", "[static initializer] failed to load so!");
    }
  }
  
  public static INativeDataSource fileDataSource(String paramString)
  {
    new INativeDataSource()
    {
      public final AudioFormat.AudioType getAudioType()
      {
        return null;
      }
      
      public final long getNativeInstance()
      {
        if (NativeDataSourceFactory.soLoaded) {
          try
          {
            long l = NativeDataSourceFactory.localFile(this.val$filePath);
            return l;
          }
          catch (Throwable localThrowable)
          {
            Logger.e("NativeDataSourceFactory", "[getNativeInstance] failed to create native data source!", localThrowable);
            return 0L;
          }
        }
        Logger.w("NativeDataSourceFactory", "[getNativeInstance] so not loaded properly!");
        return 0L;
      }
    };
  }
  
  public static native long localFile(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.NativeDataSourceFactory
 * JD-Core Version:    0.7.0.1
 */