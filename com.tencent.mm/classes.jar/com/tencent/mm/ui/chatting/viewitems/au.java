package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.b;
import com.tencent.mm.bb.t;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.neattextview.textview.view.NeatTextView;

final class au
  implements at.a
{
  public final void b(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo)
  {
    AppMethodBeat.i(37379);
    parama = (at.b)parama;
    parama.Ipl.ar(parambo.field_content);
    parama.Ipl.setTag(new bj(parambo, parama1.foQ(), paramInt, null, '\000'));
    Bundle localBundle = new Bundle();
    localBundle.putString("chatroom_name", parama1.getTalkerUserName());
    localBundle.putLong("msg_id", parambo.field_msgId);
    if ((parambo.field_flag & 0x8) != 0)
    {
      parama.Ipl.a(k.a(parama1.HZF.getContext(), parambo.field_content, (int)parama.Ipl.getTextSize(), false, localBundle), TextView.BufferType.SPANNABLE);
      parama.Ipl.setClickable(true);
      parambo = t.aGP().CW(parama1.getTalkerUserName());
      az.ayM();
      paramInt = ((Integer)c.agA().get(12311, Integer.valueOf(-2))).intValue();
      if (((parambo == null) || (parambo.hPy == -2)) && ((parambo != null) || (paramInt == -2))) {
        break label291;
      }
      parama.Ipl.setTextColor(parama1.HZF.getContext().getResources().getColor(2131100151));
      parama.Ipl.setBackground(parama1.HZF.getContext().getResources().getDrawable(2131231583));
    }
    for (;;)
    {
      parama.Ipl.invalidate();
      AppMethodBeat.o(37379);
      return;
      parama.Ipl.a(k.a(parama1.HZF.getContext(), parambo.field_content, (int)parama.Ipl.getTextSize(), true, localBundle), TextView.BufferType.SPANNABLE);
      break;
      label291:
      parama.Ipl.setTextColor(ao.aJ(parama1.HZF.getContext(), 2130968586));
      parama.Ipl.setBackground(parama1.HZF.getContext().getResources().getDrawable(2131231582));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.au
 * JD-Core Version:    0.7.0.1
 */