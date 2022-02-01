package com.tencent.thumbplayer.core.imagegenerator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;
import java.util.Map;

public class TPImageGenerator
{
  private ITPImageGeneratorCallback mCallback;
  private int mFd;
  private Map<String, String> mHttpHeader;
  private boolean mInited;
  private boolean mIsLibLoaded;
  private long mNativeContext;
  private String mUrl;
  
  public TPImageGenerator(int paramInt, ITPImageGeneratorCallback paramITPImageGeneratorCallback)
  {
    AppMethodBeat.i(189932);
    this.mUrl = null;
    this.mHttpHeader = null;
    this.mCallback = null;
    this.mFd = -1;
    this.mInited = false;
    this.mIsLibLoaded = false;
    this.mNativeContext = 0L;
    loadLibrary();
    this.mFd = paramInt;
    this.mCallback = paramITPImageGeneratorCallback;
    AppMethodBeat.o(189932);
  }
  
  public TPImageGenerator(String paramString, ITPImageGeneratorCallback paramITPImageGeneratorCallback)
  {
    AppMethodBeat.i(189930);
    this.mUrl = null;
    this.mHttpHeader = null;
    this.mCallback = null;
    this.mFd = -1;
    this.mInited = false;
    this.mIsLibLoaded = false;
    this.mNativeContext = 0L;
    loadLibrary();
    this.mUrl = paramString;
    this.mCallback = paramITPImageGeneratorCallback;
    AppMethodBeat.o(189930);
  }
  
  public TPImageGenerator(String paramString, Map<String, String> paramMap, ITPImageGeneratorCallback paramITPImageGeneratorCallback)
  {
    AppMethodBeat.i(189931);
    this.mUrl = null;
    this.mHttpHeader = null;
    this.mCallback = null;
    this.mFd = -1;
    this.mInited = false;
    this.mIsLibLoaded = false;
    this.mNativeContext = 0L;
    loadLibrary();
    this.mUrl = paramString;
    this.mHttpHeader = paramMap;
    this.mCallback = paramITPImageGeneratorCallback;
    AppMethodBeat.o(189931);
  }
  
  private native void _cancelAllImageGenerations();
  
  private native int _createWithFd(int paramInt, Object paramObject);
  
  private native int _createWithUrl(String paramString, Object paramObject);
  
  private native void _generateImageAsyncAtTime(long paramLong1, long paramLong2, Object paramObject);
  
  private native void _generateImagesAsyncForTimes(long[] paramArrayOfLong, long paramLong, Object paramObject);
  
  private native void _release();
  
  private void loadLibrary()
  {
    AppMethodBeat.i(189929);
    try
    {
      TPNativeLibraryLoader.loadLibIfNeeded(null);
      this.mIsLibLoaded = true;
      AppMethodBeat.o(189929);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      this.mIsLibLoaded = false;
      AppMethodBeat.o(189929);
    }
  }
  
  public void cancelAllImageGenerations()
  {
    AppMethodBeat.i(189937);
    if (!this.mIsLibLoaded)
    {
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(189937);
      throw localUnsupportedOperationException;
    }
    if (!this.mInited)
    {
      AppMethodBeat.o(189937);
      return;
    }
    _cancelAllImageGenerations();
    AppMethodBeat.o(189937);
  }
  
  public void generateImageAsyncAtTime(long paramLong1, long paramLong2, TPImageGeneratorParams paramTPImageGeneratorParams)
  {
    AppMethodBeat.i(189935);
    if (!this.mIsLibLoaded)
    {
      paramTPImageGeneratorParams = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(189935);
      throw paramTPImageGeneratorParams;
    }
    if (!this.mInited)
    {
      paramTPImageGeneratorParams = new IllegalStateException("Failed to generate image at time " + paramLong1 + " due to invalid state.");
      AppMethodBeat.o(189935);
      throw paramTPImageGeneratorParams;
    }
    _generateImageAsyncAtTime(paramLong1, paramLong2, paramTPImageGeneratorParams);
    AppMethodBeat.o(189935);
  }
  
  public void generateImagesAsyncForTimes(long[] paramArrayOfLong, long paramLong, TPImageGeneratorParams paramTPImageGeneratorParams)
  {
    AppMethodBeat.i(189936);
    if (!this.mIsLibLoaded)
    {
      paramArrayOfLong = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(189936);
      throw paramArrayOfLong;
    }
    if (!this.mInited)
    {
      paramArrayOfLong = new IllegalStateException("Failed to generate images due to invalid state.");
      AppMethodBeat.o(189936);
      throw paramArrayOfLong;
    }
    _generateImagesAsyncForTimes(paramArrayOfLong, paramLong, paramTPImageGeneratorParams);
    AppMethodBeat.o(189936);
  }
  
  public void init()
  {
    AppMethodBeat.i(189933);
    Object localObject;
    if (!this.mIsLibLoaded)
    {
      localObject = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(189933);
      throw ((Throwable)localObject);
    }
    if (this.mInited)
    {
      localObject = new IllegalStateException("Failed to init due to invalid state.");
      AppMethodBeat.o(189933);
      throw ((Throwable)localObject);
    }
    this.mInited = true;
    if ((this.mUrl == null) || (this.mHttpHeader == null))
    {
      if (this.mUrl != null)
      {
        _createWithUrl(this.mUrl, this.mCallback);
        AppMethodBeat.o(189933);
        return;
      }
      _createWithFd(this.mFd, this.mCallback);
    }
    AppMethodBeat.o(189933);
  }
  
  public void unInit()
  {
    AppMethodBeat.i(189934);
    if (!this.mIsLibLoaded)
    {
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(189934);
      throw localUnsupportedOperationException;
    }
    if (!this.mInited)
    {
      AppMethodBeat.o(189934);
      return;
    }
    this.mInited = false;
    _release();
    AppMethodBeat.o(189934);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.core.imagegenerator.TPImageGenerator
 * JD-Core Version:    0.7.0.1
 */