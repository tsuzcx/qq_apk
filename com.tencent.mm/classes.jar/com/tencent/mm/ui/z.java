package com.tencent.mm.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.model.bg;
import com.tencent.mm.n.f;
import com.tencent.mm.network.ag;
import com.tencent.mm.pluginsdk.i.g;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.ui.tools.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.applet.SecurityImage;

public final class z
{
  private static boolean OHu = false;
  static ProgressDialog gtM = null;
  static SecurityImage kdp = null;
  
  public static com.tencent.mm.ui.widget.a.d a(Activity paramActivity, String paramString1, String paramString2, Intent paramIntent)
  {
    AppMethodBeat.i(33449);
    ma localma = new ma();
    localma.dRA.status = 0;
    localma.dRA.bDZ = 1;
    EventCenter.instance.publish(localma);
    paramActivity = com.tencent.mm.ui.base.h.a(paramActivity, paramString1, paramActivity.getString(2131755998), new z.1(paramString2, paramActivity, paramIntent), new z.2(paramString2, paramActivity, paramIntent));
    AppMethodBeat.o(33449);
    return paramActivity;
  }
  
  public static void bi(Activity paramActivity)
  {
    AppMethodBeat.i(232643);
    com.tencent.f.h.RTc.b(new Runnable()
    {
      public final void run()
      {
        int k = 1;
        int j = 0;
        AppMethodBeat.i(232639);
        if (Util.safeParseInt(com.tencent.mm.n.h.aqJ().getValue("SilentDownloadApkAtWiFi")) != 0)
        {
          AppMethodBeat.o(232639);
          return;
        }
        bg.aVF();
        int i;
        if ((((Integer)com.tencent.mm.model.c.azQ().get(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
        {
          i = 1;
          if ((!NetStatusUtil.isWifi(this.dnO)) || (i == 0)) {
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
          if ((i != 0) && (g.gnw())) {
            this.dnO.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(232638);
                if (z.bk(z.3.this.dnO)) {
                  Log.d("MicroMsg.MMErrorProcessor", "we got an unfinished silence download");
                }
                AppMethodBeat.o(232638);
              }
            });
          }
          AppMethodBeat.o(232639);
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
    AppMethodBeat.o(232643);
  }
  
  private static boolean bj(Activity paramActivity)
  {
    AppMethodBeat.i(33453);
    b localb = b.gmM();
    if (localb != null)
    {
      localb.gmP();
      Log.i("MicroMsg.MMErrorProcessor", "alpha download in silence.");
      AppMethodBeat.o(33453);
      return true;
    }
    if (com.tencent.mm.plugin.p.d.elq() != null)
    {
      com.tencent.mm.plugin.p.d.elq().gB(paramActivity).update(2);
      AppMethodBeat.o(33453);
      return true;
    }
    AppMethodBeat.o(33453);
    return false;
  }
  
  public static boolean c(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33452);
    Log.w("MicroMsg.MMErrorProcessor", "updateRequired [%d,%d] current version:%d  channel:%d updateMode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(com.tencent.mm.protocal.d.KyO), Integer.valueOf(ChannelUtil.channelId), Integer.valueOf(ChannelUtil.updateMode) });
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
      if (com.tencent.mm.plugin.p.d.elq() != null)
      {
        paramActivity = com.tencent.mm.plugin.p.d.elq().d(paramActivity, new z.5(paramActivity));
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(405L, 36L, 1L, true);
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
    String str = com.tencent.mm.n.h.aqJ().getValue("SilentDownloadApkAtWiFi");
    bg.aVF();
    if ((((Integer)com.tencent.mm.model.c.azQ().get(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
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
      if (com.tencent.mm.plugin.p.d.elq() == null) {
        break label458;
      }
      paramActivity = com.tencent.mm.plugin.p.d.elq().d(paramActivity, new z.6(paramActivity));
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(405L, 38L, 1L, true);
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
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(405L, 40L, 1L, true);
    boolean bool = bj(paramActivity);
    AppMethodBeat.o(33452);
    return bool;
  }
  
  public static boolean jP(final Context paramContext)
  {
    AppMethodBeat.i(33451);
    final String str = g.gnt();
    int i = g.gnu();
    Log.i("MicroMsg.MMErrorProcessor", "installRequired %s, updateType: %d", new Object[] { str, Integer.valueOf(i) });
    if ((!Util.isNullOrNil(str)) && (!g.gnv()))
    {
      bg.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(232641);
          if ((this.OHw == 4) && (b.gmM() == null))
          {
            Log.w("MicroMsg.MMErrorProcessor", "alphaUpdateInfo expired");
            AppMethodBeat.o(232641);
            return;
          }
          if ((com.tencent.mm.plugin.p.d.elq() != null) && (com.tencent.mm.plugin.p.d.elq().aFr(str) != null)) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(232640);
                if (com.tencent.mm.plugin.p.d.elq() != null) {
                  com.tencent.mm.plugin.p.d.elq().gC(z.4.this.val$context);
                }
                AppMethodBeat.o(232640);
              }
            });
          }
          AppMethodBeat.o(232641);
        }
      });
      AppMethodBeat.o(33451);
      return true;
    }
    AppMethodBeat.o(33451);
    return false;
  }
  
  public static final class a
  {
    public static boolean a(final Context paramContext, int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      AppMethodBeat.i(33447);
      switch (paramInt1)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(33447);
        return false;
        if (((paramInt3 & 0x2) != 0) && (bg.azz().aYT()))
        {
          bg.azz().getNetworkServerIp();
          new StringBuilder().append(paramInt2);
        }
        for (;;)
        {
          AppMethodBeat.o(33447);
          return true;
          if ((((paramInt3 & 0x1) == 0) || (!ag.dm(paramContext)) || (!m.iC(paramContext))) && (((paramInt3 & 0x4) == 0) || (!NetStatusUtil.isWap(paramContext)) || (!MMAppMgr.jN(paramContext)))) {
            Toast.makeText(paramContext, paramContext.getString(2131760825, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 1).show();
          }
        }
        Toast.makeText(paramContext, paramContext.getString(2131760826, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt2) }), 1).show();
        AppMethodBeat.o(33447);
        return true;
        AppMethodBeat.o(33447);
        return true;
        if (com.tencent.mm.plugin.account.ui.a.dJ(paramInt1, paramInt2))
        {
          AppMethodBeat.o(33447);
          return true;
        }
        com.tencent.mm.h.a locala = com.tencent.mm.h.a.Dk(paramString);
        if (locala != null)
        {
          Log.i("MicroMsg.MMErrorProcessor", "summertips errCode[%d], showType[%d], url[%s], desc[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(locala.dDG), locala.url, locala.desc });
          if (!Util.isNullOrNil(locala.url)) {}
          for (paramString = new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(33446);
                  paramAnonymousDialogInterface = new Intent();
                  StringBuilder localStringBuilder = new StringBuilder(this.jNH.url);
                  localStringBuilder.append("&wechat_real_lang=" + LocaleUtil.getApplicationLanguage());
                  paramAnonymousDialogInterface.putExtra("rawUrl", localStringBuilder.toString());
                  paramAnonymousDialogInterface.putExtra("showShare", false);
                  paramAnonymousDialogInterface.putExtra("show_bottom", false);
                  paramAnonymousDialogInterface.putExtra("needRedirect", false);
                  paramAnonymousDialogInterface.putExtra("neverGetA8Key", true);
                  paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
                  paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
                  com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
                  AppMethodBeat.o(33446);
                }
              }; locala.a(paramContext, paramString, null); paramString = null)
          {
            AppMethodBeat.o(33447);
            return true;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.z
 * JD-Core Version:    0.7.0.1
 */