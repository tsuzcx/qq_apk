package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.if;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.card.b.h;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class i$c
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
      localObject = new t(paramLayoutInflater, R.i.chatting_item_to_coupon_card);
      ((View)localObject).setTag(new i.a().t((View)localObject, false));
    }
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
  {
    this.vko = parama1;
    i.a locala = (i.a)parama;
    paramString = parambi.field_content;
    if (paramString != null) {}
    for (paramString = g.a.M(paramString, parambi.field_reserved);; paramString = null)
    {
      if ((locala != null) && (paramString != null)) {
        locala.a(parama1.vtz.getContext(), paramString, parambi.field_imgPath, this.khG);
      }
      parambi = new aw(parambi, parama1.cFE(), paramInt, null, '\000');
      parama.igg.setTag(parambi);
      parama.igg.setOnClickListener(d(parama1));
      if (this.khG)
      {
        parama.igg.setOnLongClickListener(c(parama1));
        parama.igg.setOnTouchListener(((g)parama1.ac(g.class)).cDu());
      }
      return;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    int i = ((aw)paramView.getTag()).position;
    if (parambi.field_content == null) {
      return true;
    }
    paramView = g.a.gp(bd.b(this.vko.cFE(), parambi.field_content, parambi.field_isSend));
    if (paramView == null) {
      return true;
    }
    switch (paramView.type)
    {
    default: 
    case 16: 
      do
      {
        return true;
      } while ((paramView.dRM != 5) && (paramView.dRM != 6) && (paramView.dRM != 2));
      if (paramView.dRM != 2) {
        paramContextMenu.clear();
      }
      paramContextMenu.add(i, 100, 0, this.vko.vtz.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
      return false;
    }
    paramContextMenu.clear();
    paramContextMenu.add(i, 100, 0, this.vko.vtz.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    do
    {
      do
      {
        return false;
        parama = parambi.field_content;
        paramMenuItem = null;
        if (parama != null) {
          paramMenuItem = g.a.gp(parama);
        }
        if (paramMenuItem != null) {
          l.ha(parambi.field_msgId);
        }
        bd.bC(parambi.field_msgId);
        return false;
        Object localObject = bd.b(parama.cFE(), parambi.field_content, parambi.field_isSend);
        paramMenuItem = new Intent(parama.vtz.getContext(), MsgRetransmitUI.class);
        paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
        localObject = g.a.gp((String)localObject);
        if ((localObject != null) && (16 == ((g.a)localObject).type)) {
          paramMenuItem.putExtra("Retr_Msg_Type", 14);
        }
        for (;;)
        {
          paramMenuItem.putExtra("Retr_Msg_Id", parambi.field_msgId);
          parama.startActivity(paramMenuItem);
          return false;
          paramMenuItem.putExtra("Retr_Msg_Type", 2);
        }
        paramMenuItem = parambi.field_content;
      } while (paramMenuItem == null);
      paramMenuItem = g.a.gp(paramMenuItem);
    } while (paramMenuItem == null);
    switch (paramMenuItem.type)
    {
    default: 
      return false;
    }
    parama = new if();
    parama.bQq.bQr = paramMenuItem.bQr;
    parama.bQq.bHR = parambi.field_msgId;
    parama.bQq.bQs = parambi.field_talker;
    com.tencent.mm.sdk.b.a.udP.m(parama);
    return false;
  }
  
  public final boolean au(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && ((paramInt == 452984881) || (paramInt == 520093745));
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    paramView = parambi.field_content;
    if (paramView == null) {
      return false;
    }
    Object localObject = g.a.gp(paramView);
    if (localObject == null) {
      return false;
    }
    switch (((g.a)localObject).type)
    {
    default: 
      return false;
    case 16: 
      if (bk.bl(((g.a)localObject).bQr)) {
        return false;
      }
      paramView = new Intent();
      paramView.setFlags(65536);
      paramView.putExtra("key_card_app_msg", ((g.a)localObject).bQr);
      paramView.putExtra("key_from_scene", ((g.a)localObject).dRM);
      d.b(parama.vtz.getContext(), "card", ".ui.CardDetailUI", paramView);
      return true;
    }
    paramView = h.b((g.a)localObject);
    PackageInfo localPackageInfo;
    int i;
    if (1 < paramView.ver)
    {
      String str = p.u(((g.a)localObject).dQu, "message");
      localPackageInfo = getPackageInfo(parama.vtz.getContext(), ((g.a)localObject).appId);
      if (localPackageInfo == null)
      {
        paramView = null;
        if (localPackageInfo != null) {
          break label229;
        }
        i = 0;
        label191:
        a(parama, str, str, paramView, i, ((g.a)localObject).appId, true, parambi.field_msgId, parambi.field_msgSvrId, parambi);
      }
    }
    for (;;)
    {
      return true;
      paramView = localPackageInfo.versionName;
      break;
      label229:
      i = localPackageInfo.versionCode;
      break label191;
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_from_user_name", b(parama, parambi));
      ((Intent)localObject).putExtra("key_biz_uin", paramView.dRO);
      ((Intent)localObject).putExtra("key_order_id", paramView.dRP);
      if ((parambi.field_talker != null) && (!parambi.field_talker.equals("")) && (s.fn(parambi.field_talker))) {
        ((Intent)localObject).putExtra("key_chatroom_name", parambi.field_talker);
      }
      d.b(parama.vtz.getContext(), "card", ".ui.CardGiftAcceptUI", (Intent)localObject);
    }
  }
  
  public final boolean bfO()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.i.c
 * JD-Core Version:    0.7.0.1
 */