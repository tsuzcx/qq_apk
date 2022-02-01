package com.tencent.mm.plugin.normsg;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.m;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.util.HotpotService;
import com.tencent.mm.util.HotpotService.b;
import com.tencent.mm.util.HotpotService.c;

@m
public final class NormsgDataService
  extends HotpotService
{
  public static String H(Context paramContext, String paramString)
  {
    AppMethodBeat.i(257867);
    Bundle localBundle = new Bundle();
    localBundle.putString("package_name", paramString);
    try
    {
      paramContext = HotpotService.a(paramContext, NormsgDataService.class, 1, localBundle);
      if (paramContext != null)
      {
        paramContext = paramContext.getString("result", "");
        AppMethodBeat.o(257867);
        return paramContext;
      }
    }
    catch (HotpotService.c paramContext)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.NormsgDS", paramContext.YyT, "Fail to call m1.", new Object[0]);
        paramContext = null;
      }
    }
    catch (HotpotService.b paramContext)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.NormsgDS", paramContext, "Fail to call m1.", new Object[0]);
        paramContext = null;
      }
      AppMethodBeat.o(257867);
    }
    return "";
  }
  
  private String aTd(String paramString)
  {
    AppMethodBeat.i(257870);
    try
    {
      PackageManager localPackageManager = getApplicationContext().getPackageManager();
      paramString = localPackageManager.getApplicationInfo(paramString, 0).loadLabel(localPackageManager).toString();
      AppMethodBeat.o(257870);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(257870);
    }
    return "";
  }
  
  public static boolean dk(Context paramContext)
  {
    AppMethodBeat.i(257868);
    try
    {
      Log.i("MicroMsg.NormsgDS", "hit getPhoneState");
      paramContext = HotpotService.a(paramContext, NormsgDataService.class, 2, null);
      Log.i("MicroMsg.NormsgDS", "hit getPhoneState end.");
      if ((paramContext != null) && (paramContext.getBoolean("result", false)))
      {
        AppMethodBeat.o(257868);
        return true;
      }
    }
    catch (HotpotService.c paramContext)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.NormsgDS", paramContext.YyT, "Fail to call m2.", new Object[0]);
        paramContext = null;
      }
    }
    catch (HotpotService.b paramContext)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.NormsgDS", paramContext, "Fail to call m2.", new Object[0]);
        paramContext = null;
      }
      AppMethodBeat.o(257868);
    }
    return false;
  }
  
  private static boolean fji()
  {
    AppMethodBeat.i(257873);
    try
    {
      boolean bool = d.GxJ.fjr();
      AppMethodBeat.o(257873);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(257873);
    }
    return false;
  }
  
  public final void a(int paramInt, Bundle paramBundle1, Bundle paramBundle2)
  {
    AppMethodBeat.i(257869);
    if (paramInt == 1)
    {
      paramBundle2.putString("result", aTd(paramBundle1.getString("package_name")));
      AppMethodBeat.o(257869);
      return;
    }
    if (paramInt == 2)
    {
      paramBundle2.putBoolean("result", fji());
      AppMethodBeat.o(257869);
      return;
    }
    Log.w("MicroMsg.NormsgDS", "unknown op: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(257869);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(257866);
    super.onCreate();
    d.a(b.Gxy);
    AppMethodBeat.o(257866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.NormsgDataService
 * JD-Core Version:    0.7.0.1
 */