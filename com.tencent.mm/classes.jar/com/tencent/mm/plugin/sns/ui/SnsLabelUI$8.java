package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;

final class SnsLabelUI$8
  implements MenuItem.OnMenuItemClickListener
{
  SnsLabelUI$8(SnsLabelUI paramSnsLabelUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(39018);
    paramMenuItem = this.rSh;
    String str1 = bo.d(paramMenuItem.rRT.rSs, ",");
    String str2 = bo.d(paramMenuItem.rRT.rSu, ",");
    String str3 = bo.d(paramMenuItem.rRT.rSw, ",");
    String str4 = bo.d(paramMenuItem.rRT.rSt, ",");
    String str5 = bo.d(paramMenuItem.rRT.rSv, ",");
    String str6 = bo.d(paramMenuItem.rRT.rSx, ",");
    if (((paramMenuItem.rRT.rSq == 2) && (paramMenuItem.rRT.rSs.size() == 0) && (paramMenuItem.rRT.rSu.size() == 0) && (paramMenuItem.rRT.rSw.size() == 0)) || ((paramMenuItem.rRT.rSq == 3) && (paramMenuItem.rRT.rSt.size() == 0) && (paramMenuItem.rRT.rSv.size() == 0) && (paramMenuItem.rRT.rSx.size() == 0))) {
      h.a(paramMenuItem, paramMenuItem.getString(2131303859), "", paramMenuItem.getString(2131303871), null);
    }
    for (;;)
    {
      AppMethodBeat.o(39018);
      return true;
      if (((paramMenuItem.rRT.rSq == 2) && (bo.isNullOrNil(str1)) && (bo.isNullOrNil(str2)) && (bo.isNullOrNil(str3))) || ((paramMenuItem.rRT.rSq == 3) && (bo.isNullOrNil(str4)) && (bo.isNullOrNil(str5)) && (bo.isNullOrNil(str6)))) {
        h.a(paramMenuItem, paramMenuItem.getString(2131303859), "", paramMenuItem.getString(2131303871), null);
      } else {
        paramMenuItem.cvu();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsLabelUI.8
 * JD-Core Version:    0.7.0.1
 */