package com.tencent.mm.sandbox.updater;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.bb.m;
import com.tencent.mm.d.i.a;
import com.tencent.mm.g.a.bo;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.o;
import com.tencent.mm.protocal.protobuf.azz;
import com.tencent.mm.protocal.protobuf.baa;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bsi;
import com.tencent.mm.protocal.protobuf.bxj;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.sdk.platformtools.ac;
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
  implements com.tencent.mm.al.g, com.tencent.mm.plugin.q.a
{
  private int ENK;
  private p EOP = null;
  private boolean EOQ = false;
  private boolean EOR = false;
  private boolean EOS = false;
  private com.tencent.mm.al.g EOT;
  private com.tencent.mm.al.g EOU;
  private boolean ddw;
  
  private Updater(Context paramContext)
  {
    super(paramContext);
  }
  
  public Updater(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static void VS(int paramInt)
  {
    AppMethodBeat.i(32762);
    if (!az.afw())
    {
      AppMethodBeat.o(32762);
      return;
    }
    ad.d("MicroMsg.Updater", "reportUpdateStat : opCode = ".concat(String.valueOf(paramInt)));
    az.arV();
    com.tencent.mm.model.c.apL().c(new m(paramInt));
    AppMethodBeat.o(32762);
  }
  
  private void cancel()
  {
    AppMethodBeat.i(32757);
    az.aeS().b(11, this);
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
    aj.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bt.aGK()).commit();
    az.getNotification().cancel(34);
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
        az.getNotification().cancel(99);
        h.vKh.idkeyStat(405L, 47L, 1L, true);
        Updater.VS(2);
        this.EOV.onStop();
        if ((!Updater.a(this.EOV)) && (paramOnCancelListener != null)) {
          paramOnCancelListener.onCancel(paramAnonymousDialogInterface);
        }
        AppMethodBeat.o(32744);
      }
    });
    try
    {
      localUpdater.EOP = paramContext;
      localUpdater.EOP.show();
      localUpdater.ddw = true;
      h.vKh.idkeyStat(405L, 46L, 1L, true);
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
  
  public static void e(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(32761);
    Intent localIntent = new Intent(aj.getContext(), UpdaterService.class);
    localIntent.putExtra("intent_client_version", com.tencent.mm.protocal.d.CpK);
    localIntent.putExtra("intent_update_type", 4);
    localIntent.putExtra("intent_extra_desc", paramString2);
    localIntent.putExtra("intent_extra_md5", paramString1);
    localIntent.putExtra("intent_extra_size", paramInt);
    localIntent.putExtra("intent_extra_download_url", new String[] { paramString3 });
    localIntent.putExtra("intent_extra_updateMode", com.tencent.mm.sdk.platformtools.i.cJT);
    localIntent.putExtra("intent_extra_marketUrl", com.tencent.mm.sdk.platformtools.i.ETv);
    localIntent.putExtra("intent_extra_run_in_foreground", true);
    localIntent.putExtra("intent_extra_download_mode", 2);
    h.vKh.idkeyStat(405L, 45L, 1L, true);
    com.tencent.mm.bs.d.l(localIntent, "sandbox");
    AppMethodBeat.o(32761);
  }
  
  public static Updater f(Context paramContext, final DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(32752);
    aj.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bt.aGK()).commit();
    az.getNotification().cancel(34);
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
        az.getNotification().cancel(99);
        h.vKh.idkeyStat(405L, 49L, 1L, true);
        Updater.VS(2);
        this.EOV.onStop();
        if ((!Updater.a(this.EOV)) && (paramOnCancelListener != null)) {
          paramOnCancelListener.onCancel(paramAnonymousDialogInterface);
        }
        AppMethodBeat.o(32745);
      }
    });
    h.vKh.idkeyStat(405L, 48L, 1L, true);
    localUpdater.EOP = paramContext;
    localUpdater.ddw = false;
    AppMethodBeat.o(32752);
    return localUpdater;
  }
  
  public static void fA(Context paramContext)
  {
    AppMethodBeat.i(32754);
    Object localObject = new Intent(paramContext, AppInstallerUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/sandbox/updater/Updater", "goInstall", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/sandbox/updater/Updater", "goInstall", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(32754);
  }
  
  private String[] getShortIps()
  {
    int i = 0;
    AppMethodBeat.i(32758);
    if ((ab.hVl != null) && (ab.hVl.length() > 0))
    {
      localObject = ab.hVl;
      AppMethodBeat.o(32758);
      return new String[] { localObject };
    }
    Object localObject = aj.getContext().getSharedPreferences("system_config_prefs", 0).getString("builtin_short_ips", "");
    if ((localObject != null) && (((String)localObject).length() > 0)) {}
    String[] arrayOfString;
    for (;;)
    {
      localObject = o.aDj((String)localObject);
      arrayOfString = new String[((List)localObject).size()];
      while (i < ((List)localObject).size())
      {
        arrayOfString[i] = ((o)((List)localObject).get(i)).sOr;
        i += 1;
      }
      localObject = "0,112.64.200.240,80|0,180.153.82.27,80|0,117.135.130.177,80";
    }
    AppMethodBeat.o(32758);
    return arrayOfString;
  }
  
  public static Updater hZ(Context paramContext)
  {
    AppMethodBeat.i(32753);
    aj.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bt.aGK()).commit();
    az.getNotification().cancel(34);
    h.vKh.idkeyStat(405L, 50L, 1L, true);
    ad.i("MicroMsg.Updater", "updater silence");
    paramContext = new Updater(paramContext);
    paramContext.onStart();
    paramContext.EOR = true;
    AppMethodBeat.o(32753);
    return paramContext;
  }
  
  private void onStart()
  {
    AppMethodBeat.i(32749);
    az.aeS().a(11, this);
    h.vKh.idkeyStat(405L, 42L, 1L, true);
    AppMethodBeat.o(32749);
  }
  
  public final void a(Intent paramIntent, f paramf)
  {
    AppMethodBeat.i(32756);
    paramIntent.putExtra("intent_short_ips", getShortIps());
    paramIntent.putExtra("intent_client_version", com.tencent.mm.protocal.d.CpK);
    paramIntent.putExtra("intent_update_type", 3);
    int i;
    if ((paramf.syE != null) && (!paramf.syE.isEmpty()) && (paramf.syE.containsKey(Integer.valueOf(4))))
    {
      i = 1;
      if (i == 0) {
        break label365;
      }
      localObject1 = paramf.syE;
      if ((localObject1 != null) && (!((HashMap)localObject1).isEmpty())) {
        break label217;
      }
      localObject1 = "";
    }
    label217:
    Object localObject2;
    LinkedList localLinkedList;
    int j;
    label266:
    do
    {
      do
      {
        do
        {
          paramIntent.putExtra("intent_extra_desc", (String)localObject1);
          paramIntent.putExtra("intent_extra_md5", paramf.syI);
          paramIntent.putExtra("intent_extra_size", paramf.fileSize);
          paramIntent.putExtra("intent_extra_download_url", new String[] { paramf.syH });
          paramIntent.putExtra("intent_extra_patchInfo", paramf.eDI());
          paramIntent.putExtra("intent_extra_updateMode", com.tencent.mm.sdk.platformtools.i.cJT);
          paramIntent.putExtra("intent_extra_marketUrl", com.tencent.mm.sdk.platformtools.i.ETv);
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
    Object localObject1 = (bsi)localLinkedList.get(i);
    if (((bsi)localObject1).lang.equalsIgnoreCase("default")) {}
    for (localObject1 = new String(Base64.decode(((bsi)localObject1).content, 0));; localObject1 = localObject2)
    {
      i += 1;
      localObject2 = localObject1;
      break label266;
      if (((bsi)localObject1).lang.equalsIgnoreCase(ac.eFu()))
      {
        localObject1 = new String(Base64.decode(((bsi)localObject1).content, 0));
        break;
        label365:
        localObject1 = "";
        break;
      }
    }
  }
  
  public final void aQ(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(32760);
    ad.i("MicroMsg.Updater", "summerupdate begin update routine, type=".concat(String.valueOf(paramInt)));
    this.ENK = paramInt;
    this.EOS = paramBoolean;
    h.vKh.idkeyStat(405L, 44L, 1L, true);
    com.tencent.mm.sandbox.a.a locala = new com.tencent.mm.sandbox.a.a(paramInt);
    az.aeS().a(locala, 0);
    AppMethodBeat.o(32760);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(32755);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      h.vKh.idkeyStat(405L, 51L, 1L, true);
      ad.i("MicroMsg.Updater", "isShow " + this.ddw);
      if ((!this.ddw) && (this.EOP != null)) {
        this.EOP.show();
      }
      this.EOQ = true;
      if (this.EOP != null) {
        this.EOP.cancel();
      }
      paramString = (com.tencent.mm.sandbox.a.a)paramn;
      az.aeS().a(new bn(new bn.a()
      {
        public final void a(final com.tencent.mm.network.e paramAnonymouse)
        {
          AppMethodBeat.i(32747);
          if (paramAnonymouse == null)
          {
            h.vKh.idkeyStat(405L, 52L, 1L, true);
            Assert.assertTrue("updater invalid assert", false);
          }
          az.getNotification().cancel(34);
          ad.i("MicroMsg.Updater", "go to update");
          if (!com.tencent.mm.compatible.util.g.getExternalStorageState().equals("mounted"))
          {
            ad.e("MicroMsg.Updater", "no sdcard.");
            h.vKh.idkeyStat(405L, 53L, 1L, true);
            Updater.b(Updater.this);
          }
          int i = paramString.eDr();
          com.tencent.mm.d.i locali = com.tencent.mm.d.i.eo(paramString.eDt());
          String str = com.tencent.mm.pluginsdk.g.i.hg(Updater.this.getContext());
          Object localObject = null;
          if (locali != null) {
            localObject = locali.en(str);
          }
          if (localObject == null) {}
          for (long l = i;; l = ((i.a)localObject).size + i)
          {
            if (!com.tencent.mm.compatible.util.e.lo(l))
            {
              ad.e("MicroMsg.Updater", "no enough space.");
              h.vKh.idkeyStat(405L, 54L, 1L, true);
              Updater.b(Updater.this);
            }
            if ((com.tencent.mm.sdk.platformtools.i.cJT & 0x1) != 0)
            {
              ad.i("MicroMsg.Updater", "channel pack, not silence download.");
              h.vKh.idkeyStat(405L, 55L, 1L, true);
              Updater.b(Updater.this);
            }
            if ((Updater.c(Updater.this) != 2) || (Updater.d(Updater.this))) {
              break;
            }
            localObject = j.ewe();
            if ((com.tencent.mm.sandbox.monitor.c.ahi(paramString.eDs()) == null) || (bt.isNullOrNil((String)localObject)) || (!((String)localObject).equals(paramString.eDs()))) {
              break;
            }
            ad.i("MicroMsg.Updater", "we already have this pack %s being to install, just ignore this update request", new Object[] { localObject });
            h.vKh.idkeyStat(405L, 56L, 1L, true);
            AppMethodBeat.o(32747);
            return;
          }
          localObject = paramString.cRn();
          if ((localObject != null) && (((bbn)localObject).Dzh != 0) && (!bt.isNullOrNil(((bbn)localObject).Dzi)))
          {
            paramAnonymouse = ((bbn)localObject).Dzi;
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", paramAnonymouse);
            ((Intent)localObject).putExtra("showShare", false);
            ((Intent)localObject).putExtra("show_bottom", false);
            com.tencent.mm.bs.d.b(Updater.this.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
            j.eDP();
            h.vKh.idkeyStat(405L, 57L, 1L, true);
            AppMethodBeat.o(32747);
            return;
          }
          if (Updater.e(Updater.this))
          {
            ad.i("MicroMsg.Updater", "summerupdate gonna start UpdaterService checkcontrol");
            h.vKh.idkeyStat(405L, 58L, 1L, true);
            az.aeS().a(725, Updater.a(Updater.this, new com.tencent.mm.al.g()
            {
              public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
              {
                AppMethodBeat.i(32746);
                az.aeS().b(221, Updater.f(Updater.this));
                Updater.a(Updater.this, null);
                if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
                {
                  paramAnonymous2String = (com.tencent.mm.modelsimple.q)paramAnonymous2n;
                  String str;
                  if (((azz)paramAnonymous2String.gOF.gUS.gUX).mBH == 0)
                  {
                    paramAnonymous2String = ((baa)paramAnonymous2String.gOF.gUT.gUX).gKr;
                    if (!bt.isNullOrNil(paramAnonymous2String))
                    {
                      paramAnonymous2String = bw.K(paramAnonymous2String, "resourcecontrolinfo");
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
                    h.vKh.idkeyStat(405L, 0L, 1L, true);
                    AppMethodBeat.o(32746);
                    return;
                  }
                }
                ad.i("MicroMsg.Updater", "summerupdate gonna start UpdaterService after checkcontrol");
                h.vKh.idkeyStat(405L, 59L, 1L, true);
                paramAnonymous2String = new Intent(Updater.this.getContext(), UpdaterService.class);
                Updater.a(Updater.this, paramAnonymous2String, paramAnonymouse, Updater.3.this.EOX);
                paramAnonymous2String.putExtra("intent_extra_run_in_foreground", true);
                paramAnonymous2String.putExtra("intent_extra_download_mode", 2);
                com.tencent.mm.bs.d.l(paramAnonymous2String, "sandbox");
                AppMethodBeat.o(32746);
              }
            }));
            az.aeS().a(new com.tencent.mm.modelsimple.q(), 0);
            com.tencent.mm.z.c.adr().w(262145, true);
            com.tencent.mm.pluginsdk.model.app.b.evz();
            AppMethodBeat.o(32747);
            return;
          }
          ad.i("MicroMsg.Updater", "gonna start AppUpdaterUI");
          localObject = new Intent(Updater.this.getContext(), AppUpdaterUI.class);
          Updater.a(Updater.this, (Intent)localObject, paramAnonymouse, paramString);
          ad.i("MicroMsg.Updater", "current updateType : %s", new Object[] { Integer.valueOf(Updater.c(Updater.this)) });
          if (Updater.c(Updater.this) == 1)
          {
            ((Intent)localObject).putExtra("intent_extra_download_mode", 0);
            h.vKh.idkeyStat(405L, 60L, 1L, true);
          }
          for (;;)
          {
            paramAnonymouse = Updater.this.getContext();
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymouse, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/sandbox/updater/Updater$3", "onSceneEnd", "(Lcom/tencent/mm/network/IDispatcher;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymouse.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymouse, "com/tencent/mm/sandbox/updater/Updater$3", "onSceneEnd", "(Lcom/tencent/mm/network/IDispatcher;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
            h.vKh.idkeyStat(405L, 61L, 1L, true);
            ((Intent)localObject).putExtra("intent_extra_download_mode", 1);
          }
        }
      }), 0);
      onStop();
      AppMethodBeat.o(32755);
      return;
    }
    h.vKh.idkeyStat(405L, 62L, 1L, true);
    if (this.EOP != null)
    {
      paramString = this.EOP;
      if (paramString.lQU != null) {
        paramString.lQU.setVisibility(8);
      }
      paramString = (TextView)this.EOP.findViewById(2131302339);
      if ((paramInt1 != 4) || (paramInt2 != -18)) {
        break label262;
      }
      paramn = new bo();
      com.tencent.mm.sdk.b.a.ESL.l(paramn);
      paramn = az.aeS();
      paramString = new com.tencent.mm.al.g()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(32748);
          az.aeS().b(3899, Updater.g(Updater.this));
          Updater.a(Updater.this, null);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousn = ((bxj)((com.tencent.mm.al.b)paramAnonymousn.getReqResp()).gUT.gUX).DTR;
            paramAnonymousString = new f(paramAnonymousn);
            if ((paramAnonymousn != null) && (paramAnonymousn.DTW == 3))
            {
              paramAnonymousn = new Intent(Updater.this.getContext(), AppUpdaterUI.class);
              if (f.adK(paramAnonymousString.clientVersion)) {
                if (bt.isNullOrNil(paramAnonymousString.syO))
                {
                  paramAnonymousString = "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";
                  paramAnonymousn = new Intent("android.intent.action.VIEW");
                  paramAnonymousn.setClassName(Updater.this.getContext().getPackageName(), Updater.this.getContext().getPackageName() + ".plugin.webview.ui.tools.WebViewUI");
                  paramAnonymousn.putExtra("rawUrl", paramAnonymousString);
                  paramAnonymousn.putExtra("useJs", true);
                  paramAnonymousn.putExtra("vertical_scroll", true);
                  paramAnonymousn.setFlags(872415232);
                  paramAnonymousString = Updater.this.getContext();
                  paramAnonymousn = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousn);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, paramAnonymousn.adn(), "com/tencent/mm/sandbox/updater/Updater$4", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousString.startActivity((Intent)paramAnonymousn.lS(0));
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
                paramAnonymousString = paramAnonymousString.syO;
                break;
                Updater.this.a(paramAnonymousn, paramAnonymousString);
                paramAnonymousString = Updater.this.getContext();
                paramAnonymousn = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousn);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, paramAnonymousn.adn(), "com/tencent/mm/sandbox/updater/Updater$4", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousString.startActivity((Intent)paramAnonymousn.lS(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/sandbox/updater/Updater$4", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
            }
            if (Updater.h(Updater.this).findViewById(2131302338) != null) {
              Updater.h(Updater.this).findViewById(2131302338).setVisibility(8);
            }
            if (paramString != null)
            {
              h.vKh.idkeyStat(405L, 63L, 1L, true);
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
            h.vKh.idkeyStat(405L, 63L, 1L, true);
            paramString.setText(2131764580);
          }
          AppMethodBeat.o(32748);
        }
      };
      this.EOU = paramString;
      paramn.a(3899, paramString);
    }
    for (;;)
    {
      j.eDT();
      cancel();
      AppMethodBeat.o(32755);
      return;
      label262:
      if (paramString != null)
      {
        h.vKh.idkeyStat(405L, 64L, 1L, true);
        paramString.setText(2131764570);
        k.m(paramString, 1);
      }
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(32750);
    h.vKh.idkeyStat(405L, 43L, 1L, true);
    cancel();
    AppMethodBeat.o(32750);
  }
  
  public final void update(int paramInt)
  {
    AppMethodBeat.i(32759);
    aQ(paramInt, false);
    AppMethodBeat.o(32759);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.Updater
 * JD-Core Version:    0.7.0.1
 */