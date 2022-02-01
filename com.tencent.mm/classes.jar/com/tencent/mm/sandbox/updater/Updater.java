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
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.d.i.a;
import com.tencent.mm.g.a.bo;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.o;
import com.tencent.mm.protocal.protobuf.bdr;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.bff;
import com.tencent.mm.protocal.protobuf.bwz;
import com.tencent.mm.protocal.protobuf.cce;
import com.tencent.mm.protocal.protobuf.cch;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.ui.base.p;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class Updater
  extends LinearLayout
  implements com.tencent.mm.ak.g, com.tencent.mm.plugin.q.a
{
  private int GkX;
  private p Gmc = null;
  private boolean Gmd = false;
  private boolean Gme = false;
  private boolean Gmf = false;
  private com.tencent.mm.ak.g Gmg;
  private com.tencent.mm.ak.g Gmh;
  private boolean daU;
  
  private Updater(Context paramContext)
  {
    super(paramContext);
  }
  
  public Updater(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static void Yb(int paramInt)
  {
    AppMethodBeat.i(32762);
    if (!az.agM())
    {
      AppMethodBeat.o(32762);
      return;
    }
    ac.d("MicroMsg.Updater", "reportUpdateStat : opCode = ".concat(String.valueOf(paramInt)));
    az.ayM();
    com.tencent.mm.model.c.awA().c(new com.tencent.mm.ba.n(paramInt));
    AppMethodBeat.o(32762);
  }
  
  private void cancel()
  {
    AppMethodBeat.i(32757);
    az.agi().b(11, this);
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
      ac.e("MicroMsg.Updater", "showWithProgress, context isFinishing");
      AppMethodBeat.o(32751);
      return null;
    }
    ai.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bs.aNx()).commit();
    az.getNotification().cancel(34);
    ac.i("MicroMsg.Updater", "showWithProgress");
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
        h.wUl.idkeyStat(405L, 47L, 1L, true);
        Updater.Yb(2);
        this.Gmi.onStop();
        if ((!Updater.a(this.Gmi)) && (paramOnCancelListener != null)) {
          paramOnCancelListener.onCancel(paramAnonymousDialogInterface);
        }
        AppMethodBeat.o(32744);
      }
    });
    try
    {
      localUpdater.Gmc = paramContext;
      localUpdater.Gmc.show();
      localUpdater.daU = true;
      h.wUl.idkeyStat(405L, 46L, 1L, true);
      AppMethodBeat.o(32751);
      return localUpdater;
    }
    catch (Exception paramContext)
    {
      ac.e("MicroMsg.Updater", "exception in showWithProgress, ", new Object[] { paramContext.getMessage() });
      ac.printErrStackTrace("MicroMsg.Updater", paramContext, "", new Object[0]);
      AppMethodBeat.o(32751);
    }
    return null;
  }
  
  public static Updater f(Context paramContext, final DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(32752);
    ai.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bs.aNx()).commit();
    az.getNotification().cancel(34);
    ac.i("MicroMsg.Updater", "show update dialog");
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
        h.wUl.idkeyStat(405L, 49L, 1L, true);
        Updater.Yb(2);
        this.Gmi.onStop();
        if ((!Updater.a(this.Gmi)) && (paramOnCancelListener != null)) {
          paramOnCancelListener.onCancel(paramAnonymousDialogInterface);
        }
        AppMethodBeat.o(32745);
      }
    });
    h.wUl.idkeyStat(405L, 48L, 1L, true);
    localUpdater.Gmc = paramContext;
    localUpdater.daU = false;
    AppMethodBeat.o(32752);
    return localUpdater;
  }
  
  public static void fM(Context paramContext)
  {
    AppMethodBeat.i(32754);
    Object localObject = new Intent(paramContext, AppInstallerUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/sandbox/updater/Updater", "goInstall", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/sandbox/updater/Updater", "goInstall", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(32754);
  }
  
  private String[] getShortIps()
  {
    int i = 0;
    AppMethodBeat.i(32758);
    if ((com.tencent.mm.platformtools.ab.ivp != null) && (com.tencent.mm.platformtools.ab.ivp.length() > 0))
    {
      localObject = com.tencent.mm.platformtools.ab.ivp;
      AppMethodBeat.o(32758);
      return new String[] { localObject };
    }
    Object localObject = ai.getContext().getSharedPreferences("system_config_prefs", 0).getString("builtin_short_ips", "");
    if ((localObject != null) && (((String)localObject).length() > 0)) {}
    String[] arrayOfString;
    for (;;)
    {
      localObject = o.aIA((String)localObject);
      arrayOfString = new String[((List)localObject).size()];
      while (i < ((List)localObject).size())
      {
        arrayOfString[i] = ((o)((List)localObject).get(i)).tWE;
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
    Intent localIntent = new Intent(ai.getContext(), UpdaterService.class);
    localIntent.putExtra("intent_client_version", com.tencent.mm.protocal.d.DIc);
    localIntent.putExtra("intent_update_type", 4);
    localIntent.putExtra("intent_extra_desc", paramString2);
    localIntent.putExtra("intent_extra_md5", paramString1);
    localIntent.putExtra("intent_extra_size", paramInt);
    localIntent.putExtra("intent_extra_download_url", new String[] { paramString3 });
    localIntent.putExtra("intent_extra_updateMode", com.tencent.mm.sdk.platformtools.i.cHa);
    localIntent.putExtra("intent_extra_marketUrl", com.tencent.mm.sdk.platformtools.i.GqI);
    localIntent.putExtra("intent_extra_run_in_foreground", true);
    localIntent.putExtra("intent_extra_download_mode", 2);
    h.wUl.idkeyStat(405L, 45L, 1L, true);
    com.tencent.mm.br.d.l(localIntent, "sandbox");
    AppMethodBeat.o(32761);
  }
  
  public static Updater ik(Context paramContext)
  {
    AppMethodBeat.i(32753);
    ai.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bs.aNx()).commit();
    az.getNotification().cancel(34);
    h.wUl.idkeyStat(405L, 50L, 1L, true);
    ac.i("MicroMsg.Updater", "updater silence");
    paramContext = new Updater(paramContext);
    paramContext.onStart();
    paramContext.Gme = true;
    AppMethodBeat.o(32753);
    return paramContext;
  }
  
  private void onStart()
  {
    AppMethodBeat.i(32749);
    az.agi().a(11, this);
    h.wUl.idkeyStat(405L, 42L, 1L, true);
    AppMethodBeat.o(32749);
  }
  
  public final void a(Intent paramIntent, f paramf)
  {
    AppMethodBeat.i(32756);
    paramIntent.putExtra("intent_short_ips", getShortIps());
    paramIntent.putExtra("intent_client_version", com.tencent.mm.protocal.d.DIc);
    paramIntent.putExtra("intent_update_type", 3);
    int i;
    if ((paramf.tGt != null) && (!paramf.tGt.isEmpty()) && (paramf.tGt.containsKey(Integer.valueOf(4))))
    {
      i = 1;
      if (i == 0) {
        break label365;
      }
      localObject1 = paramf.tGt;
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
          paramIntent.putExtra("intent_extra_md5", paramf.ntk);
          paramIntent.putExtra("intent_extra_size", paramf.fileSize);
          paramIntent.putExtra("intent_extra_download_url", new String[] { paramf.gnO });
          paramIntent.putExtra("intent_extra_patchInfo", paramf.eTc());
          paramIntent.putExtra("intent_extra_updateMode", com.tencent.mm.sdk.platformtools.i.cHa);
          paramIntent.putExtra("intent_extra_marketUrl", com.tencent.mm.sdk.platformtools.i.GqI);
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
    Object localObject1 = (bwz)localLinkedList.get(i);
    if (((bwz)localObject1).lang.equalsIgnoreCase("default")) {}
    for (localObject1 = new String(Base64.decode(((bwz)localObject1).content, 0));; localObject1 = localObject2)
    {
      i += 1;
      localObject2 = localObject1;
      break label266;
      if (((bwz)localObject1).lang.equalsIgnoreCase(com.tencent.mm.sdk.platformtools.ab.eUO()))
      {
        localObject1 = new String(Base64.decode(((bwz)localObject1).content, 0));
        break;
        label365:
        localObject1 = "";
        break;
      }
    }
  }
  
  public final void aU(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(32760);
    ac.i("MicroMsg.Updater", "summerupdate begin update routine, type=".concat(String.valueOf(paramInt)));
    this.GkX = paramInt;
    this.Gmf = paramBoolean;
    h.wUl.idkeyStat(405L, 44L, 1L, true);
    com.tencent.mm.sandbox.a.a locala = new com.tencent.mm.sandbox.a.a(paramInt);
    az.agi().a(locala, 0);
    AppMethodBeat.o(32760);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(32755);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      h.wUl.idkeyStat(405L, 51L, 1L, true);
      ac.i("MicroMsg.Updater", "isShow " + this.daU);
      if ((!this.daU) && (this.Gmc != null)) {
        this.Gmc.show();
      }
      this.Gmd = true;
      if (this.Gmc != null) {
        this.Gmc.cancel();
      }
      paramString = (com.tencent.mm.sandbox.a.a)paramn;
      az.agi().a(new bn(new bn.a()
      {
        public final void a(final com.tencent.mm.network.e paramAnonymouse)
        {
          AppMethodBeat.i(32747);
          if (paramAnonymouse == null)
          {
            h.wUl.idkeyStat(405L, 52L, 1L, true);
            Assert.assertTrue("updater invalid assert", false);
          }
          az.getNotification().cancel(34);
          ac.i("MicroMsg.Updater", "go to update");
          if (!com.tencent.mm.compatible.util.g.getExternalStorageState().equals("mounted"))
          {
            ac.e("MicroMsg.Updater", "no sdcard.");
            h.wUl.idkeyStat(405L, 53L, 1L, true);
            Updater.b(Updater.this);
          }
          int i = paramString.eSL();
          com.tencent.mm.d.i locali = com.tencent.mm.d.i.ed(paramString.eSN());
          String str = com.tencent.mm.pluginsdk.g.i.hr(Updater.this.getContext());
          Object localObject = null;
          if (locali != null) {
            localObject = locali.ec(str);
          }
          if (localObject == null) {}
          for (long l = i;; l = ((i.a)localObject).size + i)
          {
            if (!com.tencent.mm.compatible.util.e.oR(l))
            {
              ac.e("MicroMsg.Updater", "no enough space.");
              h.wUl.idkeyStat(405L, 54L, 1L, true);
              Updater.b(Updater.this);
            }
            if ((com.tencent.mm.sdk.platformtools.i.cHa & 0x1) != 0)
            {
              ac.i("MicroMsg.Updater", "channel pack, not silence download.");
              h.wUl.idkeyStat(405L, 55L, 1L, true);
              Updater.b(Updater.this);
            }
            if ((Updater.c(Updater.this) != 2) || (Updater.d(Updater.this))) {
              break;
            }
            localObject = j.eLy();
            if ((com.tencent.mm.sandbox.monitor.c.amd(paramString.eSM()) == null) || (bs.isNullOrNil((String)localObject)) || (!((String)localObject).equals(paramString.eSM()))) {
              break;
            }
            ac.i("MicroMsg.Updater", "we already have this pack %s being to install, just ignore this update request", new Object[] { localObject });
            h.wUl.idkeyStat(405L, 56L, 1L, true);
            AppMethodBeat.o(32747);
            return;
          }
          localObject = paramString.deX();
          if ((localObject != null) && (((bff)localObject).EUD != 0) && (!bs.isNullOrNil(((bff)localObject).EUE)))
          {
            paramAnonymouse = ((bff)localObject).EUE;
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", paramAnonymouse);
            ((Intent)localObject).putExtra("showShare", false);
            ((Intent)localObject).putExtra("show_bottom", false);
            com.tencent.mm.br.d.b(Updater.this.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
            j.eTj();
            h.wUl.idkeyStat(405L, 57L, 1L, true);
            AppMethodBeat.o(32747);
            return;
          }
          if (Updater.e(Updater.this))
          {
            ac.i("MicroMsg.Updater", "summerupdate gonna start UpdaterService checkcontrol");
            h.wUl.idkeyStat(405L, 58L, 1L, true);
            az.agi().a(725, Updater.a(Updater.this, new com.tencent.mm.ak.g()
            {
              public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.ak.n paramAnonymous2n)
              {
                AppMethodBeat.i(32746);
                az.agi().b(221, Updater.f(Updater.this));
                Updater.a(Updater.this, null);
                if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
                {
                  paramAnonymous2String = (com.tencent.mm.modelsimple.q)paramAnonymous2n;
                  String str;
                  if (((bdr)paramAnonymous2String.hpf.hvr.hvw).ndI == 0)
                  {
                    paramAnonymous2String = ((bds)paramAnonymous2String.hpf.hvs.hvw).hkR;
                    if (!bs.isNullOrNil(paramAnonymous2String))
                    {
                      paramAnonymous2String = bv.L(paramAnonymous2String, "resourcecontrolinfo");
                      if (paramAnonymous2String != null)
                      {
                        paramAnonymous2n = (String)paramAnonymous2String.get(".resourcecontrolinfo.enableupdate");
                        str = (String)paramAnonymous2String.get(".resourcecontrolinfo.expiredtime");
                        ac.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate getDisableUpdateTime values[%s]", new Object[] { paramAnonymous2String });
                        if (bs.getInt(paramAnonymous2n, 1) != 0) {}
                      }
                    }
                  }
                  for (long l1 = bs.getLong(str, 0L);; l1 = 0L)
                  {
                    long l2 = System.currentTimeMillis() / 1000L;
                    if (l1 <= l2) {
                      break;
                    }
                    ac.i("MicroMsg.Updater", "summerupdate checkcontrol time[%d] > now[%d] control not auto download and ret", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
                    h.wUl.idkeyStat(405L, 0L, 1L, true);
                    AppMethodBeat.o(32746);
                    return;
                  }
                }
                ac.i("MicroMsg.Updater", "summerupdate gonna start UpdaterService after checkcontrol");
                h.wUl.idkeyStat(405L, 59L, 1L, true);
                paramAnonymous2String = new Intent(Updater.this.getContext(), UpdaterService.class);
                Updater.a(Updater.this, paramAnonymous2String, paramAnonymouse, Updater.3.this.Gmk);
                paramAnonymous2String.putExtra("intent_extra_run_in_foreground", true);
                paramAnonymous2String.putExtra("intent_extra_download_mode", 2);
                com.tencent.mm.br.d.l(paramAnonymous2String, "sandbox");
                AppMethodBeat.o(32746);
              }
            }));
            az.agi().a(new com.tencent.mm.modelsimple.q(), 0);
            com.tencent.mm.y.c.aeH().w(262145, true);
            com.tencent.mm.pluginsdk.model.app.b.eKT();
            AppMethodBeat.o(32747);
            return;
          }
          ac.i("MicroMsg.Updater", "gonna start AppUpdaterUI");
          localObject = new Intent(Updater.this.getContext(), AppUpdaterUI.class);
          Updater.a(Updater.this, (Intent)localObject, paramAnonymouse, paramString);
          ac.i("MicroMsg.Updater", "current updateType : %s", new Object[] { Integer.valueOf(Updater.c(Updater.this)) });
          if (Updater.c(Updater.this) == 1)
          {
            ((Intent)localObject).putExtra("intent_extra_download_mode", 0);
            h.wUl.idkeyStat(405L, 60L, 1L, true);
          }
          for (;;)
          {
            paramAnonymouse = Updater.this.getContext();
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymouse, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/sandbox/updater/Updater$3", "onSceneEnd", "(Lcom/tencent/mm/network/IDispatcher;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymouse.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymouse, "com/tencent/mm/sandbox/updater/Updater$3", "onSceneEnd", "(Lcom/tencent/mm/network/IDispatcher;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
            h.wUl.idkeyStat(405L, 61L, 1L, true);
            ((Intent)localObject).putExtra("intent_extra_download_mode", 1);
          }
        }
      }), 0);
      onStop();
      AppMethodBeat.o(32755);
      return;
    }
    h.wUl.idkeyStat(405L, 62L, 1L, true);
    if (this.Gmc != null)
    {
      paramString = this.Gmc;
      if (paramString.msX != null) {
        paramString.msX.setVisibility(8);
      }
      paramString = (TextView)this.Gmc.findViewById(2131302339);
      if ((paramInt1 != 4) || (paramInt2 != -18)) {
        break label262;
      }
      paramn = new bo();
      com.tencent.mm.sdk.b.a.GpY.l(paramn);
      paramn = az.agi();
      paramString = new com.tencent.mm.ak.g()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
        {
          AppMethodBeat.i(32748);
          az.agi().b(3899, Updater.g(Updater.this));
          Updater.a(Updater.this, null);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousn = ((cce)((com.tencent.mm.ak.b)paramAnonymousn.getReqResp()).hvs.hvw).FqE;
            paramAnonymousString = new f(paramAnonymousn);
            if ((paramAnonymousn != null) && (paramAnonymousn.FqJ == 3))
            {
              paramAnonymousn = new Intent(Updater.this.getContext(), AppUpdaterUI.class);
              if (f.aiC(paramAnonymousString.clientVersion)) {
                if (bs.isNullOrNil(paramAnonymousString.tGy))
                {
                  paramAnonymousString = "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";
                  paramAnonymousn = new Intent("android.intent.action.VIEW");
                  paramAnonymousn.setClassName(Updater.this.getContext().getPackageName(), Updater.this.getContext().getPackageName() + ".plugin.webview.ui.tools.WebViewUI");
                  paramAnonymousn.putExtra("rawUrl", paramAnonymousString);
                  paramAnonymousn.putExtra("useJs", true);
                  paramAnonymousn.putExtra("vertical_scroll", true);
                  paramAnonymousn.setFlags(872415232);
                  paramAnonymousString = Updater.this.getContext();
                  paramAnonymousn = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousn);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, paramAnonymousn.aeD(), "com/tencent/mm/sandbox/updater/Updater$4", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousString.startActivity((Intent)paramAnonymousn.lR(0));
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
                paramAnonymousString = paramAnonymousString.tGy;
                break;
                Updater.this.a(paramAnonymousn, paramAnonymousString);
                paramAnonymousString = Updater.this.getContext();
                paramAnonymousn = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousn);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, paramAnonymousn.aeD(), "com/tencent/mm/sandbox/updater/Updater$4", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousString.startActivity((Intent)paramAnonymousn.lR(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/sandbox/updater/Updater$4", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
            }
            if (Updater.h(Updater.this).findViewById(2131302338) != null) {
              Updater.h(Updater.this).findViewById(2131302338).setVisibility(8);
            }
            if (paramString != null)
            {
              h.wUl.idkeyStat(405L, 63L, 1L, true);
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
            h.wUl.idkeyStat(405L, 63L, 1L, true);
            paramString.setText(2131764580);
          }
          AppMethodBeat.o(32748);
        }
      };
      this.Gmh = paramString;
      paramn.a(3899, paramString);
    }
    for (;;)
    {
      j.eTn();
      cancel();
      AppMethodBeat.o(32755);
      return;
      label262:
      if (paramString != null)
      {
        h.wUl.idkeyStat(405L, 64L, 1L, true);
        paramString.setText(2131764570);
        k.m(paramString, 1);
      }
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(32750);
    h.wUl.idkeyStat(405L, 43L, 1L, true);
    cancel();
    AppMethodBeat.o(32750);
  }
  
  public final void update(int paramInt)
  {
    AppMethodBeat.i(32759);
    aU(paramInt, false);
    AppMethodBeat.o(32759);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.Updater
 * JD-Core Version:    0.7.0.1
 */