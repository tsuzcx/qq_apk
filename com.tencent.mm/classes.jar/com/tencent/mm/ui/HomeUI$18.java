package com.tencent.mm.ui;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.ay.p;
import com.tencent.mm.ay.p.c;
import com.tencent.mm.booter.o;
import com.tencent.mm.booter.y;
import com.tencent.mm.booter.y.1;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.c;
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
    AppMethodBeat.i(265886);
    bh.beI();
    if (Util.nullAsNil((Integer)c.aHp().b(15, null)) == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("MicroMsg.LauncherUI.HomeUI", "not init finish , do not post sync task");
      AppMethodBeat.o(265886);
      return false;
    }
    Object localObject = bg.ltv.aD("login_user_name", "");
    if ((bh.beJ()) || (!((String)localObject).equals(""))) {
      bh.aGY().a(new bv(new HomeUI.18.1(this), "launch normal"), 0);
    }
    ThreadPool.post(new y.1(new y(HomeUI.c(this.VWJ))), "StartupReport_report");
    o.aqS();
    HomeUI.hGT();
    h.ZvG.be(new HomeUI.18.2(this));
    localObject = p.blV().lQc;
    Log.i("MicroMsg.SendImgSpeeder", "POOL_AUTO_FILL_SIZE is 0");
    ((p.c)localObject).blZ();
    Looper.myQueue().removeIdleHandler(this.VWJ.sJE);
    AppMethodBeat.o(265886);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.18
 * JD-Core Version:    0.7.0.1
 */