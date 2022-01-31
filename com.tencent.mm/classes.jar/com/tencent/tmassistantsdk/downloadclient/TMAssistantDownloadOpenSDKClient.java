package com.tencent.tmassistantsdk.downloadclient;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.b.a.a.a;
import com.tencent.b.a.a.a.a;
import com.tencent.b.a.a.b;
import com.tencent.b.a.a.b.a;
import com.tencent.tmassistantsdk.util.Base64;
import com.tencent.tmassistantsdk.util.Cryptor;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class TMAssistantDownloadOpenSDKClient
  extends TMAssistantDownloadSDKClientBase
{
  protected static final String TAG = "TMAssistantDownloadOpenSDKClient";
  ArrayList<IAssistantOnActionListener> mListeners = new ArrayList();
  protected boolean retryBindResult = false;
  protected int retryCount = 0;
  
  public TMAssistantDownloadOpenSDKClient(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext, paramString1, paramString2);
    this.mServiceCallback = new b.a()
    {
      public void onActionResult(byte[] paramAnonymousArrayOfByte)
      {
        TMLog.i("TMAssistantDownloadOpenSDKClient", "onActionResult  callBack data:" + paramAnonymousArrayOfByte + "  mListeners.size:" + TMAssistantDownloadOpenSDKClient.this.mListeners.size());
        TMAssistantDownloadSDKMessageThread.getInstance().postActionResult(paramAnonymousArrayOfByte, TMAssistantDownloadOpenSDKClient.this.mListeners);
      }
    };
  }
  
  public static String about()
  {
    return "TMAssistantDownloadOpenSDKClient_2014_03_06_11_20_release_25634";
  }
  
  public void addAssistantOnActionListener(IAssistantOnActionListener paramIAssistantOnActionListener)
  {
    TMLog.i("TMAssistantDownloadOpenSDKClient", "addAssistantOnActionListener");
    if ((paramIAssistantOnActionListener != null) && (!this.mListeners.contains(paramIAssistantOnActionListener))) {
      this.mListeners.add(paramIAssistantOnActionListener);
    }
  }
  
  protected Intent getBindServiceIntent()
  {
    Intent localIntent = new Intent(this.mDwonloadServiceName);
    localIntent.setPackage("com.tencent.android.qqdownloader");
    return localIntent;
  }
  
  /* Error */
  public boolean initTMAssistantDownloadSDK()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 84	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:initTMAssistantDownloadSDK	()Z
    //   6: istore_1
    //   7: ldc 12
    //   9: new 86	java/lang/StringBuilder
    //   12: dup
    //   13: ldc 88
    //   15: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: iload_1
    //   19: invokevirtual 93	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   22: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 55	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: iload_1
    //   29: ifne +78 -> 107
    //   32: new 66	android/content/Intent
    //   35: dup
    //   36: invokespecial 97	android/content/Intent:<init>	()V
    //   39: astore_2
    //   40: aload_2
    //   41: ldc 74
    //   43: ldc 99
    //   45: invokevirtual 103	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   48: pop
    //   49: aload_2
    //   50: ldc 104
    //   52: invokevirtual 108	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   55: pop
    //   56: aload_0
    //   57: getfield 112	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadOpenSDKClient:mContext	Landroid/content/Context;
    //   60: aload_2
    //   61: invokevirtual 118	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   64: new 120	android/os/HandlerThread
    //   67: dup
    //   68: ldc 122
    //   70: invokespecial 123	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   73: astore_2
    //   74: aload_2
    //   75: invokevirtual 126	android/os/HandlerThread:start	()V
    //   78: new 128	android/os/Handler
    //   81: dup
    //   82: aload_2
    //   83: invokevirtual 132	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   86: invokespecial 135	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   89: astore_2
    //   90: aload_2
    //   91: new 8	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadOpenSDKClient$2
    //   94: dup
    //   95: aload_0
    //   96: aload_2
    //   97: invokespecial 138	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadOpenSDKClient$2:<init>	(Lcom/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadOpenSDKClient;Landroid/os/Handler;)V
    //   100: ldc2_w 139
    //   103: invokevirtual 144	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   106: pop
    //   107: aload_0
    //   108: monitorexit
    //   109: iload_1
    //   110: ireturn
    //   111: astore_2
    //   112: ldc 12
    //   114: new 86	java/lang/StringBuilder
    //   117: dup
    //   118: ldc 146
    //   120: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   123: aload_2
    //   124: invokevirtual 147	java/lang/Exception:toString	()Ljava/lang/String;
    //   127: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 153	com/tencent/tmassistantsdk/util/TMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: goto -72 -> 64
    //   139: astore_2
    //   140: aload_0
    //   141: monitorexit
    //   142: aload_2
    //   143: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	TMAssistantDownloadOpenSDKClient
    //   6	104	1	bool	boolean
    //   39	58	2	localObject1	Object
    //   111	13	2	localException	Exception
    //   139	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   32	64	111	java/lang/Exception
    //   2	28	139	finally
    //   32	64	139	finally
    //   64	107	139	finally
    //   112	136	139	finally
  }
  
  protected void onDownloadSDKServiceInvalid()
  {
    if ((this.mListeners != null) && (this.mListeners.size() > 0))
    {
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext())
      {
        IAssistantOnActionListener localIAssistantOnActionListener = (IAssistantOnActionListener)localIterator.next();
        if (localIAssistantOnActionListener != null) {
          localIAssistantOnActionListener.onDownloadSDKServiceInvalid();
        }
      }
    }
  }
  
  protected void registerServiceCallback()
  {
    Object localObject = String.valueOf(System.currentTimeMillis()).getBytes();
    localObject = Base64.encodeToString(new Cryptor().encrypt((byte[])localObject, this.mClientKey.getBytes()), 0);
    int i = ((a)this.mServiceInterface).a(this.mClientKey, (String)localObject, (b)this.mServiceCallback);
    TMLog.i("TMAssistantDownloadOpenSDKClient", "onServiceConnected,registerActionCallback:" + this.mClientKey + ",tokenString:" + (String)localObject + ",threadId:" + Thread.currentThread().getId() + ",mServiceCallback:" + this.mServiceCallback + ",registed result:" + i);
    if (i == 2) {
      onDownloadSDKServiceInvalid();
    }
  }
  
  public void sendAsyncData(byte[] paramArrayOfByte)
  {
    if (!TextUtils.isEmpty(this.mClientKey))
    {
      a locala = (a)super.getServiceInterface();
      if (locala != null) {
        locala.d(this.mClientKey, paramArrayOfByte);
      }
    }
  }
  
  public byte[] sendSyncData(byte[] paramArrayOfByte)
  {
    if (!TextUtils.isEmpty(this.mClientKey))
    {
      a locala = (a)super.getServiceInterface();
      if (locala != null) {
        return locala.c(this.mClientKey, paramArrayOfByte);
      }
    }
    return null;
  }
  
  protected void stubAsInterface(IBinder paramIBinder)
  {
    this.mServiceInterface = a.a.i(paramIBinder);
  }
  
  protected void unRegisterServiceCallback()
  {
    if (((a)this.mServiceInterface).a((b)this.mServiceCallback) == 2) {
      onDownloadSDKServiceInvalid();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadOpenSDKClient
 * JD-Core Version:    0.7.0.1
 */