package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class ComposeUI$10
  implements MenuItem.OnMenuItemClickListener
{
  ComposeUI$10(ComposeUI paramComposeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(122904);
    if (((ComposeUI.a(this.vXa, false)) && (ComposeUI.a(this.vXa) == 5)) || (ComposeUI.a(this.vXa) == 6)) {
      h.d(this.vXa.getContext(), this.vXa.getString(2131761969), "", this.vXa.getString(2131761971), this.vXa.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(122903);
          ComposeUI.10.this.vXa.setResult(0);
          ComposeUI.10.this.vXa.finish();
          AppMethodBeat.o(122903);
        }
      }, null);
    }
    for (;;)
    {
      AppMethodBeat.o(122904);
      return true;
      this.vXa.setResult(0);
      this.vXa.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.10
 * JD-Core Version:    0.7.0.1
 */