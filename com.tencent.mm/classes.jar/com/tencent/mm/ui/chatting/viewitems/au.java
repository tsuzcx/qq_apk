package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bc.b;
import com.tencent.mm.bc.t;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;

final class au
  implements as.a
{
  public final void b(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl)
  {
    AppMethodBeat.i(37381);
    String str = parama1.getTalkerUserName();
    parama = (as.b)parama;
    Bundle localBundle = new Bundle();
    localBundle.putString("conv_talker_username", str);
    if ((parama1.GzJ instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
    {
      paramInt = 10;
      localBundle.putInt("scene", paramInt);
      localBundle.putLong("msg_id", parambl.field_msgId);
      localBundle.putLong("msg_sever_id", parambl.field_msgSvrId);
      localBundle.putString("send_msg_username", parambl.field_talker);
      localBundle.putString("local_session", parama1.GzM);
      parambl = ((f)g.ab(f.class)).b(parambl.field_content, localBundle, new WeakReference(parama1.GzJ.getContext()), new WeakReference(parama.GPj));
      if ((parambl != null) && (parambl.length() != 0)) {
        break label337;
      }
      parama.rLd.setVisibility(8);
      label173:
      parambl = t.azZ().yR(str);
      az.arV();
      paramInt = ((Integer)c.afk().get(12311, Integer.valueOf(-2))).intValue();
      if (((parambl == null) || (parambl.hoW == -2)) && ((parambl != null) || (paramInt == -2))) {
        break label357;
      }
      parama.GPj.setTextColor(parama1.GzJ.getContext().getResources().getColor(2131100151));
      parama.GPj.setBackground(parama1.GzJ.getContext().getResources().getDrawable(2131231583));
    }
    for (;;)
    {
      parama.GPj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37380);
          ad.d("MicroMsg.ChattingItemNewXmlSysImpl", "hy: textview clicked");
          AppMethodBeat.o(37380);
        }
      });
      parama.GPj.invalidate();
      AppMethodBeat.o(37381);
      return;
      if (parama1.eZb())
      {
        paramInt = 2;
        break;
      }
      if (w.sE(str))
      {
        paramInt = 7;
        break;
      }
      paramInt = 1;
      break;
      label337:
      parama.rLd.setVisibility(0);
      parama.GPj.aq(parambl);
      break label173;
      label357:
      parama.GPj.setTextColor(ao.aD(parama1.GzJ.getContext(), 2130968586));
      parama.GPj.setBackground(parama1.GzJ.getContext().getResources().getDrawable(2131231582));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.au
 * JD-Core Version:    0.7.0.1
 */