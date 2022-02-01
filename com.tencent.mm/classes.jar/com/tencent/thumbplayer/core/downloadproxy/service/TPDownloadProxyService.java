package com.tencent.thumbplayer.core.downloadproxy.service;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl.Stub;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadParamAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl.Stub;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDLProxyInitParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyHelper;
import com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TPDownloadProxyService
  extends Service
{
  private static final String FILE_NAME = "TPDownloadProxyService";
  private TPDownloadProxyFactoryAidl.Stub downloadProxyFactory = null;
  private int pid = -1;
  
  private boolean isExistMainProcess()
  {
    AppMethodBeat.i(210106);
    try
    {
      Iterator localIterator = ((ActivityManager)getSystemService("activity")).getRunningAppProcesses().iterator();
      while (localIterator.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        String str = localRunningAppProcessInfo.processName;
        if ((!TextUtils.isEmpty(str)) && (str.equals(getPackageName())))
        {
          if ((this.pid != -1) && (this.pid != localRunningAppProcessInfo.pid))
          {
            this.pid = localRunningAppProcessInfo.pid;
            AppMethodBeat.o(210106);
            return false;
          }
          this.pid = localRunningAppProcessInfo.pid;
          TPDLProxyLog.i("TPDownloadProxyService", 0, "tpdlnative", "app main exist!");
          AppMethodBeat.o(210106);
          return true;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.i("TPDownloadProxyService", 0, "tpdlnative", "isExistMainProcess failed, error:" + localThrowable.toString());
      AppMethodBeat.o(210106);
    }
    return false;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(210102);
    if (this.downloadProxyFactory == null) {
      this.downloadProxyFactory = new DownloadProxyFactory(null);
    }
    isExistMainProcess();
    paramIntent = this.downloadProxyFactory;
    AppMethodBeat.o(210102);
    return paramIntent;
  }
  
  public void onRebind(Intent paramIntent)
  {
    AppMethodBeat.i(210104);
    TPDLProxyLog.i("TPDownloadProxyService", 0, "tpdlnative", "on rebind!");
    isExistMainProcess();
    super.onRebind(paramIntent);
    AppMethodBeat.o(210104);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210105);
    super.onStartCommand(paramIntent, paramInt1, paramInt2);
    AppMethodBeat.o(210105);
    return 2;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(210103);
    TPDLProxyLog.i("TPDownloadProxyService", 0, "tpdlnative", "on unbind!");
    super.onUnbind(paramIntent);
    if (!isExistMainProcess()) {}
    try
    {
      TPDownloadProxyNative.getInstance().stopAllDownload(3);
      TPListenerManager.getInstance().removeAllPlayListener();
      TPListenerManager.getInstance().removeAllPreLoadListener();
      AppMethodBeat.o(210103);
      return true;
    }
    catch (Throwable paramIntent)
    {
      for (;;)
      {
        TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", paramIntent.toString());
      }
    }
  }
  
  class DownloadProxy
    extends ITPDownloadProxyAidl.Stub
  {
    private ITPDownloadProxy downloadProxy;
    
    public DownloadProxy(int paramInt)
    {
      AppMethodBeat.i(210080);
      this.downloadProxy = null;
      this.downloadProxy = TPDownloadProxyFactory.getTPDownloadProxy(paramInt);
      AppMethodBeat.o(210080);
    }
    
    public String getClipPlayUrl(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(210086);
      String str = this.downloadProxy.getClipPlayUrl(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(210086);
      return str;
    }
    
    public String getPlayErrorCodeStr(int paramInt)
    {
      AppMethodBeat.i(210087);
      String str = this.downloadProxy.getPlayErrorCodeStr(paramInt);
      AppMethodBeat.o(210087);
      return str;
    }
    
    public String getPlayUrl(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(210085);
      String str = this.downloadProxy.getPlayUrl(paramInt1, paramInt2);
      AppMethodBeat.o(210085);
      return str;
    }
    
    public int init(String paramString)
    {
      AppMethodBeat.i(210081);
      try
      {
        paramString = (TPDLProxyInitParam)TPDLProxyUtils.serializeToObject(paramString);
        if (paramString == null)
        {
          TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "param is null");
          AppMethodBeat.o(210081);
          return -1;
        }
        int i = this.downloadProxy.init(TPDownloadProxyHelper.getContext(), paramString);
        AppMethodBeat.o(210081);
        return i;
      }
      catch (Throwable paramString)
      {
        TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "init failed, error:" + paramString.toString());
        AppMethodBeat.o(210081);
      }
      return -2;
    }
    
    public int pauseDownload(int paramInt)
    {
      AppMethodBeat.i(210089);
      paramInt = this.downloadProxy.pauseDownload(paramInt);
      AppMethodBeat.o(210089);
      return paramInt;
    }
    
    public void pushEvent(int paramInt)
    {
      AppMethodBeat.i(210094);
      this.downloadProxy.pushEvent(paramInt);
      AppMethodBeat.o(210094);
    }
    
    public int resumeDownload(int paramInt)
    {
      AppMethodBeat.i(210090);
      paramInt = this.downloadProxy.resumeDownload(paramInt);
      AppMethodBeat.o(210090);
      return paramInt;
    }
    
    public boolean setClipInfo(int paramInt1, int paramInt2, String paramString, TPDownloadParamAidl paramTPDownloadParamAidl)
    {
      AppMethodBeat.i(210084);
      paramTPDownloadParamAidl = new TPDownloadParam(paramTPDownloadParamAidl.getUrlList(), paramTPDownloadParamAidl.getDlType(), paramTPDownloadParamAidl.getExtInfoMap());
      boolean bool = this.downloadProxy.setClipInfo(paramInt1, paramInt2, paramString, paramTPDownloadParamAidl);
      AppMethodBeat.o(210084);
      return bool;
    }
    
    public void setMaxStorageSizeMB(long paramLong)
    {
      AppMethodBeat.i(210096);
      this.downloadProxy.setMaxStorageSizeMB(paramLong);
      AppMethodBeat.o(210096);
    }
    
    public void setPlayState(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(210095);
      this.downloadProxy.setPlayState(paramInt1, paramInt2);
      AppMethodBeat.o(210095);
    }
    
    public void setUserData(Map paramMap)
    {
      AppMethodBeat.i(210093);
      if (paramMap != null)
      {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          if (localEntry != null) {
            try
            {
              if (localEntry.getValue() != null) {
                this.downloadProxy.setUserData((String)localEntry.getKey(), localEntry.getValue());
              }
            }
            catch (Throwable localThrowable)
            {
              TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "setUserData failed, error:" + localThrowable.toString());
            }
          }
        }
      }
      AppMethodBeat.o(210093);
    }
    
    public int startClipPlay(String paramString, int paramInt, ITPPlayListenerAidl paramITPPlayListenerAidl)
    {
      AppMethodBeat.i(210083);
      paramITPPlayListenerAidl = new TPDownloadProxyService.DownloadProxy.2(this, paramITPPlayListenerAidl);
      paramInt = this.downloadProxy.startClipPlay(paramString, paramInt, paramITPPlayListenerAidl);
      AppMethodBeat.o(210083);
      return paramInt;
    }
    
    public int startPlay(String paramString, TPDownloadParamAidl paramTPDownloadParamAidl, ITPPlayListenerAidl paramITPPlayListenerAidl)
    {
      AppMethodBeat.i(210082);
      try
      {
        paramTPDownloadParamAidl = new TPDownloadParam(paramTPDownloadParamAidl.getUrlList(), paramTPDownloadParamAidl.getDlType(), paramTPDownloadParamAidl.getExtInfoMap());
        paramITPPlayListenerAidl = new TPDownloadProxyService.DownloadProxy.1(this, paramITPPlayListenerAidl);
        int i = this.downloadProxy.startPlay(paramString, paramTPDownloadParamAidl, paramITPPlayListenerAidl);
        AppMethodBeat.o(210082);
        return i;
      }
      catch (Throwable paramString)
      {
        TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "startPlay failed, error:" + paramString.toString());
        AppMethodBeat.o(210082);
      }
      return -1;
    }
    
    public int startPreload(String paramString, TPDownloadParamAidl paramTPDownloadParamAidl, final ITPPreLoadListenerAidl paramITPPreLoadListenerAidl)
    {
      AppMethodBeat.i(210091);
      paramTPDownloadParamAidl = new TPDownloadParam(paramTPDownloadParamAidl.getUrlList(), paramTPDownloadParamAidl.getDlType(), paramTPDownloadParamAidl.getExtInfoMap());
      paramITPPreLoadListenerAidl = new ITPPreLoadListener()
      {
        public void onPrepareDownloadProgressUpdate(int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString)
        {
          AppMethodBeat.i(210079);
          try
          {
            if (paramITPPreLoadListenerAidl != null) {
              paramITPPreLoadListenerAidl.onPrepareDownloadProgressUpdate(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousString);
            }
            AppMethodBeat.o(210079);
            return;
          }
          catch (Throwable paramAnonymousString)
          {
            TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onPrepareDownloadProgressUpdate failed, error:" + paramAnonymousString.toString());
            AppMethodBeat.o(210079);
          }
        }
        
        public void onPrepareError(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
        {
          AppMethodBeat.i(210078);
          try
          {
            if (paramITPPreLoadListenerAidl != null) {
              paramITPPreLoadListenerAidl.onPrepareError(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString);
            }
            AppMethodBeat.o(210078);
            return;
          }
          catch (Throwable paramAnonymousString)
          {
            TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onPrepareError failed, error:" + paramAnonymousString.toString());
            AppMethodBeat.o(210078);
          }
        }
        
        public void onPrepareOK()
        {
          AppMethodBeat.i(210077);
          try
          {
            if (paramITPPreLoadListenerAidl != null) {
              paramITPPreLoadListenerAidl.onPrepareOK();
            }
            AppMethodBeat.o(210077);
            return;
          }
          catch (Throwable localThrowable)
          {
            TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onPrepareOK failed, error:" + localThrowable.toString());
            AppMethodBeat.o(210077);
          }
        }
      };
      int i = this.downloadProxy.startPreload(paramString, paramTPDownloadParamAidl, paramITPPreLoadListenerAidl);
      AppMethodBeat.o(210091);
      return i;
    }
    
    public void stopPlay(int paramInt)
    {
      AppMethodBeat.i(210088);
      this.downloadProxy.stopPlay(paramInt);
      AppMethodBeat.o(210088);
    }
    
    public void stopPreload(int paramInt)
    {
      AppMethodBeat.i(210092);
      this.downloadProxy.stopPreload(paramInt);
      AppMethodBeat.o(210092);
    }
  }
  
  class DownloadProxyFactory
    extends TPDownloadProxyFactoryAidl.Stub
  {
    private HashMap<Integer, ITPDownloadProxyAidl> mvTPDownloadProxyMap;
    
    private DownloadProxyFactory()
    {
      AppMethodBeat.i(210097);
      this.mvTPDownloadProxyMap = new HashMap();
      AppMethodBeat.o(210097);
    }
    
    public String getNativeVersion()
    {
      AppMethodBeat.i(210101);
      String str = TPDownloadProxyFactory.getNativeVersion();
      AppMethodBeat.o(210101);
      return str;
    }
    
    public ITPDownloadProxyAidl getTPDownloadProxy(int paramInt)
    {
      try
      {
        AppMethodBeat.i(210098);
        ITPDownloadProxyAidl localITPDownloadProxyAidl = (ITPDownloadProxyAidl)this.mvTPDownloadProxyMap.get(Integer.valueOf(paramInt));
        Object localObject1 = localITPDownloadProxyAidl;
        if (localITPDownloadProxyAidl == null)
        {
          localObject1 = new TPDownloadProxyService.DownloadProxy(TPDownloadProxyService.this, paramInt);
          this.mvTPDownloadProxyMap.put(Integer.valueOf(paramInt), localObject1);
        }
        AppMethodBeat.o(210098);
        return localObject1;
      }
      finally {}
    }
    
    public boolean isReadyForDownload()
    {
      AppMethodBeat.i(210100);
      boolean bool = TPDownloadProxyFactory.isReadyForDownload();
      AppMethodBeat.o(210100);
      return bool;
    }
    
    public boolean isReadyForPlay()
    {
      AppMethodBeat.i(210099);
      boolean bool = TPDownloadProxyFactory.isReadyForPlay();
      AppMethodBeat.o(210099);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.service.TPDownloadProxyService
 * JD-Core Version:    0.7.0.1
 */