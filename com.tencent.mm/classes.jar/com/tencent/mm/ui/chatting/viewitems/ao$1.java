package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fu;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.ag;

final class ao$1
  implements Runnable
{
  ao$1(com.tencent.mm.ui.chatting.d.a parama, bi parambi) {}
  
  public final void run()
  {
    AppMethodBeat.i(33355);
    Object localObject = this.zRK;
    bi localbi = this.fkH;
    ag localag = (ag)((com.tencent.mm.ui.chatting.d.a)localObject).ay(ag.class);
    if ((localObject == null) || (localag == null))
    {
      ab.e("MicroMsg.ChattingItemVoice", "alvinluo ui or ui.transformImp null");
      AppMethodBeat.o(33355);
      return;
    }
    int i;
    if (localag.oJ(localbi.field_msgId)) {
      i = 2;
    }
    for (;;)
    {
      ab.i("MicroMsg.ChattingItemVoice", "alvinluo TransformText report clickScene: %d, msgId: %d", new Object[] { Integer.valueOf(i), Long.valueOf(localbi.field_msgId) });
      localObject = new fu();
      ((fu)localObject).cuc.cud = 1;
      ((fu)localObject).cuc.scene = i;
      ((fu)localObject).cuc.fileName = localbi.field_imgPath;
      com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
      AppMethodBeat.o(33355);
      return;
      if (localag.oG(localbi.field_msgId)) {
        i = 3;
      } else if (!bo.isNullOrNil(localag.D(localbi.field_msgId, localbi.field_imgPath))) {
        i = 5;
      } else {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ao.1
 * JD-Core Version:    0.7.0.1
 */