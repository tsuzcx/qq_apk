package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.os.Message;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.r;

final class j$4
  extends ah
{
  j$4(boolean paramBoolean, Context paramContext) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (this.hZO) {
      j.jdMethod_if(true);
    }
    int i = q.Gu();
    if (this.hZO) {
      i &= 0xFFFFFFEF;
    }
    for (;;)
    {
      au.Hx();
      c.Dz().o(34, Integer.valueOf(i));
      au.Hx();
      c.Fv().b(new com.tencent.mm.ay.j("", "", "", "", "", "", "", "", i, "", ""));
      if (!this.hZO) {
        j.dX(this.val$context);
      }
      if (this.hZP != null) {
        this.hZP.a(null, null);
      }
      return;
      i |= 0x10;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.j.4
 * JD-Core Version:    0.7.0.1
 */