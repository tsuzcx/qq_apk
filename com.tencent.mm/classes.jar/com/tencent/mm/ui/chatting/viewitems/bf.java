package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bc.b;
import com.tencent.mm.bc.t;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.modelappbrand.l;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;

final class bf
  implements au.a
{
  public final void b(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu)
  {
    AppMethodBeat.i(37550);
    String str = parama1.getTalkerUserName();
    parama = (au.b)parama;
    Bundle localBundle = new Bundle();
    localBundle.putString("conv_talker_username", str);
    if ((parama1.JOR instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
    {
      paramInt = 10;
      localBundle.putInt("scene", paramInt);
      localBundle.putLong("msg_id", parambu.field_msgId);
      localBundle.putLong("msg_sever_id", parambu.field_msgSvrId);
      localBundle.putString("send_msg_username", parambu.field_talker);
      parambu = ((l)g.ab(l.class)).a(parambu.field_content, localBundle, new WeakReference(parama1.JOR.getContext()), new WeakReference(parama.KfL));
      if ((parambu != null) && (parambu.length() != 0)) {
        break label326;
      }
      parama.tPw.setVisibility(8);
      label162:
      parambu = t.aKa().Gb(str);
      ba.aBQ();
      paramInt = ((Integer)c.ajl().get(12311, Integer.valueOf(-2))).intValue();
      if (((parambu == null) || (parambu.iiM == -2)) && ((parambu != null) || (paramInt == -2))) {
        break label346;
      }
      parama.KfL.setTextColor(parama1.JOR.getContext().getResources().getColor(2131100151));
      parama.KfL.setBackground(parama1.JOR.getContext().getResources().getDrawable(2131231583));
    }
    for (;;)
    {
      parama.KfL.setOnClickListener(new bf.1(this));
      parama.KfL.invalidate();
      AppMethodBeat.o(37550);
      return;
      if (parama1.fFv())
      {
        paramInt = 2;
        break;
      }
      if (w.zE(str))
      {
        paramInt = 7;
        break;
      }
      paramInt = 1;
      break;
      label326:
      parama.tPw.setVisibility(0);
      parama.KfL.ar(parambu);
      break label162;
      label346:
      parama.KfL.setTextColor(parama1.JOR.getContext().getResources().getColor(2131099735));
      parama.KfL.setBackground(parama1.JOR.getContext().getResources().getDrawable(2131231582));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bf
 * JD-Core Version:    0.7.0.1
 */