package io.flutter.embedding.engine.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.VsyncWaiter;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class a
{
  private static final String SOV;
  private static final String SOW;
  private static final String SOX;
  private static final String SOY;
  private static a SPd;
  private String SOZ = "libapp.so";
  private String SPa = "vm_snapshot_data";
  private String SPb = "isolate_snapshot_data";
  public String SPc = "flutter_assets";
  public boolean SPe = false;
  public b SPf;
  private long SPg;
  Future<a> SPh;
  
  static
  {
    AppMethodBeat.i(215010);
    SOV = a.class.getName() + '.' + "aot-shared-library-name";
    SOW = a.class.getName() + '.' + "vm-snapshot-data";
    SOX = a.class.getName() + '.' + "isolate-snapshot-data";
    SOY = a.class.getName() + '.' + "flutter-assets-dir";
    AppMethodBeat.o(215010);
  }
  
  private static ApplicationInfo L(Context paramContext)
  {
    AppMethodBeat.i(215006);
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      AppMethodBeat.o(215006);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext = new RuntimeException(paramContext);
      AppMethodBeat.o(215006);
      throw paramContext;
    }
  }
  
  public static a hwT()
  {
    AppMethodBeat.i(215002);
    if (SPd == null) {
      SPd = new a();
    }
    a locala = SPd;
    AppMethodBeat.o(215002);
    return locala;
  }
  
  private void lN(Context paramContext)
  {
    AppMethodBeat.i(215007);
    paramContext = L(paramContext).metaData;
    if (paramContext == null)
    {
      AppMethodBeat.o(215007);
      return;
    }
    this.SOZ = paramContext.getString(SOV, "libapp.so");
    this.SPc = paramContext.getString(SOY, "flutter_assets");
    this.SPa = paramContext.getString(SOW, "vm_snapshot_data");
    this.SPb = paramContext.getString(SOX, "isolate_snapshot_data");
    AppMethodBeat.o(215007);
  }
  
  public final void a(final Context paramContext, b paramb)
  {
    AppMethodBeat.i(215004);
    if (this.SPf != null)
    {
      AppMethodBeat.o(215004);
      return;
    }
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      paramContext = new IllegalStateException("startInitialization must be called on the main thread");
      AppMethodBeat.o(215004);
      throw paramContext;
    }
    paramContext = paramContext.getApplicationContext();
    this.SPf = paramb;
    this.SPg = SystemClock.uptimeMillis();
    lN(paramContext);
    VsyncWaiter.getInstance((WindowManager)paramContext.getSystemService("window")).init();
    paramContext = new Callable()
    {
      private a.a hwV()
      {
        AppMethodBeat.i(215000);
        a.hwU();
        try
        {
          System.loadLibrary("flutter");
          label14:
          Executors.newSingleThreadExecutor().execute(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(215014);
              FlutterJNI.nativePrefetchDefaultFontManager();
              AppMethodBeat.o(215014);
            }
          });
          String str = paramContext.getFilesDir().getPath();
          Object localObject = paramContext;
          if (Build.VERSION.SDK_INT >= 21) {}
          for (localObject = ((Context)localObject).getCodeCacheDir().getPath();; localObject = ((Context)localObject).getCacheDir().getPath())
          {
            localObject = new a.a(str, (String)localObject, io.flutter.a.a.lO(paramContext), (byte)0);
            AppMethodBeat.o(215000);
            return localObject;
          }
        }
        catch (Exception localException)
        {
          break label14;
        }
      }
    };
    this.SPh = Executors.newSingleThreadExecutor().submit(paramContext);
    AppMethodBeat.o(215004);
  }
  
  public final String btd(String paramString)
  {
    AppMethodBeat.i(215009);
    paramString = this.SPc + File.separator + paramString;
    AppMethodBeat.o(215009);
    return paramString;
  }
  
  public final void ensureInitializationComplete(Context paramContext, String[] paramArrayOfString)
  {
    AppMethodBeat.i(215005);
    if (this.SPe)
    {
      AppMethodBeat.o(215005);
      return;
    }
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      paramContext = new IllegalStateException("ensureInitializationComplete must be called on the main thread");
      AppMethodBeat.o(215005);
      throw paramContext;
    }
    if (this.SPf == null)
    {
      paramContext = new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
      AppMethodBeat.o(215005);
      throw paramContext;
    }
    try
    {
      a locala = (a)this.SPh.get();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("--icu-symbol-prefix=_binary_icudtl_dat");
      ApplicationInfo localApplicationInfo = L(paramContext);
      localArrayList.add("--icu-native-lib-path=" + localApplicationInfo.nativeLibraryDir + File.separator + "libflutter.so");
      if (paramArrayOfString != null) {
        Collections.addAll(localArrayList, paramArrayOfString);
      }
      localArrayList.add("--aot-shared-library-name=" + this.SOZ);
      localArrayList.add("--aot-shared-library-name=" + localApplicationInfo.nativeLibraryDir + File.separator + this.SOZ);
      localArrayList.add("--cache-dir-path=" + locala.SPo);
      if (this.SPf.logTag != null) {
        localArrayList.add("--log-tag=" + this.SPf.logTag);
      }
      long l1 = SystemClock.uptimeMillis();
      long l2 = this.SPg;
      paramArrayOfString = localApplicationInfo.metaData;
      if ((paramArrayOfString != null) && (paramArrayOfString.getBoolean("io.flutter.embedded_views_preview"))) {
        localArrayList.add("--use-embedded-view");
      }
      FlutterJNI.nativeInit(paramContext, (String[])localArrayList.toArray(new String[0]), null, locala.SPn, locala.SPo, l1 - l2);
      this.SPe = true;
      AppMethodBeat.o(215005);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext = new RuntimeException(paramContext);
      AppMethodBeat.o(215005);
      throw paramContext;
    }
  }
  
  public final String getLookupKeyForAsset(String paramString1, String paramString2)
  {
    AppMethodBeat.i(215008);
    paramString1 = btd("packages" + File.separator + paramString2 + File.separator + paramString1);
    AppMethodBeat.o(215008);
    return paramString1;
  }
  
  public final void startInitialization(Context paramContext)
  {
    AppMethodBeat.i(215003);
    a(paramContext, new b());
    AppMethodBeat.o(215003);
  }
  
  static final class a
  {
    final String SPn;
    final String SPo;
    final String SPp;
    
    private a(String paramString1, String paramString2, String paramString3)
    {
      this.SPn = paramString1;
      this.SPo = paramString2;
      this.SPp = paramString3;
    }
  }
  
  public static final class b
  {
    public String logTag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.a.a
 * JD-Core Version:    0.7.0.1
 */