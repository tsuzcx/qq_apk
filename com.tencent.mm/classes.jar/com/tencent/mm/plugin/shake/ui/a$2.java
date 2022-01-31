package com.tencent.mm.plugin.shake.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.k;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.p;

final class a$2
  extends ak
{
  a$2(boolean paramBoolean) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(24690);
    int j = r.Zy();
    if (this.ldm) {}
    for (int i = j & 0xFFFFFEFF;; i = j | 0x100)
    {
      ab.i("MicroMsg.ContactWidgetShake", "setInstall pluginFlag install:%b  pluginFlag : %d -> %d", new Object[] { Boolean.valueOf(this.ldm), Integer.valueOf(j), Integer.valueOf(i) });
      aw.aaz();
      c.Ru().set(34, Integer.valueOf(i));
      aw.aaz();
      c.Yz().c(new k("", "", "", "", "", "", "", "", i, "", ""));
      if (!this.ldm) {
        m.clq();
      }
      if (this.oBt != null) {
        this.oBt.a(null, null);
      }
      AppMethodBeat.o(24690);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.a.2
 * JD-Core Version:    0.7.0.1
 */