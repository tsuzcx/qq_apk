package com.tencent.mm.plugin.webview.ui.tools.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.y;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.g.b.a.cn;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.eo;
import com.tencent.mm.protocal.protobuf.ep;
import com.tencent.mm.protocal.protobuf.eq;
import com.tencent.mm.protocal.protobuf.er;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport;", "", "()V", "_realPlayTime", "", "get_realPlayTime", "()J", "set_realPlayTime", "(J)V", "endPlayTime", "", "getEndPlayTime", "()I", "setEndPlayTime", "(I)V", "isFans", "", "()Z", "setFans", "(Z)V", "lastOpType", "playErrType", "", "getPlayErrType", "()Ljava/lang/String;", "setPlayErrType", "(Ljava/lang/String;)V", "playStatus", "getPlayStatus", "setPlayStatus", "realPlayTime", "getRealPlayTime", "setRealPlayTime", "scene", "getScene", "setScene", "startPlayTime", "getStartPlayTime", "setStartPlayTime", "stayTimeInPage", "getStayTimeInPage", "setStayTimeInPage", "subScene", "getSubScene", "setSubScene", "doPlayReport", "", "doStopReport", "getPlayType", "report17149", "videoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "opType", "enterId", "itemShowType", "Companion", "KV17149OpType", "PlayStatus", "plugin-webview_release"})
public class g
{
  public static final a CLj;
  private static final String TAG = "MicroMsg.MpVideoShareReport";
  private int CLi;
  public int hYu;
  private long hto;
  protected int nLC;
  protected int nOV;
  protected int nOW;
  public String nOX;
  protected boolean nOY;
  private long rxY;
  protected int scene;
  
  static
  {
    AppMethodBeat.i(82685);
    CLj = new a((byte)0);
    TAG = "MicroMsg.MpVideoShareReport";
    AppMethodBeat.o(82685);
  }
  
  public g()
  {
    AppMethodBeat.i(82684);
    this.hto = System.currentTimeMillis();
    this.nOX = "";
    AppMethodBeat.o(82684);
  }
  
  public final void a(y paramy, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82683);
    if (paramy == null)
    {
      AppMethodBeat.o(82683);
      return;
    }
    if (this.CLi == paramInt1)
    {
      AppMethodBeat.o(82683);
      return;
    }
    this.CLi = paramInt1;
    paramy.aws();
    String str1;
    String str2;
    label132:
    long l;
    switch (paramInt1)
    {
    case 5: 
    case 6: 
    default: 
      if (paramInt1 == 3)
      {
        str1 = paramy.DWG;
        k.g(str1, "videoInfo.videoVid");
        str2 = paramy.DWF;
        k.g(str2, "videoInfo.mpUrl");
        a.b(0, str1, str2, this.nLC, paramInt2);
        int j = m.Yu();
        int i = j;
        if (j == 100) {
          i = -1;
        }
        paramy = new cn().kx(paramy.ddo).hM(paramInt1).ky(paramy.DWG).im(i).hI(paramy.hlF).hJ(paramy.idx).hK(paramInt2).hL(paramy.videoDuration).hR(this.scene).hS(this.nLC).hV(paramy.width).hU(paramy.height).QQ();
        if ((this.rxY == 0L) && (this.hto != 0L)) {
          this.rxY = (System.currentTimeMillis() - this.hto);
        }
        paramy = paramy.hO(this.rxY).hQ(this.nOW).hN(System.currentTimeMillis() / 1000L).hP(this.nOV).kz(this.nOX).QO();
        if (!this.nOY) {
          break label525;
        }
        l = 1L;
        label331:
        paramy.hT(l).QP().aHZ();
        ac.d(TAG, "eventType: ".concat(String.valueOf(paramInt1)));
        switch (paramInt1)
        {
        }
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(82683);
      return;
      this.hto = System.currentTimeMillis();
      break;
      l = System.currentTimeMillis();
      this.rxY += l - this.hto;
      this.hto = l;
      break;
      if (paramInt1 == 4)
      {
        str1 = paramy.DWG;
        k.g(str1, "videoInfo.videoVid");
        str2 = paramy.DWF;
        k.g(str2, "videoInfo.mpUrl");
        a.b(1, str1, str2, this.nLC, paramInt2);
        break label132;
      }
      if (paramInt1 != 10) {
        break label132;
      }
      str1 = paramy.DWG;
      k.g(str1, "videoInfo.videoVid");
      str2 = paramy.DWF;
      k.g(str2, "videoInfo.mpUrl");
      a.b(2, str1, str2, this.nLC, paramInt2);
      break label132;
      label525:
      l = 0L;
      break label331;
      this.rxY = 0L;
      this.hto = System.currentTimeMillis();
      this.nOW = 0;
    }
  }
  
