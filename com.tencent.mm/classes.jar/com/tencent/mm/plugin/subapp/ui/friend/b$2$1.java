package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.d;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.n.a;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;

final class b$2$1
  implements a.a
{
  b$2$1(b.2 param2, com.tencent.mm.pluginsdk.ui.preference.b paramb, ad paramad) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(25346);
    if (paramBoolean1)
    {
      com.tencent.mm.model.aw.aaz();
      paramString2 = c.YA().arw(this.sXO.username);
      paramString1 = paramString2;
      if ((int)paramString2.euF == 0)
      {
        paramString2 = this.sXP;
        com.tencent.mm.model.aw.aaz();
        paramString1 = paramString2;
        if (!c.YA().Y(paramString2))
        {
          ab.e("MicroMsg.FMessageConversationUI", "canAddContact fail, insert fail");
          AppMethodBeat.o(25346);
          return;
        }
      }
      t.q(paramString1);
      d.ali().eD(this.sXO.username, 1);
      h.bO(b.a(this.sXQ.sXN), b.a(this.sXQ.sXN).getString(2131296540));
      b.a(this.sXQ.sXN, this.sXO.username);
    }
    for (;;)
    {
      this.sXQ.sXN.notifyDataSetChanged();
      AppMethodBeat.o(25346);
      return;
      if (!paramBoolean2) {
        break;
      }
      d.ali().eD(this.sXO.username, 2);
    }
    ab.e("MicroMsg.FMessageConversationUI", "canAddContact fail, username = " + this.sXO.username);
    AppMethodBeat.o(25346);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.b.2.1
 * JD-Core Version:    0.7.0.1
 */