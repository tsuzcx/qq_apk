package io.flutter.embedding.engine.a;

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
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.VsyncWaiter;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a
{
  private static final String MDf;
  private static final String MDg;
  private static final String MDh;
  private static final String MDi;
  private static a MDn;
  private String MDj = "libapp.so";
  private String MDk = "vm_snapshot_data";
  private String MDl = "isolate_snapshot_data";
  public String MDm = "flutter_assets";
  public boolean MDo = false;
  private c MDp;
  public a MDq;
  
  static
  {
    AppMethodBeat.i(213281);
    MDf = a.class.getName() + '.' + "aot-shared-library-name";
    MDg = a.class.getName() + '.' + "vm-snapshot-data";
    MDh = a.class.getName() + '.' + "isolate-snapshot-data";
    MDi = a.class.getName() + '.' + "flutter-assets-dir";
    AppMethodBeat.o(213281);
  }
  
  private static ApplicationInfo K(Context paramContext)
  {
    AppMethodBeat.i(213277);
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      AppMethodBeat.o(213277);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext = new RuntimeException(paramContext);
      AppMethodBeat.o(213277);
      throw paramContext;
    }
  }
  
  public static a geQ()
  {
    AppMethodBeat.i(213273);
    if (MDn == null) {
      MDn = new a();
    }
    a locala = MDn;
    AppMethodBeat.o(213273);
    return locala;
  }
  
  private void lI(Context paramContext)
  {
    AppMethodBeat.i(213278);
    paramContext = K(paramContext).metaData;
    if (paramContext == null)
    {
      AppMethodBeat.o(213278);
      return;
    }
    this.MDj = paramContext.getString(MDf, "libapp.so");
    this.MDm = paramContext.getString(MDi, "flutter_assets");
    this.MDk = paramContext.getString(MDg, "vm_snapshot_data");
    this.MDl = paramContext.getString(MDh, "isolate_snapshot_data");
    AppMethodBeat.o(213278);
  }
  
  private static void lJ(Context paramContext)
  {
    AppMethodBeat.i(213279);
    new b(paramContext).start();
    AppMethodBeat.o(213279);
  }
  
  public final void a(Context paramContext, a parama)
  {
    AppMethodBeat.i(213275);
    if (this.MDq != null)
    {
      AppMethodBeat.o(213275);
      return;
    }
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      paramContext = new IllegalStateException("startInitialization must be called on the main thread");
      AppMethodBeat.o(213275);
      throw paramContext;
    }
    paramContext = paramContext.getApplicationContext();
    this.MDq = parama;
    long l = SystemClock.uptimeMillis();
    lI(paramContext);
    lJ(paramContext);
    System.loadLibrary("flutter");
    VsyncWaiter.getInstance((WindowManager)paramContext.getSystemService("window")).init();
    FlutterJNI.nativeRecordStartTimestamp(SystemClock.uptimeMillis() - l);
    AppMethodBeat.o(213275);
  }
  
  public final void ensureInitializationComplete(Context paramContext, String[] paramArrayOfString)
  {
    AppMethodBeat.i(213276);
    if (this.MDo)
    {
      AppMethodBeat.o(213276);
      return;
    }
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      paramContext = new IllegalStateException("ensureInitializationComplete must be called on the main thread");
      AppMethodBeat.o(213276);
      throw paramContext;
    }
    if (this.MDq == null)
    {
      paramContext = new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
      AppMethodBeat.o(213276);
      throw paramContext;
    }
    try
    {
      if (this.MDp != null) {
        this.MDp.geS();
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("--icu-symbol-prefix=_binary_icudtl_dat");
      Object localObject = K(paramContext);
      localArrayList.add("--icu-native-lib-path=" + ((ApplicationInfo)localObject).nativeLibraryDir + File.separator + "libflutter.so");
      if (paramArrayOfString != null) {
        Collections.addAll(localArrayList, paramArrayOfString);
      }
      localArrayList.add("--aot-shared-library-name=" + this.MDj);
      localArrayList.add("--aot-shared-library-name=" + ((ApplicationInfo)localObject).nativeLibraryDir + File.separator + this.MDj);
      localArrayList.add("--cache-dir-path=" + io.flutter.b.a.lK(paramContext));
      if (this.MDq.loX != null) {
        localArrayList.add("--log-tag=" + this.MDq.loX);
      }
      paramArrayOfString = paramContext.getFilesDir().getPath();
      localObject = io.flutter.b.a.lK(paramContext);
      FlutterJNI.nativeInit(paramContext, (String[])localArrayList.toArray(new String[0]), null, paramArrayOfString, (String)localObject);
      this.MDo = true;
      AppMethodBeat.o(213276);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext = new RuntimeException(paramContext);
      AppMethodBeat.o(213276);
      throw paramContext;
    }
  }
  
  public final String getLookupKeyForAsset(String paramString)
  {
    AppMethodBeat.i(213280);
    paramString = this.MDm + File.separator + paramString;
    AppMethodBeat.o(213280);
    return paramString;
  }
  
  public final void startInitialization(Context paramContext)
  {
    AppMethodBeat.i(213274);
    a(paramContext, new a());
    AppMethodBeat.o(213274);
  }
  
  public static final class a
  {
    public String loX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.a.a
 * JD-Core Version:    0.7.0.1
 */