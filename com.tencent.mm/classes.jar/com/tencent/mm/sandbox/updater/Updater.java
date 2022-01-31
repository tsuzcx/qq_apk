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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ay.l;
import com.tencent.mm.c.i.a;
import com.tencent.mm.h.a.bh;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.modelsimple.o;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.ajz;
import com.tencent.mm.protocal.c.aka;
import com.tencent.mm.protocal.c.all;
import com.tencent.mm.protocal.c.ayo;
import com.tencent.mm.protocal.c.bxv;
import com.tencent.mm.protocal.c.pt;
import com.tencent.mm.protocal.n;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class Updater
  extends LinearLayout
  implements com.tencent.mm.ah.f, com.tencent.mm.plugin.w.a
{
  private boolean bHj;
  private int ubR;
  private com.tencent.mm.ui.base.p ucX = null;
  private boolean ucY = false;
  private boolean ucZ = false;
  private boolean uda = false;
  private com.tencent.mm.ah.f udb;
  private com.tencent.mm.ah.f udc;
  
  private Updater(Context paramContext)
  {
    super(paramContext);
  }
  
  public Updater(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static void EW(int paramInt)
  {
    if (!au.DK()) {
      return;
    }
    y.d("MicroMsg.Updater", "reportUpdateStat : opCode = " + paramInt);
    au.Hx();
    com.tencent.mm.model.c.Fv().b(new l(paramInt));
  }
  
  public static Updater c(Context paramContext, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (paramContext == null) {
      return null;
    }
    if (((paramContext instanceof Activity)) && ((((Activity)paramContext).isFinishing()) || (((Activity)paramContext).getWindow() == null)))
    {
      y.e("MicroMsg.Updater", "showWithProgress, context isFinishing");
      return null;
    }
    com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bk.UX()).commit();
    au.getNotification().cancel(34);
    y.i("MicroMsg.Updater", "showWithProgress");
    Updater localUpdater = (Updater)View.inflate(paramContext, R.i.updater, null);
    localUpdater.onStart();
    paramContext = com.tencent.mm.ui.base.p.a(paramContext, paramContext.getString(R.l.update_getting_updateinfo), true, 0, null);
    paramContext.setCancelable(true);
    paramContext.setOnCancelListener(new Updater.1(localUpdater, paramOnCancelListener));
    try
    {
      localUpdater.ucX = paramContext;
      localUpdater.ucX.show();
      localUpdater.bHj = true;
      com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 46L, 1L, true);
      return localUpdater;
    }
    catch (Exception paramContext)
    {
      y.e("MicroMsg.Updater", "exception in showWithProgress, ", new Object[] { paramContext.getMessage() });
      y.printErrStackTrace("MicroMsg.Updater", paramContext, "", new Object[0]);
    }
    return null;
  }
  
  private void cancel()
  {
    au.Dk().b(11, this);
  }
  
  public static Updater d(Context paramContext, final DialogInterface.OnCancelListener paramOnCancelListener)
  {
    com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bk.UX()).commit();
    au.getNotification().cancel(34);
    y.i("MicroMsg.Updater", "show update dialog");
    Updater localUpdater = (Updater)View.inflate(paramContext, R.i.updater, null);
    localUpdater.onStart();
    paramContext = com.tencent.mm.ui.base.p.a(paramContext, "", true, 0, null);
    paramContext.setCancelable(true);
    paramContext.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        au.getNotification().cancel(99);
        com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 49L, 1L, true);
        Updater.EW(2);
        this.udd.onStop();
        if ((!Updater.a(this.udd)) && (paramOnCancelListener != null)) {
          paramOnCancelListener.onCancel(paramAnonymousDialogInterface);
        }
      }
    });
    com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 48L, 1L, true);
    localUpdater.ucX = paramContext;
    localUpdater.bHj = false;
    return localUpdater;
  }
  
  public static void dQ(Context paramContext)
  {
    paramContext.startActivity(new Intent(paramContext, AppInstallerUI.class));
  }
  
  public static void e(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent(com.tencent.mm.sdk.platformtools.ae.getContext(), UpdaterService.class);
    localIntent.putExtra("intent_client_version", com.tencent.mm.protocal.d.spa);
    localIntent.putExtra("intent_update_type", 4);
    localIntent.putExtra("intent_extra_desc", paramString2);
    localIntent.putExtra("intent_extra_md5", paramString1);
    localIntent.putExtra("intent_extra_size", paramInt);
    localIntent.putExtra("intent_extra_download_url", new String[] { paramString3 });
    localIntent.putExtra("intent_extra_updateMode", com.tencent.mm.sdk.platformtools.e.bvl);
    localIntent.putExtra("intent_extra_marketUrl", com.tencent.mm.sdk.platformtools.e.uej);
    localIntent.putExtra("intent_extra_run_in_foreground", true);
    localIntent.putExtra("intent_extra_download_mode", 2);
    com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 45L, 1L, true);
    com.tencent.mm.sdk.platformtools.ae.getContext().startService(localIntent);
  }
  
  public static Updater fn(Context paramContext)
  {
    com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bk.UX()).commit();
    au.getNotification().cancel(34);
    com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 50L, 1L, true);
    y.i("MicroMsg.Updater", "updater silence");
    paramContext = new Updater(paramContext);
    paramContext.onStart();
    paramContext.ucZ = true;
    return paramContext;
  }
  
  private String[] getShortIps()
  {
    int i = 0;
    if ((com.tencent.mm.platformtools.ae.eSy != null) && (com.tencent.mm.platformtools.ae.eSy.length() > 0)) {
      return new String[] { com.tencent.mm.platformtools.ae.eSy };
    }
    Object localObject = com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences("system_config_prefs", 0).getString("builtin_short_ips", "");
    if ((localObject != null) && (((String)localObject).length() > 0)) {}
    String[] arrayOfString;
    for (;;)
    {
      localObject = n.Xs((String)localObject);
      arrayOfString = new String[((List)localObject).size()];
      while (i < ((List)localObject).size())
      {
        arrayOfString[i] = ((n)((List)localObject).get(i)).lCF;
        i += 1;
      }
      localObject = "0,112.64.200.240,80|0,180.153.82.27,80|0,117.135.130.177,80";
    }
    return arrayOfString;
  }
  
  private void onStart()
  {
    au.Dk().a(11, this);
    com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 42L, 1L, true);
  }
  
  public final void a(Intent paramIntent, e parame)
  {
    paramIntent.putExtra("intent_short_ips", getShortIps());
    paramIntent.putExtra("intent_client_version", com.tencent.mm.protocal.d.spa);
    paramIntent.putExtra("intent_update_type", 3);
    int i;
    if ((parame.lnt != null) && (!parame.lnt.isEmpty()) && (parame.lnt.containsKey(Integer.valueOf(4))))
    {
      i = 1;
      if (i == 0) {
        break label352;
      }
      localObject1 = parame.lnt;
      if ((localObject1 != null) && (!((HashMap)localObject1).isEmpty())) {
        break label204;
      }
      localObject1 = "";
    }
    label204:
    Object localObject2;
    LinkedList localLinkedList;
    int j;
    label253:
    do
    {
      do
      {
        do
        {
          paramIntent.putExtra("intent_extra_desc", (String)localObject1);
          paramIntent.putExtra("intent_extra_md5", parame.lnx);
          paramIntent.putExtra("intent_extra_size", parame.fileSize);
          paramIntent.putExtra("intent_extra_download_url", new String[] { parame.lnw });
          paramIntent.putExtra("intent_extra_patchInfo", parame.cpR());
          paramIntent.putExtra("intent_extra_updateMode", com.tencent.mm.sdk.platformtools.e.bvl);
          paramIntent.putExtra("intent_extra_marketUrl", com.tencent.mm.sdk.platformtools.e.uej);
          paramIntent.putExtra("intent_extra_extinfo", "<extinfo></extinfo>");
          paramIntent.putExtra("intent_extra_tinker_patch", true);
          paramIntent.putExtra("intent_extra_download_mode", 1);
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
    Object localObject1 = (ayo)localLinkedList.get(i);
    if (((ayo)localObject1).lang.equalsIgnoreCase("default")) {}
    for (localObject1 = new String(Base64.decode(((ayo)localObject1).content, 0));; localObject1 = localObject2)
    {
      i += 1;
      localObject2 = localObject1;
      break label253;
      if (((ayo)localObject1).lang.equalsIgnoreCase(x.cqJ()))
      {
        localObject1 = new String(Base64.decode(((ayo)localObject1).content, 0));
        break;
        label352:
        localObject1 = "";
        break;
      }
    }
  }
  
  public final void am(int paramInt, boolean paramBoolean)
  {
    y.i("MicroMsg.Updater", "summerupdate begin update routine, type=" + paramInt);
    this.ubR = paramInt;
    this.uda = paramBoolean;
    com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 44L, 1L, true);
    com.tencent.mm.sandbox.a.a locala = new com.tencent.mm.sandbox.a.a(paramInt);
    au.Dk().a(locala, 0);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 51L, 1L, true);
      y.i("MicroMsg.Updater", "isShow " + this.bHj);
      if ((!this.bHj) && (this.ucX != null)) {
        this.ucX.show();
      }
      this.ucY = true;
      if (this.ucX != null) {
        this.ucX.cancel();
      }
      paramString = (com.tencent.mm.sandbox.a.a)paramm;
      au.Dk().a(new bi(new bi.a()
      {
        public final void a(final com.tencent.mm.network.e paramAnonymouse)
        {
          if (paramAnonymouse == null)
          {
            com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 52L, 1L, true);
            Assert.assertTrue("updater invalid assert", false);
          }
          au.getNotification().cancel(34);
          y.i("MicroMsg.Updater", "go to update");
          if (!com.tencent.mm.compatible.util.h.getExternalStorageState().equals("mounted"))
          {
            y.e("MicroMsg.Updater", "no sdcard.");
            com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 53L, 1L, true);
            Updater.b(Updater.this);
          }
          int i = paramString.cpB();
          com.tencent.mm.c.i locali = com.tencent.mm.c.i.cf(paramString.cpD());
          String str = com.tencent.mm.pluginsdk.f.i.eU(Updater.this.getContext());
          Object localObject = null;
          if (locali != null) {
            localObject = locali.ce(str);
          }
          if (localObject == null) {}
          for (long l = i;; l = ((i.a)localObject).size + i)
          {
            if (!com.tencent.mm.compatible.util.f.bs(l))
            {
              y.e("MicroMsg.Updater", "no enough space.");
              com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 54L, 1L, true);
              Updater.b(Updater.this);
            }
            if ((com.tencent.mm.sdk.platformtools.e.bvl & 0x1) != 0)
            {
              y.i("MicroMsg.Updater", "channel pack, not silence download.");
              com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 55L, 1L, true);
              Updater.b(Updater.this);
            }
            if ((Updater.c(Updater.this) != 2) || (Updater.d(Updater.this))) {
              break;
            }
            localObject = i.cli();
            if ((com.tencent.mm.sandbox.monitor.c.Iq(paramString.cpC()) == null) || (bk.bl((String)localObject)) || (!((String)localObject).equals(paramString.cpC()))) {
              break;
            }
            y.i("MicroMsg.Updater", "we already have this pack %s being to install, just ignore this update request", new Object[] { localObject });
            com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 56L, 1L, true);
            return;
          }
          localObject = paramString.bkq();
          if ((localObject != null) && (((all)localObject).thx != 0) && (!bk.bl(((all)localObject).thy)))
          {
            paramAnonymouse = ((all)localObject).thy;
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", paramAnonymouse);
            ((Intent)localObject).putExtra("showShare", false);
            ((Intent)localObject).putExtra("show_bottom", false);
            com.tencent.mm.br.d.b(Updater.this.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
            i.cpW();
            com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 57L, 1L, true);
            return;
          }
          if (Updater.e(Updater.this))
          {
            y.i("MicroMsg.Updater", "summerupdate gonna start UpdaterService checkcontrol");
            com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 58L, 1L, true);
            au.Dk().a(725, Updater.a(Updater.this, new com.tencent.mm.ah.f()
            {
              public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, m paramAnonymous2m)
              {
                au.Dk().b(221, Updater.f(Updater.this));
                Updater.a(Updater.this, null);
                if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
                {
                  paramAnonymous2String = (o)paramAnonymous2m;
                  String str;
                  if (((ajz)paramAnonymous2String.dWV.ecE.ecN).hQR == 0)
                  {
                    paramAnonymous2String = ((aka)paramAnonymous2String.dWV.ecF.ecN).kVs;
                    if (!bk.bl(paramAnonymous2String))
                    {
                      paramAnonymous2String = bn.s(paramAnonymous2String, "resourcecontrolinfo");
                      if (paramAnonymous2String != null)
                      {
                        paramAnonymous2m = (String)paramAnonymous2String.get(".resourcecontrolinfo.enableupdate");
                        str = (String)paramAnonymous2String.get(".resourcecontrolinfo.expiredtime");
                        y.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate getDisableUpdateTime values[%s]", new Object[] { paramAnonymous2String });
                        if (bk.getInt(paramAnonymous2m, 1) != 0) {}
                      }
                    }
                  }
                  for (long l1 = bk.getLong(str, 0L);; l1 = 0L)
                  {
                    long l2 = System.currentTimeMillis() / 1000L;
                    if (l1 <= l2) {
                      break;
                    }
                    y.i("MicroMsg.Updater", "summerupdate checkcontrol time[%d] > now[%d] control not auto download and ret", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
                    com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 0L, 1L, true);
                    return;
                  }
                }
                y.i("MicroMsg.Updater", "summerupdate gonna start UpdaterService after checkcontrol");
                com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 59L, 1L, true);
                paramAnonymous2String = new Intent(Updater.this.getContext(), UpdaterService.class);
                Updater.a(Updater.this, paramAnonymous2String, paramAnonymouse, Updater.3.this.udf);
                paramAnonymous2String.putExtra("intent_extra_run_in_foreground", true);
                paramAnonymous2String.putExtra("intent_extra_download_mode", 2);
                Updater.this.getContext().startService(paramAnonymous2String);
              }
            }));
            au.Dk().a(new o(), 0);
            com.tencent.mm.y.c.BS().v(262145, true);
            com.tencent.mm.pluginsdk.model.app.a.ckK();
            return;
          }
          y.i("MicroMsg.Updater", "gonna start AppUpdaterUI");
          localObject = new Intent(Updater.this.getContext(), AppUpdaterUI.class);
          Updater.a(Updater.this, (Intent)localObject, paramAnonymouse, paramString);
          y.i("MicroMsg.Updater", "current updateType : %s", new Object[] { Integer.valueOf(Updater.c(Updater.this)) });
          if (Updater.c(Updater.this) == 1)
          {
            ((Intent)localObject).putExtra("intent_extra_download_mode", 0);
            com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 60L, 1L, true);
          }
          for (;;)
          {
            Updater.this.getContext().startActivity((Intent)localObject);
            break;
            com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 61L, 1L, true);
            ((Intent)localObject).putExtra("intent_extra_download_mode", 1);
          }
        }
      }), 0);
      onStop();
      return;
    }
    com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 62L, 1L, true);
    if (this.ucX != null)
    {
      paramString = this.ucX;
      if (paramString.hox != null) {
        paramString.hox.setVisibility(8);
      }
      paramString = (TextView)this.ucX.findViewById(R.h.mm_progress_dialog_msg);
      if ((paramInt1 != 4) || (paramInt2 != -18)) {
        break label244;
      }
      paramm = new bh();
      com.tencent.mm.sdk.b.a.udP.m(paramm);
      paramm = au.Dk();
      paramString = new com.tencent.mm.ah.f()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
        {
          au.Dk().b(922, Updater.g(Updater.this));
          Updater.a(Updater.this, null);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousm = ((pt)((b)paramAnonymousm.edi).ecF.ecN).sNB;
            paramAnonymousString = new e(paramAnonymousm);
            if ((paramAnonymousm != null) && (paramAnonymousm.tNO == 3))
            {
              paramAnonymousm = new Intent(Updater.this.getContext(), AppUpdaterUI.class);
              if (e.Ft(paramAnonymousString.clientVersion)) {
                if (bk.bl(paramAnonymousString.lnD))
                {
                  paramAnonymousString = "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";
                  paramAnonymousm = new Intent("android.intent.action.VIEW");
                  paramAnonymousm.setClassName(Updater.this.getContext().getPackageName(), Updater.this.getContext().getPackageName() + ".plugin.webview.ui.tools.WebViewUI");
                  paramAnonymousm.putExtra("rawUrl", paramAnonymousString);
                  paramAnonymousm.putExtra("useJs", true);
                  paramAnonymousm.putExtra("vertical_scroll", true);
                  paramAnonymousm.setFlags(872415232);
                  Updater.this.getContext().startActivity(paramAnonymousm);
                  label222:
                  if (Updater.h(Updater.this) != null) {
                    Updater.h(Updater.this).cancel();
                  }
                  Updater.this.onStop();
                }
              }
            }
          }
          do
          {
            do
            {
              return;
              paramAnonymousString = paramAnonymousString.lnD;
              break;
              Updater.this.a(paramAnonymousm, paramAnonymousString);
              Updater.this.getContext().startActivity(paramAnonymousm);
              break label222;
              if (Updater.h(Updater.this).findViewById(R.h.mm_progress_dialog_icon) != null) {
                Updater.h(Updater.this).findViewById(R.h.mm_progress_dialog_icon).setVisibility(8);
              }
            } while (paramString == null);
            com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 63L, 1L, true);
            paramString.setText(R.l.update_noupdate);
            return;
            if (Updater.h(Updater.this).findViewById(R.h.mm_progress_dialog_icon) != null) {
              Updater.h(Updater.this).findViewById(R.h.mm_progress_dialog_icon).setVisibility(8);
            }
          } while (paramString == null);
          com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 63L, 1L, true);
          paramString.setText(R.l.update_noupdate);
        }
      };
      this.udc = paramString;
      paramm.a(922, paramString);
    }
    for (;;)
    {
      i.cqa();
      cancel();
      return;
      label244:
      if (paramString != null)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 64L, 1L, true);
        paramString.setText(R.l.update_err_getinfo);
        j.h(paramString, 1);
      }
    }
  }
  
  public final void onStop()
  {
    com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 43L, 1L, true);
    cancel();
  }
  
  public final void update(int paramInt)
  {
    am(paramInt, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.Updater
 * JD-Core Version:    0.7.0.1
 */