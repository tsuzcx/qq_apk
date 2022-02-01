package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.c;
import com.tencent.mm.modelpackage.b;
import com.tencent.mm.modelpackage.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.span.o.a;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class bh
  extends bg.a
{
  public final void b(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc)
  {
    AppMethodBeat.i(37379);
    bg.b localb = (bg.b)parama;
    localb.aeVA.aZ(paramcc.field_content);
    localb.aeVA.setTag(new bz(paramcc, parama1.juG(), paramInt, null, '\000'));
    Bundle localBundle = new Bundle();
    localBundle.putString("chatroom_name", parama1.getTalkerUserName());
    localBundle.putLong("msg_id", paramcc.field_msgId);
    parama = paramcc.field_content;
    if (paramcc.getType() == 268445456) {
      parama = paramcc.kLy;
    }
    if ((paramcc.field_flag & 0x8) != 0)
    {
      localb.aeVA.a(p.a(parama1.aezO.getContext(), parama, (int)localb.aeVA.getTextSize(), false, localBundle), TextView.BufferType.SPANNABLE);
      localb.aeVA.setClickable(true);
      if (paramcc.field_content.contains("weixin://wxpay/transfer/remindrcvmsg"))
      {
        parama = paramcc.field_content;
        parama = o.a.Yom.matcher(parama);
        if (parama.find())
        {
          paramcc = Uri.parse(parama.group(1));
          parama = paramcc.getQueryParameter("transferid");
          paramcc = paramcc.getQueryParameter("transfer_msg_type");
          h.OAn.b(20467, new Object[] { "transfer_to_change", "read message", "", "", "", "", Integer.valueOf(4), parama, paramcc });
        }
      }
      parama = u.bLI().OM(parama1.getTalkerUserName());
      com.tencent.mm.model.bh.bCz();
      paramInt = ((Integer)c.ban().d(12311, Integer.valueOf(-2))).intValue();
      if (((parama == null) || (parama.oQj == -2)) && ((parama != null) || (paramInt == -2))) {
        break label438;
      }
      localb.aeVA.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.chatting_to_text_color));
      localb.aeVA.setBackground(parama1.aezO.getContext().getResources().getDrawable(R.g.chat_tips_light_bg));
    }
    for (;;)
    {
      localb.aeVA.invalidate();
      AppMethodBeat.o(37379);
      return;
      localb.aeVA.a(p.a(parama1.aezO.getContext(), parama, (int)localb.aeVA.getTextSize(), true, localBundle), TextView.BufferType.SPANNABLE);
      break;
      label438:
      localb.aeVA.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.FG_2));
      localb.aeVA.setBackground(parama1.aezO.getContext().getResources().getDrawable(R.g.chat_tips_bg));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bh
 * JD-Core Version:    0.7.0.1
 */