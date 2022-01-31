package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioPlayerConfigure;
import com.tencent.qqmusic.mediaplayer.ISoLibraryLoader;
import com.tencent.qqmusic.mediaplayer.NativeLibs;

public class Util4NativeCommon
{
  private static final String TAG = "Util4NativeCommon";
  
  static
  {
    AppMethodBeat.i(128389);
    try
    {
      AudioPlayerConfigure.getSoLibraryLoader().load(NativeLibs.audioCommon.getName());
      AppMethodBeat.o(128389);
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("Util4NativeCommon", localThrowable);
      AppMethodBeat.o(128389);
    }
  }
  
  public static native boolean isSupportNeon();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.Util4NativeCommon
 * JD-Core Version:    0.7.0.1
 */