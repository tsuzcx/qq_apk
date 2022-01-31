package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.model.app.ak.a;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

final class d$c$2
  implements View.OnClickListener
{
  d$c$2(Boolean paramBoolean, long paramLong, String paramString, bi parambi) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(32811);
    b localb;
    if (!this.zSP.booleanValue())
    {
      long l = this.cap;
      paramView = this.zSQ;
      localb = al.aUJ().nw(l);
      if (localb != null) {
        break label102;
      }
      ab.e("MicroMsg.AppMsgLogic", "ERR:" + g.Ml() + " getinfo failed: " + paramView);
    }
    for (;;)
    {
      this.fkH.setStatus(1);
      aw.aaz();
      com.tencent.mm.model.c.YC().kB(this.cap);
      AppMethodBeat.o(32811);
      return;
      label102:
      if ((localb.field_status != 105L) && (localb.field_status != 101L))
      {
        ab.e("MicroMsg.AppMsgLogic", "ERR:" + g.Ml() + " get status failed: " + paramView + " status:" + localb.field_status);
      }
      else
      {
        localb.field_status = 101L;
        localb.field_lastModifyTime = bo.aox();
        al.aUJ().a(localb, new String[0]);
        al.dlN().run();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.c.2
 * JD-Core Version:    0.7.0.1
 */