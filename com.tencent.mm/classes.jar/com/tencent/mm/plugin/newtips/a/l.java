package com.tencent.mm.plugin.newtips.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.g.a.nf;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.newtips.b.b;
import com.tencent.mm.plugin.newtips.b.c;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.protocal.protobuf.dnf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
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
  private static final Long dcP;
  private ConcurrentHashMap<String, a> wsT;
  
  static
  {
    AppMethodBeat.i(127261);
    dcP = Long.valueOf(604800L);
    AppMethodBeat.o(127261);
  }
  
  public l()
  {
    AppMethodBeat.i(214429);
    this.wsT = new ConcurrentHashMap();
    AppMethodBeat.o(214429);
  }
  
  private static boolean a(List<c> paramList, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(214431);
    ad.i("MicroMsg.NewTips.NewTipsXMLConsumer", "checkLogicValidOp() newTips type(%s) unique_id(%s) op(%s)", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
    if ((paramList == null) || (paramList.size() <= 0))
    {
      ad.i("MicroMsg.NewTips.NewTipsXMLConsumer", "checkLogicValidOp() uniqueId not exist in storage");
      if (paramInt2 == 1)
      {
        AppMethodBeat.o(214431);
        return false;
      }
      AppMethodBeat.o(214431);
      return true;
    }
    if (paramInt1 == d.wsg)
    {
      AppMethodBeat.o(214431);
      return false;
    }
    if (paramInt2 == 1)
    {
      paramList = paramList.iterator();
      c localc;
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
        localc = (c)paramList.next();
      } while ((localc.field_state != 0) && (localc.field_state != 1));
    }
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0)
      {
        AppMethodBeat.o(214431);
        return true;
      }
      ad.i("MicroMsg.NewTips.NewTipsXMLConsumer", "checkLogicValidOp() unique_id(%s) exist(op:%s)", new Object[] { paramString, Integer.valueOf(paramInt2) });
      AppMethodBeat.o(214431);
      return false;
    }
  }
  
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(127260);
    ad.d("MicroMsg.NewTips.NewTipsXMLConsumer", "dancy consumeNewXml， subType:%s", new Object[] { paramString });
    long l3;
    if ((bt.nullAsNil(paramString).equals("newtips")) && (paramMap != null))
    {
      if (paramMap.get(".sysmsg.newtips.tips_showInfo_list") == null) {
        break label2240;
      }
      paramString = "";
      l3 = 0L;
      if (paramMap.containsKey(".sysmsg.newtips.control.tips_id")) {
        l3 = bt.getLong((String)paramMap.get(".sysmsg.newtips.control.tips_id"), 0L);
      }
      if (paramMap.containsKey(".sysmsg.newtips.control.unique_id")) {
        paramString = bt.nullAsNil((String)paramMap.get(".sysmsg.newtips.control.unique_id"));
      }
      if (!paramMap.containsKey(".sysmsg.newtips.control.op")) {
        break label2851;
      }
    }
    label1183:
    label2465:
    label2851:
    for (int j = bt.getInt((String)paramMap.get(".sysmsg.newtips.control.op"), 0);; j = 0)
    {
      int i;
      if (bt.isNullOrNil(paramString))
      {
        ad.i("MicroMsg.NewTips.NewTipsXMLConsumer", "checkNumValidUniqueIdAndOp() uniqueId is null");
        i = 0;
      }
      Object localObject1;
      Object localObject3;
      while (i != 0)
      {
        i = 0;
        if (paramMap.containsKey(".sysmsg.newtips.control.tips_type")) {
          i = bt.getInt((String)paramMap.get(".sysmsg.newtips.control.tips_type"), 0);
        }
        parama = com.tencent.mm.plugin.newtips.a.dup().ati(paramString);
        if (j != 1) {
          break label476;
        }
        localObject1 = parama.iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            ((c)((Iterator)localObject1).next()).field_state = 2;
            continue;
            ad.i("MicroMsg.NewTips.NewTipsXMLConsumer", "checkNumValidUniqueIdAndOp() uniqueId:%s op:%s", new Object[] { paramString, Integer.valueOf(j) });
            if ((j != 0) && (j != 1))
            {
              ad.i("MicroMsg.NewTips.NewTipsXMLConsumer", "checkNumValidUniqueIdAndOp() op:%s not exist in (0,1)", new Object[] { Integer.valueOf(j) });
              i = 0;
              break;
            }
            i = 1;
            break;
          }
        }
        localObject1 = this.wsT.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          localObject3 = (a)((Map.Entry)localObject2).getValue();
          if ((localObject3 != null) && (((a)localObject3).a(l3, paramString, parama, paramMap))) {
            ad.i("MicroMsg.NewTips.NewTipsXMLConsumer", "[handleNewXml] key=%s, handleCallback=%s has cancel consume. tipsId=%s uniqueId=%s", new Object[] { ((Map.Entry)localObject2).getKey(), localObject3, Long.valueOf(l3), paramString });
          }
        }
      }
      label422:
      label476:
      while (!a(parama, paramString, i, j)) {
        for (;;)
        {
          aq.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(127258);
              ad.i("MicroMsg.NewTips.NewTipsXMLConsumer", "consumeNewXml() batch delete expire data!!");
              com.tencent.mm.plugin.newtips.a.dup().ym(cf.aCK() / 1000L);
              AppMethodBeat.o(127258);
            }
          }, 30000L);
          AppMethodBeat.o(127260);
          return null;
          if (a(parama, paramString, i, j))
          {
            ad.i("MicroMsg.NewTips.NewTipsXMLConsumer", "handleNewXml() update localNewTips state to NEW_TIPS_STATE_CANCEL. ret: %s", new Object[] { Integer.valueOf(com.tencent.mm.plugin.newtips.a.dup().eD(parama)) });
            com.tencent.mm.plugin.newtips.a.dun();
            i.eC(parama);
          }
        }
      }
      int i4 = (int)l3;
      Object localObject2 = new ArrayList();
      if (paramMap.containsKey(".sysmsg.newtips.tips_showInfo_list.size")) {}
      label2482:
      for (j = bt.getInt((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.size"), 0);; j = 0)
      {
        if (j == 0) {
          ad.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() tipsCount == 0");
        }
        boolean bool;
        label564:
        int k;
        int m;
        int n;
        long l1;
        long l4;
        long l5;
        int i1;
        do
        {
          i = (int)l3;
          f.dus();
          parama = f.LN(i);
          if (parama != null) {
            break label2154;
          }
          bool = true;
          if (!bool) {
            break label2229;
          }
          parama = this.wsT.entrySet().iterator();
          do
          {
            if (!parama.hasNext()) {
              break;
            }
            localObject1 = (Map.Entry)parama.next();
            localObject3 = (a)((Map.Entry)localObject1).getValue();
          } while ((localObject3 == null) || (!((a)localObject3).b(l3, paramString, (List)localObject2, paramMap)));
          ad.i("MicroMsg.NewTips.NewTipsXMLConsumer", "[handleNewXml] key=%s, handleCallback=%s has add consume. tipsId=%s uniqueId=%s", new Object[] { ((Map.Entry)localObject1).getKey(), localObject3, Long.valueOf(l3), paramString });
          break;
          k = 0;
          m = 0;
          if (paramMap.containsKey(".sysmsg.newtips.control.android_min_clientversion")) {
            k = bt.getInt((String)paramMap.get(".sysmsg.newtips.control.android_min_clientversion"), 0);
          }
          if (paramMap.containsKey(".sysmsg.newtips.control.android_max_clientversion")) {
            m = bt.getInt((String)paramMap.get(".sysmsg.newtips.control.android_max_clientversion"), 2147483647);
          }
          n = 0;
          l1 = 0L;
          l4 = 0L;
          long l2 = 0L;
          parama = "";
          if (paramMap.containsKey(".sysmsg.newtips.control.priority")) {
            n = bt.getInt((String)paramMap.get(".sysmsg.newtips.control.priority"), 0);
          }
          if (paramMap.containsKey(".sysmsg.newtips.control.begin_time")) {
            l1 = bt.getLong((String)paramMap.get(".sysmsg.newtips.control.begin_time"), 0L);
          }
          if (paramMap.containsKey(".sysmsg.newtips.control.overdue_time")) {
            l4 = bt.getLong((String)paramMap.get(".sysmsg.newtips.control.overdue_time"), 0L);
          }
          if (paramMap.containsKey(".sysmsg.newtips.control.disappear_time")) {
            l2 = bt.getLong((String)paramMap.get(".sysmsg.newtips.control.disappear_time"), 0L);
          }
          if (paramMap.containsKey(".sysmsg.newtips.ext_info")) {
            parama = bt.nullAsNil((String)paramMap.get(".sysmsg.newtips.ext_info")).trim();
          }
          l5 = l1;
          if (l1 == 0L)
          {
            l5 = cf.aCK() / 1000L;
            ad.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s) => beginShowTime==0", new Object[] { paramString });
          }
          l1 = l2;
          if (l2 == 0L)
          {
            l1 = l2;
            if (l4 == 0L)
            {
              l1 = l5 + dcP.longValue();
              ad.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s) => disappearTime==0", new Object[] { paramString });
            }
          }
          i1 = 0;
        } while (i1 >= j);
        localObject3 = new c(paramString, i4, n, i, l5, l4, l1, k, m, parama);
        if (i1 == 0)
        {
          ((c)localObject3).field_showType = bt.getInt((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.show_type"), 0);
          ((c)localObject3).field_title = bt.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.title")).trim();
          ((c)localObject3).field_icon_url = bt.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.icon_url")).trim();
          localObject1 = bt.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.path")).trim();
          i2 = g.atf((String)localObject1);
          if (i2 == 0)
          {
            ((c)localObject3).field_dynamicPath = ((String)localObject1);
            if (!paramMap.containsKey(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.parents.size")) {
              break label2839;
            }
          }
        }
        label2229:
        label2240:
        label2763:
        for (int i2 = bt.getInt((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.parents.size"), 0);; i2 = 0)
        {
          dnf localdnf;
          int i3;
          if (i2 != 0)
          {
            localdnf = new dnf();
            i3 = 0;
            if (i3 < i2)
            {
              if (i3 == 0) {}
              for (localObject1 = bt.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.parents.parent")).trim();; localObject1 = bt.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.parents.parent".concat(String.valueOf(i3)))).trim())
              {
                if (!bt.isNullOrNil((String)localObject1)) {
                  localdnf.fVg.add(localObject1);
                }
                i3 += 1;
                break label1183;
                ((c)localObject3).field_path = i2;
                break;
              }
            }
            if (localdnf.fVg.size() > 0) {
              ((c)localObject3).field_parents = localdnf;
            }
          }
          localObject1 = k.LS(((c)localObject3).field_showType);
          label2638:
          label2644:
          switch (2.wsF[localObject1.ordinal()])
          {
          case 1: 
          case 2: 
          case 3: 
          case 4: 
          default: 
            ((List)localObject2).add(localObject3);
            ad.d("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() i:%s newTipsInfo:%s", new Object[] { Integer.valueOf(i1), localObject3 });
            i1 += 1;
            break;
            ((c)localObject3).field_showType = bt.getInt((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".show_type"), 0);
            ((c)localObject3).field_title = bt.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".title")).trim();
            ((c)localObject3).field_icon_url = bt.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".icon_url")).trim();
            localObject1 = bt.nullAsNil(((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".path")).trim());
            i2 = g.atf((String)localObject1);
            if (i2 == 0)
            {
              ((c)localObject3).field_dynamicPath = ((String)localObject1);
              if (!paramMap.containsKey(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".parents.size")) {
                break label2833;
              }
            }
          case 5: 
          case 6: 
          case 7: 
            label1364:
            for (i2 = bt.getInt((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".parents.size"), 0);; i2 = 0)
            {
              if (i2 == 0) {
                break label1302;
              }
              localdnf = new dnf();
              i3 = 0;
              if (i3 < i2)
              {
                if (i3 == 0) {}
                for (localObject1 = bt.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".parents.parent")).trim();; localObject1 = bt.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".parents.parent" + i3)).trim())
                {
                  if (!bt.isNullOrNil((String)localObject1)) {
                    localdnf.fVg.add(localObject1);
                  }
                  i3 += 1;
                  break label1687;
                  ((c)localObject3).field_path = i2;
                  break;
                }
              }
              if (localdnf.fVg.size() <= 0) {
                break label1302;
              }
              ((c)localObject3).field_parents = localdnf;
              break label1302;
              if (!bt.isNullOrNil(((c)localObject3).field_title)) {
                break label1364;
              }
              ((c)localObject3).field_showType = 0;
              ad.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s path:%s showType:%s) => field_title==null", new Object[] { ((c)localObject3).field_uniqueId, Integer.valueOf(((c)localObject3).field_path), ((k)localObject1).toString() });
              break label1364;
              if (!bt.isNullOrNil(((c)localObject3).field_icon_url)) {
                break label1364;
              }
              ((c)localObject3).field_showType = 0;
              ad.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s path:%s showType:%s) => field_icon_url==null", new Object[] { ((c)localObject3).field_uniqueId, Integer.valueOf(((c)localObject3).field_path), ((k)localObject1).toString() });
              break label1364;
              if ((bt.isNullOrNil(((c)localObject3).field_title)) && (bt.isNullOrNil(((c)localObject3).field_icon_url)))
              {
                ((c)localObject3).field_showType = 0;
                ad.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s path:%s showType:%s) => field_title==null && field_icon_url==null", new Object[] { ((c)localObject3).field_uniqueId, Integer.valueOf(((c)localObject3).field_path), ((k)localObject1).toString() });
                break label1364;
              }
              if (bt.isNullOrNil(((c)localObject3).field_title))
              {
                ((c)localObject3).field_showType = 3;
                ad.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s path:%s showType:%s) => field_title==null", new Object[] { ((c)localObject3).field_uniqueId, Integer.valueOf(((c)localObject3).field_path), ((k)localObject1).toString() });
                break label1364;
              }
              if (!bt.isNullOrNil(((c)localObject3).field_icon_url)) {
                break label1364;
              }
              ((c)localObject3).field_showType = 2;
              ad.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s path:%s showType:%s) => field_icon_url==null", new Object[] { ((c)localObject3).field_uniqueId, Integer.valueOf(((c)localObject3).field_path), ((k)localObject1).toString() });
              break label1364;
              label2154:
              bool = parama.dut();
              break label564;
              i = com.tencent.mm.plugin.newtips.a.dup().eE((List)localObject2);
              paramMap = new nf();
              paramMap.dBf.dBg = paramString;
              com.tencent.mm.sdk.b.a.IbL.l(paramMap);
              ad.i("MicroMsg.NewTips.NewTipsXMLConsumer", "handleNewXml() insert ret:%s", new Object[] { Integer.valueOf(i) });
              com.tencent.mm.plugin.newtips.a.dun();
              i.eC((List)localObject2);
              break;
              ad.i("MicroMsg.NewTips.NewTipsXMLConsumer", "handleNewXml() no insert");
              break;
              com.tencent.mm.plugin.newtips.a.dun();
              localObject1 = i.am(paramMap);
              if (localObject1 == null) {
                break label422;
              }
              if (localObject1 == null)
              {
                ad.e("MicroMsg.NewTips.NewTipsXMLConsumer", "reportNewTips, newTipsInfo is null !!");
                paramString = com.tencent.mm.plugin.newtips.a.dun().wsI;
                if (paramString == null) {
                  break label422;
                }
                com.tencent.mm.plugin.newtips.a.duq();
                if (!e.d((com.tencent.mm.plugin.newtips.b.a)localObject1)) {
                  break label422;
                }
                ad.d("dancy", "dancy consumeNewXml notifyShowNewTips isExit: %s, begintime: %s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.newtips.b.a)localObject1).field_isExit), Long.valueOf(((com.tencent.mm.plugin.newtips.b.a)localObject1).field_beginShowTime) });
                paramString.e((com.tencent.mm.plugin.newtips.b.a)localObject1);
                break label422;
              }
              k = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipId;
              m = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipVersion;
              n = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipType;
              l1 = bt.flT();
              aj.getContext().getSharedPreferences(aj.fkC() + "_newtips_report", 0).edit().putLong("newtips_gettipstime", l1).commit();
              if (((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo != null)
              {
                j = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo.dlp;
                label2431:
                if (((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo == null) {
                  break label2638;
                }
                paramString = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo.title;
                if (((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo == null) {
                  break label2644;
                }
                paramMap = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo.pkr;
                if (((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo == null) {
                  break label2650;
                }
                parama = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo.path;
                com.tencent.mm.plugin.newtips.a.duq();
                if (localObject1 != null) {
                  break label2656;
                }
                i = 1;
              }
              label2777:
              for (;;)
              {
                com.tencent.mm.plugin.report.service.g.yhR.f(14995, new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Long.valueOf(l1), "", "", "", "", "", "", "", Integer.valueOf(j), paramString, paramMap, parama, Integer.valueOf(i), Integer.valueOf(d.wsv), "" });
                break;
                j = 0;
                break label2431;
                paramString = "";
                break label2448;
                paramMap = "";
                break label2465;
                label2650:
                parama = "";
                break label2482;
                label2656:
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
                    ad.e("MicroMsg.NewTipsManager", "check type, tipsInfo is null!!!");
                  }
                  for (i = 0;; i = 1)
                  {
                    if (i != 0) {
                      break label2763;
                    }
                    i = 5;
                    break;
                    localObject2 = com.tencent.mm.plugin.newtips.a.duo().LT(((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipId);
                    if ((localObject2 == null) || (((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipType != ((com.tencent.mm.plugin.newtips.b.a)localObject2).field_tipType)) {
                      break label2712;
                    }
                  }
                  if (localObject1 == null) {
                    ad.e("MicroMsg.NewTipsManager", "check local info, newTipsInfo is null !!");
                  }
                  for (i = 0;; i = 1)
                  {
                    if (i != 0) {
                      break label2812;
                    }
                    i = 6;
                    break;
                    if (com.tencent.mm.plugin.newtips.a.duo().LT(((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipId) == null) {
                      break label2777;
                    }
                  }
                  label2812:
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
    AppMethodBeat.i(214430);
    this.wsT.put(paramString, parama);
    AppMethodBeat.o(214430);
  }
  
  public static abstract interface a
  {
    public abstract boolean a(long paramLong, String paramString, List<c> paramList, Map<String, String> paramMap);
    
    public abstract boolean b(long paramLong, String paramString, List<c> paramList, Map<String, String> paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.l
 * JD-Core Version:    0.7.0.1
 */