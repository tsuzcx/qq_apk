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
import com.tencent.mm.br.d.a;
import com.tencent.mm.g.a.zb;
import com.tencent.mm.g.a.zb.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public final class y$c
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JWz;
  
  private static void a(y.a parama)
  {
    AppMethodBeat.i(37053);
    parama.olI.getPaddingLeft();
    parama.olI.getPaddingTop();
    parama.olI.getPaddingRight();
    parama.olI.getPaddingBottom();
    parama.olI.setBackgroundResource(2131231395);
    parama.olI.setPadding(0, 0, 0, 0);
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
      ((View)localObject).setTag(new y.a().gJ((View)localObject));
    }
    AppMethodBeat.o(37051);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(37052);
    this.JWz = parama1;
    y.a locala = (y.a)parama;
    parama = parambv.field_content;
    if (parama != null) {}
    label400:
    label664:
    label1184:
    for (paramString = k.b.aB(parama, parambv.field_reserved);; paramString = null)
    {
      boolean bool;
      Object localObject;
      if (paramString != null)
      {
        y.a.aI(locala.olI, locala.KwJ);
        locala.olI.setBackgroundResource(2131231390);
        locala.olI.setPadding(0, 0, 0, 0);
        locala.Kze.setSingleLine(true);
        parama = new zb();
        parama.dPf.dyA = paramString.hDL;
        com.tencent.mm.sdk.b.a.IvT.l(parama);
        bool = parama.dPg.dPh;
        if (parama.dPg.status == -2) {
          bool = false;
        }
        int j = parama.dPg.status;
        int i = j;
        if (j <= 0) {
          i = paramString.hDI;
        }
        switch (i)
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
          parama = new bk(parambv, this.JWz.fJC(), paramInt, null, '\000');
          locala.olI.setTag(parama);
          if (locala.oPx != null) {
            if (al.isDarkMode())
            {
              locala.oPx.setBackground(null);
              locala.Kzg.setVisibility(0);
              AppMethodBeat.o(37052);
              return;
            }
          }
          break;
        case 1: 
        case 7: 
          bc.aCg();
          parama = com.tencent.mm.model.c.azF().aUL(parambv.field_talker);
          if (parama != null)
          {
            parama = parama.adG();
            if (!af.isNullOrNil(paramString.hER)) {
              break label634;
            }
            localObject = parama1.Kkd.getMMResources().getString(2131757197, new Object[] { af.nullAsNil(parama) });
            locala.Kze.setText(com.tencent.mm.pluginsdk.ui.span.k.b(parama1.Kkd.getContext(), (CharSequence)localObject, locala.Kze.getTextSize()));
            label465:
            localObject = (j)paramString.ao(j.class);
            if (!af.isNullOrNil(paramString.hER)) {
              break label694;
            }
            parama = parama1.Kkd.getMMResources().getString(2131757197, new Object[] { af.nullAsNil(parama) });
            if (!bu.jB(((j)localObject).hCu, 1)) {
              break label1638;
            }
            if (parama.length() <= 5) {
              break label664;
            }
            parama = parama.substring(0, 5) + "..." + ak.getContext().getString(2131757199);
          }
          break;
        }
      }
      label694:
      label1638:
      for (;;)
      {
        locala.Kze.setText(com.tencent.mm.pluginsdk.ui.span.k.b(parama1.Kkd.getContext(), parama, locala.Kze.getTextSize()));
        locala.Kzf.setText(paramString.hDJ);
        locala.Kzd.setImageResource(2131689850);
        break;
        parama = parambv.field_talker;
        break label400;
        label634:
        localObject = com.tencent.mm.pluginsdk.ui.span.k.c(parama1.Kkd.getContext(), paramString.hER);
        locala.Kze.setText((CharSequence)localObject);
        break label465;
        parama = parama + ak.getContext().getString(2131757199);
        continue;
        if (bu.jB(((j)localObject).hCu, 1)) {
          if (paramString.hER.length() > 5) {
            parama = paramString.hER.substring(0, 5) + "..." + ak.getContext().getString(2131757199);
          }
        }
        label760:
        for (parama = com.tencent.mm.pluginsdk.ui.span.k.c(parama1.Kkd.getContext(), parama);; parama = com.tencent.mm.pluginsdk.ui.span.k.c(parama1.Kkd.getContext(), paramString.hER))
        {
          locala.Kze.setText(parama);
          break;
          parama = paramString.hER + parama1.Kkd.getContext().getString(2131757199);
          break label760;
        }
        if (bool) {
          if (bu.jB(((j)paramString.ao(j.class)).hCu, 1)) {
            if (af.isNullOrNil(paramString.hER))
            {
              parama = ak.getContext().getString(2131757188) + ak.getContext().getString(2131757199);
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
          localObject = ak.getContext().getString(2131757188) + "-" + paramString.hER;
          parama = (c.a)localObject;
          if (((String)localObject).length() <= 5) {
            break label913;
          }
          parama = ((String)localObject).substring(0, 5) + "..." + ak.getContext().getString(2131757199);
          break label913;
          if (af.isNullOrNil(paramString.hER))
          {
            parama = ak.getContext().getString(2131757188);
            break label913;
          }
          parama = ak.getContext().getString(2131757188) + "-" + paramString.hER;
          break label913;
          locala.Kze.setText(2131757189);
        }
        locala.Kzf.setText(paramString.hDJ);
        locala.Kzd.setImageResource(2131689852);
        if (bool) {
          if (af.isNullOrNil(paramString.hER))
          {
            parama = ak.getContext().getString(2131757201);
            locala.Kze.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.Kkd.getContext(), parama));
          }
        }
        for (;;)
        {
          a(locala);
          break;
          parama = ak.getContext().getString(2131757201) + "-" + paramString.hER;
          break label1184;
          locala.Kze.setText(2131757200);
        }
        if (bool) {
          if (af.isNullOrNil(paramString.hER))
          {
            parama = ak.getContext().getString(2131757195);
            locala.Kze.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.Kkd.getContext(), parama));
          }
        }
        for (;;)
        {
          locala.Kzf.setText(paramString.hDJ);
          locala.Kzd.setImageResource(2131689851);
          a(locala);
          break;
          parama = ak.getContext().getString(2131757195) + "-" + paramString.hER;
          break label1291;
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
        locala.oPx.setBackground(parama1.Kkd.getMMResources().getDrawable(2131231681));
        locala.Kzg.setVisibility(8);
        AppMethodBeat.o(37052);
        return;
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187795);
    int i = ((bk)paramView.getTag()).position;
    String str = parambv.field_content;
    paramView = null;
    if (str != null) {
      paramView = k.b.aB(str, parambv.field_reserved);
    }
    if (paramView != null) {
      paraml.a(i, 100, this.JWz.Kkd.getMMResources().getString(2131757221), 2131690384);
    }
    AppMethodBeat.o(187795);
    return false;
  }
  
  public final boolean b(View paramView, final com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37055);
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
        ae.w("MicroMsg.ChattingItemAppMsgRemittanceTo", "Unrecognized type %d, probably version to low & check update!", new Object[] { Integer.valueOf(paramView.hDI) });
        af.df(parama.Kkd.getContext());
      }
      for (;;)
      {
        AppMethodBeat.o(37055);
        return true;
        ((Intent)localObject).putExtra("invalid_time", paramView.hDM);
        ((Intent)localObject).putExtra("is_sender", true);
        ((Intent)localObject).putExtra("appmsg_type", paramView.hDI);
        ((Intent)localObject).putExtra("transfer_id", paramView.hDL);
        ((Intent)localObject).putExtra("transaction_id", paramView.hDK);
        ((Intent)localObject).putExtra("effective_date", paramView.hDN);
        ((Intent)localObject).putExtra("total_fee", paramView.dGv);
        ((Intent)localObject).putExtra("fee_type", paramView.dog);
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
              if (!bu.isNullOrNil(paramAnonymousIntent)) {
                h.c(parama.Kkd.getContext(), paramAnonymousIntent, "", false);
              }
              AppMethodBeat.o(37050);
              return;
            }
            AppMethodBeat.o(37050);
          }
        };
        if (v.aAR())
        {
          d.a(parama.Kka, "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", (Intent)localObject, 221, paramView);
        }
        else
        {
          d.a(parama.Kka, "remittance", ".ui.RemittanceDetailUI", (Intent)localObject, 221, paramView);
          continue;
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
    AppMethodBeat.o(37055);
    return false;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 419430449);
  }
  
  public final boolean fLz()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.y.c
 * JD-Core Version:    0.7.0.1
 */