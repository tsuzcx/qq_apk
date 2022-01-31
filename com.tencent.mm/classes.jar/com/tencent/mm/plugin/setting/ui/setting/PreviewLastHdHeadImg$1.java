package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.d;

final class PreviewLastHdHeadImg$1
  implements MenuItem.OnMenuItemClickListener
{
  PreviewLastHdHeadImg$1(PreviewLastHdHeadImg paramPreviewLastHdHeadImg) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127007);
    paramMenuItem = new d(this.qGt, 1, false);
    paramMenuItem.sao = new PreviewLastHdHeadImg.1.1(this);
    paramMenuItem.sap = new PreviewLastHdHeadImg.1.2(this);
    paramMenuItem.crd();
    AppMethodBeat.o(127007);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PreviewLastHdHeadImg.1
 * JD-Core Version:    0.7.0.1
 */