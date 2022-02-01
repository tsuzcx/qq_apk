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
  public static String M(Context paramContext, String paramString)
  {
    AppMethodBeat.i(261923);
    Bundle localBundle = new Bundle();
    localBundle.putString("package_name", paramString);
    try
    {
      paramContext = HotpotService.a(paramContext, NormsgDataService.class, 1, localBundle);
      if (paramContext != null)
      {
        paramContext = paramContext.getString("result", "");
        AppMethodBeat.o(261923);
        return paramContext;
      }
    }
    catch (HotpotService.c paramContext)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.NormsgDS", paramContext.agtr, "Fail to call m1.", new Object[0]);
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
      AppMethodBeat.o(261923);
    }
    return "";
  }
  
  private String aQd(String paramString)
  {
    AppMethodBeat.i(261930);
    try
    {
      PackageManager localPackageManager = getApplicationContext().getPackageManager();
      paramString = localPackageManager.getApplicationInfo(paramString, 0).loadLabel(localPackageManager).toString();
      return paramString;
    }
    finally
    {
      AppMethodBeat.o(261930);
    }
    return "";
  }
  
  public static boolean ec(Context paramContext)
  {
    AppMethodBeat.i(261927);
    try
    {
      Log.i("MicroMsg.NormsgDS", "hit getPhoneState");
      paramContext = HotpotService.a(paramContext, NormsgDataService.class, 2, null);
      Log.i("MicroMsg.NormsgDS", "hit getPhoneState end.");
      if ((paramContext != null) && (paramContext.getBoolean("result", false)))
      {
        AppMethodBeat.o(261927);
        return true;
      }
    }
    catch (HotpotService.c paramContext)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.NormsgDS", paramContext.agtr, "Fail to call m2.", new Object[0]);
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
      AppMethodBeat.o(261927);
    }
    return false;
  }
  
  private static boolean gty()
  {
    AppMethodBeat.i(261933);
    try
    {
      boolean bool = d.MtP.gtI();
      return bool;
    }
    finally
    {
      AppMethodBeat.o(261933);
    }
    return false;
  }
  
  public final void a(int paramInt, Bundle paramBundle1, Bundle paramBundle2)
  {
    AppMethodBeat.i(261937);
    if (paramInt == 1)
    {
      paramBundle2.putString("result", aQd(paramBundle1.getString("package_name")));
      AppMethodBeat.o(261937);
      return;
    }
    if (paramInt == 2)
    {
      paramBundle2.putBoolean("result", gty());
      AppMethodBeat.o(261937);
      return;
    }
    Log.w("MicroMsg.NormsgDS", "unknown op: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(261937);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(261935);
    super.onCreate();
    d.a(b.MtE);
    AppMethodBeat.o(261935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.NormsgDataService
 * JD-Core Version:    0.7.0.1
 */