package com.tencent.mm.plugin.newtips.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.newtips.b.b;
import com.tencent.mm.plugin.newtips.b.c;
import com.tencent.mm.protocal.protobuf.dhp;
import com.tencent.mm.protocal.protobuf.dhq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class l
  implements o
{
  private static final Long cRz;
  private ConcurrentHashMap<String, a> vnB;
  
  static
  {
    AppMethodBeat.i(127261);
    cRz = Long.valueOf(604800L);
    AppMethodBeat.o(127261);
  }
  
  public l()
  {
    AppMethodBeat.i(204971);
    this.vnB = new ConcurrentHashMap();
    AppMethodBeat.o(204971);
  }
  
  public final f.b a(String paramString, Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(127260);
    ac.d("MicroMsg.NewTips.NewTipsXMLConsumer", "dancy consumeNewXml， subType:%s", new Object[] { paramString });
    if ((bs.nullAsNil(paramString).equals("newtips")) && (paramMap != null))
    {
      if (paramMap.get(".sysmsg.newtips.tips_showInfo_list") == null) {
        break label2388;
      }
      paramString = "";
      if (!paramMap.containsKey(".sysmsg.newtips.control.tips_id")) {
        break label3005;
      }
    }
    label640:
    label1331:
    label2613:
    label3005:
    for (long l3 = bs.getLong((String)paramMap.get(".sysmsg.newtips.control.tips_id"), 0L);; l3 = 0L)
    {
      int k = 0;
      if (paramMap.containsKey(".sysmsg.newtips.control.unique_id")) {
        paramString = bs.nullAsNil((String)paramMap.get(".sysmsg.newtips.control.unique_id"));
      }
      if (paramMap.containsKey(".sysmsg.newtips.control.op")) {
        k = bs.getInt((String)paramMap.get(".sysmsg.newtips.control.op"), 0);
      }
      int j;
      if (bs.isNullOrNil(paramString))
      {
        ac.i("MicroMsg.NewTips.NewTipsXMLConsumer", "checkNumValidUniqueIdAndOp() uniqueId is null");
        i = 0;
        if (i == 0) {
          break label584;
        }
        j = 0;
        if (paramMap.containsKey(".sysmsg.newtips.control.tips_type")) {
          j = bs.getInt((String)paramMap.get(".sysmsg.newtips.control.tips_type"), 0);
        }
        parama = com.tencent.mm.plugin.newtips.a.dkd().aoj(paramString);
        ac.i("MicroMsg.NewTips.NewTipsXMLConsumer", "checkLogicValidOp() newTips type(%s) unique_id(%s) op(%s)", new Object[] { Integer.valueOf(j), paramString, Integer.valueOf(k) });
        if (parama.size() > 0) {
          break label369;
        }
        ac.i("MicroMsg.NewTips.NewTipsXMLConsumer", "checkLogicValidOp() uniqueId not exist in storage");
        if (k != 1) {
          break label363;
        }
        i = 0;
      }
      label252:
      Object localObject1;
      label363:
      label369:
      Object localObject2;
      for (;;)
      {
        if (i != 0)
        {
          if (k != 1) {
            break label640;
          }
          localObject1 = parama.iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext())
            {
              ((c)((Iterator)localObject1).next()).field_state = 2;
              continue;
              ac.i("MicroMsg.NewTips.NewTipsXMLConsumer", "checkNumValidUniqueIdAndOp() uniqueId:%s op:%s", new Object[] { paramString, Integer.valueOf(k) });
              if ((k != 0) && (k != 1))
              {
                ac.i("MicroMsg.NewTips.NewTipsXMLConsumer", "checkNumValidUniqueIdAndOp() op:%s not exist in (0,1)", new Object[] { Integer.valueOf(k) });
                i = 0;
                break;
              }
              i = 1;
              break;
              i = 1;
              break label252;
              if (j == d.vmO)
              {
                i = 0;
                break label252;
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
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          i = 1;
          break;
        }
        ac.i("MicroMsg.NewTips.NewTipsXMLConsumer", "checkLogicValidOp() unique_id(%s) exist(op:%s)", new Object[] { paramString, Integer.valueOf(k) });
        i = 0;
        break;
        localObject1 = this.vnB.entrySet().iterator();
        Object localObject3;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          localObject3 = (a)((Map.Entry)localObject2).getValue();
          if ((localObject3 != null) && (((a)localObject3).a(l3, parama, paramMap))) {
            ac.i("MicroMsg.NewTips.NewTipsXMLConsumer", "[handleNewXml] key=%s, handleCallback=%s has cancel consume. tipsId=%s uniqueId=%s", new Object[] { ((Map.Entry)localObject2).getKey(), localObject3, Long.valueOf(l3), paramString });
          }
        }
        for (;;)
        {
          label584:
          ap.n(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(127258);
              ac.i("MicroMsg.NewTips.NewTipsXMLConsumer", "consumeNewXml() batch delete expire data!!");
              com.tencent.mm.plugin.newtips.a.dkd().wd(ce.azH() / 1000L);
              AppMethodBeat.o(127258);
            }
          }, 30000L);
          label598:
          AppMethodBeat.o(127260);
          return null;
          ac.i("MicroMsg.NewTips.NewTipsXMLConsumer", "handleNewXml() update localNewTips state to NEW_TIPS_STATE_CANCEL. ret: %s", new Object[] { Integer.valueOf(com.tencent.mm.plugin.newtips.a.dkd().eq(parama)) });
          com.tencent.mm.plugin.newtips.a.dkb();
          i.ep(parama);
        }
        int i4 = (int)l3;
        localObject2 = new ArrayList();
        if (paramMap.containsKey(".sysmsg.newtips.tips_showInfo_list.size")) {}
        label2630:
        for (i = bs.getInt((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.size"), 0);; i = 0)
        {
          if (i == 0) {
            ac.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() tipsCount == 0");
          }
          boolean bool;
          label716:
          int m;
          int n;
          long l1;
          long l4;
          long l5;
          int i1;
          do
          {
            i = (int)l3;
            f.dkg();
            parama = f.Kl(i);
            if (parama != null) {
              break label2302;
            }
            bool = true;
            if (!bool) {
              break label2377;
            }
            parama = this.vnB.entrySet().iterator();
            do
            {
              if (!parama.hasNext()) {
                break;
              }
              localObject1 = (Map.Entry)parama.next();
              localObject3 = (a)((Map.Entry)localObject1).getValue();
            } while ((localObject3 == null) || (!((a)localObject3).a(l3, paramString, (List)localObject2, paramMap)));
            ac.i("MicroMsg.NewTips.NewTipsXMLConsumer", "[handleNewXml] key=%s, handleCallback=%s has add consume. tipsId=%s uniqueId=%s", new Object[] { ((Map.Entry)localObject1).getKey(), localObject3, Long.valueOf(l3), paramString });
            break;
            k = 0;
            m = 0;
            if (paramMap.containsKey(".sysmsg.newtips.control.android_min_clientversion")) {
              k = bs.getInt((String)paramMap.get(".sysmsg.newtips.control.android_min_clientversion"), 0);
            }
            if (paramMap.containsKey(".sysmsg.newtips.control.android_max_clientversion")) {
              m = bs.getInt((String)paramMap.get(".sysmsg.newtips.control.android_max_clientversion"), 2147483647);
            }
            n = 0;
            l1 = 0L;
            l4 = 0L;
            long l2 = 0L;
            parama = "";
            if (paramMap.containsKey(".sysmsg.newtips.control.priority")) {
              n = bs.getInt((String)paramMap.get(".sysmsg.newtips.control.priority"), 0);
            }
            if (paramMap.containsKey(".sysmsg.newtips.control.begin_time")) {
              l1 = bs.getLong((String)paramMap.get(".sysmsg.newtips.control.begin_time"), 0L);
            }
            if (paramMap.containsKey(".sysmsg.newtips.control.overdue_time")) {
              l4 = bs.getLong((String)paramMap.get(".sysmsg.newtips.control.overdue_time"), 0L);
            }
            if (paramMap.containsKey(".sysmsg.newtips.control.disappear_time")) {
              l2 = bs.getLong((String)paramMap.get(".sysmsg.newtips.control.disappear_time"), 0L);
            }
            if (paramMap.containsKey(".sysmsg.newtips.ext_info")) {
              parama = bs.nullAsNil((String)paramMap.get(".sysmsg.newtips.ext_info")).trim();
            }
            l5 = l1;
            if (l1 == 0L)
            {
              l5 = ce.azH() / 1000L;
              ac.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s) => beginShowTime==0", new Object[] { paramString });
            }
            l1 = l2;
            if (l2 == 0L)
            {
              l1 = l2;
              if (l4 == 0L)
              {
                l1 = l5 + cRz.longValue();
                ac.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s) => disappearTime==0", new Object[] { paramString });
              }
            }
            i1 = 0;
          } while (i1 >= i);
          localObject3 = new c(paramString, i4, n, j, l5, l4, l1, k, m, parama);
          if (i1 == 0)
          {
            ((c)localObject3).field_showType = bs.getInt((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.show_type"), 0);
            ((c)localObject3).field_title = bs.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.title")).trim();
            ((c)localObject3).field_icon_url = bs.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.icon_url")).trim();
            localObject1 = bs.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.path")).trim();
            i2 = g.aog((String)localObject1);
            if (i2 == 0)
            {
              ((c)localObject3).field_dynamicPath = ((String)localObject1);
              if (!paramMap.containsKey(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.parents.size")) {
                break label2987;
              }
            }
          }
          label2377:
          label2388:
          label2911:
          for (int i2 = bs.getInt((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.parents.size"), 0);; i2 = 0)
          {
            dhq localdhq;
            int i3;
            if (i2 != 0)
            {
              localdhq = new dhq();
              i3 = 0;
              if (i3 < i2)
              {
                if (i3 == 0) {}
                for (localObject1 = bs.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.parents.parent")).trim();; localObject1 = bs.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.parents.parent".concat(String.valueOf(i3)))).trim())
                {
                  if (!bs.isNullOrNil((String)localObject1)) {
                    localdhq.fBS.add(localObject1);
                  }
                  i3 += 1;
                  break label1331;
                  ((c)localObject3).field_path = i2;
                  break;
                }
              }
              if (localdhq.fBS.size() > 0) {
                ((c)localObject3).field_parents = localdhq;
              }
            }
            localObject1 = k.Kq(((c)localObject3).field_showType);
            label2786:
            label2792:
            switch (2.vnn[localObject1.ordinal()])
            {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            default: 
              ((List)localObject2).add(localObject3);
              ac.d("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() i:%s newTipsInfo:%s", new Object[] { Integer.valueOf(i1), localObject3 });
              i1 += 1;
              break;
              ((c)localObject3).field_showType = bs.getInt((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".show_type"), 0);
              ((c)localObject3).field_title = bs.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".title")).trim();
              ((c)localObject3).field_icon_url = bs.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".icon_url")).trim();
              localObject1 = bs.nullAsNil(((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".path")).trim());
              i2 = g.aog((String)localObject1);
              if (i2 == 0)
              {
                ((c)localObject3).field_dynamicPath = ((String)localObject1);
                if (!paramMap.containsKey(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".parents.size")) {
                  break label2981;
                }
              }
            case 5: 
            case 6: 
            case 7: 
              label1512:
              for (i2 = bs.getInt((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".parents.size"), 0);; i2 = 0)
              {
                if (i2 == 0) {
                  break label1450;
                }
                localdhq = new dhq();
                i3 = 0;
                if (i3 < i2)
                {
                  if (i3 == 0) {}
                  for (localObject1 = bs.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".parents.parent")).trim();; localObject1 = bs.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".parents.parent" + i3)).trim())
                  {
                    if (!bs.isNullOrNil((String)localObject1)) {
                      localdhq.fBS.add(localObject1);
                    }
                    i3 += 1;
                    break label1835;
                    ((c)localObject3).field_path = i2;
                    break;
                  }
                }
                if (localdhq.fBS.size() <= 0) {
                  break label1450;
                }
                ((c)localObject3).field_parents = localdhq;
                break label1450;
                if (!bs.isNullOrNil(((c)localObject3).field_title)) {
                  break label1512;
                }
                ((c)localObject3).field_showType = 0;
                ac.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s path:%s showType:%s) => field_title==null", new Object[] { ((c)localObject3).field_uniqueId, Integer.valueOf(((c)localObject3).field_path), ((k)localObject1).toString() });
                break label1512;
                if (!bs.isNullOrNil(((c)localObject3).field_icon_url)) {
                  break label1512;
                }
                ((c)localObject3).field_showType = 0;
                ac.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s path:%s showType:%s) => field_icon_url==null", new Object[] { ((c)localObject3).field_uniqueId, Integer.valueOf(((c)localObject3).field_path), ((k)localObject1).toString() });
                break label1512;
                if ((bs.isNullOrNil(((c)localObject3).field_title)) && (bs.isNullOrNil(((c)localObject3).field_icon_url)))
                {
                  ((c)localObject3).field_showType = 0;
                  ac.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s path:%s showType:%s) => field_title==null && field_icon_url==null", new Object[] { ((c)localObject3).field_uniqueId, Integer.valueOf(((c)localObject3).field_path), ((k)localObject1).toString() });
                  break label1512;
                }
                if (bs.isNullOrNil(((c)localObject3).field_title))
                {
                  ((c)localObject3).field_showType = 3;
                  ac.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s path:%s showType:%s) => field_title==null", new Object[] { ((c)localObject3).field_uniqueId, Integer.valueOf(((c)localObject3).field_path), ((k)localObject1).toString() });
                  break label1512;
                }
                if (!bs.isNullOrNil(((c)localObject3).field_icon_url)) {
                  break label1512;
                }
                ((c)localObject3).field_showType = 2;
                ac.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s path:%s showType:%s) => field_icon_url==null", new Object[] { ((c)localObject3).field_uniqueId, Integer.valueOf(((c)localObject3).field_path), ((k)localObject1).toString() });
                break label1512;
                label2302:
                bool = parama.dkh();
                break label716;
                i = com.tencent.mm.plugin.newtips.a.dkd().er((List)localObject2);
                paramMap = new mx();
                paramMap.dps.dpt = paramString;
                com.tencent.mm.sdk.b.a.GpY.l(paramMap);
                ac.i("MicroMsg.NewTips.NewTipsXMLConsumer", "handleNewXml() insert ret:%s", new Object[] { Integer.valueOf(i) });
                com.tencent.mm.plugin.newtips.a.dkb();
                i.ep((List)localObject2);
                break;
                ac.i("MicroMsg.NewTips.NewTipsXMLConsumer", "handleNewXml() no insert");
                break;
                com.tencent.mm.plugin.newtips.a.dkb();
                localObject1 = i.ah(paramMap);
                if (localObject1 == null) {
                  break label598;
                }
                if (localObject1 == null)
                {
                  ac.e("MicroMsg.NewTips.NewTipsXMLConsumer", "reportNewTips, newTipsInfo is null !!");
                  paramString = com.tencent.mm.plugin.newtips.a.dkb().vnq;
                  if (paramString == null) {
                    break label598;
                  }
                  com.tencent.mm.plugin.newtips.a.dke();
                  if (!e.d((com.tencent.mm.plugin.newtips.b.a)localObject1)) {
                    break label598;
                  }
                  ac.d("dancy", "dancy consumeNewXml notifyShowNewTips isExit: %s, begintime: %s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.newtips.b.a)localObject1).field_isExit), Long.valueOf(((com.tencent.mm.plugin.newtips.b.a)localObject1).field_beginShowTime) });
                  paramString.e((com.tencent.mm.plugin.newtips.b.a)localObject1);
                  break label598;
                }
                k = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipId;
                m = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipVersion;
                n = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipType;
                l1 = bs.eWj();
                ai.getContext().getSharedPreferences(ai.eUX() + "_newtips_report", 0).edit().putLong("newtips_gettipstime", l1).commit();
                if (((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo != null)
                {
                  j = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo.cZX;
                  if (((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo == null) {
                    break label2786;
                  }
                  paramString = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo.title;
                  if (((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo == null) {
                    break label2792;
                  }
                  paramMap = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo.oGN;
                  if (((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo == null) {
                    break label2798;
                  }
                  parama = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo.path;
                  com.tencent.mm.plugin.newtips.a.dke();
                  if (localObject1 != null) {
                    break label2804;
                  }
                  i = 1;
                }
                label2925:
                for (;;)
                {
                  com.tencent.mm.plugin.report.service.h.wUl.f(14995, new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Long.valueOf(l1), "", "", "", "", "", "", "", Integer.valueOf(j), paramString, paramMap, parama, Integer.valueOf(i), Integer.valueOf(d.vnd), "" });
                  break;
                  j = 0;
                  break label2579;
                  paramString = "";
                  break label2596;
                  paramMap = "";
                  break label2613;
                  label2798:
                  parama = "";
                  break label2630;
                  label2804:
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
                      ac.e("MicroMsg.NewTipsManager", "check type, tipsInfo is null!!!");
                    }
                    for (i = 0;; i = 1)
                    {
                      if (i != 0) {
                        break label2911;
                      }
                      i = 5;
                      break;
                      localObject2 = com.tencent.mm.plugin.newtips.a.dkc().Kr(((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipId);
                      if ((localObject2 == null) || (((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipType != ((com.tencent.mm.plugin.newtips.b.a)localObject2).field_tipType)) {
                        break label2860;
                      }
                    }
                    if (localObject1 == null) {
                      ac.e("MicroMsg.NewTipsManager", "check local info, newTipsInfo is null !!");
                    }
                    for (i = 0;; i = 1)
                    {
                      if (i != 0) {
                        break label2960;
                      }
                      i = 6;
                      break;
                      if (com.tencent.mm.plugin.newtips.a.dkc().Kr(((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipId) == null) {
                        break label2925;
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
  }
  
  public final void a(String paramString, a parama)
  {
    AppMethodBeat.i(204972);
    this.vnB.put(paramString, parama);
    AppMethodBeat.o(204972);
  }
  
  public static abstract interface a
  {
    public abstract boolean a(long paramLong, String paramString, List<c> paramList, Map<String, String> paramMap);
    
    public abstract boolean a(long paramLong, List<c> paramList, Map<String, String> paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.l
 * JD-Core Version:    0.7.0.1
 */