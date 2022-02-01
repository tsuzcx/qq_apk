package com.tencent.mm.storage;

import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.dli;
import com.tencent.mm.protocal.protobuf.dlk;
import com.tencent.mm.protocal.protobuf.dll;
import com.tencent.mm.protocal.protobuf.dlm;
import com.tencent.mm.protocal.protobuf.dlo;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/storage/BizRecycleCardLogic;", "", "()V", "DEFAULT_INTERVAL", "", "TAG", "", "cardRecycleSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getCardRecycleSlot", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "cardRecycleSlot$delegate", "Lkotlin/Lazy;", "isRecycleCard", "", "()Z", "setRecycleCard", "(Z)V", "isRecycleCardCheckOpen", "isRecycleCardCheckOpen$delegate", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "recycleCardOpen", "getRecycleCardOpen", "recycleCardOpen$delegate", "checkRecycleReportStatus", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "doRecycleCard", "", "fromScene", "Lcom/tencent/mm/storage/BizRecycleCardLogic$RecycleCardScene;", "handleRecycleCardResult", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecycleCard;", "recycleCard", "reportIdKey", "key", "RecycleCardFlag", "RecycleCardScene", "RecycleCardStatus", "plugin-biz_release"})
public final class y
{
  private static final f NPL;
  private static final f NPM;
  private static final f NPN;
  private static boolean NPO;
  public static final y NPP;
  private static final f iBW;
  
  static
  {
    AppMethodBeat.i(212601);
    NPP = new y();
    NPL = g.ah((kotlin.g.a.a)y.d.NQb);
    iBW = g.ah((kotlin.g.a.a)y.h.NQf);
    NPM = g.ah((kotlin.g.a.a)y.j.NQi);
    NPN = g.ah((kotlin.g.a.a)g.NQe);
    AppMethodBeat.o(212601);
  }
  
