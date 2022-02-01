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
    AppMethodBeat.i(210014);
    try
    {
      String str = this.downloadProxyAidl.getClipPlayUrl(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(210014);
      return str;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "getClipPlayUrl failed, error:" + localThrowable.toString());
      AppMethodBeat.o(210014);
    }
    return null;
  }
  
  public String getPlayErrorCodeStr(int paramInt)
  {
    AppMethodBeat.i(210015);
    try
    {
      String str = this.downloadProxyAidl.getPlayErrorCodeStr(paramInt);
      AppMethodBeat.o(210015);
      return str;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "getPlayErrorCodeStr failed, error:" + localThrowable.toString());
      AppMethodBeat.o(210015);
    }
    return null;
  }
  
  public String getPlayUrl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210013);
    try
    {
      String str = this.downloadProxyAidl.getPlayUrl(paramInt1, paramInt2);
      AppMethodBeat.o(210013);
      return str;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "getPlayUrl failed, error:" + localThrowable.toString());
      AppMethodBeat.o(210013);
    }
    return null;
  }
  
  public int init(Context paramContext, TPDLProxyInitParam paramTPDLProxyInitParam)
  {
    AppMethodBeat.i(210008);
    paramContext = TPDLProxyUtils.serialize(paramTPDLProxyInitParam);
    if (TextUtils.isEmpty(paramContext))
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "param is null");
      AppMethodBeat.o(210008);
      return -1;
    }
    try
    {
      int i = this.downloadProxyAidl.init(paramContext);
      AppMethodBeat.o(210008);
      return i;
    }
    catch (Throwable paramContext)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "init failed, error:" + paramContext.toString());
      AppMethodBeat.o(210008);
    }
    return -2;
  }
  
  public int pauseDownload(int paramInt)
  {
    AppMethodBeat.i(210017);
    try
    {
      paramInt = this.downloadProxyAidl.pauseDownload(paramInt);
      AppMethodBeat.o(210017);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "pauseDownload failed, error:" + localThrowable.toString());
      AppMethodBeat.o(210017);
    }
    return -1;
  }
  
  public void pushEvent(int paramInt)
  {
    AppMethodBeat.i(210023);
    try
    {
      this.downloadProxyAidl.pushEvent(paramInt);
      AppMethodBeat.o(210023);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "pushEvent failed, error:" + localThrowable.toString());
      AppMethodBeat.o(210023);
    }
  }
  
  public int removeStorageCache(String paramString)
  {
    return -1;
  }
  
  public int resumeDownload(int paramInt)
  {
    AppMethodBeat.i(210018);
    try
    {
      paramInt = this.downloadProxyAidl.resumeDownload(paramInt);
      AppMethodBeat.o(210018);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "resumeDownload failed, error:" + localThrowable.toString());
      AppMethodBeat.o(210018);
    }
    return -1;
  }
  
  public boolean setClipInfo(int paramInt1, int paramInt2, String paramString, TPDownloadParam paramTPDownloadParam)
  {
    AppMethodBeat.i(210012);
    paramTPDownloadParam = new TPDownloadParamAidl(paramTPDownloadParam.getUrlList(), paramTPDownloadParam.getDlType(), paramTPDownloadParam.getExtInfoMap());
    try
    {
      boolean bool = this.downloadProxyAidl.setClipInfo(paramInt1, paramInt2, paramString, paramTPDownloadParam);
      AppMethodBeat.o(210012);
      return bool;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "setClipInfo failed, error:" + paramString.toString());
      AppMethodBeat.o(210012);
    }
    return false;
  }
  
  public void setLogListener(ITPDLProxyLogListener paramITPDLProxyLogListener)
  {
    AppMethodBeat.i(210009);
    TPDLProxyLog.setLogListener(10303, paramITPDLProxyLogListener);
    AppMethodBeat.o(210009);
  }
  
  public void setMaxStorageSizeMB(long paramLong)
  {
    AppMethodBeat.i(210021);
    try
    {
      this.downloadProxyAidl.setMaxStorageSizeMB(paramLong);
      AppMethodBeat.o(210021);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "setMaxStorageSizeMB failed, error:" + localThrowable.toString());
      AppMethodBeat.o(210021);
    }
  }
  
  public void setPlayState(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210024);
    try
    {
      this.downloadProxyAidl.setPlayState(paramInt1, paramInt2);
      AppMethodBeat.o(210024);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "setPlayState failed, error:" + localThrowable.toString());
      AppMethodBeat.o(210024);
    }
  }
  
  public void setUserData(String paramString, Object paramObject)
  {
    AppMethodBeat.i(210022);
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString, paramObject);
    try
    {
      this.downloadProxyAidl.setUserData(localHashMap);
      AppMethodBeat.o(210022);
      return;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "setUserData failed, error:" + paramString.toString());
      AppMethodBeat.o(210022);
    }
  }
  
  public int startClipOfflineDownload(String paramString, int paramInt, ITPOfflineDownloadListener paramITPOfflineDownloadListener)
  {
    return -1;
  }
  
  public int startClipPlay(String paramString, int paramInt, final ITPPlayListener paramITPPlayListener)
  {
    AppMethodBeat.i(210011);
    if (paramITPPlayListener == null) {}
    try
    {
      paramInt = this.downloadProxyAidl.startClipPlay(paramString, paramInt, null);
      AppMethodBeat.o(210011);
      return paramInt;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "startClipPlay failed, error:" + paramString.toString());
      AppMethodBeat.o(210011);
    }
    paramITPPlayListener = new ITPPlayListenerAidl.Stub()
    {
      public long getAdvRemainTime()
      {
        AppMethodBeat.i(210003);
        long l = paramITPPlayListener.getAdvRemainTime();
        AppMethodBeat.o(210003);
        return l;
      }
      
      public String getContentType(int paramAnonymousInt, String paramAnonymousString)
      {
        return null;
      }
      
      public int getCurrentPlayClipNo()
      {
        AppMethodBeat.i(210002);
        int i = paramITPPlayListener.getCurrentPlayClipNo();
        AppMethodBeat.o(210002);
        return i;
      }
      
      public long getCurrentPosition()
      {
        AppMethodBeat.i(210001);
        long l = paramITPPlayListener.getCurrentPosition();
        AppMethodBeat.o(210001);
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
        AppMethodBeat.i(210004);
        paramAnonymousString = paramITPPlayListener.getPlayInfo(paramAnonymousString);
        if ((paramAnonymousString != null) && (paramAnonymousString.getClass() == String.class))
        {
          if (paramAnonymousString.getClass() == String.class)
          {
            paramAnonymousString = (String)paramAnonymousString;
            AppMethodBeat.o(210004);
            return paramAnonymousString;
          }
          if (paramAnonymousString.getClass() == Integer.class)
          {
            paramAnonymousString = Integer.toString(((Integer)paramAnonymousString).intValue());
            AppMethodBeat.o(210004);
            return paramAnonymousString;
          }
        }
        AppMethodBeat.o(210004);
        return null;
      }
      
      public long getPlayerBufferLength()
      {
        AppMethodBeat.i(210000);
        long l = paramITPPlayListener.getPlayerBufferLength();
        AppMethodBeat.o(210000);
        return l;
      }
      
      public void onDownloadCdnUrlExpired(Map paramAnonymousMap)
      {
        AppMethodBeat.i(209997);
        paramITPPlayListener.onDownloadCdnUrlExpired(paramAnonymousMap);
        AppMethodBeat.o(209997);
      }
      
      public void onDownloadCdnUrlInfoUpdate(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4)
      {
        AppMethodBeat.i(209996);
        paramITPPlayListener.onDownloadCdnUrlInfoUpdate(paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousString4);
        AppMethodBeat.o(209996);
      }
      
      public void onDownloadCdnUrlUpdate(String paramAnonymousString)
      {
        AppMethodBeat.i(209995);
        paramITPPlayListener.onDownloadCdnUrlUpdate(paramAnonymousString);
        AppMethodBeat.o(209995);
      }
      
      public void onDownloadError(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(209993);
        paramITPPlayListener.onDownloadError(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString);
        AppMethodBeat.o(209993);
      }
      
      public void onDownloadFinish()
      {
        AppMethodBeat.i(209992);
        paramITPPlayListener.onDownloadFinish();
        AppMethodBeat.o(209992);
      }
      
      public void onDownloadProgressUpdate(int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString)
      {
        AppMethodBeat.i(209991);
        paramITPPlayListener.onDownloadProgressUpdate(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousString);
        AppMethodBeat.o(209991);
      }
      
      public void onDownloadProtocolUpdate(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(209999);
        paramITPPlayListener.onDownloadProtocolUpdate(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(209999);
      }
      
      public void onDownloadStatusUpdate(int paramAnonymousInt)
      {
        AppMethodBeat.i(209998);
        paramITPPlayListener.onDownloadStatusUpdate(paramAnonymousInt);
        AppMethodBeat.o(209998);
      }
      
      public int onPlayCallback(int paramAnonymousInt, List paramAnonymousList)
      {
        AppMethodBeat.i(209994);
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
          AppMethodBeat.o(209994);
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
        AppMethodBeat.o(209994);
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
    AppMethodBeat.o(210011);
    return paramInt;
    return -1;
  }
  
  public int startOfflineDownload(String paramString, TPDownloadParam paramTPDownloadParam, ITPOfflineDownloadListener paramITPOfflineDownloadListener)
  {
    return -1;
  }
  
  public int startPlay(String paramString, TPDownloadParam paramTPDownloadParam, final ITPPlayListener paramITPPlayListener)
  {
    AppMethodBeat.i(210010);
    if ((this.downloadProxyAidl == null) || (paramTPDownloadParam == null))
    {
      AppMethodBeat.o(210010);
      return -1;
    }
    paramTPDownloadParam = new TPDownloadParamAidl(paramTPDownloadParam.getUrlList(), paramTPDownloadParam.getDlType(), paramTPDownloadParam.getExtInfoMap());
    if (paramITPPlayListener == null) {}
    try
    {
      i = this.downloadProxyAidl.startPlay(paramString, paramTPDownloadParam, null);
      AppMethodBeat.o(210010);
      return i;
    }
    catch (Throwable paramString)
    {
      int i;
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "startPlay failed, error:" + paramString.toString());
      AppMethodBeat.o(210010);
    }
    paramITPPlayListener = new ITPPlayListenerAidl.Stub()
    {
      public long getAdvRemainTime()
      {
        AppMethodBeat.i(209983);
        long l = paramITPPlayListener.getAdvRemainTime();
        AppMethodBeat.o(209983);
        return l;
      }
      
      public String getContentType(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(209990);
        paramAnonymousString = paramITPPlayListener.getContentType(paramAnonymousInt, paramAnonymousString);
        AppMethodBeat.o(209990);
        return paramAnonymousString;
      }
      
      public int getCurrentPlayClipNo()
      {
        AppMethodBeat.i(209982);
        int i = paramITPPlayListener.getCurrentPlayClipNo();
        AppMethodBeat.o(209982);
        return i;
      }
      
      public long getCurrentPosition()
      {
        AppMethodBeat.i(209981);
        long l = paramITPPlayListener.getCurrentPosition();
        AppMethodBeat.o(209981);
        return l;
      }
      
      public String getDataFilePath(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(209989);
        paramAnonymousString = paramITPPlayListener.getDataFilePath(paramAnonymousInt, paramAnonymousString);
        AppMethodBeat.o(209989);
        return paramAnonymousString;
      }
      
      public long getDataTotalSize(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(209988);
        long l = paramITPPlayListener.getDataTotalSize(paramAnonymousInt, paramAnonymousString);
        AppMethodBeat.o(209988);
        return l;
      }
      
      public String getPlayInfo(String paramAnonymousString)
      {
        AppMethodBeat.i(209984);
        paramAnonymousString = paramITPPlayListener.getPlayInfo(paramAnonymousString);
        if ((paramAnonymousString != null) && (paramAnonymousString.getClass() == String.class))
        {
          if (paramAnonymousString.getClass() == String.class)
          {
            paramAnonymousString = (String)paramAnonymousString;
            AppMethodBeat.o(209984);
            return paramAnonymousString;
          }
          if (paramAnonymousString.getClass() == Integer.class)
          {
            paramAnonymousString = Integer.toString(((Integer)paramAnonymousString).intValue());
            AppMethodBeat.o(209984);
            return paramAnonymousString;
          }
        }
        AppMethodBeat.o(209984);
        return null;
      }
      
      public long getPlayerBufferLength()
      {
        AppMethodBeat.i(209980);
        long l = paramITPPlayListener.getPlayerBufferLength();
        AppMethodBeat.o(209980);
        return l;
      }
      
      public void onDownloadCdnUrlExpired(Map paramAnonymousMap)
      {
        AppMethodBeat.i(209977);
        paramITPPlayListener.onDownloadCdnUrlExpired(paramAnonymousMap);
        AppMethodBeat.o(209977);
      }
      
      public void onDownloadCdnUrlInfoUpdate(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4)
      {
        AppMethodBeat.i(209976);
        paramITPPlayListener.onDownloadCdnUrlInfoUpdate(paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousString4);
        AppMethodBeat.o(209976);
      }
      
      public void onDownloadCdnUrlUpdate(String paramAnonymousString)
      {
        AppMethodBeat.i(209975);
        paramITPPlayListener.onDownloadCdnUrlUpdate(paramAnonymousString);
        AppMethodBeat.o(209975);
      }
      
      public void onDownloadError(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(209973);
        paramITPPlayListener.onDownloadError(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString);
        AppMethodBeat.o(209973);
      }
      
      public void onDownloadFinish()
      {
        AppMethodBeat.i(209972);
        paramITPPlayListener.onDownloadFinish();
        AppMethodBeat.o(209972);
      }
      
      public void onDownloadProgressUpdate(int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString)
      {
        AppMethodBeat.i(209971);
        paramITPPlayListener.onDownloadProgressUpdate(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousString);
        AppMethodBeat.o(209971);
      }
      
      public void onDownloadProtocolUpdate(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(209979);
        paramITPPlayListener.onDownloadProtocolUpdate(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(209979);
      }
      
      public void onDownloadStatusUpdate(int paramAnonymousInt)
      {
        AppMethodBeat.i(209978);
        paramITPPlayListener.onDownloadStatusUpdate(paramAnonymousInt);
        AppMethodBeat.o(209978);
      }
      
      public int onPlayCallback(int paramAnonymousInt, List paramAnonymousList)
      {
        AppMethodBeat.i(209974);
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
          AppMethodBeat.o(209974);
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
        AppMethodBeat.o(209974);
        return paramAnonymousInt;
      }
      
      public int onReadData(int paramAnonymousInt, String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(209986);
        paramAnonymousInt = paramITPPlayListener.onReadData(paramAnonymousInt, paramAnonymousString, paramAnonymousLong1, paramAnonymousLong2);
        AppMethodBeat.o(209986);
        return paramAnonymousInt;
      }
      
      public int onStartReadData(int paramAnonymousInt, String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(209985);
        paramAnonymousInt = paramITPPlayListener.onStartReadData(paramAnonymousInt, paramAnonymousString, paramAnonymousLong1, paramAnonymousLong2);
        AppMethodBeat.o(209985);
        return paramAnonymousInt;
      }
      
      public int onStopReadData(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        AppMethodBeat.i(209987);
        paramAnonymousInt1 = paramITPPlayListener.onStopReadData(paramAnonymousInt1, paramAnonymousString, paramAnonymousInt2);
        AppMethodBeat.o(209987);
        return paramAnonymousInt1;
      }
    };
    i = this.downloadProxyAidl.startPlay(paramString, paramTPDownloadParam, paramITPPlayListener);
    AppMethodBeat.o(210010);
    return i;
    return -1;
  }
  
  public int startPreload(String paramString, TPDownloadParam paramTPDownloadParam, final ITPPreLoadListener paramITPPreLoadListener)
  {
    AppMethodBeat.i(210019);
    paramTPDownloadParam = new TPDownloadParamAidl(paramTPDownloadParam.getUrlList(), paramTPDownloadParam.getDlType(), paramTPDownloadParam.getExtInfoMap());
    paramITPPreLoadListener = new ITPPreLoadListenerAidl.Stub()
    {
      public void onPrepareDownloadProgressUpdate(int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString)
      {
        AppMethodBeat.i(210007);
        paramITPPreLoadListener.onPrepareDownloadProgressUpdate(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousString);
        AppMethodBeat.o(210007);
      }
      
      public void onPrepareError(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(210006);
        paramITPPreLoadListener.onPrepareError(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString);
        AppMethodBeat.o(210006);
      }
      
      public void onPrepareOK()
      {
        AppMethodBeat.i(210005);
        paramITPPreLoadListener.onPrepareOK();
        AppMethodBeat.o(210005);
      }
    };
    try
    {
      int i = this.downloadProxyAidl.startPreload(paramString, paramTPDownloadParam, paramITPPreLoadListener);
      AppMethodBeat.o(210019);
      return i;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "startPreload failed, error:" + paramString.toString());
      AppMethodBeat.o(210019);
    }
    return -1;
  }
  
  public void startTask(int paramInt) {}
  
  public void stopOfflineDownload(int paramInt) {}
  
  public void stopPlay(int paramInt)
  {
    AppMethodBeat.i(210016);
    try
    {
      this.downloadProxyAidl.stopPlay(paramInt);
      AppMethodBeat.o(210016);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "stopPlay failed, error:" + localThrowable.toString());
      AppMethodBeat.o(210016);
    }
  }
  
  public void stopPreload(int paramInt)
  {
    AppMethodBeat.i(210020);
    try
    {
      this.downloadProxyAidl.stopPreload(paramInt);
      AppMethodBeat.o(210020);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "stopPreload failed, error:" + localThrowable.toString());
      AppMethodBeat.o(210020);
    }
  }
  
  public void updateAidl(ITPDownloadProxyAidl paramITPDownloadProxyAidl)
  {
    this.downloadProxyAidl = paramITPDownloadProxyAidl;
  }
  
  public void updateStoragePath(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.client.TPDownloadProxyClient
 * JD-Core Version:    0.7.0.1
 */