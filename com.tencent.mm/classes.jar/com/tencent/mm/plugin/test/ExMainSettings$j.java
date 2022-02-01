package com.tencent.mm.plugin.test;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class ExMainSettings$j
  implements MenuItem.OnMenuItemClickListener
{
  ExMainSettings$j(ExMainSettings paramExMainSettings) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(163404);
    this.zYc.finish();
    AppMethodBeat.o(163404);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.test.ExMainSettings.j
 * JD-Core Version:    0.7.0.1
 */