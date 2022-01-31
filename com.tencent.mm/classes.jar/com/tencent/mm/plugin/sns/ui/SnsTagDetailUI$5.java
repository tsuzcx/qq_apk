package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.h;

final class SnsTagDetailUI$5
  implements MenuItem.OnMenuItemClickListener
{
  SnsTagDetailUI$5(SnsTagDetailUI paramSnsTagDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (((this.pdQ.pdN + " " + bk.c(this.pdQ.iSZ, ",")).equals(this.pdQ.bIW)) && (this.pdQ.oqH != 0L))
    {
      this.pdQ.finish();
      return true;
    }
    h.a(this.pdQ, i.j.sns_tag_cancel, i.j.app_tip, new SnsTagDetailUI.5.1(this), null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTagDetailUI.5
 * JD-Core Version:    0.7.0.1
 */