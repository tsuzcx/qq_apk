package com.tencent.mm.plugin.readerapp.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.model.bj;
import com.tencent.mm.plugin.readerapp.b.a;
import com.tencent.mm.pluginsdk.m;

final class ReaderAppIntroUI$2
  implements MenuItem.OnMenuItemClickListener
{
  ReaderAppIntroUI$2(ReaderAppIntroUI paramReaderAppIntroUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    a.eUR.d(new Intent().putExtra("Contact_User", bj.hS(ReaderAppIntroUI.a(this.noF))), this.noF);
    this.noF.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppIntroUI.2
 * JD-Core Version:    0.7.0.1
 */