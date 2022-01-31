package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.f;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.do;
import com.tencent.mm.h.a.do.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bf;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.b.b.ah;

public final class ak$a
  extends c
{
  private ak.c vGf;
  private com.tencent.mm.ui.chatting.c.a vko;
  
  private ak.c cHg()
  {
    if (this.vGf == null) {
      this.vGf = new ak.c(this.vko);
    }
    return this.vGf;
  }
  
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
      localObject = new t(paramLayoutInflater, R.i.chatting_item_from_video);
      ((View)localObject).setTag(new ak.d().s((View)localObject, true));
    }
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
  {
    this.vko = parama1;
    parama = (ak.d)parama;
    ak.d.a(parama, parambi, true, paramInt, parama1, R.g.chat_img_template, cHg(), c(parama1));
    parambi = parambi.cQF;
    if ((parambi == null) || (parambi.length() == 0))
    {
      parama.vBz.setVisibility(8);
      return;
    }
    parama.vBz.setVisibility(0);
    b(parama1, parama.vBz, aw.adO(parambi));
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    au.Hx();
    if (com.tencent.mm.model.c.isSDCardAvailable())
    {
      int i = ((aw)paramView.getTag()).position;
      s locals = o.Sr().nQ(parambi.field_imgPath);
      paramContextMenu.add(i, 130, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_mute_play));
      paramContextMenu.add(i, 107, 0, paramView.getContext().getString(R.l.retransmit));
      if (d.SP("favorite")) {
        paramContextMenu.add(i, 116, 0, paramView.getContext().getString(R.l.plugin_favorite_opt));
      }
      do localdo = new do();
      localdo.bJZ.bIt = parambi.field_msgId;
      com.tencent.mm.sdk.b.a.udP.m(localdo);
      if (localdo.bKa.bJy) {
        paramContextMenu.add(i, 129, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_open));
      }
      if ((locals != null) && ((locals.status == 199) || (locals.status == 199)) && (f.Mj()) && (!this.vko.cFF())) {
        paramContextMenu.add(i, 114, 0, paramView.getContext().getString(R.l.chatting_long_click_brand_service));
      }
      if (bf.k(parambi))
      {
        paramContextMenu.clear();
        paramContextMenu.add(i, 130, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_mute_play));
      }
      if (!this.vko.cFF()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_delete_video));
      }
    }
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    ((ah)parama.ac(ah.class)).a(paramMenuItem, parambi);
    return false;
  }
  
  public final boolean au(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 43);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    cHg().onClick(paramView);
    return true;
  }
  
  public final boolean bfO()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ak.a
 * JD-Core Version:    0.7.0.1
 */