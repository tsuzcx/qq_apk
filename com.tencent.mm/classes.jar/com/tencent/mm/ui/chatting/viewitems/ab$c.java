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
import com.tencent.mm.R.e;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.bk.d;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.at;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class ab$c
  extends c
{
  private com.tencent.mm.ui.chatting.e.a WBq;
  
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
      localObject = new aq(paramLayoutInflater, R.i.eeb);
      ((View)localObject).setTag(new ab.a().ih((View)localObject));
    }
    AppMethodBeat.o(36997);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(36998);
    paramString = (ab.a)parama;
    this.WBq = parama1;
    parama = paramca.field_content;
    if (parama != null) {}
    for (parama = k.b.aG(parama, paramca.field_reserved);; parama = null)
    {
      if (parama != null)
      {
        paramca = new by(paramca, parama1.hRi(), paramInt, null, '\000');
        paramString.clickArea.setTag(paramca);
        paramString.clickArea.setOnClickListener(d(parama1));
        if (this.tMW)
        {
          paramString.clickArea.setOnLongClickListener(c(parama1));
          paramString.clickArea.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
        }
        paramString.XgS.setText(parama.title);
      }
      if ((d.meV != null) && (d.meV.Xw(parama1.getTalkerUserName())))
      {
        paramString.XgS.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.chatting_to_text_color));
        paramString.XgT.setAlpha(1.0F);
        paramString.clickArea.setClickable(true);
        paramString.clickArea.setEnabled(true);
        AppMethodBeat.o(36998);
        return;
      }
      paramString.XgS.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.chatting_to_disable_text_color));
      paramString.XgT.setAlpha(0.3F);
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
    paramMenuItem = new Intent(parama.WQv.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", paramca.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgLocationShare$ChattingItemAppMsgLocationShareTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgLocationShare$ChattingItemAppMsgLocationShareTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37000);
    return false;
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(251074);
    int i = ((by)paramView.getTag()).position;
    m.bqe(bq.b(this.WBq.hRi(), paramca.field_content, paramca.field_isSend));
    k.b localb = k.b.OQ(bq.b(this.WBq.hRi(), paramca.field_content, paramca.field_isSend));
    g localg = com.tencent.mm.pluginsdk.model.app.h.o(localb.appId, false, false);
    if ((com.tencent.mm.by.c.blP("favorite")) && ((localg == null) || (!localg.Qv()))) {
      switch (localb.type)
      {
      }
    }
    for (;;)
    {
      if ((!paramca.hwA()) && (paramca.erm()) && ((paramca.field_status == 2) || (paramca.ill == 1)) && (b(paramca, this.WBq)) && (bzE(paramca.field_talker))) {
        paramo.a(i, 123, paramView.getContext().getString(R.l.ewa), R.k.icons_filled_previous);
      }
      if (!this.WBq.hRj()) {
        paramo.a(i, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
      }
      AppMethodBeat.o(251074);
      return true;
      paramo.add(i, 116, 0, paramView.getContext().getString(R.l.plugin_favorite_opt));
    }
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == -1879048186);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37001);
    ((b)com.tencent.mm.kernel.h.ae(b.class)).asK(paramca.field_talker);
    paramView = (at)parama.bC(at.class);
    parama.getTalkerUserName();
    paramView.dC("fromMessage", true);
    AppMethodBeat.o(37001);
    return true;
  }
  
  public final boolean hTD()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ab.c
 * JD-Core Version:    0.7.0.1
 */