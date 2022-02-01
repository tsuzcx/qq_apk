package io.flutter.view;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.c.a;
import io.flutter.embedding.engine.FlutterJNI;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlutterMain
{
  private static final String AOT_SHARED_LIBRARY_NAME = "aot-shared-library-name";
  private static final String DEFAULT_AOT_SHARED_LIBRARY_NAME = "libapp.so";
  private static final String DEFAULT_FLUTTER_ASSETS_DIR = "flutter_assets";
  private static final String DEFAULT_ISOLATE_SNAPSHOT_DATA = "isolate_snapshot_data";
  private static final String DEFAULT_KERNEL_BLOB = "kernel_blob.bin";
  private static final String DEFAULT_LIBRARY = "libflutter.so";
  private static final String DEFAULT_SKIA_LIBRARY = "libwechatskia.so";
  private static final String DEFAULT_VM_SNAPSHOT_DATA = "vm_snapshot_data";
  private static final String FLUTTER_ASSETS_DIR_KEY = "flutter-assets-dir";
  private static final String ISOLATE_SNAPSHOT_DATA_KEY = "isolate-snapshot-data";
  public static final String PUBLIC_AOT_SHARED_LIBRARY_NAME;
  public static final String PUBLIC_FLUTTER_ASSETS_DIR_KEY;
  public static final String PUBLIC_ISOLATE_SNAPSHOT_DATA_KEY;
  public static final String PUBLIC_VM_SNAPSHOT_DATA_KEY;
  private static final String SNAPSHOT_ASSET_PATH_KEY = "snapshot-asset-path";
  private static final String TAG = "FlutterMain";
  private static final String VM_SNAPSHOT_DATA_KEY = "vm-snapshot-data";
  private static boolean isRunningInRobolectricTest;
  private static String sAotSharedLibraryName;
  private static boolean sEngineInitialized;
  private static String sFlutterAssetsDir;
  private static String sIsolateSnapshotData;
  private static e sResourceExtractor;
  private static a sSettings;
  private static String sVmSnapshotData;
  
  static
  {
    AppMethodBeat.i(9749);
    PUBLIC_AOT_SHARED_LIBRARY_NAME = FlutterMain.class.getName() + '.' + "aot-shared-library-name";
    PUBLIC_VM_SNAPSHOT_DATA_KEY = FlutterMain.class.getName() + '.' + "vm-snapshot-data";
    PUBLIC_ISOLATE_SNAPSHOT_DATA_KEY = FlutterMain.class.getName() + '.' + "isolate-snapshot-data";
    PUBLIC_FLUTTER_ASSETS_DIR_KEY = FlutterMain.class.getName() + '.' + "flutter-assets-dir";
    isRunningInRobolectricTest = false;
    sAotSharedLibraryName = "libapp.so";
    sVmSnapshotData = "vm_snapshot_data";
    sIsolateSnapshotData = "isolate_snapshot_data";
    sFlutterAssetsDir = "flutter_assets";
    sEngineInitialized = false;
    AppMethodBeat.o(9749);
  }
  
  public static void ensureInitializationComplete(Context paramContext, String[] paramArrayOfString)
  {
    AppMethodBeat.i(9742);
    if (isRunningInRobolectricTest)
    {
      AppMethodBeat.o(9742);
      return;
    }
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      paramContext = new IllegalStateException("ensureInitializationComplete must be called on the main thread");
      AppMethodBeat.o(9742);
      throw paramContext;
    }
    if (sSettings == null)
    {
      paramContext = new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
      AppMethodBeat.o(9742);
      throw paramContext;
    }
    if (sEngineInitialized)
    {
      AppMethodBeat.o(9742);
      return;
    }
    try
    {
      if (sResourceExtractor != null) {
        sResourceExtractor.fvs();
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("--icu-symbol-prefix=_binary_icudtl_dat");
      Object localObject = getApplicationInfo(paramContext);
      localArrayList.add("--icu-native-lib-path=" + ((ApplicationInfo)localObject).nativeLibraryDir + File.separator + "libflutter.so");
      if (paramArrayOfString != null) {
        Collections.addAll(localArrayList, paramArrayOfString);
      }
      localArrayList.add("--aot-shared-library-name=" + sAotSharedLibraryName);
      localArrayList.add("--aot-shared-library-name=" + ((ApplicationInfo)localObject).nativeLibraryDir + File.separator + sAotSharedLibraryName);
      localArrayList.add("--cache-dir-path=" + a.lj(paramContext));
      if (sSettings.krb != null) {
        localArrayList.add("--log-tag=" + sSettings.krb);
      }
      paramArrayOfString = paramContext.getFilesDir().getPath();
      localObject = a.lj(paramContext);
      FlutterJNI.nativeInit(paramContext, (String[])localArrayList.toArray(new String[0]), null, paramArrayOfString, (String)localObject);
      sEngineInitialized = true;
      AppMethodBeat.o(9742);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext = new RuntimeException(paramContext);
      AppMethodBeat.o(9742);
      throw paramContext;
    }
  }
  
  public static void ensureInitializationCompleteAsync(Context paramContext, final String[] paramArrayOfString, final Handler paramHandler, final Runnable paramRunnable)
  {
    AppMethodBeat.i(9743);
    if (isRunningInRobolectricTest)
    {
      AppMethodBeat.o(9743);
      return;
    }
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      paramContext = new IllegalStateException("ensureInitializationComplete must be called on the main thread");
      AppMethodBeat.o(9743);
      throw paramContext;
    }
    if (sSettings == null)
    {
      paramContext = new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
      AppMethodBeat.o(9743);
      throw paramContext;
    }
    if (sEngineInitialized)
    {
      AppMethodBeat.o(9743);
      return;
    }
    new Thread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9681);
        if (FlutterMain.sResourceExtractor != null) {
          FlutterMain.sResourceExtractor.fvs();
        }
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(9697);
            FlutterMain.ensureInitializationComplete(FlutterMain.1.this.val$applicationContext.getApplicationContext(), FlutterMain.1.this.fHR);
            FlutterMain.1.this.JeW.post(FlutterMain.1.this.val$callback);
            AppMethodBeat.o(9697);
          }
        });
        AppMethodBeat.o(9681);
      }
    }).start();
    AppMethodBeat.o(9743);
  }
  
  public static String findAppBundlePath()
  {
    return sFlutterAssetsDir;
  }
  
  @Deprecated
  public static String findAppBundlePath(Context paramContext)
  {
    return sFlutterAssetsDir;
  }
  
  private static String fromFlutterAssets(String paramString)
  {
    AppMethodBeat.i(9739);
    paramString = sFlutterAssetsDir + File.separator + paramString;
    AppMethodBeat.o(9739);
    return paramString;
  }
  
  private static ApplicationInfo getApplicationInfo(Context paramContext)
  {
    AppMethodBeat.i(9744);
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      AppMethodBeat.o(9744);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext = new RuntimeException(paramContext);
      AppMethodBeat.o(9744);
      throw paramContext;
    }
  }
  
  public static String getLookupKeyForAsset(String paramString)
  {
    AppMethodBeat.i(9747);
    paramString = fromFlutterAssets(paramString);
    AppMethodBeat.o(9747);
    return paramString;
  }
  
  public static String getLookupKeyForAsset(String paramString1, String paramString2)
  {
    AppMethodBeat.i(9748);
    paramString1 = getLookupKeyForAsset("packages" + File.separator + paramString2 + File.separator + paramString1);
    AppMethodBeat.o(9748);
    return paramString1;
  }
  
  private static void initConfig(Context paramContext)
  {
    AppMethodBeat.i(9745);
    paramContext = getApplicationInfo(paramContext).metaData;
    if (paramContext == null)
    {
      AppMethodBeat.o(9745);
      return;
    }
    sAotSharedLibraryName = paramContext.getString(PUBLIC_AOT_SHARED_LIBRARY_NAME, "libapp.so");
    sFlutterAssetsDir = paramContext.getString(PUBLIC_FLUTTER_ASSETS_DIR_KEY, "flutter_assets");
    sVmSnapshotData = paramContext.getString(PUBLIC_VM_SNAPSHOT_DATA_KEY, "vm_snapshot_data");
    sIsolateSnapshotData = paramContext.getString(PUBLIC_ISOLATE_SNAPSHOT_DATA_KEY, "isolate_snapshot_data");
    AppMethodBeat.o(9745);
  }
  
  private static void initResources(Context paramContext)
  {
    AppMethodBeat.i(9746);
    paramContext = new d(paramContext);
    Object localObject = paramContext.mContext.getCacheDir();
    if (localObject != null)
    {
      localObject = new d.a(((File)localObject).listFiles(new d.1(paramContext)));
      if ((((d.a)localObject).JfB == null) || (((d.a)localObject).JfB.length <= 0)) {
        break label98;
      }
    }
    label98:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        new Handler().postDelayed(new d.2(paramContext, (d.a)localObject), 5000L);
      }
      AppMethodBeat.o(9746);
      return;
    }
  }
  
  public static void setIsRunningInRobolectricTest(boolean paramBoolean)
  {
    isRunningInRobolectricTest = paramBoolean;
  }
  
  public static void startInitialization(Context paramContext)
  {
    AppMethodBeat.i(9740);
    if (isRunningInRobolectricTest)
    {
      AppMethodBeat.o(9740);
      return;
    }
    startInitialization(paramContext, new a());
    AppMethodBeat.o(9740);
  }
  
  public static void startInitialization(Context paramContext, a parama)
  {
    AppMethodBeat.i(9741);
    if (isRunningInRobolectricTest)
    {
      AppMethodBeat.o(9741);
      return;
    }
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      paramContext = new IllegalStateException("startInitialization must be called on the main thread");
      AppMethodBeat.o(9741);
      throw paramContext;
    }
    if (sSettings != null)
    {
      AppMethodBeat.o(9741);
      return;
    }
    sSettings = parama;
    long l = SystemClock.uptimeMillis();
    initConfig(paramContext);
    initResources(paramContext);
    System.loadLibrary("flutter");
    VsyncWaiter.getInstance((WindowManager)paramContext.getSystemService("window")).init();
    FlutterJNI.nativeRecordStartTimestamp(SystemClock.uptimeMillis() - l);
    AppMethodBeat.o(9741);
  }
  
  public static final class a
  {
    String krb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.view.FlutterMain
 * JD-Core Version:    0.7.0.1
 */