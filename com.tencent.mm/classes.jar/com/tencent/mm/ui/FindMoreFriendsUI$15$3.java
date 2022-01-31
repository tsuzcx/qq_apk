package com.tencent.mm.ui;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.IconPreference;

final class FindMoreFriendsUI$15$3
  implements Runnable
{
  FindMoreFriendsUI$15$3(FindMoreFriendsUI.15 param15, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(29229);
    FindMoreFriendsUI.a(this.yWS.yWI, true);
    IconPreference localIconPreference = (IconPreference)FindMoreFriendsUI.a(this.yWS.yWI).atx("more_tab_game_recommend");
    if (this.yWS.yWR == 3)
    {
      localIconPreference.eN(this.yWS.yWI.getString(2131297012), 2130839787);
      FindMoreFriendsUI.b(localIconPreference, 0, 8, false, 8, 8, 8);
      FindMoreFriendsUI.c(this.yWS.val$appId, this.yWS.uls, this.yWS.tgD, this.yWS.fkN, 1);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(858L, 12L, 1L, false);
      if (this.jiC == 2) {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(858L, 14L, 1L, false);
      }
      AppMethodBeat.o(29229);
      return;
      if (this.yWS.yWR == 4)
      {
        localIconPreference.aG(this.yWS.gWJ, -1, Color.parseColor("#8c8c8c"));
        FindMoreFriendsUI.b(localIconPreference, 8, 0, true, 8, 8, 8);
        FindMoreFriendsUI.c(this.yWS.val$appId, this.yWS.uls, this.yWS.tgD, this.yWS.fkN, 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.15.3
 * JD-Core Version:    0.7.0.1
 */