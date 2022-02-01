package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.y;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.s.a.a.a;
import com.tencent.mm.protocal.protobuf.brs;
import com.tencent.mm.protocal.protobuf.brt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aq
  implements com.tencent.mm.ak.g, u
{
  private static aq Djg;
  public boolean Djh;
  public boolean Dji;
  private List<String> Djj;
  public long Djk;
  private final int Djl;
  private int Djm;
  public boolean Djn;
  private long Djo;
  public String lang;
  
  private aq()
  {
    AppMethodBeat.i(151834);
    this.Djh = false;
    this.Dji = false;
    this.Djj = new LinkedList();
    this.Djl = 20;
    this.Djm = 0;
    this.Djn = false;
    AppMethodBeat.o(151834);
  }
  
  private static void a(g paramg, brt parambrt)
  {
    AppMethodBeat.i(151843);
    paramg.field_appName = parambrt.oGM;
    paramg.field_appName_en = parambrt.FgL;
    paramg.field_appName_tw = parambrt.FgM;
    paramg.field_appName_hk = parambrt.FgW;
    paramg.qc(parambrt.FgN);
    paramg.qd(parambrt.FgO);
    paramg.qe(parambrt.FgQ);
    paramg.field_serviceAppInfoFlag = parambrt.FgP;
    paramg.field_serviceAppType = parambrt.oGP;
    paramg.jz(parambrt.FgR);
    paramg.field_serviceShowFlag = parambrt.FgS;
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
    ac.d("MicroMsg.SuggestionAppListLogic", "removeExpiredServiceApp");
    Object localObject = h.eLb();
    ac.i("MicroMsg.SuggestionAppListLogic", "oldList %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
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
          ac.i("MicroMsg.SuggestionAppListLogic", "delete old service : %s, %s", new Object[] { localg.field_appId, Boolean.valueOf(bool) });
          break;
          AppMethodBeat.o(151842);
          return;
        }
      }
    }
  }
  
  public static aq eLo()
  {
    AppMethodBeat.i(151835);
    if (Djg == null) {
      Djg = new aq();
    }
    aq localaq = Djg;
    AppMethodBeat.o(151835);
    return localaq;
  }
  
  private static void fC(String paramString, int paramInt)
  {
    AppMethodBeat.i(151839);
    ac.i("MicroMsg.SuggestionAppListLogic", "get service app, offset = %d, lang = %s", new Object[] { Integer.valueOf(paramInt), paramString });
    paramString = new af(paramInt, paramString);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(paramString, 0);
    AppMethodBeat.o(151839);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, aa paramaa)
  {
    AppMethodBeat.i(151836);
    if (!com.tencent.mm.kernel.g.agM())
    {
      AppMethodBeat.o(151836);
      return;
    }
    this.Djh = false;
    ac.d("MicroMsg.SuggestionAppListLogic", "Suggestion onSceneEnd errType=%s errCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramaa == null)
    {
      ac.e("MicroMsg.SuggestionAppListLogic", "scene == null");
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
    ac.d("MicroMsg.SuggestionAppListLogic", "get suggestion appList, AppCount = %s", new Object[] { Integer.valueOf(paramString.eLi()) });
    paramString = paramString.Diz;
    if ((paramString == null) || (paramString.size() <= 0))
    {
      ac.w("MicroMsg.SuggestionAppListLogic", "empty suggestAppList");
      AppMethodBeat.o(151836);
      return;
    }
    if ((ai.getContext() == null) || (a.a.dnF() == null))
    {
      ac.e("MicroMsg.SuggestionAppListLogic", "wrong environment");
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
      String str2 = localg.eqs;
      if (localg.eqr != null) {}
      for (boolean bool = true;; bool = false)
      {
        ac.d("MicroMsg.SuggestionAppListLogic", "suggestion appName=%s, packageName=%s, signature [%s], introUrl [%s], has iconUrl [%s]", new Object[] { localObject2, localObject3, str1, str2, Boolean.valueOf(bool) });
        paramaa.add(localg.field_appId);
        break;
      }
    }
    a.a.dnF().aH(paramaa);
    localObject1 = h.hn(ai.getContext());
    if (((List)localObject1).size() > 0)
    {
      paramaa = a.a.dnF().dnD();
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
          if (h.a(ai.getContext(), localg)) {}
          for (localg.field_status = 1;; localg.field_status = 4)
          {
            paramaa.a(localg, new String[0]);
            break;
          }
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agR().agA().setLong(352275, System.currentTimeMillis());
          this.Djk = System.currentTimeMillis();
          break;
        }
      }
    }
  }
  
  public final void hp(Context paramContext)
  {
    AppMethodBeat.i(151837);
    if (!com.tencent.mm.kernel.g.agM())
    {
      AppMethodBeat.o(151837);
      return;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(151837);
      return;
    }
    if (this.Dji)
    {
      ac.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
      AppMethodBeat.o(151837);
      return;
    }
    this.Dji = true;
    if (System.currentTimeMillis() - this.Djo < 43200000L)
    {
      ac.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now");
      this.Dji = false;
      AppMethodBeat.o(151837);
      return;
    }
    com.tencent.mm.kernel.g.agS();
    this.Djo = com.tencent.mm.kernel.g.agR().agA().YH(352276);
    if (System.currentTimeMillis() - this.Djo < 43200000L)
    {
      ac.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now pp");
      this.Dji = false;
      AppMethodBeat.o(151837);
      return;
    }
    if (this.lang == null) {
      this.lang = ab.f(paramContext.getSharedPreferences(ai.eUX(), 0));
    }
    fC(this.lang, this.Djm);
    AppMethodBeat.o(151837);
  }
  
  public final void hq(Context paramContext)
  {
    AppMethodBeat.i(151838);
    if (!com.tencent.mm.kernel.g.agM())
    {
      AppMethodBeat.o(151838);
      return;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(151838);
      return;
    }
    if (this.Dji)
    {
      ac.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
      AppMethodBeat.o(151838);
      return;
    }
    this.Dji = true;
    if (this.lang == null) {
      this.lang = ab.f(paramContext.getSharedPreferences(ai.eUX(), 0));
    }
    ac.i("MicroMsg.SuggestionAppListLogic", "getServiceAppListImmediately");
    fC(this.lang, this.Djm);
    AppMethodBeat.o(151838);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(151841);
    if (!com.tencent.mm.kernel.g.agM())
    {
      ac.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd account not ready");
      this.Djm = 0;
      this.Djj.clear();
      AppMethodBeat.o(151841);
      return;
    }
    this.Dji = false;
    if (paramn == null)
    {
      ac.e("MicroMsg.SuggestionAppListLogic", "scene == null");
      this.Djm = 0;
      this.Djj.clear();
      AppMethodBeat.o(151841);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ac.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      this.Djm = 0;
      this.Djj.clear();
      AppMethodBeat.o(151841);
      return;
    }
    ac.i("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = (af)paramn;
    if ((paramString.rr != null) && (paramString.rr.hvs.hvw != null)) {}
    for (paramString = (brs)paramString.rr.hvs.hvw; paramString == null; paramString = null)
    {
      ac.e("MicroMsg.SuggestionAppListLogic", "resp == null");
      this.Djm = 0;
      this.Djj.clear();
      AppMethodBeat.o(151841);
      return;
    }
    if ((paramString.FgK == null) || (paramString.FgK.size() <= 0))
    {
      ac.e("MicroMsg.SuggestionAppListLogic", "Service_appinfo empty");
      a(a.a.dnF().dnD(), this.Djj);
      this.Djm = 0;
      this.Djj.clear();
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().setLong(352276, System.currentTimeMillis());
      this.Djo = System.currentTimeMillis();
      AppMethodBeat.o(151841);
      return;
    }
    ac.i("MicroMsg.SuggestionAppListLogic", "offset = %d, count = %s", new Object[] { Integer.valueOf(this.Djm), Integer.valueOf(paramString.FgK.size()) });
    j localj = a.a.dnF().dnD();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramString.FgK.iterator();
    label1436:
    while (localIterator.hasNext())
    {
      brt localbrt = (brt)localIterator.next();
      ac.i("MicroMsg.SuggestionAppListLogic", "service info: %s, %s, %s, %s, %s, %s", new Object[] { localbrt.oGM, Integer.valueOf(localbrt.oGP), Integer.valueOf(localbrt.FgS), Integer.valueOf(localbrt.FgR), Integer.valueOf(localbrt.FgP), localbrt.djj });
      if ((!bs.isNullOrNil(localbrt.djj)) && (!bs.isNullOrNil(localbrt.oGM)))
      {
        paramInt1 = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GIP, Integer.valueOf(0))).intValue();
        g localg;
        label636:
        boolean bool;
        if (g.DhV.equals(localbrt.djj))
        {
          localbrt.FgP = (localbrt.FgP ^ 0xFD ^ 0xFFFFFFFF);
          ac.d("MicroMsg.SuggestionAppListLogic", "aa change: %s", new Object[] { Integer.valueOf(localbrt.FgP) });
          this.Djj.add(localbrt.djj);
          localg = h.k(localbrt.djj, true, false);
          if (localg == null) {
            break label1321;
          }
          if (localg.field_serviceAppInfoFlag == localbrt.FgP) {
            break label1073;
          }
          paramInt1 = 1;
          paramn = localg;
          if (paramInt1 != 0)
          {
            paramn = localg.eqD;
            String str = localg.eqC;
            a(localg, localbrt);
            bool = localj.a(localg, new String[0]);
            if (!bs.nullAsNil(paramn).equals(bs.nullAsNil(localbrt.FgO)))
            {
              ac.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_list" + bs.nullAsNil(localbrt.FgO));
              com.tencent.mm.plugin.s.a.dnw().fz(localg.field_appId, 5);
            }
            if (!bs.nullAsNil(str).equals(bs.nullAsNil(localbrt.FgN)))
            {
              ac.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_panel" + bs.nullAsNil(localbrt.FgN));
              com.tencent.mm.plugin.s.a.dnw().fz(localg.field_appId, 4);
            }
            ac.i("MicroMsg.SuggestionAppListLogic", "update app: AppID = %s, ret = %s", new Object[] { localbrt.djj, Boolean.valueOf(bool) });
            paramn = localg;
          }
          label830:
          if (bs.isNullOrNil(paramn.field_openId)) {
            localLinkedList.add(localbrt.djj);
          }
          paramn = h.iX(0, 3).iterator();
        }
        for (;;)
        {
          if (!paramn.hasNext()) {
            break label1436;
          }
          localg = (g)paramn.next();
          if (g.DhS.equals(localg.field_appId))
          {
            ac.i("MicroMsg.SuggestionAppListLogic", "remittance: %s, %s", new Object[] { Integer.valueOf(localg.field_serviceShowFlag), Integer.valueOf(localg.field_appInfoFlag) });
            continue;
            if (g.DhU.equals(localbrt.djj))
            {
              if (localbrt.FgS > 0) {
                break;
              }
              if ((com.tencent.mm.model.u.axG()) && (com.tencent.mm.model.u.axD() == 0) && (paramInt1 == 1))
              {
                com.tencent.mm.plugin.report.service.h.wUl.dB(965, 33);
                break;
              }
              com.tencent.mm.plugin.report.service.h.wUl.dB(965, 35);
              break;
            }
            if ((!g.DhS.equals(localbrt.djj)) || (localbrt.FgS > 0)) {
              break;
            }
            if ((com.tencent.mm.model.u.axG()) && (com.tencent.mm.model.u.axD() == 0) && (paramInt1 == 1))
            {
              com.tencent.mm.plugin.report.service.h.wUl.dB(965, 32);
              break;
            }
            com.tencent.mm.plugin.report.service.h.wUl.dB(965, 34);
            break;
            label1073:
            if (localg.field_serviceAppType != localbrt.oGP)
            {
              paramInt1 = 1;
              break label636;
            }
            if (localg.eqF != localbrt.FgR)
            {
              paramInt1 = 1;
              break label636;
            }
            if (localg.field_serviceShowFlag != localbrt.FgS)
            {
              paramInt1 = 1;
              break label636;
            }
            if (!bs.nullAsNil(localg.field_appName).equals(bs.nullAsNil(localbrt.oGM)))
            {
              paramInt1 = 1;
              break label636;
            }
            if (!bs.nullAsNil(localg.field_appName_en).equals(bs.nullAsNil(localbrt.FgL)))
            {
              paramInt1 = 1;
              break label636;
            }
            if (!bs.nullAsNil(localg.field_appName_tw).equals(bs.nullAsNil(localbrt.FgM)))
            {
              paramInt1 = 1;
              break label636;
            }
            if (!bs.nullAsNil(localg.field_appName_hk).equals(bs.nullAsNil(localbrt.FgW)))
            {
              paramInt1 = 1;
              break label636;
            }
            if (!bs.nullAsNil(localg.eqD).equals(bs.nullAsNil(localbrt.FgO)))
            {
              paramInt1 = 1;
              break label636;
            }
            if (!bs.nullAsNil(localg.eqC).equals(bs.nullAsNil(localbrt.FgN)))
            {
              paramInt1 = 1;
              break label636;
            }
            if (!bs.nullAsNil(localg.eqE).equals(bs.nullAsNil(localbrt.FgQ)))
            {
              paramInt1 = 1;
              break label636;
            }
            paramInt1 = 0;
            break label636;
            label1321:
            paramn = new g();
            paramn.field_appId = localbrt.djj;
            a(paramn, localbrt);
            bool = localj.q(paramn);
            ac.i("MicroMsg.SuggestionAppListLogic", "insert app: AppID = %s, ret = %s", new Object[] { localbrt.djj, Boolean.valueOf(bool) });
            break label830;
          }
          if (g.DhU.equals(localg.field_appId)) {
            ac.i("MicroMsg.SuggestionAppListLogic", "lucky: %s, %s", new Object[] { Integer.valueOf(localg.field_serviceShowFlag), Integer.valueOf(localg.field_appInfoFlag) });
          }
        }
      }
    }
    if (localLinkedList.size() > 0)
    {
      ac.i("MicroMsg.SuggestionAppListLogic", "needGetOpenIdList %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
      com.tencent.mm.plugin.s.a.dnA().addAll(localLinkedList);
    }
    if (paramString.FgK.size() == 20)
    {
      this.Djm += 20;
      fC(this.lang, this.Djm);
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().setLong(352276, System.currentTimeMillis());
      this.Djo = System.currentTimeMillis();
      AppMethodBeat.o(151841);
      return;
      a(localj, this.Djj);
      this.Djm = 0;
      this.Djj.clear();
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(151840);
    ac.i("MicroMsg.SuggestionAppListLogic", "reset getServiceAppList");
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agR().agA().setLong(352276, 0L);
    this.Djo = 0L;
    this.Djn = true;
    AppMethodBeat.o(151840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.aq
 * JD-Core Version:    0.7.0.1
 */