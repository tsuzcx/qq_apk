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
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.app.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.bd.n;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.d.i.a;
import com.tencent.mm.f.a.by;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.boots.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.o;
import com.tencent.mm.protocal.protobuf.ccg;
import com.tencent.mm.protocal.protobuf.cch;
import com.tencent.mm.protocal.protobuf.cee;
import com.tencent.mm.protocal.protobuf.dag;
import com.tencent.mm.protocal.protobuf.dhh;
import com.tencent.mm.protocal.protobuf.dhk;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.base.s;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class Updater
  extends LinearLayout
  implements com.tencent.mm.an.i, com.tencent.mm.plugin.y.a
{
  private int URN;
  private s USV = null;
  private boolean USW = false;
  private boolean USX = false;
  private boolean USY = false;
  private com.tencent.mm.an.i USZ;
  private com.tencent.mm.an.i UTa;
  private boolean fxt;
  
  private Updater(Context paramContext)
  {
    super(paramContext);
  }
  
  public Updater(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static void arR(int paramInt)
  {
    AppMethodBeat.i(32762);
    if (!bh.aHB())
    {
      AppMethodBeat.o(32762);
      return;
    }
    Log.d("MicroMsg.Updater", "reportUpdateStat : opCode = ".concat(String.valueOf(paramInt)));
    bh.beI();
    com.tencent.mm.model.c.bbK().d(new n(paramInt));
    AppMethodBeat.o(32762);
  }
  
  private void cancel()
  {
    AppMethodBeat.i(32757);
    bh.aGY().b(11, this);
    AppMethodBeat.o(32757);
  }
  
  public static Updater d(Context paramContext, final DialogInterface.OnCancelListener paramOnCancelListener)
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
    Updater localUpdater = (Updater)View.inflate(paramContext, R.i.elF, null);
    localUpdater.onStart();
    paramContext = s.a(paramContext, paramContext.getString(R.l.update_getting_updateinfo), true);
    paramContext.setCancelable(true);
    paramContext.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(32744);
        bh.getNotification().cancel(99);
        h.IzE.idkeyStat(405L, 47L, 1L, true);
        Updater.arR(2);
        this.UTb.onStop();
        if ((!Updater.a(this.UTb)) && (paramOnCancelListener != null)) {
          paramOnCancelListener.onCancel(paramAnonymousDialogInterface);
        }
        AppMethodBeat.o(32744);
      }
    });
    try
    {
      localUpdater.USV = paramContext;
      localUpdater.USV.show();
      localUpdater.fxt = true;
      h.IzE.idkeyStat(405L, 46L, 1L, true);
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
  
  public static Updater e(Context paramContext, final DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(32752);
    MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", Util.nowSecond()).commit();
    bh.getNotification().cancel(34);
    Log.i("MicroMsg.Updater", "show update dialog");
    Updater localUpdater = (Updater)View.inflate(paramContext, R.i.elF, null);
    localUpdater.onStart();
    paramContext = s.a(paramContext, "", true);
    paramContext.setCancelable(true);
    paramContext.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(32745);
        bh.getNotification().cancel(99);
        h.IzE.idkeyStat(405L, 49L, 1L, true);
        Updater.arR(2);
        this.UTb.onStop();
        if ((!Updater.a(this.UTb)) && (paramOnCancelListener != null)) {
          paramOnCancelListener.onCancel(paramAnonymousDialogInterface);
        }
        AppMethodBeat.o(32745);
      }
    });
    h.IzE.idkeyStat(405L, 48L, 1L, true);
    localUpdater.USV = paramContext;
    localUpdater.fxt = false;
    AppMethodBeat.o(32752);
    return localUpdater;
  }
  
  private String[] getShortIps()
  {
    int i = 0;
    AppMethodBeat.i(32758);
    if ((ac.mFt != null) && (ac.mFt.length() > 0))
    {
      localObject = ac.mFt;
      AppMethodBeat.o(32758);
      return new String[] { localObject };
    }
    Object localObject = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).getString("builtin_short_ips", "");
    if ((localObject != null) && (((String)localObject).length() > 0)) {}
    String[] arrayOfString;
    for (;;)
    {
      localObject = o.bsv((String)localObject);
      arrayOfString = new String[((List)localObject).size()];
      while (i < ((List)localObject).size())
      {
        arrayOfString[i] = ((o)((List)localObject).get(i)).Ejj;
        i += 1;
      }
      localObject = "0,112.64.200.240,80|0,180.153.82.27,80|0,117.135.130.177,80";
    }
    AppMethodBeat.o(32758);
    return arrayOfString;
  }
  
  public static void hz(Context paramContext)
  {
    AppMethodBeat.i(32754);
    Object localObject = new Intent(paramContext, AppInstallerUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/sandbox/updater/Updater", "goInstall", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/sandbox/updater/Updater", "goInstall", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(32754);
  }
  
  public static void k(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(32761);
    Intent localIntent = new Intent(MMApplicationContext.getContext(), UpdaterService.class);
    localIntent.putExtra("intent_client_version", com.tencent.mm.protocal.d.RAD);
    localIntent.putExtra("intent_update_type", 4);
    localIntent.putExtra("intent_extra_desc", paramString2);
    localIntent.putExtra("intent_extra_md5", paramString1);
    localIntent.putExtra("intent_extra_size", paramInt);
    localIntent.putExtra("intent_extra_download_url", new String[] { paramString3 });
    localIntent.putExtra("intent_extra_updateMode", ChannelUtil.updateMode);
    localIntent.putExtra("intent_extra_marketUrl", ChannelUtil.marketURL);
    localIntent.putExtra("intent_extra_run_in_foreground", true);
    localIntent.putExtra("intent_extra_download_mode", 2);
    h.IzE.idkeyStat(405L, 45L, 1L, true);
    com.tencent.mm.by.c.l(localIntent, "sandbox");
    AppMethodBeat.o(32761);
  }
  
  public static Updater kx(Context paramContext)
  {
    AppMethodBeat.i(32753);
    MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", Util.nowSecond()).commit();
    bh.getNotification().cancel(34);
    h.IzE.idkeyStat(405L, 50L, 1L, true);
    Log.i("MicroMsg.Updater", "updater silence");
    paramContext = new Updater(paramContext);
    paramContext.onStart();
    paramContext.USX = true;
    AppMethodBeat.o(32753);
    return paramContext;
  }
  
  private void onStart()
  {
    AppMethodBeat.i(32749);
    bh.aGY().a(11, this);
    h.IzE.idkeyStat(405L, 42L, 1L, true);
    AppMethodBeat.o(32749);
  }
  
  public final void a(Intent paramIntent, f paramf)
  {
    AppMethodBeat.i(32756);
    paramIntent.putExtra("intent_short_ips", getShortIps());
    paramIntent.putExtra("intent_client_version", com.tencent.mm.protocal.d.RAD);
    paramIntent.putExtra("intent_update_type", 3);
    int i;
    if ((paramf.DNw != null) && (!paramf.DNw.isEmpty()) && (paramf.DNw.containsKey(Integer.valueOf(4))))
    {
      i = 1;
      if (i == 0) {
        break label364;
      }
      localObject1 = paramf.DNw;
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
          paramIntent.putExtra("intent_extra_md5", paramf.smU);
          paramIntent.putExtra("intent_extra_size", paramf.fileSize);
          paramIntent.putExtra("intent_extra_download_url", new String[] { paramf.smT });
          paramIntent.putExtra("intent_extra_patchInfo", paramf.hsi());
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
    Object localObject1 = (dag)localLinkedList.get(i);
    if (((dag)localObject1).lang.equalsIgnoreCase("default")) {}
    for (localObject1 = new String(Base64.decode(((dag)localObject1).content, 0));; localObject1 = localObject2)
    {
      i += 1;
      localObject2 = localObject1;
      break label265;
      if (((dag)localObject1).lang.equalsIgnoreCase(LocaleUtil.getApplicationLanguage()))
      {
        localObject1 = new String(Base64.decode(((dag)localObject1).content, 0));
        break;
        label364:
        localObject1 = "";
        break;
      }
    }
  }
  
  public final void bO(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(32760);
    Log.i("MicroMsg.Updater", "summerupdate begin update routine, type=".concat(String.valueOf(paramInt)));
    this.URN = paramInt;
    this.USY = paramBoolean;
    h.IzE.idkeyStat(405L, 44L, 1L, true);
    com.tencent.mm.sandbox.a.a locala = new com.tencent.mm.sandbox.a.a(paramInt);
    bh.aGY().a(locala, 0);
    AppMethodBeat.o(32760);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(32755);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      h.IzE.idkeyStat(405L, 51L, 1L, true);
      Log.i("MicroMsg.Updater", "isShow " + this.fxt);
      if ((!this.fxt) && (this.USV != null)) {
        this.USV.show();
      }
      this.USW = true;
      if (this.USV != null) {
        this.USV.cancel();
      }
      paramString = (com.tencent.mm.sandbox.a.a)paramq;
      bh.aGY().a(new bv(new bv.a()
      {
        public final void a(final com.tencent.mm.network.g paramAnonymousg)
        {
          AppMethodBeat.i(32747);
          if (paramAnonymousg == null)
          {
            h.IzE.idkeyStat(405L, 52L, 1L, true);
            Assert.assertTrue("updater invalid assert", false);
          }
          bh.getNotification().cancel(34);
          Log.i("MicroMsg.Updater", "go to update, isSilenceDownload:%s", new Object[] { Boolean.valueOf(Updater.b(Updater.this)) });
          if (!com.tencent.mm.compatible.util.g.avJ().equals("mounted"))
          {
            Log.e("MicroMsg.Updater", "no sdcard.");
            h.IzE.idkeyStat(405L, 53L, 1L, true);
            Updater.c(Updater.this);
          }
          int i = paramString.hrQ();
          Object localObject2 = com.tencent.mm.d.i.gB(paramString.hrS());
          Object localObject3 = com.tencent.mm.pluginsdk.j.g.jz(Updater.this.getContext());
          Object localObject1 = null;
          if (localObject2 != null) {
            localObject1 = ((com.tencent.mm.d.i)localObject2).gA((String)localObject3);
          }
          if (localObject1 == null) {}
          for (long l = i;; l = ((i.a)localObject1).size + i)
          {
            if (!e.EY(l))
            {
              Log.e("MicroMsg.Updater", "no enough space.");
              h.IzE.idkeyStat(405L, 54L, 1L, true);
              Updater.c(Updater.this);
            }
            if ((ChannelUtil.updateMode & 0x1) != 0)
            {
              Log.i("MicroMsg.Updater", "channel pack, not silence download.");
              h.IzE.idkeyStat(405L, 55L, 1L, true);
              Updater.c(Updater.this);
            }
            if ((Updater.d(Updater.this) != 2) || (Updater.e(Updater.this))) {
              break;
            }
            localObject1 = j.hhZ();
            if ((com.tencent.mm.sandbox.monitor.c.aPB(paramString.hrR()) == null) || (Util.isNullOrNil((String)localObject1)) || (!((String)localObject1).equals(paramString.hrR()))) {
              break;
            }
            Log.i("MicroMsg.Updater", "we already have this pack %s being to install, just ignore this update request", new Object[] { localObject1 });
            h.IzE.idkeyStat(405L, 56L, 1L, true);
            AppMethodBeat.o(32747);
            return;
          }
          localObject1 = paramString.eUW();
          if ((localObject1 != null) && (((cee)localObject1).TlR != 0) && (!Util.isNullOrNil(((cee)localObject1).TlS)))
          {
            localObject2 = ((cee)localObject1).TlS;
            paramAnonymousg = Updater.this.getContext();
            localObject1 = paramAnonymousg.getString(b.a.app_recommend_update_alpha);
            localObject3 = new Intent("android.intent.action.VIEW");
            ((Intent)localObject3).setClassName(MMApplicationContext.getPackageName(), MMApplicationContext.getSourcePackageName() + ".plugin.webview.ui.tools.WebViewUI");
            ((Intent)localObject3).putExtra("rawUrl", (String)localObject2);
            ((Intent)localObject3).putExtra("showShare", false);
            ((Intent)localObject3).putExtra("show_bottom", false);
            ((Intent)localObject3).setFlags(872415232);
            localObject2 = PendingIntent.getActivity(Updater.this.getContext(), 0, (Intent)localObject3, 268435456);
            localObject1 = com.tencent.mm.bx.a.cp(Updater.this.getContext(), "reminder_channel_id").n(null).e(System.currentTimeMillis()).k((CharSequence)localObject1).l("");
            ((e.d)localObject1).Ip = ((PendingIntent)localObject2);
            ((e.d)localObject1).bn(com.tencent.mm.bx.a.fkG());
            localObject1 = ((e.d)localObject1).gr();
            ((Notification)localObject1).flags |= 0x10;
            ((NotificationManager)paramAnonymousg.getSystemService("notification")).notify(99, (Notification)localObject1);
            j.hsp();
            h.IzE.idkeyStat(405L, 57L, 1L, true);
            AppMethodBeat.o(32747);
            return;
          }
          if (Updater.b(Updater.this))
          {
            Log.i("MicroMsg.Updater", "summerupdate gonna start UpdaterService checkcontrol");
            h.IzE.idkeyStat(405L, 58L, 1L, true);
            bh.aGY().a(725, Updater.a(Updater.this, new com.tencent.mm.an.i()
            {
              public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, q paramAnonymous2q)
              {
                AppMethodBeat.i(32746);
                bh.aGY().b(221, Updater.f(Updater.this));
                Updater.a(Updater.this, null);
                if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
                {
                  paramAnonymous2String = (r)paramAnonymous2q;
                  String str;
                  if (((ccg)d.b.b(paramAnonymous2String.lvf.lBR)).rWu == 0)
                  {
                    paramAnonymous2String = ((cch)d.c.b(paramAnonymous2String.lvf.lBS)).lpy;
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
                    h.IzE.idkeyStat(405L, 0L, 1L, true);
                    AppMethodBeat.o(32746);
                    return;
                  }
                }
                Log.i("MicroMsg.Updater", "summerupdate gonna start UpdaterService after checkcontrol");
                h.IzE.idkeyStat(405L, 59L, 1L, true);
                paramAnonymous2String = new Intent(Updater.this.getContext(), UpdaterService.class);
                Updater.a(Updater.this, paramAnonymous2String, paramAnonymousg, Updater.3.this.UTd);
                paramAnonymous2String.putExtra("intent_extra_run_in_foreground", true);
                paramAnonymous2String.putExtra("intent_extra_download_mode", 2);
                com.tencent.mm.by.c.l(paramAnonymous2String, "sandbox");
                AppMethodBeat.o(32746);
              }
            }));
            bh.aGY().a(new r(), 0);
            if (Updater.d(Updater.this) != 3) {
              com.tencent.mm.aa.c.aFn().C(262145, true);
            }
            b.hho();
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
            h.IzE.idkeyStat(405L, 60L, 1L, true);
          }
          for (;;)
          {
            paramAnonymousg = Updater.this.getContext();
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousg, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/sandbox/updater/Updater$3", "onSceneEnd", "(Lcom/tencent/mm/network/IDispatcher;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousg.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousg, "com/tencent/mm/sandbox/updater/Updater$3", "onSceneEnd", "(Lcom/tencent/mm/network/IDispatcher;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
            h.IzE.idkeyStat(405L, 61L, 1L, true);
            ((Intent)localObject1).putExtra("intent_extra_download_mode", 1);
          }
        }
      }), 0);
      onStop();
      AppMethodBeat.o(32755);
      return;
    }
    h.IzE.idkeyStat(405L, 62L, 1L, true);
    if (this.USV != null)
    {
      paramString = this.USV;
      if (paramString.ros != null) {
        paramString.ros.setVisibility(8);
      }
      paramString = (TextView)this.USV.findViewById(R.h.mm_progress_dialog_msg);
      if ((paramInt1 != 4) || (paramInt2 != -18)) {
        break label262;
      }
      paramq = new by();
      EventCenter.instance.publish(paramq);
      paramq = bh.aGY();
      paramString = new com.tencent.mm.an.i()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(32748);
          bh.aGY().b(3899, Updater.g(Updater.this));
          Updater.a(Updater.this, null);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousq = ((dhh)d.c.b(((com.tencent.mm.an.d)paramAnonymousq.getReqResp()).lBS)).TOs;
            paramAnonymousString = new f(paramAnonymousq);
            if ((paramAnonymousq != null) && (paramAnonymousq.TOx == 3))
            {
              paramAnonymousq = new Intent(Updater.this.getContext(), AppUpdaterUI.class);
              if (f.aLR(paramAnonymousString.clientVersion)) {
                if (Util.isNullOrNil(paramAnonymousString.DNB))
                {
                  paramAnonymousString = "http://" + WeChatHosts.domainString(R.l.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";
                  paramAnonymousq = new Intent("android.intent.action.VIEW");
                  paramAnonymousq.setClassName(Updater.this.getContext().getPackageName(), MMApplicationContext.getSourcePackageName() + ".plugin.webview.ui.tools.WebViewUI");
                  paramAnonymousq.putExtra("rawUrl", paramAnonymousString);
                  paramAnonymousq.putExtra("useJs", true);
                  paramAnonymousq.putExtra("vertical_scroll", true);
                  paramAnonymousq.setFlags(872415232);
                  paramAnonymousString = Updater.this.getContext();
                  paramAnonymousq = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousq);
                  com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousString, paramAnonymousq.aFh(), "com/tencent/mm/sandbox/updater/Updater$4", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousString.startActivity((Intent)paramAnonymousq.sf(0));
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
                paramAnonymousString = paramAnonymousString.DNB;
                break;
                Updater.this.a(paramAnonymousq, paramAnonymousString);
                paramAnonymousString = Updater.this.getContext();
                paramAnonymousq = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousq);
                com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousString, paramAnonymousq.aFh(), "com/tencent/mm/sandbox/updater/Updater$4", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousString.startActivity((Intent)paramAnonymousq.sf(0));
                com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousString, "com/tencent/mm/sandbox/updater/Updater$4", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
            }
            if (Updater.h(Updater.this).findViewById(R.h.mm_progress_dialog_icon) != null) {
              Updater.h(Updater.this).findViewById(R.h.mm_progress_dialog_icon).setVisibility(8);
            }
            if (paramString != null)
            {
              h.IzE.idkeyStat(405L, 63L, 1L, true);
              paramString.setText(R.l.update_noupdate);
            }
            AppMethodBeat.o(32748);
            return;
          }
          if (Updater.h(Updater.this).findViewById(R.h.mm_progress_dialog_icon) != null) {
            Updater.h(Updater.this).findViewById(R.h.mm_progress_dialog_icon).setVisibility(8);
          }
          if (paramString != null)
          {
            h.IzE.idkeyStat(405L, 63L, 1L, true);
            paramString.setText(R.l.update_noupdate);
          }
          AppMethodBeat.o(32748);
        }
      };
      this.UTa = paramString;
      paramq.a(3899, paramString);
    }
    for (;;)
    {
      j.hst();
      cancel();
      AppMethodBeat.o(32755);
      return;
      label262:
      if (paramString != null)
      {
        h.IzE.idkeyStat(405L, 64L, 1L, true);
        paramString.setText(R.l.update_err_getinfo);
        l.q(paramString, 1);
      }
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(32750);
    h.IzE.idkeyStat(405L, 43L, 1L, true);
    cancel();
    AppMethodBeat.o(32750);
  }
  
  public final void update(int paramInt)
  {
    AppMethodBeat.i(32759);
    bO(paramInt, false);
    AppMethodBeat.o(32759);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.Updater
 * JD-Core Version:    0.7.0.1
 */