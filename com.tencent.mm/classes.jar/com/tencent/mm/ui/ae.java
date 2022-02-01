package com.tencent.mm.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.ny;
import com.tencent.mm.k.f;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.ah;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.platformtools.g;
import com.tencent.mm.pluginsdk.ui.tools.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.e;

public final class ae
{
  private static boolean adFk = false;
  static ProgressDialog lzP = null;
  static SecurityImage pRw = null;
  
  public static e a(Activity paramActivity, String paramString1, String paramString2, Intent paramIntent)
  {
    AppMethodBeat.i(33449);
    ny localny = new ny();
    localny.hQx.status = 0;
    localny.hQx.reason = 1;
    localny.publish();
    paramActivity = k.a(paramActivity, paramString1, paramActivity.getString(R.l.app_tip), new ae.1(paramString2, paramActivity, paramIntent), new ae.2(paramString2, paramActivity, paramIntent));
    AppMethodBeat.o(33449);
    return paramActivity;
  }
  
  public static void bS(Activity paramActivity)
  {
    AppMethodBeat.i(249694);
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        int k = 1;
        int j = 0;
        AppMethodBeat.i(249572);
        if (Util.safeParseInt(com.tencent.mm.k.i.aRC().getValue("SilentDownloadApkAtWiFi")) != 0)
        {
          AppMethodBeat.o(249572);
          return;
        }
        bh.bCz();
        int i;
        if ((((Integer)com.tencent.mm.model.c.ban().d(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
        {
          i = 1;
          if ((!NetStatusUtil.isWifi(ae.this)) || (i == 0)) {
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
          if ((i != 0) && (g.iJc())) {
            ae.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(249809);
                if (ae.bU(ae.this)) {
                  Log.d("MicroMsg.MMErrorProcessor", "we got an unfinished silence download");
                }
                AppMethodBeat.o(249809);
              }
            });
          }
          AppMethodBeat.o(249572);
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
    AppMethodBeat.o(249694);
  }
  
  private static boolean bT(Activity paramActivity)
  {
    AppMethodBeat.i(33453);
    b localb = b.iIn();
    if (localb != null)
    {
      localb.iIq();
      Log.i("MicroMsg.MMErrorProcessor", "alpha download in silence.");
      AppMethodBeat.o(33453);
      return true;
    }
    if (com.tencent.mm.plugin.y.d.gdL() != null)
    {
      com.tencent.mm.plugin.y.d.gdL().iT(paramActivity).update(2);
      AppMethodBeat.o(33453);
      return true;
    }
    AppMethodBeat.o(33453);
    return false;
  }
  
  public static boolean d(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33452);
    Log.w("MicroMsg.MMErrorProcessor", "updateRequired [%d,%d] current version:%d  channel:%d updateMode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(com.tencent.mm.protocal.d.Yxh), Integer.valueOf(ChannelUtil.channelId), Integer.valueOf(ChannelUtil.updateMode) });
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
      if (com.tencent.mm.plugin.y.d.gdL() != null)
      {
        paramActivity = com.tencent.mm.plugin.y.d.gdL().c(paramActivity, new ae.5(paramActivity));
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 36L, 1L, true);
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
    String str = com.tencent.mm.k.i.aRC().getValue("SilentDownloadApkAtWiFi");
    bh.bCz();
    if ((((Integer)com.tencent.mm.model.c.ban().d(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
    {
      paramInt1 = 1;
      if ((paramInt1 == 0) || ((!Util.isNullOrNil(str)) && (Util.safeParseInt(str) != 0))) {
        break label441;
      }
      bool = true;
      label325:
      if ((ChannelUtil.updateMode & 0x1) == 0) {
        break label447;
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
        break label464;
      }
      if (com.tencent.mm.plugin.y.d.gdL() == null) {
        break label457;
      }
      paramActivity = com.tencent.mm.plugin.y.d.gdL().c(paramActivity, new ae.6(paramActivity));
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 38L, 1L, true);
      paramActivity.update(2);
      AppMethodBeat.o(33452);
      return true;
      paramInt1 = 0;
      break;
      label441:
      bool = false;
      break label325;
      label447:
      Log.d("MicroMsg.MMErrorProcessor", "not channel pack.");
    }
    label457:
    AppMethodBeat.o(33452);
    return false;
    label464:
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 40L, 1L, true);
    boolean bool = bT(paramActivity);
    AppMethodBeat.o(33452);
    return bool;
  }
  
  public static boolean mT(final Context paramContext)
  {
    AppMethodBeat.i(33451);
    final String str = g.iIZ();
    int i = g.iJa();
    Log.i("MicroMsg.MMErrorProcessor", "installRequired %s, updateType: %d", new Object[] { str, Integer.valueOf(i) });
    if ((!Util.isNullOrNil(str)) && (!g.iJb()))
    {
      bh.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(249571);
          if ((this.adFm == 4) && (b.iIn() == null))
          {
            Log.w("MicroMsg.MMErrorProcessor", "alphaUpdateInfo expired");
            AppMethodBeat.o(249571);
            return;
          }
          if ((com.tencent.mm.plugin.y.d.gdL() != null) && (com.tencent.mm.plugin.y.d.gdL().aMz(str) != null)) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(249429);
                if (com.tencent.mm.plugin.y.d.gdL() != null) {
                  com.tencent.mm.plugin.y.d.gdL().iU(ae.4.this.val$context);
                }
                AppMethodBeat.o(249429);
              }
            });
          }
          AppMethodBeat.o(249571);
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
        if (((paramInt3 & 0x2) != 0) && (bh.aZW().bFR()))
        {
          bh.aZW().getNetworkServerIp();
          new StringBuilder().append(paramInt2);
        }
        for (;;)
        {
          AppMethodBeat.o(33447);
          return true;
          if ((((paramInt3 & 0x1) == 0) || (!ah.eb(paramContext)) || (!m.lE(paramContext))) && (((paramInt3 & 0x4) == 0) || (!NetStatusUtil.isWap(paramContext)) || (!MMAppMgr.mR(paramContext)))) {
            Toast.makeText(paramContext, paramContext.getString(R.l.fmt_http_err, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 1).show();
          }
        }
        Toast.makeText(paramContext, paramContext.getString(R.l.fmt_iap_err, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt2) }), 1).show();
        AppMethodBeat.o(33447);
        return true;
        AppMethodBeat.o(33447);
        return true;
        if (com.tencent.mm.plugin.account.ui.a.fb(paramInt1, paramInt2))
        {
          AppMethodBeat.o(33447);
          return true;
        }
        com.tencent.mm.broadcast.a locala = com.tencent.mm.broadcast.a.CH(paramString);
        if (locala != null)
        {
          Log.i("MicroMsg.MMErrorProcessor", "summertips errCode[%d], showType[%d], url[%s], desc[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(locala.hAN), locala.url, locala.desc });
          if (!Util.isNullOrNil(locala.url)) {}
          for (paramString = new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(33446);
                  paramAnonymousDialogInterface = new Intent();
                  StringBuilder localStringBuilder = new StringBuilder(ae.a.this.url);
                  localStringBuilder.append("&wechat_real_lang=" + LocaleUtil.getApplicationLanguage());
                  paramAnonymousDialogInterface.putExtra("rawUrl", localStringBuilder.toString());
                  paramAnonymousDialogInterface.putExtra("showShare", false);
                  paramAnonymousDialogInterface.putExtra("show_bottom", false);
                  paramAnonymousDialogInterface.putExtra("needRedirect", false);
                  paramAnonymousDialogInterface.putExtra("neverGetA8Key", true);
                  paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
                  paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.YxA);
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
 * Qualified Name:     com.tencent.mm.ui.ae
 * JD-Core Version:    0.7.0.1
 */