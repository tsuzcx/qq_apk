package com.tencent.mm.plugin.product.ui;

import android.content.res.Resources;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.List;

final class MallProductUI$7
  implements MenuItem.OnMenuItemClickListener
{
  MallProductUI$7(MallProductUI paramMallProductUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(44164);
    paramMenuItem = this.pxl.getResources().getStringArray(2131755035);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramMenuItem.length)
    {
      localArrayList.add(paramMenuItem[i]);
      i += 1;
    }
    if ((this.pxl.pvR.caW().pvN & 0x1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.MallProductConfig", "isShowSellerEntry, ret = ".concat(String.valueOf(bool)));
      if (bool) {
        localArrayList.add(this.pxl.getString(2131301485));
      }
      h.a(this.pxl.getContext(), null, (String[])localArrayList.toArray(new String[localArrayList.size()]), null, false, new MallProductUI.7.1(this));
      AppMethodBeat.o(44164);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductUI.7
 * JD-Core Version:    0.7.0.1
 */