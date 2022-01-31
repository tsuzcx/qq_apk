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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.util.Base64;
import com.tencent.tmassistantsdk.util.Cryptor;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class TMAssistantDownloadOpenSDKClient
  extends TMAssistantDownloadSDKClientBase
{
  protected static final String TAG = "TMAssistantDownloadOpenSDKClient";
  ArrayList<IAssistantOnActionListener> mListeners;
  protected boolean retryBindResult;
  protected int retryCount;
  
  public TMAssistantDownloadOpenSDKClient(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext, paramString1, paramString2);
    AppMethodBeat.i(75623);
    this.retryBindResult = false;
    this.retryCount = 0;
    this.mListeners = new ArrayList();
    this.mServiceCallback = new b.a()
    {
      public void onActionResult(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(75621);
        TMLog.i("TMAssistantDownloadOpenSDKClient", "onActionResult  callBack data:" + paramAnonymousArrayOfByte + "  mListeners.size:" + TMAssistantDownloadOpenSDKClient.this.mListeners.size());
        TMAssistantDownloadSDKMessageThread.getInstance().postActionResult(paramAnonymousArrayOfByte, TMAssistantDownloadOpenSDKClient.this.mListeners);
        AppMethodBeat.o(75621);
      }
    };
    AppMethodBeat.o(75623);
  }
  
  public static String about()
  {
    return "TMAssistantDownloadOpenSDKClient_2014_03_06_11_20_release_25634";
  }
  
  public void addAssistantOnActionListener(IAssistantOnActionListener paramIAssistantOnActionListener)
  {
    AppMethodBeat.i(75626);
    TMLog.i("TMAssistantDownloadOpenSDKClient", "addAssistantOnActionListener");
    if ((paramIAssistantOnActionListener != null) && (!this.mListeners.contains(paramIAssistantOnActionListener))) {
      this.mListeners.add(paramIAssistantOnActionListener);
    }
    AppMethodBeat.o(75626);
  }
  
  protected Intent getBindServiceIntent()
  {
    AppMethodBeat.i(75630);
    Intent localIntent = new Intent(this.mDwonloadServiceName);
    localIntent.setPackage("com.tencent.android.qqdownloader");
    AppMethodBeat.o(75630);
    return localIntent;
  }
  
  /* Error */
  public boolean initTMAssistantDownloadSDK()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 94
    //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokespecial 96	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:initTMAssistantDownloadSDK	()Z
    //   11: istore_1
    //   12: ldc 12
    //   14: ldc 98
    //   16: iload_1
    //   17: invokestatic 104	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   20: invokevirtual 108	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   23: invokestatic 65	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: iload_1
    //   27: ifne +78 -> 105
    //   30: new 77	android/content/Intent
    //   33: dup
    //   34: invokespecial 109	android/content/Intent:<init>	()V
    //   37: astore_2
    //   38: aload_2
    //   39: ldc 85
    //   41: ldc 111
    //   43: invokevirtual 115	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   46: pop
    //   47: aload_2
    //   48: ldc 116
    //   50: invokevirtual 120	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   53: pop
    //   54: aload_0
    //   55: getfield 124	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadOpenSDKClient:mContext	Landroid/content/Context;
    //   58: aload_2
    //   59: invokevirtual 130	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   62: new 132	android/os/HandlerThread
    //   65: dup
    //   66: ldc 134
    //   68: invokespecial 135	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   71: astore_2
    //   72: aload_2
    //   73: invokevirtual 138	android/os/HandlerThread:start	()V
    //   76: new 140	android/os/Handler
    //   79: dup
    //   80: aload_2
    //   81: invokevirtual 144	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   84: invokespecial 147	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   87: astore_2
    //   88: aload_2
    //   89: new 8	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadOpenSDKClient$2
    //   92: dup
    //   93: aload_0
    //   94: aload_2
    //   95: invokespecial 150	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadOpenSDKClient$2:<init>	(Lcom/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadOpenSDKClient;Landroid/os/Handler;)V
    //   98: ldc2_w 151
    //   101: invokevirtual 156	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   104: pop
    //   105: ldc 94
    //   107: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aload_0
    //   111: monitorexit
    //   112: iload_1
    //   113: ireturn
    //   114: astore_2
    //   115: ldc 12
    //   117: new 158	java/lang/StringBuilder
    //   120: dup
    //   121: ldc 160
    //   123: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   126: aload_2
    //   127: invokevirtual 164	java/lang/Exception:toString	()Ljava/lang/String;
    //   130: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 172	com/tencent/tmassistantsdk/util/TMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: goto -77 -> 62
    //   142: astore_2
    //   143: aload_0
    //   144: monitorexit
    //   145: aload_2
    //   146: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	TMAssistantDownloadOpenSDKClient
    //   11	102	1	bool	boolean
    //   37	58	2	localObject1	Object
    //   114	13	2	localException	Exception
    //   142	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   30	62	114	java/lang/Exception
    //   2	26	142	finally
    //   30	62	142	finally
    //   62	105	142	finally
    //   105	110	142	finally
    //   115	139	142	finally
  }
  
  protected void onDownloadSDKServiceInvalid()
  {
    AppMethodBeat.i(75627);
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
    AppMethodBeat.o(75627);
  }
  
  protected void registerServiceCallback()
  {
    AppMethodBeat.i(75629);
    Object localObject = String.valueOf(System.currentTimeMillis()).getBytes();
    localObject = Base64.encodeToString(new Cryptor().encrypt((byte[])localObject, this.mClientKey.getBytes()), 0);
    int i = ((a)this.mServiceInterface).a(this.mClientKey, (String)localObject, (b)this.mServiceCallback);
    TMLog.i("TMAssistantDownloadOpenSDKClient", "onServiceConnected,registerActionCallback:" + this.mClientKey + ",tokenString:" + (String)localObject + ",threadId:" + Thread.currentThread().getId() + ",mServiceCallback:" + this.mServiceCallback + ",registed result:" + i);
    if (i == 2) {
      onDownloadSDKServiceInvalid();
    }
    AppMethodBeat.o(75629);
  }
  
  public void sendAsyncData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(75625);
    if (!TextUtils.isEmpty(this.mClientKey))
    {
      a locala = (a)super.getServiceInterface();
      if (locala != null) {
        locala.d(this.mClientKey, paramArrayOfByte);
      }
    }
    AppMethodBeat.o(75625);
  }
  
  public byte[] sendSyncData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(75624);
    if (!TextUtils.isEmpty(this.mClientKey))
    {
      a locala = (a)super.getServiceInterface();
      if (locala != null)
      {
        paramArrayOfByte = locala.c(this.mClientKey, paramArrayOfByte);
        AppMethodBeat.o(75624);
        return paramArrayOfByte;
      }
    }
    AppMethodBeat.o(75624);
    return null;
  }
  
  protected void stubAsInterface(IBinder paramIBinder)
  {
    AppMethodBeat.i(75628);
    this.mServiceInterface = a.a.j(paramIBinder);
    AppMethodBeat.o(75628);
  }
  
  protected void unRegisterServiceCallback()
  {
    AppMethodBeat.i(75631);
    if (((a)this.mServiceInterface).a((b)this.mServiceCallback) == 2) {
      onDownloadSDKServiceInvalid();
    }
    AppMethodBeat.o(75631);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadOpenSDKClient
 * JD-Core Version:    0.7.0.1
 */