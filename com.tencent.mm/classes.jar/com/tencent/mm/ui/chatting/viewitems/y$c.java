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
import com.tencent.mm.bs.d.a;
import com.tencent.mm.g.a.yv;
import com.tencent.mm.g.a.yv.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public final class y$c
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JBI;
  
  private static void a(y.a parama)
  {
    AppMethodBeat.i(37053);
    parama.ofK.getPaddingLeft();
    parama.ofK.getPaddingTop();
    parama.ofK.getPaddingRight();
    parama.ofK.getPaddingBottom();
    parama.ofK.setBackgroundResource(2131231395);
    parama.ofK.setPadding(0, 0, 0, 0);
    AppMethodBeat.o(37053);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37051);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ah(paramLayoutInflater, 2131493490);
      ((View)localObject).setTag(new y.a().gE((View)localObject));
    }
    AppMethodBeat.o(37051);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(37052);
    this.JBI = parama1;
    y.a locala = (y.a)parama;
    parama = parambu.field_content;
    if (parama != null) {}
    label400:
    label664:
    label1184:
    for (paramString = k.b.aA(parama, parambu.field_reserved);; paramString = null)
    {
      boolean bool;
      Object localObject;
      if (paramString != null)
      {
        y.a.aI(locala.ofK, locala.Kaq);
        locala.ofK.setBackgroundResource(2131231390);
        locala.ofK.setPadding(0, 0, 0, 0);
        locala.KcM.setSingleLine(true);
        parama = new yv();
        parama.dNP.dxv = paramString.hAX;
        com.tencent.mm.sdk.b.a.IbL.l(parama);
        bool = parama.dNQ.dNR;
        if (parama.dNQ.status == -2) {
          bool = false;
        }
        int j = parama.dNQ.status;
        int i = j;
        if (j <= 0) {
          i = paramString.hAU;
        }
        switch (i)
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
          parama = new bk(parambu, this.JBI.fFv(), paramInt, null, '\000');
          locala.ofK.setTag(parama);
          if (locala.oIV != null) {
            if (al.isDarkMode())
            {
              locala.oIV.setBackground(null);
              locala.KcO.setVisibility(0);
              AppMethodBeat.o(37052);
              return;
            }
          }
          break;
        case 1: 
        case 7: 
          ba.aBQ();
          parama = com.tencent.mm.model.c.azp().aTk(parambu.field_talker);
          if (parama != null)
          {
            parama = parama.adv();
            if (!af.isNullOrNil(paramString.hCd)) {
              break label634;
            }
            localObject = parama1.JOR.getMMResources().getString(2131757197, new Object[] { af.nullAsNil(parama) });
            locala.KcM.setText(com.tencent.mm.pluginsdk.ui.span.k.b(parama1.JOR.getContext(), (CharSequence)localObject, locala.KcM.getTextSize()));
            label465:
            localObject = (j)paramString.ao(j.class);
            if (!af.isNullOrNil(paramString.hCd)) {
              break label694;
            }
            parama = parama1.JOR.getMMResources().getString(2131757197, new Object[] { af.nullAsNil(parama) });
            if (!bt.jx(((j)localObject).hzG, 1)) {
              break label1638;
            }
            if (parama.length() <= 5) {
              break label664;
            }
            parama = parama.substring(0, 5) + "..." + aj.getContext().getString(2131757199);
          }
          break;
        }
      }
      label694:
      label1638:
      for (;;)
      {
        locala.KcM.setText(com.tencent.mm.pluginsdk.ui.span.k.b(parama1.JOR.getContext(), parama, locala.KcM.getTextSize()));
        locala.KcN.setText(paramString.hAV);
        locala.KcL.setImageResource(2131689850);
        break;
        parama = parambu.field_talker;
        break label400;
        label634:
        localObject = com.tencent.mm.pluginsdk.ui.span.k.c(parama1.JOR.getContext(), paramString.hCd);
        locala.KcM.setText((CharSequence)localObject);
        break label465;
        parama = parama + aj.getContext().getString(2131757199);
        continue;
        if (bt.jx(((j)localObject).hzG, 1)) {
          if (paramString.hCd.length() > 5) {
            parama = paramString.hCd.substring(0, 5) + "..." + aj.getContext().getString(2131757199);
          }
        }
        label760:
        for (parama = com.tencent.mm.pluginsdk.ui.span.k.c(parama1.JOR.getContext(), parama);; parama = com.tencent.mm.pluginsdk.ui.span.k.c(parama1.JOR.getContext(), paramString.hCd))
        {
          locala.KcM.setText(parama);
          break;
          parama = paramString.hCd + parama1.JOR.getContext().getString(2131757199);
          break label760;
        }
        if (bool) {
          if (bt.jx(((j)paramString.ao(j.class)).hzG, 1)) {
            if (af.isNullOrNil(paramString.hCd))
            {
              parama = aj.getContext().getString(2131757188) + aj.getContext().getString(2131757199);
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
          localObject = aj.getContext().getString(2131757188) + "-" + paramString.hCd;
          parama = (c.a)localObject;
          if (((String)localObject).length() <= 5) {
            break label913;
          }
          parama = ((String)localObject).substring(0, 5) + "..." + aj.getContext().getString(2131757199);
          break label913;
          if (af.isNullOrNil(paramString.hCd))
          {
            parama = aj.getContext().getString(2131757188);
            break label913;
          }
          parama = aj.getContext().getString(2131757188) + "-" + paramString.hCd;
          break label913;
          locala.KcM.setText(2131757189);
        }
        locala.KcN.setText(paramString.hAV);
        locala.KcL.setImageResource(2131689852);
        if (bool) {
          if (af.isNullOrNil(paramString.hCd))
          {
            parama = aj.getContext().getString(2131757201);
            locala.KcM.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.JOR.getContext(), parama));
          }
        }
        for (;;)
        {
          a(locala);
          break;
          parama = aj.getContext().getString(2131757201) + "-" + paramString.hCd;
          break label1184;
          locala.KcM.setText(2131757200);
        }
        if (bool) {
          if (af.isNullOrNil(paramString.hCd))
          {
            parama = aj.getContext().getString(2131757195);
            locala.KcM.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.JOR.getContext(), parama));
          }
        }
        for (;;)
        {
          locala.KcN.setText(paramString.hAV);
          locala.KcL.setImageResource(2131689851);
          a(locala);
          break;
          parama = aj.getContext().getString(2131757195) + "-" + paramString.hCd;
          break label1291;
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
        locala.oIV.setBackground(parama1.JOR.getMMResources().getDrawable(2131231681));
        locala.KcO.setVisibility(8);
        AppMethodBeat.o(37052);
        return;
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194400);
    int i = ((bk)paramView.getTag()).position;
    String str = parambu.field_content;
    paramView = null;
    if (str != null) {
      paramView = k.b.aA(str, parambu.field_reserved);
    }
    if (paramView != null) {
      paraml.a(i, 100, this.JBI.JOR.getMMResources().getString(2131757221), 2131690384);
    }
    AppMethodBeat.o(194400);
    return false;
  }
  
  public final boolean b(View paramView, final com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(37055);
    ((com.tencent.mm.plugin.comm.a.b)g.ab(com.tencent.mm.plugin.comm.a.b.class)).ZT(parambu.field_talker);
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
        ad.w("MicroMsg.ChattingItemAppMsgRemittanceTo", "Unrecognized type %d, probably version to low & check update!", new Object[] { Integer.valueOf(paramView.hAU) });
        af.dd(parama.JOR.getContext());
      }
      for (;;)
      {
        AppMethodBeat.o(37055);
        return true;
        ((Intent)localObject).putExtra("invalid_time", paramView.hAY);
        ((Intent)localObject).putExtra("is_sender", true);
        ((Intent)localObject).putExtra("appmsg_type", paramView.hAU);
        ((Intent)localObject).putExtra("transfer_id", paramView.hAX);
        ((Intent)localObject).putExtra("transaction_id", paramView.hAW);
        ((Intent)localObject).putExtra("effective_date", paramView.hAZ);
        ((Intent)localObject).putExtra("total_fee", paramView.dFq);
        ((Intent)localObject).putExtra("fee_type", paramView.dne);
        paramView = new d.a()
        {
          public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(37050);
            if (paramAnonymousInt1 == 221)
            {
              if (paramAnonymousIntent == null)
              {
                AppMethodBeat.o(37050);
                return;
              }
              paramAnonymousIntent = paramAnonymousIntent.getStringExtra("result_msg");
              if (!bt.isNullOrNil(paramAnonymousIntent)) {
                h.c(parama.JOR.getContext(), paramAnonymousIntent, "", false);
              }
              AppMethodBeat.o(37050);
              return;
            }
            AppMethodBeat.o(37050);
          }
        };
        if (u.aAB())
        {
          d.a(parama.JOO, "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", (Intent)localObject, 221, paramView);
        }
        else
        {
          d.a(parama.JOO, "remittance", ".ui.RemittanceDetailUI", (Intent)localObject, 221, paramView);
          continue;
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
    AppMethodBeat.o(37055);
    return false;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 419430449);
  }
  
  public final boolean fHh()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.y.c
 * JD-Core Version:    0.7.0.1
 */