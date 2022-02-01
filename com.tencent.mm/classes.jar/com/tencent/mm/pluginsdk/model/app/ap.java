package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.c.y;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.ab.a.a.a;
import com.tencent.mm.protocal.protobuf.ctk;
import com.tencent.mm.protocal.protobuf.ctl;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ap
  implements i, u
{
  private static ap QXE;
  public boolean QXF;
  public boolean QXG;
  private List<String> QXH;
  public long QXI;
  private final int QXJ;
  private int QXK;
  public boolean QXL;
  private long QXM;
  public String lang;
  
  private ap()
  {
    AppMethodBeat.i(151834);
    this.QXF = false;
    this.QXG = false;
    this.QXH = new LinkedList();
    this.QXJ = 20;
    this.QXK = 0;
    this.QXL = false;
    AppMethodBeat.o(151834);
  }
  
  private static void a(g paramg, ctl paramctl)
  {
    AppMethodBeat.i(151843);
    paramg.field_appName = paramctl.ufB;
    paramg.field_appName_en = paramctl.TBf;
    paramg.field_appName_tw = paramctl.TBg;
    paramg.field_appName_hk = paramctl.TBq;
    paramg.Im(paramctl.TBh);
    paramg.In(paramctl.TBi);
    paramg.Io(paramctl.TBk);
    paramg.field_serviceAppInfoFlag = paramctl.TBj;
    paramg.field_serviceAppType = paramctl.ufE;
    paramg.po(paramctl.TBl);
    paramg.field_serviceShowFlag = paramctl.TBm;
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
    Log.d("MicroMsg.SuggestionAppListLogic", "removeExpiredServiceApp");
    Object localObject = h.hhv();
    Log.i("MicroMsg.SuggestionAppListLogic", "oldList %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
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
          Log.i("MicroMsg.SuggestionAppListLogic", "delete old service : %s, %s", new Object[] { localg.field_appId, Boolean.valueOf(bool) });
          break;
          AppMethodBeat.o(151842);
          return;
        }
      }
    }
  }
  
  public static ap hhK()
  {
    AppMethodBeat.i(151835);
    if (QXE == null) {
      QXE = new ap();
    }
    ap localap = QXE;
    AppMethodBeat.o(151835);
    return localap;
  }
  
  private static void hp(String paramString, int paramInt)
  {
    AppMethodBeat.i(151839);
    Log.i("MicroMsg.SuggestionAppListLogic", "get service app, offset = %d, lang = %s", new Object[] { Integer.valueOf(paramInt), paramString });
    paramString = new ae(paramInt, paramString);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(paramString, 0);
    AppMethodBeat.o(151839);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, aa paramaa)
  {
    AppMethodBeat.i(151836);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      AppMethodBeat.o(151836);
      return;
    }
    this.QXF = false;
    Log.d("MicroMsg.SuggestionAppListLogic", "Suggestion onSceneEnd errType=%s errCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramaa == null)
    {
      Log.e("MicroMsg.SuggestionAppListLogic", "scene == null");
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
    Log.d("MicroMsg.SuggestionAppListLogic", "get suggestion appList, AppCount = %s", new Object[] { Integer.valueOf(paramString.hhC()) });
    paramString = paramString.QWT;
    if ((paramString == null) || (paramString.size() <= 0))
    {
      Log.w("MicroMsg.SuggestionAppListLogic", "empty suggestAppList");
      AppMethodBeat.o(151836);
      return;
    }
    if ((MMApplicationContext.getContext() == null) || (a.a.fmG() == null))
    {
      Log.e("MicroMsg.SuggestionAppListLogic", "wrong environment");
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
      String str2 = localg.hrL;
      if (localg.hrK != null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.d("MicroMsg.SuggestionAppListLogic", "suggestion appName=%s, packageName=%s, signature [%s], introUrl [%s], has iconUrl [%s]", new Object[] { localObject2, localObject3, str1, str2, Boolean.valueOf(bool) });
        paramaa.add(localg.field_appId);
        break;
      }
    }
    a.a.fmG().bA(paramaa);
    localObject1 = h.jv(MMApplicationContext.getContext());
    if (((List)localObject1).size() > 0)
    {
      paramaa = a.a.fmG().fmE();
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
          if (h.a(MMApplicationContext.getContext(), localg)) {}
          for (localg.field_status = 1;; localg.field_status = 4)
          {
            paramaa.a(localg, new String[0]);
            break;
          }
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHG().aHp().setLong(352275, System.currentTimeMillis());
          this.QXI = System.currentTimeMillis();
          break;
        }
      }
    }
  }
  
  public final void jx(Context paramContext)
  {
    AppMethodBeat.i(151837);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      AppMethodBeat.o(151837);
      return;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(151837);
      return;
    }
    if (this.QXG)
    {
      Log.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
      AppMethodBeat.o(151837);
      return;
    }
    this.QXG = true;
    if (System.currentTimeMillis() - this.QXM < 43200000L)
    {
      Log.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now");
      this.QXG = false;
      AppMethodBeat.o(151837);
      return;
    }
    com.tencent.mm.kernel.h.aHH();
    this.QXM = com.tencent.mm.kernel.h.aHG().aHp().ahV(352276);
    if (System.currentTimeMillis() - this.QXM < 43200000L)
    {
      Log.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now pp");
      this.QXG = false;
      AppMethodBeat.o(151837);
      return;
    }
    if (this.lang == null) {
      this.lang = LocaleUtil.loadApplicationLanguage(paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), paramContext);
    }
    hp(this.lang, this.QXK);
    AppMethodBeat.o(151837);
  }
  
  public final void jy(Context paramContext)
  {
    AppMethodBeat.i(151838);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      AppMethodBeat.o(151838);
      return;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(151838);
      return;
    }
    if (this.QXG)
    {
      Log.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
      AppMethodBeat.o(151838);
      return;
    }
    this.QXG = true;
    if (this.lang == null) {
      this.lang = LocaleUtil.loadApplicationLanguage(paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), paramContext);
    }
    Log.i("MicroMsg.SuggestionAppListLogic", "getServiceAppListImmediately");
    hp(this.lang, this.QXK);
    AppMethodBeat.o(151838);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(151841);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      Log.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd account not ready");
      this.QXK = 0;
      this.QXH.clear();
      AppMethodBeat.o(151841);
      return;
    }
    this.QXG = false;
    if (paramq == null)
    {
      Log.e("MicroMsg.SuggestionAppListLogic", "scene == null");
      this.QXK = 0;
      this.QXH.clear();
      AppMethodBeat.o(151841);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      this.QXK = 0;
      this.QXH.clear();
      AppMethodBeat.o(151841);
      return;
    }
    Log.i("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = (ae)paramq;
    if ((paramString.rr != null) && (d.c.b(paramString.rr.lBS) != null)) {}
    for (paramString = (ctk)d.c.b(paramString.rr.lBS); paramString == null; paramString = null)
    {
      Log.e("MicroMsg.SuggestionAppListLogic", "resp == null");
      this.QXK = 0;
      this.QXH.clear();
      AppMethodBeat.o(151841);
      return;
    }
    if ((paramString.TBe == null) || (paramString.TBe.size() <= 0))
    {
      Log.e("MicroMsg.SuggestionAppListLogic", "Service_appinfo empty");
      a(a.a.fmG().fmE(), this.QXH);
      this.QXK = 0;
      this.QXH.clear();
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().setLong(352276, System.currentTimeMillis());
      this.QXM = System.currentTimeMillis();
      AppMethodBeat.o(151841);
      return;
    }
    Log.i("MicroMsg.SuggestionAppListLogic", "offset = %d, count = %s", new Object[] { Integer.valueOf(this.QXK), Integer.valueOf(paramString.TBe.size()) });
    j localj = a.a.fmG().fmE();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramString.TBe.iterator();
    label1303:
    while (localIterator.hasNext())
    {
      ctl localctl = (ctl)localIterator.next();
      Log.i("MicroMsg.SuggestionAppListLogic", "service info: %s, %s, %s, %s, %s, %s", new Object[] { localctl.ufB, Integer.valueOf(localctl.ufE), Integer.valueOf(localctl.TBm), Integer.valueOf(localctl.TBl), Integer.valueOf(localctl.TBj), localctl.appid });
      if ((!Util.isNullOrNil(localctl.appid)) && (!Util.isNullOrNil(localctl.ufB)))
      {
        paramInt1 = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlG, Integer.valueOf(0))).intValue();
        label589:
        g localg;
        label636:
        boolean bool;
        if (g.QWh.equals(localctl.appid))
        {
          localctl.TBj = (localctl.TBj ^ 0xFD ^ 0xFFFFFFFF);
          Log.d("MicroMsg.SuggestionAppListLogic", "aa change: %s", new Object[] { Integer.valueOf(localctl.TBj) });
          this.QXH.add(localctl.appid);
          localg = h.o(localctl.appid, true, false);
          if (localg == null) {
            break label1239;
          }
          if (localg.field_serviceAppInfoFlag == localctl.TBj) {
            break label991;
          }
          paramInt1 = 1;
          paramq = localg;
          if (paramInt1 != 0)
          {
            paramq = localg.hrW;
            String str = localg.hrV;
            a(localg, localctl);
            bool = localj.a(localg, new String[0]);
            if (!Util.nullAsNil(paramq).equals(Util.nullAsNil(localctl.TBi)))
            {
              Log.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_list" + Util.nullAsNil(localctl.TBi));
              com.tencent.mm.plugin.ab.a.fmx().hm(localg.field_appId, 5);
            }
            if (!Util.nullAsNil(str).equals(Util.nullAsNil(localctl.TBh)))
            {
              Log.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_panel" + Util.nullAsNil(localctl.TBh));
              com.tencent.mm.plugin.ab.a.fmx().hm(localg.field_appId, 4);
            }
            Log.i("MicroMsg.SuggestionAppListLogic", "update app: AppID = %s, ret = %s", new Object[] { localctl.appid, Boolean.valueOf(bool) });
            paramq = localg;
          }
        }
        for (;;)
        {
          if (!Util.isNullOrNil(paramq.field_openId)) {
            break label1303;
          }
          localLinkedList.add(localctl.appid);
          break;
          if (g.QWg.equals(localctl.appid))
          {
            if (localctl.TBm > 0) {
              break label589;
            }
            if ((z.bdl()) && (z.bdg() == 0) && (paramInt1 == 1))
            {
              com.tencent.mm.plugin.report.service.h.IzE.el(965, 33);
              break label589;
            }
            com.tencent.mm.plugin.report.service.h.IzE.el(965, 35);
            break label589;
          }
          if ((!g.QWe.equals(localctl.appid)) || (localctl.TBm > 0)) {
            break label589;
          }
          if ((z.bdl()) && (z.bdg() == 0) && (paramInt1 == 1))
          {
            com.tencent.mm.plugin.report.service.h.IzE.el(965, 32);
            break label589;
          }
          com.tencent.mm.plugin.report.service.h.IzE.el(965, 34);
          break label589;
          label991:
          if (localg.field_serviceAppType != localctl.ufE)
          {
            paramInt1 = 1;
            break label636;
          }
          if (localg.hrY != localctl.TBl)
          {
            paramInt1 = 1;
            break label636;
          }
          if (localg.field_serviceShowFlag != localctl.TBm)
          {
            paramInt1 = 1;
            break label636;
          }
          if (!Util.nullAsNil(localg.field_appName).equals(Util.nullAsNil(localctl.ufB)))
          {
            paramInt1 = 1;
            break label636;
          }
          if (!Util.nullAsNil(localg.field_appName_en).equals(Util.nullAsNil(localctl.TBf)))
          {
            paramInt1 = 1;
            break label636;
          }
          if (!Util.nullAsNil(localg.field_appName_tw).equals(Util.nullAsNil(localctl.TBg)))
          {
            paramInt1 = 1;
            break label636;
          }
          if (!Util.nullAsNil(localg.field_appName_hk).equals(Util.nullAsNil(localctl.TBq)))
          {
            paramInt1 = 1;
            break label636;
          }
          if (!Util.nullAsNil(localg.hrW).equals(Util.nullAsNil(localctl.TBi)))
          {
            paramInt1 = 1;
            break label636;
          }
          if (!Util.nullAsNil(localg.hrV).equals(Util.nullAsNil(localctl.TBh)))
          {
            paramInt1 = 1;
            break label636;
          }
          if (!Util.nullAsNil(localg.hrX).equals(Util.nullAsNil(localctl.TBk)))
          {
            paramInt1 = 1;
            break label636;
          }
          paramInt1 = 0;
          break label636;
          label1239:
          paramq = new g();
          paramq.field_appId = localctl.appid;
          a(paramq, localctl);
          bool = localj.r(paramq);
          Log.i("MicroMsg.SuggestionAppListLogic", "insert app: AppID = %s, ret = %s", new Object[] { localctl.appid, Boolean.valueOf(bool) });
        }
      }
    }
    if (localLinkedList.size() > 0)
    {
      Log.i("MicroMsg.SuggestionAppListLogic", "needGetOpenIdList %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
      com.tencent.mm.plugin.ab.a.fmB().addAll(localLinkedList);
    }
    if (paramString.TBe.size() == 20)
    {
      this.QXK += 20;
      hp(this.lang, this.QXK);
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().setLong(352276, System.currentTimeMillis());
      this.QXM = System.currentTimeMillis();
      AppMethodBeat.o(151841);
      return;
      a(localj, this.QXH);
      this.QXK = 0;
      this.QXH.clear();
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(151840);
    Log.i("MicroMsg.SuggestionAppListLogic", "reset getServiceAppList");
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHG().aHp().setLong(352276, 0L);
    this.QXM = 0L;
    this.QXL = true;
    AppMethodBeat.o(151840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ap
 * JD-Core Version:    0.7.0.1
 */