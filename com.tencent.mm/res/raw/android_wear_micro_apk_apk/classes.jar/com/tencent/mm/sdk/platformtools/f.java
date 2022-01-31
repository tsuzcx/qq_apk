package com.tencent.mm.sdk.platformtools;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;

public final class f
{
  private static g Xj;
  private static g Xk;
  private static final String Xl;
  private static int level = 6;
  
  static
  {
    Object localObject = new g()
    {
      private Handler handler = new Handler(Looper.getMainLooper());
      
      public final void g(String paramAnonymousString1, String paramAnonymousString2)
      {
        if (f.ln() <= 0) {
          Log.v(paramAnonymousString1, paramAnonymousString2);
        }
      }
      
      public final void h(String paramAnonymousString1, String paramAnonymousString2)
      {
        if (f.ln() <= 2) {
          Log.i(paramAnonymousString1, paramAnonymousString2);
        }
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2)
      {
        if (f.ln() <= 1) {
          Log.d(paramAnonymousString1, paramAnonymousString2);
        }
      }
      
      public final void j(String paramAnonymousString1, String paramAnonymousString2)
      {
        if (f.ln() <= 3) {
          Log.w(paramAnonymousString1, paramAnonymousString2);
        }
      }
      
      public final void k(String paramAnonymousString1, String paramAnonymousString2)
      {
        if (f.ln() <= 4) {
          Log.e(paramAnonymousString1, paramAnonymousString2);
        }
      }
      
      public final int lo()
      {
        return f.ln();
      }
    };
    Xj = (g)localObject;
    Xk = (g)localObject;
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
      Xl = ((StringBuilder)localObject).toString();
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
    if ((Xk != null) && (Xk.lo() <= 4)) {
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
      paramString2 = Xk;
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
    if ((Xk != null) && (Xk.lo() <= 4))
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      paramThrowable = paramString2 + "  " + Log.getStackTraceString(paramThrowable);
      paramString2 = Xk;
      Process.myTid();
      Process.myPid();
      Thread.currentThread().getId();
      Looper.getMainLooper().getThread().getId();
      paramString2.k(paramString1, paramThrowable);
    }
  }
  
  public static void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if ((Xk != null) && (Xk.lo() <= 3)) {
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
      paramString2 = Xk;
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
    if ((Xk != null) && (Xk.lo() <= 2)) {
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
      paramString2 = Xk;
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
    if ((Xk != null) && (Xk.lo() <= 0))
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      paramVarArgs = Xk;
      Process.myTid();
      Process.myPid();
      Thread.currentThread().getId();
      Looper.getMainLooper().getThread().getId();
      paramVarArgs.g(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    c(paramString1, paramString2, null);
  }
  
  public static void f(String paramString1, String paramString2)
  {
    if ((Xk != null) && (Xk.lo() <= 1))
    {
      g localg = Xk;
      Process.myTid();
      Process.myPid();
      Thread.currentThread().getId();
      Looper.getMainLooper().getThread().getId();
      localg.i(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.f
 * JD-Core Version:    0.7.0.1
 */