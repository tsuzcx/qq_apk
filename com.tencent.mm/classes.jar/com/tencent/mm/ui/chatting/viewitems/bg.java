package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.be.b;
import com.tencent.mm.be.w;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.span.k.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class bg
  implements bf.a
{
  public final void b(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca)
  {
    AppMethodBeat.i(37379);
    bf.b localb = (bf.b)parama;
    localb.XkO.aL(paramca.field_content);
    localb.XkO.setTag(new by(paramca, parama1.hRi(), paramInt, null, '\000'));
    Bundle localBundle = new Bundle();
    localBundle.putString("chatroom_name", parama1.getTalkerUserName());
    localBundle.putLong("msg_id", paramca.field_msgId);
    parama = paramca.field_content;
    if (paramca.getType() == 268445456) {
      parama = paramca.ilz;
    }
    if ((paramca.field_flag & 0x8) != 0)
    {
      localb.XkO.a(l.a(parama1.WQv.getContext(), parama, (int)localb.XkO.getTextSize(), false, localBundle), TextView.BufferType.SPANNABLE);
      localb.XkO.setClickable(true);
      if (paramca.field_content.contains("weixin://wxpay/transfer/remindrcvmsg"))
      {
        parama = paramca.field_content;
        parama = k.a.RrT.matcher(parama);
        if (parama.find())
        {
          paramca = Uri.parse(parama.group(1));
          parama = paramca.getQueryParameter("transferid");
          paramca = paramca.getQueryParameter("transfer_msg_type");
          h.IzE.a(20467, new Object[] { "transfer_to_change", "read message", "", "", "", "", Integer.valueOf(4), parama, paramca });
        }
      }
      parama = w.bnV().WM(parama1.getTalkerUserName());
      bh.beI();
      paramInt = ((Integer)c.aHp().b(12311, Integer.valueOf(-2))).intValue();
      if (((parama == null) || (parama.lXh == -2)) && ((parama != null) || (paramInt == -2))) {
        break label438;
      }
      localb.XkO.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.chatting_to_text_color));
      localb.XkO.setBackground(parama1.WQv.getContext().getResources().getDrawable(R.g.chat_tips_light_bg));
    }
    for (;;)
    {
      localb.XkO.invalidate();
      AppMethodBeat.o(37379);
      return;
      localb.XkO.a(l.a(parama1.WQv.getContext(), parama, (int)localb.XkO.getTextSize(), true, localBundle), TextView.BufferType.SPANNABLE);
      break;
      label438:
      localb.XkO.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.FG_2));
      localb.XkO.setBackground(parama1.WQv.getContext().getResources().getDrawable(R.g.chat_tips_bg));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bg
 * JD-Core Version:    0.7.0.1
 */