package com.tencent.mm.view.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.emotion.EmojiInfo;

final class a$7
  implements k.a
{
  a$7(a parama) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(63029);
    ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "emoji storage notify %s", new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(63029);
      return;
    }
    if (paramString.equalsIgnoreCase("delete_emoji_info_notify"))
    {
      this.AUz.dRo();
      AppMethodBeat.o(63029);
      return;
    }
    if (!g.RJ().QU())
    {
      AppMethodBeat.o(63029);
      return;
    }
    paramm = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt(paramString);
    if (paramm != null)
    {
      ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "update emoji %s, group %x.", new Object[] { paramString, Integer.valueOf(paramm.field_catalog) });
      this.AUz.dRo();
    }
    AppMethodBeat.o(63029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.e.a.7
 * JD-Core Version:    0.7.0.1
 */