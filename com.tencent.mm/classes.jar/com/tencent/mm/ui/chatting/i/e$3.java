package com.tencent.mm.ui.chatting.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.pluginsdk.model.app.l.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.gallery.c;

final class e$3
  implements l.a
{
  e$3(e parame, bi parambi) {}
  
  public final void ha(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(32560);
    if (paramInt1 == paramInt2)
    {
      ab.i("MicroMsg.MediaHistoryGalleryPresenter", "[onSceneProgressEnd] MsgId:%s", new Object[] { Long.valueOf(this.fkQ.field_msgId) });
      e.h(this.zPs);
      if (!c.b(e.b(this.zPs), this.fkQ, false)) {
        e.a(this.zPs, true);
      }
      if (e.g(this.zPs))
      {
        if (!e.f(this.zPs))
        {
          e.d(this.zPs).post(new e.3.1(this));
          AppMethodBeat.o(32560);
          return;
        }
        e.d(this.zPs).post(new e.3.2(this));
      }
    }
    AppMethodBeat.o(32560);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.e.3
 * JD-Core Version:    0.7.0.1
 */