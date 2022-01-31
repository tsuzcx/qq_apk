package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.tu;
import com.tencent.mm.h.a.tu.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.e;

public final class n$b
  extends c
{
  private com.tencent.mm.ui.chatting.c.a vko;
  
  private static void a(n.a parama)
  {
    int i = parama.igg.getPaddingLeft();
    int j = parama.igg.getPaddingTop();
    int k = parama.igg.getPaddingRight();
    int m = parama.igg.getPaddingBottom();
    parama.igg.setBackgroundResource(R.g.c2c_chatfrom_done_bg);
    parama.igg.setPadding(i, j, k, m);
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
      localObject = new t(paramLayoutInflater, R.i.chatting_item_from_appmsg_remittance);
      ((View)localObject).setTag(new n.a().dU((View)localObject));
    }
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
  {
    int i = 1;
    this.vko = parama1;
    n.a locala = (n.a)parama;
    parama = parambi.field_content;
    if (parama != null) {}
    for (parama = g.a.M(parama, parambi.field_reserved);; parama = null)
    {
      if (parama != null)
      {
        n.a.Y(locala.igg, locala.vBZ);
        locala.igg.setBackgroundResource(R.g.c2c_chatfrom_bg);
        locala.igg.setPadding(com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 13), 0, parama1.vtz.getContext().getResources().getDimensionPixelOffset(R.f.chattingBubblepadding), 0);
        locala.vDe.setSingleLine(true);
        paramString = new tu();
        paramString.cee.bQR = parama.dRH;
        com.tencent.mm.sdk.b.a.udP.m(paramString);
        if (paramString.cef.ceg) {
          break label357;
        }
        if (paramString.cef.status == -2) {
          i = 0;
        }
        int k = paramString.cef.status;
        int j = k;
        if (k <= 0) {
          j = parama.dRE;
        }
        switch (j)
        {
        case 2: 
        default: 
          locala.vDd.setImageResource(R.k.c2c_remittance_icon);
          locala.vDe.setSingleLine(false);
          locala.vDe.setMaxLines(2);
          locala.vDf.setText(null);
          locala.vDe.setText(parama.description);
        }
      }
      for (;;)
      {
        locala.igg.setOnClickListener(d(parama1));
        locala.igg.setOnLongClickListener(c(parama1));
        locala.igg.setOnTouchListener(((g)parama1.ac(g.class)).cDu());
        parama = new aw(parambi, parama1.cFE(), paramInt, null, '\000');
        locala.igg.setTag(parama);
        return;
        label357:
        i = 0;
        break;
        if (ah.bl(parama.dSO)) {
          locala.vDe.setText(R.l.chatting_item_appmsg_remittance_receiver_title);
        }
        for (;;)
        {
          locala.vDf.setText(parama.dRF);
          locala.vDd.setImageResource(R.k.c2c_remittance_icon);
          break;
          paramString = j.b(parama1.vtz.getContext(), parama.dSO);
          locala.vDe.setText(paramString);
        }
        if (i != 0) {
          if (ah.bl(parama.dSO))
          {
            paramString = ae.getContext().getString(R.l.chatting_item_appmsg_remittance_accepted_payer);
            label465:
            locala.vDe.setText(j.b(parama1.vtz.getContext(), paramString));
          }
        }
        for (;;)
        {
          locala.vDf.setText(parama.dRF);
          locala.vDd.setImageResource(R.k.c2c_remittance_received_icon);
          a(locala);
          break;
          paramString = ae.getContext().getString(R.l.chatting_item_appmsg_remittance_accepted_payer) + "-" + parama.dSO;
          break label465;
          locala.vDe.setText(R.l.chatting_item_appmsg_remittance_accpeted_receiver);
        }
        locala.vDf.setText(parama.dRF);
        locala.vDd.setImageResource(R.k.c2c_remittance_rejected_icon);
        if (i != 0) {
          if (ah.bl(parama.dSO))
          {
            parama = ae.getContext().getString(R.l.chatting_item_appmsg_remittance_rejected_payer);
            label618:
            locala.vDe.setText(j.b(parama1.vtz.getContext(), parama));
          }
        }
        for (;;)
        {
          a(locala);
          break;
          parama = ae.getContext().getString(R.l.chatting_item_appmsg_remittance_rejected_payer) + "-" + parama.dSO;
          break label618;
          locala.vDe.setText(R.l.chatting_item_appmsg_remittance_rejected);
        }
        locala.vDf.setText(parama.dRF);
        locala.vDd.setImageResource(R.k.c2c_remittance_received_icon);
        if (i != 0) {
          if (ah.bl(parama.dSO))
          {
            parama = ae.getContext().getString(R.l.chatting_item_appmsg_remittance_delay_confirm_payer);
            label746:
            locala.vDe.setText(j.b(parama1.vtz.getContext(), parama));
          }
        }
        for (;;)
        {
          a(locala);
          break;
          parama = ae.getContext().getString(R.l.chatting_item_appmsg_remittance_delay_confirm_payer) + "-" + parama.dSO;
          break label746;
          locala.vDe.setText(R.l.chatting_item_appmsg_remittance_delay_confirm_receiver);
        }
        locala.vDe.setText(R.l.chatting_item_appmsg_remittance_cancel);
        locala.vDf.setText(parama.dRF);
        locala.vDd.setImageResource(R.k.c2c_remittance_cancle_icon);
        a(locala);
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    int i = ((aw)paramView.getTag()).position;
    if (parambi != null) {
      paramContextMenu.add(i, 100, 0, this.vko.vtz.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
    }
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
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
    return (!paramBoolean) && (paramInt == 419430449);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    Object localObject = parambi.field_content;
    paramView = null;
    if (localObject != null) {
      paramView = g.a.M((String)localObject, parambi.field_reserved);
    }
    if (paramView != null)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("sender_name", parambi.field_talker);
      switch (paramView.dRE)
      {
      case 2: 
      default: 
        y.w("MicroMsg.ChattingItemAppMsgRemittanceFrom", "Unrecognized type %d, probably version to low & check update!", new Object[] { Integer.valueOf(paramView.dRE) });
        ah.bV(parama.vtz.getContext());
        return true;
      case 1: 
      case 7: 
        ((Intent)localObject).putExtra("invalid_time", paramView.dRI);
        ((Intent)localObject).putExtra("is_sender", false);
        ((Intent)localObject).putExtra("appmsg_type", paramView.dRE);
        ((Intent)localObject).putExtra("transfer_id", paramView.dRH);
        ((Intent)localObject).putExtra("transaction_id", paramView.dRG);
        ((Intent)localObject).putExtra("effective_date", paramView.dRJ);
        ((Intent)localObject).putExtra("total_fee", paramView.bXd);
        ((Intent)localObject).putExtra("fee_type", paramView.bHY);
        if (q.Gw())
        {
          d.a(parama.vtz, "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", (Intent)localObject, 221);
          return true;
        }
        d.a(parama.vtz, "remittance", ".ui.RemittanceDetailUI", (Intent)localObject, 221);
        return true;
      }
      ((Intent)localObject).putExtra("is_sender", true);
      ((Intent)localObject).putExtra("appmsg_type", paramView.dRE);
      ((Intent)localObject).putExtra("transfer_id", paramView.dRH);
      ((Intent)localObject).putExtra("transaction_id", paramView.dRG);
      ((Intent)localObject).putExtra("effective_date", paramView.dRJ);
      ((Intent)localObject).putExtra("total_fee", paramView.bXd);
      ((Intent)localObject).putExtra("fee_type", paramView.bHY);
      if (q.Gw())
      {
        d.b(parama.vtz.getContext(), "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", (Intent)localObject);
        return true;
      }
      d.b(parama.vtz.getContext(), "remittance", ".ui.RemittanceDetailUI", (Intent)localObject);
      return true;
    }
    return false;
  }
  
  public final boolean bfO()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.n.b
 * JD-Core Version:    0.7.0.1
 */