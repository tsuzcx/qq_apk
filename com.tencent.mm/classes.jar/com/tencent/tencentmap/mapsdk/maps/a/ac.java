package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ac
{
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  public static volatile boolean e = false;
  public static boolean f = true;
  private static Context g = null;
  private static String h = "DefaultSessionId";
  private static long i;
  private static int j = 0;
  private static boolean k = false;
  private static String l = "";
  private static String m;
  private static String n;
  private static boolean o;
  private static String p;
  private static Handler q;
  private static boolean r = false;
  
  static
  {
    a = "null";
    b = "";
    c = "";
    d = "";
    m = "3.5.1.18";
    n = "";
    o = false;
    p = "";
  }
  
  public static Context a()
  {
    return g;
  }
  
  public static void a(boolean paramBoolean, int paramInt1, q paramq, String paramString, int paramInt2)
  {
    AppMethodBeat.i(147192);
    r = paramBoolean;
    i = SystemClock.elapsedRealtime();
    Process.myPid();
    Context localContext = paramq.a();
    g = localContext.getApplicationContext();
    l = localContext.getPackageName();
    j = paramInt1;
    k = paramq.d();
    String str2 = paramq.c();
    String str1 = str2;
    if (dd.a(str2)) {
      str1 = "";
    }
    c = str1;
    str1 = paramq.b();
    paramq = str1;
    if (dd.a(str1)) {
      paramq = "";
    }
    d = paramq;
    m = "3.5.1.18";
    new Handler(g.getMainLooper());
    try
    {
      paramq = localContext.getPackageManager().getPackageInfo(localContext.getPackageName(), 0);
      a = paramq.versionName;
      paramInt1 = paramq.versionCode;
      b = paramq.applicationInfo.loadLabel(localContext.getPackageManager()).toString();
      label169:
      n = paramString;
      o = l.equals(n);
      paramq = new HandlerThread("halley_" + j + "_" + "TempTask", 10);
      paramq.start();
      paramq = new Handler(paramq.getLooper());
      q = paramq;
      paramq.post(new ax());
      AppMethodBeat.o(147192);
      return;
    }
    catch (Throwable paramq)
    {
      break label169;
    }
  }
  
  public static boolean b()
  {
    return r;
  }
  
  public static int c()
  {
    return j;
  }
  
  public static String d()
  {
    return h;
  }
  
  public static int e()
  {
    AppMethodBeat.i(147193);
    int i1 = (int)(SystemClock.elapsedRealtime() - i);
    AppMethodBeat.o(147193);
    return i1;
  }
  
  public static String f()
  {
    return l;
  }
  
  public static boolean g()
  {
    return k;
  }
  
  public static String h()
  {
    return m;
  }
  
  public static String i()
  {
    AppMethodBeat.i(147194);
    String str;
    if (!dd.a(p))
    {
      str = p;
      AppMethodBeat.o(147194);
      return str;
    }
    if ((!dd.a(n)) && (n.contains(":")))
    {
      int i1 = n.indexOf(":");
      str = n.substring(i1 + 1);
      AppMethodBeat.o(147194);
      return str;
    }
    AppMethodBeat.o(147194);
    return "";
  }
  
  public static Handler j()
  {
    return q;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ac
 * JD-Core Version:    0.7.0.1
 */