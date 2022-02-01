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
  private static final String KMi;
  private static final String KMj;
  private static final String KMk;
  private static final String KMl;
  private static a KMq;
  private String KMm = "libapp.so";
  private String KMn = "vm_snapshot_data";
  private String KMo = "isolate_snapshot_data";
  public String KMp = "flutter_assets";
  public boolean KMr = false;
  private c KMs;
  public a KMt;
  
  static
  {
    AppMethodBeat.i(192832);
    KMi = a.class.getName() + '.' + "aot-shared-library-name";
    KMj = a.class.getName() + '.' + "vm-snapshot-data";
    KMk = a.class.getName() + '.' + "isolate-snapshot-data";
    KMl = a.class.getName() + '.' + "flutter-assets-dir";
    AppMethodBeat.o(192832);
  }
  
  private static ApplicationInfo K(Context paramContext)
  {
    AppMethodBeat.i(192828);
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      AppMethodBeat.o(192828);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext = new RuntimeException(paramContext);
      AppMethodBeat.o(192828);
      throw paramContext;
    }
  }
  
  public static a fNr()
  {
    AppMethodBeat.i(192824);
    if (KMq == null) {
      KMq = new a();
    }
    a locala = KMq;
    AppMethodBeat.o(192824);
    return locala;
  }
  
  private void lw(Context paramContext)
  {
    AppMethodBeat.i(192829);
    paramContext = K(paramContext).metaData;
    if (paramContext == null)
    {
      AppMethodBeat.o(192829);
      return;
    }
    this.KMm = paramContext.getString(KMi, "libapp.so");
    this.KMp = paramContext.getString(KMl, "flutter_assets");
    this.KMn = paramContext.getString(KMj, "vm_snapshot_data");
    this.KMo = paramContext.getString(KMk, "isolate_snapshot_data");
    AppMethodBeat.o(192829);
  }
  
  private static void lx(Context paramContext)
  {
    AppMethodBeat.i(192830);
    new b(paramContext).start();
    AppMethodBeat.o(192830);
  }
  
  public final void a(Context paramContext, a parama)
  {
    AppMethodBeat.i(192826);
    if (this.KMt != null)
    {
      AppMethodBeat.o(192826);
      return;
    }
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      paramContext = new IllegalStateException("startInitialization must be called on the main thread");
      AppMethodBeat.o(192826);
      throw paramContext;
    }
    this.KMt = parama;
    long l = SystemClock.uptimeMillis();
    lw(paramContext);
    lx(paramContext);
    System.loadLibrary("flutter");
    VsyncWaiter.getInstance((WindowManager)paramContext.getSystemService("window")).init();
    FlutterJNI.nativeRecordStartTimestamp(SystemClock.uptimeMillis() - l);
    AppMethodBeat.o(192826);
  }
  
  public final void ensureInitializationComplete(Context paramContext, String[] paramArrayOfString)
  {
    AppMethodBeat.i(192827);
    if (this.KMr)
    {
      AppMethodBeat.o(192827);
      return;
    }
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      paramContext = new IllegalStateException("ensureInitializationComplete must be called on the main thread");
      AppMethodBeat.o(192827);
      throw paramContext;
    }
    if (this.KMt == null)
    {
      paramContext = new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
      AppMethodBeat.o(192827);
      throw paramContext;
    }
    try
    {
      if (this.KMs != null) {
        this.KMs.fNt();
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("--icu-symbol-prefix=_binary_icudtl_dat");
      Object localObject = K(paramContext);
      localArrayList.add("--icu-native-lib-path=" + ((ApplicationInfo)localObject).nativeLibraryDir + File.separator + "libflutter.so");
      if (paramArrayOfString != null) {
        Collections.addAll(localArrayList, paramArrayOfString);
      }
      localArrayList.add("--aot-shared-library-name=" + this.KMm);
      localArrayList.add("--aot-shared-library-name=" + ((ApplicationInfo)localObject).nativeLibraryDir + File.separator + this.KMm);
      localArrayList.add("--cache-dir-path=" + io.flutter.b.a.ly(paramContext));
      if (this.KMt.kSu != null) {
        localArrayList.add("--log-tag=" + this.KMt.kSu);
      }
      paramArrayOfString = paramContext.getFilesDir().getPath();
      localObject = io.flutter.b.a.ly(paramContext);
      FlutterJNI.nativeInit(paramContext, (String[])localArrayList.toArray(new String[0]), null, paramArrayOfString, (String)localObject);
      this.KMr = true;
      AppMethodBeat.o(192827);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext = new RuntimeException(paramContext);
      AppMethodBeat.o(192827);
      throw paramContext;
    }
  }
  
  public final String getLookupKeyForAsset(String paramString)
  {
    AppMethodBeat.i(192831);
    paramString = this.KMp + File.separator + paramString;
    AppMethodBeat.o(192831);
    return paramString;
  }
  
  public final void startInitialization(Context paramContext)
  {
    AppMethodBeat.i(192825);
    a(paramContext, new a());
    AppMethodBeat.o(192825);
  }
  
  public static final class a
  {
    public String kSu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.a.a
 * JD-Core Version:    0.7.0.1
 */