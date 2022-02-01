package com.tencent.mm.plugin.webview.emojistore.ui;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.h;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/emojistore/ui/MenuItemCreateListener;", "Landroid/view/View$OnCreateContextMenuListener;", "item", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "(Lcom/tencent/mm/emoji/model/panel/EmojiItem;)V", "getItem", "()Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "onCreateContextMenu", "", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "plugin-webview_release"})
public final class a
  implements View.OnCreateContextMenuListener
{
  private final h Cgl;
  
  public a(h paramh)
  {
    this.Cgl = paramh;
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(189441);
    if (paramContextMenu != null) {
      paramContextMenu.add(0, 0, 0, 2131755137);
    }
    AppMethodBeat.o(189441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.ui.a
 * JD-Core Version:    0.7.0.1
 */