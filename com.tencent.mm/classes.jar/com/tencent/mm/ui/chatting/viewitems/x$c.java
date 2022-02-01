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
import com.tencent.mm.ai.j;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.bs.d;
import com.tencent.mm.bs.d.a;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.g.a.xq.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;

public final class x$c
  extends c
{
  private com.tencent.mm.ui.chatting.d.a Gob;
  
  private static void a(x.a parama)
  {
    AppMethodBeat.i(37053);
    parama.naN.getPaddingLeft();
    parama.naN.getPaddingTop();
    parama.naN.getPaddingRight();
    parama.naN.getPaddingBottom();
    parama.naN.setBackgroundResource(2131231395);
    parama.naN.setPadding(0, 0, 0, 0);
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
      localObject = new af(paramLayoutInflater, 2131493490);
      ((View)localObject).setTag(new x.a().ga((View)localObject));
    }
    AppMethodBeat.o(37051);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(37052);
    this.Gob = parama1;
    x.a locala = (x.a)parama;
    parama = parambl.field_content;
    if (parama != null) {}
    for (paramString = k.b.ar(parama, parambl.field_reserved);; paramString = null)
    {
      boolean bool;
      label400:
      Object localObject;
      if (paramString != null)
      {
        x.a.aE(locala.naN, locala.GJV);
        locala.naN.setBackgroundResource(2131231390);
        locala.naN.setPadding(0, 0, 0, 0);
        locala.GMr.setSingleLine(true);
        parama = new xq();
        parama.dDQ.dnZ = paramString.gIn;
        com.tencent.mm.sdk.b.a.ESL.l(parama);
        bool = parama.dDR.dDS;
        if (parama.dDR.status == -2) {
          bool = false;
        }
        int j = parama.dDR.status;
        int i = j;
        if (j <= 0) {
          i = paramString.gIk;
        }
        switch (i)
        {
        case 2: 
        default: 
          locala.GMq.setImageResource(2131689850);
          locala.GMr.setSingleLine(false);
          locala.GMr.setMaxLines(2);
          locala.GMs.setText(null);
          locala.GMr.setText(paramString.description);
          locala.naN.setOnClickListener(d(parama1));
          locala.naN.setOnLongClickListener(c(parama1));
          locala.naN.setOnTouchListener(((i)parama1.be(i.class)).eWp());
          parama = new bi(parambl, this.Gob.eZb(), paramInt, null, '\000');
          locala.naN.setTag(parama);
          if (locala.nCB != null) {
            if (ai.Eq())
            {
              locala.nCB.setBackground(null);
              locala.GMt.setVisibility(0);
              AppMethodBeat.o(37052);
              return;
            }
          }
          break;
        case 1: 
        case 7: 
          az.arV();
          parama = com.tencent.mm.model.c.apM().aHX(parambl.field_talker);
          if (parama != null)
          {
            parama = parama.ZX();
            if (!ae.isNullOrNil(paramString.gJu)) {
              break label634;
            }
            localObject = parama1.GzJ.getMMResources().getString(2131757197, new Object[] { ae.nullAsNil(parama) });
            locala.GMr.setText(k.b(parama1.GzJ.getContext(), (CharSequence)localObject, locala.GMr.getTextSize()));
            label465:
            localObject = (j)paramString.ao(j.class);
            if (!ae.isNullOrNil(paramString.gJu)) {
              break label694;
            }
            parama = parama1.GzJ.getMMResources().getString(2131757197, new Object[] { ae.nullAsNil(parama) });
            if (!bt.iY(((j)localObject).gGW, 1)) {
              break label1536;
            }
            if (parama.length() <= 5) {
              break label664;
            }
            parama = parama.substring(0, 5) + "..." + aj.getContext().getString(2131757199);
          }
          break;
        }
      }
      label1536:
      for (;;)
      {
        locala.GMr.setText(k.b(parama1.GzJ.getContext(), parama, locala.GMr.getTextSize()));
        locala.GMs.setText(paramString.gIl);
        locala.GMq.setImageResource(2131689850);
        break;
        parama = parambl.field_talker;
        break label400;
        label634:
        localObject = k.c(parama1.GzJ.getContext(), paramString.gJu);
        locala.GMr.setText((CharSequence)localObject);
        break label465;
        label664:
        parama = parama + aj.getContext().getString(2131757199);
        continue;
        label694:
        if (bt.iY(((j)localObject).gGW, 1)) {
          if (paramString.gJu.length() > 5) {
            parama = paramString.gJu.substring(0, 5) + "..." + aj.getContext().getString(2131757199);
          }
        }
        label760:
        for (parama = k.c(parama1.GzJ.getContext(), parama);; parama = k.c(parama1.GzJ.getContext(), paramString.gJu))
        {
          locala.GMr.setText(parama);
          break;
          parama = paramString.gJu + parama1.GzJ.getContext().getString(2131757199);
          break label760;
        }
        if (bool) {
          if (bt.iY(((j)paramString.ao(j.class)).gGW, 1)) {
            if (ae.isNullOrNil(paramString.gJu))
            {
              parama = aj.getContext().getString(2131757188) + aj.getContext().getString(2131757199);
              label913:
              locala.GMr.setText(k.c(parama1.GzJ.getContext(), parama));
            }
          }
        }
        for (;;)
        {
          locala.GMs.setText(paramString.gIl);
          locala.GMq.setImageResource(2131689851);
          a(locala);
          break;
          localObject = aj.getContext().getString(2131757188) + "-" + paramString.gJu;
          parama = (c.a)localObject;
          if (((String)localObject).length() <= 5) {
            break label913;
          }
          parama = ((String)localObject).substring(0, 5) + "..." + aj.getContext().getString(2131757199);
          break label913;
          if (ae.isNullOrNil(paramString.gJu))
          {
            parama = aj.getContext().getString(2131757188);
            break label913;
          }
          parama = aj.getContext().getString(2131757188) + "-" + paramString.gJu;
          break label913;
          locala.GMr.setText(2131757189);
        }
        locala.GMs.setText(paramString.gIl);
        locala.GMq.setImageResource(2131689852);
        if (bool) {
          if (ae.isNullOrNil(paramString.gJu))
          {
            parama = aj.getContext().getString(2131757201);
            label1184:
            locala.GMr.setText(k.c(parama1.GzJ.getContext(), parama));
          }
        }
        for (;;)
        {
          a(locala);
          break;
          parama = aj.getContext().getString(2131757201) + "-" + paramString.gJu;
          break label1184;
          locala.GMr.setText(2131757200);
        }
        if (bool) {
          if (ae.isNullOrNil(paramString.gJu))
          {
            parama = aj.getContext().getString(2131757195);
            label1291:
            locala.GMr.setText(k.c(parama1.GzJ.getContext(), parama));
          }
        }
        for (;;)
        {
          locala.GMs.setText(paramString.gIl);
          locala.GMq.setImageResource(2131689851);
          a(locala);
          break;
          parama = aj.getContext().getString(2131757195) + "-" + paramString.gJu;
          break label1291;
          locala.GMr.setText(2131757196);
        }
        if (ae.isNullOrNil(paramString.gJu)) {
          locala.GMr.setText(2131757190);
        }
        for (;;)
        {
          locala.GMs.setText(paramString.gIl);
          locala.GMq.setImageResource(2131689849);
          a(locala);
          break;
          parama = aj.getContext().getString(2131757190) + "-" + paramString.gJu;
          locala.GMr.setText(parama);
        }
        locala.nCB.setBackground(parama1.GzJ.getMMResources().getDrawable(2131231681));
        locala.GMt.setVisibility(8);
        AppMethodBeat.o(37052);
        return;
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(37054);
    int i = ((bi)paramView.getTag()).position;
    String str = parambl.field_content;
    paramView = null;
    if (str != null) {
      paramView = k.b.ar(str, parambl.field_reserved);
    }
    if (paramView != null) {
      paramContextMenu.add(i, 100, 0, this.Gob.GzJ.getMMResources().getString(2131757221));
    }
    AppMethodBeat.o(37054);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    return false;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 419430449);
  }
  
  public final boolean b(View paramView, final com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(37055);
    ((com.tencent.mm.plugin.comm.a.b)g.ab(com.tencent.mm.plugin.comm.a.b.class)).Sa(parambl.field_talker);
    Object localObject = parambl.field_content;
    paramView = null;
    if (localObject != null) {
      paramView = k.b.ar((String)localObject, parambl.field_reserved);
    }
    if (paramView != null)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("sender_name", parambl.field_talker);
      switch (paramView.gIk)
      {
      case 2: 
      default: 
        ad.w("MicroMsg.ChattingItemAppMsgRemittanceTo", "Unrecognized type %d, probably version to low & check update!", new Object[] { Integer.valueOf(paramView.gIk) });
        ae.cW(parama.GzJ.getContext());
      }
      for (;;)
      {
        AppMethodBeat.o(37055);
        return true;
        ((Intent)localObject).putExtra("invalid_time", paramView.gIo);
        ((Intent)localObject).putExtra("is_sender", true);
        ((Intent)localObject).putExtra("appmsg_type", paramView.gIk);
        ((Intent)localObject).putExtra("transfer_id", paramView.gIn);
        ((Intent)localObject).putExtra("transaction_id", paramView.gIm);
        ((Intent)localObject).putExtra("effective_date", paramView.gIp);
        ((Intent)localObject).putExtra("total_fee", paramView.dvC);
        ((Intent)localObject).putExtra("fee_type", paramView.dem);
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
                h.c(parama.GzJ.getContext(), paramAnonymousIntent, "", false);
              }
              AppMethodBeat.o(37050);
              return;
            }
            AppMethodBeat.o(37050);
          }
        };
        if (u.aqV())
        {
          d.a(parama.GzG, "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", (Intent)localObject, 221, paramView);
        }
        else
        {
          d.a(parama.GzG, "remittance", ".ui.RemittanceDetailUI", (Intent)localObject, 221, paramView);
          continue;
          ((Intent)localObject).putExtra("appmsg_type", paramView.gIk);
          ((Intent)localObject).putExtra("transfer_id", paramView.gIn);
          ((Intent)localObject).putExtra("transaction_id", paramView.gIm);
          ((Intent)localObject).putExtra("effective_date", paramView.gIp);
          ((Intent)localObject).putExtra("total_fee", paramView.dvC);
          ((Intent)localObject).putExtra("fee_type", paramView.dem);
          if (u.aqV()) {
            d.b(parama.GzJ.getContext(), "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", (Intent)localObject);
          } else {
            d.b(parama.GzJ.getContext(), "remittance", ".ui.RemittanceDetailUI", (Intent)localObject);
          }
        }
      }
    }
    AppMethodBeat.o(37055);
    return false;
  }
  
  public final boolean faE()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.c
 * JD-Core Version:    0.7.0.1
 */