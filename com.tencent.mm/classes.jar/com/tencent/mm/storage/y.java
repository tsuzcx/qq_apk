package com.tencent.mm.storage;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.c;
import com.tencent.mm.protocal.protobuf.dva;
import com.tencent.mm.protocal.protobuf.dvc;
import com.tencent.mm.protocal.protobuf.dvd;
import com.tencent.mm.protocal.protobuf.dve;
import com.tencent.mm.protocal.protobuf.dvg;
import com.tencent.mm.protocal.protobuf.eqg;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/storage/BizRecycleCardLogic;", "", "()V", "DEFAULT_INTERVAL", "", "MAX_KEEP_DIGEST_TIME", "TAG", "", "cardRecycleSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getCardRecycleSlot", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "cardRecycleSlot$delegate", "Lkotlin/Lazy;", "isRecycleCard", "", "()Z", "setRecycleCard", "(Z)V", "isRecycleCardCheckOpen", "isRecycleCardCheckOpen$delegate", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "recycleCardOpen", "getRecycleCardOpen", "recycleCardOpen$delegate", "checkRecycleReportStatus", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "doRecycleCard", "", "fromScene", "Lcom/tencent/mm/storage/BizRecycleCardLogic$RecycleCardScene;", "handleRecycleCardResult", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecycleCard;", "isDigestExposed", "recycleCard", "reportIdKey", "key", "RecycleCardFlag", "RecycleCardScene", "RecycleCardStatus", "plugin-biz_release"})
public final class y
{
  private static final f VdD;
  private static final f VdE;
  private static final f VdF;
  private static boolean VdG;
  public static final y VdH;
  private static final f lrB;
  
  static
  {
    AppMethodBeat.i(205707);
    VdH = new y();
    VdD = g.ar((kotlin.g.a.a)y.d.VdT);
    lrB = g.ar((kotlin.g.a.a)y.h.VdX);
    VdE = g.ar((kotlin.g.a.a)y.j.Vea);
    VdF = g.ar((kotlin.g.a.a)g.VdW);
    AppMethodBeat.o(205707);
  }
  
  private static boolean D(z paramz)
  {
    AppMethodBeat.i(205702);
    paramz = "CardRecycleReport" + paramz.field_msgId + '-' + paramz.field_recommendCardId;
    if (hws().decodeBool(paramz, false))
    {
      AppMethodBeat.o(205702);
      return false;
    }
    ((MultiProcessMMKV)hws().getSlotForWrite()).encode(paramz, true);
    AppMethodBeat.o(205702);
    return true;
  }
  
  private static boolean E(z paramz)
  {
    AppMethodBeat.i(205703);
    if (System.currentTimeMillis() - paramz.field_createTime > 172800000L)
    {
      AppMethodBeat.o(205703);
      return false;
    }
    if (c.lEh.decodeInt(String.valueOf(paramz.field_msgId), 0) == 1)
    {
      AppMethodBeat.o(205703);
      return true;
    }
    AppMethodBeat.o(205703);
    return false;
  }
  
  public static void HG(long paramLong)
  {
    AppMethodBeat.i(205705);
    com.tencent.mm.plugin.report.service.h.IzE.p(1534L, paramLong, 1L);
    AppMethodBeat.o(205705);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(205699);
    p.k(paramb, "fromScene");
    com.tencent.e.h.ZvG.a((Runnable)new e(paramb), 1000L, "BizRecycleCardLogic");
    AppMethodBeat.o(205699);
  }
  
