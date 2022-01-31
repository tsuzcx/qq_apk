package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.base.p;

final class e
{
  ap frx;
  d igU;
  p mOt;
  boolean vaO;
  boolean vaP;
  final e.a vaQ;
  OAuthUI vaR;
  
  private e(OAuthUI paramOAuthUI, e.a parama, d paramd)
  {
    AppMethodBeat.i(7415);
    this.vaO = false;
    this.vaP = false;
    this.frx = new ap(new e.1(this), false);
    this.vaR = paramOAuthUI;
    this.vaQ = parama;
    this.igU = paramd;
    AppMethodBeat.o(7415);
  }
  
  public static e a(OAuthUI paramOAuthUI, String paramString, SendAuth.Req paramReq, e.a parama, d paramd)
  {
    AppMethodBeat.i(7416);
    paramOAuthUI = new e(paramOAuthUI, parama, paramd);
    parama = paramReq.scope;
    paramReq = paramReq.state;
    if (paramOAuthUI.vaO) {
      ab.e("MicroMsg.OAuthSession", "already getting");
    }
    for (;;)
    {
      AppMethodBeat.o(7416);
      return paramOAuthUI;
      paramOAuthUI.vaP = true;
      paramd = new Bundle();
      paramd.putString("geta8key_data_appid", paramString);
      paramd.putString("geta8key_data_scope", parama);
      paramd.putString("geta8key_data_state", paramReq);
      try
      {
        paramOAuthUI.igU.v(233, paramd);
        paramOAuthUI.vaO = true;
        paramOAuthUI.frx.ag(3000L, 3000L);
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ab.w("MicroMsg.OAuthSession", "startGetA8Key, ex = " + paramString.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.e
 * JD-Core Version:    0.7.0.1
 */