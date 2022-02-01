package com.tencent.mm.plugin.textstatus.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class TextStatusLikeListActivity$j
  implements MenuItem.OnMenuItemClickListener
{
  TextStatusLikeListActivity$j(TextStatusLikeListActivity paramTextStatusLikeListActivity) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(233415);
    this.MNC.onBackPressed();
    AppMethodBeat.o(233415);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListActivity.j
 * JD-Core Version:    0.7.0.1
 */