package com.tencent.mm.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.mr;
import com.tencent.mm.model.bh;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.y.a;
import com.tencent.mm.pluginsdk.j.g;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.applet.SecurityImage;

public final class ac
{
  private static boolean WaP = false;
  static ProgressDialog iXX = null;
  static SecurityImage mUP = null;
  
  public static com.tencent.mm.ui.widget.a.d a(Activity paramActivity, String paramString1, String paramString2, Intent paramIntent)
  {
    AppMethodBeat.i(33449);
    mr localmr = new mr();
    localmr.fKQ.status = 0;
    localmr.fKQ.bnA = 1;
    EventCenter.instance.publish(localmr);
    paramActivity = com.tencent.mm.ui.base.h.a(paramActivity, paramString1, paramActivity.getString(R.l.app_tip), new ac.1(paramString2, paramActivity, paramIntent), new ac.2(paramString2, paramActivity, paramIntent));
    AppMethodBeat.o(33449);
    return paramActivity;
  }
  
  public static void bo(Activity paramActivity)
  {
    AppMethodBeat.i(266760);
    com.tencent.e.h.ZvG.d(new Runnable()
    {
      public final void run()
      {
        int k = 1;
        int j = 0;
        AppMethodBeat.i(279789);
        if (Util.safeParseInt(com.tencent.mm.n.h.axc().getValue("SilentDownloadApkAtWiFi")) != 0)
        {
          AppMethodBeat.o(279789);
          return;
        }
        bh.beI();
        int i;
        if ((((Integer)com.tencent.mm.model.c.aHp().b(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
        {
          i = 1;
          if ((!NetStatusUtil.isWifi(this.fgc)) || (i == 0)) {
            break label128;
          }
          i = k;
          label75:
          if ((ChannelUtil.updateMode & 0x1) == 0) {
            break label133;
          }
          Log.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
          i = j;
        }
        for (;;)
        {
          if ((i != 0) && (g.hic())) {
            this.fgc.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(289700);
                if (ac.bq(ac.3.this.fgc)) {
                  Log.d("MicroMsg.MMErrorProcessor", "we got an unfinished silence download");
                }
                AppMethodBeat.o(289700);
              }
            });
          }
          AppMethodBeat.o(279789);
          return;
          i = 0;
          break;
          label128:
          i = 0;
          break label75;
          label133:
          Log.d("MicroMsg.MMErrorProcessor", "not channel pack.");
        }
      }
    }, "Thread-checkUnfinishSilenceDownload");
    AppMethodBeat.o(266760);
  }
  
  private static boolean bp(Activity paramActivity)
  {
    AppMethodBeat.i(33453);
    b localb = b.hhn();
    if (localb != null)
    {
      localb.hhq();
      Log.i("MicroMsg.MMErrorProcessor", "alpha download in silence.");
      AppMethodBeat.o(33453);
      return true;
    }
    if (com.tencent.mm.plugin.y.d.eUZ() != null)
    {
      com.tencent.mm.plugin.y.d.eUZ().hy(paramActivity).update(2);
      AppMethodBeat.o(33453);
      return true;
    }
    AppMethodBeat.o(33453);
    return false;
  }
  
  public static boolean c(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33452);
    Log.w("MicroMsg.MMErrorProcessor", "updateRequired [%d,%d] current version:%d  channel:%d updateMode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(com.tencent.mm.protocal.d.RAD), Integer.valueOf(ChannelUtil.channelId), Integer.valueOf(ChannelUtil.updateMode) });
    if (paramInt1 != 4)
    {
      AppMethodBeat.o(33452);
      return false;
    }
    switch (paramInt2)
    {
    default: 
      AppMethodBeat.o(33452);
      return false;
    case -16: 
      if (com.tencent.mm.plugin.y.d.eUZ() != null)
      {
        paramActivity = com.tencent.mm.plugin.y.d.eUZ().c(paramActivity, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(33442);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(405L, 37L, 1L, true);
            this.fgc.finish();
            MMAppMgr.bT(this.fgc);
            AppMethodBeat.o(33442);
          }
        });
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(405L, 36L, 1L, true);
        paramActivity.update(1);
        AppMethodBeat.o(33452);
        return true;
      }
      AppMethodBeat.o(33452);
      return false;
    }
    long l = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).getLong("recomended_update_ignore", -1L);
    Log.i("MicroMsg.MMErrorProcessor", "updateRequired last:%d  now:%d", new Object[] { Long.valueOf(l), Long.valueOf(Util.secondsToNow(l)) });
    if ((l != -1L) && (Util.secondsToNow(l) < 86400L))
    {
      AppMethodBeat.o(33452);
      return true;
    }
    if ((ChannelUtil.updateMode & 0x2) != 0)
    {
      Log.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
      AppMethodBeat.o(33452);
      return true;
    }
    Log.d("MicroMsg.MMErrorProcessor", "not channel pack.");
    String str = com.tencent.mm.n.h.axc().getValue("SilentDownloadApkAtWiFi");
    bh.beI();
    if ((((Integer)com.tencent.mm.model.c.aHp().b(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
    {
      paramInt1 = 1;
      if ((paramInt1 == 0) || ((!Util.isNullOrNil(str)) && (Util.safeParseInt(str) != 0))) {
        break label442;
      }
      bool = true;
      label326:
      if ((ChannelUtil.updateMode & 0x1) == 0) {
        break label448;
      }
      Log.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
      bool = false;
    }
    for (;;)
    {
      if (Util.safeParseInt(str) != 0) {
        Log.d("MicroMsg.MMErrorProcessor", "dynaCfg close silence wifi download.");
      }
      Log.d("MicroMsg.MMErrorProcessor", "summerupdate updateRequired silenceDownload[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        break label465;
      }
      if (com.tencent.mm.plugin.y.d.eUZ() == null) {
        break label458;
      }
      paramActivity = com.tencent.mm.plugin.y.d.eUZ().c(paramActivity, new ac.6(paramActivity));
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(405L, 38L, 1L, true);
      paramActivity.update(2);
      AppMethodBeat.o(33452);
      return true;
      paramInt1 = 0;
      break;
      label442:
      bool = false;
      break label326;
      label448:
      Log.d("MicroMsg.MMErrorProcessor", "not channel pack.");
    }
    label458:
    AppMethodBeat.o(33452);
    return false;
    label465:
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(405L, 40L, 1L, true);
    boolean bool = bp(paramActivity);
    AppMethodBeat.o(33452);
    return bool;
  }
  
  public static boolean kR(final Context paramContext)
  {
    AppMethodBeat.i(33451);
    final String str = g.hhZ();
    int i = g.hia();
    Log.i("MicroMsg.MMErrorProcessor", "installRequired %s, updateType: %d", new Object[] { str, Integer.valueOf(i) });
    if ((!Util.isNullOrNil(str)) && (!g.hib()))
    {
      bh.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(276555);
          if ((this.WaR == 4) && (b.hhn() == null))
          {
            Log.w("MicroMsg.MMErrorProcessor", "alphaUpdateInfo expired");
            AppMethodBeat.o(276555);
            return;
          }
          if ((com.tencent.mm.plugin.y.d.eUZ() != null) && (com.tencent.mm.plugin.y.d.eUZ().aPB(str) != null)) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(284855);
                if (com.tencent.mm.plugin.y.d.eUZ() != null) {
                  com.tencent.mm.plugin.y.d.eUZ().hz(ac.4.this.val$context);
                }
                AppMethodBeat.o(284855);
              }
            });
          }
          AppMethodBeat.o(276555);
        }
      });
      AppMethodBeat.o(33451);
      return true;
    }
    AppMethodBeat.o(33451);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.ac
 * JD-Core Version:    0.7.0.1
 */