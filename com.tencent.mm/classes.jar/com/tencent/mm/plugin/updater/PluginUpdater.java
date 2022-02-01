package com.tencent.mm.plugin.updater;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.hp.net.e;
import com.tencent.mm.protocal.protobuf.dhf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public class PluginUpdater
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.updater.a.a
{
  private com.tencent.mm.an.i jxB;
  private LinkedList<com.tencent.mm.plugin.updater.a.b> qem;
  
  public PluginUpdater()
  {
    AppMethodBeat.i(195964);
    this.qem = new LinkedList();
    this.jxB = new com.tencent.mm.an.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        boolean bool2 = true;
        AppMethodBeat.i(196070);
        if ((paramAnonymousq instanceof com.tencent.mm.plugin.updater.model.c))
        {
          paramAnonymousq = (com.tencent.mm.plugin.updater.model.c)paramAnonymousq;
          paramAnonymousString = paramAnonymousq.Nkc;
          if ((paramAnonymousString != null) && (paramAnonymousString.eIt()) && (paramAnonymousString.eIq()) && (!paramAnonymousString.eIu()) && (!paramAnonymousString.eIv()))
          {
            Log.i("MicroMsg.Updater.PluginUpdater", "TinkerSyncResponse packageType:%d", new Object[] { paramAnonymousString.smR });
            if (paramAnonymousq.source == 0) {
              if (paramAnonymousString.smR.intValue() != 3) {}
            }
          }
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
                paramAnonymousq = com.tencent.mm.plugin.updater.model.d.Nke;
                com.tencent.mm.plugin.updater.model.d.gsP().edit().putInt("KeyCurrentUpdateVersion", paramAnonymousInt1).putInt("RedDotCheckUpdateTab", 1).apply();
                bool1 = bool2;
              }
              if (paramAnonymousString == null) {
                Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(a.c.updater_not_patch), 0).show();
              }
              paramAnonymousString = PluginUpdater.this.qem.iterator();
              if (!paramAnonymousString.hasNext()) {
                break;
              }
              ((com.tencent.mm.plugin.updater.a.b)paramAnonymousString.next()).xO(bool1);
              continue;
            }
            catch (Exception paramAnonymousq)
            {
              paramAnonymousInt1 = 0;
              continue;
            }
            if (paramAnonymousString.smR.intValue() == 2)
            {
              com.tencent.mm.plugin.updater.model.b.NjU.a(paramAnonymousString);
              bool1 = false;
              continue;
              if ((paramAnonymousq.source == 1) || (paramAnonymousq.source == 2))
              {
                Log.i("MicroMsg.Updater.PluginUpdater", "handle response source=%d", new Object[] { Integer.valueOf(paramAnonymousq.source) });
                com.tencent.mm.plugin.updater.model.b.NjU.a(paramAnonymousString);
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
        }
        AppMethodBeat.o(196070);
      }
    };
    AppMethodBeat.o(195964);
  }
  
  private String getBasePatchId()
  {
    AppMethodBeat.i(195992);
    Object localObject = com.tencent.mm.util.d.YyA;
    if (com.tencent.mm.util.d.ien())
    {
      localObject = com.tencent.mm.util.i.YyX;
      localObject = com.tencent.mm.util.i.a(com.tencent.mm.util.b.a.Yyp, "");
      if (!Util.isNullOrNil((String)localObject))
      {
        AppMethodBeat.o(195992);
        return localObject;
      }
    }
    localObject = Util.nullAs(com.tencent.mm.loader.j.a.aSy(), "");
    AppMethodBeat.o(195992);
    return localObject;
  }
  
  private LinkedList<dhf> getTinkerConditionList()
  {
    AppMethodBeat.i(195995);
    LinkedList localLinkedList = e.eIb();
    AppMethodBeat.o(195995);
    return localLinkedList;
  }
  
  private String getTinkerPatchId()
  {
    AppMethodBeat.i(195994);
    String str = Util.nullAs(com.tencent.mm.loader.j.a.aSz(), "");
    AppMethodBeat.o(195994);
    return str;
  }
  
  public void addManualCheckUpdateListener(com.tencent.mm.plugin.updater.a.b paramb)
  {
    AppMethodBeat.i(195983);
    this.qem.add(paramb);
    AppMethodBeat.o(195983);
  }
  
  public void autoCheckUpdate(int paramInt)
  {
    AppMethodBeat.i(195990);
    Log.i("MicroMsg.Updater.PluginUpdater", "autoCheckUpdate %s", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.hp.net.d locald = new com.tencent.mm.plugin.hp.net.d(getBasePatchId(), getTinkerPatchId(), getTinkerConditionList());
    com.tencent.mm.kernel.h.aGY().a(locald, 0);
    AppMethodBeat.o(195990);
  }
  
  public void clickAboutWechatRedDot()
  {
    AppMethodBeat.i(195971);
    Log.i("MicroMsg.Updater.PluginUpdater", "clickAboutWechatRedDot");
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.Nke;
    com.tencent.mm.plugin.updater.model.d.gsP().edit().putInt("RedDotAboutWechatTab", 0).putInt("RedDotSettingTab", 0).putInt("RedDotBottomTab", 0).apply();
    AppMethodBeat.o(195971);
  }
  
  public void clickBottomTabRedDot()
  {
    AppMethodBeat.i(195969);
    Log.i("MicroMsg.Updater.PluginUpdater", "clickBottomTabRedDot");
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.Nke;
    com.tencent.mm.plugin.updater.model.d.gsP().edit().putInt("RedDotBottomTab", 0).apply();
    AppMethodBeat.o(195969);
  }
  
  public void clickCheckUpdateRedDot()
  {
    AppMethodBeat.i(195975);
    Log.i("MicroMsg.Updater.PluginUpdater", "clickCheckUpdateRedDot");
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.Nke;
    com.tencent.mm.plugin.updater.model.d.gsP().edit().putInt("RedDotCheckUpdateTab", 0).putInt("RedDotAboutWechatTab", 0).putInt("RedDotSettingTab", 0).putInt("RedDotBottomTab", 0).apply();
    AppMethodBeat.o(195975);
  }
  
  public void clickSettingTabRedDot()
  {
    AppMethodBeat.i(195966);
    Log.i("MicroMsg.Updater.PluginUpdater", "clickSettingTabRedDot");
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.Nke;
    com.tencent.mm.plugin.updater.model.d.gsP().edit().putInt("RedDotSettingTab", 0).putInt("RedDotBottomTab", 0).apply();
    AppMethodBeat.o(195966);
  }
  
  public void execute(g paramg) {}
  
  public int getUpdateVersion()
  {
    AppMethodBeat.i(195980);
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.Nke;
    int i = com.tencent.mm.plugin.updater.model.d.gsP().getInt("KeyCurrentUpdateVersion", 0);
    AppMethodBeat.o(195980);
    return i;
  }
  
  public boolean hasAboutWechatRedDot()
  {
    AppMethodBeat.i(195970);
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.Nke;
    if (com.tencent.mm.plugin.updater.model.d.gsP().getInt("RedDotAboutWechatTab", 0) == 1)
    {
      AppMethodBeat.o(195970);
      return true;
    }
    AppMethodBeat.o(195970);
    return false;
  }
  
  public boolean hasBottomTabRedDot()
  {
    AppMethodBeat.i(195967);
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.Nke;
    if (com.tencent.mm.plugin.updater.model.d.gsP().getInt("RedDotBottomTab", 0) == 1)
    {
      AppMethodBeat.o(195967);
      return true;
    }
    AppMethodBeat.o(195967);
    return false;
  }
  
  public boolean hasCheckUpdateTabRedDot()
  {
    AppMethodBeat.i(195974);
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.Nke;
    if (com.tencent.mm.plugin.updater.model.d.gsP().getInt("RedDotCheckUpdateTab", 0) == 1)
    {
      AppMethodBeat.o(195974);
      return true;
    }
    AppMethodBeat.o(195974);
    return false;
  }
  
  public boolean hasSettingTabRedDot()
  {
    AppMethodBeat.i(195965);
    com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.Nke;
    if (com.tencent.mm.plugin.updater.model.d.gsP().getInt("RedDotSettingTab", 0) == 1)
    {
      AppMethodBeat.o(195965);
      return true;
    }
    AppMethodBeat.o(195965);
    return false;
  }
  
  public void manualCheckUpdate(int paramInt)
  {
    AppMethodBeat.i(195986);
    Log.i("MicroMsg.Updater.PluginUpdater", "manualCheckUpdate %s", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.updater.model.c localc = new com.tencent.mm.plugin.updater.model.c(getBasePatchId(), getTinkerPatchId(), getTinkerConditionList(), paramInt);
    com.tencent.mm.kernel.h.aGY().a(localc, 0);
    if (paramInt == 2)
    {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1429L, 14L, 1L, false);
      AppMethodBeat.o(195986);
      return;
    }
    if (paramInt == 1)
    {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1429L, 15L, 1L, false);
      AppMethodBeat.o(195986);
      return;
    }
    if (paramInt == 0) {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1429L, 16L, 1L, false);
    }
    AppMethodBeat.o(195986);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(195981);
    com.tencent.mm.kernel.h.aGY().a(3899, this.jxB);
    if (paramc.kcX)
    {
      paramc = com.tencent.mm.plugin.updater.model.d.Nke;
      com.tencent.mm.plugin.updater.model.d.gsP().edit().putInt("RedDotCheckUpdateTab", 0).putInt("RedDotAboutWechatTab", 0).putInt("RedDotSettingTab", 0).putInt("RedDotBottomTab", 0).apply();
    }
    AppMethodBeat.o(195981);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(195982);
    com.tencent.mm.kernel.h.aGY().b(3899, this.jxB);
    AppMethodBeat.o(195982);
  }
  
  public boolean openUpdater()
  {
    AppMethodBeat.i(195996);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vXy, com.tencent.mm.util.b.a.Yyo, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.Updater.PluginUpdater", "openUpdater %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(195996);
      return bool;
    }
  }
  
  public void removeManualCheckUpdateListener(com.tencent.mm.plugin.updater.a.b paramb)
  {
    AppMethodBeat.i(195984);
    this.qem.remove(paramb);
    AppMethodBeat.o(195984);
  }
  
  public void setFullCheckUpdateRedDot(int paramInt)
  {
    AppMethodBeat.i(195978);
    Log.i("MicroMsg.Updater.PluginUpdater", "setFullCheckUpdateRedDot %s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt != 0)
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1429L, 25L, 1L, false);
      com.tencent.mm.plugin.updater.model.d locald = com.tencent.mm.plugin.updater.model.d.Nke;
      com.tencent.mm.plugin.updater.model.d.gsP().edit().putInt("KeyCurrentUpdateVersion", paramInt).putInt("RedDotCheckUpdateTab", 1).putInt("RedDotAboutWechatTab", 1).putInt("RedDotSettingTab", 1).putInt("RedDotBottomTab", 1).apply();
      AppMethodBeat.o(195978);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1429L, 26L, 1L, false);
    AppMethodBeat.o(195978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.PluginUpdater
 * JD-Core Version:    0.7.0.1
 */