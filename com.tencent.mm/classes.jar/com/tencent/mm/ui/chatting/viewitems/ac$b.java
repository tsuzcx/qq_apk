package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.f;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.do;
import com.tencent.mm.h.a.do.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.chatting.l;
import com.tencent.mm.ui.chatting.t.m;
import java.util.LinkedList;
import java.util.List;

public final class ac$b
  extends c
  implements t.m
{
  protected ac.c vFb;
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
      localObject = new t(paramLayoutInflater, R.i.chatting_item_to_location);
      ((View)localObject).setTag(new ac.d().s((View)localObject, false));
    }
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    parambi.cvz();
    au.Hx();
    com.tencent.mm.model.c.Fy().a(parambi.field_msgId, parambi);
    ((com.tencent.mm.ui.chatting.b.b.t)parama.ac(com.tencent.mm.ui.chatting.b.b.t.class)).aR(parambi);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
  {
    this.vko = parama1;
    paramString = (ac.d)parama;
    if (this.vFb == null) {
      this.vFb = new ac.c(parama1);
    }
    ac.d.a(paramString, parambi, false, paramInt, parama1, this.vFb, c(parama1));
    parama = (ac.d)parama;
    if (cHc())
    {
      if ((parambi.field_status != 2) || (!a((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class), parambi.field_msgId))) {
        break label123;
      }
      if (parama.vBN != null) {
        parama.vBN.setVisibility(0);
      }
    }
    for (;;)
    {
      a(paramInt, parama, parambi, parama1.cFB(), parama1.cFE(), parama1, this);
      return;
      label123:
      if (parama.vBN != null) {
        parama.vBN.setVisibility(8);
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    if (parambi.getType() == 48)
    {
      int i = ((aw)paramView.getTag()).position;
      if (parambi.field_status == 5) {
        paramContextMenu.add(i, 103, 0, paramView.getContext().getString(R.l.chatting_resend_title));
      }
      paramContextMenu.add(i, 127, 0, paramView.getContext().getString(R.l.retransmit));
      if ((f.Mk()) && (!this.vko.cFF())) {
        paramContextMenu.add(i, 114, 0, paramView.getContext().getString(R.l.chatting_long_click_brand_service));
      }
      if (d.SP("favorite")) {
        paramContextMenu.add(i, 116, 0, paramView.getContext().getString(R.l.plugin_favorite_opt));
      }
      do localdo = new do();
      localdo.bJZ.bIt = parambi.field_msgId;
      com.tencent.mm.sdk.b.a.udP.m(localdo);
      if ((localdo.bKa.bJy) || (com.tencent.mm.pluginsdk.model.app.g.S(this.vko.vtz.getContext(), parambi.getType()))) {
        paramContextMenu.add(i, 129, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_open));
      }
      if ((!parambi.ctz()) && (parambi.aVM()) && ((parambi.field_status == 2) || (parambi.cQJ == 1)) && (a(parambi, this.vko)) && (adG(parambi.field_talker))) {
        paramContextMenu.add(i, 123, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_revoke_msg));
      }
      if (!this.vko.cFF()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_delete_msg));
      }
    }
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    }
    if (parambi.aVM())
    {
      paramMenuItem = new LinkedList();
      paramMenuItem.add(parambi);
      l.a(parama.vtz.getContext(), paramMenuItem, parama.cFE(), parama.pSb.field_username, null);
    }
    return true;
  }
  
  public final boolean au(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 48);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ac.b
 * JD-Core Version:    0.7.0.1
 */