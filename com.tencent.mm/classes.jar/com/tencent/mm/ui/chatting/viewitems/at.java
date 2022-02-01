package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bc.b;
import com.tencent.mm.bc.t;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.neattextview.textview.view.NeatTextView;

final class at
  implements as.a
{
  public final void b(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl)
  {
    AppMethodBeat.i(37379);
    parama = (as.b)parama;
    parama.GPj.aq(parambl.field_content);
    parama.GPj.setTag(new bi(parambl, parama1.eZb(), paramInt, null, '\000'));
    Bundle localBundle = new Bundle();
    localBundle.putString("chatroom_name", parama1.getTalkerUserName());
    localBundle.putLong("msg_id", parambl.field_msgId);
    if ((parambl.field_flag & 0x8) != 0)
    {
      parama.GPj.a(k.a(parama1.GzJ.getContext(), parambl.field_content, (int)parama.GPj.getTextSize(), false, localBundle), TextView.BufferType.SPANNABLE);
      parama.GPj.setClickable(true);
      parambl = t.azZ().yR(parama1.getTalkerUserName());
      az.arV();
      paramInt = ((Integer)c.afk().get(12311, Integer.valueOf(-2))).intValue();
      if (((parambl == null) || (parambl.hoW == -2)) && ((parambl != null) || (paramInt == -2))) {
        break label291;
      }
      parama.GPj.setTextColor(parama1.GzJ.getContext().getResources().getColor(2131100151));
      parama.GPj.setBackground(parama1.GzJ.getContext().getResources().getDrawable(2131231583));
    }
    for (;;)
    {
      parama.GPj.invalidate();
      AppMethodBeat.o(37379);
      return;
      parama.GPj.a(k.a(parama1.GzJ.getContext(), parambl.field_content, (int)parama.GPj.getTextSize(), true, localBundle), TextView.BufferType.SPANNABLE);
      break;
      label291:
      parama.GPj.setTextColor(ao.aD(parama1.GzJ.getContext(), 2130968586));
      parama.GPj.setBackground(parama1.GzJ.getContext().getResources().getDrawable(2131231582));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.at
 * JD-Core Version:    0.7.0.1
 */