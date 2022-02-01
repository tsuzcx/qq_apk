package com.tencent.thumbplayer.core.downloadproxy.apiinner;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPOfflineDownloadListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TPListenerManager
{
  private static final String FILE_NAME = "TPListenerManager";
  private static final int MSG_CURRENT_CDN_URL = 5;
  private static final int MSG_CURRENT_CDN_URL_INFO = 6;
  private static final int MSG_DOWNLOAD_PROTOCOL = 9;
  private static final int MSG_DOWNLOAD_STATUS = 8;
  private static final int MSG_ERROR = 4;
  private static final int MSG_FINISH = 3;
  private static final int MSG_NOTIFY_PLAYER_SWITCH_DEFINITION = 2003;
  private static final int MSG_PLAY_VIDEO_NOT_FOUND = 101;
  private static final int MSG_PREPARE_FINISH = 50;
  private static final int MSG_PROGRESS = 2;
  private static final int MSG_PROXY_CANCEL_READ_DATA = 12;
  private static final int MSG_PROXY_GET_CONTENT_TYPE = 15;
  private static final int MSG_PROXY_GET_DATA_FILE_PATH = 14;
  private static final int MSG_PROXY_GET_DATA_TOTAL_SIZE = 13;
  private static final int MSG_PROXY_READ_DATA = 11;
  private static final int MSG_PROXY_START_READ_DATA = 10;
  private static final int MSG_URL_EXPIRED = 7;
  private static final Object OFFLINE_LISTENER_MAP_MUTEX;
  private static final Object PLAY_LISTENER_MAP_MUTEX;
  private static final Object PRELOAD_LISTENER_MAP_MUTEX;
  private static final Object PROXY_PLAY_LISTENER_MAP_MUTEX;
  private static final String THREAD_NAME = "TVKDL-Listener";
  private Handler mMsgHandler;
  private HandlerThread mMsgHandlerThread;
  private Map<Integer, ITPOfflineDownloadListener> mOfflineDownloadListenerMap;
  private Map<Integer, ITPPlayListener> mPlayListenerMap;
  private Map<Integer, ITPPreLoadListener> mPreLoadListenerMap;
  private Map<Integer, ITPPlayListener> mProxyPlayListenerMap;
  private Runnable updatePlayerInfo;
  private Runnable updateProxyPlayerInfo;
  
  static
  {
    AppMethodBeat.i(191458);
    PLAY_LISTENER_MAP_MUTEX = new Object();
    PROXY_PLAY_LISTENER_MAP_MUTEX = new Object();
    PRELOAD_LISTENER_MAP_MUTEX = new Object();
    OFFLINE_LISTENER_MAP_MUTEX = new Object();
    AppMethodBeat.o(191458);
  }
  
  private TPListenerManager()
  {
    AppMethodBeat.i(191435);
    this.mPlayListenerMap = new HashMap();
    this.mProxyPlayListenerMap = new HashMap();
    this.mPreLoadListenerMap = new HashMap();
    this.mOfflineDownloadListenerMap = new HashMap();
    this.updatePlayerInfo = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(191431);
        Object localObject1 = TPListenerManager.this.mPlayListenerMap;
        try
        {
          localObject1 = ((Map)localObject1).entrySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
            int i = ((Integer)((Map.Entry)localObject2).getKey()).intValue();
            localObject2 = (ITPPlayListener)((Map.Entry)localObject2).getValue();
            int j = (int)(((ITPPlayListener)localObject2).getCurrentPosition() / 1000L);
            int k = (int)(((ITPPlayListener)localObject2).getPlayerBufferLength() / 1000L);
            int m = (int)(((ITPPlayListener)localObject2).getAdvRemainTime() / 1000L);
            TPDownloadProxyNative.getInstance().updatePlayerPlayMsg(i, j, k, m);
          }
          TPListenerManager.this.mMsgHandler.postDelayed(TPListenerManager.this.updatePlayerInfo, 1000L);
        }
        catch (Throwable localThrowable)
        {
          TPDLProxyLog.e("TPListenerManager", 0, "tpdlnative", "updatePlayerInfo failed, error:" + localThrowable.toString());
          AppMethodBeat.o(191431);
          return;
        }
        AppMethodBeat.o(191431);
      }
    };
    this.updateProxyPlayerInfo = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(191432);
        Object localObject = TPListenerManager.this.mProxyPlayListenerMap;
        try
        {
          localObject = ((Map)localObject).entrySet().iterator();
          while (((Iterator)localObject).hasNext())
          {
            int i = ((Integer)((Map.Entry)((Iterator)localObject).next()).getKey()).intValue();
            long l1 = TPProxyAdapterManager.getInstance().getCurrentOffset(i);
            long l2 = TPProxyAdapterManager.getInstance().getCurrentFilesize(i);
            TPListenerManager.this.handleCallbackMessage(2, i, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(l1), Long.valueOf(l2), null);
          }
          TPListenerManager.this.mMsgHandler.postDelayed(TPListenerManager.this.updateProxyPlayerInfo, 1000L);
        }
        catch (Throwable localThrowable)
        {
          TPDLProxyLog.e("TPListenerManager", 0, "tpdlnative", "updateProxyPlayerInfo failed, error:" + localThrowable.toString());
          AppMethodBeat.o(191432);
          return;
        }
        AppMethodBeat.o(191432);
      }
    };
    AppMethodBeat.o(191435);
  }
  
  private void dispatchCallbackMessage(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    AppMethodBeat.i(191453);
    Object localObject = getPlaylistener(paramInt2);
    if (localObject != null)
    {
      dispatchPlayMessage((ITPPlayListener)localObject, paramInt1, paramInt2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
      AppMethodBeat.o(191453);
      return;
    }
    localObject = getProxyPlayListener(paramInt2);
    if (localObject != null)
    {
      dispatchPlayMessage((ITPPlayListener)localObject, paramInt1, paramInt2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
      AppMethodBeat.o(191453);
      return;
    }
    localObject = getPreLoadListener(paramInt2);
    if (localObject != null)
    {
      dispatchPreLoadMessage((ITPPreLoadListener)localObject, paramInt1, paramInt2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
      AppMethodBeat.o(191453);
      return;
    }
    localObject = getOfflineDownloadListener(paramInt2);
    if (localObject != null) {
      dispatchOfflineDownloadMessage((ITPOfflineDownloadListener)localObject, paramInt1, paramInt2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
    }
    AppMethodBeat.o(191453);
  }
  
  private void dispatchOfflineDownloadMessage(ITPOfflineDownloadListener paramITPOfflineDownloadListener, int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    AppMethodBeat.i(191456);
    if (paramITPOfflineDownloadListener == null)
    {
      AppMethodBeat.o(191456);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(191456);
      return;
      paramITPOfflineDownloadListener.onDownloadProgressUpdate(TPDLProxyUtils.objectToInt(paramObject1, 0), TPDLProxyUtils.objectToInt(paramObject2, 0), TPDLProxyUtils.objectToLong(paramObject3, 0L), TPDLProxyUtils.objectToLong(paramObject4, 0L));
      AppMethodBeat.o(191456);
      return;
      paramITPOfflineDownloadListener.onDownloadFinish();
      AppMethodBeat.o(191456);
      return;
      paramITPOfflineDownloadListener.onDownloadError(((Integer)paramObject1).intValue(), ((Integer)paramObject2).intValue(), TPDLProxyUtils.byteArrayToString((byte[])paramObject3));
      AppMethodBeat.o(191456);
      return;
      paramITPOfflineDownloadListener.onDownloadCdnUrlUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1));
      AppMethodBeat.o(191456);
      return;
      paramITPOfflineDownloadListener.onDownloadCdnUrlInfoUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.byteArrayToString((byte[])paramObject2), TPDLProxyUtils.byteArrayToString((byte[])paramObject3), TPDLProxyUtils.byteArrayToString((byte[])paramObject4));
      AppMethodBeat.o(191456);
      return;
      paramObject1 = TPDLProxyUtils.byteArrayToString((byte[])paramObject1);
      long l = TPDLProxyUtils.objectToLong(paramObject2, 0L);
      paramObject2 = new HashMap();
      if (!TextUtils.isEmpty(paramObject1))
      {
        paramObject2.put("exttag", paramObject1);
        paramObject2.put("randnum", String.valueOf(l));
      }
      paramITPOfflineDownloadListener.onDownloadCdnUrlExpired(paramObject2);
      AppMethodBeat.o(191456);
      return;
      paramITPOfflineDownloadListener.onDownloadStatusUpdate(TPDLProxyUtils.objectToInt(paramObject1, 0));
      AppMethodBeat.o(191456);
      return;
      paramITPOfflineDownloadListener.onDownloadProtocolUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.byteArrayToString((byte[])paramObject2));
    }
  }
  
  private void dispatchPlayMessage(ITPPlayListener paramITPPlayListener, int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    AppMethodBeat.i(191454);
    if (paramITPPlayListener == null)
    {
      AppMethodBeat.o(191454);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(191454);
      return;
      paramITPPlayListener.onDownloadProgressUpdate(TPDLProxyUtils.objectToInt(paramObject1, 0), TPDLProxyUtils.objectToInt(paramObject2, 0), TPDLProxyUtils.objectToLong(paramObject3, 0L), TPDLProxyUtils.objectToLong(paramObject4, 0L));
      AppMethodBeat.o(191454);
      return;
      paramITPPlayListener.onDownloadFinish();
      AppMethodBeat.o(191454);
      return;
      AppMethodBeat.o(191454);
      return;
      paramITPPlayListener.onDownloadCdnUrlUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1));
      AppMethodBeat.o(191454);
      return;
      paramITPPlayListener.onDownloadCdnUrlInfoUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.byteArrayToString((byte[])paramObject2), TPDLProxyUtils.byteArrayToString((byte[])paramObject3), TPDLProxyUtils.byteArrayToString((byte[])paramObject4));
      AppMethodBeat.o(191454);
      return;
      paramObject1 = TPDLProxyUtils.byteArrayToString((byte[])paramObject1);
      long l = TPDLProxyUtils.objectToLong(paramObject2, 0L);
      paramObject2 = new HashMap();
      if (!TextUtils.isEmpty(paramObject1))
      {
        paramObject2.put("exttag", paramObject1);
        paramObject2.put("randnum", String.valueOf(l));
      }
      paramITPPlayListener.onDownloadCdnUrlExpired(paramObject2);
      AppMethodBeat.o(191454);
      return;
      paramITPPlayListener.onDownloadStatusUpdate(TPDLProxyUtils.objectToInt(paramObject1, 0));
      AppMethodBeat.o(191454);
      return;
      paramITPPlayListener.onDownloadProtocolUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.byteArrayToString((byte[])paramObject2));
      AppMethodBeat.o(191454);
      return;
      paramObject1 = TPDLProxyUtils.byteArrayToString((byte[])paramObject1);
      l = TPDLProxyUtils.objectToLong(paramObject2, 0L);
      paramObject2 = new HashMap();
      if (!TextUtils.isEmpty(paramObject1))
      {
        paramObject2.put("exttag", paramObject1);
        paramObject2.put("randnum", String.valueOf(l));
      }
      paramITPPlayListener.onPlayCallback(1, paramObject2, null, null, null);
      AppMethodBeat.o(191454);
      return;
      paramITPPlayListener.onPlayCallback(2, TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.byteArrayToString((byte[])paramObject2), Integer.valueOf(TPDLProxyUtils.objectToInt(paramObject3, 0)), null);
    }
  }
  
  private void dispatchPreLoadMessage(ITPPreLoadListener paramITPPreLoadListener, int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    AppMethodBeat.i(191455);
    if (paramITPPreLoadListener == null)
    {
      AppMethodBeat.o(191455);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(191455);
      return;
      paramITPPreLoadListener.onPrepareDownloadProgressUpdate(TPDLProxyUtils.objectToInt(paramObject1, 0), TPDLProxyUtils.objectToInt(paramObject2, 0), TPDLProxyUtils.objectToLong(paramObject3, 0L), TPDLProxyUtils.objectToLong(paramObject4, 0L));
      AppMethodBeat.o(191455);
      return;
      paramITPPreLoadListener.onPrepareOK();
      AppMethodBeat.o(191455);
      return;
      paramITPPreLoadListener.onPrepareError();
    }
  }
  
  public static TPListenerManager getInstance()
  {
    AppMethodBeat.i(191436);
    TPListenerManager localTPListenerManager = SingletonHolder.INSTANCE;
    AppMethodBeat.o(191436);
    return localTPListenerManager;
  }
  
  public ITPOfflineDownloadListener getOfflineDownloadListener(int paramInt)
  {
    AppMethodBeat.i(191449);
    synchronized (OFFLINE_LISTENER_MAP_MUTEX)
    {
      ITPOfflineDownloadListener localITPOfflineDownloadListener = (ITPOfflineDownloadListener)this.mOfflineDownloadListenerMap.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(191449);
      return localITPOfflineDownloadListener;
    }
  }
  
  public ITPPlayListener getPlaylistener(int paramInt)
  {
    AppMethodBeat.i(191440);
    synchronized (PLAY_LISTENER_MAP_MUTEX)
    {
      ITPPlayListener localITPPlayListener = (ITPPlayListener)this.mPlayListenerMap.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(191440);
      return localITPPlayListener;
    }
  }
  
  public ITPPreLoadListener getPreLoadListener(int paramInt)
  {
    AppMethodBeat.i(191446);
    synchronized (PRELOAD_LISTENER_MAP_MUTEX)
    {
      ITPPreLoadListener localITPPreLoadListener = (ITPPreLoadListener)this.mPreLoadListenerMap.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(191446);
      return localITPPreLoadListener;
    }
  }
  
  public ITPPlayListener getProxyPlayListener(int paramInt)
  {
    AppMethodBeat.i(191443);
    synchronized (PROXY_PLAY_LISTENER_MAP_MUTEX)
    {
      ITPPlayListener localITPPlayListener = (ITPPlayListener)this.mProxyPlayListenerMap.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(191443);
      return localITPPlayListener;
    }
  }
  
  public void handleCallbackMessage(final int paramInt1, final int paramInt2, final Object paramObject1, final Object paramObject2, final Object paramObject3, final Object paramObject4, final Object paramObject5)
  {
    try
    {
      AppMethodBeat.i(191450);
      this.mMsgHandler.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(191433);
          TPListenerManager.access$700(TPListenerManager.this, paramInt1, paramInt2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
          AppMethodBeat.o(191433);
        }
      });
      AppMethodBeat.o(191450);
      return;
    }
    finally
    {
      paramObject1 = finally;
      throw paramObject1;
    }
  }
  
  public int handleIntCallbackMessage(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    AppMethodBeat.i(191451);
    paramObject4 = getPlaylistener(paramInt2);
    long l1;
    if (paramObject4 != null) {
      if (paramInt1 == 10)
      {
        paramObject1 = TPDLProxyUtils.byteArrayToString((byte[])paramObject1);
        l1 = TPDLProxyUtils.objectToLong(paramObject2, 0L);
        long l2 = TPDLProxyUtils.objectToLong(paramObject3, -1L);
        paramInt1 = paramObject4.onStartReadData(paramInt2, paramObject1, l1, l2);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(191451);
      return paramInt1;
      if (paramInt1 == 12)
      {
        paramObject1 = TPDLProxyUtils.byteArrayToString((byte[])paramObject1);
        paramInt1 = paramObject4.onStopReadData(paramInt2, paramObject1);
      }
      else if (paramInt1 == 11)
      {
        paramObject1 = TPDLProxyUtils.byteArrayToString((byte[])paramObject1);
        l1 = TPDLProxyUtils.objectToLong(paramObject2, 0L);
        paramInt1 = TPDLProxyUtils.objectToInt(paramObject3, 0);
        paramInt1 = paramObject4.onReadData(paramInt2, paramObject1, l1, paramInt1);
      }
      else
      {
        paramInt1 = 0;
      }
    }
  }
  
  public String handleStringCallbackMessage(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    AppMethodBeat.i(191452);
    paramObject3 = "";
    paramObject4 = getPlaylistener(paramInt2);
    paramObject2 = paramObject3;
    if (paramObject4 != null)
    {
      if (paramInt1 != 15) {
        break label65;
      }
      paramObject1 = TPDLProxyUtils.byteArrayToString((byte[])paramObject1);
      paramObject2 = paramObject4.getContentType(paramInt2, paramObject1);
    }
    for (;;)
    {
      AppMethodBeat.o(191452);
      return paramObject2;
      label65:
      if (paramInt1 == 13)
      {
        paramObject1 = TPDLProxyUtils.byteArrayToString((byte[])paramObject1);
        paramObject2 = String.valueOf(paramObject4.getDataTotalSize(paramInt2, paramObject1));
      }
      else
      {
        paramObject2 = paramObject3;
        if (paramInt1 == 14)
        {
          paramObject1 = TPDLProxyUtils.byteArrayToString((byte[])paramObject1);
          paramObject2 = paramObject4.getDataFilePath(paramInt2, paramObject1);
        }
      }
    }
  }
  
  public void initHandler()
  {
    AppMethodBeat.i(191437);
    if (this.mMsgHandlerThread == null)
    {
      this.mMsgHandlerThread = new HandlerThread("TVKDL-Listener");
      this.mMsgHandlerThread.start();
      this.mMsgHandler = new Handler(this.mMsgHandlerThread.getLooper());
      this.mMsgHandler.postDelayed(this.updatePlayerInfo, 1000L);
      this.mMsgHandler.postDelayed(this.updateProxyPlayerInfo, 1000L);
    }
    AppMethodBeat.o(191437);
  }
  
  public void removeOfflineDownloadListener(int paramInt)
  {
    AppMethodBeat.i(191448);
    if (paramInt > 0) {
      synchronized (OFFLINE_LISTENER_MAP_MUTEX)
      {
        this.mOfflineDownloadListenerMap.remove(Integer.valueOf(paramInt));
        AppMethodBeat.o(191448);
        return;
      }
    }
    AppMethodBeat.o(191448);
  }
  
  public void removePlayListener(int paramInt)
  {
    AppMethodBeat.i(191439);
    if (paramInt > 0) {
      synchronized (PLAY_LISTENER_MAP_MUTEX)
      {
        this.mPlayListenerMap.remove(Integer.valueOf(paramInt));
        AppMethodBeat.o(191439);
        return;
      }
    }
    AppMethodBeat.o(191439);
  }
  
  public void removePreLoadListener(int paramInt)
  {
    AppMethodBeat.i(191445);
    if (paramInt > 0) {
      synchronized (PRELOAD_LISTENER_MAP_MUTEX)
      {
        this.mPreLoadListenerMap.remove(Integer.valueOf(paramInt));
        AppMethodBeat.o(191445);
        return;
      }
    }
    AppMethodBeat.o(191445);
  }
  
  public void removeProxyPlayListener(int paramInt)
  {
    AppMethodBeat.i(191442);
    if (paramInt > 0) {
      synchronized (PROXY_PLAY_LISTENER_MAP_MUTEX)
      {
        this.mProxyPlayListenerMap.remove(Integer.valueOf(paramInt));
        AppMethodBeat.o(191442);
        return;
      }
    }
    AppMethodBeat.o(191442);
  }
  
  public void setOfflineDownloadListener(int paramInt, ITPOfflineDownloadListener paramITPOfflineDownloadListener)
  {
    AppMethodBeat.i(191447);
    if ((paramInt > 0) && (paramITPOfflineDownloadListener != null)) {
      synchronized (OFFLINE_LISTENER_MAP_MUTEX)
      {
        this.mOfflineDownloadListenerMap.put(Integer.valueOf(paramInt), paramITPOfflineDownloadListener);
        AppMethodBeat.o(191447);
        return;
      }
    }
    AppMethodBeat.o(191447);
  }
  
  public void setPlayListener(int paramInt, ITPPlayListener paramITPPlayListener)
  {
    AppMethodBeat.i(191438);
    if ((paramInt > 0) && (paramITPPlayListener != null)) {
      synchronized (PLAY_LISTENER_MAP_MUTEX)
      {
        this.mPlayListenerMap.put(Integer.valueOf(paramInt), paramITPPlayListener);
        AppMethodBeat.o(191438);
        return;
      }
    }
    AppMethodBeat.o(191438);
  }
  
  public void setPreLoadListener(int paramInt, ITPPreLoadListener paramITPPreLoadListener)
  {
    AppMethodBeat.i(191444);
    if ((paramInt > 0) && (paramITPPreLoadListener != null)) {
      synchronized (PRELOAD_LISTENER_MAP_MUTEX)
      {
        this.mPreLoadListenerMap.put(Integer.valueOf(paramInt), paramITPPreLoadListener);
        AppMethodBeat.o(191444);
        return;
      }
    }
    AppMethodBeat.o(191444);
  }
  
  public void setProxyPlayListener(int paramInt, ITPPlayListener paramITPPlayListener)
  {
    AppMethodBeat.i(191441);
    if ((paramInt > 0) && (paramITPPlayListener != null)) {
      synchronized (PROXY_PLAY_LISTENER_MAP_MUTEX)
      {
        this.mProxyPlayListenerMap.put(Integer.valueOf(paramInt), paramITPPlayListener);
        AppMethodBeat.o(191441);
        return;
      }
    }
    AppMethodBeat.o(191441);
  }
  
  static class SingletonHolder
  {
    private static final TPListenerManager INSTANCE;
    
    static
    {
      AppMethodBeat.i(191434);
      INSTANCE = new TPListenerManager(null);
      AppMethodBeat.o(191434);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager
 * JD-Core Version:    0.7.0.1
 */