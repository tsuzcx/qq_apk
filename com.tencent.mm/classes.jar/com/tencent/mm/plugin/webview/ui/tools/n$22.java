package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.64;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

final class n$22
  implements Runnable
{
  n$22(n paramn, WebViewUI paramWebViewUI, d paramd, JSONArray paramJSONArray) {}
  
  public final void run()
  {
    AppMethodBeat.i(7734);
    if ((this.vdo == null) || (this.vdo.isFinishing()))
    {
      AppMethodBeat.o(7734);
      return;
    }
    if (this.vdp != null)
    {
      d locald = this.vdp;
      JSONArray localJSONArray = this.val$jsonArray;
      if (localJSONArray == null)
      {
        ab.e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, not ready");
        AppMethodBeat.o(7734);
        return;
      }
      ab.i("MicroMsg.JsApiHandler", "onGetMsgProofItems success, ready");
      HashMap localHashMap = new HashMap();
      localHashMap.put("msgs", localJSONArray);
      al.d(new d.64(locald, i.a.b("onGetMsgProofItems", localHashMap, locald.voB, locald.voC)));
    }
    AppMethodBeat.o(7734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.22
 * JD-Core Version:    0.7.0.1
 */