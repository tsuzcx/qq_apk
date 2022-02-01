package com.tencent.thumbplayer.core.downloadproxy.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl.Stub;
import com.tencent.thumbplayer.core.downloadproxy.client.TPDownloadProxyClient;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
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
    AppMethodBeat.i(228170);
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
        AppMethodBeat.i(228069);
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
        finally
        {
          TPDLProxyLog.i("TPDownloadProxyFactory", 0, "tpdlnative", "onServiceConnected failed, error:" + paramAnonymousComponentName.toString());
          TPDLProxyLog.i("TPDownloadProxyFactory", 0, "tpdlnative", "on service connected!");
          if (TPDownloadProxyFactory.downloadProxyFactoryAidl == null)
          {
            TPDLProxyLog.i("TPDownloadProxyFactory", 0, "tpdlnative", "on service connected, aidl is null!");
            AppMethodBeat.o(228069);
            return;
          }
          TPDLProxyLog.i("TPDownloadProxyFactory", 0, "tpdlnative", "on service connected, aidl not null!");
          TPDownloadProxyFactory.access$200(true);
          if (TPDownloadProxyFactory.mCallback != null) {
            TPDownloadProxyFactory.mCallback.onBindSuccess();
          }
          AppMethodBeat.o(228069);
        }
      }
      
      public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        AppMethodBeat.i(228078);
        TPDLProxyLog.i("TPDownloadProxyFactory", 0, "tpdlnative", "on service disconnected");
        TPDownloadProxyFactory.access$002(null);
        TPDownloadProxyFactory.access$200(false);
        TPDownloadProxyFactory.ensurePlayManagerService(TPDownloadProxyFactory.mCallback);
        AppMethodBeat.o(228078);
      }
    };
    AppMethodBeat.o(228170);
  }
  
  public static boolean canUseService()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(228127);
        if (!mUseService)
        {
          AppMethodBeat.o(228127);
          return bool;
        }
        if (!mCanUseAIDL)
        {
          AppMethodBeat.o(228127);
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
          AppMethodBeat.o(228127);
          continue;
        }
        finally {}
        localObject1 = finally;
      }
      AppMethodBeat.o(228127);
      bool = false;
    }
  }
  
  /* Error */
  public static boolean ensurePlayManagerService(TPDLProxyBindServiceCallback paramTPDLProxyBindServiceCallback)
  {
    // Byte code:
    //   0: ldc 116
    //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 122	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxyHelper:getContext	()Landroid/content/Context;
    //   8: astore_1
    //   9: aload_1
    //   10: ifnonnull +20 -> 30
    //   13: ldc 10
    //   15: iconst_0
    //   16: ldc 89
    //   18: ldc 124
    //   20: invokestatic 126	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   23: ldc 116
    //   25: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: iconst_0
    //   29: ireturn
    //   30: aload_0
    //   31: putstatic 56	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxyFactory:mCallback	Lcom/tencent/thumbplayer/core/downloadproxy/api/TPDLProxyBindServiceCallback;
    //   34: new 91	java/lang/StringBuilder
    //   37: dup
    //   38: ldc 128
    //   40: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   43: astore_2
    //   44: aload_1
    //   45: ifnonnull +68 -> 113
    //   48: ldc 130
    //   50: astore_0
    //   51: ldc 10
    //   53: iconst_0
    //   54: ldc 89
    //   56: aload_2
    //   57: aload_0
    //   58: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 126	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   67: new 132	android/content/Intent
    //   70: dup
    //   71: aload_1
    //   72: ldc 134
    //   74: invokespecial 137	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   77: astore_0
    //   78: aload_1
    //   79: aload_0
    //   80: invokevirtual 143	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   83: pop
    //   84: aload_1
    //   85: aload_0
    //   86: getstatic 59	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxyFactory:mConnection	Landroid/content/ServiceConnection;
    //   89: iconst_1
    //   90: invokevirtual 147	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   93: ifne +13 -> 106
    //   96: ldc 10
    //   98: iconst_0
    //   99: ldc 89
    //   101: ldc 149
    //   103: invokestatic 113	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   106: ldc 116
    //   108: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: iconst_1
    //   112: ireturn
    //   113: ldc 151
    //   115: astore_0
    //   116: goto -65 -> 51
    //   119: astore_0
    //   120: ldc 10
    //   122: iconst_0
    //   123: ldc 89
    //   125: new 91	java/lang/StringBuilder
    //   128: dup
    //   129: ldc 153
    //   131: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   134: aload_0
    //   135: invokevirtual 102	java/lang/Throwable:toString	()Ljava/lang/String;
    //   138: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 113	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   147: ldc 116
    //   149: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: iconst_0
    //   153: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	paramTPDLProxyBindServiceCallback	TPDLProxyBindServiceCallback
    //   8	77	1	localContext	android.content.Context
    //   43	14	2	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   67	106	119	finally
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
    AppMethodBeat.i(228134);
    String str1;
    if (!mUseService)
    {
      str1 = TPDownloadProxyNative.getInstance().getNativeVersion();
      AppMethodBeat.o(228134);
      return str1;
    }
    if (!mCanUseAIDL)
    {
      str1 = TPDownloadProxyNative.getInstance().getNativeVersion();
      AppMethodBeat.o(228134);
      return str1;
    }
    if (downloadProxyFactoryAidl != null) {
      try
      {
        str1 = downloadProxyFactoryAidl.getNativeVersion();
        AppMethodBeat.o(228134);
        return str1;
      }
      finally
      {
        TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", "getNativeVersion failed, error:" + localObject.toString());
      }
    }
    String str2 = TPDownloadProxyNative.getInstance().getNativeVersion();
    AppMethodBeat.o(228134);
    return str2;
  }
  
  public static ITPDownloadProxy getTPDownloadProxy(int paramInt)
  {
    AppMethodBeat.i(228068);
    if (paramInt <= 0)
    {
      TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", "getTPDownloadProxy is invalid, serviceType:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(228068);
      return null;
    }
    if (mUseService)
    {
      if (mCanUseAIDL) {
        try
        {
          ITPDownloadProxy localITPDownloadProxy1 = getTPDownloadProxyService(paramInt);
          AppMethodBeat.o(228068);
          return localITPDownloadProxy1;
        }
        finally
        {
          TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", "getTPDownloadProxy failed, error:" + localObject1.toString());
          AppMethodBeat.o(228068);
          return null;
        }
      }
      TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", "getTPDownloadProxy failed, can't use aidl!");
      AppMethodBeat.o(228068);
      return null;
    }
    synchronized (mMapObject)
    {
      ITPDownloadProxy localITPDownloadProxy2 = (ITPDownloadProxy)mvTPDownloadProxyMap.get(Integer.valueOf(paramInt));
      Object localObject2 = localITPDownloadProxy2;
      if (localITPDownloadProxy2 == null)
      {
        localObject2 = new TPDownloadProxy(paramInt);
        mvTPDownloadProxyMap.put(Integer.valueOf(paramInt), localObject2);
      }
      AppMethodBeat.o(228068);
      return localObject2;
    }
  }
  
  private static ITPDownloadProxy getTPDownloadProxyService(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(228080);
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
              AppMethodBeat.o(228080);
              return localTPDownloadProxyClient1;
            }
            finally
            {
              localObject1 = finally;
              TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", "getTPDownloadProxyService failed, error:" + localObject1.toString());
              TPDownloadProxyClient localTPDownloadProxyClient2 = localTPDownloadProxyClient3;
              continue;
            }
          }
        }
        TPDLProxyLog.e("TPDownloadProxyFactory", 0, "tpdlnative", "getTPDownloadProxyService failed, aidl is null!");
      }
      finally {}
      Object localObject4 = null;
      AppMethodBeat.o(228080);
    }
  }
  
  public static boolean getUseService()
  {
    return mUseService;
  }
  
  /* Error */
  public static boolean isReadyForDownload()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iconst_0
    //   3: istore_0
    //   4: ldc 2
    //   6: monitorenter
    //   7: ldc 224
    //   9: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: getstatic 50	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxyFactory:mUseService	Z
    //   15: ifne +43 -> 58
    //   18: ldc 10
    //   20: iconst_0
    //   21: ldc 89
    //   23: new 91	java/lang/StringBuilder
    //   26: dup
    //   27: ldc 226
    //   29: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   32: getstatic 54	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxyFactory:mIsReadyForDownload	Z
    //   35: invokevirtual 229	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   38: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 126	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   44: getstatic 54	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxyFactory:mIsReadyForDownload	Z
    //   47: istore_0
    //   48: ldc 224
    //   50: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: ldc 2
    //   55: monitorexit
    //   56: iload_0
    //   57: ireturn
    //   58: getstatic 52	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxyFactory:mCanUseAIDL	Z
    //   61: ifne +17 -> 78
    //   64: ldc 224
    //   66: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: goto -16 -> 53
    //   72: astore_2
    //   73: ldc 2
    //   75: monitorexit
    //   76: aload_2
    //   77: athrow
    //   78: getstatic 67	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxyFactory:downloadProxyFactoryAidl	Lcom/tencent/thumbplayer/core/downloadproxy/aidl/TPDownloadProxyFactoryAidl;
    //   81: astore_2
    //   82: iload_1
    //   83: istore_0
    //   84: aload_2
    //   85: ifnull +12 -> 97
    //   88: getstatic 67	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxyFactory:downloadProxyFactoryAidl	Lcom/tencent/thumbplayer/core/downloadproxy/aidl/TPDownloadProxyFactoryAidl;
    //   91: invokeinterface 231 1 0
    //   96: istore_0
    //   97: ldc 224
    //   99: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: goto -49 -> 53
    //   105: astore_2
    //   106: ldc 10
    //   108: iconst_0
    //   109: ldc 89
    //   111: new 91	java/lang/StringBuilder
    //   114: dup
    //   115: ldc 233
    //   117: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   120: aload_2
    //   121: invokevirtual 102	java/lang/Throwable:toString	()Ljava/lang/String;
    //   124: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 113	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   133: iload_1
    //   134: istore_0
    //   135: goto -38 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	132	0	bool1	boolean
    //   1	133	1	bool2	boolean
    //   72	5	2	localObject1	Object
    //   81	4	2	localTPDownloadProxyFactoryAidl	TPDownloadProxyFactoryAidl
    //   105	16	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	53	72	finally
    //   58	69	72	finally
    //   78	82	72	finally
    //   97	102	72	finally
    //   106	133	72	finally
    //   88	97	105	finally
  }
  
  /* Error */
  public static boolean isReadyForPlay()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iconst_0
    //   3: istore_0
    //   4: ldc 2
    //   6: monitorenter
    //   7: ldc 234
    //   9: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: getstatic 50	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxyFactory:mUseService	Z
    //   15: ifne +37 -> 52
    //   18: invokestatic 162	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:getInstance	()Lcom/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative;
    //   21: invokevirtual 237	com/tencent/thumbplayer/core/downloadproxy/jni/TPDownloadProxyNative:isReadyForWork	()Z
    //   24: istore_0
    //   25: ldc 10
    //   27: iconst_0
    //   28: ldc 89
    //   30: ldc 239
    //   32: iload_0
    //   33: invokestatic 242	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   36: invokevirtual 182	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   39: invokestatic 126	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   42: ldc 234
    //   44: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: ldc 2
    //   49: monitorexit
    //   50: iload_0
    //   51: ireturn
    //   52: getstatic 52	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxyFactory:mCanUseAIDL	Z
    //   55: ifne +17 -> 72
    //   58: ldc 234
    //   60: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: goto -16 -> 47
    //   66: astore_2
    //   67: ldc 2
    //   69: monitorexit
    //   70: aload_2
    //   71: athrow
    //   72: getstatic 67	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxyFactory:downloadProxyFactoryAidl	Lcom/tencent/thumbplayer/core/downloadproxy/aidl/TPDownloadProxyFactoryAidl;
    //   75: astore_2
    //   76: iload_1
    //   77: istore_0
    //   78: aload_2
    //   79: ifnull +12 -> 91
    //   82: getstatic 67	com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxyFactory:downloadProxyFactoryAidl	Lcom/tencent/thumbplayer/core/downloadproxy/aidl/TPDownloadProxyFactoryAidl;
    //   85: invokeinterface 87 1 0
    //   90: istore_0
    //   91: ldc 234
    //   93: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: goto -49 -> 47
    //   99: astore_2
    //   100: ldc 10
    //   102: iconst_0
    //   103: ldc 89
    //   105: new 91	java/lang/StringBuilder
    //   108: dup
    //   109: ldc 244
    //   111: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   114: aload_2
    //   115: invokevirtual 102	java/lang/Throwable:toString	()Ljava/lang/String;
    //   118: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 113	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   127: iload_1
    //   128: istore_0
    //   129: goto -38 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	126	0	bool1	boolean
    //   1	127	1	bool2	boolean
    //   66	5	2	localObject1	Object
    //   75	4	2	localTPDownloadProxyFactoryAidl	TPDownloadProxyFactoryAidl
    //   99	16	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	47	66	finally
    //   52	63	66	finally
    //   72	76	66	finally
    //   91	96	66	finally
    //   100	127	66	finally
    //   82	91	99	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory
 * JD-Core Version:    0.7.0.1
 */