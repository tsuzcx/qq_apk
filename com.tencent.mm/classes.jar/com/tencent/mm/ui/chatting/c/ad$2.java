package com.tencent.mm.ui.chatting.c;

import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;

final class ad$2
  implements Runnable
{
  ad$2(ad paramad, bi parambi, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(31614);
    ab.i("MicroMsg.NewXmlSysMsgComponent", "[handleClickInvokeMessageSysText] is over time to delete invokeMsg:%s", new Object[] { Long.valueOf(this.fkQ.field_msgId) });
    v.a(this.zHi.caz.zJz.getMMResources().getString(2131298301), "", this.fkQ, "");
    aw.aaz();
    c.YC().a(this.fkQ.field_msgId, this.fkQ);
    al.d(new ad.2.1(this));
    AppMethodBeat.o(31614);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ad.2
 * JD-Core Version:    0.7.0.1
 */