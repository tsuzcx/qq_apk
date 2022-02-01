package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.c.y;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.r.a.a.a;
import com.tencent.mm.protocal.protobuf.ckr;
import com.tencent.mm.protocal.protobuf.cks;
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
  private static ap JXk;
  public boolean JXl;
  public boolean JXm;
  private List<String> JXn;
  public long JXo;
  private final int JXp;
  private int JXq;
  public boolean JXr;
  private long JXs;
  public String lang;
  
  private ap()
  {
    AppMethodBeat.i(151834);
    this.JXl = false;
    this.JXm = false;
    this.JXn = new LinkedList();
    this.JXp = 20;
    this.JXq = 0;
    this.JXr = false;
    AppMethodBeat.o(151834);
  }
  
  private static void a(g paramg, cks paramcks)
  {
    AppMethodBeat.i(151843);
    paramg.field_appName = paramcks.qGA;
    paramg.field_appName_en = paramcks.Mqc;
    paramg.field_appName_tw = paramcks.Mqd;
    paramg.field_appName_hk = paramcks.Mqn;
    paramg.By(paramcks.Mqe);
    paramg.Bz(paramcks.Mqf);
    paramg.BA(paramcks.Mqh);
    paramg.field_serviceAppInfoFlag = paramcks.Mqg;
    paramg.field_serviceAppType = paramcks.qGD;
    paramg.nb(paramcks.Mqi);
    paramg.field_serviceShowFlag = paramcks.Mqj;
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
    Object localObject = h.gmU();
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
  
  private static void gG(String paramString, int paramInt)
  {
    AppMethodBeat.i(151839);
    Log.i("MicroMsg.SuggestionAppListLogic", "get service app, offset = %d, lang = %s", new Object[] { Integer.valueOf(paramInt), paramString });
    paramString = new ae(paramInt, paramString);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(paramString, 0);
    AppMethodBeat.o(151839);
  }
  
  public static ap gni()
  {
    AppMethodBeat.i(151835);
    if (JXk == null) {
      JXk = new ap();
    }
    ap localap = JXk;
    AppMethodBeat.o(151835);
    return localap;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, aa paramaa)
  {
    AppMethodBeat.i(151836);
    if (!com.tencent.mm.kernel.g.aAc())
    {
      AppMethodBeat.o(151836);
      return;
    }
    this.JXl = false;
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
    Log.d("MicroMsg.SuggestionAppListLogic", "get suggestion appList, AppCount = %s", new Object[] { Integer.valueOf(paramString.gnb()) });
    paramString = paramString.JWA;
    if ((paramString == null) || (paramString.size() <= 0))
    {
      Log.w("MicroMsg.SuggestionAppListLogic", "empty suggestAppList");
      AppMethodBeat.o(151836);
      return;
    }
    if ((MMApplicationContext.getContext() == null) || (a.a.eAZ() == null))
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
      String str2 = localg.fmM;
      if (localg.fmL != null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.d("MicroMsg.SuggestionAppListLogic", "suggestion appName=%s, packageName=%s, signature [%s], introUrl [%s], has iconUrl [%s]", new Object[] { localObject2, localObject3, str1, str2, Boolean.valueOf(bool) });
        paramaa.add(localg.field_appId);
        break;
      }
    }
    a.a.eAZ().bg(paramaa);
    localObject1 = h.is(MMApplicationContext.getContext());
    if (((List)localObject1).size() > 0)
    {
      paramaa = a.a.eAZ().eAX();
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
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAh().azQ().setLong(352275, System.currentTimeMillis());
          this.JXo = System.currentTimeMillis();
          break;
        }
      }
    }
  }
  
  public final void iu(Context paramContext)
  {
    AppMethodBeat.i(151837);
    if (!com.tencent.mm.kernel.g.aAc())
    {
      AppMethodBeat.o(151837);
      return;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(151837);
      return;
    }
    if (this.JXm)
    {
      Log.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
      AppMethodBeat.o(151837);
      return;
    }
    this.JXm = true;
    if (System.currentTimeMillis() - this.JXs < 43200000L)
    {
      Log.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now");
      this.JXm = false;
      AppMethodBeat.o(151837);
      return;
    }
    com.tencent.mm.kernel.g.aAi();
    this.JXs = com.tencent.mm.kernel.g.aAh().azQ().akg(352276);
    if (System.currentTimeMillis() - this.JXs < 43200000L)
    {
      Log.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now pp");
      this.JXm = false;
      AppMethodBeat.o(151837);
      return;
    }
    if (this.lang == null) {
      this.lang = LocaleUtil.loadApplicationLanguage(paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), paramContext);
    }
    gG(this.lang, this.JXq);
    AppMethodBeat.o(151837);
  }
  
  public final void iv(Context paramContext)
  {
    AppMethodBeat.i(151838);
    if (!com.tencent.mm.kernel.g.aAc())
    {
      AppMethodBeat.o(151838);
      return;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(151838);
      return;
    }
    if (this.JXm)
    {
      Log.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
      AppMethodBeat.o(151838);
      return;
    }
    this.JXm = true;
    if (this.lang == null) {
      this.lang = LocaleUtil.loadApplicationLanguage(paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), paramContext);
    }
    Log.i("MicroMsg.SuggestionAppListLogic", "getServiceAppListImmediately");
    gG(this.lang, this.JXq);
    AppMethodBeat.o(151838);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(151841);
    if (!com.tencent.mm.kernel.g.aAc())
    {
      Log.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd account not ready");
      this.JXq = 0;
      this.JXn.clear();
      AppMethodBeat.o(151841);
      return;
    }
    this.JXm = false;
    if (paramq == null)
    {
      Log.e("MicroMsg.SuggestionAppListLogic", "scene == null");
      this.JXq = 0;
      this.JXn.clear();
      AppMethodBeat.o(151841);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      this.JXq = 0;
      this.JXn.clear();
      AppMethodBeat.o(151841);
      return;
    }
    Log.i("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = (ae)paramq;
    if ((paramString.rr != null) && (paramString.rr.iLL.iLR != null)) {}
    for (paramString = (ckr)paramString.rr.iLL.iLR; paramString == null; paramString = null)
    {
      Log.e("MicroMsg.SuggestionAppListLogic", "resp == null");
      this.JXq = 0;
      this.JXn.clear();
      AppMethodBeat.o(151841);
      return;
    }
    if ((paramString.Mqb == null) || (paramString.Mqb.size() <= 0))
    {
      Log.e("MicroMsg.SuggestionAppListLogic", "Service_appinfo empty");
      a(a.a.eAZ().eAX(), this.JXn);
      this.JXq = 0;
      this.JXn.clear();
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().setLong(352276, System.currentTimeMillis());
      this.JXs = System.currentTimeMillis();
      AppMethodBeat.o(151841);
      return;
    }
    Log.i("MicroMsg.SuggestionAppListLogic", "offset = %d, count = %s", new Object[] { Integer.valueOf(this.JXq), Integer.valueOf(paramString.Mqb.size()) });
    j localj = a.a.eAZ().eAX();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramString.Mqb.iterator();
    label1303:
    while (localIterator.hasNext())
    {
      cks localcks = (cks)localIterator.next();
      Log.i("MicroMsg.SuggestionAppListLogic", "service info: %s, %s, %s, %s, %s, %s", new Object[] { localcks.qGA, Integer.valueOf(localcks.qGD), Integer.valueOf(localcks.Mqj), Integer.valueOf(localcks.Mqi), Integer.valueOf(localcks.Mqg), localcks.dNI });
      if ((!Util.isNullOrNil(localcks.dNI)) && (!Util.isNullOrNil(localcks.qGA)))
      {
        paramInt1 = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NXG, Integer.valueOf(0))).intValue();
        label589:
        g localg;
        label636:
        boolean bool;
        if (g.JVU.equals(localcks.dNI))
        {
          localcks.Mqg = (localcks.Mqg ^ 0xFD ^ 0xFFFFFFFF);
          Log.d("MicroMsg.SuggestionAppListLogic", "aa change: %s", new Object[] { Integer.valueOf(localcks.Mqg) });
          this.JXn.add(localcks.dNI);
          localg = h.o(localcks.dNI, true, false);
          if (localg == null) {
            break label1239;
          }
          if (localg.field_serviceAppInfoFlag == localcks.Mqg) {
            break label991;
          }
          paramInt1 = 1;
          paramq = localg;
          if (paramInt1 != 0)
          {
            paramq = localg.fmX;
            String str = localg.fmW;
            a(localg, localcks);
            bool = localj.a(localg, new String[0]);
            if (!Util.nullAsNil(paramq).equals(Util.nullAsNil(localcks.Mqf)))
            {
              Log.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_list" + Util.nullAsNil(localcks.Mqf));
              com.tencent.mm.plugin.r.a.eAQ().gD(localg.field_appId, 5);
            }
            if (!Util.nullAsNil(str).equals(Util.nullAsNil(localcks.Mqe)))
            {
              Log.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_panel" + Util.nullAsNil(localcks.Mqe));
              com.tencent.mm.plugin.r.a.eAQ().gD(localg.field_appId, 4);
            }
            Log.i("MicroMsg.SuggestionAppListLogic", "update app: AppID = %s, ret = %s", new Object[] { localcks.dNI, Boolean.valueOf(bool) });
            paramq = localg;
          }
        }
        for (;;)
        {
          if (!Util.isNullOrNil(paramq.field_openId)) {
            break label1303;
          }
          localLinkedList.add(localcks.dNI);
          break;
          if (g.JVT.equals(localcks.dNI))
          {
            if (localcks.Mqj > 0) {
              break label589;
            }
            if ((z.aUj()) && (z.aUf() == 0) && (paramInt1 == 1))
            {
              com.tencent.mm.plugin.report.service.h.CyF.dN(965, 33);
              break label589;
            }
            com.tencent.mm.plugin.report.service.h.CyF.dN(965, 35);
            break label589;
          }
          if ((!g.JVR.equals(localcks.dNI)) || (localcks.Mqj > 0)) {
            break label589;
          }
          if ((z.aUj()) && (z.aUf() == 0) && (paramInt1 == 1))
          {
            com.tencent.mm.plugin.report.service.h.CyF.dN(965, 32);
            break label589;
          }
          com.tencent.mm.plugin.report.service.h.CyF.dN(965, 34);
          break label589;
          label991:
          if (localg.field_serviceAppType != localcks.qGD)
          {
            paramInt1 = 1;
            break label636;
          }
          if (localg.fmZ != localcks.Mqi)
          {
            paramInt1 = 1;
            break label636;
          }
          if (localg.field_serviceShowFlag != localcks.Mqj)
          {
            paramInt1 = 1;
            break label636;
          }
          if (!Util.nullAsNil(localg.field_appName).equals(Util.nullAsNil(localcks.qGA)))
          {
            paramInt1 = 1;
            break label636;
          }
          if (!Util.nullAsNil(localg.field_appName_en).equals(Util.nullAsNil(localcks.Mqc)))
          {
            paramInt1 = 1;
            break label636;
          }
          if (!Util.nullAsNil(localg.field_appName_tw).equals(Util.nullAsNil(localcks.Mqd)))
          {
            paramInt1 = 1;
            break label636;
          }
          if (!Util.nullAsNil(localg.field_appName_hk).equals(Util.nullAsNil(localcks.Mqn)))
          {
            paramInt1 = 1;
            break label636;
          }
          if (!Util.nullAsNil(localg.fmX).equals(Util.nullAsNil(localcks.Mqf)))
          {
            paramInt1 = 1;
            break label636;
          }
          if (!Util.nullAsNil(localg.fmW).equals(Util.nullAsNil(localcks.Mqe)))
          {
            paramInt1 = 1;
            break label636;
          }
          if (!Util.nullAsNil(localg.fmY).equals(Util.nullAsNil(localcks.Mqh)))
          {
            paramInt1 = 1;
            break label636;
          }
          paramInt1 = 0;
          break label636;
          label1239:
          paramq = new g();
          paramq.field_appId = localcks.dNI;
          a(paramq, localcks);
          bool = localj.r(paramq);
          Log.i("MicroMsg.SuggestionAppListLogic", "insert app: AppID = %s, ret = %s", new Object[] { localcks.dNI, Boolean.valueOf(bool) });
        }
      }
    }
    if (localLinkedList.size() > 0)
    {
      Log.i("MicroMsg.SuggestionAppListLogic", "needGetOpenIdList %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
      com.tencent.mm.plugin.r.a.eAU().addAll(localLinkedList);
    }
    if (paramString.Mqb.size() == 20)
    {
      this.JXq += 20;
      gG(this.lang, this.JXq);
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().setLong(352276, System.currentTimeMillis());
      this.JXs = System.currentTimeMillis();
      AppMethodBeat.o(151841);
      return;
      a(localj, this.JXn);
      this.JXq = 0;
      this.JXn.clear();
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(151840);
    Log.i("MicroMsg.SuggestionAppListLogic", "reset getServiceAppList");
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAh().azQ().setLong(352276, 0L);
    this.JXs = 0L;
    this.JXr = true;
    AppMethodBeat.o(151840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ap
 * JD-Core Version:    0.7.0.1
 */