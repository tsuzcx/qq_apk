package com.tencent.mm.ui.chatting;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.d.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.fav.b.c.a;
import com.tencent.mm.sdk.platformtools.ak;

final class ab$3
  implements d.a
{
  ab$3(ab paramab, a parama, Object paramObject) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(30931);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FavMsgHandle", "oreh downloadImgAndFav download image taskcancel: msgID:%d", new Object[] { Long.valueOf(this.zBO.cmQ.field_msgId) });
    AppMethodBeat.o(30931);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, m paramm) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, m paramm)
  {
    AppMethodBeat.i(30930);
    if ((paramInt3 == 0) && (paramInt4 == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FavMsgHandle", "oreh downloadImreportHandler.removeMessagesreportHandler.removeMessagesgAndFav taskEnd image succed: %s, msgID:%d, errType: %s, errCode:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(this.zBO.cmQ.field_msgId), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      new ak(Looper.getMainLooper()).post(new ab.3.1(this));
      AppMethodBeat.o(30930);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ab.3
 * JD-Core Version:    0.7.0.1
 */