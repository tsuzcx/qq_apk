package com.tencent.mm.plugin.vlog.model.panel;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.o;
import com.tencent.mm.emoji.d.c;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelGroupViewProvider;", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelGroupViewProvider;", "()V", "getGroupId", "", "setTabIcon", "", "icon", "Landroid/widget/ImageView;", "color", "", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "plugin-vlog_release"})
public final class d
  implements o
{
  public final void a(ImageView paramImageView, int paramInt, EmojiGroupInfo paramEmojiGroupInfo)
  {
    AppMethodBeat.i(195872);
    p.h(paramImageView, "icon");
    p.h(paramEmojiGroupInfo, "groupInfo");
    c.a(paramImageView, 2131691602, paramInt);
    AppMethodBeat.o(195872);
  }
  
  public final String afw()
  {
    AppMethodBeat.i(195871);
    String str = b.esB();
    AppMethodBeat.o(195871);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.panel.d
 * JD-Core Version:    0.7.0.1
 */