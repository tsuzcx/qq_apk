package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.protocal.c.bev;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.r;

final class i$2
  implements am.a
{
  i$2(ProgressDialog paramProgressDialog, boolean paramBoolean) {}
  
  public final boolean tC()
  {
    if (this.iMq != null) {
      this.iMq.dismiss();
    }
    int i = q.Gu();
    bev localbev;
    if (this.hZO)
    {
      i &= 0xFEFFFFFF;
      au.Hx();
      c.Dz().o(34, Integer.valueOf(i));
      localbev = new bev();
      localbev.stP = 16777216;
      if (!this.hZO) {
        break label164;
      }
    }
    label164:
    for (i = 0;; i = 1)
    {
      localbev.tzI = i;
      au.Hx();
      c.Fv().b(new i.a(39, localbev));
      if (this.hZP != null) {
        this.hZP.a(null, null);
      }
      return false;
      i |= 0x1000000;
      au.Hx();
      c.Dz().o(286722, "");
      au.Hx();
      c.Dz().o(286721, "");
      au.Hx();
      c.Dz().o(286723, "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.i.2
 * JD-Core Version:    0.7.0.1
 */