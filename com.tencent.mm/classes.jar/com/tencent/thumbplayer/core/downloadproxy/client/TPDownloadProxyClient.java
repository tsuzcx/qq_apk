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
    AppMethodBeat.i(190158);
    try
    {
      String str = this.downloadProxyAidl.getClipPlayUrl(paramInt1, paramInt2);
      AppMethodBeat.o(190158);
      return str;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "getClipPlayUrl failed, error:" + localThrowable.toString());
      AppMethodBeat.o(190158);
    }
    return null;
  }
  
  public String getPlayErrorCodeStr(int paramInt)
  {
    AppMethodBeat.i(190159);
    try
    {
      String str = this.downloadProxyAidl.getPlayErrorCodeStr(paramInt);
      AppMethodBeat.o(190159);
      return str;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "getPlayErrorCodeStr failed, error:" + localThrowable.toString());
      AppMethodBeat.o(190159);
    }
    return null;
  }
  
  public String getPlayUrl(int paramInt)
  {
    AppMethodBeat.i(190157);
    try
    {
      String str = this.downloadProxyAidl.getPlayUrl(paramInt);
      AppMethodBeat.o(190157);
      return str;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "getPlayUrl failed, error:" + localThrowable.toString());
      AppMethodBeat.o(190157);
    }
    return null;
  }
  
  public int init(Context paramContext, TPDLProxyInitParam paramTPDLProxyInitParam)
  {
    AppMethodBeat.i(190152);
    paramContext = TPDLProxyUtils.serialize(paramTPDLProxyInitParam);
    if (TextUtils.isEmpty(paramContext))
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "param is null");
      AppMethodBeat.o(190152);
      return -1;
    }
    try
    {
      int i = this.downloadProxyAidl.init(paramContext);
      AppMethodBeat.o(190152);
      return i;
    }
    catch (Throwable paramContext)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "init failed, error:" + paramContext.toString());
      AppMethodBeat.o(190152);
    }
    return -2;
  }
  
  public int pauseDownload(int paramInt)
  {
    AppMethodBeat.i(190161);
    try
    {
      paramInt = this.downloadProxyAidl.pauseDownload(paramInt);
      AppMethodBeat.o(190161);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "pauseDownload failed, error:" + localThrowable.toString());
      AppMethodBeat.o(190161);
    }
    return -1;
  }
  
  public void pushEvent(int paramInt)
  {
    AppMethodBeat.i(190167);
    try
    {
      this.downloadProxyAidl.pushEvent(paramInt);
      AppMethodBeat.o(190167);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "pushEvent failed, error:" + localThrowable.toString());
      AppMethodBeat.o(190167);
    }
  }
  
  public int removeOfflineDownload(String paramString)
  {
    return -1;
  }
  
  public int resumeDownload(int paramInt)
  {
    AppMethodBeat.i(190162);
    try
    {
      paramInt = this.downloadProxyAidl.resumeDownload(paramInt);
      AppMethodBeat.o(190162);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "resumeDownload failed, error:" + localThrowable.toString());
      AppMethodBeat.o(190162);
    }
    return -1;
  }
  
  public boolean setClipInfo(int paramInt1, int paramInt2, String paramString, TPDownloadParam paramTPDownloadParam)
  {
    AppMethodBeat.i(190156);
    paramTPDownloadParam = new TPDownloadParamAidl(paramTPDownloadParam.getUrlList(), paramTPDownloadParam.getDlType(), paramTPDownloadParam.getExtInfoMap());
    try
    {
      boolean bool = this.downloadProxyAidl.setClipInfo(paramInt1, paramInt2, paramString, paramTPDownloadParam);
      AppMethodBeat.o(190156);
      return bool;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "setClipInfo failed, error:" + paramString.toString());
      AppMethodBeat.o(190156);
    }
    return false;
  }
  
  public void setLogListener(ITPDLProxyLogListener paramITPDLProxyLogListener)
  {
    AppMethodBeat.i(190153);
    TPDLProxyLog.setLogListener(10303, paramITPDLProxyLogListener);
    AppMethodBeat.o(190153);
  }
  
  public void setMaxStorageSizeMB(long paramLong)
  {
    AppMethodBeat.i(190165);
    try
    {
      this.downloadProxyAidl.setMaxStorageSizeMB(paramLong);
      AppMethodBeat.o(190165);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "setMaxStorageSizeMB failed, error:" + localThrowable.toString());
      AppMethodBeat.o(190165);
    }
  }
  
  public void setPlayState(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190168);
    try
    {
      this.downloadProxyAidl.setPlayState(paramInt1, paramInt2);
      AppMethodBeat.o(190168);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "setPlayState failed, error:" + localThrowable.toString());
      AppMethodBeat.o(190168);
    }
  }
  
  public void setUserData(String paramString, Object paramObject)
  {
    AppMethodBeat.i(190166);
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString, paramObject);
    try
    {
      this.downloadProxyAidl.setUserData(localHashMap);
      AppMethodBeat.o(190166);
      return;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "setUserData failed, error:" + paramString.toString());
      AppMethodBeat.o(190166);
    }
  }
  
  public int startClipOfflineDownload(String paramString, int paramInt, ITPOfflineDownloadListener paramITPOfflineDownloadListener)
  {
    return -1;
  }
  
  public int startClipPlay(String paramString, int paramInt, final ITPPlayListener paramITPPlayListener)
  {
    AppMethodBeat.i(190155);
    paramITPPlayListener = new ITPPlayListenerAidl.Stub()
    {
      public long getAdvRemainTime()
      {
        AppMethodBeat.i(190141);
        long l = paramITPPlayListener.getAdvRemainTime();
        AppMethodBeat.o(190141);
        return l;
      }
      
      public String getContentType(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(190148);
        paramAnonymousString = paramITPPlayListener.getContentType(paramAnonymousLong, paramAnonymousString);
        AppMethodBeat.o(190148);
        return paramAnonymousString;
      }
      
      public int getCurrentPlayClipNo()
      {
        AppMethodBeat.i(190140);
        int i = paramITPPlayListener.getCurrentPlayClipNo();
        AppMethodBeat.o(190140);
        return i;
      }
      
      public long getCurrentPosition()
      {
        AppMethodBeat.i(190139);
        long l = paramITPPlayListener.getCurrentPosition();
        AppMethodBeat.o(190139);
        return l;
      }
      
      public String getDataFilePath(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(190147);
        paramAnonymousString = paramITPPlayListener.getDataFilePath(paramAnonymousLong, paramAnonymousString);
        AppMethodBeat.o(190147);
        return paramAnonymousString;
      }
      
      public long getDataTotalSize(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(190146);
        paramAnonymousLong = paramITPPlayListener.getDataTotalSize(paramAnonymousLong, paramAnonymousString);
        AppMethodBeat.o(190146);
        return paramAnonymousLong;
      }
      
      public String getPlayInfo(String paramAnonymousString)
      {
        AppMethodBeat.i(190142);
        paramAnonymousString = paramITPPlayListener.getPlayInfo(paramAnonymousString);
        if ((paramAnonymousString != null) && (paramAnonymousString.getClass() == String.class))
        {
          if (paramAnonymousString.getClass() == String.class)
          {
            paramAnonymousString = (String)paramAnonymousString;
            AppMethodBeat.o(190142);
            return paramAnonymousString;
          }
          if (paramAnonymousString.getClass() == Integer.class)
          {
            paramAnonymousString = Integer.toString(((Integer)paramAnonymousString).intValue());
            AppMethodBeat.o(190142);
            return paramAnonymousString;
          }
        }
        AppMethodBeat.o(190142);
        return null;
      }
      
      public long getPlayerBufferLength()
      {
        AppMethodBeat.i(190138);
        long l = paramITPPlayListener.getPlayerBufferLength();
        AppMethodBeat.o(190138);
        return l;
      }
      
      public void onDownloadCdnUrlExpired(Map paramAnonymousMap)
      {
        AppMethodBeat.i(190135);
        paramITPPlayListener.onDownloadCdnUrlExpired(paramAnonymousMap);
        AppMethodBeat.o(190135);
      }
      
      public void onDownloadCdnUrlInfoUpdate(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4)
      {
        AppMethodBeat.i(190134);
        paramITPPlayListener.onDownloadCdnUrlInfoUpdate(paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousString4);
        AppMethodBeat.o(190134);
      }
      
      public void onDownloadCdnUrlUpdate(String paramAnonymousString)
      {
        AppMethodBeat.i(190133);
        paramITPPlayListener.onDownloadCdnUrlUpdate(paramAnonymousString);
        AppMethodBeat.o(190133);
      }
      
      public void onDownloadError(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(190131);
        paramITPPlayListener.onDownloadError(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString);
        AppMethodBeat.o(190131);
      }
      
      public void onDownloadFinish()
      {
        AppMethodBeat.i(190130);
        paramITPPlayListener.onDownloadFinish();
        AppMethodBeat.o(190130);
      }
      
      public void onDownloadProgressUpdate(int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(190129);
        paramITPPlayListener.onDownloadProgressUpdate(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousLong1, paramAnonymousLong2);
        AppMethodBeat.o(190129);
      }
      
      public void onDownloadProtocolUpdate(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(190137);
        paramITPPlayListener.onDownloadProtocolUpdate(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(190137);
      }
      
      public void onDownloadStatusUpdate(int paramAnonymousInt)
      {
        AppMethodBeat.i(190136);
        paramITPPlayListener.onDownloadStatusUpdate(paramAnonymousInt);
        AppMethodBeat.o(190136);
      }
      
      public int onPlayCallback(int paramAnonymousInt, List paramAnonymousList)
      {
        AppMethodBeat.i(190132);
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
          AppMethodBeat.o(190132);
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
        AppMethodBeat.o(190132);
        return paramAnonymousInt;
      }
      
      public int onReadData(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3)
      {
        AppMethodBeat.i(190144);
        int i = paramITPPlayListener.onReadData(paramAnonymousLong1, paramAnonymousString, paramAnonymousLong2, paramAnonymousLong3);
        AppMethodBeat.o(190144);
        return i;
      }
      
      public int onStartReadData(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3)
      {
        AppMethodBeat.i(190143);
        int i = paramITPPlayListener.onStartReadData(paramAnonymousLong1, paramAnonymousString, paramAnonymousLong2, paramAnonymousLong3);
        AppMethodBeat.o(190143);
        return i;
      }
      
      public int onStopReadData(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(190145);
        int i = paramITPPlayListener.onStopReadData(paramAnonymousLong, paramAnonymousString);
        AppMethodBeat.o(190145);
        return i;
      }
    };
    try
    {
      paramInt = this.downloadProxyAidl.startClipPlay(paramString, paramInt, paramITPPlayListener);
      AppMethodBeat.o(190155);
      return paramInt;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "startClipPlay failed, error:" + paramString.toString());
      AppMethodBeat.o(190155);
    }
    return -1;
  }
  
  public int startOfflineDownload(String paramString, TPDownloadParam paramTPDownloadParam, ITPOfflineDownloadListener paramITPOfflineDownloadListener)
  {
    return -1;
  }
  
  public int startPlay(String paramString, TPDownloadParam paramTPDownloadParam, final ITPPlayListener paramITPPlayListener)
  {
    AppMethodBeat.i(190154);
    if ((this.downloadProxyAidl == null) || (paramTPDownloadParam == null) || (paramITPPlayListener == null))
    {
      AppMethodBeat.o(190154);
      return -1;
    }
    paramTPDownloadParam = new TPDownloadParamAidl(paramTPDownloadParam.getUrlList(), paramTPDownloadParam.getDlType(), paramTPDownloadParam.getExtInfoMap());
    paramITPPlayListener = new ITPPlayListenerAidl.Stub()
    {
      public long getAdvRemainTime()
      {
        AppMethodBeat.i(190121);
        long l = paramITPPlayListener.getAdvRemainTime();
        AppMethodBeat.o(190121);
        return l;
      }
      
      public String getContentType(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(190128);
        paramAnonymousString = paramITPPlayListener.getContentType(paramAnonymousLong, paramAnonymousString);
        AppMethodBeat.o(190128);
        return paramAnonymousString;
      }
      
      public int getCurrentPlayClipNo()
      {
        AppMethodBeat.i(190120);
        int i = paramITPPlayListener.getCurrentPlayClipNo();
        AppMethodBeat.o(190120);
        return i;
      }
      
      public long getCurrentPosition()
      {
        AppMethodBeat.i(190119);
        long l = paramITPPlayListener.getCurrentPosition();
        AppMethodBeat.o(190119);
        return l;
      }
      
      public String getDataFilePath(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(190127);
        paramAnonymousString = paramITPPlayListener.getDataFilePath(paramAnonymousLong, paramAnonymousString);
        AppMethodBeat.o(190127);
        return paramAnonymousString;
      }
      
      public long getDataTotalSize(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(190126);
        paramAnonymousLong = paramITPPlayListener.getDataTotalSize(paramAnonymousLong, paramAnonymousString);
        AppMethodBeat.o(190126);
        return paramAnonymousLong;
      }
      
      public String getPlayInfo(String paramAnonymousString)
      {
        AppMethodBeat.i(190122);
        paramAnonymousString = paramITPPlayListener.getPlayInfo(paramAnonymousString);
        if ((paramAnonymousString != null) && (paramAnonymousString.getClass() == String.class))
        {
          if (paramAnonymousString.getClass() == String.class)
          {
            paramAnonymousString = (String)paramAnonymousString;
            AppMethodBeat.o(190122);
            return paramAnonymousString;
          }
          if (paramAnonymousString.getClass() == Integer.class)
          {
            paramAnonymousString = Integer.toString(((Integer)paramAnonymousString).intValue());
            AppMethodBeat.o(190122);
            return paramAnonymousString;
          }
        }
        AppMethodBeat.o(190122);
        return null;
      }
      
      public long getPlayerBufferLength()
      {
        AppMethodBeat.i(190118);
        long l = paramITPPlayListener.getPlayerBufferLength();
        AppMethodBeat.o(190118);
        return l;
      }
      
      public void onDownloadCdnUrlExpired(Map paramAnonymousMap)
      {
        AppMethodBeat.i(190115);
        paramITPPlayListener.onDownloadCdnUrlExpired(paramAnonymousMap);
        AppMethodBeat.o(190115);
      }
      
      public void onDownloadCdnUrlInfoUpdate(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4)
      {
        AppMethodBeat.i(190114);
        paramITPPlayListener.onDownloadCdnUrlInfoUpdate(paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousString4);
        AppMethodBeat.o(190114);
      }
      
      public void onDownloadCdnUrlUpdate(String paramAnonymousString)
      {
        AppMethodBeat.i(190113);
        paramITPPlayListener.onDownloadCdnUrlUpdate(paramAnonymousString);
        AppMethodBeat.o(190113);
      }
      
      public void onDownloadError(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(190111);
        paramITPPlayListener.onDownloadError(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString);
        AppMethodBeat.o(190111);
      }
      
      public void onDownloadFinish()
      {
        AppMethodBeat.i(190110);
        paramITPPlayListener.onDownloadFinish();
        AppMethodBeat.o(190110);
      }
      
      public void onDownloadProgressUpdate(int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(190109);
        paramITPPlayListener.onDownloadProgressUpdate(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousLong1, paramAnonymousLong2);
        AppMethodBeat.o(190109);
      }
      
      public void onDownloadProtocolUpdate(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(190117);
        paramITPPlayListener.onDownloadProtocolUpdate(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(190117);
      }
      
      public void onDownloadStatusUpdate(int paramAnonymousInt)
      {
        AppMethodBeat.i(190116);
        paramITPPlayListener.onDownloadStatusUpdate(paramAnonymousInt);
        AppMethodBeat.o(190116);
      }
      
      public int onPlayCallback(int paramAnonymousInt, List paramAnonymousList)
      {
        AppMethodBeat.i(190112);
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
          AppMethodBeat.o(190112);
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
        AppMethodBeat.o(190112);
        return paramAnonymousInt;
      }
      
      public int onReadData(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3)
      {
        AppMethodBeat.i(190124);
        int i = paramITPPlayListener.onReadData(paramAnonymousLong1, paramAnonymousString, paramAnonymousLong2, paramAnonymousLong3);
        AppMethodBeat.o(190124);
        return i;
      }
      
      public int onStartReadData(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3)
      {
        AppMethodBeat.i(190123);
        int i = paramITPPlayListener.onStartReadData(paramAnonymousLong1, paramAnonymousString, paramAnonymousLong2, paramAnonymousLong3);
        AppMethodBeat.o(190123);
        return i;
      }
      
      public int onStopReadData(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(190125);
        int i = paramITPPlayListener.onStopReadData(paramAnonymousLong, paramAnonymousString);
        AppMethodBeat.o(190125);
        return i;
      }
    };
    try
    {
      int i = this.downloadProxyAidl.startPlay(paramString, paramTPDownloadParam, paramITPPlayListener);
      AppMethodBeat.o(190154);
      return i;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "startPlay failed, error:" + paramString.toString());
      AppMethodBeat.o(190154);
    }
    return -1;
  }
  
  public int startPreload(String paramString, TPDownloadParam paramTPDownloadParam, final ITPPreLoadListener paramITPPreLoadListener)
  {
    AppMethodBeat.i(190163);
    paramTPDownloadParam = new TPDownloadParamAidl(paramTPDownloadParam.getUrlList(), paramTPDownloadParam.getDlType(), paramTPDownloadParam.getExtInfoMap());
    paramITPPreLoadListener = new ITPPreLoadListenerAidl.Stub()
    {
      public void onPrepareDownloadProgressUpdate(int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(190151);
        paramITPPreLoadListener.onPrepareDownloadProgressUpdate(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousLong1, paramAnonymousLong2);
        AppMethodBeat.o(190151);
      }
      
      public void onPrepareError()
      {
        AppMethodBeat.i(190150);
        paramITPPreLoadListener.onPrepareError();
        AppMethodBeat.o(190150);
      }
      
      public void onPrepareOK()
      {
        AppMethodBeat.i(190149);
        paramITPPreLoadListener.onPrepareOK();
        AppMethodBeat.o(190149);
      }
    };
    try
    {
      int i = this.downloadProxyAidl.startPreload(paramString, paramTPDownloadParam, paramITPPreLoadListener);
      AppMethodBeat.o(190163);
      return i;
    }
    catch (Throwable paramString)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "startPreload failed, error:" + paramString.toString());
      AppMethodBeat.o(190163);
    }
    return -1;
  }
  
  public void startTask(int paramInt) {}
  
  public void stopOfflineDownload(int paramInt) {}
  
  public void stopPlay(int paramInt)
  {
    AppMethodBeat.i(190160);
    try
    {
      this.downloadProxyAidl.stopPlay(paramInt);
      AppMethodBeat.o(190160);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "stopPlay failed, error:" + localThrowable.toString());
      AppMethodBeat.o(190160);
    }
  }
  
  public void stopPreload(int paramInt)
  {
    AppMethodBeat.i(190164);
    try
    {
      this.downloadProxyAidl.stopPreload(paramInt);
      AppMethodBeat.o(190164);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPDownloadProxyClient", 0, "tpdlnative", "stopPreload failed, error:" + localThrowable.toString());
      AppMethodBeat.o(190164);
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