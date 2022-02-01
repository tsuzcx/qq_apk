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
import com.tencent.mm.ag.j;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.a.aag;
import com.tencent.mm.g.a.aag.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;

public final class ae$b
  extends c
{
  private a PhN;
  
  private static void a(ae.a parama)
  {
    AppMethodBeat.i(37046);
    parama.clickArea.getPaddingLeft();
    parama.clickArea.getPaddingTop();
    parama.clickArea.getPaddingRight();
    parama.clickArea.getPaddingBottom();
    parama.clickArea.setBackgroundResource(2131231453);
    parama.clickArea.setPadding(0, 0, 0, 0);
    if (parama.qdl != null)
    {
      if (!ao.isDarkMode()) {
        break label129;
      }
      parama.PLC.setAlpha(0.3F);
      parama.PLD.setAlpha(0.3F);
      parama.PLE.setAlpha(0.3F);
      parama.PLF.setAlpha(0.3F);
    }
    for (;;)
    {
      parama.qdl.setBackgroundResource(2131101287);
      parama.HMl.setVisibility(0);
      AppMethodBeat.o(37046);
      return;
      label129:
      parama.PLC.setAlpha(1.0F);
      parama.PLD.setAlpha(1.0F);
      parama.PLE.setAlpha(1.0F);
      parama.PLF.setAlpha(0.8F);
    }
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
      localObject = new an(paramLayoutInflater, 2131493547);
      ((View)localObject).setTag(new ae.a().gZ((View)localObject));
    }
    AppMethodBeat.o(37044);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37045);
    this.PhN = parama1;
    ae.a locala = (ae.a)parama;
    parama = paramca.field_content;
    if (parama != null) {}
    for (paramString = k.b.aD(parama, paramca.field_reserved);; paramString = null)
    {
      int i;
      label129:
      int j;
      if (paramString != null)
      {
        locala.resetChatBubbleWidth(locala.clickArea, locala.PJa);
        locala.clickArea.setBackgroundResource(2131231448);
        locala.clickArea.setPadding(0, 0, 0, 0);
        locala.PLD.setSingleLine(true);
        parama = new aag();
        parama.ehb.dQp = paramString.ixQ;
        EventCenter.instance.publish(parama);
        if (parama.ehc.ehd) {
          break label418;
        }
        i = 1;
        if (parama.ehc.status == -2) {
          i = 0;
        }
        int k = parama.ehc.status;
        j = k;
        if (k <= 0) {
          j = paramString.ixN;
        }
        if (locala.qdl != null)
        {
          if (!ao.isDarkMode()) {
            break label424;
          }
          locala.PLC.setAlpha(0.8F);
          locala.PLD.setAlpha(0.8F);
          locala.PLE.setAlpha(0.8F);
          locala.PLF.setAlpha(0.5F);
        }
      }
      for (;;)
      {
        locala.qdl.setBackgroundResource(2131101287);
        locala.HMl.setVisibility(0);
        switch (j)
        {
        default: 
          locala.PLC.setImageResource(2131689865);
          locala.PLD.setSingleLine(false);
          locala.PLD.setMaxLines(2);
          locala.PLE.setText(null);
          locala.PLD.setText(paramString.description);
          locala.clickArea.setOnClickListener(d(parama1));
          locala.clickArea.setOnLongClickListener(c(parama1));
          locala.clickArea.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
          parama = new bq(paramca, parama1.gRM(), paramInt, null, '\000');
          locala.clickArea.setTag(parama);
          AppMethodBeat.o(37045);
          return;
          label418:
          i = 0;
          break label129;
          label424:
          locala.PLC.setAlpha(1.0F);
          locala.PLD.setAlpha(1.0F);
          locala.PLE.setAlpha(1.0F);
          locala.PLF.setAlpha(0.8F);
        }
      }
      parama = (j)paramString.as(j.class);
      if (parama1.gRM()) {
        locala.PLD.setText(2131757405);
      }
      for (;;)
      {
        locala.PLE.setText(paramString.ixO);
        locala.PLC.setImageResource(2131689865);
        break;
        if (!af.isNullOrNil(paramString.iyX)) {
          break label599;
        }
        if (Util.isEqual(parama.iwA, 1)) {
          locala.PLD.setText(MMApplicationContext.getContext().getString(2131757407) + MMApplicationContext.getContext().getString(2131757408));
        } else {
          locala.PLD.setText(2131757407);
        }
      }
      label599:
      if (Util.isEqual(parama.iwA, 1)) {
        if (paramString.iyX.length() > 5) {
          parama = paramString.iyX.substring(0, 5) + "..." + MMApplicationContext.getContext().getString(2131757408);
        }
      }
      label664:
      for (parama = l.c(parama1.Pwc.getContext(), parama);; parama = l.c(parama1.Pwc.getContext(), paramString.iyX))
      {
        locala.PLD.setText(parama);
        break;
        parama = paramString.iyX + parama1.Pwc.getContext().getString(2131757408);
        break label664;
      }
      if (parama1.gRM()) {
        locala.PLD.setText(2131757393);
      }
      for (;;)
      {
        locala.PLE.setText(paramString.ixO);
        locala.PLC.setImageResource(2131689866);
        a(locala);
        break;
        if (i != 0)
        {
          if (Util.isEqual(((j)paramString.as(j.class)).iwA, 1)) {
            if (af.isNullOrNil(paramString.iyX)) {
              parama = MMApplicationContext.getContext().getString(2131757395) + MMApplicationContext.getContext().getString(2131757408);
            }
          }
          for (;;)
          {
            locala.PLD.setText(l.c(parama1.Pwc.getContext(), parama));
            break;
            String str = MMApplicationContext.getContext().getString(2131757395) + "-" + paramString.iyX;
            parama = str;
            if (str.length() > 5)
            {
              parama = str.substring(0, 5) + "..." + MMApplicationContext.getContext().getString(2131757408);
              continue;
              if (af.isNullOrNil(paramString.iyX)) {
                parama = MMApplicationContext.getContext().getString(2131757395);
              } else {
                parama = MMApplicationContext.getContext().getString(2131757395) + "-" + paramString.iyX;
              }
            }
          }
        }
        locala.PLD.setText(2131757396);
      }
      if (parama1.gRM()) {
        locala.PLD.setText(2131757409);
      }
      for (;;)
      {
        locala.PLE.setText(paramString.ixO);
        locala.PLC.setImageResource(2131689864);
        a(locala);
        break;
        if (i != 0)
        {
          if (af.isNullOrNil(paramString.iyX)) {}
          for (parama = MMApplicationContext.getContext().getString(2131757411);; parama = MMApplicationContext.getContext().getString(2131757411) + "-" + paramString.iyX)
          {
            locala.PLD.setText(l.c(parama1.Pwc.getContext(), parama));
            break;
          }
        }
        locala.PLD.setText(2131757410);
      }
      if (parama1.gRM()) {
        locala.PLD.setText(2131757404);
      }
      for (;;)
      {
        locala.PLE.setText(paramString.ixO);
        locala.PLC.setImageResource(2131689866);
        a(locala);
        break;
        if (i != 0)
        {
          if (af.isNullOrNil(paramString.iyX)) {}
          for (parama = MMApplicationContext.getContext().getString(2131757402);; parama = MMApplicationContext.getContext().getString(2131757402) + "-" + paramString.iyX)
          {
            locala.PLD.setText(l.c(parama1.Pwc.getContext(), parama));
            break;
          }
        }
        locala.PLD.setText(2131757403);
      }
      if (parama1.gRM()) {
        locala.PLD.setText(2131757414);
      }
      for (;;)
      {
        locala.PLE.setText(paramString.ixO);
        locala.PLC.setImageResource(2131689865);
        a(locala);
        break;
        if (af.isNullOrNil(paramString.iyX))
        {
          locala.PLD.setText(2131757413);
        }
        else
        {
          parama = MMApplicationContext.getContext().getString(2131757413) + "-" + paramString.iyX;
          locala.PLD.setText(parama);
        }
      }
      if (af.isNullOrNil(paramString.iyX)) {
        locala.PLD.setText(2131757397);
      }
      for (;;)
      {
        locala.PLE.setText(paramString.ixO);
        locala.PLC.setImageResource(2131689864);
        a(locala);
        break;
        parama = MMApplicationContext.getContext().getString(2131757397) + "-" + paramString.iyX;
        locala.PLD.setText(parama);
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    AppMethodBeat.i(37048);
    paramMenuItem.getItemId();
    AppMethodBeat.o(37048);
    return false;
  }
  
  public final boolean a(m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233791);
    int i = ((bq)paramView.getTag()).position;
    if (paramca != null) {
      paramm.a(i, 100, this.PhN.Pwc.getMMResources().getString(2131757433), 2131690529);
    }
    AppMethodBeat.o(233791);
    return false;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 419430449);
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(37049);
    if (!WeChatBrands.Business.Entries.SessionPayment.checkAvailable(paramView.getContext()))
    {
      AppMethodBeat.o(37049);
      return true;
    }
    ((b)g.af(b.class)).akR(paramca.field_talker);
    Object localObject = paramca.field_content;
    paramView = null;
    if (localObject != null) {
      paramView = k.b.aD((String)localObject, paramca.field_reserved);
    }
    if (paramView != null)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("sender_name", paramca.field_talker);
      switch (paramView.ixN)
      {
      case 2: 
      default: 
        Log.w("MicroMsg.ChattingItemAppMsgRemittanceFrom", "Unrecognized type %d, probably version to low & check update!", new Object[] { Integer.valueOf(paramView.ixN) });
        af.dA(parama.Pwc.getContext());
      }
      for (;;)
      {
        AppMethodBeat.o(37049);
        return true;
        ((Intent)localObject).putExtra("invalid_time", paramView.ixR);
        ((Intent)localObject).putExtra("is_sender", false);
        ((Intent)localObject).putExtra("appmsg_type", paramView.ixN);
        ((Intent)localObject).putExtra("transfer_id", paramView.ixQ);
        ((Intent)localObject).putExtra("transaction_id", paramView.ixP);
        ((Intent)localObject).putExtra("effective_date", paramView.ixS);
        ((Intent)localObject).putExtra("total_fee", paramView.dYg);
        ((Intent)localObject).putExtra("fee_type", paramView.dFv);
        if (z.aUo())
        {
          com.tencent.mm.br.c.a(parama.Pwc, "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", (Intent)localObject, 221);
        }
        else
        {
          com.tencent.mm.br.c.a(parama.Pwc, "remittance", ".ui.RemittanceDetailUI", (Intent)localObject, 221);
          continue;
          ((Intent)localObject).putExtra("is_sender", true);
          ((Intent)localObject).putExtra("appmsg_type", paramView.ixN);
          ((Intent)localObject).putExtra("transfer_id", paramView.ixQ);
          ((Intent)localObject).putExtra("transaction_id", paramView.ixP);
          ((Intent)localObject).putExtra("effective_date", paramView.ixS);
          ((Intent)localObject).putExtra("total_fee", paramView.dYg);
          ((Intent)localObject).putExtra("fee_type", paramView.dFv);
          if (z.aUo()) {
            com.tencent.mm.br.c.b(parama.Pwc.getContext(), "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", (Intent)localObject);
          } else {
            com.tencent.mm.br.c.b(parama.Pwc.getContext(), "remittance", ".ui.RemittanceDetailUI", (Intent)localObject);
          }
        }
      }
    }
    AppMethodBeat.o(37049);
    return false;
  }
  
  public final boolean gTT()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ae.b
 * JD-Core Version:    0.7.0.1
 */