package com.tencent.mm.plugin.webview.ui.tools.preload;

import com.tencent.mm.plugin.webview.preload.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class d$1
  implements Runnable
{
  d$1(String paramString1, String paramString2, Map paramMap, String paramString3, d.a parama, i parami) {}
  
  public final void run()
  {
    b.a locala;
    int j;
    if (this.rBq.toUpperCase().equals("POST"))
    {
      locala = b.a(this.rBr, this.rBs, this.val$data);
      if (locala == null) {
        break label286;
      }
      j = locala.statusCode;
      if (locala.gRQ == null) {
        break label281;
      }
    }
    label281:
    for (int i = locala.gRQ.size();; i = 0)
    {
      y.i("MicroMsg.TmplWebViewJsAPi", "[doRequest]resonse stats:%d, header.size:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      y.v("MicroMsg.TmplWebViewJsAPi", "[doRequest]resonse header:%s data:%s", new Object[] { locala.gRQ, locala.data });
      a.jdMethod_if(71);
      HashMap localHashMap = new HashMap();
      localHashMap.put("statusCode", Integer.valueOf(locala.statusCode));
      localHashMap.put("data", locala.data);
      if ((locala.gRQ != null) && (locala.gRQ.size() > 0))
      {
        d.ar(locala.gRQ);
        localHashMap.put("header", new JSONObject(locala.gRQ).toString());
      }
      y.i("MicroMsg.TmplWebViewJsAPi", "[doRequest]values success");
      y.d("MicroMsg.TmplWebViewJsAPi", "[doRequest]values:%s", new Object[] { localHashMap });
      this.rBt.a(this.rzk, this.rzk.rAO + ":ok", localHashMap);
      return;
      locala = b.v(this.rBr, this.rBs);
      break;
    }
    label286:
    a.jdMethod_if(72);
    y.i("MicroMsg.TmplWebViewJsAPi", "[doRequest]resonse is null, return");
    this.rBt.a(this.rzk, this.rzk.rAO + ":fail", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.preload.d.1
 * JD-Core Version:    0.7.0.1
 */