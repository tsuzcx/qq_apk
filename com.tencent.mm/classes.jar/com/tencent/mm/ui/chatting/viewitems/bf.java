package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.b;
import com.tencent.mm.bb.t;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.x;
import com.tencent.mm.modelappbrand.l;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;

final class bf
  implements au.a
{
  public final void b(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv)
  {
    AppMethodBeat.i(37550);
    String str = parama1.getTalkerUserName();
    parama = (au.b)parama;
    Bundle localBundle = new Bundle();
    localBundle.putString("conv_talker_username", str);
    if ((parama1.Kkd instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
    {
      paramInt = 10;
      localBundle.putInt("scene", paramInt);
      localBundle.putLong("msg_id", parambv.field_msgId);
      localBundle.putLong("msg_sever_id", parambv.field_msgSvrId);
      localBundle.putString("send_msg_username", parambv.field_talker);
      parambv = ((l)g.ab(l.class)).a(parambv.field_content, localBundle, new WeakReference(parama1.Kkd.getContext()), new WeakReference(parama.KCe));
      if ((parambv != null) && (parambv.length() != 0)) {
        break label326;
      }
      parama.uan.setVisibility(8);
      label162:
      parambv = t.aKt().GD(str);
      bc.aCg();
      paramInt = ((Integer)c.ajA().get(12311, Integer.valueOf(-2))).intValue();
      if (((parambv == null) || (parambv.ilF == -2)) && ((parambv != null) || (paramInt == -2))) {
        break label346;
      }
      parama.KCe.setTextColor(parama1.Kkd.getContext().getResources().getColor(2131100151));
      parama.KCe.setBackground(parama1.Kkd.getContext().getResources().getDrawable(2131231583));
    }
    for (;;)
    {
      parama.KCe.setOnClickListener(new bf.1(this));
      parama.KCe.invalidate();
      AppMethodBeat.o(37550);
      return;
      if (parama1.fJC())
      {
        paramInt = 2;
        break;
      }
      if (x.Ao(str))
      {
        paramInt = 7;
        break;
      }
      paramInt = 1;
      break;
      label326:
      parama.uan.setVisibility(0);
      parama.KCe.aq(parambv);
      break label162;
      label346:
      parama.KCe.setTextColor(parama1.Kkd.getContext().getResources().getColor(2131099735));
      parama.KCe.setBackground(parama1.Kkd.getContext().getResources().getDrawable(2131231582));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bf
 * JD-Core Version:    0.7.0.1
 */