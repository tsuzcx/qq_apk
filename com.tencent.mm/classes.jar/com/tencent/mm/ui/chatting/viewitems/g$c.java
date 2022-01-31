package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;

public final class g$c
  extends c
{
  private a vko;
  
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
      localObject = new t(paramLayoutInflater, R.i.chatting_item_to_appmsg_c2c_newyear);
      ((View)localObject).setTag(new g.a().dQ((View)localObject));
    }
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    this.vko = parama1;
    paramString = parambi.field_content;
    if (paramString != null) {}
    for (paramString = com.tencent.mm.ae.g.a.M(paramString, parambi.field_reserved);; paramString = null)
    {
      g.a locala = (g.a)parama;
      if (paramString != null) {
        if (parambi.field_isSend != 1) {
          break label140;
        }
      }
      label140:
      for (paramString = paramString.dSd;; paramString = paramString.dSe)
      {
        locala.vCz.setText(paramString);
        parama.igg.setOnClickListener(d(parama1));
        parama.igg.setOnLongClickListener(c(parama1));
        parama.igg.setOnTouchListener(((g)parama1.ac(g.class)).cDu());
        parama1 = new aw(parambi, this.vko.cFE(), paramInt, null, '\000');
        parama.igg.setTag(parama1);
        return;
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    paramContextMenu.add(((aw)paramView.getTag()).position, 100, 0, this.vko.vtz.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bi parambi)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    }
    bd.bC(parambi.field_msgId);
    return true;
  }
  
  public final boolean au(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 469762097);
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    paramView = parambi.field_content;
    if (paramView != null)
    {
      paramView = com.tencent.mm.ae.g.a.M(paramView, parambi.field_reserved);
      if ((paramView != null) && (!bk.bl(paramView.dSi)))
      {
        parambi = new Intent();
        parambi.putExtra("key_native_url", paramView.dSi);
        parambi.putExtra("key_image_id", paramView.dSl);
        parambi.putExtra("key_image_aes_key", paramView.dSm);
        parambi.putExtra("key_image_length", paramView.dSn);
        parambi.putExtra("key_username", parama.getTalkerUserName());
        d.b(parama.vtz.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearReceiveUI", parambi);
      }
    }
    return true;
  }
  
  public final boolean bfO()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.g.c
 * JD-Core Version:    0.7.0.1
 */