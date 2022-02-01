package com.tencent.mm.storage;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.or;
import com.tencent.mm.protocal.protobuf.ot;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.LinkedList;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.aa.e;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/storage/BizTimeLineResortLogic;", "", "()V", "MIN_FORE_GROUND_REQ_TIME", "", "MIN_IN_TIMELINE_REQ_TIME", "MIN_REV_MSG_REQ_TIME", "TAG", "", "clickFirstVisibleItem", "", "getClickFirstVisibleItem", "()I", "setClickFirstVisibleItem", "(I)V", "isBizMsgResort", "", "Ljava/lang/Boolean;", "isBizMsgResortCheckOpen", "()Z", "isBizMsgResortCheckOpen$delegate", "Lkotlin/Lazy;", "isDoingSortBizMsg", "isForeGroundBizMsgResortOpen", "isReceiveMsgResortOpen", "lastExposeOrderFlag", "getLastExposeOrderFlag", "()J", "setLastExposeOrderFlag", "(J)V", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "resortBizMsgRespFlagOpenClickArticle", "resortBizMsgRespFlagOpenClickOftenRead", "resortBizMsgRespFlagOpenEnterTimeline", "sFirstVisibleItem", "getSFirstVisibleItem", "setSFirstVisibleItem", "doReSortCgi", "", "fromScene", "context", "Lcom/tencent/mm/protocal/protobuf/BizMsgReSortContext;", "orderFlag", "getResortBizTimeLineInfo", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "groupId", "item", "Lcom/tencent/mm/protocal/protobuf/BizMsgItem;", "handleReSortResult", "resp", "Lcom/tencent/mm/protocal/protobuf/BizMsgReSortResp;", "maxWeight", "hasScrollNotDoResort", "inTimeLineNotDoResort", "isBizMsgResortOpen", "isInTimeLineResortScene", "markScroll", "onReceiveRecCard", "msgContent", "digestInfo", "Lcom/tencent/mm/protocal/protobuf/DigestInfo;", "reSortBizMsg", "reportBizMsgResortIDKey", "value", "saveConfig", "plugin-biz_release"})
public final class ad
{
  private static boolean VeY;
  private static long VeZ;
  private static Boolean Vfa;
  private static final f Vfb;
  public static Boolean Vfc;
  private static Boolean Vfd;
  public static final ad Vfe;
  private static final f lrB;
  private static int sCk;
  private static int sIr;
  
  static
  {
    AppMethodBeat.i(208564);
    Vfe = new ad();
    lrB = g.ar((a)ad.c.Vfm);
    Vfb = g.ar((a)ad.b.Vfl);
    AppMethodBeat.o(208564);
  }
  
  public static void GP(int paramInt)
  {
    sCk = paramInt;
  }
  
  public static void UP(long paramLong)
  {
    VeZ = paramLong;
  }
  
  public static void a(int paramInt, final or paramor, final long paramLong)
  {
    AppMethodBeat.i(208555);
    com.tencent.e.h.ZvG.d((Runnable)new d(paramInt, paramor, paramLong), "MicroMsg.BizTimeLineResortLogic");
    AppMethodBeat.o(208555);
  }
  
  public static void ast(int paramInt)
  {
    sIr = paramInt;
  }
  
