package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.pluginsdk.model.app.ac;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.b.b.ai;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class an
  extends c
{
  private f eBv;
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
      localObject = new t(paramLayoutInflater, R.i.chatting_item_voiceremind_remind);
      ((View)localObject).setTag(new bc().ed((View)localObject));
    }
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    localbc = (bc)parama;
    this.vko = parama1;
    Object localObject2 = ap.clc().gZ(parambi.field_msgId);
    Object localObject1 = parambi.field_content;
    parama = null;
    paramString = parama;
    if (localObject2 != null)
    {
      paramString = parama;
      if (localObject1 != null) {
        paramString = g.a.M((String)localObject1, parambi.field_reserved);
      }
    }
    localObject2 = com.tencent.mm.plugin.subapp.c.e.PA((String)localObject1);
    if ((localObject2 != null) && (((com.tencent.mm.plugin.subapp.c.e)localObject2).pvG != 0)) {}
    try
    {
      localObject3 = com.tencent.mm.pluginsdk.f.h.T(parama1.vtz.getContext(), ((com.tencent.mm.plugin.subapp.c.e)localObject2).pvG);
      localObject1 = "";
      parama = (c.a)localObject1;
      if (localObject3 != null)
      {
        parama = (c.a)localObject1;
        if (((String)localObject3).length() > 0)
        {
          localObject3 = ((String)localObject3).split(";");
          localObject1 = "" + localObject3[0].replace(" ", "");
          parama = (c.a)localObject1;
          if (localObject3.length > 1) {
            parama = (String)localObject1 + localObject3[1];
          }
        }
      }
      localObject1 = parama;
      if (paramString != null)
      {
        localObject1 = parama;
        if (paramString.description != null) {
          localObject1 = parama + " " + paramString.description;
        }
      }
      localbc.eXP.setText((CharSequence)localObject1);
    }
    catch (Exception parama)
    {
      for (;;)
      {
        Object localObject3;
        long l;
        y.printErrStackTrace("MicroMsg.ChattingItemVoiceRemindRemind", parama, "", new Object[0]);
        continue;
        int i = 0;
        continue;
        localbc.vIn.setImageResource(R.g.music_playicon);
      }
    }
    y.d("MicroMsg.ChattingItemVoiceRemindRemind", "content remind " + parambi.field_content);
    if ((bk.bl(parambi.field_imgPath)) && (((com.tencent.mm.plugin.subapp.c.e)localObject2).pvM > 0))
    {
      au.Hx();
      parama = com.tencent.mm.model.c.Fy().O(parambi.field_talker, ((com.tencent.mm.plugin.subapp.c.e)localObject2).pvM);
      if (!bk.bl(parama.field_imgPath))
      {
        localObject1 = com.tencent.mm.plugin.subapp.c.k.nR(q.Gj());
        localObject3 = com.tencent.mm.plugin.subapp.c.h.bh((String)localObject1, false);
        if (com.tencent.mm.vfs.e.r(com.tencent.mm.plugin.subapp.c.h.bh(parama.field_imgPath, false), (String)localObject3) >= 0L)
        {
          parambi.ed((String)localObject1);
          au.Hx();
          com.tencent.mm.model.c.Fy().a(parambi.field_msgId, parambi);
        }
      }
    }
    if ((bk.bl(parambi.field_imgPath)) && (localObject2 != null) && (((com.tencent.mm.plugin.subapp.c.e)localObject2).bFE != null) && (((com.tencent.mm.plugin.subapp.c.e)localObject2).bFE.length() > 0) && (((com.tencent.mm.plugin.subapp.c.e)localObject2).dQv > 0) && (this.eBv == null))
    {
      parama = com.tencent.mm.plugin.subapp.c.k.nR(q.Gj());
      localObject1 = com.tencent.mm.plugin.subapp.c.h.bh(parama, false);
      if (bk.bl(parambi.field_imgPath))
      {
        parambi.ed(parama);
        au.Hx();
        com.tencent.mm.model.c.Fy().a(parambi.field_msgId, parambi);
        y.d("MicroMsg.ChattingItemVoiceRemindRemind", "content.attachid " + paramString.bFE);
        parama = l.a((String)localObject1, parambi.field_msgId, paramString.sdkVer, paramString.appId, paramString.bFE, paramString.dQv);
        y.d("MicroMsg.ChattingItemVoiceRemindRemind", "ainfo.field_mediaSvrId " + parama.field_mediaSvrId);
        if (parama.field_mediaSvrId != null)
        {
          paramString = au.Dk();
          localObject1 = new an.1(this);
          this.eBv = ((f)localObject1);
          paramString.a(221, (f)localObject1);
          y.d("MicroMsg.ChattingItemVoiceRemindRemind", "doscene");
          parama = new ac(parama);
          au.Dk().a(parama, 0);
        }
      }
    }
    localbc.vIn.setOnClickListener(new an.2(this, parambi, paramInt));
    l = parambi.field_msgId;
    parama = ((ai)this.vko.ac(ai.class)).cFx();
    if ((parama.isPlaying()) && (parama.vhz == l))
    {
      i = 1;
      if (i == 0) {
        break label785;
      }
      localbc.vIn.setImageResource(R.g.music_pauseicon);
      localbc.igg.setTag(new aw(parambi, parama1.cFE(), paramInt, null, '\000'));
      au.Hx();
      if (com.tencent.mm.model.c.isSDCardAvailable()) {
        localbc.igg.setOnLongClickListener(c(parama1));
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    int i = ((aw)paramView.getTag()).position;
    int j = l.VW(bd.b(this.vko.cFE(), parambi.field_content, parambi.field_isSend));
    paramView = g.a.gp(bd.b(this.vko.cFE(), parambi.field_content, parambi.field_isSend));
    if ((paramView.dQv <= 0) || ((paramView.dQv > 0) && (j >= 100))) {
      paramContextMenu.add(i, 111, 0, this.vko.vtz.getMMResources().getString(R.l.retransmit));
    }
    if (!this.vko.cFF()) {
      paramContextMenu.add(i, 100, 0, this.vko.vtz.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
    }
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bi parambi)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    case 100: 
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
    return paramInt == -1879048190;
  }
  
  public final String b(a parama, bi parambi)
  {
    return parama.getTalkerUserName();
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    return true;
  }
  
  protected final boolean b(a parama)
  {
    return false;
  }
  
  public final boolean bfO()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.an
 * JD-Core Version:    0.7.0.1
 */