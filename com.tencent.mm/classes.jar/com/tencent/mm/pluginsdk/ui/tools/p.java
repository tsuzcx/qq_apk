package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.xweb.WebView;

public final class p
{
  private static String DFP = null;
  private static final String[] DFQ = { "", "dynamic_config_recv", "trigger_download", "start_download", "stop_download", "download_finish", "install_finish", "use" };
  
  public static void fS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(133688);
    if ((paramInt1 <= 0) || (paramInt1 > 7))
    {
      ac.e("MicroMsg.TBSReporter", "report invalid scene = %d", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(133688);
      return;
    }
    jd(paramInt1, paramInt2);
    Object localObject = ai.getContext();
    int i = WebView.getInstalledTbsCoreVersion((Context)localObject);
    int j = WebView.getTbsSDKVersion((Context)localObject);
    localObject = hy((Context)localObject);
    h.wUl.a(11633, false, true, new Object[] { Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(i), Integer.valueOf(j), localObject, Integer.valueOf(paramInt2) });
    AppMethodBeat.o(133688);
  }
  
  private static String hy(Context paramContext)
  {
    AppMethodBeat.i(133689);
    if (DFP != null)
    {
      paramContext = DFP;
      AppMethodBeat.o(133689);
      return paramContext;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(ai.getPackageName(), 128);
      if ((paramContext != null) && (paramContext.metaData != null))
      {
        paramContext = paramContext.metaData.getString("com.tencent.mtt.TBS_CODE");
        if (!bs.isNullOrNil(paramContext))
        {
          DFP = paramContext;
          AppMethodBeat.o(133689);
          return paramContext;
        }
      }
    }
    catch (Exception paramContext)
    {
      ac.e("MicroMsg.TBSReporter", "getMetaTbsCode, ex = %s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(133689);
    }
    return null;
  }
  
  private static void jd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(133690);
    ac.i("MicroMsg.TBSReporter", "logSceneDetail, scene = %d_%s, errcode = %d", new Object[] { Integer.valueOf(paramInt1), DFQ[paramInt1], Integer.valueOf(paramInt2) });
    AppMethodBeat.o(133690);
  }
  
  public static void lA(int paramInt)
  {
    AppMethodBeat.i(133687);
    fS(paramInt, 0);
    AppMethodBeat.o(133687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.p
 * JD-Core Version:    0.7.0.1
 */