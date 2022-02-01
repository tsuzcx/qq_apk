package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
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
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.bd.d;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.br;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.ba;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class aa$c
  extends c
{
  private com.tencent.mm.ui.chatting.d.a aeiK;
  
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
      localObject = new ap(paramLayoutInflater, R.i.ggQ);
      ((View)localObject).setTag(new aa.a().lD((View)localObject));
    }
    AppMethodBeat.o(36997);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(36998);
    paramString = (aa.a)parama;
    this.aeiK = parama1;
    parama = paramcc.field_content;
    if (parama != null) {}
    for (parama = k.b.aP(parama, paramcc.field_reserved);; parama = null)
    {
      if (parama != null)
      {
        paramcc = new bz(paramcc, parama1.juG(), paramInt, null, '\000');
        paramString.clickArea.setTag(paramcc);
        paramString.clickArea.setOnClickListener(d(parama1));
        if (this.wQm)
        {
          paramString.clickArea.setOnLongClickListener(c(parama1));
          paramString.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
        }
        paramString.aeQN.setText(parama.title);
      }
      if ((d.oXN != null) && (d.oXN.Py(parama1.getTalkerUserName())))
      {
        paramString.aeQN.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.chatting_to_text_color));
        paramString.aeQO.setAlpha(1.0F);
        paramString.clickArea.setClickable(true);
        paramString.clickArea.setEnabled(true);
        AppMethodBeat.o(36998);
        return;
      }
      paramString.aeQN.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.chatting_to_disable_text_color));
      paramString.aeQO.setAlpha(0.3F);
      paramString.clickArea.setClickable(false);
      paramString.clickArea.setEnabled(false);
      AppMethodBeat.o(36998);
      return;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(37000);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37000);
      return false;
    }
    paramMenuItem = new Intent(parama.aezO.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", paramcc.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgLocationShare$ChattingItemAppMsgLocationShareTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgLocationShare$ChattingItemAppMsgLocationShareTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37000);
    return false;
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(254911);
    int i = ((bz)paramView.getTag()).position;
    n.bpT(br.a(this.aeiK.juG(), paramcc.field_content, paramcc.field_isSend));
    paramContextMenuInfo = k.b.Hf(br.a(this.aeiK.juG(), paramcc.field_content, paramcc.field_isSend));
    g localg = com.tencent.mm.pluginsdk.model.app.h.s(paramContextMenuInfo.appId, false, false);
    if ((com.tencent.mm.br.c.blq("favorite")) && ((localg == null) || (!localg.aqJ()))) {
      switch (paramContextMenuInfo.type)
      {
      }
    }
    for (;;)
    {
      if ((!paramcc.iYe()) && (paramcc.fxT()) && ((paramcc.field_status == 2) || (paramcc.kLk == 1)) && (c(paramcc, this.aeiK)) && (bBs(paramcc.field_talker))) {
        params.a(i, 123, paramView.getContext().getString(R.l.gyA), R.k.icons_filled_previous);
      }
      if (!this.aeiK.juH()) {
        params.a(i, 100, this.aeiK.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
      }
      AppMethodBeat.o(254911);
      return true;
      params.add(i, 116, 0, paramView.getContext().getString(R.l.plugin_favorite_opt));
    }
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    int i = 0;
    AppMethodBeat.i(37001);
    paramView = parama.getTalkerUserName();
    boolean bool1;
    if ((au.bwE(paramView)) && (((b)com.tencent.mm.kernel.h.ax(b.class)).alQ(paramView)))
    {
      bool1 = true;
      if ((!au.bwE(paramView)) || (v.If(paramView))) {
        break label126;
      }
    }
    label126:
    for (boolean bool2 = true;; bool2 = false)
    {
      Log.i("MicroMsg.ChattingItemAppMsgLocationShareTo", "isChatroomDismiss = " + bool1 + ", inChatRoom = " + bool2);
      if ((bool1) || (bool2)) {
        i = 1;
      }
      if (i == 0) {
        break label132;
      }
      AppMethodBeat.o(37001);
      return true;
      bool1 = false;
      break;
    }
    label132:
    ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(paramcc.field_talker);
    paramView = (ba)parama.cm(ba.class);
    parama.getTalkerUserName();
    paramView.el("fromMessage", true);
    AppMethodBeat.o(37001);
    return true;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == -1879048186);
  }
  
  public final boolean fXn()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aa.c
 * JD-Core Version:    0.7.0.1
 */