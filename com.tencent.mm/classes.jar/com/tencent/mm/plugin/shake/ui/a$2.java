package com.tencent.mm.plugin.shake.ui;

import android.os.Message;
import com.tencent.mm.ay.j;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.r;

final class a$2
  extends ah
{
  a$2(boolean paramBoolean) {}
  
  public final void handleMessage(Message paramMessage)
  {
    int j = q.Gu();
    if (this.hZO) {}
    for (int i = j & 0xFFFFFEFF;; i = j | 0x100)
    {
      y.i("MicroMsg.ContactWidgetShake", "setInstall pluginFlag install:%b  pluginFlag : %d -> %d", new Object[] { Boolean.valueOf(this.hZO), Integer.valueOf(j), Integer.valueOf(i) });
      au.Hx();
      c.Dz().o(34, Integer.valueOf(i));
      au.Hx();
      c.Fv().b(new j("", "", "", "", "", "", "", "", i, "", ""));
      if (!this.hZO) {
        m.bzX();
      }
      if (this.hZP != null) {
        this.hZP.a(null, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.a.2
 * JD-Core Version:    0.7.0.1
 */