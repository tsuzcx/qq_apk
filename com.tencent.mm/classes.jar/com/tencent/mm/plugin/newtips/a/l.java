package com.tencent.mm.plugin.newtips.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.g.a.ng;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.newtips.b.b;
import com.tencent.mm.plugin.newtips.b.c;
import com.tencent.mm.protocal.protobuf.dob;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
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
  private static final Long ddR;
  private ConcurrentHashMap<String, a> wID;
  
  static
  {
    AppMethodBeat.i(127261);
    ddR = Long.valueOf(604800L);
    AppMethodBeat.o(127261);
  }
  
  public l()
  {
    AppMethodBeat.i(200598);
    this.wID = new ConcurrentHashMap();
    AppMethodBeat.o(200598);
  }
  
  private static boolean a(List<c> paramList, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200600);
    ae.i("MicroMsg.NewTips.NewTipsXMLConsumer", "checkLogicValidOp() newTips type(%s) unique_id(%s) op(%s)", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
    if ((paramList == null) || (paramList.size() <= 0))
    {
      ae.i("MicroMsg.NewTips.NewTipsXMLConsumer", "checkLogicValidOp() uniqueId not exist in storage");
      if (paramInt2 == 1)
      {
        AppMethodBeat.o(200600);
        return false;
      }
      AppMethodBeat.o(200600);
      return true;
    }
    if (paramInt1 == d.wHP)
    {
      AppMethodBeat.o(200600);
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
        AppMethodBeat.o(200600);
        return true;
      }
      ae.i("MicroMsg.NewTips.NewTipsXMLConsumer", "checkLogicValidOp() unique_id(%s) exist(op:%s)", new Object[] { paramString, Integer.valueOf(paramInt2) });
      AppMethodBeat.o(200600);
      return false;
    }
  }
  
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(127260);
    ae.d("MicroMsg.NewTips.NewTipsXMLConsumer", "dancy consumeNewXml， subType:%s", new Object[] { paramString });
    long l3;
    if ((bu.nullAsNil(paramString).equals("newtips")) && (paramMap != null))
    {
      if (paramMap.get(".sysmsg.newtips.tips_showInfo_list") == null) {
        break label2240;
      }
      paramString = "";
      l3 = 0L;
      if (paramMap.containsKey(".sysmsg.newtips.control.tips_id")) {
        l3 = bu.getLong((String)paramMap.get(".sysmsg.newtips.control.tips_id"), 0L);
      }
      if (paramMap.containsKey(".sysmsg.newtips.control.unique_id")) {
        paramString = bu.nullAsNil((String)paramMap.get(".sysmsg.newtips.control.unique_id"));
      }
      if (!paramMap.containsKey(".sysmsg.newtips.control.op")) {
        break label2851;
      }
    }
    label1183:
    label2465:
    label2851:
    for (int j = bu.getInt((String)paramMap.get(".sysmsg.newtips.control.op"), 0);; j = 0)
    {
      int i;
      if (bu.isNullOrNil(paramString))
      {
        ae.i("MicroMsg.NewTips.NewTipsXMLConsumer", "checkNumValidUniqueIdAndOp() uniqueId is null");
        i = 0;
      }
      Object localObject1;
      Object localObject3;
      while (i != 0)
      {
        i = 0;
        if (paramMap.containsKey(".sysmsg.newtips.control.tips_type")) {
          i = bu.getInt((String)paramMap.get(".sysmsg.newtips.control.tips_type"), 0);
        }
        parama = com.tencent.mm.plugin.newtips.a.dxF().auv(paramString);
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
            ae.i("MicroMsg.NewTips.NewTipsXMLConsumer", "checkNumValidUniqueIdAndOp() uniqueId:%s op:%s", new Object[] { paramString, Integer.valueOf(j) });
            if ((j != 0) && (j != 1))
            {
              ae.i("MicroMsg.NewTips.NewTipsXMLConsumer", "checkNumValidUniqueIdAndOp() op:%s not exist in (0,1)", new Object[] { Integer.valueOf(j) });
              i = 0;
              break;
            }
            i = 1;
            break;
          }
        }
        localObject1 = this.wID.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          localObject3 = (a)((Map.Entry)localObject2).getValue();
          if ((localObject3 != null) && (((a)localObject3).a(l3, paramString, parama, paramMap))) {
            ae.i("MicroMsg.NewTips.NewTipsXMLConsumer", "[handleNewXml] key=%s, handleCallback=%s has cancel consume. tipsId=%s uniqueId=%s", new Object[] { ((Map.Entry)localObject2).getKey(), localObject3, Long.valueOf(l3), paramString });
          }
        }
      }
      label422:
      label476:
      while (!a(parama, paramString, i, j)) {
        for (;;)
        {
          ar.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(127258);
              ae.i("MicroMsg.NewTips.NewTipsXMLConsumer", "consumeNewXml() batch delete expire data!!");
              com.tencent.mm.plugin.newtips.a.dxF().yG(ch.aDa() / 1000L);
              AppMethodBeat.o(127258);
            }
          }, 30000L);
          AppMethodBeat.o(127260);
          return null;
          if (a(parama, paramString, i, j))
          {
            ae.i("MicroMsg.NewTips.NewTipsXMLConsumer", "handleNewXml() update localNewTips state to NEW_TIPS_STATE_CANCEL. ret: %s", new Object[] { Integer.valueOf(com.tencent.mm.plugin.newtips.a.dxF().eK(parama)) });
            com.tencent.mm.plugin.newtips.a.dxD();
            i.eJ(parama);
          }
        }
      }
      int i4 = (int)l3;
      Object localObject2 = new ArrayList();
      if (paramMap.containsKey(".sysmsg.newtips.tips_showInfo_list.size")) {}
      label2482:
      for (j = bu.getInt((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.size"), 0);; j = 0)
      {
        if (j == 0) {
          ae.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() tipsCount == 0");
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
          f.dxI();
          parama = f.Ms(i);
          if (parama != null) {
            break label2154;
          }
          bool = true;
          if (!bool) {
            break label2229;
          }
          parama = this.wID.entrySet().iterator();
          do
          {
            if (!parama.hasNext()) {
              break;
            }
            localObject1 = (Map.Entry)parama.next();
            localObject3 = (a)((Map.Entry)localObject1).getValue();
          } while ((localObject3 == null) || (!((a)localObject3).b(l3, paramString, (List)localObject2, paramMap)));
          ae.i("MicroMsg.NewTips.NewTipsXMLConsumer", "[handleNewXml] key=%s, handleCallback=%s has add consume. tipsId=%s uniqueId=%s", new Object[] { ((Map.Entry)localObject1).getKey(), localObject3, Long.valueOf(l3), paramString });
          break;
          k = 0;
          m = 0;
          if (paramMap.containsKey(".sysmsg.newtips.control.android_min_clientversion")) {
            k = bu.getInt((String)paramMap.get(".sysmsg.newtips.control.android_min_clientversion"), 0);
          }
          if (paramMap.containsKey(".sysmsg.newtips.control.android_max_clientversion")) {
            m = bu.getInt((String)paramMap.get(".sysmsg.newtips.control.android_max_clientversion"), 2147483647);
          }
          n = 0;
          l1 = 0L;
          l4 = 0L;
          long l2 = 0L;
          parama = "";
          if (paramMap.containsKey(".sysmsg.newtips.control.priority")) {
            n = bu.getInt((String)paramMap.get(".sysmsg.newtips.control.priority"), 0);
          }
          if (paramMap.containsKey(".sysmsg.newtips.control.begin_time")) {
            l1 = bu.getLong((String)paramMap.get(".sysmsg.newtips.control.begin_time"), 0L);
          }
          if (paramMap.containsKey(".sysmsg.newtips.control.overdue_time")) {
            l4 = bu.getLong((String)paramMap.get(".sysmsg.newtips.control.overdue_time"), 0L);
          }
          if (paramMap.containsKey(".sysmsg.newtips.control.disappear_time")) {
            l2 = bu.getLong((String)paramMap.get(".sysmsg.newtips.control.disappear_time"), 0L);
          }
          if (paramMap.containsKey(".sysmsg.newtips.ext_info")) {
            parama = bu.nullAsNil((String)paramMap.get(".sysmsg.newtips.ext_info")).trim();
          }
          l5 = l1;
          if (l1 == 0L)
          {
            l5 = ch.aDa() / 1000L;
            ae.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s) => beginShowTime==0", new Object[] { paramString });
          }
          l1 = l2;
          if (l2 == 0L)
          {
            l1 = l2;
            if (l4 == 0L)
            {
              l1 = l5 + ddR.longValue();
              ae.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s) => disappearTime==0", new Object[] { paramString });
            }
          }
          i1 = 0;
        } while (i1 >= j);
        localObject3 = new c(paramString, i4, n, i, l5, l4, l1, k, m, parama);
        if (i1 == 0)
        {
          ((c)localObject3).field_showType = bu.getInt((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.show_type"), 0);
          ((c)localObject3).field_title = bu.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.title")).trim();
          ((c)localObject3).field_icon_url = bu.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.icon_url")).trim();
          localObject1 = bu.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.path")).trim();
          i2 = g.aus((String)localObject1);
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
        for (int i2 = bu.getInt((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.parents.size"), 0);; i2 = 0)
        {
          doc localdoc;
          int i3;
          if (i2 != 0)
          {
            localdoc = new doc();
            i3 = 0;
            if (i3 < i2)
            {
              if (i3 == 0) {}
              for (localObject1 = bu.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.parents.parent")).trim();; localObject1 = bu.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.parents.parent".concat(String.valueOf(i3)))).trim())
              {
                if (!bu.isNullOrNil((String)localObject1)) {
                  localdoc.fXm.add(localObject1);
                }
                i3 += 1;
                break label1183;
                ((c)localObject3).field_path = i2;
                break;
              }
            }
            if (localdoc.fXm.size() > 0) {
              ((c)localObject3).field_parents = localdoc;
            }
          }
          localObject1 = k.Mx(((c)localObject3).field_showType);
          label2638:
          label2644:
          switch (2.wIo[localObject1.ordinal()])
          {
          case 1: 
          case 2: 
          case 3: 
          case 4: 
          default: 
            ((List)localObject2).add(localObject3);
            ae.d("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() i:%s newTipsInfo:%s", new Object[] { Integer.valueOf(i1), localObject3 });
            i1 += 1;
            break;
            ((c)localObject3).field_showType = bu.getInt((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".show_type"), 0);
            ((c)localObject3).field_title = bu.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".title")).trim();
            ((c)localObject3).field_icon_url = bu.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".icon_url")).trim();
            localObject1 = bu.nullAsNil(((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".path")).trim());
            i2 = g.aus((String)localObject1);
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
            for (i2 = bu.getInt((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".parents.size"), 0);; i2 = 0)
            {
              if (i2 == 0) {
                break label1302;
              }
              localdoc = new doc();
              i3 = 0;
              if (i3 < i2)
              {
                if (i3 == 0) {}
                for (localObject1 = bu.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".parents.parent")).trim();; localObject1 = bu.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".parents.parent" + i3)).trim())
                {
                  if (!bu.isNullOrNil((String)localObject1)) {
                    localdoc.fXm.add(localObject1);
                  }
                  i3 += 1;
                  break label1687;
                  ((c)localObject3).field_path = i2;
                  break;
                }
              }
              if (localdoc.fXm.size() <= 0) {
                break label1302;
              }
              ((c)localObject3).field_parents = localdoc;
              break label1302;
              if (!bu.isNullOrNil(((c)localObject3).field_title)) {
                break label1364;
              }
              ((c)localObject3).field_showType = 0;
              ae.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s path:%s showType:%s) => field_title==null", new Object[] { ((c)localObject3).field_uniqueId, Integer.valueOf(((c)localObject3).field_path), ((k)localObject1).toString() });
              break label1364;
              if (!bu.isNullOrNil(((c)localObject3).field_icon_url)) {
                break label1364;
              }
              ((c)localObject3).field_showType = 0;
              ae.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s path:%s showType:%s) => field_icon_url==null", new Object[] { ((c)localObject3).field_uniqueId, Integer.valueOf(((c)localObject3).field_path), ((k)localObject1).toString() });
              break label1364;
              if ((bu.isNullOrNil(((c)localObject3).field_title)) && (bu.isNullOrNil(((c)localObject3).field_icon_url)))
              {
                ((c)localObject3).field_showType = 0;
                ae.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s path:%s showType:%s) => field_title==null && field_icon_url==null", new Object[] { ((c)localObject3).field_uniqueId, Integer.valueOf(((c)localObject3).field_path), ((k)localObject1).toString() });
                break label1364;
              }
              if (bu.isNullOrNil(((c)localObject3).field_title))
              {
                ((c)localObject3).field_showType = 3;
                ae.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s path:%s showType:%s) => field_title==null", new Object[] { ((c)localObject3).field_uniqueId, Integer.valueOf(((c)localObject3).field_path), ((k)localObject1).toString() });
                break label1364;
              }
              if (!bu.isNullOrNil(((c)localObject3).field_icon_url)) {
                break label1364;
              }
              ((c)localObject3).field_showType = 2;
              ae.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s path:%s showType:%s) => field_icon_url==null", new Object[] { ((c)localObject3).field_uniqueId, Integer.valueOf(((c)localObject3).field_path), ((k)localObject1).toString() });
              break label1364;
              label2154:
              bool = parama.dxJ();
              break label564;
              i = com.tencent.mm.plugin.newtips.a.dxF().eL((List)localObject2);
              paramMap = new ng();
              paramMap.dCk.dCl = paramString;
              com.tencent.mm.sdk.b.a.IvT.l(paramMap);
              ae.i("MicroMsg.NewTips.NewTipsXMLConsumer", "handleNewXml() insert ret:%s", new Object[] { Integer.valueOf(i) });
              com.tencent.mm.plugin.newtips.a.dxD();
              i.eJ((List)localObject2);
              break;
              ae.i("MicroMsg.NewTips.NewTipsXMLConsumer", "handleNewXml() no insert");
              break;
              com.tencent.mm.plugin.newtips.a.dxD();
              localObject1 = i.as(paramMap);
              if (localObject1 == null) {
                break label422;
              }
              if (localObject1 == null)
              {
                ae.e("MicroMsg.NewTips.NewTipsXMLConsumer", "reportNewTips, newTipsInfo is null !!");
                paramString = com.tencent.mm.plugin.newtips.a.dxD().wIr;
                if (paramString == null) {
                  break label422;
                }
                com.tencent.mm.plugin.newtips.a.dxG();
                if (!e.d((com.tencent.mm.plugin.newtips.b.a)localObject1)) {
                  break label422;
                }
                ae.d("dancy", "dancy consumeNewXml notifyShowNewTips isExit: %s, begintime: %s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.newtips.b.a)localObject1).field_isExit), Long.valueOf(((com.tencent.mm.plugin.newtips.b.a)localObject1).field_beginShowTime) });
                paramString.e((com.tencent.mm.plugin.newtips.b.a)localObject1);
                break label422;
              }
              k = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipId;
              m = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipVersion;
              n = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipType;
              l1 = bu.fpO();
              ak.getContext().getSharedPreferences(ak.fow() + "_newtips_report", 0).edit().putLong("newtips_gettipstime", l1).commit();
              if (((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo != null)
              {
                j = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo.dmr;
                label2431:
                if (((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo == null) {
                  break label2638;
                }
                paramString = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo.title;
                if (((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo == null) {
                  break label2644;
                }
                paramMap = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo.pqW;
                if (((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo == null) {
                  break label2650;
                }
                parama = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo.path;
                com.tencent.mm.plugin.newtips.a.dxG();
                if (localObject1 != null) {
                  break label2656;
                }
                i = 1;
              }
              label2777:
              for (;;)
              {
                com.tencent.mm.plugin.report.service.g.yxI.f(14995, new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Long.valueOf(l1), "", "", "", "", "", "", "", Integer.valueOf(j), paramString, paramMap, parama, Integer.valueOf(i), Integer.valueOf(d.wIe), "" });
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
                    ae.e("MicroMsg.NewTipsManager", "check type, tipsInfo is null!!!");
                  }
                  for (i = 0;; i = 1)
                  {
                    if (i != 0) {
                      break label2763;
                    }
                    i = 5;
                    break;
                    localObject2 = com.tencent.mm.plugin.newtips.a.dxE().My(((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipId);
                    if ((localObject2 == null) || (((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipType != ((com.tencent.mm.plugin.newtips.b.a)localObject2).field_tipType)) {
                      break label2712;
                    }
                  }
                  if (localObject1 == null) {
                    ae.e("MicroMsg.NewTipsManager", "check local info, newTipsInfo is null !!");
                  }
                  for (i = 0;; i = 1)
                  {
                    if (i != 0) {
                      break label2812;
                    }
                    i = 6;
                    break;
                    if (com.tencent.mm.plugin.newtips.a.dxE().My(((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipId) == null) {
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
    AppMethodBeat.i(200599);
    this.wID.put(paramString, parama);
    AppMethodBeat.o(200599);
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