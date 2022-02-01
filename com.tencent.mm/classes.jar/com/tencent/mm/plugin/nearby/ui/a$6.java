package com.tencent.mm.plugin.nearby.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bd.l;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.v;

final class a$6
  extends MMHandler
{
  a$6(boolean paramBoolean) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(89814);
    int i = z.bdn();
    if (this.uoH) {
      i &= 0xFFFFFDFF;
    }
    for (;;)
    {
      h.aHG().aHp().i(34, Integer.valueOf(i));
      ((n)h.ae(n.class)).bbK().d(new l("", "", "", "", "", "", "", "", i, "", ""));
      if (!this.uoH) {
        com.tencent.mm.plugin.nearby.a.f.fix();
      }
      if (this.ESS != null) {
        this.ESS.onNotifyChange(null, null);
      }
      AppMethodBeat.o(89814);
      return;
      i |= 0x200;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.a.6
 * JD-Core Version:    0.7.0.1
 */