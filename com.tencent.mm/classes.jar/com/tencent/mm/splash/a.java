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
  private static String Ikn;
  private static String Iko;
  private static com.tencent.mm.vfs.e Ikp;
  private static long Ikq;
  @SuppressLint({"HandlerLeak"})
  private static Handler Ikr;
  
  static
  {
    AppMethodBeat.i(40605);
    Ikr = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(40587);
        paramAnonymousMessage = (a.a)paramAnonymousMessage.obj;
        if (a.access$000()) {
          if (a.Dk(a.Ikq))
          {
            if (!a.ju(h.HUP))
            {
              h.fnx().idkey(675L, 25L, 1L);
              paramAnonymousMessage.fnl();
              AppMethodBeat.o(40587);
              return;
            }
            if (!a.fS(h.HUP)) {
              h.fnx().idkey(675L, 18L, 1L);
            }
            h.fnx().idkey(675L, 17L, 1L);
            paramAnonymousMessage.fnm();
          }
        }
        for (;;)
        {
          a.fnk();
          AppMethodBeat.o(40587);
          return;
          a.c(paramAnonymousMessage);
          AppMethodBeat.o(40587);
          return;
          if (!a.Mv())
          {
            h.fnx().idkey(675L, 15L, 1L);
            paramAnonymousMessage.fnl();
          }
          else if (!a.ju(h.HUP))
          {
            h.fnx().idkey(675L, 26L, 1L);
            h.fnx().idkey(675L, 15L, 1L);
            paramAnonymousMessage.fnl();
          }
          else
          {
            h.fnx().idkey(675L, 16L, 1L);
            paramAnonymousMessage.dTk();
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
  
  private static void aRS(String paramString)
  {
    try
    {
      AppMethodBeat.i(40593);
      String str = fnh();
      com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(str);
      if (!locale.exists()) {
        locale.mkdirs();
      }
      paramString = new com.tencent.mm.vfs.e(str + "/" + paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
      paramString.createNewFile();
      Ikp = paramString;
      AppMethodBeat.o(40593);
      return;
    }
    finally {}
  }
  
  private static void b(a parama)
  {
    AppMethodBeat.i(40597);
    if (Ikq == 0L) {
      Ikq = System.currentTimeMillis();
    }
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    localMessage.obj = parama;
    Ikr.sendMessageDelayed(localMessage, 100L);
    AppMethodBeat.o(40597);
  }
  
  public static String fnh()
  {
    AppMethodBeat.i(40589);
    if (Ikn == null)
    {
      localObject = new IllegalStateException("data directory should not be null, give one.");
      AppMethodBeat.o(40589);
      throw ((Throwable)localObject);
    }
    Object localObject = new com.tencent.mm.vfs.e(Ikn);
    if ((!((com.tencent.mm.vfs.e)localObject).exists()) && (!((com.tencent.mm.vfs.e)localObject).mkdirs())) {
      h.b("WxSplash.DexOpt", "data directory create failed.", new Object[0]);
    }
    localObject = Ikn;
    AppMethodBeat.o(40589);
    return localObject;
  }
  
  private static boolean fni()
  {
    AppMethodBeat.i(40598);
    if (Ikp == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("tmp file field should not be null");
      AppMethodBeat.o(40598);
      throw localIllegalStateException;
    }
    boolean bool = Ikp.exists();
    AppMethodBeat.o(40598);
    return bool;
  }
  
  private static boolean fnj()
  {
    AppMethodBeat.i(40599);
    String str = fnh();
    boolean bool = new com.tencent.mm.vfs.e(str + "/DexOpt_Failed").exists();
    AppMethodBeat.o(40599);
    return bool;
  }
  
  public static boolean ju(Context paramContext)
  {
    AppMethodBeat.i(40590);
    boolean bool = h.IkB.bv(paramContext);
    h.b("WxSplash.DexOpt", "if need dexopt %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(40590);
    return bool;
  }
  
  public static void jv(Context paramContext)
  {
    AppMethodBeat.i(40591);
    if (g.zz)
    {
      AppMethodBeat.o(40591);
      return;
    }
    h.fnx().idkey(675L, 22L, 1L);
    try
    {
      bool = h.IkB.bu(paramContext);
      h.b("WxSplash.DexOpt", "install multidex result %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        h.b("WxSplash.DexOpt", "install multidex failed, kill self.", new Object[0]);
        h.dyJ();
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
  
  public static void jw(Context paramContext)
  {
    AppMethodBeat.i(40592);
    h.b("WxSplash.DexOpt", "start dex opt service", new Object[0]);
    String str = bt.getProcessNameByPid(paramContext, Process.myPid());
    str.replace(':', '_');
    Iko = "DexOpt_Request_".concat(String.valueOf(str));
    h.fnx().idkey(675L, 14L, 1L);
    try
    {
      aRS(Iko);
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
          localObject = new com.tencent.mm.vfs.e(fnh());
          if (((com.tencent.mm.vfs.e)localObject).exists()) {
            break label216;
          }
          i = 1;
          if (i == 0) {
            break label253;
          }
          h.IkB.bw(paramContext);
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
        i = ((com.tencent.mm.vfs.e)localObject).fOM().length;
        h.b("WxSplash.DexOpt", "check dexopt directory size %s.", new Object[] { Integer.valueOf(i) });
        if (i >= 10000) {
          break label291;
        }
        i = 1;
        break;
        label253:
        h.b("WxSplash.DexOpt", "check dexopt directory size not ok, clean it and throw exception.", new Object[0]);
        paramContext = new com.tencent.mm.vfs.e(fnh());
        if (paramContext.exists()) {
          com.tencent.mm.b.e.a(paramContext);
        }
      }
      label291:
      int i = 0;
    }
  }
  
  private static boolean jx(Context paramContext)
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
  
  public static boolean jy(Context paramContext)
  {
    AppMethodBeat.i(40595);
    long l1 = 0L;
    long l3 = System.currentTimeMillis();
    h.b("WxSplash.DexOpt", "block checking dex opt result.", new Object[0]);
    while (fni())
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
          if (!ju(paramContext))
          {
            h.fnx().idkey(675L, 25L, 1L);
            h.fnx().idkey(675L, 15L, 1L);
            AppMethodBeat.o(40595);
            return true;
          }
          if (!jx(paramContext)) {
            h.fnx().idkey(675L, 18L, 1L);
          }
          h.fnx().idkey(675L, 17L, 1L);
          AppMethodBeat.o(40595);
          return false;
        }
      }
    }
    if (!fnj())
    {
      h.fnx().idkey(675L, 15L, 1L);
      AppMethodBeat.o(40595);
      return true;
    }
    if (!ju(paramContext))
    {
      h.fnx().idkey(675L, 26L, 1L);
      h.fnx().idkey(675L, 15L, 1L);
      AppMethodBeat.o(40595);
      return true;
    }
    h.fnx().idkey(675L, 16L, 1L);
    AppMethodBeat.o(40595);
    return false;
  }
  
  public static void n(Application paramApplication)
  {
    AppMethodBeat.i(40588);
    Ikn = q.B(new com.tencent.mm.vfs.e(paramApplication.getFilesDir(), "dexopt_service").fOK());
    AppMethodBeat.o(40588);
  }
  
  public static abstract interface a
  {
    public abstract void dTk();
    
    public abstract void fnl();
    
    public abstract void fnm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.a
 * JD-Core Version:    0.7.0.1
 */