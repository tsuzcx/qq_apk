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
  private static final String Nak;
  private static final String Nal;
  private static final String Nam;
  private static final String Nan;
  private static a Nas;
  private String Nao = "libapp.so";
  private String Nap = "vm_snapshot_data";
  private String Naq = "isolate_snapshot_data";
  public String Nar = "flutter_assets";
  public boolean Nat = false;
  private c Nau;
  public a Nav;
  
  static
  {
    AppMethodBeat.i(197863);
    Nak = a.class.getName() + '.' + "aot-shared-library-name";
    Nal = a.class.getName() + '.' + "vm-snapshot-data";
    Nam = a.class.getName() + '.' + "isolate-snapshot-data";
    Nan = a.class.getName() + '.' + "flutter-assets-dir";
    AppMethodBeat.o(197863);
  }
  
  private static ApplicationInfo L(Context paramContext)
  {
    AppMethodBeat.i(197859);
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      AppMethodBeat.o(197859);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext = new RuntimeException(paramContext);
      AppMethodBeat.o(197859);
      throw paramContext;
    }
  }
  
  public static a gjs()
  {
    AppMethodBeat.i(197855);
    if (Nas == null) {
      Nas = new a();
    }
    a locala = Nas;
    AppMethodBeat.o(197855);
    return locala;
  }
  
  private void lO(Context paramContext)
  {
    AppMethodBeat.i(197860);
    paramContext = L(paramContext).metaData;
    if (paramContext == null)
    {
      AppMethodBeat.o(197860);
      return;
    }
    this.Nao = paramContext.getString(Nak, "libapp.so");
    this.Nar = paramContext.getString(Nan, "flutter_assets");
    this.Nap = paramContext.getString(Nal, "vm_snapshot_data");
    this.Naq = paramContext.getString(Nam, "isolate_snapshot_data");
    AppMethodBeat.o(197860);
  }
  
  private static void lP(Context paramContext)
  {
    AppMethodBeat.i(197861);
    new b(paramContext).start();
    AppMethodBeat.o(197861);
  }
  
  public final void a(Context paramContext, a parama)
  {
    AppMethodBeat.i(197857);
    if (this.Nav != null)
    {
      AppMethodBeat.o(197857);
      return;
    }
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      paramContext = new IllegalStateException("startInitialization must be called on the main thread");
      AppMethodBeat.o(197857);
      throw paramContext;
    }
    paramContext = paramContext.getApplicationContext();
    this.Nav = parama;
    long l = SystemClock.uptimeMillis();
    lO(paramContext);
    lP(paramContext);
    System.loadLibrary("flutter");
    VsyncWaiter.getInstance((WindowManager)paramContext.getSystemService("window")).init();
    FlutterJNI.nativeRecordStartTimestamp(SystemClock.uptimeMillis() - l);
    AppMethodBeat.o(197857);
  }
  
  public final void ensureInitializationComplete(Context paramContext, String[] paramArrayOfString)
  {
    AppMethodBeat.i(197858);
    if (this.Nat)
    {
      AppMethodBeat.o(197858);
      return;
    }
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      paramContext = new IllegalStateException("ensureInitializationComplete must be called on the main thread");
      AppMethodBeat.o(197858);
      throw paramContext;
    }
    if (this.Nav == null)
    {
      paramContext = new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
      AppMethodBeat.o(197858);
      throw paramContext;
    }
    try
    {
      if (this.Nau != null) {
        this.Nau.gju();
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("--icu-symbol-prefix=_binary_icudtl_dat");
      Object localObject = L(paramContext);
      localArrayList.add("--icu-native-lib-path=" + ((ApplicationInfo)localObject).nativeLibraryDir + File.separator + "libflutter.so");
      if (paramArrayOfString != null) {
        Collections.addAll(localArrayList, paramArrayOfString);
      }
      localArrayList.add("--aot-shared-library-name=" + this.Nao);
      localArrayList.add("--aot-shared-library-name=" + ((ApplicationInfo)localObject).nativeLibraryDir + File.separator + this.Nao);
      localArrayList.add("--cache-dir-path=" + io.flutter.b.a.lQ(paramContext));
      if (this.Nav.ltu != null) {
        localArrayList.add("--log-tag=" + this.Nav.ltu);
      }
      paramArrayOfString = paramContext.getFilesDir().getPath();
      localObject = io.flutter.b.a.lQ(paramContext);
      FlutterJNI.nativeInit(paramContext, (String[])localArrayList.toArray(new String[0]), null, paramArrayOfString, (String)localObject);
      this.Nat = true;
      AppMethodBeat.o(197858);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext = new RuntimeException(paramContext);
      AppMethodBeat.o(197858);
      throw paramContext;
    }
  }
  
  public final String getLookupKeyForAsset(String paramString)
  {
    AppMethodBeat.i(197862);
    paramString = this.Nar + File.separator + paramString;
    AppMethodBeat.o(197862);
    return paramString;
  }
  
  public final void startInitialization(Context paramContext)
  {
    AppMethodBeat.i(197856);
    a(paramContext, new a());
    AppMethodBeat.o(197856);
  }
  
  public static final class a
  {
    public String ltu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.a.a
 * JD-Core Version:    0.7.0.1
 */