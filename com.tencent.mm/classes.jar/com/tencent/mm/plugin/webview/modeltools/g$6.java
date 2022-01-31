package com.tencent.mm.plugin.webview.modeltools;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.h.a.co;
import com.tencent.mm.m.e;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class g$6
  extends c<co>
{
  g$6(g paramg)
  {
    this.udX = co.class.getName().hashCode();
  }
  
  private static boolean a(co paramco)
  {
    String str1;
    if ((paramco instanceof co))
    {
      paramco = ae.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
      str1 = com.tencent.mm.m.g.AA().getValue("WebviewDownloadTbs");
      String str2 = com.tencent.mm.m.g.AA().getValue("WebviewEnableTbs");
      y.i("MicroMsg.SubCoreTools", "updateWebViewDynamicConfig, tbsDownload = %s, tbsEnable = %s, tbsSupportedVerSec = %s", new Object[] { str1, str2, com.tencent.mm.m.g.AA().getValue("WebviewSupportedTbsVersionSection") });
      if (str1 != null) {
        paramco.putString("tbs_download", str1);
      }
      paramco.apply();
      if (("1".equals(str1)) && ("1".equals(str2))) {
        k.jdMethod_if(1);
      }
      if (str1 == null) {}
    }
    try
    {
      if ("0".equals(str1))
      {
        y.i("MicroMsg.SubCoreTools", "tbs download disable, reset tbssdk in sandbox");
        paramco = new Intent();
        paramco.setComponent(new ComponentName(ae.getPackageName(), "com.tencent.mm.booter.MMReceivers$SandBoxProcessReceiver"));
        ae.getContext().sendBroadcast(paramco);
      }
      return false;
    }
    catch (Exception paramco)
    {
      y.w("MicroMsg.SubCoreTools", "sendbroadcast ,ex = %s", new Object[] { paramco.getMessage() });
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.g.6
 * JD-Core Version:    0.7.0.1
 */