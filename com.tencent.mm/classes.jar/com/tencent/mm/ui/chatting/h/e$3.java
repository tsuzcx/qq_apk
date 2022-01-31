package com.tencent.mm.ui.chatting.h;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.pluginsdk.model.app.l.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.gallery.c;

final class e$3
  implements l.a
{
  e$3(e parame, bi parambi) {}
  
  public final void eT(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2)
    {
      y.i("MicroMsg.MediaHistoryGalleryPresenter", "[onSceneProgressEnd] MsgId:%s", new Object[] { Long.valueOf(this.dUH.field_msgId) });
      e.h(this.vyV);
      if (!c.b(e.b(this.vyV), this.dUH, false)) {
        e.a(this.vyV, true);
      }
      if (e.g(this.vyV))
      {
        if (e.f(this.vyV)) {
          break label104;
        }
        e.d(this.vyV).post(new e.3.1(this));
      }
    }
    return;
    label104:
    e.d(this.vyV).post(new e.3.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.e.3
 * JD-Core Version:    0.7.0.1
 */