package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.d;
import com.tencent.mm.g.a.fk;
import com.tencent.mm.g.a.wm;
import com.tencent.mm.g.a.wm.b;
import com.tencent.mm.g.a.ya;
import com.tencent.mm.g.a.ya.a;
import com.tencent.mm.g.a.yb;
import com.tencent.mm.g.a.yb.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.chatting.s.e;

public final class bd$h
  extends s.e
{
  public bd$h(com.tencent.mm.ui.chatting.e.a parama)
  {
    super(parama);
  }
  
  private void c(bk parambk)
  {
    AppMethodBeat.i(177732);
    parambk.dBd.setStatus(6);
    ba.aBQ();
    c.azs().a(parambk.dBd.field_msgId, parambk.dBd);
    ((s)this.JBI.bh(s.class)).fDG();
    Object localObject = new yb();
    ((yb)localObject).dMo.dsi = 5;
    ((yb)localObject).dMo.talker = parambk.dBd.field_talker;
    ((yb)localObject).dMo.context = this.JBI.JOR.getContext();
    ((yb)localObject).dMo.dMk = 2;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = com.tencent.mm.plugin.report.service.g.yhR;
    if ((parambk.dBd.eLs == null) || (parambk.dBd.eLs.length() <= 0)) {}
    for (int i = 1;; i = 3)
    {
      ((com.tencent.mm.plugin.report.service.g)localObject).f(11033, new Object[] { Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(i) });
      AppMethodBeat.o(177732);
      return;
    }
  }
  
  public final void a(final View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(37535);
    paramView = (bk)paramView.getTag();
    parama = parambu.field_content;
    yb localyb = new yb();
    localyb.dMo.dsi = 1;
    localyb.dMo.content = parama;
    com.tencent.mm.sdk.b.a.IbL.l(localyb);
    if (localyb.dMp.type == 2)
    {
      i = 1;
      if ((i == 0) && (!parambu.field_content.equals(bu.IMe))) {
        break label414;
      }
      if ((!com.tencent.mm.s.a.cd(this.JBI.JOR.getContext())) && (!com.tencent.mm.s.a.ce(this.JBI.JOR.getContext())) && (!com.tencent.mm.s.a.ch(this.JBI.JOR.getContext())))
      {
        parama = new ya();
        com.tencent.mm.sdk.b.a.IbL.l(parama);
        if ((paramView.dBd.field_talker.equals(parama.dMm.talker)) || ((!parama.dMm.dkp) && (!parama.dMm.dkq))) {
          break label267;
        }
        if (!parama.dMm.dMn) {
          break label260;
        }
        i = 2131756778;
        label205:
        Toast.makeText(this.JBI.JOR.getContext(), i, 0).show();
        ad.i("MicroMsg.VoipClickListener", "voip is running, can't do this");
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).ZT(parambu.field_talker);
      AppMethodBeat.o(37535);
      return;
      i = 0;
      break;
      label260:
      i = 2131756779;
      break label205;
      label267:
      parama = new wm();
      parama.dKN.dKP = true;
      com.tencent.mm.sdk.b.a.IbL.l(parama);
      parama = parama.dKO.dKR;
      if (!af.isNullOrNil(parama))
      {
        ad.v("MicroMsg.VoipClickListener", "Talkroom is on: ".concat(String.valueOf(parama)));
        h.e(this.JBI.JOR.getContext(), this.JBI.JOR.getContext().getString(2131764350), "", this.JBI.JOR.getContext().getString(2131755835), this.JBI.JOR.getContext().getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(37533);
            Object localObject = new wm();
            ((wm)localObject).dKN.dKQ = true;
            com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
            localObject = new fk();
            ((fk)localObject).dqw.username = d.irv.aMm();
            com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
            bd.h.a(bd.h.this, paramView);
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
    parama = parambu.field_content;
    localyb = new yb();
    localyb.dMo.dsi = 1;
    localyb.dMo.content = parama;
    com.tencent.mm.sdk.b.a.IbL.l(localyb);
    if (localyb.dMp.type == 3)
    {
      i = 1;
      label470:
      if (((i == 0) && (!parambu.field_content.equals(bu.IMd))) || (com.tencent.mm.s.a.cd(this.JBI.JOR.getContext())) || (com.tencent.mm.s.a.ce(this.JBI.JOR.getContext())) || (com.tencent.mm.s.a.ch(this.JBI.JOR.getContext()))) {
        break label639;
      }
      parama = new ya();
      com.tencent.mm.sdk.b.a.IbL.l(parama);
      if ((paramView.dBd.field_talker.equals(parama.dMm.talker)) || ((!parama.dMm.dkp) && (!parama.dMm.dkq))) {
        break label648;
      }
      if (!parama.dMm.dMn) {
        break label641;
      }
    }
    label641:
    for (int i = 2131756778;; i = 2131756779)
    {
      Toast.makeText(this.JBI.JOR.getContext(), i, 0).show();
      ad.i("MicroMsg.VoipClickListener", "voip is running, can't do this");
      break;
      i = 0;
      break label470;
      label639:
      break;
    }
    label648:
    paramView.dBd.setStatus(6);
    ba.aBQ();
    c.azs().a(paramView.dBd.field_msgId, paramView.dBd);
    ((s)this.JBI.bh(s.class)).fDG();
    parama = new yb();
    parama.dMo.dsi = 5;
    parama.dMo.talker = paramView.dBd.field_talker;
    parama.dMo.context = this.JBI.JOR.getContext();
    parama.dMo.dMk = 4;
    com.tencent.mm.sdk.b.a.IbL.l(parama);
    parama = com.tencent.mm.plugin.report.service.g.yhR;
    if ((paramView.dBd.eLs == null) || (paramView.dBd.eLs.length() <= 0)) {}
    for (i = 1;; i = 3)
    {
      parama.f(11033, new Object[] { Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(i) });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bd.h
 * JD-Core Version:    0.7.0.1
 */