package com.tencent.mm.plugin.newtips.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.newtips.PluginNewTips;
import com.tencent.mm.plugin.newtips.PluginNewTips.a;
import com.tencent.mm.protocal.protobuf.ehv;
import com.tencent.mm.protocal.protobuf.ehx;
import com.tencent.mm.protocal.protobuf.ehy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class i
  implements com.tencent.mm.ak.i
{
  private static HashMap<String, WeakReference<a>> ADA;
  private static HashMap<Integer, WeakReference<a>> ADz;
  public a ADB = null;
  
  static
  {
    AppMethodBeat.i(127251);
    ADz = new HashMap();
    ADA = new HashMap();
    AppMethodBeat.o(127251);
  }
  
  public static void TA(int paramInt)
  {
    AppMethodBeat.i(127241);
    com.tencent.mm.plugin.newtips.b.a locala = com.tencent.mm.plugin.newtips.a.exm().TF(paramInt);
    if (locala == null)
    {
      Log.e("MicroMsg.NewTips.NewTipsManager", "newTipsInfo is null , makeRead failed!!");
      AppMethodBeat.o(127241);
      return;
    }
    Log.i("MicroMsg.NewTips.NewTipsManager", "dancy new tips tipsId:%s, make read: %s", new Object[] { Integer.valueOf(paramInt), Boolean.TRUE });
    if (locala.field_tipType == d.ACZ)
    {
      locala.field_hadRead = true;
      com.tencent.mm.plugin.newtips.a.exm().a(locala, new String[0]);
    }
    if (locala.field_tipType == d.ADa)
    {
      locala.field_hadRead = true;
      com.tencent.mm.plugin.newtips.a.exm().a(locala, new String[0]);
    }
    long l = Util.nowMilliSecond();
    MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_newtips_report", 0).edit().putLong("newtips_makeread_time", l).commit();
    AppMethodBeat.o(127241);
  }
  
  public static void TD(int paramInt)
  {
    AppMethodBeat.i(258631);
    com.tencent.mm.plugin.newtips.a.exl().TB(paramInt);
    AppMethodBeat.o(258631);
  }
  
  private void a(final WeakReference<a> paramWeakReference, final com.tencent.mm.plugin.newtips.b.e parame)
  {
    AppMethodBeat.i(188561);
    if (paramWeakReference == null)
    {
      Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() weakReference(%s) is null", new Object[] { parame });
      AppMethodBeat.o(188561);
      return;
    }
    paramWeakReference = (a)paramWeakReference.get();
    if (paramWeakReference == null)
    {
      Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() curNewTip(%s) is null", new Object[] { parame });
      AppMethodBeat.o(188561);
      return;
    }
    if (g.c(paramWeakReference))
    {
      Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() curNewTip(%s) is show old new tip", new Object[] { parame });
      AppMethodBeat.o(188561);
      return;
    }
    h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(188558);
        Pair localPair = i.a(i.this, parame);
        Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() path:%s show %s [%s,%s,%s]", new Object[] { parame, ((k)localPair.first).ADM, ((ehv)localPair.second).title, ((ehv)localPair.second).url, Integer.valueOf(((ehv)localPair.second).ibS) });
        boolean bool2;
        if (g.a(parame, (k)localPair.first))
        {
          k localk = g.e(paramWeakReference);
          Object localObject = paramWeakReference;
          int i;
          if (localObject == null)
          {
            Log.e("MicroMsg.NewTips.NewTipsHelper", "isEqual() curNewTip == null");
            i = 1;
          }
          while (i != 0)
          {
            Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() path:%s origin==new", new Object[] { parame });
            AppMethodBeat.o(188558);
            return;
            if (localk != localPair.first)
            {
              i = 0;
            }
            else
            {
              localObject = g.f((a)localObject);
              ehv localehv = (ehv)localPair.second;
              if ((localObject == null) && (localehv == null))
              {
                i = 1;
              }
              else
              {
                if (((localObject != null) && (localehv == null)) || ((localObject == null) && (localehv != null))) {}
                switch (g.2.ADy[localk.ordinal()])
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
                  switch (g.2.ADy[localk.ordinal()])
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
                    if (Util.isEqual(((ehv)localObject).title, localehv.title)) {
                      i = 1;
                    } else {
                      i = 0;
                    }
                    break;
                  case 4: 
                    if (Util.isEqual(((ehv)localObject).url, localehv.url)) {
                      i = 1;
                    } else {
                      i = 0;
                    }
                    break;
                  case 5: 
                    if ((Util.isEqual(((ehv)localObject).title, localehv.title)) && (Util.isEqual(((ehv)localObject).url, localehv.url))) {
                      i = 1;
                    } else {
                      i = 0;
                    }
                    break;
                  case 6: 
                    if (Util.isEqual(((ehv)localObject).ibS, localehv.ibS)) {
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
          bool2 = g.a(paramWeakReference, new Pair(localk, new ehv()), false);
          if (!bool2) {
            break label602;
          }
        }
        label602:
        for (boolean bool1 = g.a(paramWeakReference, localPair, true);; bool1 = true)
        {
          Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() path:%s hideResult:%s showReuslt:%s", new Object[] { parame, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
          AppMethodBeat.o(188558);
          return;
          Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() curNewTip(%s) not support %s", new Object[] { parame, ((k)localPair.first).toString() });
          AppMethodBeat.o(188558);
          return;
        }
      }
    });
    AppMethodBeat.o(188561);
  }
  
  private void a(List<com.tencent.mm.plugin.newtips.b.c> paramList, com.tencent.mm.plugin.newtips.b.c paramc, int paramInt)
  {
    AppMethodBeat.i(127248);
    if (paramInt >= 10)
    {
      Log.e("MicroMsg.NewTips.NewTipsManager", "logicDisappearParent() disappear fail!!!!!");
      AppMethodBeat.o(127248);
      return;
    }
    paramc = paramc.field_parents;
    if ((paramc != null) && (paramc.gCs != null))
    {
      Iterator localIterator1 = paramc.gCs.iterator();
      while (localIterator1.hasNext())
      {
        String str = (String)localIterator1.next();
        ArrayList localArrayList = new ArrayList();
        int i = g.aIB(str);
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
          if (paramc.ADS)
          {
            if (!Util.isEqual(localc.field_dynamicPath, paramc.ADR)) {
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
        Log.d("MicroMsg.NewTips.NewTipsManager", "clickNewTip() clickNewTip parentTipsInfos(%s) state to NEW_TIPS_STATE_DISAPPEAR. ret: %s layer: %s", new Object[] { str, Integer.valueOf(com.tencent.mm.plugin.newtips.a.exn().fI(localArrayList)), Integer.valueOf(paramInt) });
        b(paramc);
      }
    }
    AppMethodBeat.o(127248);
  }
  
  private void aIC(String paramString)
  {
    AppMethodBeat.i(188560);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() dynamicPath is null");
      AppMethodBeat.o(188560);
      return;
    }
    a((WeakReference)ADA.get(paramString), new com.tencent.mm.plugin.newtips.b.e(paramString));
    AppMethodBeat.o(188560);
  }
  
  public static com.tencent.mm.plugin.newtips.b.a as(Map<String, String> paramMap)
  {
    AppMethodBeat.i(127242);
    if (paramMap == null)
    {
      Log.e("MicroMsg.NewTips.NewTipsManager", "parse newtips map fail! map is null!!");
      AppMethodBeat.o(127242);
      return null;
    }
    long l = Util.nowSecond();
    com.tencent.mm.plugin.newtips.b.a locala = new com.tencent.mm.plugin.newtips.b.a();
    locala.field_tipId = Util.getInt((String)paramMap.get(".sysmsg.newtips.control.tips_id"), 0);
    locala.field_tipVersion = Util.getInt((String)paramMap.get(".sysmsg.newtips.control.tips_version"), 0);
    locala.field_tipType = Util.getInt((String)paramMap.get(".sysmsg.newtips.control.tips_type"), 0);
    locala.field_beginShowTime = Math.max(Util.getLong((String)paramMap.get(".sysmsg.newtips.control.begin_time"), 0L), l);
    locala.field_overdueTime = Util.getLong((String)paramMap.get(".sysmsg.newtips.control.overdue_time"), 0L);
    locala.field_disappearTime = Util.getLong((String)paramMap.get(".sysmsg.newtips.control.disappear_time"), 0L);
    if (paramMap.get(".sysmsg.newtips.control.tips_showInfo") != null)
    {
      locala.field_tipsShowInfo = new ehx();
      locala.field_tipsShowInfo.dDG = Util.getInt((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo.show_type"), 0);
      locala.field_tipsShowInfo.title = ((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo.title"));
      locala.field_tipsShowInfo.qGB = ((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo.icon_url"));
      locala.field_tipsShowInfo.path = ((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo.path"));
    }
    locala.field_extInfo = ((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo."));
    com.tencent.mm.plugin.newtips.a.exm().TF(locala.field_tipId);
    com.tencent.mm.plugin.newtips.a.exo();
    if ((e.a(locala)) && (e.b(locala)) && (e.c(locala)) && (!locala.field_isReject)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        locala.field_isExit = true;
        com.tencent.mm.plugin.newtips.a.exm().a(locala, new String[0]);
      }
      AppMethodBeat.o(127242);
      return locala;
    }
  }
  
  public static void aw(int paramInt, long paramLong)
  {
    AppMethodBeat.i(127243);
    com.tencent.mm.plugin.newtips.b.a locala = com.tencent.mm.plugin.newtips.a.exm().TF(paramInt);
    if (locala == null)
    {
      Log.e("MicroMsg.NewTips.NewTipsManager", "setPageStayTime fail! newTipsInfo is null!!");
      AppMethodBeat.o(127243);
      return;
    }
    locala.field_pagestaytime = paramLong;
    com.tencent.mm.plugin.newtips.a.exm().a(locala, new String[0]);
    AppMethodBeat.o(127243);
  }
  
  private static void b(com.tencent.mm.plugin.newtips.b.e parame)
  {
    AppMethodBeat.i(188563);
    if (parame == null)
    {
      AppMethodBeat.o(188563);
      return;
    }
    if (parame.ADS)
    {
      parame = parame.ADR;
      com.tencent.mm.plugin.newtips.a.exl().aIC(parame);
      AppMethodBeat.o(188563);
      return;
    }
    int i = parame.path;
    com.tencent.mm.plugin.newtips.a.exl().TB(i);
    AppMethodBeat.o(188563);
  }
  
  public static void b(String paramString, PluginNewTips.a parama)
  {
    AppMethodBeat.i(184031);
    String str = Util.nullAs(paramString, "null");
    boolean bool = MultiProcessMMKV.getMMKV("new_tips").getBoolean(str, false);
    Log.i("MicroMsg.NewTips.NewTipsManager", "registerLocalNewTips() uniqueId(%s) isReject(%s)", new Object[] { paramString, Boolean.valueOf(bool) });
    if (bool)
    {
      AppMethodBeat.o(184031);
      return;
    }
    if (parama != null) {
      PluginNewTips.addLocalNewTipsCallback(paramString, parama);
    }
    parama = new c(paramString);
    com.tencent.mm.kernel.g.azz().a(parama, 0);
    Log.i("MicroMsg.NewTips.NewTipsManager", "registerLocalNewTips() uniqueId:%s", new Object[] { paramString });
    AppMethodBeat.o(184031);
  }
  
  public static void f(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(127240);
    com.tencent.mm.plugin.newtips.b.a locala = com.tencent.mm.plugin.newtips.a.exm().TF(paramInt1);
    if (locala == null)
    {
      locala = new com.tencent.mm.plugin.newtips.b.a();
      locala.field_tipId = paramInt1;
      locala.field_tipVersion = 1;
      locala.field_tipkey = paramString1;
      locala.field_tipType = paramInt2;
      if (locala.field_tipsShowInfo == null) {
        locala.field_tipsShowInfo = new ehx();
      }
      locala.field_tipsShowInfo.path = paramString2;
      com.tencent.mm.plugin.newtips.a.exm().f(locala);
      if ((paramInt2 == d.ACZ) && ((!locala.field_isExit) || (1 != locala.field_tipVersion)))
      {
        paramString1 = new b(paramInt1, 1, paramString1);
        com.tencent.mm.kernel.g.azz().a(paramString1, 0);
        Log.d("MicroMsg.NewTips.NewTipsManager", "dancy doScene NetScenePushCompatNewTips！！");
        AppMethodBeat.o(127240);
      }
    }
    else
    {
      if ((paramInt2 == d.ACZ) && ((!locala.field_isExit) || (1 != locala.field_tipVersion)))
      {
        b localb = new b(paramInt1, 1, paramString1);
        com.tencent.mm.kernel.g.azz().a(localb, 0);
        Log.d("MicroMsg.NewTips.NewTipsManager", "dancy doScene NetScenePushCompatNewTips！！");
      }
      if (((paramInt2 == d.ACZ) && (1 != locala.field_tipVersion)) || ((paramInt2 == d.ADa) && (locala.field_tipVersion <= 0)))
      {
        locala.field_tipId = paramInt1;
        locala.field_tipVersion = 1;
        locala.field_tipkey = paramString1;
        locala.field_tipType = paramInt2;
        locala.field_isExit = false;
        if (locala.field_tipsShowInfo == null) {
          locala.field_tipsShowInfo = new ehx();
        }
        locala.field_tipsShowInfo.path = paramString2;
        com.tencent.mm.plugin.newtips.a.exm().a(locala, new String[0]);
      }
    }
    AppMethodBeat.o(127240);
  }
  
  public static void fH(List<com.tencent.mm.plugin.newtips.b.c> paramList)
  {
    AppMethodBeat.i(127249);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (com.tencent.mm.plugin.newtips.b.c)paramList.next();
      if (Util.isNullOrNil(((com.tencent.mm.plugin.newtips.b.c)localObject).field_dynamicPath))
      {
        int i = ((com.tencent.mm.plugin.newtips.b.c)localObject).field_path;
        com.tencent.mm.plugin.newtips.a.exl().TB(i);
      }
      else
      {
        localObject = ((com.tencent.mm.plugin.newtips.b.c)localObject).field_dynamicPath;
        com.tencent.mm.plugin.newtips.a.exl().aIC((String)localObject);
      }
    }
    AppMethodBeat.o(127249);
  }
  
  public static void i(a parama)
  {
    AppMethodBeat.i(184032);
    if (parama == null)
    {
      Log.i("MicroMsg.NewTips.NewTipsManager", "unRegisterNewTips() iNewTipsView is null");
      AppMethodBeat.o(184032);
      return;
    }
    if (Util.isNullOrNil(parama.getPath()))
    {
      Log.i("MicroMsg.NewTips.NewTipsManager", "unRegisterNewTips() iNewTipsView.getPath() is null");
      AppMethodBeat.o(184032);
      return;
    }
    if (parama.ehp())
    {
      String str = parama.getPath();
      if ((WeakReference)ADA.get(str) != null) {
        ADA.remove(str);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.NewTips.NewTipsManager", "unRegisterNewTips %s %s", new Object[] { parama.getPath(), Boolean.valueOf(parama.ehp()) });
      AppMethodBeat.o(184032);
      return;
      int i = g.aIB(parama.getPath());
      if ((WeakReference)ADz.get(Integer.valueOf(i)) != null) {
        ADz.remove(Integer.valueOf(i));
      }
    }
  }
  
  public final void TB(int paramInt)
  {
    AppMethodBeat.i(127245);
    if (paramInt == 0)
    {
      Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() path == 0");
      AppMethodBeat.o(127245);
      return;
    }
    a((WeakReference)ADz.get(Integer.valueOf(paramInt)), new com.tencent.mm.plugin.newtips.b.e(paramInt));
    AppMethodBeat.o(127245);
  }
  
  public final void TC(int paramInt)
  {
    AppMethodBeat.i(185494);
    a(new com.tencent.mm.plugin.newtips.b.e(paramInt));
    AppMethodBeat.o(185494);
  }
  
  public final void a(com.tencent.mm.plugin.newtips.b.e parame)
  {
    AppMethodBeat.i(188562);
    Object localObject1 = e.fG(com.tencent.mm.plugin.newtips.a.exn().c(parame));
    if (((List)localObject1).isEmpty())
    {
      AppMethodBeat.o(188562);
      return;
    }
    Iterator localIterator1 = ((List)localObject1).iterator();
    while (localIterator1.hasNext()) {
      ((com.tencent.mm.plugin.newtips.b.c)localIterator1.next()).field_state = 1;
    }
    Log.i("MicroMsg.NewTips.NewTipsManager", "clickNewTip(%s) clickNewTip tipsInfos state to NEW_TIPS_STATE_DISAPPEAR. ret: %s", new Object[] { parame, Integer.valueOf(com.tencent.mm.plugin.newtips.a.exn().fI((List)localObject1)) });
    b(parame);
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      parame = ((com.tencent.mm.plugin.newtips.b.c)((Iterator)localObject1).next()).field_parents;
      if ((parame != null) && (parame.gCs != null))
      {
        localIterator1 = parame.gCs.iterator();
        while (localIterator1.hasNext())
        {
          Object localObject2 = (String)localIterator1.next();
          int i = g.aIB((String)localObject2);
          if (i == 0) {}
          List localList;
          for (parame = new com.tencent.mm.plugin.newtips.b.e((String)localObject2);; parame = new com.tencent.mm.plugin.newtips.b.e(i))
          {
            localList = com.tencent.mm.plugin.newtips.a.exn().c(parame);
            Iterator localIterator2 = localList.iterator();
            while (localIterator2.hasNext()) {
              ((com.tencent.mm.plugin.newtips.b.c)localIterator2.next()).field_state = 1;
            }
          }
          Log.i("MicroMsg.NewTips.NewTipsManager", "clickNewTip() clickNewTip parentTipsInfos(%s) state to NEW_TIPS_STATE_DISAPPEAR. ret: %s", new Object[] { localObject2, Integer.valueOf(com.tencent.mm.plugin.newtips.a.exn().fI(localList)) });
          b(parame);
          parame = localList.iterator();
          while (parame.hasNext())
          {
            localObject2 = (com.tencent.mm.plugin.newtips.b.c)parame.next();
            a(com.tencent.mm.plugin.newtips.a.exn().aIE(((com.tencent.mm.plugin.newtips.b.c)localObject2).field_uniqueId), (com.tencent.mm.plugin.newtips.b.c)localObject2, 1);
          }
        }
      }
    }
    AppMethodBeat.o(188562);
  }
  
  public final void h(a parama)
  {
    AppMethodBeat.i(127244);
    if (parama == null)
    {
      Log.i("MicroMsg.NewTips.NewTipsManager", "registerNewTips() iNewTipsView is null");
      AppMethodBeat.o(127244);
      return;
    }
    if (Util.isNullOrNil(parama.getPath()))
    {
      Log.i("MicroMsg.NewTips.NewTipsManager", "registerNewTips() iNewTipsView.getPath() is null");
      AppMethodBeat.o(127244);
      return;
    }
    Object localObject;
    if (parama.ehp())
    {
      localObject = parama.getPath();
      WeakReference localWeakReference = (WeakReference)ADA.get(localObject);
      if ((localWeakReference != null) && (parama.equals((a)localWeakReference.get())))
      {
        Log.i("MicroMsg.NewTips.NewTipsManager", "registerNewTips(%s) iNewTipsView had registed!", new Object[] { localObject });
        aIC((String)localObject);
        AppMethodBeat.o(127244);
        return;
      }
      ADA.put(localObject, new WeakReference(parama));
      aIC((String)localObject);
    }
    for (;;)
    {
      Log.i("MicroMsg.NewTips.NewTipsManager", "registerNewTips() register %s (%s) [%s] (%s)", new Object[] { parama.getPath(), Boolean.valueOf(parama.ehp()), parama.toString(), parama.getClass().getName() + "@" + Integer.toHexString(parama.hashCode()) });
      AppMethodBeat.o(127244);
      return;
      int i = g.aIB(parama.getPath());
      localObject = (WeakReference)ADz.get(Integer.valueOf(i));
      if ((localObject != null) && (parama.equals((a)((WeakReference)localObject).get())))
      {
        Log.i("MicroMsg.NewTips.NewTipsManager", "registerNewTips(%s) iNewTipsView had registed!", new Object[] { parama.getPath() });
        TB(i);
        AppMethodBeat.o(127244);
        return;
      }
      ADz.put(Integer.valueOf(i), new WeakReference(parama));
      TB(i);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(127239);
    Log.i("MicroMsg.NewTips.NewTipsManager", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramq.getType() == 597)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(127239);
        return;
      }
      boolean bool = ((b)paramq).ACX;
      paramInt1 = ((b)paramq).ACY;
      paramString = com.tencent.mm.plugin.newtips.a.exm().TF(paramInt1);
      if (paramString != null)
      {
        paramString.field_isReject = bool;
        Log.i("MicroMsg.NewTips.NewTipsManager", "Newtips push is reject: %s", new Object[] { Boolean.valueOf(bool) });
        com.tencent.mm.plugin.newtips.a.exm().a(paramString, new String[0]);
      }
    }
    AppMethodBeat.o(127239);
  }
  
  public static abstract interface a
  {
    public abstract void e(com.tencent.mm.plugin.newtips.b.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.i
 * JD-Core Version:    0.7.0.1
 */