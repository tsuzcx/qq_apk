package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.openapi.a.a.a;
import com.tencent.mm.protocal.protobuf.dkm;
import com.tencent.mm.protocal.protobuf.dkn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class at
  implements com.tencent.mm.am.h, y
{
  private static at XTC;
  public boolean XTD;
  public boolean XTE;
  private List<String> XTF;
  public long XTG;
  private final int XTH;
  private int XTI;
  public boolean XTJ;
  private long XTK;
  public String lang;
  
  private at()
  {
    AppMethodBeat.i(151834);
    this.XTD = false;
    this.XTE = false;
    this.XTF = new LinkedList();
    this.XTH = 20;
    this.XTI = 0;
    this.XTJ = false;
    AppMethodBeat.o(151834);
  }
  
  private static void a(g paramg, dkn paramdkn)
  {
    AppMethodBeat.i(151843);
    paramg.field_appName = paramdkn.xlJ;
    paramg.field_appName_en = paramdkn.aaQt;
    paramg.field_appName_tw = paramdkn.aaQu;
    paramg.field_appName_hk = paramdkn.aaQE;
    paramg.AR(paramdkn.aaQv);
    paramg.AS(paramdkn.aaQw);
    paramg.AT(paramdkn.aaQy);
    paramg.field_serviceAppInfoFlag = paramdkn.aaQx;
    paramg.field_serviceAppType = paramdkn.xlL;
    paramg.pn(paramdkn.aaQz);
    paramg.field_serviceShowFlag = paramdkn.aaQA;
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
    Object localObject = h.iIv();
    Log.i("MicroMsg.SuggestionAppListLogic", "oldList %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      localObject = ((List)localObject).iterator();
    }
    label216:
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
            break label216;
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
  
  public static at iIM()
  {
    AppMethodBeat.i(151835);
    if (XTC == null) {
      XTC = new at();
    }
    at localat = XTC;
    AppMethodBeat.o(151835);
    return localat;
  }
  
  private static void iu(String paramString, int paramInt)
  {
    AppMethodBeat.i(151839);
    Log.i("MicroMsg.SuggestionAppListLogic", "get service app, offset = %d, lang = %s", new Object[] { Integer.valueOf(paramInt), paramString });
    paramString = new ai(paramInt, paramString);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramString, 0);
    AppMethodBeat.o(151839);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, ae paramae)
  {
    AppMethodBeat.i(151836);
    if (!com.tencent.mm.kernel.h.baz())
    {
      AppMethodBeat.o(151836);
      return;
    }
    this.XTD = false;
    Log.d("MicroMsg.SuggestionAppListLogic", "Suggestion onSceneEnd errType=%s errCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramae == null)
    {
      Log.e("MicroMsg.SuggestionAppListLogic", "scene == null");
      AppMethodBeat.o(151836);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    switch (paramae.getType())
    {
    default: 
      AppMethodBeat.o(151836);
      return;
    }
    paramString = (aj)paramae;
    Log.d("MicroMsg.SuggestionAppListLogic", "get suggestion appList, AppCount = %s", new Object[] { Integer.valueOf(paramString.iIE()) });
    paramString = paramString.XSR;
    if ((paramString == null) || (paramString.size() <= 0))
    {
      Log.w("MicroMsg.SuggestionAppListLogic", "empty suggestAppList");
      AppMethodBeat.o(151836);
      return;
    }
    if ((MMApplicationContext.getContext() == null) || (a.a.gxu() == null))
    {
      Log.e("MicroMsg.SuggestionAppListLogic", "wrong environment");
      AppMethodBeat.o(151836);
      return;
    }
    paramae = new LinkedList();
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
      String str2 = localg.jOy;
      if (localg.jOx != null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.d("MicroMsg.SuggestionAppListLogic", "suggestion appName=%s, packageName=%s, signature [%s], introUrl [%s], has iconUrl [%s]", new Object[] { localObject2, localObject3, str1, str2, Boolean.valueOf(bool) });
        paramae.add(localg.field_appId);
        break;
      }
    }
    a.a.gxu().bJ(paramae);
    localObject1 = h.ls(MMApplicationContext.getContext());
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      paramae = a.a.gxu().gxs();
      localObject1 = ((List)localObject1).iterator();
    }
    label535:
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
            break label535;
          }
          if (h.a(MMApplicationContext.getContext(), localg)) {}
          for (localg.field_status = 1;; localg.field_status = 4)
          {
            paramae.a(localg, new String[0]);
            break;
          }
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baE().ban().setLong(352275, System.currentTimeMillis());
          this.XTG = System.currentTimeMillis();
          break;
        }
      }
    }
  }
  
  public final void lu(Context paramContext)
  {
    AppMethodBeat.i(151837);
    if (!com.tencent.mm.kernel.h.baz())
    {
      AppMethodBeat.o(151837);
      return;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(151837);
      return;
    }
    if (this.XTE)
    {
      Log.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
      AppMethodBeat.o(151837);
      return;
    }
    this.XTE = true;
    if (System.currentTimeMillis() - this.XTK < 43200000L)
    {
      Log.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now");
      this.XTE = false;
      AppMethodBeat.o(151837);
      return;
    }
    com.tencent.mm.kernel.h.baF();
    this.XTK = com.tencent.mm.kernel.h.baE().ban().amW(352276);
    if (System.currentTimeMillis() - this.XTK < 43200000L)
    {
      Log.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now pp");
      this.XTE = false;
      AppMethodBeat.o(151837);
      return;
    }
    if (this.lang == null) {
      this.lang = LocaleUtil.loadApplicationLanguage(paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), paramContext);
    }
    iu(this.lang, this.XTI);
    AppMethodBeat.o(151837);
  }
  
  public final void lv(Context paramContext)
  {
    AppMethodBeat.i(151838);
    if (!com.tencent.mm.kernel.h.baz())
    {
      AppMethodBeat.o(151838);
      return;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(151838);
      return;
    }
    if (this.XTE)
    {
      Log.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
      AppMethodBeat.o(151838);
      return;
    }
    this.XTE = true;
    if (this.lang == null) {
      this.lang = LocaleUtil.loadApplicationLanguage(paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), paramContext);
    }
    Log.i("MicroMsg.SuggestionAppListLogic", "getServiceAppListImmediately");
    iu(this.lang, this.XTI);
    AppMethodBeat.o(151838);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(151841);
    if (!com.tencent.mm.kernel.h.baz())
    {
      Log.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd account not ready");
      this.XTI = 0;
      this.XTF.clear();
      AppMethodBeat.o(151841);
      return;
    }
    this.XTE = false;
    if (paramp == null)
    {
      Log.e("MicroMsg.SuggestionAppListLogic", "scene == null");
      this.XTI = 0;
      this.XTF.clear();
      AppMethodBeat.o(151841);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      this.XTI = 0;
      this.XTF.clear();
      AppMethodBeat.o(151841);
      return;
    }
    Log.i("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = (ai)paramp;
    if ((paramString.rr != null) && (c.c.b(paramString.rr.otC) != null)) {}
    for (paramString = (dkm)c.c.b(paramString.rr.otC); paramString == null; paramString = null)
    {
      Log.e("MicroMsg.SuggestionAppListLogic", "resp == null");
      this.XTI = 0;
      this.XTF.clear();
      AppMethodBeat.o(151841);
      return;
    }
    if ((paramString.aaQs == null) || (paramString.aaQs.size() <= 0))
    {
      Log.e("MicroMsg.SuggestionAppListLogic", "Service_appinfo empty");
      a(a.a.gxu().gxs(), this.XTF);
      this.XTI = 0;
      this.XTF.clear();
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().setLong(352276, System.currentTimeMillis());
      this.XTK = System.currentTimeMillis();
      AppMethodBeat.o(151841);
      return;
    }
    Log.i("MicroMsg.SuggestionAppListLogic", "offset = %d, count = %s", new Object[] { Integer.valueOf(this.XTI), Integer.valueOf(paramString.aaQs.size()) });
    j localj = a.a.gxu().gxs();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramString.aaQs.iterator();
    label1303:
    while (localIterator.hasNext())
    {
      dkn localdkn = (dkn)localIterator.next();
      Log.i("MicroMsg.SuggestionAppListLogic", "service info: %s, %s, %s, %s, %s, %s", new Object[] { localdkn.xlJ, Integer.valueOf(localdkn.xlL), Integer.valueOf(localdkn.aaQA), Integer.valueOf(localdkn.aaQz), Integer.valueOf(localdkn.aaQx), localdkn.appid });
      if ((!Util.isNullOrNil(localdkn.appid)) && (!Util.isNullOrNil(localdkn.xlJ)))
      {
        paramInt1 = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNa, Integer.valueOf(0))).intValue();
        label589:
        g localg;
        label636:
        boolean bool;
        if (g.XSe.equals(localdkn.appid))
        {
          localdkn.aaQx = (localdkn.aaQx ^ 0xFD ^ 0xFFFFFFFF);
          Log.d("MicroMsg.SuggestionAppListLogic", "aa change: %s", new Object[] { Integer.valueOf(localdkn.aaQx) });
          this.XTF.add(localdkn.appid);
          localg = h.s(localdkn.appid, true, false);
          if (localg == null) {
            break label1239;
          }
          if (localg.field_serviceAppInfoFlag == localdkn.aaQx) {
            break label991;
          }
          paramInt1 = 1;
          paramp = localg;
          if (paramInt1 != 0)
          {
            paramp = localg.jOJ;
            String str = localg.jOI;
            a(localg, localdkn);
            bool = localj.a(localg, new String[0]);
            if (!Util.nullAsNil(paramp).equals(Util.nullAsNil(localdkn.aaQw)))
            {
              Log.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_list" + Util.nullAsNil(localdkn.aaQw));
              com.tencent.mm.plugin.openapi.a.gxl().ir(localg.field_appId, 5);
            }
            if (!Util.nullAsNil(str).equals(Util.nullAsNil(localdkn.aaQv)))
            {
              Log.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_panel" + Util.nullAsNil(localdkn.aaQv));
              com.tencent.mm.plugin.openapi.a.gxl().ir(localg.field_appId, 4);
            }
            Log.i("MicroMsg.SuggestionAppListLogic", "update app: AppID = %s, ret = %s", new Object[] { localdkn.appid, Boolean.valueOf(bool) });
            paramp = localg;
          }
        }
        for (;;)
        {
          if (!Util.isNullOrNil(paramp.field_openId)) {
            break label1303;
          }
          localLinkedList.add(localdkn.appid);
          break;
          if (g.XSd.equals(localdkn.appid))
          {
            if (localdkn.aaQA > 0) {
              break label589;
            }
            if ((com.tencent.mm.model.z.bBd()) && (com.tencent.mm.model.z.bAV() == 0) && (paramInt1 == 1))
            {
              com.tencent.mm.plugin.report.service.h.OAn.kJ(965, 33);
              break label589;
            }
            com.tencent.mm.plugin.report.service.h.OAn.kJ(965, 35);
            break label589;
          }
          if ((!g.XSb.equals(localdkn.appid)) || (localdkn.aaQA > 0)) {
            break label589;
          }
          if ((com.tencent.mm.model.z.bBd()) && (com.tencent.mm.model.z.bAV() == 0) && (paramInt1 == 1))
          {
            com.tencent.mm.plugin.report.service.h.OAn.kJ(965, 32);
            break label589;
          }
          com.tencent.mm.plugin.report.service.h.OAn.kJ(965, 34);
          break label589;
          label991:
          if (localg.field_serviceAppType != localdkn.xlL)
          {
            paramInt1 = 1;
            break label636;
          }
          if (localg.jOL != localdkn.aaQz)
          {
            paramInt1 = 1;
            break label636;
          }
          if (localg.field_serviceShowFlag != localdkn.aaQA)
          {
            paramInt1 = 1;
            break label636;
          }
          if (!Util.nullAsNil(localg.field_appName).equals(Util.nullAsNil(localdkn.xlJ)))
          {
            paramInt1 = 1;
            break label636;
          }
          if (!Util.nullAsNil(localg.field_appName_en).equals(Util.nullAsNil(localdkn.aaQt)))
          {
            paramInt1 = 1;
            break label636;
          }
          if (!Util.nullAsNil(localg.field_appName_tw).equals(Util.nullAsNil(localdkn.aaQu)))
          {
            paramInt1 = 1;
            break label636;
          }
          if (!Util.nullAsNil(localg.field_appName_hk).equals(Util.nullAsNil(localdkn.aaQE)))
          {
            paramInt1 = 1;
            break label636;
          }
          if (!Util.nullAsNil(localg.jOJ).equals(Util.nullAsNil(localdkn.aaQw)))
          {
            paramInt1 = 1;
            break label636;
          }
          if (!Util.nullAsNil(localg.jOI).equals(Util.nullAsNil(localdkn.aaQv)))
          {
            paramInt1 = 1;
            break label636;
          }
          if (!Util.nullAsNil(localg.jOK).equals(Util.nullAsNil(localdkn.aaQy)))
          {
            paramInt1 = 1;
            break label636;
          }
          paramInt1 = 0;
          break label636;
          label1239:
          paramp = new g();
          paramp.field_appId = localdkn.appid;
          a(paramp, localdkn);
          bool = localj.r(paramp);
          Log.i("MicroMsg.SuggestionAppListLogic", "insert app: AppID = %s, ret = %s", new Object[] { localdkn.appid, Boolean.valueOf(bool) });
        }
      }
    }
    if (localLinkedList.size() > 0)
    {
      Log.i("MicroMsg.SuggestionAppListLogic", "needGetOpenIdList %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
      com.tencent.mm.plugin.openapi.a.gxp().addAll(localLinkedList);
    }
    if (paramString.aaQs.size() == 20)
    {
      this.XTI += 20;
      iu(this.lang, this.XTI);
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().setLong(352276, System.currentTimeMillis());
      this.XTK = System.currentTimeMillis();
      AppMethodBeat.o(151841);
      return;
      a(localj, this.XTF);
      this.XTI = 0;
      this.XTF.clear();
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(151840);
    Log.i("MicroMsg.SuggestionAppListLogic", "reset getServiceAppList");
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baE().ban().setLong(352276, 0L);
    this.XTK = 0L;
    this.XTJ = true;
    AppMethodBeat.o(151840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.at
 * JD-Core Version:    0.7.0.1
 */