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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.bi.d;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.as;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class y$b
  extends c
{
  private com.tencent.mm.ui.chatting.e.a PhN;
  
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
      localObject = new an(paramLayoutInflater, 2131493543);
      ((View)localObject).setTag(new y.a().gV((View)localObject));
    }
    AppMethodBeat.o(36992);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(36993);
    y.a locala = (y.a)parama;
    this.PhN = parama1;
    com.tencent.mm.ag.k localk = ao.gnf().GL(paramca.field_msgId);
    parama = paramca.field_content;
    if (parama1.gRM())
    {
      int i = paramca.field_content.indexOf(':');
      if (i != -1) {
        parama = paramca.field_content.substring(i + 1);
      }
    }
    for (;;)
    {
      if ((localk != null) && (parama != null))
      {
        parama = k.b.aD(parama, paramca.field_reserved);
        if (parama != null)
        {
          locala.PKZ.setText(parama.title);
          parama = new bq(paramca, parama1.gRM(), paramInt, null, '\000');
          locala.clickArea.setTag(parama);
          locala.clickArea.setOnClickListener(d(parama1));
          if (this.qoo)
          {
            locala.clickArea.setOnLongClickListener(c(parama1));
            locala.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
          }
        }
        if ((d.jpA != null) && (d.jpA.PZ(parama1.getTalkerUserName())))
        {
          locala.PKZ.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131100904));
          locala.PLa.setAlpha(1.0F);
          locala.clickArea.setClickable(true);
          locala.clickArea.setEnabled(true);
          AppMethodBeat.o(36993);
        }
      }
      else
      {
        if (localk == null) {}
        for (boolean bool = true;; bool = false)
        {
          Log.e("MicroMsg.ChattingItemAppMsgLocationShareFrom", "amessage:%b, %s, %s", new Object[] { Boolean.valueOf(bool), parama, Long.valueOf(paramca.field_msgId), paramString });
          parama = null;
          break;
        }
      }
      locala.PKZ.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131100283));
      locala.PLa.setAlpha(0.3F);
      locala.clickArea.setClickable(false);
      locala.clickArea.setEnabled(false);
      AppMethodBeat.o(36993);
      return;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(36995);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(36995);
      return false;
    }
    paramMenuItem = new Intent(parama.Pwc.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", paramca.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgLocationShare$ChattingItemAppMsgLocationShareFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgLocationShare$ChattingItemAppMsgLocationShareFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(36995);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233732);
    int i = ((bq)paramView.getTag()).position;
    com.tencent.mm.pluginsdk.model.app.m.bdI(bp.b(this.PhN.gRM(), paramca.field_content, paramca.field_isSend));
    paramca = k.b.HD(bp.b(this.PhN.gRM(), paramca.field_content, paramca.field_isSend));
    com.tencent.mm.pluginsdk.model.app.g localg = h.o(paramca.appId, false, false);
    if ((com.tencent.mm.br.c.aZU("favorite")) && ((localg == null) || (!localg.NA()))) {
      switch (paramca.type)
      {
      }
    }
    for (;;)
    {
      if (!this.PhN.gRN()) {
        paramm.a(i, 100, this.PhN.Pwc.getMMResources().getString(2131757433), 2131690529);
      }
      AppMethodBeat.o(233732);
      return true;
      paramm.a(i, 116, paramView.getContext().getString(2131763947), 2131690551);
    }
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == -1879048186);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(36996);
    if ((com.tencent.mm.q.a.cC(paramView.getContext())) || (com.tencent.mm.q.a.cA(paramView.getContext())) || (com.tencent.mm.q.a.cE(parama.Pwc.getContext())))
    {
      Log.d("MicroMsg.ChattingItemAppMsgLocationShareFrom", "voip is running, cann't start share location");
      AppMethodBeat.o(36996);
      return false;
    }
    ((b)com.tencent.mm.kernel.g.af(b.class)).akR(paramca.field_talker);
    paramView = (as)parama.bh(as.class);
    parama.getTalkerUserName();
    paramView.dq("fromMessage", true);
    AppMethodBeat.o(36996);
    return true;
  }
  
  public final boolean gTT()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.y.b
 * JD-Core Version:    0.7.0.1
 */