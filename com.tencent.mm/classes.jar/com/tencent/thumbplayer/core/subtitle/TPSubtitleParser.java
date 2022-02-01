package com.tencent.thumbplayer.core.subtitle;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPMediaTrackInfo;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.core.common.TPSubtitleFrameWrapper;

public class TPSubtitleParser
{
  public static final int TP_SUBTITLE_OUTPUT_RGBA = 1;
  public static final int TP_SUBTITLE_OUTPUT_TEXT = 0;
  private ITPSubtitleParserCallback mCallback;
  private boolean mInited;
  private boolean mIsLibLoaded;
  private long mNativeContext;
  private int mOutputType;
  private String mUrl;
  
  public TPSubtitleParser(String paramString, ITPSubtitleParserCallback paramITPSubtitleParserCallback)
  {
    AppMethodBeat.i(223875);
    this.mUrl = null;
    this.mOutputType = 0;
    this.mCallback = null;
    this.mInited = false;
    this.mIsLibLoaded = false;
    this.mNativeContext = 0L;
    loadLibrary();
    this.mUrl = paramString;
    this.mCallback = paramITPSubtitleParserCallback;
    AppMethodBeat.o(223875);
  }
  
  public TPSubtitleParser(String paramString, ITPSubtitleParserCallback paramITPSubtitleParserCallback, int paramInt)
  {
    AppMethodBeat.i(223878);
    this.mUrl = null;
    this.mOutputType = 0;
    this.mCallback = null;
    this.mInited = false;
    this.mIsLibLoaded = false;
    this.mNativeContext = 0L;
    loadLibrary();
    this.mUrl = paramString;
    this.mCallback = paramITPSubtitleParserCallback;
    this.mOutputType = paramInt;
    AppMethodBeat.o(223878);
  }
  
  private native int _subtitleCreate(String paramString, Object paramObject, int paramInt);
  
  private native void _subtitleDelete();
  
  private native TPSubtitleFrameWrapper _subtitleGetFrame(long paramLong);
  
  private native String _subtitleGetText(long paramLong, int paramInt);
  
  private native int _subtitleGetTrackCount();
  
  private native String _subtitleGetTrackName(int paramInt);
  
  private native int _subtitleSelectTrackAsync(int paramInt, long paramLong);
  
  private native void _subtitleSetCanvasSize(int paramInt1, int paramInt2);
  
  private void loadLibrary()
  {
    AppMethodBeat.i(223870);
    try
    {
      TPNativeLibraryLoader.loadLibIfNeeded(null);
      this.mIsLibLoaded = true;
      AppMethodBeat.o(223870);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      this.mIsLibLoaded = false;
      AppMethodBeat.o(223870);
    }
  }
  
  public TPSubtitleFrameWrapper getSubtitleFrame(long paramLong)
  {
    AppMethodBeat.i(223900);
    if (!this.mIsLibLoaded)
    {
      localObject = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(223900);
      throw ((Throwable)localObject);
    }
    if (!this.mInited)
    {
      localObject = new IllegalStateException("Failed to getSubtitleFrame due to invalid state.");
      AppMethodBeat.o(223900);
      throw ((Throwable)localObject);
    }
    Object localObject = _subtitleGetFrame(paramLong);
    AppMethodBeat.o(223900);
    return localObject;
  }
  
  public String getSubtitleText(long paramLong, int paramInt)
  {
    AppMethodBeat.i(223896);
    if (!this.mIsLibLoaded)
    {
      localObject = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(223896);
      throw ((Throwable)localObject);
    }
    if (!this.mInited)
    {
      localObject = new IllegalStateException("Failed to getSubtitleText due to invalid state.");
      AppMethodBeat.o(223896);
      throw ((Throwable)localObject);
    }
    Object localObject = _subtitleGetText(paramLong, paramInt);
    AppMethodBeat.o(223896);
    return localObject;
  }
  
  public TPMediaTrackInfo[] getTrackInfo()
  {
    AppMethodBeat.i(223889);
    if (!this.mIsLibLoaded)
    {
      localObject = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(223889);
      throw ((Throwable)localObject);
    }
    if (!this.mInited)
    {
      localObject = new IllegalStateException("Failed to getTrackInfo due to invalid state.");
      AppMethodBeat.o(223889);
      throw ((Throwable)localObject);
    }
    Object localObject = null;
    int j = _subtitleGetTrackCount();
    if (j > 0)
    {
      TPMediaTrackInfo[] arrayOfTPMediaTrackInfo = new TPMediaTrackInfo[j];
      int i = 0;
      for (;;)
      {
        localObject = arrayOfTPMediaTrackInfo;
        if (i >= j) {
          break;
        }
        localObject = new TPMediaTrackInfo();
        ((TPMediaTrackInfo)localObject).trackType = 3;
        ((TPMediaTrackInfo)localObject).trackName = _subtitleGetTrackName(i);
        arrayOfTPMediaTrackInfo[i] = localObject;
        i += 1;
      }
    }
    AppMethodBeat.o(223889);
    return localObject;
  }
  
  public void init()
  {
    AppMethodBeat.i(223882);
    Object localObject;
    if (!this.mIsLibLoaded)
    {
      localObject = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(223882);
      throw ((Throwable)localObject);
    }
    if (this.mInited)
    {
      localObject = new IllegalStateException("Failed to init due to invalid state.");
      AppMethodBeat.o(223882);
      throw ((Throwable)localObject);
    }
    this.mInited = true;
    if ((this.mUrl != null) && (this.mCallback != null)) {
      _subtitleCreate(this.mUrl, this.mCallback, this.mOutputType);
    }
    AppMethodBeat.o(223882);
  }
  
  public int selectTrackAsync(int paramInt, long paramLong)
  {
    AppMethodBeat.i(223894);
    Object localObject;
    if (!this.mIsLibLoaded)
    {
      localObject = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(223894);
      throw ((Throwable)localObject);
    }
    if (!this.mInited)
    {
      localObject = new IllegalStateException("Failed to selectTrackAsync due to invalid state.");
      AppMethodBeat.o(223894);
      throw ((Throwable)localObject);
    }
    paramInt = _subtitleSelectTrackAsync(paramInt, paramLong);
    AppMethodBeat.o(223894);
    return paramInt;
  }
  
  public int selectTracksAsync(int[] paramArrayOfInt, long paramLong)
  {
    return 0;
  }
  
  public void setCanvasSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(223899);
    Object localObject;
    if (!this.mIsLibLoaded)
    {
      localObject = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(223899);
      throw ((Throwable)localObject);
    }
    if (!this.mInited)
    {
      localObject = new IllegalStateException("Failed to setCanvasSize due to invalid state.");
      AppMethodBeat.o(223899);
      throw ((Throwable)localObject);
    }
    _subtitleSetCanvasSize(paramInt1, paramInt2);
    AppMethodBeat.o(223899);
  }
  
  public void unInit()
  {
    AppMethodBeat.i(223885);
    if (!this.mIsLibLoaded)
    {
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(223885);
      throw localUnsupportedOperationException;
    }
    if (!this.mInited)
    {
      AppMethodBeat.o(223885);
      return;
    }
    this.mInited = false;
    _subtitleDelete();
    AppMethodBeat.o(223885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.core.subtitle.TPSubtitleParser
 * JD-Core Version:    0.7.0.1
 */