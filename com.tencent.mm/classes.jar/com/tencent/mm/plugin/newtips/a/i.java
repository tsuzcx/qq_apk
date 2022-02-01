package com.tencent.mm.plugin.newtips.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.newtips.PluginNewTips;
import com.tencent.mm.plugin.newtips.PluginNewTips.a;
import com.tencent.mm.protocal.protobuf.dcb;
import com.tencent.mm.protocal.protobuf.dcc;
import com.tencent.mm.protocal.protobuf.dcd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class i
  implements com.tencent.mm.al.g
{
  private static HashMap<Integer, WeakReference<a>> ueq;
  private static HashMap<String, WeakReference<a>> uer;
  public a ues = null;
  
  static
  {
    AppMethodBeat.i(127251);
    ueq = new HashMap();
    uer = new HashMap();
    AppMethodBeat.o(127251);
  }
  
  public static void In(int paramInt)
  {
    AppMethodBeat.i(127241);
    com.tencent.mm.plugin.newtips.b.a locala = com.tencent.mm.plugin.newtips.a.cWt().Is(paramInt);
    if (locala == null)
    {
      ad.e("MicroMsg.NewTips.NewTipsManager", "newTipsInfo is null , makeRead failed!!");
      AppMethodBeat.o(127241);
      return;
    }
    ad.i("MicroMsg.NewTips.NewTipsManager", "dancy new tips tipsId:%s, make read: %s", new Object[] { Integer.valueOf(paramInt), Boolean.TRUE });
    if (locala.field_tipType == d.udP)
    {
      locala.field_hadRead = true;
      com.tencent.mm.plugin.newtips.a.cWt().a(locala, new String[0]);
    }
    if (locala.field_tipType == d.udQ)
    {
      locala.field_hadRead = true;
      com.tencent.mm.plugin.newtips.a.cWt().a(locala, new String[0]);
    }
    long l = bt.eGO();
    aj.getContext().getSharedPreferences(aj.eFD() + "_newtips_report", 0).edit().putLong("newtips_makeread_time", l).commit();
    AppMethodBeat.o(127241);
  }
  
  public static void Iq(int paramInt)
  {
    AppMethodBeat.i(202387);
    com.tencent.mm.plugin.newtips.a.cWs().Io(paramInt);
    AppMethodBeat.o(202387);
  }
  
  private void a(WeakReference<a> paramWeakReference, com.tencent.mm.plugin.newtips.b.e parame)
  {
    AppMethodBeat.i(189170);
    if (paramWeakReference == null)
    {
      ad.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() weakReference(%s) is null", new Object[] { parame });
      AppMethodBeat.o(189170);
      return;
    }
    paramWeakReference = (a)paramWeakReference.get();
    if (paramWeakReference == null)
    {
      ad.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() curNewTip(%s) is null", new Object[] { parame });
      AppMethodBeat.o(189170);
      return;
    }
    if (g.c(paramWeakReference))
    {
      ad.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() curNewTip(%s) is show old new tip", new Object[] { parame });
      AppMethodBeat.o(189170);
      return;
    }
    Pair localPair = b(parame);
    ad.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() path:%s show %s [%s,%s,%s]", new Object[] { parame, ((k)localPair.first).ueB, ((dcb)localPair.second).title, ((dcb)localPair.second).url, Integer.valueOf(((dcb)localPair.second).glx) });
    boolean bool2;
    if (g.a(parame, (k)localPair.first))
    {
      k localk = g.e(paramWeakReference);
      if (g.a(paramWeakReference, localk, localPair))
      {
        ad.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() path:%s origin==new", new Object[] { parame });
        AppMethodBeat.o(189170);
        return;
      }
      bool2 = g.a(paramWeakReference, new Pair(localk, new dcb()), false);
      if (!bool2) {
        break label332;
      }
    }
    label332:
    for (boolean bool1 = g.a(paramWeakReference, localPair, true);; bool1 = true)
    {
      ad.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() path:%s hideResult:%s showReuslt:%s", new Object[] { parame, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      AppMethodBeat.o(189170);
      return;
      ad.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() curNewTip(%s) not support %s", new Object[] { parame, ((k)localPair.first).toString() });
      AppMethodBeat.o(189170);
      return;
    }
  }
  
  private void a(List<com.tencent.mm.plugin.newtips.b.c> paramList, com.tencent.mm.plugin.newtips.b.c paramc, int paramInt)
  {
    AppMethodBeat.i(127248);
    if (paramInt >= 10)
    {
      ad.e("MicroMsg.NewTips.NewTipsManager", "logicDisappearParent() disappear fail!!!!!");
      AppMethodBeat.o(127248);
      return;
    }
    paramc = paramc.field_parents;
    if ((paramc != null) && (paramc.fyl != null))
    {
      Iterator localIterator1 = paramc.fyl.iterator();
      while (localIterator1.hasNext())
      {
        String str = (String)localIterator1.next();
        ArrayList localArrayList = new ArrayList();
        int i = g.aji(str);
        Iterator localIterator2;
        if (i == 0)
        {
          paramc = new com.tencent.mm.plugin.newtips.b.e(str);
          localIterator2 = paramList.iterator();
        }
        for (;;)
        {
          if (!localIterator2.hasNext()) {
            break label237;
          }
          com.tencent.mm.plugin.newtips.b.c localc = (com.tencent.mm.plugin.newtips.b.c)localIterator2.next();
          if (paramc.ueG)
          {
            if (!bt.kU(localc.field_dynamicPath, paramc.ueF)) {
              continue;
            }
            localc.field_state = 1;
            localArrayList.add(localc);
            a(paramList, localc, paramInt + 1);
            continue;
            paramc = new com.tencent.mm.plugin.newtips.b.e(i);
            break;
          }
          if (localc.field_path == paramc.path)
          {
            localc.field_state = 1;
            localArrayList.add(localc);
            a(paramList, localc, paramInt + 1);
          }
        }
        label237:
        ad.d("MicroMsg.NewTips.NewTipsManager", "clickNewTip() clickNewTip parentTipsInfos(%s) state to NEW_TIPS_STATE_DISAPPEAR. ret: %s layer: %s", new Object[] { str, Integer.valueOf(com.tencent.mm.plugin.newtips.a.cWu().em(localArrayList)), Integer.valueOf(paramInt) });
        d(paramc);
      }
    }
    AppMethodBeat.o(127248);
  }
  
  public static com.tencent.mm.plugin.newtips.b.a af(Map<String, String> paramMap)
  {
    AppMethodBeat.i(127242);
    if (paramMap == null)
    {
      ad.e("MicroMsg.NewTips.NewTipsManager", "parse newtips map fail! map is null!!");
      AppMethodBeat.o(127242);
      return null;
    }
    long l = bt.aGK();
    com.tencent.mm.plugin.newtips.b.a locala = new com.tencent.mm.plugin.newtips.b.a();
    locala.field_tipId = bt.getInt((String)paramMap.get(".sysmsg.newtips.control.tips_id"), 0);
    locala.field_tipVersion = bt.getInt((String)paramMap.get(".sysmsg.newtips.control.tips_version"), 0);
    locala.field_tipType = bt.getInt((String)paramMap.get(".sysmsg.newtips.control.tips_type"), 0);
    locala.field_beginShowTime = Math.max(bt.getLong((String)paramMap.get(".sysmsg.newtips.control.begin_time"), 0L), l);
    locala.field_overdueTime = bt.getLong((String)paramMap.get(".sysmsg.newtips.control.overdue_time"), 0L);
    locala.field_disappearTime = bt.getLong((String)paramMap.get(".sysmsg.newtips.control.disappear_time"), 0L);
    if (paramMap.get(".sysmsg.newtips.control.tips_showInfo") != null)
    {
      locala.field_tipsShowInfo = new dcc();
      locala.field_tipsShowInfo.dcz = bt.getInt((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo.show_type"), 0);
      locala.field_tipsShowInfo.title = ((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo.title"));
      locala.field_tipsShowInfo.odo = ((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo.icon_url"));
      locala.field_tipsShowInfo.path = ((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo.path"));
    }
    locala.field_extInfo = ((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo."));
    com.tencent.mm.plugin.newtips.a.cWt().Is(locala.field_tipId);
    com.tencent.mm.plugin.newtips.a.cWv();
    if ((e.a(locala)) && (e.b(locala)) && (e.c(locala)) && (!locala.field_isReject)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        locala.field_isExit = true;
        com.tencent.mm.plugin.newtips.a.cWt().a(locala, new String[0]);
      }
      AppMethodBeat.o(127242);
      return locala;
    }
  }
  
  private void ajj(String paramString)
  {
    AppMethodBeat.i(189169);
    if (bt.isNullOrNil(paramString))
    {
      ad.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() dynamicPath is null");
      AppMethodBeat.o(189169);
      return;
    }
    a((WeakReference)uer.get(paramString), new com.tencent.mm.plugin.newtips.b.e(paramString));
    AppMethodBeat.o(189169);
  }
  
  public static void an(int paramInt, long paramLong)
  {
    AppMethodBeat.i(127243);
    com.tencent.mm.plugin.newtips.b.a locala = com.tencent.mm.plugin.newtips.a.cWt().Is(paramInt);
    if (locala == null)
    {
      ad.e("MicroMsg.NewTips.NewTipsManager", "setPageStayTime fail! newTipsInfo is null!!");
      AppMethodBeat.o(127243);
      return;
    }
    locala.field_pagestaytime = paramLong;
    com.tencent.mm.plugin.newtips.a.cWt().a(locala, new String[0]);
    AppMethodBeat.o(127243);
  }
  
  private Pair<k, dcb> b(com.tencent.mm.plugin.newtips.b.e parame)
  {
    AppMethodBeat.i(189171);
    if (!g.a(parame))
    {
      ad.i("MicroMsg.NewTips.NewTipsManager", "getShouldShowType() %s not support newTip", new Object[] { parame });
      parame = new Pair(k.ueu, new dcb());
      AppMethodBeat.o(189171);
      return parame;
    }
    Object localObject1 = e.ek(com.tencent.mm.plugin.newtips.a.cWu().e(parame));
    if (((List)localObject1).size() <= 0)
    {
      parame = new Pair(k.ueu, new dcb());
      AppMethodBeat.o(189171);
      return parame;
    }
    Object localObject2 = new ArrayList();
    long l = ce.asT();
    Iterator localIterator = ((List)localObject1).iterator();
    com.tencent.mm.plugin.newtips.b.c localc;
    while (localIterator.hasNext())
    {
      localc = (com.tencent.mm.plugin.newtips.b.c)localIterator.next();
      if (localc.field_exposureTime == 0L)
      {
        localc.field_exposureTime = l;
        if (localc.field_overdueTime != 0L) {
          localc.field_exposureDisappearTime = (localc.field_overdueTime + l);
        }
        ((List)localObject2).add(localc);
      }
    }
    if (!((List)localObject2).isEmpty()) {
      ad.i("MicroMsg.NewTips.NewTipsManager", "getShouldShowType() set exposureTime(%s). ret: %s", new Object[] { Long.valueOf(l), Integer.valueOf(com.tencent.mm.plugin.newtips.a.cWu().em((List)localObject2)) });
    }
    if (((List)localObject1).size() == 1)
    {
      localObject2 = k.Ir(((com.tencent.mm.plugin.newtips.b.c)((List)localObject1).get(0)).field_showType);
      if (g.a(parame, (k)localObject2))
      {
        if (localObject2 == k.ueA)
        {
          parame = new dcb();
          parame.glx = 1;
          parame = new Pair(k.ueA, parame);
          AppMethodBeat.o(189171);
          return parame;
        }
        parame = new Pair(localObject2, k.a((k)localObject2, (com.tencent.mm.plugin.newtips.b.c)((List)localObject1).get(0)));
        AppMethodBeat.o(189171);
        return parame;
      }
      parame = new Pair(k.uev, new dcb());
      AppMethodBeat.o(189171);
      return parame;
    }
    localObject2 = new ArrayList();
    localIterator = ((List)localObject1).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      localc = (com.tencent.mm.plugin.newtips.b.c)localIterator.next();
      if (k.ueA == k.Ir(localc.field_showType)) {
        i += 1;
      } else {
        ((List)localObject2).add(localc);
      }
    }
    if (i > 0)
    {
      if (g.a(parame, k.ueA))
      {
        parame = new dcb();
        parame.glx = i;
        parame = new Pair(k.ueA, parame);
        AppMethodBeat.o(189171);
        return parame;
      }
      if (i == ((List)localObject1).size())
      {
        ad.d("MicroMsg.NewTips.NewTipsManager", "getShouldShowType() path(%s): MMNEWTIPS_SHOWTYPE_COUNTER => MMNEWTIPS_SHOWTYPE_REDPOINT", new Object[] { parame });
        parame = new Pair(k.uev, new dcb());
        AppMethodBeat.o(189171);
        return parame;
      }
    }
    ad.d("MicroMsg.NewTips.NewTipsManager", "getShouldShowType() path(%s) (MMNEWTIPS_SHOWTYPE_COUNTER:%s, ALL:%s) postpone", new Object[] { parame, Integer.valueOf(i), Integer.valueOf(((List)localObject1).size()) });
    Collections.sort((List)localObject2, new Comparator() {});
    i = ((List)localObject2).size() - 1;
    while (i >= 0)
    {
      localObject1 = k.Ir(((com.tencent.mm.plugin.newtips.b.c)((List)localObject2).get(i)).field_showType);
      if (g.a(parame, (k)localObject1))
      {
        parame = new Pair(localObject1, k.a((k)localObject1, (com.tencent.mm.plugin.newtips.b.c)((List)localObject2).get(i)));
        AppMethodBeat.o(189171);
        return parame;
      }
      i -= 1;
    }
    parame = new Pair(k.uev, new dcb());
    AppMethodBeat.o(189171);
    return parame;
  }
  
  public static void b(String paramString, PluginNewTips.a parama)
  {
    AppMethodBeat.i(184031);
    String str = bt.by(paramString, "null");
    boolean bool = ax.aFC("new_tips").getBoolean(str, false);
    ad.i("MicroMsg.NewTips.NewTipsManager", "registerLocalNewTips() uniqueId(%s) isReject(%s)", new Object[] { paramString, Boolean.valueOf(bool) });
    if (bool)
    {
      AppMethodBeat.o(184031);
      return;
    }
    if (parama != null) {
      PluginNewTips.addLocalNewTipsCallback(paramString, parama);
    }
    parama = new c(paramString);
    com.tencent.mm.kernel.g.aeS().a(parama, 0);
    ad.i("MicroMsg.NewTips.NewTipsManager", "registerLocalNewTips() uniqueId:%s", new Object[] { paramString });
    AppMethodBeat.o(184031);
  }
  
  private static void d(com.tencent.mm.plugin.newtips.b.e parame)
  {
    AppMethodBeat.i(189173);
    if (parame == null)
    {
      AppMethodBeat.o(189173);
      return;
    }
    if (parame.ueG)
    {
      parame = parame.ueF;
      com.tencent.mm.plugin.newtips.a.cWs().ajj(parame);
      AppMethodBeat.o(189173);
      return;
    }
    int i = parame.path;
    com.tencent.mm.plugin.newtips.a.cWs().Io(i);
    AppMethodBeat.o(189173);
  }
  
  public static void e(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(127240);
    com.tencent.mm.plugin.newtips.b.a locala = com.tencent.mm.plugin.newtips.a.cWt().Is(paramInt1);
    if (locala == null)
    {
      locala = new com.tencent.mm.plugin.newtips.b.a();
      locala.field_tipId = paramInt1;
      locala.field_tipVersion = 1;
      locala.field_tipkey = paramString1;
      locala.field_tipType = paramInt2;
      if (locala.field_tipsShowInfo == null) {
        locala.field_tipsShowInfo = new dcc();
      }
      locala.field_tipsShowInfo.path = paramString2;
      com.tencent.mm.plugin.newtips.a.cWt().f(locala);
      if ((paramInt2 == d.udP) && ((!locala.field_isExit) || (1 != locala.field_tipVersion)))
      {
        paramString1 = new b(paramInt1, paramString1);
        com.tencent.mm.kernel.g.aeS().a(paramString1, 0);
        ad.d("MicroMsg.NewTips.NewTipsManager", "dancy doScene NetScenePushCompatNewTips！！");
        AppMethodBeat.o(127240);
      }
    }
    else
    {
      if ((paramInt2 == d.udP) && ((!locala.field_isExit) || (1 != locala.field_tipVersion)))
      {
        b localb = new b(paramInt1, paramString1);
        com.tencent.mm.kernel.g.aeS().a(localb, 0);
        ad.d("MicroMsg.NewTips.NewTipsManager", "dancy doScene NetScenePushCompatNewTips！！");
      }
      if (((paramInt2 == d.udP) && (1 != locala.field_tipVersion)) || ((paramInt2 == d.udQ) && (locala.field_tipVersion <= 0)))
      {
        locala.field_tipId = paramInt1;
        locala.field_tipVersion = 1;
        locala.field_tipkey = paramString1;
        locala.field_tipType = paramInt2;
        locala.field_isExit = false;
        if (locala.field_tipsShowInfo == null) {
          locala.field_tipsShowInfo = new dcc();
        }
        locala.field_tipsShowInfo.path = paramString2;
        com.tencent.mm.plugin.newtips.a.cWt().a(locala, new String[0]);
      }
    }
    AppMethodBeat.o(127240);
  }
  
  public static void el(List<com.tencent.mm.plugin.newtips.b.c> paramList)
  {
    AppMethodBeat.i(127249);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (com.tencent.mm.plugin.newtips.b.c)paramList.next();
      if (bt.isNullOrNil(((com.tencent.mm.plugin.newtips.b.c)localObject).field_dynamicPath))
      {
        int i = ((com.tencent.mm.plugin.newtips.b.c)localObject).field_path;
        com.tencent.mm.plugin.newtips.a.cWs().Io(i);
      }
      else
      {
        localObject = ((com.tencent.mm.plugin.newtips.b.c)localObject).field_dynamicPath;
        com.tencent.mm.plugin.newtips.a.cWs().ajj((String)localObject);
      }
    }
    AppMethodBeat.o(127249);
  }
  
  public static void i(a parama)
  {
    AppMethodBeat.i(184032);
    if (parama == null)
    {
      ad.i("MicroMsg.NewTips.NewTipsManager", "unRegisterNewTips() iNewTipsView is null");
      AppMethodBeat.o(184032);
      return;
    }
    if (bt.isNullOrNil(parama.getPath()))
    {
      ad.i("MicroMsg.NewTips.NewTipsManager", "unRegisterNewTips() iNewTipsView.getPath() is null");
      AppMethodBeat.o(184032);
      return;
    }
    if (parama.cND())
    {
      String str = parama.getPath();
      if ((WeakReference)uer.get(str) != null) {
        uer.remove(str);
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.NewTips.NewTipsManager", "unRegisterNewTips %s %s", new Object[] { parama.getPath(), Boolean.valueOf(parama.cND()) });
      AppMethodBeat.o(184032);
      return;
      int i = g.aji(parama.getPath());
      if ((WeakReference)ueq.get(Integer.valueOf(i)) != null) {
        ueq.remove(Integer.valueOf(i));
      }
    }
  }
  
  public final void Io(int paramInt)
  {
    AppMethodBeat.i(127245);
    if (paramInt == 0)
    {
      ad.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() path == 0");
      AppMethodBeat.o(127245);
      return;
    }
    a((WeakReference)ueq.get(Integer.valueOf(paramInt)), new com.tencent.mm.plugin.newtips.b.e(paramInt));
    AppMethodBeat.o(127245);
  }
  
  public final void Ip(int paramInt)
  {
    AppMethodBeat.i(185494);
    c(new com.tencent.mm.plugin.newtips.b.e(paramInt));
    AppMethodBeat.o(185494);
  }
  
  public final void c(com.tencent.mm.plugin.newtips.b.e parame)
  {
    AppMethodBeat.i(189172);
    Object localObject1 = e.ek(com.tencent.mm.plugin.newtips.a.cWu().e(parame));
    if (((List)localObject1).isEmpty())
    {
      AppMethodBeat.o(189172);
      return;
    }
    Iterator localIterator1 = ((List)localObject1).iterator();
    while (localIterator1.hasNext()) {
      ((com.tencent.mm.plugin.newtips.b.c)localIterator1.next()).field_state = 1;
    }
    ad.i("MicroMsg.NewTips.NewTipsManager", "clickNewTip(%s) clickNewTip tipsInfos state to NEW_TIPS_STATE_DISAPPEAR. ret: %s", new Object[] { parame, Integer.valueOf(com.tencent.mm.plugin.newtips.a.cWu().em((List)localObject1)) });
    d(parame);
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      parame = ((com.tencent.mm.plugin.newtips.b.c)((Iterator)localObject1).next()).field_parents;
      if ((parame != null) && (parame.fyl != null))
      {
        localIterator1 = parame.fyl.iterator();
        while (localIterator1.hasNext())
        {
          Object localObject2 = (String)localIterator1.next();
          int i = g.aji((String)localObject2);
          if (i == 0) {}
          List localList;
          for (parame = new com.tencent.mm.plugin.newtips.b.e((String)localObject2);; parame = new com.tencent.mm.plugin.newtips.b.e(i))
          {
            localList = com.tencent.mm.plugin.newtips.a.cWu().e(parame);
            Iterator localIterator2 = localList.iterator();
            while (localIterator2.hasNext()) {
              ((com.tencent.mm.plugin.newtips.b.c)localIterator2.next()).field_state = 1;
            }
          }
          ad.i("MicroMsg.NewTips.NewTipsManager", "clickNewTip() clickNewTip parentTipsInfos(%s) state to NEW_TIPS_STATE_DISAPPEAR. ret: %s", new Object[] { localObject2, Integer.valueOf(com.tencent.mm.plugin.newtips.a.cWu().em(localList)) });
          d(parame);
          parame = localList.iterator();
          while (parame.hasNext())
          {
            localObject2 = (com.tencent.mm.plugin.newtips.b.c)parame.next();
            a(com.tencent.mm.plugin.newtips.a.cWu().ajl(((com.tencent.mm.plugin.newtips.b.c)localObject2).field_uniqueId), (com.tencent.mm.plugin.newtips.b.c)localObject2, 1);
          }
        }
      }
    }
    AppMethodBeat.o(189172);
  }
  
  public final void h(a parama)
  {
    AppMethodBeat.i(127244);
    if (parama == null)
    {
      ad.i("MicroMsg.NewTips.NewTipsManager", "registerNewTips() iNewTipsView is null");
      AppMethodBeat.o(127244);
      return;
    }
    if (bt.isNullOrNil(parama.getPath()))
    {
      ad.i("MicroMsg.NewTips.NewTipsManager", "registerNewTips() iNewTipsView.getPath() is null");
      AppMethodBeat.o(127244);
      return;
    }
    Object localObject;
    if (parama.cND())
    {
      localObject = parama.getPath();
      WeakReference localWeakReference = (WeakReference)uer.get(localObject);
      if ((localWeakReference != null) && (parama.equals((a)localWeakReference.get())))
      {
        ad.i("MicroMsg.NewTips.NewTipsManager", "registerNewTips(%s) iNewTipsView had registed!", new Object[] { localObject });
        ajj((String)localObject);
        AppMethodBeat.o(127244);
        return;
      }
      uer.put(localObject, new WeakReference(parama));
      ajj((String)localObject);
    }
    for (;;)
    {
      ad.i("MicroMsg.NewTips.NewTipsManager", "registerNewTips() register %s (%s) [%s] (%s)", new Object[] { parama.getPath(), Boolean.valueOf(parama.cND()), parama.toString(), parama.getClass().getName() + "@" + Integer.toHexString(parama.hashCode()) });
      AppMethodBeat.o(127244);
      return;
      int i = g.aji(parama.getPath());
      localObject = (WeakReference)ueq.get(Integer.valueOf(i));
      if ((localObject != null) && (parama.equals((a)((WeakReference)localObject).get())))
      {
        ad.i("MicroMsg.NewTips.NewTipsManager", "registerNewTips(%s) iNewTipsView had registed!", new Object[] { parama.getPath() });
        Io(i);
        AppMethodBeat.o(127244);
        return;
      }
      ueq.put(Integer.valueOf(i), new WeakReference(parama));
      Io(i);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(127239);
    ad.i("MicroMsg.NewTips.NewTipsManager", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramn.getType() == 597)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(127239);
        return;
      }
      boolean bool = ((b)paramn).udN;
      paramInt1 = ((b)paramn).udO;
      paramString = com.tencent.mm.plugin.newtips.a.cWt().Is(paramInt1);
      if (paramString != null)
      {
        paramString.field_isReject = bool;
        ad.i("MicroMsg.NewTips.NewTipsManager", "Newtips push is reject: %s", new Object[] { Boolean.valueOf(bool) });
        com.tencent.mm.plugin.newtips.a.cWt().a(paramString, new String[0]);
      }
    }
    AppMethodBeat.o(127239);
  }
  
  public static abstract interface a
  {
    public abstract void e(com.tencent.mm.plugin.newtips.b.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.i
 * JD-Core Version:    0.7.0.1
 */