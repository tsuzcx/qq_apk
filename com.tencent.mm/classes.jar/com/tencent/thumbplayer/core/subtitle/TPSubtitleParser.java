package com.tencent.thumbplayer.core.subtitle;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPMediaTrackInfo;

public class TPSubtitleParser
{
  private ITPSubtitleParserCallback mCallback = null;
  private boolean mInited = false;
  private long mNativeContext = 0L;
  private String mUrl = null;
  
  public TPSubtitleParser(String paramString, ITPSubtitleParserCallback paramITPSubtitleParserCallback)
  {
    this.mUrl = paramString;
    this.mCallback = paramITPSubtitleParserCallback;
  }
  
  private native int _subtitleCreate(String paramString, Object paramObject);
  
  private native void _subtitleDelete();
  
  private native String _subtitleGetText(long paramLong, int paramInt);
  
  private native int _subtitleGetTrackCount();
  
  private native String _subtitleGetTrackName(int paramInt);
  
  public String getSubtitleText(long paramLong, int paramInt)
  {
    AppMethodBeat.i(197656);
    if (this.mInited)
    {
      String str = _subtitleGetText(paramLong, paramInt);
      AppMethodBeat.o(197656);
      return str;
    }
    AppMethodBeat.o(197656);
    return null;
  }
  
  public TPMediaTrackInfo[] getTrackInfo()
  {
    Object localObject = null;
    AppMethodBeat.i(197655);
    if (this.mInited)
    {
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
          arrayOfTPMediaTrackInfo[i].trackType = 3;
          arrayOfTPMediaTrackInfo[i].trackName = _subtitleGetTrackName(i);
          i += 1;
        }
      }
      AppMethodBeat.o(197655);
      return localObject;
    }
    AppMethodBeat.o(197655);
    return null;
  }
  
  public void init()
  {
    AppMethodBeat.i(197653);
    if (this.mInited)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Failed to init due to invalid state.");
      AppMethodBeat.o(197653);
      throw localIllegalStateException;
    }
    if ((this.mUrl != null) && (this.mCallback != null))
    {
      this.mInited = true;
      _subtitleCreate(this.mUrl, this.mCallback);
    }
    AppMethodBeat.o(197653);
  }
  
  public int selectTrackAsync(int paramInt, long paramLong)
  {
    return 0;
  }
  
  public int selectTracksAsync(int[] paramArrayOfInt, long paramLong)
  {
    return 0;
  }
  
  public void unInit()
  {
    AppMethodBeat.i(197654);
    if (!this.mInited)
    {
      AppMethodBeat.o(197654);
      return;
    }
    _subtitleDelete();
    AppMethodBeat.o(197654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.core.subtitle.TPSubtitleParser
 * JD-Core Version:    0.7.0.1
 */