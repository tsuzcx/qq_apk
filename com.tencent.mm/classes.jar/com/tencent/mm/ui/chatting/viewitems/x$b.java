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
import com.tencent.mm.ah.j;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.yb;
import com.tencent.mm.g.a.yb.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;

public final class x$b
  extends c
{
  private com.tencent.mm.ui.chatting.d.a HNS;
  
  private static void a(x.a parama)
  {
    AppMethodBeat.i(37046);
    parama.nDl.getPaddingLeft();
    parama.nDl.getPaddingTop();
    parama.nDl.getPaddingRight();
    parama.nDl.getPaddingBottom();
    parama.nDl.setBackgroundResource(2131231389);
    parama.nDl.setPadding(0, 0, 0, 0);
    AppMethodBeat.o(37046);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37044);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ag(paramLayoutInflater, 2131493446);
      ((View)localObject).setTag(new x.a().gn((View)localObject));
    }
    AppMethodBeat.o(37044);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(37045);
    this.HNS = parama1;
    x.a locala = (x.a)parama;
    parama = parambo.field_content;
    if (parama != null) {}
    for (paramString = k.b.az(parama, parambo.field_reserved);; paramString = null)
    {
      if (paramString != null)
      {
        x.a.aG(locala.nDl, locala.IjS);
        locala.nDl.setBackgroundResource(2131231384);
        locala.nDl.setPadding(0, 0, 0, 0);
        locala.Imo.setSingleLine(true);
        parama = new yb();
        parama.dBC.dlI = paramString.hiO;
        com.tencent.mm.sdk.b.a.GpY.l(parama);
        if (!parama.dBD.dBE) {}
        for (int i = 1;; i = 0)
        {
          if (parama.dBD.status == -2) {
            i = 0;
          }
          int k = parama.dBD.status;
          int j = k;
          if (k <= 0) {
            j = paramString.hiL;
          }
          switch (j)
          {
          default: 
            locala.Imn.setImageResource(2131689850);
            locala.Imo.setSingleLine(false);
            locala.Imo.setMaxLines(2);
            locala.Imp.setText(null);
            locala.Imo.setText(paramString.description);
            locala.nDl.setOnClickListener(d(parama1));
            locala.nDl.setOnLongClickListener(c(parama1));
            locala.nDl.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
            parama = new bj(parambo, parama1.foQ(), paramInt, null, '\000');
            locala.nDl.setTag(parama);
            if (locala.ofC == null) {
              break label1431;
            }
            if (!aj.DT()) {
              break label1400;
            }
            locala.ofC.setBackground(null);
            locala.Imq.setVisibility(0);
            AppMethodBeat.o(37045);
            return;
          }
        }
        parama = (j)paramString.ao(j.class);
        if (ae.isNullOrNil(paramString.hjU))
        {
          if (bs.jl(parama.hhx, 1)) {
            locala.Imo.setText(ai.getContext().getString(2131757198) + ai.getContext().getString(2131757199));
          }
          for (;;)
          {
            locala.Imp.setText(paramString.hiM);
            locala.Imn.setImageResource(2131689850);
            break;
            locala.Imo.setText(2131757198);
          }
        }
        if (bs.jl(parama.hhx, 1)) {
          if (paramString.hjU.length() > 5) {
            parama = paramString.hjU.substring(0, 5) + "..." + ai.getContext().getString(2131757199);
          }
        }
        label560:
        for (parama = k.c(parama1.HZF.getContext(), parama);; parama = k.c(parama1.HZF.getContext(), paramString.hjU))
        {
          locala.Imo.setText(parama);
          break;
          parama = paramString.hjU + parama1.HZF.getContext().getString(2131757199);
          break label560;
        }
        if (i != 0) {
          if (bs.jl(((j)paramString.ao(j.class)).hhx, 1)) {
            if (ae.isNullOrNil(paramString.hjU))
            {
              parama = ai.getContext().getString(2131757188) + ai.getContext().getString(2131757199);
              label712:
              locala.Imo.setText(k.c(parama1.HZF.getContext(), parama));
            }
          }
        }
        for (;;)
        {
          locala.Imp.setText(paramString.hiM);
          locala.Imn.setImageResource(2131689851);
          a(locala);
          break;
          String str = ai.getContext().getString(2131757188) + "-" + paramString.hjU;
          parama = str;
          if (str.length() <= 5) {
            break label712;
          }
          parama = str.substring(0, 5) + "..." + ai.getContext().getString(2131757199);
          break label712;
          if (ae.isNullOrNil(paramString.hjU))
          {
            parama = ai.getContext().getString(2131757188);
            break label712;
          }
          parama = ai.getContext().getString(2131757188) + "-" + paramString.hjU;
          break label712;
          locala.Imo.setText(2131757189);
        }
        locala.Imp.setText(paramString.hiM);
        locala.Imn.setImageResource(2131689852);
        if (i != 0) {
          if (ae.isNullOrNil(paramString.hjU))
          {
            parama = ai.getContext().getString(2131757201);
            label983:
            locala.Imo.setText(k.c(parama1.HZF.getContext(), parama));
          }
        }
        for (;;)
        {
          a(locala);
          break;
          parama = ai.getContext().getString(2131757201) + "-" + paramString.hjU;
          break label983;
          locala.Imo.setText(2131757200);
        }
        locala.Imp.setText(paramString.hiM);
        locala.Imn.setImageResource(2131689851);
        if (i != 0) {
          if (ae.isNullOrNil(paramString.hjU))
          {
            parama = ai.getContext().getString(2131757195);
            label1114:
            locala.Imo.setText(k.c(parama1.HZF.getContext(), parama));
          }
        }
        for (;;)
        {
          a(locala);
          break;
          parama = ai.getContext().getString(2131757195) + "-" + paramString.hjU;
          break label1114;
          locala.Imo.setText(2131757196);
        }
        if (ae.isNullOrNil(paramString.hjU)) {
          locala.Imo.setText(2131761041);
        }
        for (;;)
        {
          locala.Imp.setText(paramString.hiM);
          locala.Imn.setImageResource(2131689850);
          a(locala);
          break;
          parama = ai.getContext().getString(2131761041) + "-" + paramString.hjU;
          locala.Imo.setText(parama);
        }
        if (ae.isNullOrNil(paramString.hjU)) {
          locala.Imo.setText(2131757190);
        }
        for (;;)
        {
          locala.Imp.setText(paramString.hiM);
          locala.Imn.setImageResource(2131689849);
          a(locala);
          break;
          parama = ai.getContext().getString(2131757190) + "-" + paramString.hjU;
          locala.Imo.setText(parama);
        }
        label1400:
        locala.ofC.setBackground(parama1.HZF.getMMResources().getDrawable(2131231681));
        locala.Imq.setVisibility(8);
      }
      label1431:
      AppMethodBeat.o(37045);
      return;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(37047);
    int i = ((bj)paramView.getTag()).position;
    if (parambo != null) {
      paramContextMenu.add(i, 100, 0, this.HNS.HZF.getMMResources().getString(2131757221));
    }
    AppMethodBeat.o(37047);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37048);
    paramMenuItem.getItemId();
    AppMethodBeat.o(37048);
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37049);
    ((b)g.ab(b.class)).Wm(parambo.field_talker);
    Object localObject = parambo.field_content;
    paramView = null;
    if (localObject != null) {
      paramView = k.b.az((String)localObject, parambo.field_reserved);
    }
    if (paramView != null)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("sender_name", parambo.field_talker);
      switch (paramView.hiL)
      {
      case 2: 
      default: 
        ac.w("MicroMsg.ChattingItemAppMsgRemittanceFrom", "Unrecognized type %d, probably version to low & check update!", new Object[] { Integer.valueOf(paramView.hiL) });
        ae.df(parama.HZF.getContext());
      }
      for (;;)
      {
        AppMethodBeat.o(37049);
        return true;
        ((Intent)localObject).putExtra("invalid_time", paramView.hiP);
        ((Intent)localObject).putExtra("is_sender", false);
        ((Intent)localObject).putExtra("appmsg_type", paramView.hiL);
        ((Intent)localObject).putExtra("transfer_id", paramView.hiO);
        ((Intent)localObject).putExtra("transaction_id", paramView.hiN);
        ((Intent)localObject).putExtra("effective_date", paramView.hiQ);
        ((Intent)localObject).putExtra("total_fee", paramView.dto);
        ((Intent)localObject).putExtra("fee_type", paramView.dbI);
        if (u.axL())
        {
          d.a(parama.HZF, "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", (Intent)localObject, 221);
        }
        else
        {
          d.a(parama.HZF, "remittance", ".ui.RemittanceDetailUI", (Intent)localObject, 221);
          continue;
          ((Intent)localObject).putExtra("is_sender", true);
          ((Intent)localObject).putExtra("appmsg_type", paramView.hiL);
          ((Intent)localObject).putExtra("transfer_id", paramView.hiO);
          ((Intent)localObject).putExtra("transaction_id", paramView.hiN);
          ((Intent)localObject).putExtra("effective_date", paramView.hiQ);
          ((Intent)localObject).putExtra("total_fee", paramView.dto);
          ((Intent)localObject).putExtra("fee_type", paramView.dbI);
          if (u.axL()) {
            d.b(parama.HZF.getContext(), "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", (Intent)localObject);
          } else {
            d.b(parama.HZF.getContext(), "remittance", ".ui.RemittanceDetailUI", (Intent)localObject);
          }
        }
      }
    }
    AppMethodBeat.o(37049);
    return false;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 419430449);
  }
  
  public final boolean fqu()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.b
 * JD-Core Version:    0.7.0.1
 */