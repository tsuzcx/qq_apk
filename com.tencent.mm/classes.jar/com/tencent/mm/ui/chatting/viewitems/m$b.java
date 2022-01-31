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
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.b.b.ae;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class m$b
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
      localObject = new t(paramLayoutInflater, R.i.chatting_item_from_appmsg_location_share);
      ((View)localObject).setTag(new m.a().dT((View)localObject));
    }
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
  {
    m.a locala = (m.a)parama;
    this.vko = parama1;
    com.tencent.mm.ae.g localg = ap.clc().gZ(parambi.field_msgId);
    parama = parambi.field_content;
    if (parama1.cFE())
    {
      int i = parambi.field_content.indexOf(':');
      if (i != -1) {
        parama = parambi.field_content.substring(i + 1);
      }
    }
    for (;;)
    {
      if ((localg != null) && (parama != null))
      {
        parama = g.a.M(parama, parambi.field_reserved);
        if (parama != null)
        {
          locala.vDc.setText(parama.title);
          parama = new aw(parambi, parama1.cFE(), paramInt, null, '\000');
          locala.igg.setTag(parama);
          locala.igg.setOnClickListener(d(parama1));
          if (this.khG)
          {
            locala.igg.setOnLongClickListener(c(parama1));
            locala.igg.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDu());
          }
        }
        if ((com.tencent.mm.bg.d.eEX != null) && (com.tencent.mm.bg.d.eEX.nA(parama1.getTalkerUserName())))
        {
          locala.vDc.setTextColor(parama1.vtz.getContext().getResources().getColor(R.e.normal_text_color));
          locala.igg.setClickable(true);
          locala.igg.setEnabled(true);
        }
      }
      else
      {
        if (localg == null) {}
        for (boolean bool = true;; bool = false)
        {
          y.e("MicroMsg.ChattingItemAppMsgLocationShareFrom", "amessage:%b, %s, %s", new Object[] { Boolean.valueOf(bool), parama, Long.valueOf(parambi.field_msgId), paramString });
          parama = null;
          break;
        }
      }
      locala.vDc.setTextColor(-8750470);
      locala.igg.setClickable(false);
      locala.igg.setEnabled(false);
      return;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    int i = ((aw)paramView.getTag()).position;
    l.VW(bd.b(this.vko.cFE(), parambi.field_content, parambi.field_isSend));
    parambi = g.a.gp(bd.b(this.vko.cFE(), parambi.field_content, parambi.field_isSend));
    f localf = com.tencent.mm.pluginsdk.model.app.g.by(parambi.appId, false);
    if ((com.tencent.mm.br.d.SP("favorite")) && ((localf == null) || (!localf.ZH()))) {
      switch (parambi.type)
      {
      }
    }
    for (;;)
    {
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
    return (!paramBoolean) && (paramInt == -1879048186);
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
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.m.b
 * JD-Core Version:    0.7.0.1
 */