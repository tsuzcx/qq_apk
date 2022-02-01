package com.tencent.mm.sandbox.updater;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.app.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.c.c;
import com.tencent.mm.autogen.a.ch;
import com.tencent.mm.ay.n;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.d.h.a;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bw.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.boots.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.o;
import com.tencent.mm.protocal.protobuf.cug;
import com.tencent.mm.protocal.protobuf.dro;
import com.tencent.mm.protocal.protobuf.dzq;
import com.tencent.mm.protocal.protobuf.dzt;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.base.w;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class Updater
  extends LinearLayout
  implements com.tencent.mm.am.h, com.tencent.mm.plugin.y.a
{
  private int acmZ;
  private w acog = null;
  private boolean acoh = false;
  private boolean acoi = false;
  private boolean acoj = false;
  private com.tencent.mm.am.h acok;
  private com.tencent.mm.am.h acol;
  private boolean hBY;
  
  private Updater(Context paramContext)
  {
    super(paramContext);
  }
  
  public Updater(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static void axW(int paramInt)
  {
    AppMethodBeat.i(32762);
    if (!bh.baz())
    {
      AppMethodBeat.o(32762);
      return;
    }
    Log.d("MicroMsg.Updater", "reportUpdateStat : opCode = ".concat(String.valueOf(paramInt)));
    bh.bCz();
    com.tencent.mm.model.c.bzz().d(new n(paramInt));
    AppMethodBeat.o(32762);
  }
  
  private void cancel()
  {
    AppMethodBeat.i(32757);
    bh.aZW().b(11, this);
    AppMethodBeat.o(32757);
  }
  
  public static Updater d(Context paramContext, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(32751);
    if (paramContext == null)
    {
      AppMethodBeat.o(32751);
      return null;
    }
    if (((paramContext instanceof Activity)) && ((((Activity)paramContext).isFinishing()) || (((Activity)paramContext).getWindow() == null)))
    {
      Log.e("MicroMsg.Updater", "showWithProgress, context isFinishing");
      AppMethodBeat.o(32751);
      return null;
    }
    MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", Util.nowSecond()).commit();
    bh.getNotification().cancel(34);
    Log.i("MicroMsg.Updater", "showWithProgress");
    Updater localUpdater = (Updater)View.inflate(paramContext, R.i.goJ, null);
    localUpdater.onStart();
    paramContext = w.a(paramContext, paramContext.getString(R.l.update_getting_updateinfo), true);
    paramContext.setCancelable(true);
    paramContext.setOnCancelListener(new Updater.1(localUpdater, paramOnCancelListener));
    try
    {
      localUpdater.acog = paramContext;
      localUpdater.acog.show();
      localUpdater.hBY = true;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 46L, 1L, true);
      AppMethodBeat.o(32751);
      return localUpdater;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.Updater", "exception in showWithProgress, ", new Object[] { paramContext.getMessage() });
      Log.printErrStackTrace("MicroMsg.Updater", paramContext, "", new Object[0]);
      AppMethodBeat.o(32751);
    }
    return null;
  }
  
  public static Updater e(Context paramContext, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(32752);
    MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", Util.nowSecond()).commit();
    bh.getNotification().cancel(34);
    Log.i("MicroMsg.Updater", "show update dialog");
    Updater localUpdater = (Updater)View.inflate(paramContext, R.i.goJ, null);
    localUpdater.onStart();
    paramContext = w.a(paramContext, "", true);
    paramContext.setCancelable(true);
    paramContext.setOnCancelListener(new Updater.2(localUpdater, paramOnCancelListener));
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 48L, 1L, true);
    localUpdater.acog = paramContext;
    localUpdater.hBY = false;
    AppMethodBeat.o(32752);
    return localUpdater;
  }
  
  private String[] getShortIps()
  {
    int i = 0;
    AppMethodBeat.i(32758);
    if ((z.pBU != null) && (z.pBU.length() > 0))
    {
      localObject = z.pBU;
      AppMethodBeat.o(32758);
      return new String[] { localObject };
    }
    Object localObject = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).getString("builtin_short_ips", "");
    if ((localObject != null) && (((String)localObject).length() > 0)) {}
    String[] arrayOfString;
    for (;;)
    {
      localObject = o.bsm((String)localObject);
      arrayOfString = new String[((List)localObject).size()];
      while (i < ((List)localObject).size())
      {
        arrayOfString[i] = ((o)((List)localObject).get(i)).KbS;
        i += 1;
      }
      localObject = "0,112.64.200.240,80|0,180.153.82.27,80|0,117.135.130.177,80";
    }
    AppMethodBeat.o(32758);
    return arrayOfString;
  }
  
  public static void h(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(32761);
    Intent localIntent = new Intent(MMApplicationContext.getContext(), UpdaterService.class);
    localIntent.putExtra("intent_client_version", d.Yxh);
    localIntent.putExtra("intent_update_type", 4);
    localIntent.putExtra("intent_extra_desc", paramString2);
    localIntent.putExtra("intent_extra_md5", paramString1);
    localIntent.putExtra("intent_extra_size", paramInt);
    localIntent.putExtra("intent_extra_download_url", new String[] { paramString3 });
    localIntent.putExtra("intent_extra_updateMode", ChannelUtil.updateMode);
    localIntent.putExtra("intent_extra_marketUrl", ChannelUtil.marketURL);
    localIntent.putExtra("intent_extra_run_in_foreground", true);
    localIntent.putExtra("intent_extra_download_mode", 2);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 45L, 1L, true);
    com.tencent.mm.br.c.n(localIntent, "sandbox");
    AppMethodBeat.o(32761);
  }
  
  public static void iU(Context paramContext)
  {
    AppMethodBeat.i(32754);
    Object localObject = new Intent(paramContext, AppInstallerUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/sandbox/updater/Updater", "goInstall", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/sandbox/updater/Updater", "goInstall", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(32754);
  }
  
  public static Updater mz(Context paramContext)
  {
    AppMethodBeat.i(32753);
    MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", Util.nowSecond()).commit();
    bh.getNotification().cancel(34);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 50L, 1L, true);
    Log.i("MicroMsg.Updater", "updater silence");
    paramContext = new Updater(paramContext);
    paramContext.onStart();
    paramContext.acoi = true;
    AppMethodBeat.o(32753);
    return paramContext;
  }
  
  private void onStart()
  {
    AppMethodBeat.i(32749);
    bh.aZW().a(11, this);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 42L, 1L, true);
    AppMethodBeat.o(32749);
  }
  
  public final void a(Intent paramIntent, f paramf)
  {
    AppMethodBeat.i(32756);
    paramIntent.putExtra("intent_short_ips", getShortIps());
    paramIntent.putExtra("intent_client_version", d.Yxh);
    paramIntent.putExtra("intent_update_type", 3);
    int i;
    if ((paramf.JEK != null) && (!paramf.JEK.isEmpty()) && (paramf.JEK.containsKey(Integer.valueOf(4))))
    {
      i = 1;
      if (i == 0) {
        break label364;
      }
      localObject1 = paramf.JEK;
      if ((localObject1 != null) && (!((HashMap)localObject1).isEmpty())) {
        break label216;
      }
      localObject1 = "";
    }
    label216:
    Object localObject2;
    LinkedList localLinkedList;
    int j;
    label265:
    do
    {
      do
      {
        do
        {
          paramIntent.putExtra("intent_extra_desc", (String)localObject1);
          paramIntent.putExtra("intent_extra_md5", paramf.vyS);
          paramIntent.putExtra("intent_extra_size", paramf.fileSize);
          paramIntent.putExtra("intent_extra_download_url", new String[] { paramf.mOI });
          paramIntent.putExtra("intent_extra_patchInfo", paramf.iSn());
          paramIntent.putExtra("intent_extra_updateMode", ChannelUtil.updateMode);
          paramIntent.putExtra("intent_extra_marketUrl", ChannelUtil.marketURL);
          paramIntent.putExtra("intent_extra_extinfo", "<extinfo></extinfo>");
          paramIntent.putExtra("intent_extra_tinker_patch", true);
          paramIntent.putExtra("intent_extra_download_mode", 1);
          AppMethodBeat.o(32756);
          return;
          i = 0;
          break;
          localObject2 = "";
          localLinkedList = (LinkedList)((HashMap)localObject1).get(Integer.valueOf(4));
          localObject1 = localObject2;
        } while (localLinkedList == null);
        localObject1 = localObject2;
      } while (localLinkedList.isEmpty());
      j = localLinkedList.size();
      i = 0;
      localObject1 = localObject2;
    } while (i >= j);
    Object localObject1 = (dro)localLinkedList.get(i);
    if (((dro)localObject1).lang.equalsIgnoreCase("default")) {}
    for (localObject1 = new String(Base64.decode(((dro)localObject1).content, 0));; localObject1 = localObject2)
    {
      i += 1;
      localObject2 = localObject1;
      break label265;
      if (((dro)localObject1).lang.equalsIgnoreCase(LocaleUtil.getApplicationLanguage()))
      {
        localObject1 = new String(Base64.decode(((dro)localObject1).content, 0));
        break;
        label364:
        localObject1 = "";
        break;
      }
    }
  }
  
  public final void cw(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(32760);
    Log.i("MicroMsg.Updater", "summerupdate begin update routine, type=".concat(String.valueOf(paramInt)));
    this.acmZ = paramInt;
    this.acoj = paramBoolean;
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 44L, 1L, true);
    com.tencent.mm.sandbox.a.a locala = new com.tencent.mm.sandbox.a.a(paramInt);
    bh.aZW().a(locala, 0);
    AppMethodBeat.o(32760);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(32755);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 51L, 1L, true);
      Log.i("MicroMsg.Updater", "isShow " + this.hBY);
      if ((!this.hBY) && (this.acog != null)) {
        this.acog.show();
      }
      this.acoh = true;
      if (this.acog != null) {
        this.acog.cancel();
      }
      paramString = (com.tencent.mm.sandbox.a.a)paramp;
      bh.aZW().a(new bw(new bw.a()
      {
        public final void b(com.tencent.mm.network.g paramAnonymousg)
        {
          AppMethodBeat.i(32747);
          if (paramAnonymousg == null)
          {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 52L, 1L, true);
            Assert.assertTrue("updater invalid assert", false);
          }
          bh.getNotification().cancel(34);
          Log.i("MicroMsg.Updater", "go to update, isSilenceDownload:%s", new Object[] { Boolean.valueOf(Updater.b(Updater.this)) });
          if (!com.tencent.mm.compatible.util.g.aQd().equals("mounted"))
          {
            Log.e("MicroMsg.Updater", "no sdcard.");
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 53L, 1L, true);
            Updater.c(Updater.this);
          }
          int i = paramString.iRW();
          Object localObject2 = com.tencent.mm.d.h.ib(paramString.iRY());
          Object localObject3 = com.tencent.mm.pluginsdk.platformtools.g.ju(Updater.this.getContext());
          Object localObject1 = null;
          if (localObject2 != null) {
            localObject1 = ((com.tencent.mm.d.h)localObject2).ia((String)localObject3);
          }
          if (localObject1 == null) {}
          for (long l = i;; l = ((h.a)localObject1).size + i)
          {
            if (!e.hq(l))
            {
              Log.e("MicroMsg.Updater", "no enough space.");
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 54L, 1L, true);
              Updater.c(Updater.this);
            }
            if ((ChannelUtil.updateMode & 0x1) != 0)
            {
              Log.i("MicroMsg.Updater", "channel pack, not silence download.");
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 55L, 1L, true);
              Updater.c(Updater.this);
            }
            if ((Updater.d(Updater.this) != 2) || (Updater.e(Updater.this))) {
              break;
            }
            localObject1 = i.iIZ();
            if ((com.tencent.mm.sandbox.monitor.c.aMz(paramString.iRX()) == null) || (Util.isNullOrNil((String)localObject1)) || (!((String)localObject1).equals(paramString.iRX()))) {
              break;
            }
            Log.i("MicroMsg.Updater", "we already have this pack %s being to install, just ignore this update request", new Object[] { localObject1 });
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 56L, 1L, true);
            AppMethodBeat.o(32747);
            return;
          }
          localObject1 = paramString.gdI();
          if ((localObject1 != null) && (((cug)localObject1).aazN != 0) && (!Util.isNullOrNil(((cug)localObject1).aazO)))
          {
            localObject2 = ((cug)localObject1).aazO;
            paramAnonymousg = Updater.this.getContext();
            localObject1 = paramAnonymousg.getString(b.a.app_recommend_update_alpha);
            localObject3 = new Intent("android.intent.action.VIEW");
            ((Intent)localObject3).setClassName(MMApplicationContext.getPackageName(), MMApplicationContext.getSourcePackageName() + ".plugin.webview.ui.tools.WebViewUI");
            ((Intent)localObject3).putExtra("rawUrl", (String)localObject2);
            ((Intent)localObject3).putExtra("showShare", false);
            ((Intent)localObject3).putExtra("show_bottom", false);
            ((Intent)localObject3).setFlags(872415232);
            localObject2 = PendingIntent.getActivity(Updater.this.getContext(), 0, (Intent)localObject3, 268435456);
            localObject1 = com.tencent.mm.bq.a.cA(Updater.this.getContext(), "reminder_channel_id").o(null).bt(System.currentTimeMillis()).l((CharSequence)localObject1).m("");
            ((f.d)localObject1).bor = ((PendingIntent)localObject2);
            ((f.d)localObject1).eb(com.tencent.mm.bq.a.guX());
            localObject1 = ((f.d)localObject1).DA();
            ((Notification)localObject1).flags |= 0x10;
            ((NotificationManager)paramAnonymousg.getSystemService("notification")).notify(99, (Notification)localObject1);
            i.iSu();
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 57L, 1L, true);
            AppMethodBeat.o(32747);
            return;
          }
          if (Updater.b(Updater.this))
          {
            Log.i("MicroMsg.Updater", "summerupdate gonna start UpdaterService checkcontrol");
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 58L, 1L, true);
            bh.aZW().a(725, Updater.a(Updater.this, new Updater.3.1(this, paramAnonymousg)));
            bh.aZW().a(new com.tencent.mm.modelsimple.s(), 0);
            if (Updater.d(Updater.this) != 3) {
              com.tencent.mm.aa.c.aYo().Q(262145, true);
            }
            b.iIo();
            AppMethodBeat.o(32747);
            return;
          }
          Log.i("MicroMsg.Updater", "gonna start AppUpdaterUI");
          localObject1 = new Intent(Updater.this.getContext(), AppUpdaterUI.class);
          Updater.a(Updater.this, (Intent)localObject1, paramAnonymousg, paramString);
          Log.i("MicroMsg.Updater", "current updateType : %s", new Object[] { Integer.valueOf(Updater.d(Updater.this)) });
          if (Updater.d(Updater.this) == 1)
          {
            ((Intent)localObject1).putExtra("intent_extra_download_mode", 0);
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 60L, 1L, true);
          }
          for (;;)
          {
            paramAnonymousg = Updater.this.getContext();
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousg, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/sandbox/updater/Updater$3", "onSceneEnd", "(Lcom/tencent/mm/network/IDispatcher;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousg.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousg, "com/tencent/mm/sandbox/updater/Updater$3", "onSceneEnd", "(Lcom/tencent/mm/network/IDispatcher;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 61L, 1L, true);
            ((Intent)localObject1).putExtra("intent_extra_download_mode", 1);
          }
        }
      }), 0);
      onStop();
      AppMethodBeat.o(32755);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 62L, 1L, true);
    if (this.acog != null)
    {
      paramString = this.acog;
      if (paramString.uyz != null) {
        paramString.uyz.setVisibility(8);
      }
      paramp = (TextView)this.acog.findViewById(R.h.mm_progress_dialog_msg);
      if ((paramInt1 != 4) || (paramInt2 != -18)) {
        break label258;
      }
      new ch().publish();
      paramString = bh.aZW();
      paramp = new com.tencent.mm.am.h()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(32748);
          bh.aZW().b(3899, Updater.g(Updater.this));
          Updater.a(Updater.this, null);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousp = ((dzq)c.c.b(((com.tencent.mm.am.c)paramAnonymousp.getReqResp()).otC)).abeO;
            paramAnonymousString = new f(paramAnonymousp);
            if ((paramAnonymousp != null) && (paramAnonymousp.abeT == 3))
            {
              paramAnonymousp = new Intent(Updater.this.getContext(), AppUpdaterUI.class);
              if (f.aIL(paramAnonymousString.clientVersion)) {
                if (Util.isNullOrNil(paramAnonymousString.JEP))
                {
                  paramAnonymousString = "http://" + WeChatHosts.domainString(R.l.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";
                  paramAnonymousp = new Intent("android.intent.action.VIEW");
                  paramAnonymousp.setClassName(Updater.this.getContext().getPackageName(), MMApplicationContext.getSourcePackageName() + ".plugin.webview.ui.tools.WebViewUI");
                  paramAnonymousp.putExtra("rawUrl", paramAnonymousString);
                  paramAnonymousp.putExtra("useJs", true);
                  paramAnonymousp.putExtra("vertical_scroll", true);
                  paramAnonymousp.setFlags(872415232);
                  paramAnonymousString = Updater.this.getContext();
                  paramAnonymousp = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousp);
                  com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousString, paramAnonymousp.aYi(), "com/tencent/mm/sandbox/updater/Updater$4", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousString.startActivity((Intent)paramAnonymousp.sb(0));
                  com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousString, "com/tencent/mm/sandbox/updater/Updater$4", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
              }
              for (;;)
              {
                if (Updater.h(Updater.this) != null) {
                  Updater.h(Updater.this).cancel();
                }
                Updater.this.onStop();
                AppMethodBeat.o(32748);
                return;
                paramAnonymousString = paramAnonymousString.JEP;
                break;
                Updater.this.a(paramAnonymousp, paramAnonymousString);
                paramAnonymousString = Updater.this.getContext();
                paramAnonymousp = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousp);
                com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousString, paramAnonymousp.aYi(), "com/tencent/mm/sandbox/updater/Updater$4", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousString.startActivity((Intent)paramAnonymousp.sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousString, "com/tencent/mm/sandbox/updater/Updater$4", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
            }
            if (Updater.h(Updater.this).findViewById(R.h.mm_progress_dialog_icon) != null) {
              Updater.h(Updater.this).findViewById(R.h.mm_progress_dialog_icon).setVisibility(8);
            }
            if (paramp != null)
            {
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 63L, 1L, true);
              paramp.setText(R.l.update_noupdate);
            }
            AppMethodBeat.o(32748);
            return;
          }
          if (Updater.h(Updater.this).findViewById(R.h.mm_progress_dialog_icon) != null) {
            Updater.h(Updater.this).findViewById(R.h.mm_progress_dialog_icon).setVisibility(8);
          }
          if (paramp != null)
          {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 63L, 1L, true);
            paramp.setText(R.l.update_noupdate);
          }
          AppMethodBeat.o(32748);
        }
      };
      this.acol = paramp;
      paramString.a(3899, paramp);
    }
    for (;;)
    {
      i.iSy();
      cancel();
      AppMethodBeat.o(32755);
      return;
      label258:
      if (paramp != null)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 64L, 1L, true);
        paramp.setText(R.l.update_err_getinfo);
        com.tencent.mm.pluginsdk.ui.span.p.t(paramp, 1);
      }
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(32750);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 43L, 1L, true);
    cancel();
    AppMethodBeat.o(32750);
  }
  
  public final void update(int paramInt)
  {
    AppMethodBeat.i(32759);
    cw(paramInt, false);
    AppMethodBeat.o(32759);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.Updater
 * JD-Core Version:    0.7.0.1
 */