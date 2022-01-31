package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.g.a.tl.b;
import com.tencent.mm.g.a.uw;
import com.tencent.mm.g.a.uw.a;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.g.a.ux.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.o;
import com.tencent.mm.ui.chatting.s.e;

public final class as$h
  extends s.e
{
  public as$h(com.tencent.mm.ui.chatting.d.a parama)
  {
    super(parama);
  }
  
  private void a(az paramaz)
  {
    AppMethodBeat.i(33426);
    paramaz.cEE.setStatus(6);
    aw.aaz();
    c.YC().a(paramaz.cEE.field_msgId, paramaz.cEE);
    ((o)this.zzP.ay(o.class)).dIk();
    Object localObject = new ux();
    ((ux)localObject).cLs.cut = 5;
    ((ux)localObject).cLs.talker = paramaz.cEE.field_talker;
    ((ux)localObject).cLs.context = this.zzP.zJz.getContext();
    ((ux)localObject).cLs.cLm = 2;
    com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
    localObject = com.tencent.mm.plugin.report.service.h.qsU;
    if ((paramaz.cEE.dns == null) || (paramaz.cEE.dns.length() <= 0)) {}
    for (int i = 1;; i = 3)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).e(11033, new Object[] { Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(i) });
      AppMethodBeat.o(33426);
      return;
    }
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33425);
    paramView = (az)paramView.getTag();
    parama = parambi.field_content;
    ux localux = new ux();
    localux.cLs.cut = 1;
    localux.cLs.content = parama;
    com.tencent.mm.sdk.b.a.ymk.l(localux);
    if (localux.cLt.type == 2)
    {
      i = 1;
      if ((i == 0) && (!parambi.field_content.equals(bi.yOc))) {
        break label371;
      }
      if (com.tencent.mm.r.a.bM(this.zzP.zJz.getContext())) {
        break label365;
      }
      parama = new uw();
      com.tencent.mm.sdk.b.a.ymk.l(parama);
      if ((paramView.cEE.field_talker.equals(parama.cLo.talker)) || ((!parama.cLo.cLq) && (!parama.cLo.cLr))) {
        break label218;
      }
      if (!parama.cLo.cLp) {
        break label211;
      }
    }
    label211:
    for (int i = 2131297846;; i = 2131297847)
    {
      Toast.makeText(this.zzP.zJz.getContext(), i, 0).show();
      ab.i("MicroMsg.VoipClickListener", "voip is running, can't do this");
      AppMethodBeat.o(33425);
      return;
      i = 0;
      break;
    }
    label218:
    parama = new tl();
    parama.cJT.cJV = true;
    com.tencent.mm.sdk.b.a.ymk.l(parama);
    parama = parama.cJU.cJX;
    if (!ah.isNullOrNil(parama))
    {
      ab.v("MicroMsg.VoipClickListener", "Talkroom is on: ".concat(String.valueOf(parama)));
      com.tencent.mm.ui.base.h.d(this.zzP.zJz.getContext(), this.zzP.zJz.getContext().getString(2131304232), "", this.zzP.zJz.getContext().getString(2131297018), this.zzP.zJz.getContext().getString(2131296888), new as.h.1(this, paramView), new as.h.2(this));
      AppMethodBeat.o(33425);
      return;
    }
    a(paramView);
    label365:
    AppMethodBeat.o(33425);
    return;
    label371:
    parama = parambi.field_content;
    localux = new ux();
    localux.cLs.cut = 1;
    localux.cLs.content = parama;
    com.tencent.mm.sdk.b.a.ymk.l(localux);
    if (localux.cLt.type == 3)
    {
      i = 1;
      if (((i == 0) && (!parambi.field_content.equals(bi.yOb))) || (com.tencent.mm.r.a.bM(this.zzP.zJz.getContext()))) {
        break label751;
      }
      parama = new uw();
      com.tencent.mm.sdk.b.a.ymk.l(parama);
      if ((paramView.cEE.field_talker.equals(parama.cLo.talker)) || ((!parama.cLo.cLq) && (!parama.cLo.cLr))) {
        break label576;
      }
      if (!parama.cLo.cLp) {
        break label569;
      }
    }
    label569:
    for (i = 2131297846;; i = 2131297847)
    {
      Toast.makeText(this.zzP.zJz.getContext(), i, 0).show();
      ab.i("MicroMsg.VoipClickListener", "voip is running, can't do this");
      AppMethodBeat.o(33425);
      return;
      i = 0;
      break;
    }
    label576:
    paramView.cEE.setStatus(6);
    aw.aaz();
    c.YC().a(paramView.cEE.field_msgId, paramView.cEE);
    ((o)this.zzP.ay(o.class)).dIk();
    parama = new ux();
    parama.cLs.cut = 5;
    parama.cLs.talker = paramView.cEE.field_talker;
    parama.cLs.context = this.zzP.zJz.getContext();
    parama.cLs.cLm = 4;
    com.tencent.mm.sdk.b.a.ymk.l(parama);
    parama = com.tencent.mm.plugin.report.service.h.qsU;
    if ((paramView.cEE.dns == null) || (paramView.cEE.dns.length() <= 0)) {}
    for (i = 1;; i = 3)
    {
      parama.e(11033, new Object[] { Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(i) });
      label751:
      AppMethodBeat.o(33425);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.as.h
 * JD-Core Version:    0.7.0.1
 */