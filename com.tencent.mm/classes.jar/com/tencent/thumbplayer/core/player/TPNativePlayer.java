package com.tencent.thumbplayer.core.player;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPAudioPassThroughPluginDetector;
import com.tencent.thumbplayer.core.common.TPHeadsetPluginDetector;
import com.tencent.thumbplayer.core.common.TPMediaTrackInfo;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import com.tencent.thumbplayer.core.common.TPScreenRefreshRateDetector;
import com.tencent.thumbplayer.core.common.TPSystemInfo;
import com.tencent.thumbplayer.core.demuxer.ITPDemuxerCallback;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

public class TPNativePlayer
{
  private Context mContext;
  private long mNativeContext;
  private int m_playerID;
  
  public TPNativePlayer(Context paramContext)
  {
    AppMethodBeat.i(228436);
    this.m_playerID = -1;
    this.mContext = null;
    this.mContext = paramContext.getApplicationContext();
    TPNativeLibraryLoader.loadLibIfNeeded(paramContext);
    try
    {
      this.m_playerID = _createPlayer();
      TPHeadsetPluginDetector.init(this.mContext);
      TPAudioPassThroughPluginDetector.init(this.mContext);
      if (Build.VERSION.SDK_INT >= 17) {
        TPScreenRefreshRateDetector.init(this.mContext);
      }
      TPSystemInfo.initAudioBestSettings(this.mContext);
      AppMethodBeat.o(228436);
      return;
    }
    finally
    {
      TPNativeLog.printLog(4, "Failed to create native player:" + paramContext.getMessage());
      paramContext = new UnsupportedOperationException("Failed to create native player");
      AppMethodBeat.o(228436);
    }
  }
  
  private native int _addAudioTrackSource(String paramString1, String paramString2);
  
  private native int _addInitConfigQueueInt(int paramInt1, int paramInt2);
  
  private native int _addInitConfigQueueString(int paramInt, String paramString);
  
  private native int _addSubtitleTrackSource(String paramString1, String paramString2);
  
  private native int _applyInitConfig();
  
  private native int _createPlayer();
  
  private native int _deselectTrackAsync(int paramInt, long paramLong);
  
  private native long _getBufferedDurationMs();
  
  private native long _getBufferedSize();
  
  private native long _getCurrentPositionMs();
  
  private native long _getDurationMs();
  
  private native int _getPlayerID();
  
  private native int _getProgramCount();
  
  private native TPNativePlayerProgramInfo _getProgramInfo(int paramInt);
  
  private native long _getPropertyLong(int paramInt);
  
  private native String _getPropertyString(int paramInt);
  
  private native int _getTrackCount();
  
  private native boolean _getTrackIsExclusive(int paramInt);
  
  private native boolean _getTrackIsInternal(int paramInt);
  
  private native boolean _getTrackIsSelected(int paramInt);
  
  private native String _getTrackName(int paramInt);
  
  private native int _getTrackType(int paramInt);
  
  private native int _getVideoHeight();
  
  private native int _getVideoWidth();
  
  private native int _pause();
  
  private native int _prepare();
  
  private native int _prepareAsync();
  
  private native int _release();
  
  private native int _reset();
  
  private native int _resetInitConfig();
  
  private native int _resume();
  
  private native int _seekToAsync(int paramInt1, int paramInt2, long paramLong);
  
  private native int _selectProgramAsync(int paramInt, long paramLong);
  
  private native int _selectTrackAsync(int paramInt, long paramLong);
  
  private native int _setAudioFrameCallback(Object paramObject);
  
  private native int _setAudioMute(boolean paramBoolean);
  
  private native int _setAudioNormalizeVolumeParams(String paramString);
  
  private native int _setAudioVolume(float paramFloat);
  
  private native int _setDataSource(String paramString);
  
  private native int _setDataSourceFd(int paramInt, long paramLong1, long paramLong2);
  
  private native int _setDataSourceWithHttpHeader(String paramString, Object[] paramArrayOfObject);
  
  private native int _setDemuxerCallback(Object paramObject);
  
  private native int _setInitConfigBool(int paramInt, boolean paramBoolean);
  
