package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.b;
import com.tencent.mm.bb.t;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.modelappbrand.l;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;

final class be
  implements at.a
{
  public final void b(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo)
  {
    AppMethodBeat.i(37550);
    String str = parama1.getTalkerUserName();
    parama = (at.b)parama;
    Bundle localBundle = new Bundle();
    localBundle.putString("conv_talker_username", str);
    if ((parama1.HZF instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
    {
      paramInt = 10;
      localBundle.putInt("scene", paramInt);
      localBundle.putLong("msg_id", parambo.field_msgId);
      localBundle.putLong("msg_sever_id", parambo.field_msgSvrId);
      localBundle.putString("send_msg_username", parambo.field_talker);
      parambo = ((l)g.ab(l.class)).a(parambo.field_content, localBundle, new WeakReference(parama1.HZF.getContext()), new WeakReference(parama.Ipl));
      if ((parambo != null) && (parambo.length() != 0)) {
        break label326;
      }
      parama.sSS.setVisibility(8);
      label162:
      parambo = t.aGP().CW(str);
      az.ayM();
      paramInt = ((Integer)c.agA().get(12311, Integer.valueOf(-2))).intValue();
      if (((parambo == null) || (parambo.hPy == -2)) && ((parambo != null) || (paramInt == -2))) {
        break label346;
      }
      parama.Ipl.setTextColor(parama1.HZF.getContext().getResources().getColor(2131100151));
      parama.Ipl.setBackground(parama1.HZF.getContext().getResources().getDrawable(2131231583));
    }
    for (;;)
    {
      parama.Ipl.setOnClickListener(new be.1(this));
      parama.Ipl.invalidate();
      AppMethodBeat.o(37550);
      return;
      if (parama1.foQ())
      {
        paramInt = 2;
        break;
      }
      if (w.wH(str))
      {
        paramInt = 7;
        break;
      }
      paramInt = 1;
      break;
      label326:
      parama.sSS.setVisibility(0);
      parama.Ipl.ar(parambo);
      break label162;
      label346:
      parama.Ipl.setTextColor(ao.aJ(parama1.HZF.getContext(), 2130968586));
      parama.Ipl.setBackground(parama1.HZF.getContext().getResources().getDrawable(2131231582));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.be
 * JD-Core Version:    0.7.0.1
 */