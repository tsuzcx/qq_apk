package com.tencent.thumbplayer.core.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;

public class TPPlayerCoreConfig
{
  private static boolean mIsLibLoaded;
  
  static
  {
    AppMethodBeat.i(189867);
    mIsLibLoaded = false;
    try
    {
      TPNativeLibraryLoader.loadLibIfNeeded(null);
      mIsLibLoaded = true;
      AppMethodBeat.o(189867);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      mIsLibLoaded = false;
      AppMethodBeat.o(189867);
    }
  }
  
  private static native int _getVideoMediaCodecCoexistMaxCnt();
  
  private static native void _setVideoMediaCodecCoexistMaxCnt(int paramInt);
  
  public static int getVideoMediaCodecCoexistMaxCnt()
  {
    AppMethodBeat.i(189866);
    if (!mIsLibLoaded)
    {
      AppMethodBeat.o(189866);
      return -1;
    }
    int i = _getVideoMediaCodecCoexistMaxCnt();
    AppMethodBeat.o(189866);
    return i;
  }
  
  public static void setVideoMediaCodecCoexistMaxCnt(int paramInt)
  {
    AppMethodBeat.i(189865);
    if (!mIsLibLoaded)
    {
      AppMethodBeat.o(189865);
      return;
    }
    _setVideoMediaCodecCoexistMaxCnt(paramInt);
    AppMethodBeat.o(189865);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.thumbplayer.core.config.TPPlayerCoreConfig
 * JD-Core Version:    0.7.0.1
 */