package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.bf;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.af;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class n$b
  extends c
{
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(32976);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969071);
      ((View)localObject).setTag(new n.a().fe((View)localObject));
    }
    AppMethodBeat.o(32976);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(32977);
    n.a locala = (n.a)parama;
    this.zzP = parama1;
    j localj = al.dlL().nx(parambi.field_msgId);
    parama = parambi.field_content;
    if (parama1.dJG())
    {
      int i = parambi.field_content.indexOf(':');
      if (i != -1) {
        parama = parambi.field_content.substring(i + 1);
      }
    }
    for (;;)
    {
      if ((localj != null) && (parama != null))
      {
        parama = j.b.ab(parama, parambi.field_reserved);
        if (parama != null)
        {
          locala.zUg.setText(parama.title);
          parama = new az(parambi, parama1.dJG(), paramInt, null, '\000');
          locala.jYu.setTag(parama);
          locala.jYu.setOnClickListener(d(parama1));
          if (this.kFs)
          {
            locala.jYu.setOnLongClickListener(c(parama1));
            locala.jYu.setOnTouchListener(((h)parama1.ay(h.class)).dHi());
          }
        }
        if ((com.tencent.mm.bh.d.fUO != null) && (com.tencent.mm.bh.d.fUO.uO(parama1.getTalkerUserName())))
        {
          locala.zUg.setTextColor(parama1.zJz.getContext().getResources().getColor(2131690322));
          locala.jYu.setClickable(true);
          locala.jYu.setEnabled(true);
          AppMethodBeat.o(32977);
        }
      }
      else
      {
        if (localj == null) {}
        for (boolean bool = true;; bool = false)
        {
          ab.e("MicroMsg.ChattingItemAppMsgLocationShareFrom", "amessage:%b, %s, %s", new Object[] { Boolean.valueOf(bool), parama, Long.valueOf(parambi.field_msgId), paramString });
          parama = null;
          break;
        }
      }
      locala.zUg.setTextColor(-8750470);
      locala.jYu.setClickable(false);
      locala.jYu.setEnabled(false);
      AppMethodBeat.o(32977);
      return;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(32978);
    int i = ((az)paramView.getTag()).position;
    l.alu(bf.b(this.zzP.dJG(), parambi.field_content, parambi.field_isSend));
    parambi = j.b.mY(bf.b(this.zzP.dJG(), parambi.field_content, parambi.field_isSend));
    f localf = g.ca(parambi.appId, false);
    if ((com.tencent.mm.bq.d.ahR("favorite")) && ((localf == null) || (!localf.vY()))) {
      switch (parambi.type)
      {
      }
    }
    for (;;)
    {
      if (!this.zzP.dJH()) {
        paramContextMenu.add(i, 100, 0, this.zzP.zJz.getMMResources().getString(2131298232));
      }
      AppMethodBeat.o(32978);
      return true;
      paramContextMenu.add(i, 116, 0, paramView.getContext().getString(2131302102));
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(32979);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(32979);
      return false;
    }
    paramMenuItem = new Intent(parama.zJz.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", bf.b(parama.dJG(), parambi.field_content, parambi.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", parambi.field_msgId);
    parama.startActivity(paramMenuItem);
    AppMethodBeat.o(32979);
    return false;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == -1879048186);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(32980);
    if ((com.tencent.mm.r.a.bO(ah.getContext())) || (com.tencent.mm.r.a.bM(ah.getContext())))
    {
      ab.d("MicroMsg.ChattingItemAppMsgLocationShareFrom", "voip is running, cann't start share location");
      AppMethodBeat.o(32980);
      return false;
    }
    paramView = (af)parama.ay(af.class);
    parama.getTalkerUserName();
    paramView.cn("fromMessage", true);
    AppMethodBeat.o(32980);
    return true;
  }
  
  public final boolean dLp()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.n.b
 * JD-Core Version:    0.7.0.1
 */