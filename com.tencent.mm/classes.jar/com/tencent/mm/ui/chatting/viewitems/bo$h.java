package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.bk.d;
import com.tencent.mm.f.a.aap;
import com.tencent.mm.f.a.aap.a;
import com.tencent.mm.f.a.aaq;
import com.tencent.mm.f.a.aaq.b;
import com.tencent.mm.f.a.fv;
import com.tencent.mm.f.a.yx;
import com.tencent.mm.f.a.yx.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.chatting.t.e;

public final class bo$h
  extends t.e
{
  public bo$h(com.tencent.mm.ui.chatting.e.a parama)
  {
    super(parama);
  }
  
  private void c(by paramby)
  {
    AppMethodBeat.i(177732);
    paramby.fNz.setStatus(6);
    bh.beI();
    c.bbO().a(paramby.fNz.field_msgId, paramby.fNz);
    ((u)this.WBq.bC(u.class)).hPn();
    Object localObject = new aaq();
    ((aaq)localObject).fZM.fDn = 5;
    ((aaq)localObject).fZM.talker = paramby.fNz.field_talker;
    ((aaq)localObject).fZM.context = this.WBq.WQv.getContext();
    ((aaq)localObject).fZM.fZI = 2;
    EventCenter.instance.publish((IEvent)localObject);
    localObject = com.tencent.mm.plugin.report.service.h.IzE;
    if ((paramby.fNz.hxy == null) || (paramby.fNz.hxy.length() <= 0)) {}
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
    paramView = (by)paramView.getTag();
    parama = paramca.field_content;
    aaq localaaq = new aaq();
    localaaq.fZM.fDn = 1;
    localaaq.fZM.content = parama;
    EventCenter.instance.publish(localaaq);
    if (localaaq.fZN.type == 2)
    {
      i = 1;
      if ((i == 0) && (!paramca.field_content.equals(ca.VGy))) {
        break label450;
      }
      if ((!com.tencent.mm.q.a.cw(this.WBq.WQv.getContext())) && (!com.tencent.mm.q.a.cx(this.WBq.WQv.getContext())) && (!com.tencent.mm.q.a.cB(this.WBq.WQv.getContext())) && (!com.tencent.mm.q.a.q(this.WBq.WQv.getContext(), true)) && (!com.tencent.mm.q.a.u(this.WBq.WQv.getContext(), true)))
      {
        parama = new aap();
        EventCenter.instance.publish(parama);
        if ((paramView.fNz.field_talker.equals(parama.fZK.talker)) || ((!parama.fZK.fvo) && (!parama.fZK.fvp))) {
          break label303;
        }
        if (!parama.fZK.fZL) {
          break label295;
        }
        i = R.l.cannot_use_voip_bcz_video_talking;
        label240:
        Toast.makeText(this.WBq.WQv.getContext(), i, 0).show();
        Log.i("MicroMsg.VoipClickListener", "voip is running, can't do this");
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.comm.a.b.class)).asK(paramca.field_talker);
      AppMethodBeat.o(37535);
      return;
      i = 0;
      break;
      label295:
      i = R.l.cannot_use_voip_bcz_voice_talking;
      break label240;
      label303:
      parama = new yx();
      parama.fYg.fYi = true;
      EventCenter.instance.publish(parama);
      parama = parama.fYh.fYk;
      if (!ae.isNullOrNil(parama))
      {
        Log.v("MicroMsg.VoipClickListener", "Talkroom is on: ".concat(String.valueOf(parama)));
        com.tencent.mm.ui.base.h.c(this.WBq.WQv.getContext(), this.WBq.WQv.getContext().getString(R.l.eTP), "", this.WBq.WQv.getContext().getString(R.l.app_ok), this.WBq.WQv.getContext().getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(37533);
            Object localObject = new yx();
            ((yx)localObject).fYg.fYj = true;
            EventCenter.instance.publish((IEvent)localObject);
            localObject = new fv();
            ((fv)localObject).fBE.username = d.meW.bqa();
            EventCenter.instance.publish((IEvent)localObject);
            bo.h.a(bo.h.this, paramView);
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
    label450:
    parama = paramca.field_content;
    localaaq = new aaq();
    localaaq.fZM.fDn = 1;
    localaaq.fZM.content = parama;
    EventCenter.instance.publish(localaaq);
    if (localaaq.fZN.type == 3)
    {
      i = 1;
      label506:
      if (((i == 0) && (!paramca.field_content.equals(ca.VGx))) || (com.tencent.mm.q.a.cw(this.WBq.WQv.getContext())) || (com.tencent.mm.q.a.cx(this.WBq.WQv.getContext())) || (com.tencent.mm.q.a.cB(this.WBq.WQv.getContext())) || (com.tencent.mm.q.a.q(this.WBq.WQv.getContext(), true)) || (com.tencent.mm.q.a.u(this.WBq.WQv.getContext(), true))) {
        break label710;
      }
      parama = new aap();
      EventCenter.instance.publish(parama);
      if ((paramView.fNz.field_talker.equals(parama.fZK.talker)) || ((!parama.fZK.fvo) && (!parama.fZK.fvp))) {
        break label720;
      }
      if (!parama.fZK.fZL) {
        break label712;
      }
    }
    label710:
    label712:
    for (int i = R.l.cannot_use_voip_bcz_video_talking;; i = R.l.cannot_use_voip_bcz_voice_talking)
    {
      Toast.makeText(this.WBq.WQv.getContext(), i, 0).show();
      Log.i("MicroMsg.VoipClickListener", "voip is running, can't do this");
      break;
      i = 0;
      break label506;
      break;
    }
    label720:
    paramView.fNz.setStatus(6);
    bh.beI();
    c.bbO().a(paramView.fNz.field_msgId, paramView.fNz);
    ((u)this.WBq.bC(u.class)).hPn();
    parama = new aaq();
    parama.fZM.fDn = 5;
    parama.fZM.talker = paramView.fNz.field_talker;
    parama.fZM.context = this.WBq.WQv.getContext();
    parama.fZM.fZI = 4;
    EventCenter.instance.publish(parama);
    parama = com.tencent.mm.plugin.report.service.h.IzE;
    if ((paramView.fNz.hxy == null) || (paramView.fNz.hxy.length() <= 0)) {}
    for (i = 1;; i = 3)
    {
      parama.a(11033, new Object[] { Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(i) });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bo.h
 * JD-Core Version:    0.7.0.1
 */