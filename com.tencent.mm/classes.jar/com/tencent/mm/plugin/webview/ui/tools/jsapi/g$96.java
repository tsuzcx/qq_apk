package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import com.tencent.mm.ah.m;
import com.tencent.mm.ai.a.c;
import com.tencent.mm.ai.a.t;
import com.tencent.mm.ai.n;
import com.tencent.mm.ai.z;
import com.tencent.mm.protocal.c.aqk;
import com.tencent.mm.protocal.c.bih;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashMap;
import java.util.Map;

final class g$96
  implements n
{
  g$96(g paramg, i parami, String paramString) {}
  
  public final void a(int paramInt, m paramm)
  {
    if (paramInt != 0)
    {
      g.a(this.rzi, this.rzk, "openEnterpriseChat:fail", null);
      return;
    }
    aqk localaqk = ((t)paramm).MV();
    if ((localaqk == null) || (localaqk.sCU == null) || (localaqk.sCU.ret != 0))
    {
      if ((localaqk != null) && (localaqk.sCU != null))
      {
        localObject = new HashMap();
        ((Map)localObject).put("err_code", Integer.valueOf(localaqk.sCU.ret));
        paramm = "openEnterpriseChat:fail";
        if (localaqk.sCU.bLC != null) {
          paramm = localaqk.sCU.bLC;
        }
        g.a(this.rzi, this.rzk, paramm, (Map)localObject);
        return;
      }
      g.a(this.rzi, this.rzk, "openEnterpriseChat:fail", null);
      return;
    }
    Object localObject = localaqk.sCO;
    paramm = ((t)paramm).eia;
    if (paramm == null)
    {
      g.a(this.rzi, this.rzk, "openEnterpriseChat:fail", null);
      return;
    }
    paramm = z.MA().lp(paramm);
    if ((paramm != null) && (!bk.bl((String)localObject)))
    {
      Intent localIntent;
      if ((!bk.bl(this.rAt)) && (this.rAt.equals("long")))
      {
        localIntent = new Intent();
        localIntent.addFlags(67108864);
        localIntent.putExtra("biz_chat_need_to_jump_to_chatting_ui", true);
        localIntent.putExtra("Main_User", (String)localObject);
        localIntent.putExtra("biz_chat_chat_id", paramm.field_bizChatLocalId);
        localIntent.putExtra("biz_chat_from_scene", 8);
        com.tencent.mm.br.d.e(g.i(this.rzi), ".ui.LauncherUI", localIntent);
      }
      for (;;)
      {
        paramm = new HashMap();
        if ((!bk.bl(localaqk.sPN)) && (!bk.bl(localaqk.sPO)))
        {
          paramm.put("chat_type", localaqk.sPN);
          paramm.put("chat_id", localaqk.sPO);
        }
        g.a(this.rzi, this.rzk, "openEnterpriseChat:ok", paramm);
        return;
        localIntent = new Intent();
        localIntent.putExtra("Chat_User", (String)localObject);
        localIntent.putExtra("key_biz_chat_id", paramm.field_bizChatLocalId);
        localIntent.putExtra("finish_direct", true);
        localIntent.putExtra("key_need_send_video", false);
        localIntent.putExtra("key_is_biz_chat", true);
        com.tencent.mm.br.d.e(g.i(this.rzi), ".ui.chatting.ChattingUI", localIntent);
      }
    }
    g.a(this.rzi, this.rzk, "openEnterpriseChat:fail", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.96
 * JD-Core Version:    0.7.0.1
 */