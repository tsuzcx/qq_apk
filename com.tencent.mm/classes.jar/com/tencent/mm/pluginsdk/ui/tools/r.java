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
import com.tencent.xweb.WebView;

public final class r
{
  private static String Kww = null;
  private static final String[] Kwx = { "", "dynamic_config_recv", "trigger_download", "start_download", "stop_download", "download_finish", "install_finish", "use" };
  
  public static void gH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(133688);
    if ((paramInt1 <= 0) || (paramInt1 > 7))
    {
      Log.e("MicroMsg.TBSReporter", "report invalid scene = %d", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(133688);
      return;
    }
    kF(paramInt1, paramInt2);
    Object localObject = MMApplicationContext.getContext();
    int i = WebView.getInstalledTbsCoreVersion((Context)localObject);
    int j = WebView.getTbsSDKVersion((Context)localObject);
    localObject = iD((Context)localObject);
    h.CyF.a(11633, false, true, new Object[] { Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(i), Integer.valueOf(j), localObject, Integer.valueOf(paramInt2) });
    AppMethodBeat.o(133688);
  }
  
  private static String iD(Context paramContext)
  {
    AppMethodBeat.i(133689);
    if (Kww != null)
    {
      paramContext = Kww;
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
          Kww = paramContext;
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
  
  private static void kF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(133690);
    Log.i("MicroMsg.TBSReporter", "logSceneDetail, scene = %d_%s, errcode = %d", new Object[] { Integer.valueOf(paramInt1), Kwx[paramInt1], Integer.valueOf(paramInt2) });
    AppMethodBeat.o(133690);
  }
  
  public static void pl(int paramInt)
  {
    AppMethodBeat.i(133687);
    gH(paramInt, 0);
    AppMethodBeat.o(133687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.r
 * JD-Core Version:    0.7.0.1
 */