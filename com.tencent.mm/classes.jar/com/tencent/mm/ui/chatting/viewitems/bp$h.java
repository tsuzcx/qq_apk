package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.aaq;
import com.tencent.mm.autogen.a.aaq.b;
import com.tencent.mm.autogen.a.acm;
import com.tencent.mm.autogen.a.acm.a;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.autogen.a.acn.b;
import com.tencent.mm.autogen.a.gg;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.bd.b;
import com.tencent.mm.bd.d;
import com.tencent.mm.model.bh;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.x;
import com.tencent.mm.ui.chatting.v.e;

public final class bp$h
  extends v.e
{
  public bp$h(com.tencent.mm.ui.chatting.d.a parama)
  {
    super(parama);
  }
  
  private void c(bz parambz)
  {
    AppMethodBeat.i(177732);
    parambz.hTm.setStatus(6);
    bh.bCz();
    com.tencent.mm.model.c.bzD().a(parambz.hTm.field_msgId, parambz.hTm);
    ((x)this.aeiK.cm(x.class)).jsh();
    Object localObject = new acn();
    ((acn)localObject).ifU.hId = 5;
    ((acn)localObject).ifU.talker = parambz.hTm.field_talker;
    ((acn)localObject).ifU.context = this.aeiK.aezO.getContext();
    ((acn)localObject).ifU.ifQ = 2;
    ((acn)localObject).publish();
    localObject = com.tencent.mm.plugin.report.service.h.OAn;
    if ((parambz.hTm.jUr == null) || (parambz.hTm.jUr.length() <= 0)) {}
    for (int i = 1;; i = 3)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).b(11033, new Object[] { Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(i) });
      AppMethodBeat.o(177732);
      return;
    }
  }
  
  public final void a(final View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(37535);
    paramView = (bz)paramView.getTag();
    parama = paramcc.field_content;
    acn localacn = new acn();
    localacn.ifU.hId = 1;
    localacn.ifU.content = parama;
    localacn.publish();
    if (localacn.ifV.type == 2)
    {
      i = 1;
      if ((i == 0) && (!paramcc.field_content.equals(cc.adkp))) {
        break label442;
      }
      if ((!com.tencent.mm.n.a.dl(this.aeiK.aezO.getContext())) && (!com.tencent.mm.n.a.c(this.aeiK.aezO.getContext(), null)) && (!com.tencent.mm.n.a.dp(this.aeiK.aezO.getContext())) && (!com.tencent.mm.n.a.q(this.aeiK.aezO.getContext(), true)) && (!com.tencent.mm.n.a.v(this.aeiK.aezO.getContext(), true)))
      {
        parama = new acm();
        parama.publish();
        if ((paramView.hTm.field_talker.equals(parama.ifS.talker)) || ((!parama.ifS.hzJ) && (!parama.ifS.hzK))) {
          break label298;
        }
        if (!parama.ifS.ifT) {
          break label290;
        }
        i = R.l.cannot_use_voip_bcz_video_talking;
        label235:
        Toast.makeText(this.aeiK.aezO.getContext(), i, 0).show();
        Log.i("MicroMsg.VoipClickListener", "voip is running, can't do this");
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(paramcc.field_talker);
      AppMethodBeat.o(37535);
      return;
      i = 0;
      break;
      label290:
      i = R.l.cannot_use_voip_bcz_voice_talking;
      break label235;
      label298:
      parama = new aaq();
      parama.ieg.iei = true;
      parama.publish();
      parama = parama.ieh.iek;
      if (!ab.isNullOrNil(parama))
      {
        Log.v("MicroMsg.VoipClickListener", "Talkroom is on: ".concat(String.valueOf(parama)));
        k.b(this.aeiK.aezO.getContext(), this.aeiK.aezO.getContext().getString(R.l.gWJ), "", this.aeiK.aezO.getContext().getString(R.l.app_ok), this.aeiK.aezO.getContext().getString(R.l.app_cancel), new DialogInterface.OnClickListener()new bp.h.2
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(37533);
            Object localObject = new aaq();
            ((aaq)localObject).ieg.iej = true;
            ((aaq)localObject).publish();
            localObject = new gg();
            ((gg)localObject).hGt.username = d.oXO.bNG();
            ((gg)localObject).publish();
            bp.h.a(bp.h.this, paramView);
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(37533);
          }
        }, new bp.h.2(this));
      }
      else
      {
        c(paramView);
      }
    }
    label442:
    parama = paramcc.field_content;
    localacn = new acn();
    localacn.ifU.hId = 1;
    localacn.ifU.content = parama;
    localacn.publish();
    if (localacn.ifV.type == 3)
    {
      i = 1;
      label495:
      if (((i == 0) && (!paramcc.field_content.equals(cc.adko))) || (com.tencent.mm.n.a.dl(this.aeiK.aezO.getContext())) || (com.tencent.mm.n.a.c(this.aeiK.aezO.getContext(), null)) || (com.tencent.mm.n.a.dp(this.aeiK.aezO.getContext())) || (com.tencent.mm.n.a.q(this.aeiK.aezO.getContext(), true)) || (com.tencent.mm.n.a.v(this.aeiK.aezO.getContext(), true))) {
        break label697;
      }
      parama = new acm();
      parama.publish();
      if ((paramView.hTm.field_talker.equals(parama.ifS.talker)) || ((!parama.ifS.hzJ) && (!parama.ifS.hzK))) {
        break label707;
      }
      if (!parama.ifS.ifT) {
        break label699;
      }
    }
    label697:
    label699:
    for (int i = R.l.cannot_use_voip_bcz_video_talking;; i = R.l.cannot_use_voip_bcz_voice_talking)
    {
      Toast.makeText(this.aeiK.aezO.getContext(), i, 0).show();
      Log.i("MicroMsg.VoipClickListener", "voip is running, can't do this");
      break;
      i = 0;
      break label495;
      break;
    }
    label707:
    paramView.hTm.setStatus(6);
    bh.bCz();
    com.tencent.mm.model.c.bzD().a(paramView.hTm.field_msgId, paramView.hTm);
    ((x)this.aeiK.cm(x.class)).jsh();
    parama = new acn();
    parama.ifU.hId = 5;
    parama.ifU.talker = paramView.hTm.field_talker;
    parama.ifU.context = this.aeiK.aezO.getContext();
    parama.ifU.ifQ = 4;
    parama.publish();
    parama = com.tencent.mm.plugin.report.service.h.OAn;
    if ((paramView.hTm.jUr == null) || (paramView.hTm.jUr.length() <= 0)) {}
    for (i = 1;; i = 3)
    {
      parama.b(11033, new Object[] { Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(i) });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bp.h
 * JD-Core Version:    0.7.0.1
 */