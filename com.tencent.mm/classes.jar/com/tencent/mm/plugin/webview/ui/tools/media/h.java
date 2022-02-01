package com.tencent.mm.plugin.webview.ui.tools.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.y;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.g.b.a.fu;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.ff;
import com.tencent.mm.protocal.protobuf.fg;
import com.tencent.mm.protocal.protobuf.fh;
import com.tencent.mm.protocal.protobuf.fi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport;", "", "()V", "_realPlayTime", "", "get_realPlayTime", "()J", "set_realPlayTime", "(J)V", "endPlayTime", "", "getEndPlayTime", "()I", "setEndPlayTime", "(I)V", "isFans", "", "()Z", "setFans", "(Z)V", "lastOpType", "playErrType", "", "getPlayErrType", "()Ljava/lang/String;", "setPlayErrType", "(Ljava/lang/String;)V", "playStatus", "getPlayStatus", "setPlayStatus", "realPlayTime", "getRealPlayTime", "setRealPlayTime", "scene", "getScene", "setScene", "startPlayTime", "getStartPlayTime", "setStartPlayTime", "stayTimeInPage", "getStayTimeInPage", "setStayTimeInPage", "subScene", "getSubScene", "setSubScene", "doPlayReport", "", "doStopReport", "getPlayType", "report17149", "videoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "opType", "enterId", "itemShowType", "Companion", "KV17149OpType", "PlayStatus", "plugin-webview_release"})
public class h
{
  public static final a JwJ;
  private static final String TAG = "MicroMsg.MpVideoShareReport";
  private int JwI;
  private long iJF;
  public int jpW;
  protected int pHw;
  protected int pLB;
  protected int pLC;
  public String pLD;
  protected boolean pLE;
  protected int scene;
  private long vgm;
  
  static
  {
    AppMethodBeat.i(82685);
    JwJ = new a((byte)0);
    TAG = "MicroMsg.MpVideoShareReport";
    AppMethodBeat.o(82685);
  }
  
