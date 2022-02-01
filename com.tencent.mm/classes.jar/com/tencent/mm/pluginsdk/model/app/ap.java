package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.y;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.s.a.a.a;
import com.tencent.mm.protocal.protobuf.bwz;
import com.tencent.mm.protocal.protobuf.bxa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ap
  implements com.tencent.mm.ak.f, u
{
  private static ap Fgs;
  private long FgA;
  public boolean Fgt;
  public boolean Fgu;
  private List<String> Fgv;
  public long Fgw;
  private final int Fgx;
  private int Fgy;
  public boolean Fgz;
  public String lang;
  
  private ap()
  {
    AppMethodBeat.i(151834);
    this.Fgt = false;
    this.Fgu = false;
    this.Fgv = new LinkedList();
    this.Fgx = 20;
    this.Fgy = 0;
    this.Fgz = false;
    AppMethodBeat.o(151834);
  }
  
  private static void a(g paramg, bxa parambxa)
  {
    AppMethodBeat.i(151843);
    paramg.field_appName = parambxa.pqV;
    paramg.field_appName_en = parambxa.HjO;
    paramg.field_appName_tw = parambxa.HjP;
    paramg.field_appName_hk = parambxa.HjZ;
    paramg.th(parambxa.HjQ);
    paramg.ti(parambxa.HjR);
    paramg.tj(parambxa.HjT);
    paramg.field_serviceAppInfoFlag = parambxa.HjS;
    paramg.field_serviceAppType = parambxa.pqY;
    paramg.jZ(parambxa.HjU);
    paramg.field_serviceShowFlag = parambxa.HjV;
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
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SuggestionAppListLogic", "removeExpiredServiceApp");
    Object localObject = h.fdJ();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SuggestionAppListLogic", "oldList %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
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
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SuggestionAppListLogic", "delete old service : %s, %s", new Object[] { localg.field_appId, Boolean.valueOf(bool) });
          break;
          AppMethodBeat.o(151842);
          return;
        }
      }
    }
  }
  
  public static ap fdX()
  {
    AppMethodBeat.i(151835);
    if (Fgs == null) {
      Fgs = new ap();
    }
    ap localap = Fgs;
    AppMethodBeat.o(151835);
    return localap;
  }
  
  private static void gi(String paramString, int paramInt)
  {
    AppMethodBeat.i(151839);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SuggestionAppListLogic", "get service app, offset = %d, lang = %s", new Object[] { Integer.valueOf(paramInt), paramString });
    paramString = new ae(paramInt, paramString);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(paramString, 0);
    AppMethodBeat.o(151839);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, aa paramaa)
  {
    AppMethodBeat.i(151836);
    if (!com.tencent.mm.kernel.g.ajM())
    {
      AppMethodBeat.o(151836);
      return;
    }
    this.Fgt = false;
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SuggestionAppListLogic", "Suggestion onSceneEnd errType=%s errCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramaa == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SuggestionAppListLogic", "scene == null");
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
    paramString = (af)paramaa;
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SuggestionAppListLogic", "get suggestion appList, AppCount = %s", new Object[] { Integer.valueOf(paramString.fdQ()) });
    paramString = paramString.FfJ;
    if ((paramString == null) || (paramString.size() <= 0))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.SuggestionAppListLogic", "empty suggestAppList");
      AppMethodBeat.o(151836);
      return;
    }
    if ((ak.getContext() == null) || (a.a.dBn() == null))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SuggestionAppListLogic", "wrong environment");
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
      String str2 = localg.eJk;
      if (localg.eJj != null) {}
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SuggestionAppListLogic", "suggestion appName=%s, packageName=%s, signature [%s], introUrl [%s], has iconUrl [%s]", new Object[] { localObject2, localObject3, str1, str2, Boolean.valueOf(bool) });
        paramaa.add(localg.field_appId);
        break;
      }
    }
    a.a.dBn().aJ(paramaa);
    localObject1 = h.hy(ak.getContext());
    if (((List)localObject1).size() > 0)
    {
      paramaa = a.a.dBn().dBl();
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
          if (h.a(ak.getContext(), localg)) {}
          for (localg.field_status = 1;; localg.field_status = 4)
          {
            paramaa.a(localg, new String[0]);
            break;
          }
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajR().ajA().setLong(352275, System.currentTimeMillis());
          this.Fgw = System.currentTimeMillis();
          break;
        }
      }
    }
  }
  
  public final void hA(Context paramContext)
  {
    AppMethodBeat.i(151837);
    if (!com.tencent.mm.kernel.g.ajM())
    {
      AppMethodBeat.o(151837);
      return;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(151837);
      return;
    }
    if (this.Fgu)
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
      AppMethodBeat.o(151837);
      return;
    }
    this.Fgu = true;
    if (System.currentTimeMillis() - this.FgA < 43200000L)
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now");
      this.Fgu = false;
      AppMethodBeat.o(151837);
      return;
    }
    com.tencent.mm.kernel.g.ajS();
    this.FgA = com.tencent.mm.kernel.g.ajR().ajA().aby(352276);
    if (System.currentTimeMillis() - this.FgA < 43200000L)
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now pp");
      this.Fgu = false;
      AppMethodBeat.o(151837);
      return;
    }
    if (this.lang == null) {
      this.lang = ad.f(paramContext.getSharedPreferences(ak.fow(), 0));
    }
    gi(this.lang, this.Fgy);
    AppMethodBeat.o(151837);
  }
  
  public final void hB(Context paramContext)
  {
    AppMethodBeat.i(151838);
    if (!com.tencent.mm.kernel.g.ajM())
    {
      AppMethodBeat.o(151838);
      return;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(151838);
      return;
    }
    if (this.Fgu)
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
      AppMethodBeat.o(151838);
      return;
    }
    this.Fgu = true;
    if (this.lang == null) {
      this.lang = ad.f(paramContext.getSharedPreferences(ak.fow(), 0));
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SuggestionAppListLogic", "getServiceAppListImmediately");
    gi(this.lang, this.Fgy);
    AppMethodBeat.o(151838);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(151841);
    if (!com.tencent.mm.kernel.g.ajM())
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd account not ready");
      this.Fgy = 0;
      this.Fgv.clear();
      AppMethodBeat.o(151841);
      return;
    }
    this.Fgu = false;
    if (paramn == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SuggestionAppListLogic", "scene == null");
      this.Fgy = 0;
      this.Fgv.clear();
      AppMethodBeat.o(151841);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      this.Fgy = 0;
      this.Fgv.clear();
      AppMethodBeat.o(151841);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = (ae)paramn;
    if ((paramString.rr != null) && (paramString.rr.hQE.hQJ != null)) {}
    for (paramString = (bwz)paramString.rr.hQE.hQJ; paramString == null; paramString = null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SuggestionAppListLogic", "resp == null");
      this.Fgy = 0;
      this.Fgv.clear();
      AppMethodBeat.o(151841);
      return;
    }
    if ((paramString.HjN == null) || (paramString.HjN.size() <= 0))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SuggestionAppListLogic", "Service_appinfo empty");
      a(a.a.dBn().dBl(), this.Fgv);
      this.Fgy = 0;
      this.Fgv.clear();
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajR().ajA().setLong(352276, System.currentTimeMillis());
      this.FgA = System.currentTimeMillis();
      AppMethodBeat.o(151841);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SuggestionAppListLogic", "offset = %d, count = %s", new Object[] { Integer.valueOf(this.Fgy), Integer.valueOf(paramString.HjN.size()) });
    j localj = a.a.dBn().dBl();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramString.HjN.iterator();
    label1303:
    while (localIterator.hasNext())
    {
      bxa localbxa = (bxa)localIterator.next();
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SuggestionAppListLogic", "service info: %s, %s, %s, %s, %s, %s", new Object[] { localbxa.pqV, Integer.valueOf(localbxa.pqY), Integer.valueOf(localbxa.HjV), Integer.valueOf(localbxa.HjU), Integer.valueOf(localbxa.HjS), localbxa.dwb });
      if ((!bu.isNullOrNil(localbxa.dwb)) && (!bu.isNullOrNil(localbxa.pqV)))
      {
        paramInt1 = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPF, Integer.valueOf(0))).intValue();
        label589:
        g localg;
        label636:
        boolean bool;
        if (g.Ffd.equals(localbxa.dwb))
        {
          localbxa.HjS = (localbxa.HjS ^ 0xFD ^ 0xFFFFFFFF);
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SuggestionAppListLogic", "aa change: %s", new Object[] { Integer.valueOf(localbxa.HjS) });
          this.Fgv.add(localbxa.dwb);
          localg = h.m(localbxa.dwb, true, false);
          if (localg == null) {
            break label1239;
          }
          if (localg.field_serviceAppInfoFlag == localbxa.HjS) {
            break label991;
          }
          paramInt1 = 1;
          paramn = localg;
          if (paramInt1 != 0)
          {
            paramn = localg.eJv;
            String str = localg.eJu;
            a(localg, localbxa);
            bool = localj.a(localg, new String[0]);
            if (!bu.nullAsNil(paramn).equals(bu.nullAsNil(localbxa.HjR)))
            {
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_list" + bu.nullAsNil(localbxa.HjR));
              com.tencent.mm.plugin.s.a.dBe().gf(localg.field_appId, 5);
            }
            if (!bu.nullAsNil(str).equals(bu.nullAsNil(localbxa.HjQ)))
            {
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_panel" + bu.nullAsNil(localbxa.HjQ));
              com.tencent.mm.plugin.s.a.dBe().gf(localg.field_appId, 4);
            }
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SuggestionAppListLogic", "update app: AppID = %s, ret = %s", new Object[] { localbxa.dwb, Boolean.valueOf(bool) });
            paramn = localg;
          }
        }
        for (;;)
        {
          if (!bu.isNullOrNil(paramn.field_openId)) {
            break label1303;
          }
          localLinkedList.add(localbxa.dwb);
          break;
          if (g.Ffc.equals(localbxa.dwb))
          {
            if (localbxa.HjV > 0) {
              break label589;
            }
            if ((v.aAM()) && (v.aAJ() == 0) && (paramInt1 == 1))
            {
              com.tencent.mm.plugin.report.service.g.yxI.dD(965, 33);
              break label589;
            }
            com.tencent.mm.plugin.report.service.g.yxI.dD(965, 35);
            break label589;
          }
          if ((!g.Ffa.equals(localbxa.dwb)) || (localbxa.HjV > 0)) {
            break label589;
          }
          if ((v.aAM()) && (v.aAJ() == 0) && (paramInt1 == 1))
          {
            com.tencent.mm.plugin.report.service.g.yxI.dD(965, 32);
            break label589;
          }
          com.tencent.mm.plugin.report.service.g.yxI.dD(965, 34);
          break label589;
          label991:
          if (localg.field_serviceAppType != localbxa.pqY)
          {
            paramInt1 = 1;
            break label636;
          }
          if (localg.eJx != localbxa.HjU)
          {
            paramInt1 = 1;
            break label636;
          }
          if (localg.field_serviceShowFlag != localbxa.HjV)
          {
            paramInt1 = 1;
            break label636;
          }
          if (!bu.nullAsNil(localg.field_appName).equals(bu.nullAsNil(localbxa.pqV)))
          {
            paramInt1 = 1;
            break label636;
          }
          if (!bu.nullAsNil(localg.field_appName_en).equals(bu.nullAsNil(localbxa.HjO)))
          {
            paramInt1 = 1;
            break label636;
          }
          if (!bu.nullAsNil(localg.field_appName_tw).equals(bu.nullAsNil(localbxa.HjP)))
          {
            paramInt1 = 1;
            break label636;
          }
          if (!bu.nullAsNil(localg.field_appName_hk).equals(bu.nullAsNil(localbxa.HjZ)))
          {
            paramInt1 = 1;
            break label636;
          }
          if (!bu.nullAsNil(localg.eJv).equals(bu.nullAsNil(localbxa.HjR)))
          {
            paramInt1 = 1;
            break label636;
          }
          if (!bu.nullAsNil(localg.eJu).equals(bu.nullAsNil(localbxa.HjQ)))
          {
            paramInt1 = 1;
            break label636;
          }
          if (!bu.nullAsNil(localg.eJw).equals(bu.nullAsNil(localbxa.HjT)))
          {
            paramInt1 = 1;
            break label636;
          }
          paramInt1 = 0;
          break label636;
          label1239:
          paramn = new g();
          paramn.field_appId = localbxa.dwb;
          a(paramn, localbxa);
          bool = localj.q(paramn);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SuggestionAppListLogic", "insert app: AppID = %s, ret = %s", new Object[] { localbxa.dwb, Boolean.valueOf(bool) });
        }
      }
    }
    if (localLinkedList.size() > 0)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SuggestionAppListLogic", "needGetOpenIdList %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
      com.tencent.mm.plugin.s.a.dBi().addAll(localLinkedList);
    }
    if (paramString.HjN.size() == 20)
    {
      this.Fgy += 20;
      gi(this.lang, this.Fgy);
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajR().ajA().setLong(352276, System.currentTimeMillis());
      this.FgA = System.currentTimeMillis();
      AppMethodBeat.o(151841);
      return;
      a(localj, this.Fgv);
      this.Fgy = 0;
      this.Fgv.clear();
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(151840);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SuggestionAppListLogic", "reset getServiceAppList");
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajR().ajA().setLong(352276, 0L);
    this.FgA = 0L;
    this.Fgz = true;
    AppMethodBeat.o(151840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ap
 * JD-Core Version:    0.7.0.1
 */