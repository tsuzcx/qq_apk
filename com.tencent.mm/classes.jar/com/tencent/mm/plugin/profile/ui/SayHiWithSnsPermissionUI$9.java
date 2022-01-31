package com.tencent.mm.plugin.profile.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SayHiWithSnsPermissionUI$9
  implements MenuItem.OnMenuItemClickListener
{
  SayHiWithSnsPermissionUI$9(SayHiWithSnsPermissionUI paramSayHiWithSnsPermissionUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(153574);
    if (SayHiWithSnsPermissionUI.k(this.pCR)) {
      SayHiWithSnsPermissionUI.l(this.pCR)[1] = 1;
    }
    this.pCR.finish();
    AppMethodBeat.o(153574);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.9
 * JD-Core Version:    0.7.0.1
 */