  public static void asu(int paramInt)
  {
    AppMethodBeat.i(208554);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1130L, paramInt, 1L, false);
    AppMethodBeat.o(208554);
  }
  
  private static boolean asv(int paramInt)
  {
    AppMethodBeat.i(208557);
    if ((ab.VeK) && (!asx(paramInt)))
    {
      AppMethodBeat.o(208557);
      return true;
    }
    AppMethodBeat.o(208557);
    return false;
  }
  
  private static boolean asw(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(208558);
    int i;
    if (sCk != sIr)
    {
      i = 1;
      if ((i == 0) || (!asx(paramInt))) {
        break label60;
      }
    }
    for (;;)
    {
      if (bool)
      {
        asu(34);
        Log.i("MicroMsg.BizTimeLineResortLogic", "hasScrollNotDoResort");
      }
      AppMethodBeat.o(208558);
      return bool;
      i = 0;
      break;
      label60:
      bool = false;
    }
  }
  
  public static boolean asx(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 4) || (paramInt == 5);
  }
  
  public static MultiProcessMMKV bcJ()
  {
    AppMethodBeat.i(208549);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)lrB.getValue();
    AppMethodBeat.o(208549);
    return localMultiProcessMMKV;
  }
  
  public static int hxs()
  {
    return sCk;
  }
  
  public static boolean hxt()
  {
    AppMethodBeat.i(208550);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger()))
    {
      AppMethodBeat.o(208550);
      return true;
    }
    Boolean localBoolean;
    if (Vfa != null)
    {
      localBoolean = Vfa;
      if (localBoolean == null) {
        p.iCn();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(208550);
      return bool;
    }
    if (((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vAs, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Vfa = Boolean.valueOf(bool);
      Log.i("MicroMsg.BizTimeLineResortLogic", "isBizMsgResortOpen open %b", new Object[] { Vfa });
      localBoolean = Vfa;
      if (localBoolean == null) {
        p.iCn();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(208550);
      return bool;
    }
  }
  
  private static boolean hxu()
  {
    AppMethodBeat.i(208552);
    boolean bool = ((Boolean)Vfb.getValue()).booleanValue();
    AppMethodBeat.o(208552);
    return bool;
  }
  
  public static boolean hxv()
  {
    AppMethodBeat.i(208553);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger()))
    {
      AppMethodBeat.o(208553);
      return true;
    }
    if (!hxt())
    {
      AppMethodBeat.o(208553);
      return false;
    }
    Boolean localBoolean;
    if (Vfd != null)
    {
      localBoolean = Vfd;
      if (localBoolean == null) {
        p.iCn();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(208553);
      return bool;
    }
    if (((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vAu, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Vfd = Boolean.valueOf(bool);
      Log.i("MicroMsg.BizTimeLineResortLogic", "isReceiveMsgResortOpen open %b", new Object[] { Vfd });
      localBoolean = Vfd;
      if (localBoolean == null) {
        p.iCn();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(208553);
      return bool;
    }
  }
  
  public static boolean hxw()
  {
    return VeY;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class a
    implements aa.a
  {
    a(ot paramot, LinkedList paramLinkedList, int paramInt, aa.e parame, or paramor) {}
    
    public final int a(int paramInt1, int paramInt2, final String paramString, d paramd, q paramq)
    {
      int i = 2;
      AppMethodBeat.i(205426);
      Log.i("MicroMsg.BizTimeLineResortLogic", "doReSortCgi CGI callback errType=%d, errCode=%d, bitFlag=%d, digest_bold_cnt=" + this.Vff.RWU + ", digest_expose_cnt=" + this.Vff.RWV + ", size=" + this.Vfg.size(), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.Vff.RWT) });
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramString = ad.Vfe;
        paramString = ad.Vfe;
        paramInt1 = i;
        if (ad.asx(this.swd)) {
          paramInt1 = 62;
        }
        ad.asu(paramInt1);
        paramString = ad.Vfe;
        ad.hxx();
        AppMethodBeat.o(205426);
        return 0;
      }
      paramString = ad.Vfe;
      paramString = ad.Vfe;
      if (ad.asx(this.swd)) {}
      for (paramInt1 = 61;; paramInt1 = 1)
      {
        ad.asu(paramInt1);
        p.j(paramd, "rr");
        paramString = paramd.bhY();
        if (paramString != null) {
          break;
        }
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizMsgReSortResp");
        AppMethodBeat.o(205426);
        throw paramString;
      }
      paramString = (ou)paramString;
      paramd = ad.Vfe;
      ad.a(this.swd, paramString);
      com.tencent.e.h.ZvG.d((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(205908);
          Object localObject = ad.Vfe;
          localObject = paramString;
          int j = this.Vfj.swd;
          long l = this.Vfj.Vfh.aaBB;
          or localor = this.Vfj.Vfi;
          if (localor != null) {}
          for (int i = localor.RWP;; i = 0)
          {
            ad.a((ou)localObject, j, l, i);
            localObject = ad.Vfe;
            ad.hxx();
            AppMethodBeat.o(205908);
            return;
          }
        }
      }, "MicroMsg.BizTimeLineResortLogic");
      AppMethodBeat.o(205426);
      return 0;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(int paramInt, or paramor, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(205765);
      ad localad = ad.Vfe;
      ad.b(this.swd, paramor, paramLong);
      AppMethodBeat.o(205765);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.storage.ad
 * JD-Core Version:    0.7.0.1
 */