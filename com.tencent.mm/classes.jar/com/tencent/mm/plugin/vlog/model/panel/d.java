package com.tencent.mm.plugin.vlog.model.panel;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.b.o;
import com.tencent.mm.emoji.f.g;
import com.tencent.mm.plugin.vlog.a.h;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelGroupViewProvider;", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelGroupViewProvider;", "()V", "getGroupId", "", "setTabIcon", "", "icon", "Landroid/widget/ImageView;", "color", "", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements o
{
  public final void a(ImageView paramImageView, int paramInt, EmojiGroupInfo paramEmojiGroupInfo)
  {
    AppMethodBeat.i(283679);
    s.u(paramImageView, "icon");
    s.u(paramEmojiGroupInfo, "groupInfo");
    g.a(paramImageView, a.h.icons_filled_magic, paramInt);
    AppMethodBeat.o(283679);
  }
  
  public final String aVp()
  {
    AppMethodBeat.i(283668);
    String str = b.hRJ();
    AppMethodBeat.o(283668);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.panel.d
 * JD-Core Version:    0.7.0.1
 */