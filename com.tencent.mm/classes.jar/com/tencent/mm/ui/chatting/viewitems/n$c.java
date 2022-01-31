package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.e;

public final class n$c
  extends c
{
  private com.tencent.mm.ui.chatting.c.a vko;
  
  private static void a(n.a parama)
  {
    int i = parama.igg.getPaddingLeft();
    int j = parama.igg.getPaddingTop();
    int k = parama.igg.getPaddingRight();
    int m = parama.igg.getPaddingBottom();
    parama.igg.setBackgroundResource(R.g.c2c_chatto_done_bg);
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
      localObject = new t(paramLayoutInflater, R.i.chatting_item_to_appmsg_remittance);
      ((View)localObject).setTag(new n.a().dU((View)localObject));
    }
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
  {
    this.vko = parama1;
    n.a locala = (n.a)parama;
    parama = parambi.field_content;
    if (parama != null) {}
    for (parama = g.a.M(parama, parambi.field_reserved);; parama = null)
    {
      boolean bool;
      if (parama != null)
      {
        n.a.Y(locala.igg, locala.vBZ);
        locala.igg.setBackgroundResource(R.g.c2c_chatto_bg);
        locala.igg.setPadding(parama1.vtz.getContext().getResources().getDimensionPixelSize(R.f.MiddlePadding), 0, com.tencent.mm.cb.a.fromDPToPix(parama1.vtz.getContext(), 13), 0);
        locala.vDe.setSingleLine(true);
        paramString = new tu();
        paramString.cee.bQR = parama.dRH;
        com.tencent.mm.sdk.b.a.udP.m(paramString);
        bool = paramString.cef.ceg;
        if (paramString.cef.status == -2) {
          bool = false;
        }
        int j = paramString.cef.status;
        int i = j;
        if (j <= 0) {
          i = parama.dRE;
        }
        switch (i)
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
        parama = new aw(parambi, this.vko.cFE(), paramInt, null, '\000');
        locala.igg.setTag(parama);
        return;
        au.Hx();
        paramString = com.tencent.mm.model.c.Fw().abk(parambi.field_talker);
        if (paramString != null)
        {
          paramString = paramString.Bq();
          label391:
          if (!ah.bl(parama.dSO)) {
            break label492;
          }
          paramString = parama1.vtz.getMMResources().getString(R.l.chatting_item_appmsg_remittance_payer_title, new Object[] { ah.pm(paramString) });
          locala.vDe.setText(j.a(parama1.vtz.getContext(), paramString, locala.vDe.getTextSize()));
        }
        for (;;)
        {
          locala.vDf.setText(parama.dRF);
          locala.vDd.setImageResource(R.k.c2c_remittance_icon);
          break;
          paramString = parambi.field_talker;
          break label391;
          label492:
          paramString = j.b(parama1.vtz.getContext(), parama.dSO);
          locala.vDe.setText(paramString);
        }
        if (bool) {
          if (ah.bl(parama.dSO))
          {
            paramString = ae.getContext().getString(R.l.chatting_item_appmsg_remittance_accepted_payer);
            label547:
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
          break label547;
          locala.vDe.setText(R.l.chatting_item_appmsg_remittance_accpeted_receiver);
        }
        locala.vDf.setText(parama.dRF);
        locala.vDd.setImageResource(R.k.c2c_remittance_rejected_icon);
        if (bool) {
          if (ah.bl(parama.dSO))
          {
            parama = ae.getContext().getString(R.l.chatting_item_appmsg_remittance_rejected_payer);
            label700:
            locala.vDe.setText(j.b(parama1.vtz.getContext(), parama));
          }
        }
        for (;;)
        {
          a(locala);
          break;
          parama = ae.getContext().getString(R.l.chatting_item_appmsg_remittance_rejected_payer) + "-" + parama.dSO;
          break label700;
          locala.vDe.setText(R.l.chatting_item_appmsg_remittance_rejected);
        }
        if (bool) {
          if (ah.bl(parama.dSO))
          {
            paramString = ae.getContext().getString(R.l.chatting_item_appmsg_remittance_delay_confirm_payer);
            label806:
            locala.vDe.setText(j.b(parama1.vtz.getContext(), paramString));
          }
        }
        for (;;)
        {
          locala.vDf.setText(parama.dRF);
          locala.vDd.setImageResource(R.k.c2c_remittance_received_icon);
          a(locala);
          break;
          paramString = ae.getContext().getString(R.l.chatting_item_appmsg_remittance_delay_confirm_payer) + "-" + parama.dSO;
          break label806;
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
    String str = parambi.field_content;
    paramView = null;
    if (str != null) {
      paramView = g.a.M(str, parambi.field_reserved);
    }
    if (paramView != null)
    {
      paramContextMenu.add(i, 100, 0, this.vko.vtz.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
      if (paramView.dRE == 1) {
        paramContextMenu.add(i, 103, 0, this.vko.vtz.getMMResources().getString(R.l.span_remittance_resend));
      }
    }
    return false;
  }
  
  public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.c.a parama, final bi parambi)
  {
    switch (paramMenuItem.getItemId())
    {
    case 101: 
    case 102: 
    default: 
      return false;
    case 100: 
      com.tencent.mm.model.bd.bC(parambi.field_msgId);
      return true;
    }
    final String str = parambi.field_content;
    paramMenuItem = null;
    if (str != null) {
      paramMenuItem = g.a.M(str, parambi.field_reserved);
    }
    if (paramMenuItem != null)
    {
      str = paramMenuItem.dRG;
      parambi = parambi.field_talker;
      final int i = paramMenuItem.dRI;
      final int j = paramMenuItem.bXd;
      paramMenuItem = paramMenuItem.bHY;
      h.a(parama.vtz.getContext(), parama.vtz.getMMResources().getString(R.l.span_remittance_confirm_resend_msg), parama.vtz.getMMResources().getString(R.l.app_remind), parama.vtz.getMMResources().getString(R.l.span_remittance_resend), parama.vtz.getMMResources().getString(R.l.app_cancel), new DialogInterface.OnClickListener()new n.c.2
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("transaction_id", str);
          paramAnonymousDialogInterface.putExtra("receiver_name", parambi);
          paramAnonymousDialogInterface.putExtra("resend_msg_from_flag", 2);
          paramAnonymousDialogInterface.putExtra("invalid_time", i);
          paramAnonymousDialogInterface.putExtra("total_fee", j);
          paramAnonymousDialogInterface.putExtra("fee_type", paramMenuItem);
          if (q.Gw())
          {
            d.b(parama.vtz.getContext(), "wallet_payu", ".remittance.ui.PayURemittanceResendMsgUI", paramAnonymousDialogInterface);
            return;
          }
          d.b(parama.vtz.getContext(), "remittance", ".ui.RemittanceResendMsgUI", paramAnonymousDialogInterface);
        }
      }, new n.c.2(this));
    }
    return true;
  }
  
  public final boolean au(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 419430449);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    boolean bool = false;
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
        y.w("MicroMsg.ChattingItemAppMsgRemittanceTo", "Unrecognized type %d, probably version to low & check update!", new Object[] { Integer.valueOf(paramView.dRE) });
        ah.bV(parama.vtz.getContext());
      }
    }
    for (;;)
    {
      bool = true;
      return bool;
      ((Intent)localObject).putExtra("invalid_time", paramView.dRI);
      ((Intent)localObject).putExtra("is_sender", true);
      ((Intent)localObject).putExtra("appmsg_type", paramView.dRE);
      ((Intent)localObject).putExtra("transfer_id", paramView.dRH);
      ((Intent)localObject).putExtra("transaction_id", paramView.dRG);
      ((Intent)localObject).putExtra("effective_date", paramView.dRJ);
      ((Intent)localObject).putExtra("total_fee", paramView.bXd);
      ((Intent)localObject).putExtra("fee_type", paramView.bHY);
      paramView = new n.c.3(this, parama);
      if (q.Gw())
      {
        d.a(parama.vtx, "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", (Intent)localObject, 221, paramView);
      }
      else
      {
        d.a(parama.vtx, "remittance", ".ui.RemittanceDetailUI", (Intent)localObject, 221, paramView);
        continue;
        ((Intent)localObject).putExtra("appmsg_type", paramView.dRE);
        ((Intent)localObject).putExtra("transfer_id", paramView.dRH);
        ((Intent)localObject).putExtra("transaction_id", paramView.dRG);
        ((Intent)localObject).putExtra("effective_date", paramView.dRJ);
        ((Intent)localObject).putExtra("total_fee", paramView.bXd);
        ((Intent)localObject).putExtra("fee_type", paramView.bHY);
        if (q.Gw()) {
          d.b(parama.vtz.getContext(), "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", (Intent)localObject);
        } else {
          d.b(parama.vtz.getContext(), "remittance", ".ui.RemittanceDetailUI", (Intent)localObject);
        }
      }
    }
  }
  
  public final boolean bfO()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.n.c
 * JD-Core Version:    0.7.0.1
 */