  private static boolean A(z paramz)
  {
    AppMethodBeat.i(212599);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)gAl().getSlot();
    paramz = "CardRecycleReport" + paramz.field_msgId + '-' + paramz.field_recommendCardId;
    if (localMultiProcessMMKV.decodeBool(paramz, false))
    {
      AppMethodBeat.o(212599);
      return false;
    }
    localMultiProcessMMKV.encode(paramz, true);
    AppMethodBeat.o(212599);
    return true;
  }
  
  public static void Bt(long paramLong)
  {
    AppMethodBeat.i(212600);
    com.tencent.mm.plugin.report.service.h.CyF.n(1534L, paramLong, 1L);
    AppMethodBeat.o(212600);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(212597);
    p.h(paramb, "fromScene");
    com.tencent.f.h.RTc.a((Runnable)new e(paramb), 1000L, "BizRecycleCardLogic");
    AppMethodBeat.o(212597);
  }
  
  public static void a(LinkedList<dli> paramLinkedList, b paramb)
  {
    AppMethodBeat.i(212598);
    p.h(paramLinkedList, "list");
    p.h(paramb, "fromScene");
    if (((Collection)paramLinkedList).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult list is empty");
      AppMethodBeat.o(212598);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    label184:
    Object localObject5;
    if (paramb == b.NPV)
    {
      localObject2 = (Iterable)paramLinkedList;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        localObject4 = (dli)localObject3;
        Log.d("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult flag " + ((dli)localObject4).cSx);
        if (((dli)localObject4).cSx == y.a.NPR.cSx) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label184;
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
        localObject3 = (dli)((Iterator)localObject2).next();
        localObject4 = ag.ban().MM(((dli)localObject3).KVE);
      } while ((localObject4 == null) || (!((z)localObject4).gAu()));
      localObject5 = new dlk();
      localObject1 = ((z)localObject4).gAD();
      if (localObject1 != null) {}
      for (localObject1 = ((ege)localObject1).dSJ;; localObject1 = null)
      {
        ((dlk)localObject5).KUp = ((String)localObject1);
        ((dlk)localObject5).KVE = ((dli)localObject3).KVE;
        ((dlk)localObject5).MPh = ((dli)localObject3).MPh;
        localLinkedList.add(localObject5);
        ag.ban().MX(((dli)localObject3).KVE);
        Log.i("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult ok " + ((z)localObject4).field_msgId);
        Bt(12L);
        break;
      }
    }
    Object localObject1 = ag.ban();
    p.g(localObject1, "SubCoreBiz.getBizTimeLineInfoStorage()");
    Object localObject2 = ((aa)localObject1).gAN();
    Object localObject3 = (MultiProcessMMKV)c.iNQ.getSlot();
    Object localObject4 = (Iterable)paramLinkedList;
    localObject1 = (Collection)new ArrayList();
    localObject4 = ((Iterable)localObject4).iterator();
    dli localdli;
    label510:
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = ((Iterator)localObject4).next();
      localdli = (dli)localObject5;
      Log.d("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult flag " + localdli.cSx);
      if (localdli.cSx == y.a.NPR.cSx) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label510;
        }
        ((Collection)localObject1).add(localObject5);
        break;
      }
    }
    localObject4 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localdli = (dli)((Iterator)localObject4).next();
      localObject5 = ag.ban().MM(localdli.KVE);
      if ((localObject5 != null) && (((z)localObject5).gAu())) {
        if ((((z)localObject5).field_isRead == 1) && (gAm()))
        {
          if (A((z)localObject5))
          {
            Bt(1L);
            localObject1 = s.NPC;
            i = c.NPX.status;
            localObject1 = ((z)localObject5).gAD();
            if (localObject1 != null) {}
            for (localObject1 = ((ege)localObject1).dSJ;; localObject1 = null)
            {
              s.di(i, (String)localObject1);
              Log.i("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult msgIsRead " + ((z)localObject5).field_msgId);
              break;
            }
          }
          Log.d("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult msgIsRead " + ((z)localObject5).field_msgId);
        }
        else if ((((MultiProcessMMKV)localObject3).decodeInt(String.valueOf(((z)localObject5).field_msgId), 0) == 1) && (gAm()))
        {
          if (A((z)localObject5))
          {
            Bt(2L);
            localObject1 = s.NPC;
            i = c.NPY.status;
            localObject1 = ((z)localObject5).gAD();
            if (localObject1 != null) {}
            for (localObject1 = ((ege)localObject1).dSJ;; localObject1 = null)
            {
              s.di(i, (String)localObject1);
              Log.i("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult msg digest IsRead " + ((z)localObject5).field_msgId);
              break;
            }
          }
          Log.d("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult msg digest IsRead " + ((z)localObject5).field_msgId);
        }
        else if ((((z)localObject5).field_msgId == ((z)localObject2).field_msgId) && (gAm()))
        {
          if (A((z)localObject5))
          {
            Bt(3L);
            localObject1 = s.NPC;
            i = c.NPZ.status;
            localObject1 = ((z)localObject5).gAD();
            if (localObject1 != null) {}
            for (localObject1 = ((ege)localObject1).dSJ;; localObject1 = null)
            {
              s.di(i, (String)localObject1);
              Log.i("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult msg is newest card " + ((z)localObject5).field_msgId);
              break;
            }
          }
          Log.d("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult msg is newest card " + ((z)localObject5).field_msgId);
        }
        else
        {
          ag.ban().MX(localdli.KVE);
          Log.i("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult ok " + ((z)localObject5).field_msgId);
          Bt(4L);
          dlk localdlk = new dlk();
          localObject1 = ((z)localObject5).gAD();
          if (localObject1 != null) {}
          for (localObject1 = ((ege)localObject1).dSJ;; localObject1 = null)
          {
            localdlk.KUp = ((String)localObject1);
            localdlk.KVE = localdli.KVE;
            localdlk.MPh = localdli.MPh;
            localLinkedList.add(localdlk);
            localObject1 = ((z)localObject5).gAD();
            if ((localObject1 == null) || (((ege)localObject1).MOD != 2)) {
              break;
            }
            localObject1 = ac.NRc;
            ac.Nd(20L);
            break;
          }
        }
      }
    }
    Log.i("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult recycleReportList fromScene=" + paramb.scene + ", size = " + localLinkedList.size() + '/' + paramLinkedList.size());
    if (((Collection)localLinkedList).isEmpty()) {}
    for (i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(212598);
      return;
    }
    int k = 0;
    i = 0;
    paramLinkedList = ag.ban();
    paramb = ag.ban();
    p.g(paramb, "SubCoreBiz.getBizTimeLineInfoStorage()");
    paramLinkedList = paramLinkedList.MO(paramb.gAS() << 32);
    int m;
    if (paramLinkedList != null)
    {
      paramLinkedList = ((Iterable)paramLinkedList).iterator();
      int j = 0;
      m = j;
      k = i;
      if (paramLinkedList.hasNext())
      {
        paramb = (z)paramLinkedList.next();
        p.g(paramb, "it");
        if (paramb.gAt())
        {
          k = 1;
          label1295:
          if (!paramb.gAu()) {
            break label1324;
          }
        }
        label1324:
        for (m = 1;; m = 0)
        {
          j = m + j;
          i = k + i;
          break;
          k = 0;
          break label1295;
        }
      }
    }
    else
    {
      m = 0;
    }
    paramLinkedList = new d.a();
    paramb = new dll();
    paramb.gCs = localLinkedList;
    paramb.MPj = k;
    paramb.MPk = m;
    paramLinkedList.c((com.tencent.mm.bw.a)paramb);
    paramLinkedList.d((com.tencent.mm.bw.a)new dlm());
    paramLinkedList.MB("/cgi-bin/mmbiz-bin/timeline/recyclecardreport");
    paramLinkedList.sG(4768);
    com.tencent.mm.ak.aa.a(paramLinkedList.aXF(), (aa.a)y.f.NQd);
    AppMethodBeat.o(212598);
  }
  
  public static MultiProcessMMKV aTI()
  {
    AppMethodBeat.i(212595);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)iBW.getValue();
    AppMethodBeat.o(212595);
    return localMultiProcessMMKV;
  }
  
  private static MMKVSlotManager gAl()
  {
    AppMethodBeat.i(212594);
    MMKVSlotManager localMMKVSlotManager = (MMKVSlotManager)NPL.getValue();
    AppMethodBeat.o(212594);
    return localMMKVSlotManager;
  }
  
  private static boolean gAm()
  {
    AppMethodBeat.i(212596);
    boolean bool = ((Boolean)NPN.getValue()).booleanValue();
    AppMethodBeat.o(212596);
    return bool;
  }
  
  public static void gAn()
  {
    NPO = false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/storage/BizRecycleCardLogic$RecycleCardScene;", "", "scene", "", "(Ljava/lang/String;II)V", "getScene", "()I", "RECYCLE_CARD_SCENE_NEW_MSG", "RECYCLE_CARD_SCENE_ENTER_BOX", "RECYCLE_CARD_SCENE_FEEDBACK", "plugin-biz_release"})
  public static enum b
  {
    final int scene;
    
    static
    {
      AppMethodBeat.i(212575);
      b localb1 = new b("RECYCLE_CARD_SCENE_NEW_MSG", 0, 1);
      NPT = localb1;
      b localb2 = new b("RECYCLE_CARD_SCENE_ENTER_BOX", 1, 2);
      NPU = localb2;
      b localb3 = new b("RECYCLE_CARD_SCENE_FEEDBACK", 2, 3);
      NPV = localb3;
      NPW = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(212575);
    }
    
    private b(int paramInt)
    {
      this.scene = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/storage/BizRecycleCardLogic$RecycleCardStatus;", "", "status", "", "(Ljava/lang/String;II)V", "getStatus", "()I", "RECYCLE_CARD_STATUS_CARD_EXPOSURE", "RECYCLE_CARD_STATUS_DIGEST_EXPOSURE", "RECYCLE_CARD_STATUS_NEWEST_CARD", "plugin-biz_release"})
  public static enum c
  {
    final int status;
    
    static
    {
      AppMethodBeat.i(212578);
      c localc1 = new c("RECYCLE_CARD_STATUS_CARD_EXPOSURE", 0, 1);
      NPX = localc1;
      c localc2 = new c("RECYCLE_CARD_STATUS_DIGEST_EXPOSURE", 1, 2);
      NPY = localc2;
      c localc3 = new c("RECYCLE_CARD_STATUS_NEWEST_CARD", 2, 3);
      NPZ = localc3;
      NQa = new c[] { localc1, localc2, localc3 };
      AppMethodBeat.o(212578);
    }
    
    private c(int paramInt)
    {
      this.status = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(y.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(212583);
      y localy = y.NPP;
      y.b(this.NQc);
      AppMethodBeat.o(212583);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    public static final g NQe;
    
    static
    {
      AppMethodBeat.i(212587);
      NQe = new g();
      AppMethodBeat.o(212587);
    }
    
    g()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class i
    implements aa.a
  {
    i(y.b paramb) {}
    
    public final int a(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.d paramd, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(212591);
      paramString = y.NPP;
      y.aTI().encode("RecycleCardLastTime", System.currentTimeMillis() / 1000L);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramString = y.NPP;
        y.gAn();
        AppMethodBeat.o(212591);
        return 0;
      }
      p.g(paramd, "rr");
      paramString = (dlo)paramd.aYK();
      if (paramString == null)
      {
        paramString = y.NPP;
        y.gAn();
        AppMethodBeat.o(212591);
        return 0;
      }
      paramd = y.NPP;
      y.aTI().encode("RecycleCardInterval", paramString.KVL);
      paramd = y.NPP;
      y.aTI().encode("RecycleCardMaxMsgCount", paramString.KUq);
      com.tencent.mm.ac.d.b("BizRecycleCardLogic", (kotlin.g.a.a)new kotlin.g.b.q(paramString) {});
      AppMethodBeat.o(212591);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.y
 * JD-Core Version:    0.7.0.1
 */