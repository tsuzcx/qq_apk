package com.tencent.mm.plugin.webview.ui.tools.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.y;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.g.b.a.bb;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.em;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.protocal.protobuf.eo;
import com.tencent.mm.protocal.protobuf.ep;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport;", "", "()V", "_realPlayTime", "", "get_realPlayTime", "()J", "set_realPlayTime", "(J)V", "endPlayTime", "", "getEndPlayTime", "()I", "setEndPlayTime", "(I)V", "isFans", "", "()Z", "setFans", "(Z)V", "lastOpType", "playErrType", "", "getPlayErrType", "()Ljava/lang/String;", "setPlayErrType", "(Ljava/lang/String;)V", "playStatus", "getPlayStatus", "setPlayStatus", "realPlayTime", "getRealPlayTime", "setRealPlayTime", "scene", "getScene", "setScene", "startPlayTime", "getStartPlayTime", "setStartPlayTime", "stayTimeInPage", "getStayTimeInPage", "setStayTimeInPage", "subScene", "getSubScene", "setSubScene", "doPlayReport", "", "doStopReport", "getPlayType", "report17149", "videoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "opType", "enterId", "itemShowType", "Companion", "KV17149OpType", "PlayStatus", "plugin-webview_release"})
public class g
{
  public static final a Btd;
  private static final String TAG = "MicroMsg.MpVideoShareReport";
  private int Btc;
  private long gSP;
  public int hxT;
  protected int niJ;
  protected int nlV;
  protected int nlW;
  public String nlX;
  protected boolean nlY;
  private long qGR;
  protected int scene;
  
  static
  {
    AppMethodBeat.i(82685);
    Btd = new a((byte)0);
    TAG = "MicroMsg.MpVideoShareReport";
    AppMethodBeat.o(82685);
  }
  
