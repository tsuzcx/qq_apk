package com.tencent.mm.splash;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.system.OsConstants;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.bk;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private static String ulu;
  private static String ulv;
  private static File ulw;
  private static long ulx;
  @SuppressLint({"HandlerLeak"})
  private static Handler uly = new Handler(Looper.getMainLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      paramAnonymousMessage = (a.a)paramAnonymousMessage.obj;
      if (a.access$000()) {
        if (a.hw(a.ulx))
        {
          if (!a.gc(i.ulG))
          {
            i.cte().j(675L, 25L, 1L);
            paramAnonymousMessage.csR();
            return;
          }
          if (!a.gh(i.ulG)) {
            i.cte().j(675L, 18L, 1L);
          }
          i.cte().j(675L, 17L, 1L);
          paramAnonymousMessage.csS();
        }
      }
      for (;;)
      {
        a.csQ();
        return;
        a.c(paramAnonymousMessage);
        return;
        if (!a.ciX())
        {
          i.cte().j(675L, 15L, 1L);
          paramAnonymousMessage.csR();
        }
        else if (!a.gc(i.ulG))
        {
          i.cte().j(675L, 26L, 1L);
          i.cte().j(675L, 15L, 1L);
          paramAnonymousMessage.csR();
        }
        else
        {
          i.cte().j(675L, 16L, 1L);
          paramAnonymousMessage.bCD();
        }
      }
    }
  };
  
  public static void a(a parama)
  {
    b(parama);
  }
  
  private static void aax(String paramString)
  {
    try
    {
      String str = csN();
      File localFile = new File(str);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      paramString = new File(str + "/" + paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
      paramString.createNewFile();
      ulw = paramString;
      return;
    }
    finally {}
  }
  
  private static void b(a parama)
  {
    if (ulx == 0L) {
      ulx = System.currentTimeMillis();
    }
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    localMessage.obj = parama;
    uly.sendMessageDelayed(localMessage, 100L);
  }
  
  public static String csN()
  {
    if (ulu == null) {
      throw new IllegalStateException("data directory should not be null, give one.");
    }
    File localFile = new File(ulu);
    if ((!localFile.exists()) && (!localFile.mkdirs())) {
      i.c("WxSplash.DexOpt", "data directory create failed.", new Object[0]);
    }
    return ulu;
  }
  
  private static boolean csO()
  {
    if (ulw == null) {
      throw new IllegalStateException("tmp file field should not be null");
    }
    return ulw.exists();
  }
  
  private static boolean csP()
  {
    String str = csN();
    return new File(str + "/DexOpt_Failed").exists();
  }
  
  public static void e(Application paramApplication)
  {
    ulu = new File(paramApplication.getFilesDir(), "dexopt_service").getAbsolutePath();
  }
  
  public static boolean gc(Context paramContext)
  {
    boolean bool = i.ulJ.aH(paramContext);
    i.c("WxSplash.DexOpt", "if need dexopt %s", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public static void gd(Context paramContext)
  {
    if (g.pg) {}
    for (;;)
    {
      return;
      i.cte().j(675L, 22L, 1L);
      try
      {
        bool = i.ulJ.aG(paramContext);
        i.c("WxSplash.DexOpt", "install multidex result %s", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          continue;
        }
        i.c("WxSplash.DexOpt", "install multidex failed, kill self.", new Object[0]);
        i.csY();
        return;
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          i.a(paramContext, "multidex install failed");
          boolean bool = false;
        }
      }
    }
  }
  
  public static void ge(Context paramContext)
  {
    i.c("WxSplash.DexOpt", "start dex opt service", new Object[0]);
    String str = bk.am(paramContext, Process.myPid());
    str.replace(':', '_');
    ulv = "DexOpt_Request_" + str;
    i.cte().j(675L, 14L, 1L);
    try
    {
      aax(ulv);
      paramContext.startService(new Intent(paramContext, DexOptService.class));
      return;
    }
    catch (Exception localException)
    {
      if (Build.VERSION.SDK_INT > 19) {
        break label196;
      }
    }
    if (localException.getClass().getCanonicalName().equals("libcore.io.ErrnoException")) {}
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = localException.getClass().getField("errno");
        ((Field)localObject).setAccessible(true);
        if (((Integer)((Field)localObject).get(localException)).intValue() == OsConstants.ENOSPC)
        {
          localObject = new File(csN());
          if (((File)localObject).exists()) {
            break label205;
          }
          i = 1;
          if (i == 0) {
            break label242;
          }
          i.ulJ.aI(paramContext);
        }
      }
      catch (Exception paramContext)
      {
        i.c("WxSplash.DexOpt", "%s, %s", new Object[] { paramContext.getMessage() });
      }
      for (;;)
      {
        label196:
        throw new RuntimeException(localException);
        label205:
        i = ((File)localObject).listFiles().length;
        i.c("WxSplash.DexOpt", "check dexopt directory size %s.", new Object[] { Integer.valueOf(i) });
        if (i >= 10000) {
          break label280;
        }
        i = 1;
        break;
        label242:
        i.c("WxSplash.DexOpt", "check dexopt directory size not ok, clean it and throw exception.", new Object[0]);
        paramContext = new File(csN());
        if (paramContext.exists()) {
          e.l(paramContext);
        }
      }
      label280:
      int i = 0;
    }
  }
  
  private static boolean gf(Context paramContext)
  {
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext != null)
    {
      paramContext = paramContext.getRunningServices(2147483647);
      if (paramContext == null)
      {
        i.c("WxSplash.DexOpt", "dexopt service may dead, get running services return null.", new Object[0]);
        return false;
      }
      paramContext = paramContext.iterator();
      while (paramContext.hasNext()) {
        if ("com.tencent.mm.splash.DexOptService".equals(((ActivityManager.RunningServiceInfo)paramContext.next()).service.getClassName())) {
          return true;
        }
      }
    }
    i.c("WxSplash.DexOpt", "dexopt service may dead", new Object[0]);
    return false;
  }
  
  public static boolean gg(Context paramContext)
  {
    long l1 = 0L;
    long l3 = System.currentTimeMillis();
    i.c("WxSplash.DexOpt", "block checking dex opt result.", new Object[0]);
    while (csO())
    {
      long l2 = l1 + 1L;
      Thread.sleep(100L);
      l1 = l2;
      if (l2 >= 5L)
      {
        l1 = 0L;
        if (System.currentTimeMillis() - l3 > 180000L)
        {
          i.c("WxSplash.DexOpt", "block checking dex opt timeout.", new Object[0]);
          if (!gc(paramContext))
          {
            i.cte().j(675L, 25L, 1L);
            i.cte().j(675L, 15L, 1L);
            return true;
          }
          if (!gf(paramContext)) {
            i.cte().j(675L, 18L, 1L);
          }
          i.cte().j(675L, 17L, 1L);
          return false;
        }
      }
    }
    if (!csP())
    {
      i.cte().j(675L, 15L, 1L);
      return true;
    }
    if (!gc(paramContext))
    {
      i.cte().j(675L, 26L, 1L);
      i.cte().j(675L, 15L, 1L);
      return true;
    }
    i.cte().j(675L, 16L, 1L);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void bCD();
    
    public abstract void csR();
    
    public abstract void csS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.a
 * JD-Core Version:    0.7.0.1
 */