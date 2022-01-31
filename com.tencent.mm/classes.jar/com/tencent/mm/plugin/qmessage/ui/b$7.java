package com.tencent.mm.plugin.qmessage.ui;

import android.os.Message;
import com.tencent.mm.ay.j;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.r;

final class b$7
  extends ah
{
  b$7(boolean paramBoolean) {}
  
  public final void handleMessage(Message paramMessage)
  {
    b.e(64, this.hZO, 5);
    b.e(8192, this.hZO, 12);
    int i = q.Gu();
    if (this.hZO) {
      i &= 0xFFFFFFDF;
    }
    for (;;)
    {
      au.Hx();
      c.Dz().o(34, Integer.valueOf(i));
      au.Hx();
      c.Fv().b(new j("", "", "", "", "", "", "", "", i, "", ""));
      if (!this.hZO) {
        g.btm();
      }
      if (this.hZP != null) {
        this.hZP.a(null, null);
      }
      return;
      i |= 0x20;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.b.7
 * JD-Core Version:    0.7.0.1
 */