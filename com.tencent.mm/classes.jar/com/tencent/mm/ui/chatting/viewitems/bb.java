package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.b;
import com.tencent.mm.bb.v;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
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

final class bb
  implements ba.a
{
  public final void b(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca)
  {
    AppMethodBeat.i(37379);
    parama = (ba.b)parama;
    parama.POM.aw(paramca.field_content);
    parama.POM.setTag(new bq(paramca, parama1.gRM(), paramInt, null, '\000'));
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("chatroom_name", parama1.getTalkerUserName());
    ((Bundle)localObject).putLong("msg_id", paramca.field_msgId);
    if ((paramca.field_flag & 0x8) != 0)
    {
      parama.POM.a(l.a(parama1.Pwc.getContext(), paramca.field_content, (int)parama.POM.getTextSize(), false, localObject), TextView.BufferType.SPANNABLE);
      parama.POM.setClickable(true);
      if (paramca.field_content.contains("weixin://wxpay/transfer/remindrcvmsg"))
      {
        paramca = paramca.field_content;
        paramca = k.a.KqM.matcher(paramca);
        if (paramca.find())
        {
          localObject = Uri.parse(paramca.group(1));
          paramca = ((Uri)localObject).getQueryParameter("transferid");
          localObject = ((Uri)localObject).getQueryParameter("transfer_msg_type");
          h.CyF.a(20467, new Object[] { "transfer_to_change", "read message", "", "", "", "", Integer.valueOf(4), paramca, localObject });
        }
      }
      paramca = v.bew().Pp(parama1.getTalkerUserName());
      bg.aVF();
      paramInt = ((Integer)c.azQ().get(12311, Integer.valueOf(-2))).intValue();
      if (((paramca == null) || (paramca.jgE == -2)) && ((paramca != null) || (paramInt == -2))) {
        break label422;
      }
      parama.POM.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131100184));
      parama.POM.setBackground(parama1.Pwc.getContext().getResources().getDrawable(2131231647));
    }
    for (;;)
    {
      parama.POM.invalidate();
      AppMethodBeat.o(37379);
      return;
      parama.POM.a(l.a(parama1.Pwc.getContext(), paramca.field_content, (int)parama.POM.getTextSize(), true, localObject), TextView.BufferType.SPANNABLE);
      break;
      label422:
      parama.POM.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131099749));
      parama.POM.setBackground(parama1.Pwc.getContext().getResources().getDrawable(2131231646));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bb
 * JD-Core Version:    0.7.0.1
 */