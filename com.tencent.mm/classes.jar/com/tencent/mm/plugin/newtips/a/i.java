package com.tencent.mm.plugin.newtips.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.newtips.PluginNewTips;
import com.tencent.mm.plugin.newtips.PluginNewTips.a;
import com.tencent.mm.protocal.protobuf.fng;
import com.tencent.mm.protocal.protobuf.fni;
import com.tencent.mm.protocal.protobuf.fnj;
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
  implements com.tencent.mm.am.h
{
  private static HashMap<Integer, WeakReference<a>> MsE;
  private static HashMap<String, WeakReference<a>> MsF;
  public a MsG = null;
  
  static
  {
    AppMethodBeat.i(127251);
    MsE = new HashMap();
    MsF = new HashMap();
    AppMethodBeat.o(127251);
  }
  
  private void a(final WeakReference<a> paramWeakReference, final com.tencent.mm.plugin.newtips.b.e parame)
  {
    AppMethodBeat.i(266321);
    if (paramWeakReference == null)
    {
      Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() weakReference(%s) is null", new Object[] { parame });
      AppMethodBeat.o(266321);
      return;
    }
    paramWeakReference = (a)paramWeakReference.get();
    if (paramWeakReference == null)
    {
      Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() curNewTip(%s) is null", new Object[] { parame });
      AppMethodBeat.o(266321);
      return;
    }
    if (g.c(paramWeakReference))
    {
      Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() curNewTip(%s) is show old new tip", new Object[] { parame });
      AppMethodBeat.o(266321);
      return;
    }
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(266294);
        Pair localPair = i.a(i.this, parame);
        Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() path:%s show %s [%s,%s,%s]", new Object[] { parame, ((k)localPair.first).MsQ, ((fng)localPair.second).title, ((fng)localPair.second).url, Integer.valueOf(((fng)localPair.second).num) });
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
            AppMethodBeat.o(266294);
            return;
            if (localPair == null)
            {
              Log.e("MicroMsg.NewTips.NewTipsHelper", "isEqual() second == null");
              i = 1;
            }
            else if (localk != localPair.first)
            {
              i = 0;
            }
            else
            {
              localObject = g.f((a)localObject);
              fng localfng = (fng)localPair.second;
              if ((localObject == null) && (localfng == null))
              {
                i = 1;
              }
              else
              {
                if (((localObject != null) && (localfng == null)) || ((localObject == null) && (localfng != null))) {}
                switch (g.2.MsD[localk.ordinal()])
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
                  switch (g.2.MsD[localk.ordinal()])
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
                    if (Util.isEqual(((fng)localObject).title, localfng.title)) {
                      i = 1;
                    } else {
                      i = 0;
                    }
                    break;
                  case 4: 
                    if (Util.isEqual(((fng)localObject).url, localfng.url)) {
                      i = 1;
                    } else {
                      i = 0;
                    }
                    break;
                  case 5: 
                    if ((Util.isEqual(((fng)localObject).title, localfng.title)) && (Util.isEqual(((fng)localObject).url, localfng.url))) {
                      i = 1;
                    } else {
                      i = 0;
                    }
                    break;
                  case 6: 
                    if (Util.isEqual(((fng)localObject).num, localfng.num)) {
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
          bool2 = g.a(paramWeakReference, new Pair(localk, new fng()), false);
          if (!bool2) {
            break label618;
          }
        }
        label618:
        for (boolean bool1 = g.a(paramWeakReference, localPair, true);; bool1 = true)
        {
          Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() path:%s hideResult:%s showReuslt:%s", new Object[] { parame, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
          AppMethodBeat.o(266294);
          return;
          Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() curNewTip(%s) not support %s", new Object[] { parame, ((k)localPair.first).toString() });
          AppMethodBeat.o(266294);
          return;
        }
      }
    });
    AppMethodBeat.o(266321);
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
    if ((paramc != null) && (paramc.lPK != null))
    {
      Iterator localIterator1 = paramc.lPK.iterator();
      while (localIterator1.hasNext())
      {
        String str = (String)localIterator1.next();
        ArrayList localArrayList = new ArrayList();
        int i = g.aPV(str);
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
          if (paramc.MsW)
          {
            if (!Util.isEqual(localc.field_dynamicPath, paramc.MsV)) {
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
        Log.d("MicroMsg.NewTips.NewTipsManager", "clickNewTip() clickNewTip parentTipsInfos(%s) state to NEW_TIPS_STATE_DISAPPEAR. ret: %s layer: %s", new Object[] { str, Integer.valueOf(com.tencent.mm.plugin.newtips.a.gth().jl(localArrayList)), Integer.valueOf(paramInt) });
        b(paramc);
      }
    }
    AppMethodBeat.o(127248);
  }
  
  public static com.tencent.mm.plugin.newtips.b.a aC(Map<String, String> paramMap)
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
      locala.field_tipsShowInfo = new fni();
      locala.field_tipsShowInfo.hAN = Util.getInt((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo.show_type"), 0);
      locala.field_tipsShowInfo.title = ((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo.title"));
      locala.field_tipsShowInfo.icon_url = ((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo.icon_url"));
      locala.field_tipsShowInfo.path = ((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo.path"));
    }
    locala.field_extInfo = ((String)paramMap.get(".sysmsg.newtips.control.tips_showInfo."));
    com.tencent.mm.plugin.newtips.a.gtg().aeL(locala.field_tipId);
    com.tencent.mm.plugin.newtips.a.gti();
    if ((e.a(locala)) && (e.b(locala)) && (e.c(locala)) && (!locala.field_isReject)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        locala.field_isExit = true;
        com.tencent.mm.plugin.newtips.a.gtg().a(locala, new String[0]);
      }
      AppMethodBeat.o(127242);
      return locala;
    }
  }
  
  public static void aP(int paramInt, long paramLong)
  {
    AppMethodBeat.i(127243);
    com.tencent.mm.plugin.newtips.b.a locala = com.tencent.mm.plugin.newtips.a.gtg().aeL(paramInt);
    if (locala == null)
    {
      Log.e("MicroMsg.NewTips.NewTipsManager", "setPageStayTime fail! newTipsInfo is null!!");
      AppMethodBeat.o(127243);
      return;
    }
    locala.field_pagestaytime = paramLong;
    com.tencent.mm.plugin.newtips.a.gtg().a(locala, new String[0]);
    AppMethodBeat.o(127243);
  }
  
  public static void aPW(String paramString)
  {
    AppMethodBeat.i(266315);
    if (MMApplicationContext.isMainProcess())
    {
      b(paramString, null);
      AppMethodBeat.o(266315);
      return;
    }
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCString(paramString), b.class, null);
    AppMethodBeat.o(266315);
  }
  
  private void aPX(String paramString)
  {
    AppMethodBeat.i(266320);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() dynamicPath is null");
      AppMethodBeat.o(266320);
      return;
    }
    a((WeakReference)MsF.get(paramString), new com.tencent.mm.plugin.newtips.b.e(paramString));
    AppMethodBeat.o(266320);
  }
  
  public static void aeG(int paramInt)
  {
    AppMethodBeat.i(127241);
    com.tencent.mm.plugin.newtips.b.a locala = com.tencent.mm.plugin.newtips.a.gtg().aeL(paramInt);
    if (locala == null)
    {
      Log.e("MicroMsg.NewTips.NewTipsManager", "newTipsInfo is null , makeRead failed!!");
      AppMethodBeat.o(127241);
      return;
    }
    Log.i("MicroMsg.NewTips.NewTipsManager", "dancy new tips tipsId:%s, make read: %s", new Object[] { Integer.valueOf(paramInt), Boolean.TRUE });
    if (locala.field_tipType == d.Msc)
    {
      locala.field_hadRead = true;
      com.tencent.mm.plugin.newtips.a.gtg().a(locala, new String[0]);
    }
    if (locala.field_tipType == d.Msd)
    {
      locala.field_hadRead = true;
      com.tencent.mm.plugin.newtips.a.gtg().a(locala, new String[0]);
    }
    long l = Util.nowMilliSecond();
    MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_newtips_report", 0).edit().putLong("newtips_makeread_time", l).commit();
    AppMethodBeat.o(127241);
  }
  
  public static void aeJ(int paramInt)
  {
    AppMethodBeat.i(369735);
    com.tencent.mm.plugin.newtips.a.gtf().aeH(paramInt);
    AppMethodBeat.o(369735);
  }
  
  private static void b(com.tencent.mm.plugin.newtips.b.e parame)
  {
    AppMethodBeat.i(266324);
    if (parame == null)
    {
      AppMethodBeat.o(266324);
      return;
    }
    if (parame.MsW)
    {
      parame = parame.MsV;
      com.tencent.mm.plugin.newtips.a.gtf().aPX(parame);
      AppMethodBeat.o(266324);
      return;
    }
    int i = parame.path;
    com.tencent.mm.plugin.newtips.a.gtf().aeH(i);
    AppMethodBeat.o(266324);
  }
  
  public static void b(String paramString, PluginNewTips.a parama)
  {
    AppMethodBeat.i(184031);
    boolean bool = g.aPU(Util.nullAs(paramString, "null"));
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
    com.tencent.mm.kernel.h.aZW().a(parama, 0);
    Log.i("MicroMsg.NewTips.NewTipsManager", "registerLocalNewTips() uniqueId:%s", new Object[] { paramString });
    AppMethodBeat.o(184031);
  }
  
  public static void h(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(127240);
    com.tencent.mm.plugin.newtips.b.a locala = com.tencent.mm.plugin.newtips.a.gtg().aeL(paramInt1);
    if (locala == null)
    {
      locala = new com.tencent.mm.plugin.newtips.b.a();
      locala.field_tipId = paramInt1;
      locala.field_tipVersion = 1;
      locala.field_tipkey = paramString1;
      locala.field_tipType = paramInt2;
      if (locala.field_tipsShowInfo == null) {
        locala.field_tipsShowInfo = new fni();
      }
      locala.field_tipsShowInfo.path = paramString2;
      com.tencent.mm.plugin.newtips.a.gtg().f(locala);
      if ((paramInt2 == d.Msc) && ((!locala.field_isExit) || (1 != locala.field_tipVersion)))
      {
        paramString1 = new b(paramInt1, 1, paramString1);
        com.tencent.mm.kernel.h.aZW().a(paramString1, 0);
        Log.d("MicroMsg.NewTips.NewTipsManager", "dancy doScene NetScenePushCompatNewTips！！");
        AppMethodBeat.o(127240);
      }
    }
    else
    {
      if ((paramInt2 == d.Msc) && ((!locala.field_isExit) || (1 != locala.field_tipVersion)))
      {
        b localb = new b(paramInt1, 1, paramString1);
        com.tencent.mm.kernel.h.aZW().a(localb, 0);
        Log.d("MicroMsg.NewTips.NewTipsManager", "dancy doScene NetScenePushCompatNewTips！！");
      }
      if (((paramInt2 == d.Msc) && (1 != locala.field_tipVersion)) || ((paramInt2 == d.Msd) && (locala.field_tipVersion <= 0)))
      {
        locala.field_tipId = paramInt1;
        locala.field_tipVersion = 1;
        locala.field_tipkey = paramString1;
        locala.field_tipType = paramInt2;
        locala.field_isExit = false;
        if (locala.field_tipsShowInfo == null) {
          locala.field_tipsShowInfo = new fni();
        }
        locala.field_tipsShowInfo.path = paramString2;
        com.tencent.mm.plugin.newtips.a.gtg().a(locala, new String[0]);
      }
    }
    AppMethodBeat.o(127240);
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
    if (parama.fZD())
    {
      String str = parama.getPath();
      if ((WeakReference)MsF.get(str) != null) {
        MsF.remove(str);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.NewTips.NewTipsManager", "unRegisterNewTips %s %s", new Object[] { parama.getPath(), Boolean.valueOf(parama.fZD()) });
      AppMethodBeat.o(184032);
      return;
      int i = g.aPV(parama.getPath());
      if ((WeakReference)MsE.get(Integer.valueOf(i)) != null) {
        MsE.remove(Integer.valueOf(i));
      }
    }
  }
  
  public static void jk(List<com.tencent.mm.plugin.newtips.b.c> paramList)
  {
    AppMethodBeat.i(127249);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (com.tencent.mm.plugin.newtips.b.c)paramList.next();
      if (Util.isNullOrNil(((com.tencent.mm.plugin.newtips.b.c)localObject).field_dynamicPath))
      {
        int i = ((com.tencent.mm.plugin.newtips.b.c)localObject).field_path;
        com.tencent.mm.plugin.newtips.a.gtf().aeH(i);
      }
      else
      {
        localObject = ((com.tencent.mm.plugin.newtips.b.c)localObject).field_dynamicPath;
        com.tencent.mm.plugin.newtips.a.gtf().aPX((String)localObject);
      }
    }
    AppMethodBeat.o(127249);
  }
  
  public final void a(com.tencent.mm.plugin.newtips.b.e parame)
  {
    AppMethodBeat.i(266338);
    Object localObject1 = e.jj(com.tencent.mm.plugin.newtips.a.gth().c(parame));
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      AppMethodBeat.o(266338);
      return;
    }
    Iterator localIterator1 = ((List)localObject1).iterator();
    while (localIterator1.hasNext()) {
      ((com.tencent.mm.plugin.newtips.b.c)localIterator1.next()).field_state = 1;
    }
    Log.i("MicroMsg.NewTips.NewTipsManager", "clickNewTip(%s) clickNewTip tipsInfos state to NEW_TIPS_STATE_DISAPPEAR. ret: %s", new Object[] { parame, Integer.valueOf(com.tencent.mm.plugin.newtips.a.gth().jl((List)localObject1)) });
    b(parame);
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      parame = ((com.tencent.mm.plugin.newtips.b.c)((Iterator)localObject1).next()).field_parents;
      if ((parame != null) && (parame.lPK != null))
      {
        localIterator1 = parame.lPK.iterator();
        while (localIterator1.hasNext())
        {
          Object localObject2 = (String)localIterator1.next();
          int i = g.aPV((String)localObject2);
          if (i == 0) {}
          List localList;
          for (parame = new com.tencent.mm.plugin.newtips.b.e((String)localObject2);; parame = new com.tencent.mm.plugin.newtips.b.e(i))
          {
            localList = com.tencent.mm.plugin.newtips.a.gth().c(parame);
            Iterator localIterator2 = localList.iterator();
            while (localIterator2.hasNext()) {
              ((com.tencent.mm.plugin.newtips.b.c)localIterator2.next()).field_state = 1;
            }
          }
          Log.i("MicroMsg.NewTips.NewTipsManager", "clickNewTip() clickNewTip parentTipsInfos(%s) state to NEW_TIPS_STATE_DISAPPEAR. ret: %s", new Object[] { localObject2, Integer.valueOf(com.tencent.mm.plugin.newtips.a.gth().jl(localList)) });
          b(parame);
          parame = localList.iterator();
          while (parame.hasNext())
          {
            localObject2 = (com.tencent.mm.plugin.newtips.b.c)parame.next();
            a(com.tencent.mm.plugin.newtips.a.gth().aPZ(((com.tencent.mm.plugin.newtips.b.c)localObject2).field_uniqueId), (com.tencent.mm.plugin.newtips.b.c)localObject2, 1);
          }
        }
      }
    }
    AppMethodBeat.o(266338);
  }
  
  public final void aeH(int paramInt)
  {
    AppMethodBeat.i(127245);
    if (paramInt == 0)
    {
      Log.i("MicroMsg.NewTips.NewTipsManager", "showNewTip() path == 0");
      AppMethodBeat.o(127245);
      return;
    }
    a((WeakReference)MsE.get(Integer.valueOf(paramInt)), new com.tencent.mm.plugin.newtips.b.e(paramInt));
    AppMethodBeat.o(127245);
  }
  
  public final void aeI(int paramInt)
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
    if (parama.fZD())
    {
      localObject = parama.getPath();
      WeakReference localWeakReference = (WeakReference)MsF.get(localObject);
      if ((localWeakReference != null) && (parama.equals((a)localWeakReference.get())))
      {
        Log.i("MicroMsg.NewTips.NewTipsManager", "registerNewTips(%s) iNewTipsView had registed!", new Object[] { localObject });
        aPX((String)localObject);
        AppMethodBeat.o(127244);
        return;
      }
      MsF.put(localObject, new WeakReference(parama));
      aPX((String)localObject);
    }
    for (;;)
    {
      Log.i("MicroMsg.NewTips.NewTipsManager", "registerNewTips() register %s (%s) [%s] (%s)", new Object[] { parama.getPath(), Boolean.valueOf(parama.fZD()), parama.toString(), parama.getClass().getName() + "@" + Integer.toHexString(parama.hashCode()) });
      AppMethodBeat.o(127244);
      return;
      int i = g.aPV(parama.getPath());
      localObject = (WeakReference)MsE.get(Integer.valueOf(i));
      if ((localObject != null) && (parama.equals((a)((WeakReference)localObject).get())))
      {
        Log.i("MicroMsg.NewTips.NewTipsManager", "registerNewTips(%s) iNewTipsView had registed!", new Object[] { parama.getPath() });
        aeH(i);
        AppMethodBeat.o(127244);
        return;
      }
      MsE.put(Integer.valueOf(i), new WeakReference(parama));
      aeH(i);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(127239);
    Log.i("MicroMsg.NewTips.NewTipsManager", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramp.getType() == 597)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(127239);
        return;
      }
      boolean bool = ((b)paramp).Msa;
      paramInt1 = ((b)paramp).Msb;
      paramString = com.tencent.mm.plugin.newtips.a.gtg().aeL(paramInt1);
      if (paramString != null)
      {
        paramString.field_isReject = bool;
        Log.i("MicroMsg.NewTips.NewTipsManager", "Newtips push is reject: %s", new Object[] { Boolean.valueOf(bool) });
        com.tencent.mm.plugin.newtips.a.gtg().a(paramString, new String[0]);
      }
    }
    AppMethodBeat.o(127239);
  }
  
  public static abstract interface a
  {
    public abstract void e(com.tencent.mm.plugin.newtips.b.a parama);
  }
  
  class b
    implements com.tencent.mm.ipcinvoker.d<IPCString, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.i
 * JD-Core Version:    0.7.0.1
 */