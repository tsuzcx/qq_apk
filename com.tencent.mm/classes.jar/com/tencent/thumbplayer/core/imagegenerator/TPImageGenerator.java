package com.tencent.thumbplayer.core.imagegenerator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class TPImageGenerator
{
  private ITPImageGeneratorCallback mCallback = null;
  private int mFd = -1;
  private Map<String, String> mHttpHeader = null;
  private boolean mInited = false;
  private long mNativeContext = 0L;
  private String mUrl = null;
  
  public TPImageGenerator(int paramInt, ITPImageGeneratorCallback paramITPImageGeneratorCallback)
  {
    this.mFd = paramInt;
    this.mCallback = paramITPImageGeneratorCallback;
  }
  
  public TPImageGenerator(String paramString, ITPImageGeneratorCallback paramITPImageGeneratorCallback)
  {
    this.mUrl = paramString;
    this.mCallback = paramITPImageGeneratorCallback;
  }
  
  public TPImageGenerator(String paramString, Map<String, String> paramMap, ITPImageGeneratorCallback paramITPImageGeneratorCallback)
  {
    this.mUrl = paramString;
    this.mHttpHeader = paramMap;
    this.mCallback = paramITPImageGeneratorCallback;
  }
  
  private native void _cancelAllImageGenerations();
  
  private native int _createWithFd(int paramInt, Object paramObject);
  
  private native int _createWithUrl(String paramString, Object paramObject);
  
  private native void _generateImageAsyncAtTime(long paramLong1, long paramLong2, Object paramObject);
  
  private native void _generateImagesAsyncForTimes(long[] paramArrayOfLong, long paramLong, Object paramObject);
  
  private native void _release();
  
  public void cancelAllImageGenerations()
  {
    AppMethodBeat.i(193883);
    if (!this.mInited)
    {
      AppMethodBeat.o(193883);
      return;
    }
    _cancelAllImageGenerations();
    AppMethodBeat.o(193883);
  }
  
  public void generateImageAsyncAtTime(long paramLong1, long paramLong2, TPImageGeneratorParams paramTPImageGeneratorParams)
  {
    AppMethodBeat.i(193881);
    if (!this.mInited)
    {
      paramTPImageGeneratorParams = new IllegalStateException("Failed to generate image at time " + paramLong1 + " due to invalid state.");
      AppMethodBeat.o(193881);
      throw paramTPImageGeneratorParams;
    }
    _generateImageAsyncAtTime(paramLong1, paramLong2, paramTPImageGeneratorParams);
    AppMethodBeat.o(193881);
  }
  
  public void generateImagesAsyncForTimes(long[] paramArrayOfLong, long paramLong, TPImageGeneratorParams paramTPImageGeneratorParams)
  {
    AppMethodBeat.i(193882);
    if (!this.mInited)
    {
      paramArrayOfLong = new IllegalStateException("Failed to generate images due to invalid state.");
      AppMethodBeat.o(193882);
      throw paramArrayOfLong;
    }
    _generateImagesAsyncForTimes(paramArrayOfLong, paramLong, paramTPImageGeneratorParams);
    AppMethodBeat.o(193882);
  }
  
  public void init()
  {
    AppMethodBeat.i(193879);
    if (this.mInited)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Failed to init due to invalid state.");
      AppMethodBeat.o(193879);
      throw localIllegalStateException;
    }
    this.mInited = true;
    if ((this.mUrl == null) || (this.mHttpHeader == null))
    {
      if (this.mUrl != null)
      {
        _createWithUrl(this.mUrl, this.mCallback);
        AppMethodBeat.o(193879);
        return;
      }
      _createWithFd(this.mFd, this.mCallback);
    }
    AppMethodBeat.o(193879);
  }
  
  public void unInit()
  {
    AppMethodBeat.i(193880);
    if (!this.mInited)
    {
      AppMethodBeat.o(193880);
      return;
    }
    this.mInited = false;
    _release();
    AppMethodBeat.o(193880);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.imagegenerator.TPImageGenerator
 * JD-Core Version:    0.7.0.1
 */