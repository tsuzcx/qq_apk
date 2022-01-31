package com.tencent.mm.plugin.sns.ui.jsapi;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;

final class JsapiSnsLabelUI$8
  implements MenuItem.OnMenuItemClickListener
{
  JsapiSnsLabelUI$8(JsapiSnsLabelUI paramJsapiSnsLabelUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(40179);
    paramMenuItem = this.sjc;
    String str1 = bo.d(paramMenuItem.sja.rSs, ",");
    String str2 = bo.d(paramMenuItem.sja.rSu, ",");
    String str3 = bo.d(paramMenuItem.sja.rSt, ",");
    String str4 = bo.d(paramMenuItem.sja.rSv, ",");
    if (((paramMenuItem.sja.rSq == paramMenuItem.siX) && (paramMenuItem.sja.rSs.size() == 0) && (paramMenuItem.sja.rSu.size() == 0)) || ((paramMenuItem.sja.rSq == paramMenuItem.siY) && (paramMenuItem.sja.rSt.size() == 0) && (paramMenuItem.sja.rSv.size() == 0))) {
      h.a(paramMenuItem, paramMenuItem.getString(2131303859), "", paramMenuItem.getString(2131303871), null);
    }
    for (;;)
    {
      AppMethodBeat.o(40179);
      return true;
      if (((paramMenuItem.sja.rSq == paramMenuItem.siX) && (bo.isNullOrNil(str1)) && (bo.isNullOrNil(str2))) || ((paramMenuItem.sja.rSq == paramMenuItem.siY) && (bo.isNullOrNil(str3)) && (bo.isNullOrNil(str4)))) {
        h.a(paramMenuItem, paramMenuItem.getString(2131303859), "", paramMenuItem.getString(2131303871), null);
      } else {
        paramMenuItem.cvu();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.jsapi.JsapiSnsLabelUI.8
 * JD-Core Version:    0.7.0.1
 */