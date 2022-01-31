package com.tencent.tencentmap.mapsdk.a;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import java.util.Date;
import java.util.Map;

public class df
{
  protected static Map<String, String> a = null;
  private static Context b = null;
  private static String c = "";
  private static String d = "10000";
  private static String e = "";
  private static Runnable f = new df.1();
  
  public static String a()
  {
    return d;
  }
  
  public static void a(Context paramContext)
  {
    a(paramContext, null, true, 0L);
  }
  
  @TargetApi(14)
  private static void a(Context paramContext, dr paramdr, boolean paramBoolean, long paramLong)
  {
    if (paramContext == null)
    {
      cy.c(" the context is null! init beacon sdk failed!", new Object[0]);
      return;
    }
    Context localContext = paramContext.getApplicationContext();
    if (localContext != null) {}
    for (b = localContext;; b = paramContext)
    {
      if (paramLong > 0L)
      {
        long l = paramLong;
        if (paramLong > 10000L) {
          l = 10000L;
        }
        cl.a(l);
      }
      paramLong = new Date().getTime();
      if (Integer.valueOf(Build.VERSION.SDK).intValue() >= 14)
      {
        paramContext = new f();
        ((Application)b).registerActivityLifecycleCallbacks(paramContext);
      }
      cy.a("initUserAction t1:" + (new Date().getTime() - paramLong), new Object[0]);
      paramContext = dq.a(b, a(paramBoolean));
      dq.a(b, paramContext, paramdr);
      cy.a("initUserAction t1:" + (new Date().getTime() - paramLong), new Object[0]);
      return;
    }
  }
  
  public static void a(String paramString)
  {
    if ((paramString != null) && (!paramString.trim().equals(""))) {
      a.a(paramString);
    }
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    cy.a = paramBoolean1;
    cy.b = paramBoolean2;
  }
  
  private static boolean a(boolean paramBoolean)
  {
    boolean bool = true;
    if (!paramBoolean) {
      paramBoolean = false;
    }
    String str;
    int k;
    int i;
    label62:
    do
    {
      return paramBoolean;
      str = a.b(b, "pid_stat", "");
      k = Process.myPid();
      if ("".equals(str))
      {
        a.c(b, String.valueOf(k));
        return true;
      }
      i = -1;
      try
      {
        int j = Integer.valueOf(str).intValue();
        i = j;
      }
      catch (Exception localException)
      {
        break label62;
      }
      paramBoolean = bool;
    } while (i == k);
    if (!a.a(b, i))
    {
      a.c(b, str);
      return true;
    }
    return false;
  }
  
  public static String b()
  {
    return c;
  }
  
  public static void b(String paramString)
  {
    if ((paramString != null) && (!paramString.equals(""))) {
      e = paramString;
    }
  }
  
  public static Map<String, String> c()
  {
    return a;
  }
  
  public static void c(String paramString)
  {
    c localc2 = c.m();
    c localc1 = localc2;
    if (localc2 == null)
    {
      c.a(b);
      localc1 = c.m();
    }
    if (localc1 == null)
    {
      cy.d("please set the channelID after call initUserAction!", new Object[0]);
      return;
    }
    localc1.c(e.b(paramString));
  }
  
  public static String d()
  {
    return e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.df
 * JD-Core Version:    0.7.0.1
 */