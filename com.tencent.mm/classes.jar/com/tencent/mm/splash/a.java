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
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private static String yuZ;
  private static String yva;
  private static File yvb;
  private static long yvc;
  @SuppressLint({"HandlerLeak"})
  private static Handler yvd;
  
  static
  {
    AppMethodBeat.i(114812);
    yvd = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(114794);
        paramAnonymousMessage = (a.a)paramAnonymousMessage.obj;
        if (a.access$000()) {
          if (a.nZ(a.yvc))
          {
            if (!a.hv(h.yvl))
            {
              h.dvB().l(675L, 25L, 1L);
              paramAnonymousMessage.dvp();
              AppMethodBeat.o(114794);
              return;
            }
            if (!a.eE(h.yvl)) {
              h.dvB().l(675L, 18L, 1L);
            }
            h.dvB().l(675L, 17L, 1L);
            paramAnonymousMessage.dvq();
          }
        }
        for (;;)
        {
          a.dvo();
          AppMethodBeat.o(114794);
          return;
          a.c(paramAnonymousMessage);
          AppMethodBeat.o(114794);
          return;
          if (!a.djy())
          {
            h.dvB().l(675L, 15L, 1L);
            paramAnonymousMessage.dvp();
          }
          else if (!a.hv(h.yvl))
          {
            h.dvB().l(675L, 26L, 1L);
            h.dvB().l(675L, 15L, 1L);
            paramAnonymousMessage.dvp();
          }
          else
          {
            h.dvB().l(675L, 16L, 1L);
            paramAnonymousMessage.cod();
          }
        }
      }
    };
    AppMethodBeat.o(114812);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(114803);
    b(parama);
    AppMethodBeat.o(114803);
  }
  
  private static void aqH(String paramString)
  {
    try
    {
      AppMethodBeat.i(114800);
      String str = dvl();
      File localFile = new File(str);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      paramString = new File(str + "/" + paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
      paramString.createNewFile();
      yvb = paramString;
      AppMethodBeat.o(114800);
      return;
    }
    finally {}
  }
  
  private static void b(a parama)
  {
    AppMethodBeat.i(114804);
    if (yvc == 0L) {
      yvc = System.currentTimeMillis();
    }
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    localMessage.obj = parama;
    yvd.sendMessageDelayed(localMessage, 100L);
    AppMethodBeat.o(114804);
  }
  
  public static String dvl()
  {
    AppMethodBeat.i(114796);
    if (yuZ == null)
    {
      localObject = new IllegalStateException("data directory should not be null, give one.");
      AppMethodBeat.o(114796);
      throw ((Throwable)localObject);
    }
    Object localObject = new File(yuZ);
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs())) {
      h.c("WxSplash.DexOpt", "data directory create failed.", new Object[0]);
    }
    localObject = yuZ;
    AppMethodBeat.o(114796);
    return localObject;
  }
  
  private static boolean dvm()
  {
    AppMethodBeat.i(114805);
    if (yvb == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("tmp file field should not be null");
      AppMethodBeat.o(114805);
      throw localIllegalStateException;
    }
    boolean bool = yvb.exists();
    AppMethodBeat.o(114805);
    return bool;
  }
  
  private static boolean dvn()
  {
    AppMethodBeat.i(114806);
    String str = dvl();
    boolean bool = new File(str + "/DexOpt_Failed").exists();
    AppMethodBeat.o(114806);
    return bool;
  }
  
  public static boolean hv(Context paramContext)
  {
    AppMethodBeat.i(114797);
    boolean bool = h.yvo.bf(paramContext);
    h.c("WxSplash.DexOpt", "if need dexopt %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(114797);
    return bool;
  }
  
  public static void hw(Context paramContext)
  {
    AppMethodBeat.i(114798);
    if (g.qd)
    {
      AppMethodBeat.o(114798);
      return;
    }
    h.dvB().l(675L, 22L, 1L);
    try
    {
      bool = h.yvo.be(paramContext);
      h.c("WxSplash.DexOpt", "install multidex result %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        h.c("WxSplash.DexOpt", "install multidex failed, kill self.", new Object[0]);
        h.caC();
      }
      AppMethodBeat.o(114798);
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
  
  public static void hx(Context paramContext)
  {
    AppMethodBeat.i(114799);
    h.c("WxSplash.DexOpt", "start dex opt service", new Object[0]);
    String str = bo.az(paramContext, Process.myPid());
    str.replace(':', '_');
    yva = "DexOpt_Request_".concat(String.valueOf(str));
    h.dvB().l(675L, 14L, 1L);
    try
    {
      aqH(yva);
      paramContext.startService(new Intent(paramContext, DexOptService.class));
      AppMethodBeat.o(114799);
      return;
    }
    catch (Exception localException)
    {
      if (Build.VERSION.SDK_INT > 19) {
        break label200;
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
          localObject = new File(dvl());
          if (((File)localObject).exists()) {
            break label216;
          }
          i = 1;
          if (i == 0) {
            break label253;
          }
          h.yvo.bg(paramContext);
        }
      }
      catch (Exception paramContext)
      {
        h.c("WxSplash.DexOpt", "%s, %s", new Object[] { paramContext.getMessage() });
      }
      for (;;)
      {
        label200:
        paramContext = new RuntimeException(localException);
        AppMethodBeat.o(114799);
        throw paramContext;
        label216:
        i = ((File)localObject).listFiles().length;
        h.c("WxSplash.DexOpt", "check dexopt directory size %s.", new Object[] { Integer.valueOf(i) });
        if (i >= 10000) {
          break label291;
        }
        i = 1;
        break;
        label253:
        h.c("WxSplash.DexOpt", "check dexopt directory size not ok, clean it and throw exception.", new Object[0]);
        paramContext = new File(dvl());
        if (paramContext.exists()) {
          e.p(paramContext);
        }
      }
      label291:
      int i = 0;
    }
  }
  
  private static boolean hy(Context paramContext)
  {
    AppMethodBeat.i(114801);
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext != null)
    {
      paramContext = paramContext.getRunningServices(2147483647);
      if (paramContext == null)
      {
        h.c("WxSplash.DexOpt", "dexopt service may dead, get running services return null.", new Object[0]);
        AppMethodBeat.o(114801);
        return false;
      }
      paramContext = paramContext.iterator();
      while (paramContext.hasNext()) {
        if ("com.tencent.mm.splash.DexOptService".equals(((ActivityManager.RunningServiceInfo)paramContext.next()).service.getClassName()))
        {
          AppMethodBeat.o(114801);
          return true;
        }
      }
    }
    h.c("WxSplash.DexOpt", "dexopt service may dead", new Object[0]);
    AppMethodBeat.o(114801);
    return false;
  }
  
  public static boolean hz(Context paramContext)
  {
    AppMethodBeat.i(114802);
    long l1 = 0L;
    long l3 = System.currentTimeMillis();
    h.c("WxSplash.DexOpt", "block checking dex opt result.", new Object[0]);
    while (dvm())
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
          if (!hv(paramContext))
          {
            h.dvB().l(675L, 25L, 1L);
            h.dvB().l(675L, 15L, 1L);
            AppMethodBeat.o(114802);
            return true;
          }
          if (!hy(paramContext)) {
            h.dvB().l(675L, 18L, 1L);
          }
          h.dvB().l(675L, 17L, 1L);
          AppMethodBeat.o(114802);
          return false;
        }
      }
    }
    if (!dvn())
    {
      h.dvB().l(675L, 15L, 1L);
      AppMethodBeat.o(114802);
      return true;
    }
    if (!hv(paramContext))
    {
      h.dvB().l(675L, 26L, 1L);
      h.dvB().l(675L, 15L, 1L);
      AppMethodBeat.o(114802);
      return true;
    }
    h.dvB().l(675L, 16L, 1L);
    AppMethodBeat.o(114802);
    return false;
  }
  
  public static void i(Application paramApplication)
  {
    AppMethodBeat.i(114795);
    yuZ = new File(paramApplication.getFilesDir(), "dexopt_service").getAbsolutePath();
    AppMethodBeat.o(114795);
  }
  
  public static abstract interface a
  {
    public abstract void cod();
    
    public abstract void dvp();
    
    public abstract void dvq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.a
 * JD-Core Version:    0.7.0.1
 */