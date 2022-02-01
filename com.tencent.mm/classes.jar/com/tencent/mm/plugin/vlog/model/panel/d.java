package com.tencent.mm.plugin.vlog.model.panel;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.b.o;
import com.tencent.mm.emoji.d.e;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelGroupViewProvider;", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelGroupViewProvider;", "()V", "getGroupId", "", "setTabIcon", "", "icon", "Landroid/widget/ImageView;", "color", "", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "plugin-vlog_release"})
public final class d
  implements o
{
  public final void a(ImageView paramImageView, int paramInt, EmojiGroupInfo paramEmojiGroupInfo)
  {
    AppMethodBeat.i(191331);
    p.h(paramImageView, "icon");
    p.h(paramEmojiGroupInfo, "groupInfo");
    e.a(paramImageView, 2131691602, paramInt);
    AppMethodBeat.o(191331);
  }
  
  public final String afK()
  {
    AppMethodBeat.i(191330);
    String str = b.ewi();
    AppMethodBeat.o(191330);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.panel.d
 * JD-Core Version:    0.7.0.1
 */