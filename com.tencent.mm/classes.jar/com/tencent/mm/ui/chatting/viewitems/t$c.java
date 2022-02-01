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
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.bi;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.ak;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class t$c
  extends c
{
  private com.tencent.mm.ui.chatting.d.a HNS;
  
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
      localObject = new ag(paramLayoutInflater, 2131493487);
      ((View)localObject).setTag(new t.a().gj((View)localObject));
    }
    AppMethodBeat.o(36997);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(36998);
    paramString = (t.a)parama;
    this.HNS = parama1;
    parama = parambo.field_content;
    if (parama != null) {}
    for (parama = k.b.az(parama, parambo.field_reserved);; parama = null)
    {
      if (parama != null)
      {
        parambo = new bj(parambo, parama1.foQ(), paramInt, null, '\000');
        paramString.nDl.setTag(parambo);
        paramString.nDl.setOnClickListener(d(parama1));
        if (this.opt)
        {
          paramString.nDl.setOnLongClickListener(c(parama1));
          paramString.nDl.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
        }
        paramString.IlU.setText(parama.title);
      }
      if ((com.tencent.mm.bi.d.hXY != null) && (com.tencent.mm.bi.d.hXY.DF(parama1.getTalkerUserName())))
      {
        paramString.IlU.setTextColor(parama1.HZF.getContext().getResources().getColor(2131100151));
        paramString.IlV.setAlpha(255);
        paramString.nDl.setClickable(true);
        paramString.nDl.setEnabled(true);
        AppMethodBeat.o(36998);
        return;
      }
      paramString.IlU.setTextColor(parama1.HZF.getContext().getResources().getColor(2131100150));
      paramString.IlV.setAlpha(77);
      paramString.nDl.setClickable(false);
      paramString.nDl.setEnabled(false);
      AppMethodBeat.o(36998);
      return;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(36999);
    int i = ((bj)paramView.getTag()).position;
    m.aGm(bi.b(this.HNS.foQ(), parambo.field_content, parambo.field_isSend));
    k.b localb = k.b.vA(bi.b(this.HNS.foQ(), parambo.field_content, parambo.field_isSend));
    com.tencent.mm.pluginsdk.model.app.g localg = h.k(localb.appId, false, false);
    if ((com.tencent.mm.br.d.aCT("favorite")) && ((localg == null) || (!localg.CC()))) {
      switch (localb.type)
      {
      }
    }
    for (;;)
    {
      if ((!parambo.eZj()) && (parambo.cKP()) && ((parambo.field_status == 2) || (parambo.eSf == 1)) && (b(parambo, this.HNS)) && (aQE(parambo.field_talker))) {
        paramContextMenu.add(i, 123, 0, paramView.getContext().getString(2131757234));
      }
      if (!this.HNS.foR()) {
        paramContextMenu.add(i, 100, 0, this.HNS.HZF.getMMResources().getString(2131757221));
      }
      AppMethodBeat.o(36999);
      return true;
      paramContextMenu.add(i, 116, 0, paramView.getContext().getString(2131761941));
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37000);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37000);
      return false;
    }
    paramMenuItem = new Intent(parama.HZF.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", parambo.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().ba(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgLocationShare$ChattingItemAppMsgLocationShareTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgLocationShare$ChattingItemAppMsgLocationShareTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37000);
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37001);
    ((b)com.tencent.mm.kernel.g.ab(b.class)).Wm(parambo.field_talker);
    paramView = (ak)parama.bf(ak.class);
    parama.getTalkerUserName();
    paramView.cM("fromMessage", true);
    AppMethodBeat.o(37001);
    return true;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == -1879048186);
  }
  
  public final boolean fqu()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.t.c
 * JD-Core Version:    0.7.0.1
 */