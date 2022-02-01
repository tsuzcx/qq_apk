package com.tencent.thumbplayer.core.player;

import android.content.Context;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPAudioPassThroughPluginDetector;
import com.tencent.thumbplayer.core.common.TPFieldCalledByNative;
import com.tencent.thumbplayer.core.common.TPHeadsetPluginDetector;
import com.tencent.thumbplayer.core.common.TPMediaTrackInfo;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.core.common.TPNativeLog;
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
    AppMethodBeat.i(220666);
    this.m_playerID = -1;
    this.mContext = null;
    this.mContext = paramContext.getApplicationContext();
    TPNativeLibraryLoader.loadLibIfNeeded(paramContext);
    try
    {
      this.m_playerID = _createPlayer();
      TPHeadsetPluginDetector.init(this.mContext);
      TPAudioPassThroughPluginDetector.init(this.mContext);
      AppMethodBeat.o(220666);
      return;
    }
    catch (Throwable paramContext)
    {
      TPNativeLog.printLog(4, "Failed to create native player:" + paramContext.getMessage());
      paramContext = new UnsupportedOperationException("Failed to create native player");
      AppMethodBeat.o(220666);
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
  
  private native int _setAudioVolume(float paramFloat);
  
  private native int _setDataSource(String paramString);
  
  private native int _setDataSourceFd(int paramInt);
  
  private native int _setDataSourceWithHttpHeader(String paramString, Object[] paramArrayOfObject);
  
  private native int _setInitConfigBool(int paramInt, boolean paramBoolean);
  
  private native int _setInitConfigInt(int paramInt1, int paramInt2);
  
  private native int _setInitConfigLong(int paramInt, long paramLong);
  
  private native int _setLoopback(boolean paramBoolean, long paramLong1, long paramLong2);
  
  private native int _setMessageCallback(Object paramObject);
  
  private native int _setOptionLong(int paramInt, long paramLong1, long paramLong2);
  
  private native int _setOptionObject(int paramInt, Object paramObject);
  
  private native int _setPlaybackRate(float paramFloat);
  
  private native int _setVideoFrameCallback(Object paramObject);
  
  private native int _setVideoSurface(Surface paramSurface);
  
  private native int _start();
  
  private native int _stop();
  
  private native int _switchDefinitionAsync(String paramString, int paramInt, long paramLong);
  
  public int addAudioTrackSource(String paramString1, String paramString2)
  {
    AppMethodBeat.i(220701);
    try
    {
      int i = _addAudioTrackSource(paramString1, paramString2);
      AppMethodBeat.o(220701);
      return i;
    }
    catch (Throwable paramString1)
    {
      TPNativeLog.printLog(4, paramString1.getMessage());
      AppMethodBeat.o(220701);
    }
    return 1000001;
  }
  
  public int addSubtitleTrackSource(String paramString1, String paramString2)
  {
    AppMethodBeat.i(220700);
    try
    {
      int i = _addSubtitleTrackSource(paramString1, paramString2);
      AppMethodBeat.o(220700);
      return i;
    }
    catch (Throwable paramString1)
    {
      TPNativeLog.printLog(4, paramString1.getMessage());
      AppMethodBeat.o(220700);
    }
    return 1000001;
  }
  
  public int deselectTrackAsync(int paramInt, long paramLong)
  {
    AppMethodBeat.i(220703);
    try
    {
      paramInt = _deselectTrackAsync(paramInt, paramLong);
      AppMethodBeat.o(220703);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(220703);
    }
    return 1000001;
  }
  
  public long getBufferedDurationMs()
  {
    AppMethodBeat.i(220698);
    try
    {
      long l = _getBufferedDurationMs();
      AppMethodBeat.o(220698);
      return l;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(220698);
    }
    return 0L;
  }
  
  public long getBufferedSize()
  {
    AppMethodBeat.i(220699);
    try
    {
      long l = _getBufferedSize();
      AppMethodBeat.o(220699);
      return l;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(220699);
    }
    return 0L;
  }
  
  public long getCurrentPositionMs()
  {
    AppMethodBeat.i(220697);
    try
    {
      long l = _getCurrentPositionMs();
      AppMethodBeat.o(220697);
      return l;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(220697);
    }
    return 0L;
  }
  
  public long getDurationMs()
  {
    AppMethodBeat.i(220696);
    try
    {
      long l = _getDurationMs();
      AppMethodBeat.o(220696);
      return l;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(220696);
    }
    return 0L;
  }
  
  public int getPlayerID()
  {
    AppMethodBeat.i(220691);
    try
    {
      int i = _getPlayerID();
      AppMethodBeat.o(220691);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(220691);
    }
    return 0;
  }
  
  public int getProgramCount()
  {
    AppMethodBeat.i(220705);
    try
    {
      int i = _getProgramCount();
      AppMethodBeat.o(220705);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(220705);
    }
    return 1000001;
  }
  
  public TPNativePlayerProgramInfo[] getProgramInfo()
  {
    AppMethodBeat.i(220707);
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
      AppMethodBeat.o(220707);
      return arrayOfTPNativePlayerProgramInfo;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(220707);
    }
    return null;
  }
  
  public long getPropertyLong(int paramInt)
  {
    AppMethodBeat.i(220692);
    try
    {
      long l = _getPropertyLong(paramInt);
      AppMethodBeat.o(220692);
      return l;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(220692);
    }
    return 0L;
  }
  
  public String getPropertyString(int paramInt)
  {
    AppMethodBeat.i(220693);
    try
    {
      String str = _getPropertyString(paramInt);
      AppMethodBeat.o(220693);
      return str;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(220693);
    }
    return "";
  }
  
  public TPMediaTrackInfo[] getTrackInfo()
  {
    AppMethodBeat.i(220704);
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
      AppMethodBeat.o(220704);
      return arrayOfTPMediaTrackInfo1;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(220704);
    }
    return null;
  }
  
  public int getVideoHeight()
  {
    AppMethodBeat.i(220695);
    try
    {
      int i = _getVideoHeight();
      AppMethodBeat.o(220695);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(220695);
    }
    return 0;
  }
  
  public int getVideoWidth()
  {
    AppMethodBeat.i(220694);
    try
    {
      int i = _getVideoWidth();
      AppMethodBeat.o(220694);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(220694);
    }
    return 0;
  }
  
  public int pause()
  {
    AppMethodBeat.i(220674);
    try
    {
      int i = _pause();
      AppMethodBeat.o(220674);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(220674);
    }
    return 1000001;
  }
  
  public int prepare()
  {
    AppMethodBeat.i(220671);
    try
    {
      int i = _prepare();
      AppMethodBeat.o(220671);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(220671);
    }
    return 1000001;
  }
  
  public int prepareAsync()
  {
    AppMethodBeat.i(220672);
    try
    {
      int i = _prepareAsync();
      AppMethodBeat.o(220672);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(220672);
    }
    return 1000001;
  }
  
  public void release()
  {
    AppMethodBeat.i(220677);
    try
    {
      _release();
      AppMethodBeat.o(220677);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(220677);
    }
  }
  
  public void reset()
  {
    AppMethodBeat.i(220676);
    try
    {
      _reset();
      AppMethodBeat.o(220676);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(220676);
    }
  }
  
  public int seekToAsync(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(220678);
    try
    {
      paramInt1 = _seekToAsync(paramInt1, paramInt2, paramLong);
      AppMethodBeat.o(220678);
      return paramInt1;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(220678);
    }
    return 1000001;
  }
  
  public int selectProgramAsync(int paramInt, long paramLong)
  {
    AppMethodBeat.i(220706);
    try
    {
      paramInt = _selectProgramAsync(paramInt, paramLong);
      AppMethodBeat.o(220706);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(220706);
    }
    return 1000001;
  }
  
  public int selectTrackAsync(int paramInt, long paramLong)
  {
    AppMethodBeat.i(220702);
    try
    {
      paramInt = _selectTrackAsync(paramInt, paramLong);
      AppMethodBeat.o(220702);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(220702);
    }
    return 1000001;
  }
  
  public int setAudioFrameCallback(ITPNativePlayerAudioFrameCallback paramITPNativePlayerAudioFrameCallback)
  {
    AppMethodBeat.i(220689);
    try
    {
      int i = _setAudioFrameCallback(paramITPNativePlayerAudioFrameCallback);
      AppMethodBeat.o(220689);
      return i;
    }
    catch (Throwable paramITPNativePlayerAudioFrameCallback)
    {
      TPNativeLog.printLog(4, paramITPNativePlayerAudioFrameCallback.getMessage());
      AppMethodBeat.o(220689);
    }
    return 1000001;
  }
  
  public int setAudioMute(boolean paramBoolean)
  {
    AppMethodBeat.i(220684);
    try
    {
      int i = _setAudioMute(paramBoolean);
      AppMethodBeat.o(220684);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(220684);
    }
    return 1000001;
  }
  
  public int setAudioVolume(float paramFloat)
  {
    AppMethodBeat.i(220683);
    try
    {
      int i = _setAudioVolume(paramFloat);
      AppMethodBeat.o(220683);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(220683);
    }
    return 1000001;
  }
  
  public int setDataSource(int paramInt)
  {
    AppMethodBeat.i(220670);
    try
    {
      paramInt = _setDataSourceFd(paramInt);
      AppMethodBeat.o(220670);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(220670);
    }
    return 1000001;
  }
  
  public int setDataSource(String paramString)
  {
    AppMethodBeat.i(220668);
    try
    {
      int i = _setDataSource(paramString);
      AppMethodBeat.o(220668);
      return i;
    }
    catch (Throwable paramString)
    {
      TPNativeLog.printLog(4, paramString.getMessage());
      AppMethodBeat.o(220668);
    }
    return 1000001;
  }
  
  public int setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(220669);
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
            AppMethodBeat.o(220669);
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
        AppMethodBeat.o(220669);
        return 1000001;
      }
    }
  }
  
  public void setInitConfig(TPNativePlayerInitConfig paramTPNativePlayerInitConfig)
  {
    AppMethodBeat.i(220667);
    Object localObject4;
    Object localObject3;
    try
    {
      _resetInitConfig();
      localObject4 = paramTPNativePlayerInitConfig.getIntMap();
      localObject3 = paramTPNativePlayerInitConfig.getLongMap();
      localObject2 = paramTPNativePlayerInitConfig.getBoolMap();
      localObject1 = paramTPNativePlayerInitConfig.getQueueIntMap();
      localObject4 = ((HashMap)localObject4).entrySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject4).next();
        _setInitConfigInt(((Integer)localEntry.getKey()).intValue(), ((Integer)localEntry.getValue()).intValue());
      }
      localObject3 = ((HashMap)localObject3).entrySet().iterator();
    }
    catch (Throwable paramTPNativePlayerInitConfig)
    {
      TPNativeLog.printLog(4, paramTPNativePlayerInitConfig.getMessage());
      AppMethodBeat.o(220667);
      return;
    }
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (Map.Entry)((Iterator)localObject3).next();
      _setInitConfigLong(((Integer)((Map.Entry)localObject4).getKey()).intValue(), ((Long)((Map.Entry)localObject4).getValue()).longValue());
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
    AppMethodBeat.o(220667);
  }
  
  public int setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(220687);
    try
    {
      int i = _setLoopback(paramBoolean, paramLong1, paramLong2);
      AppMethodBeat.o(220687);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(220687);
    }
    return 1000001;
  }
  
  public int setMessageCallback(ITPNativePlayerMessageCallback paramITPNativePlayerMessageCallback)
  {
    AppMethodBeat.i(220688);
    try
    {
      int i = _setMessageCallback(paramITPNativePlayerMessageCallback);
      AppMethodBeat.o(220688);
      return i;
    }
    catch (Throwable paramITPNativePlayerMessageCallback)
    {
      TPNativeLog.printLog(4, paramITPNativePlayerMessageCallback.getMessage());
      AppMethodBeat.o(220688);
    }
    return 1000001;
  }
  
  public int setOptionLong(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(220681);
    try
    {
      paramInt = _setOptionLong(paramInt, paramLong1, paramLong2);
      AppMethodBeat.o(220681);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(220681);
    }
    return 1000001;
  }
  
  public int setOptionObject(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(220682);
    try
    {
      paramInt = _setOptionObject(paramInt, paramObject);
      AppMethodBeat.o(220682);
      return paramInt;
    }
    catch (Throwable paramObject)
    {
      TPNativeLog.printLog(4, paramObject.getMessage());
      AppMethodBeat.o(220682);
    }
    return 1000001;
  }
  
  public int setPlaybackRate(float paramFloat)
  {
    AppMethodBeat.i(220685);
    try
    {
      int i = _setPlaybackRate(paramFloat);
      AppMethodBeat.o(220685);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(220685);
    }
    return 1000001;
  }
  
  public int setVideoFrameCallback(ITPNativePlayerVideoFrameCallback paramITPNativePlayerVideoFrameCallback)
  {
    AppMethodBeat.i(220690);
    try
    {
      int i = _setVideoFrameCallback(paramITPNativePlayerVideoFrameCallback);
      AppMethodBeat.o(220690);
      return i;
    }
    catch (Throwable paramITPNativePlayerVideoFrameCallback)
    {
      TPNativeLog.printLog(4, paramITPNativePlayerVideoFrameCallback.getMessage());
      AppMethodBeat.o(220690);
    }
    return 1000001;
  }
  
  public int setVideoSurface(Surface paramSurface)
  {
    AppMethodBeat.i(220686);
    try
    {
      int i = _setVideoSurface(paramSurface);
      AppMethodBeat.o(220686);
      return i;
    }
    catch (Throwable paramSurface)
    {
      TPNativeLog.printLog(4, paramSurface.getMessage());
      AppMethodBeat.o(220686);
    }
    return 1000001;
  }
  
  public int start()
  {
    AppMethodBeat.i(220673);
    try
    {
      int i = _start();
      AppMethodBeat.o(220673);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(220673);
    }
    return 1000001;
  }
  
  public int stop()
  {
    AppMethodBeat.i(220675);
    try
    {
      int i = _stop();
      AppMethodBeat.o(220675);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      AppMethodBeat.o(220675);
    }
    return 1000001;
  }
  
  public int switchDefinitionAsync(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(220680);
    try
    {
      paramInt = _switchDefinitionAsync(paramString, paramInt, paramLong);
      AppMethodBeat.o(220680);
      return paramInt;
    }
    catch (Throwable paramString)
    {
      TPNativeLog.printLog(4, paramString.getMessage());
      AppMethodBeat.o(220680);
    }
    return 1000001;
  }
  
  @Deprecated
  public int switchDefinitionAsync(String paramString, long paramLong)
  {
    AppMethodBeat.i(220679);
    int i = switchDefinitionAsync(paramString, 0, paramLong);
    AppMethodBeat.o(220679);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.core.player.TPNativePlayer
 * JD-Core Version:    0.7.0.1
 */