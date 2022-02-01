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
    AppMethodBeat.i(191610);
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
            AppMethodBeat.o(191610);
            return false;
          }
          this.pid = localRunningAppProcessInfo.pid;
          TPDLProxyLog.i("TPDownloadProxyService", 0, "tpdlnative", "app main exist!");
          AppMethodBeat.o(191610);
          return true;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.i("TPDownloadProxyService", 0, "tpdlnative", "isExistMainProcess failed, error:" + localThrowable.toString());
      AppMethodBeat.o(191610);
    }
    return false;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(191606);
    if (this.downloadProxyFactory == null) {
      this.downloadProxyFactory = new DownloadProxyFactory(null);
    }
    isExistMainProcess();
    paramIntent = this.downloadProxyFactory;
    AppMethodBeat.o(191606);
    return paramIntent;
  }
  
  public void onRebind(Intent paramIntent)
  {
    AppMethodBeat.i(191608);
    TPDLProxyLog.i("TPDownloadProxyService", 0, "tpdlnative", "on rebind!");
    isExistMainProcess();
    super.onRebind(paramIntent);
    AppMethodBeat.o(191608);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191609);
    super.onStartCommand(paramIntent, paramInt1, paramInt2);
    AppMethodBeat.o(191609);
    return 2;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(191607);
    TPDLProxyLog.i("TPDownloadProxyService", 0, "tpdlnative", "on unbind!");
    super.onUnbind(paramIntent);
    AppMethodBeat.o(191607);
    return true;
  }
  
  class DownloadProxy
    extends ITPDownloadProxyAidl.Stub
  {
    private ITPDownloadProxy downloadProxy;
    
    public DownloadProxy(int paramInt)
    {
      AppMethodBeat.i(191584);
      this.downloadProxy = null;
      this.downloadProxy = TPDownloadProxyFactory.getTPDownloadProxy(paramInt);
      AppMethodBeat.o(191584);
    }
    
    public String getClipPlayUrl(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(191590);
      String str = this.downloadProxy.getClipPlayUrl(paramInt1, paramInt2);
      AppMethodBeat.o(191590);
      return str;
    }
    
    public String getPlayErrorCodeStr(int paramInt)
    {
      AppMethodBeat.i(191591);
      String str = this.downloadProxy.getPlayErrorCodeStr(paramInt);
      AppMethodBeat.o(191591);
      return str;
    }
    
    public String getPlayUrl(int paramInt)
    {
      AppMethodBeat.i(191589);
      String str = this.downloadProxy.getPlayUrl(paramInt);
      AppMethodBeat.o(191589);
      return str;
    }
    
    public int init(String paramString)
    {
      AppMethodBeat.i(191585);
      try
      {
        paramString = (TPDLProxyInitParam)TPDLProxyUtils.serializeToObject(paramString);
        if (paramString == null)
        {
          TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "param is null");
          AppMethodBeat.o(191585);
          return -1;
        }
        int i = this.downloadProxy.init(TPDownloadProxyHelper.getContext(), paramString);
        AppMethodBeat.o(191585);
        return i;
      }
      catch (Throwable paramString)
      {
        TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "init failed, error:" + paramString.toString());
        AppMethodBeat.o(191585);
      }
      return -2;
    }
    
    public int pauseDownload(int paramInt)
    {
      AppMethodBeat.i(191593);
      paramInt = this.downloadProxy.pauseDownload(paramInt);
      AppMethodBeat.o(191593);
      return paramInt;
    }
    
    public void pushEvent(int paramInt)
    {
      AppMethodBeat.i(191598);
      this.downloadProxy.pushEvent(paramInt);
      AppMethodBeat.o(191598);
    }
    
    public int resumeDownload(int paramInt)
    {
      AppMethodBeat.i(191594);
      paramInt = this.downloadProxy.resumeDownload(paramInt);
      AppMethodBeat.o(191594);
      return paramInt;
    }
    
    public boolean setClipInfo(int paramInt1, int paramInt2, String paramString, TPDownloadParamAidl paramTPDownloadParamAidl)
    {
      AppMethodBeat.i(191588);
      paramTPDownloadParamAidl = new TPDownloadParam(paramTPDownloadParamAidl.getUrlList(), paramTPDownloadParamAidl.getDlType(), paramTPDownloadParamAidl.getExtInfoMap());
      boolean bool = this.downloadProxy.setClipInfo(paramInt1, paramInt2, paramString, paramTPDownloadParamAidl);
      AppMethodBeat.o(191588);
      return bool;
    }
    
    public void setMaxStorageSizeMB(long paramLong)
    {
      AppMethodBeat.i(191600);
      this.downloadProxy.setMaxStorageSizeMB(paramLong);
      AppMethodBeat.o(191600);
    }
    
    public void setPlayState(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(191599);
      this.downloadProxy.setPlayState(paramInt1, paramInt2);
      AppMethodBeat.o(191599);
    }
    
    public void setUserData(Map paramMap)
    {
      AppMethodBeat.i(191597);
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
      AppMethodBeat.o(191597);
    }
    
    public int startClipPlay(String paramString, int paramInt, ITPPlayListenerAidl paramITPPlayListenerAidl)
    {
      AppMethodBeat.i(191587);
      paramITPPlayListenerAidl = new TPDownloadProxyService.DownloadProxy.2(this, paramITPPlayListenerAidl);
      paramInt = this.downloadProxy.startClipPlay(paramString, paramInt, paramITPPlayListenerAidl);
      AppMethodBeat.o(191587);
      return paramInt;
    }
    
    public int startPlay(String paramString, TPDownloadParamAidl paramTPDownloadParamAidl, ITPPlayListenerAidl paramITPPlayListenerAidl)
    {
      AppMethodBeat.i(191586);
      try
      {
        paramTPDownloadParamAidl = new TPDownloadParam(paramTPDownloadParamAidl.getUrlList(), paramTPDownloadParamAidl.getDlType(), paramTPDownloadParamAidl.getExtInfoMap());
        paramITPPlayListenerAidl = new TPDownloadProxyService.DownloadProxy.1(this, paramITPPlayListenerAidl);
        int i = this.downloadProxy.startPlay(paramString, paramTPDownloadParamAidl, paramITPPlayListenerAidl);
        AppMethodBeat.o(191586);
        return i;
      }
      catch (Throwable paramString)
      {
        TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "startPlay failed, error:" + paramString.toString());
        AppMethodBeat.o(191586);
      }
      return -1;
    }
    
    public int startPreload(String paramString, TPDownloadParamAidl paramTPDownloadParamAidl, final ITPPreLoadListenerAidl paramITPPreLoadListenerAidl)
    {
      AppMethodBeat.i(191595);
      paramTPDownloadParamAidl = new TPDownloadParam(paramTPDownloadParamAidl.getUrlList(), paramTPDownloadParamAidl.getDlType(), paramTPDownloadParamAidl.getExtInfoMap());
      paramITPPreLoadListenerAidl = new ITPPreLoadListener()
      {
        public void onPrepareDownloadProgressUpdate(int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2)
        {
          AppMethodBeat.i(191583);
          try
          {
            if (paramITPPreLoadListenerAidl != null) {
              paramITPPreLoadListenerAidl.onPrepareDownloadProgressUpdate(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousLong1, paramAnonymousLong2);
            }
            AppMethodBeat.o(191583);
            return;
          }
          catch (Throwable localThrowable)
          {
            TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onPrepareDownloadProgressUpdate failed, error:" + localThrowable.toString());
            AppMethodBeat.o(191583);
          }
        }
        
        public void onPrepareError()
        {
          AppMethodBeat.i(191582);
          try
          {
            if (paramITPPreLoadListenerAidl != null) {
              paramITPPreLoadListenerAidl.onPrepareError();
            }
            AppMethodBeat.o(191582);
            return;
          }
          catch (Throwable localThrowable)
          {
            TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onPrepareError failed, error:" + localThrowable.toString());
            AppMethodBeat.o(191582);
          }
        }
        
        public void onPrepareOK()
        {
          AppMethodBeat.i(191581);
          try
          {
            if (paramITPPreLoadListenerAidl != null) {
              paramITPPreLoadListenerAidl.onPrepareOK();
            }
            AppMethodBeat.o(191581);
            return;
          }
          catch (Throwable localThrowable)
          {
            TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onPrepareOK failed, error:" + localThrowable.toString());
            AppMethodBeat.o(191581);
          }
        }
      };
      int i = this.downloadProxy.startPreload(paramString, paramTPDownloadParamAidl, paramITPPreLoadListenerAidl);
      AppMethodBeat.o(191595);
      return i;
    }
    
    public void stopPlay(int paramInt)
    {
      AppMethodBeat.i(191592);
      this.downloadProxy.stopPlay(paramInt);
      AppMethodBeat.o(191592);
    }
    
    public void stopPreload(int paramInt)
    {
      AppMethodBeat.i(191596);
      this.downloadProxy.stopPreload(paramInt);
      AppMethodBeat.o(191596);
    }
  }
  
  class DownloadProxyFactory
    extends TPDownloadProxyFactoryAidl.Stub
  {
    private HashMap<Integer, ITPDownloadProxyAidl> mvTPDownloadProxyMap;
    
    private DownloadProxyFactory()
    {
      AppMethodBeat.i(191601);
      this.mvTPDownloadProxyMap = new HashMap();
      AppMethodBeat.o(191601);
    }
    
    public String getNativeVersion()
    {
      AppMethodBeat.i(191605);
      String str = TPDownloadProxyFactory.getNativeVersion();
      AppMethodBeat.o(191605);
      return str;
    }
    
    public ITPDownloadProxyAidl getTPDownloadProxy(int paramInt)
    {
      try
      {
        AppMethodBeat.i(191602);
        ITPDownloadProxyAidl localITPDownloadProxyAidl = (ITPDownloadProxyAidl)this.mvTPDownloadProxyMap.get(Integer.valueOf(paramInt));
        Object localObject1 = localITPDownloadProxyAidl;
        if (localITPDownloadProxyAidl == null)
        {
          localObject1 = new TPDownloadProxyService.DownloadProxy(TPDownloadProxyService.this, paramInt);
          this.mvTPDownloadProxyMap.put(Integer.valueOf(paramInt), localObject1);
        }
        AppMethodBeat.o(191602);
        return localObject1;
      }
      finally {}
    }
    
    public boolean isReadyForDownload()
    {
      AppMethodBeat.i(191604);
      boolean bool = TPDownloadProxyFactory.isReadyForDownload();
      AppMethodBeat.o(191604);
      return bool;
    }
    
    public boolean isReadyForPlay()
    {
      AppMethodBeat.i(191603);
      boolean bool = TPDownloadProxyFactory.isReadyForPlay();
      AppMethodBeat.o(191603);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.service.TPDownloadProxyService
 * JD-Core Version:    0.7.0.1
 */