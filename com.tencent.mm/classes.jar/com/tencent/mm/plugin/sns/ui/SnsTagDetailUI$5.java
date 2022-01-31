package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

final class SnsTagDetailUI$5
  implements MenuItem.OnMenuItemClickListener
{
  SnsTagDetailUI$5(SnsTagDetailUI paramSnsTagDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(39348);
    if (((this.rWD.rWA + " " + bo.d(this.rWD.lbK, ",")).equals(this.rWD.cqq)) && (this.rWD.rfr != 0L))
    {
      this.rWD.finish();
      AppMethodBeat.o(39348);
      return true;
    }
    h.a(this.rWD, 2131303972, 2131297087, new SnsTagDetailUI.5.1(this), null);
    AppMethodBeat.o(39348);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTagDetailUI.5
 * JD-Core Version:    0.7.0.1
 */