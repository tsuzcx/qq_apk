package com.tencent.thumbplayer.core.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;

public class TPPlayerCoreConfig
{
  private static boolean mIsLibLoaded;
  
  static
  {
    AppMethodBeat.i(227335);
    mIsLibLoaded = false;
    try
    {
      TPNativeLibraryLoader.loadLibIfNeeded(null);
      mIsLibLoaded = true;
      AppMethodBeat.o(227335);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      mIsLibLoaded = false;
      AppMethodBeat.o(227335);
    }
  }
  
  private static native int _getVideoMediaCodecCoexistMaxCnt();
  
  private static native void _setVideoMediaCodecCoexistMaxCnt(int paramInt);
  
  private static native void _setVideoMediaCodecStuckCheck(boolean paramBoolean);
  
  public static int getVideoMediaCodecCoexistMaxCnt()
  {
    AppMethodBeat.i(227322);
    if (!mIsLibLoaded)
    {
      AppMethodBeat.o(227322);
      return -1;
    }
    int i = _getVideoMediaCodecCoexistMaxCnt();
    AppMethodBeat.o(227322);
    return i;
  }
  
  public static void setVideoMediaCodecCoexistMaxCnt(int paramInt)
  {
    AppMethodBeat.i(227318);
    if (!mIsLibLoaded)
    {
      AppMethodBeat.o(227318);
      return;
    }
    _setVideoMediaCodecCoexistMaxCnt(paramInt);
    AppMethodBeat.o(227318);
  }
  
  public static void setVideoMediaCodecStuckCheck(boolean paramBoolean)
  {
    AppMethodBeat.i(227329);
    if (!mIsLibLoaded)
    {
      AppMethodBeat.o(227329);
      return;
    }
    _setVideoMediaCodecStuckCheck(paramBoolean);
    AppMethodBeat.o(227329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.config.TPPlayerCoreConfig
 * JD-Core Version:    0.7.0.1
 */