  private native int _setInitConfigFloat(int paramInt, float paramFloat);
  
  private native int _setInitConfigInt(int paramInt1, int paramInt2);
  
  private native int _setInitConfigLong(int paramInt, long paramLong);
  
  private native int _setInitConfigString(int paramInt, String paramString);
  
  private native int _setLoopback(boolean paramBoolean, long paramLong1, long paramLong2);
  
  private native int _setMessageCallback(Object paramObject);
  
  private native int _setOptionLong(int paramInt, long paramLong1, long paramLong2);
  
  private native int _setOptionObject(int paramInt, Object paramObject);
  
  private native int _setPlaySharpenSwitch();
  
  private native int _setPlaybackRate(float paramFloat);
  
  private native int _setPostProcessFrameCallback(Object paramObject);
  
  private native int _setSubtitleFrameCallback(Object paramObject);
  
  private native int _setVideoFrameCallback(Object paramObject);
  
  private native int _setVideoSurface(Surface paramSurface);
  
  private native int _setVideoSurfaceWithType(Surface paramSurface, int paramInt);
  
  private native int _start();
  
  private native int _stop();
  
  private native int _switchDefinitionAsync(String paramString, int paramInt, long paramLong);
  
  public int addAudioTrackSource(String paramString1, String paramString2)
  {
    AppMethodBeat.i(228691);
    try
    {
      int i = _addAudioTrackSource(paramString1, paramString2);
      AppMethodBeat.o(228691);
      return i;
    }
    finally
    {
      TPNativeLog.printLog(4, paramString1.getMessage());
      AppMethodBeat.o(228691);
    }
    return 1000001;
  }
  
  public int addSubtitleTrackSource(String paramString1, String paramString2)
  {
    AppMethodBeat.i(228684);
    try
    {
      int i = _addSubtitleTrackSource(paramString1, paramString2);
      AppMethodBeat.o(228684);
      return i;
    }
    finally
    {
      TPNativeLog.printLog(4, paramString1.getMessage());
      AppMethodBeat.o(228684);
    }
    return 1000001;
  }
  
  public int deselectTrackAsync(int paramInt, long paramLong)
  {
    AppMethodBeat.i(228707);
    try
    {
      paramInt = _deselectTrackAsync(paramInt, paramLong);
      AppMethodBeat.o(228707);
      return paramInt;
    }
    finally
    {
      TPNativeLog.printLog(4, localObject.getMessage());
      AppMethodBeat.o(228707);
    }
    return 1000001;
  }
  
  public long getBufferedDurationMs()
  {
    AppMethodBeat.i(228671);
    try
    {
      long l = _getBufferedDurationMs();
      AppMethodBeat.o(228671);
      return l;
    }
    finally
    {
      TPNativeLog.printLog(4, localObject.getMessage());
      AppMethodBeat.o(228671);
    }
    return 0L;
  }
  
  public long getBufferedSize()
  {
    AppMethodBeat.i(228675);
    try
    {
      long l = _getBufferedSize();
      AppMethodBeat.o(228675);
      return l;
    }
    finally
    {
      TPNativeLog.printLog(4, localObject.getMessage());
      AppMethodBeat.o(228675);
    }
    return 0L;
  }
  
  public long getCurrentPositionMs()
  {
    AppMethodBeat.i(228664);
    try
    {
      long l = _getCurrentPositionMs();
      AppMethodBeat.o(228664);
      return l;
    }
    finally
    {
      TPNativeLog.printLog(4, localObject.getMessage());
      AppMethodBeat.o(228664);
    }
    return 0L;
  }
  
  public long getDurationMs()
  {
    AppMethodBeat.i(228659);
    try
    {
      long l = _getDurationMs();
      AppMethodBeat.o(228659);
      return l;
    }
    finally
    {
      TPNativeLog.printLog(4, localObject.getMessage());
      AppMethodBeat.o(228659);
    }
    return 0L;
  }
  
