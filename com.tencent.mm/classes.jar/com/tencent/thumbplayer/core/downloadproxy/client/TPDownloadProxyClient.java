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
  
  public String getClipPlayUrl(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(227901);
    try
    {
      String str = this.downloadProxyAidl.getClipPlayUrl(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(227901);
      return str;
    }
    finally
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "getClipPlayUrl failed, error:" + localObject.toString());
      AppMethodBeat.o(227901);
    }
    return null;
  }
  
  public String getNativeInfo(int paramInt)
  {
    AppMethodBeat.i(228050);
    Object localObject = null;
    try
    {
      String str = this.downloadProxyAidl.getNativeInfo(paramInt);
      localObject = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "getNativeInfo failed, error:" + localException.toString());
      }
    }
    AppMethodBeat.o(228050);
    return localObject;
  }
  
  public String getPlayErrorCodeStr(int paramInt)
  {
    AppMethodBeat.i(227910);
    try
    {
      String str = this.downloadProxyAidl.getPlayErrorCodeStr(paramInt);
      AppMethodBeat.o(227910);
      return str;
    }
    finally
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "getPlayErrorCodeStr failed, error:" + localObject.toString());
      AppMethodBeat.o(227910);
    }
    return null;
  }
  
  public String getPlayUrl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(227892);
    try
    {
      String str = this.downloadProxyAidl.getPlayUrl(paramInt1, paramInt2);
      AppMethodBeat.o(227892);
      return str;
    }
    finally
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "getPlayUrl failed, error:" + localObject.toString());
      AppMethodBeat.o(227892);
    }
    return null;
  }
  
  public int init(Context paramContext, TPDLProxyInitParam paramTPDLProxyInitParam)
  {
    AppMethodBeat.i(227836);
    paramContext = TPDLProxyUtils.serialize(paramTPDLProxyInitParam);
    if (TextUtils.isEmpty(paramContext))
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "param is null");
      AppMethodBeat.o(227836);
      return -1;
    }
    try
    {
      int i = this.downloadProxyAidl.init(paramContext);
      AppMethodBeat.o(227836);
      return i;
    }
    finally
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "init failed, error:" + paramContext.toString());
      AppMethodBeat.o(227836);
    }
    return -2;
  }
  
  public int pauseDownload(int paramInt)
  {
    AppMethodBeat.i(227927);
    try
    {
      paramInt = this.downloadProxyAidl.pauseDownload(paramInt);
      AppMethodBeat.o(227927);
      return paramInt;
    }
    finally
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "pauseDownload failed, error:" + localObject.toString());
      AppMethodBeat.o(227927);
    }
    return -1;
  }
  
  public void pushEvent(int paramInt)
  {
    AppMethodBeat.i(228032);
    try
    {
      this.downloadProxyAidl.pushEvent(paramInt);
      AppMethodBeat.o(228032);
      return;
    }
    finally
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "pushEvent failed, error:" + localObject.toString());
      AppMethodBeat.o(228032);
    }
  }
  
  public int removeStorageCache(String paramString)
  {
    return -1;
  }
  
  public int resumeDownload(int paramInt)
  {
    AppMethodBeat.i(227937);
    try
    {
      paramInt = this.downloadProxyAidl.resumeDownload(paramInt);
      AppMethodBeat.o(227937);
      return paramInt;
    }
    finally
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "resumeDownload failed, error:" + localObject.toString());
      AppMethodBeat.o(227937);
    }
    return -1;
  }
  
  public boolean setClipInfo(int paramInt1, int paramInt2, String paramString, TPDownloadParam paramTPDownloadParam)
  {
    AppMethodBeat.i(227883);
    paramTPDownloadParam = new TPDownloadParamAidl(paramTPDownloadParam.getUrlList(), paramTPDownloadParam.getDlType(), paramTPDownloadParam.getExtInfoMap());
    try
    {
      boolean bool = this.downloadProxyAidl.setClipInfo(paramInt1, paramInt2, paramString, paramTPDownloadParam);
      AppMethodBeat.o(227883);
      return bool;
    }
    finally
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "setClipInfo failed, error:" + paramString.toString());
      AppMethodBeat.o(227883);
    }
    return false;
  }
  
  public void setLogListener(ITPDLProxyLogListener paramITPDLProxyLogListener)
  {
    AppMethodBeat.i(227850);
    TPDLProxyLog.setLogListener(10303, paramITPDLProxyLogListener);
    AppMethodBeat.o(227850);
  }
  
  public void setMaxStorageSizeMB(long paramLong)
  {
    AppMethodBeat.i(228013);
    try
    {
      this.downloadProxyAidl.setMaxStorageSizeMB(paramLong);
      AppMethodBeat.o(228013);
      return;
    }
    finally
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "setMaxStorageSizeMB failed, error:" + localObject.toString());
      AppMethodBeat.o(228013);
    }
  }
  
  public void setPlayState(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(228042);
    try
    {
      this.downloadProxyAidl.setPlayState(paramInt1, paramInt2);
      AppMethodBeat.o(228042);
      return;
    }
    finally
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "setPlayState failed, error:" + localObject.toString());
      AppMethodBeat.o(228042);
    }
  }
  
  public void setUserData(String paramString, Object paramObject)
  {
    AppMethodBeat.i(228023);
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString, paramObject);
    try
    {
      this.downloadProxyAidl.setUserData(localHashMap);
      AppMethodBeat.o(228023);
      return;
    }
    finally
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "setUserData failed, error:" + paramString.toString());
      AppMethodBeat.o(228023);
    }
  }
  
  public int startClipOfflineDownload(String paramString, int paramInt, ITPOfflineDownloadListener paramITPOfflineDownloadListener)
  {
    return -1;
  }
  
  public int startClipPlay(String paramString, int paramInt, final ITPPlayListener paramITPPlayListener)
  {
    AppMethodBeat.i(227871);
    if (paramITPPlayListener == null) {}
    try
    {
      paramInt = this.downloadProxyAidl.startClipPlay(paramString, paramInt, null);
      AppMethodBeat.o(227871);
      return paramInt;
    }
    finally
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "startClipPlay failed, error:" + paramString.toString());
      AppMethodBeat.o(227871);
    }
    paramITPPlayListener = new ITPPlayListenerAidl.Stub()
    {
      public long getAdvRemainTime()
      {
        AppMethodBeat.i(228016);
        long l = paramITPPlayListener.getAdvRemainTime();
        AppMethodBeat.o(228016);
        return l;
      }
      
      public String getContentType(int paramAnonymousInt, String paramAnonymousString)
      {
        return null;
      }
      
      public int getCurrentPlayClipNo()
      {
        AppMethodBeat.i(228003);
        int i = paramITPPlayListener.getCurrentPlayClipNo();
        AppMethodBeat.o(228003);
        return i;
      }
      
      public long getCurrentPosition()
      {
        AppMethodBeat.i(227989);
        long l = paramITPPlayListener.getCurrentPosition();
        AppMethodBeat.o(227989);
        return l;
      }
      
      public String getDataFilePath(int paramAnonymousInt, String paramAnonymousString)
      {
        return null;
      }
      
      public long getDataTotalSize(int paramAnonymousInt, String paramAnonymousString)
      {
        return 0L;
      }
      
      public String getPlayInfo(String paramAnonymousString)
      {
        AppMethodBeat.i(228035);
        paramAnonymousString = paramITPPlayListener.getPlayInfo(paramAnonymousString);
        if ((paramAnonymousString != null) && (paramAnonymousString.getClass() == String.class))
        {
          if (paramAnonymousString.getClass() == String.class)
          {
            paramAnonymousString = (String)paramAnonymousString;
            AppMethodBeat.o(228035);
            return paramAnonymousString;
          }
          if (paramAnonymousString.getClass() == Integer.class)
          {
            paramAnonymousString = Integer.toString(((Integer)paramAnonymousString).intValue());
            AppMethodBeat.o(228035);
            return paramAnonymousString;
          }
        }
        AppMethodBeat.o(228035);
        return null;
      }
      
      public long getPlayerBufferLength()
      {
        AppMethodBeat.i(227973);
        long l = paramITPPlayListener.getPlayerBufferLength();
        AppMethodBeat.o(227973);
        return l;
      }
      
      public void onDownloadCdnUrlExpired(Map paramAnonymousMap)
      {
        AppMethodBeat.i(227926);
        paramITPPlayListener.onDownloadCdnUrlExpired(paramAnonymousMap);
        AppMethodBeat.o(227926);
      }
      
      public void onDownloadCdnUrlInfoUpdate(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4)
      {
        AppMethodBeat.i(227912);
        paramITPPlayListener.onDownloadCdnUrlInfoUpdate(paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousString4);
        AppMethodBeat.o(227912);
      }
      
      public void onDownloadCdnUrlUpdate(String paramAnonymousString)
      {
        AppMethodBeat.i(227893);
        paramITPPlayListener.onDownloadCdnUrlUpdate(paramAnonymousString);
        AppMethodBeat.o(227893);
      }
      
      public void onDownloadError(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(227859);
        paramITPPlayListener.onDownloadError(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString);
        AppMethodBeat.o(227859);
      }
      
      public void onDownloadFinish()
      {
        AppMethodBeat.i(227843);
        paramITPPlayListener.onDownloadFinish();
        AppMethodBeat.o(227843);
      }
      
      public void onDownloadProgressUpdate(int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString)
      {
        AppMethodBeat.i(227835);
        paramITPPlayListener.onDownloadProgressUpdate(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousString);
        AppMethodBeat.o(227835);
      }
      
      public void onDownloadProtocolUpdate(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(227958);
        paramITPPlayListener.onDownloadProtocolUpdate(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(227958);
      }
      
      public void onDownloadStatusUpdate(int paramAnonymousInt)
      {
        AppMethodBeat.i(227942);
        paramITPPlayListener.onDownloadStatusUpdate(paramAnonymousInt);
        AppMethodBeat.o(227942);
      }
      
      public int onPlayCallback(int paramAnonymousInt, List paramAnonymousList)
      {
        AppMethodBeat.i(227877);
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
          AppMethodBeat.o(227877);
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
        AppMethodBeat.o(227877);
        return paramAnonymousInt;
      }
      
      public int onReadData(int paramAnonymousInt, String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        return 0;
      }
      
      public int onStartReadData(int paramAnonymousInt, String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        return 0;
      }
      
      public int onStopReadData(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        return 0;
      }
    };
    paramInt = this.downloadProxyAidl.startClipPlay(paramString, paramInt, paramITPPlayListener);
    AppMethodBeat.o(227871);
    return paramInt;
    return -1;
  }
  
  public int startOfflineDownload(String paramString, TPDownloadParam paramTPDownloadParam, ITPOfflineDownloadListener paramITPOfflineDownloadListener)
  {
    return -1;
  }
  
  public int startPlay(String paramString, TPDownloadParam paramTPDownloadParam, final ITPPlayListener paramITPPlayListener)
  {
    AppMethodBeat.i(227862);
    if ((this.downloadProxyAidl == null) || (paramTPDownloadParam == null))
    {
      AppMethodBeat.o(227862);
      return -1;
    }
    paramTPDownloadParam = new TPDownloadParamAidl(paramTPDownloadParam.getUrlList(), paramTPDownloadParam.getDlType(), paramTPDownloadParam.getExtInfoMap());
    if (paramITPPlayListener == null) {}
    try
    {
      i = this.downloadProxyAidl.startPlay(paramString, paramTPDownloadParam, null);
      AppMethodBeat.o(227862);
      return i;
    }
    finally
    {
      int i;
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "startPlay failed, error:" + paramString.toString());
      AppMethodBeat.o(227862);
    }
    paramITPPlayListener = new ITPPlayListenerAidl.Stub()
    {
      public long getAdvRemainTime()
      {
        AppMethodBeat.i(228005);
        long l = paramITPPlayListener.getAdvRemainTime();
        AppMethodBeat.o(228005);
        return l;
      }
      
      public String getContentType(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(228094);
        paramAnonymousString = paramITPPlayListener.getContentType(paramAnonymousInt, paramAnonymousString);
        AppMethodBeat.o(228094);
        return paramAnonymousString;
      }
      
      public int getCurrentPlayClipNo()
      {
        AppMethodBeat.i(227996);
        int i = paramITPPlayListener.getCurrentPlayClipNo();
        AppMethodBeat.o(227996);
        return i;
      }
      
      public long getCurrentPosition()
      {
        AppMethodBeat.i(227984);
        long l = paramITPPlayListener.getCurrentPosition();
        AppMethodBeat.o(227984);
        return l;
      }
      
      public String getDataFilePath(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(228081);
        paramAnonymousString = paramITPPlayListener.getDataFilePath(paramAnonymousInt, paramAnonymousString);
        AppMethodBeat.o(228081);
        return paramAnonymousString;
      }
      
      public long getDataTotalSize(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(228067);
        long l = paramITPPlayListener.getDataTotalSize(paramAnonymousInt, paramAnonymousString);
        AppMethodBeat.o(228067);
        return l;
      }
      
      public String getPlayInfo(String paramAnonymousString)
      {
        AppMethodBeat.i(228024);
        paramAnonymousString = paramITPPlayListener.getPlayInfo(paramAnonymousString);
        if ((paramAnonymousString != null) && (paramAnonymousString.getClass() == String.class))
        {
          if (paramAnonymousString.getClass() == String.class)
          {
            paramAnonymousString = (String)paramAnonymousString;
            AppMethodBeat.o(228024);
            return paramAnonymousString;
          }
          if (paramAnonymousString.getClass() == Integer.class)
          {
            paramAnonymousString = Integer.toString(((Integer)paramAnonymousString).intValue());
            AppMethodBeat.o(228024);
            return paramAnonymousString;
          }
        }
        AppMethodBeat.o(228024);
        return null;
      }
      
      public long getPlayerBufferLength()
      {
        AppMethodBeat.i(227972);
        long l = paramITPPlayListener.getPlayerBufferLength();
        AppMethodBeat.o(227972);
        return l;
      }
      
      public void onDownloadCdnUrlExpired(Map paramAnonymousMap)
      {
        AppMethodBeat.i(227934);
        paramITPPlayListener.onDownloadCdnUrlExpired(paramAnonymousMap);
        AppMethodBeat.o(227934);
      }
      
      public void onDownloadCdnUrlInfoUpdate(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4)
      {
        AppMethodBeat.i(227919);
        paramITPPlayListener.onDownloadCdnUrlInfoUpdate(paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousString4);
        AppMethodBeat.o(227919);
      }
      
      public void onDownloadCdnUrlUpdate(String paramAnonymousString)
      {
        AppMethodBeat.i(227903);
        paramITPPlayListener.onDownloadCdnUrlUpdate(paramAnonymousString);
        AppMethodBeat.o(227903);
      }
      
      public void onDownloadError(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(227869);
        paramITPPlayListener.onDownloadError(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString);
        AppMethodBeat.o(227869);
      }
      
      public void onDownloadFinish()
      {
        AppMethodBeat.i(227858);
        paramITPPlayListener.onDownloadFinish();
        AppMethodBeat.o(227858);
      }
      
      public void onDownloadProgressUpdate(int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString)
      {
        AppMethodBeat.i(227844);
        paramITPPlayListener.onDownloadProgressUpdate(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousString);
        AppMethodBeat.o(227844);
      }
      
      public void onDownloadProtocolUpdate(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(227961);
        paramITPPlayListener.onDownloadProtocolUpdate(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(227961);
      }
      
      public void onDownloadStatusUpdate(int paramAnonymousInt)
      {
        AppMethodBeat.i(227946);
        paramITPPlayListener.onDownloadStatusUpdate(paramAnonymousInt);
        AppMethodBeat.o(227946);
      }
      
      public int onPlayCallback(int paramAnonymousInt, List paramAnonymousList)
      {
        AppMethodBeat.i(227887);
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
          AppMethodBeat.o(227887);
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
        AppMethodBeat.o(227887);
        return paramAnonymousInt;
      }
      
      public int onReadData(int paramAnonymousInt, String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(228045);
        paramAnonymousInt = paramITPPlayListener.onReadData(paramAnonymousInt, paramAnonymousString, paramAnonymousLong1, paramAnonymousLong2);
        AppMethodBeat.o(228045);
        return paramAnonymousInt;
      }
      
      public int onStartReadData(int paramAnonymousInt, String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(228036);
        paramAnonymousInt = paramITPPlayListener.onStartReadData(paramAnonymousInt, paramAnonymousString, paramAnonymousLong1, paramAnonymousLong2);
        AppMethodBeat.o(228036);
        return paramAnonymousInt;
      }
      
      public int onStopReadData(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        AppMethodBeat.i(228058);
        paramAnonymousInt1 = paramITPPlayListener.onStopReadData(paramAnonymousInt1, paramAnonymousString, paramAnonymousInt2);
        AppMethodBeat.o(228058);
        return paramAnonymousInt1;
      }
    };
    i = this.downloadProxyAidl.startPlay(paramString, paramTPDownloadParam, paramITPPlayListener);
    AppMethodBeat.o(227862);
    return i;
    return -1;
  }
  
  public int startPreload(String paramString, TPDownloadParam paramTPDownloadParam, final ITPPreLoadListener paramITPPreLoadListener)
  {
    AppMethodBeat.i(227949);
    paramTPDownloadParam = new TPDownloadParamAidl(paramTPDownloadParam.getUrlList(), paramTPDownloadParam.getDlType(), paramTPDownloadParam.getExtInfoMap());
    paramITPPreLoadListener = new ITPPreLoadListenerAidl.Stub()
    {
      public void onPrepareDownloadProgressUpdate(int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString)
      {
        AppMethodBeat.i(227875);
        paramITPPreLoadListener.onPrepareDownloadProgressUpdate(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousString);
        AppMethodBeat.o(227875);
      }
      
      public void onPrepareError(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(227861);
        paramITPPreLoadListener.onPrepareError(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString);
        AppMethodBeat.o(227861);
      }
      
      public void onPrepareOK()
      {
        AppMethodBeat.i(227846);
        paramITPPreLoadListener.onPrepareOK();
        AppMethodBeat.o(227846);
      }
    };
    try
    {
      int i = this.downloadProxyAidl.startPreload(paramString, paramTPDownloadParam, paramITPPreLoadListener);
      AppMethodBeat.o(227949);
      return i;
    }
    finally
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "startPreload failed, error:" + paramString.toString());
      AppMethodBeat.o(227949);
    }
    return -1;
  }
  
  public void startTask(int paramInt) {}
  
  public void stopOfflineDownload(int paramInt) {}
  
  public void stopPlay(int paramInt)
  {
    AppMethodBeat.i(227921);
    try
    {
      this.downloadProxyAidl.stopPlay(paramInt);
      AppMethodBeat.o(227921);
      return;
    }
    finally
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "stopPlay failed, error:" + localObject.toString());
      AppMethodBeat.o(227921);
    }
  }
  
  public void stopPreload(int paramInt)
  {
    AppMethodBeat.i(227956);
    try
    {
      this.downloadProxyAidl.stopPreload(paramInt);
      AppMethodBeat.o(227956);
      return;
    }
    finally
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "stopPreload failed, error:" + localObject.toString());
      AppMethodBeat.o(227956);
    }
  }
  
  public void updateAidl(ITPDownloadProxyAidl paramITPDownloadProxyAidl)
  {
    this.downloadProxyAidl = paramITPDownloadProxyAidl;
  }
  
  public void updateStoragePath(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.client.TPDownloadProxyClient
 * JD-Core Version:    0.7.0.1
 */