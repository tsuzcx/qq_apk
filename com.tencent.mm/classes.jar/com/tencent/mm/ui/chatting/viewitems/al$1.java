package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.h.a.fr;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.b.b.af;

final class al$1
  implements Runnable
{
  al$1(com.tencent.mm.ui.chatting.c.a parama, bi parambi) {}
  
  public final void run()
  {
    Object localObject = this.vBl;
    bi localbi = this.dUy;
    af localaf = (af)((com.tencent.mm.ui.chatting.c.a)localObject).ac(af.class);
    if ((localObject == null) || (localaf == null))
    {
      y.e("MicroMsg.ChattingItemVoice", "alvinluo ui or ui.transformImp null");
      return;
    }
    int i;
    if (localaf.hX(localbi.field_msgId)) {
      i = 2;
    }
    for (;;)
    {
      y.i("MicroMsg.ChattingItemVoice", "alvinluo TransformText report clickScene: %d, msgId: %d", new Object[] { Integer.valueOf(i), Long.valueOf(localbi.field_msgId) });
      localObject = new fr();
      ((fr)localObject).bMI.bMJ = 1;
      ((fr)localObject).bMI.scene = i;
      ((fr)localObject).bMI.fileName = localbi.field_imgPath;
      com.tencent.mm.sdk.b.a.udP.m((b)localObject);
      return;
      if (localaf.hU(localbi.field_msgId)) {
        i = 3;
      } else if (!bk.bl(localaf.E(localbi.field_msgId, localbi.field_imgPath))) {
        i = 5;
      } else {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.al.1
 * JD-Core Version:    0.7.0.1
 */