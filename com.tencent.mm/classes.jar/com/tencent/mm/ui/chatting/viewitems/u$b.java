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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ap;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class u$b
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JWz;
  
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
      ((View)localObject).setTag(new u.a().gF((View)localObject));
    }
    AppMethodBeat.o(36992);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(36993);
    u.a locala = (u.a)parama;
    this.JWz = parama1;
    com.tencent.mm.ah.k localk = ao.fdU().yb(parambv.field_msgId);
    parama = parambv.field_content;
    if (parama1.fJC())
    {
      int i = parambv.field_content.indexOf(':');
      if (i != -1) {
        parama = parambv.field_content.substring(i + 1);
      }
    }
    for (;;)
    {
      if ((localk != null) && (parama != null))
      {
        parama = k.b.aB(parama, parambv.field_reserved);
        if (parama != null)
        {
          locala.KyM.setText(parama.title);
          parama = new bk(parambv, parama1.fJC(), paramInt, null, '\000');
          locala.olI.setTag(parama);
          locala.olI.setOnClickListener(d(parama1));
          if (this.oZq)
          {
            locala.olI.setOnLongClickListener(c(parama1));
            locala.olI.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
          }
        }
        if ((com.tencent.mm.bi.d.iuo != null) && (com.tencent.mm.bi.d.iuo.Hm(parama1.getTalkerUserName())))
        {
          locala.KyM.setTextColor(parama1.Kkd.getContext().getResources().getColor(2131100711));
          locala.KyN.setAlpha(1.0F);
          locala.olI.setClickable(true);
          locala.olI.setEnabled(true);
          AppMethodBeat.o(36993);
        }
      }
      else
      {
        if (localk == null) {}
        for (boolean bool = true;; bool = false)
        {
          ae.e("MicroMsg.ChattingItemAppMsgLocationShareFrom", "amessage:%b, %s, %s", new Object[] { Boolean.valueOf(bool), parama, Long.valueOf(parambv.field_msgId), paramString });
          parama = null;
          break;
        }
      }
      locala.KyM.setTextColor(parama1.Kkd.getContext().getResources().getColor(2131100249));
      locala.KyN.setAlpha(0.3F);
      locala.olI.setClickable(false);
      locala.olI.setEnabled(false);
      AppMethodBeat.o(36993);
      return;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(36995);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(36995);
      return false;
    }
    paramMenuItem = new Intent(parama.Kkd.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", bl.b(parama.fJC(), parambv.field_content, parambv.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", parambv.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgLocationShare$ChattingItemAppMsgLocationShareFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgLocationShare$ChattingItemAppMsgLocationShareFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(36995);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187774);
    int i = ((bk)paramView.getTag()).position;
    m.aNi(bl.b(this.JWz.fJC(), parambv.field_content, parambv.field_isSend));
    parambv = k.b.zb(bl.b(this.JWz.fJC(), parambv.field_content, parambv.field_isSend));
    com.tencent.mm.pluginsdk.model.app.g localg = h.m(parambv.appId, false, false);
    if ((com.tencent.mm.br.d.aJN("favorite")) && ((localg == null) || (!localg.Ee()))) {
      switch (parambv.type)
      {
      }
    }
    for (;;)
    {
      if (!this.JWz.fJD()) {
        paraml.a(i, 100, this.JWz.Kkd.getMMResources().getString(2131757221), 2131690384);
      }
      AppMethodBeat.o(187774);
      return true;
      paraml.a(i, 116, paramView.getContext().getString(2131761941), 2131690400);
    }
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(36996);
    if ((com.tencent.mm.r.a.ch(paramView.getContext())) || (com.tencent.mm.r.a.cf(paramView.getContext())) || (com.tencent.mm.r.a.cj(parama.Kkd.getContext())))
    {
      ae.d("MicroMsg.ChattingItemAppMsgLocationShareFrom", "voip is running, cann't start share location");
      AppMethodBeat.o(36996);
      return false;
    }
    ((b)com.tencent.mm.kernel.g.ab(b.class)).aaK(parambv.field_talker);
    paramView = (ap)parama.bh(ap.class);
    parama.getTalkerUserName();
    paramView.cV("fromMessage", true);
    AppMethodBeat.o(36996);
    return true;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == -1879048186);
  }
  
  public final boolean fLz()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.b
 * JD-Core Version:    0.7.0.1
 */