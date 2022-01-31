package com.tencent.mm.ui.chatting.viewitems;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.pluginsdk.model.app.ac;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.b.b.ai;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class am
  extends c
{
  private f eBv;
  private ProgressDialog nTd;
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
      localObject = new t(paramLayoutInflater, R.i.chatting_item_voiceremind_confirm);
      ((View)localObject).setTag(new as().ec((View)localObject));
    }
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    paramString = (as)parama;
    this.vko = parama1;
    parama = ap.clc().gZ(parambi.field_msgId);
    parama1 = parambi.field_content;
    if ((parama != null) && (parama1 != null)) {}
    for (parama = g.a.gp(parama1);; parama = null)
    {
      boolean bool2 = false;
      parama1 = com.tencent.mm.plugin.subapp.c.e.PA(parama1);
      boolean bool1 = bool2;
      if (parama1 != null)
      {
        bool1 = bool2;
        if (parama1.pvG == 0) {}
      }
      for (;;)
      {
        try
        {
          localObject1 = com.tencent.mm.pluginsdk.f.h.T(this.vko.vtz.getContext(), parama1.pvG);
          if ((parama != null) && (parama.description != null))
          {
            i = parama.description.indexOf('|');
            if ((i <= 0) || (parama.description.length() <= i + 1)) {
              continue;
            }
            localObject2 = parama.description.substring(i + 1);
            paramString.eXP.setText((CharSequence)localObject2);
          }
          if ((localObject1 != null) && (((String)localObject1).length() > 0))
          {
            localObject1 = ((String)localObject1).split(";");
            paramString.vGU.setText(localObject1[0]);
            if (localObject1.length > 1) {
              paramString.vGV.setText(localObject1[1]);
            }
          }
        }
        catch (Exception localException)
        {
          Object localObject1;
          Object localObject2;
          long l;
          Object localObject3;
          int j;
          int k;
          String str;
          y.printErrStackTrace("MicroMsg.ChattingItemVoiceRemindConfirm", localException, "", new Object[0]);
          continue;
          paramString.vGY.setVisibility(8);
          paramString.eXP.setTextColor(this.vko.vtz.getMMResources().getColor(R.e.voice_remind_date_color));
          paramString.vGV.setTextColor(this.vko.vtz.getMMResources().getColor(R.e.voice_remind_date_color));
          paramString.vGU.setTextColor(this.vko.vtz.getMMResources().getColor(R.e.voice_remind_date_color));
          continue;
          int i = 0;
          continue;
          paramString.vGW.setBackgroundResource(R.g.voice_remind_play_btn);
          continue;
        }
        bool1 = ah.jM(parama1.pvG);
        if (!bool1) {
          continue;
        }
        paramString.vGY.setVisibility(0);
        paramString.eXP.setTextColor(this.vko.vtz.getMMResources().getColor(R.e.voice_remind_grey_color));
        paramString.vGV.setTextColor(this.vko.vtz.getMMResources().getColor(R.e.voice_remind_grey_color));
        paramString.vGU.setTextColor(this.vko.vtz.getMMResources().getColor(R.e.voice_remind_grey_color));
        paramString.vGW.setOnClickListener(new am.1(this, parambi, paramInt));
        l = parambi.field_msgId;
        localObject1 = ((ai)this.vko.ac(ai.class)).cFx();
        if ((localObject1 == null) || (!((d)localObject1).isPlaying()) || (((d)localObject1).vhz != l)) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        paramString.vGW.setBackgroundResource(R.g.voice_remind_pause_btn);
        if ((parama1 != null) && (!ah.bl(parama1.pvI)) && (parama1.pvJ > 0) && (ah.bl(parambi.field_reserved)) && (parama != null))
        {
          localObject2 = com.tencent.mm.plugin.subapp.c.k.nR(q.Gj());
          localObject1 = com.tencent.mm.plugin.subapp.c.h.bh((String)localObject2, false);
          parambi.ee((String)localObject2);
          au.Hx();
          com.tencent.mm.model.c.Fy().a(parambi.field_msgId, parambi);
          l = parambi.field_msgId;
          i = parama.sdkVer;
          localObject2 = parama.appId;
          localObject3 = parama1.pvI;
          j = parama1.pvJ;
          k = parama.type;
          str = parama.dQR;
          localObject1 = l.a((String)localObject1, l, i, (String)localObject2, (String)localObject3, j, k, parama.dQz);
          if (localObject1 != null)
          {
            localObject2 = au.Dk();
            localObject3 = new am.2(this, parambi, (String)localObject1, paramInt);
            this.eBv = ((f)localObject3);
            ((p)localObject2).a(221, (f)localObject3);
            localObject1 = new ac((String)localObject1);
            ((ac)localObject1).ckX();
            au.Dk().a((m)localObject1, 0);
          }
        }
        if ((ah.bl(parambi.field_imgPath)) && (parama1.pvM > 0))
        {
          au.Hx();
          localObject1 = com.tencent.mm.model.c.Fy().O(parambi.field_talker, parama1.pvM);
          if (!ah.bl(((cs)localObject1).field_imgPath))
          {
            localObject2 = com.tencent.mm.plugin.subapp.c.k.nR(q.Gj());
            localObject3 = com.tencent.mm.plugin.subapp.c.h.bh((String)localObject2, false);
            if (com.tencent.mm.vfs.e.r(com.tencent.mm.plugin.subapp.c.h.bh(((cs)localObject1).field_imgPath, false), (String)localObject3) >= 0L)
            {
              parambi.ed((String)localObject2);
              au.Hx();
              com.tencent.mm.model.c.Fy().a(parambi.field_msgId, parambi);
            }
          }
        }
        if ((ah.bl(parambi.field_imgPath)) && (parama1 != null) && (!ah.bl(parama1.bFE)) && (parama1.dQv > 0) && (this.eBv == null))
        {
          localObject1 = com.tencent.mm.plugin.subapp.c.k.nR(q.Gj());
          localObject2 = com.tencent.mm.plugin.subapp.c.h.bh((String)localObject1, false);
          parambi.ed((String)localObject1);
          au.Hx();
          com.tencent.mm.model.c.Fy().a(parambi.field_msgId, parambi);
          parama = l.a((String)localObject2, parambi.field_msgId, parama.sdkVer, parama.appId, parama.bFE, parama.dQv);
          y.d("MicroMsg.ChattingItemVoiceRemindConfirm", "mediaId  " + parama.field_mediaSvrId);
          if (parama.field_mediaSvrId != null)
          {
            localObject1 = au.Dk();
            localObject2 = new am.3(this, parama);
            this.eBv = ((f)localObject2);
            ((p)localObject1).a(221, (f)localObject2);
            parama = new ac(parama);
            au.Dk().a(parama, 0);
          }
        }
        paramString.vGX.setOnClickListener(new am.4(this, parambi, parama1));
        paramString.igg.setTag(new aw(parambi, this.vko.cFE(), paramInt, null, '\000'));
        au.Hx();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
          paramString.igg.setOnLongClickListener(c(this.vko));
        }
        return;
        paramString.eXP.setText("");
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
    return paramInt == -1879048189;
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    return true;
  }
  
  public final boolean bfO()
  {
    return false;
  }
  
  protected final boolean cHb()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am
 * JD-Core Version:    0.7.0.1
 */