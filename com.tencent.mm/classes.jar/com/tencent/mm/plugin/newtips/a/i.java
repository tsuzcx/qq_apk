package com.tencent.mm.plugin.newtips.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.newtips.PluginNewTips;
import com.tencent.mm.plugin.newtips.PluginNewTips.a;
import com.tencent.mm.protocal.protobuf.erx;
import com.tencent.mm.protocal.protobuf.erz;
import com.tencent.mm.protocal.protobuf.esa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
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
  implements com.tencent.mm.an.i
{
  private static HashMap<Integer, WeakReference<a>> GwE;
  private static HashMap<String, WeakReference<a>> GwF;
  public a GwG = null;
  
  static
  {
    AppMethodBeat.i(127251);
    GwE = new HashMap();
    GwF = new HashMap();
    AppMethodBeat.o(127251);
  }
  
  private void a(final WeakReference<a> paramWeakReference, final com.tencent.mm.plugin.newtips.b.e parame)
  {
    AppMethodBeat.i(186462);
    if (paramWeakReference == null)
    {
      Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() weakReference(%s) is null", new Object[] { parame });
      AppMethodBeat.o(186462);
      return;
    }
    paramWeakReference = (a)paramWeakReference.get();
    if (paramWeakReference == null)
    {
      Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() curNewTip(%s) is null", new Object[] { parame });
      AppMethodBeat.o(186462);
      return;
    }
    if (g.c(paramWeakReference))
    {
      Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() curNewTip(%s) is show old new tip", new Object[] { parame });
      AppMethodBeat.o(186462);
      return;
    }
    com.tencent.e.h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186684);
        Pair localPair = i.a(i.this, parame);
        Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() path:%s show %s [%s,%s,%s]", new Object[] { parame, ((k)localPair.first).GwQ, ((erx)localPair.second).title, ((erx)localPair.second).url, Integer.valueOf(((erx)localPair.second).num) });
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
            AppMethodBeat.o(186684);
            return;
            if (localk != localPair.first)
            {
              i = 0;
            }
            else
            {
              localObject = g.f((a)localObject);
              erx localerx = (erx)localPair.second;
              if ((localObject == null) && (localerx == null))
              {
                i = 1;
              }
              else
              {
                if (((localObject != null) && (localerx == null)) || ((localObject == null) && (localerx != null))) {}
                switch (g.2.GwD[localk.ordinal()])
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
                  switch (g.2.GwD[localk.ordinal()])
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
                    if (Util.isEqual(((erx)localObject).title, localerx.title)) {
                      i = 1;
                    } else {
                      i = 0;
                    }
                    break;
                  case 4: 
                    if (Util.isEqual(((erx)localObject).url, localerx.url)) {
                      i = 1;
                    } else {
                      i = 0;
                    }
                    break;
                  case 5: 
                    if ((Util.isEqual(((erx)localObject).title, localerx.title)) && (Util.isEqual(((erx)localObject).url, localerx.url))) {
                      i = 1;
                    } else {
                      i = 0;
                    }
                    break;
                  case 6: 
                    if (Util.isEqual(((erx)localObject).num, localerx.num)) {
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
          bool2 = g.a(paramWeakReference, new Pair(localk, new erx()), false);
          if (!bool2) {
            break label602;
          }
        }
        label602:
        for (boolean bool1 = g.a(paramWeakReference, localPair, true);; bool1 = true)
        {
          Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() path:%s hideResult:%s showReuslt:%s", new Object[] { parame, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
          AppMethodBeat.o(186684);
          return;
          Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() curNewTip(%s) not support %s", new Object[] { parame, ((k)localPair.first).toString() });
          AppMethodBeat.o(186684);
          return;
        }
      }
    });
    AppMethodBeat.o(186462);
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
    if ((paramc != null) && (paramc.jmy != null))
    {
      Iterator localIterator1 = paramc.jmy.iterator();
      while (localIterator1.hasNext())
      {
        String str = (String)localIterator1.next();
        ArrayList localArrayList = new ArrayList();
        int i = g.aSW(str);
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
          if (paramc.GwW)
          {
            if (!Util.isEqual(localc.field_dynamicPath, paramc.GwV)) {
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
        Log.d("MicroMsg.NewTips.NewTipsManager", "clickNewTip() clickNewTip parentTipsInfos(%s) state to NEW_TIPS_STATE_DISAPPEAR. ret: %s layer: %s", new Object[] { str, Integer.valueOf(com.tencent.mm.plugin.newtips.a.fiQ().gm(localArrayList)), Integer.valueOf(paramInt) });
        b(paramc);
      }
    }
    AppMethodBeat.o(127248);
  }
  
  public static void aI(int paramInt, long paramLong)
  {
    AppMethodBeat.i(127243);
    com.tencent.mm.plugin.newtips.b.a locala = com.tencent.mm.plugin.newtips.a.fiP().aas(paramInt);
    if (locala == null)
    {
      Log.e("MicroMsg.NewTips.NewTipsManager", "setPageStayTime fail! newTipsInfo is null!!");
      AppMethodBeat.o(127243);
      return;
    }
    locala.field_pagestaytime = paramLong;
    com.tencent.mm.plugin.newtips.a.fiP().a(locala, new String[0]);
    AppMethodBeat.o(127243);
  }
  
  public static void aSX(String paramString)
  {
    AppMethodBeat.i(186459);
    if (MMApplicationContext.isMainProcess())
    {
      b(paramString, null);
      AppMethodBeat.o(186459);
      return;
    }
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCString(paramString), i.b.class, null);
    AppMethodBeat.o(186459);
  }
  
  private void aSY(String paramString)
  {
    AppMethodBeat.i(186460);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() dynamicPath is null");
      AppMethodBeat.o(186460);
      return;
    }
    a((WeakReference)GwF.get(paramString), new com.tencent.mm.plugin.newtips.b.e(paramString));
    AppMethodBeat.o(186460);
  }
  
  public static void aan(int paramInt)
  {
    AppMethodBeat.i(127241);
    com.tencent.mm.plugin.newtips.b.a locala = com.tencent.mm.plugin.newtips.a.fiP().aas(paramInt);
    if (locala == null)
    {
      Log.e("MicroMsg.NewTips.NewTipsManager", "newTipsInfo is null , makeRead failed!!");
      AppMethodBeat.o(127241);
      return;
    }
    Log.i("MicroMsg.NewTips.NewTipsManager", "dancy new tips tipsId:%s, make read: %s", new Object[] { Integer.valueOf(paramInt), Boolean.TRUE });
    if (locala.field_tipType == d.Gwd)
    {
      locala.field_hadRead = true;
      com.tencent.mm.plugin.newtips.a.fiP().a(locala, new String[0]);
    }
    if (locala.field_tipType == d.Gwe)
    {
      locala.field_hadRead = true;
      com.tencent.mm.plugin.newtips.a.fiP().a(locala, new String[0]);
    }
    long l = Util.nowMilliSecond();
    MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_newtips_report", 0).edit().putLong("newtips_makeread_time", l).commit();
    AppMethodBeat.o(127241);
  }
  
  public static void aaq(int paramInt)
  {
    AppMethodBeat.i(292750);
    com.tencent.mm.plugin.newtips.a.fiO().aao(paramInt);
    AppMethodBeat.o(292750);
  }
  
  public static com.tencent.mm.plugin.newtips.b.a am(Map<String, String> paramMap)
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
      locala.field_tipsShowInfo = new erz();
      locala.field_tipsShowInfo.fwp = Util.getInt((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo.show_type"), 0);
      locala.field_tipsShowInfo.title = ((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo.title"));
      locala.field_tipsShowInfo.ufC = ((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo.icon_url"));
      locala.field_tipsShowInfo.path = ((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo.path"));
    }
    locala.field_extInfo = ((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo."));
    com.tencent.mm.plugin.newtips.a.fiP().aas(locala.field_tipId);
    com.tencent.mm.plugin.newtips.a.fiR();
    if ((e.a(locala)) && (e.b(locala)) && (e.c(locala)) && (!locala.field_isReject)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        locala.field_isExit = true;
        com.tencent.mm.plugin.newtips.a.fiP().a(locala, new String[0]);
      }
      AppMethodBeat.o(127242);
      return locala;
    }
  }
  
  private static void b(com.tencent.mm.plugin.newtips.b.e parame)
  {
    AppMethodBeat.i(186474);
    if (parame == null)
    {
      AppMethodBeat.o(186474);
      return;
    }
    if (parame.GwW)
    {
      parame = parame.GwV;
      com.tencent.mm.plugin.newtips.a.fiO().aSY(parame);
      AppMethodBeat.o(186474);
      return;
    }
    int i = parame.path;
    com.tencent.mm.plugin.newtips.a.fiO().aao(i);
    AppMethodBeat.o(186474);
  }
  
  public static void b(String paramString, PluginNewTips.a parama)
  {
    AppMethodBeat.i(184031);
    boolean bool = g.aSV(Util.nullAs(paramString, "null"));
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
    com.tencent.mm.kernel.h.aGY().a(parama, 0);
    Log.i("MicroMsg.NewTips.NewTipsManager", "registerLocalNewTips() uniqueId:%s", new Object[] { paramString });
    AppMethodBeat.o(184031);
  }
  
  public static void g(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(127240);
    com.tencent.mm.plugin.newtips.b.a locala = com.tencent.mm.plugin.newtips.a.fiP().aas(paramInt1);
    if (locala == null)
    {
      locala = new com.tencent.mm.plugin.newtips.b.a();
      locala.field_tipId = paramInt1;
      locala.field_tipVersion = 1;
      locala.field_tipkey = paramString1;
      locala.field_tipType = paramInt2;
      if (locala.field_tipsShowInfo == null) {
        locala.field_tipsShowInfo = new erz();
      }
      locala.field_tipsShowInfo.path = paramString2;
      com.tencent.mm.plugin.newtips.a.fiP().f(locala);
      if ((paramInt2 == d.Gwd) && ((!locala.field_isExit) || (1 != locala.field_tipVersion)))
      {
        paramString1 = new b(paramInt1, 1, paramString1);
        com.tencent.mm.kernel.h.aGY().a(paramString1, 0);
        Log.d("MicroMsg.NewTips.NewTipsManager", "dancy doScene NetScenePushCompatNewTips！！");
        AppMethodBeat.o(127240);
      }
    }
    else
    {
      if ((paramInt2 == d.Gwd) && ((!locala.field_isExit) || (1 != locala.field_tipVersion)))
      {
        b localb = new b(paramInt1, 1, paramString1);
        com.tencent.mm.kernel.h.aGY().a(localb, 0);
        Log.d("MicroMsg.NewTips.NewTipsManager", "dancy doScene NetScenePushCompatNewTips！！");
      }
      if (((paramInt2 == d.Gwd) && (1 != locala.field_tipVersion)) || ((paramInt2 == d.Gwe) && (locala.field_tipVersion <= 0)))
      {
        locala.field_tipId = paramInt1;
        locala.field_tipVersion = 1;
        locala.field_tipkey = paramString1;
        locala.field_tipType = paramInt2;
        locala.field_isExit = false;
        if (locala.field_tipsShowInfo == null) {
          locala.field_tipsShowInfo = new erz();
        }
        locala.field_tipsShowInfo.path = paramString2;
        com.tencent.mm.plugin.newtips.a.fiP().a(locala, new String[0]);
      }
    }
    AppMethodBeat.o(127240);
  }
  
  public static void gl(List<com.tencent.mm.plugin.newtips.b.c> paramList)
  {
    AppMethodBeat.i(127249);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (com.tencent.mm.plugin.newtips.b.c)paramList.next();
      if (Util.isNullOrNil(((com.tencent.mm.plugin.newtips.b.c)localObject).field_dynamicPath))
      {
        int i = ((com.tencent.mm.plugin.newtips.b.c)localObject).field_path;
        com.tencent.mm.plugin.newtips.a.fiO().aao(i);
      }
      else
      {
        localObject = ((com.tencent.mm.plugin.newtips.b.c)localObject).field_dynamicPath;
        com.tencent.mm.plugin.newtips.a.fiO().aSY((String)localObject);
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
    if (parama.eQW())
    {
      String str = parama.getPath();
      if ((WeakReference)GwF.get(str) != null) {
        GwF.remove(str);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.NewTips.NewTipsManager", "unRegisterNewTips %s %s", new Object[] { parama.getPath(), Boolean.valueOf(parama.eQW()) });
      AppMethodBeat.o(184032);
      return;
      int i = g.aSW(parama.getPath());
      if ((WeakReference)GwE.get(Integer.valueOf(i)) != null) {
        GwE.remove(Integer.valueOf(i));
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.newtips.b.e parame)
  {
    AppMethodBeat.i(186467);
    Object localObject1 = e.gk(com.tencent.mm.plugin.newtips.a.fiQ().c(parame));
    if (((List)localObject1).isEmpty())
    {
      AppMethodBeat.o(186467);
      return;
    }
    Iterator localIterator1 = ((List)localObject1).iterator();
    while (localIterator1.hasNext()) {
      ((com.tencent.mm.plugin.newtips.b.c)localIterator1.next()).field_state = 1;
    }
    Log.i("MicroMsg.NewTips.NewTipsManager", "clickNewTip(%s) clickNewTip tipsInfos state to NEW_TIPS_STATE_DISAPPEAR. ret: %s", new Object[] { parame, Integer.valueOf(com.tencent.mm.plugin.newtips.a.fiQ().gm((List)localObject1)) });
    b(parame);
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      parame = ((com.tencent.mm.plugin.newtips.b.c)((Iterator)localObject1).next()).field_parents;
      if ((parame != null) && (parame.jmy != null))
      {
        localIterator1 = parame.jmy.iterator();
        while (localIterator1.hasNext())
        {
          Object localObject2 = (String)localIterator1.next();
          int i = g.aSW((String)localObject2);
          if (i == 0) {}
          List localList;
          for (parame = new com.tencent.mm.plugin.newtips.b.e((String)localObject2);; parame = new com.tencent.mm.plugin.newtips.b.e(i))
          {
            localList = com.tencent.mm.plugin.newtips.a.fiQ().c(parame);
            Iterator localIterator2 = localList.iterator();
            while (localIterator2.hasNext()) {
              ((com.tencent.mm.plugin.newtips.b.c)localIterator2.next()).field_state = 1;
            }
          }
          Log.i("MicroMsg.NewTips.NewTipsManager", "clickNewTip() clickNewTip parentTipsInfos(%s) state to NEW_TIPS_STATE_DISAPPEAR. ret: %s", new Object[] { localObject2, Integer.valueOf(com.tencent.mm.plugin.newtips.a.fiQ().gm(localList)) });
          b(parame);
          parame = localList.iterator();
          while (parame.hasNext())
          {
            localObject2 = (com.tencent.mm.plugin.newtips.b.c)parame.next();
            a(com.tencent.mm.plugin.newtips.a.fiQ().aTa(((com.tencent.mm.plugin.newtips.b.c)localObject2).field_uniqueId), (com.tencent.mm.plugin.newtips.b.c)localObject2, 1);
          }
        }
      }
    }
    AppMethodBeat.o(186467);
  }
  
  public final void aao(int paramInt)
  {
    AppMethodBeat.i(127245);
    if (paramInt == 0)
    {
      Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() path == 0");
      AppMethodBeat.o(127245);
      return;
    }
    a((WeakReference)GwE.get(Integer.valueOf(paramInt)), new com.tencent.mm.plugin.newtips.b.e(paramInt));
    AppMethodBeat.o(127245);
  }
  
  public final void aap(int paramInt)
  {
    AppMethodBeat.i(185494);
    a(new com.tencent.mm.plugin.newtips.b.e(paramInt));
    AppMethodBeat.o(185494);
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
    if (parama.eQW())
    {
      localObject = parama.getPath();
      WeakReference localWeakReference = (WeakReference)GwF.get(localObject);
      if ((localWeakReference != null) && (parama.equals((a)localWeakReference.get())))
      {
        Log.i("MicroMsg.NewTips.NewTipsManager", "registerNewTips(%s) iNewTipsView had registed!", new Object[] { localObject });
        aSY((String)localObject);
        AppMethodBeat.o(127244);
        return;
      }
      GwF.put(localObject, new WeakReference(parama));
      aSY((String)localObject);
    }
    for (;;)
    {
      Log.i("MicroMsg.NewTips.NewTipsManager", "registerNewTips() register %s (%s) [%s] (%s)", new Object[] { parama.getPath(), Boolean.valueOf(parama.eQW()), parama.toString(), parama.getClass().getName() + "@" + Integer.toHexString(parama.hashCode()) });
      AppMethodBeat.o(127244);
      return;
      int i = g.aSW(parama.getPath());
      localObject = (WeakReference)GwE.get(Integer.valueOf(i));
      if ((localObject != null) && (parama.equals((a)((WeakReference)localObject).get())))
      {
        Log.i("MicroMsg.NewTips.NewTipsManager", "registerNewTips(%s) iNewTipsView had registed!", new Object[] { parama.getPath() });
        aao(i);
        AppMethodBeat.o(127244);
        return;
      }
      GwE.put(Integer.valueOf(i), new WeakReference(parama));
      aao(i);
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
      boolean bool = ((b)paramq).Gwb;
      paramInt1 = ((b)paramq).Gwc;
      paramString = com.tencent.mm.plugin.newtips.a.fiP().aas(paramInt1);
      if (paramString != null)
      {
        paramString.field_isReject = bool;
        Log.i("MicroMsg.NewTips.NewTipsManager", "Newtips push is reject: %s", new Object[] { Boolean.valueOf(bool) });
        com.tencent.mm.plugin.newtips.a.fiP().a(paramString, new String[0]);
      }
    }
    AppMethodBeat.o(127239);
  }
  
  public static abstract interface a
  {
    public abstract void e(com.tencent.mm.plugin.newtips.b.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.i
 * JD-Core Version:    0.7.0.1
 */