package com.tencent.mm.ui;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.av.p;
import com.tencent.mm.av.p.c;
import com.tencent.mm.booter.o;
import com.tencent.mm.booter.y;
import com.tencent.mm.booter.y.1;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.bu.a;
import com.tencent.mm.model.c;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;

final class HomeUI$18
  implements MessageQueue.IdleHandler
{
  HomeUI$18(HomeUI paramHomeUI) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(232571);
    bg.aVF();
    if (Util.nullAsNil((Integer)c.azQ().get(15, null)) == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("MicroMsg.LauncherUI.HomeUI", "not init finish , do not post sync task");
      AppMethodBeat.o(232571);
      return false;
    }
    Object localObject = bf.iDu.aA("login_user_name", "");
    if ((bg.aVG()) || (!((String)localObject).equals(""))) {
      bg.azz().a(new bu(new bu.a()
      {
        public final void a(g paramAnonymousg) {}
      }, "launch normal"), 0);
    }
    ThreadPool.post(new y.1(new y(HomeUI.b(this.ODr))), "StartupReport_report");
    o.akW();
    HomeUI.hRQ();
    h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(232570);
        try
        {
          f.eOF();
          AppMethodBeat.o(232570);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("MicroMsg.LauncherUI.HomeUI", "loadFilesToReport error message : " + localThrowable.getMessage());
          AppMethodBeat.o(232570);
        }
      }
    });
    localObject = p.bcF().iZH;
    Log.i("MicroMsg.SendImgSpeeder", "POOL_AUTO_FILL_SIZE is 0");
    ((p.c)localObject).bcJ();
    Looper.myQueue().removeIdleHandler(this.ODr.pzA);
    AppMethodBeat.o(232571);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.18
 * JD-Core Version:    0.7.0.1
 */