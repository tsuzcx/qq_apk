package com.tencent.mm.plugin.remittance.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.e;

final class RemittanceDetailUI$11
  implements n.e
{
  RemittanceDetailUI$11(RemittanceDetailUI paramRemittanceDetailUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(68135);
    ClipboardManager localClipboardManager = (ClipboardManager)ak.getContext().getSystemService("clipboard");
    paramMenuItem = "";
    if (bu.jB(RemittanceDetailUI.n(this.yuO), 2131304016)) {
      paramMenuItem = RemittanceDetailUI.o(this.yuO).getText().toString().trim();
    }
    do
    {
      for (;;)
      {
        localClipboardManager.setPrimaryClip(ClipData.newPlainText(null, paramMenuItem));
        h.cm(this.yuO, this.yuO.getString(2131755702));
        AppMethodBeat.o(68135);
        return;
        if (bu.jB(RemittanceDetailUI.n(this.yuO), 2131303989))
        {
          paramMenuItem = new StringBuilder();
          paramMenuItem.append(RemittanceDetailUI.p(this.yuO).getText().toString().trim() + " ");
          str = RemittanceDetailUI.l(this.yuO).getText().toString().trim();
          if (str.endsWith(this.yuO.getString(2131762446))) {
            paramMenuItem.append(str.substring(0, str.length() - 4));
          }
          for (;;)
          {
            paramMenuItem = paramMenuItem.toString();
            break;
            paramMenuItem.append(str);
          }
        }
        if (!bu.jB(RemittanceDetailUI.n(this.yuO), 2131304015)) {
          break;
        }
        paramMenuItem = RemittanceDetailUI.q(this.yuO).getText().toString().trim();
      }
    } while (!bu.jB(RemittanceDetailUI.n(this.yuO), 2131303990));
    paramMenuItem = new StringBuilder();
    paramMenuItem.append(RemittanceDetailUI.r(this.yuO).getText().toString().trim() + " ");
    String str = RemittanceDetailUI.f(this.yuO).getText().toString().trim();
    if (str.endsWith(this.yuO.getString(2131762446))) {
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
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.11
 * JD-Core Version:    0.7.0.1
 */