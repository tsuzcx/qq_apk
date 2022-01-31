package com.tencent.mm.plugin.readerapp.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bl;
import com.tencent.mm.plugin.readerapp.b.a;
import com.tencent.mm.pluginsdk.n;

final class ReaderAppIntroUI$2
  implements MenuItem.OnMenuItemClickListener
{
  ReaderAppIntroUI$2(ReaderAppIntroUI paramReaderAppIntroUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(76799);
    a.gmO.c(new Intent().putExtra("Contact_User", bl.kF(ReaderAppIntroUI.a(this.pTT))), this.pTT);
    this.pTT.finish();
    AppMethodBeat.o(76799);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppIntroUI.2
 * JD-Core Version:    0.7.0.1
 */