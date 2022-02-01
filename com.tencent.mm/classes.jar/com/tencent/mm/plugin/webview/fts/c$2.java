package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

final class c$2
  implements Runnable
{
  c$2(c paramc, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3) {}
  
  public final void run()
  {
    AppMethodBeat.i(210818);
    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "getTeachSearchData realTime, webviewID = %d", new Object[] { Integer.valueOf(this.IOm) });
    g.azz().a(1048, this.IOi);
    String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    long l = ak.aXe("discoverSearchEntry").optLong("guideParam");
    this.IOi.IOb = new ac(this.gsA, this.val$type, ai.aft(0), this.IOm, str, l, this.DHv, this.lnN, this.IOn);
    g.azz().a(this.IOi.IOb, 0);
    AppMethodBeat.o(210818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c.2
 * JD-Core Version:    0.7.0.1
 */