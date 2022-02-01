package com.tencent.thumbplayer.core.downloadproxy.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl.Stub;
import com.tencent.thumbplayer.core.downloadproxy.client.TPDownloadProxyClient;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.service.TPDownloadProxyService;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class TPDownloadProxyFactory
{
  private static final String FILE_NAME = "TPDownloadProxyFactory";
  private static TPDownloadProxyFactoryAidl downloadProxyFactoryAidl;
  private static TPDLProxyBindServiceCallback mCallback;
  private static boolean mCanUseAIDL;
  private static ServiceConnection mConnection;
  private static boolean mIsReadyForDownload;
  private static Object mMapObject;
  private static boolean mUseService;
  private static HashMap<Integer, TPDownloadProxyClient> mvTPDownloadProxyClientMap;
  private static HashMap<Integer, ITPDownloadProxy> mvTPDownloadProxyMap;
  
  static
  {
    AppMethodBeat.i(207272);
    mMapObject = new Object();
    mvTPDownloadProxyMap = new HashMap();
    mvTPDownloadProxyClientMap = new HashMap();
    mUseService = false;
    mCanUseAIDL = false;
    mIsReadyForDownload = false;
    mCallback = null;
    mConnection = new ServiceConnection()
    {
      public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        AppMethodBeat.i(207262);
        TPDownloadProxyFactory.access$002(TPDownloadProxyFactoryAidl.Stub.asInterface(paramAnonymousIBinder));
        try
        {
          paramAnonymousComponentName = TPDownloadProxyFactory.mvTPDownloadProxyClientMap.entrySet().iterator();
          while (paramAnonymousComponentName.hasNext())
          {
            paramAnonymousIBinder = (Map.Entry)paramAnonymousComponentName.next();
            ((TPDownloadProxyClient)paramAnonymousIBinder.getValue()).updateAidl(TPDownloadProxyFactory.downloadProxyFactoryAidl.getTPDownloadProxy(((Integer)paramAnonymousIBinder.getKey()).intValue()));
          }
          return;
        }
        catch (Throwable paramAnonymousComponentName)
        {
          TPDLProxyLog.i("TPDownloadProxyFactory", 0, "tpdlnative", "onServiceConnected failed, error:" + paramAnonymousComponentName.toString());
          TPDLProxyLog.i("TPDownloadProxyFactory", 0, "tpdlnative", "on service connected!");
          if (TPDownloadProxyFactory.downloadProxyFactoryAidl == null)
          {
            TPDLProxyLog.i("TPDownloadProxyFactory", 0, "tpdlnative", "on service connected, aidl is null!");
            AppMethodBeat.o(207262);
            return;
          }
          TPDLProxyLog.i("TPDownloadProxyFactory", 0, "tpdlnative", "on service connected, aidl not null!");
          TPDownloadProxyFactory.access$200(true);
          if (TPDownloadProxyFactory.mCallback != null) {
            TPDownloadProxyFactory.mCallback.onBindSuccess();
          }
          AppMethodBeat.o(207262);
        }
      }
      
      public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        AppMethodBeat.i(207263);
        TPDLProxyLog.i("TPDownloadProxyFactory", 0, "tpdlnative", "on service disconnected");
        TPDownloadProxyFactory.access$002(null);
        TPDownloadProxyFactory.access$200(false);
        TPDownloadProxyFactory.ensurePlayManagerService(TPDownloadProxyFactory.mCallback);
        AppMethodBeat.o(207263);
      }
    };
    AppMethodBeat.o(207272);
  }
  
  public static boolean canUseService()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(207269);
        if (!mUseService)
        {
          AppMethodBeat.o(207269);
          return bool;
        }
        if (!mCanUseAIDL)
        {
          AppMethodBeat.o(207269);
          bool = false;
          continue;
        }
        TPDownloadProxyFactoryAidl localTPDownloadProxyFactoryAidl = downloadProxyFactoryAidl;
        if (localTPDownloadProxyFactoryAidl == null) {}
      }
      finally
      {
        try
        {
          downloadProxyFactoryAidl.isReadyForPlay();
          AppMethodBeat.o(207269);
        }
        catch (Throwable localThrowable)
        {
          TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", "canUseService failed, error:" + localThrowable.toString());
        }
        localObject = finally;
      }
      AppMethodBeat.o(207269);
      bool = false;
    }
  }
  
  public static boolean ensurePlayManagerService(TPDLProxyBindServiceCallback paramTPDLProxyBindServiceCallback)
  {
    AppMethodBeat.i(207266);
    Context localContext = TPDownloadProxyHelper.getContext();
    if (localContext == null)
    {
      TPDLProxyLog.i("TPDownloadProxyFactory", 0, "tpdlnative", "ensurePlayManagerService get context null!");
      AppMethodBeat.o(207266);
      return false;
    }
    mCallback = paramTPDLProxyBindServiceCallback;
    StringBuilder localStringBuilder = new StringBuilder("ensurePlayManagerService ");
    if (localContext == null) {}
    for (paramTPDLProxyBindServiceCallback = "context is null";; paramTPDLProxyBindServiceCallback = "ok")
    {
      TPDLProxyLog.i("TPDownloadProxyFactory", 0, "tpdlnative", paramTPDLProxyBindServiceCallback);
      try
      {
        paramTPDLProxyBindServiceCallback = new Intent(localContext, TPDownloadProxyService.class);
        localContext.startService(paramTPDLProxyBindServiceCallback);
        if (!localContext.bindService(paramTPDLProxyBindServiceCallback, mConnection, 1)) {
          TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", "ensurePlayManagerService bind service failed!");
        }
        AppMethodBeat.o(207266);
        return true;
      }
      catch (Throwable paramTPDLProxyBindServiceCallback)
      {
        TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", "ensurePlayManagerService failed, error:" + paramTPDLProxyBindServiceCallback.toString());
        AppMethodBeat.o(207266);
      }
    }
    return false;
  }
  
  public static boolean getCanUseAIDL()
  {
    try
    {
      boolean bool = mCanUseAIDL;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String getNativeVersion()
  {
    AppMethodBeat.i(207270);
    String str1;
    if (!mUseService)
    {
      str1 = TPDownloadProxyNative.getInstance().getNativeVersion();
      AppMethodBeat.o(207270);
      return str1;
    }
    if (!mCanUseAIDL)
    {
      str1 = TPDownloadProxyNative.getInstance().getNativeVersion();
      AppMethodBeat.o(207270);
      return str1;
    }
    if (downloadProxyFactoryAidl != null) {
      try
      {
        str1 = downloadProxyFactoryAidl.getNativeVersion();
        AppMethodBeat.o(207270);
        return str1;
      }
      catch (Throwable localThrowable)
      {
        TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", "getNativeVersion failed, error:" + localThrowable.toString());
      }
    }
    String str2 = TPDownloadProxyNative.getInstance().getNativeVersion();
    AppMethodBeat.o(207270);
    return str2;
  }
  
  public static ITPDownloadProxy getTPDownloadProxy(int paramInt)
  {
    AppMethodBeat.i(207264);
    if (paramInt <= 0)
    {
      TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", "getTPDownloadProxy is invalid, serviceType:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(207264);
      return null;
    }
    if (mUseService)
    {
      if (mCanUseAIDL) {
        try
        {
          ITPDownloadProxy localITPDownloadProxy1 = getTPDownloadProxyService(paramInt);
          AppMethodBeat.o(207264);
          return localITPDownloadProxy1;
        }
        catch (Throwable localThrowable)
        {
          TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", "getTPDownloadProxy failed, error:" + localThrowable.toString());
          AppMethodBeat.o(207264);
          return null;
        }
      }
      TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", "getTPDownloadProxy failed, can't use aidl!");
      AppMethodBeat.o(207264);
      return null;
    }
    synchronized (mMapObject)
    {
      ITPDownloadProxy localITPDownloadProxy2 = (ITPDownloadProxy)mvTPDownloadProxyMap.get(Integer.valueOf(paramInt));
      Object localObject1 = localITPDownloadProxy2;
      if (localITPDownloadProxy2 == null)
      {
        localObject1 = new TPDownloadProxy(paramInt);
        mvTPDownloadProxyMap.put(Integer.valueOf(paramInt), localObject1);
      }
      AppMethodBeat.o(207264);
      return localObject1;
    }
  }
  
  private static ITPDownloadProxy getTPDownloadProxyService(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(207265);
        if (downloadProxyFactoryAidl != null) {
          synchronized (mvTPDownloadProxyClientMap)
          {
            TPDownloadProxyClient localTPDownloadProxyClient3 = (TPDownloadProxyClient)mvTPDownloadProxyClientMap.get(Integer.valueOf(paramInt));
            TPDownloadProxyClient localTPDownloadProxyClient1 = localTPDownloadProxyClient3;
            if (localTPDownloadProxyClient3 == null) {}
            try
            {
              localTPDownloadProxyClient1 = new TPDownloadProxyClient(downloadProxyFactoryAidl.getTPDownloadProxy(paramInt));
              mvTPDownloadProxyClientMap.put(Integer.valueOf(paramInt), localTPDownloadProxyClient1);
              AppMethodBeat.o(207265);
              return localTPDownloadProxyClient1;
            }
            catch (Throwable localThrowable)
            {
              TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", "getTPDownloadProxyService failed, error:" + localThrowable.toString());
              TPDownloadProxyClient localTPDownloadProxyClient2 = localTPDownloadProxyClient3;
              continue;
            }
          }
        }
        TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", "getTPDownloadProxyService failed, aidl is null!");
      }
      finally {}
      Object localObject3 = null;
      AppMethodBeat.o(207265);
    }
  }
  
  public static boolean getUseService()
  {
    return mUseService;
  }
  
  public static boolean isReadyForDownload()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(207268);
        if (!mUseService)
        {
          TPDLProxyLog.i("TPDownloadProxyFactory", 0, "tpdlnative", "isReadyForDownload ret:" + mIsReadyForDownload);
          bool1 = mIsReadyForDownload;
          AppMethodBeat.o(207268);
          return bool1;
        }
        if (!mCanUseAIDL)
        {
          AppMethodBeat.o(207268);
          continue;
        }
        localTPDownloadProxyFactoryAidl = downloadProxyFactoryAidl;
      }
      finally {}
      TPDownloadProxyFactoryAidl localTPDownloadProxyFactoryAidl;
      bool1 = bool2;
      if (localTPDownloadProxyFactoryAidl != null) {}
      try
      {
        bool1 = downloadProxyFactoryAidl.isReadyForDownload();
        AppMethodBeat.o(207268);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", "isReadyForDownload failed, error:" + localThrowable.toString());
          bool1 = bool2;
        }
      }
    }
  }
  
  public static boolean isReadyForPlay()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(207267);
        if (!mUseService)
        {
          bool1 = TPDownloadProxyNative.getInstance().isReadyForWork();
          TPDLProxyLog.i("TPDownloadProxyFactory", 0, "tpdlnative", "isReadyForPlay ret:".concat(String.valueOf(bool1)));
          AppMethodBeat.o(207267);
          return bool1;
        }
        if (!mCanUseAIDL)
        {
          AppMethodBeat.o(207267);
          continue;
        }
        localTPDownloadProxyFactoryAidl = downloadProxyFactoryAidl;
      }
      finally {}
      TPDownloadProxyFactoryAidl localTPDownloadProxyFactoryAidl;
      bool1 = bool2;
      if (localTPDownloadProxyFactoryAidl != null) {}
      try
      {
        bool1 = downloadProxyFactoryAidl.isReadyForPlay();
        AppMethodBeat.o(207267);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", "isReadyForPlay failed, error:" + localThrowable.toString());
          bool1 = bool2;
        }
      }
    }
  }
  
  private static void setCanUseAIDL(boolean paramBoolean)
  {
    try
    {
      mCanUseAIDL = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void setReadyForDownload(boolean paramBoolean)
  {
    try
    {
      mIsReadyForDownload = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void setUseService(boolean paramBoolean)
  {
    mUseService = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory
 * JD-Core Version:    0.7.0.1
 */