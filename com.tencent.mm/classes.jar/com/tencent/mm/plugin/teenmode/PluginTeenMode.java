package com.tencent.mm.plugin.teenmode;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.mvvm.MvvmPlugin;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.aj;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.teenmode.a.f;
import com.tencent.mm.plugin.teenmode.b.j;
import com.tencent.mm.plugin.teenmode.b.k;
import com.tencent.mm.plugin.teenmode.b.m;
import com.tencent.mm.sdk.event.MvvmEventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.threadpool.i;
import java.util.Map;

public class PluginTeenMode
  extends MvvmPlugin
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.plugin.teenmode.a.c
{
  private t SUV;
  private t SUW;
  
  public PluginTeenMode()
  {
    AppMethodBeat.i(278822);
    this.SUV = new t()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, g.a paramAnonymousa)
      {
        AppMethodBeat.i(278844);
        paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.teenagermodebecomeguardian.guardianusername");
        paramAnonymousa = (String)paramAnonymousMap.get(".sysmsg.teenagermodebecomeguardian.wardusername");
        Object localObject = (String)paramAnonymousMap.get(".sysmsg.teenagermodebecomeguardian.ticket");
        long l = Util.getLong((String)paramAnonymousMap.get(".sysmsg.teenagermodebecomeguardian.becomeguardiantime"), cn.getSyncServerTimeSecond());
        paramAnonymousMap = new f();
        paramAnonymousMap.field_guardianUserName = paramAnonymousString;
        paramAnonymousMap.field_wardUserName = paramAnonymousa;
        paramAnonymousMap.field_ticket = ((String)localObject);
        paramAnonymousMap.field_time = (l * 1000L);
        localObject = com.tencent.mm.plugin.teenmode.b.a.e.SZq;
        com.tencent.mm.plugin.teenmode.b.a.e.hEC().replace(paramAnonymousMap);
        if (z.bAM().equalsIgnoreCase(paramAnonymousa))
        {
          paramAnonymousString = ab.Jg(paramAnonymousString);
          paramAnonymousString.setType(paramAnonymousString.field_type | au.aSB());
          ab.O(paramAnonymousString);
        }
        for (;;)
        {
          com.tencent.threadpool.h.ahAA.bm(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(278839);
              ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).hEs();
              AppMethodBeat.o(278839);
            }
          });
          AppMethodBeat.o(278844);
          return;
          if (z.bAM().equalsIgnoreCase(paramAnonymousString))
          {
            paramAnonymousString = ab.Jg(paramAnonymousa);
            paramAnonymousString.setType(paramAnonymousString.field_type | au.aSC());
            ab.O(paramAnonymousString);
          }
        }
      }
    };
    this.SUW = new t()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, g.a paramAnonymousa)
      {
        AppMethodBeat.i(278849);
        paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.teenagermodeagreenauthorization.guardianusername");
        paramAnonymousa = (String)paramAnonymousMap.get(".sysmsg.teenagermodeagreenauthorization.wardusername");
        String str = (String)paramAnonymousMap.get(".sysmsg.teenagermodeagreenauthorization.businesskey");
        int i = Util.getInt((String)paramAnonymousMap.get(".sysmsg.teenagermodeagreenauthorization.businesstype"), 0);
        long l1 = Util.getLong((String)paramAnonymousMap.get(".sysmsg.teenagermodeagreenauthorization.agreenauthorizationtime"), cn.getSyncServerTimeSecond());
        long l2 = Util.getLong((String)paramAnonymousMap.get(".sysmsg.teenagermodeagreenauthorization.requestauthorizationmsgid"), 0L);
        paramAnonymousMap = new com.tencent.mm.plugin.teenmode.a.e();
        paramAnonymousMap.field_businessKey = str;
        paramAnonymousMap.field_businessType = i;
        paramAnonymousMap.field_guardianUserName = paramAnonymousString;
        paramAnonymousMap.field_wardUserName = paramAnonymousa;
        paramAnonymousMap.field_time = (l1 * 1000L);
        paramAnonymousMap.field_msgSvrId = l2;
        com.tencent.mm.plugin.teenmode.b.a.e locale = com.tencent.mm.plugin.teenmode.b.a.e.SZq;
        com.tencent.mm.plugin.teenmode.b.a.e.hEB().replace(paramAnonymousMap);
        paramAnonymousMap = new com.tencent.mm.autogen.a.l();
        paramAnonymousMap.hyX.bizKey = str;
        paramAnonymousMap.hyX.hyY = i;
        paramAnonymousMap.publish();
        com.tencent.threadpool.h.ahAA.bm(new PluginTeenMode.2.1(this, paramAnonymousa, paramAnonymousString, i, l2));
        AppMethodBeat.o(278849);
      }
    };
    AppMethodBeat.o(278822);
  }
  
  public void configure(g paramg) {}
  
  public void dependency() {}
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(278842);
    Log.d("PluginTeenMode", "execute");
    if (paramg.bbA())
    {
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.teenmode.a.d.class, j.hEy());
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.comm.a.a.class, new com.tencent.mm.plugin.teenmode.b.b());
      AppMethodBeat.o(278842);
      return;
    }
    if ((paramg.FH(":tools")) || (paramg.FH(":toolsmp")) || (paramg.FI(":appbrand"))) {
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.teenmode.a.d.class, k.hEz());
    }
    AppMethodBeat.o(278842);
  }
  
  public void installed()
  {
    AppMethodBeat.i(278834);
    alias(com.tencent.mm.plugin.teenmode.a.c.class);
    AppMethodBeat.o(278834);
  }
  
  public void onAccountInit(f.c paramc)
  {
    AppMethodBeat.i(278857);
    Log.i("PluginTeenMode", "onAccountInitialized");
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("teenagermodebecomeguardian", this.SUV);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("teenagermodeagreenauthorization", this.SUW);
    ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a(2147483647, new com.tencent.mm.plugin.teenmode.ui.d());
    ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a(1, new com.tencent.mm.plugin.teenmode.ui.a());
    ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a(2, new com.tencent.mm.plugin.teenmode.ui.b());
    ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a(3, new com.tencent.mm.plugin.teenmode.ui.c());
    ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a(1, new com.tencent.mm.plugin.teenmode.b.l());
    ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a(2, new m());
    ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a(3, new m());
    ((aj)MvvmEventCenter.getEvent(aj.class)).observe(this, PluginTeenMode..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(278857);
  }
  
  public void onAccountReleaseAfter()
  {
    AppMethodBeat.i(278863);
    Log.i("PluginTeenMode", "onAccountRelease");
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("teenagermodebecomeguardian", this.SUV);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("teenagermodeagreenauthorization", this.SUW);
    AppMethodBeat.o(278863);
  }
  
  public void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2) {}
  
  public void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2) {}
  
  public String toString()
  {
    return "plugin-teenmode";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.PluginTeenMode
 * JD-Core Version:    0.7.0.1
 */