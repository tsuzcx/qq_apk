package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.ao;

public final class s
{
  private static String Yui = null;
  private static final String[] Yuj = { "", "dynamic_config_recv", "trigger_download", "start_download", "stop_download", "download_finish", "install_finish", "use" };
  
  public static void ik(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(133688);
    if ((paramInt1 <= 0) || (paramInt1 > 7))
    {
      Log.e("MicroMsg.TBSReporter", "report invalid scene = %d", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(133688);
      return;
    }
    nN(paramInt1, paramInt2);
    Object localObject = MMApplicationContext.getContext();
    int i = ao.getInstalledTbsCoreVersion((Context)localObject);
    int j = ao.getTbsSDKVersion((Context)localObject);
    localObject = lF((Context)localObject);
    h.OAn.a(11633, false, true, new Object[] { Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(i), Integer.valueOf(j), localObject, Integer.valueOf(paramInt2) });
    AppMethodBeat.o(133688);
  }
  
  private static String lF(Context paramContext)
  {
    AppMethodBeat.i(133689);
    if (Yui != null)
    {
      paramContext = Yui;
      AppMethodBeat.o(133689);
      return paramContext;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(MMApplicationContext.getPackageName(), 128);
      if ((paramContext != null) && (paramContext.metaData != null))
      {
        paramContext = paramContext.metaData.getString("com.tencent.mtt.TBS_CODE");
        if (!Util.isNullOrNil(paramContext))
        {
          Yui = paramContext;
          AppMethodBeat.o(133689);
          return paramContext;
        }
      }
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.TBSReporter", "getMetaTbsCode, ex = %s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(133689);
    }
    return null;
  }
  
  private static void nN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(133690);
    Log.i("MicroMsg.TBSReporter", "logSceneDetail, scene = %d_%s, errcode = %d", new Object[] { Integer.valueOf(paramInt1), Yuj[paramInt1], Integer.valueOf(paramInt2) });
    AppMethodBeat.o(133690);
  }
  
  public static void rG(int paramInt)
  {
    AppMethodBeat.i(133687);
    ik(paramInt, 0);
    AppMethodBeat.o(133687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.s
 * JD-Core Version:    0.7.0.1
 */