package com.tencent.mm.plugin.updater;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cxu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public class PluginUpdater
  extends f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.updater.a.a
{
  private i gNh;
  private LinkedList<com.tencent.mm.plugin.updater.a.b> ndV;
  
  public PluginUpdater()
  {
    AppMethodBeat.i(194694);
    this.ndV = new LinkedList();
    this.gNh = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        boolean bool2 = true;
        AppMethodBeat.i(194693);
        if ((paramAnonymousq instanceof com.tencent.mm.plugin.updater.model.c))
        {
          paramAnonymousq = (com.tencent.mm.plugin.updater.model.c)paramAnonymousq;
          paramAnonymousString = paramAnonymousq.GwJ;
          com.tencent.mm.util.c localc = com.tencent.mm.util.c.QYz;
          if (Util.getInt(com.tencent.mm.util.c.axY(com.tencent.mm.util.c.np("updater", "openAutoProcessor")), 0) == 1)
          {
            paramAnonymousInt1 = 1;
            if (paramAnonymousInt1 != 0) {
              break label406;
            }
            if ((paramAnonymousString == null) || (!paramAnonymousString.dZw()) || (!paramAnonymousString.dZt()) || (paramAnonymousString.dZx()) || (paramAnonymousString.dZy())) {
              break label387;
            }
            Log.i("MicroMsg.Updater.PluginUpdater", "TinkerSyncResponse packageType:%d", new Object[] { paramAnonymousString.pkI });
            if (paramAnonymousq.source != 0) {
              break label306;
            }
            if (paramAnonymousString.pkI.intValue() != 3) {
              break label282;
            }
          }
          label387:
          for (;;)
          {
            boolean bool1;
            try
            {
              paramAnonymousInt1 = Integer.decode(paramAnonymousString.clientVersion).intValue();
              Log.i("MicroMsg.Updater.PluginUpdater", "save update client version %s %d", new Object[] { paramAnonymousString.clientVersion, Integer.valueOf(paramAnonymousInt1) });
              bool1 = bool2;
              if (paramAnonymousInt1 != 0)
              {
                paramAnonymousq = com.tencent.mm.plugin.updater.model.d.GwL;
                com.tencent.mm.plugin.updater.model.d.fAO().edit().putInt("KeyCurrentUpdateVersion", paramAnonymousInt1).putInt("RedDotCheckUpdateTab", 1).apply();
                bool1 = bool2;
              }
              if (paramAnonymousString == null) {
                Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(2131766944), 0).show();
              }
              paramAnonymousString = PluginUpdater.this.ndV.iterator();
              if (!paramAnonymousString.hasNext()) {
                break label400;
              }
              ((com.tencent.mm.plugin.updater.a.b)paramAnonymousString.next()).uq(bool1);
              continue;
              paramAnonymousInt1 = 0;
            }
            catch (Exception paramAnonymousq)
            {
              paramAnonymousInt1 = 0;
              continue;
            }
            label282:
            if (paramAnonymousString.pkI.intValue() == 2)
            {
              com.tencent.mm.plugin.updater.model.b.GwB.a(paramAnonymousString);
              bool1 = false;
              continue;
              label306:
              if ((paramAnonymousq.source == 1) || (paramAnonymousq.source == 2))
              {
                Log.i("MicroMsg.Updater.PluginUpdater", "handle response source=%d", new Object[] { Integer.valueOf(paramAnonymousq.source) });
                com.tencent.mm.plugin.updater.model.b.GwB.a(paramAnonymousString);
                bool1 = false;
              }
              else
              {
                Log.i("MicroMsg.Updater.PluginUpdater", "not handle response unknown source=%d", new Object[] { Integer.valueOf(paramAnonymousq.source) });
                bool1 = false;
                continue;
                Log.i("MicroMsg.Updater.PluginUpdater", "not handle response");
              }
            }
            else
            {
              bool1 = false;
            }
          }
          label400:
          AppMethodBeat.o(194693);
          return;
          label406:
          Log.i("MicroMsg.Updater.PluginUpdater", "test auto sync processor response");
          MMApplicationContext.getContext();
          com.tencent.mm.plugin.hp.d.d.dZA();
          new com.tencent.mm.plugin.hp.b.e(paramAnonymousString).qk(true);
        }
        AppMethodBeat.o(194693);
      }
    };
    AppMethodBeat.o(194694);
  }
  
  private String getBasePatchId()
  {
    AppMethodBeat.i(194711);
    Object localObject = com.tencent.mm.util.c.QYz;
    if (com.tencent.mm.util.c.hdg())
    {
      localObject = com.tencent.mm.util.c.QYz;
      if (!Util.isNullOrNil(com.tencent.mm.util.c.hdk()))
      {
        localObject = com.tencent.mm.util.c.QYz;
        localObject = com.tencent.mm.util.c.hdk();
        AppMethodBeat.o(194711);
        return localObject;
      }
    }
    localObject = Util.nullAs(com.tencent.mm.loader.j.a.aKw(), "");
    AppMethodBeat.o(194711);
    return localObject;
  }
  
  private LinkedList<cxu> getTinkerConditionList()
  {
    AppMethodBeat.i(194713);
    LinkedList localLinkedList = com.tencent.mm.plugin.hp.net.e.dZe();
    AppMethodBeat.o(194713);
    return localLinkedList;
  }
  
  private String getTinkerPatchId()
  {
    AppMethodBeat.i(194712);
    String str = Util.nullAs(com.tencent.mm.loader.j.a.aKx(), "");
    AppMethodBeat.o(194712);
    return str;
  }
  
  public void addManualCheckUpdateListener(com.tencent.mm.plugin.updater.a.b paramb)
  {
    AppMethodBeat.i(194707);
    this.ndV.add(paramb);
    AppMethodBeat.o(194707);
  }
  
  public void autoCheckUpdate(int paramInt)
  {
    AppMethodBeat.i(194710);
    Log.i("MicroMsg.Updater.PluginUpdater", "autoCheckUpdate %s", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.hp.net.d locald = new com.tencent.mm.plugin.hp.net.d(getBasePatchId(), getTinkerPatchId(), getTinkerConditionList());
    com.tencent.mm.kernel.g.azz().a(locald, 0);
    AppMethodBeat.o(194710);
  }
  
  public void clickAboutWechatRedDot()
  {
    AppMethodBeat.i(194700);
    Log.i("MicroMsg.Updater.PluginUpdater", "clickAboutWechatRedDot");
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.GwL;
    com.tencent.mm.plugin.updater.model.d.fAO().edit().putInt("RedDotAboutWechatTab", 0).putInt("RedDotSettingTab", 0).putInt("RedDotBottomTab", 0).apply();
    AppMethodBeat.o(194700);
  }
  
  public void clickBottomTabRedDot()
  {
    AppMethodBeat.i(194698);
    Log.i("MicroMsg.Updater.PluginUpdater", "clickBottomTabRedDot");
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.GwL;
    com.tencent.mm.plugin.updater.model.d.fAO().edit().putInt("RedDotBottomTab", 0).apply();
    AppMethodBeat.o(194698);
  }
  
  public void clickCheckUpdateRedDot()
  {
    AppMethodBeat.i(194702);
    Log.i("MicroMsg.Updater.PluginUpdater", "clickCheckUpdateRedDot");
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.GwL;
    com.tencent.mm.plugin.updater.model.d.fAO().edit().putInt("RedDotCheckUpdateTab", 0).putInt("RedDotAboutWechatTab", 0).putInt("RedDotSettingTab", 0).putInt("RedDotBottomTab", 0).apply();
    AppMethodBeat.o(194702);
  }
  
  public void clickSettingTabRedDot()
  {
    AppMethodBeat.i(194696);
    Log.i("MicroMsg.Updater.PluginUpdater", "clickSettingTabRedDot");
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.GwL;
    com.tencent.mm.plugin.updater.model.d.fAO().edit().putInt("RedDotSettingTab", 0).putInt("RedDotBottomTab", 0).apply();
    AppMethodBeat.o(194696);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public int getUpdateVersion()
  {
    AppMethodBeat.i(194704);
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.GwL;
    int i = com.tencent.mm.plugin.updater.model.d.fAO().getInt("KeyCurrentUpdateVersion", 0);
    AppMethodBeat.o(194704);
    return i;
  }
  
  public boolean hasAboutWechatRedDot()
  {
    AppMethodBeat.i(194699);
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.GwL;
    if (com.tencent.mm.plugin.updater.model.d.fAO().getInt("RedDotAboutWechatTab", 0) == 1)
    {
      AppMethodBeat.o(194699);
      return true;
    }
    AppMethodBeat.o(194699);
    return false;
  }
  
  public boolean hasBottomTabRedDot()
  {
    AppMethodBeat.i(194697);
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.GwL;
    if (com.tencent.mm.plugin.updater.model.d.fAO().getInt("RedDotBottomTab", 0) == 1)
    {
      AppMethodBeat.o(194697);
      return true;
    }
    AppMethodBeat.o(194697);
    return false;
  }
  
  public boolean hasCheckUpdateTabRedDot()
  {
    AppMethodBeat.i(194701);
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.GwL;
    if (com.tencent.mm.plugin.updater.model.d.fAO().getInt("RedDotCheckUpdateTab", 0) == 1)
    {
      AppMethodBeat.o(194701);
      return true;
    }
    AppMethodBeat.o(194701);
    return false;
  }
  
  public boolean hasSettingTabRedDot()
  {
    AppMethodBeat.i(194695);
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.GwL;
    if (com.tencent.mm.plugin.updater.model.d.fAO().getInt("RedDotSettingTab", 0) == 1)
    {
      AppMethodBeat.o(194695);
      return true;
    }
    AppMethodBeat.o(194695);
    return false;
  }
  
  public void manualCheckUpdate(int paramInt)
  {
    AppMethodBeat.i(194709);
    Log.i("MicroMsg.Updater.PluginUpdater", "manualCheckUpdate %s", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.updater.model.c localc = new com.tencent.mm.plugin.updater.model.c(getBasePatchId(), getTinkerPatchId(), getTinkerConditionList(), paramInt);
    com.tencent.mm.kernel.g.azz().a(localc, 0);
    if (paramInt == 2)
    {
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1429L, 14L, 1L, false);
      AppMethodBeat.o(194709);
      return;
    }
    if (paramInt == 1)
    {
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1429L, 15L, 1L, false);
      AppMethodBeat.o(194709);
      return;
    }
    if (paramInt == 0) {
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1429L, 16L, 1L, false);
    }
    AppMethodBeat.o(194709);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(194705);
    com.tencent.mm.kernel.g.azz().a(3899, this.gNh);
    if (paramc.hrc)
    {
      paramc = com.tencent.mm.plugin.updater.model.d.GwL;
      com.tencent.mm.plugin.updater.model.d.fAO().edit().putInt("RedDotCheckUpdateTab", 0).putInt("RedDotAboutWechatTab", 0).putInt("RedDotSettingTab", 0).putInt("RedDotBottomTab", 0).apply();
    }
    AppMethodBeat.o(194705);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(194706);
    com.tencent.mm.kernel.g.azz().b(3899, this.gNh);
    AppMethodBeat.o(194706);
  }
  
  public boolean openUpdater()
  {
    AppMethodBeat.i(194714);
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.QYz;
    boolean bool;
    if (com.tencent.mm.util.c.hdg())
    {
      localc = com.tencent.mm.util.c.QYz;
      if (Util.getInt(com.tencent.mm.util.c.axY(com.tencent.mm.util.c.np("updater", "openNewUpdater")), 0) == 1) {
        bool = true;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.Updater.PluginUpdater", "openUpdater %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(194714);
      return bool;
      bool = false;
      continue;
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.smB, 0) == 1) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public void removeManualCheckUpdateListener(com.tencent.mm.plugin.updater.a.b paramb)
  {
    AppMethodBeat.i(194708);
    this.ndV.remove(paramb);
    AppMethodBeat.o(194708);
  }
  
  public void setFullCheckUpdateRedDot(int paramInt)
  {
    AppMethodBeat.i(194703);
    Log.i("MicroMsg.Updater.PluginUpdater", "setFullCheckUpdateRedDot %s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt != 0)
    {
      h.CyF.idkeyStat(1429L, 25L, 1L, false);
      com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.GwL;
      com.tencent.mm.plugin.updater.model.d.fAO().edit().putInt("KeyCurrentUpdateVersion", paramInt).putInt("RedDotCheckUpdateTab", 1).putInt("RedDotAboutWechatTab", 1).putInt("RedDotSettingTab", 1).putInt("RedDotBottomTab", 1).apply();
      AppMethodBeat.o(194703);
      return;
    }
    h.CyF.idkeyStat(1429L, 26L, 1L, false);
    AppMethodBeat.o(194703);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.PluginUpdater
 * JD-Core Version:    0.7.0.1
 */