  public int getPlayerID()
  {
    AppMethodBeat.i(228630);
    try
    {
      int i = _getPlayerID();
      AppMethodBeat.o(228630);
      return i;
    }
    finally
    {
      TPNativeLog.printLog(4, localObject.getMessage());
      AppMethodBeat.o(228630);
    }
    return 0;
  }
  
  public int getProgramCount()
  {
    AppMethodBeat.i(228719);
    try
    {
      int i = _getProgramCount();
      AppMethodBeat.o(228719);
      return i;
    }
    finally
    {
      TPNativeLog.printLog(4, localObject.getMessage());
      AppMethodBeat.o(228719);
    }
    return 1000001;
  }
  
  public TPNativePlayerProgramInfo[] getProgramInfo()
  {
    AppMethodBeat.i(228733);
    try
    {
      int j = _getProgramCount();
      TPNativePlayerProgramInfo[] arrayOfTPNativePlayerProgramInfo = new TPNativePlayerProgramInfo[j];
      int i = 0;
      while (i < j)
      {
        arrayOfTPNativePlayerProgramInfo[i] = _getProgramInfo(i);
        i += 1;
      }
      AppMethodBeat.o(228733);
      return arrayOfTPNativePlayerProgramInfo;
    }
    finally
    {
      TPNativeLog.printLog(4, localObject.getMessage());
      AppMethodBeat.o(228733);
    }
    return null;
  }
  
  public long getPropertyLong(int paramInt)
  {
    AppMethodBeat.i(228635);
    try
    {
      long l = _getPropertyLong(paramInt);
      AppMethodBeat.o(228635);
      return l;
    }
    finally
    {
      TPNativeLog.printLog(4, localObject.getMessage());
      AppMethodBeat.o(228635);
    }
    return 0L;
  }
  
  public String getPropertyString(int paramInt)
  {
    AppMethodBeat.i(228643);
    try
    {
      String str = _getPropertyString(paramInt);
      AppMethodBeat.o(228643);
      return str;
    }
    finally
    {
      TPNativeLog.printLog(4, localObject.getMessage());
      AppMethodBeat.o(228643);
    }
    return "";
  }
  
  public TPMediaTrackInfo[] getTrackInfo()
  {
    AppMethodBeat.i(228714);
    try
    {
      int j = _getTrackCount();
      if (j > 0)
      {
        TPMediaTrackInfo[] arrayOfTPMediaTrackInfo2 = new TPMediaTrackInfo[j];
        int i = 0;
        for (;;)
        {
          arrayOfTPMediaTrackInfo1 = arrayOfTPMediaTrackInfo2;
          if (i >= j) {
            break;
          }
          arrayOfTPMediaTrackInfo2[i] = new TPMediaTrackInfo();
          arrayOfTPMediaTrackInfo2[i].trackType = _getTrackType(i);
          arrayOfTPMediaTrackInfo2[i].trackName = _getTrackName(i);
          arrayOfTPMediaTrackInfo2[i].isSelected = _getTrackIsSelected(i);
          arrayOfTPMediaTrackInfo2[i].isExclusive = _getTrackIsExclusive(i);
          arrayOfTPMediaTrackInfo2[i].isInternal = _getTrackIsInternal(i);
          i += 1;
        }
      }
      TPMediaTrackInfo[] arrayOfTPMediaTrackInfo1 = null;
      AppMethodBeat.o(228714);
      return arrayOfTPMediaTrackInfo1;
    }
    finally
    {
      TPNativeLog.printLog(4, localObject.getMessage());
      AppMethodBeat.o(228714);
    }
    return null;
  }
  
  public int getVideoHeight()
  {
    AppMethodBeat.i(228653);
    try
    {
      int i = _getVideoHeight();
      AppMethodBeat.o(228653);
      return i;
    }
    finally
    {
      TPNativeLog.printLog(4, localObject.getMessage());
      AppMethodBeat.o(228653);
    }
    return 0;
  }
  
  public int getVideoWidth()
  {
    AppMethodBeat.i(228646);
    try
    {
      int i = _getVideoWidth();
      AppMethodBeat.o(228646);
      return i;
    }
    finally
    {
      TPNativeLog.printLog(4, localObject.getMessage());
      AppMethodBeat.o(228646);
    }
    return 0;
  }
  
