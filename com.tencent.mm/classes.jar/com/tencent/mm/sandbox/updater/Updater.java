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
import com.tencent.mm.c.i.a;
import com.tencent.mm.g.a.bj;
import com.tencent.mm.model.an;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.bk.a;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.o;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.bfl;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.g;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class Updater
  extends LinearLayout
  implements com.tencent.mm.ai.f, com.tencent.mm.plugin.p.a
{
  private boolean coy;
  private int ykg;
  private com.tencent.mm.ui.base.p ylm = null;
  private boolean yln = false;
  private boolean ylo = false;
  private boolean ylp = false;
  private com.tencent.mm.ai.f ylq;
  private com.tencent.mm.ai.f ylr;
  
  private Updater(Context paramContext)
  {
    super(paramContext);
  }
  
  public Updater(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static void MX(int paramInt)
  {
    AppMethodBeat.i(28949);
    if (!aw.RG())
    {
      AppMethodBeat.o(28949);
      return;
    }
    ab.d("MicroMsg.Updater", "reportUpdateStat : opCode = ".concat(String.valueOf(paramInt)));
    aw.aaz();
    com.tencent.mm.model.c.Yz().c(new com.tencent.mm.az.m(paramInt));
    AppMethodBeat.o(28949);
  }
  
  private void cancel()
  {
    AppMethodBeat.i(28944);
    aw.Rc().b(11, this);
    AppMethodBeat.o(28944);
  }
  
  public static Updater e(Context paramContext, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(28938);
    if (paramContext == null)
    {
      AppMethodBeat.o(28938);
      return null;
    }
    if (((paramContext instanceof Activity)) && ((((Activity)paramContext).isFinishing()) || (((Activity)paramContext).getWindow() == null)))
    {
      ab.e("MicroMsg.Updater", "showWithProgress, context isFinishing");
      AppMethodBeat.o(28938);
      return null;
    }
    ah.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bo.aox()).commit();
    aw.getNotification().cancel(34);
    ab.i("MicroMsg.Updater", "showWithProgress");
    Updater localUpdater = (Updater)View.inflate(paramContext, 2130971050, null);
    localUpdater.onStart();
    paramContext = com.tencent.mm.ui.base.p.d(paramContext, paramContext.getString(2131304429));
    paramContext.setCancelable(true);
    paramContext.setOnCancelListener(new Updater.1(localUpdater, paramOnCancelListener));
    try
    {
      localUpdater.ylm = paramContext;
      localUpdater.ylm.show();
      localUpdater.coy = true;
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 46L, 1L, true);
      AppMethodBeat.o(28938);
      return localUpdater;
    }
    catch (Exception paramContext)
    {
      ab.e("MicroMsg.Updater", "exception in showWithProgress, ", new Object[] { paramContext.getMessage() });
      ab.printErrStackTrace("MicroMsg.Updater", paramContext, "", new Object[0]);
      AppMethodBeat.o(28938);
    }
    return null;
  }
  
  public static void e(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(28948);
    Intent localIntent = new Intent(ah.getContext(), UpdaterService.class);
    localIntent.putExtra("intent_client_version", com.tencent.mm.protocal.d.whH);
    localIntent.putExtra("intent_update_type", 4);
    localIntent.putExtra("intent_extra_desc", paramString2);
    localIntent.putExtra("intent_extra_md5", paramString1);
    localIntent.putExtra("intent_extra_size", paramInt);
    localIntent.putExtra("intent_extra_download_url", new String[] { paramString3 });
    localIntent.putExtra("intent_extra_updateMode", g.bWw);
    localIntent.putExtra("intent_extra_marketUrl", g.ymK);
    localIntent.putExtra("intent_extra_run_in_foreground", true);
    localIntent.putExtra("intent_extra_download_mode", 2);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 45L, 1L, true);
    com.tencent.mm.bq.d.j(localIntent, "sandbox");
    AppMethodBeat.o(28948);
  }
  
  public static void eC(Context paramContext)
  {
    AppMethodBeat.i(28941);
    paramContext.startActivity(new Intent(paramContext, AppInstallerUI.class));
    AppMethodBeat.o(28941);
  }
  
  public static Updater f(Context paramContext, final DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(28939);
    ah.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bo.aox()).commit();
    aw.getNotification().cancel(34);
    ab.i("MicroMsg.Updater", "show update dialog");
    Updater localUpdater = (Updater)View.inflate(paramContext, 2130971050, null);
    localUpdater.onStart();
    paramContext = com.tencent.mm.ui.base.p.d(paramContext, "");
    paramContext.setCancelable(true);
    paramContext.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(28932);
        aw.getNotification().cancel(99);
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 49L, 1L, true);
        Updater.MX(2);
        this.yls.onStop();
        if ((!Updater.a(this.yls)) && (paramOnCancelListener != null)) {
          paramOnCancelListener.onCancel(paramAnonymousDialogInterface);
        }
        AppMethodBeat.o(28932);
      }
    });
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 48L, 1L, true);
    localUpdater.ylm = paramContext;
    localUpdater.coy = false;
    AppMethodBeat.o(28939);
    return localUpdater;
  }
  
  public static Updater gA(Context paramContext)
  {
    AppMethodBeat.i(28940);
    ah.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bo.aox()).commit();
    aw.getNotification().cancel(34);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 50L, 1L, true);
    ab.i("MicroMsg.Updater", "updater silence");
    paramContext = new Updater(paramContext);
    paramContext.onStart();
    paramContext.ylo = true;
    AppMethodBeat.o(28940);
    return paramContext;
  }
  
  private String[] getShortIps()
  {
    int i = 0;
    AppMethodBeat.i(28945);
    if ((ae.gkt != null) && (ae.gkt.length() > 0))
    {
      localObject = ae.gkt;
      AppMethodBeat.o(28945);
      return new String[] { localObject };
    }
    Object localObject = ah.getContext().getSharedPreferences("system_config_prefs", 0).getString("builtin_short_ips", "");
    if ((localObject != null) && (((String)localObject).length() > 0)) {}
    String[] arrayOfString;
    for (;;)
    {
      localObject = o.ano((String)localObject);
      arrayOfString = new String[((List)localObject).size()];
      while (i < ((List)localObject).size())
      {
        arrayOfString[i] = ((o)((List)localObject).get(i)).nZR;
        i += 1;
      }
      localObject = "0,112.64.200.240,80|0,180.153.82.27,80|0,117.135.130.177,80";
    }
    AppMethodBeat.o(28945);
    return arrayOfString;
  }
  
  private void onStart()
  {
    AppMethodBeat.i(28936);
    aw.Rc().a(11, this);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 42L, 1L, true);
    AppMethodBeat.o(28936);
  }
  
  public final void a(Intent paramIntent, e parame)
  {
    AppMethodBeat.i(28943);
    paramIntent.putExtra("intent_short_ips", getShortIps());
    paramIntent.putExtra("intent_client_version", com.tencent.mm.protocal.d.whH);
    paramIntent.putExtra("intent_update_type", 3);
    int i;
    if ((parame.nKM != null) && (!parame.nKM.isEmpty()) && (parame.nKM.containsKey(Integer.valueOf(4))))
    {
      i = 1;
      if (i == 0) {
        break label364;
      }
      localObject1 = parame.nKM;
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
          paramIntent.putExtra("intent_extra_md5", parame.nKQ);
          paramIntent.putExtra("intent_extra_size", parame.fileSize);
          paramIntent.putExtra("intent_extra_download_url", new String[] { parame.nKP });
          paramIntent.putExtra("intent_extra_patchInfo", parame.drF());
          paramIntent.putExtra("intent_extra_updateMode", g.bWw);
          paramIntent.putExtra("intent_extra_marketUrl", g.ymK);
          paramIntent.putExtra("intent_extra_extinfo", "<extinfo></extinfo>");
          paramIntent.putExtra("intent_extra_tinker_patch", true);
          paramIntent.putExtra("intent_extra_download_mode", 1);
          AppMethodBeat.o(28943);
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
    Object localObject1 = (bfl)localLinkedList.get(i);
    if (((bfl)localObject1).lang.equalsIgnoreCase("default")) {}
    for (localObject1 = new String(Base64.decode(((bfl)localObject1).content, 0));; localObject1 = localObject2)
    {
      i += 1;
      localObject2 = localObject1;
      break label265;
      if (((bfl)localObject1).lang.equalsIgnoreCase(aa.dsG()))
      {
        localObject1 = new String(Base64.decode(((bfl)localObject1).content, 0));
        break;
        label364:
        localObject1 = "";
        break;
      }
    }
  }
  
  public final void aD(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(28947);
    ab.i("MicroMsg.Updater", "summerupdate begin update routine, type=".concat(String.valueOf(paramInt)));
    this.ykg = paramInt;
    this.ylp = paramBoolean;
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 44L, 1L, true);
    com.tencent.mm.sandbox.a.a locala = new com.tencent.mm.sandbox.a.a(paramInt);
    aw.Rc().a(locala, 0);
    AppMethodBeat.o(28947);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(28942);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 51L, 1L, true);
      ab.i("MicroMsg.Updater", "isShow " + this.coy);
      if ((!this.coy) && (this.ylm != null)) {
        this.ylm.show();
      }
      this.yln = true;
      if (this.ylm != null) {
        this.ylm.cancel();
      }
      paramString = (com.tencent.mm.sandbox.a.a)paramm;
      aw.Rc().a(new bk(new bk.a()
      {
        public final void a(com.tencent.mm.network.e paramAnonymouse)
        {
          AppMethodBeat.i(28934);
          if (paramAnonymouse == null)
          {
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 52L, 1L, true);
            Assert.assertTrue("updater invalid assert", false);
          }
          aw.getNotification().cancel(34);
          ab.i("MicroMsg.Updater", "go to update");
          if (!com.tencent.mm.compatible.util.h.getExternalStorageState().equals("mounted"))
          {
            ab.e("MicroMsg.Updater", "no sdcard.");
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 53L, 1L, true);
            Updater.b(Updater.this);
          }
          int i = paramString.drp();
          com.tencent.mm.c.i locali = com.tencent.mm.c.i.dq(paramString.drr());
          String str = com.tencent.mm.pluginsdk.f.i.fU(Updater.this.getContext());
          Object localObject = null;
          if (locali != null) {
            localObject = locali.dp(str);
          }
          if (localObject == null) {}
          for (long l = i;; l = ((i.a)localObject).size + i)
          {
            if (!com.tencent.mm.compatible.util.f.gc(l))
            {
              ab.e("MicroMsg.Updater", "no enough space.");
              com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 54L, 1L, true);
              Updater.b(Updater.this);
            }
            if ((g.bWw & 0x1) != 0)
            {
              ab.i("MicroMsg.Updater", "channel pack, not silence download.");
              com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 55L, 1L, true);
              Updater.b(Updater.this);
            }
            if ((Updater.c(Updater.this) != 2) || (Updater.d(Updater.this))) {
              break;
            }
            localObject = i.dlS();
            if ((com.tencent.mm.sandbox.monitor.c.Uc(paramString.drq()) == null) || (bo.isNullOrNil((String)localObject)) || (!((String)localObject).equals(paramString.drq()))) {
              break;
            }
            ab.i("MicroMsg.Updater", "we already have this pack %s being to install, just ignore this update request", new Object[] { localObject });
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 56L, 1L, true);
            AppMethodBeat.o(28934);
            return;
          }
          localObject = paramString.bSr();
          if ((localObject != null) && (((aqy)localObject).xgl != 0) && (!bo.isNullOrNil(((aqy)localObject).xgm)))
          {
            paramAnonymouse = ((aqy)localObject).xgm;
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", paramAnonymouse);
            ((Intent)localObject).putExtra("showShare", false);
            ((Intent)localObject).putExtra("show_bottom", false);
            com.tencent.mm.bq.d.b(Updater.this.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
            i.drM();
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 57L, 1L, true);
            AppMethodBeat.o(28934);
            return;
          }
          if (Updater.e(Updater.this))
          {
            ab.i("MicroMsg.Updater", "summerupdate gonna start UpdaterService checkcontrol");
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 58L, 1L, true);
            aw.Rc().a(725, Updater.a(Updater.this, new Updater.3.1(this, paramAnonymouse)));
            aw.Rc().a(new q(), 0);
            com.tencent.mm.x.c.PJ().x(262145, true);
            com.tencent.mm.pluginsdk.model.app.a.dls();
            AppMethodBeat.o(28934);
            return;
          }
          ab.i("MicroMsg.Updater", "gonna start AppUpdaterUI");
          localObject = new Intent(Updater.this.getContext(), AppUpdaterUI.class);
          Updater.a(Updater.this, (Intent)localObject, paramAnonymouse, paramString);
          ab.i("MicroMsg.Updater", "current updateType : %s", new Object[] { Integer.valueOf(Updater.c(Updater.this)) });
          if (Updater.c(Updater.this) == 1)
          {
            ((Intent)localObject).putExtra("intent_extra_download_mode", 0);
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 60L, 1L, true);
          }
          for (;;)
          {
            Updater.this.getContext().startActivity((Intent)localObject);
            break;
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 61L, 1L, true);
            ((Intent)localObject).putExtra("intent_extra_download_mode", 1);
          }
        }
      }), 0);
      onStop();
      AppMethodBeat.o(28942);
      return;
    }
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 62L, 1L, true);
    if (this.ylm != null)
    {
      paramString = this.ylm;
      if (paramString.jba != null) {
        paramString.jba.setVisibility(8);
      }
      paramString = (TextView)this.ylm.findViewById(2131821848);
      if ((paramInt1 != 4) || (paramInt2 != -18)) {
        break label262;
      }
      paramm = new bj();
      com.tencent.mm.sdk.b.a.ymk.l(paramm);
      paramm = aw.Rc();
      paramString = new Updater.4(this, paramString);
      this.ylr = paramString;
      paramm.a(3899, paramString);
    }
    for (;;)
    {
      i.drQ();
      cancel();
      AppMethodBeat.o(28942);
      return;
      label262:
      if (paramString != null)
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 64L, 1L, true);
        paramString.setText(2131304424);
        j.k(paramString, 1);
      }
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(28937);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 43L, 1L, true);
    cancel();
    AppMethodBeat.o(28937);
  }
  
  public final void update(int paramInt)
  {
    AppMethodBeat.i(28946);
    aD(paramInt, false);
    AppMethodBeat.o(28946);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.Updater
 * JD-Core Version:    0.7.0.1
 */