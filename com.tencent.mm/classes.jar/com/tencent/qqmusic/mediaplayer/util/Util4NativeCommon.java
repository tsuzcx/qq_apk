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
    AppMethodBeat.i(114164);
    try
    {
      AudioPlayerConfigure.getSoLibraryLoader().load(NativeLibs.audioCommon.getName());
      AppMethodBeat.o(114164);
      return;
    }
    finally
    {
      Logger.e("Util4NativeCommon", localThrowable);
      AppMethodBeat.o(114164);
    }
  }
  
  public static native boolean isSupportNeon();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.Util4NativeCommon
 * JD-Core Version:    0.7.0.1
 */