  public int pause()
  {
    AppMethodBeat.i(228491);
    try
    {
      int i = _pause();
      AppMethodBeat.o(228491);
      return i;
    }
    finally
    {
      TPNativeLog.printLog(4, localObject.getMessage());
      AppMethodBeat.o(228491);
    }
    return 1000001;
  }
  
  public int prepare()
  {
    AppMethodBeat.i(228473);
    try
    {
      int i = _prepare();
      AppMethodBeat.o(228473);
      return i;
    }
    finally
    {
      TPNativeLog.printLog(4, localObject.getMessage());
      AppMethodBeat.o(228473);
    }
    return 1000001;
  }
  
  public int prepareAsync()
  {
    AppMethodBeat.i(228478);
    try
    {
      int i = _prepareAsync();
      AppMethodBeat.o(228478);
      return i;
    }
    finally
    {
      TPNativeLog.printLog(4, localObject.getMessage());
      AppMethodBeat.o(228478);
    }
    return 1000001;
  }
  
  public void release()
  {
    AppMethodBeat.i(228509);
    try
    {
      _release();
      AppMethodBeat.o(228509);
      return;
    }
    finally
    {
      TPNativeLog.printLog(4, localObject.getMessage());
      AppMethodBeat.o(228509);
    }
  }
  
  public void reset()
  {
    AppMethodBeat.i(228502);
    try
    {
      _reset();
      AppMethodBeat.o(228502);
      return;
    }
    finally
    {
      TPNativeLog.printLog(4, localObject.getMessage());
      AppMethodBeat.o(228502);
    }
  }
  
  public int seekToAsync(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(228512);
    try
    {
      paramInt1 = _seekToAsync(paramInt1, paramInt2, paramLong);
      AppMethodBeat.o(228512);
      return paramInt1;
    }
    finally
    {
      TPNativeLog.printLog(4, localObject.getMessage());
      AppMethodBeat.o(228512);
    }
    return 1000001;
  }
  
  public int selectProgramAsync(int paramInt, long paramLong)
  {
    AppMethodBeat.i(228725);
    try
    {
      paramInt = _selectProgramAsync(paramInt, paramLong);
      AppMethodBeat.o(228725);
      return paramInt;
    }
    finally
    {
      TPNativeLog.printLog(4, localObject.getMessage());
      AppMethodBeat.o(228725);
    }
    return 1000001;
  }
  
  public int selectTrackAsync(int paramInt, long paramLong)
  {
    AppMethodBeat.i(228699);
    try
    {
      paramInt = _selectTrackAsync(paramInt, paramLong);
      AppMethodBeat.o(228699);
      return paramInt;
    }
    finally
    {
      TPNativeLog.printLog(4, localObject.getMessage());
      AppMethodBeat.o(228699);
    }
    return 1000001;
  }
  
  public int setAudioFrameCallback(ITPNativePlayerAudioFrameCallback paramITPNativePlayerAudioFrameCallback)
  {
    AppMethodBeat.i(228603);
    try
    {
      int i = _setAudioFrameCallback(paramITPNativePlayerAudioFrameCallback);
      AppMethodBeat.o(228603);
      return i;
    }
    finally
    {
      TPNativeLog.printLog(4, paramITPNativePlayerAudioFrameCallback.getMessage());
      AppMethodBeat.o(228603);
    }
    return 1000001;
  }
  
  public int setAudioMute(boolean paramBoolean)
  {
    AppMethodBeat.i(228552);
    try
    {
      int i = _setAudioMute(paramBoolean);
      AppMethodBeat.o(228552);
      return i;
    }
    finally
    {
      TPNativeLog.printLog(4, localObject.getMessage());
      AppMethodBeat.o(228552);
    }
    return 1000001;
  }
  
  public int setAudioNormalizeVolumeParams(String paramString)
  {
    AppMethodBeat.i(228560);
    try
    {
      int i = _setAudioNormalizeVolumeParams(paramString);
      AppMethodBeat.o(228560);
      return i;
    }
    finally
    {
      TPNativeLog.printLog(4, paramString.getMessage());
      AppMethodBeat.o(228560);
    }
    return 1000001;
  }
  
