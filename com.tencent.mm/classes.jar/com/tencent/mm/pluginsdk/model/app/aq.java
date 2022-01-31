package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.r;
import com.tencent.mm.plugin.z.a.a.a;
import com.tencent.mm.protocal.c.akx;
import com.tencent.mm.protocal.c.aut;
import com.tencent.mm.protocal.c.auu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aq
  implements com.tencent.mm.ah.f, t
{
  private static aq rVp;
  public String lang;
  public boolean rVq = false;
  public boolean rVr = false;
  private List<String> rVs = new LinkedList();
  public long rVt;
  private final int rVu = 20;
  private int rVv = 0;
  public boolean rVw = false;
  private long rVx;
  
  private static void a(f paramf, auu paramauu)
  {
    paramf.field_appName = paramauu.sLq;
    paramf.field_appName_en = paramauu.tql;
    paramf.field_appName_tw = paramauu.tqm;
    paramf.field_appName_hk = paramauu.tqx;
    paramf.cvQ = paramauu.tqn;
    paramf.cuS = true;
    paramf.cvR = paramauu.tqo;
    paramf.cuS = true;
    paramf.cvS = paramauu.tqr;
    paramf.cuS = true;
    paramf.field_serviceAppInfoFlag = paramauu.tqq;
    paramf.field_serviceAppType = paramauu.tqp;
    paramf.cvT = paramauu.tqs;
    paramf.cuS = true;
    paramf.field_serviceShowFlag = paramauu.tqt;
  }
  
  private static void a(i parami, List<String> paramList)
  {
    if ((parami == null) || (paramList == null) || (paramList.size() <= 0)) {}
    label47:
    do
    {
      return;
      y.d("MicroMsg.SuggestionAppListLogic", "removeExpiredServiceApp");
      localObject1 = new ArrayList();
      if (a.a.bru() != null) {
        break;
      }
      y.e("MicroMsg.AppInfoLogic", "getAllServices, getISubCorePluginBase() == null");
      y.d("MicroMsg.SuggestionAppListLogic", "oldList %d", new Object[] { Integer.valueOf(((List)localObject1).size()) });
    } while (((List)localObject1).size() <= 0);
    Object localObject1 = ((List)localObject1).iterator();
    label287:
    for (;;)
    {
      label90:
      Object localObject2;
      Object localObject3;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (f)((Iterator)localObject1).next();
        if (((f)localObject2).field_appId != null)
        {
          localObject3 = paramList.iterator();
          String str;
          do
          {
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            str = (String)((Iterator)localObject3).next();
          } while (!((f)localObject2).field_appId.equals(str));
        }
      }
      else
      {
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label287;
          }
          boolean bool = parami.b((f)localObject2, new String[0]);
          y.d("MicroMsg.SuggestionAppListLogic", "delete old service : %s, %s", new Object[] { ((f)localObject2).field_appId, Boolean.valueOf(bool) });
          break label90;
          break;
          localObject2 = a.a.bru().brt();
          if (localObject2 == null) {
            break label47;
          }
          while (((Cursor)localObject2).moveToNext())
          {
            localObject3 = new f();
            ((f)localObject3).d((Cursor)localObject2);
            if (!bk.bl(((f)localObject3).field_openId)) {
              ((List)localObject1).add(localObject3);
            }
          }
          ((Cursor)localObject2).close();
          break label47;
        }
      }
    }
  }
  
  public static aq clf()
  {
    if (rVp == null) {
      rVp = new aq();
    }
    return rVp;
  }
  
  private static void dj(String paramString, int paramInt)
  {
    y.i("MicroMsg.SuggestionAppListLogic", "get service app, offset = %d, lang = %s", new Object[] { Integer.valueOf(paramInt), paramString });
    paramString = new ag(paramInt, paramString);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(paramString, 0);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, x paramx)
  {
    if (!com.tencent.mm.kernel.g.DK()) {}
    do
    {
      return;
      this.rVq = false;
      y.d("MicroMsg.SuggestionAppListLogic", "Suggestion onSceneEnd errType=%s errCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramx == null)
      {
        y.e("MicroMsg.SuggestionAppListLogic", "scene == null");
        return;
      }
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    switch (paramx.getType())
    {
    default: 
      return;
    }
    paramString = (ah)paramx;
    y.d("MicroMsg.SuggestionAppListLogic", "get suggestion appList, AppCount = %s", new Object[] { Integer.valueOf(((akx)paramString.jvQ.ecF.ecN).tha) });
    paramString = paramString.rUN;
    if ((paramString == null) || (paramString.size() <= 0))
    {
      y.w("MicroMsg.SuggestionAppListLogic", "empty suggestAppList");
      return;
    }
    if ((ae.getContext() == null) || (a.a.bru() == null))
    {
      y.e("MicroMsg.SuggestionAppListLogic", "wrong environment");
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
      String str2 = localf.cvG;
      if (localf.cvF != null) {}
      for (boolean bool = true;; bool = false)
      {
        y.d("MicroMsg.SuggestionAppListLogic", "suggestion appName=%s, packageName=%s, signature [%s], introUrl [%s], has iconUrl [%s]", new Object[] { localObject2, localObject3, str1, str2, Boolean.valueOf(bool) });
        paramx.add(localf.field_appId);
        break;
      }
    }
    a.a.bru().ad(paramx);
    localObject1 = g.eQ(ae.getContext());
    if (((List)localObject1).size() > 0)
    {
      paramx = a.a.bru().brs();
      localObject1 = ((List)localObject1).iterator();
    }
    label513:
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
            break label513;
          }
          if (g.a(ae.getContext(), localf)) {}
          for (localf.field_status = 1;; localf.field_status = 4)
          {
            paramx.a(localf, new String[0]);
            break;
          }
          com.tencent.mm.kernel.g.DQ();
          com.tencent.mm.kernel.g.DP().Dz().setLong(352275, System.currentTimeMillis());
          this.rVt = System.currentTimeMillis();
          return;
        }
      }
    }
  }
  
  public final void eS(Context paramContext)
  {
    if (!com.tencent.mm.kernel.g.DK()) {}
    while (paramContext == null) {
      return;
    }
    if (this.rVr)
    {
      y.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
      return;
    }
    this.rVr = true;
    if (System.currentTimeMillis() - this.rVx < 43200000L)
    {
      y.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now");
      this.rVr = false;
      return;
    }
    com.tencent.mm.kernel.g.DQ();
    this.rVx = com.tencent.mm.kernel.g.DP().Dz().Fm(352276);
    if (System.currentTimeMillis() - this.rVx < 43200000L)
    {
      y.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now pp");
      this.rVr = false;
      return;
    }
    if (this.lang == null) {
      this.lang = com.tencent.mm.sdk.platformtools.x.d(paramContext.getSharedPreferences(ae.cqR(), 0));
    }
    dj(this.lang, this.rVv);
  }
  
  public final void eT(Context paramContext)
  {
    if (!com.tencent.mm.kernel.g.DK()) {}
    while (paramContext == null) {
      return;
    }
    if (this.rVr)
    {
      y.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
      return;
    }
    this.rVr = true;
    if (this.lang == null) {
      this.lang = com.tencent.mm.sdk.platformtools.x.d(paramContext.getSharedPreferences(ae.cqR(), 0));
    }
    y.i("MicroMsg.SuggestionAppListLogic", "getServiceAppListImmediately");
    dj(this.lang, this.rVv);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if (!com.tencent.mm.kernel.g.DK())
    {
      y.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd account not ready");
      this.rVv = 0;
      this.rVs.clear();
      return;
    }
    this.rVr = false;
    if (paramm == null)
    {
      y.e("MicroMsg.SuggestionAppListLogic", "scene == null");
      this.rVv = 0;
      this.rVs.clear();
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      this.rVv = 0;
      this.rVs.clear();
      return;
    }
    y.i("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = (ag)paramm;
    if ((paramString.dmK != null) && (paramString.dmK.ecF.ecN != null)) {}
    for (paramString = (aut)paramString.dmK.ecF.ecN; paramString == null; paramString = null)
    {
      y.e("MicroMsg.SuggestionAppListLogic", "resp == null");
      this.rVv = 0;
      this.rVs.clear();
      return;
    }
    if ((paramString.tqk == null) || (paramString.tqk.size() <= 0))
    {
      y.e("MicroMsg.SuggestionAppListLogic", "Service_appinfo empty");
      a(a.a.bru().brs(), this.rVs);
      this.rVv = 0;
      this.rVs.clear();
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DP().Dz().setLong(352276, System.currentTimeMillis());
      this.rVx = System.currentTimeMillis();
      return;
    }
    y.i("MicroMsg.SuggestionAppListLogic", "offset = %d, count = %s", new Object[] { Integer.valueOf(this.rVv), Integer.valueOf(paramString.tqk.size()) });
    i locali = a.a.bru().brs();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramString.tqk.iterator();
    label566:
    label1099:
    while (localIterator.hasNext())
    {
      auu localauu = (auu)localIterator.next();
      y.v("MicroMsg.SuggestionAppListLogic", "service info: %s, %s, %s, %s, %s, %s", new Object[] { localauu.sLq, Integer.valueOf(localauu.tqp), Integer.valueOf(localauu.tqt), Integer.valueOf(localauu.tqs), Integer.valueOf(localauu.tqq), localauu.bOL });
      if (!bk.bl(localauu.bOL))
      {
        if (f.rUd.equals(localauu.bOL))
        {
          localauu.tqq = (localauu.tqq ^ 0xFD ^ 0xFFFFFFFF);
          y.d("MicroMsg.SuggestionAppListLogic", "aa change: %s", new Object[] { Integer.valueOf(localauu.tqq) });
        }
        this.rVs.add(localauu.bOL);
        f localf = g.by(localauu.bOL, true);
        boolean bool;
        if (localf != null) {
          if (localf.field_serviceAppInfoFlag != localauu.tqq)
          {
            paramInt1 = 1;
            paramm = localf;
            if (paramInt1 != 0)
            {
              paramm = localf.cvR;
              String str = localf.cvQ;
              a(localf, localauu);
              bool = locali.a(localf, new String[0]);
              if (!bk.pm(paramm).equals(bk.pm(localauu.tqo)))
              {
                y.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_list" + bk.pm(localauu.tqo));
                com.tencent.mm.plugin.z.a.brl().dg(localf.field_appId, 5);
              }
              if (!bk.pm(str).equals(bk.pm(localauu.tqn)))
              {
                y.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_panel" + bk.pm(localauu.tqn));
                com.tencent.mm.plugin.z.a.brl().dg(localf.field_appId, 4);
              }
              y.i("MicroMsg.SuggestionAppListLogic", "update app: AppID = %s, ret = %s", new Object[] { localauu.bOL, Boolean.valueOf(bool) });
              paramm = localf;
            }
          }
        }
        for (;;)
        {
          if (!bk.bl(paramm.field_openId)) {
            break label1099;
          }
          localLinkedList.add(localauu.bOL);
          break;
          if (localf.field_serviceAppType != localauu.tqp)
          {
            paramInt1 = 1;
            break label566;
          }
          if (localf.cvT != localauu.tqs)
          {
            paramInt1 = 1;
            break label566;
          }
          if (localf.field_serviceShowFlag != localauu.tqt)
          {
            paramInt1 = 1;
            break label566;
          }
          if (!bk.pm(localf.field_appName).equals(bk.pm(localauu.sLq)))
          {
            paramInt1 = 1;
            break label566;
          }
          if (!bk.pm(localf.field_appName_en).equals(bk.pm(localauu.tql)))
          {
            paramInt1 = 1;
            break label566;
          }
          if (!bk.pm(localf.field_appName_tw).equals(bk.pm(localauu.tqm)))
          {
            paramInt1 = 1;
            break label566;
          }
          if (!bk.pm(localf.field_appName_hk).equals(bk.pm(localauu.tqx)))
          {
            paramInt1 = 1;
            break label566;
          }
          if (!bk.pm(localf.cvR).equals(bk.pm(localauu.tqo)))
          {
            paramInt1 = 1;
            break label566;
          }
          if (!bk.pm(localf.cvQ).equals(bk.pm(localauu.tqn)))
          {
            paramInt1 = 1;
            break label566;
          }
          if (!bk.pm(localf.cvS).equals(bk.pm(localauu.tqr)))
          {
            paramInt1 = 1;
            break label566;
          }
          paramInt1 = 0;
          break label566;
          paramm = new f();
          paramm.field_appId = localauu.bOL;
          a(paramm, localauu);
          bool = locali.l(paramm);
          y.i("MicroMsg.SuggestionAppListLogic", "insert app: AppID = %s, ret = %s", new Object[] { localauu.bOL, Boolean.valueOf(bool) });
        }
      }
    }
    if (localLinkedList.size() > 0)
    {
      y.d("MicroMsg.SuggestionAppListLogic", "needGetOpenIdList %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
      com.tencent.mm.plugin.z.a.brp().addAll(localLinkedList);
    }
    if (paramString.tqk.size() == 20)
    {
      this.rVv += 20;
      dj(this.lang, this.rVv);
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DP().Dz().setLong(352276, System.currentTimeMillis());
      this.rVx = System.currentTimeMillis();
      return;
      a(locali, this.rVs);
      this.rVv = 0;
      this.rVs.clear();
    }
  }
  
  public final void reset()
  {
    y.i("MicroMsg.SuggestionAppListLogic", "reset getServiceAppList");
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DP().Dz().setLong(352276, 0L);
    this.rVx = 0L;
    this.rVw = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.aq
 * JD-Core Version:    0.7.0.1
 */