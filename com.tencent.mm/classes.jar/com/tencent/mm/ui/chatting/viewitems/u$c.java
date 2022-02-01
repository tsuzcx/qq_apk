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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ao;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class u$c
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JBI;
  
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
      ((View)localObject).setTag(new u.a().gA((View)localObject));
    }
    AppMethodBeat.o(36997);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(36998);
    paramString = (u.a)parama;
    this.JBI = parama1;
    parama = parambu.field_content;
    if (parama != null) {}
    for (parama = k.b.aA(parama, parambu.field_reserved);; parama = null)
    {
      if (parama != null)
      {
        parambu = new bk(parambu, parama1.fFv(), paramInt, null, '\000');
        paramString.ofK.setTag(parambu);
        paramString.ofK.setOnClickListener(d(parama1));
        if (this.oSO)
        {
          paramString.ofK.setOnLongClickListener(c(parama1));
          paramString.ofK.setOnTouchListener(((k)parama1.bh(k.class)).fCu());
        }
        paramString.Kcu.setText(parama.title);
      }
      if ((com.tencent.mm.bj.d.iru != null) && (com.tencent.mm.bj.d.iru.GK(parama1.getTalkerUserName())))
      {
        paramString.Kcu.setTextColor(parama1.JOR.getContext().getResources().getColor(2131100151));
        paramString.Kcv.setAlpha(1.0F);
        paramString.ofK.setClickable(true);
        paramString.ofK.setEnabled(true);
        AppMethodBeat.o(36998);
        return;
      }
      paramString.Kcu.setTextColor(parama1.JOR.getContext().getResources().getColor(2131100150));
      paramString.Kcv.setAlpha(0.3F);
      paramString.ofK.setClickable(false);
      paramString.ofK.setEnabled(false);
      AppMethodBeat.o(36998);
      return;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(37000);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37000);
      return false;
    }
    paramMenuItem = new Intent(parama.JOR.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", parambu.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgLocationShare$ChattingItemAppMsgLocationShareTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgLocationShare$ChattingItemAppMsgLocationShareTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37000);
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194380);
    int i = ((bk)paramView.getTag()).position;
    m.aLM(bj.b(this.JBI.fFv(), parambu.field_content, parambu.field_isSend));
    k.b localb = k.b.yr(bj.b(this.JBI.fFv(), parambu.field_content, parambu.field_isSend));
    com.tencent.mm.pluginsdk.model.app.g localg = h.m(localb.appId, false, false);
    if ((com.tencent.mm.bs.d.aIu("favorite")) && ((localg == null) || (!localg.Eb()))) {
      switch (localb.type)
      {
      }
    }
    for (;;)
    {
      if ((!parambu.fpd()) && (parambu.cTe()) && ((parambu.field_status == 2) || (parambu.fku == 1)) && (b(parambu, this.JBI)) && (aWy(parambu.field_talker))) {
        paraml.a(i, 123, paramView.getContext().getString(2131757234), 2131690462);
      }
      if (!this.JBI.fFw()) {
        paraml.a(i, 100, this.JBI.JOR.getMMResources().getString(2131757221), 2131690384);
      }
      AppMethodBeat.o(194380);
      return true;
      paraml.add(i, 116, 0, paramView.getContext().getString(2131761941));
    }
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(37001);
    ((b)com.tencent.mm.kernel.g.ab(b.class)).ZT(parambu.field_talker);
    paramView = (ao)parama.bh(ao.class);
    parama.getTalkerUserName();
    paramView.cR("fromMessage", true);
    AppMethodBeat.o(37001);
    return true;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == -1879048186);
  }
  
  public final boolean fHh()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.c
 * JD-Core Version:    0.7.0.1
 */