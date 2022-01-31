package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.cj.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.b.b.af;
import com.tencent.mm.ui.chatting.b.b.ai;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class al$a
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
      localObject = new t(paramLayoutInflater, R.i.chatting_item_from_voice);
      ((View)localObject).setTag(new al.c().b((View)localObject, true, this.vgB));
    }
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
  {
    this.vko = parama1;
    al.c localc = (al.c)parama;
    localc.vGu.setFromVoice(true);
    localc.vGu.setFromGroup(parama1.cFE());
    g localg = (g)parama1.ac(g.class);
    a(localg, parambi.field_msgId);
    al.c.a(localc, parambi, paramInt, parama1, true, c(parama1));
    paramString = null;
    parama = ChattingItemTranslate.b.vGa;
    Object localObject = (af)parama1.ac(af.class);
    if (al.c(parambi, parama1))
    {
      localObject = ((af)localObject).E(parambi.field_msgId, parambi.field_imgPath);
      paramString = (String)localObject;
      if (!bk.bl((String)localObject))
      {
        parama = ChattingItemTranslate.b.vGd;
        paramString = (String)localObject;
      }
      if ((bk.bl(paramString)) && (parama == ChattingItemTranslate.b.vGa)) {
        break label418;
      }
      if (localc.vFR == null)
      {
        localc.vFR = ((ChattingItemTranslate)localc.vFQ.inflate());
        localc.vFR.setMinimumWidth(localc.vGr - com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 5));
        localc.vFR.init();
      }
      localc.vFR.a(paramString, parama);
      if (!bk.bl(paramString))
      {
        parama = new ChattingItemTranslate.a(parambi, parama1.cFE(), paramInt);
        parama.ivk = 2;
        localc.vFR.setTag(parama);
        localc.vFR.setOnTouchListener(localg.cDu());
        localc.vFR.setOnDoubleClickListener(new al.a.1(this, paramString, parambi));
        localc.vFR.setOnLongClickListener(c(parama1));
        localc.vFR.setVisibility(0);
      }
      label308:
      parama = new n(parambi.field_content);
      if (parama.time != 0L) {
        break label439;
      }
      localc.vBa.setVisibility(8);
    }
    for (;;)
    {
      parama = parambi.cQF;
      if ((parama != null) && (parama.length() != 0)) {
        break label625;
      }
      localc.vBz.setVisibility(8);
      return;
      if (!((af)localObject).hU(parambi.field_msgId)) {
        break;
      }
      paramString = ((af)localObject).E(parambi.field_msgId, parambi.field_imgPath);
      parama = ((af)localObject).hT(parambi.field_msgId);
      break;
      label418:
      if (localc.vFR == null) {
        break label308;
      }
      localc.vFR.setVisibility(8);
      break label308;
      label439:
      paramString = ((ai)parama1.ac(ai.class)).cFx();
      if (((paramString != null) && (paramString.vhz == parambi.field_msgId)) || (com.tencent.mm.modelvoice.q.F(parambi)))
      {
        paramInt = 1;
        label484:
        paramString = localc.vBa;
        if (paramInt == 0) {
          break label564;
        }
      }
      label564:
      for (int i = 8;; i = 0)
      {
        paramString.setVisibility(i);
        i = (int)com.tencent.mm.modelvoice.q.ck(parama.time);
        if (paramInt != 0) {
          break label570;
        }
        localc.vGt.setContentDescription(String.format(parama1.vtz.getContext().getString(R.l.voice_msg_unread_desc), new Object[] { Integer.valueOf(i) }));
        break;
        paramInt = 0;
        break label484;
      }
      label570:
      parama = ((com.tencent.mm.ui.chatting.b.b.e)parama1.ac(com.tencent.mm.ui.chatting.b.b.e.class)).adr(parama1.getTalkerUserName());
      paramString = a.a.cAj();
      localObject = localc.vGt;
      if (parama != null) {
        parama.toString();
      }
      paramString.S((View)localObject, i);
    }
    label625:
    localc.vBz.setVisibility(0);
    b(parama1, localc.vBz, aw.adO(parama));
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    au.Hx();
    if (com.tencent.mm.model.c.isSDCardAvailable())
    {
      Object localObject = (ChattingItemTranslate.a)paramView.getTag();
      int m = ((ChattingItemTranslate.a)localObject).position;
      if (((ChattingItemTranslate.a)localObject).ivk == 1)
      {
        int i;
        label187:
        label236:
        int k;
        if (((new n(parambi.field_content).time != 0L) || (parambi.field_isSend != 0)) && ((parambi.field_status != 1) || (parambi.field_isSend != 1)))
        {
          au.Hx();
          Boolean localBoolean = (Boolean)com.tencent.mm.model.c.Dz().get(26, null);
          localObject = localBoolean;
          if (localBoolean == null) {
            localObject = Boolean.valueOf(false);
          }
          if (!((Boolean)localObject).booleanValue()) {
            break label443;
          }
          paramContextMenu.add(m, 120, 0, R.l.chatfooter_SpeakerOff);
          au.Hx();
          localObject = com.tencent.mm.model.c.Fw().abl(parambi.field_talker);
          if ((s.hx(parambi.field_talker)) || (s.hU(parambi.field_talker)) || (localObject == null) || (((ad)localObject).cua())) {
            break label461;
          }
          i = 1;
          if (com.tencent.mm.br.d.SP("favorite")) {
            paramContextMenu.add(m, 116, 0, paramView.getContext().getString(R.l.plugin_favorite_opt));
          }
          if (i != 0)
          {
            if (com.tencent.mm.ai.z.My().io(2) <= 0) {
              break label467;
            }
            i = 1;
            if ((i != 0) && (!this.vko.cFF())) {
              paramContextMenu.add(m, 114, 0, paramView.getContext().getString(R.l.chatting_long_click_brand_service));
            }
          }
          localObject = (af)this.vko.ac(af.class);
          k = 0;
          if (!al.c(parambi, this.vko)) {
            break label481;
          }
          if (bk.bl(((af)localObject).E(parambi.field_msgId, parambi.field_imgPath))) {
            break label473;
          }
          i = R.l.chatting_long_click_menu_switch_voice_trans;
        }
        for (;;)
        {
          int j = k;
          if (s.hl(parambi.field_talker))
          {
            j = k;
            if (x.cqF())
            {
              j = k;
              if (i != -1)
              {
                paramContextMenu.add(m, 121, 0, i);
                j = 1;
              }
            }
          }
          if (!this.vko.cFF()) {
            paramContextMenu.add(m, 100, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_delete_voice));
          }
          if ((j == 0) && (x.cqF()) && (i != -1)) {
            paramContextMenu.add(m, 121, 0, i);
          }
          return true;
          label443:
          paramContextMenu.add(m, 119, 0, R.l.chatfooter_SpeakerON);
          break;
          label461:
          i = 0;
          break label187;
          label467:
          i = 0;
          break label236;
          label473:
          i = R.l.chatting_long_click_menu_voice_trans;
          continue;
          label481:
          if (((af)localObject).hU(parambi.field_msgId)) {
            i = R.l.chatting_long_click_menu_stop_voice_trans;
          } else {
            i = R.l.chatting_long_click_menu_voice_trans;
          }
        }
      }
      if (((ChattingItemTranslate.a)localObject).ivk == 2)
      {
        paramContextMenu.add(m, 141, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_copy_msg));
        paramContextMenu.add(m, 142, 0, paramView.getContext().getString(R.l.retransmit));
        if (com.tencent.mm.br.d.SP("favorite")) {
          paramContextMenu.add(m, 143, 0, paramView.getContext().getString(R.l.plugin_favorite_opt));
        }
        return false;
      }
    }
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.c.a parama, final bi parambi)
  {
    Object localObject = (af)parama.ac(af.class);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return false;
      ((ai)parama.ac(ai.class)).no(true);
      return true;
      ((ai)parama.ac(ai.class)).no(false);
      return true;
      al.e(parama, parambi);
      if (((af)localObject).cFt()) {
        h.a(parama.vtz.getContext(), parama.vtz.getContext().getString(R.l.voice_trans_text_tips), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            com.tencent.mm.modelvoice.q.H(parambi);
            this.vGp.cFu();
            this.vGp.e(parambi, true);
          }
        });
      }
      for (;;)
      {
        b.eBD.A(parambi);
        return true;
        com.tencent.mm.modelvoice.q.H(parambi);
        ((af)localObject).e(parambi, true);
      }
      paramMenuItem = (ClipboardManager)parama.vtz.getContext().getSystemService("clipboard");
      parama = ((af)localObject).E(parambi.field_msgId, parambi.field_imgPath);
      if (!bk.bl(parama)) {
        paramMenuItem.setText(parama);
      }
      al.e(8, parambi);
      continue;
      paramMenuItem = new Intent(parama.vtz.getContext(), MsgRetransmitUI.class);
      localObject = ((af)localObject).E(parambi.field_msgId, parambi.field_imgPath);
      if (parambi.cvi())
      {
        paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
        paramMenuItem.putExtra("Retr_Msg_Type", 6);
      }
      for (;;)
      {
        parama.startActivity(paramMenuItem);
        al.e(9, parambi);
        break;
        paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
        paramMenuItem.putExtra("Retr_Msg_Type", 4);
      }
      localObject = ((af)localObject).E(parambi.field_msgId, parambi.field_imgPath);
      paramMenuItem = new cj();
      com.tencent.mm.pluginsdk.model.e.b(paramMenuItem, (String)localObject, 1);
      paramMenuItem.bIw.uD = parama.vtz;
      paramMenuItem.bIw.bID = 43;
      if (paramMenuItem.bIw.bIy != null)
      {
        parama = paramMenuItem.bIw.bIy.sXa;
        if (parama != null)
        {
          parama.Yq(parambi.field_talker);
          parama.Yr(com.tencent.mm.model.q.Gj());
          com.tencent.mm.sdk.b.a.udP.m(paramMenuItem);
        }
      }
      for (;;)
      {
        al.e(10, parambi);
        break;
        y.e("MicroMsg.ChattingItemVoice", "alvinluo transform text fav failed");
      }
      ((ai)parama.ac(ai.class)).bc(parambi);
      continue;
      ((ai)parama.ac(ai.class)).bd(parambi);
    }
  }
  
  public final boolean au(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 34);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    paramView = (aw)paramView.getTag();
    b.eBD.z(paramView.bWO);
    al.a(parama, paramView);
    return true;
  }
  
  protected final boolean b(com.tencent.mm.ui.chatting.c.a parama)
  {
    return parama.cFE();
  }
  
  public final boolean bfO()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.al.a
 * JD-Core Version:    0.7.0.1
 */