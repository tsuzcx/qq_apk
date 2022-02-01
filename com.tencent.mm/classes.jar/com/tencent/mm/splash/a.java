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
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.q;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private static String Fbc;
  private static String Fbd;
  private static com.tencent.mm.vfs.e Fbe;
  private static long Fbf;
  @SuppressLint({"HandlerLeak"})
  private static Handler Fbg;
  
  static
  {
    AppMethodBeat.i(40605);
    Fbg = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(40587);
        paramAnonymousMessage = (a.a)paramAnonymousMessage.obj;
        if (a.access$000()) {
          if (a.vR(a.Fbf))
          {
            if (!a.ja(h.ELQ))
            {
              h.eIr().idkey(675L, 25L, 1L);
              paramAnonymousMessage.eIf();
              AppMethodBeat.o(40587);
              return;
            }
            if (!a.fB(h.ELQ)) {
              h.eIr().idkey(675L, 18L, 1L);
            }
            h.eIr().idkey(675L, 17L, 1L);
            paramAnonymousMessage.eIg();
          }
        }
        for (;;)
        {
          a.eIe();
          AppMethodBeat.o(40587);
          return;
          a.c(paramAnonymousMessage);
          AppMethodBeat.o(40587);
          return;
          if (!a.bTt())
          {
            h.eIr().idkey(675L, 15L, 1L);
            paramAnonymousMessage.eIf();
          }
          else if (!a.ja(h.ELQ))
          {
            h.eIr().idkey(675L, 26L, 1L);
            h.eIr().idkey(675L, 15L, 1L);
            paramAnonymousMessage.eIf();
          }
          else
          {
            h.eIr().idkey(675L, 16L, 1L);
            paramAnonymousMessage.dsy();
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
  
  private static void aGT(String paramString)
  {
    try
    {
      AppMethodBeat.i(40593);
      String str = eIb();
      com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(str);
      if (!locale.exists()) {
        locale.mkdirs();
      }
      paramString = new com.tencent.mm.vfs.e(str + "/" + paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
      paramString.createNewFile();
      Fbe = paramString;
      AppMethodBeat.o(40593);
      return;
    }
    finally {}
  }
  
  private static void b(a parama)
  {
    AppMethodBeat.i(40597);
    if (Fbf == 0L) {
      Fbf = System.currentTimeMillis();
    }
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    localMessage.obj = parama;
    Fbg.sendMessageDelayed(localMessage, 100L);
    AppMethodBeat.o(40597);
  }
  
  public static String eIb()
  {
    AppMethodBeat.i(40589);
    if (Fbc == null)
    {
      localObject = new IllegalStateException("data directory should not be null, give one.");
      AppMethodBeat.o(40589);
      throw ((Throwable)localObject);
    }
    Object localObject = new com.tencent.mm.vfs.e(Fbc);
    if ((!((com.tencent.mm.vfs.e)localObject).exists()) && (!((com.tencent.mm.vfs.e)localObject).mkdirs())) {
      h.b("WxSplash.DexOpt", "data directory create failed.", new Object[0]);
    }
    localObject = Fbc;
    AppMethodBeat.o(40589);
    return localObject;
  }
  
  private static boolean eIc()
  {
    AppMethodBeat.i(40598);
    if (Fbe == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("tmp file field should not be null");
      AppMethodBeat.o(40598);
      throw localIllegalStateException;
    }
    boolean bool = Fbe.exists();
    AppMethodBeat.o(40598);
    return bool;
  }
  
  private static boolean eId()
  {
    AppMethodBeat.i(40599);
    String str = eIb();
    boolean bool = new com.tencent.mm.vfs.e(str + "/DexOpt_Failed").exists();
    AppMethodBeat.o(40599);
    return bool;
  }
  
  public static boolean ja(Context paramContext)
  {
    AppMethodBeat.i(40590);
    boolean bool = h.Fbq.bt(paramContext);
    h.b("WxSplash.DexOpt", "if need dexopt %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(40590);
    return bool;
  }
  
  public static void jb(Context paramContext)
  {
    AppMethodBeat.i(40591);
    if (g.wH)
    {
      AppMethodBeat.o(40591);
      return;
    }
    h.eIr().idkey(675L, 22L, 1L);
    try
    {
      bool = h.Fbq.bs(paramContext);
      h.b("WxSplash.DexOpt", "install multidex result %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        h.b("WxSplash.DexOpt", "install multidex failed, kill self.", new Object[0]);
        h.daD();
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
  
  public static void jc(Context paramContext)
  {
    AppMethodBeat.i(40592);
    h.b("WxSplash.DexOpt", "start dex opt service", new Object[0]);
    String str = bt.getProcessNameByPid(paramContext, Process.myPid());
    str.replace(':', '_');
    Fbd = "DexOpt_Request_".concat(String.valueOf(str));
    h.eIr().idkey(675L, 14L, 1L);
    try
    {
      aGT(Fbd);
      paramContext.startService(new Intent(paramContext, DexOptService.class));
      AppMethodBeat.o(40592);
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
          localObject = new com.tencent.mm.vfs.e(eIb());
          if (((com.tencent.mm.vfs.e)localObject).exists()) {
            break label216;
          }
          i = 1;
          if (i == 0) {
            break label253;
          }
          h.Fbq.bu(paramContext);
        }
      }
      catch (Exception paramContext)
      {
        h.b("WxSplash.DexOpt", "%s, %s", new Object[] { paramContext.getMessage() });
      }
      for (;;)
      {
        label200:
        paramContext = new RuntimeException(localException);
        AppMethodBeat.o(40592);
        throw paramContext;
        label216:
        i = ((com.tencent.mm.vfs.e)localObject).fhW().length;
        h.b("WxSplash.DexOpt", "check dexopt directory size %s.", new Object[] { Integer.valueOf(i) });
        if (i >= 10000) {
          break label291;
        }
        i = 1;
        break;
        label253:
        h.b("WxSplash.DexOpt", "check dexopt directory size not ok, clean it and throw exception.", new Object[0]);
        paramContext = new com.tencent.mm.vfs.e(eIb());
        if (paramContext.exists()) {
          com.tencent.mm.b.e.a(paramContext);
        }
      }
      label291:
      int i = 0;
    }
  }
  
  private static boolean jd(Context paramContext)
  {
    AppMethodBeat.i(40594);
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext != null)
    {
      paramContext = paramContext.getRunningServices(2147483647);
      if (paramContext == null)
      {
        h.b("WxSplash.DexOpt", "dexopt service may dead, get running services return null.", new Object[0]);
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
    h.b("WxSplash.DexOpt", "dexopt service may dead", new Object[0]);
    AppMethodBeat.o(40594);
    return false;
  }
  
  public static boolean je(Context paramContext)
  {
    AppMethodBeat.i(40595);
    long l1 = 0L;
    long l3 = System.currentTimeMillis();
    h.b("WxSplash.DexOpt", "block checking dex opt result.", new Object[0]);
    while (eIc())
    {
      long l2 = l1 + 1L;
      Thread.sleep(100L);
      l1 = l2;
      if (l2 >= 5L)
      {
        l1 = 0L;
        if (System.currentTimeMillis() - l3 > 180000L)
        {
          h.b("WxSplash.DexOpt", "block checking dex opt timeout.", new Object[0]);
          if (!ja(paramContext))
          {
            h.eIr().idkey(675L, 25L, 1L);
            h.eIr().idkey(675L, 15L, 1L);
            AppMethodBeat.o(40595);
            return true;
          }
          if (!jd(paramContext)) {
            h.eIr().idkey(675L, 18L, 1L);
          }
          h.eIr().idkey(675L, 17L, 1L);
          AppMethodBeat.o(40595);
          return false;
        }
      }
    }
    if (!eId())
    {
      h.eIr().idkey(675L, 15L, 1L);
      AppMethodBeat.o(40595);
      return true;
    }
    if (!ja(paramContext))
    {
      h.eIr().idkey(675L, 26L, 1L);
      h.eIr().idkey(675L, 15L, 1L);
      AppMethodBeat.o(40595);
      return true;
    }
    h.eIr().idkey(675L, 16L, 1L);
    AppMethodBeat.o(40595);
    return false;
  }
  
  public static void l(Application paramApplication)
  {
    AppMethodBeat.i(40588);
    Fbc = q.B(new com.tencent.mm.vfs.e(paramApplication.getFilesDir(), "dexopt_service").fhU());
    AppMethodBeat.o(40588);
  }
  
  public static abstract interface a
  {
    public abstract void dsy();
    
    public abstract void eIf();
    
    public abstract void eIg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.a
 * JD-Core Version:    0.7.0.1
 */