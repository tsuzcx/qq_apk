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
import com.tencent.thumbplayer.core.downloadproxy.utils.TVKThreadUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

public class TPListenerManager
{
  private static final String FILE_NAME = "TPListenerManager";
  private static final int MSG_CURRENT_CDN_URL = 5;
  private static final int MSG_CURRENT_CDN_URL_INFO = 6;
  private static final int MSG_DOWNLOAD_PROTOCOL = 9;
  private static final int MSG_DOWNLOAD_STATUS = 8;
  private static final int MSG_ERROR = 4;
  private static final int MSG_FINISH = 3;
  private static final int MSG_NOTIFY_HTTP_HEADER = 2006;
  private static final int MSG_NOTIFY_LOSE_PACKAGE_CEHCK = 2004;
  private static final int MSG_NOTIFY_M3U8_CONTENT = 2007;
  private static final int MSG_NOTIFY_PLAYER_SWITCH_DEFINITION = 2003;
  private static final int MSG_PLAY_VIDEO_NOT_FOUND = 101;
  private static final int MSG_PREPARE_FINISH = 50;
  private static final int MSG_PROGRESS = 2;
  private static final int MSG_PROXY_CANCEL_READ_DATA = 202;
  private static final int MSG_PROXY_GET_CONTENT_TYPE = 205;
  private static final int MSG_PROXY_GET_DATA_FILE_PATH = 204;
  private static final int MSG_PROXY_GET_DATA_TOTAL_SIZE = 203;
  private static final int MSG_PROXY_READ_DATA = 201;
  private static final int MSG_PROXY_START_READ_DATA = 200;
  private static final int MSG_URL_EXPIRED = 7;
  private static final Object OFFLINE_LISTENER_MAP_MUTEX;
  private static final Object PLAY_LISTENER_MAP_MUTEX;
  private static final Object PRELOAD_LISTENER_MAP_MUTEX;
  private static final String THREAD_NAME = "TVKDL-Listener";
  private Handler mMsgHandler;
  private HandlerThread mMsgHandlerThread;
  private Map<Integer, ITPOfflineDownloadListener> mOfflineDownloadListenerMap;
  private Map<Integer, ITPPlayListener> mPlayListenerMap;
  private Map<Integer, ITPPreLoadListener> mPreLoadListenerMap;
  private Runnable updatePlayerInfo;
  
  static
  {
    AppMethodBeat.i(227923);
    PLAY_LISTENER_MAP_MUTEX = new Object();
    PRELOAD_LISTENER_MAP_MUTEX = new Object();
    OFFLINE_LISTENER_MAP_MUTEX = new Object();
    AppMethodBeat.o(227923);
  }
  
