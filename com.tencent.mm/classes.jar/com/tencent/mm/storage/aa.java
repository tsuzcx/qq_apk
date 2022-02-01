package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.an.af;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.eny;
import com.tencent.mm.protocal.protobuf.eoa;
import com.tencent.mm.protocal.protobuf.eob;
import com.tencent.mm.protocal.protobuf.eoc;
import com.tencent.mm.protocal.protobuf.flj;
import com.tencent.mm.protocal.protobuf.pz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/storage/BizRecycleCardLogic;", "", "()V", "DEFAULT_INTERVAL", "", "MAX_KEEP_DIGEST_TIME", "TAG", "", "cardRecycleSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getCardRecycleSlot", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "cardRecycleSlot$delegate", "Lkotlin/Lazy;", "isRecycleCard", "", "()Z", "setRecycleCard", "(Z)V", "isRecycleCardCheckOpen", "isRecycleCardCheckOpen$delegate", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "recycleCardOpen", "getRecycleCardOpen", "recycleCardOpen$delegate", "checkRecycleReportStatus", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "doRecycleCard", "", "fromScene", "Lcom/tencent/mm/storage/BizRecycleCardLogic$RecycleCardScene;", "handleRecycleCardResult", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecycleCardReport;", "list", "Lcom/tencent/mm/protocal/protobuf/RecycleCard;", "isDigestExposed", "recycleCard", "recycleCardFromResort", "resortList", "Lcom/tencent/mm/protocal/protobuf/BizMsgItem;", "reportIdKey", "key", "RecycleCardFlag", "RecycleCardScene", "RecycleCardStatus", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
{
  public static final aa acFb;
  private static final j acFc;
  private static final j acFd;
  private static final j acFe;
  private static final j exj;
  
  static
  {
    AppMethodBeat.i(248607);
    acFb = new aa();
    acFc = k.cm((kotlin.g.a.a)aa.d.acFr);
    exj = k.cm((kotlin.g.a.a)aa.f.acFt);
    acFd = k.cm((kotlin.g.a.a)aa.g.acFu);
    acFe = k.cm((kotlin.g.a.a)e.acFs);
    AppMethodBeat.o(248607);
  }
  
  private static boolean D(ab paramab)
  {
    AppMethodBeat.i(248584);
    paramab = "CardRecycleReport" + paramab.field_msgId + '-' + paramab.field_recommendCardId;
    if (iXY().decodeBool(paramab, false))
    {
      AppMethodBeat.o(248584);
      return false;
    }
    ((MultiProcessMMKV)iXY().getSlotForWrite()).encode(paramab, true);
    AppMethodBeat.o(248584);
    return true;
  }
  
  public static LinkedList<eoa> a(LinkedList<eny> paramLinkedList, aa.b paramb)
  {
    AppMethodBeat.i(248576);
    kotlin.g.b.s.u(paramLinkedList, "list");
    kotlin.g.b.s.u(paramb, "fromScene");
    if (((Collection)paramLinkedList).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult list is empty");
      AppMethodBeat.o(248576);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject4;
    label177:
    Object localObject5;
    if (paramb == aa.b.acFk)
    {
      localObject2 = (Iterable)paramLinkedList;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        localObject4 = (eny)localObject3;
        Log.d("MicroMsg.BizRecycleCardLogic", kotlin.g.b.s.X("handleRecycleCardResult flag ", Integer.valueOf(((eny)localObject4).eQp)));
        if (((eny)localObject4).eQp == aa.a.acFg.eQp) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label177;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      localObject2 = ((Iterable)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (eny)((Iterator)localObject2).next();
        localObject4 = af.bHl().aq(((eny)localObject3).YUq, "msgId");
      } while ((localObject4 == null) || (!((ab)localObject4).iYf()));
      localObject5 = new eoa();
      localObject1 = ((ab)localObject4).iYp();
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = ((flj)localObject1).hRR)
      {
        ((eoa)localObject5).DVu = ((String)localObject1);
        ((eoa)localObject5).YUq = ((eny)localObject3).YUq;
        ((eoa)localObject5).YUu = ((eny)localObject3).YUu;
        localLinkedList.add(localObject5);
        af.bHl().yQ(((eny)localObject3).YUq);
        Log.i("MicroMsg.BizRecycleCardLogic", kotlin.g.b.s.X("handleRecycleCardResult ok ", Long.valueOf(((ab)localObject4).field_msgId)));
        jX(12L);
        break;
      }
    }
    Object localObject2 = af.bHl().iYy();
    Object localObject3 = (Iterable)paramLinkedList;
    Object localObject1 = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject3).iterator();
    label468:
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((Iterator)localObject3).next();
      localObject5 = (eny)localObject4;
      Log.d("MicroMsg.BizRecycleCardLogic", kotlin.g.b.s.X("handleRecycleCardResult flag ", Integer.valueOf(((eny)localObject5).eQp)));
      if (((eny)localObject5).eQp == aa.a.acFg.eQp) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label468;
        }
        ((Collection)localObject1).add(localObject4);
        break;
      }
    }
    localObject3 = ((Iterable)localObject1).iterator();
    label703:
    label1089:
    while (((Iterator)localObject3).hasNext())
    {
      localObject5 = (eny)((Iterator)localObject3).next();
      localObject4 = af.bHl().aq(((eny)localObject5).YUq, "msgId");
      if ((localObject4 != null) && (((ab)localObject4).iYf())) {
        if ((((ab)localObject4).field_isRead == 1) && (iXZ()))
        {
          kotlin.g.b.s.s(localObject4, "info");
          if (D((ab)localObject4))
          {
            jX(1L);
            localObject1 = s.acEH;
            i = aa.c.acFn.status;
            localObject1 = ((ab)localObject4).iYp();
            if (localObject1 == null) {}
            for (localObject1 = null;; localObject1 = ((flj)localObject1).hRR)
            {
              s.dZ(i, (String)localObject1);
              Log.i("MicroMsg.BizRecycleCardLogic", kotlin.g.b.s.X("handleRecycleCardResult msgIsRead ", Long.valueOf(((ab)localObject4).field_msgId)));
              break;
            }
          }
          Log.d("MicroMsg.BizRecycleCardLogic", kotlin.g.b.s.X("handleRecycleCardResult msgIsRead ", Long.valueOf(((ab)localObject4).field_msgId)));
        }
        else
        {
          kotlin.g.b.s.s(localObject4, "info");
          if ((System.currentTimeMillis() - ((ab)localObject4).field_createTime <= 172800000L) && (com.tencent.mm.an.c.ovO.decodeInt(String.valueOf(((ab)localObject4).field_msgId), 0) == 1))
          {
            i = 1;
            if ((i == 0) || (!iXZ())) {
              break label819;
            }
            if (!D((ab)localObject4)) {
              break label797;
            }
            jX(2L);
            localObject1 = s.acEH;
            i = aa.c.acFo.status;
            localObject1 = ((ab)localObject4).iYp();
            if (localObject1 != null) {
              break label787;
            }
          }
          for (localObject1 = null;; localObject1 = ((flj)localObject1).hRR)
          {
            s.dZ(i, (String)localObject1);
            Log.i("MicroMsg.BizRecycleCardLogic", kotlin.g.b.s.X("handleRecycleCardResult msg digest IsRead ", Long.valueOf(((ab)localObject4).field_msgId)));
            break;
            i = 0;
            break label703;
          }
          Log.d("MicroMsg.BizRecycleCardLogic", kotlin.g.b.s.X("handleRecycleCardResult msg digest IsRead ", Long.valueOf(((ab)localObject4).field_msgId)));
          continue;
          if ((((ab)localObject4).field_msgId == ((ab)localObject2).field_msgId) && (iXZ()))
          {
            if (D((ab)localObject4))
            {
              jX(3L);
              localObject1 = s.acEH;
              i = aa.c.acFp.status;
              localObject1 = ((ab)localObject4).iYp();
              if (localObject1 == null) {}
              for (localObject1 = null;; localObject1 = ((flj)localObject1).hRR)
              {
                s.dZ(i, (String)localObject1);
                Log.i("MicroMsg.BizRecycleCardLogic", kotlin.g.b.s.X("handleRecycleCardResult msg is newest card ", Long.valueOf(((ab)localObject4).field_msgId)));
                break;
              }
            }
            Log.d("MicroMsg.BizRecycleCardLogic", kotlin.g.b.s.X("handleRecycleCardResult msg is newest card ", Long.valueOf(((ab)localObject4).field_msgId)));
          }
          else
          {
            af.bHl().yQ(((eny)localObject5).YUq);
            Log.i("MicroMsg.BizRecycleCardLogic", kotlin.g.b.s.X("handleRecycleCardResult ok ", Long.valueOf(((ab)localObject4).field_msgId)));
            jX(4L);
            eoa localeoa = new eoa();
            localObject1 = ((ab)localObject4).iYp();
            if (localObject1 == null)
            {
              localObject1 = null;
              label1000:
              localeoa.DVu = ((String)localObject1);
              localeoa.YUq = ((eny)localObject5).YUq;
              localeoa.YUu = ((eny)localObject5).YUu;
              localLinkedList.add(localeoa);
              localObject1 = ((ab)localObject4).iYp();
              if ((localObject1 == null) || (((flj)localObject1).abrz != 2)) {
                break label1086;
              }
            }
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label1089;
              }
              localObject1 = ae.acGm;
              ae.yX(20L);
              break;
              localObject1 = ((flj)localObject1).hRR;
              break label1000;
            }
          }
        }
      }
    }
    label787:
    label797:
    label819:
    label1086:
    Log.i("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult recycleReportList fromScene=" + paramb.scene + ", size = " + localLinkedList.size() + '/' + paramLinkedList.size());
    if (((Collection)localLinkedList).isEmpty()) {}
    for (i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(248576);
      return null;
    }
    int k = 0;
    i = 0;
    paramLinkedList = af.bHl().yH(af.bHl().iYD() << 32);
    int m;
    if (paramLinkedList != null)
    {
      paramLinkedList = ((Iterable)paramLinkedList).iterator();
      int j = 0;
      m = j;
      k = i;
      if (paramLinkedList.hasNext())
      {
        paramb = (ab)paramLinkedList.next();
        if (paramb.iYe())
        {
          k = 1;
          label1245:
          if (!paramb.iYf()) {
            break label1274;
          }
        }
        label1274:
        for (m = 1;; m = 0)
        {
          j = k + j;
          i = m + i;
          break;
          k = 0;
          break label1245;
        }
      }
    }
    else
    {
      m = 0;
    }
    paramLinkedList = new c.a();
    paramb = new eob();
    paramb.lPK = localLinkedList;
    paramb.absr = m;
    paramb.abss = k;
    localObject1 = ah.aiuX;
    paramLinkedList.otE = ((com.tencent.mm.bx.a)paramb);
    paramLinkedList.otF = ((com.tencent.mm.bx.a)new eoc());
    paramLinkedList.uri = "/cgi-bin/mmbiz-bin/timeline/recyclecardreport";
    paramLinkedList.funcId = 4768;
    z.a(paramLinkedList.bEF(), aa..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(248576);
    return localLinkedList;
  }
  
  public static MultiProcessMMKV atj()
  {
    AppMethodBeat.i(248523);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)exj.getValue();
    AppMethodBeat.o(248523);
    return localMultiProcessMMKV;
  }
  
  public static LinkedList<eoa> cu(LinkedList<pz> paramLinkedList)
  {
    AppMethodBeat.i(248540);
    kotlin.g.b.s.u(paramLinkedList, "resortList");
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    label107:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      pz localpz = (pz)localObject2;
      if ((localpz.tNW != 0) && ((localpz.YUt & 0x1) != 0)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label107;
        }
        paramLinkedList.add(localObject2);
        break;
      }
    }
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      localObject1 = (pz)paramLinkedList.next();
      localObject2 = new eny();
      ((eny)localObject2).DVu = ((pz)localObject1).DVu;
      ((eny)localObject2).YUq = ((pz)localObject1).YUq;
      ((eny)localObject2).eQp = aa.a.acFg.eQp;
      ((eny)localObject2).YUu = ((pz)localObject1).YUu;
      localLinkedList.add(localObject2);
    }
    if (((Collection)localLinkedList).isEmpty()) {}
    for (int i = 1; i == 0; i = 0)
    {
      jX(5L);
      paramLinkedList = a(localLinkedList, aa.b.acFl);
      AppMethodBeat.o(248540);
      return paramLinkedList;
    }
    AppMethodBeat.o(248540);
    return null;
  }
  
  private static final int i(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.c paramc, p paramp)
  {
    AppMethodBeat.i(248600);
    Log.i("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult callback errType = " + paramInt1 + ", errCode=" + paramInt2);
    AppMethodBeat.o(248600);
    return 0;
  }
  
  private static MMKVSlotManager iXY()
  {
    AppMethodBeat.i(248517);
    MMKVSlotManager localMMKVSlotManager = (MMKVSlotManager)acFc.getValue();
    AppMethodBeat.o(248517);
    return localMMKVSlotManager;
  }
  
  private static boolean iXZ()
  {
    AppMethodBeat.i(248530);
    boolean bool = ((Boolean)acFe.getValue()).booleanValue();
    AppMethodBeat.o(248530);
    return bool;
  }
  
  public static void jX(long paramLong)
  {
    AppMethodBeat.i(248591);
    h.OAn.p(1534L, paramLong, 1L);
    AppMethodBeat.o(248591);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    public static final e acFs;
    
    static
    {
      AppMethodBeat.i(248706);
      acFs = new e();
      AppMethodBeat.o(248706);
    }
    
    e()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.aa
 * JD-Core Version:    0.7.0.1
 */