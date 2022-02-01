package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(114305);
    boolean bool = NativeLibs.loadAll(Arrays.asList(new NativeLibs[] { NativeLibs.audioCommon, NativeLibs.formatDetector, NativeLibs.codecFactory, NativeLibs.decoderJni, NativeLibs.cppShared, NativeLibs.stlportShared, NativeLibs.xlog, NativeLibs.FFmpeg }));
    soLoaded = bool;
    if (!bool) {
      Logger.e("NativeDataSourceFactory", "[static initializer] failed to load so!");
    }
    AppMethodBeat.o(114305);
  }
  
  public static INativeDataSource fileDataSource(String paramString)
  {
    AppMethodBeat.i(114303);
    paramString = new INativeDataSource()
    {
      public final AudioFormat.AudioType getAudioType()
      {
        return null;
      }
      
      public final long getNativeInstance()
      {
        AppMethodBeat.i(114298);
        if (NativeDataSourceFactory.soLoaded) {
          try
          {
            long l = NativeDataSourceFactory.localFile(this.val$filePath, 0);
            AppMethodBeat.o(114298);
            return l;
          }
          catch (Throwable localThrowable)
          {
            Logger.e("NativeDataSourceFactory", "[getNativeInstance] failed to create native data source!", localThrowable);
            AppMethodBeat.o(114298);
            return 0L;
          }
        }
        Logger.w("NativeDataSourceFactory", "[getNativeInstance] so not loaded properly!");
        AppMethodBeat.o(114298);
        return 0L;
      }
    };
    AppMethodBeat.o(114303);
    return paramString;
  }
  
  public static INativeDataSource fileDataSource(String paramString, final int paramInt)
  {
    AppMethodBeat.i(114304);
    paramString = new INativeDataSource()
    {
      public final AudioFormat.AudioType getAudioType()
      {
        return null;
      }
      
      public final long getNativeInstance()
      {
        AppMethodBeat.i(114306);
        if (NativeDataSourceFactory.soLoaded) {
          try
          {
            String str = this.val$filePath;
            if (paramInt > 0) {}
            for (int i = 1;; i = 0)
            {
              long l = NativeDataSourceFactory.localFile(str, i);
              AppMethodBeat.o(114306);
              return l;
            }
            Logger.w("NativeDataSourceFactory", "[getNativeInstance] so not loaded properly!");
          }
          catch (Throwable localThrowable)
          {
            Logger.e("NativeDataSourceFactory", "[getNativeInstance] failed to create native data source!", localThrowable);
            AppMethodBeat.o(114306);
            return 0L;
          }
        }
        AppMethodBeat.o(114306);
        return 0L;
      }
    };
    AppMethodBeat.o(114304);
    return paramString;
  }
  
  public static native long localFile(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.NativeDataSourceFactory
 * JD-Core Version:    0.7.0.1
 */