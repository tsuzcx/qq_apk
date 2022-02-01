package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.y;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.s.a.a.a;
import com.tencent.mm.protocal.protobuf.bnc;
import com.tencent.mm.protocal.protobuf.bnd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aq
  implements com.tencent.mm.al.g, u
{
  private static aq BQQ;
  public boolean BQR;
  public boolean BQS;
  private List<String> BQT;
  public long BQU;
  private final int BQV;
  private int BQW;
  public boolean BQX;
  private long BQY;
  public String lang;
  
  private aq()
  {
    AppMethodBeat.i(151834);
    this.BQR = false;
    this.BQS = false;
    this.BQT = new LinkedList();
    this.BQV = 20;
    this.BQW = 0;
    this.BQX = false;
    AppMethodBeat.o(151834);
  }
  
  private static void a(g paramg, bnd parambnd)
  {
    AppMethodBeat.i(151843);
    paramg.field_appName = parambnd.odn;
    paramg.field_appName_en = parambnd.DKw;
    paramg.field_appName_tw = parambnd.DKx;
    paramg.field_appName_hk = parambnd.DKH;
    paramg.mW(parambnd.DKy);
    paramg.mX(parambnd.DKz);
    paramg.mY(parambnd.DKB);
    paramg.field_serviceAppInfoFlag = parambnd.DKA;
    paramg.field_serviceAppType = parambnd.odq;
    paramg.jB(parambnd.DKC);
    paramg.field_serviceShowFlag = parambnd.DKD;
    AppMethodBeat.o(151843);
  }
  
  private static void a(j paramj, List<String> paramList)
  {
    AppMethodBeat.i(151842);
    if ((paramj == null) || (paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(151842);
      return;
    }
    ad.d("MicroMsg.SuggestionAppListLogic", "removeExpiredServiceApp");
    Object localObject = h.evH();
    ad.i("MicroMsg.SuggestionAppListLogic", "oldList %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
    if (((List)localObject).size() > 0) {
      localObject = ((List)localObject).iterator();
    }
    label211:
    for (;;)
    {
      g localg;
      if (((Iterator)localObject).hasNext())
      {
        localg = (g)((Iterator)localObject).next();
        if (localg.field_appId != null)
        {
          Iterator localIterator = paramList.iterator();
          String str;
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            str = (String)localIterator.next();
          } while (!localg.field_appId.equals(str));
        }
      }
      else
      {
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label211;
          }
          boolean bool = paramj.b(localg, new String[0]);
          ad.i("MicroMsg.SuggestionAppListLogic", "delete old service : %s, %s", new Object[] { localg.field_appId, Boolean.valueOf(bool) });
          break;
          AppMethodBeat.o(151842);
          return;
        }
      }
    }
  }
  
  public static aq evU()
  {
    AppMethodBeat.i(151835);
    if (BQQ == null) {
      BQQ = new aq();
    }
    aq localaq = BQQ;
    AppMethodBeat.o(151835);
    return localaq;
  }
  
  private static void fx(String paramString, int paramInt)
  {
    AppMethodBeat.i(151839);
    ad.i("MicroMsg.SuggestionAppListLogic", "get service app, offset = %d, lang = %s", new Object[] { Integer.valueOf(paramInt), paramString });
    paramString = new af(paramInt, paramString);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(paramString, 0);
    AppMethodBeat.o(151839);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, aa paramaa)
  {
    AppMethodBeat.i(151836);
    if (!com.tencent.mm.kernel.g.afw())
    {
      AppMethodBeat.o(151836);
      return;
    }
    this.BQR = false;
    ad.d("MicroMsg.SuggestionAppListLogic", "Suggestion onSceneEnd errType=%s errCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramaa == null)
    {
      ad.e("MicroMsg.SuggestionAppListLogic", "scene == null");
      AppMethodBeat.o(151836);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    switch (paramaa.getType())
    {
    default: 
      AppMethodBeat.o(151836);
      return;
    }
    paramString = (ag)paramaa;
    ad.d("MicroMsg.SuggestionAppListLogic", "get suggestion appList, AppCount = %s", new Object[] { Integer.valueOf(paramString.evO()) });
    paramString = paramString.BQl;
    if ((paramString == null) || (paramString.size() <= 0))
    {
      ad.w("MicroMsg.SuggestionAppListLogic", "empty suggestAppList");
      AppMethodBeat.o(151836);
      return;
    }
    if ((aj.getContext() == null) || (a.a.cZX() == null))
    {
      ad.e("MicroMsg.SuggestionAppListLogic", "wrong environment");
      AppMethodBeat.o(151836);
      return;
    }
    paramaa = new LinkedList();
    Object localObject1 = paramString.iterator();
    g localg;
    Object localObject2;
    Object localObject3;
    if (((Iterator)localObject1).hasNext())
    {
      localg = (g)((Iterator)localObject1).next();
      localObject2 = localg.field_appName;
      localObject3 = localg.field_packageName;
      String str1 = localg.field_signature;
      String str2 = localg.eoo;
      if (localg.eon != null) {}
      for (boolean bool = true;; bool = false)
      {
        ad.d("MicroMsg.SuggestionAppListLogic", "suggestion appName=%s, packageName=%s, signature [%s], introUrl [%s], has iconUrl [%s]", new Object[] { localObject2, localObject3, str1, str2, Boolean.valueOf(bool) });
        paramaa.add(localg.field_appId);
        break;
      }
    }
    a.a.cZX().aA(paramaa);
    localObject1 = h.hc(aj.getContext());
    if (((List)localObject1).size() > 0)
    {
      paramaa = a.a.cZX().cZV();
      localObject1 = ((List)localObject1).iterator();
    }
    label530:
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localg = (g)((Iterator)localObject1).next();
        if (localg.field_appId != null)
        {
          localObject2 = paramString.iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject3 = (g)((Iterator)localObject2).next();
          } while ((((g)localObject3).field_appId == null) || (!localg.field_appId.equals(((g)localObject3).field_appId)));
        }
      }
      else
      {
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 != 0) {
            break label530;
          }
          if (h.a(aj.getContext(), localg)) {}
          for (localg.field_status = 1;; localg.field_status = 4)
          {
            paramaa.a(localg, new String[0]);
            break;
          }
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afB().afk().setLong(352275, System.currentTimeMillis());
          this.BQU = System.currentTimeMillis();
          break;
        }
      }
    }
  }
  
  public final void he(Context paramContext)
  {
    AppMethodBeat.i(151837);
    if (!com.tencent.mm.kernel.g.afw())
    {
      AppMethodBeat.o(151837);
      return;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(151837);
      return;
    }
    if (this.BQS)
    {
      ad.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
      AppMethodBeat.o(151837);
      return;
    }
    this.BQS = true;
    if (System.currentTimeMillis() - this.BQY < 43200000L)
    {
      ad.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now");
      this.BQS = false;
      AppMethodBeat.o(151837);
      return;
    }
    com.tencent.mm.kernel.g.afC();
    this.BQY = com.tencent.mm.kernel.g.afB().afk().Wx(352276);
    if (System.currentTimeMillis() - this.BQY < 43200000L)
    {
      ad.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now pp");
      this.BQS = false;
      AppMethodBeat.o(151837);
      return;
    }
    if (this.lang == null) {
      this.lang = ac.f(paramContext.getSharedPreferences(aj.eFD(), 0));
    }
    fx(this.lang, this.BQW);
    AppMethodBeat.o(151837);
  }
  
  public final void hf(Context paramContext)
  {
    AppMethodBeat.i(151838);
    if (!com.tencent.mm.kernel.g.afw())
    {
      AppMethodBeat.o(151838);
      return;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(151838);
      return;
    }
    if (this.BQS)
    {
      ad.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
      AppMethodBeat.o(151838);
      return;
    }
    this.BQS = true;
    if (this.lang == null) {
      this.lang = ac.f(paramContext.getSharedPreferences(aj.eFD(), 0));
    }
    ad.i("MicroMsg.SuggestionAppListLogic", "getServiceAppListImmediately");
    fx(this.lang, this.BQW);
    AppMethodBeat.o(151838);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(151841);
    if (!com.tencent.mm.kernel.g.afw())
    {
      ad.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd account not ready");
      this.BQW = 0;
      this.BQT.clear();
      AppMethodBeat.o(151841);
      return;
    }
    this.BQS = false;
    if (paramn == null)
    {
      ad.e("MicroMsg.SuggestionAppListLogic", "scene == null");
      this.BQW = 0;
      this.BQT.clear();
      AppMethodBeat.o(151841);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ad.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      this.BQW = 0;
      this.BQT.clear();
      AppMethodBeat.o(151841);
      return;
    }
    ad.i("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = (af)paramn;
    if ((paramString.rr != null) && (paramString.rr.gUT.gUX != null)) {}
    for (paramString = (bnc)paramString.rr.gUT.gUX; paramString == null; paramString = null)
    {
      ad.e("MicroMsg.SuggestionAppListLogic", "resp == null");
      this.BQW = 0;
      this.BQT.clear();
      AppMethodBeat.o(151841);
      return;
    }
    if ((paramString.DKv == null) || (paramString.DKv.size() <= 0))
    {
      ad.e("MicroMsg.SuggestionAppListLogic", "Service_appinfo empty");
      a(a.a.cZX().cZV(), this.BQT);
      this.BQW = 0;
      this.BQT.clear();
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().setLong(352276, System.currentTimeMillis());
      this.BQY = System.currentTimeMillis();
      AppMethodBeat.o(151841);
      return;
    }
    ad.i("MicroMsg.SuggestionAppListLogic", "offset = %d, count = %s", new Object[] { Integer.valueOf(this.BQW), Integer.valueOf(paramString.DKv.size()) });
    j localj = a.a.cZX().cZV();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramString.DKv.iterator();
    label1436:
    while (localIterator.hasNext())
    {
      bnd localbnd = (bnd)localIterator.next();
      ad.i("MicroMsg.SuggestionAppListLogic", "service info: %s, %s, %s, %s, %s, %s", new Object[] { localbnd.odn, Integer.valueOf(localbnd.odq), Integer.valueOf(localbnd.DKD), Integer.valueOf(localbnd.DKC), Integer.valueOf(localbnd.DKA), localbnd.dlB });
      if ((!bt.isNullOrNil(localbnd.dlB)) && (!bt.isNullOrNil(localbnd.odn)))
      {
        paramInt1 = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fla, Integer.valueOf(0))).intValue();
        g localg;
        label636:
        boolean bool;
        if (g.BPH.equals(localbnd.dlB))
        {
          localbnd.DKA = (localbnd.DKA ^ 0xFD ^ 0xFFFFFFFF);
          ad.d("MicroMsg.SuggestionAppListLogic", "aa change: %s", new Object[] { Integer.valueOf(localbnd.DKA) });
          this.BQT.add(localbnd.dlB);
          localg = h.j(localbnd.dlB, true, false);
          if (localg == null) {
            break label1321;
          }
          if (localg.field_serviceAppInfoFlag == localbnd.DKA) {
            break label1073;
          }
          paramInt1 = 1;
          paramn = localg;
          if (paramInt1 != 0)
          {
            paramn = localg.eoz;
            String str = localg.eoy;
            a(localg, localbnd);
            bool = localj.a(localg, new String[0]);
            if (!bt.nullAsNil(paramn).equals(bt.nullAsNil(localbnd.DKz)))
            {
              ad.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_list" + bt.nullAsNil(localbnd.DKz));
              com.tencent.mm.plugin.s.a.cZO().fu(localg.field_appId, 5);
            }
            if (!bt.nullAsNil(str).equals(bt.nullAsNil(localbnd.DKy)))
            {
              ad.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_panel" + bt.nullAsNil(localbnd.DKy));
              com.tencent.mm.plugin.s.a.cZO().fu(localg.field_appId, 4);
            }
            ad.i("MicroMsg.SuggestionAppListLogic", "update app: AppID = %s, ret = %s", new Object[] { localbnd.dlB, Boolean.valueOf(bool) });
            paramn = localg;
          }
          label830:
          if (bt.isNullOrNil(paramn.field_openId)) {
            localLinkedList.add(localbnd.dlB);
          }
          paramn = h.iK(0, 3).iterator();
        }
        for (;;)
        {
          if (!paramn.hasNext()) {
            break label1436;
          }
          localg = (g)paramn.next();
          if (g.BPE.equals(localg.field_appId))
          {
            ad.i("MicroMsg.SuggestionAppListLogic", "remittance: %s, %s", new Object[] { Integer.valueOf(localg.field_serviceShowFlag), Integer.valueOf(localg.field_appInfoFlag) });
            continue;
            if (g.BPG.equals(localbnd.dlB))
            {
              if (localbnd.DKD > 0) {
                break;
              }
              if ((com.tencent.mm.model.u.aqQ()) && (com.tencent.mm.model.u.aqN() == 0) && (paramInt1 == 1))
              {
                com.tencent.mm.plugin.report.service.h.vKh.dB(965, 33);
                break;
              }
              com.tencent.mm.plugin.report.service.h.vKh.dB(965, 35);
              break;
            }
            if ((!g.BPE.equals(localbnd.dlB)) || (localbnd.DKD > 0)) {
              break;
            }
            if ((com.tencent.mm.model.u.aqQ()) && (com.tencent.mm.model.u.aqN() == 0) && (paramInt1 == 1))
            {
              com.tencent.mm.plugin.report.service.h.vKh.dB(965, 32);
              break;
            }
            com.tencent.mm.plugin.report.service.h.vKh.dB(965, 34);
            break;
            label1073:
            if (localg.field_serviceAppType != localbnd.odq)
            {
              paramInt1 = 1;
              break label636;
            }
            if (localg.eoB != localbnd.DKC)
            {
              paramInt1 = 1;
              break label636;
            }
            if (localg.field_serviceShowFlag != localbnd.DKD)
            {
              paramInt1 = 1;
              break label636;
            }
            if (!bt.nullAsNil(localg.field_appName).equals(bt.nullAsNil(localbnd.odn)))
            {
              paramInt1 = 1;
              break label636;
            }
            if (!bt.nullAsNil(localg.field_appName_en).equals(bt.nullAsNil(localbnd.DKw)))
            {
              paramInt1 = 1;
              break label636;
            }
            if (!bt.nullAsNil(localg.field_appName_tw).equals(bt.nullAsNil(localbnd.DKx)))
            {
              paramInt1 = 1;
              break label636;
            }
            if (!bt.nullAsNil(localg.field_appName_hk).equals(bt.nullAsNil(localbnd.DKH)))
            {
              paramInt1 = 1;
              break label636;
            }
            if (!bt.nullAsNil(localg.eoz).equals(bt.nullAsNil(localbnd.DKz)))
            {
              paramInt1 = 1;
              break label636;
            }
            if (!bt.nullAsNil(localg.eoy).equals(bt.nullAsNil(localbnd.DKy)))
            {
              paramInt1 = 1;
              break label636;
            }
            if (!bt.nullAsNil(localg.eoA).equals(bt.nullAsNil(localbnd.DKB)))
            {
              paramInt1 = 1;
              break label636;
            }
            paramInt1 = 0;
            break label636;
            label1321:
            paramn = new g();
            paramn.field_appId = localbnd.dlB;
            a(paramn, localbnd);
            bool = localj.q(paramn);
            ad.i("MicroMsg.SuggestionAppListLogic", "insert app: AppID = %s, ret = %s", new Object[] { localbnd.dlB, Boolean.valueOf(bool) });
            break label830;
          }
          if (g.BPG.equals(localg.field_appId)) {
            ad.i("MicroMsg.SuggestionAppListLogic", "lucky: %s, %s", new Object[] { Integer.valueOf(localg.field_serviceShowFlag), Integer.valueOf(localg.field_appInfoFlag) });
          }
        }
      }
    }
    if (localLinkedList.size() > 0)
    {
      ad.i("MicroMsg.SuggestionAppListLogic", "needGetOpenIdList %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
      com.tencent.mm.plugin.s.a.cZS().addAll(localLinkedList);
    }
    if (paramString.DKv.size() == 20)
    {
      this.BQW += 20;
      fx(this.lang, this.BQW);
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().setLong(352276, System.currentTimeMillis());
      this.BQY = System.currentTimeMillis();
      AppMethodBeat.o(151841);
      return;
      a(localj, this.BQT);
      this.BQW = 0;
      this.BQT.clear();
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(151840);
    ad.i("MicroMsg.SuggestionAppListLogic", "reset getServiceAppList");
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afB().afk().setLong(352276, 0L);
    this.BQY = 0L;
    this.BQX = true;
    AppMethodBeat.o(151840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.aq
 * JD-Core Version:    0.7.0.1
 */