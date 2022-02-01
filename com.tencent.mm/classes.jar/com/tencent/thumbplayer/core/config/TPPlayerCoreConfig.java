package com.tencent.thumbplayer.core.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;

public class TPPlayerCoreConfig
{
  private static boolean mIsLibLoaded;
  
  static
  {
    AppMethodBeat.i(223290);
    mIsLibLoaded = false;
    try
    {
      TPNativeLibraryLoader.loadLibIfNeeded(null);
      mIsLibLoaded = true;
      AppMethodBeat.o(223290);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      mIsLibLoaded = false;
      AppMethodBeat.o(223290);
    }
  }
  
  private static native int _getVideoMediaCodecCoexistMaxCnt();
  
  private static native void _setVideoMediaCodecCoexistMaxCnt(int paramInt);
  
  public static int getVideoMediaCodecCoexistMaxCnt()
  {
    AppMethodBeat.i(223288);
    if (!mIsLibLoaded)
    {
      AppMethodBeat.o(223288);
      return -1;
    }
    int i = _getVideoMediaCodecCoexistMaxCnt();
    AppMethodBeat.o(223288);
    return i;
  }
  
  public static void setVideoMediaCodecCoexistMaxCnt(int paramInt)
  {
    AppMethodBeat.i(223287);
    if (!mIsLibLoaded)
    {
      AppMethodBeat.o(223287);
      return;
    }
    _setVideoMediaCodecCoexistMaxCnt(paramInt);
    AppMethodBeat.o(223287);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.config.TPPlayerCoreConfig
 * JD-Core Version:    0.7.0.1
 */