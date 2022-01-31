package com.tencent.tmassistantsdk.downloadclient;

import android.content.Context;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class TMAssistantDownloadSDKManager
{
  protected static TMAssistantDownloadSDKManager mInstance = null;
  protected static ArrayList<TMAssistantDownloadOpenSDKClient> mOpenSDKClientList = new ArrayList();
  protected static ArrayList<TMAssistantDownloadSDKClient> mSDKClientList = new ArrayList();
  protected static TMAssistantDownloadSDKSettingClient mSDKSettingClient = null;
  protected Context mContext = null;
  
  protected TMAssistantDownloadSDKManager(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static String about()
  {
    return "TMAssistantDownloadSDKManager_2014_03_04_17_55_release_25406";
  }
  
  public static void closeAllService(Context paramContext)
  {
    for (;;)
    {
      try
      {
        TMLog.i("TMAssistantDownloadSDKManager", "closeAllService method!");
        if (mInstance == null)
        {
          TMLog.i("TMAssistantDownloadSDKManager", "manager minstance == null");
          return;
        }
        if ((mSDKClientList != null) && (mSDKClientList.size() > 0))
        {
          paramContext = mSDKClientList.iterator();
          if (paramContext.hasNext())
          {
            TMAssistantDownloadSDKClient localTMAssistantDownloadSDKClient = (TMAssistantDownloadSDKClient)paramContext.next();
            if (localTMAssistantDownloadSDKClient == null) {
              continue;
            }
            localTMAssistantDownloadSDKClient.unInitTMAssistantDownloadSDK();
            continue;
          }
          mSDKClientList.clear();
        }
      }
      finally {}
      if (mSDKSettingClient != null)
      {
        mSDKSettingClient.unInitTMAssistantDownloadSDK();
        mSDKSettingClient = null;
      }
      mInstance = null;
    }
  }
  
  public static TMAssistantDownloadSDKManager getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null) {
        mInstance = new TMAssistantDownloadSDKManager(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  public TMAssistantDownloadOpenSDKClient getDownloadOpenSDKClient(String paramString)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = mOpenSDKClientList.iterator();
        if (localIterator.hasNext())
        {
          TMAssistantDownloadOpenSDKClient localTMAssistantDownloadOpenSDKClient = (TMAssistantDownloadOpenSDKClient)localIterator.next();
          boolean bool = localTMAssistantDownloadOpenSDKClient.mClientKey.equals(paramString);
          if (bool == true)
          {
            paramString = localTMAssistantDownloadOpenSDKClient;
            return paramString;
          }
        }
        else
        {
          paramString = new TMAssistantDownloadOpenSDKClient(this.mContext, paramString, "com.tencent.android.qqdownloader.SDKService");
          if (paramString.initTMAssistantDownloadSDK()) {
            mOpenSDKClientList.add(paramString);
          } else {
            paramString = null;
          }
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public TMAssistantDownloadSDKClient getDownloadSDKClient(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +12 -> 15
    //   6: aload_1
    //   7: invokevirtual 115	java/lang/String:length	()I
    //   10: istore_2
    //   11: iload_2
    //   12: ifgt +9 -> 21
    //   15: aconst_null
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: getstatic 26	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKManager:mSDKClientList	Ljava/util/ArrayList;
    //   24: invokevirtual 60	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   27: astore 4
    //   29: aload 4
    //   31: invokeinterface 66 1 0
    //   36: ifeq +31 -> 67
    //   39: aload 4
    //   41: invokeinterface 70 1 0
    //   46: checkcast 72	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClient
    //   49: astore_3
    //   50: aload_3
    //   51: getfield 116	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClient:mClientKey	Ljava/lang/String;
    //   54: aload_1
    //   55: invokevirtual 99	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: iconst_1
    //   59: if_icmpne -30 -> 29
    //   62: aload_3
    //   63: astore_1
    //   64: goto -47 -> 17
    //   67: new 72	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClient
    //   70: dup
    //   71: aload_0
    //   72: getfield 35	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKManager:mContext	Landroid/content/Context;
    //   75: aload_1
    //   76: invokespecial 119	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClient:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   79: astore_1
    //   80: aload_1
    //   81: invokevirtual 120	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClient:initTMAssistantDownloadSDK	()Z
    //   84: pop
    //   85: getstatic 26	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKManager:mSDKClientList	Ljava/util/ArrayList;
    //   88: aload_1
    //   89: invokevirtual 110	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   92: pop
    //   93: goto -76 -> 17
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	TMAssistantDownloadSDKManager
    //   0	101	1	paramString	String
    //   10	2	2	i	int
    //   49	14	3	localTMAssistantDownloadSDKClient	TMAssistantDownloadSDKClient
    //   27	13	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   6	11	96	finally
    //   21	29	96	finally
    //   29	62	96	finally
    //   67	93	96	finally
  }
  
  public TMAssistantDownloadSDKSettingClient getDownloadSDKSettingClient()
  {
    try
    {
      if (mSDKSettingClient == null)
      {
        localTMAssistantDownloadSDKSettingClient = new TMAssistantDownloadSDKSettingClient(this.mContext, "TMAssistantDownloadSDKManager");
        mSDKSettingClient = localTMAssistantDownloadSDKSettingClient;
        localTMAssistantDownloadSDKSettingClient.initTMAssistantDownloadSDK();
      }
      TMAssistantDownloadSDKSettingClient localTMAssistantDownloadSDKSettingClient = mSDKSettingClient;
      return localTMAssistantDownloadSDKSettingClient;
    }
    finally {}
  }
  
  /* Error */
  public boolean releaseDownloadSDKClient(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 26	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKManager:mSDKClientList	Ljava/util/ArrayList;
    //   5: invokevirtual 60	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   8: astore_3
    //   9: aload_3
    //   10: invokeinterface 66 1 0
    //   15: ifeq +49 -> 64
    //   18: aload_3
    //   19: invokeinterface 70 1 0
    //   24: checkcast 72	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClient
    //   27: astore 4
    //   29: aload 4
    //   31: ifnull -22 -> 9
    //   34: aload 4
    //   36: getfield 116	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClient:mClientKey	Ljava/lang/String;
    //   39: aload_1
    //   40: invokevirtual 99	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   43: iconst_1
    //   44: if_icmpne -35 -> 9
    //   47: aload 4
    //   49: invokevirtual 75	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClient:unInitTMAssistantDownloadSDK	()V
    //   52: aload_3
    //   53: invokeinterface 129 1 0
    //   58: iconst_1
    //   59: istore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: iload_2
    //   63: ireturn
    //   64: getstatic 28	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKManager:mSDKSettingClient	Lcom/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKSettingClient;
    //   67: ifnull +32 -> 99
    //   70: getstatic 28	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKManager:mSDKSettingClient	Lcom/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKSettingClient;
    //   73: getfield 130	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKSettingClient:mClientKey	Ljava/lang/String;
    //   76: aload_1
    //   77: invokevirtual 99	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   80: iconst_1
    //   81: if_icmpne +18 -> 99
    //   84: getstatic 28	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKManager:mSDKSettingClient	Lcom/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKSettingClient;
    //   87: invokevirtual 81	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKSettingClient:unInitTMAssistantDownloadSDK	()V
    //   90: aconst_null
    //   91: putstatic 28	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKManager:mSDKSettingClient	Lcom/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKSettingClient;
    //   94: iconst_1
    //   95: istore_2
    //   96: goto -36 -> 60
    //   99: iconst_0
    //   100: istore_2
    //   101: goto -41 -> 60
    //   104: astore_1
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_1
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	TMAssistantDownloadSDKManager
    //   0	109	1	paramString	String
    //   59	42	2	bool	boolean
    //   8	45	3	localIterator	Iterator
    //   27	21	4	localTMAssistantDownloadSDKClient	TMAssistantDownloadSDKClient
    // Exception table:
    //   from	to	target	type
    //   2	9	104	finally
    //   9	29	104	finally
    //   34	58	104	finally
    //   64	94	104	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKManager
 * JD-Core Version:    0.7.0.1
 */