package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;

final class d$c$1
  implements View.OnClickListener
{
  d$c$1(Boolean paramBoolean, long paramLong, String paramString1, String paramString2, bi parambi) {}
  
  public final void onClick(View paramView)
  {
    if (this.vCb.booleanValue())
    {
      l = this.byn;
      paramView = this.vCc;
      localb = ap.avh().gY(l);
      if (localb == null)
      {
        y.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.g.zI() + " getinfo failed: " + paramView);
        return;
      }
      if (localb.field_status != 101L)
      {
        y.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.g.zI() + " get status failed: " + paramView + " status:" + localb.field_status);
        return;
      }
      localb.field_status = 102L;
      localb.field_lastModifyTime = bk.UX();
      ap.avh().c(localb, new String[0]);
      return;
    }
    long l = this.byn;
    paramView = this.vCc;
    b localb = ap.avh().gY(l);
    if (localb == null) {
      y.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.g.zI() + " getinfo failed: " + paramView);
    }
    for (;;)
    {
      this.dUy.setStatus(5);
      au.Hx();
      com.tencent.mm.model.c.Fy().fd(this.byn);
      return;
      if (localb.field_status == 101L) {
        break;
      }
      y.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.g.zI() + " get status failed: " + paramView + " status:" + localb.field_status);
    }
    if ((bk.bl(localb.field_clientAppDataId)) && (!bk.bl(localb.field_mediaSvrId))) {}
    for (localb.field_status = 102L;; localb.field_status = 105L)
    {
      localb.field_lastModifyTime = bk.UX();
      ap.avh().c(localb, new String[0]);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.c.1
 * JD-Core Version:    0.7.0.1
 */