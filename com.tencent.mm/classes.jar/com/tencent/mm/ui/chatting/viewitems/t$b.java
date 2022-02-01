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
import com.tencent.mm.ai.k;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.ak;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class t$b
  extends c
{
  private com.tencent.mm.ui.chatting.d.a Gob;
  
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
      localObject = new af(paramLayoutInflater, 2131493443);
      ((View)localObject).setTag(new t.a().fW((View)localObject));
    }
    AppMethodBeat.o(36992);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(36993);
    t.a locala = (t.a)parama;
    this.Gob = parama1;
    k localk = ap.evR().vk(parambl.field_msgId);
    parama = parambl.field_content;
    if (parama1.eZb())
    {
      int i = parambl.field_content.indexOf(':');
      if (i != -1) {
        parama = parambl.field_content.substring(i + 1);
      }
    }
    for (;;)
    {
      if ((localk != null) && (parama != null))
      {
        parama = k.b.ar(parama, parambl.field_reserved);
        if (parama != null)
        {
          locala.GLX.setText(parama.title);
          parama = new bi(parambl, parama1.eZb(), paramInt, null, '\000');
          locala.naN.setTag(parama);
          locala.naN.setOnClickListener(d(parama1));
          if (this.nMt)
          {
            locala.naN.setOnLongClickListener(c(parama1));
            locala.naN.setOnTouchListener(((i)parama1.be(i.class)).eWp());
          }
        }
        if ((com.tencent.mm.bj.d.hxx != null) && (com.tencent.mm.bj.d.hxx.zA(parama1.getTalkerUserName())))
        {
          locala.GLX.setTextColor(parama1.GzJ.getContext().getResources().getColor(2131100711));
          locala.GLY.setAlpha(255);
          locala.naN.setClickable(true);
          locala.naN.setEnabled(true);
          AppMethodBeat.o(36993);
        }
      }
      else
      {
        if (localk == null) {}
        for (boolean bool = true;; bool = false)
        {
          ad.e("MicroMsg.ChattingItemAppMsgLocationShareFrom", "amessage:%b, %s, %s", new Object[] { Boolean.valueOf(bool), parama, Long.valueOf(parambl.field_msgId), paramString });
          parama = null;
          break;
        }
      }
      locala.GLX.setTextColor(parama1.GzJ.getContext().getResources().getColor(2131100249));
      locala.GLY.setAlpha(77);
      locala.naN.setClickable(false);
      locala.naN.setEnabled(false);
      AppMethodBeat.o(36993);
      return;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(36994);
    int i = ((bi)paramView.getTag()).position;
    m.aAU(com.tencent.mm.model.bi.b(this.Gob.eZb(), parambl.field_content, parambl.field_isSend));
    parambl = k.b.rx(com.tencent.mm.model.bi.b(this.Gob.eZb(), parambl.field_content, parambl.field_isSend));
    com.tencent.mm.pluginsdk.model.app.g localg = h.j(parambl.appId, false, false);
    if ((com.tencent.mm.bs.d.axB("favorite")) && ((localg == null) || (!localg.CZ()))) {
      switch (parambl.type)
      {
      }
    }
    for (;;)
    {
      if (!this.Gob.eZc()) {
        paramContextMenu.add(i, 100, 0, this.Gob.GzJ.getMMResources().getString(2131757221));
      }
      AppMethodBeat.o(36994);
      return true;
      paramContextMenu.add(i, 116, 0, paramView.getContext().getString(2131761941));
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(36995);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(36995);
      return false;
    }
    paramMenuItem = new Intent(parama.GzJ.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", com.tencent.mm.model.bi.b(parama.eZb(), parambl.field_content, parambl.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", parambl.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bd(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgLocationShare$ChattingItemAppMsgLocationShareFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgLocationShare$ChattingItemAppMsgLocationShareFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(36995);
    return false;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == -1879048186);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(36996);
    if ((com.tencent.mm.r.a.ce(paramView.getContext())) || (com.tencent.mm.r.a.cc(paramView.getContext())))
    {
      ad.d("MicroMsg.ChattingItemAppMsgLocationShareFrom", "voip is running, cann't start share location");
      AppMethodBeat.o(36996);
      return false;
    }
    ((b)com.tencent.mm.kernel.g.ab(b.class)).Sa(parambl.field_talker);
    paramView = (ak)parama.be(ak.class);
    parama.getTalkerUserName();
    paramView.cG("fromMessage", true);
    AppMethodBeat.o(36996);
    return true;
  }
  
  public final boolean faE()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.t.b
 * JD-Core Version:    0.7.0.1
 */