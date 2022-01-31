package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.b.b.i;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.chatting.t.m;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeatTextView;

public final class o$c
  extends c
  implements t.m
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
      localObject = new t(paramLayoutInflater, R.i.chatting_item_to_appmsg_text);
      ((View)localObject).setTag(new o.a().dV((View)localObject));
    }
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    if (parambi.aVK())
    {
      l.ae(parambi);
      bd.bC(parambi.field_msgId);
      parama.cCW();
    }
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
  {
    o.a locala = (o.a)parama;
    this.vko = parama1;
    ((i)parama1.ac(i.class)).aW(parambi);
    parama = parambi.field_content;
    if (parama != null) {}
    for (parama = g.a.M(parama, parambi.field_reserved);; parama = null)
    {
      f localf;
      if ((parama != null) && (parama.type == 1))
      {
        paramString = j.a(locala.vDk.getContext(), parama.title, (int)locala.vDk.getTextSize(), 1);
        locala.vDk.R(paramString);
        locala.vDk.setClickable(true);
        localf = com.tencent.mm.pluginsdk.model.app.g.by(parama.appId, true);
        if ((localf != null) && (localf.field_appName != null) && (localf.field_appName.trim().length() > 0)) {
          break label380;
        }
        paramString = parama.appName;
        if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.g.ct(paramString))) {
          break label390;
        }
        locala.kiv.setText(parama1.vtz.getMMResources().getString(R.l.chatting_source_from, new Object[] { com.tencent.mm.pluginsdk.model.app.g.b(parama1.vtz.getContext(), localf, paramString) }));
        locala.kiv.setVisibility(0);
        a(parama1, locala.kiv, parama.appId);
        a(parama1, locala.kiv, parama.appId);
        label250:
        if ((parambi.field_status != 2) && (parambi.field_status != 5)) {
          break label403;
        }
        locala.nhQ.setVisibility(8);
      }
      for (;;)
      {
        a(paramInt, locala, parambi, parama1.cFB(), parama1.cFE(), parama1, this);
        locala.vDk.setTag(new aw(parambi, parama1.cFE(), paramInt, null, '\000'));
        au.Hx();
        if (com.tencent.mm.model.c.isSDCardAvailable())
        {
          locala.vDk.setOnLongClickListener(c(parama1));
          if ((parama != null) && (parama.type == 1)) {
            locala.vDk.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDu());
          }
        }
        return;
        label380:
        paramString = localf.field_appName;
        break;
        label390:
        locala.kiv.setVisibility(8);
        break label250;
        label403:
        locala.nhQ.setVisibility(0);
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    int i = ((aw)paramView.getTag()).position;
    paramContextMenu.add(i, 102, 0, this.vko.vtz.getMMResources().getString(R.l.chatting_long_click_menu_copy_msg));
    paramContextMenu.add(i, 111, 0, this.vko.vtz.getMMResources().getString(R.l.retransmit));
    if (com.tencent.mm.br.d.SP("favorite")) {
      paramContextMenu.add(i, 116, 0, this.vko.vtz.getMMResources().getString(R.l.plugin_favorite_opt));
    }
    if ((!parambi.ctz()) && ((parambi.field_status == 2) || (parambi.cQJ == 1)) && (a(parambi, this.vko)) && (adG(parambi.field_talker))) {
      paramContextMenu.add(i, 123, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_revoke_msg));
    }
    if (!this.vko.cFF()) {
      paramContextMenu.add(i, 100, 0, this.vko.vtz.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
    }
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    case 100: 
      bd.bC(parambi.field_msgId);
      au.Hx();
      com.tencent.mm.model.c.Fv().b(new com.tencent.mm.ay.d(parambi.field_talker, parambi.field_msgSvrId));
      return false;
    case 102: 
      paramMenuItem = (ClipboardManager)parama.vtz.getContext().getSystemService("clipboard");
      g.a locala = g.a.gp(parambi.field_content);
      parama = bd.b(parama.cFD(), locala.title, parambi.field_isSend);
      paramMenuItem.setText(parama);
      paramMenuItem = com.tencent.mm.plugin.secinforeport.a.a.nQo;
      com.tencent.mm.plugin.secinforeport.a.a.f(1, parambi.field_msgSvrId, bk.ZH(parama));
      return false;
    }
    paramMenuItem = new Intent(parama.vtz.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", parambi.field_content);
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", parambi.field_msgId);
    parama.startActivity(paramMenuItem);
    return false;
  }
  
  public final boolean au(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 16777265);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean bfO()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.o.c
 * JD-Core Version:    0.7.0.1
 */