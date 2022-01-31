package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.cj.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.b.b.af;
import com.tencent.mm.ui.chatting.b.b.ai;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.t.m;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class al$b
  extends c
  implements t.m
{
  private int sbm = 3;
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
      localObject = new t(paramLayoutInflater, R.i.chatting_item_to_voice);
      ((View)localObject).setTag(new al.c().b((View)localObject, false, this.vgB));
    }
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    ((ai)parama.ac(ai.class)).bd(parambi);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
  {
    this.vko = parama1;
    al.c localc = (al.c)parama;
    localc.vGu.setFromVoice(false);
    localc.vGu.setFromGroup(parama1.cFE());
    g localg = (g)parama1.ac(g.class);
    a(localg, parambi.field_msgId);
    al.c.a(localc, parambi, paramInt, parama1, false, c(parama1));
    Object localObject = (af)parama1.ac(af.class);
    paramString = null;
    parama = ChattingItemTranslate.b.vGa;
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
        break label455;
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
        localc.vFR.setOnDoubleClickListener(new al.b.1(this, paramString, parambi));
        localc.vFR.setOnLongClickListener(c(parama1));
        localc.vFR.setVisibility(0);
      }
      label308:
      if (!cHc()) {
        break label562;
      }
      if (localc.vGz != null) {
        localc.vGz.setVisibility(8);
      }
      if (localc.vBN != null) {
        localc.vBN.setVisibility(8);
      }
      if ((parambi.field_status != 1) && (parambi.field_status != 5)) {
        break label476;
      }
      localc.vGA.setBackgroundResource(R.g.chatto_bg_alpha);
      parambi.uBR = true;
    }
    for (;;)
    {
      a(paramInt, localc, parambi, parama1.cFB(), parama1.cFE(), parama1, this);
      return;
      if (!((af)localObject).hU(parambi.field_msgId)) {
        break;
      }
      paramString = ((af)localObject).E(parambi.field_msgId, parambi.field_imgPath);
      parama = ((af)localObject).hT(parambi.field_msgId);
      break;
      label455:
      if (localc.vFR == null) {
        break label308;
      }
      localc.vFR.setVisibility(8);
      break label308;
      label476:
      localc.vGA.setBackgroundResource(R.g.chatto_bg);
      if ((localc.vBN != null) && (a(localg, parambi.field_msgId)))
      {
        if (parambi.uBR)
        {
          parama = new AlphaAnimation(0.5F, 1.0F);
          parama.setDuration(300L);
          localc.vGA.startAnimation(parama);
          parambi.uBR = false;
        }
        localc.vBN.setVisibility(0);
        continue;
        label562:
        if (localc.vGz != null)
        {
          localc.vGz.setVisibility(0);
          if (parambi.field_status >= 2) {
            localc.vGz.setVisibility(8);
          }
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    au.Hx();
    Object localObject;
    int k;
    af localaf;
    int i;
    if (com.tencent.mm.model.c.isSDCardAvailable())
    {
      localObject = (ChattingItemTranslate.a)paramView.getTag();
      k = ((ChattingItemTranslate.a)localObject).position;
      if (((ChattingItemTranslate.a)localObject).ivk != 1) {
        break label494;
      }
      localObject = new n(parambi.field_content);
      if (((((n)localObject).time != 0L) || (parambi.field_isSend != 0)) && ((parambi.field_status != 1) || (parambi.field_isSend != 1)))
      {
        if (!((ai)this.vko.ac(ai.class)).cFz()) {
          break label438;
        }
        paramContextMenu.add(k, 120, 0, R.l.chatfooter_SpeakerOff);
      }
      if (parambi.field_status == 5) {
        paramContextMenu.add(k, 103, 0, paramView.getContext().getString(R.l.chatting_resend_title));
      }
      if (d.SP("favorite")) {
        paramContextMenu.add(k, 116, 0, paramView.getContext().getString(R.l.plugin_favorite_opt));
      }
      if ((!parambi.ctz()) && (parambi.ctA()) && ((parambi.field_status == 2) || (parambi.cQJ == 1)) && (a(parambi, this.vko)) && (adG(parambi.field_talker))) {
        paramContextMenu.add(k, 123, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_revoke_msg));
      }
      localaf = (af)this.vko.ac(af.class);
      if (!al.c(parambi, this.vko)) {
        break label464;
      }
      if (bk.bl(localaf.E(parambi.field_msgId, parambi.field_imgPath))) {
        break label456;
      }
      i = R.l.chatting_long_click_menu_switch_voice_trans;
      label301:
      if ((!s.hl(parambi.field_talker)) || (!x.cqF()) || (i == -1)) {
        break label583;
      }
      paramContextMenu.add(k, 121, 0, i);
    }
    label438:
    label583:
    for (int j = 1;; j = 0)
    {
      if (((((n)localObject).time != 0L) || (parambi.field_isSend != 0)) && ((parambi.field_status != 1) || (parambi.field_isSend != 1)) && (!this.vko.cFF())) {
        paramContextMenu.add(k, 100, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_delete_voice));
      }
      if ((j == 0) && (x.cqF()) && (i != -1)) {
        paramContextMenu.add(k, 121, 0, i);
      }
      label456:
      label464:
      label494:
      do
      {
        return true;
        paramContextMenu.add(k, 119, 0, R.l.chatfooter_SpeakerON);
        break;
        i = R.l.chatting_long_click_menu_voice_trans;
        break label301;
        if (localaf.hU(parambi.field_msgId))
        {
          i = R.l.chatting_long_click_menu_stop_voice_trans;
          break label301;
        }
        i = R.l.chatting_long_click_menu_voice_trans;
        break label301;
      } while (((ChattingItemTranslate.a)localObject).ivk != 2);
      paramContextMenu.add(k, 141, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_copy_msg));
      paramContextMenu.add(k, 142, 0, paramView.getContext().getString(R.l.retransmit));
      if (d.SP("favorite")) {
        paramContextMenu.add(k, 143, 0, paramView.getContext().getString(R.l.plugin_favorite_opt));
      }
      return false;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
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
        h.a(parama.vtz.getContext(), parama.vtz.getContext().getString(R.l.voice_trans_text_tips), "", new al.b.2(this, (af)localObject, parambi));
      }
      for (;;)
      {
        b.eBD.A(parambi);
        return true;
        ((af)localObject).e(parambi, true);
      }
      paramMenuItem = (ClipboardManager)parama.vtz.getContext().getSystemService("clipboard");
      parama = ((af)localObject).E(parambi.field_msgId, parambi.field_imgPath);
      if (!bk.bl(parama)) {
        paramMenuItem.setText(parama);
      }
      al.e(8, parambi);
      return true;
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
        return true;
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
          parama.Yq(q.Gj());
          parama.Yr(parambi.field_talker);
          com.tencent.mm.sdk.b.a.udP.m(paramMenuItem);
        }
      }
      for (;;)
      {
        al.e(10, parambi);
        return true;
        y.e("MicroMsg.ChattingItemVoice", "alvinluo transform text fav failed");
      }
      ((ai)parama.ac(ai.class)).bc(parambi);
      continue;
      ((ai)parama.ac(ai.class)).bd(parambi);
    }
  }
  
  public final boolean au(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 34);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    paramView = (aw)paramView.getTag();
    b.eBD.z(paramView.bWO);
    al.a(parama, paramView);
    return true;
  }
  
  public final boolean bfO()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.al.b
 * JD-Core Version:    0.7.0.1
 */