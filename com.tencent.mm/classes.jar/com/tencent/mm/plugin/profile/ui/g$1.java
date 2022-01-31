package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.ay.j;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.r;

final class g$1
  implements am.a
{
  g$1(boolean paramBoolean, p paramp) {}
  
  public final boolean tC()
  {
    int i = q.Gu();
    if (this.hZO) {
      i &= 0xFFFF7FFF;
    }
    for (;;)
    {
      au.Hx();
      c.Dz().o(34, Integer.valueOf(i));
      au.Hx();
      c.Fv().b(new j("", "", "", "", "", "", "", "", i, "", ""));
      if (!this.hZO) {
        g.adg();
      }
      if (this.hZP != null) {
        this.hZP.a(null, null);
      }
      if (this.hZQ != null) {
        this.hZQ.dismiss();
      }
      return true;
      i |= 0x8000;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.g.1
 * JD-Core Version:    0.7.0.1
 */