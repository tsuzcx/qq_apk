package com.tencent.mm.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ab;

final class j$1
  implements Runnable
{
  j$1(Activity paramActivity, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(29436);
    Activity localActivity = this.val$activity;
    int i = this.yYH;
    int j = this.yYI;
    ab.i("MicroMsg.LauncherUI.HomeUtil", "clickFlowStat index:%d op:%d %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), ah.aoA() });
    if (j >= 0)
    {
      String str = "MainUI";
      if (j == 1) {
        str = "AddressUI";
      }
      if (j == 2) {
        str = "FindMoreFriendUI";
      }
      if (j == 3) {
        str = "MoreTabUI";
      }
      d.b(i, str, localActivity.hashCode() / 16 * 16 + j);
    }
    AppMethodBeat.o(29436);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.j.1
 * JD-Core Version:    0.7.0.1
 */