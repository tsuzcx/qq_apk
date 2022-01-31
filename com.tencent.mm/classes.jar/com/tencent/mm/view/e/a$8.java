package com.tencent.mm.view.e;

import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.emotion.EmojiInfo;

final class a$8
  implements j.a
{
  a$8(a parama) {}
  
  public final void a(String paramString, l paraml)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        return;
        if (paramString.equalsIgnoreCase("delete_emoji_info_notify"))
        {
          this.wzg.cLR();
          return;
        }
      } while (!g.DN().Dc());
      paramString = ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As(paramString);
    } while ((paramString == null) || (paramString.field_catalog != EmojiInfo.uCZ));
    ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().aHp();
    y.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "update emoji");
    this.wzg.cLR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.e.a.8
 * JD-Core Version:    0.7.0.1
 */