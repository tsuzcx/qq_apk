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
import com.tencent.mm.g.c.du;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.ak;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class t$c
  extends c
{
  private com.tencent.mm.ui.chatting.d.a Gob;
  
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
      localObject = new af(paramLayoutInflater, 2131493487);
      ((View)localObject).setTag(new t.a().fW((View)localObject));
    }
    AppMethodBeat.o(36997);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(36998);
    paramString = (t.a)parama;
    this.Gob = parama1;
    parama = parambl.field_content;
    if (parama != null) {}
    for (parama = k.b.ar(parama, parambl.field_reserved);; parama = null)
    {
      if (parama != null)
      {
        parambl = new bi(parambl, parama1.eZb(), paramInt, null, '\000');
        paramString.naN.setTag(parambl);
        paramString.naN.setOnClickListener(d(parama1));
        if (this.nMt)
        {
          paramString.naN.setOnLongClickListener(c(parama1));
          paramString.naN.setOnTouchListener(((i)parama1.be(i.class)).eWp());
        }
        paramString.GLX.setText(parama.title);
      }
      if ((com.tencent.mm.bj.d.hxx != null) && (com.tencent.mm.bj.d.hxx.zA(parama1.getTalkerUserName())))
      {
        paramString.GLX.setTextColor(parama1.GzJ.getContext().getResources().getColor(2131100151));
        paramString.GLY.setAlpha(255);
        paramString.naN.setClickable(true);
        paramString.naN.setEnabled(true);
        AppMethodBeat.o(36998);
        return;
      }
      paramString.GLX.setTextColor(parama1.GzJ.getContext().getResources().getColor(2131100150));
      paramString.GLY.setAlpha(77);
      paramString.naN.setClickable(false);
      paramString.naN.setEnabled(false);
      AppMethodBeat.o(36998);
      return;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(36999);
    int i = ((bi)paramView.getTag()).position;
    m.aAU(com.tencent.mm.model.bi.b(this.Gob.eZb(), parambl.field_content, parambl.field_isSend));
    k.b localb = k.b.rx(com.tencent.mm.model.bi.b(this.Gob.eZb(), parambl.field_content, parambl.field_isSend));
    com.tencent.mm.pluginsdk.model.app.g localg = h.j(localb.appId, false, false);
    if ((com.tencent.mm.bs.d.axB("favorite")) && ((localg == null) || (!localg.CZ()))) {
      switch (localb.type)
      {
      }
    }
    for (;;)
    {
      if ((!parambl.eJL()) && (parambl.cxD()) && ((parambl.field_status == 2) || (parambl.eOX == 1)) && (b(parambl, this.Gob)) && (aKZ(parambl.field_talker))) {
        paramContextMenu.add(i, 123, 0, paramView.getContext().getString(2131757234));
      }
      if (!this.Gob.eZc()) {
        paramContextMenu.add(i, 100, 0, this.Gob.GzJ.getMMResources().getString(2131757221));
      }
      AppMethodBeat.o(36999);
      return true;
      paramContextMenu.add(i, 116, 0, paramView.getContext().getString(2131761941));
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(37000);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37000);
      return false;
    }
    paramMenuItem = new Intent(parama.GzJ.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", com.tencent.mm.model.bi.b(parama.eZb(), parambl.field_content, parambl.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", parambl.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bd(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgLocationShare$ChattingItemAppMsgLocationShareTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgLocationShare$ChattingItemAppMsgLocationShareTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37000);
    return false;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == -1879048186);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(37001);
    ((b)com.tencent.mm.kernel.g.ab(b.class)).Sa(parambl.field_talker);
    paramView = (ak)parama.be(ak.class);
    parama.getTalkerUserName();
    paramView.cG("fromMessage", true);
    AppMethodBeat.o(37001);
    return true;
  }
  
  public final boolean faE()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.t.c
 * JD-Core Version:    0.7.0.1
 */