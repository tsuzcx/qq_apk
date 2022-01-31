package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.d;

final class PreviewHdHeadImg$1
  implements MenuItem.OnMenuItemClickListener
{
  PreviewHdHeadImg$1(PreviewHdHeadImg paramPreviewHdHeadImg) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(126989);
    paramMenuItem = new d(this.qGo, 1, false);
    paramMenuItem.sao = new PreviewHdHeadImg.1.1(this);
    paramMenuItem.sap = new PreviewHdHeadImg.1.2(this);
    paramMenuItem.crd();
    AppMethodBeat.o(126989);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg.1
 * JD-Core Version:    0.7.0.1
 */