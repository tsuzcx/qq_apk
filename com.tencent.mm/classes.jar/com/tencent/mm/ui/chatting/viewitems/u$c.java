package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
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
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ap;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class u$c
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JWz;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(36997);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ah(paramLayoutInflater, 2131493487);
      ((View)localObject).setTag(new u.a().gF((View)localObject));
    }
    AppMethodBeat.o(36997);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(36998);
    paramString = (u.a)parama;
    this.JWz = parama1;
    parama = parambv.field_content;
    if (parama != null) {}
    for (parama = k.b.aB(parama, parambv.field_reserved);; parama = null)
    {
      if (parama != null)
      {
        parambv = new bk(parambv, parama1.fJC(), paramInt, null, '\000');
        paramString.olI.setTag(parambv);
        paramString.olI.setOnClickListener(d(parama1));
        if (this.oZq)
        {
          paramString.olI.setOnLongClickListener(c(parama1));
          paramString.olI.setOnTouchListener(((k)parama1.bh(k.class)).fGw());
        }
        paramString.KyM.setText(parama.title);
      }
      if ((com.tencent.mm.bi.d.iuo != null) && (com.tencent.mm.bi.d.iuo.Hm(parama1.getTalkerUserName())))
      {
        paramString.KyM.setTextColor(parama1.Kkd.getContext().getResources().getColor(2131100151));
        paramString.KyN.setAlpha(1.0F);
        paramString.olI.setClickable(true);
        paramString.olI.setEnabled(true);
        AppMethodBeat.o(36998);
        return;
      }
      paramString.KyM.setTextColor(parama1.Kkd.getContext().getResources().getColor(2131100150));
      paramString.KyN.setAlpha(0.3F);
      paramString.olI.setClickable(false);
      paramString.olI.setEnabled(false);
      AppMethodBeat.o(36998);
      return;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37000);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37000);
      return false;
    }
    paramMenuItem = new Intent(parama.Kkd.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", bl.b(parama.fJC(), parambv.field_content, parambv.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", parambv.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgLocationShare$ChattingItemAppMsgLocationShareTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgLocationShare$ChattingItemAppMsgLocationShareTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37000);
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187775);
    int i = ((bk)paramView.getTag()).position;
    m.aNi(bl.b(this.JWz.fJC(), parambv.field_content, parambv.field_isSend));
    k.b localb = k.b.zb(bl.b(this.JWz.fJC(), parambv.field_content, parambv.field_isSend));
    com.tencent.mm.pluginsdk.model.app.g localg = h.m(localb.appId, false, false);
    if ((com.tencent.mm.br.d.aJN("favorite")) && ((localg == null) || (!localg.Ee()))) {
      switch (localb.type)
      {
      }
    }
    for (;;)
    {
      if ((!parambv.fta()) && (parambv.cVJ()) && ((parambv.field_status == 2) || (parambv.fmr == 1)) && (b(parambv, this.JWz)) && (aYa(parambv.field_talker))) {
        paraml.a(i, 123, paramView.getContext().getString(2131757234), 2131690462);
      }
      if (!this.JWz.fJD()) {
        paraml.a(i, 100, this.JWz.Kkd.getMMResources().getString(2131757221), 2131690384);
      }
      AppMethodBeat.o(187775);
      return true;
      paraml.add(i, 116, 0, paramView.getContext().getString(2131761941));
    }
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37001);
    ((b)com.tencent.mm.kernel.g.ab(b.class)).aaK(parambv.field_talker);
    paramView = (ap)parama.bh(ap.class);
    parama.getTalkerUserName();
    paramView.cV("fromMessage", true);
    AppMethodBeat.o(37001);
    return true;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == -1879048186);
  }
  
  public final boolean fLz()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.c
 * JD-Core Version:    0.7.0.1
 */