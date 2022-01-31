package com.tencent.mm.plugin.webview.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class e$1
  implements Runnable
{
  e$1(String paramString1, String paramString2, Map paramMap, String paramString3, e.a parama, i parami) {}
  
  public final void run()
  {
    AppMethodBeat.i(7047);
    d.a locala;
    int j;
    if (this.uYW.toUpperCase().equals("POST"))
    {
      locala = d.a(this.uYX, this.uYY, this.val$data);
      if (locala == null) {
        break label298;
      }
      j = locala.statusCode;
      if (locala.itJ == null) {
        break label293;
      }
    }
    label293:
    for (int i = locala.itJ.size();; i = 0)
    {
      ab.i("MicroMsg.TmplWebViewJsAPi", "[doRequest]resonse stats:%d, header.size:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      ab.v("MicroMsg.TmplWebViewJsAPi", "[doRequest]resonse header:%s data:%s", new Object[] { locala.itJ, locala.data });
      a.kS(71);
      HashMap localHashMap = new HashMap();
      localHashMap.put("statusCode", Integer.valueOf(locala.statusCode));
      localHashMap.put("data", locala.data);
      if ((locala.itJ != null) && (locala.itJ.size() > 0))
      {
        e.aI(locala.itJ);
        localHashMap.put("header", new JSONObject(locala.itJ).toString());
      }
      ab.i("MicroMsg.TmplWebViewJsAPi", "[doRequest]values success");
      ab.d("MicroMsg.TmplWebViewJsAPi", "[doRequest]values:%s", new Object[] { localHashMap });
      this.uYZ.a(this.uZa, this.uZa.vrQ + ":ok", localHashMap);
      AppMethodBeat.o(7047);
      return;
      locala = d.y(this.uYX, this.uYY);
      break;
    }
    label298:
    a.kS(72);
    ab.i("MicroMsg.TmplWebViewJsAPi", "[doRequest]resonse is null, return");
    this.uYZ.a(this.uZa, this.uZa.vrQ + ":fail", null);
    AppMethodBeat.o(7047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.preload.e.1
 * JD-Core Version:    0.7.0.1
 */