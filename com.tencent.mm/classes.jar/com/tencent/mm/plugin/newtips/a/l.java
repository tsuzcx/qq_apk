package com.tencent.mm.plugin.newtips.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.newtips.b.b;
import com.tencent.mm.plugin.newtips.b.c;
import com.tencent.mm.protocal.protobuf.ehx;
import com.tencent.mm.protocal.protobuf.ehy;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class l
  implements p
{
  private static final Long duN;
  private ConcurrentHashMap<String, a> ADO;
  
  static
  {
    AppMethodBeat.i(127261);
    duN = Long.valueOf(604800L);
    AppMethodBeat.o(127261);
  }
  
  public l()
  {
    AppMethodBeat.i(188566);
    this.ADO = new ConcurrentHashMap();
    AppMethodBeat.o(188566);
  }
  
  public final h.b a(String paramString, Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(127260);
    Log.d("MicroMsg.NewTips.NewTipsXMLConsumer", "dancy consumeNewXml， subType:%s", new Object[] { paramString });
    long l3;
    int k;
    int j;
    label255:
    Object localObject1;
    label366:
    label372:
    Object localObject2;
    if ((Util.nullAsNil(paramString).equals("newtips")) && (paramMap != null))
    {
      if (paramMap.get(".sysmsg.newtips.tips_showInfo_list") == null) {
        break label2392;
      }
      paramString = "";
      l3 = 0L;
      if (paramMap.containsKey(".sysmsg.newtips.control.tips_id")) {
        l3 = Util.getLong((String)paramMap.get(".sysmsg.newtips.control.tips_id"), 0L);
      }
      k = 0;
      if (paramMap.containsKey(".sysmsg.newtips.control.unique_id")) {
        paramString = Util.nullAsNil((String)paramMap.get(".sysmsg.newtips.control.unique_id"));
      }
      if (paramMap.containsKey(".sysmsg.newtips.control.op")) {
        k = Util.getInt((String)paramMap.get(".sysmsg.newtips.control.op"), 0);
      }
      if (Util.isNullOrNil(paramString))
      {
        Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "checkNumValidUniqueIdAndOp() uniqueId is null");
        i = 0;
        if (i == 0) {
          break label588;
        }
        j = 0;
        if (paramMap.containsKey(".sysmsg.newtips.control.tips_type")) {
          j = Util.getInt((String)paramMap.get(".sysmsg.newtips.control.tips_type"), 0);
        }
        parama = com.tencent.mm.plugin.newtips.a.exn().aIE(paramString);
        Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "checkLogicValidOp() newTips type(%s) unique_id(%s) op(%s)", new Object[] { Integer.valueOf(j), paramString, Integer.valueOf(k) });
        if (parama.size() > 0) {
          break label372;
        }
        Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "checkLogicValidOp() uniqueId not exist in storage");
        if (k != 1) {
          break label366;
        }
        i = 0;
      }
      for (;;)
      {
        if (i != 0)
        {
          if (k != 1) {
            break label644;
          }
          localObject1 = parama.iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext())
            {
              ((c)((Iterator)localObject1).next()).field_state = 2;
              continue;
              Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "checkNumValidUniqueIdAndOp() uniqueId:%s op:%s", new Object[] { paramString, Integer.valueOf(k) });
              if ((k != 0) && (k != 1))
              {
                Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "checkNumValidUniqueIdAndOp() op:%s not exist in (0,1)", new Object[] { Integer.valueOf(k) });
                i = 0;
                break;
              }
              i = 1;
              break;
              i = 1;
              break label255;
              if (j == d.ACZ)
              {
                i = 0;
                break label255;
              }
              if (k == 1)
              {
                localObject1 = parama.iterator();
                do
                {
                  if (!((Iterator)localObject1).hasNext()) {
                    break;
                  }
                  localObject2 = (c)((Iterator)localObject1).next();
                } while ((((c)localObject2).field_state != 0) && (((c)localObject2).field_state != 1));
              }
            }
          }
        }
      }
    }
    label644:
    label1454:
    label1839:
    label2864:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        i = 1;
        break;
      }
      Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "checkLogicValidOp() unique_id(%s) exist(op:%s)", new Object[] { paramString, Integer.valueOf(k) });
      i = 0;
      break;
      localObject1 = this.ADO.entrySet().iterator();
      Object localObject3;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localObject3 = (a)((Map.Entry)localObject2).getValue();
        if ((localObject3 != null) && (((a)localObject3).a(l3, paramString, parama, paramMap))) {
          Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "[handleNewXml] key=%s, handleCallback=%s has cancel consume. tipsId=%s uniqueId=%s", new Object[] { ((Map.Entry)localObject2).getKey(), localObject3, Long.valueOf(l3), paramString });
        }
      }
      for (;;)
      {
        label588:
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(127258);
            Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "consumeNewXml() batch delete expire data!!");
            com.tencent.mm.plugin.newtips.a.exn().Hw(cl.aWy() / 1000L);
            AppMethodBeat.o(127258);
          }
        }, 30000L);
        label602:
        AppMethodBeat.o(127260);
        return null;
        Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "handleNewXml() update localNewTips state to NEW_TIPS_STATE_CANCEL. ret: %s", new Object[] { Integer.valueOf(com.tencent.mm.plugin.newtips.a.exn().fI(parama)) });
        com.tencent.mm.plugin.newtips.a.exl();
        i.fH(parama);
      }
      int i4 = (int)l3;
      localObject2 = new ArrayList();
      if (paramMap.containsKey(".sysmsg.newtips.tips_showInfo_list.size")) {}
      label1335:
      label2617:
      label2634:
      for (i = Util.getInt((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.size"), 0);; i = 0)
      {
        if (i == 0) {
          Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() tipsCount == 0");
        }
        boolean bool;
        label720:
        int m;
        int n;
        long l1;
        long l4;
        long l5;
        int i1;
        do
        {
          i = (int)l3;
          f.exq();
          parama = f.Tz(i);
          if (parama != null) {
            break label2306;
          }
          bool = true;
          if (!bool) {
            break label2381;
          }
          parama = this.ADO.entrySet().iterator();
          do
          {
            if (!parama.hasNext()) {
              break;
            }
            localObject1 = (Map.Entry)parama.next();
            localObject3 = (a)((Map.Entry)localObject1).getValue();
          } while ((localObject3 == null) || (!((a)localObject3).b(l3, paramString, (List)localObject2, paramMap)));
          Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "[handleNewXml] key=%s, handleCallback=%s has add consume. tipsId=%s uniqueId=%s", new Object[] { ((Map.Entry)localObject1).getKey(), localObject3, Long.valueOf(l3), paramString });
          break;
          k = 0;
          m = 0;
          if (paramMap.containsKey(".sysmsg.newtips.control.android_min_clientversion")) {
            k = Util.getInt((String)paramMap.get(".sysmsg.newtips.control.android_min_clientversion"), 0);
          }
          if (paramMap.containsKey(".sysmsg.newtips.control.android_max_clientversion")) {
            m = Util.getInt((String)paramMap.get(".sysmsg.newtips.control.android_max_clientversion"), 2147483647);
          }
          n = 0;
          l1 = 0L;
          l4 = 0L;
          long l2 = 0L;
          parama = "";
          if (paramMap.containsKey(".sysmsg.newtips.control.priority")) {
            n = Util.getInt((String)paramMap.get(".sysmsg.newtips.control.priority"), 0);
          }
          if (paramMap.containsKey(".sysmsg.newtips.control.begin_time")) {
            l1 = Util.getLong((String)paramMap.get(".sysmsg.newtips.control.begin_time"), 0L);
          }
          if (paramMap.containsKey(".sysmsg.newtips.control.overdue_time")) {
            l4 = Util.getLong((String)paramMap.get(".sysmsg.newtips.control.overdue_time"), 0L);
          }
          if (paramMap.containsKey(".sysmsg.newtips.control.disappear_time")) {
            l2 = Util.getLong((String)paramMap.get(".sysmsg.newtips.control.disappear_time"), 0L);
          }
          if (paramMap.containsKey(".sysmsg.newtips.ext_info")) {
            parama = Util.nullAsNil((String)paramMap.get(".sysmsg.newtips.ext_info")).trim();
          }
          l5 = l1;
          if (l1 == 0L)
          {
            l5 = cl.aWy() / 1000L;
            Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s) => beginShowTime==0", new Object[] { paramString });
          }
          l1 = l2;
          if (l2 == 0L)
          {
            l1 = l2;
            if (l4 == 0L)
            {
              l1 = l5 + duN.longValue();
              Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s) => disappearTime==0", new Object[] { paramString });
            }
          }
          i1 = 0;
        } while (i1 >= i);
        localObject3 = new c(paramString, i4, n, j, l5, l4, l1, k, m, parama);
        if (i1 == 0)
        {
          ((c)localObject3).field_showType = Util.getInt((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.show_type"), 0);
          ((c)localObject3).field_title = Util.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.title")).trim();
          ((c)localObject3).field_icon_url = Util.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.icon_url")).trim();
          localObject1 = Util.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.path")).trim();
          i2 = g.aIB((String)localObject1);
          if (i2 == 0)
          {
            ((c)localObject3).field_dynamicPath = ((String)localObject1);
            if (!paramMap.containsKey(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.parents.size")) {
              break label2991;
            }
          }
        }
        label2381:
        label2392:
        label2915:
        for (int i2 = Util.getInt((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.parents.size"), 0);; i2 = 0)
        {
          ehy localehy;
          int i3;
          if (i2 != 0)
          {
            localehy = new ehy();
            i3 = 0;
            if (i3 < i2)
            {
              if (i3 == 0) {}
              for (localObject1 = Util.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.parents.parent")).trim();; localObject1 = Util.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.parents.parent".concat(String.valueOf(i3)))).trim())
              {
                if (!Util.isNullOrNil((String)localObject1)) {
                  localehy.gCs.add(localObject1);
                }
                i3 += 1;
                break label1335;
                ((c)localObject3).field_path = i2;
                break;
              }
            }
            if (localehy.gCs.size() > 0) {
              ((c)localObject3).field_parents = localehy;
            }
          }
          localObject1 = k.TE(((c)localObject3).field_showType);
          label2790:
          label2796:
          switch (2.ADy[localObject1.ordinal()])
          {
          case 1: 
          case 2: 
          case 3: 
          case 4: 
          default: 
            ((List)localObject2).add(localObject3);
            Log.d("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() i:%s newTipsInfo:%s", new Object[] { Integer.valueOf(i1), localObject3 });
            i1 += 1;
            break;
            ((c)localObject3).field_showType = Util.getInt((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".show_type"), 0);
            ((c)localObject3).field_title = Util.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".title")).trim();
            ((c)localObject3).field_icon_url = Util.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".icon_url")).trim();
            localObject1 = Util.nullAsNil(((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".path")).trim());
            i2 = g.aIB((String)localObject1);
            if (i2 == 0)
            {
              ((c)localObject3).field_dynamicPath = ((String)localObject1);
              if (!paramMap.containsKey(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".parents.size")) {
                break label2985;
              }
            }
          case 5: 
          case 6: 
          case 7: 
            label1516:
            for (i2 = Util.getInt((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".parents.size"), 0);; i2 = 0)
            {
              if (i2 == 0) {
                break label1454;
              }
              localehy = new ehy();
              i3 = 0;
              if (i3 < i2)
              {
                if (i3 == 0) {}
                for (localObject1 = Util.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".parents.parent")).trim();; localObject1 = Util.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".parents.parent" + i3)).trim())
                {
                  if (!Util.isNullOrNil((String)localObject1)) {
                    localehy.gCs.add(localObject1);
                  }
                  i3 += 1;
                  break label1839;
                  ((c)localObject3).field_path = i2;
                  break;
                }
              }
              if (localehy.gCs.size() <= 0) {
                break label1454;
              }
              ((c)localObject3).field_parents = localehy;
              break label1454;
              if (!Util.isNullOrNil(((c)localObject3).field_title)) {
                break label1516;
              }
              ((c)localObject3).field_showType = 0;
              Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s path:%s showType:%s) => field_title==null", new Object[] { ((c)localObject3).field_uniqueId, Integer.valueOf(((c)localObject3).field_path), ((k)localObject1).toString() });
              break label1516;
              if (!Util.isNullOrNil(((c)localObject3).field_icon_url)) {
                break label1516;
              }
              ((c)localObject3).field_showType = 0;
              Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s path:%s showType:%s) => field_icon_url==null", new Object[] { ((c)localObject3).field_uniqueId, Integer.valueOf(((c)localObject3).field_path), ((k)localObject1).toString() });
              break label1516;
              if ((Util.isNullOrNil(((c)localObject3).field_title)) && (Util.isNullOrNil(((c)localObject3).field_icon_url)))
              {
                ((c)localObject3).field_showType = 0;
                Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s path:%s showType:%s) => field_title==null && field_icon_url==null", new Object[] { ((c)localObject3).field_uniqueId, Integer.valueOf(((c)localObject3).field_path), ((k)localObject1).toString() });
                break label1516;
              }
              if (Util.isNullOrNil(((c)localObject3).field_title))
              {
                ((c)localObject3).field_showType = 3;
                Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s path:%s showType:%s) => field_title==null", new Object[] { ((c)localObject3).field_uniqueId, Integer.valueOf(((c)localObject3).field_path), ((k)localObject1).toString() });
                break label1516;
              }
              if (!Util.isNullOrNil(((c)localObject3).field_icon_url)) {
                break label1516;
              }
              ((c)localObject3).field_showType = 2;
              Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s path:%s showType:%s) => field_icon_url==null", new Object[] { ((c)localObject3).field_uniqueId, Integer.valueOf(((c)localObject3).field_path), ((k)localObject1).toString() });
              break label1516;
              bool = parama.exr();
              break label720;
              i = com.tencent.mm.plugin.newtips.a.exn().bb((List)localObject2);
              paramMap = new ny();
              paramMap.dUa.dUb = paramString;
              EventCenter.instance.publish(paramMap);
              Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "handleNewXml() insert ret:%s", new Object[] { Integer.valueOf(i) });
              com.tencent.mm.plugin.newtips.a.exl();
              i.fH((List)localObject2);
              break;
              Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "handleNewXml() no insert");
              break;
              com.tencent.mm.plugin.newtips.a.exl();
              localObject1 = i.as(paramMap);
              if (localObject1 == null) {
                break label602;
              }
              if (localObject1 == null)
              {
                Log.e("MicroMsg.NewTips.NewTipsXMLConsumer", "reportNewTips, newTipsInfo is null !!");
                paramString = com.tencent.mm.plugin.newtips.a.exl().ADB;
                if (paramString == null) {
                  break label602;
                }
                com.tencent.mm.plugin.newtips.a.exo();
                if (!e.d((com.tencent.mm.plugin.newtips.b.a)localObject1)) {
                  break label602;
                }
                Log.d("dancy", "dancy consumeNewXml notifyShowNewTips isExit: %s, begintime: %s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.newtips.b.a)localObject1).field_isExit), Long.valueOf(((com.tencent.mm.plugin.newtips.b.a)localObject1).field_beginShowTime) });
                paramString.e((com.tencent.mm.plugin.newtips.b.a)localObject1);
                break label602;
              }
              k = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipId;
              m = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipVersion;
              n = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipType;
              l1 = Util.nowMilliSecond();
              MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_newtips_report", 0).edit().putLong("newtips_gettipstime", l1).commit();
              if (((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo != null)
              {
                j = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo.dDG;
                if (((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo == null) {
                  break label2790;
                }
                paramString = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo.title;
                if (((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo == null) {
                  break label2796;
                }
                paramMap = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo.qGB;
                if (((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo == null) {
                  break label2802;
                }
                parama = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo.path;
                com.tencent.mm.plugin.newtips.a.exo();
                if (localObject1 != null) {
                  break label2808;
                }
                i = 1;
              }
              label2929:
              for (;;)
              {
                com.tencent.mm.plugin.report.service.h.CyF.a(14995, new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Long.valueOf(l1), "", "", "", "", "", "", "", Integer.valueOf(j), paramString, paramMap, parama, Integer.valueOf(i), Integer.valueOf(d.ADo), "" });
                break;
                j = 0;
                break label2583;
                paramString = "";
                break label2600;
                paramMap = "";
                break label2617;
                label2802:
                parama = "";
                break label2634;
                label2808:
                if (!e.b((com.tencent.mm.plugin.newtips.b.a)localObject1))
                {
                  i = 2;
                }
                else if (!e.c((com.tencent.mm.plugin.newtips.b.a)localObject1))
                {
                  i = 3;
                }
                else if (!e.a((com.tencent.mm.plugin.newtips.b.a)localObject1))
                {
                  i = 4;
                }
                else
                {
                  if (localObject1 == null) {
                    Log.e("MicroMsg.NewTipsManager", "check type, tipsInfo is null!!!");
                  }
                  for (i = 0;; i = 1)
                  {
                    if (i != 0) {
                      break label2915;
                    }
                    i = 5;
                    break;
                    localObject2 = com.tencent.mm.plugin.newtips.a.exm().TF(((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipId);
                    if ((localObject2 == null) || (((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipType != ((com.tencent.mm.plugin.newtips.b.a)localObject2).field_tipType)) {
                      break label2864;
                    }
                  }
                  if (localObject1 == null) {
                    Log.e("MicroMsg.NewTipsManager", "check local info, newTipsInfo is null !!");
                  }
                  for (i = 0;; i = 1)
                  {
                    if (i != 0) {
                      break label2964;
                    }
                    i = 6;
                    break;
                    if (com.tencent.mm.plugin.newtips.a.exm().TF(((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipId) == null) {
                      break label2929;
                    }
                  }
                  if (((com.tencent.mm.plugin.newtips.b.a)localObject1).field_isReject) {
                    i = 7;
                  } else {
                    i = 0;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void a(String paramString, a parama)
  {
    AppMethodBeat.i(188567);
    this.ADO.put(paramString, parama);
    AppMethodBeat.o(188567);
  }
  
  public static abstract interface a
  {
    public abstract boolean a(long paramLong, String paramString, List<c> paramList, Map<String, String> paramMap);
    
    public abstract boolean b(long paramLong, String paramString, List<c> paramList, Map<String, String> paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.l
 * JD-Core Version:    0.7.0.1
 */