package com.tencent.mm.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class j
{
  public static void a(Activity paramActivity, final int paramInt1, final int paramInt2, String paramString)
  {
    AppMethodBeat.i(33284);
    b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33283);
        Activity localActivity = this.val$activity;
        int i = paramInt1;
        int j = paramInt2;
        ad.i("MicroMsg.LauncherUI.HomeUtil", "clickFlowStat index:%d op:%d %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), bt.eGN() });
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
          d.c(i, str, localActivity.hashCode() / 16 * 16 + j);
        }
        AppMethodBeat.o(33283);
      }
    }, paramString);
    AppMethodBeat.o(33284);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.j
 * JD-Core Version:    0.7.0.1
 */