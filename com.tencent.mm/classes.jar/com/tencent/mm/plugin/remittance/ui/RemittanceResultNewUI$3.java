package com.tencent.mm.plugin.remittance.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

final class RemittanceResultNewUI$3
  implements n.d
{
  RemittanceResultNewUI$3(RemittanceResultNewUI paramRemittanceResultNewUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(45117);
    ClipboardManager localClipboardManager = (ClipboardManager)ah.getContext().getSystemService("clipboard");
    paramMenuItem = "";
    if (bo.hl(RemittanceResultNewUI.c(this.qru), 2131827254)) {
      paramMenuItem = RemittanceResultNewUI.d(this.qru).getText().toString().trim();
    }
    while (!bo.hl(RemittanceResultNewUI.c(this.qru), 2131827330))
    {
      localClipboardManager.setPrimaryClip(ClipData.newPlainText(null, paramMenuItem));
      h.bO(this.qru, this.qru.getString(2131296896));
      AppMethodBeat.o(45117);
      return;
    }
    paramMenuItem = new StringBuilder();
    paramMenuItem.append(RemittanceResultNewUI.e(this.qru).getText().toString().trim() + " ");
    String str = RemittanceResultNewUI.b(this.qru).getText().toString().trim();
    if (str.endsWith(this.qru.getString(2131296825))) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceResultNewUI.3
 * JD-Core Version:    0.7.0.1
 */