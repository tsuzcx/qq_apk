package com.tencent.tmassistantsdk.downloadclient;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
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
  protected ReferenceQueue<ITMAssistantDownloadSDKClientListener> mListenerReferenceQueue = new ReferenceQueue();
  protected ArrayList<WeakReference<ITMAssistantDownloadSDKClientListener>> mWeakListenerArrayList = new ArrayList();
  
  public TMAssistantDownloadSDKClient(Context paramContext, String paramString)
  {
    super(paramContext, paramString, "com.tencent.tmassistantsdk.downloadservice.TMAssistantDownloadSDKService");
    this.mServiceCallback = new ITMAssistantDownloadSDKServiceCallback.Stub()
    {
      public void OnDownloadSDKServiceTaskProgressChanged(String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong1, long paramAnonymousLong2)
      {
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
      }
      
      public void OnDownloadSDKServiceTaskStateChanged(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString3, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
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
      }
    };
  }
  
  public static String about()
  {
    return "TMAssistantDownloadSDKClient_2014_03_06_11_20_release_25634";
  }
  
  public void cancelDownloadTask(String paramString)
  {
    try
    {
      TMLog.i("TMAssistantDownloadSDKClient", "cancelDownloadTask,clientKey:" + this.mClientKey + ",url:" + paramString);
      if (paramString == null) {
        throw new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
      }
    }
    finally {}
    ITMAssistantDownloadSDKServiceInterface localITMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface)super.getServiceInterface();
    if (localITMAssistantDownloadSDKServiceInterface != null) {
      localITMAssistantDownloadSDKServiceInterface.cancelDownloadTask(this.mClientKey, paramString);
    }
    for (;;)
    {
      return;
      TMLog.i("TMAssistantDownloadSDKClient", "cancelDownloadTask, serviceInterface is null");
      super.initTMAssistantDownloadSDK();
    }
  }
  
  protected Intent getBindServiceIntent()
  {
    return new Intent(this.mContext, Class.forName(this.mDwonloadServiceName));
  }
  
  public TMAssistantDownloadTaskInfo getDownloadTaskState(String paramString)
  {
    try
    {
      TMLog.i("TMAssistantDownloadSDKClient", "getDownloadTaskState,clientKey:" + this.mClientKey + ",url:" + paramString);
      if (paramString == null) {
        throw new IllegalArgumentException("TMAssistantDownloadSDKClient.getDownloadTaskState url is null");
      }
    }
    finally {}
    ITMAssistantDownloadSDKServiceInterface localITMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface)super.getServiceInterface();
    if (localITMAssistantDownloadSDKServiceInterface != null) {}
    for (paramString = localITMAssistantDownloadSDKServiceInterface.getDownloadTaskInfo(this.mClientKey, paramString);; paramString = null)
    {
      return paramString;
      super.initTMAssistantDownloadSDK();
    }
  }
  
  protected void onDownloadSDKServiceInvalid()
  {
    Iterator localIterator = this.mWeakListenerArrayList.iterator();
    while (localIterator.hasNext())
    {
      ITMAssistantDownloadSDKClientListener localITMAssistantDownloadSDKClientListener = (ITMAssistantDownloadSDKClientListener)((WeakReference)localIterator.next()).get();
      TMAssistantDownloadSDKMessageThread.getInstance().postSDKServiceInvalidMessage(this, localITMAssistantDownloadSDKClientListener);
    }
  }
  
  public void pauseDownloadTask(String paramString)
  {
    try
    {
      TMLog.i("TMAssistantDownloadSDKClient", "pauseDownloadTask,clientKey:" + this.mClientKey + ",url:" + paramString);
      if (paramString == null) {
        throw new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
      }
    }
    finally {}
    ITMAssistantDownloadSDKServiceInterface localITMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface)super.getServiceInterface();
    if (localITMAssistantDownloadSDKServiceInterface != null) {
      localITMAssistantDownloadSDKServiceInterface.pauseDownloadTask(this.mClientKey, paramString);
    }
    for (;;)
    {
      return;
      TMLog.i("TMAssistantDownloadSDKClient", "pauseDownloadTask, serviceInterface is null");
      super.initTMAssistantDownloadSDK();
    }
  }
  
  public boolean registerDownloadTaskListener(ITMAssistantDownloadSDKClientListener paramITMAssistantDownloadSDKClientListener)
  {
    boolean bool;
    if (paramITMAssistantDownloadSDKClientListener == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      Object localObject;
      try
      {
        for (;;)
        {
          localObject = this.mListenerReferenceQueue.poll();
          if (localObject == null) {
            break;
          }
          TMLog.i("TMAssistantDownloadSDKClient", "registerDownloadTaskListener removed listener!!!!");
          this.mWeakListenerArrayList.remove(localObject);
        }
        localObject = this.mWeakListenerArrayList.iterator();
      }
      finally {}
      for (;;)
      {
        if (((Iterator)localObject).hasNext()) {
          if ((ITMAssistantDownloadSDKClientListener)((WeakReference)((Iterator)localObject).next()).get() == paramITMAssistantDownloadSDKClientListener)
          {
            bool = true;
            break;
          }
        }
      }
      paramITMAssistantDownloadSDKClientListener = new WeakReference(paramITMAssistantDownloadSDKClientListener, this.mListenerReferenceQueue);
      this.mWeakListenerArrayList.add(paramITMAssistantDownloadSDKClientListener);
      bool = true;
    }
  }
  
  protected void registerServiceCallback()
  {
    ((ITMAssistantDownloadSDKServiceInterface)this.mServiceInterface).registerDownloadTaskCallback(this.mClientKey, (ITMAssistantDownloadSDKServiceCallback)this.mServiceCallback);
  }
  
  public int startDownloadTask(String paramString1, String paramString2)
  {
    try
    {
      int i = startDownloadTask(paramString1, "", 0L, 0, paramString2, null, true, null);
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
      TMLog.i("TMAssistantDownloadSDKClient", "startDownloadTask,clientKey:" + this.mClientKey + ",url:" + paramString1 + ",contentType:" + paramString3);
      if (paramString1 == null) {
        throw new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
      }
    }
    finally {}
    if ((paramString3.equals("resource/tm.android.unknown")) && (TextUtils.isEmpty(paramString4))) {
      throw new IllegalArgumentException("if contentType is others, filename shouldn't be null!");
    }
    ITMAssistantDownloadSDKServiceInterface localITMAssistantDownloadSDKServiceInterface = (ITMAssistantDownloadSDKServiceInterface)super.getServiceInterface();
    if (localITMAssistantDownloadSDKServiceInterface != null) {
      localITMAssistantDownloadSDKServiceInterface.setServiceSetingIsDownloadWifiOnly(paramBoolean);
    }
    for (paramInt = localITMAssistantDownloadSDKServiceInterface.startDownloadTask(this.mClientKey, paramString1, paramString2, paramLong, 0, paramString3, paramString4, paramMap);; paramInt = 0)
    {
      return paramInt;
      TMLog.i("TMAssistantDownloadSDKClient", "startDownloadTask, serviceInterface is null");
      super.initTMAssistantDownloadSDK();
    }
  }
  
  public int startDownloadTask(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      int i = startDownloadTask(paramString1, "", 0L, 0, paramString2, paramString3, true, null);
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
      int i = startDownloadTask(paramString1, "", 0L, 0, paramString2, null, true, paramMap);
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
    this.mServiceInterface = ITMAssistantDownloadSDKServiceInterface.Stub.asInterface(paramIBinder);
  }
  
  public boolean unRegisterDownloadTaskListener(ITMAssistantDownloadSDKClientListener paramITMAssistantDownloadSDKClientListener)
  {
    boolean bool;
    if (paramITMAssistantDownloadSDKClientListener == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        Iterator localIterator = this.mWeakListenerArrayList.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            WeakReference localWeakReference = (WeakReference)localIterator.next();
            if ((ITMAssistantDownloadSDKClientListener)localWeakReference.get() == paramITMAssistantDownloadSDKClientListener)
            {
              this.mWeakListenerArrayList.remove(localWeakReference);
              bool = true;
              break;
            }
          }
        }
        bool = false;
      }
      finally {}
    }
  }
  
  protected void unRegisterServiceCallback()
  {
    ((ITMAssistantDownloadSDKServiceInterface)this.mServiceInterface).unregisterDownloadTaskCallback(this.mClientKey, (ITMAssistantDownloadSDKServiceCallback)this.mServiceCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient
 * JD-Core Version:    0.7.0.1
 */