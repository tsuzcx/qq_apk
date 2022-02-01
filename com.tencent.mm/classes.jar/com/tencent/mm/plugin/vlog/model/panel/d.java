package com.tencent.mm.plugin.vlog.model.panel;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.o;
import com.tencent.mm.emoji.e.e;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelGroupViewProvider;", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelGroupViewProvider;", "()V", "getGroupId", "", "setTabIcon", "", "icon", "Landroid/widget/ImageView;", "color", "", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "plugin-vlog_release"})
public final class d
  implements o
{
  public final void a(ImageView paramImageView, int paramInt, EmojiGroupInfo paramEmojiGroupInfo)
  {
    AppMethodBeat.i(190791);
    p.h(paramImageView, "icon");
    p.h(paramEmojiGroupInfo, "groupInfo");
    e.a(paramImageView, 2131690591, paramInt);
    AppMethodBeat.o(190791);
  }
  
  public final String avy()
  {
    AppMethodBeat.i(190790);
    String str = b.fCd();
    AppMethodBeat.o(190790);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.panel.d
 * JD-Core Version:    0.7.0.1
 */