package com.tencent.mm.sdk.platformtools;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;

public final class f
{
  private static g Zl;
  private static g Zm;
  private static final String Zn;
  private static int level = 6;
  
  static
  {
    Object localObject = new g()
    {
      private Handler handler = new Handler(Looper.getMainLooper());
      
      public final void g(String paramAnonymousString1, String paramAnonymousString2)
      {
        if (f.lA() <= 0) {
          Log.v(paramAnonymousString1, paramAnonymousString2);
        }
      }
      
      public final int getLogLevel()
      {
        return f.lA();
      }
      
      public final void h(String paramAnonymousString1, String paramAnonymousString2)
      {
        if (f.lA() <= 2) {
          Log.i(paramAnonymousString1, paramAnonymousString2);
        }
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2)
      {
        if (f.lA() <= 1) {
          Log.d(paramAnonymousString1, paramAnonymousString2);
        }
      }
      
      public final void j(String paramAnonymousString1, String paramAnonymousString2)
      {
        if (f.lA() <= 3) {
          Log.w(paramAnonymousString1, paramAnonymousString2);
        }
      }
      
      public final void k(String paramAnonymousString1, String paramAnonymousString2)
      {
        if (f.lA() <= 4) {
          Log.e(paramAnonymousString1, paramAnonymousString2);
        }
      }
    };
    Zl = (g)localObject;
    Zm = (g)localObject;
    localObject = new StringBuilder();
    try
    {
      ((StringBuilder)localObject).append("VERSION.RELEASE:[" + Build.VERSION.RELEASE);
      ((StringBuilder)localObject).append("] VERSION.CODENAME:[" + Build.VERSION.CODENAME);
      ((StringBuilder)localObject).append("] VERSION.INCREMENTAL:[" + Build.VERSION.INCREMENTAL);
      ((StringBuilder)localObject).append("] BOARD:[" + Build.BOARD);
      ((StringBuilder)localObject).append("] DEVICE:[" + Build.DEVICE);
      ((StringBuilder)localObject).append("] DISPLAY:[" + Build.DISPLAY);
      ((StringBuilder)localObject).append("] FINGERPRINT:[" + Build.FINGERPRINT);
      ((StringBuilder)localObject).append("] HOST:[" + Build.HOST);
      ((StringBuilder)localObject).append("] MANUFACTURER:[" + Build.MANUFACTURER);
      ((StringBuilder)localObject).append("] MODEL:[" + Build.MODEL);
      ((StringBuilder)localObject).append("] PRODUCT:[" + Build.PRODUCT);
      ((StringBuilder)localObject).append("] TAGS:[" + Build.TAGS);
      ((StringBuilder)localObject).append("] TYPE:[" + Build.TYPE);
      ((StringBuilder)localObject).append("] USER:[" + Build.USER + "]");
      Zn = ((StringBuilder)localObject).toString();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a("MicroMsg.SDK.Log", localThrowable, "", new Object[0]);
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((Zm != null) && (Zm.getLogLevel() <= 4)) {
      if (paramVarArgs != null) {
        break label69;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      paramString2 = Zm;
      Process.myTid();
      Process.myPid();
      Thread.currentThread().getId();
      Looper.getMainLooper().getThread().getId();
      paramString2.k(paramString1, paramVarArgs);
      return;
      label69:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void a(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if ((Zm != null) && (Zm.getLogLevel() <= 4))
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      paramThrowable = paramString2 + "  " + Log.getStackTraceString(paramThrowable);
      paramString2 = Zm;
      Process.myTid();
      Process.myPid();
      Thread.currentThread().getId();
      Looper.getMainLooper().getThread().getId();
      paramString2.k(paramString1, paramThrowable);
    }
  }
  
  public static void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((Zm != null) && (Zm.getLogLevel() <= 3)) {
      if (paramVarArgs != null) {
        break label69;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      paramString2 = Zm;
      Process.myTid();
      Process.myPid();
      Thread.currentThread().getId();
      Looper.getMainLooper().getThread().getId();
      paramString2.j(paramString1, paramVarArgs);
      return;
      label69:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void c(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, null);
  }
  
  public static void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((Zm != null) && (Zm.getLogLevel() <= 2)) {
      if (paramVarArgs != null) {
        break label69;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      paramString2 = Zm;
      Process.myTid();
      Process.myPid();
      Thread.currentThread().getId();
      Looper.getMainLooper().getThread().getId();
      paramString2.h(paramString1, paramVarArgs);
      return;
      label69:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    b(paramString1, paramString2, null);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((Zm != null) && (Zm.getLogLevel() <= 1)) {
      if (paramVarArgs != null) {
        break label69;
      }
    }
    for (;;)
    {
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      paramString2 = Zm;
      Process.myTid();
      Process.myPid();
      Thread.currentThread().getId();
      Looper.getMainLooper().getThread().getId();
      paramString2.i(paramString1, paramVarArgs);
      return;
      label69:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    c(paramString1, paramString2, null);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((Zm != null) && (Zm.getLogLevel() <= 0))
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      paramVarArgs = Zm;
      Process.myTid();
      Process.myPid();
      Thread.currentThread().getId();
      Looper.getMainLooper().getThread().getId();
      paramVarArgs.g(paramString1, paramString2);
    }
  }
  
  public static void f(String paramString1, String paramString2)
  {
    d(paramString1, paramString2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.f
 * JD-Core Version:    0.7.0.1
 */