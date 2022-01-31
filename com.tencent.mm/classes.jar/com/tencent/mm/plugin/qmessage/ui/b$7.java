package com.tencent.mm.plugin.qmessage.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.k;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.p;

final class b$7
  extends ak
{
  b$7(boolean paramBoolean) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(24108);
    b.f(64, this.ldm, 5);
    b.f(8192, this.ldm, 12);
    int i = r.Zy();
    if (this.ldm) {
      i &= 0xFFFFFFDF;
    }
    for (;;)
    {
      aw.aaz();
      c.Ru().set(34, Integer.valueOf(i));
      aw.aaz();
      c.Yz().c(new k("", "", "", "", "", "", "", "", i, "", ""));
      if (!this.ldm) {
        g.cdt();
      }
      if (this.oBt != null) {
        this.oBt.a(null, null);
      }
      AppMethodBeat.o(24108);
      return;
      i |= 0x20;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.b.7
 * JD-Core Version:    0.7.0.1
 */