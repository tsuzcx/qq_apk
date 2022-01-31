package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

final class d$c$1
  implements View.OnClickListener
{
  d$c$1(Boolean paramBoolean, long paramLong, String paramString1, String paramString2, bi parambi) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(32810);
    if (this.zSP.booleanValue())
    {
      l = this.cap;
      paramView = this.zSQ;
      localb = al.aUJ().nw(l);
      if (localb == null)
      {
        ab.e("MicroMsg.AppMsgLogic", "ERR:" + g.Ml() + " getinfo failed: " + paramView);
        AppMethodBeat.o(32810);
        return;
      }
      if (localb.field_status != 101L)
      {
        ab.e("MicroMsg.AppMsgLogic", "ERR:" + g.Ml() + " get status failed: " + paramView + " status:" + localb.field_status);
        AppMethodBeat.o(32810);
        return;
      }
      localb.field_status = 102L;
      localb.field_lastModifyTime = bo.aox();
      al.aUJ().a(localb, new String[0]);
      AppMethodBeat.o(32810);
      return;
    }
    long l = this.cap;
    paramView = this.zSQ;
    b localb = al.aUJ().nw(l);
    if (localb == null) {
      ab.e("MicroMsg.AppMsgLogic", "ERR:" + g.Ml() + " getinfo failed: " + paramView);
    }
    for (;;)
    {
      this.fkH.setStatus(5);
      aw.aaz();
      com.tencent.mm.model.c.YC().kB(this.cap);
      AppMethodBeat.o(32810);
      return;
      if (localb.field_status == 101L) {
        break;
      }
      ab.e("MicroMsg.AppMsgLogic", "ERR:" + g.Ml() + " get status failed: " + paramView + " status:" + localb.field_status);
    }
    if ((bo.isNullOrNil(localb.field_clientAppDataId)) && (!bo.isNullOrNil(localb.field_mediaSvrId))) {}
    for (localb.field_status = 102L;; localb.field_status = 105L)
    {
      localb.field_lastModifyTime = bo.aox();
      al.aUJ().a(localb, new String[0]);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.c.1
 * JD-Core Version:    0.7.0.1
 */