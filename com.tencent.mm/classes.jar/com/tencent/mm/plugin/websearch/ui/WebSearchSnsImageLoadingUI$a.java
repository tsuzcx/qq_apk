package com.tencent.mm.plugin.websearch.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class WebSearchSnsImageLoadingUI$a
  implements MenuItem.OnMenuItemClickListener
{
  WebSearchSnsImageLoadingUI$a(WebSearchSnsImageLoadingUI paramWebSearchSnsImageLoadingUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(198019);
    this.IGR.finish();
    WebSearchSnsImageLoadingUI.a(this.IGR, 11, "", WebSearchSnsImageLoadingUI.a(this.IGR), 0, System.currentTimeMillis());
    AppMethodBeat.o(198019);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchSnsImageLoadingUI.a
 * JD-Core Version:    0.7.0.1
 */