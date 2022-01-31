package com.tencent.tmassistantsdk.downloadclient;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.tmassistantsdk.util.TMLog;

public abstract class TMAssistantDownloadSDKClientBase
  implements ServiceConnection
{
  public static final String CONNTECTSTATE_CONNECTING = "CONNECTING";
  public static final String CONNTECTSTATE_FINISH = "FINISH";
  public static final String CONNTECTSTATE_INIT = "INIT";
  protected static final String TAG = "TMAssistantDownloadSDKClient";
  protected String connectState = "INIT";
  public String mClientKey;
  protected Context mContext;
  protected String mDwonloadServiceName = null;
  protected IInterface mServiceCallback = null;
  protected IInterface mServiceInterface = null;
  protected final Object mThreadlock = new Object();
  
  public TMAssistantDownloadSDKClientBase(Context paramContext, String paramString1, String paramString2)
  {
    this.mContext = paramContext;
    this.mClientKey = paramString1;
    this.mDwonloadServiceName = paramString2;
  }
  
  protected abstract Intent getBindServiceIntent();
  
  protected IInterface getServiceInterface()
  {
    if ((this.mContext != null) && (this.mContext.getMainLooper().getThread().getId() == Thread.currentThread().getId())) {
      throw new Exception("TMAssistantDownloadSDKClient must be called in other Thread(no MainThread)");
    }
    if (this.mServiceInterface == null)
    {
      initTMAssistantDownloadSDK();
      this.connectState = "CONNECTING";
    }
    synchronized (this.mThreadlock)
    {
      this.mThreadlock.wait(10000L);
      if (this.mServiceInterface == null) {
        throw new Exception("TMAssistantDownloadSDKClient ServiceInterface is null");
      }
    }
    return this.mServiceInterface;
  }
  
  /* Error */
  public boolean initTMAssistantDownloadSDK()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: aload_0
    //   5: monitorenter
    //   6: ldc 19
    //   8: new 95	java/lang/StringBuilder
    //   11: dup
    //   12: ldc 97
    //   14: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   17: aload_0
    //   18: getfield 38	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:connectState	Ljava/lang/String;
    //   21: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 112	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload_0
    //   31: getfield 38	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:connectState	Ljava/lang/String;
    //   34: astore 4
    //   36: aload 4
    //   38: ldc 16
    //   40: if_acmpeq +9 -> 49
    //   43: iconst_1
    //   44: istore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: iload_1
    //   48: ireturn
    //   49: ldc 19
    //   51: new 95	java/lang/StringBuilder
    //   54: dup
    //   55: ldc 114
    //   57: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   60: aload_0
    //   61: getfield 48	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:mClientKey	Ljava/lang/String;
    //   64: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc 116
    //   69: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_0
    //   73: getfield 40	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:mServiceInterface	Landroid/os/IInterface;
    //   76: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   79: ldc 121
    //   81: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokestatic 74	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   87: invokevirtual 71	java/lang/Thread:getId	()J
    //   90: invokevirtual 124	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   93: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 112	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload_0
    //   100: ldc 16
    //   102: putfield 38	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:connectState	Ljava/lang/String;
    //   105: aload_0
    //   106: getfield 40	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:mServiceInterface	Landroid/os/IInterface;
    //   109: ifnull +14 -> 123
    //   112: aload_0
    //   113: ldc 13
    //   115: putfield 38	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:connectState	Ljava/lang/String;
    //   118: iconst_1
    //   119: istore_1
    //   120: goto -75 -> 45
    //   123: iload_3
    //   124: istore_1
    //   125: aload_0
    //   126: getfield 46	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:mContext	Landroid/content/Context;
    //   129: ifnull -84 -> 45
    //   132: aload_0
    //   133: getfield 36	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:mDwonloadServiceName	Ljava/lang/String;
    //   136: astore 4
    //   138: iload_3
    //   139: istore_1
    //   140: aload 4
    //   142: ifnull -97 -> 45
    //   145: aload_0
    //   146: invokevirtual 126	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:getBindServiceIntent	()Landroid/content/Intent;
    //   149: astore 4
    //   151: aload_0
    //   152: getfield 46	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:mContext	Landroid/content/Context;
    //   155: aload 4
    //   157: aload_0
    //   158: iconst_1
    //   159: invokevirtual 130	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   162: istore_1
    //   163: ldc 19
    //   165: new 95	java/lang/StringBuilder
    //   168: dup
    //   169: ldc 132
    //   171: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   174: iload_1
    //   175: invokevirtual 135	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   178: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 112	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: goto -139 -> 45
    //   187: astore 4
    //   189: aload_0
    //   190: monitorexit
    //   191: aload 4
    //   193: athrow
    //   194: astore 4
    //   196: ldc 19
    //   198: aload 4
    //   200: ldc 137
    //   202: iconst_0
    //   203: anewarray 4	java/lang/Object
    //   206: invokestatic 143	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   209: iload_2
    //   210: istore_1
    //   211: goto -48 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	TMAssistantDownloadSDKClientBase
    //   44	167	1	bool1	boolean
    //   1	209	2	bool2	boolean
    //   3	136	3	bool3	boolean
    //   34	122	4	localObject1	Object
    //   187	5	4	localObject2	Object
    //   194	5	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   6	36	187	finally
    //   49	118	187	finally
    //   125	138	187	finally
    //   145	163	187	finally
    //   163	184	187	finally
    //   196	209	187	finally
    //   145	163	194	java/lang/Exception
  }
  
  protected abstract void onDownloadSDKServiceInvalid();
  
  public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    stubAsInterface(paramIBinder);
    this.connectState = "FINISH";
    synchronized (this.mThreadlock)
    {
      this.mThreadlock.notifyAll();
      TMLog.i("TMAssistantDownloadSDKClient", "onServiceConnected,clientKey:" + this.mClientKey + ",mServiceInterface:" + this.mServiceInterface + ",IBinder:" + paramIBinder + ",threadId:" + Thread.currentThread().getId());
    }
  }
  
  /* Error */
  public void onServiceDisconnected(ComponentName arg1)
  {
    // Byte code:
    //   0: ldc 19
    //   2: new 95	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 173
    //   8: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield 48	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:mClientKey	Ljava/lang/String;
    //   15: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   21: invokestatic 112	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: aload_0
    //   25: monitorenter
    //   26: aload_0
    //   27: aconst_null
    //   28: putfield 40	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:mServiceInterface	Landroid/os/IInterface;
    //   31: aload_0
    //   32: ldc 16
    //   34: putfield 38	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:connectState	Ljava/lang/String;
    //   37: aload_0
    //   38: getfield 44	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:mThreadlock	Ljava/lang/Object;
    //   41: astore_1
    //   42: aload_1
    //   43: monitorenter
    //   44: aload_0
    //   45: getfield 44	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:mThreadlock	Ljava/lang/Object;
    //   48: invokevirtual 155	java/lang/Object:notifyAll	()V
    //   51: aload_1
    //   52: monitorexit
    //   53: aload_0
    //   54: invokevirtual 169	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:onDownloadSDKServiceInvalid	()V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: astore_2
    //   61: aload_1
    //   62: monitorexit
    //   63: aload_2
    //   64: athrow
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	TMAssistantDownloadSDKClientBase
    //   60	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   44	53	60	finally
    //   61	63	60	finally
    //   26	44	65	finally
    //   53	59	65	finally
    //   63	65	65	finally
    //   66	68	65	finally
  }
  
  protected abstract void registerServiceCallback();
  
  protected abstract void stubAsInterface(IBinder paramIBinder);
  
  /* Error */
  public void unInitTMAssistantDownloadSDK()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 19
    //   4: new 95	java/lang/StringBuilder
    //   7: dup
    //   8: ldc 176
    //   10: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 48	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:mClientKey	Ljava/lang/String;
    //   17: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc 116
    //   22: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: getfield 40	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:mServiceInterface	Landroid/os/IInterface;
    //   29: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   32: ldc 121
    //   34: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokestatic 74	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   40: invokevirtual 71	java/lang/Thread:getId	()J
    //   43: invokevirtual 124	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   46: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 112	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_0
    //   53: getfield 40	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:mServiceInterface	Landroid/os/IInterface;
    //   56: ifnull +16 -> 72
    //   59: aload_0
    //   60: getfield 42	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:mServiceCallback	Landroid/os/IInterface;
    //   63: astore_1
    //   64: aload_1
    //   65: ifnull +7 -> 72
    //   68: aload_0
    //   69: invokevirtual 179	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:unRegisterServiceCallback	()V
    //   72: aload_0
    //   73: getfield 46	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:mContext	Landroid/content/Context;
    //   76: ifnull +22 -> 98
    //   79: aload_0
    //   80: ifnull +18 -> 98
    //   83: aload_0
    //   84: getfield 40	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:mServiceInterface	Landroid/os/IInterface;
    //   87: ifnull +11 -> 98
    //   90: aload_0
    //   91: getfield 46	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:mContext	Landroid/content/Context;
    //   94: aload_0
    //   95: invokevirtual 183	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   98: aload_0
    //   99: aconst_null
    //   100: putfield 40	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:mServiceInterface	Landroid/os/IInterface;
    //   103: aload_0
    //   104: aconst_null
    //   105: putfield 42	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:mServiceCallback	Landroid/os/IInterface;
    //   108: aload_0
    //   109: ldc 16
    //   111: putfield 38	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:connectState	Ljava/lang/String;
    //   114: aload_0
    //   115: monitorexit
    //   116: return
    //   117: astore_1
    //   118: goto -46 -> 72
    //   121: astore_1
    //   122: aload_0
    //   123: monitorexit
    //   124: aload_1
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	TMAssistantDownloadSDKClientBase
    //   63	2	1	localIInterface	IInterface
    //   117	1	1	localRemoteException	RemoteException
    //   121	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   68	72	117	android/os/RemoteException
    //   2	64	121	finally
    //   68	72	121	finally
    //   72	79	121	finally
    //   83	98	121	finally
    //   98	114	121	finally
  }
  
  protected abstract void unRegisterServiceCallback();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase
 * JD-Core Version:    0.7.0.1
 */