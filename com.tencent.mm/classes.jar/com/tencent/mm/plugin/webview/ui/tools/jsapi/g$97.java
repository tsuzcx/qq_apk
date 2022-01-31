package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import com.tencent.mm.ai.a.c;
import com.tencent.mm.ai.n;
import com.tencent.mm.ai.z;
import com.tencent.mm.protocal.c.bih;
import com.tencent.mm.protocal.c.rr;
import com.tencent.mm.sdk.platformtools.bk;

final class g$97
  implements n
{
  g$97(g paramg, i parami) {}
  
  public final void a(int paramInt, com.tencent.mm.ah.m paramm)
  {
    if (paramInt != 0)
    {
      g.a(this.rzi, this.rzk, "enterEnterpriseChat:fail", null);
      return;
    }
    Object localObject = ((com.tencent.mm.ai.a.m)paramm).MS();
    String str = "enterEnterpriseChat:fail";
    if (paramInt < 0)
    {
      paramm = str;
      if (localObject != null)
      {
        paramm = str;
        if (((rr)localObject).sCU != null)
        {
          paramm = str;
          if (bk.bl(((rr)localObject).sCU.bLC)) {
            paramm = "enterEnterpriseChat:fail_" + ((rr)localObject).sCU.bLC;
          }
        }
      }
      g.a(this.rzi, this.rzk, paramm, null);
      return;
    }
    str = ((rr)localObject).sCO;
    paramm = ((com.tencent.mm.ai.a.m)paramm).eia;
    if (paramm == null)
    {
      g.a(this.rzi, this.rzk, "enterEnterpriseChat:fail", null);
      return;
    }
    paramm = z.MA().lp(paramm);
    if ((paramm != null) && (!bk.bl(str)))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("Chat_User", str);
      ((Intent)localObject).putExtra("key_biz_chat_id", paramm.field_bizChatLocalId);
      ((Intent)localObject).putExtra("finish_direct", true);
      ((Intent)localObject).putExtra("key_need_send_video", false);
      ((Intent)localObject).putExtra("key_is_biz_chat", true);
      com.tencent.mm.br.d.e(g.i(this.rzi), ".ui.chatting.ChattingUI", (Intent)localObject);
      g.a(this.rzi, this.rzk, "enterEnterpriseChat:ok", null);
      return;
    }
    g.a(this.rzi, this.rzk, "enterEnterpriseChat:fail", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.97
 * JD-Core Version:    0.7.0.1
 */