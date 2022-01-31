package com.tencent.mm.plugin.profile.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.k;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.p;

final class f$2
  extends ak
{
  f$2(boolean paramBoolean) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(23510);
    int i = r.Zy();
    if (this.ldm) {
      i &= 0xFFFFDFFF;
    }
    for (;;)
    {
      aw.aaz();
      c.Ru().set(34, Integer.valueOf(i));
      aw.aaz();
      c.Yz().c(new k("", "", "", "", "", "", "", "", i, "", ""));
      if (!this.ldm)
      {
        a.getFacebookFrdStg().aql();
        aw.aaz();
        c.Ru().set(65828, "");
        aw.aaz();
        c.YF().arF("facebookapp");
        aw.aaz();
        c.YC().Ts("facebookapp");
      }
      if (this.oBt != null) {
        this.oBt.a(null, null);
      }
      AppMethodBeat.o(23510);
      return;
      i |= 0x2000;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.f.2
 * JD-Core Version:    0.7.0.1
 */