  public g()
  {
    AppMethodBeat.i(82684);
    this.gSP = System.currentTimeMillis();
    this.nlX = "";
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
    if (this.Btc == paramInt1)
    {
      AppMethodBeat.o(82683);
      return;
    }
    this.Btc = paramInt1;
    paramy.apD();
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
        str1 = paramy.CEg;
        k.g(str1, "videoInfo.videoVid");
        str2 = paramy.CEf;
        k.g(str2, "videoInfo.mpUrl");
        a.b(0, str1, str2, this.niJ, paramInt2);
        int j = m.Xx();
        int i = j;
        if (j == 100) {
          i = -1;
        }
        paramy = new bb().hV(paramy.dfT).eD(paramInt1).hW(paramy.CEg).iw(i).ez(paramy.gLf).eA(paramy.idx).eB(paramInt2).eC(paramy.videoDuration).eI(this.scene).eJ(this.niJ).eM(paramy.width).eL(paramy.height).Qo();
        if ((this.qGR == 0L) && (this.gSP != 0L)) {
          this.qGR = (System.currentTimeMillis() - this.gSP);
        }
        paramy = paramy.eF(this.qGR).eH(this.nlW).eE(System.currentTimeMillis() / 1000L).eG(this.nlV).hX(this.nlX).Qm();
        if (!this.nlY) {
          break label525;
        }
        l = 1L;
        label331:
        paramy.eK(l).Qn().aBj();
        ad.d(TAG, "eventType: ".concat(String.valueOf(paramInt1)));
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
      this.gSP = System.currentTimeMillis();
      break;
      l = System.currentTimeMillis();
      this.qGR += l - this.gSP;
      this.gSP = l;
      break;
      if (paramInt1 == 4)
      {
        str1 = paramy.CEg;
        k.g(str1, "videoInfo.videoVid");
        str2 = paramy.CEf;
        k.g(str2, "videoInfo.mpUrl");
        a.b(1, str1, str2, this.niJ, paramInt2);
        break label132;
      }
      if (paramInt1 != 10) {
        break label132;
      }
      str1 = paramy.CEg;
      k.g(str1, "videoInfo.videoVid");
      str2 = paramy.CEf;
      k.g(str2, "videoInfo.mpUrl");
      a.b(2, str1, str2, this.niJ, paramInt2);
      break label132;
      label525:
      l = 0L;
      break label331;
      this.qGR = 0L;
      this.gSP = System.currentTimeMillis();
      this.nlW = 0;
    }
  }
  
  public final int eqM()
  {
    switch (this.hxT)
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport$Companion;", "", "()V", "ACTION_TYPE_FRIEND", "", "REPORT_TYPE_10380", "REPORT_TYPE_10945", "REPORT_TYPE_17537", "SHARE_TYPE_MP_VIDEO", "TAG", "", "addCommReportItem", "", "key", "value", "items", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommReportItem;", "doAppMsgCommDataReport", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReportReq;", "logReportData", "kv", "report10380", "actionType", "sharePageType", "vid", "url", "timeLineSessionId", "enterId", "report17537", "eventType", "scene", "subScene", "plugin-webview_release"})
  public static final class a
  {
    private static void a(en paramen)
    {
      AppMethodBeat.i(82678);
      b.a locala = new b.a();
      locala.c((a)paramen);
      locala.d((a)new eo());
      locala.wg("/cgi-bin/mmbiz-bin/appmsg/appmsg_report");
      locala.nB(1870);
      locala.nD(0);
      locala.nE(0);
      IPCRunCgi.a(locala.atI(), (IPCRunCgi.a)g.a.a.Bte);
      AppMethodBeat.o(82678);
    }
    
    private static void a(String paramString1, String paramString2, LinkedList<ep> paramLinkedList)
    {
      AppMethodBeat.i(82682);
      ep localep = new ep();
      localep.key = paramString1;
      localep.gPh = paramString2;
      paramLinkedList.add(localep);
      AppMethodBeat.o(82682);
    }
    
    public static void ac(String paramString1, String paramString2, int paramInt)
    {
      AppMethodBeat.i(82679);
      k.h(paramString1, "vid");
      k.h(paramString2, "url");
      en localen = new en();
      em localem = new em();
      localem.type = 2;
      LinkedList localLinkedList = localem.Cvr;
      k.g(localLinkedList, "reportData.item");
      a("Vid", paramString1, localLinkedList);
      paramString1 = ay.iw(aj.getContext());
      localLinkedList = localem.Cvr;
      k.g(localLinkedList, "reportData.item");
      a("Network", paramString1, localLinkedList);
      paramString1 = localem.Cvr;
      k.g(paramString1, "reportData.item");
      a("SharePageType", "101", paramString1);
      paramString1 = localem.Cvr;
      k.g(paramString1, "reportData.item");
      a("ContentUrl", paramString2, paramString1);
      paramString1 = localem.Cvr;
      k.g(paramString1, "reportData.item");
      a("#AppMsgUrl#", paramString2, paramString1);
      paramString1 = localem.Cvr;
      k.g(paramString1, "reportData.item");
      a("ActionType", "1", paramString1);
      paramString1 = localem.Cvr;
      k.g(paramString1, "reportData.item");
      a("SessionId", "0", paramString1);
      paramString1 = localem.Cvr;
      k.g(paramString1, "reportData.item");
      a("EnterId", String.valueOf(paramInt), paramString1);
      localen.CyM.add(localem);
      a(localen);
      paramString1 = localem.Cvr;
      k.g(paramString1, "reportData.item");
      b(10380, paramString1);
      AppMethodBeat.o(82679);
    }
    
    public static void b(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(82680);
      k.h(paramString1, "vid");
      k.h(paramString2, "url");
      en localen = new en();
      em localem = new em();
      localem.type = 3;
      LinkedList localLinkedList = localem.Cvr;
      k.g(localLinkedList, "reportData.item");
      a("#AppMsgUrl#", paramString2, localLinkedList);
      paramString2 = localem.Cvr;
      k.g(paramString2, "reportData.item");
      a("VideoId", paramString1, paramString2);
      paramString1 = localem.Cvr;
      k.g(paramString1, "reportData.item");
      a("Scene", "141", paramString1);
      paramString1 = localem.Cvr;
      k.g(paramString1, "reportData.item");
      a("SubScene", String.valueOf(paramInt2), paramString1);
      long l = System.currentTimeMillis();
      paramString1 = localem.Cvr;
      k.g(paramString1, "reportData.item");
      a("ClientId", String.valueOf(l), paramString1);
      paramString1 = localem.Cvr;
      k.g(paramString1, "reportData.item");
      a("SessionId", "0", paramString1);
      paramString1 = localem.Cvr;
      k.g(paramString1, "reportData.item");
      a("EnterId", String.valueOf(paramInt3), paramString1);
      paramString1 = localem.Cvr;
      k.g(paramString1, "reportData.item");
      a("EventType", String.valueOf(paramInt1), paramString1);
      localen.CyM.add(localem);
      a(localen);
      paramString1 = localem.Cvr;
      k.g(paramString1, "reportData.item");
      b(17537, paramString1);
      AppMethodBeat.o(82680);
    }
    
    private static void b(int paramInt, LinkedList<ep> paramLinkedList)
    {
      AppMethodBeat.i(82681);
      if ((ad.getLogLevel() <= 0) && (!bt.gL((List)paramLinkedList)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        paramLinkedList = paramLinkedList.iterator();
        while (paramLinkedList.hasNext())
        {
          ep localep = (ep)paramLinkedList.next();
          localStringBuilder.append(localep.key).append(":").append(localep.gPh).append("  ");
        }
        ad.v(g.access$getTAG$cp(), paramInt + ", " + localStringBuilder);
      }
      AppMethodBeat.o(82681);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.g
 * JD-Core Version:    0.7.0.1
 */