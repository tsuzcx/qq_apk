package com.tencent.mm.plugin.webview.modeltools;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.du;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.pluginsdk.model.ad.a;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.xweb.ao;

class SubCoreTools$16
  extends IListener<du>
{
  SubCoreTools$16(g paramg, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(295837);
    this.__eventId = du.class.getName().hashCode();
    AppMethodBeat.o(295837);
  }
  
  private static boolean a(du paramdu)
  {
    AppMethodBeat.i(295844);
    String str1;
    if ((paramdu instanceof du))
    {
      paramdu = MMApplicationContext.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
      boolean bool = ao.aJA(i.aRC().getInt("WebKernelMode", -1));
      Log.i("MicroMsg.SubCoreTools", "updateWebViewDynamicConfig, need check update xwalk:%s", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        MMApplicationContext.getContext();
        ad.a.avN(5);
      }
      str1 = i.aRC().getValue("WebviewDownloadTbs");
      String str2 = i.aRC().getValue("WebviewEnableTbs");
      Log.i("MicroMsg.SubCoreTools", "updateWebViewDynamicConfig, tbsDownload = %s, tbsEnable = %s, tbsSupportedVerSec = %s", new Object[] { str1, str2, i.aRC().getValue("WebviewSupportedTbsVersionSection") });
      if (str1 != null) {
        paramdu.putString("tbs_download", str1);
      }
      paramdu.apply();
      if (("1".equals(str1)) && ("1".equals(str2))) {
        s.rG(1);
      }
      if (str1 == null) {}
    }
    try
    {
      if ("0".equals(str1))
      {
        Log.i("MicroMsg.SubCoreTools", "tbs download disable, reset tbssdk in sandbox");
        paramdu = new Intent();
        paramdu.setComponent(new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.booter.MMReceivers$SandBoxProcessReceiver"));
        MMApplicationContext.getContext().sendBroadcast(paramdu);
      }
      AppMethodBeat.o(295844);
      return false;
    }
    catch (Exception paramdu)
    {
      for (;;)
      {
        Log.w("MicroMsg.SubCoreTools", "sendbroadcast ,ex = %s", new Object[] { paramdu.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.SubCoreTools.16
 * JD-Core Version:    0.7.0.1
 */