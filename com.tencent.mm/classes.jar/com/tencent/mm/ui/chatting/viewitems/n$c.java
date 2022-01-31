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
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.bf;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.af;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class n$c
  extends c
{
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(32981);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969109);
      ((View)localObject).setTag(new n.a().fe((View)localObject));
    }
    AppMethodBeat.o(32981);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(32982);
    paramString = (n.a)parama;
    this.zzP = parama1;
    parama = parambi.field_content;
    if (parama != null) {}
    for (parama = j.b.ab(parama, parambi.field_reserved);; parama = null)
    {
      if (parama != null)
      {
        parambi = new az(parambi, parama1.dJG(), paramInt, null, '\000');
        paramString.jYu.setTag(parambi);
        paramString.jYu.setOnClickListener(d(parama1));
        if (this.kFs)
        {
          paramString.jYu.setOnLongClickListener(c(parama1));
          paramString.jYu.setOnTouchListener(((h)parama1.ay(h.class)).dHi());
        }
        paramString.zUg.setText(parama.title);
      }
      if ((com.tencent.mm.bh.d.fUO != null) && (com.tencent.mm.bh.d.fUO.uO(parama1.getTalkerUserName())))
      {
        paramString.zUg.setTextColor(parama1.zJz.getContext().getResources().getColor(2131690322));
        paramString.jYu.setClickable(true);
        paramString.jYu.setEnabled(true);
        AppMethodBeat.o(32982);
        return;
      }
      paramString.zUg.setTextColor(-8750470);
      paramString.jYu.setClickable(false);
      paramString.jYu.setEnabled(false);
      AppMethodBeat.o(32982);
      return;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(32983);
    int i = ((az)paramView.getTag()).position;
    l.alu(bf.b(this.zzP.dJG(), parambi.field_content, parambi.field_isSend));
    j.b localb = j.b.mY(bf.b(this.zzP.dJG(), parambi.field_content, parambi.field_isSend));
    f localf = g.ca(localb.appId, false);
    if ((com.tencent.mm.bq.d.ahR("favorite")) && ((localf == null) || (!localf.vY()))) {
      switch (localb.type)
      {
      }
    }
    for (;;)
    {
      if ((!parambi.dvV()) && (parambi.bCp()) && ((parambi.field_status == 2) || (parambi.dGV == 1)) && (a(parambi, this.zzP)) && (auk(parambi.field_talker))) {
        paramContextMenu.add(i, 123, 0, paramView.getContext().getString(2131298244));
      }
      if (!this.zzP.dJH()) {
        paramContextMenu.add(i, 100, 0, this.zzP.zJz.getMMResources().getString(2131298232));
      }
      AppMethodBeat.o(32983);
      return true;
      paramContextMenu.add(i, 116, 0, paramView.getContext().getString(2131302102));
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(32984);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(32984);
      return false;
    }
    paramMenuItem = new Intent(parama.zJz.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", bf.b(parama.dJG(), parambi.field_content, parambi.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", parambi.field_msgId);
    parama.startActivity(paramMenuItem);
    AppMethodBeat.o(32984);
    return false;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == -1879048186);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(32985);
    paramView = (af)parama.ay(af.class);
    parama.getTalkerUserName();
    paramView.cn("fromMessage", true);
    AppMethodBeat.o(32985);
    return true;
  }
  
  public final boolean dLp()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.n.c
 * JD-Core Version:    0.7.0.1
 */