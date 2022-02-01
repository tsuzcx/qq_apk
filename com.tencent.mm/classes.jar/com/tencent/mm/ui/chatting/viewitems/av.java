package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.b;
import com.tencent.mm.bb.t;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.span.j.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class av
  implements au.a
{
  public final void b(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv)
  {
    AppMethodBeat.i(37379);
    parama = (au.b)parama;
    parama.KCe.aq(parambv.field_content);
    parama.KCe.setTag(new bk(parambv, parama1.fJC(), paramInt, null, '\000'));
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("chatroom_name", parama1.getTalkerUserName());
    ((Bundle)localObject).putLong("msg_id", parambv.field_msgId);
    if ((parambv.field_flag & 0x8) != 0)
    {
      parama.KCe.a(k.a(parama1.Kkd.getContext(), parambv.field_content, (int)parama.KCe.getTextSize(), false, localObject), TextView.BufferType.SPANNABLE);
      parama.KCe.setClickable(true);
      if (parambv.field_content.contains("weixin://wxpay/transfer/remindrcvmsg"))
      {
        parambv = parambv.field_content;
        parambv = j.a.FzK.matcher(parambv);
        if (parambv.find())
        {
          localObject = Uri.parse(parambv.group(1));
          parambv = ((Uri)localObject).getQueryParameter("transferid");
          localObject = ((Uri)localObject).getQueryParameter("transfer_msg_type");
          g.yxI.f(20467, new Object[] { "transfer_to_change", "read message", "", "", "", "", Integer.valueOf(4), parambv, localObject });
        }
      }
      parambv = t.aKt().GD(parama1.getTalkerUserName());
      bc.aCg();
      paramInt = ((Integer)c.ajA().get(12311, Integer.valueOf(-2))).intValue();
      if (((parambv == null) || (parambv.ilF == -2)) && ((parambv != null) || (paramInt == -2))) {
        break label422;
      }
      parama.KCe.setTextColor(parama1.Kkd.getContext().getResources().getColor(2131100151));
      parama.KCe.setBackground(parama1.Kkd.getContext().getResources().getDrawable(2131231583));
    }
    for (;;)
    {
      parama.KCe.invalidate();
      AppMethodBeat.o(37379);
      return;
      parama.KCe.a(k.a(parama1.Kkd.getContext(), parambv.field_content, (int)parama.KCe.getTextSize(), true, localObject), TextView.BufferType.SPANNABLE);
      break;
      label422:
      parama.KCe.setTextColor(parama1.Kkd.getContext().getResources().getColor(2131099735));
      parama.KCe.setBackground(parama1.Kkd.getContext().getResources().getDrawable(2131231582));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.av
 * JD-Core Version:    0.7.0.1
 */