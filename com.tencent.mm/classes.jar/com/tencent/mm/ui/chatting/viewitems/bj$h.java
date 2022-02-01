package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.d;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.g.a.xq.b;
import com.tencent.mm.g.a.zi;
import com.tencent.mm.g.a.zi.a;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.g.a.zj.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.chatting.t.e;

public final class bj$h
  extends t.e
{
  public bj$h(com.tencent.mm.ui.chatting.e.a parama)
  {
    super(parama);
  }
  
  private void c(bq parambq)
  {
    AppMethodBeat.i(177732);
    parambq.dTX.setStatus(6);
    bg.aVF();
    c.aSQ().a(parambq.dTX.field_msgId, parambq.dTX);
    ((u)this.PhN.bh(u.class)).gPS();
    Object localObject = new zj();
    ((zj)localObject).efx.dKy = 5;
    ((zj)localObject).efx.talker = parambq.dTX.field_talker;
    ((zj)localObject).efx.context = this.PhN.Pwc.getContext();
    ((zj)localObject).efx.eft = 2;
    EventCenter.instance.publish((IEvent)localObject);
    localObject = com.tencent.mm.plugin.report.service.h.CyF;
    if ((parambq.dTX.fqK == null) || (parambq.dTX.fqK.length() <= 0)) {}
    for (int i = 1;; i = 3)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).a(11033, new Object[] { Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(i) });
      AppMethodBeat.o(177732);
      return;
    }
  }
  
  public final void a(final View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37535);
    paramView = (bq)paramView.getTag();
    parama = paramca.field_content;
    zj localzj = new zj();
    localzj.efx.dKy = 1;
    localzj.efx.content = parama;
    EventCenter.instance.publish(localzj);
    if (localzj.efy.type == 2)
    {
      i = 1;
      if ((i == 0) && (!paramca.field_content.equals(ca.OqC))) {
        break label431;
      }
      if ((!com.tencent.mm.q.a.cA(this.PhN.Pwc.getContext())) && (!com.tencent.mm.q.a.cB(this.PhN.Pwc.getContext())) && (!com.tencent.mm.q.a.cE(this.PhN.Pwc.getContext())) && (!com.tencent.mm.q.a.p(this.PhN.Pwc.getContext(), true)))
      {
        parama = new zi();
        EventCenter.instance.publish(parama);
        if ((paramView.dTX.field_talker.equals(parama.efv.talker)) || ((!parama.efv.dCH) && (!parama.efv.dCI))) {
          break label284;
        }
        if (!parama.efv.efw) {
          break label277;
        }
        i = 2131756942;
        label222:
        Toast.makeText(this.PhN.Pwc.getContext(), i, 0).show();
        Log.i("MicroMsg.VoipClickListener", "voip is running, can't do this");
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.comm.a.b)g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(paramca.field_talker);
      AppMethodBeat.o(37535);
      return;
      i = 0;
      break;
      label277:
      i = 2131756943;
      break label222;
      label284:
      parama = new xq();
      parama.edR.edT = true;
      EventCenter.instance.publish(parama);
      parama = parama.edS.edV;
      if (!af.isNullOrNil(parama))
      {
        Log.v("MicroMsg.VoipClickListener", "Talkroom is on: ".concat(String.valueOf(parama)));
        com.tencent.mm.ui.base.h.c(this.PhN.Pwc.getContext(), this.PhN.Pwc.getContext().getString(2131766611), "", this.PhN.Pwc.getContext().getString(2131755921), this.PhN.Pwc.getContext().getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(37533);
            Object localObject = new xq();
            ((xq)localObject).edR.edU = true;
            EventCenter.instance.publish((IEvent)localObject);
            localObject = new fo();
            ((fo)localObject).dIN.username = d.jpB.bgL();
            EventCenter.instance.publish((IEvent)localObject);
            bj.h.a(bj.h.this, paramView);
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(37533);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(37534);
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(37534);
          }
        });
      }
      else
      {
        c(paramView);
      }
    }
    label431:
    parama = paramca.field_content;
    localzj = new zj();
    localzj.efx.dKy = 1;
    localzj.efx.content = parama;
    EventCenter.instance.publish(localzj);
    if (localzj.efy.type == 3)
    {
      i = 1;
      label487:
      if (((i == 0) && (!paramca.field_content.equals(ca.OqB))) || (com.tencent.mm.q.a.cA(this.PhN.Pwc.getContext())) || (com.tencent.mm.q.a.cB(this.PhN.Pwc.getContext())) || (com.tencent.mm.q.a.cE(this.PhN.Pwc.getContext()))) {
        break label656;
      }
      parama = new zi();
      EventCenter.instance.publish(parama);
      if ((paramView.dTX.field_talker.equals(parama.efv.talker)) || ((!parama.efv.dCH) && (!parama.efv.dCI))) {
        break label665;
      }
      if (!parama.efv.efw) {
        break label658;
      }
    }
    label656:
    label658:
    for (int i = 2131756942;; i = 2131756943)
    {
      Toast.makeText(this.PhN.Pwc.getContext(), i, 0).show();
      Log.i("MicroMsg.VoipClickListener", "voip is running, can't do this");
      break;
      i = 0;
      break label487;
      break;
    }
    label665:
    paramView.dTX.setStatus(6);
    bg.aVF();
    c.aSQ().a(paramView.dTX.field_msgId, paramView.dTX);
    ((u)this.PhN.bh(u.class)).gPS();
    parama = new zj();
    parama.efx.dKy = 5;
    parama.efx.talker = paramView.dTX.field_talker;
    parama.efx.context = this.PhN.Pwc.getContext();
    parama.efx.eft = 4;
    EventCenter.instance.publish(parama);
    parama = com.tencent.mm.plugin.report.service.h.CyF;
    if ((paramView.dTX.fqK == null) || (paramView.dTX.fqK.length() <= 0)) {}
    for (i = 1;; i = 3)
    {
      parama.a(11033, new Object[] { Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(i) });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bj.h
 * JD-Core Version:    0.7.0.1
 */