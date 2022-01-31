package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.os.SystemClock;

public final class em
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
  
  public static void a(boolean paramBoolean, int paramInt1, ea paramea, String paramString, int paramInt2)
  {
    r = paramBoolean;
    i = SystemClock.elapsedRealtime();
    Process.myPid();
    Context localContext = paramea.a();
    g = localContext.getApplicationContext();
    l = localContext.getPackageName();
    j = paramInt1;
    k = paramea.d();
    String str2 = paramea.c();
    String str1 = str2;
    if (hq.a(str2)) {
      str1 = "";
    }
    c = str1;
    str1 = paramea.b();
    paramea = str1;
    if (hq.a(str1)) {
      paramea = "";
    }
    d = paramea;
    m = "3.5.1.18";
    new Handler(g.getMainLooper());
    try
    {
      paramea = localContext.getPackageManager().getPackageInfo(localContext.getPackageName(), 0);
      a = paramea.versionName;
      paramInt1 = paramea.versionCode;
      b = paramea.applicationInfo.loadLabel(localContext.getPackageManager()).toString();
      label164:
      n = paramString;
      o = l.equals(n);
      paramea = new HandlerThread("halley_" + j + "_" + "TempTask", 10);
      paramea.start();
      paramea = new Handler(paramea.getLooper());
      q = paramea;
      paramea.post(new fi());
      return;
    }
    catch (Throwable paramea)
    {
      break label164;
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
    return (int)(SystemClock.elapsedRealtime() - i);
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
    if (!hq.a(p)) {
      return p;
    }
    if ((!hq.a(n)) && (n.contains(":")))
    {
      int i1 = n.indexOf(":");
      return n.substring(i1 + 1);
    }
    return "";
  }
  
  public static Handler j()
  {
    return q;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.em
 * JD-Core Version:    0.7.0.1
 */