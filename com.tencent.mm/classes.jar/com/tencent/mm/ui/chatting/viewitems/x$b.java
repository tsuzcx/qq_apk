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
import com.tencent.mm.g.a.xq;
import com.tencent.mm.g.a.xq.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;

public final class x$b
  extends c
{
  private com.tencent.mm.ui.chatting.d.a Gob;
  
  private static void a(x.a parama)
  {
    AppMethodBeat.i(37046);
    parama.naN.getPaddingLeft();
    parama.naN.getPaddingTop();
    parama.naN.getPaddingRight();
    parama.naN.getPaddingBottom();
    parama.naN.setBackgroundResource(2131231389);
    parama.naN.setPadding(0, 0, 0, 0);
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
      localObject = new af(paramLayoutInflater, 2131493446);
      ((View)localObject).setTag(new x.a().ga((View)localObject));
    }
    AppMethodBeat.o(37044);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(37045);
    this.Gob = parama1;
    x.a locala = (x.a)parama;
    parama = parambl.field_content;
    if (parama != null) {}
    for (paramString = k.b.ar(parama, parambl.field_reserved);; paramString = null)
    {
      if (paramString != null)
      {
        x.a.aE(locala.naN, locala.GJV);
        locala.naN.setBackgroundResource(2131231384);
        locala.naN.setPadding(0, 0, 0, 0);
        locala.GMr.setSingleLine(true);
        parama = new xq();
        parama.dDQ.dnZ = paramString.gIn;
        com.tencent.mm.sdk.b.a.ESL.l(parama);
        if (!parama.dDR.dDS) {}
        for (int i = 1;; i = 0)
        {
          if (parama.dDR.status == -2) {
            i = 0;
          }
          int k = parama.dDR.status;
          int j = k;
          if (k <= 0) {
            j = paramString.gIk;
          }
          switch (j)
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
            parama = new bi(parambl, parama1.eZb(), paramInt, null, '\000');
            locala.naN.setTag(parama);
            if (locala.nCB == null) {
              break label1329;
            }
            if (!ai.Eq()) {
              break label1298;
            }
            locala.nCB.setBackground(null);
            locala.GMt.setVisibility(0);
            AppMethodBeat.o(37045);
            return;
          }
        }
        parama = (j)paramString.ao(j.class);
        if (ae.isNullOrNil(paramString.gJu))
        {
          if (bt.iY(parama.gGW, 1)) {
            locala.GMr.setText(aj.getContext().getString(2131757198) + aj.getContext().getString(2131757199));
          }
          for (;;)
          {
            locala.GMs.setText(paramString.gIl);
            locala.GMq.setImageResource(2131689850);
            break;
            locala.GMr.setText(2131757198);
          }
        }
        if (bt.iY(parama.gGW, 1)) {
          if (paramString.gJu.length() > 5) {
            parama = paramString.gJu.substring(0, 5) + "..." + aj.getContext().getString(2131757199);
          }
        }
        label560:
        for (parama = k.c(parama1.GzJ.getContext(), parama);; parama = k.c(parama1.GzJ.getContext(), paramString.gJu))
        {
          locala.GMr.setText(parama);
          break;
          parama = paramString.gJu + parama1.GzJ.getContext().getString(2131757199);
          break label560;
        }
        if (i != 0) {
          if (bt.iY(((j)paramString.ao(j.class)).gGW, 1)) {
            if (ae.isNullOrNil(paramString.gJu))
            {
              parama = aj.getContext().getString(2131757188) + aj.getContext().getString(2131757199);
              label712:
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
          String str = aj.getContext().getString(2131757188) + "-" + paramString.gJu;
          parama = str;
          if (str.length() <= 5) {
            break label712;
          }
          parama = str.substring(0, 5) + "..." + aj.getContext().getString(2131757199);
          break label712;
          if (ae.isNullOrNil(paramString.gJu))
          {
            parama = aj.getContext().getString(2131757188);
            break label712;
          }
          parama = aj.getContext().getString(2131757188) + "-" + paramString.gJu;
          break label712;
          locala.GMr.setText(2131757189);
        }
        locala.GMs.setText(paramString.gIl);
        locala.GMq.setImageResource(2131689852);
        if (i != 0) {
          if (ae.isNullOrNil(paramString.gJu))
          {
            parama = aj.getContext().getString(2131757201);
            label983:
            locala.GMr.setText(k.c(parama1.GzJ.getContext(), parama));
          }
        }
        for (;;)
        {
          a(locala);
          break;
          parama = aj.getContext().getString(2131757201) + "-" + paramString.gJu;
          break label983;
          locala.GMr.setText(2131757200);
        }
        locala.GMs.setText(paramString.gIl);
        locala.GMq.setImageResource(2131689851);
        if (i != 0) {
          if (ae.isNullOrNil(paramString.gJu))
          {
            parama = aj.getContext().getString(2131757195);
            label1114:
            locala.GMr.setText(k.c(parama1.GzJ.getContext(), parama));
          }
        }
        for (;;)
        {
          a(locala);
          break;
          parama = aj.getContext().getString(2131757195) + "-" + paramString.gJu;
          break label1114;
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
        label1298:
        locala.nCB.setBackground(parama1.GzJ.getMMResources().getDrawable(2131231681));
        locala.GMt.setVisibility(8);
      }
      label1329:
      AppMethodBeat.o(37045);
      return;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(37047);
    int i = ((bi)paramView.getTag()).position;
    if (parambl != null) {
      paramContextMenu.add(i, 100, 0, this.Gob.GzJ.getMMResources().getString(2131757221));
    }
    AppMethodBeat.o(37047);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(37048);
    paramMenuItem.getItemId();
    AppMethodBeat.o(37048);
    return false;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 419430449);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(37049);
    ((b)g.ab(b.class)).Sa(parambl.field_talker);
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
        ad.w("MicroMsg.ChattingItemAppMsgRemittanceFrom", "Unrecognized type %d, probably version to low & check update!", new Object[] { Integer.valueOf(paramView.gIk) });
        ae.cW(parama.GzJ.getContext());
      }
      for (;;)
      {
        AppMethodBeat.o(37049);
        return true;
        ((Intent)localObject).putExtra("invalid_time", paramView.gIo);
        ((Intent)localObject).putExtra("is_sender", false);
        ((Intent)localObject).putExtra("appmsg_type", paramView.gIk);
        ((Intent)localObject).putExtra("transfer_id", paramView.gIn);
        ((Intent)localObject).putExtra("transaction_id", paramView.gIm);
        ((Intent)localObject).putExtra("effective_date", paramView.gIp);
        ((Intent)localObject).putExtra("total_fee", paramView.dvC);
        ((Intent)localObject).putExtra("fee_type", paramView.dem);
        if (u.aqV())
        {
          d.a(parama.GzJ, "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", (Intent)localObject, 221);
        }
        else
        {
          d.a(parama.GzJ, "remittance", ".ui.RemittanceDetailUI", (Intent)localObject, 221);
          continue;
          ((Intent)localObject).putExtra("is_sender", true);
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
    AppMethodBeat.o(37049);
    return false;
  }
  
  public final boolean faE()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.b
 * JD-Core Version:    0.7.0.1
 */