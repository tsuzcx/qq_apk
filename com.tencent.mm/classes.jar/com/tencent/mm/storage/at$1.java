package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class at$1
  implements k.a
{
  at$1(at paramat) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(62709);
    if ((!bo.isNullOrNil(paramString)) && (paramString.equals("event_update_group")))
    {
      ab.d("MicroMsg.emoji.EmojiStorageMgr", "onNotifyChange event:%s", new Object[] { (String)paramm.obj });
      if (!g.RJ().QU())
      {
        AppMethodBeat.o(62709);
        return;
      }
      ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiDescMgr().dxs();
    }
    if ((!bo.isNullOrNil(paramString)) && ((paramString.equals("event_update_group")) || (paramString.equalsIgnoreCase("productID"))))
    {
      ab.d("MicroMsg.emoji.EmojiStorageMgr", "modify emoji gorup .");
      at.yNA = true;
      at.a(this.yNJ).cl(true);
    }
    AppMethodBeat.o(62709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.storage.at.1
 * JD-Core Version:    0.7.0.1
 */