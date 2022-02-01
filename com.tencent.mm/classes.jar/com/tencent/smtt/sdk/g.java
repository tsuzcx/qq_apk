package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.libwebp;
import com.tencent.smtt.library_loader.Linker;
import com.tencent.smtt.sandbox.ChildProcessService;
import com.tencent.smtt.sandbox.SandboxListener;
import java.io.File;
import java.io.FileDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class g
{
  private static Linker a;
  private static ChildProcessService b;
  private static String c;
  private static String d;
  private static SandboxListener e;
  private static Map<String, String> f;
  private static String g;
  private static String h;
  
  static
  {
    AppMethodBeat.i(55173);
    a = null;
    b = null;
    c = "sandbox_crash_record0";
    d = "sandbox_crash_record1";
    e = null;
    f = new HashMap();
    g = "/data/data/com.tencent.mm/app_tbs/core_share/";
    h = "/data/data/com.tbs.default/app_tbs/core_share/";
    AppMethodBeat.o(55173);
  }
  
  public static ParcelFileDescriptor a()
  {
    AppMethodBeat.i(55163);
    if (b != null)
    {
      ParcelFileDescriptor localParcelFileDescriptor = b.getFdByFileName(c);
      AppMethodBeat.o(55163);
      return localParcelFileDescriptor;
    }
    AppMethodBeat.o(55163);
    return null;
  }
  
  public static String a(String paramString)
  {
    AppMethodBeat.i(55169);
    if (paramString == null)
    {
      AppMethodBeat.o(55169);
      return paramString;
    }
    Iterator localIterator = f.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramString = paramString.replace(String.format("[anon:libc_malloc:%s]", new Object[] { f.get(str) }), g + str);
    }
    paramString = paramString.replace("[anon:libc_malloc]", h + "libmttwebview.so");
    AppMethodBeat.o(55169);
    return paramString;
  }
  
  public static String a(String paramString, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(55167);
    new StringBuilder(" [").append(java.lang.Thread.currentThread().getStackTrace()[2].getMethodName()).append("] libraryName: ").append(paramString).append(", parcelFileDescriptor: ").append(paramParcelFileDescriptor);
    int j = paramParcelFileDescriptor.getFd();
    i = j;
    Object localObject;
    if (j == -1)
    {
      localObject = paramParcelFileDescriptor.getFileDescriptor();
      k = j;
    }
    try
    {
      Method localMethod = FileDescriptor.class.getDeclaredMethod("getInt$", new Class[0]);
      k = j;
      localObject = localMethod.invoke(localObject, new Object[0]);
      i = j;
      k = j;
      if ((localObject instanceof Integer))
      {
        k = j;
        i = ((Integer)localObject).intValue();
      }
      k = i;
      new StringBuilder("loadLibraryByPrivateLinker -- method:").append(localMethod).append(", fd_internal: ").append(localObject);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        long l;
        i = k;
      }
    }
    l = paramParcelFileDescriptor.getStatSize();
    new StringBuilder("loadLibraryByPrivateLinker -- loadLibraryByFd: ").append(paramParcelFileDescriptor).append(", size: ").append(l).append(", name: ").append(paramString).append(", nativeFd: ").append(i);
    paramParcelFileDescriptor = a.loadLibraryByFd(paramParcelFileDescriptor, l, paramString, i);
    f.put(paramString, paramParcelFileDescriptor.substring(2));
    AppMethodBeat.o(55167);
    return paramParcelFileDescriptor;
  }
  
  public static void a(ChildProcessService paramChildProcessService)
  {
    b = paramChildProcessService;
  }
  
  public static void a(SandboxListener paramSandboxListener)
  {
    e = paramSandboxListener;
  }
  
  public static boolean a(Context paramContext)
  {
    AppMethodBeat.i(55172);
    String str = b(paramContext);
    new StringBuilder("[").append(java.lang.Thread.currentThread().getStackTrace()[2].getMethodName()).append("] hostContext: ").append(paramContext).append(" libraryPath: ").append(str);
    try
    {
      libwebp.loadWepLibraryIfNeed(paramContext, str);
      paramContext = str + File.separator + "libmttwebview.so";
      new StringBuilder("[").append(java.lang.Thread.currentThread().getStackTrace()[2].getMethodName()).append("] loading library: ").append(paramContext);
      System.load(paramContext);
      AppMethodBeat.o(55172);
      return true;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(55172);
    }
    return false;
  }
  
  public static boolean a(Context paramContext, ParcelFileDescriptor[] paramArrayOfParcelFileDescriptor)
  {
    AppMethodBeat.i(55170);
    new StringBuilder("[").append(java.lang.Thread.currentThread().getStackTrace()[2].getMethodName()).append("] hostContext: ").append(paramContext);
    try
    {
      a("libwebp_base.so", paramArrayOfParcelFileDescriptor[0]);
      a("libmttwebview.so", paramArrayOfParcelFileDescriptor[1]);
      AppMethodBeat.o(55170);
      return true;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(55170);
    }
    return false;
  }
  
  public static ParcelFileDescriptor b()
  {
    AppMethodBeat.i(55164);
    if (b != null)
    {
      ParcelFileDescriptor localParcelFileDescriptor = b.getFdByFileName(d);
      AppMethodBeat.o(55164);
      return localParcelFileDescriptor;
    }
    AppMethodBeat.o(55164);
    return null;
  }
  
  private static String b(Context paramContext)
  {
    AppMethodBeat.i(55171);
    paramContext = o.a().q(paramContext).getAbsolutePath();
    AppMethodBeat.o(55171);
    return paramContext;
  }
  
  public static void c()
  {
    AppMethodBeat.i(55165);
    ParcelFileDescriptor localParcelFileDescriptor1 = a();
    ParcelFileDescriptor localParcelFileDescriptor2 = b();
    if (e != null) {
      e.setCrashRecordFileDescriptor(localParcelFileDescriptor1, localParcelFileDescriptor2);
    }
    AppMethodBeat.o(55165);
  }
  
  public static void d()
  {
    try
    {
      AppMethodBeat.i(55166);
      new StringBuilder("[").append(java.lang.Thread.currentThread().getStackTrace()[2].getMethodName()).append("]");
      Linker localLinker = Linker.getInstance();
      localLinker.disableSharedRelros();
      localLinker.prepareLibraryLoad();
      a = localLinker;
      AppMethodBeat.o(55166);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void e()
  {
    AppMethodBeat.i(55168);
    Iterator localIterator = f.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      new StringBuilder("@TbsLinker -- loaded library : ").append(str).append(", start_address: ").append((String)f.get(str));
    }
    AppMethodBeat.o(55168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.g
 * JD-Core Version:    0.7.0.1
 */