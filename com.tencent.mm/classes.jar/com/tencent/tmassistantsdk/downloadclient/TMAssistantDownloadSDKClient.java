package com.tencent.tmassistantsdk.downloadclient;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback.Stub;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface;
import com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface.Stub;
import com.tencent.tmassistantsdk.util.TMLog;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class TMAssistantDownloadSDKClient
  extends TMAssistantDownloadSDKClientBase
{
  protected static final String DOWNDLOADSDKSERVICENAME = "com.tencent.tmassistantsdk.downloadservice.TMAssistantDownloadSDKService";
  protected static final String TAG = "TMAssistantDownloadSDKClient";
  protected ReferenceQueue<ITMAssistantDownloadSDKClientListener> mListenerReferenceQueue;
  protected ArrayList<WeakReference<ITMAssistantDownloadSDKClientListener>> mWeakListenerArrayList;
  
  public TMAssistantDownloadSDKClient(Context paramContext, String paramString)
  {
    super(paramContext, paramString, "com.tencent.tmassistantsdk.downloadservice.TMAssistantDownloadSDKService");
    AppMethodBeat.i(75635);
    this.mListenerReferenceQueue = new ReferenceQueue();
    this.mWeakListenerArrayList = new ArrayList();
    this.mServiceCallback = new ITMAssistantDownloadSDKServiceCallback.Stub()
    {
      public void OnDownloadSDKServiceTaskProgressChanged(String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(75634);
        TMLog.i("TMAssistantDownloadSDKClient", "OnDownloadProgressChanged,clientKey:" + paramAnonymousString1 + ",receivedLen:" + paramAnonymousLong1 + ",totalLen:" + paramAnonymousLong2 + ",url:" + paramAnonymousString2);
        paramAnonymousString1 = TMAssistantDownloadSDKClient.this.mWeakListenerArrayList.iterator();
        while (paramAnonymousString1.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)paramAnonymousString1.next();
          ITMAssistantDownloadSDKClientListener localITMAssistantDownloadSDKClientListener = (ITMAssistantDownloadSDKClientListener)localWeakReference.get();
          if (localITMAssistantDownloadSDKClientListener == null) {
            TMLog.i("TMAssistantDownloadSDKClient", " listener = " + localITMAssistantDownloadSDKClientListener + "   linstenerWeakReference :" + localWeakReference);
          }
          TMAssistantDownloadSDKMessageThread.getInstance().postTaskProgressChangedMessage(TMAssistantDownloadSDKClient.this, localITMAssistantDownloadSDKClientListener, paramAnonymousString2, paramAnonymousLong1, paramAnonymousLong2);
        }
        AppMethodBeat.o(75634);
      }
      
      public void OnDownloadSDKServiceTaskStateChanged(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString3, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(75633);
        TMLog.i("TMAssistantDownloadSDKClient", "OnDownloadStateChanged,clientKey:" + paramAnonymousString1 + ",state:" + paramAnonymousInt1 + ", errorcode" + paramAnonymousInt2 + ",url:" + paramAnonymousString2);
        paramAnonymousString1 = TMAssistantDownloadSDKClient.this.mWeakListenerArrayList.iterator();
        while (paramAnonymousString1.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)paramAnonymousString1.next();
          ITMAssistantDownloadSDKClientListener localITMAssistantDownloadSDKClientListener = (ITMAssistantDownloadSDKClientListener)localWeakReference.get();
          if (localITMAssistantDownloadSDKClientListener == null) {
            TMLog.i("TMAssistantDownloadSDKClient", " listener = " + localITMAssistantDownloadSDKClientListener + "   linstenerWeakReference :" + localWeakReference);
          }
          TMAssistantDownloadSDKMessageThread.getInstance().postTaskStateChangedMessage(TMAssistantDownloadSDKClient.this, localITMAssistantDownloadSDKClientListener, paramAnonymousString2, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString3, paramAnonymousBoolean1, paramAnonymousBoolean2);
        }
        AppMethodBeat.o(75633);
      }
    };
    AppMethodBeat.o(75635);
  }
  
  public static String about()
  {
    return "TMAssistantDownloadSDKClient_2014_03_06_11_20_release_25634";
  }
  
  public void cancelDownloadTask(String paramString)
  {
    try
    {
      AppMethodBeat.i(75642);
      TMLog.i("TMAssistantDownloadSDKClient", "cancelDownloadTask,clientKey:" + this.mClientKey + ",url:" + paramString);
      if (paramString == null)
      {
        paramString = new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
        AppMethodBeat.o(75642);
        throw paramString;
      }
    }
    finally {}
    ITMAssistantDownloadSDKServiceInterface localITMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface)super.getServiceInterface();
    if (localITMAssistantDownloadSDKServiceInterface != null)
    {
      localITMAssistantDownloadSDKServiceInterface.cancelDownloadTask(this.mClientKey, paramString);
      AppMethodBeat.o(75642);
    }
    for (;;)
    {
      return;
      TMLog.i("TMAssistantDownloadSDKClient", "cancelDownloadTask, serviceInterface is null");
      super.initTMAssistantDownloadSDK();
      AppMethodBeat.o(75642);
    }
  }
  
  protected Intent getBindServiceIntent()
  {
    AppMethodBeat.i(75648);
    Intent localIntent = new Intent(this.mContext, Class.forName(this.mDwonloadServiceName));
    AppMethodBeat.o(75648);
    return localIntent;
  }
  
  public TMAssistantDownloadTaskInfo getDownloadTaskState(String paramString)
  {
    try
    {
      AppMethodBeat.i(75636);
      TMLog.i("TMAssistantDownloadSDKClient", "getDownloadTaskState,clientKey:" + this.mClientKey + ",url:" + paramString);
      if (paramString == null)
      {
        paramString = new IllegalArgumentException("TMAssistantDownloadSDKClient.getDownloadTaskState url is null");
        AppMethodBeat.o(75636);
        throw paramString;
      }
    }
    finally {}
    ITMAssistantDownloadSDKServiceInterface localITMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface)super.getServiceInterface();
    if (localITMAssistantDownloadSDKServiceInterface != null)
    {
      paramString = localITMAssistantDownloadSDKServiceInterface.getDownloadTaskInfo(this.mClientKey, paramString);
      AppMethodBeat.o(75636);
    }
    for (;;)
    {
      return paramString;
      super.initTMAssistantDownloadSDK();
      paramString = null;
      AppMethodBeat.o(75636);
    }
  }
  
  protected void onDownloadSDKServiceInvalid()
  {
    AppMethodBeat.i(75645);
    Iterator localIterator = this.mWeakListenerArrayList.iterator();
    while (localIterator.hasNext())
    {
      ITMAssistantDownloadSDKClientListener localITMAssistantDownloadSDKClientListener = (ITMAssistantDownloadSDKClientListener)((WeakReference)localIterator.next()).get();
      TMAssistantDownloadSDKMessageThread.getInstance().postSDKServiceInvalidMessage(this, localITMAssistantDownloadSDKClientListener);
    }
    AppMethodBeat.o(75645);
  }
  
  public void pauseDownloadTask(String paramString)
  {
    try
    {
      AppMethodBeat.i(75641);
      TMLog.i("TMAssistantDownloadSDKClient", "pauseDownloadTask,clientKey:" + this.mClientKey + ",url:" + paramString);
      if (paramString == null)
      {
        paramString = new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
        AppMethodBeat.o(75641);
        throw paramString;
      }
    }
    finally {}
    ITMAssistantDownloadSDKServiceInterface localITMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface)super.getServiceInterface();
    if (localITMAssistantDownloadSDKServiceInterface != null)
    {
      localITMAssistantDownloadSDKServiceInterface.pauseDownloadTask(this.mClientKey, paramString);
      AppMethodBeat.o(75641);
    }
    for (;;)
    {
      return;
      TMLog.i("TMAssistantDownloadSDKClient", "pauseDownloadTask, serviceInterface is null");
      super.initTMAssistantDownloadSDK();
      AppMethodBeat.o(75641);
    }
  }
  
  public boolean registerDownloadTaskListener(ITMAssistantDownloadSDKClientListener paramITMAssistantDownloadSDKClientListener)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        AppMethodBeat.i(75643);
        if (paramITMAssistantDownloadSDKClientListener == null)
        {
          bool = false;
          AppMethodBeat.o(75643);
          return bool;
        }
        localObject = this.mListenerReferenceQueue.poll();
        if (localObject != null)
        {
          TMLog.i("TMAssistantDownloadSDKClient", "registerDownloadTaskListener removed listener!!!!");
          this.mWeakListenerArrayList.remove(localObject);
          continue;
        }
        localObject = this.mWeakListenerArrayList.iterator();
      }
      finally {}
      for (;;)
      {
        if (((Iterator)localObject).hasNext()) {
          if ((ITMAssistantDownloadSDKClientListener)((WeakReference)((Iterator)localObject).next()).get() == paramITMAssistantDownloadSDKClientListener)
          {
            AppMethodBeat.o(75643);
            bool = true;
            break;
          }
        }
      }
      paramITMAssistantDownloadSDKClientListener = new WeakReference(paramITMAssistantDownloadSDKClientListener, this.mListenerReferenceQueue);
      this.mWeakListenerArrayList.add(paramITMAssistantDownloadSDKClientListener);
      AppMethodBeat.o(75643);
      boolean bool = true;
    }
  }
  
  protected void registerServiceCallback()
  {
    AppMethodBeat.i(75647);
    ((ITMAssistantDownloadSDKServiceInterface)this.mServiceInterface).registerDownloadTaskCallback(this.mClientKey, (ITMAssistantDownloadSDKServiceCallback)this.mServiceCallback);
    AppMethodBeat.o(75647);
  }
  
  public int startDownloadTask(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(75637);
      int i = startDownloadTask(paramString1, "", 0L, 0, paramString2, null, true, null);
      AppMethodBeat.o(75637);
      return i;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public int startDownloadTask(String paramString1, String paramString2, long paramLong, int paramInt, String paramString3, String paramString4, boolean paramBoolean, Map<String, String> paramMap)
  {
    try
    {
      AppMethodBeat.i(75640);
      TMLog.i("TMAssistantDownloadSDKClient", "startDownloadTask,clientKey:" + this.mClientKey + ",url:" + paramString1 + ",contentType:" + paramString3);
      if (paramString1 == null)
      {
        paramString1 = new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
        AppMethodBeat.o(75640);
        throw paramString1;
      }
    }
    finally {}
    if ((paramString3.equals("resource/tm.android.unknown")) && (TextUtils.isEmpty(paramString4)))
    {
      paramString1 = new IllegalArgumentException("if contentType is others, filename shouldn't be null!");
      AppMethodBeat.o(75640);
      throw paramString1;
    }
    ITMAssistantDownloadSDKServiceInterface localITMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface)super.getServiceInterface();
    if (localITMAssistantDownloadSDKServiceInterface != null)
    {
      localITMAssistantDownloadSDKServiceInterface.setServiceSetingIsDownloadWifiOnly(paramBoolean);
      paramInt = localITMAssistantDownloadSDKServiceInterface.startDownloadTask(this.mClientKey, paramString1, paramString2, paramLong, 0, paramString3, paramString4, paramMap);
      AppMethodBeat.o(75640);
    }
    for (;;)
    {
      return paramInt;
      TMLog.i("TMAssistantDownloadSDKClient", "startDownloadTask, serviceInterface is null");
      super.initTMAssistantDownloadSDK();
      paramInt = 0;
      AppMethodBeat.o(75640);
    }
  }
  
  public int startDownloadTask(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      AppMethodBeat.i(75639);
      int i = startDownloadTask(paramString1, "", 0L, 0, paramString2, paramString3, true, null);
      AppMethodBeat.o(75639);
      return i;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public int startDownloadTask(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    try
    {
      AppMethodBeat.i(75638);
      int i = startDownloadTask(paramString1, "", 0L, 0, paramString2, null, true, paramMap);
      AppMethodBeat.o(75638);
      return i;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  protected void stubAsInterface(IBinder paramIBinder)
  {
    AppMethodBeat.i(75646);
    this.mServiceInterface = ITMAssistantDownloadSDKServiceInterface.Stub.asInterface(paramIBinder);
    AppMethodBeat.o(75646);
  }
  
  public boolean unRegisterDownloadTaskListener(ITMAssistantDownloadSDKClientListener paramITMAssistantDownloadSDKClientListener)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(75644);
        if (paramITMAssistantDownloadSDKClientListener == null)
        {
          AppMethodBeat.o(75644);
          bool = false;
          return bool;
        }
        Iterator localIterator = this.mWeakListenerArrayList.iterator();
        if (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if ((ITMAssistantDownloadSDKClientListener)localWeakReference.get() != paramITMAssistantDownloadSDKClientListener) {
            continue;
          }
          this.mWeakListenerArrayList.remove(localWeakReference);
          bool = true;
          AppMethodBeat.o(75644);
          continue;
        }
        AppMethodBeat.o(75644);
      }
      finally {}
      boolean bool = false;
    }
  }
  
  protected void unRegisterServiceCallback()
  {
    AppMethodBeat.i(75649);
    ((ITMAssistantDownloadSDKServiceInterface)this.mServiceInterface).unregisterDownloadTaskCallback(this.mClientKey, (ITMAssistantDownloadSDKServiceCallback)this.mServiceCallback);
    AppMethodBeat.o(75649);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient
 * JD-Core Version:    0.7.0.1
 */