package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.qqmusic.mediaplayer.AudioPlayerConfigure;
import com.tencent.qqmusic.mediaplayer.ISoLibraryLoader;
import com.tencent.qqmusic.mediaplayer.NativeLibs;

public class Util4NativeCommon
{
  private static final String TAG = "Util4NativeCommon";
  
  static
  {
    try
    {
      AudioPlayerConfigure.getSoLibraryLoader().load(NativeLibs.audioCommon.getName());
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("Util4NativeCommon", localThrowable);
    }
  }
  
  public static native boolean isSupportNeon();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.Util4NativeCommon
 * JD-Core Version:    0.7.0.1
 */