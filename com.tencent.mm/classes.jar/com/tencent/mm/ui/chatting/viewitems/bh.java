package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.be.b;
import com.tencent.mm.be.w;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;

final class bh
  implements bf.a
{
  public final void b(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca)
  {
    AppMethodBeat.i(37381);
    String str = parama1.getTalkerUserName();
    parama = (bf.b)parama;
    Bundle localBundle = new Bundle();
    localBundle.putString("conv_talker_username", str);
    if ((parama1.WQv instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
    {
      paramInt = 10;
      localBundle.putInt("scene", paramInt);
      localBundle.putLong("msg_id", paramca.field_msgId);
      localBundle.putLong("msg_sever_id", paramca.field_msgSvrId);
      localBundle.putString("send_msg_username", paramca.field_talker);
      localBundle.putString("local_session", parama1.WQA);
      paramca = ((e)h.ae(e.class)).b(paramca.field_content, localBundle, new WeakReference(parama1.WQv.getContext()), new WeakReference(parama.XkO));
      if ((paramca != null) && (paramca.length() != 0)) {
        break label339;
      }
      parama.convertView.setVisibility(8);
      label173:
      paramca = w.bnV().WM(str);
      com.tencent.mm.model.bh.beI();
      paramInt = ((Integer)c.aHp().b(12311, Integer.valueOf(-2))).intValue();
      if (((paramca == null) || (paramca.lXh == -2)) && ((paramca != null) || (paramInt == -2))) {
        break label359;
      }
      parama.XkO.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.chatting_to_text_color));
      parama.XkO.setBackground(parama1.WQv.getContext().getResources().getDrawable(R.g.chat_tips_light_bg));
    }
    for (;;)
    {
      parama.XkO.setOnClickListener(new bh.1(this));
      parama.XkO.invalidate();
      AppMethodBeat.o(37381);
      return;
      if (parama1.hRi())
      {
        paramInt = 2;
        break;
      }
      if (ab.Qm(str))
      {
        paramInt = 7;
        break;
      }
      paramInt = 1;
      break;
      label339:
      parama.convertView.setVisibility(0);
      parama.XkO.aL(paramca);
      break label173;
      label359:
      parama.XkO.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.FG_2));
      parama.XkO.setBackground(parama1.WQv.getContext().getResources().getDrawable(R.g.chat_tips_bg));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bh
 * JD-Core Version:    0.7.0.1
 */