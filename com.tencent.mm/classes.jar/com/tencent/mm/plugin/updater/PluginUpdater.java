package com.tencent.mm.plugin.updater;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.s.c;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.chn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import java.util.Iterator;
import java.util.LinkedList;

public class PluginUpdater
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.updater.a.a
{
  private com.tencent.mm.ak.f ghB;
  private LinkedList<com.tencent.mm.plugin.updater.a.b> lWt;
  
  public PluginUpdater()
  {
    AppMethodBeat.i(197729);
    this.lWt = new LinkedList();
    this.ghB = new com.tencent.mm.ak.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(197728);
        com.tencent.mm.plugin.hp.d.b localb;
        if ((paramAnonymousn instanceof com.tencent.mm.plugin.updater.model.c))
        {
          paramAnonymousString = (com.tencent.mm.plugin.updater.model.c)paramAnonymousn;
          localb = paramAnonymousString.BWe;
          if ((localb != null) && (localb.dfC()) && (localb.dfz()) && (!localb.dfD()) && (!localb.dfE()))
          {
            ae.i("MicroMsg.Updater.PluginUpdater", "TinkerSyncResponse packageType:%d", new Object[] { localb.nZK });
            if (paramAnonymousString.doj == 0) {
              if (localb.nZK.intValue() == 3) {
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
        ae.i("MicroMsg.Updater.PluginUpdater", "save update client version %s %d", new Object[] { localb.clientVersion, Integer.valueOf(paramAnonymousInt1) });
        if (paramAnonymousInt1 != 0)
        {
          paramAnonymousString = com.tencent.mm.plugin.updater.model.d.BWg;
          com.tencent.mm.plugin.updater.model.d.evv().edit().putInt("KeyCurrentUpdateVersion", paramAnonymousInt1).putInt("RedDotCheckUpdateTab", 1).apply();
        }
        bool = true;
        for (;;)
        {
          if (localb == null) {
            Toast.makeText(ak.getContext(), ak.getContext().getString(2131766999), 0).show();
          }
          paramAnonymousString = PluginUpdater.this.lWt.iterator();
          while (paramAnonymousString.hasNext()) {
            ((com.tencent.mm.plugin.updater.a.b)paramAnonymousString.next()).qV(bool);
          }
          if (localb.nZK.intValue() == 2)
          {
            new com.tencent.mm.plugin.hp.b.e(localb).nB(false);
            bool = false;
            continue;
            if ((paramAnonymousString.doj == 1) || (paramAnonymousString.doj == 2))
            {
              ae.i("MicroMsg.Updater.PluginUpdater", "handle response source=%d", new Object[] { Integer.valueOf(paramAnonymousString.doj) });
              paramAnonymousString = com.tencent.mm.plugin.updater.model.b.BVV;
              p.h(localb, "response");
              if (!localb.dfC())
              {
                ae.i(com.tencent.mm.plugin.updater.model.b.TAG, "check response error");
                com.tencent.mm.plugin.report.e.ywz.idkeyStat(1429L, 0L, 1L, false);
                bool = false;
              }
              else if (localb.dfD())
              {
                ae.i(com.tencent.mm.plugin.updater.model.b.TAG, "need to rollback");
                com.tencent.mm.plugin.report.e.ywz.idkeyStat(1429L, 1L, 1L, false);
                com.tencent.mm.plugin.updater.model.b.evr();
                bool = false;
              }
              else if (!localb.dfz())
              {
                ae.i(com.tencent.mm.plugin.updater.model.b.TAG, "check not need to update");
                com.tencent.mm.plugin.report.e.ywz.idkeyStat(1429L, 2L, 1L, false);
                bool = false;
              }
              else if (localb.dfE())
              {
                ae.i(com.tencent.mm.plugin.updater.model.b.TAG, "lower client version");
                com.tencent.mm.plugin.report.e.ywz.idkeyStat(1429L, 3L, 1L, false);
                bool = false;
              }
              else if (com.tencent.mm.sdk.a.b.fnI())
              {
                ae.i(com.tencent.mm.plugin.updater.model.b.TAG, "patch downloading is blocked by assist.");
                bool = false;
              }
              else
              {
                paramAnonymousString = localb.nZK;
                if (paramAnonymousString == null)
                {
                  label497:
                  paramAnonymousString = localb.nZK;
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
                  ae.i(com.tencent.mm.plugin.updater.model.b.TAG, "full apk not support, comming soon");
                  bool = false;
                  break;
                  if (paramAnonymousString.intValue() != 3) {
                    break label497;
                  }
                  ae.i(com.tencent.mm.plugin.updater.model.b.TAG, "handle bspatch");
                  if (com.tencent.mm.plugin.hp.d.c.aor(localb.clientVersion))
                  {
                    ae.i(com.tencent.mm.plugin.updater.model.b.TAG, "handle alpha version " + localb.clientVersion);
                    com.tencent.mm.plugin.report.e.ywz.idkeyStat(1429L, 4L, 1L, false);
                    ae.i(com.tencent.mm.plugin.updater.model.b.TAG, "dealWithAlphaVersion " + localb.clientVersion);
                    Object localObject2 = ak.getContext();
                    if (bu.isNullOrNil(localb.uUW))
                    {
                      paramAnonymousString = ((Context)localObject2).getString(2131755871);
                      if (!bu.isNullOrNil(localb.uUX)) {
                        break label865;
                      }
                      paramAnonymousn = "";
                      if (!bu.isNullOrNil(localb.uUY)) {
                        break label875;
                      }
                    }
                    for (Object localObject1 = "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";; localObject1 = localb.uUY)
                    {
                      Intent localIntent = new Intent("android.intent.action.VIEW");
                      localIntent.setClassName(ak.getPackageName(), ak.getPackageName() + ".plugin.webview.ui.tools.WebViewUI");
                      localIntent.putExtra("rawUrl", (String)localObject1);
                      localIntent.putExtra("useJs", true);
                      localIntent.putExtra("vertical_scroll", true);
                      localIntent.setFlags(872415232);
                      localObject1 = PendingIntent.getActivity((Context)localObject2, 0, localIntent, 268435456);
                      localObject2 = com.tencent.mm.bq.a.bJ((Context)localObject2, "reminder_channel_id").i(null).i(System.currentTimeMillis()).f((CharSequence)paramAnonymousString).g((CharSequence)paramAnonymousn);
                      ((s.c)localObject2).Hl = ((PendingIntent)localObject1);
                      p.g(localObject2, "NotificationHelper.getNo…tentIntent(pendingIntent)");
                      ((s.c)localObject2).as(com.tencent.mm.bq.a.dzu());
                      p.g(paramAnonymousString, "title");
                      p.g(paramAnonymousn, "text");
                      com.tencent.mm.plugin.updater.model.b.a(paramAnonymousString, paramAnonymousn, (PendingIntent)localObject1);
                      bool = false;
                      break;
                      paramAnonymousString = localb.uUW;
                      break label640;
                      paramAnonymousn = localb.uUX;
                      break label656;
                    }
                  }
                  if (!com.tencent.mm.plugin.updater.model.b.b(localb))
                  {
                    com.tencent.mm.plugin.report.e.ywz.idkeyStat(1429L, 6L, 1L, false);
                    com.tencent.mm.plugin.updater.model.b.a(localb);
                  }
                  bool = false;
                  break;
                }
                label918:
                ae.i(com.tencent.mm.plugin.updater.model.b.TAG, "handle hotpatch");
                com.tencent.mm.plugin.updater.model.b.a(localb);
                com.tencent.mm.plugin.report.e.ywz.idkeyStat(1429L, 7L, 1L, false);
                bool = false;
              }
            }
            else
            {
              ae.i("MicroMsg.Updater.PluginUpdater", "not handle response unknown source=%d", new Object[] { Integer.valueOf(paramAnonymousString.doj) });
              bool = false;
              continue;
              ae.i("MicroMsg.Updater.PluginUpdater", "not handle response");
            }
          }
          else
          {
            bool = false;
          }
        }
        AppMethodBeat.o(197728);
      }
    };
    AppMethodBeat.o(197729);
  }
  
  private String getBasePatchId()
  {
    int j = 1;
    AppMethodBeat.i(197746);
    Object localObject = com.tencent.mm.util.c.LDf;
    if (com.tencent.mm.util.c.aZw(com.tencent.mm.util.c.mz("testUpdate", "testBSDiff")) == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(197746);
      return "tinker_id_8d1ef6614c959cc7613ddfb7b8ce13674e91a3cf_arm64-v8a";
    }
    localObject = com.tencent.mm.util.c.LDf;
    if (com.tencent.mm.util.c.aZw(com.tencent.mm.util.c.mz("testUpdate", "testHotPatch")) == 1) {}
    for (i = j; i != 0; i = 0)
    {
      AppMethodBeat.o(197746);
      return "tinker_id_f27acdfef08d000160f65a8f43f2c2fc656b5ae2_arm64-v8a";
    }
    localObject = bu.bI(com.tencent.mm.loader.j.a.arW(), "");
    AppMethodBeat.o(197746);
    return localObject;
  }
  
  private LinkedList<chn> getTinkerConditionList()
  {
    AppMethodBeat.i(197748);
    LinkedList localLinkedList = com.tencent.mm.plugin.hp.net.e.dfk();
    AppMethodBeat.o(197748);
    return localLinkedList;
  }
  
  private String getTinkerPatchId()
  {
    AppMethodBeat.i(197747);
    String str = bu.bI(com.tencent.mm.loader.j.a.arX(), "");
    AppMethodBeat.o(197747);
    return str;
  }
  
  public void addManualCheckUpdateListener(com.tencent.mm.plugin.updater.a.b paramb)
  {
    AppMethodBeat.i(197742);
    this.lWt.add(paramb);
    AppMethodBeat.o(197742);
  }
  
  public void autoCheckUpdate(int paramInt)
  {
    AppMethodBeat.i(197745);
    ae.i("MicroMsg.Updater.PluginUpdater", "autoCheckUpdate %s", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.hp.net.d locald = new com.tencent.mm.plugin.hp.net.d(getBasePatchId(), getTinkerPatchId(), getTinkerConditionList());
    com.tencent.mm.kernel.g.ajj().a(locald, 0);
    AppMethodBeat.o(197745);
  }
  
  public void clickAboutWechatRedDot()
  {
    AppMethodBeat.i(197735);
    ae.i("MicroMsg.Updater.PluginUpdater", "clickAboutWechatRedDot");
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.BWg;
    com.tencent.mm.plugin.updater.model.d.evv().edit().putInt("RedDotAboutWechatTab", 0).putInt("RedDotSettingTab", 0).putInt("RedDotBottomTab", 0).apply();
    AppMethodBeat.o(197735);
  }
  
  public void clickBottomTabRedDot()
  {
    AppMethodBeat.i(197733);
    ae.i("MicroMsg.Updater.PluginUpdater", "clickBottomTabRedDot");
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.BWg;
    com.tencent.mm.plugin.updater.model.d.evv().edit().putInt("RedDotBottomTab", 0).apply();
    AppMethodBeat.o(197733);
  }
  
  public void clickCheckUpdateRedDot()
  {
    AppMethodBeat.i(197737);
    ae.i("MicroMsg.Updater.PluginUpdater", "clickCheckUpdateRedDot");
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.BWg;
    com.tencent.mm.plugin.updater.model.d.evv().edit().putInt("RedDotCheckUpdateTab", 0).putInt("RedDotAboutWechatTab", 0).putInt("RedDotSettingTab", 0).putInt("RedDotBottomTab", 0).apply();
    AppMethodBeat.o(197737);
  }
  
  public void clickSettingTabRedDot()
  {
    AppMethodBeat.i(197731);
    ae.i("MicroMsg.Updater.PluginUpdater", "clickSettingTabRedDot");
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.BWg;
    com.tencent.mm.plugin.updater.model.d.evv().edit().putInt("RedDotSettingTab", 0).putInt("RedDotBottomTab", 0).apply();
    AppMethodBeat.o(197731);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public int getUpdateVersion()
  {
    AppMethodBeat.i(197739);
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.BWg;
    int i = com.tencent.mm.plugin.updater.model.d.evv().getInt("KeyCurrentUpdateVersion", 0);
    AppMethodBeat.o(197739);
    return i;
  }
  
  public boolean hasAboutWechatRedDot()
  {
    AppMethodBeat.i(197734);
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.BWg;
    if (com.tencent.mm.plugin.updater.model.d.evv().getInt("RedDotAboutWechatTab", 0) == 1)
    {
      AppMethodBeat.o(197734);
      return true;
    }
    AppMethodBeat.o(197734);
    return false;
  }
  
  public boolean hasBottomTabRedDot()
  {
    AppMethodBeat.i(197732);
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.BWg;
    if (com.tencent.mm.plugin.updater.model.d.evv().getInt("RedDotBottomTab", 0) == 1)
    {
      AppMethodBeat.o(197732);
      return true;
    }
    AppMethodBeat.o(197732);
    return false;
  }
  
  public boolean hasCheckUpdateTabRedDot()
  {
    AppMethodBeat.i(197736);
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.BWg;
    if (com.tencent.mm.plugin.updater.model.d.evv().getInt("RedDotCheckUpdateTab", 0) == 1)
    {
      AppMethodBeat.o(197736);
      return true;
    }
    AppMethodBeat.o(197736);
    return false;
  }
  
  public boolean hasSettingTabRedDot()
  {
    AppMethodBeat.i(197730);
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.BWg;
    if (com.tencent.mm.plugin.updater.model.d.evv().getInt("RedDotSettingTab", 0) == 1)
    {
      AppMethodBeat.o(197730);
      return true;
    }
    AppMethodBeat.o(197730);
    return false;
  }
  
  public void manualCheckUpdate(int paramInt)
  {
    AppMethodBeat.i(197744);
    ae.i("MicroMsg.Updater.PluginUpdater", "manualCheckUpdate %s", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.updater.model.c localc = new com.tencent.mm.plugin.updater.model.c(getBasePatchId(), getTinkerPatchId(), getTinkerConditionList(), paramInt);
    com.tencent.mm.kernel.g.ajj().a(localc, 0);
    if (paramInt == 2)
    {
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1429L, 14L, 1L, false);
      AppMethodBeat.o(197744);
      return;
    }
    if (paramInt == 1)
    {
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1429L, 15L, 1L, false);
      AppMethodBeat.o(197744);
      return;
    }
    if (paramInt == 0) {
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1429L, 16L, 1L, false);
    }
    AppMethodBeat.o(197744);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(197740);
    com.tencent.mm.kernel.g.ajj().a(3899, this.ghB);
    if (paramc.gEo)
    {
      paramc = com.tencent.mm.plugin.updater.model.d.BWg;
      com.tencent.mm.plugin.updater.model.d.evv().edit().putInt("RedDotCheckUpdateTab", 0).putInt("RedDotAboutWechatTab", 0).putInt("RedDotSettingTab", 0).putInt("RedDotBottomTab", 0).apply();
    }
    AppMethodBeat.o(197740);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(197741);
    com.tencent.mm.kernel.g.ajj().b(3899, this.ghB);
    AppMethodBeat.o(197741);
  }
  
  public boolean openUpdater()
  {
    AppMethodBeat.i(197749);
    com.tencent.mm.plugin.expt.b.b localb = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class);
    b.a locala = b.a.qPs;
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.LDf;
    if (localb.a(locala, com.tencent.mm.util.c.fSe()) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.Updater.PluginUpdater", "openUpdater %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(197749);
      return bool;
    }
  }
  
  public void removeManualCheckUpdateListener(com.tencent.mm.plugin.updater.a.b paramb)
  {
    AppMethodBeat.i(197743);
    this.lWt.remove(paramb);
    AppMethodBeat.o(197743);
  }
  
  public void setFullCheckUpdateRedDot(int paramInt)
  {
    AppMethodBeat.i(197738);
    ae.i("MicroMsg.Updater.PluginUpdater", "setFullCheckUpdateRedDot %s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt != 0)
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1429L, 25L, 1L, false);
      com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.BWg;
      com.tencent.mm.plugin.updater.model.d.evv().edit().putInt("KeyCurrentUpdateVersion", paramInt).putInt("RedDotCheckUpdateTab", 1).putInt("RedDotAboutWechatTab", 1).putInt("RedDotSettingTab", 1).putInt("RedDotBottomTab", 1).apply();
      AppMethodBeat.o(197738);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1429L, 26L, 1L, false);
    AppMethodBeat.o(197738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.PluginUpdater
 * JD-Core Version:    0.7.0.1
 */