package com.tencent.mm.plugin.profile.ui;

import android.os.Message;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.protocal.c.bev;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.r;

final class n$2
  extends ah
{
  n$2(boolean paramBoolean) {}
  
  public final void handleMessage(Message paramMessage)
  {
    int i = q.Gu();
    if (this.hZO)
    {
      i &= 0xFDFFFFFF;
      au.Hx();
      c.Dz().o(34, Integer.valueOf(i));
      paramMessage = new bev();
      paramMessage.stP = 33554432;
      if (!this.hZO) {
        break label107;
      }
    }
    label107:
    for (i = 0;; i = 1)
    {
      paramMessage.tzI = i;
      au.Hx();
      c.Fv().b(new i.a(39, paramMessage));
      if (this.hZP != null) {
        this.hZP.a(null, null);
      }
      return;
      i |= 0x2000000;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.n.2
 * JD-Core Version:    0.7.0.1
 */