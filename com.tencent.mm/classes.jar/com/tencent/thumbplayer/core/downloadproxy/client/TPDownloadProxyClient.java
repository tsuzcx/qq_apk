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
    AppMethodBeat.i(191518);
    try
    {
      String str = this.downloadProxyAidl.getClipPlayUrl(paramInt1, paramInt2);
      AppMethodBeat.o(191518);
      return str;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "getClipPlayUrl failed, error:" + localThrowable.toString());
      AppMethodBeat.o(191518);
    }
    return null;
  }
  
  public String getPlayErrorCodeStr(int paramInt)
  {
    AppMethodBeat.i(191519);
    try
    {
      String str = this.downloadProxyAidl.getPlayErrorCodeStr(paramInt);
      AppMethodBeat.o(191519);
      return str;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "getPlayErrorCodeStr failed, error:" + localThrowable.toString());
      AppMethodBeat.o(191519);
    }
    return null;
  }
  
  public String getPlayUrl(int paramInt)
  {
    AppMethodBeat.i(191517);
    try
    {
      String str = this.downloadProxyAidl.getPlayUrl(paramInt);
      AppMethodBeat.o(191517);
      return str;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "getPlayUrl failed, error:" + localThrowable.toString());
      AppMethodBeat.o(191517);
    }
    return null;
  }
  
  public int init(Context paramContext, TPDLProxyInitParam paramTPDLProxyInitParam)
  {
    AppMethodBeat.i(191512);
    paramContext = TPDLProxyUtils.serialize(paramTPDLProxyInitParam);
    if (TextUtils.isEmpty(paramContext))
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "param is null");
      AppMethodBeat.o(191512);
      return -1;
    }
    try
    {
      int i = this.downloadProxyAidl.init(paramContext);
      AppMethodBeat.o(191512);
      return i;
    }
    catch (Throwable paramContext)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "init failed, error:" + paramContext.toString());
      AppMethodBeat.o(191512);
    }
    return -2;
  }
  
  public int pauseDownload(int paramInt)
  {
    AppMethodBeat.i(191521);
    try
    {
      paramInt = this.downloadProxyAidl.pauseDownload(paramInt);
      AppMethodBeat.o(191521);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "pauseDownload failed, error:" + localThrowable.toString());
      AppMethodBeat.o(191521);
    }
    return -1;
  }
  
  public void pushEvent(int paramInt)
  {
    AppMethodBeat.i(191527);
    try
    {
      this.downloadProxyAidl.pushEvent(paramInt);
      AppMethodBeat.o(191527);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "pushEvent failed, error:" + localThrowable.toString());
      AppMethodBeat.o(191527);
    }
  }
  
  public int removeOfflineDownload(String paramString)
  {
    return -1;
  }
  
  public int resumeDownload(int paramInt)
  {
    AppMethodBeat.i(191522);
    try
    {
      paramInt = this.downloadProxyAidl.resumeDownload(paramInt);
      AppMethodBeat.o(191522);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "resumeDownload failed, error:" + localThrowable.toString());
      AppMethodBeat.o(191522);
    }
    return -1;
  }
  
  public boolean setClipInfo(int paramInt1, int paramInt2, String paramString, TPDownloadParam paramTPDownloadParam)
  {
    AppMethodBeat.i(191516);
    paramTPDownloadParam = new TPDownloadParamAidl(paramTPDownloadParam.getUrlList(), paramTPDownloadParam.getDlType(), paramTPDownloadParam.getExtInfoMap());
    try
    {
      boolean bool = this.downloadProxyAidl.setClipInfo(paramInt1, paramInt2, paramString, paramTPDownloadParam);
      AppMethodBeat.o(191516);
      return bool;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "setClipInfo failed, error:" + paramString.toString());
      AppMethodBeat.o(191516);
    }
    return false;
  }
  
  public void setLogListener(ITPDLProxyLogListener paramITPDLProxyLogListener)
  {
    AppMethodBeat.i(191513);
    TPDLProxyLog.setLogListener(10303, paramITPDLProxyLogListener);
    AppMethodBeat.o(191513);
  }
  
  public void setMaxStorageSizeMB(long paramLong)
  {
    AppMethodBeat.i(191525);
    try
    {
      this.downloadProxyAidl.setMaxStorageSizeMB(paramLong);
      AppMethodBeat.o(191525);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "setMaxStorageSizeMB failed, error:" + localThrowable.toString());
      AppMethodBeat.o(191525);
    }
  }
  
  public void setPlayState(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191528);
    try
    {
      this.downloadProxyAidl.setPlayState(paramInt1, paramInt2);
      AppMethodBeat.o(191528);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "setPlayState failed, error:" + localThrowable.toString());
      AppMethodBeat.o(191528);
    }
  }
  
  public void setUserData(String paramString, Object paramObject)
  {
    AppMethodBeat.i(191526);
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString, paramObject);
    try
    {
      this.downloadProxyAidl.setUserData(localHashMap);
      AppMethodBeat.o(191526);
      return;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "setUserData failed, error:" + paramString.toString());
      AppMethodBeat.o(191526);
    }
  }
  
  public int startClipOfflineDownload(String paramString, int paramInt, ITPOfflineDownloadListener paramITPOfflineDownloadListener)
  {
    return -1;
  }
  
  public int startClipPlay(String paramString, int paramInt, final ITPPlayListener paramITPPlayListener)
  {
    AppMethodBeat.i(191515);
    paramITPPlayListener = new ITPPlayListenerAidl.Stub()
    {
      public long getAdvRemainTime()
      {
        AppMethodBeat.i(191501);
        long l = paramITPPlayListener.getAdvRemainTime();
        AppMethodBeat.o(191501);
        return l;
      }
      
      public String getContentType(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(191508);
        paramAnonymousString = paramITPPlayListener.getContentType(paramAnonymousLong, paramAnonymousString);
        AppMethodBeat.o(191508);
        return paramAnonymousString;
      }
      
      public int getCurrentPlayClipNo()
      {
        AppMethodBeat.i(191500);
        int i = paramITPPlayListener.getCurrentPlayClipNo();
        AppMethodBeat.o(191500);
        return i;
      }
      
      public long getCurrentPosition()
      {
        AppMethodBeat.i(191499);
        long l = paramITPPlayListener.getCurrentPosition();
        AppMethodBeat.o(191499);
        return l;
      }
      
      public String getDataFilePath(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(191507);
        paramAnonymousString = paramITPPlayListener.getDataFilePath(paramAnonymousLong, paramAnonymousString);
        AppMethodBeat.o(191507);
        return paramAnonymousString;
      }
      
      public long getDataTotalSize(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(191506);
        paramAnonymousLong = paramITPPlayListener.getDataTotalSize(paramAnonymousLong, paramAnonymousString);
        AppMethodBeat.o(191506);
        return paramAnonymousLong;
      }
      
      public String getPlayInfo(String paramAnonymousString)
      {
        AppMethodBeat.i(191502);
        paramAnonymousString = paramITPPlayListener.getPlayInfo(paramAnonymousString);
        if ((paramAnonymousString != null) && (paramAnonymousString.getClass() == String.class))
        {
          if (paramAnonymousString.getClass() == String.class)
          {
            paramAnonymousString = (String)paramAnonymousString;
            AppMethodBeat.o(191502);
            return paramAnonymousString;
          }
          if (paramAnonymousString.getClass() == Integer.class)
          {
            paramAnonymousString = Integer.toString(((Integer)paramAnonymousString).intValue());
            AppMethodBeat.o(191502);
            return paramAnonymousString;
          }
        }
        AppMethodBeat.o(191502);
        return null;
      }
      
      public long getPlayerBufferLength()
      {
        AppMethodBeat.i(191498);
        long l = paramITPPlayListener.getPlayerBufferLength();
        AppMethodBeat.o(191498);
        return l;
      }
      
      public void onDownloadCdnUrlExpired(Map paramAnonymousMap)
      {
        AppMethodBeat.i(191495);
        paramITPPlayListener.onDownloadCdnUrlExpired(paramAnonymousMap);
        AppMethodBeat.o(191495);
      }
      
      public void onDownloadCdnUrlInfoUpdate(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4)
      {
        AppMethodBeat.i(191494);
        paramITPPlayListener.onDownloadCdnUrlInfoUpdate(paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousString4);
        AppMethodBeat.o(191494);
      }
      
      public void onDownloadCdnUrlUpdate(String paramAnonymousString)
      {
        AppMethodBeat.i(191493);
        paramITPPlayListener.onDownloadCdnUrlUpdate(paramAnonymousString);
        AppMethodBeat.o(191493);
      }
      
      public void onDownloadError(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(191491);
        paramITPPlayListener.onDownloadError(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString);
        AppMethodBeat.o(191491);
      }
      
      public void onDownloadFinish()
      {
        AppMethodBeat.i(191490);
        paramITPPlayListener.onDownloadFinish();
        AppMethodBeat.o(191490);
      }
      
      public void onDownloadProgressUpdate(int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(191489);
        paramITPPlayListener.onDownloadProgressUpdate(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousLong1, paramAnonymousLong2);
        AppMethodBeat.o(191489);
      }
      
      public void onDownloadProtocolUpdate(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(191497);
        paramITPPlayListener.onDownloadProtocolUpdate(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(191497);
      }
      
      public void onDownloadStatusUpdate(int paramAnonymousInt)
      {
        AppMethodBeat.i(191496);
        paramITPPlayListener.onDownloadStatusUpdate(paramAnonymousInt);
        AppMethodBeat.o(191496);
      }
      
      public int onPlayCallback(int paramAnonymousInt, List paramAnonymousList)
      {
        AppMethodBeat.i(191492);
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
          AppMethodBeat.o(191492);
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
        AppMethodBeat.o(191492);
        return paramAnonymousInt;
      }
      
      public int onReadData(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3)
      {
        AppMethodBeat.i(191504);
        int i = paramITPPlayListener.onReadData(paramAnonymousLong1, paramAnonymousString, paramAnonymousLong2, paramAnonymousLong3);
        AppMethodBeat.o(191504);
        return i;
      }
      
      public int onStartReadData(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3)
      {
        AppMethodBeat.i(191503);
        int i = paramITPPlayListener.onStartReadData(paramAnonymousLong1, paramAnonymousString, paramAnonymousLong2, paramAnonymousLong3);
        AppMethodBeat.o(191503);
        return i;
      }
      
      public int onStopReadData(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(191505);
        int i = paramITPPlayListener.onStopReadData(paramAnonymousLong, paramAnonymousString);
        AppMethodBeat.o(191505);
        return i;
      }
    };
    try
    {
      paramInt = this.downloadProxyAidl.startClipPlay(paramString, paramInt, paramITPPlayListener);
      AppMethodBeat.o(191515);
      return paramInt;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "startClipPlay failed, error:" + paramString.toString());
      AppMethodBeat.o(191515);
    }
    return -1;
  }
  
  public int startOfflineDownload(String paramString, TPDownloadParam paramTPDownloadParam, ITPOfflineDownloadListener paramITPOfflineDownloadListener)
  {
    return -1;
  }
  
  public int startPlay(String paramString, TPDownloadParam paramTPDownloadParam, final ITPPlayListener paramITPPlayListener)
  {
    AppMethodBeat.i(191514);
    if ((this.downloadProxyAidl == null) || (paramTPDownloadParam == null) || (paramITPPlayListener == null))
    {
      AppMethodBeat.o(191514);
      return -1;
    }
    paramTPDownloadParam = new TPDownloadParamAidl(paramTPDownloadParam.getUrlList(), paramTPDownloadParam.getDlType(), paramTPDownloadParam.getExtInfoMap());
    paramITPPlayListener = new ITPPlayListenerAidl.Stub()
    {
      public long getAdvRemainTime()
      {
        AppMethodBeat.i(191481);
        long l = paramITPPlayListener.getAdvRemainTime();
        AppMethodBeat.o(191481);
        return l;
      }
      
      public String getContentType(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(191488);
        paramAnonymousString = paramITPPlayListener.getContentType(paramAnonymousLong, paramAnonymousString);
        AppMethodBeat.o(191488);
        return paramAnonymousString;
      }
      
      public int getCurrentPlayClipNo()
      {
        AppMethodBeat.i(191480);
        int i = paramITPPlayListener.getCurrentPlayClipNo();
        AppMethodBeat.o(191480);
        return i;
      }
      
      public long getCurrentPosition()
      {
        AppMethodBeat.i(191479);
        long l = paramITPPlayListener.getCurrentPosition();
        AppMethodBeat.o(191479);
        return l;
      }
      
      public String getDataFilePath(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(191487);
        paramAnonymousString = paramITPPlayListener.getDataFilePath(paramAnonymousLong, paramAnonymousString);
        AppMethodBeat.o(191487);
        return paramAnonymousString;
      }
      
      public long getDataTotalSize(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(191486);
        paramAnonymousLong = paramITPPlayListener.getDataTotalSize(paramAnonymousLong, paramAnonymousString);
        AppMethodBeat.o(191486);
        return paramAnonymousLong;
      }
      
      public String getPlayInfo(String paramAnonymousString)
      {
        AppMethodBeat.i(191482);
        paramAnonymousString = paramITPPlayListener.getPlayInfo(paramAnonymousString);
        if ((paramAnonymousString != null) && (paramAnonymousString.getClass() == String.class))
        {
          if (paramAnonymousString.getClass() == String.class)
          {
            paramAnonymousString = (String)paramAnonymousString;
            AppMethodBeat.o(191482);
            return paramAnonymousString;
          }
          if (paramAnonymousString.getClass() == Integer.class)
          {
            paramAnonymousString = Integer.toString(((Integer)paramAnonymousString).intValue());
            AppMethodBeat.o(191482);
            return paramAnonymousString;
          }
        }
        AppMethodBeat.o(191482);
        return null;
      }
      
      public long getPlayerBufferLength()
      {
        AppMethodBeat.i(191478);
        long l = paramITPPlayListener.getPlayerBufferLength();
        AppMethodBeat.o(191478);
        return l;
      }
      
      public void onDownloadCdnUrlExpired(Map paramAnonymousMap)
      {
        AppMethodBeat.i(191475);
        paramITPPlayListener.onDownloadCdnUrlExpired(paramAnonymousMap);
        AppMethodBeat.o(191475);
      }
      
      public void onDownloadCdnUrlInfoUpdate(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4)
      {
        AppMethodBeat.i(191474);
        paramITPPlayListener.onDownloadCdnUrlInfoUpdate(paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousString4);
        AppMethodBeat.o(191474);
      }
      
      public void onDownloadCdnUrlUpdate(String paramAnonymousString)
      {
        AppMethodBeat.i(191473);
        paramITPPlayListener.onDownloadCdnUrlUpdate(paramAnonymousString);
        AppMethodBeat.o(191473);
      }
      
      public void onDownloadError(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(191471);
        paramITPPlayListener.onDownloadError(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString);
        AppMethodBeat.o(191471);
      }
      
      public void onDownloadFinish()
      {
        AppMethodBeat.i(191470);
        paramITPPlayListener.onDownloadFinish();
        AppMethodBeat.o(191470);
      }
      
      public void onDownloadProgressUpdate(int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(191469);
        paramITPPlayListener.onDownloadProgressUpdate(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousLong1, paramAnonymousLong2);
        AppMethodBeat.o(191469);
      }
      
      public void onDownloadProtocolUpdate(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(191477);
        paramITPPlayListener.onDownloadProtocolUpdate(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(191477);
      }
      
      public void onDownloadStatusUpdate(int paramAnonymousInt)
      {
        AppMethodBeat.i(191476);
        paramITPPlayListener.onDownloadStatusUpdate(paramAnonymousInt);
        AppMethodBeat.o(191476);
      }
      
      public int onPlayCallback(int paramAnonymousInt, List paramAnonymousList)
      {
        AppMethodBeat.i(191472);
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
          AppMethodBeat.o(191472);
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
        AppMethodBeat.o(191472);
        return paramAnonymousInt;
      }
      
      public int onReadData(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3)
      {
        AppMethodBeat.i(191484);
        int i = paramITPPlayListener.onReadData(paramAnonymousLong1, paramAnonymousString, paramAnonymousLong2, paramAnonymousLong3);
        AppMethodBeat.o(191484);
        return i;
      }
      
      public int onStartReadData(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3)
      {
        AppMethodBeat.i(191483);
        int i = paramITPPlayListener.onStartReadData(paramAnonymousLong1, paramAnonymousString, paramAnonymousLong2, paramAnonymousLong3);
        AppMethodBeat.o(191483);
        return i;
      }
      
      public int onStopReadData(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(191485);
        int i = paramITPPlayListener.onStopReadData(paramAnonymousLong, paramAnonymousString);
        AppMethodBeat.o(191485);
        return i;
      }
    };
    try
    {
      int i = this.downloadProxyAidl.startPlay(paramString, paramTPDownloadParam, paramITPPlayListener);
      AppMethodBeat.o(191514);
      return i;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "startPlay failed, error:" + paramString.toString());
      AppMethodBeat.o(191514);
    }
    return -1;
  }
  
  public int startPreload(String paramString, TPDownloadParam paramTPDownloadParam, final ITPPreLoadListener paramITPPreLoadListener)
  {
    AppMethodBeat.i(191523);
    paramTPDownloadParam = new TPDownloadParamAidl(paramTPDownloadParam.getUrlList(), paramTPDownloadParam.getDlType(), paramTPDownloadParam.getExtInfoMap());
    paramITPPreLoadListener = new ITPPreLoadListenerAidl.Stub()
    {
      public void onPrepareDownloadProgressUpdate(int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(191511);
        paramITPPreLoadListener.onPrepareDownloadProgressUpdate(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousLong1, paramAnonymousLong2);
        AppMethodBeat.o(191511);
      }
      
      public void onPrepareError()
      {
        AppMethodBeat.i(191510);
        paramITPPreLoadListener.onPrepareError();
        AppMethodBeat.o(191510);
      }
      
      public void onPrepareOK()
      {
        AppMethodBeat.i(191509);
        paramITPPreLoadListener.onPrepareOK();
        AppMethodBeat.o(191509);
      }
    };
    try
    {
      int i = this.downloadProxyAidl.startPreload(paramString, paramTPDownloadParam, paramITPPreLoadListener);
      AppMethodBeat.o(191523);
      return i;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "startPreload failed, error:" + paramString.toString());
      AppMethodBeat.o(191523);
    }
    return -1;
  }
  
  public void startTask(int paramInt) {}
  
  public void stopOfflineDownload(int paramInt) {}
  
  public void stopPlay(int paramInt)
  {
    AppMethodBeat.i(191520);
    try
    {
      this.downloadProxyAidl.stopPlay(paramInt);
      AppMethodBeat.o(191520);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "stopPlay failed, error:" + localThrowable.toString());
      AppMethodBeat.o(191520);
    }
  }
  
  public void stopPreload(int paramInt)
  {
    AppMethodBeat.i(191524);
    try
    {
      this.downloadProxyAidl.stopPreload(paramInt);
      AppMethodBeat.o(191524);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "stopPreload failed, error:" + localThrowable.toString());
      AppMethodBeat.o(191524);
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