package com.tencent.mm.splash;

import android.annotation.SuppressLint;
import android.app.Application;
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
import com.tencent.mm.vfs.q;
import java.lang.reflect.Field;

public final class a
{
  private static String UYY;
  private static String UYZ;
  private static q UZa;
  private static long UZb;
  @SuppressLint({"HandlerLeak"})
  private static Handler UZc;
  
  static
  {
    AppMethodBeat.i(40605);
    UZc = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(40587);
        paramAnonymousMessage = (a.a)paramAnonymousMessage.obj;
        Application localApplication;
        if (a.access$000())
        {
          if (a.Ur(a.UZb))
          {
            localApplication = i.jxU;
            a.hub();
            i.huq().idkey(675L, 25L, 1L);
            paramAnonymousMessage.hue();
            AppMethodBeat.o(40587);
            return;
          }
          a.c(paramAnonymousMessage);
          AppMethodBeat.o(40587);
          return;
        }
        if (!a.abi())
        {
          i.huq().idkey(675L, 15L, 1L);
          paramAnonymousMessage.hue();
        }
        for (;;)
        {
          a.hud();
          AppMethodBeat.o(40587);
          return;
          localApplication = i.jxU;
          a.hub();
          i.huq().idkey(675L, 26L, 1L);
          i.huq().idkey(675L, 15L, 1L);
          paramAnonymousMessage.hue();
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
    if (UZb == 0L) {
      UZb = System.currentTimeMillis();
    }
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    localMessage.obj = parama;
    UZc.sendMessageDelayed(localMessage, 100L);
    AppMethodBeat.o(40597);
  }
  
  private static void buA(String paramString)
  {
    try
    {
      AppMethodBeat.i(40593);
      String str = hua();
      q localq = new q(str);
      if (!localq.ifE()) {
        localq.ifL();
      }
      paramString = new q(str + "/" + paramString);
      if (paramString.ifE()) {
        paramString.cFq();
      }
      paramString.ifM();
      UZa = paramString;
      AppMethodBeat.o(40593);
      return;
    }
    finally {}
  }
  
  public static String hua()
  {
    AppMethodBeat.i(40589);
    if (UYY == null)
    {
      localObject = new IllegalStateException("data directory should not be null, give one.");
      AppMethodBeat.o(40589);
      throw ((Throwable)localObject);
    }
    Object localObject = new q(UYY);
    if ((!((q)localObject).ifE()) && (!((q)localObject).ifL())) {
      i.g("WxSplash.DexOpt", "data directory create failed.", new Object[0]);
    }
    localObject = UYY;
    AppMethodBeat.o(40589);
    return localObject;
  }
  
  public static boolean hub()
  {
    AppMethodBeat.i(208805);
    b localb = i.UZp;
    i.g("WxSplash.DexOpt", "if need dexopt %s", new Object[] { Boolean.FALSE });
    AppMethodBeat.o(208805);
    return false;
  }
  
  public static void huc()
  {
    AppMethodBeat.i(208806);
    if (g.acB)
    {
      AppMethodBeat.o(208806);
      return;
    }
    i.huq().idkey(675L, 22L, 1L);
    try
    {
      b localb = i.UZp;
      bool = true;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        i.a(localThrowable, "multidex install failed");
        boolean bool = false;
      }
    }
    i.g("WxSplash.DexOpt", "install multidex result %s", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      i.g("WxSplash.DexOpt", "install multidex failed, kill self.", new Object[0]);
      i.fnZ();
    }
    AppMethodBeat.o(208806);
  }
  
  public static void kA(Context paramContext)
  {
    AppMethodBeat.i(40592);
    i.g("WxSplash.DexOpt", "start dex opt service", new Object[0]);
    String str = Util.getProcessNameByPid(paramContext, Process.myPid());
    str.replace(':', '_');
    UYZ = "DexOpt_Request_".concat(String.valueOf(str));
    i.huq().idkey(675L, 14L, 1L);
    try
    {
      buA(UYZ);
      paramContext.startService(new Intent(paramContext, DexOptService.class));
      AppMethodBeat.o(40592);
      return;
    }
    catch (Exception localException)
    {
      if (Build.VERSION.SDK_INT > 19) {
        break label246;
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
          localObject = new q(hua());
          if (((q)localObject).ifE()) {
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
        localObject = i.UZp;
        break;
        i = ((q)localObject).ifJ().length;
        i.g("WxSplash.DexOpt", "check dexopt directory size %s.", new Object[] { Integer.valueOf(i) });
        if (i >= 10000) {
          continue;
        }
        i = 1;
      }
      i.g("WxSplash.DexOpt", "check dexopt directory size not ok, clean it and throw exception.", new Object[0]);
      paramContext = new q(hua());
      if (paramContext.ifE()) {
        e.a(paramContext);
      }
    }
    label246:
    paramContext = new RuntimeException(localException);
    AppMethodBeat.o(40592);
    throw paramContext;
  }
  
  public static void q(Application paramApplication)
  {
    AppMethodBeat.i(40588);
    UYY = new q(paramApplication.getFilesDir(), "dexopt_service").bOF();
    AppMethodBeat.o(40588);
  }
  
  public static abstract interface a
  {
    public abstract void hue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.splash.a
 * JD-Core Version:    0.7.0.1
 */