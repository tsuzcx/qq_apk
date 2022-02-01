package com.tencent.mm.storage;

import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.ox;
import com.tencent.mm.protocal.protobuf.oy;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.LinkedList;
import kotlin.f;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/storage/BizTimeLineResortLogic;", "", "()V", "TAG", "", "isBizMsgResort", "", "Ljava/lang/Boolean;", "isBizMsgResortCheckOpen", "()Z", "isBizMsgResortCheckOpen$delegate", "Lkotlin/Lazy;", "isBizMsgResortNew", "isDoingSortBizMsg", "isForeGroundBizMsgResortOpen", "isReceiveMsgResortOpen", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "doReSortCgi", "", "fromScene", "", "getResortBizTimeLineInfo", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "groupId", "", "item", "Lcom/tencent/mm/protocal/protobuf/BizMsgItem;", "handleReSortResult", "resp", "Lcom/tencent/mm/protocal/protobuf/BizMsgReSortResp;", "isBizMsgResortNewOpen", "isBizMsgResortOpen", "onReceiveRecCard", "msgContent", "digestInfo", "Lcom/tencent/mm/protocal/protobuf/DigestInfo;", "reSortBizMsg", "reportBizMsgResortIDKey", "value", "saveConfig", "plugin-biz_release"})
public final class ad
{
  private static boolean NRh;
  private static Boolean NRi;
  private static Boolean NRj;
  private static final f NRk;
  public static Boolean NRl;
  private static Boolean NRm;
  public static final ad NRn;
  private static final f iBW;
  
  static
  {
    AppMethodBeat.i(212631);
    NRn = new ad();
    iBW = kotlin.g.ah((a)ad.c.NRs);
    NRk = kotlin.g.ah((a)b.NRr);
    AppMethodBeat.o(212631);
  }
  
  public static MultiProcessMMKV aTI()
  {
    AppMethodBeat.i(212625);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)iBW.getValue();
    AppMethodBeat.o(212625);
    return localMultiProcessMMKV;
  }
  
  public static void ajZ(int paramInt)
  {
    AppMethodBeat.i(212629);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1130L, paramInt, 1L, false);
    AppMethodBeat.o(212629);
  }
  
  public static void aka(int paramInt)
  {
    AppMethodBeat.i(212630);
    com.tencent.f.h.RTc.b((Runnable)new d(paramInt), "MicroMsg.BizTimeLineResortLogic");
    AppMethodBeat.o(212630);
  }
  
  public static boolean gBi()
  {
    AppMethodBeat.i(212626);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger()))
    {
      AppMethodBeat.o(212626);
      return true;
    }
    if (!ab.clc())
    {
      AppMethodBeat.o(212626);
      return false;
    }
    Boolean localBoolean;
    if (NRi != null)
    {
      localBoolean = NRi;
      if (localBoolean == null) {
        p.hyc();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(212626);
      return bool;
    }
    if (((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.rTL, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      NRi = Boolean.valueOf(bool);
      Log.i("MicroMsg.BizTimeLineResortLogic", "isBizMsgResortOpen open %b", new Object[] { NRi });
      localBoolean = NRi;
      if (localBoolean == null) {
        p.hyc();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(212626);
      return bool;
    }
  }
  
  private static boolean gBj()
  {
    AppMethodBeat.i(212627);
    boolean bool = ((Boolean)NRk.getValue()).booleanValue();
    AppMethodBeat.o(212627);
    return bool;
  }
  
  public static boolean gBk()
  {
    AppMethodBeat.i(212628);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger()))
    {
      AppMethodBeat.o(212628);
      return true;
    }
    if (!gBi())
    {
      AppMethodBeat.o(212628);
      return false;
    }
    Boolean localBoolean;
    if (NRm != null)
    {
      localBoolean = NRm;
      if (localBoolean == null) {
        p.hyc();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(212628);
      return bool;
    }
    if (((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.rTN, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      NRm = Boolean.valueOf(bool);
      Log.i("MicroMsg.BizTimeLineResortLogic", "isReceiveMsgResortOpen open %b", new Object[] { NRm });
      localBoolean = NRm;
      if (localBoolean == null) {
        p.hyc();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(212628);
      return bool;
    }
  }
  
  public static boolean gBl()
  {
    return NRh;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class a
    implements aa.a
  {
    a(ox paramox, LinkedList paramLinkedList, int paramInt) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, d paramd, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(212619);
      Log.i("MicroMsg.BizTimeLineResortLogic", "doReSortCgi CGI callback errType=%d, errCode=%d, bitFlag=%d, digest_bold_cnt=" + this.NRo.KVJ + ", digest_expose_cnt=" + this.NRo.KVK + ", size=" + this.NRp.size(), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.NRo.KVI) });
      paramString = ad.NRn;
      ad.aTI().encode("ReSortBizMsgLastTime", System.currentTimeMillis() / 1000L);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramString = ad.NRn;
        ad.ajZ(2);
        paramString = ad.NRn;
        ad.gBm();
        AppMethodBeat.o(212619);
        return 0;
      }
      paramString = ad.NRn;
      ad.ajZ(1);
      p.g(paramd, "rr");
      paramString = paramd.aYK();
      if (paramString == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizMsgReSortResp");
        AppMethodBeat.o(212619);
        throw paramString;
      }
      paramString = (oy)paramString;
      paramd = ad.NRn;
      ad.a(this.pnf, paramString);
      com.tencent.f.h.RTc.b((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(212618);
          ad localad = ad.NRn;
          ad.a(this.NRq);
          localad = ad.NRn;
          ad.gBm();
          AppMethodBeat.o(212618);
        }
      }, "MicroMsg.BizTimeLineResortLogic");
      AppMethodBeat.o(212619);
      return 0;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements a<Boolean>
  {
    public static final b NRr;
    
    static
    {
      AppMethodBeat.i(212621);
      NRr = new b();
      AppMethodBeat.o(212621);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(212624);
      ad localad = ad.NRn;
      ad.akb(this.pnf);
      AppMethodBeat.o(212624);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.ad
 * JD-Core Version:    0.7.0.1
 */