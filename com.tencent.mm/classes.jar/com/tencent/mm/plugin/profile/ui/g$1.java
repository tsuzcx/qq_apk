package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.k;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.storage.z;

final class g$1
  implements ap.a
{
  g$1(boolean paramBoolean, com.tencent.mm.ui.base.p paramp) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(23520);
    int i = r.Zy();
    if (this.ldm) {
      i &= 0xFFFF7FFF;
    }
    for (;;)
    {
      aw.aaz();
      c.Ru().set(34, Integer.valueOf(i));
      aw.aaz();
      c.Yz().c(new k("", "", "", "", "", "", "", "", i, "", ""));
      if (!this.ldm) {
        g.clearData();
      }
      if (this.oBt != null) {
        this.oBt.a(null, null);
      }
      if (this.oBu != null) {
        this.oBu.dismiss();
      }
      AppMethodBeat.o(23520);
      return true;
      i |= 0x8000;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.g.1
 * JD-Core Version:    0.7.0.1
 */