  public final int eGg()
  {
    switch (this.hYu)
    {
    case 0: 
    default: 
      return 3;
    case 1: 
      return 4;
    case 2: 
      return 8;
    case 3: 
      return 9;
    }
    return 10;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport$Companion;", "", "()V", "ACTION_TYPE_FRIEND", "", "REPORT_TYPE_10380", "REPORT_TYPE_10945", "REPORT_TYPE_17537", "SHARE_TYPE_MP_VIDEO", "TAG", "", "addCommReportItem", "", "key", "value", "items", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommReportItem;", "doAppMsgCommDataReport", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReportReq;", "logReportData", "kv", "report10380", "actionType", "sharePageType", "vid", "url", "timeLineSessionId", "enterId", "report17537", "eventType", "scene", "subScene", "plugin-webview_release"})
  public static final class a
  {
    private static void a(ep paramep)
    {
      AppMethodBeat.i(82678);
      b.a locala = new b.a();
      locala.c((a)paramep);
      locala.d((a)new eq());
      locala.Am("/cgi-bin/mmbiz-bin/appmsg/appmsg_report");
      locala.op(1870);
      locala.or(0);
      locala.os(0);
      IPCRunCgi.a(locala.aAz(), (IPCRunCgi.a)a.CLk);
      AppMethodBeat.o(82678);
    }
    
    private static void a(String paramString1, String paramString2, LinkedList<er> paramLinkedList)
    {
      AppMethodBeat.i(82682);
      er localer = new er();
      localer.key = paramString1;
      localer.hpH = paramString2;
      paramLinkedList.add(localer);
      AppMethodBeat.o(82682);
    }
    
    public static void ad(String paramString1, String paramString2, int paramInt)
    {
      AppMethodBeat.i(82679);
      k.h(paramString1, "vid");
      k.h(paramString2, "url");
      ep localep = new ep();
      eo localeo = new eo();
      localeo.type = 2;
      LinkedList localLinkedList = localeo.DNM;
      k.g(localLinkedList, "reportData.item");
      a("Vid", paramString1, localLinkedList);
      paramString1 = ax.iH(ai.getContext());
      localLinkedList = localeo.DNM;
      k.g(localLinkedList, "reportData.item");
      a("Network", paramString1, localLinkedList);
      paramString1 = localeo.DNM;
      k.g(paramString1, "reportData.item");
      a("SharePageType", "101", paramString1);
      paramString1 = localeo.DNM;
      k.g(paramString1, "reportData.item");
      a("ContentUrl", paramString2, paramString1);
      paramString1 = localeo.DNM;
      k.g(paramString1, "reportData.item");
      a("#AppMsgUrl#", paramString2, paramString1);
      paramString1 = localeo.DNM;
      k.g(paramString1, "reportData.item");
      a("ActionType", "1", paramString1);
      paramString1 = localeo.DNM;
      k.g(paramString1, "reportData.item");
      a("SessionId", "0", paramString1);
      paramString1 = localeo.DNM;
      k.g(paramString1, "reportData.item");
      a("EnterId", String.valueOf(paramInt), paramString1);
      localep.DRi.add(localeo);
      a(localep);
      paramString1 = localeo.DNM;
      k.g(paramString1, "reportData.item");
      b(10380, paramString1);
      AppMethodBeat.o(82679);
    }
    
    public static void b(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(82680);
      k.h(paramString1, "vid");
      k.h(paramString2, "url");
      ep localep = new ep();
      eo localeo = new eo();
      localeo.type = 3;
      LinkedList localLinkedList = localeo.DNM;
      k.g(localLinkedList, "reportData.item");
      a("#AppMsgUrl#", paramString2, localLinkedList);
      paramString2 = localeo.DNM;
      k.g(paramString2, "reportData.item");
      a("VideoId", paramString1, paramString2);
      paramString1 = localeo.DNM;
      k.g(paramString1, "reportData.item");
      a("Scene", "141", paramString1);
      paramString1 = localeo.DNM;
      k.g(paramString1, "reportData.item");
      a("SubScene", String.valueOf(paramInt2), paramString1);
      long l = System.currentTimeMillis();
      paramString1 = localeo.DNM;
      k.g(paramString1, "reportData.item");
      a("ClientId", String.valueOf(l), paramString1);
      paramString1 = localeo.DNM;
      k.g(paramString1, "reportData.item");
      a("SessionId", "0", paramString1);
      paramString1 = localeo.DNM;
      k.g(paramString1, "reportData.item");
      a("EnterId", String.valueOf(paramInt3), paramString1);
      paramString1 = localeo.DNM;
      k.g(paramString1, "reportData.item");
      a("EventType", String.valueOf(paramInt1), paramString1);
      localep.DRi.add(localeo);
      a(localep);
      paramString1 = localeo.DNM;
      k.g(paramString1, "reportData.item");
      b(17537, paramString1);
      AppMethodBeat.o(82680);
    }
    
    private static void b(int paramInt, LinkedList<er> paramLinkedList)
    {
      AppMethodBeat.i(82681);
      if ((ac.getLogLevel() <= 0) && (!bs.gY((List)paramLinkedList)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        paramLinkedList = paramLinkedList.iterator();
        while (paramLinkedList.hasNext())
        {
          er localer = (er)paramLinkedList.next();
          localStringBuilder.append(localer.key).append(":").append(localer.hpH).append("  ");
        }
        ac.v(g.access$getTAG$cp(), paramInt + ", " + localStringBuilder);
      }
      AppMethodBeat.o(82681);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
    static final class a
      implements IPCRunCgi.a
    {
      public static final a CLk;
      
      static
      {
        AppMethodBeat.i(82677);
        CLk = new a();
        AppMethodBeat.o(82677);
      }
      
      public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
      {
        AppMethodBeat.i(82676);
        ac.i(g.access$getTAG$cp(), "appmsg_report errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
        AppMethodBeat.o(82676);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.g
 * JD-Core Version:    0.7.0.1
 */