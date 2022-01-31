package com.tencent.mm.ui.chatting.g;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    this.vyy.bWO.setType(10002);
    t.a(ae.getContext().getString(R.l.chatting_revoke_msg_tips), "", this.vyy.bWO, "");
    au.Hx();
    c.Fy().a(this.vyy.bWO.field_msgId, this.vyy.bWO);
    y.i("MicroMsg.InvokeMessageNewXmlMsg", "checkExpired:%s", new Object[] { Long.valueOf(this.vyy.bWO.field_msgId) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.g.a.1
 * JD-Core Version:    0.7.0.1
 */