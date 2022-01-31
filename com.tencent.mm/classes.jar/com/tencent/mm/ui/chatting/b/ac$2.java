package com.tencent.mm.ui.chatting.b;

import android.content.res.Resources;
import android.view.View;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;

final class ac$2
  implements Runnable
{
  ac$2(ac paramac, bi parambi, View paramView) {}
  
  public final void run()
  {
    y.i("MicroMsg.NewXmlSysMsgComponent", "[handleClickInvokeMessageSysText] is over time to delete invokeMsg:%s", new Object[] { Long.valueOf(this.dUH.field_msgId) });
    t.a(this.vrD.byx.vtz.getMMResources().getString(R.l.chatting_revoke_msg_tips), "", this.dUH, "");
    au.Hx();
    c.Fy().a(this.dUH.field_msgId, this.dUH);
    ai.d(new Runnable()
    {
      public final void run()
      {
        ac.2.this.val$view.invalidate();
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.ac.2
 * JD-Core Version:    0.7.0.1
 */