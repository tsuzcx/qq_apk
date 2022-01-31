package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;

final class MMTextInputUI$3
  implements MenuItem.OnMenuItemClickListener
{
  MMTextInputUI$3(MMTextInputUI paramMMTextInputUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    this.wdC.x(MMTextInputUI.b(this.wdC).getText());
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("key_result", MMTextInputUI.b(this.wdC).getText());
    this.wdC.setResult(-1, paramMenuItem);
    this.wdC.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMTextInputUI.3
 * JD-Core Version:    0.7.0.1
 */