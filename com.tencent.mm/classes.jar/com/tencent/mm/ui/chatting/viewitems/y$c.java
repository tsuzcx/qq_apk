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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.bi.d;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.as;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class y$c
  extends c
{
  private com.tencent.mm.ui.chatting.e.a PhN;
  
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
      localObject = new an(paramLayoutInflater, 2131493594);
      ((View)localObject).setTag(new y.a().gV((View)localObject));
    }
    AppMethodBeat.o(36997);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(36998);
    paramString = (y.a)parama;
    this.PhN = parama1;
    parama = paramca.field_content;
    if (parama != null) {}
    for (parama = k.b.aD(parama, paramca.field_reserved);; parama = null)
    {
      if (parama != null)
      {
        paramca = new bq(paramca, parama1.gRM(), paramInt, null, '\000');
        paramString.clickArea.setTag(paramca);
        paramString.clickArea.setOnClickListener(d(parama1));
        if (this.qoo)
        {
          paramString.clickArea.setOnLongClickListener(c(parama1));
          paramString.clickArea.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
        }
        paramString.PKZ.setText(parama.title);
      }
      if ((d.jpA != null) && (d.jpA.PZ(parama1.getTalkerUserName())))
      {
        paramString.PKZ.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131100184));
        paramString.PLa.setAlpha(1.0F);
        paramString.clickArea.setClickable(true);
        paramString.clickArea.setEnabled(true);
        AppMethodBeat.o(36998);
        return;
      }
      paramString.PKZ.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131100183));
      paramString.PLa.setAlpha(0.3F);
      paramString.clickArea.setClickable(false);
      paramString.clickArea.setEnabled(false);
      AppMethodBeat.o(36998);
      return;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37000);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37000);
      return false;
    }
    paramMenuItem = new Intent(parama.Pwc.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", paramca.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgLocationShare$ChattingItemAppMsgLocationShareTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgLocationShare$ChattingItemAppMsgLocationShareTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37000);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233733);
    int i = ((bq)paramView.getTag()).position;
    com.tencent.mm.pluginsdk.model.app.m.bdI(bp.b(this.PhN.gRM(), paramca.field_content, paramca.field_isSend));
    k.b localb = k.b.HD(bp.b(this.PhN.gRM(), paramca.field_content, paramca.field_isSend));
    com.tencent.mm.pluginsdk.model.app.g localg = h.o(localb.appId, false, false);
    if ((com.tencent.mm.br.c.aZU("favorite")) && ((localg == null) || (!localg.NA()))) {
      switch (localb.type)
      {
      }
    }
    for (;;)
    {
      if ((!paramca.gAt()) && (paramca.dOS()) && ((paramca.field_status == 2) || (paramca.fQV == 1)) && (b(paramca, this.PhN)) && (bnf(paramca.field_talker))) {
        paramm.a(i, 123, paramView.getContext().getString(2131757446), 2131690650);
      }
      if (!this.PhN.gRN()) {
        paramm.a(i, 100, this.PhN.Pwc.getMMResources().getString(2131757433), 2131690529);
      }
      AppMethodBeat.o(233733);
      return true;
      paramm.add(i, 116, 0, paramView.getContext().getString(2131763947));
    }
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == -1879048186);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37001);
    ((b)com.tencent.mm.kernel.g.af(b.class)).akR(paramca.field_talker);
    paramView = (as)parama.bh(as.class);
    parama.getTalkerUserName();
    paramView.dq("fromMessage", true);
    AppMethodBeat.o(37001);
    return true;
  }
  
  public final boolean gTT()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.y.c
 * JD-Core Version:    0.7.0.1
 */