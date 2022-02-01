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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.e;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private static String NLr;
  private static String NLs;
  private static o NLt;
  private static long NLu;
  @SuppressLint({"HandlerLeak"})
  private static Handler NLv;
  
  static
  {
    AppMethodBeat.i(40605);
    NLv = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(40587);
        paramAnonymousMessage = (a.a)paramAnonymousMessage.obj;
        if (a.access$000()) {
          if (a.MI(a.NLu))
          {
            if (!a.jw(h.gNz))
            {
              h.gyq().idkey(675L, 25L, 1L);
              paramAnonymousMessage.gye();
              AppMethodBeat.o(40587);
              return;
            }
            if (!a.jB(h.gNz)) {
              h.gyq().idkey(675L, 18L, 1L);
            }
            h.gyq().idkey(675L, 17L, 1L);
            paramAnonymousMessage.gyf();
          }
        }
        for (;;)
        {
          a.gyd();
          AppMethodBeat.o(40587);
          return;
          a.c(paramAnonymousMessage);
          AppMethodBeat.o(40587);
          return;
          if (!a.WA())
          {
            h.gyq().idkey(675L, 15L, 1L);
            paramAnonymousMessage.gye();
          }
          else if (!a.jw(h.gNz))
          {
            h.gyq().idkey(675L, 26L, 1L);
            h.gyq().idkey(675L, 15L, 1L);
            paramAnonymousMessage.gye();
          }
          else
          {
            h.gyq().idkey(675L, 16L, 1L);
            paramAnonymousMessage.eZS();
          }
        }
      }
    };
    AppMethodBeat.o(40605);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(40596);
    b(parama);
    AppMethodBeat.o(40596);
  }
  
  private static void b(a parama)
  {
    AppMethodBeat.i(40597);
    if (NLu == 0L) {
      NLu = System.currentTimeMillis();
    }
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    localMessage.obj = parama;
    NLv.sendMessageDelayed(localMessage, 100L);
    AppMethodBeat.o(40597);
  }
  
  private static void bij(String paramString)
  {
    try
    {
      AppMethodBeat.i(40593);
      String str = gya();
      o localo = new o(str);
      if (!localo.exists()) {
        localo.mkdirs();
      }
      paramString = new o(str + "/" + paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
      paramString.createNewFile();
      NLt = paramString;
      AppMethodBeat.o(40593);
      return;
    }
    finally {}
  }
  
  public static String gya()
  {
    AppMethodBeat.i(40589);
    if (NLr == null)
    {
      localObject = new IllegalStateException("data directory should not be null, give one.");
      AppMethodBeat.o(40589);
      throw ((Throwable)localObject);
    }
    Object localObject = new o(NLr);
    if ((!((o)localObject).exists()) && (!((o)localObject).mkdirs())) {
      h.c("WxSplash.DexOpt", "data directory create failed.", new Object[0]);
    }
    localObject = NLr;
    AppMethodBeat.o(40589);
    return localObject;
  }
  
  private static boolean gyb()
  {
    AppMethodBeat.i(40598);
    if (NLt == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("tmp file field should not be null");
      AppMethodBeat.o(40598);
      throw localIllegalStateException;
    }
    boolean bool = NLt.exists();
    AppMethodBeat.o(40598);
    return bool;
  }
  
  private static boolean gyc()
  {
    AppMethodBeat.i(40599);
    String str = gya();
    boolean bool = new o(str + "/DexOpt_Failed").exists();
    AppMethodBeat.o(40599);
    return bool;
  }
  
  public static boolean jA(Context paramContext)
  {
    AppMethodBeat.i(40595);
    long l1 = 0L;
    long l3 = System.currentTimeMillis();
    h.c("WxSplash.DexOpt", "block checking dex opt result.", new Object[0]);
    while (gyb())
    {
      long l2 = l1 + 1L;
      Thread.sleep(100L);
      l1 = l2;
      if (l2 >= 5L)
      {
        l1 = 0L;
        if (System.currentTimeMillis() - l3 > 180000L)
        {
          h.c("WxSplash.DexOpt", "block checking dex opt timeout.", new Object[0]);
          if (!jw(paramContext))
          {
            h.gyq().idkey(675L, 25L, 1L);
            h.gyq().idkey(675L, 15L, 1L);
            AppMethodBeat.o(40595);
            return true;
          }
          if (!jz(paramContext)) {
            h.gyq().idkey(675L, 18L, 1L);
          }
          h.gyq().idkey(675L, 17L, 1L);
          AppMethodBeat.o(40595);
          return false;
        }
      }
    }
    if (!gyc())
    {
      h.gyq().idkey(675L, 15L, 1L);
      AppMethodBeat.o(40595);
      return true;
    }
    if (!jw(paramContext))
    {
      h.gyq().idkey(675L, 26L, 1L);
      h.gyq().idkey(675L, 15L, 1L);
      AppMethodBeat.o(40595);
      return true;
    }
    h.gyq().idkey(675L, 16L, 1L);
    AppMethodBeat.o(40595);
    return false;
  }
  
  public static boolean jw(Context paramContext)
  {
    AppMethodBeat.i(40590);
    boolean bool = h.NLF.bS(paramContext);
    h.c("WxSplash.DexOpt", "if need dexopt %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(40590);
    return bool;
  }
  
  public static void jx(Context paramContext)
  {
    AppMethodBeat.i(40591);
    if (g.zF)
    {
      AppMethodBeat.o(40591);
      return;
    }
    h.gyq().idkey(675L, 22L, 1L);
    try
    {
      bool = h.NLF.bR(paramContext);
      h.c("WxSplash.DexOpt", "install multidex result %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        h.c("WxSplash.DexOpt", "install multidex failed, kill self.", new Object[0]);
        h.eCp();
      }
      AppMethodBeat.o(40591);
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        h.a(paramContext, "multidex install failed");
        boolean bool = false;
      }
    }
  }
  
  public static void jy(Context paramContext)
  {
    AppMethodBeat.i(40592);
    h.c("WxSplash.DexOpt", "start dex opt service", new Object[0]);
    String str = Util.getProcessNameByPid(paramContext, Process.myPid());
    str.replace(':', '_');
    NLs = "DexOpt_Request_".concat(String.valueOf(str));
    h.gyq().idkey(675L, 14L, 1L);
    try
    {
      bij(NLs);
      paramContext.startService(new Intent(paramContext, DexOptService.class));
      AppMethodBeat.o(40592);
      return;
    }
    catch (Exception localException)
    {
      if (Build.VERSION.SDK_INT > 19) {
        break label204;
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
          localObject = new o(gya());
          if (((o)localObject).exists()) {
            break label221;
          }
          i = 1;
          if (i == 0) {
            break label258;
          }
          h.NLF.bT(paramContext);
        }
      }
      catch (Exception paramContext)
      {
        h.c("WxSplash.DexOpt", "%s, %s", new Object[] { paramContext.getMessage() });
      }
      for (;;)
      {
        label204:
        paramContext = new RuntimeException(localException);
        AppMethodBeat.o(40592);
        throw paramContext;
        label221:
        i = ((o)localObject).het().length;
        h.c("WxSplash.DexOpt", "check dexopt directory size %s.", new Object[] { Integer.valueOf(i) });
        if (i >= 10000) {
          break label296;
        }
        i = 1;
        break;
        label258:
        h.c("WxSplash.DexOpt", "check dexopt directory size not ok, clean it and throw exception.", new Object[0]);
        paramContext = new o(gya());
        if (paramContext.exists()) {
          e.a(paramContext);
        }
      }
      label296:
      int i = 0;
    }
  }
  
  private static boolean jz(Context paramContext)
  {
    AppMethodBeat.i(40594);
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext != null)
    {
      paramContext = paramContext.getRunningServices(2147483647);
      if (paramContext == null)
      {
        h.c("WxSplash.DexOpt", "dexopt service may dead, get running services return null.", new Object[0]);
        AppMethodBeat.o(40594);
        return false;
      }
      paramContext = paramContext.iterator();
      while (paramContext.hasNext()) {
        if ("com.tencent.mm.splash.DexOptService".equals(((ActivityManager.RunningServiceInfo)paramContext.next()).service.getClassName()))
        {
          AppMethodBeat.o(40594);
          return true;
        }
      }
    }
    h.c("WxSplash.DexOpt", "dexopt service may dead", new Object[0]);
    AppMethodBeat.o(40594);
    return false;
  }
  
  public static void n(Application paramApplication)
  {
    AppMethodBeat.i(40588);
    NLr = aa.z(new o(paramApplication.getFilesDir(), "dexopt_service").her());
    AppMethodBeat.o(40588);
  }
  
  public static abstract interface a
  {
    public abstract void eZS();
    
    public abstract void gye();
    
    public abstract void gyf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.a
 * JD-Core Version:    0.7.0.1
 */