  public int setAudioVolume(float paramFloat)
  {
    AppMethodBeat.i(228545);
    try
    {
      int i = _setAudioVolume(paramFloat);
      AppMethodBeat.o(228545);
      return i;
    }
    finally
    {
      TPNativeLog.printLog(4, localObject.getMessage());
      AppMethodBeat.o(228545);
    }
    return 1000001;
  }
  
  public int setDataSource(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(228465);
    try
    {
      paramInt = _setDataSourceFd(paramInt, paramLong1, paramLong2);
      AppMethodBeat.o(228465);
      return paramInt;
    }
    finally
    {
      TPNativeLog.printLog(4, localObject.getMessage());
      AppMethodBeat.o(228465);
    }
    return 1000001;
  }
  
  public int setDataSource(String paramString)
  {
    AppMethodBeat.i(228440);
    try
    {
      int i = _setDataSource(paramString);
      AppMethodBeat.o(228440);
      return i;
    }
    finally
    {
      TPNativeLog.printLog(4, paramString.getMessage());
      AppMethodBeat.o(228440);
    }
    return 1000001;
  }
  
  public int setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(228443);
    if (paramMap != null) {}
    for (;;)
    {
      try
      {
        String[] arrayOfString;
        if (paramMap.size() != 0)
        {
          arrayOfString = new String[paramMap.size() * 2];
          Iterator localIterator = paramMap.keySet().iterator();
          int i = 0;
          if (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            arrayOfString[(i * 2)] = str;
            arrayOfString[(i * 2 + 1)] = ((String)paramMap.get(str));
            i += 1;
            continue;
            i = _setDataSourceWithHttpHeader(paramString, paramMap);
            AppMethodBeat.o(228443);
            return i;
          }
        }
        else
        {
          paramMap = new String[0];
          continue;
        }
        paramMap = arrayOfString;
      }
      finally
      {
        TPNativeLog.printLog(4, paramString.getMessage());
        AppMethodBeat.o(228443);
        return 1000001;
      }
    }
  }
  
  public int setDemuxerCallback(ITPDemuxerCallback paramITPDemuxerCallback)
  {
    AppMethodBeat.i(228620);
    try
    {
      int i = _setDemuxerCallback(paramITPDemuxerCallback);
      AppMethodBeat.o(228620);
      return i;
    }
    finally
    {
      TPNativeLog.printLog(4, paramITPDemuxerCallback.getMessage());
      AppMethodBeat.o(228620);
    }
    return 1000001;
  }
  
  public void setInitConfig(TPNativePlayerInitConfig paramTPNativePlayerInitConfig)
  {
    AppMethodBeat.i(228438);
    Object localObject6;
    Object localObject5;
    try
    {
      _resetInitConfig();
      localObject6 = paramTPNativePlayerInitConfig.getIntMap();
      localObject5 = paramTPNativePlayerInitConfig.getStringMap();
      localObject4 = paramTPNativePlayerInitConfig.getLongMap();
      localObject3 = paramTPNativePlayerInitConfig.getFloatMap();
      localObject2 = paramTPNativePlayerInitConfig.getBoolMap();
      localObject1 = paramTPNativePlayerInitConfig.getQueueIntMap();
      localObject6 = ((HashMap)localObject6).entrySet().iterator();
      while (((Iterator)localObject6).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject6).next();
        _setInitConfigInt(((Integer)localEntry.getKey()).intValue(), ((Integer)localEntry.getValue()).intValue());
      }
      localObject5 = ((HashMap)localObject5).entrySet().iterator();
    }
    finally
    {
      TPNativeLog.printLog(4, paramTPNativePlayerInitConfig.getMessage());
      AppMethodBeat.o(228438);
      return;
    }
    while (((Iterator)localObject5).hasNext())
    {
      localObject6 = (Map.Entry)((Iterator)localObject5).next();
      _setInitConfigString(((Integer)((Map.Entry)localObject6).getKey()).intValue(), (String)((Map.Entry)localObject6).getValue());
    }
    Object localObject4 = ((HashMap)localObject4).entrySet().iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = (Map.Entry)((Iterator)localObject4).next();
      _setInitConfigLong(((Integer)((Map.Entry)localObject5).getKey()).intValue(), ((Long)((Map.Entry)localObject5).getValue()).longValue());
    }
    Object localObject3 = ((HashMap)localObject3).entrySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (Map.Entry)((Iterator)localObject3).next();
      _setInitConfigFloat(((Integer)((Map.Entry)localObject4).getKey()).intValue(), ((Float)((Map.Entry)localObject4).getValue()).floatValue());
    }
    Object localObject2 = ((HashMap)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      _setInitConfigBool(((Integer)((Map.Entry)localObject3).getKey()).intValue(), ((Boolean)((Map.Entry)localObject3).getValue()).booleanValue());
    }
    Object localObject1 = ((HashMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = (Vector)((Map.Entry)localObject2).getValue();
      if (localObject3 != null)
      {
        localObject3 = ((Vector)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          int i = ((Integer)((Iterator)localObject3).next()).intValue();
          _addInitConfigQueueInt(((Integer)((Map.Entry)localObject2).getKey()).intValue(), i);
        }
      }
    }
    paramTPNativePlayerInitConfig = paramTPNativePlayerInitConfig.getQueueStringMap().entrySet().iterator();
    while (paramTPNativePlayerInitConfig.hasNext())
    {
      localObject1 = (Map.Entry)paramTPNativePlayerInitConfig.next();
      localObject2 = (Vector)((Map.Entry)localObject1).getValue();
      if (localObject2 != null)
      {
        localObject2 = ((Vector)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          _addInitConfigQueueString(((Integer)((Map.Entry)localObject1).getKey()).intValue(), (String)localObject3);
        }
      }
    }
    _applyInitConfig();
    AppMethodBeat.o(228438);
  }
  
  public int setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(228590);
    try
    {
      int i = _setLoopback(paramBoolean, paramLong1, paramLong2);
      AppMethodBeat.o(228590);
      return i;
    }
    finally
    {
      TPNativeLog.printLog(4, localObject.getMessage());
      AppMethodBeat.o(228590);
    }
    return 1000001;
  }
  
  public int setMessageCallback(ITPNativePlayerMessageCallback paramITPNativePlayerMessageCallback)
  {
    AppMethodBeat.i(228595);
    try
    {
      int i = _setMessageCallback(paramITPNativePlayerMessageCallback);
      AppMethodBeat.o(228595);
      return i;
    }
    finally
    {
      TPNativeLog.printLog(4, paramITPNativePlayerMessageCallback.getMessage());
      AppMethodBeat.o(228595);
    }
    return 1000001;
  }
  
  public int setOptionLong(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(228533);
    try
    {
      paramInt = _setOptionLong(paramInt, paramLong1, paramLong2);
      AppMethodBeat.o(228533);
      return paramInt;
    }
    finally
    {
      TPNativeLog.printLog(4, localObject.getMessage());
      AppMethodBeat.o(228533);
    }
    return 1000001;
  }
  
  public int setOptionObject(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(228537);
    try
    {
      paramInt = _setOptionObject(paramInt, paramObject);
      AppMethodBeat.o(228537);
      return paramInt;
    }
    finally
    {
      TPNativeLog.printLog(4, paramObject.getMessage());
      AppMethodBeat.o(228537);
    }
    return 1000001;
  }
  
  public int setPlaySharpenSwitch()
  {
    AppMethodBeat.i(228574);
    try
    {
      int i = _setPlaySharpenSwitch();
      AppMethodBeat.o(228574);
      return i;
    }
    finally
    {
      TPNativeLog.printLog(4, localObject.getMessage());
      AppMethodBeat.o(228574);
    }
    return 1000001;
  }
  
  public int setPlaybackRate(float paramFloat)
  {
    AppMethodBeat.i(228568);
    try
    {
      int i = _setPlaybackRate(paramFloat);
      AppMethodBeat.o(228568);
      return i;
    }
    finally
    {
      TPNativeLog.printLog(4, localObject.getMessage());
      AppMethodBeat.o(228568);
    }
    return 1000001;
  }
  
  public int setPostProcessFrameCallback(ITPNativePlayerPostProcessFrameCallback paramITPNativePlayerPostProcessFrameCallback)
  {
    AppMethodBeat.i(228626);
    try
    {
      int i = _setPostProcessFrameCallback(paramITPNativePlayerPostProcessFrameCallback);
      AppMethodBeat.o(228626);
      return i;
    }
    finally
    {
      TPNativeLog.printLog(4, paramITPNativePlayerPostProcessFrameCallback.getMessage());
      AppMethodBeat.o(228626);
    }
    return 1000001;
  }
  
  public int setSubtitleFrameCallback(ITPNativePlayerSubtitleFrameCallback paramITPNativePlayerSubtitleFrameCallback)
  {
    AppMethodBeat.i(228616);
    try
    {
      int i = _setSubtitleFrameCallback(paramITPNativePlayerSubtitleFrameCallback);
      AppMethodBeat.o(228616);
      return i;
    }
    finally
    {
      TPNativeLog.printLog(4, paramITPNativePlayerSubtitleFrameCallback.getMessage());
      AppMethodBeat.o(228616);
    }
    return 1000001;
  }
  
  public int setVideoFrameCallback(ITPNativePlayerVideoFrameCallback paramITPNativePlayerVideoFrameCallback)
  {
    AppMethodBeat.i(228610);
    try
    {
      int i = _setVideoFrameCallback(paramITPNativePlayerVideoFrameCallback);
      AppMethodBeat.o(228610);
      return i;
    }
    finally
    {
      TPNativeLog.printLog(4, paramITPNativePlayerVideoFrameCallback.getMessage());
      AppMethodBeat.o(228610);
    }
    return 1000001;
  }
  
  public int setVideoSurface(Surface paramSurface)
  {
    AppMethodBeat.i(228579);
    try
    {
      int i = _setVideoSurface(paramSurface);
      AppMethodBeat.o(228579);
      return i;
    }
    finally
    {
      TPNativeLog.printLog(4, paramSurface.getMessage());
      AppMethodBeat.o(228579);
    }
    return 1000001;
  }
  
  public int setVideoSurfaceWithType(Surface paramSurface, int paramInt)
  {
    AppMethodBeat.i(228585);
    try
    {
      paramInt = _setVideoSurfaceWithType(paramSurface, paramInt);
      AppMethodBeat.o(228585);
      return paramInt;
    }
    finally
    {
      TPNativeLog.printLog(4, paramSurface.getMessage());
      AppMethodBeat.o(228585);
    }
    return 1000001;
  }
  
  public int start()
  {
    AppMethodBeat.i(228485);
    try
    {
      int i = _start();
      AppMethodBeat.o(228485);
      return i;
    }
    finally
    {
      TPNativeLog.printLog(4, localObject.getMessage());
      AppMethodBeat.o(228485);
    }
    return 1000001;
  }
  
  public int stop()
  {
    AppMethodBeat.i(228497);
    try
    {
      int i = _stop();
      AppMethodBeat.o(228497);
      return i;
    }
    finally
    {
      TPNativeLog.printLog(4, localObject.getMessage());
      AppMethodBeat.o(228497);
    }
    return 1000001;
  }
  
  public int switchDefinitionAsync(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(228525);
    try
    {
      paramInt = _switchDefinitionAsync(paramString, paramInt, paramLong);
      AppMethodBeat.o(228525);
      return paramInt;
    }
    finally
    {
      TPNativeLog.printLog(4, paramString.getMessage());
      AppMethodBeat.o(228525);
    }
    return 1000001;
  }
  
  @Deprecated
  public int switchDefinitionAsync(String paramString, long paramLong)
  {
    AppMethodBeat.i(228519);
    int i = switchDefinitionAsync(paramString, 0, paramLong);
    AppMethodBeat.o(228519);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.player.TPNativePlayer
 * JD-Core Version:    0.7.0.1
 */