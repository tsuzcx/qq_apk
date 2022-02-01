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
import com.tencent.mm.br.d.a;
import com.tencent.mm.g.a.yb;
import com.tencent.mm.g.a.yb.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;

public final class x$c
  extends c
{
  private com.tencent.mm.ui.chatting.d.a HNS;
  
  private static void a(x.a parama)
  {
    AppMethodBeat.i(37053);
    parama.nDl.getPaddingLeft();
    parama.nDl.getPaddingTop();
    parama.nDl.getPaddingRight();
    parama.nDl.getPaddingBottom();
    parama.nDl.setBackgroundResource(2131231395);
    parama.nDl.setPadding(0, 0, 0, 0);
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
      localObject = new ag(paramLayoutInflater, 2131493490);
      ((View)localObject).setTag(new x.a().gn((View)localObject));
    }
    AppMethodBeat.o(37051);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(37052);
    this.HNS = parama1;
    x.a locala = (x.a)parama;
    parama = parambo.field_content;
    if (parama != null) {}
    label400:
    label664:
    label1184:
    for (paramString = k.b.az(parama, parambo.field_reserved);; paramString = null)
    {
      boolean bool;
      Object localObject;
      if (paramString != null)
      {
        x.a.aG(locala.nDl, locala.IjS);
        locala.nDl.setBackgroundResource(2131231390);
        locala.nDl.setPadding(0, 0, 0, 0);
        locala.Imo.setSingleLine(true);
        parama = new yb();
        parama.dBC.dlI = paramString.hiO;
        com.tencent.mm.sdk.b.a.GpY.l(parama);
        bool = parama.dBD.dBE;
        if (parama.dBD.status == -2) {
          bool = false;
        }
        int j = parama.dBD.status;
        int i = j;
        if (j <= 0) {
          i = paramString.hiL;
        }
        switch (i)
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
          parama = new bj(parambo, this.HNS.foQ(), paramInt, null, '\000');
          locala.nDl.setTag(parama);
          if (locala.ofC != null) {
            if (aj.DT())
            {
              locala.ofC.setBackground(null);
              locala.Imq.setVisibility(0);
              AppMethodBeat.o(37052);
              return;
            }
          }
          break;
        case 1: 
        case 7: 
          az.ayM();
          parama = com.tencent.mm.model.c.awB().aNs(parambo.field_talker);
          if (parama != null)
          {
            parama = parama.aaS();
            if (!ae.isNullOrNil(paramString.hjU)) {
              break label634;
            }
            localObject = parama1.HZF.getMMResources().getString(2131757197, new Object[] { ae.nullAsNil(parama) });
            locala.Imo.setText(k.b(parama1.HZF.getContext(), (CharSequence)localObject, locala.Imo.getTextSize()));
            label465:
            localObject = (j)paramString.ao(j.class);
            if (!ae.isNullOrNil(paramString.hjU)) {
              break label694;
            }
            parama = parama1.HZF.getMMResources().getString(2131757197, new Object[] { ae.nullAsNil(parama) });
            if (!bs.jl(((j)localObject).hhx, 1)) {
              break label1638;
            }
            if (parama.length() <= 5) {
              break label664;
            }
            parama = parama.substring(0, 5) + "..." + ai.getContext().getString(2131757199);
          }
          break;
        }
      }
      label694:
      label1638:
      for (;;)
      {
        locala.Imo.setText(k.b(parama1.HZF.getContext(), parama, locala.Imo.getTextSize()));
        locala.Imp.setText(paramString.hiM);
        locala.Imn.setImageResource(2131689850);
        break;
        parama = parambo.field_talker;
        break label400;
        label634:
        localObject = k.c(parama1.HZF.getContext(), paramString.hjU);
        locala.Imo.setText((CharSequence)localObject);
        break label465;
        parama = parama + ai.getContext().getString(2131757199);
        continue;
        if (bs.jl(((j)localObject).hhx, 1)) {
          if (paramString.hjU.length() > 5) {
            parama = paramString.hjU.substring(0, 5) + "..." + ai.getContext().getString(2131757199);
          }
        }
        label760:
        for (parama = k.c(parama1.HZF.getContext(), parama);; parama = k.c(parama1.HZF.getContext(), paramString.hjU))
        {
          locala.Imo.setText(parama);
          break;
          parama = paramString.hjU + parama1.HZF.getContext().getString(2131757199);
          break label760;
        }
        if (bool) {
          if (bs.jl(((j)paramString.ao(j.class)).hhx, 1)) {
            if (ae.isNullOrNil(paramString.hjU))
            {
              parama = ai.getContext().getString(2131757188) + ai.getContext().getString(2131757199);
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
          localObject = ai.getContext().getString(2131757188) + "-" + paramString.hjU;
          parama = (c.a)localObject;
          if (((String)localObject).length() <= 5) {
            break label913;
          }
          parama = ((String)localObject).substring(0, 5) + "..." + ai.getContext().getString(2131757199);
          break label913;
          if (ae.isNullOrNil(paramString.hjU))
          {
            parama = ai.getContext().getString(2131757188);
            break label913;
          }
          parama = ai.getContext().getString(2131757188) + "-" + paramString.hjU;
          break label913;
          locala.Imo.setText(2131757189);
        }
        locala.Imp.setText(paramString.hiM);
        locala.Imn.setImageResource(2131689852);
        if (bool) {
          if (ae.isNullOrNil(paramString.hjU))
          {
            parama = ai.getContext().getString(2131757201);
            locala.Imo.setText(k.c(parama1.HZF.getContext(), parama));
          }
        }
        for (;;)
        {
          a(locala);
          break;
          parama = ai.getContext().getString(2131757201) + "-" + paramString.hjU;
          break label1184;
          locala.Imo.setText(2131757200);
        }
        if (bool) {
          if (ae.isNullOrNil(paramString.hjU))
          {
            parama = ai.getContext().getString(2131757195);
            locala.Imo.setText(k.c(parama1.HZF.getContext(), parama));
          }
        }
        for (;;)
        {
          locala.Imp.setText(paramString.hiM);
          locala.Imn.setImageResource(2131689851);
          a(locala);
          break;
          parama = ai.getContext().getString(2131757195) + "-" + paramString.hjU;
          break label1291;
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
        locala.ofC.setBackground(parama1.HZF.getMMResources().getDrawable(2131231681));
        locala.Imq.setVisibility(8);
        AppMethodBeat.o(37052);
        return;
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(37054);
    int i = ((bj)paramView.getTag()).position;
    String str = parambo.field_content;
    paramView = null;
    if (str != null) {
      paramView = k.b.az(str, parambo.field_reserved);
    }
    if (paramView != null) {
      paramContextMenu.add(i, 100, 0, this.HNS.HZF.getMMResources().getString(2131757221));
    }
    AppMethodBeat.o(37054);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    return false;
  }
  
  public final boolean b(View paramView, final com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37055);
    ((com.tencent.mm.plugin.comm.a.b)g.ab(com.tencent.mm.plugin.comm.a.b.class)).Wm(parambo.field_talker);
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
        ac.w("MicroMsg.ChattingItemAppMsgRemittanceTo", "Unrecognized type %d, probably version to low & check update!", new Object[] { Integer.valueOf(paramView.hiL) });
        ae.df(parama.HZF.getContext());
      }
      for (;;)
      {
        AppMethodBeat.o(37055);
        return true;
        ((Intent)localObject).putExtra("invalid_time", paramView.hiP);
        ((Intent)localObject).putExtra("is_sender", true);
        ((Intent)localObject).putExtra("appmsg_type", paramView.hiL);
        ((Intent)localObject).putExtra("transfer_id", paramView.hiO);
        ((Intent)localObject).putExtra("transaction_id", paramView.hiN);
        ((Intent)localObject).putExtra("effective_date", paramView.hiQ);
        ((Intent)localObject).putExtra("total_fee", paramView.dto);
        ((Intent)localObject).putExtra("fee_type", paramView.dbI);
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
              if (!bs.isNullOrNil(paramAnonymousIntent)) {
                h.c(parama.HZF.getContext(), paramAnonymousIntent, "", false);
              }
              AppMethodBeat.o(37050);
              return;
            }
            AppMethodBeat.o(37050);
          }
        };
        if (u.axL())
        {
          d.a(parama.HZC, "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", (Intent)localObject, 221, paramView);
        }
        else
        {
          d.a(parama.HZC, "remittance", ".ui.RemittanceDetailUI", (Intent)localObject, 221, paramView);
          continue;
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
    AppMethodBeat.o(37055);
    return false;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 419430449);
  }
  
  public final boolean fqu()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.c
 * JD-Core Version:    0.7.0.1
 */