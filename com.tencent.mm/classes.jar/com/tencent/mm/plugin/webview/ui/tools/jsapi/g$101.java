package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.webview.model.l;
import com.tencent.mm.protocal.protobuf.agb;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

final class g$101
  implements f
{
  g$101(g paramg, i parami) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(155019);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.MsgHandler", "doGetWechatVerifyTicket, errType = " + paramInt1 + ", errCode = " + paramInt2);
      this.vqm.a(this.uZa, "get_wechat_verify_ticket:fail ticket", null);
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.Rc().b(1097, this);
      AppMethodBeat.o(155019);
      return;
      paramString = (l)paramm;
      paramm = new HashMap();
      paramm.put("ticket", ((agb)paramString.lFp.fsW.fta).crs);
      this.vqm.a(this.uZa, "get_wechat_verify_ticket:ok ticket", paramm);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.101
 * JD-Core Version:    0.7.0.1
 */