package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.d;
import com.tencent.mm.g.a.fg;
import com.tencent.mm.g.a.vj;
import com.tencent.mm.g.a.vj.b;
import com.tencent.mm.g.a.wv;
import com.tencent.mm.g.a.wv.a;
import com.tencent.mm.g.a.ww;
import com.tencent.mm.g.a.ww.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.q;
import com.tencent.mm.ui.chatting.s.e;

public final class bb$h
  extends s.e
{
  public bb$h(com.tencent.mm.ui.chatting.d.a parama)
  {
    super(parama);
  }
  
  private void c(bi parambi)
  {
    AppMethodBeat.i(177732);
    parambi.drF.setStatus(6);
    az.arV();
    c.apO().a(parambi.drF.field_msgId, parambi.drF);
    ((q)this.Gob.be(q.class)).eXw();
    Object localObject = new ww();
    ((ww)localObject).dCp.djq = 5;
    ((ww)localObject).dCp.talker = parambi.drF.field_talker;
    ((ww)localObject).dCp.context = this.Gob.GzJ.getContext();
    ((ww)localObject).dCp.dCj = 2;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = com.tencent.mm.plugin.report.service.h.vKh;
    if ((parambi.drF.esh == null) || (parambi.drF.esh.length() <= 0)) {}
    for (int i = 1;; i = 3)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).f(11033, new Object[] { Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(i) });
      AppMethodBeat.o(177732);
      return;
    }
  }
  
  public final void a(final View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(37535);
    paramView = (bi)paramView.getTag();
    parama = parambl.field_content;
    ww localww = new ww();
    localww.dCp.djq = 1;
    localww.dCp.content = parama;
    com.tencent.mm.sdk.b.a.ESL.l(localww);
    if (localww.dCq.type == 2)
    {
      i = 1;
      if ((i == 0) && (!parambl.field_content.equals(bl.FzN))) {
        break label398;
      }
      if ((!com.tencent.mm.r.a.cc(this.Gob.GzJ.getContext())) && (!com.tencent.mm.r.a.dV(this.Gob.GzJ.getContext())))
      {
        parama = new wv();
        com.tencent.mm.sdk.b.a.ESL.l(parama);
        if ((paramView.drF.field_talker.equals(parama.dCl.talker)) || ((!parama.dCl.dCn) && (!parama.dCl.dCo))) {
          break label251;
        }
        if (!parama.dCl.dCm) {
          break label244;
        }
        i = 2131756778;
        label189:
        Toast.makeText(this.Gob.GzJ.getContext(), i, 0).show();
        ad.i("MicroMsg.VoipClickListener", "voip is running, can't do this");
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.comm.a.b)g.ab(com.tencent.mm.plugin.comm.a.b.class)).Sa(parambl.field_talker);
      AppMethodBeat.o(37535);
      return;
      i = 0;
      break;
      label244:
      i = 2131756779;
      break label189;
      label251:
      parama = new vj();
      parama.dAP.dAR = true;
      com.tencent.mm.sdk.b.a.ESL.l(parama);
      parama = parama.dAQ.dAT;
      if (!ae.isNullOrNil(parama))
      {
        ad.v("MicroMsg.VoipClickListener", "Talkroom is on: ".concat(String.valueOf(parama)));
        com.tencent.mm.ui.base.h.d(this.Gob.GzJ.getContext(), this.Gob.GzJ.getContext().getString(2131764350), "", this.Gob.GzJ.getContext().getString(2131755835), this.Gob.GzJ.getContext().getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(37533);
            Object localObject = new vj();
            ((vj)localObject).dAP.dAS = true;
            com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
            localObject = new fg();
            ((fg)localObject).dhF.username = d.hxy.aCm();
            com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
            bb.h.a(bb.h.this, paramView);
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
    label398:
    parama = parambl.field_content;
    localww = new ww();
    localww.dCp.djq = 1;
    localww.dCp.content = parama;
    com.tencent.mm.sdk.b.a.ESL.l(localww);
    if (localww.dCq.type == 3)
    {
      i = 1;
      label454:
      if (((i == 0) && (!parambl.field_content.equals(bl.FzM))) || (com.tencent.mm.r.a.cc(this.Gob.GzJ.getContext())) || (com.tencent.mm.r.a.dV(this.Gob.GzJ.getContext()))) {
        break label607;
      }
      parama = new wv();
      com.tencent.mm.sdk.b.a.ESL.l(parama);
      if ((paramView.drF.field_talker.equals(parama.dCl.talker)) || ((!parama.dCl.dCn) && (!parama.dCl.dCo))) {
        break label616;
      }
      if (!parama.dCl.dCm) {
        break label609;
      }
    }
    label607:
    label609:
    for (int i = 2131756778;; i = 2131756779)
    {
      Toast.makeText(this.Gob.GzJ.getContext(), i, 0).show();
      ad.i("MicroMsg.VoipClickListener", "voip is running, can't do this");
      break;
      i = 0;
      break label454;
      break;
    }
    label616:
    paramView.drF.setStatus(6);
    az.arV();
    c.apO().a(paramView.drF.field_msgId, paramView.drF);
    ((q)this.Gob.be(q.class)).eXw();
    parama = new ww();
    parama.dCp.djq = 5;
    parama.dCp.talker = paramView.drF.field_talker;
    parama.dCp.context = this.Gob.GzJ.getContext();
    parama.dCp.dCj = 4;
    com.tencent.mm.sdk.b.a.ESL.l(parama);
    parama = com.tencent.mm.plugin.report.service.h.vKh;
    if ((paramView.drF.esh == null) || (paramView.drF.esh.length() <= 0)) {}
    for (i = 1;; i = 3)
    {
      parama.f(11033, new Object[] { Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(i) });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bb.h
 * JD-Core Version:    0.7.0.1
 */