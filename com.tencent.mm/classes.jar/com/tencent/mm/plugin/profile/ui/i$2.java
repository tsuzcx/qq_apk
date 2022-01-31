package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.protocal.protobuf.bmq;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.p;

final class i$2
  implements ap.a
{
  i$2(ProgressDialog paramProgressDialog, boolean paramBoolean) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(23538);
    if (this.kTo != null) {
      this.kTo.dismiss();
    }
    int i = r.Zy();
    bmq localbmq;
    if (this.ldm)
    {
      i &= 0xFEFFFFFF;
      aw.aaz();
      c.Ru().set(34, Integer.valueOf(i));
      localbmq = new bmq();
      localbmq.wmt = 16777216;
      if (!this.ldm) {
        break label176;
      }
    }
    label176:
    for (i = 0;; i = 1)
    {
      localbmq.xBb = i;
      aw.aaz();
      c.Yz().c(new j.a(39, localbmq));
      if (this.oBt != null) {
        this.oBt.a(null, null);
      }
      AppMethodBeat.o(23538);
      return false;
      i |= 0x1000000;
      aw.aaz();
      c.Ru().set(286722, "");
      aw.aaz();
      c.Ru().set(286721, "");
      aw.aaz();
      c.Ru().set(286723, "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.i.2
 * JD-Core Version:    0.7.0.1
 */