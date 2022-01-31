package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.a.c;
import com.tencent.mm.aj.a.t;
import com.tencent.mm.aj.n;
import com.tencent.mm.aj.z;
import com.tencent.mm.protocal.protobuf.awm;
import com.tencent.mm.protocal.protobuf.bqx;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

final class g$106
  implements n
{
  g$106(g paramg, i parami, String paramString) {}
  
  public final void a(int paramInt, m paramm)
  {
    AppMethodBeat.i(155027);
    if (paramInt != 0)
    {
      this.vqm.a(this.uZa, "openEnterpriseChat:fail", null);
      AppMethodBeat.o(155027);
      return;
    }
    awm localawm = ((t)paramm).afF();
    if ((localawm == null) || (localawm.wyn == null) || (localawm.wyn.ret != 0))
    {
      if ((localawm != null) && (localawm.wyn != null))
      {
        localObject = new HashMap();
        ((Map)localObject).put("err_code", Integer.valueOf(localawm.wyn.ret));
        paramm = "openEnterpriseChat:fail";
        if (localawm.wyn.csW != null) {
          paramm = localawm.wyn.csW;
        }
        this.vqm.a(this.uZa, paramm, (Map)localObject);
        AppMethodBeat.o(155027);
        return;
      }
      this.vqm.a(this.uZa, "openEnterpriseChat:fail", null);
      AppMethodBeat.o(155027);
      return;
    }
    Object localObject = localawm.wyh;
    paramm = ((t)paramm).fye;
    if (paramm == null)
    {
      this.vqm.a(this.uZa, "openEnterpriseChat:fail", null);
      AppMethodBeat.o(155027);
      return;
    }
    paramm = z.afk().sl(paramm);
    if ((paramm != null) && (!bo.isNullOrNil((String)localObject)))
    {
      Intent localIntent;
      if ((!bo.isNullOrNil(this.vrw)) && (this.vrw.equals("long")))
      {
        localIntent = new Intent();
        localIntent.addFlags(67108864);
        localIntent.putExtra("biz_chat_need_to_jump_to_chatting_ui", true);
        localIntent.putExtra("Main_User", (String)localObject);
        localIntent.putExtra("biz_chat_chat_id", paramm.field_bizChatLocalId);
        localIntent.putExtra("biz_chat_from_scene", 8);
        com.tencent.mm.bq.d.f(g.j(this.vqm), ".ui.LauncherUI", localIntent);
      }
      for (;;)
      {
        paramm = new HashMap();
        if ((!bo.isNullOrNil(localawm.wOg)) && (!bo.isNullOrNil(localawm.wOh)))
        {
          paramm.put("chat_type", localawm.wOg);
          paramm.put("chat_id", localawm.wOh);
        }
        this.vqm.a(this.uZa, "openEnterpriseChat:ok", paramm);
        AppMethodBeat.o(155027);
        return;
        localIntent = new Intent();
        localIntent.putExtra("Chat_User", (String)localObject);
        localIntent.putExtra("key_biz_chat_id", paramm.field_bizChatLocalId);
        localIntent.putExtra("finish_direct", true);
        localIntent.putExtra("key_need_send_video", false);
        localIntent.putExtra("key_is_biz_chat", true);
        com.tencent.mm.bq.d.f(g.j(this.vqm), ".ui.chatting.ChattingUI", localIntent);
      }
    }
    this.vqm.a(this.uZa, "openEnterpriseChat:fail", null);
    AppMethodBeat.o(155027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.106
 * JD-Core Version:    0.7.0.1
 */