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
import com.tencent.mm.R.e;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.b.b.ae;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class m$c
  extends c
{
  private com.tencent.mm.ui.chatting.c.a vko;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new t(paramLayoutInflater, R.i.chatting_item_to_appmsg_location_share);
      ((View)localObject).setTag(new m.a().dT((View)localObject));
    }
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
  {
    paramString = (m.a)parama;
    this.vko = parama1;
    parama = parambi.field_content;
    if (parama != null) {}
    for (parama = g.a.M(parama, parambi.field_reserved);; parama = null)
    {
      if (parama != null)
      {
        parambi = new aw(parambi, parama1.cFE(), paramInt, null, '\000');
        paramString.igg.setTag(parambi);
        paramString.igg.setOnClickListener(d(parama1));
        if (this.khG)
        {
          paramString.igg.setOnLongClickListener(c(parama1));
          paramString.igg.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDu());
        }
        paramString.vDc.setText(parama.title);
      }
      if ((com.tencent.mm.bg.d.eEX != null) && (com.tencent.mm.bg.d.eEX.nA(parama1.getTalkerUserName())))
      {
        paramString.vDc.setTextColor(parama1.vtz.getContext().getResources().getColor(R.e.normal_text_color));
        paramString.igg.setClickable(true);
        paramString.igg.setEnabled(true);
        return;
      }
      paramString.vDc.setTextColor(-8750470);
      paramString.igg.setClickable(false);
      paramString.igg.setEnabled(false);
      return;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    int i = ((aw)paramView.getTag()).position;
    l.VW(bd.b(this.vko.cFE(), parambi.field_content, parambi.field_isSend));
    g.a locala = g.a.gp(bd.b(this.vko.cFE(), parambi.field_content, parambi.field_isSend));
    f localf = com.tencent.mm.pluginsdk.model.app.g.by(locala.appId, false);
    if ((com.tencent.mm.br.d.SP("favorite")) && ((localf == null) || (!localf.ZH()))) {
      switch (locala.type)
      {
      }
    }
    for (;;)
    {
      if ((!parambi.ctz()) && (parambi.aVM()) && ((parambi.field_status == 2) || (parambi.cQJ == 1)) && (a(parambi, this.vko)) && (adG(parambi.field_talker))) {
        paramContextMenu.add(i, 123, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_revoke_msg));
      }
      if (!this.vko.cFF()) {
        paramContextMenu.add(i, 100, 0, this.vko.vtz.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
      }
      return true;
      paramContextMenu.add(i, 116, 0, paramView.getContext().getString(R.l.plugin_favorite_opt));
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
    case 100: 
      Object localObject;
      do
      {
        do
        {
          return false;
          localObject = parambi.field_content;
          paramMenuItem = null;
          if (localObject != null) {
            paramMenuItem = g.a.gp((String)localObject);
          }
        } while (paramMenuItem == null);
        l.ha(parambi.field_msgId);
        bd.bC(parambi.field_msgId);
        localObject = com.tencent.mm.pluginsdk.model.app.g.by(paramMenuItem.appId, false);
      } while ((localObject == null) || (!((f)localObject).ZH()));
      a(parama, paramMenuItem, parambi, (f)localObject);
      return false;
    }
    paramMenuItem = new Intent(parama.vtz.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", bd.b(parama.cFE(), parambi.field_content, parambi.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", parambi.field_msgId);
    parama.startActivity(paramMenuItem);
    return false;
  }
  
  public final boolean au(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == -1879048186);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    paramView = (ae)parama.ac(ae.class);
    parama.getTalkerUserName();
    paramView.bL("fromMessage", true);
    return true;
  }
  
  public final boolean bfO()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.m.c
 * JD-Core Version:    0.7.0.1
 */