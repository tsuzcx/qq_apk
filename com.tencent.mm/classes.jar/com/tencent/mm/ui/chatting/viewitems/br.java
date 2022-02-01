package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelappbrand.l;
import com.tencent.mm.modelpackage.b;
import com.tencent.mm.modelpackage.u;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;

final class br
  extends bg.a
{
  public final void b(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc)
  {
    AppMethodBeat.i(37550);
    String str = parama1.getTalkerUserName();
    parama = (bg.b)parama;
    Bundle localBundle = new Bundle();
    localBundle.putString("conv_talker_username", str);
    if ((parama1.aezO instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
    {
      paramInt = 10;
      localBundle.putInt("scene", paramInt);
      localBundle.putLong("msg_id", paramcc.field_msgId);
      localBundle.putLong("msg_sever_id", paramcc.field_msgSvrId);
      localBundle.putString("send_msg_username", paramcc.field_talker);
      paramcc = ((l)h.ax(l.class)).a(paramcc.field_content, localBundle, new WeakReference(parama1.aezO.getContext()), new WeakReference(parama.aeVA));
      if ((paramcc != null) && (paramcc.length() != 0)) {
        break label328;
      }
      parama.convertView.setVisibility(8);
      label162:
      paramcc = u.bLI().OM(str);
      bh.bCz();
      paramInt = ((Integer)c.ban().d(12311, Integer.valueOf(-2))).intValue();
      if (((paramcc == null) || (paramcc.oQj == -2)) && ((paramcc != null) || (paramInt == -2))) {
        break label348;
      }
      parama.aeVA.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.chatting_to_text_color));
      parama.aeVA.setBackground(parama1.aezO.getContext().getResources().getDrawable(R.g.chat_tips_light_bg));
    }
    for (;;)
    {
      parama.aeVA.setOnClickListener(new br.1(this));
      parama.aeVA.invalidate();
      AppMethodBeat.o(37550);
      return;
      if (parama1.juG())
      {
        paramInt = 2;
        break;
      }
      if (ab.IS(str))
      {
        paramInt = 7;
        break;
      }
      paramInt = 1;
      break;
      label328:
      parama.convertView.setVisibility(0);
      parama.aeVA.aZ(paramcc);
      break label162;
      label348:
      parama.aeVA.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.FG_2));
      parama.aeVA.setBackground(parama1.aezO.getContext().getResources().getDrawable(R.g.chat_tips_bg));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.br
 * JD-Core Version:    0.7.0.1
 */