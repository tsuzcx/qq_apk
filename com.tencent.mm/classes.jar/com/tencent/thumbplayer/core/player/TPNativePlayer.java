package com.tencent.thumbplayer.core.player;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPAudioPassThroughPluginDetector;
import com.tencent.thumbplayer.core.common.TPFieldCalledByNative;
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
  @TPFieldCalledByNative
  private long mNativeContext;
  private int m_playerID;
  
  public TPNativePlayer(Context paramContext)
  {
    AppMethodBeat.i(189938);
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
      AppMethodBeat.o(189938);
      return;
    }
    catch (Throwable paramContext)
    {
      TPNativeLog.printLog(4, "Failed to create native player:" + paramContext.getMessage());
      paramContext = new UnsupportedOperationException("Failed to create native player");
      AppMethodBeat.o(189938);
      throw paramContext;
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
  
  private native int _setDataSourceFd(int paramInt);
  
  private native int _setDataSourceWithHttpHeader(String paramString, Object[] paramArrayOfObject);
  
  private native int _setDemuxerCallback(Object paramObject);
  
  private native int _setInitConfigBool(int paramInt, boolean paramBoolean);
  
  private native int _setInitConfigFloat(int paramInt, float paramFloat);
  
  private native int _setInitConfigInt(int paramInt1, int paramInt2);
  
  private native int _setInitConfigLong(int paramInt, long paramLong);
  
  private native int _setLoopback(boolean paramBoolean, long paramLong1, long paramLong2);
  
  private native int _setMessageCallback(Object paramObject);
  
  private native int _setOptionLong(int paramInt, long paramLong1, long paramLong2);
  
  private native int _setOptionObject(int paramInt, Object paramObject);
  
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
    AppMethodBeat.i(189978);
    try
    {
      int i = _addAudioTrackSource(paramString1, paramString2);
      AppMethodBeat.o(189978);
      return i;
    }
    catch (Throwable paramString1)
    {
      TPNativeLog.printLog(4, paramString1.getMessage());
      AppMethodBeat.o(189978);
    }
    return 1000001;
  }
  
  public int addSubtitleTrackSource(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189977);
    try
    {
      int i = _addSubtitleTrackSource(paramString1, paramString2);
      AppMethodBeat.o(189977);
      return i;
    }
    catch (Throwable paramString1)
    {
      TPNativeLog.printLog(4, paramString1.getMessage());
      AppMethodBeat.o(189977);
    }
    return 1000001;
  }
  
  public int deselectTrackAsync(int paramInt, long paramLong)
  {
    AppMethodBeat.i(189980);
    try
    {
      paramInt = _deselectTrackAsync(paramInt, paramLong);
      AppMethodBeat.o(189980);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(189980);
    }
    return 1000001;
  }
  
  public long getBufferedDurationMs()
  {
    AppMethodBeat.i(189975);
    try
    {
      long l = _getBufferedDurationMs();
      AppMethodBeat.o(189975);
      return l;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(189975);
    }
    return 0L;
  }
  
  public long getBufferedSize()
  {
    AppMethodBeat.i(189976);
    try
    {
      long l = _getBufferedSize();
      AppMethodBeat.o(189976);
      return l;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(189976);
    }
    return 0L;
  }
  
  public long getCurrentPositionMs()
  {
    AppMethodBeat.i(189974);
    try
    {
      long l = _getCurrentPositionMs();
      AppMethodBeat.o(189974);
      return l;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(189974);
    }
    return 0L;
  }
  
  public long getDurationMs()
  {
    AppMethodBeat.i(189973);
    try
    {
      long l = _getDurationMs();
      AppMethodBeat.o(189973);
      return l;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(189973);
    }
    return 0L;
  }
  
  public int getPlayerID()
  {
    AppMethodBeat.i(189968);
    try
    {
      int i = _getPlayerID();
      AppMethodBeat.o(189968);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(189968);
    }
    return 0;
  }
  
  public int getProgramCount()
  {
    AppMethodBeat.i(189982);
    try
    {
      int i = _getProgramCount();
      AppMethodBeat.o(189982);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(189982);
    }
    return 1000001;
  }
  
  public TPNativePlayerProgramInfo[] getProgramInfo()
  {
    AppMethodBeat.i(189984);
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
      AppMethodBeat.o(189984);
      return arrayOfTPNativePlayerProgramInfo;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(189984);
    }
    return null;
  }
  
  public long getPropertyLong(int paramInt)
  {
    AppMethodBeat.i(189969);
    try
    {
      long l = _getPropertyLong(paramInt);
      AppMethodBeat.o(189969);
      return l;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(189969);
    }
    return 0L;
  }
  
  public String getPropertyString(int paramInt)
  {
    AppMethodBeat.i(189970);
    try
    {
      String str = _getPropertyString(paramInt);
      AppMethodBeat.o(189970);
      return str;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(189970);
    }
    return "";
  }
  
  public TPMediaTrackInfo[] getTrackInfo()
  {
    AppMethodBeat.i(189981);
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
      AppMethodBeat.o(189981);
      return arrayOfTPMediaTrackInfo1;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(189981);
    }
    return null;
  }
  
  public int getVideoHeight()
  {
    AppMethodBeat.i(189972);
    try
    {
      int i = _getVideoHeight();
      AppMethodBeat.o(189972);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(189972);
    }
    return 0;
  }
  
  public int getVideoWidth()
  {
    AppMethodBeat.i(189971);
    try
    {
      int i = _getVideoWidth();
      AppMethodBeat.o(189971);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(189971);
    }
    return 0;
  }
  
  public int pause()
  {
    AppMethodBeat.i(189946);
    try
    {
      int i = _pause();
      AppMethodBeat.o(189946);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(189946);
    }
    return 1000001;
  }
  
  public int prepare()
  {
    AppMethodBeat.i(189943);
    try
    {
      int i = _prepare();
      AppMethodBeat.o(189943);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(189943);
    }
    return 1000001;
  }
  
  public int prepareAsync()
  {
    AppMethodBeat.i(189944);
    try
    {
      int i = _prepareAsync();
      AppMethodBeat.o(189944);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(189944);
    }
    return 1000001;
  }
  
  public void release()
  {
    AppMethodBeat.i(189949);
    try
    {
      _release();
      AppMethodBeat.o(189949);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(189949);
    }
  }
  
  public void reset()
  {
    AppMethodBeat.i(189948);
    try
    {
      _reset();
      AppMethodBeat.o(189948);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(189948);
    }
  }
  
  public int seekToAsync(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(189950);
    try
    {
      paramInt1 = _seekToAsync(paramInt1, paramInt2, paramLong);
      AppMethodBeat.o(189950);
      return paramInt1;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(189950);
    }
    return 1000001;
  }
  
  public int selectProgramAsync(int paramInt, long paramLong)
  {
    AppMethodBeat.i(189983);
    try
    {
      paramInt = _selectProgramAsync(paramInt, paramLong);
      AppMethodBeat.o(189983);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(189983);
    }
    return 1000001;
  }
  
  public int selectTrackAsync(int paramInt, long paramLong)
  {
    AppMethodBeat.i(189979);
    try
    {
      paramInt = _selectTrackAsync(paramInt, paramLong);
      AppMethodBeat.o(189979);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(189979);
    }
    return 1000001;
  }
  
  public int setAudioFrameCallback(ITPNativePlayerAudioFrameCallback paramITPNativePlayerAudioFrameCallback)
  {
    AppMethodBeat.i(189963);
    try
    {
      int i = _setAudioFrameCallback(paramITPNativePlayerAudioFrameCallback);
      AppMethodBeat.o(189963);
      return i;
    }
    catch (Throwable paramITPNativePlayerAudioFrameCallback)
    {
      TPNativeLog.printLog(4, paramITPNativePlayerAudioFrameCallback.getMessage());
      AppMethodBeat.o(189963);
    }
    return 1000001;
  }
  
  public int setAudioMute(boolean paramBoolean)
  {
    AppMethodBeat.i(189956);
    try
    {
      int i = _setAudioMute(paramBoolean);
      AppMethodBeat.o(189956);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(189956);
    }
    return 1000001;
  }
  
  public int setAudioNormalizeVolumeParams(String paramString)
  {
    AppMethodBeat.i(189957);
    try
    {
      int i = _setAudioNormalizeVolumeParams(paramString);
      AppMethodBeat.o(189957);
      return i;
    }
    catch (Throwable paramString)
    {
      TPNativeLog.printLog(4, paramString.getMessage());
      AppMethodBeat.o(189957);
    }
    return 1000001;
  }
  
  public int setAudioVolume(float paramFloat)
  {
    AppMethodBeat.i(189955);
    try
    {
      int i = _setAudioVolume(paramFloat);
      AppMethodBeat.o(189955);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(189955);
    }
    return 1000001;
  }
  
  public int setDataSource(int paramInt)
  {
    AppMethodBeat.i(189942);
    try
    {
      paramInt = _setDataSourceFd(paramInt);
      AppMethodBeat.o(189942);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(189942);
    }
    return 1000001;
  }
  
  public int setDataSource(String paramString)
  {
    AppMethodBeat.i(189940);
    try
    {
      int i = _setDataSource(paramString);
      AppMethodBeat.o(189940);
      return i;
    }
    catch (Throwable paramString)
    {
      TPNativeLog.printLog(4, paramString.getMessage());
      AppMethodBeat.o(189940);
    }
    return 1000001;
  }
  
  public int setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(189941);
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
            AppMethodBeat.o(189941);
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
      catch (Throwable paramString)
      {
        TPNativeLog.printLog(4, paramString.getMessage());
        AppMethodBeat.o(189941);
        return 1000001;
      }
    }
  }
  
  public int setDemuxerCallback(ITPDemuxerCallback paramITPDemuxerCallback)
  {
    AppMethodBeat.i(189966);
    try
    {
      int i = _setDemuxerCallback(paramITPDemuxerCallback);
      AppMethodBeat.o(189966);
      return i;
    }
    catch (Throwable paramITPDemuxerCallback)
    {
      TPNativeLog.printLog(4, paramITPDemuxerCallback.getMessage());
      AppMethodBeat.o(189966);
    }
    return 1000001;
  }
  
  public void setInitConfig(TPNativePlayerInitConfig paramTPNativePlayerInitConfig)
  {
    AppMethodBeat.i(189939);
    Object localObject5;
    Object localObject4;
    try
    {
      _resetInitConfig();
      localObject5 = paramTPNativePlayerInitConfig.getIntMap();
      localObject4 = paramTPNativePlayerInitConfig.getLongMap();
      localObject3 = paramTPNativePlayerInitConfig.getFloatMap();
      localObject2 = paramTPNativePlayerInitConfig.getBoolMap();
      localObject1 = paramTPNativePlayerInitConfig.getQueueIntMap();
      localObject5 = ((HashMap)localObject5).entrySet().iterator();
      while (((Iterator)localObject5).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject5).next();
        _setInitConfigInt(((Integer)localEntry.getKey()).intValue(), ((Integer)localEntry.getValue()).intValue());
      }
      localObject4 = ((HashMap)localObject4).entrySet().iterator();
    }
    catch (Throwable paramTPNativePlayerInitConfig)
    {
      TPNativeLog.printLog(4, paramTPNativePlayerInitConfig.getMessage());
      AppMethodBeat.o(189939);
      return;
    }
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
    AppMethodBeat.o(189939);
  }
  
  public int setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(189961);
    try
    {
      int i = _setLoopback(paramBoolean, paramLong1, paramLong2);
      AppMethodBeat.o(189961);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(189961);
    }
    return 1000001;
  }
  
  public int setMessageCallback(ITPNativePlayerMessageCallback paramITPNativePlayerMessageCallback)
  {
    AppMethodBeat.i(189962);
    try
    {
      int i = _setMessageCallback(paramITPNativePlayerMessageCallback);
      AppMethodBeat.o(189962);
      return i;
    }
    catch (Throwable paramITPNativePlayerMessageCallback)
    {
      TPNativeLog.printLog(4, paramITPNativePlayerMessageCallback.getMessage());
      AppMethodBeat.o(189962);
    }
    return 1000001;
  }
  
  public int setOptionLong(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(189953);
    try
    {
      paramInt = _setOptionLong(paramInt, paramLong1, paramLong2);
      AppMethodBeat.o(189953);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(189953);
    }
    return 1000001;
  }
  
  public int setOptionObject(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(189954);
    try
    {
      paramInt = _setOptionObject(paramInt, paramObject);
      AppMethodBeat.o(189954);
      return paramInt;
    }
    catch (Throwable paramObject)
    {
      TPNativeLog.printLog(4, paramObject.getMessage());
      AppMethodBeat.o(189954);
    }
    return 1000001;
  }
  
  public int setPlaybackRate(float paramFloat)
  {
    AppMethodBeat.i(189958);
    try
    {
      int i = _setPlaybackRate(paramFloat);
      AppMethodBeat.o(189958);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(189958);
    }
    return 1000001;
  }
  
  public int setPostProcessFrameCallback(ITPNativePlayerPostProcessFrameCallback paramITPNativePlayerPostProcessFrameCallback)
  {
    AppMethodBeat.i(189967);
    try
    {
      int i = _setPostProcessFrameCallback(paramITPNativePlayerPostProcessFrameCallback);
      AppMethodBeat.o(189967);
      return i;
    }
    catch (Throwable paramITPNativePlayerPostProcessFrameCallback)
    {
      TPNativeLog.printLog(4, paramITPNativePlayerPostProcessFrameCallback.getMessage());
      AppMethodBeat.o(189967);
    }
    return 1000001;
  }
  
  public int setSubtitleFrameCallback(ITPNativePlayerSubtitleFrameCallback paramITPNativePlayerSubtitleFrameCallback)
  {
    AppMethodBeat.i(189965);
    try
    {
      int i = _setSubtitleFrameCallback(paramITPNativePlayerSubtitleFrameCallback);
      AppMethodBeat.o(189965);
      return i;
    }
    catch (Throwable paramITPNativePlayerSubtitleFrameCallback)
    {
      TPNativeLog.printLog(4, paramITPNativePlayerSubtitleFrameCallback.getMessage());
      AppMethodBeat.o(189965);
    }
    return 1000001;
  }
  
  public int setVideoFrameCallback(ITPNativePlayerVideoFrameCallback paramITPNativePlayerVideoFrameCallback)
  {
    AppMethodBeat.i(189964);
    try
    {
      int i = _setVideoFrameCallback(paramITPNativePlayerVideoFrameCallback);
      AppMethodBeat.o(189964);
      return i;
    }
    catch (Throwable paramITPNativePlayerVideoFrameCallback)
    {
      TPNativeLog.printLog(4, paramITPNativePlayerVideoFrameCallback.getMessage());
      AppMethodBeat.o(189964);
    }
    return 1000001;
  }
  
  public int setVideoSurface(Surface paramSurface)
  {
    AppMethodBeat.i(189959);
    try
    {
      int i = _setVideoSurface(paramSurface);
      AppMethodBeat.o(189959);
      return i;
    }
    catch (Throwable paramSurface)
    {
      TPNativeLog.printLog(4, paramSurface.getMessage());
      AppMethodBeat.o(189959);
    }
    return 1000001;
  }
  
  public int setVideoSurfaceWithType(Surface paramSurface, int paramInt)
  {
    AppMethodBeat.i(189960);
    try
    {
      paramInt = _setVideoSurfaceWithType(paramSurface, paramInt);
      AppMethodBeat.o(189960);
      return paramInt;
    }
    catch (Throwable paramSurface)
    {
      TPNativeLog.printLog(4, paramSurface.getMessage());
      AppMethodBeat.o(189960);
    }
    return 1000001;
  }
  
  public int start()
  {
    AppMethodBeat.i(189945);
    try
    {
      int i = _start();
      AppMethodBeat.o(189945);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(189945);
    }
    return 1000001;
  }
  
  public int stop()
  {
    AppMethodBeat.i(189947);
    try
    {
      int i = _stop();
      AppMethodBeat.o(189947);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(189947);
    }
    return 1000001;
  }
  
  public int switchDefinitionAsync(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(189952);
    try
    {
      paramInt = _switchDefinitionAsync(paramString, paramInt, paramLong);
      AppMethodBeat.o(189952);
      return paramInt;
    }
    catch (Throwable paramString)
    {
      TPNativeLog.printLog(4, paramString.getMessage());
      AppMethodBeat.o(189952);
    }
    return 1000001;
  }
  
  @Deprecated
  public int switchDefinitionAsync(String paramString, long paramLong)
  {
    AppMethodBeat.i(189951);
    int i = switchDefinitionAsync(paramString, 0, paramLong);
    AppMethodBeat.o(189951);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.core.player.TPNativePlayer
 * JD-Core Version:    0.7.0.1
 */