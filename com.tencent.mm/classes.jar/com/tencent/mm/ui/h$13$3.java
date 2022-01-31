package com.tencent.mm.ui;

import android.graphics.Color;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.preference.IconPreference;

final class h$13$3
  implements Runnable
{
  h$13$3(h.13 param13, int paramInt) {}
  
  public final void run()
  {
    h.a(this.uJt.uJi, true);
    IconPreference localIconPreference = (IconPreference)h.a(this.uJt.uJi).add("more_tab_game_recommend");
    if (this.uJt.uJr == 3)
    {
      localIconPreference.dD(this.uJt.uJi.getString(R.l.app_new), R.g.new_tips_bg);
      h.a(localIconPreference, 0, 8, false, 8, 8, 8);
      h.c(this.uJt.val$appId, this.uJt.qyH, this.uJt.uJs, this.uJt.dUE, 1);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.a(858L, 12L, 1L, false);
      if (this.uJu == 2) {
        com.tencent.mm.plugin.report.service.h.nFQ.a(858L, 14L, 1L, false);
      }
      return;
      if (this.uJt.uJr == 4)
      {
        localIconPreference.ap(this.uJt.fEt, -1, Color.parseColor("#8c8c8c"));
        h.a(localIconPreference, 8, 0, true, 8, 8, 8);
        h.c(this.uJt.val$appId, this.uJt.qyH, this.uJt.uJs, this.uJt.dUE, 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.h.13.3
 * JD-Core Version:    0.7.0.1
 */