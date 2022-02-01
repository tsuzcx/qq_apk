package com.tencent.mm.plugin.textstatus.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class TextStatusEditActivity$aj
  implements MenuItem.OnMenuItemClickListener
{
  TextStatusEditActivity$aj(TextStatusEditActivity paramTextStatusEditActivity) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(234261);
    this.MMz.finish();
    AppMethodBeat.o(234261);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.aj
 * JD-Core Version:    0.7.0.1
 */