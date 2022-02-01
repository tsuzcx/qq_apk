package com.tencent.mm.plugin.newtips.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.newtips.PluginNewTips;
import com.tencent.mm.plugin.newtips.PluginNewTips.a;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.protocal.protobuf.dhp;
import com.tencent.mm.protocal.protobuf.dhq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
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
  implements com.tencent.mm.ak.g
{
  private static HashMap<Integer, WeakReference<a>> vno;
  private static HashMap<String, WeakReference<a>> vnp;
  public a vnq = null;
  
  static
  {
    AppMethodBeat.i(127251);
    vno = new HashMap();
    vnp = new HashMap();
    AppMethodBeat.o(127251);
  }
  
  public static void Km(int paramInt)
  {
    AppMethodBeat.i(127241);
    com.tencent.mm.plugin.newtips.b.a locala = com.tencent.mm.plugin.newtips.a.dkc().Kr(paramInt);
    if (locala == null)
    {
      ac.e("MicroMsg.NewTips.NewTipsManager", "newTipsInfo is null , makeRead failed!!");
      AppMethodBeat.o(127241);
      return;
    }
    ac.i("MicroMsg.NewTips.NewTipsManager", "dancy new tips tipsId:%s, make read: %s", new Object[] { Integer.valueOf(paramInt), Boolean.TRUE });
    if (locala.field_tipType == d.vmO)
    {
      locala.field_hadRead = true;
      com.tencent.mm.plugin.newtips.a.dkc().a(locala, new String[0]);
    }
    if (locala.field_tipType == d.vmP)
    {
      locala.field_hadRead = true;
      com.tencent.mm.plugin.newtips.a.dkc().a(locala, new String[0]);
    }
    long l = bs.eWj();
    ai.getContext().getSharedPreferences(ai.eUX() + "_newtips_report", 0).edit().putLong("newtips_makeread_time", l).commit();
    AppMethodBeat.o(127241);
  }
  
  public static void Kp(int paramInt)
  {
    AppMethodBeat.i(210391);
    com.tencent.mm.plugin.newtips.a.dkb().Kn(paramInt);
    AppMethodBeat.o(210391);
  }
  
  private void a(WeakReference<a> paramWeakReference, com.tencent.mm.plugin.newtips.b.e parame)
  {
    AppMethodBeat.i(204966);
    if (paramWeakReference == null)
    {
      ac.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() weakReference(%s) is null", new Object[] { parame });
      AppMethodBeat.o(204966);
      return;
    }
    paramWeakReference = (a)paramWeakReference.get();
    if (paramWeakReference == null)
    {
      ac.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() curNewTip(%s) is null", new Object[] { parame });
      AppMethodBeat.o(204966);
      return;
    }
    if (g.c(paramWeakReference))
    {
      ac.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() curNewTip(%s) is show old new tip", new Object[] { parame });
      AppMethodBeat.o(204966);
      return;
    }
    Pair localPair = b(parame);
    ac.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() path:%s show %s [%s,%s,%s]", new Object[] { parame, ((k)localPair.first).vnz, ((dhn)localPair.second).title, ((dhn)localPair.second).url, Integer.valueOf(((dhn)localPair.second).gMk) });
    boolean bool2;
    if (g.a(parame, (k)localPair.first))
    {
      k localk = g.e(paramWeakReference);
      if (g.a(paramWeakReference, localk, localPair))
      {
        ac.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() path:%s origin==new", new Object[] { parame });
        AppMethodBeat.o(204966);
        return;
      }
      bool2 = g.a(paramWeakReference, new Pair(localk, new dhn()), false);
      if (!bool2) {
        break label332;
      }
    }
    label332:
    for (boolean bool1 = g.a(paramWeakReference, localPair, true);; bool1 = true)
    {
      ac.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() path:%s hideResult:%s showReuslt:%s", new Object[] { parame, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      AppMethodBeat.o(204966);
      return;
      ac.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() curNewTip(%s) not support %s", new Object[] { parame, ((k)localPair.first).toString() });
      AppMethodBeat.o(204966);
      return;
    }
  }
  
  private void a(List<com.tencent.mm.plugin.newtips.b.c> paramList, com.tencent.mm.plugin.newtips.b.c paramc, int paramInt)
  {
    AppMethodBeat.i(127248);
    if (paramInt >= 10)
    {
      ac.e("MicroMsg.NewTips.NewTipsManager", "logicDisappearParent() disappear fail!!!!!");
      AppMethodBeat.o(127248);
      return;
    }
    paramc = paramc.field_parents;
    if ((paramc != null) && (paramc.fBS != null))
    {
      Iterator localIterator1 = paramc.fBS.iterator();
      while (localIterator1.hasNext())
      {
        String str = (String)localIterator1.next();
        ArrayList localArrayList = new ArrayList();
        int i = g.aog(str);
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
          if (paramc.vnF)
          {
            if (!bs.lr(localc.field_dynamicPath, paramc.vnE)) {
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
        ac.d("MicroMsg.NewTips.NewTipsManager", "clickNewTip() clickNewTip parentTipsInfos(%s) state to NEW_TIPS_STATE_DISAPPEAR. ret: %s layer: %s", new Object[] { str, Integer.valueOf(com.tencent.mm.plugin.newtips.a.dkd().eq(localArrayList)), Integer.valueOf(paramInt) });
        d(paramc);
      }
    }
    AppMethodBeat.o(127248);
  }
  
  public static com.tencent.mm.plugin.newtips.b.a ah(Map<String, String> paramMap)
  {
    AppMethodBeat.i(127242);
    if (paramMap == null)
    {
      ac.e("MicroMsg.NewTips.NewTipsManager", "parse newtips map fail! map is null!!");
      AppMethodBeat.o(127242);
      return null;
    }
    long l = bs.aNx();
    com.tencent.mm.plugin.newtips.b.a locala = new com.tencent.mm.plugin.newtips.b.a();
    locala.field_tipId = bs.getInt((String)paramMap.get(".sysmsg.newtips.control.tips_id"), 0);
    locala.field_tipVersion = bs.getInt((String)paramMap.get(".sysmsg.newtips.control.tips_version"), 0);
    locala.field_tipType = bs.getInt((String)paramMap.get(".sysmsg.newtips.control.tips_type"), 0);
    locala.field_beginShowTime = Math.max(bs.getLong((String)paramMap.get(".sysmsg.newtips.control.begin_time"), 0L), l);
    locala.field_overdueTime = bs.getLong((String)paramMap.get(".sysmsg.newtips.control.overdue_time"), 0L);
    locala.field_disappearTime = bs.getLong((String)paramMap.get(".sysmsg.newtips.control.disappear_time"), 0L);
    if (paramMap.get(".sysmsg.newtips.control.tips_showInfo") != null)
    {
      locala.field_tipsShowInfo = new dhp();
      locala.field_tipsShowInfo.cZX = bs.getInt((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo.show_type"), 0);
      locala.field_tipsShowInfo.title = ((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo.title"));
      locala.field_tipsShowInfo.oGN = ((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo.icon_url"));
      locala.field_tipsShowInfo.path = ((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo.path"));
    }
    locala.field_extInfo = ((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo."));
    com.tencent.mm.plugin.newtips.a.dkc().Kr(locala.field_tipId);
    com.tencent.mm.plugin.newtips.a.dke();
    if ((e.a(locala)) && (e.b(locala)) && (e.c(locala)) && (!locala.field_isReject)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        locala.field_isExit = true;
        com.tencent.mm.plugin.newtips.a.dkc().a(locala, new String[0]);
      }
      AppMethodBeat.o(127242);
      return locala;
    }
  }
  
  public static void al(int paramInt, long paramLong)
  {
    AppMethodBeat.i(127243);
    com.tencent.mm.plugin.newtips.b.a locala = com.tencent.mm.plugin.newtips.a.dkc().Kr(paramInt);
    if (locala == null)
    {
      ac.e("MicroMsg.NewTips.NewTipsManager", "setPageStayTime fail! newTipsInfo is null!!");
      AppMethodBeat.o(127243);
      return;
    }
    locala.field_pagestaytime = paramLong;
    com.tencent.mm.plugin.newtips.a.dkc().a(locala, new String[0]);
    AppMethodBeat.o(127243);
  }
  
  private void aoh(String paramString)
  {
    AppMethodBeat.i(204965);
    if (bs.isNullOrNil(paramString))
    {
      ac.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() dynamicPath is null");
      AppMethodBeat.o(204965);
      return;
    }
    a((WeakReference)vnp.get(paramString), new com.tencent.mm.plugin.newtips.b.e(paramString));
    AppMethodBeat.o(204965);
  }
  
  private Pair<k, dhn> b(com.tencent.mm.plugin.newtips.b.e parame)
  {
    AppMethodBeat.i(204967);
    if (!g.a(parame))
    {
      ac.i("MicroMsg.NewTips.NewTipsManager", "getShouldShowType() %s not support newTip", new Object[] { parame });
      parame = new Pair(k.vns, new dhn());
      AppMethodBeat.o(204967);
      return parame;
    }
    Object localObject1 = e.eo(com.tencent.mm.plugin.newtips.a.dkd().e(parame));
    if (((List)localObject1).size() <= 0)
    {
      parame = new Pair(k.vns, new dhn());
      AppMethodBeat.o(204967);
      return parame;
    }
    Object localObject2 = new ArrayList();
    long l = ce.azK();
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
      ac.i("MicroMsg.NewTips.NewTipsManager", "getShouldShowType() set exposureTime(%s). ret: %s", new Object[] { Long.valueOf(l), Integer.valueOf(com.tencent.mm.plugin.newtips.a.dkd().eq((List)localObject2)) });
    }
    if (((List)localObject1).size() == 1)
    {
      localObject2 = k.Kq(((com.tencent.mm.plugin.newtips.b.c)((List)localObject1).get(0)).field_showType);
      if (g.a(parame, (k)localObject2))
      {
        if (localObject2 == k.vny)
        {
          parame = new dhn();
          parame.gMk = 1;
          parame = new Pair(k.vny, parame);
          AppMethodBeat.o(204967);
          return parame;
        }
        parame = new Pair(localObject2, k.a((k)localObject2, (com.tencent.mm.plugin.newtips.b.c)((List)localObject1).get(0)));
        AppMethodBeat.o(204967);
        return parame;
      }
      parame = new Pair(k.vnt, new dhn());
      AppMethodBeat.o(204967);
      return parame;
    }
    localObject2 = new ArrayList();
    localIterator = ((List)localObject1).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      localc = (com.tencent.mm.plugin.newtips.b.c)localIterator.next();
      if (k.vny == k.Kq(localc.field_showType)) {
        i += 1;
      } else {
        ((List)localObject2).add(localc);
      }
    }
    if (i > 0)
    {
      if (g.a(parame, k.vny))
      {
        parame = new dhn();
        parame.gMk = i;
        parame = new Pair(k.vny, parame);
        AppMethodBeat.o(204967);
        return parame;
      }
      if (i == ((List)localObject1).size())
      {
        ac.d("MicroMsg.NewTips.NewTipsManager", "getShouldShowType() path(%s): MMNEWTIPS_SHOWTYPE_COUNTER => MMNEWTIPS_SHOWTYPE_REDPOINT", new Object[] { parame });
        parame = new Pair(k.vnt, new dhn());
        AppMethodBeat.o(204967);
        return parame;
      }
    }
    ac.d("MicroMsg.NewTips.NewTipsManager", "getShouldShowType() path(%s) (MMNEWTIPS_SHOWTYPE_COUNTER:%s, ALL:%s) postpone", new Object[] { parame, Integer.valueOf(i), Integer.valueOf(((List)localObject1).size()) });
    Collections.sort((List)localObject2, new Comparator() {});
    i = ((List)localObject2).size() - 1;
    while (i >= 0)
    {
      localObject1 = k.Kq(((com.tencent.mm.plugin.newtips.b.c)((List)localObject2).get(i)).field_showType);
      if (g.a(parame, (k)localObject1))
      {
        parame = new Pair(localObject1, k.a((k)localObject1, (com.tencent.mm.plugin.newtips.b.c)((List)localObject2).get(i)));
        AppMethodBeat.o(204967);
        return parame;
      }
      i -= 1;
    }
    parame = new Pair(k.vnt, new dhn());
    AppMethodBeat.o(204967);
    return parame;
  }
  
  public static void b(String paramString, PluginNewTips.a parama)
  {
    AppMethodBeat.i(184031);
    String str = bs.bG(paramString, "null");
    boolean bool = aw.aKT("new_tips").getBoolean(str, false);
    ac.i("MicroMsg.NewTips.NewTipsManager", "registerLocalNewTips() uniqueId(%s) isReject(%s)", new Object[] { paramString, Boolean.valueOf(bool) });
    if (bool)
    {
      AppMethodBeat.o(184031);
      return;
    }
    if (parama != null) {
      PluginNewTips.addLocalNewTipsCallback(paramString, parama);
    }
    parama = new c(paramString);
    com.tencent.mm.kernel.g.agi().a(parama, 0);
    ac.i("MicroMsg.NewTips.NewTipsManager", "registerLocalNewTips() uniqueId:%s", new Object[] { paramString });
    AppMethodBeat.o(184031);
  }
  
  private static void d(com.tencent.mm.plugin.newtips.b.e parame)
  {
    AppMethodBeat.i(204969);
    if (parame == null)
    {
      AppMethodBeat.o(204969);
      return;
    }
    if (parame.vnF)
    {
      parame = parame.vnE;
      com.tencent.mm.plugin.newtips.a.dkb().aoh(parame);
      AppMethodBeat.o(204969);
      return;
    }
    int i = parame.path;
    com.tencent.mm.plugin.newtips.a.dkb().Kn(i);
    AppMethodBeat.o(204969);
  }
  
  public static void ep(List<com.tencent.mm.plugin.newtips.b.c> paramList)
  {
    AppMethodBeat.i(127249);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (com.tencent.mm.plugin.newtips.b.c)paramList.next();
      if (bs.isNullOrNil(((com.tencent.mm.plugin.newtips.b.c)localObject).field_dynamicPath))
      {
        int i = ((com.tencent.mm.plugin.newtips.b.c)localObject).field_path;
        com.tencent.mm.plugin.newtips.a.dkb().Kn(i);
      }
      else
      {
        localObject = ((com.tencent.mm.plugin.newtips.b.c)localObject).field_dynamicPath;
        com.tencent.mm.plugin.newtips.a.dkb().aoh((String)localObject);
      }
    }
    AppMethodBeat.o(127249);
  }
  
  public static void g(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(127240);
    com.tencent.mm.plugin.newtips.b.a locala = com.tencent.mm.plugin.newtips.a.dkc().Kr(paramInt1);
    if (locala == null)
    {
      locala = new com.tencent.mm.plugin.newtips.b.a();
      locala.field_tipId = paramInt1;
      locala.field_tipVersion = 1;
      locala.field_tipkey = paramString1;
      locala.field_tipType = paramInt2;
      if (locala.field_tipsShowInfo == null) {
        locala.field_tipsShowInfo = new dhp();
      }
      locala.field_tipsShowInfo.path = paramString2;
      com.tencent.mm.plugin.newtips.a.dkc().f(locala);
      if ((paramInt2 == d.vmO) && ((!locala.field_isExit) || (1 != locala.field_tipVersion)))
      {
        paramString1 = new b(paramInt1, paramString1);
        com.tencent.mm.kernel.g.agi().a(paramString1, 0);
        ac.d("MicroMsg.NewTips.NewTipsManager", "dancy doScene NetScenePushCompatNewTips！！");
        AppMethodBeat.o(127240);
      }
    }
    else
    {
      if ((paramInt2 == d.vmO) && ((!locala.field_isExit) || (1 != locala.field_tipVersion)))
      {
        b localb = new b(paramInt1, paramString1);
        com.tencent.mm.kernel.g.agi().a(localb, 0);
        ac.d("MicroMsg.NewTips.NewTipsManager", "dancy doScene NetScenePushCompatNewTips！！");
      }
      if (((paramInt2 == d.vmO) && (1 != locala.field_tipVersion)) || ((paramInt2 == d.vmP) && (locala.field_tipVersion <= 0)))
      {
        locala.field_tipId = paramInt1;
        locala.field_tipVersion = 1;
        locala.field_tipkey = paramString1;
        locala.field_tipType = paramInt2;
        locala.field_isExit = false;
        if (locala.field_tipsShowInfo == null) {
          locala.field_tipsShowInfo = new dhp();
        }
        locala.field_tipsShowInfo.path = paramString2;
        com.tencent.mm.plugin.newtips.a.dkc().a(locala, new String[0]);
      }
    }
    AppMethodBeat.o(127240);
  }
  
  public static void i(a parama)
  {
    AppMethodBeat.i(184032);
    if (parama == null)
    {
      ac.i("MicroMsg.NewTips.NewTipsManager", "unRegisterNewTips() iNewTipsView is null");
      AppMethodBeat.o(184032);
      return;
    }
    if (bs.isNullOrNil(parama.getPath()))
    {
      ac.i("MicroMsg.NewTips.NewTipsManager", "unRegisterNewTips() iNewTipsView.getPath() is null");
      AppMethodBeat.o(184032);
      return;
    }
    if (parama.dbk())
    {
      String str = parama.getPath();
      if ((WeakReference)vnp.get(str) != null) {
        vnp.remove(str);
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.NewTips.NewTipsManager", "unRegisterNewTips %s %s", new Object[] { parama.getPath(), Boolean.valueOf(parama.dbk()) });
      AppMethodBeat.o(184032);
      return;
      int i = g.aog(parama.getPath());
      if ((WeakReference)vno.get(Integer.valueOf(i)) != null) {
        vno.remove(Integer.valueOf(i));
      }
    }
  }
  
  public final void Kn(int paramInt)
  {
    AppMethodBeat.i(127245);
    if (paramInt == 0)
    {
      ac.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() path == 0");
      AppMethodBeat.o(127245);
      return;
    }
    a((WeakReference)vno.get(Integer.valueOf(paramInt)), new com.tencent.mm.plugin.newtips.b.e(paramInt));
    AppMethodBeat.o(127245);
  }
  
  public final void Ko(int paramInt)
  {
    AppMethodBeat.i(185494);
    c(new com.tencent.mm.plugin.newtips.b.e(paramInt));
    AppMethodBeat.o(185494);
  }
  
  public final void c(com.tencent.mm.plugin.newtips.b.e parame)
  {
    AppMethodBeat.i(204968);
    Object localObject1 = e.eo(com.tencent.mm.plugin.newtips.a.dkd().e(parame));
    if (((List)localObject1).isEmpty())
    {
      AppMethodBeat.o(204968);
      return;
    }
    Iterator localIterator1 = ((List)localObject1).iterator();
    while (localIterator1.hasNext()) {
      ((com.tencent.mm.plugin.newtips.b.c)localIterator1.next()).field_state = 1;
    }
    ac.i("MicroMsg.NewTips.NewTipsManager", "clickNewTip(%s) clickNewTip tipsInfos state to NEW_TIPS_STATE_DISAPPEAR. ret: %s", new Object[] { parame, Integer.valueOf(com.tencent.mm.plugin.newtips.a.dkd().eq((List)localObject1)) });
    d(parame);
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      parame = ((com.tencent.mm.plugin.newtips.b.c)((Iterator)localObject1).next()).field_parents;
      if ((parame != null) && (parame.fBS != null))
      {
        localIterator1 = parame.fBS.iterator();
        while (localIterator1.hasNext())
        {
          Object localObject2 = (String)localIterator1.next();
          int i = g.aog((String)localObject2);
          if (i == 0) {}
          List localList;
          for (parame = new com.tencent.mm.plugin.newtips.b.e((String)localObject2);; parame = new com.tencent.mm.plugin.newtips.b.e(i))
          {
            localList = com.tencent.mm.plugin.newtips.a.dkd().e(parame);
            Iterator localIterator2 = localList.iterator();
            while (localIterator2.hasNext()) {
              ((com.tencent.mm.plugin.newtips.b.c)localIterator2.next()).field_state = 1;
            }
          }
          ac.i("MicroMsg.NewTips.NewTipsManager", "clickNewTip() clickNewTip parentTipsInfos(%s) state to NEW_TIPS_STATE_DISAPPEAR. ret: %s", new Object[] { localObject2, Integer.valueOf(com.tencent.mm.plugin.newtips.a.dkd().eq(localList)) });
          d(parame);
          parame = localList.iterator();
          while (parame.hasNext())
          {
            localObject2 = (com.tencent.mm.plugin.newtips.b.c)parame.next();
            a(com.tencent.mm.plugin.newtips.a.dkd().aoj(((com.tencent.mm.plugin.newtips.b.c)localObject2).field_uniqueId), (com.tencent.mm.plugin.newtips.b.c)localObject2, 1);
          }
        }
      }
    }
    AppMethodBeat.o(204968);
  }
  
  public final void h(a parama)
  {
    AppMethodBeat.i(127244);
    if (parama == null)
    {
      ac.i("MicroMsg.NewTips.NewTipsManager", "registerNewTips() iNewTipsView is null");
      AppMethodBeat.o(127244);
      return;
    }
    if (bs.isNullOrNil(parama.getPath()))
    {
      ac.i("MicroMsg.NewTips.NewTipsManager", "registerNewTips() iNewTipsView.getPath() is null");
      AppMethodBeat.o(127244);
      return;
    }
    Object localObject;
    if (parama.dbk())
    {
      localObject = parama.getPath();
      WeakReference localWeakReference = (WeakReference)vnp.get(localObject);
      if ((localWeakReference != null) && (parama.equals((a)localWeakReference.get())))
      {
        ac.i("MicroMsg.NewTips.NewTipsManager", "registerNewTips(%s) iNewTipsView had registed!", new Object[] { localObject });
        aoh((String)localObject);
        AppMethodBeat.o(127244);
        return;
      }
      vnp.put(localObject, new WeakReference(parama));
      aoh((String)localObject);
    }
    for (;;)
    {
      ac.i("MicroMsg.NewTips.NewTipsManager", "registerNewTips() register %s (%s) [%s] (%s)", new Object[] { parama.getPath(), Boolean.valueOf(parama.dbk()), parama.toString(), parama.getClass().getName() + "@" + Integer.toHexString(parama.hashCode()) });
      AppMethodBeat.o(127244);
      return;
      int i = g.aog(parama.getPath());
      localObject = (WeakReference)vno.get(Integer.valueOf(i));
      if ((localObject != null) && (parama.equals((a)((WeakReference)localObject).get())))
      {
        ac.i("MicroMsg.NewTips.NewTipsManager", "registerNewTips(%s) iNewTipsView had registed!", new Object[] { parama.getPath() });
        Kn(i);
        AppMethodBeat.o(127244);
        return;
      }
      vno.put(Integer.valueOf(i), new WeakReference(parama));
      Kn(i);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(127239);
    ac.i("MicroMsg.NewTips.NewTipsManager", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramn.getType() == 597)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(127239);
        return;
      }
      boolean bool = ((b)paramn).vmM;
      paramInt1 = ((b)paramn).vmN;
      paramString = com.tencent.mm.plugin.newtips.a.dkc().Kr(paramInt1);
      if (paramString != null)
      {
        paramString.field_isReject = bool;
        ac.i("MicroMsg.NewTips.NewTipsManager", "Newtips push is reject: %s", new Object[] { Boolean.valueOf(bool) });
        com.tencent.mm.plugin.newtips.a.dkc().a(paramString, new String[0]);
      }
    }
    AppMethodBeat.o(127239);
  }
  
  public static abstract interface a
  {
    public abstract void e(com.tencent.mm.plugin.newtips.b.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.i
 * JD-Core Version:    0.7.0.1
 */