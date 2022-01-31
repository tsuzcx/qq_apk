package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.os.Message;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.readerapp.a.g;
import com.tencent.mm.protocal.c.bev;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.r;

final class b$3
  extends ah
{
  b$3(boolean paramBoolean, Context paramContext) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (this.hZO) {
      b.io(true);
    }
    int i = q.Gu();
    if (this.hZO)
    {
      i &= 0xFFF7FFFF;
      com.tencent.mm.kernel.g.DP().Dz().o(34, Integer.valueOf(i));
      paramMessage = new bev();
      paramMessage.stP = 524288;
      if (!this.hZO) {
        break label164;
      }
    }
    label164:
    for (i = 0;; i = 1)
    {
      paramMessage.tzI = i;
      ((j)com.tencent.mm.kernel.g.r(j.class)).Fv().b(new i.a(39, paramMessage));
      if (!this.hZO)
      {
        com.tencent.mm.plugin.readerapp.c.g.a(new b.3.1(this, com.tencent.mm.ui.base.h.b(this.val$context, this.val$context.getString(a.g.readerapp_delete_news_ing), false, null)));
        b.io(false);
      }
      if (this.hZP != null) {
        this.hZP.a(null, null);
      }
      return;
      i |= 0x80000;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.b.3
 * JD-Core Version:    0.7.0.1
 */