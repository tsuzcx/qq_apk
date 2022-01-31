package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import com.tencent.mm.bh.d;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.n.d;

final class ShakeSayHiListUI$2
  implements n.d
{
  ShakeSayHiListUI$2(ShakeSayHiListUI paramShakeSayHiListUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    d.Sa().Hs(String.valueOf(ShakeSayHiListUI.g(this.odv)));
    ShakeSayHiListUI.b(this.odv).a(null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI.2
 * JD-Core Version:    0.7.0.1
 */