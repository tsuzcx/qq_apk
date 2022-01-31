package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EditSignatureUI$2
  implements MenuItem.OnMenuItemClickListener
{
  EditSignatureUI$2(EditSignatureUI paramEditSignatureUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(126945);
    this.qFL.hideVKB();
    this.qFL.finish();
    AppMethodBeat.o(126945);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.EditSignatureUI.2
 * JD-Core Version:    0.7.0.1
 */