package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.b;
import com.tencent.mm.ba.r;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.modelappbrand.j;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;

final class au
  implements aj.a
{
  public final void b(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi)
  {
    AppMethodBeat.i(33440);
    String str = parama1.getTalkerUserName();
    parama = (aj.b)parama;
    Bundle localBundle = new Bundle();
    localBundle.putString("conv_talker_username", str);
    if ((parama1.zJz instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
    {
      paramInt = 10;
      localBundle.putInt("scene", paramInt);
      localBundle.putLong("msg_id", parambi.field_msgId);
      localBundle.putLong("msg_sever_id", parambi.field_msgSvrId);
      localBundle.putString("send_msg_username", parambi.field_talker);
      parambi = ((j)g.E(j.class)).a(parambi.field_content, localBundle, new WeakReference(parama1.zJz.getContext()), new WeakReference(parama.zWS));
      if ((parambi != null) && (parambi.length() != 0)) {
        break label326;
      }
      parama.ngZ.setVisibility(8);
      label162:
      parambi = r.aiQ().tS(str);
      aw.aaz();
      paramInt = ((Integer)c.Ru().get(12311, Integer.valueOf(-2))).intValue();
      if (((parambi == null) || (parambi.fMk == -2)) && ((parambi != null) || (paramInt == -2))) {
        break label346;
      }
      parama.zWS.setTextColor(parama1.zJz.getContext().getResources().getColor(2131689766));
      parama.zWS.setBackground(parama1.zJz.getContext().getResources().getDrawable(2130838246));
    }
    for (;;)
    {
      parama.zWS.setOnClickListener(new au.1(this));
      parama.zWS.invalidate();
      AppMethodBeat.o(33440);
      return;
      if (parama1.dJG())
      {
        paramInt = 2;
        break;
      }
      if (t.nU(str))
      {
        paramInt = 7;
        break;
      }
      paramInt = 1;
      break;
      label326:
      parama.ngZ.setVisibility(0);
      parama.zWS.af(parambi);
      break label162;
      label346:
      parama.zWS.setTextColor(parama1.zJz.getContext().getResources().getColor(2131690564));
      parama.zWS.setBackground(parama1.zJz.getContext().getResources().getDrawable(2130838245));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.au
 * JD-Core Version:    0.7.0.1
 */