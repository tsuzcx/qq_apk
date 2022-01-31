package com.tencent.mm.plugin.product.ui;

import android.content.res.Resources;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.ui.base.h;

final class MallGalleryUI$4
  implements MenuItem.OnMenuItemClickListener
{
  MallGalleryUI$4(MallGalleryUI paramMallGalleryUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(44039);
    if (d.ahR("favorite")) {}
    for (paramMenuItem = this.pvE.getResources().getStringArray(2131755033);; paramMenuItem = this.pvE.getResources().getStringArray(2131755034))
    {
      h.a(this.pvE.getContext(), null, paramMenuItem, null, false, new MallGalleryUI.4.1(this));
      AppMethodBeat.o(44039);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallGalleryUI.4
 * JD-Core Version:    0.7.0.1
 */