package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.b;
import com.tencent.mm.bb.v;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelappbrand.l;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;

final class bl
  implements ba.a
{
  public final void b(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca)
  {
    AppMethodBeat.i(37550);
    String str = parama1.getTalkerUserName();
    parama = (ba.b)parama;
    Bundle localBundle = new Bundle();
    localBundle.putString("conv_talker_username", str);
    if ((parama1.Pwc instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
    {
      paramInt = 10;
      localBundle.putInt("scene", paramInt);
      localBundle.putLong("msg_id", paramca.field_msgId);
      localBundle.putLong("msg_sever_id", paramca.field_msgSvrId);
      localBundle.putString("send_msg_username", paramca.field_talker);
      paramca = ((l)g.af(l.class)).a(paramca.field_content, localBundle, new WeakReference(parama1.Pwc.getContext()), new WeakReference(parama.POM));
      if ((paramca != null) && (paramca.length() != 0)) {
        break label326;
      }
      parama.convertView.setVisibility(8);
      label162:
      paramca = v.bew().Pp(str);
      bg.aVF();
      paramInt = ((Integer)c.azQ().get(12311, Integer.valueOf(-2))).intValue();
      if (((paramca == null) || (paramca.jgE == -2)) && ((paramca != null) || (paramInt == -2))) {
        break label346;
      }
      parama.POM.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131100184));
      parama.POM.setBackground(parama1.Pwc.getContext().getResources().getDrawable(2131231647));
    }
    for (;;)
    {
      parama.POM.setOnClickListener(new bl.1(this));
      parama.POM.invalidate();
      AppMethodBeat.o(37550);
      return;
      if (parama1.gRM())
      {
        paramInt = 2;
        break;
      }
      if (ab.IT(str))
      {
        paramInt = 7;
        break;
      }
      paramInt = 1;
      break;
      label326:
      parama.convertView.setVisibility(0);
      parama.POM.aw(paramca);
      break label162;
      label346:
      parama.POM.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131099749));
      parama.POM.setBackground(parama1.Pwc.getContext().getResources().getDrawable(2131231646));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bl
 * JD-Core Version:    0.7.0.1
 */