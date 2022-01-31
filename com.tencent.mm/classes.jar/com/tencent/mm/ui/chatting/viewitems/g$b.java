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
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;
import java.util.Map;

public final class g$b
  extends c
{
  private final int vCA = 1;
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
      localObject = new t(paramLayoutInflater, R.i.chatting_item_from_appmsg_c2c_newyear);
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
        parama.igg.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDu());
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
    return (!paramBoolean) && (paramInt == 469762097);
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    paramView = parambi.field_content;
    if (paramView != null)
    {
      paramView = com.tencent.mm.ae.g.a.M(paramView, parambi.field_reserved);
      if (!bk.bl(paramView.dSi))
      {
        if (paramView.dSj != 1) {
          break label123;
        }
        y.d("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", "onItemClick hasplay, skip");
        parambi = new Intent();
        parambi.putExtra("key_native_url", paramView.dSi);
        parambi.putExtra("key_username", parama.getTalkerUserName());
        parambi.putExtra("key_image_id", paramView.dSl);
        parambi.putExtra("key_image_aes_key", paramView.dSm);
        parambi.putExtra("key_image_length", paramView.dSn);
        d.b(parama.vtz.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearReceiveUI", parambi);
      }
    }
    return true;
    label123:
    y.d("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", "onItemClick play egg emoj");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_native_url", paramView.dSi);
    localIntent.putExtra("key_username", parama.getTalkerUserName());
    localIntent.putExtra("key_image_id", paramView.dSl);
    localIntent.putExtra("key_image_aes_key", paramView.dSm);
    localIntent.putExtra("key_image_length", paramView.dSn);
    d.b(parama.vtz.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearReceiveUI", localIntent);
    paramView.dSj = 1;
    parambi.setContent(com.tencent.mm.ae.g.a.a(paramView, null, null));
    if ((parambi == null) || (!parambi.aVK())) {}
    for (;;)
    {
      au.Hx();
      com.tencent.mm.model.c.Fy().a(parambi.field_msgId, parambi);
      return true;
      try
      {
        parama = parambi.field_content;
        int i = parama.indexOf("<msg>");
        paramView = parama;
        if (i > 0)
        {
          paramView = parama;
          if (i < parama.length()) {
            paramView = parama.substring(i).trim();
          }
        }
        paramView = bn.s(paramView, "msg");
        if ((paramView != null) && (paramView.size() > 0)) {
          parambi.ee(ba.au(paramView));
        }
      }
      catch (Exception paramView)
      {
        y.e("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", paramView.getMessage());
      }
    }
  }
  
  public final boolean bfO()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.g.b
 * JD-Core Version:    0.7.0.1
 */