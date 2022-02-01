package io.flutter.embedding.engine.loader;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.util.PathUtils;
import io.flutter.view.VsyncWaiter;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FlutterLoader
{
  static final String AOT_SHARED_LIBRARY_NAME = "aot-shared-library-name";
  private static final String DEFAULT_KERNEL_BLOB = "kernel_blob.bin";
  private static final String DEFAULT_LIBRARY = "libflutter.so";
  private static final String ENABLE_SKPARAGRAPH_META_DATA_KEY = "io.flutter.embedding.android.EnableSkParagraph";
  static final String FLUTTER_ASSETS_DIR_KEY = "flutter-assets-dir";
  static final String ISOLATE_SNAPSHOT_DATA_KEY = "isolate-snapshot-data";
  private static final String OLD_GEN_HEAP_SIZE_META_DATA_KEY = "io.flutter.embedding.android.OldGenHeapSize";
  static final String SNAPSHOT_ASSET_PATH_KEY = "snapshot-asset-path";
  private static final String TAG = "FlutterLoader";
  static final String VM_SNAPSHOT_DATA_KEY = "vm-snapshot-data";
  private static FlutterLoader instance;
  private FlutterApplicationInfo flutterApplicationInfo;
  private FlutterJNI flutterJNI;
  Future<InitResult> initResultFuture;
  private long initStartTimestampMillis;
  private boolean initialized = false;
  private Settings settings;
  
  public FlutterLoader()
  {
    this(new FlutterJNI());
    AppMethodBeat.i(190096);
    AppMethodBeat.o(190096);
  }
  
  public FlutterLoader(FlutterJNI paramFlutterJNI)
  {
    this.flutterJNI = paramFlutterJNI;
  }
  
  /* Error */
  private void ensureInitializationComplete(Context paramContext, String[] paramArrayOfString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 108
    //   2: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 87	io/flutter/embedding/engine/loader/FlutterLoader:initialized	Z
    //   9: ifeq +9 -> 18
    //   12: ldc 108
    //   14: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: return
    //   18: iload_3
    //   19: ifeq +29 -> 48
    //   22: invokestatic 114	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   25: invokestatic 117	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   28: if_acmpeq +20 -> 48
    //   31: new 119	java/lang/IllegalStateException
    //   34: dup
    //   35: ldc 121
    //   37: invokespecial 124	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   40: astore_1
    //   41: ldc 108
    //   43: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aload_1
    //   47: athrow
    //   48: aload_0
    //   49: getfield 126	io/flutter/embedding/engine/loader/FlutterLoader:settings	Lio/flutter/embedding/engine/loader/FlutterLoader$Settings;
    //   52: ifnonnull +20 -> 72
    //   55: new 119	java/lang/IllegalStateException
    //   58: dup
    //   59: ldc 128
    //   61: invokespecial 124	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   64: astore_1
    //   65: ldc 108
    //   67: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aload_1
    //   71: athrow
    //   72: aload_0
    //   73: getfield 130	io/flutter/embedding/engine/loader/FlutterLoader:initResultFuture	Ljava/util/concurrent/Future;
    //   76: invokeinterface 136 1 0
    //   81: checkcast 14	io/flutter/embedding/engine/loader/FlutterLoader$InitResult
    //   84: astore 8
    //   86: new 138	java/util/ArrayList
    //   89: dup
    //   90: invokespecial 139	java/util/ArrayList:<init>	()V
    //   93: astore 9
    //   95: aload 9
    //   97: ldc 141
    //   99: invokeinterface 147 2 0
    //   104: pop
    //   105: aload 9
    //   107: new 149	java/lang/StringBuilder
    //   110: dup
    //   111: ldc 151
    //   113: invokespecial 152	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   116: aload_0
    //   117: getfield 154	io/flutter/embedding/engine/loader/FlutterLoader:flutterApplicationInfo	Lio/flutter/embedding/engine/loader/FlutterApplicationInfo;
    //   120: getfield 159	io/flutter/embedding/engine/loader/FlutterApplicationInfo:nativeLibraryDir	Ljava/lang/String;
    //   123: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: getstatic 168	java/io/File:separator	Ljava/lang/String;
    //   129: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc 28
    //   134: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokeinterface 147 2 0
    //   145: pop
    //   146: aload_2
    //   147: ifnull +10 -> 157
    //   150: aload 9
    //   152: aload_2
    //   153: invokestatic 178	java/util/Collections:addAll	(Ljava/util/Collection;[Ljava/lang/Object;)Z
    //   156: pop
    //   157: aload 9
    //   159: new 149	java/lang/StringBuilder
    //   162: dup
    //   163: ldc 180
    //   165: invokespecial 152	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   168: aload_0
    //   169: getfield 154	io/flutter/embedding/engine/loader/FlutterLoader:flutterApplicationInfo	Lio/flutter/embedding/engine/loader/FlutterApplicationInfo;
    //   172: getfield 183	io/flutter/embedding/engine/loader/FlutterApplicationInfo:aotSharedLibraryName	Ljava/lang/String;
    //   175: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokeinterface 147 2 0
    //   186: pop
    //   187: aload 9
    //   189: new 149	java/lang/StringBuilder
    //   192: dup
    //   193: ldc 180
    //   195: invokespecial 152	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   198: aload_0
    //   199: getfield 154	io/flutter/embedding/engine/loader/FlutterLoader:flutterApplicationInfo	Lio/flutter/embedding/engine/loader/FlutterApplicationInfo;
    //   202: getfield 159	io/flutter/embedding/engine/loader/FlutterApplicationInfo:nativeLibraryDir	Ljava/lang/String;
    //   205: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: getstatic 168	java/io/File:separator	Ljava/lang/String;
    //   211: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload_0
    //   215: getfield 154	io/flutter/embedding/engine/loader/FlutterLoader:flutterApplicationInfo	Lio/flutter/embedding/engine/loader/FlutterApplicationInfo;
    //   218: getfield 183	io/flutter/embedding/engine/loader/FlutterApplicationInfo:aotSharedLibraryName	Ljava/lang/String;
    //   221: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokeinterface 147 2 0
    //   232: pop
    //   233: aload 9
    //   235: new 149	java/lang/StringBuilder
    //   238: dup
    //   239: ldc 185
    //   241: invokespecial 152	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   244: aload 8
    //   246: getfield 188	io/flutter/embedding/engine/loader/FlutterLoader$InitResult:engineCachesPath	Ljava/lang/String;
    //   249: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokeinterface 147 2 0
    //   260: pop
    //   261: aload_0
    //   262: getfield 154	io/flutter/embedding/engine/loader/FlutterLoader:flutterApplicationInfo	Lio/flutter/embedding/engine/loader/FlutterApplicationInfo;
    //   265: getfield 191	io/flutter/embedding/engine/loader/FlutterApplicationInfo:clearTextPermitted	Z
    //   268: ifne +13 -> 281
    //   271: aload 9
    //   273: ldc 193
    //   275: invokeinterface 147 2 0
    //   280: pop
    //   281: aload_0
    //   282: getfield 154	io/flutter/embedding/engine/loader/FlutterLoader:flutterApplicationInfo	Lio/flutter/embedding/engine/loader/FlutterApplicationInfo;
    //   285: getfield 196	io/flutter/embedding/engine/loader/FlutterApplicationInfo:domainNetworkPolicy	Ljava/lang/String;
    //   288: ifnull +33 -> 321
    //   291: aload 9
    //   293: new 149	java/lang/StringBuilder
    //   296: dup
    //   297: ldc 198
    //   299: invokespecial 152	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   302: aload_0
    //   303: getfield 154	io/flutter/embedding/engine/loader/FlutterLoader:flutterApplicationInfo	Lio/flutter/embedding/engine/loader/FlutterApplicationInfo;
    //   306: getfield 196	io/flutter/embedding/engine/loader/FlutterApplicationInfo:domainNetworkPolicy	Ljava/lang/String;
    //   309: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokeinterface 147 2 0
    //   320: pop
    //   321: aload_0
    //   322: getfield 126	io/flutter/embedding/engine/loader/FlutterLoader:settings	Lio/flutter/embedding/engine/loader/FlutterLoader$Settings;
    //   325: invokevirtual 201	io/flutter/embedding/engine/loader/FlutterLoader$Settings:getLogTag	()Ljava/lang/String;
    //   328: ifnull +33 -> 361
    //   331: aload 9
    //   333: new 149	java/lang/StringBuilder
    //   336: dup
    //   337: ldc 203
    //   339: invokespecial 152	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   342: aload_0
    //   343: getfield 126	io/flutter/embedding/engine/loader/FlutterLoader:settings	Lio/flutter/embedding/engine/loader/FlutterLoader$Settings;
    //   346: invokevirtual 201	io/flutter/embedding/engine/loader/FlutterLoader$Settings:getLogTag	()Ljava/lang/String;
    //   349: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   355: invokeinterface 147 2 0
    //   360: pop
    //   361: aload_1
    //   362: invokevirtual 209	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   365: aload_1
    //   366: invokevirtual 212	android/content/Context:getPackageName	()Ljava/lang/String;
    //   369: sipush 128
    //   372: invokevirtual 218	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   375: getfield 224	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   378: astore_2
    //   379: aload_2
    //   380: ifnull +166 -> 546
    //   383: aload_2
    //   384: ldc 40
    //   386: invokevirtual 230	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   389: istore 4
    //   391: iload 4
    //   393: istore 5
    //   395: iload 4
    //   397: ifne +47 -> 444
    //   400: aload_1
    //   401: ldc 232
    //   403: invokevirtual 236	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   406: checkcast 238	android/app/ActivityManager
    //   409: astore 10
    //   411: new 240	android/app/ActivityManager$MemoryInfo
    //   414: dup
    //   415: invokespecial 241	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   418: astore 11
    //   420: aload 10
    //   422: aload 11
    //   424: invokevirtual 245	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   427: aload 11
    //   429: getfield 248	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   432: l2d
    //   433: ldc2_w 249
    //   436: ddiv
    //   437: ldc2_w 251
    //   440: ddiv
    //   441: d2i
    //   442: istore 5
    //   444: aload 9
    //   446: ldc 254
    //   448: iload 5
    //   450: invokestatic 260	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   453: invokevirtual 264	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   456: invokeinterface 147 2 0
    //   461: pop
    //   462: aload_2
    //   463: ifnull +23 -> 486
    //   466: aload_2
    //   467: ldc 31
    //   469: invokevirtual 268	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   472: ifeq +14 -> 486
    //   475: aload 9
    //   477: ldc_w 270
    //   480: invokeinterface 147 2 0
    //   485: pop
    //   486: invokestatic 276	android/os/SystemClock:uptimeMillis	()J
    //   489: aload_0
    //   490: getfield 278	io/flutter/embedding/engine/loader/FlutterLoader:initStartTimestampMillis	J
    //   493: lsub
    //   494: lstore 6
    //   496: iload_3
    //   497: ifeq +55 -> 552
    //   500: aload_0
    //   501: getfield 89	io/flutter/embedding/engine/loader/FlutterLoader:flutterJNI	Lio/flutter/embedding/engine/FlutterJNI;
    //   504: aload_1
    //   505: aload 9
    //   507: iconst_0
    //   508: anewarray 256	java/lang/String
    //   511: invokeinterface 282 2 0
    //   516: checkcast 284	[Ljava/lang/String;
    //   519: aconst_null
    //   520: aload 8
    //   522: getfield 287	io/flutter/embedding/engine/loader/FlutterLoader$InitResult:appStoragePath	Ljava/lang/String;
    //   525: aload 8
    //   527: getfield 188	io/flutter/embedding/engine/loader/FlutterLoader$InitResult:engineCachesPath	Ljava/lang/String;
    //   530: lload 6
    //   532: invokevirtual 291	io/flutter/embedding/engine/FlutterJNI:init	(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    //   535: aload_0
    //   536: iconst_1
    //   537: putfield 87	io/flutter/embedding/engine/loader/FlutterLoader:initialized	Z
    //   540: ldc 108
    //   542: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   545: return
    //   546: iconst_0
    //   547: istore 4
    //   549: goto -158 -> 391
    //   552: aload_0
    //   553: getfield 89	io/flutter/embedding/engine/loader/FlutterLoader:flutterJNI	Lio/flutter/embedding/engine/FlutterJNI;
    //   556: aload_1
    //   557: aload 9
    //   559: iconst_0
    //   560: anewarray 256	java/lang/String
    //   563: invokeinterface 282 2 0
    //   568: checkcast 284	[Ljava/lang/String;
    //   571: aconst_null
    //   572: aload 8
    //   574: getfield 287	io/flutter/embedding/engine/loader/FlutterLoader$InitResult:appStoragePath	Ljava/lang/String;
    //   577: aload 8
    //   579: getfield 188	io/flutter/embedding/engine/loader/FlutterLoader$InitResult:engineCachesPath	Ljava/lang/String;
    //   582: lload 6
    //   584: invokevirtual 294	io/flutter/embedding/engine/FlutterJNI:initNotInMainThread	(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    //   587: goto -52 -> 535
    //   590: astore_1
    //   591: ldc 46
    //   593: ldc_w 296
    //   596: aload_1
    //   597: invokestatic 302	io/flutter/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   600: new 304	java/lang/RuntimeException
    //   603: dup
    //   604: aload_1
    //   605: invokespecial 307	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   608: astore_1
    //   609: ldc 108
    //   611: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   614: aload_1
    //   615: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	616	0	this	FlutterLoader
    //   0	616	1	paramContext	Context
    //   0	616	2	paramArrayOfString	String[]
    //   0	616	3	paramBoolean	boolean
    //   389	159	4	i	int
    //   393	56	5	j	int
    //   494	89	6	l	long
    //   84	494	8	localInitResult	InitResult
    //   93	465	9	localArrayList	java.util.ArrayList
    //   409	12	10	localActivityManager	android.app.ActivityManager
    //   418	10	11	localMemoryInfo	android.app.ActivityManager.MemoryInfo
    // Exception table:
    //   from	to	target	type
    //   72	146	590	java/lang/Exception
    //   150	157	590	java/lang/Exception
    //   157	281	590	java/lang/Exception
    //   281	321	590	java/lang/Exception
    //   321	361	590	java/lang/Exception
    //   361	379	590	java/lang/Exception
    //   383	391	590	java/lang/Exception
    //   400	444	590	java/lang/Exception
    //   444	462	590	java/lang/Exception
    //   466	486	590	java/lang/Exception
    //   486	496	590	java/lang/Exception
    //   500	535	590	java/lang/Exception
    //   535	540	590	java/lang/Exception
    //   552	587	590	java/lang/Exception
  }
  
  private String fullAssetPathFrom(String paramString)
  {
    AppMethodBeat.i(190137);
    paramString = this.flutterApplicationInfo.flutterAssetsDir + File.separator + paramString;
    AppMethodBeat.o(190137);
    return paramString;
  }
  
  @Deprecated
  public static FlutterLoader getInstance()
  {
    AppMethodBeat.i(190088);
    if (instance == null) {
      instance = new FlutterLoader();
    }
    FlutterLoader localFlutterLoader = instance;
    AppMethodBeat.o(190088);
    return localFlutterLoader;
  }
  
  private ResourceExtractor initResources(Context paramContext)
  {
    return null;
  }
  
  public void ensureInitializationComplete(Context paramContext, String[] paramArrayOfString)
  {
    AppMethodBeat.i(190222);
    ensureInitializationComplete(paramContext, paramArrayOfString, true);
    AppMethodBeat.o(190222);
  }
  
  public void ensureInitializationCompleteAsync(final Context paramContext, final String[] paramArrayOfString, Handler paramHandler, final Runnable paramRunnable)
  {
    AppMethodBeat.i(190231);
    if (this.settings == null)
    {
      paramContext = new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
      AppMethodBeat.o(190231);
      throw paramContext;
    }
    if (this.initialized)
    {
      paramHandler.post(paramRunnable);
      AppMethodBeat.o(190231);
      return;
    }
    Executors.newSingleThreadExecutor().execute(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(190073);
        try
        {
          FlutterLoader.this.initResultFuture.get();
          FlutterLoader.access$300(FlutterLoader.this, paramContext.getApplicationContext(), paramArrayOfString, false);
          Log.i("FlutterLoader", "ensureInitializationCompleteAsync invoke callback");
          paramRunnable.run();
          new Handler(Looper.getMainLooper()).post(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(190080);
              FlutterJNI.nativeAfterInit();
              Log.i("FlutterLoader", "ensureInitializationCompleteAsync afterInit finished");
              AppMethodBeat.o(190080);
            }
          });
          AppMethodBeat.o(190073);
          return;
        }
        catch (Exception localException)
        {
          Log.e("FlutterLoader", "Flutter initialization failed.", localException);
          RuntimeException localRuntimeException = new RuntimeException(localException);
          AppMethodBeat.o(190073);
          throw localRuntimeException;
        }
      }
    });
    AppMethodBeat.o(190231);
  }
  
  public String findAppBundlePath()
  {
    return this.flutterApplicationInfo.flutterAssetsDir;
  }
  
  public String getLookupKeyForAsset(String paramString)
  {
    AppMethodBeat.i(190248);
    paramString = fullAssetPathFrom(paramString);
    AppMethodBeat.o(190248);
    return paramString;
  }
  
  public String getLookupKeyForAsset(String paramString1, String paramString2)
  {
    AppMethodBeat.i(190253);
    paramString1 = getLookupKeyForAsset("packages" + File.separator + paramString2 + File.separator + paramString1);
    AppMethodBeat.o(190253);
    return paramString1;
  }
  
  public boolean initialized()
  {
    return this.initialized;
  }
  
  public void startInitialization(Context paramContext)
  {
    AppMethodBeat.i(190174);
    startInitialization(paramContext, new Settings(), true);
    AppMethodBeat.o(190174);
  }
  
  public void startInitialization(Context paramContext, Settings paramSettings)
  {
    AppMethodBeat.i(190184);
    startInitialization(paramContext, paramSettings, true);
    AppMethodBeat.o(190184);
  }
  
  public void startInitialization(final Context paramContext, Settings paramSettings, boolean paramBoolean)
  {
    AppMethodBeat.i(190212);
    if (this.settings != null)
    {
      AppMethodBeat.o(190212);
      return;
    }
    if ((paramBoolean) && (Looper.myLooper() != Looper.getMainLooper()))
    {
      paramContext = new IllegalStateException("startInitialization must be called on the main thread");
      AppMethodBeat.o(190212);
      throw paramContext;
    }
    paramContext = paramContext.getApplicationContext();
    this.settings = paramSettings;
    this.initStartTimestampMillis = SystemClock.uptimeMillis();
    this.flutterApplicationInfo = ApplicationInfoLoader.load(paramContext);
    VsyncWaiter.getInstance((WindowManager)paramContext.getSystemService("window")).init();
    paramContext = new Callable()
    {
      public FlutterLoader.InitResult call()
      {
        AppMethodBeat.i(190066);
        Object localObject = FlutterLoader.access$000(FlutterLoader.this, paramContext);
        FlutterLoader.this.flutterJNI.loadLibrary();
        Executors.newSingleThreadExecutor().execute(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(190090);
            FlutterLoader.this.flutterJNI.prefetchDefaultFontManager();
            AppMethodBeat.o(190090);
          }
        });
        if (localObject != null) {
          ((ResourceExtractor)localObject).waitForCompletion();
        }
        localObject = new FlutterLoader.InitResult(PathUtils.getFilesDir(paramContext), PathUtils.getCacheDirectory(paramContext), PathUtils.getDataDirectory(paramContext), null);
        AppMethodBeat.o(190066);
        return localObject;
      }
    };
    this.initResultFuture = Executors.newSingleThreadExecutor().submit(paramContext);
    AppMethodBeat.o(190212);
  }
  
  public void startInitializationAsync(Context paramContext)
  {
    AppMethodBeat.i(190189);
    startInitialization(paramContext, new Settings(), false);
    AppMethodBeat.o(190189);
  }
  
  public void startInitializationAsync(Context paramContext, Settings paramSettings)
  {
    AppMethodBeat.i(190199);
    startInitialization(paramContext, paramSettings, false);
    AppMethodBeat.o(190199);
  }
  
  static class InitResult
  {
    final String appStoragePath;
    final String dataDirPath;
    final String engineCachesPath;
    
    private InitResult(String paramString1, String paramString2, String paramString3)
    {
      this.appStoragePath = paramString1;
      this.engineCachesPath = paramString2;
      this.dataDirPath = paramString3;
    }
  }
  
  public static class Settings
  {
    private String logTag;
    
    public String getLogTag()
    {
      return this.logTag;
    }
    
    public void setLogTag(String paramString)
    {
      this.logTag = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.loader.FlutterLoader
 * JD-Core Version:    0.7.0.1
 */