package com.tencent.mm.plugin.webview.emojistore.ui;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.plugin.webview.c.i;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/emojistore/ui/MenuItemCreateListener;", "Landroid/view/View$OnCreateContextMenuListener;", "item", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "(Lcom/tencent/mm/emoji/model/panel/EmojiItem;)V", "getItem", "()Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "onCreateContextMenu", "", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "plugin-webview_release"})
public final class a
  implements View.OnCreateContextMenuListener
{
  private final h PJR;
  
  public a(h paramh)
  {
    this.PJR = paramh;
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(242203);
    if (paramContextMenu != null) {
      paramContextMenu.add(0, 0, 0, c.i.add_emoji_to_emoji_board);
    }
    AppMethodBeat.o(242203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.ui.a
 * JD-Core Version:    0.7.0.1
 */