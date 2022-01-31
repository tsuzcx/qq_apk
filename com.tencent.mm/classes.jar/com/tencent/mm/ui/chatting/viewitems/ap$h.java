package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.ru;
import com.tencent.mm.h.a.ru.b;
import com.tencent.mm.h.a.tc;
import com.tencent.mm.h.a.tc.a;
import com.tencent.mm.h.a.td;
import com.tencent.mm.h.a.td.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.b.b.n;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.chatting.t.d;

public final class ap$h
  extends t.d
{
  public ap$h(com.tencent.mm.ui.chatting.c.a parama)
  {
    super(parama);
  }
  
  private void a(aw paramaw)
  {
    paramaw.bWO.setStatus(6);
    au.Hx();
    c.Fy().a(paramaw.bWO.field_msgId, paramaw.bWO);
    ((n)this.vko.ac(n.class)).cEu();
    Object localObject = new td();
    ((td)localObject).ccJ.bNb = 5;
    ((td)localObject).ccJ.talker = paramaw.bWO.field_talker;
    ((td)localObject).ccJ.context = this.vko.vtz.getContext();
    ((td)localObject).ccJ.ccE = 2;
    com.tencent.mm.sdk.b.a.udP.m((b)localObject);
    localObject = com.tencent.mm.plugin.report.service.h.nFQ;
    if ((paramaw.bWO.czr == null) || (paramaw.bWO.czr.length() <= 0)) {}
    for (int i = 1;; i = 3)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).f(11033, new Object[] { Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(i) });
      return;
    }
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    paramView = (aw)paramView.getTag();
    parama = parambi.field_content;
    td localtd = new td();
    localtd.ccJ.bNb = 1;
    localtd.ccJ.content = parama;
    com.tencent.mm.sdk.b.a.udP.m(localtd);
    if (localtd.ccK.type == 2)
    {
      i = 1;
      if ((i == 0) && (!parambi.field_content.equals(bi.uBQ))) {
        break label360;
      }
      if (!com.tencent.mm.r.a.bi(this.vko.vtz.getContext()))
      {
        parama = new tc();
        com.tencent.mm.sdk.b.a.udP.m(parama);
        if ((paramView.bWO.field_talker.equals(parama.ccF.talker)) || ((!parama.ccF.ccH) && (!parama.ccF.ccI))) {
          break label210;
        }
        if (!parama.ccF.ccG) {
          break label202;
        }
      }
    }
    label202:
    for (int i = R.l.cannot_use_voip_bcz_video_talking;; i = R.l.cannot_use_voip_bcz_voice_talking)
    {
      Toast.makeText(this.vko.vtz.getContext(), i, 0).show();
      y.i("MicroMsg.VoipClickListener", "voip is running, can't do this");
      return;
      i = 0;
      break;
    }
    label210:
    parama = new ru();
    parama.cbq.cbs = true;
    com.tencent.mm.sdk.b.a.udP.m(parama);
    parama = parama.cbr.cbu;
    if (!ah.bl(parama))
    {
      y.v("MicroMsg.VoipClickListener", "Talkroom is on: " + parama);
      com.tencent.mm.ui.base.h.a(this.vko.vtz.getContext(), this.vko.vtz.getContext().getString(R.l.talk_room_enter_voip_tip), "", this.vko.vtz.getContext().getString(R.l.app_ok), this.vko.vtz.getContext().getString(R.l.app_cancel), new ap.h.1(this, paramView), new ap.h.2(this));
      return;
    }
    a(paramView);
    return;
    label360:
    parama = parambi.field_content;
    localtd = new td();
    localtd.ccJ.bNb = 1;
    localtd.ccJ.content = parama;
    com.tencent.mm.sdk.b.a.udP.m(localtd);
    if (localtd.ccK.type == 3)
    {
      i = 1;
      label416:
      if (((i == 0) && (!parambi.field_content.equals(bi.uBP))) || (com.tencent.mm.r.a.bi(this.vko.vtz.getContext()))) {
        break label552;
      }
      parama = new tc();
      com.tencent.mm.sdk.b.a.udP.m(parama);
      if ((paramView.bWO.field_talker.equals(parama.ccF.talker)) || ((!parama.ccF.ccH) && (!parama.ccF.ccI))) {
        break label562;
      }
      if (!parama.ccF.ccG) {
        break label554;
      }
    }
    label552:
    label554:
    for (i = R.l.cannot_use_voip_bcz_video_talking;; i = R.l.cannot_use_voip_bcz_voice_talking)
    {
      Toast.makeText(this.vko.vtz.getContext(), i, 0).show();
      y.i("MicroMsg.VoipClickListener", "voip is running, can't do this");
      return;
      i = 0;
      break label416;
      break;
    }
    label562:
    paramView.bWO.setStatus(6);
    au.Hx();
    c.Fy().a(paramView.bWO.field_msgId, paramView.bWO);
    ((n)this.vko.ac(n.class)).cEu();
    parama = new td();
    parama.ccJ.bNb = 5;
    parama.ccJ.talker = paramView.bWO.field_talker;
    parama.ccJ.context = this.vko.vtz.getContext();
    parama.ccJ.ccE = 4;
    com.tencent.mm.sdk.b.a.udP.m(parama);
    parama = com.tencent.mm.plugin.report.service.h.nFQ;
    if ((paramView.bWO.czr == null) || (paramView.bWO.czr.length() <= 0)) {}
    for (i = 1;; i = 3)
    {
      parama.f(11033, new Object[] { Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(i) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ap.h
 * JD-Core Version:    0.7.0.1
 */