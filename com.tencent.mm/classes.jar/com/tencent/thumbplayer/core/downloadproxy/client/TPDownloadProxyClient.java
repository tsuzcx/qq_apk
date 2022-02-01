package com.tencent.thumbplayer.core.downloadproxy.client;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl.Stub;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl.Stub;
import com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadParamAidl;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPOfflineDownloadListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDLProxyInitParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TPDownloadProxyClient
  implements ITPDownloadProxy
{
  private static final String FILE_NAME = "TPDownloadProxyClient";
  private ITPDownloadProxyAidl downloadProxyAidl = null;
  
  public TPDownloadProxyClient(ITPDownloadProxyAidl paramITPDownloadProxyAidl)
  {
    this.downloadProxyAidl = paramITPDownloadProxyAidl;
  }
  
  public int deinit()
  {
    return 0;
  }
  
  public String getClipPlayUrl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207371);
    try
    {
      String str = this.downloadProxyAidl.getClipPlayUrl(paramInt1, paramInt2);
      AppMethodBeat.o(207371);
      return str;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "getClipPlayUrl failed, error:" + localThrowable.toString());
      AppMethodBeat.o(207371);
    }
    return null;
  }
  
  public String getPlayErrorCodeStr(int paramInt)
  {
    AppMethodBeat.i(207372);
    try
    {
      String str = this.downloadProxyAidl.getPlayErrorCodeStr(paramInt);
      AppMethodBeat.o(207372);
      return str;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "getPlayErrorCodeStr failed, error:" + localThrowable.toString());
      AppMethodBeat.o(207372);
    }
    return null;
  }
  
  public String getPlayUrl(int paramInt)
  {
    AppMethodBeat.i(207370);
    try
    {
      String str = this.downloadProxyAidl.getPlayUrl(paramInt);
      AppMethodBeat.o(207370);
      return str;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "getPlayUrl failed, error:" + localThrowable.toString());
      AppMethodBeat.o(207370);
    }
    return null;
  }
  
  public int init(Context paramContext, TPDLProxyInitParam paramTPDLProxyInitParam)
  {
    AppMethodBeat.i(207365);
    paramContext = TPDLProxyUtils.serialize(paramTPDLProxyInitParam);
    if (TextUtils.isEmpty(paramContext))
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "param is null");
      AppMethodBeat.o(207365);
      return -1;
    }
    try
    {
      int i = this.downloadProxyAidl.init(paramContext);
      AppMethodBeat.o(207365);
      return i;
    }
    catch (Throwable paramContext)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "init failed, error:" + paramContext.toString());
      AppMethodBeat.o(207365);
    }
    return -2;
  }
  
  public int pauseDownload(int paramInt)
  {
    AppMethodBeat.i(207374);
    try
    {
      paramInt = this.downloadProxyAidl.pauseDownload(paramInt);
      AppMethodBeat.o(207374);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "pauseDownload failed, error:" + localThrowable.toString());
      AppMethodBeat.o(207374);
    }
    return -1;
  }
  
  public void pushEvent(int paramInt)
  {
    AppMethodBeat.i(207380);
    try
    {
      this.downloadProxyAidl.pushEvent(paramInt);
      AppMethodBeat.o(207380);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "pushEvent failed, error:" + localThrowable.toString());
      AppMethodBeat.o(207380);
    }
  }
  
  public int removeOfflineDownload(String paramString)
  {
    return -1;
  }
  
  public int resumeDownload(int paramInt)
  {
    AppMethodBeat.i(207375);
    try
    {
      paramInt = this.downloadProxyAidl.resumeDownload(paramInt);
      AppMethodBeat.o(207375);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "resumeDownload failed, error:" + localThrowable.toString());
      AppMethodBeat.o(207375);
    }
    return -1;
  }
  
  public boolean setClipInfo(int paramInt1, int paramInt2, String paramString, TPDownloadParam paramTPDownloadParam)
  {
    AppMethodBeat.i(207369);
    paramTPDownloadParam = new TPDownloadParamAidl(paramTPDownloadParam.getUrlList(), paramTPDownloadParam.getDlType(), paramTPDownloadParam.getExtInfoMap());
    try
    {
      boolean bool = this.downloadProxyAidl.setClipInfo(paramInt1, paramInt2, paramString, paramTPDownloadParam);
      AppMethodBeat.o(207369);
      return bool;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "setClipInfo failed, error:" + paramString.toString());
      AppMethodBeat.o(207369);
    }
    return false;
  }
  
  public void setLogListener(ITPDLProxyLogListener paramITPDLProxyLogListener)
  {
    AppMethodBeat.i(207366);
    TPDLProxyLog.setLogListener(10303, paramITPDLProxyLogListener);
    AppMethodBeat.o(207366);
  }
  
  public void setMaxStorageSizeMB(long paramLong)
  {
    AppMethodBeat.i(207378);
    try
    {
      this.downloadProxyAidl.setMaxStorageSizeMB(paramLong);
      AppMethodBeat.o(207378);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "setMaxStorageSizeMB failed, error:" + localThrowable.toString());
      AppMethodBeat.o(207378);
    }
  }
  
  public void setPlayState(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207381);
    try
    {
      this.downloadProxyAidl.setPlayState(paramInt1, paramInt2);
      AppMethodBeat.o(207381);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "setPlayState failed, error:" + localThrowable.toString());
      AppMethodBeat.o(207381);
    }
  }
  
  public void setUserData(String paramString, Object paramObject)
  {
    AppMethodBeat.i(207379);
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString, paramObject);
    try
    {
      this.downloadProxyAidl.setUserData(localHashMap);
      AppMethodBeat.o(207379);
      return;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "setUserData failed, error:" + paramString.toString());
      AppMethodBeat.o(207379);
    }
  }
  
  public int startClipOfflineDownload(String paramString, int paramInt, ITPOfflineDownloadListener paramITPOfflineDownloadListener)
  {
    return -1;
  }
  
  public int startClipPlay(String paramString, int paramInt, final ITPPlayListener paramITPPlayListener)
  {
    AppMethodBeat.i(207368);
    paramITPPlayListener = new ITPPlayListenerAidl.Stub()
    {
      public long getAdvRemainTime()
      {
        AppMethodBeat.i(207354);
        long l = paramITPPlayListener.getAdvRemainTime();
        AppMethodBeat.o(207354);
        return l;
      }
      
      public String getContentType(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(207361);
        paramAnonymousString = paramITPPlayListener.getContentType(paramAnonymousLong, paramAnonymousString);
        AppMethodBeat.o(207361);
        return paramAnonymousString;
      }
      
      public int getCurrentPlayClipNo()
      {
        AppMethodBeat.i(207353);
        int i = paramITPPlayListener.getCurrentPlayClipNo();
        AppMethodBeat.o(207353);
        return i;
      }
      
      public long getCurrentPosition()
      {
        AppMethodBeat.i(207352);
        long l = paramITPPlayListener.getCurrentPosition();
        AppMethodBeat.o(207352);
        return l;
      }
      
      public String getDataFilePath(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(207360);
        paramAnonymousString = paramITPPlayListener.getDataFilePath(paramAnonymousLong, paramAnonymousString);
        AppMethodBeat.o(207360);
        return paramAnonymousString;
      }
      
      public long getDataTotalSize(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(207359);
        paramAnonymousLong = paramITPPlayListener.getDataTotalSize(paramAnonymousLong, paramAnonymousString);
        AppMethodBeat.o(207359);
        return paramAnonymousLong;
      }
      
      public String getPlayInfo(String paramAnonymousString)
      {
        AppMethodBeat.i(207355);
        paramAnonymousString = paramITPPlayListener.getPlayInfo(paramAnonymousString);
        if ((paramAnonymousString != null) && (paramAnonymousString.getClass() == String.class))
        {
          if (paramAnonymousString.getClass() == String.class)
          {
            paramAnonymousString = (String)paramAnonymousString;
            AppMethodBeat.o(207355);
            return paramAnonymousString;
          }
          if (paramAnonymousString.getClass() == Integer.class)
          {
            paramAnonymousString = Integer.toString(((Integer)paramAnonymousString).intValue());
            AppMethodBeat.o(207355);
            return paramAnonymousString;
          }
        }
        AppMethodBeat.o(207355);
        return null;
      }
      
      public long getPlayerBufferLength()
      {
        AppMethodBeat.i(207351);
        long l = paramITPPlayListener.getPlayerBufferLength();
        AppMethodBeat.o(207351);
        return l;
      }
      
      public void onDownloadCdnUrlExpired(Map paramAnonymousMap)
      {
        AppMethodBeat.i(207348);
        paramITPPlayListener.onDownloadCdnUrlExpired(paramAnonymousMap);
        AppMethodBeat.o(207348);
      }
      
      public void onDownloadCdnUrlInfoUpdate(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4)
      {
        AppMethodBeat.i(207347);
        paramITPPlayListener.onDownloadCdnUrlInfoUpdate(paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousString4);
        AppMethodBeat.o(207347);
      }
      
      public void onDownloadCdnUrlUpdate(String paramAnonymousString)
      {
        AppMethodBeat.i(207346);
        paramITPPlayListener.onDownloadCdnUrlUpdate(paramAnonymousString);
        AppMethodBeat.o(207346);
      }
      
      public void onDownloadError(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(207344);
        paramITPPlayListener.onDownloadError(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString);
        AppMethodBeat.o(207344);
      }
      
      public void onDownloadFinish()
      {
        AppMethodBeat.i(207343);
        paramITPPlayListener.onDownloadFinish();
        AppMethodBeat.o(207343);
      }
      
      public void onDownloadProgressUpdate(int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(207342);
        paramITPPlayListener.onDownloadProgressUpdate(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousLong1, paramAnonymousLong2);
        AppMethodBeat.o(207342);
      }
      
      public void onDownloadProtocolUpdate(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(207350);
        paramITPPlayListener.onDownloadProtocolUpdate(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(207350);
      }
      
      public void onDownloadStatusUpdate(int paramAnonymousInt)
      {
        AppMethodBeat.i(207349);
        paramITPPlayListener.onDownloadStatusUpdate(paramAnonymousInt);
        AppMethodBeat.o(207349);
      }
      
      public int onPlayCallback(int paramAnonymousInt, List paramAnonymousList)
      {
        AppMethodBeat.i(207345);
        Integer localInteger = Integer.valueOf(0);
        Object localObject = localInteger;
        if (paramAnonymousList != null)
        {
          localObject = localInteger;
          if (!paramAnonymousList.isEmpty())
          {
            if (paramAnonymousList.size() != 1) {
              break label77;
            }
            localObject = paramITPPlayListener.onPlayCallback(paramAnonymousInt, paramAnonymousList.get(0), null, null, null);
          }
        }
        while (localObject.getClass() != Integer.class)
        {
          AppMethodBeat.o(207345);
          return -1;
          label77:
          if (paramAnonymousList.size() == 2)
          {
            localObject = paramITPPlayListener.onPlayCallback(paramAnonymousInt, paramAnonymousList.get(0), paramAnonymousList.get(1), null, null);
          }
          else
          {
            localObject = localInteger;
            if (paramAnonymousList.size() == 3) {
              localObject = paramITPPlayListener.onPlayCallback(paramAnonymousInt, paramAnonymousList.get(0), paramAnonymousList.get(1), paramAnonymousList.get(2), null);
            }
          }
        }
        paramAnonymousInt = ((Integer)localObject).intValue();
        AppMethodBeat.o(207345);
        return paramAnonymousInt;
      }
      
      public int onReadData(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3)
      {
        AppMethodBeat.i(207357);
        int i = paramITPPlayListener.onReadData(paramAnonymousLong1, paramAnonymousString, paramAnonymousLong2, paramAnonymousLong3);
        AppMethodBeat.o(207357);
        return i;
      }
      
      public int onStartReadData(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3)
      {
        AppMethodBeat.i(207356);
        int i = paramITPPlayListener.onStartReadData(paramAnonymousLong1, paramAnonymousString, paramAnonymousLong2, paramAnonymousLong3);
        AppMethodBeat.o(207356);
        return i;
      }
      
      public int onStopReadData(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(207358);
        int i = paramITPPlayListener.onStopReadData(paramAnonymousLong, paramAnonymousString);
        AppMethodBeat.o(207358);
        return i;
      }
    };
    try
    {
      paramInt = this.downloadProxyAidl.startClipPlay(paramString, paramInt, paramITPPlayListener);
      AppMethodBeat.o(207368);
      return paramInt;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "startClipPlay failed, error:" + paramString.toString());
      AppMethodBeat.o(207368);
    }
    return -1;
  }
  
  public int startOfflineDownload(String paramString, TPDownloadParam paramTPDownloadParam, ITPOfflineDownloadListener paramITPOfflineDownloadListener)
  {
    return -1;
  }
  
  public int startPlay(String paramString, TPDownloadParam paramTPDownloadParam, final ITPPlayListener paramITPPlayListener)
  {
    AppMethodBeat.i(207367);
    if ((this.downloadProxyAidl == null) || (paramTPDownloadParam == null) || (paramITPPlayListener == null))
    {
      AppMethodBeat.o(207367);
      return -1;
    }
    paramTPDownloadParam = new TPDownloadParamAidl(paramTPDownloadParam.getUrlList(), paramTPDownloadParam.getDlType(), paramTPDownloadParam.getExtInfoMap());
    paramITPPlayListener = new ITPPlayListenerAidl.Stub()
    {
      public long getAdvRemainTime()
      {
        AppMethodBeat.i(207334);
        long l = paramITPPlayListener.getAdvRemainTime();
        AppMethodBeat.o(207334);
        return l;
      }
      
      public String getContentType(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(207341);
        paramAnonymousString = paramITPPlayListener.getContentType(paramAnonymousLong, paramAnonymousString);
        AppMethodBeat.o(207341);
        return paramAnonymousString;
      }
      
      public int getCurrentPlayClipNo()
      {
        AppMethodBeat.i(207333);
        int i = paramITPPlayListener.getCurrentPlayClipNo();
        AppMethodBeat.o(207333);
        return i;
      }
      
      public long getCurrentPosition()
      {
        AppMethodBeat.i(207332);
        long l = paramITPPlayListener.getCurrentPosition();
        AppMethodBeat.o(207332);
        return l;
      }
      
      public String getDataFilePath(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(207340);
        paramAnonymousString = paramITPPlayListener.getDataFilePath(paramAnonymousLong, paramAnonymousString);
        AppMethodBeat.o(207340);
        return paramAnonymousString;
      }
      
      public long getDataTotalSize(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(207339);
        paramAnonymousLong = paramITPPlayListener.getDataTotalSize(paramAnonymousLong, paramAnonymousString);
        AppMethodBeat.o(207339);
        return paramAnonymousLong;
      }
      
      public String getPlayInfo(String paramAnonymousString)
      {
        AppMethodBeat.i(207335);
        paramAnonymousString = paramITPPlayListener.getPlayInfo(paramAnonymousString);
        if ((paramAnonymousString != null) && (paramAnonymousString.getClass() == String.class))
        {
          if (paramAnonymousString.getClass() == String.class)
          {
            paramAnonymousString = (String)paramAnonymousString;
            AppMethodBeat.o(207335);
            return paramAnonymousString;
          }
          if (paramAnonymousString.getClass() == Integer.class)
          {
            paramAnonymousString = Integer.toString(((Integer)paramAnonymousString).intValue());
            AppMethodBeat.o(207335);
            return paramAnonymousString;
          }
        }
        AppMethodBeat.o(207335);
        return null;
      }
      
      public long getPlayerBufferLength()
      {
        AppMethodBeat.i(207331);
        long l = paramITPPlayListener.getPlayerBufferLength();
        AppMethodBeat.o(207331);
        return l;
      }
      
      public void onDownloadCdnUrlExpired(Map paramAnonymousMap)
      {
        AppMethodBeat.i(207328);
        paramITPPlayListener.onDownloadCdnUrlExpired(paramAnonymousMap);
        AppMethodBeat.o(207328);
      }
      
      public void onDownloadCdnUrlInfoUpdate(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4)
      {
        AppMethodBeat.i(207327);
        paramITPPlayListener.onDownloadCdnUrlInfoUpdate(paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousString4);
        AppMethodBeat.o(207327);
      }
      
      public void onDownloadCdnUrlUpdate(String paramAnonymousString)
      {
        AppMethodBeat.i(207326);
        paramITPPlayListener.onDownloadCdnUrlUpdate(paramAnonymousString);
        AppMethodBeat.o(207326);
      }
      
      public void onDownloadError(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(207324);
        paramITPPlayListener.onDownloadError(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString);
        AppMethodBeat.o(207324);
      }
      
      public void onDownloadFinish()
      {
        AppMethodBeat.i(207323);
        paramITPPlayListener.onDownloadFinish();
        AppMethodBeat.o(207323);
      }
      
      public void onDownloadProgressUpdate(int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(207322);
        paramITPPlayListener.onDownloadProgressUpdate(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousLong1, paramAnonymousLong2);
        AppMethodBeat.o(207322);
      }
      
      public void onDownloadProtocolUpdate(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(207330);
        paramITPPlayListener.onDownloadProtocolUpdate(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(207330);
      }
      
      public void onDownloadStatusUpdate(int paramAnonymousInt)
      {
        AppMethodBeat.i(207329);
        paramITPPlayListener.onDownloadStatusUpdate(paramAnonymousInt);
        AppMethodBeat.o(207329);
      }
      
      public int onPlayCallback(int paramAnonymousInt, List paramAnonymousList)
      {
        AppMethodBeat.i(207325);
        Integer localInteger = Integer.valueOf(0);
        Object localObject = localInteger;
        if (paramAnonymousList != null)
        {
          localObject = localInteger;
          if (!paramAnonymousList.isEmpty())
          {
            if (paramAnonymousList.size() != 1) {
              break label77;
            }
            localObject = paramITPPlayListener.onPlayCallback(paramAnonymousInt, paramAnonymousList.get(0), null, null, null);
          }
        }
        while (localObject.getClass() != Integer.class)
        {
          AppMethodBeat.o(207325);
          return -1;
          label77:
          if (paramAnonymousList.size() == 2)
          {
            localObject = paramITPPlayListener.onPlayCallback(paramAnonymousInt, paramAnonymousList.get(0), paramAnonymousList.get(1), null, null);
          }
          else
          {
            localObject = localInteger;
            if (paramAnonymousList.size() == 3) {
              localObject = paramITPPlayListener.onPlayCallback(paramAnonymousInt, paramAnonymousList.get(0), paramAnonymousList.get(1), paramAnonymousList.get(2), null);
            }
          }
        }
        paramAnonymousInt = ((Integer)localObject).intValue();
        AppMethodBeat.o(207325);
        return paramAnonymousInt;
      }
      
      public int onReadData(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3)
      {
        AppMethodBeat.i(207337);
        int i = paramITPPlayListener.onReadData(paramAnonymousLong1, paramAnonymousString, paramAnonymousLong2, paramAnonymousLong3);
        AppMethodBeat.o(207337);
        return i;
      }
      
      public int onStartReadData(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3)
      {
        AppMethodBeat.i(207336);
        int i = paramITPPlayListener.onStartReadData(paramAnonymousLong1, paramAnonymousString, paramAnonymousLong2, paramAnonymousLong3);
        AppMethodBeat.o(207336);
        return i;
      }
      
      public int onStopReadData(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(207338);
        int i = paramITPPlayListener.onStopReadData(paramAnonymousLong, paramAnonymousString);
        AppMethodBeat.o(207338);
        return i;
      }
    };
    try
    {
      int i = this.downloadProxyAidl.startPlay(paramString, paramTPDownloadParam, paramITPPlayListener);
      AppMethodBeat.o(207367);
      return i;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "startPlay failed, error:" + paramString.toString());
      AppMethodBeat.o(207367);
    }
    return -1;
  }
  
  public int startPreload(String paramString, TPDownloadParam paramTPDownloadParam, final ITPPreLoadListener paramITPPreLoadListener)
  {
    AppMethodBeat.i(207376);
    paramTPDownloadParam = new TPDownloadParamAidl(paramTPDownloadParam.getUrlList(), paramTPDownloadParam.getDlType(), paramTPDownloadParam.getExtInfoMap());
    paramITPPreLoadListener = new ITPPreLoadListenerAidl.Stub()
    {
      public void onPrepareDownloadProgressUpdate(int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(207364);
        paramITPPreLoadListener.onPrepareDownloadProgressUpdate(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousLong1, paramAnonymousLong2);
        AppMethodBeat.o(207364);
      }
      
      public void onPrepareError()
      {
        AppMethodBeat.i(207363);
        paramITPPreLoadListener.onPrepareError();
        AppMethodBeat.o(207363);
      }
      
      public void onPrepareOK()
      {
        AppMethodBeat.i(207362);
        paramITPPreLoadListener.onPrepareOK();
        AppMethodBeat.o(207362);
      }
    };
    try
    {
      int i = this.downloadProxyAidl.startPreload(paramString, paramTPDownloadParam, paramITPPreLoadListener);
      AppMethodBeat.o(207376);
      return i;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "startPreload failed, error:" + paramString.toString());
      AppMethodBeat.o(207376);
    }
    return -1;
  }
  
  public void startTask(int paramInt) {}
  
  public void stopOfflineDownload(int paramInt) {}
  
  public void stopPlay(int paramInt)
  {
    AppMethodBeat.i(207373);
    try
    {
      this.downloadProxyAidl.stopPlay(paramInt);
      AppMethodBeat.o(207373);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "stopPlay failed, error:" + localThrowable.toString());
      AppMethodBeat.o(207373);
    }
  }
  
  public void stopPreload(int paramInt)
  {
    AppMethodBeat.i(207377);
    try
    {
      this.downloadProxyAidl.stopPreload(paramInt);
      AppMethodBeat.o(207377);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "stopPreload failed, error:" + localThrowable.toString());
      AppMethodBeat.o(207377);
    }
  }
  
  public void updateAidl(ITPDownloadProxyAidl paramITPDownloadProxyAidl)
  {
    this.downloadProxyAidl = paramITPDownloadProxyAidl;
  }
  
  public void updateStoragePath(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.client.TPDownloadProxyClient
 * JD-Core Version:    0.7.0.1
 */