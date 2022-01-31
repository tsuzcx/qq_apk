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
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.h;

public final class p$c
  extends c
{
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  private static void a(p.a parama)
  {
    AppMethodBeat.i(32996);
    int i = parama.jYu.getPaddingLeft();
    int j = parama.jYu.getPaddingTop();
    int k = parama.jYu.getPaddingRight();
    int m = parama.jYu.getPaddingBottom();
    parama.jYu.setBackgroundResource(2130838070);
    parama.jYu.setPadding(i, j, k, m);
    AppMethodBeat.o(32996);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(32994);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969111);
      ((View)localObject).setTag(new p.a().fg((View)localObject));
    }
    AppMethodBeat.o(32994);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(32995);
    this.zzP = parama1;
    p.a locala = (p.a)parama;
    parama = parambi.field_content;
    if (parama != null) {}
    label392:
    label905:
    for (paramString = j.b.ab(parama, parambi.field_reserved);; paramString = null)
    {
      boolean bool;
      int i;
      if (paramString != null)
      {
        p.a.ar(locala.jYu, locala.zSN);
        locala.jYu.setBackgroundResource(2130838065);
        locala.jYu.setPadding(parama1.zJz.getContext().getResources().getDimensionPixelSize(2131427792), 0, com.tencent.mm.cb.a.fromDPToPix(parama1.zJz.getContext(), 13), 0);
        locala.zUo.setSingleLine(true);
        parama = new vq();
        parama.cMS.cyr = paramString.fhG;
        com.tencent.mm.sdk.b.a.ymk.l(parama);
        bool = parama.cMT.cMU;
        if (parama.cMT.status == -2) {
          bool = false;
        }
        int j = parama.cMT.status;
        i = j;
        if (j <= 0) {
          i = paramString.fhD;
        }
      }
      Object localObject;
      switch (i)
      {
      case 2: 
      default: 
        locala.zUn.setImageResource(2131231059);
        locala.zUo.setSingleLine(false);
        locala.zUo.setMaxLines(2);
        locala.zUp.setText(null);
        locala.zUo.setText(paramString.description);
        locala.jYu.setOnClickListener(d(parama1));
        locala.jYu.setOnLongClickListener(c(parama1));
        locala.jYu.setOnTouchListener(((h)parama1.ay(h.class)).dHi());
        parama = new az(parambi, this.zzP.dJG(), paramInt, null, '\000');
        locala.jYu.setTag(parama);
        AppMethodBeat.o(32995);
        return;
      case 1: 
      case 7: 
        aw.aaz();
        parama = com.tencent.mm.model.c.YA().arv(parambi.field_talker);
        if (parama != null)
        {
          parama = parama.Of();
          if (!com.tencent.mm.platformtools.ah.isNullOrNil(paramString.fiN)) {
            break label626;
          }
          localObject = parama1.zJz.getMMResources().getString(2131298208, new Object[] { com.tencent.mm.platformtools.ah.nullAsNil(parama) });
          locala.zUo.setText(j.b(parama1.zJz.getContext(), (CharSequence)localObject, locala.zUo.getTextSize()));
          label457:
          localObject = (i)paramString.R(i.class);
          if (!com.tencent.mm.platformtools.ah.isNullOrNil(paramString.fiN)) {
            break label686;
          }
          parama = parama1.zJz.getMMResources().getString(2131298208, new Object[] { com.tencent.mm.platformtools.ah.nullAsNil(parama) });
          if (!bo.hl(((i)localObject).fgo, 1)) {
            break label1431;
          }
          if (parama.length() <= 5) {
            break label656;
          }
          parama = parama.substring(0, 5) + "..." + com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131298210);
        }
        break;
      }
      label656:
      label1431:
      for (;;)
      {
        locala.zUo.setText(j.b(parama1.zJz.getContext(), parama, locala.zUo.getTextSize()));
        locala.zUp.setText(paramString.fhE);
        locala.zUn.setImageResource(2131231059);
        break;
        parama = parambi.field_talker;
        break label392;
        label626:
        localObject = j.b(parama1.zJz.getContext(), paramString.fiN);
        locala.zUo.setText((CharSequence)localObject);
        break label457;
        parama = parama + com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131298210);
        continue;
        label686:
        if (bo.hl(((i)localObject).fgo, 1)) {
          if (paramString.fiN.length() > 5) {
            parama = paramString.fiN.substring(0, 5) + "..." + com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131298210);
          }
        }
        label752:
        for (parama = j.b(parama1.zJz.getContext(), parama);; parama = j.b(parama1.zJz.getContext(), paramString.fiN))
        {
          locala.zUo.setText(parama);
          break;
          parama = paramString.fiN + parama1.zJz.getContext().getString(2131298210);
          break label752;
        }
        if (bool) {
          if (bo.hl(((i)paramString.R(i.class)).fgo, 1)) {
            if (com.tencent.mm.platformtools.ah.isNullOrNil(paramString.fiN))
            {
              parama = com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131298199) + com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131298210);
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
          localObject = com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131298199) + "-" + paramString.fiN;
          parama = (c.a)localObject;
          if (((String)localObject).length() <= 5) {
            break label905;
          }
          parama = ((String)localObject).substring(0, 5) + "..." + com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131298210);
          break label905;
          if (com.tencent.mm.platformtools.ah.isNullOrNil(paramString.fiN))
          {
            parama = com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131298199);
            break label905;
          }
          parama = com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131298199) + "-" + paramString.fiN;
          break label905;
          locala.zUo.setText(2131298200);
        }
        locala.zUp.setText(paramString.fhE);
        locala.zUn.setImageResource(2131231061);
        if (bool) {
          if (com.tencent.mm.platformtools.ah.isNullOrNil(paramString.fiN))
          {
            parama = com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131298212);
            label1176:
            locala.zUo.setText(j.b(parama1.zJz.getContext(), parama));
          }
        }
        for (;;)
        {
          a(locala);
          break;
          parama = com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131298212) + "-" + paramString.fiN;
          break label1176;
          locala.zUo.setText(2131298211);
        }
        if (bool) {
          if (com.tencent.mm.platformtools.ah.isNullOrNil(paramString.fiN))
          {
            parama = com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131298206);
            locala.zUo.setText(j.b(parama1.zJz.getContext(), parama));
          }
        }
        for (;;)
        {
          locala.zUp.setText(paramString.fhE);
          locala.zUn.setImageResource(2131231060);
          a(locala);
          break;
          parama = com.tencent.mm.sdk.platformtools.ah.getContext().getString(2131298206) + "-" + paramString.fiN;
          break label1283;
          locala.zUo.setText(2131298207);
        }
        locala.zUo.setText(2131298201);
        locala.zUp.setText(paramString.fhE);
        locala.zUn.setImageResource(2131231058);
        a(locala);
        break;
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(32997);
    int i = ((az)paramView.getTag()).position;
    String str = parambi.field_content;
    paramView = null;
    if (str != null) {
      paramView = j.b.ab(str, parambi.field_reserved);
    }
    if (paramView != null) {
      paramContextMenu.add(i, 100, 0, this.zzP.zJz.getMMResources().getString(2131298232));
    }
    AppMethodBeat.o(32997);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 419430449);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(32998);
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
        ab.w("MicroMsg.ChattingItemAppMsgRemittanceTo", "Unrecognized type %d, probably version to low & check update!", new Object[] { Integer.valueOf(paramView.fhD) });
        com.tencent.mm.platformtools.ah.cC(parama.zJz.getContext());
      }
      for (;;)
      {
        AppMethodBeat.o(32998);
        return true;
        ((Intent)localObject).putExtra("invalid_time", paramView.fhH);
        ((Intent)localObject).putExtra("is_sender", true);
        ((Intent)localObject).putExtra("appmsg_type", paramView.fhD);
        ((Intent)localObject).putExtra("transfer_id", paramView.fhG);
        ((Intent)localObject).putExtra("transaction_id", paramView.fhF);
        ((Intent)localObject).putExtra("effective_date", paramView.fhI);
        ((Intent)localObject).putExtra("total_fee", paramView.cEW);
        ((Intent)localObject).putExtra("fee_type", paramView.cpp);
        paramView = new p.c.1(this, parama);
        if (r.ZB())
        {
          d.a(parama.zJx, "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", (Intent)localObject, 221, paramView);
        }
        else
        {
          d.a(parama.zJx, "remittance", ".ui.RemittanceDetailUI", (Intent)localObject, 221, paramView);
          continue;
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
    AppMethodBeat.o(32998);
    return false;
  }
  
  public final boolean dLp()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.p.c
 * JD-Core Version:    0.7.0.1
 */