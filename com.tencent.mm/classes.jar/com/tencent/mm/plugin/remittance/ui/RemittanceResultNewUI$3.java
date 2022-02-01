package com.tencent.mm.plugin.remittance.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.e;

final class RemittanceResultNewUI$3
  implements n.e
{
  RemittanceResultNewUI$3(RemittanceResultNewUI paramRemittanceResultNewUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(68281);
    ClipboardManager localClipboardManager = (ClipboardManager)aj.getContext().getSystemService("clipboard");
    paramMenuItem = "";
    if (bt.jx(RemittanceResultNewUI.c(this.ygq), 2131304016)) {
      paramMenuItem = RemittanceResultNewUI.d(this.ygq).getText().toString().trim();
    }
    while (!bt.jx(RemittanceResultNewUI.c(this.ygq), 2131303988))
    {
      localClipboardManager.setPrimaryClip(ClipData.newPlainText(null, paramMenuItem));
      h.cl(this.ygq, this.ygq.getString(2131755702));
      AppMethodBeat.o(68281);
      return;
    }
    paramMenuItem = new StringBuilder();
    paramMenuItem.append(RemittanceResultNewUI.e(this.ygq).getText().toString().trim() + " ");
    String str = RemittanceResultNewUI.b(this.ygq).getText().toString().trim();
    if (str.endsWith(this.ygq.getString(2131762446))) {
      paramMenuItem.append(str.substring(0, str.length() - 4));
    }
    for (;;)
    {
      paramMenuItem = paramMenuItem.toString();
      break;
      paramMenuItem.append(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceResultNewUI.3
 * JD-Core Version:    0.7.0.1
 */