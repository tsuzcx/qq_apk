package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.d;
import com.tencent.mm.g.a.fl;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.wq.b;
import com.tencent.mm.g.a.yg;
import com.tencent.mm.g.a.yg.a;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.g.a.yh.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.chatting.t.e;

public final class bd$h
  extends t.e
{
  public bd$h(com.tencent.mm.ui.chatting.e.a parama)
  {
    super(parama);
  }
  
  private void c(bk parambk)
  {
    AppMethodBeat.i(177732);
    parambk.dCi.setStatus(6);
    bc.aCg();
    c.azI().a(parambk.dCi.field_msgId, parambk.dCi);
    ((s)this.JWz.bh(s.class)).fHJ();
    Object localObject = new yh();
    ((yh)localObject).dNE.dto = 5;
    ((yh)localObject).dNE.talker = parambk.dCi.field_talker;
    ((yh)localObject).dNE.context = this.JWz.Kkd.getContext();
    ((yh)localObject).dNE.dNA = 2;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = com.tencent.mm.plugin.report.service.g.yxI;
    if ((parambk.dCi.eNd == null) || (parambk.dCi.eNd.length() <= 0)) {}
    for (int i = 1;; i = 3)
    {
      ((com.tencent.mm.plugin.report.service.g)localObject).f(11033, new Object[] { Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(i) });
      AppMethodBeat.o(177732);
      return;
    }
  }
  
  public final void a(final View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37535);
    paramView = (bk)paramView.getTag();
    parama = parambv.field_content;
    yh localyh = new yh();
    localyh.dNE.dto = 1;
    localyh.dNE.content = parama;
    com.tencent.mm.sdk.b.a.IvT.l(localyh);
    if (localyh.dNF.type == 2)
    {
      i = 1;
      if ((i == 0) && (!parambv.field_content.equals(bv.JgL))) {
        break label414;
      }
      if ((!com.tencent.mm.r.a.cf(this.JWz.Kkd.getContext())) && (!com.tencent.mm.r.a.cg(this.JWz.Kkd.getContext())) && (!com.tencent.mm.r.a.cj(this.JWz.Kkd.getContext())))
      {
        parama = new yg();
        com.tencent.mm.sdk.b.a.IvT.l(parama);
        if ((paramView.dCi.field_talker.equals(parama.dNC.talker)) || ((!parama.dNC.dlr) && (!parama.dNC.dls))) {
          break label267;
        }
        if (!parama.dNC.dND) {
          break label260;
        }
        i = 2131756778;
        label205:
        Toast.makeText(this.JWz.Kkd.getContext(), i, 0).show();
        ae.i("MicroMsg.VoipClickListener", "voip is running, can't do this");
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).aaK(parambv.field_talker);
      AppMethodBeat.o(37535);
      return;
      i = 0;
      break;
      label260:
      i = 2131756779;
      break label205;
      label267:
      parama = new wq();
      parama.dMc.dMe = true;
      com.tencent.mm.sdk.b.a.IvT.l(parama);
      parama = parama.dMd.dMg;
      if (!af.isNullOrNil(parama))
      {
        ae.v("MicroMsg.VoipClickListener", "Talkroom is on: ".concat(String.valueOf(parama)));
        h.e(this.JWz.Kkd.getContext(), this.JWz.Kkd.getContext().getString(2131764350), "", this.JWz.Kkd.getContext().getString(2131755835), this.JWz.Kkd.getContext().getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(37533);
            Object localObject = new wq();
            ((wq)localObject).dMc.dMf = true;
            com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
            localObject = new fl();
            ((fl)localObject).drB.username = d.iup.aMK();
            com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
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
    parama = parambv.field_content;
    localyh = new yh();
    localyh.dNE.dto = 1;
    localyh.dNE.content = parama;
    com.tencent.mm.sdk.b.a.IvT.l(localyh);
    if (localyh.dNF.type == 3)
    {
      i = 1;
      label470:
      if (((i == 0) && (!parambv.field_content.equals(bv.JgK))) || (com.tencent.mm.r.a.cf(this.JWz.Kkd.getContext())) || (com.tencent.mm.r.a.cg(this.JWz.Kkd.getContext())) || (com.tencent.mm.r.a.cj(this.JWz.Kkd.getContext()))) {
        break label639;
      }
      parama = new yg();
      com.tencent.mm.sdk.b.a.IvT.l(parama);
      if ((paramView.dCi.field_talker.equals(parama.dNC.talker)) || ((!parama.dNC.dlr) && (!parama.dNC.dls))) {
        break label648;
      }
      if (!parama.dNC.dND) {
        break label641;
      }
    }
    label641:
    for (int i = 2131756778;; i = 2131756779)
    {
      Toast.makeText(this.JWz.Kkd.getContext(), i, 0).show();
      ae.i("MicroMsg.VoipClickListener", "voip is running, can't do this");
      break;
      i = 0;
      break label470;
      label639:
      break;
    }
    label648:
    paramView.dCi.setStatus(6);
    bc.aCg();
    c.azI().a(paramView.dCi.field_msgId, paramView.dCi);
    ((s)this.JWz.bh(s.class)).fHJ();
    parama = new yh();
    parama.dNE.dto = 5;
    parama.dNE.talker = paramView.dCi.field_talker;
    parama.dNE.context = this.JWz.Kkd.getContext();
    parama.dNE.dNA = 4;
    com.tencent.mm.sdk.b.a.IvT.l(parama);
    parama = com.tencent.mm.plugin.report.service.g.yxI;
    if ((paramView.dCi.eNd == null) || (paramView.dCi.eNd.length() <= 0)) {}
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