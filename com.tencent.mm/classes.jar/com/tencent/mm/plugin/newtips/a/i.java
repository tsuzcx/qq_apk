package com.tencent.mm.plugin.newtips.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.newtips.PluginNewTips;
import com.tencent.mm.plugin.newtips.PluginNewTips.a;
import com.tencent.mm.protocal.protobuf.dnz;
import com.tencent.mm.protocal.protobuf.dob;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class i
  implements f
{
  private static HashMap<Integer, WeakReference<a>> wIp;
  private static HashMap<String, WeakReference<a>> wIq;
  public a wIr = null;
  
  static
  {
    AppMethodBeat.i(127251);
    wIp = new HashMap();
    wIq = new HashMap();
    AppMethodBeat.o(127251);
  }
  
  public static void Mt(int paramInt)
  {
    AppMethodBeat.i(127241);
    com.tencent.mm.plugin.newtips.b.a locala = com.tencent.mm.plugin.newtips.a.dxE().My(paramInt);
    if (locala == null)
    {
      ae.e("MicroMsg.NewTips.NewTipsManager", "newTipsInfo is null , makeRead failed!!");
      AppMethodBeat.o(127241);
      return;
    }
    ae.i("MicroMsg.NewTips.NewTipsManager", "dancy new tips tipsId:%s, make read: %s", new Object[] { Integer.valueOf(paramInt), Boolean.TRUE });
    if (locala.field_tipType == d.wHP)
    {
      locala.field_hadRead = true;
      com.tencent.mm.plugin.newtips.a.dxE().a(locala, new String[0]);
    }
    if (locala.field_tipType == d.wHQ)
    {
      locala.field_hadRead = true;
      com.tencent.mm.plugin.newtips.a.dxE().a(locala, new String[0]);
    }
    long l = bu.fpO();
    ak.getContext().getSharedPreferences(ak.fow() + "_newtips_report", 0).edit().putLong("newtips_makeread_time", l).commit();
    AppMethodBeat.o(127241);
  }
  
  public static void Mw(int paramInt)
  {
    AppMethodBeat.i(224265);
    com.tencent.mm.plugin.newtips.a.dxD().Mu(paramInt);
    AppMethodBeat.o(224265);
  }
  
  private void a(final WeakReference<a> paramWeakReference, final com.tencent.mm.plugin.newtips.b.e parame)
  {
    AppMethodBeat.i(200593);
    if (paramWeakReference == null)
    {
      ae.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() weakReference(%s) is null", new Object[] { parame });
      AppMethodBeat.o(200593);
      return;
    }
    paramWeakReference = (a)paramWeakReference.get();
    if (paramWeakReference == null)
    {
      ae.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() curNewTip(%s) is null", new Object[] { parame });
      AppMethodBeat.o(200593);
      return;
    }
    if (g.c(paramWeakReference))
    {
      ae.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() curNewTip(%s) is show old new tip", new Object[] { parame });
      AppMethodBeat.o(200593);
      return;
    }
    h.MqF.aO(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200590);
        Pair localPair = i.a(i.this, parame);
        ae.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() path:%s show %s [%s,%s,%s]", new Object[] { parame, ((k)localPair.first).wIB, ((dnz)localPair.second).title, ((dnz)localPair.second).url, Integer.valueOf(((dnz)localPair.second).hiV) });
        boolean bool2;
        if (g.a(parame, (k)localPair.first))
        {
          k localk = g.e(paramWeakReference);
          Object localObject = paramWeakReference;
          int i;
          if (localObject == null)
          {
            ae.e("MicroMsg.NewTips.NewTipsHelper", "isEqual() curNewTip == null");
            i = 1;
          }
          while (i != 0)
          {
            ae.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() path:%s origin==new", new Object[] { parame });
            AppMethodBeat.o(200590);
            return;
            if (localk != localPair.first)
            {
              i = 0;
            }
            else
            {
              localObject = g.f((a)localObject);
              dnz localdnz = (dnz)localPair.second;
              if ((localObject == null) && (localdnz == null))
              {
                i = 1;
              }
              else
              {
                if (((localObject != null) && (localdnz == null)) || ((localObject == null) && (localdnz != null))) {}
                switch (g.2.wIo[localk.ordinal()])
                {
                default: 
                  i = 0;
                  break;
                case 1: 
                case 2: 
                case 7: 
                  i = 1;
                  break;
                case 3: 
                case 4: 
                case 5: 
                case 6: 
                  i = 0;
                  continue;
                  switch (g.2.wIo[localk.ordinal()])
                  {
                  default: 
                    i = 0;
                    break;
                  case 1: 
                  case 2: 
                  case 7: 
                    i = 1;
                    break;
                  case 3: 
                    if (bu.lX(((dnz)localObject).title, localdnz.title)) {
                      i = 1;
                    } else {
                      i = 0;
                    }
                    break;
                  case 4: 
                    if (bu.lX(((dnz)localObject).url, localdnz.url)) {
                      i = 1;
                    } else {
                      i = 0;
                    }
                    break;
                  case 5: 
                    if ((bu.lX(((dnz)localObject).title, localdnz.title)) && (bu.lX(((dnz)localObject).url, localdnz.url))) {
                      i = 1;
                    } else {
                      i = 0;
                    }
                    break;
                  case 6: 
                    if (bu.jB(((dnz)localObject).hiV, localdnz.hiV)) {
                      i = 1;
                    } else {
                      i = 0;
                    }
                    break;
                  }
                  break;
                }
              }
            }
          }
          bool2 = g.a(paramWeakReference, new Pair(localk, new dnz()), false);
          if (!bool2) {
            break label602;
          }
        }
        label602:
        for (boolean bool1 = g.a(paramWeakReference, localPair, true);; bool1 = true)
        {
          ae.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() path:%s hideResult:%s showReuslt:%s", new Object[] { parame, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
          AppMethodBeat.o(200590);
          return;
          ae.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() curNewTip(%s) not support %s", new Object[] { parame, ((k)localPair.first).toString() });
          AppMethodBeat.o(200590);
          return;
        }
      }
    });
    AppMethodBeat.o(200593);
  }
  
  private void a(List<com.tencent.mm.plugin.newtips.b.c> paramList, com.tencent.mm.plugin.newtips.b.c paramc, int paramInt)
  {
    AppMethodBeat.i(127248);
    if (paramInt >= 10)
    {
      ae.e("MicroMsg.NewTips.NewTipsManager", "logicDisappearParent() disappear fail!!!!!");
      AppMethodBeat.o(127248);
      return;
    }
    paramc = paramc.field_parents;
    if ((paramc != null) && (paramc.fXm != null))
    {
      Iterator localIterator1 = paramc.fXm.iterator();
      while (localIterator1.hasNext())
      {
        String str = (String)localIterator1.next();
        ArrayList localArrayList = new ArrayList();
        int i = g.aus(str);
        Iterator localIterator2;
        if (i == 0)
        {
          paramc = new com.tencent.mm.plugin.newtips.b.e(str);
          localIterator2 = paramList.iterator();
        }
        for (;;)
        {
          if (!localIterator2.hasNext()) {
            break label240;
          }
          com.tencent.mm.plugin.newtips.b.c localc = (com.tencent.mm.plugin.newtips.b.c)localIterator2.next();
          if (paramc.wIH)
          {
            if (!bu.lX(localc.field_dynamicPath, paramc.wIG)) {
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
        label240:
        ae.d("MicroMsg.NewTips.NewTipsManager", "clickNewTip() clickNewTip parentTipsInfos(%s) state to NEW_TIPS_STATE_DISAPPEAR. ret: %s layer: %s", new Object[] { str, Integer.valueOf(com.tencent.mm.plugin.newtips.a.dxF().eK(localArrayList)), Integer.valueOf(paramInt) });
        b(paramc);
      }
    }
    AppMethodBeat.o(127248);
  }
  
  public static void aq(int paramInt, long paramLong)
  {
    AppMethodBeat.i(127243);
    com.tencent.mm.plugin.newtips.b.a locala = com.tencent.mm.plugin.newtips.a.dxE().My(paramInt);
    if (locala == null)
    {
      ae.e("MicroMsg.NewTips.NewTipsManager", "setPageStayTime fail! newTipsInfo is null!!");
      AppMethodBeat.o(127243);
      return;
    }
    locala.field_pagestaytime = paramLong;
    com.tencent.mm.plugin.newtips.a.dxE().a(locala, new String[0]);
    AppMethodBeat.o(127243);
  }
  
  public static com.tencent.mm.plugin.newtips.b.a as(Map<String, String> paramMap)
  {
    AppMethodBeat.i(127242);
    if (paramMap == null)
    {
      ae.e("MicroMsg.NewTips.NewTipsManager", "parse newtips map fail! map is null!!");
      AppMethodBeat.o(127242);
      return null;
    }
    long l = bu.aRi();
    com.tencent.mm.plugin.newtips.b.a locala = new com.tencent.mm.plugin.newtips.b.a();
    locala.field_tipId = bu.getInt((String)paramMap.get(".sysmsg.newtips.control.tips_id"), 0);
    locala.field_tipVersion = bu.getInt((String)paramMap.get(".sysmsg.newtips.control.tips_version"), 0);
    locala.field_tipType = bu.getInt((String)paramMap.get(".sysmsg.newtips.control.tips_type"), 0);
    locala.field_beginShowTime = Math.max(bu.getLong((String)paramMap.get(".sysmsg.newtips.control.begin_time"), 0L), l);
    locala.field_overdueTime = bu.getLong((String)paramMap.get(".sysmsg.newtips.control.overdue_time"), 0L);
    locala.field_disappearTime = bu.getLong((String)paramMap.get(".sysmsg.newtips.control.disappear_time"), 0L);
    if (paramMap.get(".sysmsg.newtips.control.tips_showInfo") != null)
    {
      locala.field_tipsShowInfo = new dob();
      locala.field_tipsShowInfo.dmr = bu.getInt((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo.show_type"), 0);
      locala.field_tipsShowInfo.title = ((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo.title"));
      locala.field_tipsShowInfo.pqW = ((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo.icon_url"));
      locala.field_tipsShowInfo.path = ((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo.path"));
    }
    locala.field_extInfo = ((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo."));
    com.tencent.mm.plugin.newtips.a.dxE().My(locala.field_tipId);
    com.tencent.mm.plugin.newtips.a.dxG();
    if ((e.a(locala)) && (e.b(locala)) && (e.c(locala)) && (!locala.field_isReject)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        locala.field_isExit = true;
        com.tencent.mm.plugin.newtips.a.dxE().a(locala, new String[0]);
      }
      AppMethodBeat.o(127242);
      return locala;
    }
  }
  
  private void aut(String paramString)
  {
    AppMethodBeat.i(200592);
    if (bu.isNullOrNil(paramString))
    {
      ae.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() dynamicPath is null");
      AppMethodBeat.o(200592);
      return;
    }
    a((WeakReference)wIq.get(paramString), new com.tencent.mm.plugin.newtips.b.e(paramString));
    AppMethodBeat.o(200592);
  }
  
  private static void b(com.tencent.mm.plugin.newtips.b.e parame)
  {
    AppMethodBeat.i(200595);
    if (parame == null)
    {
      AppMethodBeat.o(200595);
      return;
    }
    if (parame.wIH)
    {
      parame = parame.wIG;
      com.tencent.mm.plugin.newtips.a.dxD().aut(parame);
      AppMethodBeat.o(200595);
      return;
    }
    int i = parame.path;
    com.tencent.mm.plugin.newtips.a.dxD().Mu(i);
    AppMethodBeat.o(200595);
  }
  
  public static void b(String paramString, PluginNewTips.a parama)
  {
    AppMethodBeat.i(184031);
    String str = bu.bI(paramString, "null");
    boolean bool = ay.aRW("new_tips").getBoolean(str, false);
    ae.i("MicroMsg.NewTips.NewTipsManager", "registerLocalNewTips() uniqueId(%s) isReject(%s)", new Object[] { paramString, Boolean.valueOf(bool) });
    if (bool)
    {
      AppMethodBeat.o(184031);
      return;
    }
    if (parama != null) {
      PluginNewTips.addLocalNewTipsCallback(paramString, parama);
    }
    parama = new c(paramString);
    com.tencent.mm.kernel.g.ajj().a(parama, 0);
    ae.i("MicroMsg.NewTips.NewTipsManager", "registerLocalNewTips() uniqueId:%s", new Object[] { paramString });
    AppMethodBeat.o(184031);
  }
  
  public static void eJ(List<com.tencent.mm.plugin.newtips.b.c> paramList)
  {
    AppMethodBeat.i(127249);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (com.tencent.mm.plugin.newtips.b.c)paramList.next();
      if (bu.isNullOrNil(((com.tencent.mm.plugin.newtips.b.c)localObject).field_dynamicPath))
      {
        int i = ((com.tencent.mm.plugin.newtips.b.c)localObject).field_path;
        com.tencent.mm.plugin.newtips.a.dxD().Mu(i);
      }
      else
      {
        localObject = ((com.tencent.mm.plugin.newtips.b.c)localObject).field_dynamicPath;
        com.tencent.mm.plugin.newtips.a.dxD().aut((String)localObject);
      }
    }
    AppMethodBeat.o(127249);
  }
  
  public static void g(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(127240);
    com.tencent.mm.plugin.newtips.b.a locala = com.tencent.mm.plugin.newtips.a.dxE().My(paramInt1);
    if (locala == null)
    {
      locala = new com.tencent.mm.plugin.newtips.b.a();
      locala.field_tipId = paramInt1;
      locala.field_tipVersion = 1;
      locala.field_tipkey = paramString1;
      locala.field_tipType = paramInt2;
      if (locala.field_tipsShowInfo == null) {
        locala.field_tipsShowInfo = new dob();
      }
      locala.field_tipsShowInfo.path = paramString2;
      com.tencent.mm.plugin.newtips.a.dxE().f(locala);
      if ((paramInt2 == d.wHP) && ((!locala.field_isExit) || (1 != locala.field_tipVersion)))
      {
        paramString1 = new b(paramInt1, paramString1);
        com.tencent.mm.kernel.g.ajj().a(paramString1, 0);
        ae.d("MicroMsg.NewTips.NewTipsManager", "dancy doScene NetScenePushCompatNewTips！！");
        AppMethodBeat.o(127240);
      }
    }
    else
    {
      if ((paramInt2 == d.wHP) && ((!locala.field_isExit) || (1 != locala.field_tipVersion)))
      {
        b localb = new b(paramInt1, paramString1);
        com.tencent.mm.kernel.g.ajj().a(localb, 0);
        ae.d("MicroMsg.NewTips.NewTipsManager", "dancy doScene NetScenePushCompatNewTips！！");
      }
      if (((paramInt2 == d.wHP) && (1 != locala.field_tipVersion)) || ((paramInt2 == d.wHQ) && (locala.field_tipVersion <= 0)))
      {
        locala.field_tipId = paramInt1;
        locala.field_tipVersion = 1;
        locala.field_tipkey = paramString1;
        locala.field_tipType = paramInt2;
        locala.field_isExit = false;
        if (locala.field_tipsShowInfo == null) {
          locala.field_tipsShowInfo = new dob();
        }
        locala.field_tipsShowInfo.path = paramString2;
        com.tencent.mm.plugin.newtips.a.dxE().a(locala, new String[0]);
      }
    }
    AppMethodBeat.o(127240);
  }
  
  public static void i(a parama)
  {
    AppMethodBeat.i(184032);
    if (parama == null)
    {
      ae.i("MicroMsg.NewTips.NewTipsManager", "unRegisterNewTips() iNewTipsView is null");
      AppMethodBeat.o(184032);
      return;
    }
    if (bu.isNullOrNil(parama.getPath()))
    {
      ae.i("MicroMsg.NewTips.NewTipsManager", "unRegisterNewTips() iNewTipsView.getPath() is null");
      AppMethodBeat.o(184032);
      return;
    }
    if (parama.dnD())
    {
      String str = parama.getPath();
      if ((WeakReference)wIq.get(str) != null) {
        wIq.remove(str);
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.NewTips.NewTipsManager", "unRegisterNewTips %s %s", new Object[] { parama.getPath(), Boolean.valueOf(parama.dnD()) });
      AppMethodBeat.o(184032);
      return;
      int i = g.aus(parama.getPath());
      if ((WeakReference)wIp.get(Integer.valueOf(i)) != null) {
        wIp.remove(Integer.valueOf(i));
      }
    }
  }
  
  public final void Mu(int paramInt)
  {
    AppMethodBeat.i(127245);
    if (paramInt == 0)
    {
      ae.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() path == 0");
      AppMethodBeat.o(127245);
      return;
    }
    a((WeakReference)wIp.get(Integer.valueOf(paramInt)), new com.tencent.mm.plugin.newtips.b.e(paramInt));
    AppMethodBeat.o(127245);
  }
  
  public final void Mv(int paramInt)
  {
    AppMethodBeat.i(185494);
    a(new com.tencent.mm.plugin.newtips.b.e(paramInt));
    AppMethodBeat.o(185494);
  }
  
  public final void a(com.tencent.mm.plugin.newtips.b.e parame)
  {
    AppMethodBeat.i(200594);
    Object localObject1 = e.eI(com.tencent.mm.plugin.newtips.a.dxF().c(parame));
    if (((List)localObject1).isEmpty())
    {
      AppMethodBeat.o(200594);
      return;
    }
    Iterator localIterator1 = ((List)localObject1).iterator();
    while (localIterator1.hasNext()) {
      ((com.tencent.mm.plugin.newtips.b.c)localIterator1.next()).field_state = 1;
    }
    ae.i("MicroMsg.NewTips.NewTipsManager", "clickNewTip(%s) clickNewTip tipsInfos state to NEW_TIPS_STATE_DISAPPEAR. ret: %s", new Object[] { parame, Integer.valueOf(com.tencent.mm.plugin.newtips.a.dxF().eK((List)localObject1)) });
    b(parame);
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      parame = ((com.tencent.mm.plugin.newtips.b.c)((Iterator)localObject1).next()).field_parents;
      if ((parame != null) && (parame.fXm != null))
      {
        localIterator1 = parame.fXm.iterator();
        while (localIterator1.hasNext())
        {
          Object localObject2 = (String)localIterator1.next();
          int i = g.aus((String)localObject2);
          if (i == 0) {}
          List localList;
          for (parame = new com.tencent.mm.plugin.newtips.b.e((String)localObject2);; parame = new com.tencent.mm.plugin.newtips.b.e(i))
          {
            localList = com.tencent.mm.plugin.newtips.a.dxF().c(parame);
            Iterator localIterator2 = localList.iterator();
            while (localIterator2.hasNext()) {
              ((com.tencent.mm.plugin.newtips.b.c)localIterator2.next()).field_state = 1;
            }
          }
          ae.i("MicroMsg.NewTips.NewTipsManager", "clickNewTip() clickNewTip parentTipsInfos(%s) state to NEW_TIPS_STATE_DISAPPEAR. ret: %s", new Object[] { localObject2, Integer.valueOf(com.tencent.mm.plugin.newtips.a.dxF().eK(localList)) });
          b(parame);
          parame = localList.iterator();
          while (parame.hasNext())
          {
            localObject2 = (com.tencent.mm.plugin.newtips.b.c)parame.next();
            a(com.tencent.mm.plugin.newtips.a.dxF().auv(((com.tencent.mm.plugin.newtips.b.c)localObject2).field_uniqueId), (com.tencent.mm.plugin.newtips.b.c)localObject2, 1);
          }
        }
      }
    }
    AppMethodBeat.o(200594);
  }
  
  public final void h(a parama)
  {
    AppMethodBeat.i(127244);
    if (parama == null)
    {
      ae.i("MicroMsg.NewTips.NewTipsManager", "registerNewTips() iNewTipsView is null");
      AppMethodBeat.o(127244);
      return;
    }
    if (bu.isNullOrNil(parama.getPath()))
    {
      ae.i("MicroMsg.NewTips.NewTipsManager", "registerNewTips() iNewTipsView.getPath() is null");
      AppMethodBeat.o(127244);
      return;
    }
    Object localObject;
    if (parama.dnD())
    {
      localObject = parama.getPath();
      WeakReference localWeakReference = (WeakReference)wIq.get(localObject);
      if ((localWeakReference != null) && (parama.equals((a)localWeakReference.get())))
      {
        ae.i("MicroMsg.NewTips.NewTipsManager", "registerNewTips(%s) iNewTipsView had registed!", new Object[] { localObject });
        aut((String)localObject);
        AppMethodBeat.o(127244);
        return;
      }
      wIq.put(localObject, new WeakReference(parama));
      aut((String)localObject);
    }
    for (;;)
    {
      ae.i("MicroMsg.NewTips.NewTipsManager", "registerNewTips() register %s (%s) [%s] (%s)", new Object[] { parama.getPath(), Boolean.valueOf(parama.dnD()), parama.toString(), parama.getClass().getName() + "@" + Integer.toHexString(parama.hashCode()) });
      AppMethodBeat.o(127244);
      return;
      int i = g.aus(parama.getPath());
      localObject = (WeakReference)wIp.get(Integer.valueOf(i));
      if ((localObject != null) && (parama.equals((a)((WeakReference)localObject).get())))
      {
        ae.i("MicroMsg.NewTips.NewTipsManager", "registerNewTips(%s) iNewTipsView had registed!", new Object[] { parama.getPath() });
        Mu(i);
        AppMethodBeat.o(127244);
        return;
      }
      wIp.put(Integer.valueOf(i), new WeakReference(parama));
      Mu(i);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(127239);
    ae.i("MicroMsg.NewTips.NewTipsManager", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramn.getType() == 597)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(127239);
        return;
      }
      boolean bool = ((b)paramn).wHN;
      paramInt1 = ((b)paramn).wHO;
      paramString = com.tencent.mm.plugin.newtips.a.dxE().My(paramInt1);
      if (paramString != null)
      {
        paramString.field_isReject = bool;
        ae.i("MicroMsg.NewTips.NewTipsManager", "Newtips push is reject: %s", new Object[] { Boolean.valueOf(bool) });
        com.tencent.mm.plugin.newtips.a.dxE().a(paramString, new String[0]);
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