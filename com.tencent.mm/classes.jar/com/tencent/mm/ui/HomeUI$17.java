package com.tencent.mm.ui;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.booter.o;
import com.tencent.mm.booter.y;
import com.tencent.mm.booter.y.1;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bw.a;
import com.tencent.mm.model.c;
import com.tencent.mm.modelimage.q;
import com.tencent.mm.modelimage.q.c;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.aq;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

final class HomeUI$17
  implements MessageQueue.IdleHandler
{
  HomeUI$17(HomeUI paramHomeUI) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(249453);
    bh.bCz();
    if (Util.nullAsNil((Integer)c.ban().d(15, null)) == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("MicroMsg.LauncherUI.HomeUI", "not init finish , do not post sync task");
      AppMethodBeat.o(249453);
      return false;
    }
    Object localObject = bg.okT.aM("login_user_name", "");
    if ((bh.bCA()) || (!((String)localObject).equals(""))) {
      bh.aZW().a(new bw(new bw.a()
      {
        public final void b(g paramAnonymousg) {}
      }, "launch normal"), 0);
    }
    ThreadPool.post(new y.1(new y(HomeUI.c(this.adBf))), "StartupReport_report");
    o.aKQ();
    HomeUI.jje();
    h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(249691);
        try
        {
          f.gNT();
          AppMethodBeat.o(249691);
          return;
        }
        finally
        {
          Log.e("MicroMsg.LauncherUI.HomeUI", "loadFilesToReport error message : " + localObject.getMessage());
          AppMethodBeat.o(249691);
        }
      }
    });
    localObject = q.bJO().oIM;
    Log.i("MicroMsg.SendImgSpeeder", "POOL_AUTO_FILL_SIZE is 0");
    ((q.c)localObject).bJS();
    Looper.myQueue().removeIdleHandler(this.adBf.fgm);
    AppMethodBeat.o(249453);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.17
 * JD-Core Version:    0.7.0.1
 */