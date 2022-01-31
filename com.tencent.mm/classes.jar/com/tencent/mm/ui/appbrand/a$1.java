package com.tencent.mm.ui.appbrand;

import android.view.MenuItem;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.n.d;

final class a$1
  implements n.d
{
  a$1(a parama) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    if (this.uRJ.uRH == null)
    {
      y.e("MicroMsg.AppBrandSerivceActionSheet", "resetOnCreateMenuListener, state is null");
      return;
    }
    this.uRJ.uRH.onMMMenuItemSelected(paramMenuItem, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.a.1
 * JD-Core Version:    0.7.0.1
 */