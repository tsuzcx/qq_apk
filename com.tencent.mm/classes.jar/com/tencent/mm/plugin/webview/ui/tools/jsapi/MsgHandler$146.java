package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.oz;
import com.tencent.mm.autogen.a.oz.a;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

class MsgHandler$146
  extends IListener<oz>
{
  MsgHandler$146(j paramj, q paramq, Map paramMap, p paramp)
  {
    super(paramq);
    AppMethodBeat.i(297440);
    this.__eventId = oz.class.getName().hashCode();
    AppMethodBeat.o(297440);
  }
  
  private boolean a(oz paramoz)
  {
    AppMethodBeat.i(297447);
    j.M(this.XjI).dead();
    Log.i("MicroMsg.MsgHandler", "doOpenBusinessView errCode %d", new Object[] { Integer.valueOf(paramoz.hRQ.errCode) });
    this.Kav.put("err_code", Integer.valueOf(paramoz.hRQ.errCode));
    switch (paramoz.hRQ.errCode)
    {
    case -1: 
    default: 
      this.XjI.callback(this.WEp, "openBusinessView:fail system error", this.Kav);
    }
    for (;;)
    {
      AppMethodBeat.o(297447);
      return false;
      this.Kav.put("extraData", paramoz.hRQ.hRR);
      this.XjI.callback(this.WEp, "openBusinessView:ok", this.Kav);
      continue;
      this.XjI.callback(this.WEp, "openBusinessView:fail request CGI error", this.Kav);
      continue;
      this.XjI.callback(this.WEp, "openBusinessView:fail cancel", this.Kav);
      continue;
      this.XjI.callback(this.WEp, "openBusinessView:fail invalid businessType", this.Kav);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.MsgHandler.146
 * JD-Core Version:    0.7.0.1
 */