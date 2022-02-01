package com.tencent.mm.plugin.textstatus.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class TextStatusEditActivity$m
  implements MenuItem.OnMenuItemClickListener
{
  TextStatusEditActivity$m(TextStatusEditActivity paramTextStatusEditActivity) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(216502);
    this.GeQ.finish();
    AppMethodBeat.o(216502);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.m
 * JD-Core Version:    0.7.0.1
 */