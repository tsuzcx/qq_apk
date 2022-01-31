package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kk;
import com.tencent.mm.g.a.kk.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;

final class g$27
  extends c<kk>
{
  g$27(g paramg, Map paramMap, i parami)
  {
    AppMethodBeat.i(154943);
    this.__eventId = kk.class.getName().hashCode();
    AppMethodBeat.o(154943);
  }
  
  private boolean a(kk paramkk)
  {
    AppMethodBeat.i(154944);
    g.J(this.vqm).dead();
    ab.i("MicroMsg.MsgHandler", "doOpenBusinessView errCode %d", new Object[] { Integer.valueOf(paramkk.cAg.errCode) });
    this.vqI.put("err_code", Integer.valueOf(paramkk.cAg.errCode));
    switch (paramkk.cAg.errCode)
    {
    case -1: 
    default: 
      this.vqm.a(this.uZa, "openBusinessView:fail system error", this.vqI);
    }
    for (;;)
    {
      AppMethodBeat.o(154944);
      return false;
      this.vqI.put("extraData", paramkk.cAg.cAh);
      this.vqm.a(this.uZa, "openBusinessView:ok", this.vqI);
      continue;
      this.vqm.a(this.uZa, "openBusinessView:fail request CGI error", this.vqI);
      continue;
      this.vqm.a(this.uZa, "openBusinessView:fail cancel", this.vqI);
      continue;
      this.vqm.a(this.uZa, "openBusinessView:fail invalid businessType", this.vqI);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.27
 * JD-Core Version:    0.7.0.1
 */