  public h()
  {
    AppMethodBeat.i(82684);
    this.iJF = System.currentTimeMillis();
    this.pLD = "";
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
    if (this.JwI == paramInt1)
    {
      AppMethodBeat.o(82683);
      return;
    }
    this.JwI = paramInt1;
    paramy.aSB();
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
        str1 = paramy.KOf;
        p.g(str1, "videoInfo.videoVid");
        str2 = paramy.KOe;
        p.g(str2, "videoInfo.mpUrl");
        a.b(0, str1, str2, this.pHw, paramInt2);
        int j = m.ape();
        int i = j;
        if (j == 100) {
          i = -1;
        }
        paramy = new fu().sL(paramy.dHc).pp(paramInt1).sM(paramy.KOf).lm(i).pl(paramy.iAQ).pm(paramy.idx).pn(paramInt2).po(paramy.videoDuration).pu(this.scene).pv(this.pHw).py(paramy.width).px(paramy.height).agG();
        if ((this.vgm == 0L) && (this.iJF != 0L)) {
          this.vgm = (System.currentTimeMillis() - this.iJF);
        }
        paramy = paramy.pr(this.vgm).pt(this.pLC).pq(System.currentTimeMillis() / 1000L).ps(this.pLB).sN(this.pLD).agE();
        if (!this.pLE) {
          break label525;
        }
        l = 1L;
        label331:
        paramy.pw(l).agF().bfK();
        Log.d(TAG, "eventType: ".concat(String.valueOf(paramInt1)));
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
      this.iJF = System.currentTimeMillis();
      break;
      l = System.currentTimeMillis();
      this.vgm += l - this.iJF;
      this.iJF = l;
      break;
      if (paramInt1 == 4)
      {
        str1 = paramy.KOf;
        p.g(str1, "videoInfo.videoVid");
        str2 = paramy.KOe;
        p.g(str2, "videoInfo.mpUrl");
        a.b(1, str1, str2, this.pHw, paramInt2);
        break label132;
      }
      if (paramInt1 != 10) {
        break label132;
      }
      str1 = paramy.KOf;
      p.g(str1, "videoInfo.videoVid");
      str2 = paramy.KOe;
      p.g(str2, "videoInfo.mpUrl");
      a.b(2, str1, str2, this.pHw, paramInt2);
      break label132;
      label525:
      l = 0L;
      break label331;
      this.vgm = 0L;
      this.iJF = System.currentTimeMillis();
      this.pLC = 0;
    }
  }
  
  public final int getPlayType()
  {
    switch (this.jpW)
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport$Companion;", "", "()V", "ACTION_TYPE_FRIEND", "", "ACTION_TYPE_SNS", "REPORT_TYPE_10380", "REPORT_TYPE_10945", "REPORT_TYPE_17537", "SHARE_TYPE_MP_VIDEO", "TAG", "", "addCommReportItem", "", "key", "value", "items", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommReportItem;", "doAppMsgCommDataReport", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReportReq;", "logReportData", "kv", "report10380", "actionType", "sharePageType", "vid", "url", "timeLineSessionId", "enterId", "report17537", "eventType", "scene", "subScene", "plugin-webview_release"})
  public static final class a
  {
    private static void a(fg paramfg)
    {
      AppMethodBeat.i(82678);
      d.a locala = new d.a();
      locala.c((a)paramfg);
      locala.d((a)new fh());
      locala.MB("/cgi-bin/mmbiz-bin/appmsg/appmsg_report");
      locala.sG(1870);
      locala.sI(0);
      locala.sJ(0);
      IPCRunCgi.a(locala.aXF(), (IPCRunCgi.a)a.JwK);
      AppMethodBeat.o(82678);
    }
    
    private static void a(String paramString1, String paramString2, LinkedList<fi> paramLinkedList)
    {
      AppMethodBeat.i(82682);
      fi localfi = new fi();
      localfi.key = paramString1;
      localfi.iFF = paramString2;
      paramLinkedList.add(localfi);
      AppMethodBeat.o(82682);
    }
    
    public static void b(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(82680);
      p.h(paramString1, "vid");
      p.h(paramString2, "url");
      fg localfg = new fg();
      ff localff = new ff();
      localff.type = 3;
      LinkedList localLinkedList = localff.KEQ;
      p.g(localLinkedList, "reportData.item");
      a("#AppMsgUrl#", paramString2, localLinkedList);
      paramString2 = localff.KEQ;
      p.g(paramString2, "reportData.item");
      a("VideoId", paramString1, paramString2);
      paramString1 = localff.KEQ;
      p.g(paramString1, "reportData.item");
      a("Scene", "141", paramString1);
      paramString1 = localff.KEQ;
      p.g(paramString1, "reportData.item");
      a("SubScene", String.valueOf(paramInt2), paramString1);
      long l = System.currentTimeMillis();
      paramString1 = localff.KEQ;
      p.g(paramString1, "reportData.item");
      a("ClientId", String.valueOf(l), paramString1);
      paramString1 = localff.KEQ;
      p.g(paramString1, "reportData.item");
      a("SessionId", "0", paramString1);
      paramString1 = localff.KEQ;
      p.g(paramString1, "reportData.item");
      a("EnterId", String.valueOf(paramInt3), paramString1);
      paramString1 = localff.KEQ;
      p.g(paramString1, "reportData.item");
      a("EventType", String.valueOf(paramInt1), paramString1);
      localfg.KIG.add(localff);
      a(localfg);
      paramString1 = localff.KEQ;
      p.g(paramString1, "reportData.item");
      b(17537, paramString1);
      AppMethodBeat.o(82680);
    }
    
    private static void b(int paramInt, LinkedList<fi> paramLinkedList)
    {
      AppMethodBeat.i(82681);
      if ((Log.getLogLevel() <= 0) && (!Util.isNullOrNil((List)paramLinkedList)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        paramLinkedList = paramLinkedList.iterator();
        while (paramLinkedList.hasNext())
        {
          fi localfi = (fi)paramLinkedList.next();
          localStringBuilder.append(localfi.key).append(":").append(localfi.iFF).append("  ");
        }
        Log.v(h.access$getTAG$cp(), paramInt + ", " + localStringBuilder);
      }
      AppMethodBeat.o(82681);
    }
    
    public static void i(int paramInt1, String paramString1, String paramString2, int paramInt2)
    {
      AppMethodBeat.i(210563);
      p.h(paramString1, "vid");
      p.h(paramString2, "url");
      fg localfg = new fg();
      ff localff = new ff();
      localff.type = 2;
      LinkedList localLinkedList = localff.KEQ;
      p.g(localLinkedList, "reportData.item");
      a("Vid", paramString1, localLinkedList);
      paramString1 = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
      localLinkedList = localff.KEQ;
      p.g(localLinkedList, "reportData.item");
      a("Network", paramString1, localLinkedList);
      paramString1 = localff.KEQ;
      p.g(paramString1, "reportData.item");
      a("SharePageType", "101", paramString1);
      paramString1 = localff.KEQ;
      p.g(paramString1, "reportData.item");
      a("ContentUrl", paramString2, paramString1);
      paramString1 = localff.KEQ;
      p.g(paramString1, "reportData.item");
      a("#AppMsgUrl#", paramString2, paramString1);
      paramString1 = localff.KEQ;
      p.g(paramString1, "reportData.item");
      a("ActionType", String.valueOf(paramInt1), paramString1);
      paramString1 = localff.KEQ;
      p.g(paramString1, "reportData.item");
      a("SessionId", "0", paramString1);
      paramString1 = localff.KEQ;
      p.g(paramString1, "reportData.item");
      a("EnterId", String.valueOf(paramInt2), paramString1);
      localfg.KIG.add(localff);
      a(localfg);
      paramString1 = localff.KEQ;
      p.g(paramString1, "reportData.item");
      b(10380, paramString1);
      AppMethodBeat.o(210563);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
    static final class a
      implements IPCRunCgi.a
    {
      public static final a JwK;
      
      static
      {
        AppMethodBeat.i(82677);
        JwK = new a();
        AppMethodBeat.o(82677);
      }
      
      public final void a(int paramInt1, int paramInt2, String paramString, d paramd)
      {
        AppMethodBeat.i(82676);
        Log.i(h.access$getTAG$cp(), "appmsg_report errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
        AppMethodBeat.o(82676);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.h
 * JD-Core Version:    0.7.0.1
 */