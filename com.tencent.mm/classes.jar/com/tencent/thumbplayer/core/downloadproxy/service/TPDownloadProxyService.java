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

public class TPDownloadProxyService
  extends Service
{
  private static final String FILE_NAME = "TPDownloadProxyService";
  private TPDownloadProxyFactoryAidl.Stub downloadProxyFactory = null;
  private int pid = -1;
  
  private boolean isExistMainProcess()
  {
    AppMethodBeat.i(227851);
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
            AppMethodBeat.o(227851);
            return false;
          }
          this.pid = localRunningAppProcessInfo.pid;
          TPDLProxyLog.i("TPDownloadProxyService", 0, "tpdlnative", "app main exist!");
          AppMethodBeat.o(227851);
          return true;
        }
      }
    }
    finally
    {
      TPDLProxyLog.i("TPDownloadProxyService", 0, "tpdlnative", "isExistMainProcess failed, error:" + localObject.toString());
      AppMethodBeat.o(227851);
    }
    return false;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(227864);
    if (this.downloadProxyFactory == null) {
      this.downloadProxyFactory = new DownloadProxyFactory(null);
    }
    isExistMainProcess();
    paramIntent = this.downloadProxyFactory;
    AppMethodBeat.o(227864);
    return paramIntent;
  }
  
  public void onRebind(Intent paramIntent)
  {
    AppMethodBeat.i(227882);
    TPDLProxyLog.i("TPDownloadProxyService", 0, "tpdlnative", "on rebind!");
    isExistMainProcess();
    super.onRebind(paramIntent);
    AppMethodBeat.o(227882);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(227890);
    super.onStartCommand(paramIntent, paramInt1, paramInt2);
    AppMethodBeat.o(227890);
    return 2;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(227872);
    TPDLProxyLog.i("TPDownloadProxyService", 0, "tpdlnative", "on unbind!");
    super.onUnbind(paramIntent);
    if (!isExistMainProcess()) {}
    try
    {
      TPDownloadProxyNative.getInstance().stopAllDownload(3);
      TPListenerManager.getInstance().removeAllPlayListener();
      TPListenerManager.getInstance().removeAllPreLoadListener();
      AppMethodBeat.o(227872);
      return true;
    }
    finally
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
      AppMethodBeat.i(227834);
      this.downloadProxy = null;
      this.downloadProxy = TPDownloadProxyFactory.getTPDownloadProxy(paramInt);
      AppMethodBeat.o(227834);
    }
    
    public String getClipPlayUrl(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(227888);
      String str = this.downloadProxy.getClipPlayUrl(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(227888);
      return str;
    }
    
    public String getNativeInfo(int paramInt)
    {
      AppMethodBeat.i(227969);
      Object localObject = null;
      try
      {
        String str = this.downloadProxy.getNativeInfo(paramInt);
        localObject = str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "getNativeInfo failed, error:" + localException.toString());
        }
      }
      AppMethodBeat.o(227969);
      return localObject;
    }
    
    public String getPlayErrorCodeStr(int paramInt)
    {
      AppMethodBeat.i(227899);
      String str = this.downloadProxy.getPlayErrorCodeStr(paramInt);
      AppMethodBeat.o(227899);
      return str;
    }
    
    public String getPlayUrl(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(227880);
      String str = this.downloadProxy.getPlayUrl(paramInt1, paramInt2);
      AppMethodBeat.o(227880);
      return str;
    }
    
    public int init(String paramString)
    {
      AppMethodBeat.i(227842);
      try
      {
        paramString = (TPDLProxyInitParam)TPDLProxyUtils.serializeToObject(paramString);
        if (paramString == null)
        {
          TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "param is null");
          AppMethodBeat.o(227842);
          return -1;
        }
        int i = this.downloadProxy.init(TPDownloadProxyHelper.getContext(), paramString);
        AppMethodBeat.o(227842);
        return i;
      }
      finally
      {
        TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "init failed, error:" + paramString.toString());
        AppMethodBeat.o(227842);
      }
      return -2;
    }
    
    public int pauseDownload(int paramInt)
    {
      AppMethodBeat.i(227916);
      paramInt = this.downloadProxy.pauseDownload(paramInt);
      AppMethodBeat.o(227916);
      return paramInt;
    }
    
    public void pushEvent(int paramInt)
    {
      AppMethodBeat.i(227978);
      this.downloadProxy.pushEvent(paramInt);
      AppMethodBeat.o(227978);
    }
    
    public int resumeDownload(int paramInt)
    {
      AppMethodBeat.i(227925);
      paramInt = this.downloadProxy.resumeDownload(paramInt);
      AppMethodBeat.o(227925);
      return paramInt;
    }
    
    public boolean setClipInfo(int paramInt1, int paramInt2, String paramString, TPDownloadParamAidl paramTPDownloadParamAidl)
    {
      AppMethodBeat.i(227870);
      paramTPDownloadParamAidl = new TPDownloadParam(paramTPDownloadParamAidl.getUrlList(), paramTPDownloadParamAidl.getDlType(), paramTPDownloadParamAidl.getExtInfoMap());
      boolean bool = this.downloadProxy.setClipInfo(paramInt1, paramInt2, paramString, paramTPDownloadParamAidl);
      AppMethodBeat.o(227870);
      return bool;
    }
    
    public void setMaxStorageSizeMB(long paramLong)
    {
      AppMethodBeat.i(227999);
      this.downloadProxy.setMaxStorageSizeMB(paramLong);
      AppMethodBeat.o(227999);
    }
    
    public void setPlayState(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(227987);
      this.downloadProxy.setPlayState(paramInt1, paramInt2);
      AppMethodBeat.o(227987);
    }
    
    /* Error */
    public void setUserData(java.util.Map paramMap)
    {
      // Byte code:
      //   0: ldc 166
      //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_1
      //   6: ifnull +105 -> 111
      //   9: aload_1
      //   10: invokeinterface 172 1 0
      //   15: invokeinterface 178 1 0
      //   20: astore_1
      //   21: aload_1
      //   22: invokeinterface 184 1 0
      //   27: ifeq +84 -> 111
      //   30: aload_1
      //   31: invokeinterface 188 1 0
      //   36: checkcast 190	java/util/Map$Entry
      //   39: astore_2
      //   40: aload_2
      //   41: ifnull -20 -> 21
      //   44: aload_2
      //   45: invokeinterface 193 1 0
      //   50: ifnull -29 -> 21
      //   53: aload_0
      //   54: getfield 29	com/tencent/thumbplayer/core/downloadproxy/service/TPDownloadProxyService$DownloadProxy:downloadProxy	Lcom/tencent/thumbplayer/core/downloadproxy/api/ITPDownloadProxy;
      //   57: aload_2
      //   58: invokeinterface 196 1 0
      //   63: checkcast 198	java/lang/String
      //   66: aload_2
      //   67: invokeinterface 193 1 0
      //   72: invokeinterface 201 3 0
      //   77: goto -56 -> 21
      //   80: astore_2
      //   81: ldc 55
      //   83: iconst_0
      //   84: ldc 57
      //   86: new 59	java/lang/StringBuilder
      //   89: dup
      //   90: ldc 203
      //   92: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   95: aload_2
      //   96: invokevirtual 115	java/lang/Throwable:toString	()Ljava/lang/String;
      //   99: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   102: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   105: invokestatic 79	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
      //   108: goto -87 -> 21
      //   111: ldc 166
      //   113: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   116: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	117	0	this	DownloadProxy
      //   0	117	1	paramMap	java.util.Map
      //   39	28	2	localEntry	java.util.Map.Entry
      //   80	16	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   44	77	80	finally
    }
    
    public int startClipPlay(String paramString, int paramInt, ITPPlayListenerAidl paramITPPlayListenerAidl)
    {
      AppMethodBeat.i(227863);
      paramITPPlayListenerAidl = new TPDownloadProxyService.DownloadProxy.2(this, paramITPPlayListenerAidl);
      paramInt = this.downloadProxy.startClipPlay(paramString, paramInt, paramITPPlayListenerAidl);
      AppMethodBeat.o(227863);
      return paramInt;
    }
    
    public int startPlay(String paramString, TPDownloadParamAidl paramTPDownloadParamAidl, ITPPlayListenerAidl paramITPPlayListenerAidl)
    {
      AppMethodBeat.i(227854);
      try
      {
        paramTPDownloadParamAidl = new TPDownloadParam(paramTPDownloadParamAidl.getUrlList(), paramTPDownloadParamAidl.getDlType(), paramTPDownloadParamAidl.getExtInfoMap());
        paramITPPlayListenerAidl = new TPDownloadProxyService.DownloadProxy.1(this, paramITPPlayListenerAidl);
        int i = this.downloadProxy.startPlay(paramString, paramTPDownloadParamAidl, paramITPPlayListenerAidl);
        AppMethodBeat.o(227854);
        return i;
      }
      finally
      {
        TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "startPlay failed, error:" + paramString.toString());
        AppMethodBeat.o(227854);
      }
      return -1;
    }
    
    public int startPreload(String paramString, TPDownloadParamAidl paramTPDownloadParamAidl, final ITPPreLoadListenerAidl paramITPPreLoadListenerAidl)
    {
      AppMethodBeat.i(227936);
      paramTPDownloadParamAidl = new TPDownloadParam(paramTPDownloadParamAidl.getUrlList(), paramTPDownloadParamAidl.getDlType(), paramTPDownloadParamAidl.getExtInfoMap());
      paramITPPreLoadListenerAidl = new ITPPreLoadListener()
      {
        public void onPrepareDownloadProgressUpdate(int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString)
        {
          AppMethodBeat.i(227906);
          try
          {
            if (paramITPPreLoadListenerAidl != null) {
              paramITPPreLoadListenerAidl.onPrepareDownloadProgressUpdate(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousString);
            }
            AppMethodBeat.o(227906);
            return;
          }
          finally
          {
            TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onPrepareDownloadProgressUpdate failed, error:" + paramAnonymousString.toString());
            AppMethodBeat.o(227906);
          }
        }
        
        public void onPrepareError(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
        {
          AppMethodBeat.i(227891);
          try
          {
            if (paramITPPreLoadListenerAidl != null) {
              paramITPPreLoadListenerAidl.onPrepareError(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString);
            }
            AppMethodBeat.o(227891);
            return;
          }
          finally
          {
            TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onPrepareError failed, error:" + paramAnonymousString.toString());
            AppMethodBeat.o(227891);
          }
        }
        
        public void onPrepareOK()
        {
          AppMethodBeat.i(227873);
          try
          {
            if (paramITPPreLoadListenerAidl != null) {
              paramITPPreLoadListenerAidl.onPrepareOK();
            }
            AppMethodBeat.o(227873);
            return;
          }
          finally
          {
            TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", "onPrepareOK failed, error:" + localObject.toString());
            AppMethodBeat.o(227873);
          }
        }
      };
      int i = this.downloadProxy.startPreload(paramString, paramTPDownloadParamAidl, paramITPPreLoadListenerAidl);
      AppMethodBeat.o(227936);
      return i;
    }
    
    public void stopPlay(int paramInt)
    {
      AppMethodBeat.i(227907);
      this.downloadProxy.stopPlay(paramInt);
      AppMethodBeat.o(227907);
    }
    
    public void stopPreload(int paramInt)
    {
      AppMethodBeat.i(227945);
      this.downloadProxy.stopPreload(paramInt);
      AppMethodBeat.o(227945);
    }
  }
  
  class DownloadProxyFactory
    extends TPDownloadProxyFactoryAidl.Stub
  {
    private HashMap<Integer, ITPDownloadProxyAidl> mvTPDownloadProxyMap;
    
    private DownloadProxyFactory()
    {
      AppMethodBeat.i(227855);
      this.mvTPDownloadProxyMap = new HashMap();
      AppMethodBeat.o(227855);
    }
    
    public String getNativeVersion()
    {
      AppMethodBeat.i(227929);
      String str = TPDownloadProxyFactory.getNativeVersion();
      AppMethodBeat.o(227929);
      return str;
    }
    
    public ITPDownloadProxyAidl getTPDownloadProxy(int paramInt)
    {
      try
      {
        AppMethodBeat.i(227884);
        ITPDownloadProxyAidl localITPDownloadProxyAidl = (ITPDownloadProxyAidl)this.mvTPDownloadProxyMap.get(Integer.valueOf(paramInt));
        Object localObject1 = localITPDownloadProxyAidl;
        if (localITPDownloadProxyAidl == null)
        {
          localObject1 = new TPDownloadProxyService.DownloadProxy(TPDownloadProxyService.this, paramInt);
          this.mvTPDownloadProxyMap.put(Integer.valueOf(paramInt), localObject1);
        }
        AppMethodBeat.o(227884);
        return localObject1;
      }
      finally {}
    }
    
    public boolean isReadyForDownload()
    {
      AppMethodBeat.i(227915);
      boolean bool = TPDownloadProxyFactory.isReadyForDownload();
      AppMethodBeat.o(227915);
      return bool;
    }
    
    public boolean isReadyForPlay()
    {
      AppMethodBeat.i(227902);
      boolean bool = TPDownloadProxyFactory.isReadyForPlay();
      AppMethodBeat.o(227902);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.service.TPDownloadProxyService
 * JD-Core Version:    0.7.0.1
 */