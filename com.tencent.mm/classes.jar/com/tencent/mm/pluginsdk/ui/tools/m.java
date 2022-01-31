package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.WebView;

public final class m
{
  private static String wfx = null;
  private static final String[] wfy = { "", "dynamic_config_recv", "trigger_download", "start_download", "stop_download", "download_finish", "install_finish", "use" };
  
  private static String fZ(Context paramContext)
  {
    AppMethodBeat.i(114678);
    if (wfx != null)
    {
      paramContext = wfx;
      AppMethodBeat.o(114678);
      return paramContext;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(ah.getPackageName(), 128);
      if ((paramContext != null) && (paramContext.metaData != null))
      {
        paramContext = paramContext.metaData.getString("com.tencent.mtt.TBS_CODE");
        if (!bo.isNullOrNil(paramContext))
        {
          wfx = paramContext;
          AppMethodBeat.o(114678);
          return paramContext;
        }
      }
    }
    catch (Exception paramContext)
    {
      ab.e("MicroMsg.TBSReporter", "getMetaTbsCode, ex = %s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(114678);
    }
    return null;
  }
  
  public static void gK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114677);
    if ((paramInt1 <= 0) || (paramInt1 > 7))
    {
      ab.e("MicroMsg.TBSReporter", "report invalid scene = %d", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(114677);
      return;
    }
    hf(paramInt1, paramInt2);
    Object localObject = ah.getContext();
    int i = WebView.getInstalledTbsCoreVersion((Context)localObject);
    int j = WebView.getTbsSDKVersion((Context)localObject);
    localObject = fZ((Context)localObject);
    h.qsU.a(11633, false, true, new Object[] { Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(i), Integer.valueOf(j), localObject, Integer.valueOf(paramInt2) });
    AppMethodBeat.o(114677);
  }
  
  private static void hf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114679);
    ab.i("MicroMsg.TBSReporter", "logSceneDetail, scene = %d_%s, errcode = %d", new Object[] { Integer.valueOf(paramInt1), wfy[paramInt1], Integer.valueOf(paramInt2) });
    AppMethodBeat.o(114679);
  }
  
  public static void kS(int paramInt)
  {
    AppMethodBeat.i(114676);
    gK(paramInt, 0);
    AppMethodBeat.o(114676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.m
 * JD-Core Version:    0.7.0.1
 */