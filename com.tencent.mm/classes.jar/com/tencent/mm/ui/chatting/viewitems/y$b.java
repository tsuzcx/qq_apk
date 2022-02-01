package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.j;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.zb;
import com.tencent.mm.g.a.zb.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public final class y$b
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JWz;
  
  private static void a(y.a parama)
  {
    AppMethodBeat.i(37046);
    parama.olI.getPaddingLeft();
    parama.olI.getPaddingTop();
    parama.olI.getPaddingRight();
    parama.olI.getPaddingBottom();
    parama.olI.setBackgroundResource(2131231389);
    parama.olI.setPadding(0, 0, 0, 0);
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
      localObject = new ah(paramLayoutInflater, 2131493446);
      ((View)localObject).setTag(new y.a().gJ((View)localObject));
    }
    AppMethodBeat.o(37044);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(37045);
    this.JWz = parama1;
    y.a locala = (y.a)parama;
    parama = parambv.field_content;
    if (parama != null) {}
    for (paramString = k.b.aB(parama, parambv.field_reserved);; paramString = null)
    {
      if (paramString != null)
      {
        y.a.aI(locala.olI, locala.KwJ);
        locala.olI.setBackgroundResource(2131231384);
        locala.olI.setPadding(0, 0, 0, 0);
        locala.Kze.setSingleLine(true);
        parama = new zb();
        parama.dPf.dyA = paramString.hDL;
        com.tencent.mm.sdk.b.a.IvT.l(parama);
        if (!parama.dPg.dPh) {}
        for (int i = 1;; i = 0)
        {
          if (parama.dPg.status == -2) {
            i = 0;
          }
          int k = parama.dPg.status;
          int j = k;
          if (k <= 0) {
            j = paramString.hDI;
          }
          switch (j)
          {
          default: 
            locala.Kzd.setImageResource(2131689850);
            locala.Kze.setSingleLine(false);
            locala.Kze.setMaxLines(2);
            locala.Kzf.setText(null);
            locala.Kze.setText(paramString.description);
            locala.olI.setOnClickListener(d(parama1));
            locala.olI.setOnLongClickListener(c(parama1));
            locala.olI.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
            parama = new bk(parambv, parama1.fJC(), paramInt, null, '\000');
            locala.olI.setTag(parama);
            if (locala.oPx == null) {
              break label1431;
            }
            if (!al.isDarkMode()) {
              break label1400;
            }
            locala.oPx.setBackground(null);
            locala.Kzg.setVisibility(0);
            AppMethodBeat.o(37045);
            return;
          }
        }
        parama = (j)paramString.ao(j.class);
        if (af.isNullOrNil(paramString.hER))
        {
          if (bu.jB(parama.hCu, 1)) {
            locala.Kze.setText(ak.getContext().getString(2131757198) + ak.getContext().getString(2131757199));
          }
          for (;;)
          {
            locala.Kzf.setText(paramString.hDJ);
            locala.Kzd.setImageResource(2131689850);
            break;
            locala.Kze.setText(2131757198);
          }
        }
        if (bu.jB(parama.hCu, 1)) {
          if (paramString.hER.length() > 5) {
            parama = paramString.hER.substring(0, 5) + "..." + ak.getContext().getString(2131757199);
          }
        }
        label560:
        for (parama = com.tencent.mm.pluginsdk.ui.span.k.c(parama1.Kkd.getContext(), parama);; parama = com.tencent.mm.pluginsdk.ui.span.k.c(parama1.Kkd.getContext(), paramString.hER))
        {
          locala.Kze.setText(parama);
          break;
          parama = paramString.hER + parama1.Kkd.getContext().getString(2131757199);
          break label560;
        }
        if (i != 0) {
          if (bu.jB(((j)paramString.ao(j.class)).hCu, 1)) {
            if (af.isNullOrNil(paramString.hER))
            {
              parama = ak.getContext().getString(2131757188) + ak.getContext().getString(2131757199);
              label712:
              locala.Kze.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.Kkd.getContext(), parama));
            }
          }
        }
        for (;;)
        {
          locala.Kzf.setText(paramString.hDJ);
          locala.Kzd.setImageResource(2131689851);
          a(locala);
          break;
          String str = ak.getContext().getString(2131757188) + "-" + paramString.hER;
          parama = str;
          if (str.length() <= 5) {
            break label712;
          }
          parama = str.substring(0, 5) + "..." + ak.getContext().getString(2131757199);
          break label712;
          if (af.isNullOrNil(paramString.hER))
          {
            parama = ak.getContext().getString(2131757188);
            break label712;
          }
          parama = ak.getContext().getString(2131757188) + "-" + paramString.hER;
          break label712;
          locala.Kze.setText(2131757189);
        }
        locala.Kzf.setText(paramString.hDJ);
        locala.Kzd.setImageResource(2131689852);
        if (i != 0) {
          if (af.isNullOrNil(paramString.hER))
          {
            parama = ak.getContext().getString(2131757201);
            label983:
            locala.Kze.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.Kkd.getContext(), parama));
          }
        }
        for (;;)
        {
          a(locala);
          break;
          parama = ak.getContext().getString(2131757201) + "-" + paramString.hER;
          break label983;
          locala.Kze.setText(2131757200);
        }
        locala.Kzf.setText(paramString.hDJ);
        locala.Kzd.setImageResource(2131689851);
        if (i != 0) {
          if (af.isNullOrNil(paramString.hER))
          {
            parama = ak.getContext().getString(2131757195);
            label1114:
            locala.Kze.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.Kkd.getContext(), parama));
          }
        }
        for (;;)
        {
          a(locala);
          break;
          parama = ak.getContext().getString(2131757195) + "-" + paramString.hER;
          break label1114;
          locala.Kze.setText(2131757196);
        }
        if (af.isNullOrNil(paramString.hER)) {
          locala.Kze.setText(2131761041);
        }
        for (;;)
        {
          locala.Kzf.setText(paramString.hDJ);
          locala.Kzd.setImageResource(2131689850);
          a(locala);
          break;
          parama = ak.getContext().getString(2131761041) + "-" + paramString.hER;
          locala.Kze.setText(parama);
        }
        if (af.isNullOrNil(paramString.hER)) {
          locala.Kze.setText(2131757190);
        }
        for (;;)
        {
          locala.Kzf.setText(paramString.hDJ);
          locala.Kzd.setImageResource(2131689849);
          a(locala);
          break;
          parama = ak.getContext().getString(2131757190) + "-" + paramString.hER;
          locala.Kze.setText(parama);
        }
        label1400:
        locala.oPx.setBackground(parama1.Kkd.getMMResources().getDrawable(2131231681));
        locala.Kzg.setVisibility(8);
      }
      label1431:
      AppMethodBeat.o(37045);
      return;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37048);
    paramMenuItem.getItemId();
    AppMethodBeat.o(37048);
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187794);
    int i = ((bk)paramView.getTag()).position;
    if (parambv != null) {
      paraml.a(i, 100, this.JWz.Kkd.getMMResources().getString(2131757221), 2131690384);
    }
    AppMethodBeat.o(187794);
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37049);
    ((b)g.ab(b.class)).aaK(parambv.field_talker);
    Object localObject = parambv.field_content;
    paramView = null;
    if (localObject != null) {
      paramView = k.b.aB((String)localObject, parambv.field_reserved);
    }
    if (paramView != null)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("sender_name", parambv.field_talker);
      switch (paramView.hDI)
      {
      case 2: 
      default: 
        ae.w("MicroMsg.ChattingItemAppMsgRemittanceFrom", "Unrecognized type %d, probably version to low & check update!", new Object[] { Integer.valueOf(paramView.hDI) });
        af.df(parama.Kkd.getContext());
      }
      for (;;)
      {
        AppMethodBeat.o(37049);
        return true;
        ((Intent)localObject).putExtra("invalid_time", paramView.hDM);
        ((Intent)localObject).putExtra("is_sender", false);
        ((Intent)localObject).putExtra("appmsg_type", paramView.hDI);
        ((Intent)localObject).putExtra("transfer_id", paramView.hDL);
        ((Intent)localObject).putExtra("transaction_id", paramView.hDK);
        ((Intent)localObject).putExtra("effective_date", paramView.hDN);
        ((Intent)localObject).putExtra("total_fee", paramView.dGv);
        ((Intent)localObject).putExtra("fee_type", paramView.dog);
        if (v.aAR())
        {
          d.a(parama.Kkd, "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", (Intent)localObject, 221);
        }
        else
        {
          d.a(parama.Kkd, "remittance", ".ui.RemittanceDetailUI", (Intent)localObject, 221);
          continue;
          ((Intent)localObject).putExtra("is_sender", true);
          ((Intent)localObject).putExtra("appmsg_type", paramView.hDI);
          ((Intent)localObject).putExtra("transfer_id", paramView.hDL);
          ((Intent)localObject).putExtra("transaction_id", paramView.hDK);
          ((Intent)localObject).putExtra("effective_date", paramView.hDN);
          ((Intent)localObject).putExtra("total_fee", paramView.dGv);
          ((Intent)localObject).putExtra("fee_type", paramView.dog);
          if (v.aAR()) {
            d.b(parama.Kkd.getContext(), "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", (Intent)localObject);
          } else {
            d.b(parama.Kkd.getContext(), "remittance", ".ui.RemittanceDetailUI", (Intent)localObject);
          }
        }
      }
    }
    AppMethodBeat.o(37049);
    return false;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 419430449);
  }
  
  public final boolean fLz()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.y.b
 * JD-Core Version:    0.7.0.1
 */