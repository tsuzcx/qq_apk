package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.t;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.d.a;

final class d$a
{
  static void a(Intent paramIntent, a parama, bi parambi, c paramc)
  {
    AppMethodBeat.i(32803);
    String str = parama.getTalkerUserName();
    paramc = paramc.b(parama, parambi);
    Bundle localBundle = new Bundle();
    int i;
    if (parama.dJG()) {
      i = 2;
    }
    for (;;)
    {
      localBundle.putInt("stat_scene", i);
      localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambi.field_msgSvrId));
      localBundle.putString("stat_chat_talker_username", str);
      localBundle.putString("stat_send_msg_user", paramc);
      paramIntent.putExtra("_stat_obj", localBundle);
      AppMethodBeat.o(32803);
      return;
      if (t.nU(str)) {
        i = 7;
      } else {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.a
 * JD-Core Version:    0.7.0.1
 */