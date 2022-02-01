package com.tencent.mm.plugin.vlog.model.panel;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.o;
import com.tencent.mm.emoji.e.e;
import com.tencent.mm.plugin.vlog.a.h;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelGroupViewProvider;", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelGroupViewProvider;", "()V", "getGroupId", "", "setTabIcon", "", "icon", "Landroid/widget/ImageView;", "color", "", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "plugin-vlog_release"})
public final class d
  implements o
{
  public final void a(ImageView paramImageView, int paramInt, EmojiGroupInfo paramEmojiGroupInfo)
  {
    AppMethodBeat.i(232409);
    p.k(paramImageView, "icon");
    p.k(paramEmojiGroupInfo, "groupInfo");
    e.a(paramImageView, a.h.icons_filled_magic, paramInt);
    AppMethodBeat.o(232409);
  }
  
  public final String aCt()
  {
    AppMethodBeat.i(232407);
    String str = b.gub();
    AppMethodBeat.o(232407);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.panel.d
 * JD-Core Version:    0.7.0.1
 */