  public static void a(LinkedList<dva> paramLinkedList, b paramb)
  {
    AppMethodBeat.i(205701);
    p.k(paramLinkedList, "list");
    p.k(paramb, "fromScene");
    if (((Collection)paramLinkedList).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult list is empty");
      AppMethodBeat.o(205701);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject4;
    label190:
    Object localObject5;
    if (paramb == b.VdN)
    {
      localObject2 = (Iterable)paramLinkedList;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        localObject4 = (dva)localObject3;
        Log.d("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult flag " + ((dva)localObject4).cUP);
        if (((dva)localObject4).cUP == y.a.VdJ.cUP) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label190;
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
        localObject3 = (dva)((Iterator)localObject2).next();
        localObject4 = af.bjB().Uw(((dva)localObject3).RWK);
      } while ((localObject4 == null) || (!((z)localObject4).hwB()));
      localObject5 = new dvc();
      localObject1 = ((z)localObject4).hwL();
      if (localObject1 != null) {}
      for (localObject1 = ((eqg)localObject1).fMh;; localObject1 = null)
      {
        ((dvc)localObject5).zaX = ((String)localObject1);
        ((dvc)localObject5).RWK = ((dva)localObject3).RWK;
        ((dvc)localObject5).SRj = ((dva)localObject3).SRj;
        localLinkedList.add(localObject5);
        af.bjB().UI(((dva)localObject3).RWK);
        Log.i("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult ok " + ((z)localObject4).field_msgId);
        HG(12L);
        break;
      }
    }
    Object localObject1 = af.bjB();
    p.j(localObject1, "SubCoreBiz.getBizTimeLineInfoStorage()");
    Object localObject2 = ((aa)localObject1).hwV();
    Object localObject3 = (Iterable)paramLinkedList;
    localObject1 = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject3).iterator();
    label507:
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((Iterator)localObject3).next();
      localObject5 = (dva)localObject4;
      Log.d("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult flag " + ((dva)localObject5).cUP);
      if (((dva)localObject5).cUP == y.a.VdJ.cUP) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label507;
        }
        ((Collection)localObject1).add(localObject4);
        break;
      }
    }
    localObject3 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject5 = (dva)((Iterator)localObject3).next();
      localObject4 = af.bjB().Uw(((dva)localObject5).RWK);
      if ((localObject4 != null) && (((z)localObject4).hwB())) {
        if ((((z)localObject4).field_isRead == 1) && (hwt()))
        {
          if (D((z)localObject4))
          {
            HG(1L);
            localObject1 = s.Vdo;
            i = c.VdP.status;
            localObject1 = ((z)localObject4).hwL();
            if (localObject1 != null) {}
            for (localObject1 = ((eqg)localObject1).fMh;; localObject1 = null)
            {
              s.dh(i, (String)localObject1);
              Log.i("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult msgIsRead " + ((z)localObject4).field_msgId);
              break;
            }
          }
          Log.d("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult msgIsRead " + ((z)localObject4).field_msgId);
        }
        else if ((E((z)localObject4)) && (hwt()))
        {
          if (D((z)localObject4))
          {
            HG(2L);
            localObject1 = s.Vdo;
            i = c.VdQ.status;
            localObject1 = ((z)localObject4).hwL();
            if (localObject1 != null) {}
            for (localObject1 = ((eqg)localObject1).fMh;; localObject1 = null)
            {
              s.dh(i, (String)localObject1);
              Log.i("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult msg digest IsRead " + ((z)localObject4).field_msgId);
              break;
            }
          }
          Log.d("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult msg digest IsRead " + ((z)localObject4).field_msgId);
        }
        else if ((((z)localObject4).field_msgId == ((z)localObject2).field_msgId) && (hwt()))
        {
          if (D((z)localObject4))
          {
            HG(3L);
            localObject1 = s.Vdo;
            i = c.VdR.status;
            localObject1 = ((z)localObject4).hwL();
            if (localObject1 != null) {}
            for (localObject1 = ((eqg)localObject1).fMh;; localObject1 = null)
            {
              s.dh(i, (String)localObject1);
              Log.i("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult msg is newest card " + ((z)localObject4).field_msgId);
              break;
            }
          }
          Log.d("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult msg is newest card " + ((z)localObject4).field_msgId);
        }
        else
        {
          af.bjB().UI(((dva)localObject5).RWK);
          Log.i("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult ok " + ((z)localObject4).field_msgId);
          HG(4L);
          dvc localdvc = new dvc();
          localObject1 = ((z)localObject4).hwL();
          if (localObject1 != null) {}
          for (localObject1 = ((eqg)localObject1).fMh;; localObject1 = null)
          {
            localdvc.zaX = ((String)localObject1);
            localdvc.RWK = ((dva)localObject5).RWK;
            localdvc.SRj = ((dva)localObject5).SRj;
            localLinkedList.add(localdvc);
            localObject1 = ((z)localObject4).hwL();
            if ((localObject1 == null) || (((eqg)localObject1).Uax != 2)) {
              break;
            }
            localObject1 = ac.VeT;
            ac.UO(20L);
            break;
          }
        }
      }
    }
    Log.i("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult recycleReportList fromScene=" + paramb.scene + ", size = " + localLinkedList.size() + '/' + paramLinkedList.size());
    if (((Collection)localLinkedList).isEmpty()) {}
    for (i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(205701);
      return;
    }
    int k = 0;
    int j = 0;
    int m = 0;
    i = 0;
    paramLinkedList = af.bjB();
    paramb = af.bjB();
    p.j(paramb, "SubCoreBiz.getBizTimeLineInfoStorage()");
    paramLinkedList = paramLinkedList.Uy(paramb.hxb() << 32);
    if (paramLinkedList != null)
    {
      paramLinkedList = ((Iterable)paramLinkedList).iterator();
      k = j;
      m = i;
      if (paramLinkedList.hasNext())
      {
        paramb = (z)paramLinkedList.next();
        p.j(paramb, "it");
        if (paramb.hwA())
        {
          k = 1;
          label1294:
          k = j + k;
          if (!paramb.hwB()) {
            break label1325;
          }
        }
        label1325:
        for (j = 1;; j = 0)
        {
          i = j + i;
          j = k;
          break;
          k = 0;
          break label1294;
        }
      }
    }
    paramLinkedList = new d.a();
    paramb = new dvd();
    paramb.jmy = localLinkedList;
    paramb.Ubk = k;
    paramb.Ubl = m;
    paramLinkedList.c((com.tencent.mm.cd.a)paramb);
    paramLinkedList.d((com.tencent.mm.cd.a)new dve());
    paramLinkedList.TW("/cgi-bin/mmbiz-bin/timeline/recyclecardreport");
    paramLinkedList.vD(4768);
    com.tencent.mm.an.aa.a(paramLinkedList.bgN(), (aa.a)y.f.VdV);
    AppMethodBeat.o(205701);
  }
  
  public static MultiProcessMMKV bcJ()
  {
    AppMethodBeat.i(205697);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)lrB.getValue();
    AppMethodBeat.o(205697);
    return localMultiProcessMMKV;
  }
  
  private static MMKVSlotManager hws()
  {
    AppMethodBeat.i(205696);
    MMKVSlotManager localMMKVSlotManager = (MMKVSlotManager)VdD.getValue();
    AppMethodBeat.o(205696);
    return localMMKVSlotManager;
  }
  
  private static boolean hwt()
  {
    AppMethodBeat.i(205698);
    boolean bool = ((Boolean)VdF.getValue()).booleanValue();
    AppMethodBeat.o(205698);
    return bool;
  }
  
  public static void hwu()
  {
    VdG = false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/storage/BizRecycleCardLogic$RecycleCardScene;", "", "scene", "", "(Ljava/lang/String;II)V", "getScene", "()I", "RECYCLE_CARD_SCENE_NEW_MSG", "RECYCLE_CARD_SCENE_ENTER_BOX", "RECYCLE_CARD_SCENE_FEEDBACK", "plugin-biz_release"})
  public static enum b
  {
    final int scene;
    
    static
    {
      AppMethodBeat.i(205794);
      b localb1 = new b("RECYCLE_CARD_SCENE_NEW_MSG", 0, 1);
      VdL = localb1;
      b localb2 = new b("RECYCLE_CARD_SCENE_ENTER_BOX", 1, 2);
      VdM = localb2;
      b localb3 = new b("RECYCLE_CARD_SCENE_FEEDBACK", 2, 3);
      VdN = localb3;
      VdO = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(205794);
    }
    
    private b(int paramInt)
    {
      this.scene = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/storage/BizRecycleCardLogic$RecycleCardStatus;", "", "status", "", "(Ljava/lang/String;II)V", "getStatus", "()I", "RECYCLE_CARD_STATUS_CARD_EXPOSURE", "RECYCLE_CARD_STATUS_DIGEST_EXPOSURE", "RECYCLE_CARD_STATUS_NEWEST_CARD", "plugin-biz_release"})
  public static enum c
  {
    final int status;
    
    static
    {
      AppMethodBeat.i(210758);
      c localc1 = new c("RECYCLE_CARD_STATUS_CARD_EXPOSURE", 0, 1);
      VdP = localc1;
      c localc2 = new c("RECYCLE_CARD_STATUS_DIGEST_EXPOSURE", 1, 2);
      VdQ = localc2;
      c localc3 = new c("RECYCLE_CARD_STATUS_NEWEST_CARD", 2, 3);
      VdR = localc3;
      VdS = new c[] { localc1, localc2, localc3 };
      AppMethodBeat.o(210758);
    }
    
    private c(int paramInt)
    {
      this.status = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(y.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(205210);
      y localy = y.VdH;
      y.b(this.VdU);
      AppMethodBeat.o(205210);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    public static final g VdW;
    
    static
    {
      AppMethodBeat.i(206312);
      VdW = new g();
      AppMethodBeat.o(206312);
    }
    
    g()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class i
    implements aa.a
  {
    i(y.b paramb) {}
    
    public final int a(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.an.d paramd, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(205422);
      paramString = y.VdH;
      y.bcJ().encode("RecycleCardLastTime", System.currentTimeMillis() / 1000L);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramString = y.VdH;
        y.hwu();
        AppMethodBeat.o(205422);
        return 0;
      }
      p.j(paramd, "rr");
      paramString = (dvg)paramd.bhY();
      if (paramString == null)
      {
        paramString = y.VdH;
        y.hwu();
        AppMethodBeat.o(205422);
        return 0;
      }
      paramd = y.VdH;
      y.bcJ().encode("RecycleCardInterval", paramString.RWY);
      paramd = y.VdH;
      y.bcJ().encode("RecycleCardMaxMsgCount", paramString.RVn);
      com.tencent.mm.ae.d.b("BizRecycleCardLogic", (kotlin.g.a.a)new kotlin.g.b.q(paramString) {});
      AppMethodBeat.o(205422);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.y
 * JD-Core Version:    0.7.0.1
 */