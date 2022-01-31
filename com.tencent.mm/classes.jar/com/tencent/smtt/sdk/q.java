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

public class q
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
    AppMethodBeat.i(139057);
    a = null;
    b = null;
    c = "sandbox_crash_record0";
    d = "sandbox_crash_record1";
    e = null;
    f = new HashMap();
    g = "/data/data/com.tencent.mm/app_tbs/core_share/";
    h = "/data/data/com.tbs.default/app_tbs/core_share/";
    AppMethodBeat.o(139057);
  }
  
  public static ParcelFileDescriptor a()
  {
    AppMethodBeat.i(139047);
    if (b != null)
    {
      ParcelFileDescriptor localParcelFileDescriptor = b.getFdByFileName(c);
      AppMethodBeat.o(139047);
      return localParcelFileDescriptor;
    }
    AppMethodBeat.o(139047);
    return null;
  }
  
  public static String a(String paramString)
  {
    AppMethodBeat.i(139053);
    if (paramString == null)
    {
      AppMethodBeat.o(139053);
      return paramString;
    }
    Iterator localIterator = f.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramString = paramString.replace(String.format("[anon:libc_malloc:%s]", new Object[] { f.get(str) }), g + str);
    }
    paramString = paramString.replace("[anon:libc_malloc]", h + "libmttwebview.so");
    AppMethodBeat.o(139053);
    return paramString;
  }
  
  public static String a(String paramString, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(139051);
    int i = paramParcelFileDescriptor.getFd();
    Object localObject;
    if (i == -1) {
      localObject = paramParcelFileDescriptor.getFileDescriptor();
    }
    label107:
    for (;;)
    {
      try
      {
        localObject = FileDescriptor.class.getDeclaredMethod("getInt$", new Class[0]).invoke(localObject, new Object[0]);
        if (!(localObject instanceof Integer)) {
          break label107;
        }
        int j = ((Integer)localObject).intValue();
        i = j;
        long l = paramParcelFileDescriptor.getStatSize();
        paramParcelFileDescriptor = a.loadLibraryByFd(paramParcelFileDescriptor, l, paramString, i);
        f.put(paramString, paramParcelFileDescriptor.substring(2));
        AppMethodBeat.o(139051);
        return paramParcelFileDescriptor;
      }
      catch (Throwable localThrowable) {}
    }
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
    AppMethodBeat.i(139056);
    String str = b(paramContext);
    try
    {
      libwebp.loadWepLibraryIfNeed(paramContext, str);
      System.load(str + File.separator + "libmttwebview.so");
      AppMethodBeat.o(139056);
      return true;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(139056);
    }
    return false;
  }
  
  public static boolean a(Context paramContext, ParcelFileDescriptor[] paramArrayOfParcelFileDescriptor)
  {
    AppMethodBeat.i(139054);
    try
    {
      a("libwebp_base.so", paramArrayOfParcelFileDescriptor[0]);
      a("libmttwebview.so", paramArrayOfParcelFileDescriptor[1]);
      AppMethodBeat.o(139054);
      return true;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(139054);
    }
    return false;
  }
  
  public static ParcelFileDescriptor b()
  {
    AppMethodBeat.i(139048);
    if (b != null)
    {
      ParcelFileDescriptor localParcelFileDescriptor = b.getFdByFileName(d);
      AppMethodBeat.o(139048);
      return localParcelFileDescriptor;
    }
    AppMethodBeat.o(139048);
    return null;
  }
  
  private static String b(Context paramContext)
  {
    AppMethodBeat.i(139055);
    paramContext = ao.a().q(paramContext).getAbsolutePath();
    AppMethodBeat.o(139055);
    return paramContext;
  }
  
  public static void c()
  {
    AppMethodBeat.i(139049);
    ParcelFileDescriptor localParcelFileDescriptor1 = a();
    ParcelFileDescriptor localParcelFileDescriptor2 = b();
    if (e != null) {
      e.setCrashRecordFileDescriptor(localParcelFileDescriptor1, localParcelFileDescriptor2);
    }
    AppMethodBeat.o(139049);
  }
  
  public static void d()
  {
    try
    {
      AppMethodBeat.i(139050);
      Linker localLinker = Linker.getInstance();
      localLinker.disableSharedRelros();
      localLinker.prepareLibraryLoad();
      a = localLinker;
      AppMethodBeat.o(139050);
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
    AppMethodBeat.i(139052);
    Iterator localIterator = f.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      new StringBuilder("@TbsLinker -- loaded library : ").append(str).append(", start_address: ").append((String)f.get(str));
    }
    AppMethodBeat.o(139052);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.q
 * JD-Core Version:    0.7.0.1
 */