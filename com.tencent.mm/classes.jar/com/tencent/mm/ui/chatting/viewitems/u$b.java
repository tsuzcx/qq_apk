package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class u$b
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JBI;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(36992);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ah(paramLayoutInflater, 2131493443);
      ((View)localObject).setTag(new u.a().gA((View)localObject));
    }
    AppMethodBeat.o(36992);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(36993);
    u.a locala = (u.a)parama;
    this.JBI = parama1;
    com.tencent.mm.ai.k localk = com.tencent.mm.pluginsdk.model.app.ao.fag().xH(parambu.field_msgId);
    parama = parambu.field_content;
    if (parama1.fFv())
    {
      int i = parambu.field_content.indexOf(':');
      if (i != -1) {
        parama = parambu.field_content.substring(i + 1);
      }
    }
    for (;;)
    {
      if ((localk != null) && (parama != null))
      {
        parama = k.b.aA(parama, parambu.field_reserved);
        if (parama != null)
        {
          locala.Kcu.setText(parama.title);
          parama = new bk(parambu, parama1.fFv(), paramInt, null, '\000');
          locala.ofK.setTag(parama);
          locala.ofK.setOnClickListener(d(parama1));
          if (this.oSO)
          {
            locala.ofK.setOnLongClickListener(c(parama1));
            locala.ofK.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
          }
        }
        if ((com.tencent.mm.bj.d.iru != null) && (com.tencent.mm.bj.d.iru.GK(parama1.getTalkerUserName())))
        {
          locala.Kcu.setTextColor(parama1.JOR.getContext().getResources().getColor(2131100711));
          locala.Kcv.setAlpha(1.0F);
          locala.ofK.setClickable(true);
          locala.ofK.setEnabled(true);
          AppMethodBeat.o(36993);
        }
      }
      else
      {
        if (localk == null) {}
        for (boolean bool = true;; bool = false)
        {
          ad.e("MicroMsg.ChattingItemAppMsgLocationShareFrom", "amessage:%b, %s, %s", new Object[] { Boolean.valueOf(bool), parama, Long.valueOf(parambu.field_msgId), paramString });
          parama = null;
          break;
        }
      }
      locala.Kcu.setTextColor(parama1.JOR.getContext().getResources().getColor(2131100249));
      locala.Kcv.setAlpha(0.3F);
      locala.ofK.setClickable(false);
      locala.ofK.setEnabled(false);
      AppMethodBeat.o(36993);
      return;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(36995);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(36995);
      return false;
    }
    paramMenuItem = new Intent(parama.JOR.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", parambu.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgLocationShare$ChattingItemAppMsgLocationShareFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgLocationShare$ChattingItemAppMsgLocationShareFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(36995);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194379);
    int i = ((bk)paramView.getTag()).position;
    m.aLM(bj.b(this.JBI.fFv(), parambu.field_content, parambu.field_isSend));
    parambu = k.b.yr(bj.b(this.JBI.fFv(), parambu.field_content, parambu.field_isSend));
    com.tencent.mm.pluginsdk.model.app.g localg = h.m(parambu.appId, false, false);
    if ((com.tencent.mm.bs.d.aIu("favorite")) && ((localg == null) || (!localg.Eb()))) {
      switch (parambu.type)
      {
      }
    }
    for (;;)
    {
      if (!this.JBI.fFw()) {
        paraml.a(i, 100, this.JBI.JOR.getMMResources().getString(2131757221), 2131690384);
      }
      AppMethodBeat.o(194379);
      return true;
      paraml.a(i, 116, paramView.getContext().getString(2131761941), 2131690400);
    }
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(36996);
    if ((com.tencent.mm.s.a.cf(paramView.getContext())) || (com.tencent.mm.s.a.cd(paramView.getContext())) || (com.tencent.mm.s.a.ch(parama.JOR.getContext())))
    {
      ad.d("MicroMsg.ChattingItemAppMsgLocationShareFrom", "voip is running, cann't start share location");
      AppMethodBeat.o(36996);
      return false;
    }
    ((b)com.tencent.mm.kernel.g.ab(b.class)).ZT(parambu.field_talker);
    paramView = (com.tencent.mm.ui.chatting.d.b.ao)parama.bh(com.tencent.mm.ui.chatting.d.b.ao.class);
    parama.getTalkerUserName();
    paramView.cR("fromMessage", true);
    AppMethodBeat.o(36996);
    return true;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == -1879048186);
  }
  
  public final boolean fHh()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.b
 * JD-Core Version:    0.7.0.1
 */