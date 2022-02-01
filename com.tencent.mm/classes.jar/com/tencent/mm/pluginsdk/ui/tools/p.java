package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.xweb.WebView;

public final class p
{
  private static String FkU = null;
  private static final String[] FkV = { "", "dynamic_config_recv", "trigger_download", "start_download", "stop_download", "download_finish", "install_finish", "use" };
  
  public static void gi(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(133688);
    if ((paramInt1 <= 0) || (paramInt1 > 7))
    {
      ad.e("MicroMsg.TBSReporter", "report invalid scene = %d", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(133688);
      return;
    }
    jp(paramInt1, paramInt2);
    Object localObject = aj.getContext();
    int i = WebView.getInstalledTbsCoreVersion((Context)localObject);
    int j = WebView.getTbsSDKVersion((Context)localObject);
    localObject = hD((Context)localObject);
    g.yhR.a(11633, false, true, new Object[] { Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(i), Integer.valueOf(j), localObject, Integer.valueOf(paramInt2) });
    AppMethodBeat.o(133688);
  }
  
  private static String hD(Context paramContext)
  {
    AppMethodBeat.i(133689);
    if (FkU != null)
    {
      paramContext = FkU;
      AppMethodBeat.o(133689);
      return paramContext;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(aj.getPackageName(), 128);
      if ((paramContext != null) && (paramContext.metaData != null))
      {
        paramContext = paramContext.metaData.getString("com.tencent.mtt.TBS_CODE");
        if (!bt.isNullOrNil(paramContext))
        {
          FkU = paramContext;
          AppMethodBeat.o(133689);
          return paramContext;
        }
      }
    }
    catch (Exception paramContext)
    {
      ad.e("MicroMsg.TBSReporter", "getMetaTbsCode, ex = %s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(133689);
    }
    return null;
  }
  
  private static void jp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(133690);
    ad.i("MicroMsg.TBSReporter", "logSceneDetail, scene = %d_%s, errcode = %d", new Object[] { Integer.valueOf(paramInt1), FkV[paramInt1], Integer.valueOf(paramInt2) });
    AppMethodBeat.o(133690);
  }
  
  public static void ma(int paramInt)
  {
    AppMethodBeat.i(133687);
    gi(paramInt, 0);
    AppMethodBeat.o(133687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.p
 * JD-Core Version:    0.7.0.1
 */