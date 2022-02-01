package com.tencent.mm.plugin.newtips.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.autogen.a.qg;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.newtips.b.b;
import com.tencent.mm.plugin.newtips.b.c;
import com.tencent.mm.protocal.protobuf.fni;
import com.tencent.mm.protocal.protobuf.fnj;
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
  implements s
{
  private static final Long hrG;
  public ConcurrentHashMap<String, a> MsS;
  
  static
  {
    AppMethodBeat.i(127261);
    hrG = Long.valueOf(604800L);
    AppMethodBeat.o(127261);
  }
  
  public l()
  {
    AppMethodBeat.i(266301);
    this.MsS = new ConcurrentHashMap();
    AppMethodBeat.o(266301);
  }
  
  public final g.b a(String paramString, Map<String, String> paramMap, g.a parama)
  {
    AppMethodBeat.i(127260);
    Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "dancy consumeNewXml， subType:%s", new Object[] { paramString });
    long l3;
    int k;
    int j;
    label259:
    Object localObject1;
    label370:
    label376:
    Object localObject2;
    if ((Util.nullAsNil(paramString).equals("newtips")) && (paramMap != null))
    {
      if (paramMap.get(".sysmsg.newtips.tips_showInfo_list") == null) {
        break label2409;
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
          break label592;
        }
        j = 0;
        if (paramMap.containsKey(".sysmsg.newtips.control.tips_type")) {
          j = Util.getInt((String)paramMap.get(".sysmsg.newtips.control.tips_type"), 0);
        }
        parama = com.tencent.mm.plugin.newtips.a.gth().aPZ(paramString);
        Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "checkLogicValidOp() newTips type(%s) unique_id(%s) op(%s)", new Object[] { Integer.valueOf(j), paramString, Integer.valueOf(k) });
        if ((parama != null) && (parama.size() > 0)) {
          break label376;
        }
        Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "checkLogicValidOp() uniqueId not exist in storage");
        if (k != 1) {
          break label370;
        }
        i = 0;
      }
      for (;;)
      {
        if (i != 0)
        {
          if (k != 1) {
            break label648;
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
              break label259;
              if (j == d.Msc)
              {
                i = 0;
                break label259;
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
    label648:
    label2825:
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
      localObject1 = this.MsS.entrySet().iterator();
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
        label592:
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(127258);
            Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "consumeNewXml() batch delete expire data!!");
            com.tencent.mm.plugin.newtips.a.gth().sQ(cn.bDu() / 1000L);
            AppMethodBeat.o(127258);
          }
        }, 30000L);
        label606:
        AppMethodBeat.o(127260);
        return null;
        Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "handleNewXml() update localNewTips state to NEW_TIPS_STATE_CANCEL. ret: %s", new Object[] { Integer.valueOf(com.tencent.mm.plugin.newtips.a.gth().jl(parama)) });
        com.tencent.mm.plugin.newtips.a.gtf();
        i.jk(parama);
      }
      int i4 = (int)l3;
      localObject2 = new ArrayList();
      if (paramMap.containsKey(".sysmsg.newtips.tips_showInfo_list.size")) {}
      label2326:
      label2981:
      for (i = Util.getInt((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.size"), 0);; i = 0)
      {
        if (i == 0) {
          Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() tipsCount == 0");
        }
        boolean bool;
        label724:
        int m;
        int n;
        long l1;
        long l4;
        long l5;
        int i1;
        do
        {
          i = (int)l3;
          f.gtk();
          parama = f.aeF(i);
          if (parama != null) {
            break label2326;
          }
          bool = true;
          if (!bool) {
            break label2398;
          }
          parama = this.MsS.entrySet().iterator();
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
            l5 = cn.bDu() / 1000L;
            Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s) => beginShowTime==0", new Object[] { paramString });
          }
          l1 = l2;
          if (l2 == 0L)
          {
            l1 = l2;
            if (l4 == 0L)
            {
              l1 = l5 + hrG.longValue();
              Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s) => disappearTime==0", new Object[] { paramString });
            }
          }
          localObject3 = (String)paramMap.get(".sysmsg.newtips.control.lang");
          i1 = 0;
        } while (i1 >= i);
        c localc = new c(paramString, i4, n, j, l5, l4, l1, k, m, parama);
        localc.field_lang = ((String)localObject3);
        if (i1 == 0)
        {
          localc.field_showType = Util.getInt((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.show_type"), 0);
          localc.field_title = Util.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.title")).trim();
          localc.field_icon_url = Util.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.icon_url")).trim();
          localObject1 = Util.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.path")).trim();
          i2 = g.aPV((String)localObject1);
          if (i2 == 0)
          {
            localc.field_dynamicPath = ((String)localObject1);
            if (!paramMap.containsKey(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.parents.size")) {
              break label3008;
            }
          }
        }
        label2600:
        label2617:
        label3002:
        label3008:
        for (int i2 = Util.getInt((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.parents.size"), 0);; i2 = 0)
        {
          fnj localfnj;
          int i3;
          if (i2 != 0)
          {
            localfnj = new fnj();
            i3 = 0;
            label1356:
            if (i3 < i2)
            {
              if (i3 == 0) {}
              for (localObject1 = Util.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.parents.parent")).trim();; localObject1 = Util.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo.parents.parent".concat(String.valueOf(i3)))).trim())
              {
                if (!Util.isNullOrNil((String)localObject1)) {
                  localfnj.lPK.add(localObject1);
                }
                i3 += 1;
                break label1356;
                localc.field_path = i2;
                break;
              }
            }
            if (localfnj.lPK.size() > 0) {
              localc.field_parents = localfnj;
            }
          }
          label1475:
          localObject1 = k.aeK(localc.field_showType);
          switch (2.MsD[localObject1.ordinal()])
          {
          case 1: 
          case 2: 
          case 3: 
          case 4: 
          default: 
            ((List)localObject2).add(localc);
            Log.d("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() i:%s newTipsInfo:%s", new Object[] { Integer.valueOf(i1), localc });
            i1 += 1;
            break;
            localc.field_showType = Util.getInt((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".show_type"), 0);
            localc.field_title = Util.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".title")).trim();
            localc.field_icon_url = Util.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".icon_url")).trim();
            localObject1 = Util.nullAsNil(((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".path")).trim());
            i2 = g.aPV((String)localObject1);
            if (i2 == 0)
            {
              localc.field_dynamicPath = ((String)localObject1);
              if (!paramMap.containsKey(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".parents.size")) {
                break label3002;
              }
            }
          case 5: 
          case 6: 
          case 7: 
            for (i2 = Util.getInt((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".parents.size"), 0);; i2 = 0)
            {
              if (i2 == 0) {
                break label1475;
              }
              localfnj = new fnj();
              i3 = 0;
              label1859:
              if (i3 < i2)
              {
                if (i3 == 0) {}
                for (localObject1 = Util.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".parents.parent")).trim();; localObject1 = Util.nullAsNil((String)paramMap.get(".sysmsg.newtips.tips_showInfo_list.tips_showInfo" + i1 + ".parents.parent" + i3)).trim())
                {
                  if (!Util.isNullOrNil((String)localObject1)) {
                    localfnj.lPK.add(localObject1);
                  }
                  i3 += 1;
                  break label1859;
                  localc.field_path = i2;
                  break;
                }
              }
              if (localfnj.lPK.size() <= 0) {
                break label1475;
              }
              localc.field_parents = localfnj;
              break label1475;
              if (!Util.isNullOrNil(localc.field_title)) {
                break label1536;
              }
              localc.field_showType = 0;
              Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s path:%s showType:%s) => field_title==null", new Object[] { localc.field_uniqueId, Integer.valueOf(localc.field_path), ((k)localObject1).toString() });
              break label1536;
              if (!Util.isNullOrNil(localc.field_icon_url)) {
                break label1536;
              }
              localc.field_showType = 0;
              Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s path:%s showType:%s) => field_icon_url==null", new Object[] { localc.field_uniqueId, Integer.valueOf(localc.field_path), ((k)localObject1).toString() });
              break label1536;
              if ((Util.isNullOrNil(localc.field_title)) && (Util.isNullOrNil(localc.field_icon_url)))
              {
                localc.field_showType = 0;
                Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s path:%s showType:%s) => field_title==null && field_icon_url==null", new Object[] { localc.field_uniqueId, Integer.valueOf(localc.field_path), ((k)localObject1).toString() });
                break label1536;
              }
              if (Util.isNullOrNil(localc.field_title))
              {
                localc.field_showType = 3;
                Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s path:%s showType:%s) => field_title==null", new Object[] { localc.field_uniqueId, Integer.valueOf(localc.field_path), ((k)localObject1).toString() });
                break label1536;
              }
              if (!Util.isNullOrNil(localc.field_icon_url)) {
                break label1536;
              }
              localc.field_showType = 2;
              Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "parseNewTips() doudi(unique_id:%s path:%s showType:%s) => field_icon_url==null", new Object[] { localc.field_uniqueId, Integer.valueOf(localc.field_path), ((k)localObject1).toString() });
              break label1536;
              bool = parama.gtl();
              break label724;
              i = com.tencent.mm.plugin.newtips.a.gth().cF((List)localObject2);
              paramMap = new qg();
              paramMap.hTr.hTs = paramString;
              paramMap.publish();
              Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "handleNewXml() insert ret:%s", new Object[] { Integer.valueOf(i) });
              com.tencent.mm.plugin.newtips.a.gtf();
              i.jk((List)localObject2);
              break;
              label2398:
              Log.i("MicroMsg.NewTips.NewTipsXMLConsumer", "handleNewXml() no insert");
              break;
              label2409:
              com.tencent.mm.plugin.newtips.a.gtf();
              localObject1 = i.aC(paramMap);
              if (localObject1 == null) {
                break label606;
              }
              if (localObject1 == null)
              {
                Log.e("MicroMsg.NewTips.NewTipsXMLConsumer", "reportNewTips, newTipsInfo is null !!");
                paramString = com.tencent.mm.plugin.newtips.a.gtf().MsG;
                if (paramString == null) {
                  break label606;
                }
                com.tencent.mm.plugin.newtips.a.gti();
                if (!e.d((com.tencent.mm.plugin.newtips.b.a)localObject1)) {
                  break label606;
                }
                Log.d("dancy", "dancy consumeNewXml notifyShowNewTips isExit: %s, begintime: %s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.newtips.b.a)localObject1).field_isExit), Long.valueOf(((com.tencent.mm.plugin.newtips.b.a)localObject1).field_beginShowTime) });
                paramString.e((com.tencent.mm.plugin.newtips.b.a)localObject1);
                break label606;
              }
              k = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipId;
              m = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipVersion;
              n = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipType;
              l1 = Util.nowMilliSecond();
              MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_newtips_report", 0).edit().putLong("newtips_gettipstime", l1).commit();
              if (((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo != null)
              {
                j = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo.hAN;
                if (((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo == null) {
                  break label2807;
                }
                paramString = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo.title;
                if (((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo == null) {
                  break label2813;
                }
                paramMap = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo.icon_url;
                label2634:
                if (((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo == null) {
                  break label2819;
                }
                parama = ((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipsShowInfo.path;
                label2651:
                com.tencent.mm.plugin.newtips.a.gti();
                if (localObject1 != null) {
                  break label2825;
                }
                i = 1;
              }
              for (;;)
              {
                com.tencent.mm.plugin.report.service.h.OAn.b(14995, new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Long.valueOf(l1), "", "", "", "", "", "", "", Integer.valueOf(j), paramString, paramMap, parama, Integer.valueOf(i), Integer.valueOf(d.Msr), "" });
                break;
                j = 0;
                break label2600;
                label2807:
                paramString = "";
                break label2617;
                label2813:
                paramMap = "";
                break label2634;
                parama = "";
                break label2651;
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
                  label2881:
                  for (i = 0;; i = 1)
                  {
                    if (i != 0) {
                      break label2932;
                    }
                    i = 5;
                    break;
                    localObject2 = com.tencent.mm.plugin.newtips.a.gtg().aeL(((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipId);
                    if ((localObject2 == null) || (((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipType != ((com.tencent.mm.plugin.newtips.b.a)localObject2).field_tipType)) {
                      break label2881;
                    }
                  }
                  label2932:
                  if (localObject1 == null) {
                    Log.e("MicroMsg.NewTipsManager", "check local info, newTipsInfo is null !!");
                  }
                  for (i = 0;; i = 1)
                  {
                    if (i != 0) {
                      break label2981;
                    }
                    i = 6;
                    break;
                    if (com.tencent.mm.plugin.newtips.a.gtg().aeL(((com.tencent.mm.plugin.newtips.b.a)localObject1).field_tipId) == null) {
                      break label2946;
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
  
  public static abstract interface a
  {
    public abstract boolean a(long paramLong, String paramString, List<c> paramList, Map<String, String> paramMap);
    
    public abstract boolean b(long paramLong, String paramString, List<c> paramList, Map<String, String> paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.a.l
 * JD-Core Version:    0.7.0.1
 */