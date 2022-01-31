package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.b;
import com.tencent.xweb.c;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class d$27
  implements Runnable
{
  d$27(d paramd, Map paramMap, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(154916);
    try
    {
      if ((this.voQ == null) || (this.voQ.size() == 0)) {
        break label188;
      }
      c.jQ(ah.getContext());
      b localb = b.dYg();
      Iterator localIterator = this.voQ.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localb.setCookie(bo.aqm(this.njr), str + "=" + (String)this.voQ.get(str));
      }
      localException.setCookie(bo.aqm(this.njr), "httponly");
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.JsApiHandler", "onGetA8KeyUrl fail, ex = %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(154916);
      return;
    }
    c.dYi();
    c.sync();
    ab.i("MicroMsg.JsApiHandler", "cookies:%s", new Object[] { localException.getCookie(bo.aqm(this.njr)) });
    label188:
    d.d(this.voP).evaluateJavascript(String.format("javascript:(function(){ window.getA8KeyUrl='%s'; })()", new Object[] { this.njr }), null);
    d.d(this.voP).evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
    if (d.g(this.voP))
    {
      d.d(this.voP).evaluateJavascript(this.voR, null);
      d.h(this.voP);
      d.i(this.voP);
    }
    AppMethodBeat.o(154916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d.27
 * JD-Core Version:    0.7.0.1
 */