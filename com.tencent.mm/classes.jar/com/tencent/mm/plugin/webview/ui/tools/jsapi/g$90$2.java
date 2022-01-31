package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import com.tencent.mm.h.a.fo;
import com.tencent.mm.h.a.fo.b;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashMap;

final class g$90$2
  implements Runnable
{
  g$90$2(g.90 param90, fo paramfo) {}
  
  public final void run()
  {
    if (this.rAq.bMA.aES)
    {
      if (g.k(this.rAp.rzi) != null)
      {
        g.k(this.rAp.rzi).dismiss();
        g.a(this.rAp.rzi, null);
      }
      if (bk.bl(this.rAq.bMA.content)) {
        g.a(this.rAp.rzi, this.rAp.rzk, "translateVoice:fail", null);
      }
    }
    else
    {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("translateResult", this.rAq.bMA.content);
    g.a(this.rAp.rzi, this.rAp.rzk, "translateVoice:ok", localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.90.2
 * JD-Core Version:    0.7.0.1
 */