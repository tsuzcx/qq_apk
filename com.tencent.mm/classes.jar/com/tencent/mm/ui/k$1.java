package com.tencent.mm.ui;

import android.app.Activity;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class k$1
  implements Runnable
{
  k$1(Activity paramActivity, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    Activity localActivity = this.val$activity;
    int i = this.uKF;
    int j = this.uKG;
    y.i("MicroMsg.LauncherUI.HomeUtil", "clickFlowStat index:%d op:%d %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), ah.Vb() });
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.k.1
 * JD-Core Version:    0.7.0.1
 */