package com.tencent.mm.sandbox.updater;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.s.c;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.t;
import com.tencent.mm.ba.n;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.d.i.a;
import com.tencent.mm.g.a.bt;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.bu.a;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.o;
import com.tencent.mm.protocal.protobuf.buo;
import com.tencent.mm.protocal.protobuf.bup;
import com.tencent.mm.protocal.protobuf.bwo;
import com.tencent.mm.protocal.protobuf.crl;
import com.tencent.mm.protocal.protobuf.cxw;
import com.tencent.mm.protocal.protobuf.cxz;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class Updater
  extends LinearLayout
  implements com.tencent.mm.ak.i, com.tencent.mm.plugin.p.a
{
  private int NEo;
  private com.tencent.mm.ak.i NFA;
  private com.tencent.mm.ui.base.q NFv = null;
  private boolean NFw = false;
  private boolean NFx = false;
  private boolean NFy = false;
  private com.tencent.mm.ak.i NFz;
  private boolean dEF;
  
  private Updater(Context paramContext)
  {
    super(paramContext);
  }
  
  public Updater(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static void ajz(int paramInt)
  {
    AppMethodBeat.i(32762);
    if (!bg.aAc())
    {
      AppMethodBeat.o(32762);
      return;
    }
    Log.d("MicroMsg.Updater", "reportUpdateStat : opCode = ".concat(String.valueOf(paramInt)));
    bg.aVF();
    com.tencent.mm.model.c.aSM().d(new n(paramInt));
    AppMethodBeat.o(32762);
  }
  
  private void cancel()
  {
    AppMethodBeat.i(32757);
    bg.azz().b(11, this);
    AppMethodBeat.o(32757);
  }
  
  public static Updater e(Context paramContext, final DialogInterface.OnCancelListener paramOnCancelListener)
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
    bg.getNotification().cancel(34);
    Log.i("MicroMsg.Updater", "showWithProgress");
    Updater localUpdater = (Updater)View.inflate(paramContext, 2131496777, null);
    localUpdater.onStart();
    paramContext = com.tencent.mm.ui.base.q.a(paramContext, paramContext.getString(2131766921), true);
    paramContext.setCancelable(true);
    paramContext.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(32744);
        bg.getNotification().cancel(99);
        h.CyF.idkeyStat(405L, 47L, 1L, true);
        Updater.ajz(2);
        this.NFB.onStop();
        if ((!Updater.a(this.NFB)) && (paramOnCancelListener != null)) {
          paramOnCancelListener.onCancel(paramAnonymousDialogInterface);
        }
        AppMethodBeat.o(32744);
      }
    });
    try
    {
      localUpdater.NFv = paramContext;
      localUpdater.NFv.show();
      localUpdater.dEF = true;
      h.CyF.idkeyStat(405L, 46L, 1L, true);
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
  
  public static Updater f(Context paramContext, final DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(32752);
    MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", Util.nowSecond()).commit();
    bg.getNotification().cancel(34);
    Log.i("MicroMsg.Updater", "show update dialog");
    Updater localUpdater = (Updater)View.inflate(paramContext, 2131496777, null);
    localUpdater.onStart();
    paramContext = com.tencent.mm.ui.base.q.a(paramContext, "", true);
    paramContext.setCancelable(true);
    paramContext.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(32745);
        bg.getNotification().cancel(99);
        h.CyF.idkeyStat(405L, 49L, 1L, true);
        Updater.ajz(2);
        this.NFB.onStop();
        if ((!Updater.a(this.NFB)) && (paramOnCancelListener != null)) {
          paramOnCancelListener.onCancel(paramAnonymousDialogInterface);
        }
        AppMethodBeat.o(32745);
      }
    });
    h.CyF.idkeyStat(405L, 48L, 1L, true);
    localUpdater.NFv = paramContext;
    localUpdater.dEF = false;
    AppMethodBeat.o(32752);
    return localUpdater;
  }
  
  public static void gC(Context paramContext)
  {
    AppMethodBeat.i(32754);
    Object localObject = new Intent(paramContext, AppInstallerUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/sandbox/updater/Updater", "goInstall", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/sandbox/updater/Updater", "goInstall", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(32754);
  }
  
  private String[] getShortIps()
  {
    int i = 0;
    AppMethodBeat.i(32758);
    if ((ac.jOk != null) && (ac.jOk.length() > 0))
    {
      localObject = ac.jOk;
      AppMethodBeat.o(32758);
      return new String[] { localObject };
    }
    Object localObject = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).getString("builtin_short_ips", "");
    if ((localObject != null) && (((String)localObject).length() > 0)) {}
    String[] arrayOfString;
    for (;;)
    {
      localObject = o.bgd((String)localObject);
      arrayOfString = new String[((List)localObject).size()];
      while (i < ((List)localObject).size())
      {
        arrayOfString[i] = ((o)((List)localObject).get(i)).yFq;
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
    localIntent.putExtra("intent_client_version", com.tencent.mm.protocal.d.KyO);
    localIntent.putExtra("intent_update_type", 4);
    localIntent.putExtra("intent_extra_desc", paramString2);
    localIntent.putExtra("intent_extra_md5", paramString1);
    localIntent.putExtra("intent_extra_size", paramInt);
    localIntent.putExtra("intent_extra_download_url", new String[] { paramString3 });
    localIntent.putExtra("intent_extra_updateMode", ChannelUtil.updateMode);
    localIntent.putExtra("intent_extra_marketUrl", ChannelUtil.marketURL);
    localIntent.putExtra("intent_extra_run_in_foreground", true);
    localIntent.putExtra("intent_extra_download_mode", 2);
    h.CyF.idkeyStat(405L, 45L, 1L, true);
    com.tencent.mm.br.c.m(localIntent, "sandbox");
    AppMethodBeat.o(32761);
  }
  
  public static Updater jt(Context paramContext)
  {
    AppMethodBeat.i(32753);
    MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", Util.nowSecond()).commit();
    bg.getNotification().cancel(34);
    h.CyF.idkeyStat(405L, 50L, 1L, true);
    Log.i("MicroMsg.Updater", "updater silence");
    paramContext = new Updater(paramContext);
    paramContext.onStart();
    paramContext.NFx = true;
    AppMethodBeat.o(32753);
    return paramContext;
  }
  
  private void onStart()
  {
    AppMethodBeat.i(32749);
    bg.azz().a(11, this);
    h.CyF.idkeyStat(405L, 42L, 1L, true);
    AppMethodBeat.o(32749);
  }
  
  public final void a(Intent paramIntent, f paramf)
  {
    AppMethodBeat.i(32756);
    paramIntent.putExtra("intent_short_ips", getShortIps());
    paramIntent.putExtra("intent_client_version", com.tencent.mm.protocal.d.KyO);
    paramIntent.putExtra("intent_update_type", 3);
    int i;
    if ((paramf.ynu != null) && (!paramf.ynu.isEmpty()) && (paramf.ynu.containsKey(Integer.valueOf(4))))
    {
      i = 1;
      if (i == 0) {
        break label364;
      }
      localObject1 = paramf.ynu;
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
          paramIntent.putExtra("intent_extra_md5", paramf.pkL);
          paramIntent.putExtra("intent_extra_size", paramf.fileSize);
          paramIntent.putExtra("intent_extra_download_url", new String[] { paramf.pkK });
          paramIntent.putExtra("intent_extra_patchInfo", paramf.gwj());
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
    Object localObject1 = (crl)localLinkedList.get(i);
    if (((crl)localObject1).lang.equalsIgnoreCase("default")) {}
    for (localObject1 = new String(Base64.decode(((crl)localObject1).content, 0));; localObject1 = localObject2)
    {
      i += 1;
      localObject2 = localObject1;
      break label265;
      if (((crl)localObject1).lang.equalsIgnoreCase(LocaleUtil.getApplicationLanguage()))
      {
        localObject1 = new String(Base64.decode(((crl)localObject1).content, 0));
        break;
        label364:
        localObject1 = "";
        break;
      }
    }
  }
  
  public final void bB(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(32760);
    Log.i("MicroMsg.Updater", "summerupdate begin update routine, type=".concat(String.valueOf(paramInt)));
    this.NEo = paramInt;
    this.NFy = paramBoolean;
    h.CyF.idkeyStat(405L, 44L, 1L, true);
    com.tencent.mm.sandbox.a.a locala = new com.tencent.mm.sandbox.a.a(paramInt);
    bg.azz().a(locala, 0);
    AppMethodBeat.o(32760);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(32755);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      h.CyF.idkeyStat(405L, 51L, 1L, true);
      Log.i("MicroMsg.Updater", "isShow " + this.dEF);
      if ((!this.dEF) && (this.NFv != null)) {
        this.NFv.show();
      }
      this.NFw = true;
      if (this.NFv != null) {
        this.NFv.cancel();
      }
      paramString = (com.tencent.mm.sandbox.a.a)paramq;
      bg.azz().a(new bu(new bu.a()
      {
        public final void a(final com.tencent.mm.network.g paramAnonymousg)
        {
          AppMethodBeat.i(32747);
          if (paramAnonymousg == null)
          {
            h.CyF.idkeyStat(405L, 52L, 1L, true);
            Assert.assertTrue("updater invalid assert", false);
          }
          bg.getNotification().cancel(34);
          Log.i("MicroMsg.Updater", "go to update, isSilenceDownload:%s", new Object[] { Boolean.valueOf(Updater.b(Updater.this)) });
          if (!com.tencent.mm.compatible.util.g.getExternalStorageState().equals("mounted"))
          {
            Log.e("MicroMsg.Updater", "no sdcard.");
            h.CyF.idkeyStat(405L, 53L, 1L, true);
            Updater.c(Updater.this);
          }
          int i = paramString.gvS();
          Object localObject2 = com.tencent.mm.d.i.fR(paramString.gvU());
          Object localObject3 = com.tencent.mm.pluginsdk.i.g.iw(Updater.this.getContext());
          Object localObject1 = null;
          if (localObject2 != null) {
            localObject1 = ((com.tencent.mm.d.i)localObject2).fQ((String)localObject3);
          }
          if (localObject1 == null) {}
          for (long l = i;; l = ((i.a)localObject1).size + i)
          {
            if (!e.yV(l))
            {
              Log.e("MicroMsg.Updater", "no enough space.");
              h.CyF.idkeyStat(405L, 54L, 1L, true);
              Updater.c(Updater.this);
            }
            if ((ChannelUtil.updateMode & 0x1) != 0)
            {
              Log.i("MicroMsg.Updater", "channel pack, not silence download.");
              h.CyF.idkeyStat(405L, 55L, 1L, true);
              Updater.c(Updater.this);
            }
            if ((Updater.d(Updater.this) != 2) || (Updater.e(Updater.this))) {
              break;
            }
            localObject1 = j.gnt();
            if ((com.tencent.mm.sandbox.monitor.c.aFr(paramString.gvT()) == null) || (Util.isNullOrNil((String)localObject1)) || (!((String)localObject1).equals(paramString.gvT()))) {
              break;
            }
            Log.i("MicroMsg.Updater", "we already have this pack %s being to install, just ignore this update request", new Object[] { localObject1 });
            h.CyF.idkeyStat(405L, 56L, 1L, true);
            AppMethodBeat.o(32747);
            return;
          }
          localObject1 = paramString.eln();
          if ((localObject1 != null) && (((bwo)localObject1).Mcs != 0) && (!Util.isNullOrNil(((bwo)localObject1).Mct)))
          {
            localObject2 = ((bwo)localObject1).Mct;
            paramAnonymousg = Updater.this.getContext();
            localObject1 = paramAnonymousg.getString(2131755960);
            localObject3 = new Intent("android.intent.action.VIEW");
            ((Intent)localObject3).setClassName(MMApplicationContext.getPackageName(), MMApplicationContext.getSourcePackageName() + ".plugin.webview.ui.tools.WebViewUI");
            ((Intent)localObject3).putExtra("rawUrl", (String)localObject2);
            ((Intent)localObject3).putExtra("showShare", false);
            ((Intent)localObject3).putExtra("show_bottom", false);
            ((Intent)localObject3).setFlags(872415232);
            localObject2 = PendingIntent.getActivity(Updater.this.getContext(), 0, (Intent)localObject3, 268435456);
            localObject1 = com.tencent.mm.bq.a.cd(Updater.this.getContext(), "reminder_channel_id").i(null).i(System.currentTimeMillis()).f((CharSequence)localObject1).g("");
            ((s.c)localObject1).Hv = ((PendingIntent)localObject2);
            ((s.c)localObject1).as(com.tencent.mm.bq.a.ezb());
            localObject1 = ((s.c)localObject1).build();
            ((Notification)localObject1).flags |= 0x10;
            ((NotificationManager)paramAnonymousg.getSystemService("notification")).notify(99, (Notification)localObject1);
            j.gwq();
            h.CyF.idkeyStat(405L, 57L, 1L, true);
            AppMethodBeat.o(32747);
            return;
          }
          if (Updater.b(Updater.this))
          {
            Log.i("MicroMsg.Updater", "summerupdate gonna start UpdaterService checkcontrol");
            h.CyF.idkeyStat(405L, 58L, 1L, true);
            bg.azz().a(725, Updater.a(Updater.this, new com.tencent.mm.ak.i()
            {
              public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.ak.q paramAnonymous2q)
              {
                AppMethodBeat.i(32746);
                bg.azz().b(221, Updater.f(Updater.this));
                Updater.a(Updater.this, null);
                if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
                {
                  paramAnonymous2String = (r)paramAnonymous2q;
                  String str;
                  if (((buo)paramAnonymous2String.iFd.iLK.iLR).oUv == 0)
                  {
                    paramAnonymous2String = ((bup)paramAnonymous2String.iFd.iLL.iLR).iAc;
                    if (!Util.isNullOrNil(paramAnonymous2String))
                    {
                      paramAnonymous2String = XmlParser.parseXml(paramAnonymous2String, "resourcecontrolinfo", null);
                      if (paramAnonymous2String != null)
                      {
                        paramAnonymous2q = (String)paramAnonymous2String.get(".resourcecontrolinfo.enableupdate");
                        str = (String)paramAnonymous2String.get(".resourcecontrolinfo.expiredtime");
                        Log.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate getDisableUpdateTime values[%s]", new Object[] { paramAnonymous2String });
                        if (Util.getInt(paramAnonymous2q, 1) != 0) {}
                      }
                    }
                  }
                  for (long l1 = Util.getLong(str, 0L);; l1 = 0L)
                  {
                    long l2 = System.currentTimeMillis() / 1000L;
                    if (l1 <= l2) {
                      break;
                    }
                    Log.i("MicroMsg.Updater", "summerupdate checkcontrol time[%d] > now[%d] control not auto download and ret", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
                    h.CyF.idkeyStat(405L, 0L, 1L, true);
                    AppMethodBeat.o(32746);
                    return;
                  }
                }
                Log.i("MicroMsg.Updater", "summerupdate gonna start UpdaterService after checkcontrol");
                h.CyF.idkeyStat(405L, 59L, 1L, true);
                paramAnonymous2String = new Intent(Updater.this.getContext(), UpdaterService.class);
                Updater.a(Updater.this, paramAnonymous2String, paramAnonymousg, Updater.3.this.NFD);
                paramAnonymous2String.putExtra("intent_extra_run_in_foreground", true);
                paramAnonymous2String.putExtra("intent_extra_download_mode", 2);
                com.tencent.mm.br.c.m(paramAnonymous2String, "sandbox");
                AppMethodBeat.o(32746);
              }
            }));
            bg.azz().a(new r(), 0);
            if (Updater.d(Updater.this) != 3) {
              com.tencent.mm.y.c.axV().A(262145, true);
            }
            b.gmN();
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
            h.CyF.idkeyStat(405L, 60L, 1L, true);
          }
          for (;;)
          {
            paramAnonymousg = Updater.this.getContext();
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousg, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/sandbox/updater/Updater$3", "onSceneEnd", "(Lcom/tencent/mm/network/IDispatcher;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousg.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousg, "com/tencent/mm/sandbox/updater/Updater$3", "onSceneEnd", "(Lcom/tencent/mm/network/IDispatcher;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
            h.CyF.idkeyStat(405L, 61L, 1L, true);
            ((Intent)localObject1).putExtra("intent_extra_download_mode", 1);
          }
        }
      }), 0);
      onStop();
      AppMethodBeat.o(32755);
      return;
    }
    h.CyF.idkeyStat(405L, 62L, 1L, true);
    if (this.NFv != null)
    {
      paramString = this.NFv;
      if (paramString.olQ != null) {
        paramString.olQ.setVisibility(8);
      }
      paramString = (TextView)this.NFv.findViewById(2131304734);
      if ((paramInt1 != 4) || (paramInt2 != -18)) {
        break label262;
      }
      paramq = new bt();
      EventCenter.instance.publish(paramq);
      paramq = bg.azz();
      paramString = new com.tencent.mm.ak.i()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
        {
          AppMethodBeat.i(32748);
          bg.azz().b(3899, Updater.g(Updater.this));
          Updater.a(Updater.this, null);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousq = ((cxw)((com.tencent.mm.ak.d)paramAnonymousq.getReqResp()).iLL.iLR).MCM;
            paramAnonymousString = new f(paramAnonymousq);
            if ((paramAnonymousq != null) && (paramAnonymousq.MCR == 3))
            {
              paramAnonymousq = new Intent(Updater.this.getContext(), AppUpdaterUI.class);
              if (f.aBK(paramAnonymousString.clientVersion)) {
                if (Util.isNullOrNil(paramAnonymousString.ynz))
                {
                  paramAnonymousString = "http://" + WeChatHosts.domainString(2131761742) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";
                  paramAnonymousq = new Intent("android.intent.action.VIEW");
                  paramAnonymousq.setClassName(Updater.this.getContext().getPackageName(), MMApplicationContext.getSourcePackageName() + ".plugin.webview.ui.tools.WebViewUI");
                  paramAnonymousq.putExtra("rawUrl", paramAnonymousString);
                  paramAnonymousq.putExtra("useJs", true);
                  paramAnonymousq.putExtra("vertical_scroll", true);
                  paramAnonymousq.setFlags(872415232);
                  paramAnonymousString = Updater.this.getContext();
                  paramAnonymousq = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousq);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, paramAnonymousq.axQ(), "com/tencent/mm/sandbox/updater/Updater$4", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousString.startActivity((Intent)paramAnonymousq.pG(0));
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/sandbox/updater/Updater$4", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
                paramAnonymousString = paramAnonymousString.ynz;
                break;
                Updater.this.a(paramAnonymousq, paramAnonymousString);
                paramAnonymousString = Updater.this.getContext();
                paramAnonymousq = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousq);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, paramAnonymousq.axQ(), "com/tencent/mm/sandbox/updater/Updater$4", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousString.startActivity((Intent)paramAnonymousq.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/sandbox/updater/Updater$4", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
            }
            if (Updater.h(Updater.this).findViewById(2131304733) != null) {
              Updater.h(Updater.this).findViewById(2131304733).setVisibility(8);
            }
            if (paramString != null)
            {
              h.CyF.idkeyStat(405L, 63L, 1L, true);
              paramString.setText(2131766926);
            }
            AppMethodBeat.o(32748);
            return;
          }
          if (Updater.h(Updater.this).findViewById(2131304733) != null) {
            Updater.h(Updater.this).findViewById(2131304733).setVisibility(8);
          }
          if (paramString != null)
          {
            h.CyF.idkeyStat(405L, 63L, 1L, true);
            paramString.setText(2131766926);
          }
          AppMethodBeat.o(32748);
        }
      };
      this.NFA = paramString;
      paramq.a(3899, paramString);
    }
    for (;;)
    {
      j.gwu();
      cancel();
      AppMethodBeat.o(32755);
      return;
      label262:
      if (paramString != null)
      {
        h.CyF.idkeyStat(405L, 64L, 1L, true);
        paramString.setText(2131766916);
        l.p(paramString, 1);
      }
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(32750);
    h.CyF.idkeyStat(405L, 43L, 1L, true);
    cancel();
    AppMethodBeat.o(32750);
  }
  
  public final void update(int paramInt)
  {
    AppMethodBeat.i(32759);
    bB(paramInt, false);
    AppMethodBeat.o(32759);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.Updater
 * JD-Core Version:    0.7.0.1
 */