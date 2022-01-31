package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.webview.model.j;
import com.tencent.mm.protocal.c.abl;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

final class g$91
  implements f
{
  g$91(g paramg, i parami) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e("MicroMsg.MsgHandler", "doGetWechatVerifyTicket, errType = " + paramInt1 + ", errCode = " + paramInt2);
      g.a(this.rzi, this.rzk, "get_wechat_verify_ticket:fail ticket", null);
    }
    for (;;)
    {
      au.Dk().b(1097, this);
      return;
      paramString = (j)paramm;
      paramm = new HashMap();
      paramm.put("ticket", ((abl)paramString.jvQ.ecF.ecN).bJY);
      g.a(this.rzi, this.rzk, "get_wechat_verify_ticket:ok ticket", paramm);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.91
 * JD-Core Version:    0.7.0.1
 */