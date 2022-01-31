package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.az.b;
import com.tencent.mm.az.r;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.chatting.e;

final class ah
  implements ag.a
{
  public final void b(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi)
  {
    parama = (ag.b)parama;
    parama.vEC.setText(parambi.field_content);
    Bundle localBundle = new Bundle();
    localBundle.putString("chatroom_name", parama1.getTalkerUserName());
    localBundle.putLong("msg_id", parambi.field_msgId);
    if ((parambi.field_flag & 0x8) != 0)
    {
      j.a(parama.vEC, false, localBundle);
      parama.vEC.setClickable(true);
      parambi = r.PL().mI(parama1.getTalkerUserName());
      au.Hx();
      paramInt = ((Integer)c.Dz().get(12311, Integer.valueOf(-2))).intValue();
      if (((parambi == null) || (parambi.ewu == -2)) && ((parambi != null) || (paramInt == -2))) {
        break label209;
      }
      parama.vEC.setTextColor(parama1.vtz.getContext().getResources().getColor(R.e.black_text_color));
      parama.vEC.setBackground(parama1.vtz.getContext().getResources().getDrawable(R.g.chat_tips_light_bg));
    }
    for (;;)
    {
      parama.vEC.invalidate();
      return;
      j.a(parama.vEC, localBundle);
      break;
      label209:
      parama.vEC.setTextColor(parama1.vtz.getContext().getResources().getColor(R.e.white_text_color));
      parama.vEC.setBackground(parama1.vtz.getContext().getResources().getDrawable(R.g.chat_tips_bg));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ah
 * JD-Core Version:    0.7.0.1
 */