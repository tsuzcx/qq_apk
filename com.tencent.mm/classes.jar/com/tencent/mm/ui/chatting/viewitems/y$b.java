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
import com.tencent.mm.ai.j;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.yv;
import com.tencent.mm.g.a.yv.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public final class y$b
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JBI;
  
  private static void a(y.a parama)
  {
    AppMethodBeat.i(37046);
    parama.ofK.getPaddingLeft();
    parama.ofK.getPaddingTop();
    parama.ofK.getPaddingRight();
    parama.ofK.getPaddingBottom();
    parama.ofK.setBackgroundResource(2131231389);
    parama.ofK.setPadding(0, 0, 0, 0);
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
      ((View)localObject).setTag(new y.a().gE((View)localObject));
    }
    AppMethodBeat.o(37044);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(37045);
    this.JBI = parama1;
    y.a locala = (y.a)parama;
    parama = parambu.field_content;
    if (parama != null) {}
    for (paramString = k.b.aA(parama, parambu.field_reserved);; paramString = null)
    {
      if (paramString != null)
      {
        y.a.aI(locala.ofK, locala.Kaq);
        locala.ofK.setBackgroundResource(2131231384);
        locala.ofK.setPadding(0, 0, 0, 0);
        locala.KcM.setSingleLine(true);
        parama = new yv();
        parama.dNP.dxv = paramString.hAX;
        com.tencent.mm.sdk.b.a.IbL.l(parama);
        if (!parama.dNQ.dNR) {}
        for (int i = 1;; i = 0)
        {
          if (parama.dNQ.status == -2) {
            i = 0;
          }
          int k = parama.dNQ.status;
          int j = k;
          if (k <= 0) {
            j = paramString.hAU;
          }
          switch (j)
          {
          default: 
            locala.KcL.setImageResource(2131689850);
            locala.KcM.setSingleLine(false);
            locala.KcM.setMaxLines(2);
            locala.KcN.setText(null);
            locala.KcM.setText(paramString.description);
            locala.ofK.setOnClickListener(d(parama1));
            locala.ofK.setOnLongClickListener(c(parama1));
            locala.ofK.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
            parama = new bk(parambu, parama1.fFv(), paramInt, null, '\000');
            locala.ofK.setTag(parama);
            if (locala.oIV == null) {
              break label1431;
            }
            if (!al.isDarkMode()) {
              break label1400;
            }
            locala.oIV.setBackground(null);
            locala.KcO.setVisibility(0);
            AppMethodBeat.o(37045);
            return;
          }
        }
        parama = (j)paramString.ao(j.class);
        if (af.isNullOrNil(paramString.hCd))
        {
          if (bt.jx(parama.hzG, 1)) {
            locala.KcM.setText(aj.getContext().getString(2131757198) + aj.getContext().getString(2131757199));
          }
          for (;;)
          {
            locala.KcN.setText(paramString.hAV);
            locala.KcL.setImageResource(2131689850);
            break;
            locala.KcM.setText(2131757198);
          }
        }
        if (bt.jx(parama.hzG, 1)) {
          if (paramString.hCd.length() > 5) {
            parama = paramString.hCd.substring(0, 5) + "..." + aj.getContext().getString(2131757199);
          }
        }
        label560:
        for (parama = com.tencent.mm.pluginsdk.ui.span.k.c(parama1.JOR.getContext(), parama);; parama = com.tencent.mm.pluginsdk.ui.span.k.c(parama1.JOR.getContext(), paramString.hCd))
        {
          locala.KcM.setText(parama);
          break;
          parama = paramString.hCd + parama1.JOR.getContext().getString(2131757199);
          break label560;
        }
        if (i != 0) {
          if (bt.jx(((j)paramString.ao(j.class)).hzG, 1)) {
            if (af.isNullOrNil(paramString.hCd))
            {
              parama = aj.getContext().getString(2131757188) + aj.getContext().getString(2131757199);
              label712:
              locala.KcM.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.JOR.getContext(), parama));
            }
          }
        }
        for (;;)
        {
          locala.KcN.setText(paramString.hAV);
          locala.KcL.setImageResource(2131689851);
          a(locala);
          break;
          String str = aj.getContext().getString(2131757188) + "-" + paramString.hCd;
          parama = str;
          if (str.length() <= 5) {
            break label712;
          }
          parama = str.substring(0, 5) + "..." + aj.getContext().getString(2131757199);
          break label712;
          if (af.isNullOrNil(paramString.hCd))
          {
            parama = aj.getContext().getString(2131757188);
            break label712;
          }
          parama = aj.getContext().getString(2131757188) + "-" + paramString.hCd;
          break label712;
          locala.KcM.setText(2131757189);
        }
        locala.KcN.setText(paramString.hAV);
        locala.KcL.setImageResource(2131689852);
        if (i != 0) {
          if (af.isNullOrNil(paramString.hCd))
          {
            parama = aj.getContext().getString(2131757201);
            label983:
            locala.KcM.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.JOR.getContext(), parama));
          }
        }
        for (;;)
        {
          a(locala);
          break;
          parama = aj.getContext().getString(2131757201) + "-" + paramString.hCd;
          break label983;
          locala.KcM.setText(2131757200);
        }
        locala.KcN.setText(paramString.hAV);
        locala.KcL.setImageResource(2131689851);
        if (i != 0) {
          if (af.isNullOrNil(paramString.hCd))
          {
            parama = aj.getContext().getString(2131757195);
            label1114:
            locala.KcM.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.JOR.getContext(), parama));
          }
        }
        for (;;)
        {
          a(locala);
          break;
          parama = aj.getContext().getString(2131757195) + "-" + paramString.hCd;
          break label1114;
          locala.KcM.setText(2131757196);
        }
        if (af.isNullOrNil(paramString.hCd)) {
          locala.KcM.setText(2131761041);
        }
        for (;;)
        {
          locala.KcN.setText(paramString.hAV);
          locala.KcL.setImageResource(2131689850);
          a(locala);
          break;
          parama = aj.getContext().getString(2131761041) + "-" + paramString.hCd;
          locala.KcM.setText(parama);
        }
        if (af.isNullOrNil(paramString.hCd)) {
          locala.KcM.setText(2131757190);
        }
        for (;;)
        {
          locala.KcN.setText(paramString.hAV);
          locala.KcL.setImageResource(2131689849);
          a(locala);
          break;
          parama = aj.getContext().getString(2131757190) + "-" + paramString.hCd;
          locala.KcM.setText(parama);
        }
        label1400:
        locala.oIV.setBackground(parama1.JOR.getMMResources().getDrawable(2131231681));
        locala.KcO.setVisibility(8);
      }
      label1431:
      AppMethodBeat.o(37045);
      return;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(37048);
    paramMenuItem.getItemId();
    AppMethodBeat.o(37048);
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194399);
    int i = ((bk)paramView.getTag()).position;
    if (parambu != null) {
      paraml.a(i, 100, this.JBI.JOR.getMMResources().getString(2131757221), 2131690384);
    }
    AppMethodBeat.o(194399);
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(37049);
    ((b)g.ab(b.class)).ZT(parambu.field_talker);
    Object localObject = parambu.field_content;
    paramView = null;
    if (localObject != null) {
      paramView = k.b.aA((String)localObject, parambu.field_reserved);
    }
    if (paramView != null)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("sender_name", parambu.field_talker);
      switch (paramView.hAU)
      {
      case 2: 
      default: 
        ad.w("MicroMsg.ChattingItemAppMsgRemittanceFrom", "Unrecognized type %d, probably version to low & check update!", new Object[] { Integer.valueOf(paramView.hAU) });
        af.dd(parama.JOR.getContext());
      }
      for (;;)
      {
        AppMethodBeat.o(37049);
        return true;
        ((Intent)localObject).putExtra("invalid_time", paramView.hAY);
        ((Intent)localObject).putExtra("is_sender", false);
        ((Intent)localObject).putExtra("appmsg_type", paramView.hAU);
        ((Intent)localObject).putExtra("transfer_id", paramView.hAX);
        ((Intent)localObject).putExtra("transaction_id", paramView.hAW);
        ((Intent)localObject).putExtra("effective_date", paramView.hAZ);
        ((Intent)localObject).putExtra("total_fee", paramView.dFq);
        ((Intent)localObject).putExtra("fee_type", paramView.dne);
        if (u.aAB())
        {
          d.a(parama.JOR, "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", (Intent)localObject, 221);
        }
        else
        {
          d.a(parama.JOR, "remittance", ".ui.RemittanceDetailUI", (Intent)localObject, 221);
          continue;
          ((Intent)localObject).putExtra("is_sender", true);
          ((Intent)localObject).putExtra("appmsg_type", paramView.hAU);
          ((Intent)localObject).putExtra("transfer_id", paramView.hAX);
          ((Intent)localObject).putExtra("transaction_id", paramView.hAW);
          ((Intent)localObject).putExtra("effective_date", paramView.hAZ);
          ((Intent)localObject).putExtra("total_fee", paramView.dFq);
          ((Intent)localObject).putExtra("fee_type", paramView.dne);
          if (u.aAB()) {
            d.b(parama.JOR.getContext(), "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", (Intent)localObject);
          } else {
            d.b(parama.JOR.getContext(), "remittance", ".ui.RemittanceDetailUI", (Intent)localObject);
          }
        }
      }
    }
    AppMethodBeat.o(37049);
    return false;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 419430449);
  }
  
  public final boolean fHh()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.y.b
 * JD-Core Version:    0.7.0.1
 */