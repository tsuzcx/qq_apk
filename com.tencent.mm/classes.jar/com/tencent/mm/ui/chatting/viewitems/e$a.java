package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.ab;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.d.a;

final class e$a
{
  static void a(Intent paramIntent, a parama, cc paramcc, c paramc)
  {
    AppMethodBeat.i(36752);
    String str = parama.getTalkerUserName();
    paramc = paramc.a(parama, paramcc);
    Bundle localBundle = new Bundle();
    int i;
    if (parama.juG()) {
      i = 2;
    }
    for (;;)
    {
      localBundle.putInt("stat_scene", i);
      localBundle.putString("stat_msg_id", "msg_" + Long.toString(paramcc.field_msgSvrId));
      localBundle.putString("stat_chat_talker_username", str);
      localBundle.putString("stat_send_msg_user", paramc);
      paramIntent.putExtra("_stat_obj", localBundle);
      AppMethodBeat.o(36752);
      return;
      if (ab.IS(str)) {
        i = 7;
      } else {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.e.a
 * JD-Core Version:    0.7.0.1
 */