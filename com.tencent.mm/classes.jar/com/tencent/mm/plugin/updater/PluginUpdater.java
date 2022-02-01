package com.tencent.mm.plugin.updater;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.s.c;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.cgt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import java.util.Iterator;
import java.util.LinkedList;

public class PluginUpdater
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.updater.a.a
{
  private com.tencent.mm.al.f hPn;
  private LinkedList<com.tencent.mm.plugin.updater.a.b> lRS;
  
  public PluginUpdater()
  {
    AppMethodBeat.i(214516);
    this.lRS = new LinkedList();
    this.hPn = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(214515);
        com.tencent.mm.plugin.hp.d.b localb;
        if ((paramAnonymousn instanceof com.tencent.mm.plugin.updater.model.c))
        {
          paramAnonymousString = (com.tencent.mm.plugin.updater.model.c)paramAnonymousn;
          localb = paramAnonymousString.BEG;
          if ((localb != null) && (localb.dcK()) && (localb.dcH()) && (!localb.dcL()) && (!localb.dcM()))
          {
            ad.i("MicroMsg.Updater.PluginUpdater", "TinkerSyncResponse packageType:%d", new Object[] { localb.nUe });
            if (paramAnonymousString.dnh == 0) {
              if (localb.nUe.intValue() == 3) {
                paramAnonymousInt1 = 0;
              }
            }
          }
        }
        try
        {
          paramAnonymousInt2 = Integer.decode(localb.clientVersion).intValue();
          paramAnonymousInt1 = paramAnonymousInt2;
        }
        catch (Exception paramAnonymousString)
        {
          label116:
          boolean bool;
          break label116;
        }
        ad.i("MicroMsg.Updater.PluginUpdater", "save update client version %s %d", new Object[] { localb.clientVersion, Integer.valueOf(paramAnonymousInt1) });
        if (paramAnonymousInt1 != 0)
        {
          paramAnonymousString = com.tencent.mm.plugin.updater.model.d.BEI;
          com.tencent.mm.plugin.updater.model.d.erO().edit().putInt("KeyCurrentUpdateVersion", paramAnonymousInt1).putInt("RedDotCheckUpdateTab", 1).apply();
        }
        bool = true;
        for (;;)
        {
          if (localb == null) {
            Toast.makeText(aj.getContext(), aj.getContext().getString(2131766999), 0).show();
          }
          paramAnonymousString = PluginUpdater.this.lRS.iterator();
          while (paramAnonymousString.hasNext()) {
            ((com.tencent.mm.plugin.updater.a.b)paramAnonymousString.next()).qO(bool);
          }
          if (localb.nUe.intValue() == 2)
          {
            new com.tencent.mm.plugin.hp.b.e(localb).nx(false);
            bool = false;
            continue;
            if ((paramAnonymousString.dnh == 1) || (paramAnonymousString.dnh == 2))
            {
              ad.i("MicroMsg.Updater.PluginUpdater", "handle response source=%d", new Object[] { Integer.valueOf(paramAnonymousString.dnh) });
              paramAnonymousString = com.tencent.mm.plugin.updater.model.b.BEx;
              p.h(localb, "response");
              if (!localb.dcK())
              {
                ad.i(com.tencent.mm.plugin.updater.model.b.TAG, "check response error");
                com.tencent.mm.plugin.report.e.ygI.idkeyStat(1429L, 0L, 1L, false);
                bool = false;
              }
              else if (localb.dcL())
              {
                ad.i(com.tencent.mm.plugin.updater.model.b.TAG, "need to rollback");
                com.tencent.mm.plugin.report.e.ygI.idkeyStat(1429L, 1L, 1L, false);
                com.tencent.mm.plugin.updater.model.b.erK();
                bool = false;
              }
              else if (!localb.dcH())
              {
                ad.i(com.tencent.mm.plugin.updater.model.b.TAG, "check not need to update");
                com.tencent.mm.plugin.report.e.ygI.idkeyStat(1429L, 2L, 1L, false);
                bool = false;
              }
              else if (localb.dcM())
              {
                ad.i(com.tencent.mm.plugin.updater.model.b.TAG, "lower client version");
                com.tencent.mm.plugin.report.e.ygI.idkeyStat(1429L, 3L, 1L, false);
                bool = false;
              }
              else if (com.tencent.mm.sdk.a.b.fjQ())
              {
                ad.i(com.tencent.mm.plugin.updater.model.b.TAG, "patch downloading is blocked by assist.");
                bool = false;
              }
              else
              {
                paramAnonymousString = localb.nUe;
                if (paramAnonymousString == null)
                {
                  label497:
                  paramAnonymousString = localb.nUe;
                  if (paramAnonymousString != null) {
                    break label918;
                  }
                }
                label640:
                label656:
                label865:
                label875:
                while (paramAnonymousString.intValue() != 2)
                {
                  ad.i(com.tencent.mm.plugin.updater.model.b.TAG, "full apk not support, comming soon");
                  bool = false;
                  break;
                  if (paramAnonymousString.intValue() != 3) {
                    break label497;
                  }
                  ad.i(com.tencent.mm.plugin.updater.model.b.TAG, "handle bspatch");
                  if (com.tencent.mm.plugin.hp.d.c.anp(localb.clientVersion))
                  {
                    ad.i(com.tencent.mm.plugin.updater.model.b.TAG, "handle alpha version " + localb.clientVersion);
                    com.tencent.mm.plugin.report.e.ygI.idkeyStat(1429L, 4L, 1L, false);
                    ad.i(com.tencent.mm.plugin.updater.model.b.TAG, "dealWithAlphaVersion " + localb.clientVersion);
                    Object localObject2 = aj.getContext();
                    if (bt.isNullOrNil(localb.uJj))
                    {
                      paramAnonymousString = ((Context)localObject2).getString(2131755871);
                      if (!bt.isNullOrNil(localb.uJk)) {
                        break label865;
                      }
                      paramAnonymousn = "";
                      if (!bt.isNullOrNil(localb.uJl)) {
                        break label875;
                      }
                    }
                    for (Object localObject1 = "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";; localObject1 = localb.uJl)
                    {
                      Intent localIntent = new Intent("android.intent.action.VIEW");
                      localIntent.setClassName(aj.getPackageName(), aj.getPackageName() + ".plugin.webview.ui.tools.WebViewUI");
                      localIntent.putExtra("rawUrl", (String)localObject1);
                      localIntent.putExtra("useJs", true);
                      localIntent.putExtra("vertical_scroll", true);
                      localIntent.setFlags(872415232);
                      localObject1 = PendingIntent.getActivity((Context)localObject2, 0, localIntent, 268435456);
                      localObject2 = com.tencent.mm.br.a.bI((Context)localObject2, "reminder_channel_id").i(null).i(System.currentTimeMillis()).f((CharSequence)paramAnonymousString).g((CharSequence)paramAnonymousn);
                      ((s.c)localObject2).Hl = ((PendingIntent)localObject1);
                      p.g(localObject2, "NotificationHelper.getNo…tentIntent(pendingIntent)");
                      ((s.c)localObject2).as(com.tencent.mm.br.a.dwe());
                      p.g(paramAnonymousString, "title");
                      p.g(paramAnonymousn, "text");
                      com.tencent.mm.plugin.updater.model.b.a(paramAnonymousString, paramAnonymousn, (PendingIntent)localObject1);
                      bool = false;
                      break;
                      paramAnonymousString = localb.uJj;
                      break label640;
                      paramAnonymousn = localb.uJk;
                      break label656;
                    }
                  }
                  if (!com.tencent.mm.plugin.updater.model.b.b(localb))
                  {
                    com.tencent.mm.plugin.report.e.ygI.idkeyStat(1429L, 6L, 1L, false);
                    com.tencent.mm.plugin.updater.model.b.a(localb);
                  }
                  bool = false;
                  break;
                }
                label918:
                ad.i(com.tencent.mm.plugin.updater.model.b.TAG, "handle hotpatch");
                com.tencent.mm.plugin.updater.model.b.a(localb);
                com.tencent.mm.plugin.report.e.ygI.idkeyStat(1429L, 7L, 1L, false);
                bool = false;
              }
            }
            else
            {
              ad.i("MicroMsg.Updater.PluginUpdater", "not handle response unknown source=%d", new Object[] { Integer.valueOf(paramAnonymousString.dnh) });
              bool = false;
              continue;
              ad.i("MicroMsg.Updater.PluginUpdater", "not handle response");
            }
          }
          else
          {
            bool = false;
          }
        }
        AppMethodBeat.o(214515);
      }
    };
    AppMethodBeat.o(214516);
  }
  
  private String getBasePatchId()
  {
    int j = 1;
    AppMethodBeat.i(214533);
    Object localObject = com.tencent.mm.util.c.LgD;
    if (com.tencent.mm.util.c.aXU(com.tencent.mm.util.c.ms("testUpdate", "testBSDiff")) == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(214533);
      return "tinker_id_8d1ef6614c959cc7613ddfb7b8ce13674e91a3cf_arm64-v8a";
    }
    localObject = com.tencent.mm.util.c.LgD;
    if (com.tencent.mm.util.c.aXU(com.tencent.mm.util.c.ms("testUpdate", "testHotPatch")) == 1) {}
    for (i = j; i != 0; i = 0)
    {
      AppMethodBeat.o(214533);
      return "tinker_id_f27acdfef08d000160f65a8f43f2c2fc656b5ae2_arm64-v8a";
    }
    localObject = bt.bI(com.tencent.mm.loader.j.a.arH(), "");
    AppMethodBeat.o(214533);
    return localObject;
  }
  
  private LinkedList<cgt> getTinkerConditionList()
  {
    AppMethodBeat.i(214535);
    LinkedList localLinkedList = com.tencent.mm.plugin.hp.net.e.dcs();
    AppMethodBeat.o(214535);
    return localLinkedList;
  }
  
  private String getTinkerPatchId()
  {
    AppMethodBeat.i(214534);
    String str = bt.bI(com.tencent.mm.loader.j.a.arI(), "");
    AppMethodBeat.o(214534);
    return str;
  }
  
  public void addManualCheckUpdateListener(com.tencent.mm.plugin.updater.a.b paramb)
  {
    AppMethodBeat.i(214529);
    this.lRS.add(paramb);
    AppMethodBeat.o(214529);
  }
  
  public void autoCheckUpdate(int paramInt)
  {
    AppMethodBeat.i(214532);
    ad.i("MicroMsg.Updater.PluginUpdater", "autoCheckUpdate %s", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.hp.net.d locald = new com.tencent.mm.plugin.hp.net.d(getBasePatchId(), getTinkerPatchId(), getTinkerConditionList());
    com.tencent.mm.kernel.g.aiU().a(locald, 0);
    AppMethodBeat.o(214532);
  }
  
  public void clickAboutWechatRedDot()
  {
    AppMethodBeat.i(214522);
    ad.i("MicroMsg.Updater.PluginUpdater", "clickAboutWechatRedDot");
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.BEI;
    com.tencent.mm.plugin.updater.model.d.erO().edit().putInt("RedDotAboutWechatTab", 0).putInt("RedDotSettingTab", 0).putInt("RedDotBottomTab", 0).apply();
    AppMethodBeat.o(214522);
  }
  
  public void clickBottomTabRedDot()
  {
    AppMethodBeat.i(214520);
    ad.i("MicroMsg.Updater.PluginUpdater", "clickBottomTabRedDot");
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.BEI;
    com.tencent.mm.plugin.updater.model.d.erO().edit().putInt("RedDotBottomTab", 0).apply();
    AppMethodBeat.o(214520);
  }
  
  public void clickCheckUpdateRedDot()
  {
    AppMethodBeat.i(214524);
    ad.i("MicroMsg.Updater.PluginUpdater", "clickCheckUpdateRedDot");
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.BEI;
    com.tencent.mm.plugin.updater.model.d.erO().edit().putInt("RedDotCheckUpdateTab", 0).putInt("RedDotAboutWechatTab", 0).putInt("RedDotSettingTab", 0).putInt("RedDotBottomTab", 0).apply();
    AppMethodBeat.o(214524);
  }
  
  public void clickSettingTabRedDot()
  {
    AppMethodBeat.i(214518);
    ad.i("MicroMsg.Updater.PluginUpdater", "clickSettingTabRedDot");
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.BEI;
    com.tencent.mm.plugin.updater.model.d.erO().edit().putInt("RedDotSettingTab", 0).putInt("RedDotBottomTab", 0).apply();
    AppMethodBeat.o(214518);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public int getUpdateVersion()
  {
    AppMethodBeat.i(214526);
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.BEI;
    int i = com.tencent.mm.plugin.updater.model.d.erO().getInt("KeyCurrentUpdateVersion", 0);
    AppMethodBeat.o(214526);
    return i;
  }
  
  public boolean hasAboutWechatRedDot()
  {
    AppMethodBeat.i(214521);
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.BEI;
    if (com.tencent.mm.plugin.updater.model.d.erO().getInt("RedDotAboutWechatTab", 0) == 1)
    {
      AppMethodBeat.o(214521);
      return true;
    }
    AppMethodBeat.o(214521);
    return false;
  }
  
  public boolean hasBottomTabRedDot()
  {
    AppMethodBeat.i(214519);
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.BEI;
    if (com.tencent.mm.plugin.updater.model.d.erO().getInt("RedDotBottomTab", 0) == 1)
    {
      AppMethodBeat.o(214519);
      return true;
    }
    AppMethodBeat.o(214519);
    return false;
  }
  
  public boolean hasCheckUpdateTabRedDot()
  {
    AppMethodBeat.i(214523);
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.BEI;
    if (com.tencent.mm.plugin.updater.model.d.erO().getInt("RedDotCheckUpdateTab", 0) == 1)
    {
      AppMethodBeat.o(214523);
      return true;
    }
    AppMethodBeat.o(214523);
    return false;
  }
  
  public boolean hasSettingTabRedDot()
  {
    AppMethodBeat.i(214517);
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.BEI;
    if (com.tencent.mm.plugin.updater.model.d.erO().getInt("RedDotSettingTab", 0) == 1)
    {
      AppMethodBeat.o(214517);
      return true;
    }
    AppMethodBeat.o(214517);
    return false;
  }
  
  public void manualCheckUpdate(int paramInt)
  {
    AppMethodBeat.i(214531);
    ad.i("MicroMsg.Updater.PluginUpdater", "manualCheckUpdate %s", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.updater.model.c localc = new com.tencent.mm.plugin.updater.model.c(getBasePatchId(), getTinkerPatchId(), getTinkerConditionList(), paramInt);
    com.tencent.mm.kernel.g.aiU().a(localc, 0);
    if (paramInt == 2)
    {
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1429L, 14L, 1L, false);
      AppMethodBeat.o(214531);
      return;
    }
    if (paramInt == 1)
    {
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1429L, 15L, 1L, false);
      AppMethodBeat.o(214531);
      return;
    }
    if (paramInt == 0) {
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1429L, 16L, 1L, false);
    }
    AppMethodBeat.o(214531);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(214527);
    com.tencent.mm.kernel.g.aiU().a(3899, this.hPn);
    if (paramc.gBH)
    {
      paramc = com.tencent.mm.plugin.updater.model.d.BEI;
      com.tencent.mm.plugin.updater.model.d.erO().edit().putInt("RedDotAboutWechatTab", 0).putInt("RedDotSettingTab", 0).putInt("RedDotBottomTab", 0).apply();
    }
    AppMethodBeat.o(214527);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(214528);
    com.tencent.mm.kernel.g.aiU().b(3899, this.hPn);
    AppMethodBeat.o(214528);
  }
  
  public boolean openUpdater()
  {
    AppMethodBeat.i(214536);
    com.tencent.mm.plugin.expt.b.b localb = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class);
    b.a locala = b.a.qHM;
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.LgD;
    if (localb.a(locala, com.tencent.mm.util.c.fNJ()) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.Updater.PluginUpdater", "openUpdater %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(214536);
      return bool;
    }
  }
  
  public void removeManualCheckUpdateListener(com.tencent.mm.plugin.updater.a.b paramb)
  {
    AppMethodBeat.i(214530);
    this.lRS.remove(paramb);
    AppMethodBeat.o(214530);
  }
  
  public void setFullCheckUpdateRedDot(int paramInt)
  {
    AppMethodBeat.i(214525);
    ad.i("MicroMsg.Updater.PluginUpdater", "setFullCheckUpdateRedDot");
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.BEI;
    com.tencent.mm.plugin.updater.model.d.erO().edit().putInt("KeyCurrentUpdateVersion", paramInt).putInt("RedDotCheckUpdateTab", 1).putInt("RedDotAboutWechatTab", 1).putInt("RedDotSettingTab", 1).putInt("RedDotBottomTab", 1).apply();
    AppMethodBeat.o(214525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.PluginUpdater
 * JD-Core Version:    0.7.0.1
 */