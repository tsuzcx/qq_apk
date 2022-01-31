package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.bh.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.n.a;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;

final class b$2$1
  implements a.a
{
  b$2$1(b.2 param2, com.tencent.mm.pluginsdk.ui.preference.b paramb, ad paramad) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    if (paramBoolean1)
    {
      au.Hx();
      paramString2 = c.Fw().abl(this.pwi.username);
      paramString1 = paramString2;
      if ((int)paramString2.dBe == 0)
      {
        paramString2 = this.pwj;
        au.Hx();
        paramString1 = paramString2;
        if (!c.Fw().V(paramString2))
        {
          y.e("MicroMsg.FMessageConversationUI", "canAddContact fail, insert fail");
          return;
        }
      }
      s.q(paramString1);
      d.RY().du(this.pwi.username, 1);
      h.bC(b.a(this.pwk.pwh), b.a(this.pwk.pwh).getString(R.l.app_added));
      b.a(this.pwk.pwh, this.pwi.username);
    }
    for (;;)
    {
      this.pwk.pwh.notifyDataSetChanged();
      return;
      if (!paramBoolean2) {
        break;
      }
      d.RY().du(this.pwi.username, 2);
    }
    y.e("MicroMsg.FMessageConversationUI", "canAddContact fail, username = " + this.pwi.username);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.b.2.1
 * JD-Core Version:    0.7.0.1
 */