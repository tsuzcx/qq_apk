package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.s.a.a.a;
import com.tencent.mm.protocal.protobuf.bbd;
import com.tencent.mm.protocal.protobuf.bbe;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class am
  implements com.tencent.mm.ai.f, t
{
  private static am vMd;
  public String lang;
  public boolean vMe;
  public boolean vMf;
  private List<String> vMg;
  public long vMh;
  private final int vMi;
  private int vMj;
  public boolean vMk;
  private long vMl;
  
  private am()
  {
    AppMethodBeat.i(79397);
    this.vMe = false;
    this.vMf = false;
    this.vMg = new LinkedList();
    this.vMi = 20;
    this.vMj = 0;
    this.vMk = false;
    AppMethodBeat.o(79397);
  }
  
  private static void a(f paramf, bbe parambbe)
  {
    AppMethodBeat.i(79406);
    paramf.field_appName = parambbe.kWx;
    paramf.field_appName_en = parambbe.xqm;
    paramf.field_appName_tw = parambbe.xqn;
    paramf.field_appName_hk = parambbe.xqx;
    paramf.ji(parambbe.xqo);
    paramf.jj(parambbe.xqp);
    paramf.jk(parambbe.xqr);
    paramf.field_serviceAppInfoFlag = parambbe.xqq;
    paramf.field_serviceAppType = parambbe.kWA;
    paramf.hq(parambbe.xqs);
    paramf.field_serviceShowFlag = parambbe.xqt;
    AppMethodBeat.o(79406);
  }
  
  private static void a(i parami, List<String> paramList)
  {
    AppMethodBeat.i(79405);
    if ((parami == null) || (paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(79405);
      return;
    }
    ab.d("MicroMsg.SuggestionAppListLogic", "removeExpiredServiceApp");
    Object localObject = g.dlA();
    ab.i("MicroMsg.SuggestionAppListLogic", "oldList %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
    if (((List)localObject).size() > 0) {
      localObject = ((List)localObject).iterator();
    }
    label211:
    for (;;)
    {
      f localf;
      if (((Iterator)localObject).hasNext())
      {
        localf = (f)((Iterator)localObject).next();
        if (localf.field_appId != null)
        {
          Iterator localIterator = paramList.iterator();
          String str;
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            str = (String)localIterator.next();
          } while (!localf.field_appId.equals(str));
        }
      }
      else
      {
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label211;
          }
          boolean bool = parami.b(localf, new String[0]);
          ab.i("MicroMsg.SuggestionAppListLogic", "delete old service : %s, %s", new Object[] { localf.field_appId, Boolean.valueOf(bool) });
          break;
          AppMethodBeat.o(79405);
          return;
        }
      }
    }
  }
  
  public static am dlO()
  {
    AppMethodBeat.i(79398);
    if (vMd == null) {
      vMd = new am();
    }
    am localam = vMd;
    AppMethodBeat.o(79398);
    return localam;
  }
  
  private static void eo(String paramString, int paramInt)
  {
    AppMethodBeat.i(79402);
    ab.i("MicroMsg.SuggestionAppListLogic", "get service app, offset = %d, lang = %s", new Object[] { Integer.valueOf(paramInt), paramString });
    paramString = new ac(paramInt, paramString);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(paramString, 0);
    AppMethodBeat.o(79402);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, x paramx)
  {
    AppMethodBeat.i(79399);
    if (!com.tencent.mm.kernel.g.RG())
    {
      AppMethodBeat.o(79399);
      return;
    }
    this.vMe = false;
    ab.d("MicroMsg.SuggestionAppListLogic", "Suggestion onSceneEnd errType=%s errCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramx == null)
    {
      ab.e("MicroMsg.SuggestionAppListLogic", "scene == null");
      AppMethodBeat.o(79399);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    switch (paramx.getType())
    {
    default: 
      AppMethodBeat.o(79399);
      return;
    }
    paramString = (ad)paramx;
    ab.d("MicroMsg.SuggestionAppListLogic", "get suggestion appList, AppCount = %s", new Object[] { Integer.valueOf(paramString.dlH()) });
    paramString = paramString.vLB;
    if ((paramString == null) || (paramString.size() <= 0))
    {
      ab.w("MicroMsg.SuggestionAppListLogic", "empty suggestAppList");
      AppMethodBeat.o(79399);
      return;
    }
    if ((ah.getContext() == null) || (a.a.caj() == null))
    {
      ab.e("MicroMsg.SuggestionAppListLogic", "wrong environment");
      AppMethodBeat.o(79399);
      return;
    }
    paramx = new LinkedList();
    Object localObject1 = paramString.iterator();
    f localf;
    Object localObject2;
    Object localObject3;
    if (((Iterator)localObject1).hasNext())
    {
      localf = (f)((Iterator)localObject1).next();
      localObject2 = localf.field_appName;
      localObject3 = localf.field_packageName;
      String str1 = localf.field_signature;
      String str2 = localf.djR;
      if (localf.djQ != null) {}
      for (boolean bool = true;; bool = false)
      {
        ab.d("MicroMsg.SuggestionAppListLogic", "suggestion appName=%s, packageName=%s, signature [%s], introUrl [%s], has iconUrl [%s]", new Object[] { localObject2, localObject3, str1, str2, Boolean.valueOf(bool) });
        paramx.add(localf.field_appId);
        break;
      }
    }
    a.a.caj().al(paramx);
    localObject1 = g.fQ(ah.getContext());
    if (((List)localObject1).size() > 0)
    {
      paramx = a.a.caj().cah();
      localObject1 = ((List)localObject1).iterator();
    }
    label530:
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localf = (f)((Iterator)localObject1).next();
        if (localf.field_appId != null)
        {
          localObject2 = paramString.iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject3 = (f)((Iterator)localObject2).next();
          } while ((((f)localObject3).field_appId == null) || (!localf.field_appId.equals(((f)localObject3).field_appId)));
        }
      }
      else
      {
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 != 0) {
            break label530;
          }
          if (g.a(ah.getContext(), localf)) {}
          for (localf.field_status = 1;; localf.field_status = 4)
          {
            paramx.a(localf, new String[0]);
            break;
          }
          com.tencent.mm.kernel.g.RM();
          com.tencent.mm.kernel.g.RL().Ru().setLong(352275, System.currentTimeMillis());
          this.vMh = System.currentTimeMillis();
          break;
        }
      }
    }
  }
  
  public final void fS(Context paramContext)
  {
    AppMethodBeat.i(79400);
    if (!com.tencent.mm.kernel.g.RG())
    {
      AppMethodBeat.o(79400);
      return;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(79400);
      return;
    }
    if (this.vMf)
    {
      ab.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
      AppMethodBeat.o(79400);
      return;
    }
    this.vMf = true;
    if (System.currentTimeMillis() - this.vMl < 43200000L)
    {
      ab.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now");
      this.vMf = false;
      AppMethodBeat.o(79400);
      return;
    }
    com.tencent.mm.kernel.g.RM();
    this.vMl = com.tencent.mm.kernel.g.RL().Ru().Ns(352276);
    if (System.currentTimeMillis() - this.vMl < 43200000L)
    {
      ab.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now pp");
      this.vMf = false;
      AppMethodBeat.o(79400);
      return;
    }
    if (this.lang == null) {
      this.lang = aa.f(paramContext.getSharedPreferences(ah.dsP(), 0));
    }
    eo(this.lang, this.vMj);
    AppMethodBeat.o(79400);
  }
  
  public final void fT(Context paramContext)
  {
    AppMethodBeat.i(79401);
    if (!com.tencent.mm.kernel.g.RG())
    {
      AppMethodBeat.o(79401);
      return;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(79401);
      return;
    }
    if (this.vMf)
    {
      ab.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
      AppMethodBeat.o(79401);
      return;
    }
    this.vMf = true;
    if (this.lang == null) {
      this.lang = aa.f(paramContext.getSharedPreferences(ah.dsP(), 0));
    }
    ab.i("MicroMsg.SuggestionAppListLogic", "getServiceAppListImmediately");
    eo(this.lang, this.vMj);
    AppMethodBeat.o(79401);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(79404);
    if (!com.tencent.mm.kernel.g.RG())
    {
      ab.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd account not ready");
      this.vMj = 0;
      this.vMg.clear();
      AppMethodBeat.o(79404);
      return;
    }
    this.vMf = false;
    if (paramm == null)
    {
      ab.e("MicroMsg.SuggestionAppListLogic", "scene == null");
      this.vMj = 0;
      this.vMg.clear();
      AppMethodBeat.o(79404);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      this.vMj = 0;
      this.vMg.clear();
      AppMethodBeat.o(79404);
      return;
    }
    ab.i("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = (ac)paramm;
    if ((paramString.rr != null) && (paramString.rr.fsW.fta != null)) {}
    for (paramString = (bbd)paramString.rr.fsW.fta; paramString == null; paramString = null)
    {
      ab.e("MicroMsg.SuggestionAppListLogic", "resp == null");
      this.vMj = 0;
      this.vMg.clear();
      AppMethodBeat.o(79404);
      return;
    }
    if ((paramString.xql == null) || (paramString.xql.size() <= 0))
    {
      ab.e("MicroMsg.SuggestionAppListLogic", "Service_appinfo empty");
      a(a.a.caj().cah(), this.vMg);
      this.vMj = 0;
      this.vMg.clear();
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RL().Ru().setLong(352276, System.currentTimeMillis());
      this.vMl = System.currentTimeMillis();
      AppMethodBeat.o(79404);
      return;
    }
    ab.i("MicroMsg.SuggestionAppListLogic", "offset = %d, count = %s", new Object[] { Integer.valueOf(this.vMj), Integer.valueOf(paramString.xql.size()) });
    i locali = a.a.caj().cah();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramString.xql.iterator();
    label1435:
    while (localIterator.hasNext())
    {
      bbe localbbe = (bbe)localIterator.next();
      ab.i("MicroMsg.SuggestionAppListLogic", "service info: %s, %s, %s, %s, %s, %s", new Object[] { localbbe.kWx, Integer.valueOf(localbbe.kWA), Integer.valueOf(localbbe.xqt), Integer.valueOf(localbbe.xqs), Integer.valueOf(localbbe.xqq), localbbe.cwc });
      if ((!bo.isNullOrNil(localbbe.cwc)) && (!bo.isNullOrNil(localbbe.kWx)))
      {
        paramInt1 = ((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yCE, Integer.valueOf(0))).intValue();
        f localf;
        label635:
        boolean bool;
        if (f.vLa.equals(localbbe.cwc))
        {
          localbbe.xqq = (localbbe.xqq ^ 0xFD ^ 0xFFFFFFFF);
          ab.d("MicroMsg.SuggestionAppListLogic", "aa change: %s", new Object[] { Integer.valueOf(localbbe.xqq) });
          this.vMg.add(localbbe.cwc);
          localf = g.ca(localbbe.cwc, true);
          if (localf == null) {
            break label1320;
          }
          if (localf.field_serviceAppInfoFlag == localbbe.xqq) {
            break label1072;
          }
          paramInt1 = 1;
          paramm = localf;
          if (paramInt1 != 0)
          {
            paramm = localf.dkc;
            String str = localf.dkb;
            a(localf, localbbe);
            bool = locali.a(localf, new String[0]);
            if (!bo.nullAsNil(paramm).equals(bo.nullAsNil(localbbe.xqp)))
            {
              ab.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_list" + bo.nullAsNil(localbbe.xqp));
              com.tencent.mm.plugin.s.a.caa().el(localf.field_appId, 5);
            }
            if (!bo.nullAsNil(str).equals(bo.nullAsNil(localbbe.xqo)))
            {
              ab.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_panel" + bo.nullAsNil(localbbe.xqo));
              com.tencent.mm.plugin.s.a.caa().el(localf.field_appId, 4);
            }
            ab.i("MicroMsg.SuggestionAppListLogic", "update app: AppID = %s, ret = %s", new Object[] { localbbe.cwc, Boolean.valueOf(bool) });
            paramm = localf;
          }
          label829:
          if (bo.isNullOrNil(paramm.field_openId)) {
            localLinkedList.add(localbbe.cwc);
          }
          paramm = g.gZ(0, 3).iterator();
        }
        for (;;)
        {
          if (!paramm.hasNext()) {
            break label1435;
          }
          localf = (f)paramm.next();
          if (f.vKX.equals(localf.field_appId))
          {
            ab.i("MicroMsg.SuggestionAppListLogic", "remittance: %s, %s", new Object[] { Integer.valueOf(localf.field_serviceShowFlag), Integer.valueOf(localf.field_appInfoFlag) });
            continue;
            if (f.vKZ.equals(localbbe.cwc))
            {
              if (localbbe.xqt > 0) {
                break;
              }
              if ((r.Zw()) && (r.Zu() == 0) && (paramInt1 == 1))
              {
                h.qsU.cT(965, 33);
                break;
              }
              h.qsU.cT(965, 35);
              break;
            }
            if ((!f.vKX.equals(localbbe.cwc)) || (localbbe.xqt > 0)) {
              break;
            }
            if ((r.Zw()) && (r.Zu() == 0) && (paramInt1 == 1))
            {
              h.qsU.cT(965, 32);
              break;
            }
            h.qsU.cT(965, 34);
            break;
            label1072:
            if (localf.field_serviceAppType != localbbe.kWA)
            {
              paramInt1 = 1;
              break label635;
            }
            if (localf.dke != localbbe.xqs)
            {
              paramInt1 = 1;
              break label635;
            }
            if (localf.field_serviceShowFlag != localbbe.xqt)
            {
              paramInt1 = 1;
              break label635;
            }
            if (!bo.nullAsNil(localf.field_appName).equals(bo.nullAsNil(localbbe.kWx)))
            {
              paramInt1 = 1;
              break label635;
            }
            if (!bo.nullAsNil(localf.field_appName_en).equals(bo.nullAsNil(localbbe.xqm)))
            {
              paramInt1 = 1;
              break label635;
            }
            if (!bo.nullAsNil(localf.field_appName_tw).equals(bo.nullAsNil(localbbe.xqn)))
            {
              paramInt1 = 1;
              break label635;
            }
            if (!bo.nullAsNil(localf.field_appName_hk).equals(bo.nullAsNil(localbbe.xqx)))
            {
              paramInt1 = 1;
              break label635;
            }
            if (!bo.nullAsNil(localf.dkc).equals(bo.nullAsNil(localbbe.xqp)))
            {
              paramInt1 = 1;
              break label635;
            }
            if (!bo.nullAsNil(localf.dkb).equals(bo.nullAsNil(localbbe.xqo)))
            {
              paramInt1 = 1;
              break label635;
            }
            if (!bo.nullAsNil(localf.dkd).equals(bo.nullAsNil(localbbe.xqr)))
            {
              paramInt1 = 1;
              break label635;
            }
            paramInt1 = 0;
            break label635;
            label1320:
            paramm = new f();
            paramm.field_appId = localbbe.cwc;
            a(paramm, localbbe);
            bool = locali.p(paramm);
            ab.i("MicroMsg.SuggestionAppListLogic", "insert app: AppID = %s, ret = %s", new Object[] { localbbe.cwc, Boolean.valueOf(bool) });
            break label829;
          }
          if (f.vKZ.equals(localf.field_appId)) {
            ab.i("MicroMsg.SuggestionAppListLogic", "lucky: %s, %s", new Object[] { Integer.valueOf(localf.field_serviceShowFlag), Integer.valueOf(localf.field_appInfoFlag) });
          }
        }
      }
    }
    if (localLinkedList.size() > 0)
    {
      ab.i("MicroMsg.SuggestionAppListLogic", "needGetOpenIdList %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
      com.tencent.mm.plugin.s.a.cae().addAll(localLinkedList);
    }
    if (paramString.xql.size() == 20)
    {
      this.vMj += 20;
      eo(this.lang, this.vMj);
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RL().Ru().setLong(352276, System.currentTimeMillis());
      this.vMl = System.currentTimeMillis();
      AppMethodBeat.o(79404);
      return;
      a(locali, this.vMg);
      this.vMj = 0;
      this.vMg.clear();
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(79403);
    ab.i("MicroMsg.SuggestionAppListLogic", "reset getServiceAppList");
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RL().Ru().setLong(352276, 0L);
    this.vMl = 0L;
    this.vMk = true;
    AppMethodBeat.o(79403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.am
 * JD-Core Version:    0.7.0.1
 */