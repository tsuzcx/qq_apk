package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.f;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.do;
import com.tencent.mm.h.a.do.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.b.b.ah;
import com.tencent.mm.ui.chatting.b.b.g;

public final class ak
{
  public static final class b
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
        localObject = new t(paramLayoutInflater, R.i.chatting_item_to_video);
        ((View)localObject).setTag(new ak.d().s((View)localObject, false));
      }
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
    {
      this.vko = parama1;
      parama = (ak.d)parama;
      ak.d.a(parama, parambi, false, paramInt, parama1, R.g.chat_img_template, cHg(), c(parama1));
      if (cHc())
      {
        paramString = u.oe(parambi.field_imgPath);
        if ((paramString == null) || (paramString.status != 199) || (!a((g)parama1.ac(g.class), parambi.field_msgId))) {
          break label99;
        }
        if (parama.vBN != null) {
          parama.vBN.setVisibility(0);
        }
      }
      label99:
      while (parama.vBN == null) {
        return;
      }
      parama.vBN.setVisibility(8);
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
    {
      au.Hx();
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        if (paramView == null) {
          return false;
        }
        int i = ((aw)paramView.getTag()).position;
        s locals = o.Sr().nQ(parambi.field_imgPath);
        Object localObject = paramContextMenu.add(i, 130, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_mute_play));
        int j = paramView.getWidth();
        int k = paramView.getHeight();
        int[] arrayOfInt = new int[2];
        paramView.getLocationInWindow(arrayOfInt);
        Intent localIntent = new Intent();
        localIntent.putExtra("img_gallery_width", j).putExtra("img_gallery_height", k).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]);
        ((MenuItem)localObject).setIntent(localIntent);
        if (locals != null)
        {
          j = locals.status;
          if ((104 != j) && (103 != j) && (105 != j) && (106 != j)) {
            paramContextMenu.add(i, 107, 0, paramView.getContext().getString(R.l.retransmit));
          }
        }
        if ((locals != null) && ((locals.status == 199) || (locals.status == 199)))
        {
          if (d.SP("favorite")) {
            paramContextMenu.add(i, 116, 0, paramView.getContext().getString(R.l.plugin_favorite_opt));
          }
          localObject = new do();
          ((do)localObject).bJZ.bIt = parambi.field_msgId;
          com.tencent.mm.sdk.b.a.udP.m((b)localObject);
          if (((do)localObject).bKa.bJy) {
            paramContextMenu.add(i, 129, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_open));
          }
          if ((!parambi.ctz()) && ((parambi.aRQ()) || (parambi.aRR())) && (a(parambi, this.vko)) && ((locals.status == 199) || (locals.status == 199) || (parambi.cQJ == 1)) && (adG(parambi.field_talker))) {
            paramContextMenu.add(i, 123, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_revoke_msg));
          }
          if ((f.Mj()) && (!this.vko.cFF())) {
            paramContextMenu.add(i, 114, 0, paramView.getContext().getString(R.l.chatting_long_click_brand_service));
          }
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
      return (paramBoolean) && (paramInt == 43);
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
    {
      cHg().onClick(paramView);
      return true;
    }
    
    public final boolean bfO()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ak
 * JD-Core Version:    0.7.0.1
 */