package com.tencent.mm.plugin.websearch.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class WebSearchImageLoadingUI$a
  implements MenuItem.OnMenuItemClickListener
{
  WebSearchImageLoadingUI$a(WebSearchImageLoadingUI paramWebSearchImageLoadingUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(212500);
    WebSearchImageLoadingUI.b(this.DVl);
    this.DVl.finish();
    AppMethodBeat.o(212500);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchImageLoadingUI.a
 * JD-Core Version:    0.7.0.1
 */