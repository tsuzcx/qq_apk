package com.tencent.mm.storage;

import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class at$1
  implements j.a
{
  at$1(at paramat) {}
  
  public final void a(String paramString, l paraml)
  {
    if ((!bk.bl(paramString)) && (paramString.equals("event_update_group")))
    {
      y.d("MicroMsg.emoji.EmojiStorageMgr", "onNotifyChange event:%s", new Object[] { (String)paraml.obj });
      if (g.DN().Dc()) {}
    }
    while ((bk.bl(paramString)) || ((!paramString.equals("event_update_group")) && (!paramString.equalsIgnoreCase("productID"))))
    {
      return;
      ((d)g.t(d.class)).getEmojiDescMgr().cuR();
    }
    y.d("MicroMsg.emoji.EmojiStorageMgr", "modify emoji gorup .");
    at.uBn = true;
    at.uBr = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.storage.at.1
 * JD-Core Version:    0.7.0.1
 */