  private TPListenerManager()
  {
    AppMethodBeat.i(227812);
    this.mPlayListenerMap = new HashMap();
    this.mPreLoadListenerMap = new HashMap();
    this.mOfflineDownloadListenerMap = new HashMap();
    this.updatePlayerInfo = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(227817);
        Object localObject1 = TPListenerManager.this.mPlayListenerMap;
        try
        {
          localObject1 = ((Map)localObject1).entrySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject3 = (Map.Entry)((Iterator)localObject1).next();
            int i = ((Integer)((Map.Entry)localObject3).getKey()).intValue();
            localObject3 = (ITPPlayListener)((Map.Entry)localObject3).getValue();
            int j = (int)(((ITPPlayListener)localObject3).getCurrentPosition() / 1000L);
            int k = (int)(((ITPPlayListener)localObject3).getPlayerBufferLength() / 1000L);
            int m = (int)(((ITPPlayListener)localObject3).getAdvRemainTime() / 1000L);
            TPDownloadProxyNative.getInstance().updatePlayerPlayMsg(i, j, k, m);
          }
          TPListenerManager.this.mMsgHandler.postDelayed(TPListenerManager.this.updatePlayerInfo, 1000L);
        }
        finally
        {
          TPDLProxyLog.e("TPListenerManager", 0, "tpdlnative", "updatePlayerInfo failed, error:" + localObject2.toString());
          AppMethodBeat.o(227817);
          return;
        }
        AppMethodBeat.o(227817);
      }
    };
    AppMethodBeat.o(227812);
  }
  
  private void dispatchCallbackMessage(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    AppMethodBeat.i(227825);
    Object localObject = getPlaylistener(paramInt2);
    if (localObject != null)
    {
      dispatchPlayMessage((ITPPlayListener)localObject, paramInt1, paramInt2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
      AppMethodBeat.o(227825);
      return;
    }
    localObject = getPreLoadListener(paramInt2);
    if (localObject != null)
    {
      dispatchPreLoadMessage((ITPPreLoadListener)localObject, paramInt1, paramInt2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
      AppMethodBeat.o(227825);
      return;
    }
    localObject = getOfflineDownloadListener(paramInt2);
    if (localObject != null) {
      dispatchOfflineDownloadMessage((ITPOfflineDownloadListener)localObject, paramInt1, paramInt2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
    }
    AppMethodBeat.o(227825);
  }
  
  private void dispatchOfflineDownloadMessage(ITPOfflineDownloadListener paramITPOfflineDownloadListener, int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    AppMethodBeat.i(227866);
    if (paramITPOfflineDownloadListener == null)
    {
      AppMethodBeat.o(227866);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(227866);
      return;
      paramITPOfflineDownloadListener.onDownloadProgressUpdate(TPDLProxyUtils.objectToInt(paramObject1, 0), TPDLProxyUtils.objectToInt(paramObject2, 0), TPDLProxyUtils.objectToLong(paramObject3, 0L), TPDLProxyUtils.objectToLong(paramObject4, 0L), TPDLProxyUtils.byteArrayToString((byte[])paramObject5));
      AppMethodBeat.o(227866);
      return;
      paramITPOfflineDownloadListener.onDownloadFinish();
      AppMethodBeat.o(227866);
      return;
      paramITPOfflineDownloadListener.onDownloadError(((Integer)paramObject1).intValue(), ((Integer)paramObject2).intValue(), TPDLProxyUtils.byteArrayToString((byte[])paramObject3));
      AppMethodBeat.o(227866);
      return;
      paramITPOfflineDownloadListener.onDownloadCdnUrlUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1));
      AppMethodBeat.o(227866);
      return;
      paramITPOfflineDownloadListener.onDownloadCdnUrlInfoUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.byteArrayToString((byte[])paramObject2), TPDLProxyUtils.byteArrayToString((byte[])paramObject3), TPDLProxyUtils.byteArrayToString((byte[])paramObject4));
      AppMethodBeat.o(227866);
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
      AppMethodBeat.o(227866);
      return;
      paramITPOfflineDownloadListener.onDownloadStatusUpdate(TPDLProxyUtils.objectToInt(paramObject1, 0));
      AppMethodBeat.o(227866);
      return;
      paramITPOfflineDownloadListener.onDownloadProtocolUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.byteArrayToString((byte[])paramObject2));
    }
  }
  
  private void dispatchPlayMessage(ITPPlayListener paramITPPlayListener, final int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    AppMethodBeat.i(227839);
    if (paramITPPlayListener == null)
    {
      AppMethodBeat.o(227839);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(227839);
      return;
      paramITPPlayListener.onDownloadProgressUpdate(TPDLProxyUtils.objectToInt(paramObject1, 0), TPDLProxyUtils.objectToInt(paramObject2, 0), TPDLProxyUtils.objectToLong(paramObject3, 0L), TPDLProxyUtils.objectToLong(paramObject4, 0L), TPDLProxyUtils.byteArrayToString((byte[])paramObject5));
      AppMethodBeat.o(227839);
      return;
      paramITPPlayListener.onDownloadFinish();
      AppMethodBeat.o(227839);
      return;
      AppMethodBeat.o(227839);
      return;
      paramITPPlayListener.onDownloadCdnUrlUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1));
      AppMethodBeat.o(227839);
      return;
      paramITPPlayListener.onDownloadCdnUrlInfoUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.byteArrayToString((byte[])paramObject2), TPDLProxyUtils.byteArrayToString((byte[])paramObject3), TPDLProxyUtils.byteArrayToString((byte[])paramObject4));
      AppMethodBeat.o(227839);
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
      AppMethodBeat.o(227839);
      return;
      paramITPPlayListener.onDownloadStatusUpdate(TPDLProxyUtils.objectToInt(paramObject1, 0));
      AppMethodBeat.o(227839);
      return;
      paramITPPlayListener.onDownloadProtocolUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.byteArrayToString((byte[])paramObject2));
      AppMethodBeat.o(227839);
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
      AppMethodBeat.o(227839);
      return;
      paramITPPlayListener.onPlayCallback(2, TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.byteArrayToString((byte[])paramObject2), Integer.valueOf(TPDLProxyUtils.objectToInt(paramObject3, 0)), null);
      AppMethodBeat.o(227839);
      return;
      paramInt1 = TPDLProxyUtils.objectToInt(paramObject2, 0);
      TVKThreadUtil.getScheduledExecutorServiceInstance().execute(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(227820);
          String str = TPDLProxyUtils.losePackageCheck(paramInt1);
          TPDownloadProxyNative.getInstance().setUserData("lose_package_check_info", str);
          AppMethodBeat.o(227820);
        }
      });
      AppMethodBeat.o(227839);
      return;
      paramITPPlayListener.onPlayCallback(3, TPDLProxyUtils.byteArrayToString((byte[])paramObject1), null, null, null);
      AppMethodBeat.o(227839);
      return;
      paramITPPlayListener.onPlayCallback(4, TPDLProxyUtils.byteArrayToString((byte[])paramObject1), null, null, null);
    }
  }
  
  private void dispatchPreLoadMessage(ITPPreLoadListener paramITPPreLoadListener, int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    AppMethodBeat.i(227852);
    if (paramITPPreLoadListener == null)
    {
      AppMethodBeat.o(227852);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(227852);
      return;
      paramITPPreLoadListener.onPrepareDownloadProgressUpdate(TPDLProxyUtils.objectToInt(paramObject1, 0), TPDLProxyUtils.objectToInt(paramObject2, 0), TPDLProxyUtils.objectToLong(paramObject3, 0L), TPDLProxyUtils.objectToLong(paramObject4, 0L), TPDLProxyUtils.byteArrayToString((byte[])paramObject5));
      AppMethodBeat.o(227852);
      return;
      paramITPPreLoadListener.onPrepareOK();
      AppMethodBeat.o(227852);
      return;
      paramITPPreLoadListener.onPrepareError(((Integer)paramObject1).intValue(), ((Integer)paramObject2).intValue(), TPDLProxyUtils.byteArrayToString((byte[])paramObject3));
    }
  }
  
  public static TPListenerManager getInstance()
  {
    AppMethodBeat.i(227819);
    TPListenerManager localTPListenerManager = SingletonHolder.INSTANCE;
    AppMethodBeat.o(227819);
    return localTPListenerManager;
  }
  
  public ITPOfflineDownloadListener getOfflineDownloadListener(int paramInt)
  {
    AppMethodBeat.i(228053);
    synchronized (OFFLINE_LISTENER_MAP_MUTEX)
    {
      ITPOfflineDownloadListener localITPOfflineDownloadListener = (ITPOfflineDownloadListener)this.mOfflineDownloadListenerMap.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(228053);
      return localITPOfflineDownloadListener;
    }
  }
  
  public ITPPlayListener getPlaylistener(int paramInt)
  {
    AppMethodBeat.i(227980);
    synchronized (PLAY_LISTENER_MAP_MUTEX)
    {
      ITPPlayListener localITPPlayListener = (ITPPlayListener)this.mPlayListenerMap.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(227980);
      return localITPPlayListener;
    }
  }
  
  public ITPPreLoadListener getPreLoadListener(int paramInt)
  {
    AppMethodBeat.i(228029);
    synchronized (PRELOAD_LISTENER_MAP_MUTEX)
    {
      ITPPreLoadListener localITPPreLoadListener = (ITPPreLoadListener)this.mPreLoadListenerMap.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(228029);
      return localITPPreLoadListener;
    }
  }
  
  public void handleCallbackMessage(final int paramInt1, final int paramInt2, final Object paramObject1, final Object paramObject2, final Object paramObject3, final Object paramObject4, final Object paramObject5)
  {
    try
    {
      AppMethodBeat.i(228061);
      this.mMsgHandler.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(227829);
          TPListenerManager.access$500(TPListenerManager.this, paramInt1, paramInt2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
          AppMethodBeat.o(227829);
        }
      });
      AppMethodBeat.o(228061);
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
    AppMethodBeat.i(228075);
    int j = 0;
    paramObject4 = getPlaylistener(paramInt2);
    int i = j;
    if (paramObject4 != null)
    {
      if (paramInt1 != 200) {
        break label75;
      }
      i = paramObject4.onStartReadData(paramInt2, TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.objectToLong(paramObject2, 0L), TPDLProxyUtils.objectToLong(paramObject3, -1L));
    }
    for (;;)
    {
      AppMethodBeat.o(228075);
      return i;
      label75:
      if (paramInt1 == 202)
      {
        i = paramObject4.onStopReadData(paramInt2, TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.objectToInt(paramObject2, 0));
      }
      else
      {
        i = j;
        if (paramInt1 == 201) {
          i = paramObject4.onReadData(paramInt2, TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.objectToLong(paramObject2, 0L), TPDLProxyUtils.objectToInt(paramObject3, 0));
        }
      }
    }
  }
  
  public String handleStringCallbackMessage(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    AppMethodBeat.i(228086);
    paramObject3 = "";
    paramObject4 = getPlaylistener(paramInt2);
    paramObject2 = paramObject3;
    if (paramObject4 != null)
    {
      if (paramInt1 != 205) {
        break label63;
      }
      paramObject2 = paramObject4.getContentType(paramInt2, TPDLProxyUtils.byteArrayToString((byte[])paramObject1));
    }
    for (;;)
    {
      AppMethodBeat.o(228086);
      return paramObject2;
      label63:
      if (paramInt1 == 203)
      {
        paramObject2 = String.valueOf(paramObject4.getDataTotalSize(paramInt2, TPDLProxyUtils.byteArrayToString((byte[])paramObject1)));
      }
      else
      {
        paramObject2 = paramObject3;
        if (paramInt1 == 204) {
          paramObject2 = paramObject4.getDataFilePath(paramInt2, TPDLProxyUtils.byteArrayToString((byte[])paramObject1));
        }
      }
    }
  }
  
  public void initHandler()
  {
    AppMethodBeat.i(227935);
    if (this.mMsgHandlerThread == null)
    {
      this.mMsgHandlerThread = new HandlerThread("TVKDL-Listener");
      this.mMsgHandlerThread.start();
      this.mMsgHandler = new Handler(this.mMsgHandlerThread.getLooper());
      this.mMsgHandler.postDelayed(this.updatePlayerInfo, 1000L);
    }
    AppMethodBeat.o(227935);
  }
  
  public void removeAllPlayListener()
  {
    AppMethodBeat.i(227965);
    synchronized (PLAY_LISTENER_MAP_MUTEX)
    {
      this.mPlayListenerMap.clear();
      AppMethodBeat.o(227965);
      return;
    }
  }
  
  public void removeAllPreLoadListener()
  {
    AppMethodBeat.i(228018);
    synchronized (PRELOAD_LISTENER_MAP_MUTEX)
    {
      this.mPreLoadListenerMap.clear();
      AppMethodBeat.o(228018);
      return;
    }
  }
  
  public void removeOfflineDownloadListener(int paramInt)
  {
    AppMethodBeat.i(228044);
    if (paramInt > 0) {
      synchronized (OFFLINE_LISTENER_MAP_MUTEX)
      {
        this.mOfflineDownloadListenerMap.remove(Integer.valueOf(paramInt));
        AppMethodBeat.o(228044);
        return;
      }
    }
    AppMethodBeat.o(228044);
  }
  
  public void removePlayListener(int paramInt)
  {
    AppMethodBeat.i(227953);
    if (paramInt > 0) {
      synchronized (PLAY_LISTENER_MAP_MUTEX)
      {
        this.mPlayListenerMap.remove(Integer.valueOf(paramInt));
        AppMethodBeat.o(227953);
        return;
      }
    }
    AppMethodBeat.o(227953);
  }
  
  public void removePreLoadListener(int paramInt)
  {
    AppMethodBeat.i(228008);
    if (paramInt > 0) {
      synchronized (PRELOAD_LISTENER_MAP_MUTEX)
      {
        this.mPreLoadListenerMap.remove(Integer.valueOf(paramInt));
        AppMethodBeat.o(228008);
        return;
      }
    }
    AppMethodBeat.o(228008);
  }
  
  public void setOfflineDownloadListener(int paramInt, ITPOfflineDownloadListener paramITPOfflineDownloadListener)
  {
    AppMethodBeat.i(228038);
    if ((paramInt > 0) && (paramITPOfflineDownloadListener != null)) {
      synchronized (OFFLINE_LISTENER_MAP_MUTEX)
      {
        this.mOfflineDownloadListenerMap.put(Integer.valueOf(paramInt), paramITPOfflineDownloadListener);
        AppMethodBeat.o(228038);
        return;
      }
    }
    AppMethodBeat.o(228038);
  }
  
  public void setPlayListener(int paramInt, ITPPlayListener paramITPPlayListener)
  {
    AppMethodBeat.i(227943);
    if ((paramInt > 0) && (paramITPPlayListener != null)) {
      synchronized (PLAY_LISTENER_MAP_MUTEX)
      {
        this.mPlayListenerMap.put(Integer.valueOf(paramInt), paramITPPlayListener);
        AppMethodBeat.o(227943);
        return;
      }
    }
    AppMethodBeat.o(227943);
  }
  
  public void setPreLoadListener(int paramInt, ITPPreLoadListener paramITPPreLoadListener)
  {
    AppMethodBeat.i(227990);
    if ((paramInt > 0) && (paramITPPreLoadListener != null)) {
      synchronized (PRELOAD_LISTENER_MAP_MUTEX)
      {
        this.mPreLoadListenerMap.put(Integer.valueOf(paramInt), paramITPPreLoadListener);
        AppMethodBeat.o(227990);
        return;
      }
    }
    AppMethodBeat.o(227990);
  }
  
  static class SingletonHolder
  {
    private static final TPListenerManager INSTANCE;
    
    static
    {
      AppMethodBeat.i(227830);
      INSTANCE = new TPListenerManager(null);
      AppMethodBeat.o(227830);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager
 * JD-Core Version:    0.7.0.1
 */