package com.tencent.mm.plugin.readerapp.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.readerapp.b.a;
import com.tencent.mm.pluginsdk.m;

final class ReaderAppUI$8
  implements MenuItem.OnMenuItemClickListener
{
  ReaderAppUI$8(ReaderAppUI paramReaderAppUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    a.eUR.d(new Intent().putExtra("Contact_User", ReaderAppUI.f(this.noS)), this.noS);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.8
 * JD-Core Version:    0.7.0.1
 */