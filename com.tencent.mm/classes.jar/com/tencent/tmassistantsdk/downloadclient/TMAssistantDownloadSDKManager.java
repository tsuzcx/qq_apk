package com.tencent.tmassistantsdk.downloadclient;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class TMAssistantDownloadSDKManager
{
  protected static TMAssistantDownloadSDKManager mInstance;
  protected static ArrayList<TMAssistantDownloadOpenSDKClient> mOpenSDKClientList;
  protected static ArrayList<TMAssistantDownloadSDKClient> mSDKClientList;
  protected static TMAssistantDownloadSDKSettingClient mSDKSettingClient;
  protected Context mContext = null;
  
  static
  {
    AppMethodBeat.i(101902);
    mInstance = null;
    mSDKClientList = new ArrayList();
    mSDKSettingClient = null;
    mOpenSDKClientList = new ArrayList();
    AppMethodBeat.o(101902);
  }
  
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
        AppMethodBeat.i(101901);
        TMLog.i("TMAssistantDownloadSDKManager", "closeAllService method!");
        if (mInstance == null)
        {
          TMLog.i("TMAssistantDownloadSDKManager", "manager minstance == null");
          AppMethodBeat.o(101901);
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
      AppMethodBeat.o(101901);
    }
  }
  
  public static TMAssistantDownloadSDKManager getInstance(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(101896);
      if (mInstance == null) {
        mInstance = new TMAssistantDownloadSDKManager(paramContext);
      }
      paramContext = mInstance;
      AppMethodBeat.o(101896);
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
        AppMethodBeat.i(101899);
        Iterator localIterator = mOpenSDKClientList.iterator();
        if (localIterator.hasNext())
        {
          TMAssistantDownloadOpenSDKClient localTMAssistantDownloadOpenSDKClient = (TMAssistantDownloadOpenSDKClient)localIterator.next();
          if (localTMAssistantDownloadOpenSDKClient.mClientKey.equals(paramString) != true) {
            continue;
          }
          AppMethodBeat.o(101899);
          paramString = localTMAssistantDownloadOpenSDKClient;
          return paramString;
        }
        paramString = new TMAssistantDownloadOpenSDKClient(this.mContext, paramString, "com.tencent.android.qqdownloader.SDKService");
        if (paramString.initTMAssistantDownloadSDK())
        {
          mOpenSDKClientList.add(paramString);
          AppMethodBeat.o(101899);
          continue;
        }
        paramString = null;
      }
      finally {}
      AppMethodBeat.o(101899);
    }
  }
  
  public TMAssistantDownloadSDKClient getDownloadSDKClient(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(101897);
        if ((paramString == null) || (paramString.length() <= 0))
        {
          paramString = null;
          AppMethodBeat.o(101897);
          return paramString;
        }
        Iterator localIterator = mSDKClientList.iterator();
        if (localIterator.hasNext())
        {
          TMAssistantDownloadSDKClient localTMAssistantDownloadSDKClient = (TMAssistantDownloadSDKClient)localIterator.next();
          if (localTMAssistantDownloadSDKClient.mClientKey.equals(paramString) != true) {
            continue;
          }
          AppMethodBeat.o(101897);
          paramString = localTMAssistantDownloadSDKClient;
          continue;
        }
        paramString = new TMAssistantDownloadSDKClient(this.mContext, paramString);
      }
      finally {}
      paramString.initTMAssistantDownloadSDK();
      mSDKClientList.add(paramString);
      AppMethodBeat.o(101897);
    }
  }
  
  public TMAssistantDownloadSDKSettingClient getDownloadSDKSettingClient()
  {
    try
    {
      AppMethodBeat.i(101898);
      if (mSDKSettingClient == null)
      {
        localTMAssistantDownloadSDKSettingClient = new TMAssistantDownloadSDKSettingClient(this.mContext, "TMAssistantDownloadSDKManager");
        mSDKSettingClient = localTMAssistantDownloadSDKSettingClient;
        localTMAssistantDownloadSDKSettingClient.initTMAssistantDownloadSDK();
      }
      TMAssistantDownloadSDKSettingClient localTMAssistantDownloadSDKSettingClient = mSDKSettingClient;
      AppMethodBeat.o(101898);
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
    //   2: ldc 141
    //   4: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: getstatic 33	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKManager:mSDKClientList	Ljava/util/ArrayList;
    //   10: invokevirtual 70	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   13: astore_3
    //   14: aload_3
    //   15: invokeinterface 76 1 0
    //   20: ifeq +54 -> 74
    //   23: aload_3
    //   24: invokeinterface 80 1 0
    //   29: checkcast 82	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClient
    //   32: astore 4
    //   34: aload 4
    //   36: ifnull -22 -> 14
    //   39: aload 4
    //   41: getfield 129	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClient:mClientKey	Ljava/lang/String;
    //   44: aload_1
    //   45: invokevirtual 111	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   48: iconst_1
    //   49: if_icmpne -35 -> 14
    //   52: aload 4
    //   54: invokevirtual 85	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClient:unInitTMAssistantDownloadSDK	()V
    //   57: aload_3
    //   58: invokeinterface 144 1 0
    //   63: ldc 141
    //   65: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: iconst_1
    //   69: istore_2
    //   70: aload_0
    //   71: monitorexit
    //   72: iload_2
    //   73: ireturn
    //   74: getstatic 35	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKManager:mSDKSettingClient	Lcom/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKSettingClient;
    //   77: ifnull +37 -> 114
    //   80: getstatic 35	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKManager:mSDKSettingClient	Lcom/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKSettingClient;
    //   83: getfield 145	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKSettingClient:mClientKey	Ljava/lang/String;
    //   86: aload_1
    //   87: invokevirtual 111	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   90: iconst_1
    //   91: if_icmpne +23 -> 114
    //   94: getstatic 35	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKManager:mSDKSettingClient	Lcom/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKSettingClient;
    //   97: invokevirtual 91	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKSettingClient:unInitTMAssistantDownloadSDK	()V
    //   100: aconst_null
    //   101: putstatic 35	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKManager:mSDKSettingClient	Lcom/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKSettingClient;
    //   104: ldc 141
    //   106: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: iconst_1
    //   110: istore_2
    //   111: goto -41 -> 70
    //   114: iconst_0
    //   115: istore_2
    //   116: ldc 141
    //   118: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: goto -51 -> 70
    //   124: astore_1
    //   125: aload_0
    //   126: monitorexit
    //   127: aload_1
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	TMAssistantDownloadSDKManager
    //   0	129	1	paramString	String
    //   69	47	2	bool	boolean
    //   13	45	3	localIterator	Iterator
    //   32	21	4	localTMAssistantDownloadSDKClient	TMAssistantDownloadSDKClient
    // Exception table:
    //   from	to	target	type
    //   2	14	124	finally
    //   14	34	124	finally
    //   39	68	124	finally
    //   74	109	124	finally
    //   116	121	124	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKManager
 * JD-Core Version:    0.7.0.1
 */