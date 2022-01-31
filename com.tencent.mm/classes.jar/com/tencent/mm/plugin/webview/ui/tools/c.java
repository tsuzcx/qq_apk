package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.p;

final class c
{
  am ebj = new am(new c.1(this), false);
  d gGn;
  p ksE;
  boolean rlm = false;
  boolean rln = false;
  final c.a rlo;
  OAuthUI rlp;
  
  private c(OAuthUI paramOAuthUI, c.a parama, d paramd)
  {
    this.rlp = paramOAuthUI;
    this.rlo = parama;
    this.gGn = paramd;
  }
  
  public static c a(OAuthUI paramOAuthUI, String paramString, SendAuth.Req paramReq, c.a parama, d paramd)
  {
    paramOAuthUI = new c(paramOAuthUI, parama, paramd);
    parama = paramReq.scope;
    paramReq = paramReq.state;
    if (paramOAuthUI.rlm)
    {
      y.e("MicroMsg.OAuthSession", "already getting");
      return paramOAuthUI;
    }
    paramOAuthUI.rln = true;
    paramd = new Bundle();
    paramd.putString("geta8key_data_appid", paramString);
    paramd.putString("geta8key_data_scope", parama);
    paramd.putString("geta8key_data_state", paramReq);
    try
    {
      paramOAuthUI.gGn.r(233, paramd);
      paramOAuthUI.rlm = true;
      paramOAuthUI.ebj.S(3000L, 3000L);
      return paramOAuthUI;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        y.w("MicroMsg.OAuthSession", "startGetA8Key, ex = " + paramString.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.c
 * JD-Core Version:    0.7.0.1
 */