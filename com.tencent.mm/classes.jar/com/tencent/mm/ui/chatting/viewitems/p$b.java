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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.i;
import com.tencent.mm.af.j.b;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.a.vq.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.h;

public final class p$b
  extends c
{
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  private static void a(p.a parama)
  {
    AppMethodBeat.i(32989);
    int i = parama.jYu.getPaddingLeft();
    int j = parama.jYu.getPaddingTop();
    int k = parama.jYu.getPaddingRight();
    int m = parama.jYu.getPaddingBottom();
    parama.jYu.setBackgroundResource(2130838064);
    parama.jYu.setPadding(i, j, k, m);
    AppMethodBeat.o(32989);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(32987);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969073);
      ((View)localObject).setTag(new p.a().fg((View)localObject));
    }
    AppMethodBeat.o(32987);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(32988);
    this.zzP = parama1;
    p.a locala = (p.a)parama;
    parama = parambi.field_content;
    if (parama != null) {}
    for (paramString = j.b.ab(parama, parambi.field_reserved);; paramString = null)
    {
      int i;
      if (paramString != null)
      {
        p.a.ar(locala.jYu, locala.zSN);
        locala.jYu.setBackgroundResource(2130838059);
        locala.jYu.setPadding(com.tencent.mm.cb.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ah.getContext(), 13), 0, parama1.zJz.getContext().getResources().getDimensionPixelOffset(2131428207), 0);
        locala.zUo.setSingleLine(true);
        parama = new vq();
        parama.cMS.cyr = paramString.fhG;
        com.tencent.mm.sdk.b.a.ymk.l(parama);
        if (parama.cMT.cMU) {
          break label362;
        }
        i = 1;
        if (parama.cMT.status == -2) {
          i = 0;
        }
        int k = parama.cMT.status;
        int j = k;
        if (k <= 0) {
          j = paramString.fhD;
        }
        switch (j)
        {
        case 2: 
        default: 
          locala.zUn.setImageResource(2131231059);
          locala.zUo.setSingleLine(false);
          locala.zUo.setMaxLines(2);
          locala.zUp.setText(null);
          locala.zUo.setText(paramString.description);
        }
      }
      for (;;)
      {
        locala.jYu.setOnClickListener(d(parama1));
        locala.jYu.setOnLongClickListener(c(parama1));
        locala.jYu.setOnTouchListener(((h)parama1.ay(h.class)).dHi());
        parama = new az(parambi, parama1.dJG(), paramInt, null, '\000');
        locala.jYu.setTag(parama);
        AppMethodBeat.o(32988);
        return;
        label362:
        i = 0;
        break;
        parama = (i)paramString.R(i.class);
        if (com.tencent.mm.platformtools.ah.isNullOrNil(paramString.fiN))
        {
          if (bo.hl(parama.fgo, 1)) {
            locala.zUo.setText(com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131298209) + com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131298210));
          }
          for (;;)
          {
            locala.zUp.setText(paramString.fhE);
            locala.zUn.setImageResource(2131231059);
            break;
            locala.zUo.setText(2131298209);
          }
        }
        if (bo.hl(parama.fgo, 1)) {
          if (paramString.fiN.length() > 5) {
            parama = paramString.fiN.substring(0, 5) + "..." + com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131298210);
          }
        }
        label548:
        for (parama = j.b(parama1.zJz.getContext(), parama);; parama = j.b(parama1.zJz.getContext(), paramString.fiN))
        {
          locala.zUo.setText(parama);
          break;
          parama = paramString.fiN + parama1.zJz.getContext().getString(2131298210);
          break label548;
        }
        if (i != 0) {
          if (bo.hl(((i)paramString.R(i.class)).fgo, 1)) {
            if (com.tencent.mm.platformtools.ah.isNullOrNil(paramString.fiN))
            {
              parama = com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131298199) + com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131298210);
              label700:
              locala.zUo.setText(j.b(parama1.zJz.getContext(), parama));
            }
          }
        }
        for (;;)
        {
          locala.zUp.setText(paramString.fhE);
          locala.zUn.setImageResource(2131231060);
          a(locala);
          break;
          String str = com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131298199) + "-" + paramString.fiN;
          parama = str;
          if (str.length() <= 5) {
            break label700;
          }
          parama = str.substring(0, 5) + "..." + com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131298210);
          break label700;
          if (com.tencent.mm.platformtools.ah.isNullOrNil(paramString.fiN))
          {
            parama = com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131298199);
            break label700;
          }
          parama = com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131298199) + "-" + paramString.fiN;
          break label700;
          locala.zUo.setText(2131298200);
        }
        locala.zUp.setText(paramString.fhE);
        locala.zUn.setImageResource(2131231061);
        if (i != 0) {
          if (com.tencent.mm.platformtools.ah.isNullOrNil(paramString.fiN))
          {
            parama = com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131298212);
            label971:
            locala.zUo.setText(j.b(parama1.zJz.getContext(), parama));
          }
        }
        for (;;)
        {
          a(locala);
          break;
          parama = com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131298212) + "-" + paramString.fiN;
          break label971;
          locala.zUo.setText(2131298211);
        }
        locala.zUp.setText(paramString.fhE);
        locala.zUn.setImageResource(2131231060);
        if (i != 0) {
          if (com.tencent.mm.platformtools.ah.isNullOrNil(paramString.fiN))
          {
            parama = com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131298206);
            label1102:
            locala.zUo.setText(j.b(parama1.zJz.getContext(), parama));
          }
        }
        for (;;)
        {
          a(locala);
          break;
          parama = com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131298206) + "-" + paramString.fiN;
          break label1102;
          locala.zUo.setText(2131298207);
        }
        locala.zUo.setText(2131298201);
        locala.zUp.setText(paramString.fhE);
        locala.zUn.setImageResource(2131231058);
        a(locala);
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(32990);
    int i = ((az)paramView.getTag()).position;
    if (parambi != null) {
      paramContextMenu.add(i, 100, 0, this.zzP.zJz.getMMResources().getString(2131298232));
    }
    AppMethodBeat.o(32990);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(32991);
    paramMenuItem.getItemId();
    AppMethodBeat.o(32991);
    return false;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 419430449);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(32992);
    Object localObject = parambi.field_content;
    paramView = null;
    if (localObject != null) {
      paramView = j.b.ab((String)localObject, parambi.field_reserved);
    }
    if (paramView != null)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("sender_name", parambi.field_talker);
      switch (paramView.fhD)
      {
      case 2: 
      default: 
        ab.w("MicroMsg.ChattingItemAppMsgRemittanceFrom", "Unrecognized type %d, probably version to low & check update!", new Object[] { Integer.valueOf(paramView.fhD) });
        com.tencent.mm.platformtools.ah.cC(parama.zJz.getContext());
      }
      for (;;)
      {
        AppMethodBeat.o(32992);
        return true;
        ((Intent)localObject).putExtra("invalid_time", paramView.fhH);
        ((Intent)localObject).putExtra("is_sender", false);
        ((Intent)localObject).putExtra("appmsg_type", paramView.fhD);
        ((Intent)localObject).putExtra("transfer_id", paramView.fhG);
        ((Intent)localObject).putExtra("transaction_id", paramView.fhF);
        ((Intent)localObject).putExtra("effective_date", paramView.fhI);
        ((Intent)localObject).putExtra("total_fee", paramView.cEW);
        ((Intent)localObject).putExtra("fee_type", paramView.cpp);
        if (r.ZB())
        {
          d.a(parama.zJz, "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", (Intent)localObject, 221);
        }
        else
        {
          d.a(parama.zJz, "remittance", ".ui.RemittanceDetailUI", (Intent)localObject, 221);
          continue;
          ((Intent)localObject).putExtra("is_sender", true);
          ((Intent)localObject).putExtra("appmsg_type", paramView.fhD);
          ((Intent)localObject).putExtra("transfer_id", paramView.fhG);
          ((Intent)localObject).putExtra("transaction_id", paramView.fhF);
          ((Intent)localObject).putExtra("effective_date", paramView.fhI);
          ((Intent)localObject).putExtra("total_fee", paramView.cEW);
          ((Intent)localObject).putExtra("fee_type", paramView.cpp);
          if (r.ZB()) {
            d.b(parama.zJz.getContext(), "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", (Intent)localObject);
          } else {
            d.b(parama.zJz.getContext(), "remittance", ".ui.RemittanceDetailUI", (Intent)localObject);
          }
        }
      }
    }
    AppMethodBeat.o(32992);
    return false;
  }
  
  public final boolean dLp()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.p.b
 * JD-Core Version:    0.7.0.1
 */