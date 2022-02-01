package org.xwalk.core;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a;
import com.tencent.xweb.util.b;
import com.tencent.xweb.util.l;
import com.tencent.xweb.util.m;
import java.io.File;

public class XWalkStandAloneChannel
{
  public static final int INVOKE_CHANNEL_FUNC_ID_LOG = 30002;
  public static final int INVOKE_CHANNEL_FUNC_ID_NATIVE_TRANS = 30003;
  public static final int INVOKE_NOTITY_FUNCTION_ID_IDKEY = 50001;
  public static final int INVOKE_NOTITY_FUNCTION_ID_KVSTAT = 50002;
  public static final String TAG = "XWalkStandAloneChannel";
  private ClassLoader mClassLoader;
  private boolean mHasInited = false;
  private boolean mInitedResult = false;
  
  private boolean checkCoreApk()
  {
    AppMethodBeat.i(187756);
    if (!new File(XWalkFileUtil.getDownloadApkPath(XWalkEnvironment.getAvailableVersion())).exists())
    {
      Log.e("XWalkStandAloneChannel", "checkCoreApk, apk not exists");
      AppMethodBeat.o(187756);
      return false;
    }
    Log.i("XWalkStandAloneChannel", "xwalk core apk matched");
    AppMethodBeat.o(187756);
    return true;
  }
  
  public static XWalkStandAloneChannel getInstance()
  {
    return SingletonHolder.sInstance;
  }
  
  /* Error */
  private boolean initCoreBridge()
  {
    // Byte code:
    //   0: ldc 92
    //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 24
    //   7: ldc 93
    //   9: invokestatic 84	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: ldc 95
    //   15: invokevirtual 99	org/xwalk/core/XWalkStandAloneChannel:getBridgeClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   18: astore_1
    //   19: new 101	org/xwalk/core/ReflectMethod
    //   22: dup
    //   23: aload_1
    //   24: ldc 103
    //   26: iconst_2
    //   27: anewarray 105	java/lang/Class
    //   30: dup
    //   31: iconst_0
    //   32: ldc 107
    //   34: aastore
    //   35: dup
    //   36: iconst_1
    //   37: ldc 4
    //   39: aastore
    //   40: invokespecial 110	org/xwalk/core/ReflectMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   43: iconst_2
    //   44: anewarray 4	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: aconst_null
    //   50: aastore
    //   51: dup
    //   52: iconst_1
    //   53: aload_0
    //   54: aastore
    //   55: invokevirtual 114	org/xwalk/core/ReflectMethod:invoke	([Ljava/lang/Object;)Ljava/lang/Object;
    //   58: pop
    //   59: ldc 92
    //   61: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: iconst_1
    //   65: ireturn
    //   66: astore_2
    //   67: aconst_null
    //   68: astore_1
    //   69: ldc 24
    //   71: ldc 116
    //   73: aload_2
    //   74: invokestatic 122	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   77: invokevirtual 126	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   80: invokestatic 77	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: aload_1
    //   84: ifnonnull +36 -> 120
    //   87: aload_2
    //   88: instanceof 128
    //   91: ifeq +29 -> 120
    //   94: ldc 24
    //   96: ldc 130
    //   98: invokestatic 77	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: invokestatic 57	org/xwalk/core/XWalkEnvironment:getAvailableVersion	()I
    //   104: invokestatic 136	com/tencent/xweb/xwalk/updater/f:aJS	(I)Z
    //   107: pop
    //   108: iconst_m1
    //   109: aconst_null
    //   110: invokestatic 142	com/tencent/xweb/util/b:khw	()Ljava/lang/String;
    //   113: invokestatic 146	org/xwalk/core/XWalkEnvironment:setCoreVersionInfo	(ILjava/lang/String;Ljava/lang/String;)Z
    //   116: pop
    //   117: invokestatic 149	org/xwalk/core/XWalkEnvironment:refreshVersionInfo	()V
    //   120: ldc 92
    //   122: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: iconst_0
    //   126: ireturn
    //   127: astore_2
    //   128: goto -59 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	XWalkStandAloneChannel
    //   18	66	1	localClass	Class
    //   66	22	2	localObject1	Object
    //   127	1	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	19	66	finally
    //   19	59	127	finally
  }
  
