package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.aj.e.a.a;
import com.tencent.mm.aj.e.a.b;
import com.tencent.mm.aj.f;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.c.b.o;

final class c$10
  implements e.a
{
  c$10(c paramc) {}
  
  public final void a(final e.a.b paramb)
  {
    AppMethodBeat.i(31202);
    if ((paramb != null) && (paramb.fwk == e.a.a.fwi) && (paramb.fuO != null) && (paramb.fuO.equals(this.zEm.caz.getTalkerUserName())))
    {
      aw.aaz();
      final ad localad = com.tencent.mm.model.c.YA().arw(paramb.fuO);
      if ((localad == null) || ((int)localad.euF == 0))
      {
        ab.i("MicroMsg.ChattingUI.BizComponent", "Get contact from db return null.(username : %s)", new Object[] { paramb.fuO });
        AppMethodBeat.o(31202);
        return;
      }
      al.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(31201);
          if ((c.d(c.10.this.zEm)) && (paramb.fuO.equals(c.10.this.zEm.caz.getTalkerUserName())))
          {
            ab.i("MicroMsg.ChattingUI.BizComponent", "try to refresh footer.");
            c.a(c.10.this.zEm, f.rS(paramb.fuO));
            if ((c.10.this.zEm.caz != null) && (c.e(c.10.this.zEm))) {
              ((o)c.10.this.zEm.caz.ay(o.class)).ad(localad);
            }
          }
          AppMethodBeat.o(31201);
        }
      });
    }
    AppMethodBeat.o(31202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.c.10
 * JD-Core Version:    0.7.0.1
 */