package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bc.b;
import com.tencent.mm.bc.t;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.span.j.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class av
  implements au.a
{
  public final void b(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu)
  {
    AppMethodBeat.i(37379);
    parama = (au.b)parama;
    parama.KfL.ar(parambu.field_content);
    parama.KfL.setTag(new bk(parambu, parama1.fFv(), paramInt, null, '\000'));
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("chatroom_name", parama1.getTalkerUserName());
    ((Bundle)localObject).putLong("msg_id", parambu.field_msgId);
    if ((parambu.field_flag & 0x8) != 0)
    {
      parama.KfL.a(k.a(parama1.JOR.getContext(), parambu.field_content, (int)parama.KfL.getTextSize(), false, localObject), TextView.BufferType.SPANNABLE);
      parama.KfL.setClickable(true);
      if (parambu.field_content.contains("weixin://wxpay/transfer/remindrcvmsg"))
      {
        parambu = parambu.field_content;
        parambu = j.a.Fhm.matcher(parambu);
        if (parambu.find())
        {
          localObject = Uri.parse(parambu.group(1));
          parambu = ((Uri)localObject).getQueryParameter("transferid");
          localObject = ((Uri)localObject).getQueryParameter("transfer_msg_type");
          g.yhR.f(20467, new Object[] { "transfer_to_change", "read message", "", "", "", "", Integer.valueOf(4), parambu, localObject });
        }
      }
      parambu = t.aKa().Gb(parama1.getTalkerUserName());
      ba.aBQ();
      paramInt = ((Integer)c.ajl().get(12311, Integer.valueOf(-2))).intValue();
      if (((parambu == null) || (parambu.iiM == -2)) && ((parambu != null) || (paramInt == -2))) {
        break label422;
      }
      parama.KfL.setTextColor(parama1.JOR.getContext().getResources().getColor(2131100151));
      parama.KfL.setBackground(parama1.JOR.getContext().getResources().getDrawable(2131231583));
    }
    for (;;)
    {
      parama.KfL.invalidate();
      AppMethodBeat.o(37379);
      return;
      parama.KfL.a(k.a(parama1.JOR.getContext(), parambu.field_content, (int)parama.KfL.getTextSize(), true, localObject), TextView.BufferType.SPANNABLE);
      break;
      label422:
      parama.KfL.setTextColor(parama1.JOR.getContext().getResources().getColor(2131099735));
      parama.KfL.setBackground(parama1.JOR.getContext().getResources().getDrawable(2131231582));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.av
 * JD-Core Version:    0.7.0.1
 */