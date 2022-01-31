package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

final class d$21
  implements Runnable
{
  d$21(d paramd, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(8884);
    i locali = new i();
    locali.pJb = new HashMap();
    locali.pJb.put("username", this.efI);
    locali.vrO = new JSONObject();
    locali.type = "call";
    locali.vrN = "";
    locali.vrQ = "profile";
    d.e(this.voP).add(locali);
    d.f(this.voP);
    AppMethodBeat.o(8884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d.21
 * JD-Core Version:    0.7.0.1
 */