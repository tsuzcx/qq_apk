package com.tencent.mm.splash;

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
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private static String acAq;
  private static String acAr;
  private static u acAs;
  private static long acAt;
  private static Handler acAu;
  
  static
  {
    AppMethodBeat.i(40605);
    acAu = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(40587);
        paramAnonymousMessage = (a.a)paramAnonymousMessage.obj;
        Application localApplication;
        if (a.access$000()) {
          if (a.yD(a.acAt))
          {
            localApplication = i.fgz;
            if (!a.iVC())
            {
              i.iVT().idkey(675L, 25L, 1L);
              paramAnonymousMessage.iVH();
              AppMethodBeat.o(40587);
              return;
            }
            if (!a.mD(i.fgz)) {
              i.iVT().idkey(675L, 18L, 1L);
            }
            i.iVT().idkey(675L, 17L, 1L);
            paramAnonymousMessage.iVI();
          }
        }
        for (;;)
        {
          a.iVG();
          AppMethodBeat.o(40587);
          return;
          a.c(paramAnonymousMessage);
          AppMethodBeat.o(40587);
          return;
          if (!a.dxo())
          {
            i.iVT().idkey(675L, 15L, 1L);
            paramAnonymousMessage.iVH();
          }
          else
          {
            localApplication = i.fgz;
            if (!a.iVC())
            {
              i.iVT().idkey(675L, 26L, 1L);
              i.iVT().idkey(675L, 15L, 1L);
              paramAnonymousMessage.iVH();
            }
            else
            {
              i.iVT().idkey(675L, 16L, 1L);
              paramAnonymousMessage.hfu();
            }
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
    if (acAt == 0L) {
      acAt = System.currentTimeMillis();
    }
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    localMessage.obj = parama;
    acAu.sendMessageDelayed(localMessage, 100L);
    AppMethodBeat.o(40597);
  }
  
  private static void buG(String paramString)
  {
    try
    {
      AppMethodBeat.i(40593);
      String str = iVB();
      u localu = new u(str);
      if (!localu.jKS()) {
        localu.jKY();
      }
      paramString = new u(str + "/" + paramString);
      if (paramString.jKS()) {
        paramString.diJ();
      }
      paramString.jKZ();
      acAs = paramString;
      AppMethodBeat.o(40593);
      return;
    }
    finally {}
  }
  
  public static String iVB()
  {
    AppMethodBeat.i(40589);
    if (acAq == null)
    {
      localObject = new IllegalStateException("data directory should not be null, give one.");
      AppMethodBeat.o(40589);
      throw ((Throwable)localObject);
    }
    Object localObject = new u(acAq);
    if ((!((u)localObject).jKS()) && (!((u)localObject).jKY())) {
      i.g("WxSplash.DexOpt", "data directory create failed.", new Object[0]);
    }
    localObject = acAq;
    AppMethodBeat.o(40589);
    return localObject;
  }
  
  public static boolean iVC()
  {
    AppMethodBeat.i(233920);
    boolean bool = i.acAH.aDr();
    i.g("WxSplash.DexOpt", "if need dexopt %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(233920);
    return bool;
  }
  
  public static void iVD()
  {
    AppMethodBeat.i(233922);
    if (g.bKk)
    {
      AppMethodBeat.o(233922);
      return;
    }
    i.iVT().idkey(675L, 22L, 1L);
    try
    {
      bool = i.acAH.aDq();
      i.g("WxSplash.DexOpt", "install multidex result %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        i.g("WxSplash.DexOpt", "install multidex failed, kill self.", new Object[0]);
        i.gyU();
      }
      AppMethodBeat.o(233922);
      return;
    }
    finally
    {
      for (;;)
      {
        i.a(localThrowable, "multidex install failed");
        boolean bool = false;
      }
    }
  }
  
  private static boolean iVE()
  {
    AppMethodBeat.i(40598);
    if (acAs == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("tmp file field should not be null");
      AppMethodBeat.o(40598);
      throw localIllegalStateException;
    }
    boolean bool = acAs.jKS();
    AppMethodBeat.o(40598);
    return bool;
  }
  
  private static boolean iVF()
  {
    AppMethodBeat.i(40599);
    String str = iVB();
    boolean bool = new u(str + "/DexOpt_Failed").jKS();
    AppMethodBeat.o(40599);
    return bool;
  }
  
  public static void mA(Context paramContext)
  {
    AppMethodBeat.i(40592);
    i.g("WxSplash.DexOpt", "start dex opt service", new Object[0]);
    String str = Util.getProcessNameByPid(paramContext, Process.myPid());
    str.replace(':', '_');
    acAr = "DexOpt_Request_".concat(String.valueOf(str));
    i.iVT().idkey(675L, 14L, 1L);
    try
    {
      buG(acAr);
      paramContext.startService(new Intent(paramContext, DexOptService.class));
      AppMethodBeat.o(40592);
      return;
    }
    catch (Exception localException)
    {
      if (Build.VERSION.SDK_INT > 19) {
        break label247;
      }
    }
    if (localException.getClass().getCanonicalName().equals("libcore.io.ErrnoException"))
    {
      for (;;)
      {
        try
        {
          localObject = localException.getClass().getField("errno");
          ((Field)localObject).setAccessible(true);
          if (((Integer)((Field)localObject).get(localException)).intValue() != OsConstants.ENOSPC) {
            continue;
          }
          localObject = new u(iVB());
          if (((u)localObject).jKS()) {
            continue;
          }
          i = 1;
        }
        catch (Exception paramContext)
        {
          Object localObject;
          i.g("WxSplash.DexOpt", "%s, %s", new Object[] { paramContext.getMessage() });
          continue;
          int i = 0;
          continue;
        }
        if (i == 0) {
          continue;
        }
        localObject = i.acAH;
        break;
        i = ((u)localObject).jKX().length;
        i.g("WxSplash.DexOpt", "check dexopt directory size %s.", new Object[] { Integer.valueOf(i) });
        if (i >= 10000) {
          continue;
        }
        i = 1;
      }
      i.g("WxSplash.DexOpt", "check dexopt directory size not ok, clean it and throw exception.", new Object[0]);
      paramContext = new u(iVB());
      if (paramContext.jKS()) {
        e.a(paramContext);
      }
    }
    label247:
    paramContext = new RuntimeException(localException);
    AppMethodBeat.o(40592);
    throw paramContext;
  }
  
  private static boolean mB(Context paramContext)
  {
    AppMethodBeat.i(40594);
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext != null)
    {
      paramContext = paramContext.getRunningServices(2147483647);
      if (paramContext == null)
      {
        i.g("WxSplash.DexOpt", "dexopt service may dead, get running services return null.", new Object[0]);
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
    i.g("WxSplash.DexOpt", "dexopt service may dead", new Object[0]);
    AppMethodBeat.o(40594);
    return false;
  }
  
  public static boolean mC(Context paramContext)
  {
    AppMethodBeat.i(40595);
    long l1 = 0L;
    long l3 = System.currentTimeMillis();
    i.g("WxSplash.DexOpt", "block checking dex opt result.", new Object[0]);
    while (iVE())
    {
      long l2 = l1 + 1L;
      Thread.sleep(100L);
      l1 = l2;
      if (l2 >= 5L)
      {
        l1 = 0L;
        if (System.currentTimeMillis() - l3 > 180000L)
        {
          i.g("WxSplash.DexOpt", "block checking dex opt timeout.", new Object[0]);
          if (!iVC())
          {
            i.iVT().idkey(675L, 25L, 1L);
            i.iVT().idkey(675L, 15L, 1L);
            AppMethodBeat.o(40595);
            return true;
          }
          if (!mB(paramContext)) {
            i.iVT().idkey(675L, 18L, 1L);
          }
          i.iVT().idkey(675L, 17L, 1L);
          AppMethodBeat.o(40595);
          return false;
        }
      }
    }
    if (!iVF())
    {
      i.iVT().idkey(675L, 15L, 1L);
      AppMethodBeat.o(40595);
      return true;
    }
    if (!iVC())
    {
      i.iVT().idkey(675L, 26L, 1L);
      i.iVT().idkey(675L, 15L, 1L);
      AppMethodBeat.o(40595);
      return true;
    }
    i.iVT().idkey(675L, 16L, 1L);
    AppMethodBeat.o(40595);
    return false;
  }
  
  public static void r(Application paramApplication)
  {
    AppMethodBeat.i(40588);
    acAq = ah.v(new u(paramApplication.getFilesDir(), "dexopt_service").jKT());
    AppMethodBeat.o(40588);
  }
  
  public static abstract interface a
  {
    public abstract void hfu();
    
    public abstract void iVH();
    
    public abstract void iVI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.splash.a
 * JD-Core Version:    0.7.0.1
 */