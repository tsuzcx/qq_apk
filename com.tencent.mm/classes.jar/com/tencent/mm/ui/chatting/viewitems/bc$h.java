package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.d;
import com.tencent.mm.g.a.fh;
import com.tencent.mm.g.a.vt;
import com.tencent.mm.g.a.vt.b;
import com.tencent.mm.g.a.xg;
import com.tencent.mm.g.a.xg.a;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.g.a.xh.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.q;
import com.tencent.mm.ui.chatting.s.e;

public final class bc$h
  extends s.e
{
  public bc$h(com.tencent.mm.ui.chatting.d.a parama)
  {
    super(parama);
  }
  
  private void c(bj parambj)
  {
    AppMethodBeat.i(177732);
    parambj.dpq.setStatus(6);
    az.ayM();
    c.awD().a(parambj.dpq.field_msgId, parambj.dpq);
    ((q)this.HNS.bf(q.class)).fni();
    Object localObject = new xh();
    ((xh)localObject).dAb.dgL = 5;
    ((xh)localObject).dAb.talker = parambj.dpq.field_talker;
    ((xh)localObject).dAb.context = this.HNS.HZF.getContext();
    ((xh)localObject).dAb.dzX = 2;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = com.tencent.mm.plugin.report.service.h.wUl;
    if ((parambj.dpq.eul == null) || (parambj.dpq.eul.length() <= 0)) {}
    for (int i = 1;; i = 3)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).f(11033, new Object[] { Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(i) });
      AppMethodBeat.o(177732);
      return;
    }
  }
  
  public final void a(final View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37535);
    paramView = (bj)paramView.getTag();
    parama = parambo.field_content;
    xh localxh = new xh();
    localxh.dAb.dgL = 1;
    localxh.dAb.content = parama;
    com.tencent.mm.sdk.b.a.GpY.l(localxh);
    if (localxh.dAc.type == 2)
    {
      i = 1;
      if ((i == 0) && (!parambo.field_content.equals(bo.GYP))) {
        break label414;
      }
      if ((!com.tencent.mm.r.a.cf(this.HNS.HZF.getContext())) && (!com.tencent.mm.r.a.ch(this.HNS.HZF.getContext())) && (!com.tencent.mm.r.a.ck(this.HNS.HZF.getContext())))
      {
        parama = new xg();
        com.tencent.mm.sdk.b.a.GpY.l(parama);
        if ((paramView.dpq.field_talker.equals(parama.dzZ.talker)) || ((!parama.dzZ.cYX) && (!parama.dzZ.cYY))) {
          break label267;
        }
        if (!parama.dzZ.dAa) {
          break label260;
        }
        i = 2131756778;
        label205:
        Toast.makeText(this.HNS.HZF.getContext(), i, 0).show();
        ac.i("MicroMsg.VoipClickListener", "voip is running, can't do this");
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.comm.a.b)g.ab(com.tencent.mm.plugin.comm.a.b.class)).Wm(parambo.field_talker);
      AppMethodBeat.o(37535);
      return;
      i = 0;
      break;
      label260:
      i = 2131756779;
      break label205;
      label267:
      parama = new vt();
      parama.dyB.dyD = true;
      com.tencent.mm.sdk.b.a.GpY.l(parama);
      parama = parama.dyC.dyF;
      if (!ae.isNullOrNil(parama))
      {
        ac.v("MicroMsg.VoipClickListener", "Talkroom is on: ".concat(String.valueOf(parama)));
        com.tencent.mm.ui.base.h.d(this.HNS.HZF.getContext(), this.HNS.HZF.getContext().getString(2131764350), "", this.HNS.HZF.getContext().getString(2131755835), this.HNS.HZF.getContext().getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(37533);
            Object localObject = new vt();
            ((vt)localObject).dyB.dyE = true;
            com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
            localObject = new fh();
            ((fh)localObject).dfa.username = d.hXZ.aJc();
            com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
            bc.h.a(bc.h.this, paramView);
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
    label414:
    parama = parambo.field_content;
    localxh = new xh();
    localxh.dAb.dgL = 1;
    localxh.dAb.content = parama;
    com.tencent.mm.sdk.b.a.GpY.l(localxh);
    if (localxh.dAc.type == 3)
    {
      i = 1;
      label470:
      if (((i == 0) && (!parambo.field_content.equals(bo.GYO))) || (com.tencent.mm.r.a.cf(this.HNS.HZF.getContext())) || (com.tencent.mm.r.a.ch(this.HNS.HZF.getContext())) || (com.tencent.mm.r.a.ck(this.HNS.HZF.getContext()))) {
        break label639;
      }
      parama = new xg();
      com.tencent.mm.sdk.b.a.GpY.l(parama);
      if ((paramView.dpq.field_talker.equals(parama.dzZ.talker)) || ((!parama.dzZ.cYX) && (!parama.dzZ.cYY))) {
        break label648;
      }
      if (!parama.dzZ.dAa) {
        break label641;
      }
    }
    label641:
    for (int i = 2131756778;; i = 2131756779)
    {
      Toast.makeText(this.HNS.HZF.getContext(), i, 0).show();
      ac.i("MicroMsg.VoipClickListener", "voip is running, can't do this");
      break;
      i = 0;
      break label470;
      label639:
      break;
    }
    label648:
    paramView.dpq.setStatus(6);
    az.ayM();
    c.awD().a(paramView.dpq.field_msgId, paramView.dpq);
    ((q)this.HNS.bf(q.class)).fni();
    parama = new xh();
    parama.dAb.dgL = 5;
    parama.dAb.talker = paramView.dpq.field_talker;
    parama.dAb.context = this.HNS.HZF.getContext();
    parama.dAb.dzX = 4;
    com.tencent.mm.sdk.b.a.GpY.l(parama);
    parama = com.tencent.mm.plugin.report.service.h.wUl;
    if ((paramView.dpq.eul == null) || (paramView.dpq.eul.length() <= 0)) {}
    for (i = 1;; i = 3)
    {
      parama.f(11033, new Object[] { Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(i) });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bc.h
 * JD-Core Version:    0.7.0.1
 */