  private boolean initLogChannel()
  {
    AppMethodBeat.i(187749);
    int i = XWalkEnvironment.getAvailableVersion();
    if (i < 153)
    {
      Log.w("XWalkStandAloneChannel", "initLogChannel, version(" + i + ") below SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION");
      AppMethodBeat.o(187749);
      return false;
    }
    Log.i("XWalkStandAloneChannel", "initLogChannel start");
    Object localObject2 = new XWalkLogMessageListener()
    {
      private String resetLogTagByFile(String paramAnonymousString)
      {
        AppMethodBeat.i(187693);
        if (paramAnonymousString.contains("/"))
        {
          AppMethodBeat.o(187693);
          return "XWeb.Core";
        }
        AppMethodBeat.o(187693);
        return paramAnonymousString;
      }
      
      public void onLogMessage(int paramAnonymousInt1, String paramAnonymousString1, int paramAnonymousInt2, String paramAnonymousString2)
      {
        AppMethodBeat.i(187697);
        Log.i(resetLogTagByFile(paramAnonymousString1), paramAnonymousString2);
        AppMethodBeat.o(187697);
      }
    };
    try
    {
      Class localClass = getBridgeClass("XWalkViewDelegate");
      localObject2 = ((XWalkLogMessageListener)localObject2).getBridge();
      new ReflectMethod(localClass, "setLogCallBack", new Class[] { Object.class }).invoke(new Object[] { localObject2 });
      AppMethodBeat.o(187749);
      return true;
    }
    finally
    {
      Log.e("XWalkStandAloneChannel", "setLogCallBack error:".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(187749);
    }
    return false;
  }
  
  private boolean initNotifyChannel()
  {
    AppMethodBeat.i(187745);
    int i = XWalkEnvironment.getAvailableVersion();
    if (i < 153)
    {
      Log.w("XWalkStandAloneChannel", "initNotifyChannel, version(" + i + ") below SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION");
      AppMethodBeat.o(187745);
      return false;
    }
    Log.i("XWalkStandAloneChannel", "initNotifyChannel start");
    Object localObject2 = new XWalkNotifyChannelListener()
    {
      public void onNotifyCallBackChannel(int paramAnonymousInt, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(187685);
        switch (paramAnonymousInt)
        {
        default: 
        case 50001: 
          try
          {
            Log.i("XWalkStandAloneChannel", "NotifyChannel called funid = " + paramAnonymousInt + " do not match");
            AppMethodBeat.o(187685);
            return;
          }
          catch (RuntimeException paramAnonymousArrayOfObject)
          {
            Log.e("XWalkStandAloneChannel", "NotifyChannel error:".concat(String.valueOf(paramAnonymousArrayOfObject)));
            AppMethodBeat.o(187685);
            return;
          }
          l.y(Long.parseLong((String)paramAnonymousArrayOfObject[0]), Long.parseLong((String)paramAnonymousArrayOfObject[1]), Integer.parseInt((String)paramAnonymousArrayOfObject[2]));
          AppMethodBeat.o(187685);
          return;
        }
        l.ev(Integer.parseInt((String)paramAnonymousArrayOfObject[0]), (String)paramAnonymousArrayOfObject[1]);
        AppMethodBeat.o(187685);
      }
    };
    try
    {
      Class localClass = getBridgeClass("XWalkViewDelegate");
      localObject2 = ((XWalkNotifyChannelListener)localObject2).getBridge();
      new ReflectMethod(localClass, "setNotifyCallBackChannel", new Class[] { Object.class }).invoke(new Object[] { localObject2 });
      AppMethodBeat.o(187745);
      return true;
    }
    finally
    {
      Log.e("XWalkStandAloneChannel", "setNotifyCallBackChannel error:".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(187745);
    }
    return false;
  }
  
  private boolean isSupportStandAloneMode()
  {
    AppMethodBeat.i(187730);
    try
    {
      Object localObject1 = new ReflectMethod(getBridgeClass("XWalkCoreBridge"), "isSupportStandAloneMode", new Class[0]).invoke(new Object[0]);
      if ((localObject1 instanceof Boolean))
      {
        boolean bool = ((Boolean)localObject1).booleanValue();
        AppMethodBeat.o(187730);
        return bool;
      }
    }
    finally
    {
      Log.e("XWalkStandAloneChannel", "isSupportStandAloneMode error:".concat(String.valueOf(localObject2)));
      AppMethodBeat.o(187730);
      return false;
    }
    AppMethodBeat.o(187730);
    return false;
  }
  
  private boolean loadNativeLibrary()
  {
    AppMethodBeat.i(187754);
    long l = System.currentTimeMillis();
    try
    {
      ReflectMethod localReflectMethod = new ReflectMethod(getBridgeClass("XWalkViewDelegate"), "loadXWalkLibrary", new Class[] { Context.class, String.class });
      String str = XWalkFileUtil.getExtractedCoreDir(XWalkEnvironment.getAvailableVersion());
      if (!((Boolean)localReflectMethod.invoke(new Object[] { XWalkEnvironment.getApplicationContext(), str })).booleanValue())
      {
        l.Br(191L);
        l.y(1749L, 56L, 1L);
        Log.e("XWalkStandAloneChannel", "Mismatch of CPU architecture current device abi is " + b.khx() + ", runtime abi is " + b.khw() + ", core detail is " + XWalkEnvironment.getAvailableVersionDetail());
        AppMethodBeat.o(187754);
        return false;
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.e("XWalkStandAloneChannel", "checkCoreArchitecture, error:".concat(String.valueOf(localRuntimeException)));
      Log.e("XWalkStandAloneChannel", "current device abi is " + b.khx() + ", runtime abi is " + b.khw() + ", core detail is " + XWalkEnvironment.getAvailableVersionDetail());
      AppMethodBeat.o(187754);
      return false;
    }
    Log.w("XWalkStandAloneChannel", "###### loadNativeLibrary, costTime:" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(187754);
    return true;
  }
  
  private boolean setStandAloneMode(boolean paramBoolean)
  {
    AppMethodBeat.i(187738);
    try
    {
      new ReflectMethod(getBridgeClass("XWalkCoreBridge"), "setStandAloneMode", new Class[] { Boolean.TYPE }).invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(187738);
      return true;
    }
    finally
    {
      Log.e("XWalkStandAloneChannel", "setStandAloneMode error:".concat(String.valueOf(localObject)));
      AppMethodBeat.o(187738);
    }
    return false;
  }
  
  public void bindNativeTrans(long paramLong)
  {
    AppMethodBeat.i(187778);
    invokeNativeChannel(30003, new String[] { String.valueOf(paramLong) });
    AppMethodBeat.o(187778);
  }
  
  public Class<?> getBridgeClass(String paramString)
  {
    AppMethodBeat.i(187771);
    try
    {
      Object localObject1 = getClassLoader();
      if (localObject1 != null)
      {
        localObject1 = ((ClassLoader)localObject1).loadClass("org.xwalk.core.internal.".concat(String.valueOf(paramString)));
        AppMethodBeat.o(187771);
        return localObject1;
      }
      Log.w("XWalkStandAloneChannel", "getBridgeClass, classloader is null");
    }
    finally
    {
      for (;;)
      {
        Log.w("XWalkStandAloneChannel", "getBridgeClass failed, class:" + paramString + ", error:" + localObject2);
      }
    }
    AppMethodBeat.o(187771);
    return null;
  }
  
  public ClassLoader getClassLoader()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(187768);
        if (this.mClassLoader != null)
        {
          localClassLoader = this.mClassLoader;
          AppMethodBeat.o(187768);
          return localClassLoader;
        }
      }
      finally
      {
        try
        {
          this.mClassLoader = m.kiJ();
          Log.i("XWalkStandAloneChannel", "getClassLoader, classLoader:" + this.mClassLoader);
          ClassLoader localClassLoader = this.mClassLoader;
          AppMethodBeat.o(187768);
          continue;
        }
        finally
        {
          Log.e("XWalkStandAloneChannel", "getClassLoader error:".concat(String.valueOf(localObject2)));
          Object localObject3 = null;
        }
        localObject1 = finally;
      }
    }
  }
  
  public boolean hasFeature(int paramInt)
  {
    AppMethodBeat.i(187774);
    Object localObject = invokeRuntimeChannel(80003, new Object[] { Integer.valueOf(paramInt) });
    if ((localObject instanceof Boolean))
    {
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(187774);
      return bool;
    }
    AppMethodBeat.o(187774);
    return false;
  }
  
  public boolean initChannels(boolean paramBoolean)
  {
    long l;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(187763);
        if (this.mHasInited)
        {
          Log.w("XWalkStandAloneChannel", "initChannels, already inited, result:" + this.mInitedResult);
          paramBoolean = this.mInitedResult;
          AppMethodBeat.o(187763);
          return paramBoolean;
        }
        this.mInitedResult = false;
        l = System.currentTimeMillis();
        int i = XWalkEnvironment.getAvailableVersion();
        XWalkEnvironment.addXWalkInitializeLog("XWalkStandAloneChannel", "initChannels, isStandAloneMode:" + paramBoolean + ", apkVersion:" + i);
        if (paramBoolean)
        {
          l.y(1749L, 59L, 1L);
          if (i == -1)
          {
            l.y(1749L, 49L, 1L);
            AppMethodBeat.o(187763);
            paramBoolean = false;
          }
        }
        else
        {
          l.y(1749L, 61L, 1L);
          continue;
        }
        if (getClassLoader() != null) {
          break label197;
        }
      }
      finally {}
      XWalkEnvironment.addXWalkInitializeLog("XWalkStandAloneChannel", "initChannels, create class loader failed");
      l.y(1749L, 50L, 1L);
      AppMethodBeat.o(187763);
      paramBoolean = false;
      continue;
      label197:
      bool = initCoreBridge();
      XWalkEnvironment.addXWalkInitializeLog("XWalkStandAloneChannel", "initChannels, initCoreBridgeResult:".concat(String.valueOf(bool)));
      if (!bool)
      {
        l.y(1749L, 51L, 1L);
        AppMethodBeat.o(187763);
        paramBoolean = false;
      }
      else if (paramBoolean)
      {
        bool = isSupportStandAloneMode();
        XWalkEnvironment.addXWalkInitializeLog("XWalkStandAloneChannel", "initChannels, isSupportStandAloneMode:".concat(String.valueOf(bool)));
        if (bool)
        {
          bool = setStandAloneMode(true);
          XWalkEnvironment.addXWalkInitializeLog("XWalkStandAloneChannel", "initChannels, setStandAloneModeResult:".concat(String.valueOf(bool)));
          if (bool) {
            break;
          }
          l.y(1749L, 57L, 1L);
          AppMethodBeat.o(187763);
          paramBoolean = false;
        }
        else
        {
          l.y(1749L, 58L, 1L);
          paramBoolean = a.keX().kff();
          XWalkEnvironment.addXWalkInitializeLog("XWalkStandAloneChannel", "initChannels, try runtime:".concat(String.valueOf(paramBoolean)));
          AppMethodBeat.o(187763);
        }
      }
      else
      {
        XWalkEnvironment.addXWalkInitializeLog("XWalkStandAloneChannel", "initChannels, setStandAloneModeResult:".concat(String.valueOf(setStandAloneMode(false))));
        bool = loadNativeLibrary();
        XWalkEnvironment.addXWalkInitializeLog("XWalkStandAloneChannel", "initChannels, loadLibraryResult:".concat(String.valueOf(bool)));
        if ((bool) && (checkCoreApk())) {
          break;
        }
        l.y(1749L, 55L, 1L);
        AppMethodBeat.o(187763);
        paramBoolean = false;
      }
    }
    boolean bool = initNotifyChannel();
    XWalkEnvironment.addXWalkInitializeLog("XWalkStandAloneChannel", "initChannels, initNotifyChannelResult:".concat(String.valueOf(bool)));
    if (!bool) {
      l.y(1749L, 52L, 1L);
    }
    bool = RuntimeToSdkChannel.initRuntimeToSdkChannel();
    XWalkEnvironment.addXWalkInitializeLog("XWalkStandAloneChannel", "initChannels, initRuntimeToSdkChannelResult:".concat(String.valueOf(bool)));
    if (!bool) {
      l.y(1749L, 53L, 1L);
    }
    bool = initLogChannel();
    XWalkEnvironment.addXWalkInitializeLog("XWalkStandAloneChannel", "initChannels, initLogChannelResult:".concat(String.valueOf(bool)));
    if (!bool) {
      l.y(1749L, 54L, 1L);
    }
    this.mHasInited = true;
    this.mInitedResult = true;
    if (paramBoolean) {
      l.y(1749L, 60L, 1L);
    }
    for (;;)
    {
      Log.w("XWalkStandAloneChannel", "###### initChannels, costTime:" + (System.currentTimeMillis() - l));
      paramBoolean = this.mInitedResult;
      AppMethodBeat.o(187763);
      break;
      l.y(1749L, 62L, 1L);
    }
  }
  
  /* Error */
  public boolean invokeNativeChannel(int paramInt, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: ldc_w 431
    //   3: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 57	org/xwalk/core/XWalkEnvironment:getAvailableVersion	()I
    //   9: istore_3
    //   10: iload_3
    //   11: sipush 153
    //   14: if_icmpge +38 -> 52
    //   17: ldc 24
    //   19: new 153	java/lang/StringBuilder
    //   22: dup
    //   23: ldc_w 433
    //   26: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   29: iload_3
    //   30: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   33: ldc 162
    //   35: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 171	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: ldc_w 431
    //   47: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: iconst_0
    //   51: ireturn
    //   52: ldc 24
    //   54: ldc_w 435
    //   57: iload_1
    //   58: invokestatic 437	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   61: invokevirtual 126	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   64: invokestatic 84	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: new 101	org/xwalk/core/ReflectMethod
    //   70: dup
    //   71: aload_0
    //   72: ldc 178
    //   74: invokevirtual 99	org/xwalk/core/XWalkStandAloneChannel:getBridgeClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   77: ldc_w 438
    //   80: iconst_2
    //   81: anewarray 105	java/lang/Class
    //   84: dup
    //   85: iconst_0
    //   86: getstatic 439	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   89: aastore
    //   90: dup
    //   91: iconst_1
    //   92: ldc_w 441
    //   95: aastore
    //   96: invokespecial 110	org/xwalk/core/ReflectMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   99: iconst_2
    //   100: anewarray 4	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: iload_1
    //   106: invokestatic 333	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   109: aastore
    //   110: dup
    //   111: iconst_1
    //   112: aload_2
    //   113: aastore
    //   114: invokevirtual 114	org/xwalk/core/ReflectMethod:invoke	([Ljava/lang/Object;)Ljava/lang/Object;
    //   117: pop
    //   118: ldc_w 431
    //   121: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: iconst_1
    //   125: ireturn
    //   126: astore_2
    //   127: ldc 24
    //   129: ldc_w 443
    //   132: aload_2
    //   133: invokestatic 122	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   136: invokevirtual 126	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   139: invokestatic 77	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: invokestatic 446	com/tencent/xweb/util/l:kiG	()V
    //   145: ldc_w 431
    //   148: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: iconst_0
    //   152: ireturn
    //   153: astore_2
    //   154: ldc 24
    //   156: ldc_w 448
    //   159: aload_2
    //   160: invokestatic 122	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   163: invokevirtual 126	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   166: invokestatic 77	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: invokestatic 451	com/tencent/xweb/util/l:kiH	()V
    //   172: ldc_w 431
    //   175: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: iconst_0
    //   179: ireturn
    //   180: astore_2
    //   181: ldc 24
    //   183: ldc_w 453
    //   186: aload_2
    //   187: invokestatic 122	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   190: invokevirtual 126	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   193: invokestatic 77	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: invokestatic 456	com/tencent/xweb/util/l:kiI	()V
    //   199: ldc_w 431
    //   202: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: iconst_0
    //   206: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	XWalkStandAloneChannel
    //   0	207	1	paramInt	int
    //   0	207	2	paramArrayOfObject	Object[]
    //   9	21	3	i	int
    // Exception table:
    //   from	to	target	type
    //   52	118	126	java/lang/RuntimeException
    //   52	118	153	java/lang/ClassCircularityError
    //   52	118	180	finally
  }
  
  /* Error */
  public Object invokeRuntimeChannel(int paramInt, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: ldc_w 457
    //   3: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 57	org/xwalk/core/XWalkEnvironment:getAvailableVersion	()I
    //   9: istore_3
    //   10: iload_3
    //   11: sipush 255
    //   14: if_icmpge +39 -> 53
    //   17: ldc 24
    //   19: new 153	java/lang/StringBuilder
    //   22: dup
    //   23: ldc_w 459
    //   26: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   29: iload_3
    //   30: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   33: ldc_w 461
    //   36: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 171	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: ldc_w 457
    //   48: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: aconst_null
    //   52: areturn
    //   53: ldc 24
    //   55: ldc_w 463
    //   58: iload_1
    //   59: invokestatic 437	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   62: invokevirtual 126	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   65: invokestatic 84	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: new 101	org/xwalk/core/ReflectMethod
    //   71: dup
    //   72: aload_0
    //   73: ldc 178
    //   75: invokevirtual 99	org/xwalk/core/XWalkStandAloneChannel:getBridgeClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   78: ldc_w 464
    //   81: iconst_2
    //   82: anewarray 105	java/lang/Class
    //   85: dup
    //   86: iconst_0
    //   87: getstatic 439	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   90: aastore
    //   91: dup
    //   92: iconst_1
    //   93: ldc_w 441
    //   96: aastore
    //   97: invokespecial 110	org/xwalk/core/ReflectMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   100: iconst_2
    //   101: anewarray 4	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: iload_1
    //   107: invokestatic 333	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   110: aastore
    //   111: dup
    //   112: iconst_1
    //   113: aload_2
    //   114: aastore
    //   115: invokevirtual 114	org/xwalk/core/ReflectMethod:invoke	([Ljava/lang/Object;)Ljava/lang/Object;
    //   118: astore_2
    //   119: ldc_w 457
    //   122: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: aload_2
    //   126: areturn
    //   127: astore_2
    //   128: ldc 24
    //   130: ldc_w 466
    //   133: aload_2
    //   134: invokestatic 122	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   137: invokevirtual 126	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   140: invokestatic 77	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: invokestatic 446	com/tencent/xweb/util/l:kiG	()V
    //   146: ldc_w 457
    //   149: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aconst_null
    //   153: areturn
    //   154: astore_2
    //   155: ldc 24
    //   157: ldc_w 468
    //   160: aload_2
    //   161: invokestatic 122	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   164: invokevirtual 126	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   167: invokestatic 77	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: invokestatic 451	com/tencent/xweb/util/l:kiH	()V
    //   173: goto -27 -> 146
    //   176: astore_2
    //   177: ldc 24
    //   179: ldc_w 470
    //   182: aload_2
    //   183: invokestatic 122	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   186: invokevirtual 126	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   189: invokestatic 77	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: invokestatic 456	com/tencent/xweb/util/l:kiI	()V
    //   195: goto -49 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	XWalkStandAloneChannel
    //   0	198	1	paramInt	int
    //   0	198	2	paramArrayOfObject	Object[]
    //   9	21	3	i	int
    // Exception table:
    //   from	to	target	type
    //   53	119	127	java/lang/RuntimeException
    //   53	119	154	java/lang/ClassCircularityError
    //   53	119	176	finally
  }
  
  static class SingletonHolder
  {
    public static final XWalkStandAloneChannel sInstance;
    
    static
    {
      AppMethodBeat.i(187617);
      sInstance = new XWalkStandAloneChannel(null);
      AppMethodBeat.o(187617);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkStandAloneChannel
 * JD-Core Version:    0.7.0.1
 */