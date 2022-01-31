package com.tencent.mm.plugin.profile.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.protocal.protobuf.bmq;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.p;

final class n$2
  extends ak
{
  n$2(boolean paramBoolean) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(23602);
    int i = r.Zy();
    if (this.ldm)
    {
      i &= 0xFDFFFFFF;
      aw.aaz();
      c.Ru().set(34, Integer.valueOf(i));
      paramMessage = new bmq();
      paramMessage.wmt = 33554432;
      if (!this.ldm) {
        break label119;
      }
    }
    label119:
    for (i = 0;; i = 1)
    {
      paramMessage.xBb = i;
      aw.aaz();
      c.Yz().c(new j.a(39, paramMessage));
      if (this.oBt != null) {
        this.oBt.a(null, null);
      }
      AppMethodBeat.o(23602);
      return;
      i |= 0x2000000;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.n.2
 * JD-Core Version:    0.7.0.1
 */