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

public class i
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
    AppMethodBeat.i(219486);
    a = null;
    b = null;
    c = "sandbox_crash_record0";
    d = "sandbox_crash_record1";
    e = null;
    f = new HashMap();
    g = "/data/data/com.tencent.mm/app_tbs/core_share/";
    h = "/data/data/com.tbs.default/app_tbs/core_share/";
    AppMethodBeat.o(219486);
  }
  
  public static ParcelFileDescriptor a()
  {
    AppMethodBeat.i(219429);
    if (b != null)
    {
      ParcelFileDescriptor localParcelFileDescriptor = b.getFdByFileName(c);
      AppMethodBeat.o(219429);
      return localParcelFileDescriptor;
    }
    AppMethodBeat.o(219429);
    return null;
  }
  
  public static String a(String paramString)
  {
    AppMethodBeat.i(219468);
    if (paramString == null)
    {
      AppMethodBeat.o(219468);
      return paramString;
    }
    Iterator localIterator = f.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramString = paramString.replace(String.format("[anon:libc_malloc:%s]", new Object[] { f.get(str) }), g + str);
    }
    paramString = paramString.replace("[anon:libc_malloc]", h + "libmttwebview.so");
    AppMethodBeat.o(219468);
    return paramString;
  }
  
  public static String a(String paramString, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(219458);
    new StringBuilder(" [").append(java.lang.Thread.currentThread().getStackTrace()[2].getMethodName()).append("] libraryName: ").append(paramString).append(", parcelFileDescriptor: ").append(paramParcelFileDescriptor);
    int j = paramParcelFileDescriptor.getFd();
    i = j;
    Object localObject2;
    if (j == -1)
    {
      localObject2 = paramParcelFileDescriptor.getFileDescriptor();
      k = j;
    }
    try
    {
      Method localMethod = FileDescriptor.class.getDeclaredMethod("getInt$", new Class[0]);
      k = j;
      localObject2 = localMethod.invoke(localObject2, new Object[0]);
      i = j;
      k = j;
      if ((localObject2 instanceof Integer))
      {
        k = j;
        i = ((Integer)localObject2).intValue();
      }
      k = i;
      new StringBuilder("loadLibraryByPrivateLinker -- method:").append(localMethod).append(", fd_internal: ").append(localObject2);
    }
    finally
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
    AppMethodBeat.o(219458);
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
    AppMethodBeat.i(219482);
    String str = b(paramContext);
    new StringBuilder("[").append(java.lang.Thread.currentThread().getStackTrace()[2].getMethodName()).append("] hostContext: ").append(paramContext).append(" libraryPath: ").append(str);
    try
    {
      libwebp.loadWepLibraryIfNeed(paramContext, str);
      paramContext = str + File.separator + "libmttwebview.so";
      new StringBuilder("[").append(java.lang.Thread.currentThread().getStackTrace()[2].getMethodName()).append("] loading library: ").append(paramContext);
      System.load(paramContext);
      return true;
    }
    finally
    {
      AppMethodBeat.o(219482);
    }
    return false;
  }
  
  public static boolean a(Context paramContext, ParcelFileDescriptor[] paramArrayOfParcelFileDescriptor)
  {
    AppMethodBeat.i(219475);
    new StringBuilder("[").append(java.lang.Thread.currentThread().getStackTrace()[2].getMethodName()).append("] hostContext: ").append(paramContext);
    try
    {
      a("libwebp_base.so", paramArrayOfParcelFileDescriptor[0]);
      a("libmttwebview.so", paramArrayOfParcelFileDescriptor[1]);
      return true;
    }
    finally
    {
      AppMethodBeat.o(219475);
    }
    return false;
  }
  
  public static ParcelFileDescriptor b()
  {
    AppMethodBeat.i(219434);
    if (b != null)
    {
      ParcelFileDescriptor localParcelFileDescriptor = b.getFdByFileName(d);
      AppMethodBeat.o(219434);
      return localParcelFileDescriptor;
    }
    AppMethodBeat.o(219434);
    return null;
  }
  
  private static String b(Context paramContext)
  {
    AppMethodBeat.i(219478);
    paramContext = q.a().r(paramContext).getAbsolutePath();
    AppMethodBeat.o(219478);
    return paramContext;
  }
  
  public static void c()
  {
    AppMethodBeat.i(219445);
    ParcelFileDescriptor localParcelFileDescriptor1 = a();
    ParcelFileDescriptor localParcelFileDescriptor2 = b();
    if (e != null) {
      e.setCrashRecordFileDescriptor(localParcelFileDescriptor1, localParcelFileDescriptor2);
    }
    AppMethodBeat.o(219445);
  }
  
  public static void d()
  {
    try
    {
      AppMethodBeat.i(219450);
      new StringBuilder("[").append(java.lang.Thread.currentThread().getStackTrace()[2].getMethodName()).append("]");
      Linker localLinker = Linker.getInstance();
      localLinker.disableSharedRelros();
      localLinker.prepareLibraryLoad();
      a = localLinker;
      AppMethodBeat.o(219450);
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
    AppMethodBeat.i(219462);
    Iterator localIterator = f.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      new StringBuilder("@TbsLinker -- loaded library : ").append(str).append(", start_address: ").append((String)f.get(str));
    }
    AppMethodBeat.o(219462);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.i
 * JD-Core Version:    0.7.0.1
 */