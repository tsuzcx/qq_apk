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
    AppMethodBeat.i(223699);
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
      AppMethodBeat.o(223699);
      return;
    }
    catch (Throwable paramContext)
    {
      TPNativeLog.printLog(4, "Failed to create native player:" + paramContext.getMessage());
      paramContext = new UnsupportedOperationException("Failed to create native player");
      AppMethodBeat.o(223699);
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
    AppMethodBeat.i(223813);
    try
    {
      int i = _addAudioTrackSource(paramString1, paramString2);
      AppMethodBeat.o(223813);
      return i;
    }
    catch (Throwable paramString1)
    {
      TPNativeLog.printLog(4, paramString1.getMessage());
      AppMethodBeat.o(223813);
    }
    return 1000001;
  }
  
  public int addSubtitleTrackSource(String paramString1, String paramString2)
  {
    AppMethodBeat.i(223811);
    try
    {
      int i = _addSubtitleTrackSource(paramString1, paramString2);
      AppMethodBeat.o(223811);
      return i;
    }
    catch (Throwable paramString1)
    {
      TPNativeLog.printLog(4, paramString1.getMessage());
      AppMethodBeat.o(223811);
    }
    return 1000001;
  }
  
  public int deselectTrackAsync(int paramInt, long paramLong)
  {
    AppMethodBeat.i(223815);
    try
    {
      paramInt = _deselectTrackAsync(paramInt, paramLong);
      AppMethodBeat.o(223815);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(223815);
    }
    return 1000001;
  }
  
  public long getBufferedDurationMs()
  {
    AppMethodBeat.i(223807);
    try
    {
      long l = _getBufferedDurationMs();
      AppMethodBeat.o(223807);
      return l;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(223807);
    }
    return 0L;
  }
  
  public long getBufferedSize()
  {
    AppMethodBeat.i(223808);
    try
    {
      long l = _getBufferedSize();
      AppMethodBeat.o(223808);
      return l;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(223808);
    }
    return 0L;
  }
  
  public long getCurrentPositionMs()
  {
    AppMethodBeat.i(223805);
    try
    {
      long l = _getCurrentPositionMs();
      AppMethodBeat.o(223805);
      return l;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(223805);
    }
    return 0L;
  }
  
  public long getDurationMs()
  {
    AppMethodBeat.i(223804);
    try
    {
      long l = _getDurationMs();
      AppMethodBeat.o(223804);
      return l;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(223804);
    }
    return 0L;
  }
  
  public int getPlayerID()
  {
    AppMethodBeat.i(223797);
    try
    {
      int i = _getPlayerID();
      AppMethodBeat.o(223797);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(223797);
    }
    return 0;
  }
  
  public int getProgramCount()
  {
    AppMethodBeat.i(223820);
    try
    {
      int i = _getProgramCount();
      AppMethodBeat.o(223820);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(223820);
    }
    return 1000001;
  }
  
  public TPNativePlayerProgramInfo[] getProgramInfo()
  {
    AppMethodBeat.i(223825);
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
      AppMethodBeat.o(223825);
      return arrayOfTPNativePlayerProgramInfo;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(223825);
    }
    return null;
  }
  
  public long getPropertyLong(int paramInt)
  {
    AppMethodBeat.i(223799);
    try
    {
      long l = _getPropertyLong(paramInt);
      AppMethodBeat.o(223799);
      return l;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(223799);
    }
    return 0L;
  }
  
  public String getPropertyString(int paramInt)
  {
    AppMethodBeat.i(223800);
    try
    {
      String str = _getPropertyString(paramInt);
      AppMethodBeat.o(223800);
      return str;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(223800);
    }
    return "";
  }
  
  public TPMediaTrackInfo[] getTrackInfo()
  {
    AppMethodBeat.i(223819);
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
      AppMethodBeat.o(223819);
      return arrayOfTPMediaTrackInfo1;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(223819);
    }
    return null;
  }
  
  public int getVideoHeight()
  {
    AppMethodBeat.i(223802);
    try
    {
      int i = _getVideoHeight();
      AppMethodBeat.o(223802);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(223802);
    }
    return 0;
  }
  
  public int getVideoWidth()
  {
    AppMethodBeat.i(223801);
    try
    {
      int i = _getVideoWidth();
      AppMethodBeat.o(223801);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(223801);
    }
    return 0;
  }
  
  public int pause()
  {
    AppMethodBeat.i(223723);
    try
    {
      int i = _pause();
      AppMethodBeat.o(223723);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(223723);
    }
    return 1000001;
  }
  
  public int prepare()
  {
    AppMethodBeat.i(223716);
    try
    {
      int i = _prepare();
      AppMethodBeat.o(223716);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(223716);
    }
    return 1000001;
  }
  
  public int prepareAsync()
  {
    AppMethodBeat.i(223719);
    try
    {
      int i = _prepareAsync();
      AppMethodBeat.o(223719);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(223719);
    }
    return 1000001;
  }
  
  public void release()
  {
    AppMethodBeat.i(223729);
    try
    {
      _release();
      AppMethodBeat.o(223729);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(223729);
    }
  }
  
  public void reset()
  {
    AppMethodBeat.i(223728);
    try
    {
      _reset();
      AppMethodBeat.o(223728);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(223728);
    }
  }
  
  public int seekToAsync(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(223731);
    try
    {
      paramInt1 = _seekToAsync(paramInt1, paramInt2, paramLong);
      AppMethodBeat.o(223731);
      return paramInt1;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(223731);
    }
    return 1000001;
  }
  
  public int selectProgramAsync(int paramInt, long paramLong)
  {
    AppMethodBeat.i(223821);
    try
    {
      paramInt = _selectProgramAsync(paramInt, paramLong);
      AppMethodBeat.o(223821);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(223821);
    }
    return 1000001;
  }
  
  public int selectTrackAsync(int paramInt, long paramLong)
  {
    AppMethodBeat.i(223814);
    try
    {
      paramInt = _selectTrackAsync(paramInt, paramLong);
      AppMethodBeat.o(223814);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(223814);
    }
    return 1000001;
  }
  
  public int setAudioFrameCallback(ITPNativePlayerAudioFrameCallback paramITPNativePlayerAudioFrameCallback)
  {
    AppMethodBeat.i(223783);
    try
    {
      int i = _setAudioFrameCallback(paramITPNativePlayerAudioFrameCallback);
      AppMethodBeat.o(223783);
      return i;
    }
    catch (Throwable paramITPNativePlayerAudioFrameCallback)
    {
      TPNativeLog.printLog(4, paramITPNativePlayerAudioFrameCallback.getMessage());
      AppMethodBeat.o(223783);
    }
    return 1000001;
  }
  
  public int setAudioMute(boolean paramBoolean)
  {
    AppMethodBeat.i(223747);
    try
    {
      int i = _setAudioMute(paramBoolean);
      AppMethodBeat.o(223747);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(223747);
    }
    return 1000001;
  }
  
  public int setAudioNormalizeVolumeParams(String paramString)
  {
    AppMethodBeat.i(223751);
    try
    {
      int i = _setAudioNormalizeVolumeParams(paramString);
      AppMethodBeat.o(223751);
      return i;
    }
    catch (Throwable paramString)
    {
      TPNativeLog.printLog(4, paramString.getMessage());
      AppMethodBeat.o(223751);
    }
    return 1000001;
  }
  
  public int setAudioVolume(float paramFloat)
  {
    AppMethodBeat.i(223745);
    try
    {
      int i = _setAudioVolume(paramFloat);
      AppMethodBeat.o(223745);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(223745);
    }
    return 1000001;
  }
  
  public int setDataSource(int paramInt)
  {
    AppMethodBeat.i(223714);
    try
    {
      paramInt = _setDataSourceFd(paramInt);
      AppMethodBeat.o(223714);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(223714);
    }
    return 1000001;
  }
  
  public int setDataSource(String paramString)
  {
    AppMethodBeat.i(223710);
    try
    {
      int i = _setDataSource(paramString);
      AppMethodBeat.o(223710);
      return i;
    }
    catch (Throwable paramString)
    {
      TPNativeLog.printLog(4, paramString.getMessage());
      AppMethodBeat.o(223710);
    }
    return 1000001;
  }
  
  public int setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(223713);
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
            AppMethodBeat.o(223713);
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
        AppMethodBeat.o(223713);
        return 1000001;
      }
    }
  }
  
  public int setDemuxerCallback(ITPDemuxerCallback paramITPDemuxerCallback)
  {
    AppMethodBeat.i(223794);
    try
    {
      int i = _setDemuxerCallback(paramITPDemuxerCallback);
      AppMethodBeat.o(223794);
      return i;
    }
    catch (Throwable paramITPDemuxerCallback)
    {
      TPNativeLog.printLog(4, paramITPDemuxerCallback.getMessage());
      AppMethodBeat.o(223794);
    }
    return 1000001;
  }
  
  public void setInitConfig(TPNativePlayerInitConfig paramTPNativePlayerInitConfig)
  {
    AppMethodBeat.i(223709);
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
      AppMethodBeat.o(223709);
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
    AppMethodBeat.o(223709);
  }
  
  public int setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(223772);
    try
    {
      int i = _setLoopback(paramBoolean, paramLong1, paramLong2);
      AppMethodBeat.o(223772);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(223772);
    }
    return 1000001;
  }
  
  public int setMessageCallback(ITPNativePlayerMessageCallback paramITPNativePlayerMessageCallback)
  {
    AppMethodBeat.i(223777);
    try
    {
      int i = _setMessageCallback(paramITPNativePlayerMessageCallback);
      AppMethodBeat.o(223777);
      return i;
    }
    catch (Throwable paramITPNativePlayerMessageCallback)
    {
      TPNativeLog.printLog(4, paramITPNativePlayerMessageCallback.getMessage());
      AppMethodBeat.o(223777);
    }
    return 1000001;
  }
  
  public int setOptionLong(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(223738);
    try
    {
      paramInt = _setOptionLong(paramInt, paramLong1, paramLong2);
      AppMethodBeat.o(223738);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(223738);
    }
    return 1000001;
  }
  
  public int setOptionObject(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(223741);
    try
    {
      paramInt = _setOptionObject(paramInt, paramObject);
      AppMethodBeat.o(223741);
      return paramInt;
    }
    catch (Throwable paramObject)
    {
      TPNativeLog.printLog(4, paramObject.getMessage());
      AppMethodBeat.o(223741);
    }
    return 1000001;
  }
  
  public int setPlaybackRate(float paramFloat)
  {
    AppMethodBeat.i(223755);
    try
    {
      int i = _setPlaybackRate(paramFloat);
      AppMethodBeat.o(223755);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(223755);
    }
    return 1000001;
  }
  
  public int setPostProcessFrameCallback(ITPNativePlayerPostProcessFrameCallback paramITPNativePlayerPostProcessFrameCallback)
  {
    AppMethodBeat.i(223795);
    try
    {
      int i = _setPostProcessFrameCallback(paramITPNativePlayerPostProcessFrameCallback);
      AppMethodBeat.o(223795);
      return i;
    }
    catch (Throwable paramITPNativePlayerPostProcessFrameCallback)
    {
      TPNativeLog.printLog(4, paramITPNativePlayerPostProcessFrameCallback.getMessage());
      AppMethodBeat.o(223795);
    }
    return 1000001;
  }
  
  public int setSubtitleFrameCallback(ITPNativePlayerSubtitleFrameCallback paramITPNativePlayerSubtitleFrameCallback)
  {
    AppMethodBeat.i(223791);
    try
    {
      int i = _setSubtitleFrameCallback(paramITPNativePlayerSubtitleFrameCallback);
      AppMethodBeat.o(223791);
      return i;
    }
    catch (Throwable paramITPNativePlayerSubtitleFrameCallback)
    {
      TPNativeLog.printLog(4, paramITPNativePlayerSubtitleFrameCallback.getMessage());
      AppMethodBeat.o(223791);
    }
    return 1000001;
  }
  
  public int setVideoFrameCallback(ITPNativePlayerVideoFrameCallback paramITPNativePlayerVideoFrameCallback)
  {
    AppMethodBeat.i(223788);
    try
    {
      int i = _setVideoFrameCallback(paramITPNativePlayerVideoFrameCallback);
      AppMethodBeat.o(223788);
      return i;
    }
    catch (Throwable paramITPNativePlayerVideoFrameCallback)
    {
      TPNativeLog.printLog(4, paramITPNativePlayerVideoFrameCallback.getMessage());
      AppMethodBeat.o(223788);
    }
    return 1000001;
  }
  
  public int setVideoSurface(Surface paramSurface)
  {
    AppMethodBeat.i(223759);
    try
    {
      int i = _setVideoSurface(paramSurface);
      AppMethodBeat.o(223759);
      return i;
    }
    catch (Throwable paramSurface)
    {
      TPNativeLog.printLog(4, paramSurface.getMessage());
      AppMethodBeat.o(223759);
    }
    return 1000001;
  }
  
  public int setVideoSurfaceWithType(Surface paramSurface, int paramInt)
  {
    AppMethodBeat.i(223766);
    try
    {
      paramInt = _setVideoSurfaceWithType(paramSurface, paramInt);
      AppMethodBeat.o(223766);
      return paramInt;
    }
    catch (Throwable paramSurface)
    {
      TPNativeLog.printLog(4, paramSurface.getMessage());
      AppMethodBeat.o(223766);
    }
    return 1000001;
  }
  
  public int start()
  {
    AppMethodBeat.i(223721);
    try
    {
      int i = _start();
      AppMethodBeat.o(223721);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(223721);
    }
    return 1000001;
  }
  
  public int stop()
  {
    AppMethodBeat.i(223726);
    try
    {
      int i = _stop();
      AppMethodBeat.o(223726);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(223726);
    }
    return 1000001;
  }
  
  public int switchDefinitionAsync(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(223735);
    try
    {
      paramInt = _switchDefinitionAsync(paramString, paramInt, paramLong);
      AppMethodBeat.o(223735);
      return paramInt;
    }
    catch (Throwable paramString)
    {
      TPNativeLog.printLog(4, paramString.getMessage());
      AppMethodBeat.o(223735);
    }
    return 1000001;
  }
  
  @Deprecated
  public int switchDefinitionAsync(String paramString, long paramLong)
  {
    AppMethodBeat.i(223732);
    int i = switchDefinitionAsync(paramString, 0, paramLong);
    AppMethodBeat.o(223732);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.core.player.TPNativePlayer
 * JD-Core Version:    0.7.0.1
 */