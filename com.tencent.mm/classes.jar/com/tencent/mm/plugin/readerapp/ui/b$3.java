package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bmq;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.p;

final class b$3
  extends ak
{
  b$3(boolean paramBoolean, Context paramContext) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(76788);
    if (this.ldm) {
      b.kq(true);
    }
    int i = r.Zy();
    if (this.ldm)
    {
      i &= 0xFFF7FFFF;
      com.tencent.mm.kernel.g.RL().Ru().set(34, Integer.valueOf(i));
      paramMessage = new bmq();
      paramMessage.wmt = 524288;
      if (!this.ldm) {
        break label173;
      }
    }
    label173:
    for (i = 0;; i = 1)
    {
      paramMessage.xBb = i;
      ((j)com.tencent.mm.kernel.g.E(j.class)).Yz().c(new j.a(39, paramMessage));
      if (!this.ldm)
      {
        com.tencent.mm.plugin.readerapp.c.g.a(new b.3.1(this, h.b(this.val$context, this.val$context.getString(2131302289), false, null)));
        b.kq(false);
      }
      if (this.oBt != null) {
        this.oBt.a(null, null);
      }
      AppMethodBeat.o(76788);
      return;
      i |= 0x80000;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.b.3
 * JD-Core Version:    0.7.0.1
 */