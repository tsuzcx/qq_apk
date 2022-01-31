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

final class RemittanceDetailUI$10
  implements n.d
{
  RemittanceDetailUI$10(RemittanceDetailUI paramRemittanceDetailUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(45006);
    ClipboardManager localClipboardManager = (ClipboardManager)ah.getContext().getSystemService("clipboard");
    paramMenuItem = "";
    if (bo.hl(RemittanceDetailUI.n(this.qpY), 2131827254)) {
      paramMenuItem = RemittanceDetailUI.o(this.qpY).getText().toString().trim();
    }
    do
    {
      for (;;)
      {
        localClipboardManager.setPrimaryClip(ClipData.newPlainText(null, paramMenuItem));
        h.bO(this.qpY, this.qpY.getString(2131296896));
        AppMethodBeat.o(45006);
        return;
        if (bo.hl(RemittanceDetailUI.n(this.qpY), 2131827257))
        {
          paramMenuItem = new StringBuilder();
          paramMenuItem.append(RemittanceDetailUI.p(this.qpY).getText().toString().trim() + " ");
          str = RemittanceDetailUI.l(this.qpY).getText().toString().trim();
          if (str.endsWith(this.qpY.getString(2131296825))) {
            paramMenuItem.append(str.substring(0, str.length() - 4));
          }
          for (;;)
          {
            paramMenuItem = paramMenuItem.toString();
            break;
            paramMenuItem.append(str);
          }
        }
        if (!bo.hl(RemittanceDetailUI.n(this.qpY), 2131827272)) {
          break;
        }
        paramMenuItem = RemittanceDetailUI.q(this.qpY).getText().toString().trim();
      }
    } while (!bo.hl(RemittanceDetailUI.n(this.qpY), 2131827275));
    paramMenuItem = new StringBuilder();
    paramMenuItem.append(RemittanceDetailUI.r(this.qpY).getText().toString().trim() + " ");
    String str = RemittanceDetailUI.f(this.qpY).getText().toString().trim();
    if (str.endsWith(this.qpY.getString(2131296825))) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.10
 * JD-Core Version:    0.7.0.1
 */