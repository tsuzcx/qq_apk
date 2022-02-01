package com.tencent.mm.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;

public final class k
{
  public static void a(Activity paramActivity, final int paramInt1, final int paramInt2, String paramString)
  {
    AppMethodBeat.i(33284);
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33283);
        Activity localActivity = k.this;
        int i = paramInt1;
        int j = paramInt2;
        Log.i("MicroMsg.LauncherUI.HomeUtil", "clickFlowStat index:%d op:%d %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Util.getStack() });
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
          d.d(i, str, localActivity.hashCode() / 16 * 16 + j);
        }
        AppMethodBeat.o(33283);
      }
    }, paramString);
    AppMethodBeat.o(33284);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.k
 * JD-Core Version:    0.7.0.1
 */