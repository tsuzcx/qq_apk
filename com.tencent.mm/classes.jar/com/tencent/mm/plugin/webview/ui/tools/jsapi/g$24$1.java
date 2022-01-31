package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.model.g.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class g$24$1
  implements g.a
{
  g$24$1(g.24 param24) {}
  
  public final void ac(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(154939);
    HashMap localHashMap = new HashMap();
    localHashMap.put("wepkg_info", paramJSONObject);
    this.vqH.vqm.a(this.vqH.uZa, "getLocalWePkgInfo:ok", localHashMap);
    AppMethodBeat.o(154939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.24.1
 * JD-Core Version:    0.7.0.1
 */