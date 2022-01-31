package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

final class d$73
  implements Runnable
{
  d$73(d paramd, Bundle paramBundle, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(8932);
    i locali = new i();
    locali.pJb = new HashMap();
    locali.pJb.put("link", this.cax.getString("link"));
    locali.pJb.put("title", this.cax.getString("title"));
    locali.pJb.put("desc", this.cax.getString("desc"));
    locali.vrO = new JSONObject();
    locali.pJb.put("img_url", this.cax.getString("img_url"));
    locali.pJb.put("use_update_jsapi_data", Boolean.valueOf(this.cax.getBoolean("use_update_jsapi_data")));
    locali.type = "call";
    locali.vrN = "";
    locali.vrQ = this.voY;
    d.e(this.voP).add(locali);
    d.f(this.voP);
    AppMethodBeat.o(8932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d.73
 * JD-Core Version:    0.7.0.1
 */