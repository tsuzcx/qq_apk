package com.tencent.mm.ui.conversation;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.az;

final class g$1
  implements Runnable
{
  g$1(g paramg, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(197680);
    Object localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOH("notifymessage");
    az localaz = (az)this.val$view.getTag(R.h.dCI);
    int j = ((Integer)this.val$view.getTag(R.h.dCJ)).intValue();
    int k = (int)(((et)localObject).field_createTime / 1000L);
    localObject = localaz.field_digest;
    if (com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.VmF, true)) {}
    for (int i = 0;; i = 1)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(22611, new Object[] { Integer.valueOf(2), Integer.valueOf(k), localObject, Integer.valueOf(i), Integer.valueOf(j) });
      AppMethodBeat.o(197680);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.g.1
 * JD-Core Version:    0.7.0.1
 */