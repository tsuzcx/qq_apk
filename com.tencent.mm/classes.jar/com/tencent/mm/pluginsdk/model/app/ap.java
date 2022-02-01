package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.y;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.s.a.a.a;
import com.tencent.mm.protocal.protobuf.bwf;
import com.tencent.mm.protocal.protobuf.bwg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ap
  implements com.tencent.mm.al.f, u
{
  private static ap ENW;
  public boolean ENX;
  public boolean ENY;
  private List<String> ENZ;
  public long EOa;
  private final int EOb;
  private int EOc;
  public boolean EOd;
  private long EOe;
  public String lang;
  
  private ap()
  {
    AppMethodBeat.i(151834);
    this.ENX = false;
    this.ENY = false;
    this.ENZ = new LinkedList();
    this.EOb = 20;
    this.EOc = 0;
    this.EOd = false;
    AppMethodBeat.o(151834);
  }
  
  private static void a(g paramg, bwg parambwg)
  {
    AppMethodBeat.i(151843);
    paramg.field_appName = parambwg.pkq;
    paramg.field_appName_en = parambwg.GQn;
    paramg.field_appName_tw = parambwg.GQo;
    paramg.field_appName_hk = parambwg.GQy;
    paramg.sM(parambwg.GQp);
    paramg.sN(parambwg.GQq);
    paramg.sO(parambwg.GQs);
    paramg.field_serviceAppInfoFlag = parambwg.GQr;
    paramg.field_serviceAppType = parambwg.pkt;
    paramg.jX(parambwg.GQt);
    paramg.field_serviceShowFlag = parambwg.GQu;
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
    Object localObject = h.eZV();
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
  
  private static void fZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(151839);
    ad.i("MicroMsg.SuggestionAppListLogic", "get service app, offset = %d, lang = %s", new Object[] { Integer.valueOf(paramInt), paramString });
    paramString = new ae(paramInt, paramString);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(paramString, 0);
    AppMethodBeat.o(151839);
  }
  
  public static ap faj()
  {
    AppMethodBeat.i(151835);
    if (ENW == null) {
      ENW = new ap();
    }
    ap localap = ENW;
    AppMethodBeat.o(151835);
    return localap;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, aa paramaa)
  {
    AppMethodBeat.i(151836);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      AppMethodBeat.o(151836);
      return;
    }
    this.ENX = false;
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
    paramString = (af)paramaa;
    ad.d("MicroMsg.SuggestionAppListLogic", "get suggestion appList, AppCount = %s", new Object[] { Integer.valueOf(paramString.fac()) });
    paramString = paramString.ENm;
    if ((paramString == null) || (paramString.size() <= 0))
    {
      ad.w("MicroMsg.SuggestionAppListLogic", "empty suggestAppList");
      AppMethodBeat.o(151836);
      return;
    }
    if ((aj.getContext() == null) || (a.a.dxX() == null))
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
      String str2 = localg.eHB;
      if (localg.eHA != null) {}
      for (boolean bool = true;; bool = false)
      {
        ad.d("MicroMsg.SuggestionAppListLogic", "suggestion appName=%s, packageName=%s, signature [%s], introUrl [%s], has iconUrl [%s]", new Object[] { localObject2, localObject3, str1, str2, Boolean.valueOf(bool) });
        paramaa.add(localg.field_appId);
        break;
      }
    }
    a.a.dxX().aI(paramaa);
    localObject1 = h.hs(aj.getContext());
    if (((List)localObject1).size() > 0)
    {
      paramaa = a.a.dxX().dxV();
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
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajC().ajl().setLong(352275, System.currentTimeMillis());
          this.EOa = System.currentTimeMillis();
          break;
        }
      }
    }
  }
  
  public final void hu(Context paramContext)
  {
    AppMethodBeat.i(151837);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      AppMethodBeat.o(151837);
      return;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(151837);
      return;
    }
    if (this.ENY)
    {
      ad.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
      AppMethodBeat.o(151837);
      return;
    }
    this.ENY = true;
    if (System.currentTimeMillis() - this.EOe < 43200000L)
    {
      ad.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now");
      this.ENY = false;
      AppMethodBeat.o(151837);
      return;
    }
    com.tencent.mm.kernel.g.ajD();
    this.EOe = com.tencent.mm.kernel.g.ajC().ajl().aaQ(352276);
    if (System.currentTimeMillis() - this.EOe < 43200000L)
    {
      ad.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now pp");
      this.ENY = false;
      AppMethodBeat.o(151837);
      return;
    }
    if (this.lang == null) {
      this.lang = ac.f(paramContext.getSharedPreferences(aj.fkC(), 0));
    }
    fZ(this.lang, this.EOc);
    AppMethodBeat.o(151837);
  }
  
  public final void hv(Context paramContext)
  {
    AppMethodBeat.i(151838);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      AppMethodBeat.o(151838);
      return;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(151838);
      return;
    }
    if (this.ENY)
    {
      ad.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
      AppMethodBeat.o(151838);
      return;
    }
    this.ENY = true;
    if (this.lang == null) {
      this.lang = ac.f(paramContext.getSharedPreferences(aj.fkC(), 0));
    }
    ad.i("MicroMsg.SuggestionAppListLogic", "getServiceAppListImmediately");
    fZ(this.lang, this.EOc);
    AppMethodBeat.o(151838);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(151841);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      ad.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd account not ready");
      this.EOc = 0;
      this.ENZ.clear();
      AppMethodBeat.o(151841);
      return;
    }
    this.ENY = false;
    if (paramn == null)
    {
      ad.e("MicroMsg.SuggestionAppListLogic", "scene == null");
      this.EOc = 0;
      this.ENZ.clear();
      AppMethodBeat.o(151841);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ad.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      this.EOc = 0;
      this.ENZ.clear();
      AppMethodBeat.o(151841);
      return;
    }
    ad.i("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = (ae)paramn;
    if ((paramString.rr != null) && (paramString.rr.hNL.hNQ != null)) {}
    for (paramString = (bwf)paramString.rr.hNL.hNQ; paramString == null; paramString = null)
    {
      ad.e("MicroMsg.SuggestionAppListLogic", "resp == null");
      this.EOc = 0;
      this.ENZ.clear();
      AppMethodBeat.o(151841);
      return;
    }
    if ((paramString.GQm == null) || (paramString.GQm.size() <= 0))
    {
      ad.e("MicroMsg.SuggestionAppListLogic", "Service_appinfo empty");
      a(a.a.dxX().dxV(), this.ENZ);
      this.EOc = 0;
      this.ENZ.clear();
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajC().ajl().setLong(352276, System.currentTimeMillis());
      this.EOe = System.currentTimeMillis();
      AppMethodBeat.o(151841);
      return;
    }
    ad.i("MicroMsg.SuggestionAppListLogic", "offset = %d, count = %s", new Object[] { Integer.valueOf(this.EOc), Integer.valueOf(paramString.GQm.size()) });
    j localj = a.a.dxX().dxV();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramString.GQm.iterator();
    label1303:
    while (localIterator.hasNext())
    {
      bwg localbwg = (bwg)localIterator.next();
      ad.i("MicroMsg.SuggestionAppListLogic", "service info: %s, %s, %s, %s, %s, %s", new Object[] { localbwg.pkq, Integer.valueOf(localbwg.pkt), Integer.valueOf(localbwg.GQu), Integer.valueOf(localbwg.GQt), Integer.valueOf(localbwg.GQr), localbwg.duW });
      if ((!bt.isNullOrNil(localbwg.duW)) && (!bt.isNullOrNil(localbwg.pkq)))
      {
        paramInt1 = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ivh, Integer.valueOf(0))).intValue();
        label589:
        g localg;
        label636:
        boolean bool;
        if (g.EMG.equals(localbwg.duW))
        {
          localbwg.GQr = (localbwg.GQr ^ 0xFD ^ 0xFFFFFFFF);
          ad.d("MicroMsg.SuggestionAppListLogic", "aa change: %s", new Object[] { Integer.valueOf(localbwg.GQr) });
          this.ENZ.add(localbwg.duW);
          localg = h.m(localbwg.duW, true, false);
          if (localg == null) {
            break label1239;
          }
          if (localg.field_serviceAppInfoFlag == localbwg.GQr) {
            break label991;
          }
          paramInt1 = 1;
          paramn = localg;
          if (paramInt1 != 0)
          {
            paramn = localg.eHM;
            String str = localg.eHL;
            a(localg, localbwg);
            bool = localj.a(localg, new String[0]);
            if (!bt.nullAsNil(paramn).equals(bt.nullAsNil(localbwg.GQq)))
            {
              ad.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_list" + bt.nullAsNil(localbwg.GQq));
              com.tencent.mm.plugin.s.a.dxO().fW(localg.field_appId, 5);
            }
            if (!bt.nullAsNil(str).equals(bt.nullAsNil(localbwg.GQp)))
            {
              ad.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_panel" + bt.nullAsNil(localbwg.GQp));
              com.tencent.mm.plugin.s.a.dxO().fW(localg.field_appId, 4);
            }
            ad.i("MicroMsg.SuggestionAppListLogic", "update app: AppID = %s, ret = %s", new Object[] { localbwg.duW, Boolean.valueOf(bool) });
            paramn = localg;
          }
        }
        for (;;)
        {
          if (!bt.isNullOrNil(paramn.field_openId)) {
            break label1303;
          }
          localLinkedList.add(localbwg.duW);
          break;
          if (g.EMF.equals(localbwg.duW))
          {
            if (localbwg.GQu > 0) {
              break label589;
            }
            if ((com.tencent.mm.model.u.aAw()) && (com.tencent.mm.model.u.aAt() == 0) && (paramInt1 == 1))
            {
              com.tencent.mm.plugin.report.service.g.yhR.dD(965, 33);
              break label589;
            }
            com.tencent.mm.plugin.report.service.g.yhR.dD(965, 35);
            break label589;
          }
          if ((!g.EMD.equals(localbwg.duW)) || (localbwg.GQu > 0)) {
            break label589;
          }
          if ((com.tencent.mm.model.u.aAw()) && (com.tencent.mm.model.u.aAt() == 0) && (paramInt1 == 1))
          {
            com.tencent.mm.plugin.report.service.g.yhR.dD(965, 32);
            break label589;
          }
          com.tencent.mm.plugin.report.service.g.yhR.dD(965, 34);
          break label589;
          label991:
          if (localg.field_serviceAppType != localbwg.pkt)
          {
            paramInt1 = 1;
            break label636;
          }
          if (localg.eHO != localbwg.GQt)
          {
            paramInt1 = 1;
            break label636;
          }
          if (localg.field_serviceShowFlag != localbwg.GQu)
          {
            paramInt1 = 1;
            break label636;
          }
          if (!bt.nullAsNil(localg.field_appName).equals(bt.nullAsNil(localbwg.pkq)))
          {
            paramInt1 = 1;
            break label636;
          }
          if (!bt.nullAsNil(localg.field_appName_en).equals(bt.nullAsNil(localbwg.GQn)))
          {
            paramInt1 = 1;
            break label636;
          }
          if (!bt.nullAsNil(localg.field_appName_tw).equals(bt.nullAsNil(localbwg.GQo)))
          {
            paramInt1 = 1;
            break label636;
          }
          if (!bt.nullAsNil(localg.field_appName_hk).equals(bt.nullAsNil(localbwg.GQy)))
          {
            paramInt1 = 1;
            break label636;
          }
          if (!bt.nullAsNil(localg.eHM).equals(bt.nullAsNil(localbwg.GQq)))
          {
            paramInt1 = 1;
            break label636;
          }
          if (!bt.nullAsNil(localg.eHL).equals(bt.nullAsNil(localbwg.GQp)))
          {
            paramInt1 = 1;
            break label636;
          }
          if (!bt.nullAsNil(localg.eHN).equals(bt.nullAsNil(localbwg.GQs)))
          {
            paramInt1 = 1;
            break label636;
          }
          paramInt1 = 0;
          break label636;
          label1239:
          paramn = new g();
          paramn.field_appId = localbwg.duW;
          a(paramn, localbwg);
          bool = localj.q(paramn);
          ad.i("MicroMsg.SuggestionAppListLogic", "insert app: AppID = %s, ret = %s", new Object[] { localbwg.duW, Boolean.valueOf(bool) });
        }
      }
    }
    if (localLinkedList.size() > 0)
    {
      ad.i("MicroMsg.SuggestionAppListLogic", "needGetOpenIdList %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
      com.tencent.mm.plugin.s.a.dxS().addAll(localLinkedList);
    }
    if (paramString.GQm.size() == 20)
    {
      this.EOc += 20;
      fZ(this.lang, this.EOc);
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajC().ajl().setLong(352276, System.currentTimeMillis());
      this.EOe = System.currentTimeMillis();
      AppMethodBeat.o(151841);
      return;
      a(localj, this.ENZ);
      this.EOc = 0;
      this.ENZ.clear();
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(151840);
    ad.i("MicroMsg.SuggestionAppListLogic", "reset getServiceAppList");
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajC().ajl().setLong(352276, 0L);
    this.EOe = 0L;
    this.EOd = true;
    AppMethodBeat.o(151840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ap
 * JD-Core Version:    0.7.0.1
 */