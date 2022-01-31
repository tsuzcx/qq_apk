package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.WebView;

public final class k
{
  private static String snc = null;
  private static final String[] snd = { "", "dynamic_config_recv", "trigger_download", "start_download", "stop_download", "download_finish", "install_finish", "use" };
  
  public static void eZ(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt1 > 7))
    {
      y.e("MicroMsg.TBSReporter", "report invalid scene = %d", new Object[] { Integer.valueOf(paramInt1) });
      return;
    }
    y.i("MicroMsg.TBSReporter", "logSceneDetail, scene = %d_%s, errcode = %d", new Object[] { Integer.valueOf(paramInt1), snd[paramInt1], Integer.valueOf(paramInt2) });
    Object localObject = ae.getContext();
    int i = WebView.getInstalledTbsCoreVersion((Context)localObject);
    int j = WebView.getTbsSDKVersion((Context)localObject);
    localObject = fa((Context)localObject);
    h.nFQ.a(11633, false, true, new Object[] { Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(i), Integer.valueOf(j), localObject, Integer.valueOf(paramInt2) });
  }
  
  private static String fa(Context paramContext)
  {
    if (snc != null) {
      return snc;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(ae.getPackageName(), 128);
      if ((paramContext != null) && (paramContext.metaData != null))
      {
        paramContext = paramContext.metaData.getString("com.tencent.mtt.TBS_CODE");
        if (!bk.bl(paramContext))
        {
          snc = paramContext;
          return paramContext;
        }
      }
    }
    catch (Exception paramContext)
    {
      y.e("MicroMsg.TBSReporter", "getMetaTbsCode, ex = %s", new Object[] { paramContext.getMessage() });
    }
    return null;
  }
  
  public static void jdMethod_if(int paramInt)
  {
    eZ(paramInt, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.k
 * JD-Core Version:    0.7.0.1
 */