package com.tencent.mm.plugin.profile.ui;

import android.os.Message;
import com.tencent.mm.ay.j;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.r;

final class f$2
  extends ah
{
  f$2(boolean paramBoolean) {}
  
  public final void handleMessage(Message paramMessage)
  {
    int i = q.Gu();
    if (this.hZO) {
      i &= 0xFFFFDFFF;
    }
    for (;;)
    {
      au.Hx();
      c.Dz().o(34, Integer.valueOf(i));
      au.Hx();
      c.Fv().b(new j("", "", "", "", "", "", "", "", i, "", ""));
      if (!this.hZO)
      {
        b.getFacebookFrdStg().WJ();
        au.Hx();
        c.Dz().o(65828, "");
        au.Hx();
        c.FB().abu("facebookapp");
        au.Hx();
        c.Fy().HG("facebookapp");
      }
      if (this.hZP != null) {
        this.hZP.a(null, null);
      }
      return;
      i |= 0x2000;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.f.2
 * JD-Core Version:    0.7.0.1
 */