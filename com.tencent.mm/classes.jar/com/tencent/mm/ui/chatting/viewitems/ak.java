package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.b;
import com.tencent.mm.ba.r;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.neattextview.textview.view.NeatTextView;

final class ak
  implements aj.a
{
  public final void b(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi)
  {
    AppMethodBeat.i(33282);
    parama = (aj.b)parama;
    parama.zWS.af(parambi.field_content);
    Bundle localBundle = new Bundle();
    localBundle.putString("chatroom_name", parama1.getTalkerUserName());
    localBundle.putLong("msg_id", parambi.field_msgId);
    if ((parambi.field_flag & 0x8) != 0)
    {
      parama.zWS.a(j.a(parama1.zJz.getContext(), parambi.field_content, (int)parama.zWS.getTextSize(), false, localBundle), TextView.BufferType.SPANNABLE);
      parama.zWS.setClickable(true);
      parambi = r.aiQ().tS(parama1.getTalkerUserName());
      aw.aaz();
      paramInt = ((Integer)c.Ru().get(12311, Integer.valueOf(-2))).intValue();
      if (((parambi == null) || (parambi.fMk == -2)) && ((parambi != null) || (paramInt == -2))) {
        break label268;
      }
      parama.zWS.setTextColor(parama1.zJz.getContext().getResources().getColor(2131689766));
      parama.zWS.setBackground(parama1.zJz.getContext().getResources().getDrawable(2130838246));
    }
    for (;;)
    {
      parama.zWS.invalidate();
      AppMethodBeat.o(33282);
      return;
      parama.zWS.a(j.a(parama1.zJz.getContext(), parambi.field_content, (int)parama.zWS.getTextSize(), true, localBundle), TextView.BufferType.SPANNABLE);
      break;
      label268:
      parama.zWS.setTextColor(parama1.zJz.getContext().getResources().getColor(2131690564));
      parama.zWS.setBackground(parama1.zJz.getContext().getResources().getDrawable(2130838245));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ak
 * JD-Core Version:    0.7.0.1
 */