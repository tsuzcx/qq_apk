package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.az.b;
import com.tencent.mm.az.r;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.modelappbrand.j;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a;
import com.tencent.mm.ui.chatting.e;
import java.lang.ref.WeakReference;

final class ar
  implements ag.a
{
  public final void b(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi)
  {
    String str = parama1.getTalkerUserName();
    parama = (ag.b)parama;
    Bundle localBundle = new Bundle();
    localBundle.putString("conv_talker_username", str);
    if ((parama1.vtz instanceof AppBrandServiceChattingUI.a))
    {
      paramInt = 10;
      localBundle.putInt("scene", paramInt);
      localBundle.putLong("msg_id", parambi.field_msgId);
      localBundle.putLong("msg_sever_id", parambi.field_msgSvrId);
      localBundle.putString("send_msg_username", parambi.field_talker);
      parambi = ((j)g.r(j.class)).a(parambi.field_content, localBundle, new WeakReference(parama1.vtz.getContext()), new WeakReference(parama.vEC));
      if ((parambi != null) && (parambi.length() != 0)) {
        break label318;
      }
      parama.kKz.setVisibility(8);
      label157:
      parambi = r.PL().mI(str);
      au.Hx();
      paramInt = ((Integer)c.Dz().get(12311, Integer.valueOf(-2))).intValue();
      if (((parambi == null) || (parambi.ewu == -2)) && ((parambi != null) || (paramInt == -2))) {
        break label348;
      }
      parama.vEC.setTextColor(parama1.vtz.getContext().getResources().getColor(R.e.black_text_color));
      parama.vEC.setBackground(parama1.vtz.getContext().getResources().getDrawable(R.g.chat_tips_light_bg));
    }
    for (;;)
    {
      parama.vEC.setOnClickListener(new ar.1(this));
      parama.vEC.invalidate();
      return;
      if (parama1.cFE())
      {
        paramInt = 2;
        break;
      }
      if (s.hl(str))
      {
        paramInt = 7;
        break;
      }
      paramInt = 1;
      break;
      label318:
      parama.kKz.setVisibility(0);
      parama.vEC.setText(parambi);
      parama.vEC.setMovementMethod(ba.getInstance());
      break label157;
      label348:
      parama.vEC.setTextColor(parama1.vtz.getContext().getResources().getColor(R.e.white_text_color));
      parama.vEC.setBackground(parama1.vtz.getContext().getResources().getDrawable(R.g.chat_tips_bg));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ar
 * JD-Core Version:    0.7.0.1
 */