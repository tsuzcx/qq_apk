package com.tencent.tmassistantsdk.downloadclient;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.a.a.a.a;
import com.tencent.a.a.a.a.a;
import com.tencent.a.a.a.b;
import com.tencent.a.a.a.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.tmassistantsdk.util.Base64;
import com.tencent.tmassistantsdk.util.Cryptor;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class TMAssistantDownloadOpenSDKClient
  extends TMAssistantDownloadSDKClientBase
{
  protected static final String TAG = "TMAssistantDownloadOpenSDKClient";
  private byte _hellAccFlag_;
  ArrayList<IAssistantOnActionListener> mListeners;
  protected boolean retryBindResult;
  protected int retryCount;
  
  public TMAssistantDownloadOpenSDKClient(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext, paramString1, paramString2);
    AppMethodBeat.i(101869);
    this.retryBindResult = false;
    this.retryCount = 0;
    this.mListeners = new ArrayList();
    this.mServiceCallback = new b.a()
    {
      public void onActionResult(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(101867);
        TMLog.i("TMAssistantDownloadOpenSDKClient", "onActionResult  callBack data:" + paramAnonymousArrayOfByte + "  mListeners.size:" + TMAssistantDownloadOpenSDKClient.this.mListeners.size());
        TMAssistantDownloadSDKMessageThread.getInstance().postActionResult(paramAnonymousArrayOfByte, TMAssistantDownloadOpenSDKClient.this.mListeners);
        AppMethodBeat.o(101867);
      }
    };
    AppMethodBeat.o(101869);
  }
  
  public static String about()
  {
    return "TMAssistantDownloadOpenSDKClient_2014_03_06_11_20_release_25634";
  }
  
  public void addAssistantOnActionListener(IAssistantOnActionListener paramIAssistantOnActionListener)
  {
    AppMethodBeat.i(101872);
    TMLog.i("TMAssistantDownloadOpenSDKClient", "addAssistantOnActionListener");
    if ((paramIAssistantOnActionListener != null) && (!this.mListeners.contains(paramIAssistantOnActionListener))) {
      this.mListeners.add(paramIAssistantOnActionListener);
    }
    AppMethodBeat.o(101872);
  }
  
  protected Intent getBindServiceIntent()
  {
    AppMethodBeat.i(101876);
    Intent localIntent = new Intent(this.mDwonloadServiceName);
    localIntent.setPackage("com.tencent.android.qqdownloader");
    AppMethodBeat.o(101876);
    return localIntent;
  }
  
  /* Error */
  public boolean initTMAssistantDownloadSDK()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 96
    //   4: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokespecial 98	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClientBase:initTMAssistantDownloadSDK	()Z
    //   11: istore_1
    //   12: ldc 12
    //   14: ldc 100
    //   16: iload_1
    //   17: invokestatic 106	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   20: invokevirtual 110	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   23: invokestatic 67	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: iload_1
    //   27: ifne +119 -> 146
    //   30: new 79	android/content/Intent
    //   33: dup
    //   34: invokespecial 111	android/content/Intent:<init>	()V
    //   37: astore_3
    //   38: aload_3
    //   39: ldc 87
    //   41: ldc 113
    //   43: invokevirtual 117	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   46: pop
    //   47: aload_3
    //   48: ldc 118
    //   50: invokevirtual 122	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   53: pop
    //   54: aload_0
    //   55: getfield 126	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadOpenSDKClient:mContext	Landroid/content/Context;
    //   58: astore_2
    //   59: new 128	com/tencent/mm/hellhoundlib/b/a
    //   62: dup
    //   63: invokespecial 129	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   66: aload_3
    //   67: invokevirtual 133	com/tencent/mm/hellhoundlib/b/a:bc	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   70: astore_3
    //   71: aload_2
    //   72: aload_3
    //   73: invokevirtual 137	com/tencent/mm/hellhoundlib/b/a:ahE	()[Ljava/lang/Object;
    //   76: ldc 138
    //   78: ldc 139
    //   80: ldc 140
    //   82: ldc 142
    //   84: ldc 144
    //   86: ldc 146
    //   88: invokestatic 152	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload_2
    //   92: aload_3
    //   93: iconst_0
    //   94: invokevirtual 156	com/tencent/mm/hellhoundlib/b/a:mt	(I)Ljava/lang/Object;
    //   97: checkcast 79	android/content/Intent
    //   100: invokevirtual 160	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   103: aload_2
    //   104: ldc 138
    //   106: ldc 139
    //   108: ldc 140
    //   110: ldc 142
    //   112: ldc 144
    //   114: ldc 146
    //   116: invokestatic 163	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   119: new 165	com/tencent/mm/sdk/platformtools/aq
    //   122: dup
    //   123: ldc 167
    //   125: invokespecial 168	com/tencent/mm/sdk/platformtools/aq:<init>	(Ljava/lang/String;)V
    //   128: astore_2
    //   129: aload_2
    //   130: new 8	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadOpenSDKClient$2
    //   133: dup
    //   134: aload_0
    //   135: aload_2
    //   136: invokespecial 171	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadOpenSDKClient$2:<init>	(Lcom/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadOpenSDKClient;Lcom/tencent/mm/sdk/platformtools/aq;)V
    //   139: ldc2_w 172
    //   142: invokevirtual 177	com/tencent/mm/sdk/platformtools/aq:postDelayed	(Ljava/lang/Runnable;J)Z
    //   145: pop
    //   146: ldc 96
    //   148: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: aload_0
    //   152: monitorexit
    //   153: iload_1
    //   154: ireturn
    //   155: astore_2
    //   156: ldc 12
    //   158: new 179	java/lang/StringBuilder
    //   161: dup
    //   162: ldc 181
    //   164: invokespecial 182	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   167: aload_2
    //   168: invokevirtual 185	java/lang/Exception:toString	()Ljava/lang/String;
    //   171: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 193	com/tencent/tmassistantsdk/util/TMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: goto -61 -> 119
    //   183: astore_2
    //   184: aload_0
    //   185: monitorexit
    //   186: aload_2
    //   187: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	TMAssistantDownloadOpenSDKClient
    //   11	143	1	bool	boolean
    //   58	78	2	localObject1	Object
    //   155	13	2	localException	Exception
    //   183	4	2	localObject2	Object
    //   37	56	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   30	119	155	java/lang/Exception
    //   2	26	183	finally
    //   30	119	183	finally
    //   119	146	183	finally
    //   146	151	183	finally
    //   156	180	183	finally
  }
  
  protected void onDownloadSDKServiceInvalid()
  {
    AppMethodBeat.i(101873);
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
    AppMethodBeat.o(101873);
  }
  
  protected void registerServiceCallback()
  {
    AppMethodBeat.i(101875);
    Object localObject = String.valueOf(System.currentTimeMillis()).getBytes();
    localObject = Base64.encodeToString(new Cryptor().encrypt((byte[])localObject, this.mClientKey.getBytes()), 0);
    int i = ((a)this.mServiceInterface).a(this.mClientKey, (String)localObject, (b)this.mServiceCallback);
    TMLog.i("TMAssistantDownloadOpenSDKClient", "onServiceConnected,registerActionCallback:" + this.mClientKey + ",tokenString:" + (String)localObject + ",threadId:" + Thread.currentThread().getId() + ",mServiceCallback:" + this.mServiceCallback + ",registed result:" + i);
    if (i == 2) {
      onDownloadSDKServiceInvalid();
    }
    AppMethodBeat.o(101875);
  }
  
  public void sendAsyncData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(101871);
    if (!TextUtils.isEmpty(this.mClientKey))
    {
      a locala = (a)super.getServiceInterface();
      if (locala != null) {
        locala.c(this.mClientKey, paramArrayOfByte);
      }
    }
    AppMethodBeat.o(101871);
  }
  
  public byte[] sendSyncData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(101870);
    if (!TextUtils.isEmpty(this.mClientKey))
    {
      a locala = (a)super.getServiceInterface();
      if (locala != null)
      {
        paramArrayOfByte = locala.b(this.mClientKey, paramArrayOfByte);
        AppMethodBeat.o(101870);
        return paramArrayOfByte;
      }
    }
    AppMethodBeat.o(101870);
    return null;
  }
  
  protected void stubAsInterface(IBinder paramIBinder)
  {
    AppMethodBeat.i(101874);
    this.mServiceInterface = a.a.k(paramIBinder);
    AppMethodBeat.o(101874);
  }
  
  protected void unRegisterServiceCallback()
  {
    AppMethodBeat.i(101877);
    if (((a)this.mServiceInterface).a((b)this.mServiceCallback) == 2) {
      onDownloadSDKServiceInvalid();
    }
    AppMethodBeat.o(101877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadOpenSDKClient
 * JD-Core Version:    0.7.0.1
 */