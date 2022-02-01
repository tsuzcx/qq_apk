package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.a.a;
import com.tencent.mm.al.f.a.b;
import com.tencent.mm.al.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.chatting.e.a;

final class c$12
  implements f.a
{
  c$12(c paramc) {}
  
  public final void a(final f.a.b paramb)
  {
    AppMethodBeat.i(35094);
    if ((paramb != null) && (paramb.iOh == f.a.a.iOf) && (paramb.iNV != null) && (paramb.iNV.equals(this.PmV.dom.getTalkerUserName())))
    {
      bg.aVF();
      final as localas = com.tencent.mm.model.c.aSN().Kn(paramb.iNV);
      if ((localas == null) || ((int)localas.gMZ == 0))
      {
        Log.i("MicroMsg.ChattingUI.BizComponent", "Get contact from db return null.(username : %s)", new Object[] { paramb.iNV });
        AppMethodBeat.o(35094);
        return;
      }
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35093);
          if ((c.d(c.12.this.PmV)) && (paramb.iNV.equals(c.12.this.PmV.dom.getTalkerUserName())))
          {
            Log.i("MicroMsg.ChattingUI.BizComponent", "try to refresh footer.");
            c.a(c.12.this.PmV, g.fJ(paramb.iNV));
            if ((c.12.this.PmV.dom != null) && (c.e(c.12.this.PmV))) {
              ((u)c.12.this.PmV.dom.bh(u.class)).au(localas);
            }
          }
          AppMethodBeat.o(35093);
        }
      });
    }
    AppMethodBeat.o(35094);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.c.12
 * JD-Core Version:    0.7.0.1
 */