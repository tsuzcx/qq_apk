package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.plugin.wepkg.model.e.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class g$33$1
  implements e.a
{
  g$33$1(g.33 param33) {}
  
  public final void R(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("wepkg_info", paramJSONObject);
    g.a(this.rzK.rzi, this.rzK.rzk, "getLocalWePkgInfo:ok", localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.33.1
 * JD-Core Version:    0.7.0.1
 */