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
    AppMethodBeat.i(227371);
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
    AppMethodBeat.o(227371);
  }
  
  public TPImageGenerator(String paramString, ITPImageGeneratorCallback paramITPImageGeneratorCallback)
  {
    AppMethodBeat.i(227348);
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
    AppMethodBeat.o(227348);
  }
  
  public TPImageGenerator(String paramString, Map<String, String> paramMap, ITPImageGeneratorCallback paramITPImageGeneratorCallback)
  {
    AppMethodBeat.i(227358);
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
    AppMethodBeat.o(227358);
  }
  
  private native void _cancelAllImageGenerations();
  
  private native int _createWithFd(int paramInt, Object paramObject);
  
  private native int _createWithUrl(String paramString, Object paramObject);
  
  private native void _generateImageAsyncAtTime(long paramLong1, long paramLong2, Object paramObject);
  
  private native void _generateImagesAsyncForTimes(long[] paramArrayOfLong, long paramLong, Object paramObject);
  
  private native void _release();
  
  private void loadLibrary()
  {
    AppMethodBeat.i(227338);
    try
    {
      TPNativeLibraryLoader.loadLibIfNeeded(null);
      this.mIsLibLoaded = true;
      AppMethodBeat.o(227338);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      this.mIsLibLoaded = false;
      AppMethodBeat.o(227338);
    }
  }
  
  public void cancelAllImageGenerations()
  {
    AppMethodBeat.i(227417);
    if (!this.mIsLibLoaded)
    {
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(227417);
      throw localUnsupportedOperationException;
    }
    if (!this.mInited)
    {
      AppMethodBeat.o(227417);
      return;
    }
    _cancelAllImageGenerations();
    AppMethodBeat.o(227417);
  }
  
  public void generateImageAsyncAtTime(long paramLong1, long paramLong2, TPImageGeneratorParams paramTPImageGeneratorParams)
  {
    AppMethodBeat.i(227398);
    if (!this.mIsLibLoaded)
    {
      paramTPImageGeneratorParams = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(227398);
      throw paramTPImageGeneratorParams;
    }
    if (!this.mInited)
    {
      paramTPImageGeneratorParams = new IllegalStateException("Failed to generate image at time " + paramLong1 + " due to invalid state.");
      AppMethodBeat.o(227398);
      throw paramTPImageGeneratorParams;
    }
    _generateImageAsyncAtTime(paramLong1, paramLong2, paramTPImageGeneratorParams);
    AppMethodBeat.o(227398);
  }
  
  public void generateImagesAsyncForTimes(long[] paramArrayOfLong, long paramLong, TPImageGeneratorParams paramTPImageGeneratorParams)
  {
    AppMethodBeat.i(227405);
    if (!this.mIsLibLoaded)
    {
      paramArrayOfLong = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(227405);
      throw paramArrayOfLong;
    }
    if (!this.mInited)
    {
      paramArrayOfLong = new IllegalStateException("Failed to generate images due to invalid state.");
      AppMethodBeat.o(227405);
      throw paramArrayOfLong;
    }
    _generateImagesAsyncForTimes(paramArrayOfLong, paramLong, paramTPImageGeneratorParams);
    AppMethodBeat.o(227405);
  }
  
  public void init()
  {
    AppMethodBeat.i(227379);
    Object localObject;
    if (!this.mIsLibLoaded)
    {
      localObject = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(227379);
      throw ((Throwable)localObject);
    }
    if (this.mInited)
    {
      localObject = new IllegalStateException("Failed to init due to invalid state.");
      AppMethodBeat.o(227379);
      throw ((Throwable)localObject);
    }
    this.mInited = true;
    if ((this.mUrl == null) || (this.mHttpHeader == null))
    {
      if (this.mUrl != null)
      {
        _createWithUrl(this.mUrl, this.mCallback);
        AppMethodBeat.o(227379);
        return;
      }
      _createWithFd(this.mFd, this.mCallback);
    }
    AppMethodBeat.o(227379);
  }
  
  public void unInit()
  {
    AppMethodBeat.i(227385);
    if (!this.mIsLibLoaded)
    {
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Failed to load native library");
      AppMethodBeat.o(227385);
      throw localUnsupportedOperationException;
    }
    if (!this.mInited)
    {
      AppMethodBeat.o(227385);
      return;
    }
    this.mInited = false;
    _release();
    AppMethodBeat.o(227385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.imagegenerator.TPImageGenerator
 * JD-Core Version:    0.7.0.1
 */