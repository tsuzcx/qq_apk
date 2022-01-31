package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMTextInputUI$3
  implements MenuItem.OnMenuItemClickListener
{
  MMTextInputUI$3(MMTextInputUI paramMMTextInputUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(107726);
    this.Awk.G(MMTextInputUI.b(this.Awk).getText());
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("key_result", MMTextInputUI.b(this.Awk).getText());
    this.Awk.setResult(-1, paramMenuItem);
    this.Awk.finish();
    AppMethodBeat.o(107726);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMTextInputUI.3
 * JD-Core Version:    0.7.0.1
 */