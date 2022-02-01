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
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.d.i;
import com.tencent.mm.d.i.a;
import com.tencent.mm.g.a.br;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bo;
import com.tencent.mm.model.bo.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.o;
import com.tencent.mm.protocal.protobuf.bhx;
import com.tencent.mm.protocal.protobuf.bhy;
import com.tencent.mm.protocal.protobuf.bjn;
import com.tencent.mm.protocal.protobuf.cbp;
import com.tencent.mm.protocal.protobuf.cgv;
import com.tencent.mm.protocal.protobuf.cgy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.ui.base.p;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class Updater
  extends LinearLayout
  implements com.tencent.mm.al.f, com.tencent.mm.plugin.q.a
{
  private int HWJ;
  private p HXP = null;
  private boolean HXQ = false;
  private boolean HXR = false;
  private boolean HXS = false;
  private com.tencent.mm.al.f HXT;
  private com.tencent.mm.al.f HXU;
  private boolean dmo;
  
  private Updater(Context paramContext)
  {
    super(paramContext);
  }
  
  public Updater(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static void aae(int paramInt)
  {
    AppMethodBeat.i(32762);
    if (!ba.ajx())
    {
      AppMethodBeat.o(32762);
      return;
    }
    ad.d("MicroMsg.Updater", "reportUpdateStat : opCode = ".concat(String.valueOf(paramInt)));
    ba.aBQ();
    com.tencent.mm.model.c.azo().c(new com.tencent.mm.bb.n(paramInt));
    AppMethodBeat.o(32762);
  }
  
  private void cancel()
  {
    AppMethodBeat.i(32757);
    ba.aiU().b(11, this);
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
      ad.e("MicroMsg.Updater", "showWithProgress, context isFinishing");
      AppMethodBeat.o(32751);
      return null;
    }
    aj.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bt.aQJ()).commit();
    ba.getNotification().cancel(34);
    ad.i("MicroMsg.Updater", "showWithProgress");
    Updater localUpdater = (Updater)View.inflate(paramContext, 2131495815, null);
    localUpdater.onStart();
    paramContext = p.a(paramContext, paramContext.getString(2131764575), true);
    paramContext.setCancelable(true);
    paramContext.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(32744);
        ba.getNotification().cancel(99);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 47L, 1L, true);
        Updater.aae(2);
        this.HXV.onStop();
        if ((!Updater.a(this.HXV)) && (paramOnCancelListener != null)) {
          paramOnCancelListener.onCancel(paramAnonymousDialogInterface);
        }
        AppMethodBeat.o(32744);
      }
    });
    try
    {
      localUpdater.HXP = paramContext;
      localUpdater.HXP.show();
      localUpdater.dmo = true;
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 46L, 1L, true);
      AppMethodBeat.o(32751);
      return localUpdater;
    }
    catch (Exception paramContext)
    {
      ad.e("MicroMsg.Updater", "exception in showWithProgress, ", new Object[] { paramContext.getMessage() });
      ad.printErrStackTrace("MicroMsg.Updater", paramContext, "", new Object[0]);
      AppMethodBeat.o(32751);
    }
    return null;
  }
  
  public static Updater f(Context paramContext, final DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(32752);
    aj.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bt.aQJ()).commit();
    ba.getNotification().cancel(34);
    ad.i("MicroMsg.Updater", "show update dialog");
    Updater localUpdater = (Updater)View.inflate(paramContext, 2131495815, null);
    localUpdater.onStart();
    paramContext = p.a(paramContext, "", true);
    paramContext.setCancelable(true);
    paramContext.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(32745);
        ba.getNotification().cancel(99);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 49L, 1L, true);
        Updater.aae(2);
        this.HXV.onStop();
        if ((!Updater.a(this.HXV)) && (paramOnCancelListener != null)) {
          paramOnCancelListener.onCancel(paramAnonymousDialogInterface);
        }
        AppMethodBeat.o(32745);
      }
    });
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 48L, 1L, true);
    localUpdater.HXP = paramContext;
    localUpdater.dmo = false;
    AppMethodBeat.o(32752);
    return localUpdater;
  }
  
  public static void fR(Context paramContext)
  {
    AppMethodBeat.i(32754);
    Object localObject = new Intent(paramContext, AppInstallerUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/sandbox/updater/Updater", "goInstall", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/sandbox/updater/Updater", "goInstall", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(32754);
  }
  
  private String[] getShortIps()
  {
    int i = 0;
    AppMethodBeat.i(32758);
    if ((com.tencent.mm.platformtools.ac.iOw != null) && (com.tencent.mm.platformtools.ac.iOw.length() > 0))
    {
      localObject = com.tencent.mm.platformtools.ac.iOw;
      AppMethodBeat.o(32758);
      return new String[] { localObject };
    }
    Object localObject = aj.getContext().getSharedPreferences("system_config_prefs", 0).getString("builtin_short_ips", "");
    if ((localObject != null) && (((String)localObject).length() > 0)) {}
    String[] arrayOfString;
    for (;;)
    {
      localObject = o.aOd((String)localObject);
      arrayOfString = new String[((List)localObject).size()];
      while (i < ((List)localObject).size())
      {
        arrayOfString[i] = ((o)((List)localObject).get(i)).uZn;
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
    Intent localIntent = new Intent(aj.getContext(), UpdaterService.class);
    localIntent.putExtra("intent_client_version", com.tencent.mm.protocal.d.Fnj);
    localIntent.putExtra("intent_update_type", 4);
    localIntent.putExtra("intent_extra_desc", paramString2);
    localIntent.putExtra("intent_extra_md5", paramString1);
    localIntent.putExtra("intent_extra_size", paramInt);
    localIntent.putExtra("intent_extra_download_url", new String[] { paramString3 });
    localIntent.putExtra("intent_extra_updateMode", com.tencent.mm.sdk.platformtools.j.cSe);
    localIntent.putExtra("intent_extra_marketUrl", com.tencent.mm.sdk.platformtools.j.Icw);
    localIntent.putExtra("intent_extra_run_in_foreground", true);
    localIntent.putExtra("intent_extra_download_mode", 2);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 45L, 1L, true);
    com.tencent.mm.bs.d.l(localIntent, "sandbox");
    AppMethodBeat.o(32761);
  }
  
  public static Updater iu(Context paramContext)
  {
    AppMethodBeat.i(32753);
    aj.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bt.aQJ()).commit();
    ba.getNotification().cancel(34);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 50L, 1L, true);
    ad.i("MicroMsg.Updater", "updater silence");
    paramContext = new Updater(paramContext);
    paramContext.onStart();
    paramContext.HXR = true;
    AppMethodBeat.o(32753);
    return paramContext;
  }
  
  private void onStart()
  {
    AppMethodBeat.i(32749);
    ba.aiU().a(11, this);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 42L, 1L, true);
    AppMethodBeat.o(32749);
  }
  
  public final void a(Intent paramIntent, f paramf)
  {
    AppMethodBeat.i(32756);
    paramIntent.putExtra("intent_short_ips", getShortIps());
    paramIntent.putExtra("intent_client_version", com.tencent.mm.protocal.d.Fnj);
    paramIntent.putExtra("intent_update_type", 3);
    int i;
    if ((paramf.uJg != null) && (!paramf.uJg.isEmpty()) && (paramf.uJg.containsKey(Integer.valueOf(4))))
    {
      i = 1;
      if (i == 0) {
        break label364;
      }
      localObject1 = paramf.uJg;
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
          paramIntent.putExtra("intent_extra_md5", paramf.nUg);
          paramIntent.putExtra("intent_extra_size", paramf.fileSize);
          paramIntent.putExtra("intent_extra_download_url", new String[] { paramf.gHx });
          paramIntent.putExtra("intent_extra_patchInfo", paramf.fiE());
          paramIntent.putExtra("intent_extra_updateMode", com.tencent.mm.sdk.platformtools.j.cSe);
          paramIntent.putExtra("intent_extra_marketUrl", com.tencent.mm.sdk.platformtools.j.Icw);
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
    Object localObject1 = (cbp)localLinkedList.get(i);
    if (((cbp)localObject1).lang.equalsIgnoreCase("default")) {}
    for (localObject1 = new String(Base64.decode(((cbp)localObject1).content, 0));; localObject1 = localObject2)
    {
      i += 1;
      localObject2 = localObject1;
      break label265;
      if (((cbp)localObject1).lang.equalsIgnoreCase(com.tencent.mm.sdk.platformtools.ac.fks()))
      {
        localObject1 = new String(Base64.decode(((cbp)localObject1).content, 0));
        break;
        label364:
        localObject1 = "";
        break;
      }
    }
  }
  
  public final void bb(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(32760);
    ad.i("MicroMsg.Updater", "summerupdate begin update routine, type=".concat(String.valueOf(paramInt)));
    this.HWJ = paramInt;
    this.HXS = paramBoolean;
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 44L, 1L, true);
    com.tencent.mm.sandbox.a.a locala = new com.tencent.mm.sandbox.a.a(paramInt);
    ba.aiU().a(locala, 0);
    AppMethodBeat.o(32760);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(32755);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 51L, 1L, true);
      ad.i("MicroMsg.Updater", "isShow " + this.dmo);
      if ((!this.dmo) && (this.HXP != null)) {
        this.HXP.show();
      }
      this.HXQ = true;
      if (this.HXP != null) {
        this.HXP.cancel();
      }
      paramString = (com.tencent.mm.sandbox.a.a)paramn;
      ba.aiU().a(new bo(new bo.a()
      {
        public final void a(final com.tencent.mm.network.e paramAnonymouse)
        {
          AppMethodBeat.i(32747);
          if (paramAnonymouse == null)
          {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 52L, 1L, true);
            Assert.assertTrue("updater invalid assert", false);
          }
          ba.getNotification().cancel(34);
          ad.i("MicroMsg.Updater", "go to update, isSilenceDownload:%s", new Object[] { Boolean.valueOf(Updater.b(Updater.this)) });
          if (!com.tencent.mm.compatible.util.g.getExternalStorageState().equals("mounted"))
          {
            ad.e("MicroMsg.Updater", "no sdcard.");
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 53L, 1L, true);
            Updater.c(Updater.this);
          }
          int i = paramString.fin();
          Object localObject2 = i.eY(paramString.fip());
          Object localObject3 = com.tencent.mm.pluginsdk.i.j.hw(Updater.this.getContext());
          Object localObject1 = null;
          if (localObject2 != null) {
            localObject1 = ((i)localObject2).eX((String)localObject3);
          }
          if (localObject1 == null) {}
          for (long l = i;; l = ((i.a)localObject1).size + i)
          {
            if (!com.tencent.mm.compatible.util.e.qR(l))
            {
              ad.e("MicroMsg.Updater", "no enough space.");
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 54L, 1L, true);
              Updater.c(Updater.this);
            }
            if ((com.tencent.mm.sdk.platformtools.j.cSe & 0x1) != 0)
            {
              ad.i("MicroMsg.Updater", "channel pack, not silence download.");
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 55L, 1L, true);
              Updater.c(Updater.this);
            }
            if ((Updater.d(Updater.this) != 2) || (Updater.e(Updater.this))) {
              break;
            }
            localObject1 = j.fav();
            if ((com.tencent.mm.sandbox.monitor.c.aqS(paramString.fio()) == null) || (bt.isNullOrNil((String)localObject1)) || (!((String)localObject1).equals(paramString.fio()))) {
              break;
            }
            ad.i("MicroMsg.Updater", "we already have this pack %s being to install, just ignore this update request", new Object[] { localObject1 });
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 56L, 1L, true);
            AppMethodBeat.o(32747);
            return;
          }
          localObject1 = paramString.dov();
          if ((localObject1 != null) && (((bjn)localObject1).GEa != 0) && (!bt.isNullOrNil(((bjn)localObject1).GEb)))
          {
            localObject2 = ((bjn)localObject1).GEb;
            paramAnonymouse = Updater.this.getContext();
            localObject1 = paramAnonymouse.getString(2131755871);
            localObject3 = new Intent("android.intent.action.VIEW");
            ((Intent)localObject3).setClassName(aj.getPackageName(), aj.getPackageName() + ".plugin.webview.ui.tools.WebViewUI");
            ((Intent)localObject3).putExtra("rawUrl", (String)localObject2);
            ((Intent)localObject3).putExtra("showShare", false);
            ((Intent)localObject3).putExtra("show_bottom", false);
            ((Intent)localObject3).setFlags(872415232);
            localObject2 = PendingIntent.getActivity(Updater.this.getContext(), 0, (Intent)localObject3, 268435456);
            localObject1 = com.tencent.mm.br.a.bI(Updater.this.getContext(), "reminder_channel_id").i(null).i(System.currentTimeMillis()).f((CharSequence)localObject1).g("");
            ((s.c)localObject1).Hl = ((PendingIntent)localObject2);
            ((s.c)localObject1).as(com.tencent.mm.br.a.dwe());
            localObject1 = ((s.c)localObject1).build();
            ((Notification)localObject1).flags |= 0x10;
            ((NotificationManager)paramAnonymouse.getSystemService("notification")).notify(99, (Notification)localObject1);
            j.fiL();
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 57L, 1L, true);
            AppMethodBeat.o(32747);
            return;
          }
          if (Updater.b(Updater.this))
          {
            ad.i("MicroMsg.Updater", "summerupdate gonna start UpdaterService checkcontrol");
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 58L, 1L, true);
            ba.aiU().a(725, Updater.a(Updater.this, new com.tencent.mm.al.f()
            {
              public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.al.n paramAnonymous2n)
              {
                AppMethodBeat.i(32746);
                ba.aiU().b(221, Updater.f(Updater.this));
                Updater.a(Updater.this, null);
                if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
                {
                  paramAnonymous2String = (com.tencent.mm.modelsimple.q)paramAnonymous2n;
                  String str;
                  if (((bhx)paramAnonymous2String.hHx.hNK.hNQ).nEf == 0)
                  {
                    paramAnonymous2String = ((bhy)paramAnonymous2String.hHx.hNL.hNQ).hDa;
                    if (!bt.isNullOrNil(paramAnonymous2String))
                    {
                      paramAnonymous2String = bw.M(paramAnonymous2String, "resourcecontrolinfo");
                      if (paramAnonymous2String != null)
                      {
                        paramAnonymous2n = (String)paramAnonymous2String.get(".resourcecontrolinfo.enableupdate");
                        str = (String)paramAnonymous2String.get(".resourcecontrolinfo.expiredtime");
                        ad.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate getDisableUpdateTime values[%s]", new Object[] { paramAnonymous2String });
                        if (bt.getInt(paramAnonymous2n, 1) != 0) {}
                      }
                    }
                  }
                  for (long l1 = bt.getLong(str, 0L);; l1 = 0L)
                  {
                    long l2 = System.currentTimeMillis() / 1000L;
                    if (l1 <= l2) {
                      break;
                    }
                    ad.i("MicroMsg.Updater", "summerupdate checkcontrol time[%d] > now[%d] control not auto download and ret", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
                    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 0L, 1L, true);
                    AppMethodBeat.o(32746);
                    return;
                  }
                }
                ad.i("MicroMsg.Updater", "summerupdate gonna start UpdaterService after checkcontrol");
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 59L, 1L, true);
                paramAnonymous2String = new Intent(Updater.this.getContext(), UpdaterService.class);
                Updater.a(Updater.this, paramAnonymous2String, paramAnonymouse, Updater.3.this.HXX);
                paramAnonymous2String.putExtra("intent_extra_run_in_foreground", true);
                paramAnonymous2String.putExtra("intent_extra_download_mode", 2);
                com.tencent.mm.bs.d.l(paramAnonymous2String, "sandbox");
                AppMethodBeat.o(32746);
              }
            }));
            ba.aiU().a(new com.tencent.mm.modelsimple.q(), 0);
            com.tencent.mm.z.c.aht().w(262145, true);
            com.tencent.mm.pluginsdk.model.app.b.eZN();
            AppMethodBeat.o(32747);
            return;
          }
          ad.i("MicroMsg.Updater", "gonna start AppUpdaterUI");
          localObject1 = new Intent(Updater.this.getContext(), AppUpdaterUI.class);
          Updater.a(Updater.this, (Intent)localObject1, paramAnonymouse, paramString);
          ad.i("MicroMsg.Updater", "current updateType : %s", new Object[] { Integer.valueOf(Updater.d(Updater.this)) });
          if (Updater.d(Updater.this) == 1)
          {
            ((Intent)localObject1).putExtra("intent_extra_download_mode", 0);
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 60L, 1L, true);
          }
          for (;;)
          {
            paramAnonymouse = Updater.this.getContext();
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymouse, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/sandbox/updater/Updater$3", "onSceneEnd", "(Lcom/tencent/mm/network/IDispatcher;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymouse.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymouse, "com/tencent/mm/sandbox/updater/Updater$3", "onSceneEnd", "(Lcom/tencent/mm/network/IDispatcher;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 61L, 1L, true);
            ((Intent)localObject1).putExtra("intent_extra_download_mode", 1);
          }
        }
      }), 0);
      onStop();
      AppMethodBeat.o(32755);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 62L, 1L, true);
    if (this.HXP != null)
    {
      paramString = this.HXP;
      if (paramString.mTD != null) {
        paramString.mTD.setVisibility(8);
      }
      paramString = (TextView)this.HXP.findViewById(2131302339);
      if ((paramInt1 != 4) || (paramInt2 != -18)) {
        break label262;
      }
      paramn = new br();
      com.tencent.mm.sdk.b.a.IbL.l(paramn);
      paramn = ba.aiU();
      paramString = new com.tencent.mm.al.f()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
        {
          AppMethodBeat.i(32748);
          ba.aiU().b(3899, Updater.g(Updater.this));
          Updater.a(Updater.this, null);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousn = ((cgv)((com.tencent.mm.al.b)paramAnonymousn.getReqResp()).hNL.hNQ).Hao;
            paramAnonymousString = new f(paramAnonymousn);
            if ((paramAnonymousn != null) && (paramAnonymousn.Hat == 3))
            {
              paramAnonymousn = new Intent(Updater.this.getContext(), AppUpdaterUI.class);
              if (f.anp(paramAnonymousString.clientVersion)) {
                if (bt.isNullOrNil(paramAnonymousString.uJl))
                {
                  paramAnonymousString = "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";
                  paramAnonymousn = new Intent("android.intent.action.VIEW");
                  paramAnonymousn.setClassName(Updater.this.getContext().getPackageName(), Updater.this.getContext().getPackageName() + ".plugin.webview.ui.tools.WebViewUI");
                  paramAnonymousn.putExtra("rawUrl", paramAnonymousString);
                  paramAnonymousn.putExtra("useJs", true);
                  paramAnonymousn.putExtra("vertical_scroll", true);
                  paramAnonymousn.setFlags(872415232);
                  paramAnonymousString = Updater.this.getContext();
                  paramAnonymousn = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousn);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, paramAnonymousn.ahp(), "com/tencent/mm/sandbox/updater/Updater$4", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousString.startActivity((Intent)paramAnonymousn.mq(0));
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
                paramAnonymousString = paramAnonymousString.uJl;
                break;
                Updater.this.a(paramAnonymousn, paramAnonymousString);
                paramAnonymousString = Updater.this.getContext();
                paramAnonymousn = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousn);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, paramAnonymousn.ahp(), "com/tencent/mm/sandbox/updater/Updater$4", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousString.startActivity((Intent)paramAnonymousn.mq(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/sandbox/updater/Updater$4", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
            }
            if (Updater.h(Updater.this).findViewById(2131302338) != null) {
              Updater.h(Updater.this).findViewById(2131302338).setVisibility(8);
            }
            if (paramString != null)
            {
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 63L, 1L, true);
              paramString.setText(2131764580);
            }
            AppMethodBeat.o(32748);
            return;
          }
          if (Updater.h(Updater.this).findViewById(2131302338) != null) {
            Updater.h(Updater.this).findViewById(2131302338).setVisibility(8);
          }
          if (paramString != null)
          {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 63L, 1L, true);
            paramString.setText(2131764580);
          }
          AppMethodBeat.o(32748);
        }
      };
      this.HXU = paramString;
      paramn.a(3899, paramString);
    }
    for (;;)
    {
      j.fiP();
      cancel();
      AppMethodBeat.o(32755);
      return;
      label262:
      if (paramString != null)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 64L, 1L, true);
        paramString.setText(2131764570);
        k.n(paramString, 1);
      }
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(32750);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 43L, 1L, true);
    cancel();
    AppMethodBeat.o(32750);
  }
  
  public final void update(int paramInt)
  {
    AppMethodBeat.i(32759);
    bb(paramInt, false);
    AppMethodBeat.o(32759);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.Updater
 * JD-Core Version:    0.7.0.1
 */