package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.c;
import com.tencent.mm.aj.n;
import com.tencent.mm.aj.z;
import com.tencent.mm.protocal.protobuf.bqx;
import com.tencent.mm.protocal.protobuf.vl;
import com.tencent.mm.sdk.platformtools.bo;

final class g$107
  implements n
{
  g$107(g paramg, i parami) {}
  
  public final void a(int paramInt, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(9183);
    if (paramInt != 0)
    {
      this.vqm.a(this.uZa, "enterEnterpriseChat:fail", null);
      AppMethodBeat.o(9183);
      return;
    }
    Object localObject = ((com.tencent.mm.aj.a.m)paramm).afC();
    String str = "enterEnterpriseChat:fail";
    if (paramInt < 0)
    {
      paramm = str;
      if (localObject != null)
      {
        paramm = str;
        if (((vl)localObject).wyn != null)
        {
          paramm = str;
          if (bo.isNullOrNil(((vl)localObject).wyn.csW)) {
            paramm = "enterEnterpriseChat:fail_" + ((vl)localObject).wyn.csW;
          }
        }
      }
      this.vqm.a(this.uZa, paramm, null);
      AppMethodBeat.o(9183);
      return;
    }
    str = ((vl)localObject).wyh;
    paramm = ((com.tencent.mm.aj.a.m)paramm).fye;
    if (paramm == null)
    {
      this.vqm.a(this.uZa, "enterEnterpriseChat:fail", null);
      AppMethodBeat.o(9183);
      return;
    }
    paramm = z.afk().sl(paramm);
    if ((paramm != null) && (!bo.isNullOrNil(str)))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("Chat_User", str);
      ((Intent)localObject).putExtra("key_biz_chat_id", paramm.field_bizChatLocalId);
      ((Intent)localObject).putExtra("finish_direct", true);
      ((Intent)localObject).putExtra("key_need_send_video", false);
      ((Intent)localObject).putExtra("key_is_biz_chat", true);
      com.tencent.mm.bq.d.f(g.j(this.vqm), ".ui.chatting.ChattingUI", (Intent)localObject);
      this.vqm.a(this.uZa, "enterEnterpriseChat:ok", null);
      AppMethodBeat.o(9183);
      return;
    }
    this.vqm.a(this.uZa, "enterEnterpriseChat:fail", null);
    AppMethodBeat.o(9183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.107
 * JD-Core Version:    0.7.0.1
 */