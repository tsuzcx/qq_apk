package com.tencent.mm.ui.chatting;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.fav.b.c.a;
import com.tencent.mm.sdk.platformtools.ak;

final class ab$2
  implements t.a
{
  ab$2(ab paramab, a parama, Object paramObject) {}
  
  public final void a(t.a.a parama)
  {
    AppMethodBeat.i(30928);
    if (this.zBK.cmQ.field_imgPath.equals(parama.fileName))
    {
      s locals = u.vr(parama.fileName);
      if ((locals != null) && (locals.alS()))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav suc msgID:%d, fileName:%s", new Object[] { Long.valueOf(this.zBK.cmQ.field_msgId), parama.fileName });
        o.alE().a(this);
        new ak(Looper.getMainLooper()).post(new ab.2.1(this));
        AppMethodBeat.o(30928);
        return;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FavMsgHandle", "oreh downloadVideoAndFav fialed msgID:%d, fileName:%s", new Object[] { Long.valueOf(this.zBK.cmQ.field_msgId), parama.fileName });
    }
    AppMethodBeat.o(30928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ab.2
 * JD-Core Version:    0.7.0.1
 */