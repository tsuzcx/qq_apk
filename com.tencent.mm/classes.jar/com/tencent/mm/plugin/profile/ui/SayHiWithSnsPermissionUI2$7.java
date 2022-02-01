package com.tencent.mm.plugin.profile.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SayHiWithSnsPermissionUI2$7
  implements MenuItem.OnMenuItemClickListener
{
  SayHiWithSnsPermissionUI2$7(SayHiWithSnsPermissionUI2 paramSayHiWithSnsPermissionUI2) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(179683);
    if (SayHiWithSnsPermissionUI2.l(this.BiF)) {
      SayHiWithSnsPermissionUI2.m(this.BiF)[1] = 1;
    }
    this.BiF.finish();
    SayHiWithSnsPermissionUI2.n(this.BiF);
    AppMethodBeat.o(179683);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI2.7
 * JD-Core Version:    0.7.0.1
 */